package com.rainemaker.loricamodularum.items;

import com.rainemaker.loricamodularum.LoricaModularum;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Padding extends Item {
    
    public Padding() {

        super(new Item.Properties().tab(LoricaModularum.loricaTab));
        setRegistryName("padded_underlay");

    }
    
}
