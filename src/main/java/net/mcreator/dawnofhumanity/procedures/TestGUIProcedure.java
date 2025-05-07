package net.mcreator.dawnofhumanity.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.command.CommandSource;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class TestGUIProcedure {
	public static Entity execute(CommandContext<CommandSource> arguments, Entity entity) {
		if (entity == null)
			return null;
		if ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "EditUser");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) == entity) {
			return entity;
		}
		return entity;
	}
}
