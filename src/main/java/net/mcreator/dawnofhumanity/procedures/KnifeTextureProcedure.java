package net.mcreator.dawnofhumanity.procedures;

import net.minecraft.item.ItemStack;

public class KnifeTextureProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("CustomKnife");
	}
}
