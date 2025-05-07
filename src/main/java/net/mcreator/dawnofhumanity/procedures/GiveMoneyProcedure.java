package net.mcreator.dawnofhumanity.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class GiveMoneyProcedure {
	public static void execute(CommandContext<CommandSource> arguments, Entity entity) {
		if (entity == null)
			return;
		if (true) {
			if ((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "payname");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()) instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(Blocks.DIRT).copy();
				_setstack.setCount((int) DoubleArgumentType.getDouble(arguments, "paynumber"));
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) (new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "payname");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity())), _setstack);
			}
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), ("tellraw @a [\"\",{\"text\":\"" + "" + (new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "payname");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()).getDisplayName().getString() + "\",\"color\":\"aqua\"},{\"text\":\" has been paid \"},{\"text\":\"" + DoubleArgumentType.getDouble(arguments, "paynumber")
							+ " \",\"color\":\"gold\"},{\"text\":\"Dirt!\\n\\n\"},{\"text\":\"(Broke Ahhhh)\",\"color\":\"dark_red\"}]"));
			}
		}
	}
}
