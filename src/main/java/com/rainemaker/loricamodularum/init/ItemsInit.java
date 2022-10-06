package com.rainemaker.loricamodularum.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.item.Item;

import com.rainemaker.loricamodularum.items.Padding;
import com.rainemaker.loricamodularum.items.Reinforcement;
import com.rainemaker.loricamodularum.items.generic.GenericArmorBase;
import com.rainemaker.loricamodularum.items.generic.PaddedArmorBase;
import com.rainemaker.loricamodularum.items.generic.ReinforcedArmorBase;
import com.rainemaker.loricamodularum.items.generic.ReinforcedPaddedArmorBase;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemsInit {
	private static final List<Item> REGISTRY = new ArrayList<>();

	public static final Item GENERIC_ARMOR_HELM = register(new GenericArmorBase.Helmet());
	public static final Item GENERIC_ARMOR_CHESTPLATE = register(new GenericArmorBase.Chestplate());
	public static final Item GENERIC__ARMOR_LEGGINGS = register(new GenericArmorBase.Leggings());
	public static final Item GENERIC__ARMOR_BOOTS = register(new GenericArmorBase.Boots());
	public static final Item PADDED_UNDERLAY = register(new Padding());
	public static final Item REINFORCEMENT = register(new Reinforcement());
	public static final Item PADDED_ARMOR_CHESTPLATE = register(new PaddedArmorBase.Chestplate());
	public static final Item PADDED_ARMOR_BOOTS = register(new PaddedArmorBase.Boots());
	public static final Item PADDED_ARMOR_LEGGINGS = register(new PaddedArmorBase.Leggings());
	public static final Item PADDED_ARMOR_HELMET = register(new PaddedArmorBase.Helmet());
	public static final Item REINFORCED_PADDED_ARMOR_CHESTPLATE = register(new ReinforcedPaddedArmorBase.Chestplate());
	public static final Item REINFORCED_PADDED_ARMOR_BOOTS = register(new ReinforcedPaddedArmorBase.Boots());
	public static final Item REINFORCED_PADDED_ARMOR_LEGGINGS = register(new ReinforcedPaddedArmorBase.Leggings());
	public static final Item REINFORCED_PADDED_ARMOR_HELMET = register(new ReinforcedPaddedArmorBase.Helmet());
	public static final Item REINFORCED_ARMOR_CHESTPLATE = register(new ReinforcedArmorBase.Chestplate());
	public static final Item REINFORCED_ARMOR_BOOTS = register(new ReinforcedArmorBase.Boots());
	public static final Item REINFORCED_ARMOR_LEGGINGS = register(new ReinforcedArmorBase.Leggings());
	public static final Item REINFORCED_ARMOR_HELMET = register(new ReinforcedArmorBase.Helmet());

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
