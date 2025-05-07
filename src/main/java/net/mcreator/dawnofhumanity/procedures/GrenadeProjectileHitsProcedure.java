package net.mcreator.dawnofhumanity.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;

public class GrenadeProjectileHitsProcedure {
	public static void execute(IWorld world, double x, double y, double z) {
		if (world instanceof World && !((World) world).isRemote())
			((World) world).createExplosion(null, x, y, z, 10, Explosion.Mode.NONE);
	}
}
