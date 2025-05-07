package net.mcreator.dawnofhumanity.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameRules;
import net.minecraft.entity.Entity;

import net.mcreator.dawnofhumanity.network.DohessModVariables;

public class PDSemiProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		DohessModVariables.WorldVariables.get(world).Hardcore = 2;
		DohessModVariables.WorldVariables.get(world).syncData(world);
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote() && _ent.world.getServer() != null)
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/gamerule keepInventory true");
		}
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote() && _ent.world.getServer() != null)
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"/title @a title [\"\",{\"text\":\"Permadeath: \",\"color\":\"dark_green\"},{\"text\":\"Semi-Enabled\",\"color\":\"green\"}]");
		}
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote() && _ent.world.getServer() != null)
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"/title @a actionbar {\"text\":\"Permanent Death Is Enabled. But your data won't be deleted\",\"color\":\"green\"}");
		}
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote() && _ent.world.getServer() != null)
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/gamerule keepInventory true");
		}
		if (world instanceof World)
			((World) world).getGameRules().get(GameRules.DO_IMMEDIATE_RESPAWN).set(true, ((World) world).getServer());
		if (world instanceof World)
			((World) world).getGameRules().get(GameRules.SHOW_DEATH_MESSAGES).set(true, ((World) world).getServer());
	}
}
