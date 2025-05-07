package net.mcreator.dawnofhumanity.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.dawnofhumanity.network.DohessModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PDDisplayProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingUpdateEvent event) {
		execute(event, event.getEntityLiving().world, event.getEntityLiving());
	}

	public static void execute(IWorld world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, IWorld world, Entity entity) {
		if (entity == null)
			return;
		if (DohessModVariables.WorldVariables.get(world).HardcoreDisplay == 1) {
			if (DohessModVariables.WorldVariables.get(world).Hardcore == 1) {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/title @a actionbar {\"text\":\"Permanent Death Is Enabled\",\"color\":\"red\"}");
				}
			} else if (DohessModVariables.WorldVariables.get(world).Hardcore == 2) {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"/title @a actionbar {\"text\":\"Permanent Death Is Enabled. But your data won't be deleted\",\"color\":\"green\"}");
				}
			} else if (DohessModVariables.WorldVariables.get(world).Hardcore == 0) {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/title @a actionbar {\"text\":\"Permanent Death Isn't Enabled\",\"color\":\"blue\"}");
				}
			}
		}
	}
}
