package net.mcreator.dawnofhumanity.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.dawnofhumanity.network.DohessModVariables;

import javax.annotation.Nullable;

import java.util.Collections;

@Mod.EventBusSubscriber
public class HardcoreRespawnProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getPlayer().world, event.getPlayer());
	}

	public static void execute(IWorld world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, IWorld world, Entity entity) {
		if (entity == null)
			return;
		if (DohessModVariables.WorldVariables.get(world).Hardcore == 1) {
			if (entity instanceof PlayerEntity) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).setGameType(GameType.SPECTATOR);
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate(((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).StoreX),
							((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).StoreY),
							((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).StoreZ));
					if (_ent instanceof ServerPlayerEntity)
						((ServerPlayerEntity) _ent).connection.setPlayerLocation(((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).StoreX),
								((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).StoreY),
								((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).StoreZ), _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
				}
			}
		} else if (DohessModVariables.WorldVariables.get(world).Hardcore == 2) {
			if (entity instanceof PlayerEntity) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).setGameType(GameType.SPECTATOR);
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate(((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).StoreX),
							((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).StoreY),
							((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).StoreZ));
					if (_ent instanceof ServerPlayerEntity)
						((ServerPlayerEntity) _ent).connection.setPlayerLocation(((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).StoreX),
								((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).StoreY),
								((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).StoreZ), _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
				}
			}
		}
	}
}
