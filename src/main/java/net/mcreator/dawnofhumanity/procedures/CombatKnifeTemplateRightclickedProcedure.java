package net.mcreator.dawnofhumanity.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.dawnofhumanity.init.DohessModItems;

public class CombatKnifeTemplateRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == DohessModItems.COMBAT_KNIFE_TEMPLATE.get()) {
			(entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag().putDouble("CustomKnife", 1);
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(DohessModItems.COMBAT_KNIFE_TEMPLATE.get());
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), 1, ((PlayerEntity) entity).container.func_234641_j_());
			}
		}
	}
}
