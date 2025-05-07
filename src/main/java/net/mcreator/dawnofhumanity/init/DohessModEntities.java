/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dawnofhumanity.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.RegistryObject;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;

import net.mcreator.dawnofhumanity.entity.SmokeGrenadeProjectileEntity;
import net.mcreator.dawnofhumanity.entity.GrenadeProjectileEntity;
import net.mcreator.dawnofhumanity.DohessMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DohessModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, DohessMod.MODID);
	public static final RegistryObject<EntityType<GrenadeProjectileEntity>> GRENADE_PROJECTILE = register("grenade_projectile", EntityType.Builder.<GrenadeProjectileEntity>create(GrenadeProjectileEntity::new, EntityClassification.MISC)
			.setCustomClientFactory(GrenadeProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).size(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SmokeGrenadeProjectileEntity>> SMOKE_GRENADE_PROJECTILE = register("smoke_grenade_projectile",
			EntityType.Builder.<SmokeGrenadeProjectileEntity>create(SmokeGrenadeProjectileEntity::new, EntityClassification.MISC).setCustomClientFactory(SmokeGrenadeProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).size(0.5f, 0.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}
}
