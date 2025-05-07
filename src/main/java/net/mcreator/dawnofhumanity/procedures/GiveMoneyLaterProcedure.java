package net.mcreator.dawnofhumanity.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.command.CommandSource;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class GiveMoneyLaterProcedure {
	public static void execute(CommandContext<CommandSource> arguments, Entity entity) {
		if (entity == null)
			return;
		String Test = "";
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote() && _ent.world.getServer() != null)
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						("/tellraw @a [\"\",{\"text\":\"" + "" + StringArgumentType.getString(arguments, "paylatername") + " \",\"color\":\"aqua\"},{\"text\":\"has been paid \"},{\"text\":\""
								+ DoubleArgumentType.getDouble(arguments, "paylaternumber") + "\",\"color\":\"gold\"},{\"text\":\"!\\n\\nThey will get there money when they are next on the server\"}]"));
		}
		Test = new java.text.DecimalFormat("##").format(DoubleArgumentType.getDouble(arguments, "paylaternumber")) + "" + StringArgumentType.getString(arguments, "paylatername");
	}
}
