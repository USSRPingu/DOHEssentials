
package net.mcreator.dawnofhumanity.item;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.BlockState;

import net.mcreator.dawnofhumanity.init.DohessModTabs;
import net.mcreator.dawnofhumanity.entity.SmokeGrenadeProjectileEntity;

public class SmokeGrenadeItem extends Item {
	public SmokeGrenadeItem() {
		super(new Item.Properties().group(DohessModTabs.TAB_DAWN_OF_HUMANITY_ESSENTIALS).maxDamage(1).rarity(Rarity.COMMON));
	}

	@Override
	public UseAction getUseAction(ItemStack itemstack) {
		return UseAction.BOW;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 72000;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0f;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
		ActionResult<ItemStack> ar = ActionResult.resultFail(entity.getHeldItem(hand));
		if (entity.abilities.isCreativeMode || findAmmo(entity) != ItemStack.EMPTY) {
			ar = ActionResult.resultSuccess(entity.getHeldItem(hand));
			entity.setActiveHand(hand);
		}
		return ar;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entity, int time) {
		if (!world.isRemote() && entity instanceof ServerPlayerEntity) {
			ItemStack stack = findAmmo((ServerPlayerEntity) entity);
			if (((ServerPlayerEntity) entity).abilities.isCreativeMode || stack != ItemStack.EMPTY) {
				SmokeGrenadeProjectileEntity projectile = SmokeGrenadeProjectileEntity.shoot(world, entity, world.getRandom());
				itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));
				if (((ServerPlayerEntity) entity).abilities.isCreativeMode) {
					projectile.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
				} else {
					if (stack.isDamageable()) {
						if (stack.attemptDamageItem(1, world.getRandom(), (ServerPlayerEntity) entity)) {
							stack.shrink(1);
							stack.setDamage(0);
							if (stack.isEmpty())
								((ServerPlayerEntity) entity).inventory.deleteStack(stack);
						}
					} else {
						stack.shrink(1);
						if (stack.isEmpty())
							((ServerPlayerEntity) entity).inventory.deleteStack(stack);
					}
				}
			}
		}
	}

	private ItemStack findAmmo(PlayerEntity player) {
		return new ItemStack(SmokeGrenadeProjectileEntity.PROJECTILE_ITEM.getItem());
	}
}
