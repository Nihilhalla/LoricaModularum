package com.rainemaker.loricamodularum.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ArmorBalance {
        public static ForgeConfigSpec.IntValue loricaToughness;
        public static ForgeConfigSpec.IntValue loricaArmor;
        public static ForgeConfigSpec.IntValue loricaSpeed;
        public static ForgeConfigSpec.IntValue loricaDiscount;
        public static ForgeConfigSpec.IntValue loricaKnockbackReduction;

        public static void initArmorSmith(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
                server.comment("This is the balance config for armor values");

                loricaArmor = server.
                        comment("This is the value we'll use for armor increase multiplier")
                        .defineInRange("balance.loricaArmor", 1, 0, 100);
                loricaToughness = server.
                        comment("This is the value we'll use for toughness increase multiplier")
                        .defineInRange("balance.loricaToughness", 1, 0, 100);
                loricaSpeed = server.
                        comment("This is the value we'll use for speed increase multiplier")
                        .defineInRange("balance.loricaSpeed", 1, 0, 100);
                loricaDiscount = server.
                        comment("This is the value we'll use for Discount Percentage").
                        defineInRange("balance.loricaDiscount", 20, 0, 100);
                loricaKnockbackReduction = server.
                        comment("This is the value we'll use for Knockback Reduction Percentage").
                        defineInRange("balance.loricaKnockbackReduction", 20, 0, 100);

        }           
}
