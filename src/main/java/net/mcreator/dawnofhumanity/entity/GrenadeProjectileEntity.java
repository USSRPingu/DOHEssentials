package net.mcreator.dawnofhumanity.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.network.IPacket;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.EntityType;
import net.minecraft.block.Blocks;

import net.mcreator.dawnofhumanity.procedures.GrenadeProjectileHitsProcedure;
import net.mcreator.dawnofhumanity.init.DohessModEntities;

import java.util.Random;

@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class GrenadeProjectileEntity extends AbstractArrowEntity implements IRendersAsItem {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(Blocks.STONE);

	public GrenadeProjectileEntity(FMLPlayMessages.SpawnEntity packet, World world) {
		super(DohessModEntities.GRENADE_PROJECTILE.get(), world);
	}

	public GrenadeProjectileEntity(EntityType<? extends GrenadeProjectileEntity> type, World world) {
		super(type, world);
	}

	public GrenadeProjectileEntity(EntityType<? extends GrenadeProjectileEntity> type, double x, double y, double z, World world) {
		super(type, x, y, z, world);
	}

	public GrenadeProjectileEntity(EntityType<? extends GrenadeProjectileEntity> type, LivingEntity entity, World world) {
		super(type, entity, world);
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected ItemStack getArrowStack() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected void arrowHit(LivingEntity entity) {
		super.arrowHit(entity);
		entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
	}

	@Override
	public void onCollideWithPlayer(PlayerEntity entity) {
		super.onCollideWithPlayer(entity);
		GrenadeProjectileHitsProcedure.execute(this.world, this.getPosX(), this.getPosY(), this.getPosZ());
	}

	@Override
	public void onEntityHit(EntityRayTraceResult entityHitResult) {
		super.onEntityHit(entityHitResult);
		GrenadeProjectileHitsProcedure.execute(this.world, this.getPosX(), this.getPosY(), this.getPosZ());
	}

	@Override
	public void func_230299_a_(BlockRayTraceResult blockHitResult) {
		super.func_230299_a_(blockHitResult);
		GrenadeProjectileHitsProcedure.execute(this.world, blockHitResult.getPos().getX(), blockHitResult.getPos().getY(), blockHitResult.getPos().getZ());
	}

	@Override
	public void tick() {
		super.tick();
		if (this.inGround)
			this.remove();
	}

	public static GrenadeProjectileEntity shoot(World world, LivingEntity entity, Random source) {
		return shoot(world, entity, source, 1f, 5, 5);
	}

	public static GrenadeProjectileEntity shoot(World world, LivingEntity entity, Random source, float pullingPower) {
		return shoot(world, entity, source, pullingPower * 1f, 5, 5);
	}

	public static GrenadeProjectileEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
		GrenadeProjectileEntity entityarrow = new GrenadeProjectileEntity(DohessModEntities.GRENADE_PROJECTILE.get(), entity, world);
		entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setIsCritical(false);
		entityarrow.setDamage(damage);
		entityarrow.setKnockbackStrength(knockback);
		world.addEntity(entityarrow);
		world.playSound(null, entity.getPosX(), entity.getPosY(), entity.getPosZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundCategory.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static GrenadeProjectileEntity shoot(LivingEntity entity, LivingEntity target) {
		GrenadeProjectileEntity entityarrow = new GrenadeProjectileEntity(DohessModEntities.GRENADE_PROJECTILE.get(), entity, entity.world);
		double dx = target.getPosX() - entity.getPosX();
		double dy = target.getPosY() + target.getEyeHeight() - 1.1;
		double dz = target.getPosZ() - entity.getPosZ();
		entityarrow.shoot(dx, dy - entityarrow.getPosY() + MathHelper.sqrt(dy * dy + dz * dz) * 0.2F, dz, 1f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setDamage(5);
		entityarrow.setKnockbackStrength(5);
		entityarrow.setIsCritical(false);
		entity.world.addEntity(entityarrow);
		entity.world.playSound(null, entity.getPosX(), entity.getPosY(), entity.getPosZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundCategory.PLAYERS, 1, 1f / (new Random().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
