package net.mcreator.dawnofhumanity.procedures;

import net.minecraft.entity.Entity;

public class WelcomeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote() && _ent.world.getServer() != null)
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "tellraw @s {\"text\":\"Click on me!\",\"underlined\":true,\"color\":\"dark_red\"}");
		}
	}
}
