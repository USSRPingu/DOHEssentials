
package net.mcreator.dawnofhumanity.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.dawnofhumanity.procedures.MedicalKitRightclickedProcedure;
import net.mcreator.dawnofhumanity.init.DohessModTabs;

import java.util.List;

public class MedicalKitItem extends Item {
	public MedicalKitItem() {
		super(new Item.Properties().group(DohessModTabs.TAB_DAWN_OF_HUMANITY_ESSENTIALS).maxDamage(50).rarity(Rarity.COMMON));
	}

	@Override
	public UseAction getUseAction(ItemStack itemstack) {
		return UseAction.BOW;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 49;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
		super.addInformation(itemstack, world, list, flag);
		list.add(new TranslationTextComponent("item.dohess.medical_kit.description_0"));
		list.add(new TranslationTextComponent("item.dohess.medical_kit.description_1"));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
		ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
		entity.setActiveHand(hand);
		return ar;
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
		ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
		double x = entity.getPosX();
		double y = entity.getPosY();
		double z = entity.getPosZ();
		MedicalKitRightclickedProcedure.execute(world, entity);
		return retval;
	}
}
