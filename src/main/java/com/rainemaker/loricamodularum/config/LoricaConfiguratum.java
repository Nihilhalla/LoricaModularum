package com.rainemaker.loricamodularum.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.rainemaker.loricamodularum.LoricaModularum;
import com.rainemaker.loricamodularum.init.ScoutInit;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class LoricaConfiguratum {
    private static final ScoutInit scout = LoricaModularum.scout;
    private static final ForgeConfigSpec.Builder mason = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.Builder serf = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec architect;
    public static final ForgeConfigSpec peon;

    static{

        ArmorBalance.initArmorSmith(mason, serf);

        architect = mason.build();
        peon = serf.build();
    }

    public static void loadBricks(ForgeConfigSpec config, String path) {
        scout.info("Lorica Configuratum Loading: " + path);
        final CommentedFileConfig brick = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        scout.info("Built config. " + path);
        brick.load();
        scout.info("Loaded brickwork " + path);
        architect.setConfig(brick);
    }
}