package net.mcreator.dawnofhumanity.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.Hand;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.dawnofhumanity.init.DohessModItems;

import java.util.stream.Collectors;
import java.util.Comparator;

public class MedicalKitRightclickedProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		Entity test = null;
		if ((entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == DohessModItems.MEDICAL_KIT.get()) {
			if (entity.isSneaking()) {
				{
					final Vector3d _center = new Vector3d(
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getLook(1f).scale(5)), RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
									.getX()),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getLook(1f).scale(5)), RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
									.getY()),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getLook(1f).scale(5)), RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
									.getZ()));
					for (Entity entityiterator : world.getLoadedEntitiesWithinAABB(Entity.class, new AxisAlignedBB(_center, _center).grow(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.getDistanceSq(_center)))
							.collect(Collectors.toList())) {
						if (entityiterator instanceof LivingEntity && !((LivingEntity) entityiterator).world.isRemote())
							((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.GLOWING, 60, 1, false, false));
						if (entityiterator instanceof LivingEntity)
							((LivingEntity) entityiterator).setHealth((float) ((entityiterator instanceof LivingEntity ? ((LivingEntity) entityiterator).getHealth() : -1) + 5));
					}
				}
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
					_setstack.setCount(1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).inventory.markDirty();
				}
			} else {
				if (entity instanceof LivingEntity && !((LivingEntity) entity).world.isRemote())
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING, 60, 1, false, false));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity ? ((LivingEntity) entity).getHealth() : -1) + 5));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
					_setstack.setCount(1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).inventory.markDirty();
				}
			}
		} else {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "say only works in main hand");
			}
		}
	}
}
