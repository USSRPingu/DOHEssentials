package net.mcreator.dawnofhumanity.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.IWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.dawnofhumanity.network.DohessModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HardcoreProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().world, event.getEntity());
		}
	}

	public static void execute(IWorld world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, IWorld world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof PlayerEntity) {
			if (DohessModVariables.WorldVariables.get(world).Hardcore == 1) {
				{
					double _setval = entity.getPosX();
					entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.StoreX = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = entity.getPosZ();
					entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.StoreZ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = entity.getPosY();
					entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.StoreY = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (DohessModVariables.WorldVariables.get(world).Hardcore == 2) {
				{
					double _setval = entity.getPosX();
					entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.StoreX = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = entity.getPosZ();
					entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.StoreZ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = entity.getPosY();
					entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.StoreY = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
