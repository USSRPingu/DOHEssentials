
package net.mcreator.dawnofhumanity.item;

import net.minecraft.item.Rarity;
import net.minecraft.item.Item;

import net.mcreator.dawnofhumanity.init.DohessModTabs;

public class SoapItem extends Item {
	public SoapItem() {
		super(new Item.Properties().group(DohessModTabs.TAB_DAWN_OF_HUMANITY_ESSENTIALS).maxStackSize(64).rarity(Rarity.COMMON));
	}
}
