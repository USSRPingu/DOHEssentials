package net.mcreator.dawnofhumanity.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.dawnofhumanity.network.DohessModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HardcoreJoiningProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getPlayer().world, event.getPlayer());
	}

	public static void execute(IWorld world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, IWorld world, Entity entity) {
		if (entity == null)
			return;
		if (DohessModVariables.WorldVariables.get(world).Hardcore == 1) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).setGameType(GameType.SPECTATOR);
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"/tellraw @s [\"\",{\"text\":\"[Server]\\nYou joined midway through a \"},{\"text\":\"Permanent Death Event\",\"color\":\"red\"},{\"text\":\". So you cannot participate the event or access anything in the server.\\n\\nIf you was in the event and you died. Your player data will be reset\"}]");
			}
		} else if (DohessModVariables.WorldVariables.get(world).Hardcore == 2) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).setGameType(GameType.SPECTATOR);
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"/tellraw @s [\"\",{\"text\":\"[Server]\\nYou joined midway through a \"},{\"text\":\"Semi-Permanent Death Event\",\"color\":\"green\"},{\"text\":\". So you cannot participate the event or access anything in the server.\\n\\nIf you was in the event and you died. Your player data will be reset\"}]");
			}
		}
	}
}
