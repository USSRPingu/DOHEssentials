package net.mcreator.dawnofhumanity.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;

import net.mcreator.dawnofhumanity.DohessMod;

public class GasbarrelOnEntityTickUpdateProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		if (entity.isBurning()) {
			DohessMod.queueServerWork(120, () -> {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/particle campfire_signal_smoke ~ ~1 ~ 3 3 3 0 5000 force");
				}
				if (world instanceof World) {
					if (!((World) world).isRemote()) {
						((World) world).playSound(null, new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tnt.primed")), SoundCategory.NEUTRAL, 1, 1);
					} else {
						((World) world).playSound((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tnt.primed")), SoundCategory.NEUTRAL, 1, 1, false);
					}
				}
				if (!entity.world.isRemote())
					entity.remove();
			});
		}
	}
}
