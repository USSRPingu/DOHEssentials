/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dawnofhumanity.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.common.extensions.IForgeContainerType;

import net.minecraft.inventory.container.ContainerType;

import net.mcreator.dawnofhumanity.world.inventory.SquadRegimentChooseMenu;
import net.mcreator.dawnofhumanity.world.inventory.RankStartScreenMenu;
import net.mcreator.dawnofhumanity.DohessMod;

public class DohessModMenus {
	public static final DeferredRegister<ContainerType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.CONTAINERS, DohessMod.MODID);
	public static final RegistryObject<ContainerType<RankStartScreenMenu>> RANK_START_SCREEN = REGISTRY.register("rank_start_screen", () -> IForgeContainerType.create(RankStartScreenMenu::new));
	public static final RegistryObject<ContainerType<SquadRegimentChooseMenu>> SQUAD_REGIMENT_CHOOSE = REGISTRY.register("squad_regiment_choose", () -> IForgeContainerType.create(SquadRegimentChooseMenu::new));
}
