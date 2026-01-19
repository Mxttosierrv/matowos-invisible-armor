package net.matowo.invisiblearmor;

import com.mojang.logging.LogUtils;
import net.matowo.invisiblearmor.item.ForgeEventHandler;
import net.matowo.invisiblearmor.item.ModCreativeModTabs;
import net.matowo.invisiblearmor.item.ModItems;
import net.minecraft.world.item.DyeableArmorItem;
import net.minecraft.world.item.DyeableHorseArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MatowosInvisibleArmor.MOD_ID)
public class MatowosInvisibleArmor
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "matowos_invisible_armor";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public MatowosInvisibleArmor() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MinecraftForge.EVENT_BUS.register(ForgeEventHandler.class);
        }

        @SubscribeEvent
        public static void onArmorItemColorRegister(RegisterColorHandlersEvent.Item event) {
            event.register((stack, tintIndex) -> {
                        if (tintIndex == 0) {
                            return ((DyeableArmorItem) stack.getItem()).getColor(stack);
                        }
                        return 0xFFFFFF;
                    }, ModItems.INVISIBLE_LEATHER_HELMET.get(),
                    ModItems.INVISIBLE_LEATHER_CHESTPLATE.get(),
                    ModItems.INVISIBLE_LEATHER_LEGGINGS.get(),
                    ModItems.INVISIBLE_LEATHER_BOOTS.get());
        }

        @SubscribeEvent
        public static void onHorseArmorItemColorRegister(RegisterColorHandlersEvent.Item event) {
            event.register((stack, tintIndex) -> {
                        if (tintIndex == 0) {
                            return ((DyeableHorseArmorItem) stack.getItem()).getColor(stack);
                        }
                        return 0xFFFFFF;
                    },
                    ModItems.INVISIBLE_LEATHER_HORSE_ARMOR.get());
        }
    }

}
