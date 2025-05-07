package net.mcreator.dawnofhumanity.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameRules;
import net.minecraft.entity.Entity;

import net.mcreator.dawnofhumanity.network.DohessModVariables;

public class PDOffProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote() && _ent.world.getServer() != null)
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"/title @a title [\"\",{\"text\":\"Permadeath:\",\"bold\":true,\"color\":\"dark_blue\"},{\"text\":\" Disabled\",\"color\":\"blue\"}]");
		}
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote() && _ent.world.getServer() != null)
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/title @a actionbar {\"text\":\"Permanent Death Isn't Enabled\",\"color\":\"blue\"}");
		}
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote() && _ent.world.getServer() != null)
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/gamerule keepInventory true");
		}
		DohessModVariables.WorldVariables.get(world).Hardcore = 0;
		DohessModVariables.WorldVariables.get(world).syncData(world);
		if (world instanceof World)
			((World) world).getGameRules().get(GameRules.DO_IMMEDIATE_RESPAWN).set(false, ((World) world).getServer());
		if (world instanceof World)
			((World) world).getGameRules().get(GameRules.SHOW_DEATH_MESSAGES).set(true, ((World) world).getServer());
	}
}
