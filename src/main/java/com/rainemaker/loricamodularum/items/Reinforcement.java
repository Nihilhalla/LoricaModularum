package com.rainemaker.loricamodularum.items;

import com.rainemaker.loricamodularum.LoricaModularum;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Reinforcement extends Item {
    
    public Reinforcement() {

        super(new Item.Properties().tab(LoricaModularum.loricaTab));
        setRegistryName("reinforcement");

    }
    
}
