
package com.rainemaker.loricamodularum.items.generic;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;

import com.rainemaker.loricamodularum.LoricaModularum;
import com.rainemaker.loricamodularum.config.ArmorBalance;

import org.jetbrains.annotations.ApiStatus.OverrideOnly;

import net.minecraft.resources.ResourceLocation;

public abstract class GenericArmorBase extends ArmorItem {
	public GenericArmorBase(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 15;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{
								(ArmorBalance.loricaHead.get() * ArmorBalance.loricaArmor.get()), 
								(ArmorBalance.loricaChest.get() * ArmorBalance.loricaArmor.get()), 
								(ArmorBalance.loricaLegs.get() * ArmorBalance.loricaArmor.get()), 
								(ArmorBalance.loricaFeet.get() * ArmorBalance.loricaArmor.get())
				}
				[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 9;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.NETHERITE_SCRAP));
			}

			@Override
			public String getName() {
				return "generic_armor";
			}

			@Override
			public float getToughness() {
				return (0f + ArmorBalance.loricaToughness.get().floatValue());
			}

			@Override
			public float getKnockbackResistance() {
				return (0f + 1 * ArmorBalance.loricaKnockbackReduction.get() / 100);
			}
		}, slot, properties);
}

	public static class Helmet extends GenericArmorBase {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(LoricaModularum.loricaTab));
			setRegistryName("generic_armor_helmet");
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "loricamodularum:textures/models/armor/generic/lorica_layer_1.png";
		}
	}

	public static class Chestplate extends GenericArmorBase {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(LoricaModularum.loricaTab));
			setRegistryName("generic_armor_chestplate");
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "loricamodularum:textures/models/armor/generic/lorica_layer_1.png";
		}
	}

	public static class Leggings extends GenericArmorBase {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(LoricaModularum.loricaTab));
			setRegistryName("generic_armor_leggings");
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "loricamodularum:textures/models/armor/generic/lorica_layer_2.png";
		}
	}

	public static class Boots extends GenericArmorBase {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(LoricaModularum.loricaTab));
			setRegistryName("generic_armor_boots");
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "loricamodularum:textures/models/armor/generic/lorica_layer_1.png";
		}
	}
}
