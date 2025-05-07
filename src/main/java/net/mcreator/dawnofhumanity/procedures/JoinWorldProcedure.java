package net.mcreator.dawnofhumanity.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.dawnofhumanity.network.DohessModVariables;
import net.mcreator.dawnofhumanity.DohessMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class JoinWorldProcedure {
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
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote() && _ent.world.getServer() != null)
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), ("team add DOH" + entity.getCachedUniqueIdString()));
		}
		DohessMod.queueServerWork(10, () -> {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), ("team join DOH" + entity.getCachedUniqueIdString()));
			}
			DohessMod.queueServerWork(10, () -> {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								("team modify DOH" + entity.getCachedUniqueIdString() + " prefix " + (entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).Squad
										+ (entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).Rank));
				}
			});
		});
	}
}
