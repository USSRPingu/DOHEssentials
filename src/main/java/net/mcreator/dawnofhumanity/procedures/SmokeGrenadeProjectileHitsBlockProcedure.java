package net.mcreator.dawnofhumanity.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;

public class SmokeGrenadeProjectileHitsBlockProcedure {
	public static void execute(IWorld world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		{
			Entity _ent = immediatesourceentity;
			if (!_ent.world.isRemote() && _ent.world.getServer() != null)
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/particle campfire_signal_smoke ~ ~1 ~ 2 2 2 0 1000 force");
		}
		if (world instanceof World) {
			if (!((World) world).isRemote()) {
				((World) world).playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundCategory.NEUTRAL, 1, 1);
			} else {
				((World) world).playSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundCategory.NEUTRAL, 1, 1, false);
			}
		}
	}
}
