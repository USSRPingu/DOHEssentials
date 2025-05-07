package net.mcreator.dawnofhumanity.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

public class GasbarrelEntityIsHurtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).setHealth(50);
	}
}
