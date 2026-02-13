package net.matowo.invisiblearmor;

import com.mojang.logging.LogUtils;
import net.matowo.invisiblearmor.client.InvisibleArmorRenderHandler;
import net.matowo.invisiblearmor.item.ForgeEventHandler;
import net.matowo.invisiblearmor.item.ModCreativeModTabs;
import net.matowo.invisiblearmor.item.ModItems;
import net.matowo.invisiblearmor.recipe.ModRecipes;
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

@Mod(MatowosInvisibleArmor.MOD_ID)
public class MatowosInvisibleArmor {

    public static final String MOD_ID = "matowos_invisible_armor";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MatowosInvisibleArmor() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModRecipes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        LOGGER.info("Matowo's Invisible Armor initialized");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Common setup for Matowo's Invisible Armor");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Server starting with Matowo's Invisible Armor");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Solo registramos ForgeEventHandler para el turtle helmet
            // El renderizado de armadura invisible ahora se maneja por Mixin
            // (HumanoidArmorLayerMixin), no necesitamos RenderArmorEventHandler
            MinecraftForge.EVENT_BUS.register(ForgeEventHandler.class);

            // Handler de respaldo para mods con RenderLayers propios (Immersive Armors, etc.)
            // El mixin cubre vanilla/GeckoLib/AzureLib, este handler cubre el resto.
            MinecraftForge.EVENT_BUS.register(InvisibleArmorRenderHandler.class);

            LOGGER.info("Client setup complete - Invisible armor rendering enabled via Mixin");
        }

        @SubscribeEvent
        public static void onArmorItemColorRegister(RegisterColorHandlersEvent.Item event) {
            event.register((stack, tintIndex) -> {
                        if (tintIndex == 0) {
                            return ((DyeableArmorItem) stack.getItem()).getColor(stack);
                        }
                        return 0xFFFFFF;
                    },
                    ModItems.INVISIBLE_LEATHER_HELMET.get(),
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