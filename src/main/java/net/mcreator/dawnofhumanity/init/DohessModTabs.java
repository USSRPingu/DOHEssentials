/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dawnofhumanity.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

public class DohessModTabs {
	public static ItemGroup TAB_DAWN_OF_HUMANITY_ESSENTIALS;

	public static void load() {
		TAB_DAWN_OF_HUMANITY_ESSENTIALS = new ItemGroup("dohess.dawn_of_humanity_essentials") {
			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack createIcon() {
				return new ItemStack(DohessModItems.MEDICAL_KIT.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
