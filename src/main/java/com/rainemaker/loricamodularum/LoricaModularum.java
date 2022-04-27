package com.rainemaker.loricamodularum;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.rainemaker.loricamodularum.config.LoricaConfiguratum;
import com.rainemaker.loricamodularum.init.ItemsInit;
import com.rainemaker.loricamodularum.init.ScoutInit;

// The value here should match an entry in the META-INF/mods.toml file

@Mod("LoricaModularum")
public class LoricaModularum {
    //Initialization crap
	public static final String MODID = "loricamodularum";
	public static final String VERSION = "0.1.0";
	public static final String RELEASE_TYPE = "Release";
	public static final String NAME = "Lorica Modularum";
    private static final String PROTOCOL_VERSION = "1";
    public static LoricaModularum loricamodularum;
    
    public static final ScoutInit scout = new ScoutInit("Lorica Modularum");
    public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
    private static int messageID = 0;
    public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder,
        BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }


    // Directly reference a log4j logger.

    public LoricaModularum() {
        //Config init
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, LoricaConfiguratum.architect);
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        LoricaConfiguratum.loadBricks(LoricaConfiguratum.architect, FMLPaths.CONFIGDIR.get().resolve("loricamodularum-server.toml").toString());
        LoricaConfiguratum.loadBricks(LoricaConfiguratum.architect, FMLPaths.CONFIGDIR.get().resolve("loricamodularum-client.toml").toString());
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static final CreativeModeTab loricaTab = new CreativeModeTab("loricaTab") {
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(ItemsInit.TEST_LEATHER_ARMOR_CHESTPLATE);
		}
	};

    //Let's take all the setup crap, and just push it over there.
    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        //scout.info("HELLO FROM PREINIT");
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { scout.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        /*
            scout.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
        */
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // do something when the server starts
        //scout.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            //scout.info("HELLO from Register Block");
        }
    }
}
