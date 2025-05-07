package net.mcreator.dawnofhumanity.procedures;

import net.minecraft.util.HandSide;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

public class SelfHarmProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (net.minecraftforge.fml.ModList.get().isLoaded("firstaid")) {
			if (entity instanceof LivingEntity && ((LivingEntity) entity).getPrimaryHand() == HandSide.LEFT) {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "damagePart RIGHT_ARM 1");
				}
			} else if (entity instanceof LivingEntity && ((LivingEntity) entity).getPrimaryHand() == HandSide.RIGHT) {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "damagePart LEFT_ARM 1");
				}
			}
		} else {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity ? ((LivingEntity) entity).getHealth() : -1) - 1));
		}
	}
}
