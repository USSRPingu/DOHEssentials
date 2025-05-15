/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dawnofhumanity.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.ScreenManager;

import net.mcreator.dawnofhumanity.client.gui.SquadRegimentChooseScreen;
import net.mcreator.dawnofhumanity.client.gui.RankStartScreenScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DohessModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ScreenManager.registerFactory(DohessModMenus.RANK_START_SCREEN.get(), RankStartScreenScreen::new);
			ScreenManager.registerFactory(DohessModMenus.SQUAD_REGIMENT_CHOOSE.get(), SquadRegimentChooseScreen::new);
		});
	}
}
