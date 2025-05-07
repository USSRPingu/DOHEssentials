
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dawnofhumanity.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.Item;

import net.mcreator.dawnofhumanity.procedures.KnifeTextureProcedure;
import net.mcreator.dawnofhumanity.item.SoapItem;
import net.mcreator.dawnofhumanity.item.SmokeGrenadeItem;
import net.mcreator.dawnofhumanity.item.RoyalKnifeTemplateItem;
import net.mcreator.dawnofhumanity.item.MilitaryKnifeTemplateItem;
import net.mcreator.dawnofhumanity.item.MedicalKitItem;
import net.mcreator.dawnofhumanity.item.KnifeTemplateItem;
import net.mcreator.dawnofhumanity.item.KnifeItem;
import net.mcreator.dawnofhumanity.item.KennyKnifeTemplateItem;
import net.mcreator.dawnofhumanity.item.HuntingKnifeTemplateItem;
import net.mcreator.dawnofhumanity.item.GrenadeItem;
import net.mcreator.dawnofhumanity.item.CrossguardKnifeItem;
import net.mcreator.dawnofhumanity.item.CombatKnifeTemplateItem;
import net.mcreator.dawnofhumanity.DohessMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DohessModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DohessMod.MODID);
	public static final RegistryObject<Item> KNIFE = REGISTRY.register("knife", () -> new KnifeItem());
	public static final RegistryObject<Item> SOAP = REGISTRY.register("soap", () -> new SoapItem());
	public static final RegistryObject<Item> KNIFE_TEMPLATE = REGISTRY.register("knife_template", () -> new KnifeTemplateItem());
	public static final RegistryObject<Item> HUNTING_KNIFE_TEMPLATE = REGISTRY.register("hunting_knife_template", () -> new HuntingKnifeTemplateItem());
	public static final RegistryObject<Item> COMBAT_KNIFE_TEMPLATE = REGISTRY.register("combat_knife_template", () -> new CombatKnifeTemplateItem());
	public static final RegistryObject<Item> ROYAL_KNIFE_TEMPLATE = REGISTRY.register("royal_knife_template", () -> new RoyalKnifeTemplateItem());
	public static final RegistryObject<Item> MILITARY_KNIFE_TEMPLATE = REGISTRY.register("military_knife_template", () -> new MilitaryKnifeTemplateItem());
	public static final RegistryObject<Item> KENNY_KNIFE_TEMPLATE = REGISTRY.register("kenny_knife_template", () -> new KennyKnifeTemplateItem());
	public static final RegistryObject<Item> CROSSGUARD_KNIFE = REGISTRY.register("crossguard_knife", () -> new CrossguardKnifeItem());
	public static final RegistryObject<Item> GRENADE = REGISTRY.register("grenade", () -> new GrenadeItem());
	public static final RegistryObject<Item> SMOKE_GRENADE = REGISTRY.register("smoke_grenade", () -> new SmokeGrenadeItem());
	public static final RegistryObject<Item> MEDICAL_KIT = REGISTRY.register("medical_kit", () -> new MedicalKitItem());

	// Start of user code block custom items
	// End of user code block custom items
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemModelsProperties.registerProperty(KNIFE.get(), new ResourceLocation("dohess:knife_knife"), (itemStackToRender, clientWorld, entity) -> (float) KnifeTextureProcedure.execute(itemStackToRender));
		});
	}
}
