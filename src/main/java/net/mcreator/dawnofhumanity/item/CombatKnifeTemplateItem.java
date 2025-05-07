
package net.mcreator.dawnofhumanity.item;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.dawnofhumanity.procedures.CombatKnifeTemplateRightclickedProcedure;
import net.mcreator.dawnofhumanity.init.DohessModTabs;

public class CombatKnifeTemplateItem extends Item {
	public CombatKnifeTemplateItem() {
		super(new Item.Properties().group(DohessModTabs.TAB_DAWN_OF_HUMANITY_ESSENTIALS).maxStackSize(64).rarity(Rarity.COMMON));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
		ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
		CombatKnifeTemplateRightclickedProcedure.execute(entity);
		return ar;
	}
}
