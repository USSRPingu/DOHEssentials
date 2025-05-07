package net.mcreator.dawnofhumanity.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.command.CommandSource;

import net.mcreator.dawnofhumanity.network.DohessModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class PDDisplayToggleProcedure {
	public static void execute(IWorld world, CommandContext<CommandSource> arguments) {
		if (BoolArgumentType.getBool(arguments, "display")) {
			DohessModVariables.WorldVariables.get(world).HardcoreDisplay = 1;
			DohessModVariables.WorldVariables.get(world).syncData(world);
		} else if (true) {
			DohessModVariables.WorldVariables.get(world).HardcoreDisplay = 0;
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
