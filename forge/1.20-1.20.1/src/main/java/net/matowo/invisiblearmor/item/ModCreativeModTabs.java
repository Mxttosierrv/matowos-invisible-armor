package net.matowo.invisiblearmor.item;

import net.matowo.invisiblearmor.MatowosInvisibleArmor;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MatowosInvisibleArmor.MOD_ID);

    public static final RegistryObject<CreativeModeTab> INVISIBLE_ARMOR = CREATIVE_MOD_TABS.register("invisible_armor",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.INVISIBLE_DIAMOND_CHESTPLATE.get()))
                    .title(Component.translatable("itemgroup.invisible_armor"))
                    .displayItems((pParameters, pOutput) -> {

                    // ADD MODITEMS TO CREATIVE TAB
                        // smithing template
                        pOutput.accept(ModItems.INVISIBLE_ARMOR_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.VISIBLE_ARMOR_SMITHING_TEMPLATE.get());

                        // elytra
                        pOutput.accept(ModItems.INVISIBLE_ELYTRA.get());

                        // armors
                        pOutput.accept(ModItems.INVISIBLE_LEATHER_HELMET.get());
                        pOutput.accept(ModItems.INVISIBLE_LEATHER_CHESTPLATE.get());
                        pOutput.accept(ModItems.INVISIBLE_LEATHER_LEGGINGS.get());
                        pOutput.accept(ModItems.INVISIBLE_LEATHER_BOOTS.get());

                        pOutput.accept(ModItems.INVISIBLE_CHAINMAIL_HELMET.get());
                        pOutput.accept(ModItems.INVISIBLE_CHAINMAIL_CHESTPLATE.get());
                        pOutput.accept(ModItems.INVISIBLE_CHAINMAIL_LEGGINGS.get());
                        pOutput.accept(ModItems.INVISIBLE_CHAINMAIL_BOOTS.get());

                        pOutput.accept(ModItems.INVISIBLE_IRON_HELMET.get());
                        pOutput.accept(ModItems.INVISIBLE_IRON_CHESTPLATE.get());
                        pOutput.accept(ModItems.INVISIBLE_IRON_LEGGINGS.get());
                        pOutput.accept(ModItems.INVISIBLE_IRON_BOOTS.get());

                        pOutput.accept(ModItems.INVISIBLE_GOLDEN_HELMET.get());
                        pOutput.accept(ModItems.INVISIBLE_GOLDEN_CHESTPLATE.get());
                        pOutput.accept(ModItems.INVISIBLE_GOLDEN_LEGGINGS.get());
                        pOutput.accept(ModItems.INVISIBLE_GOLDEN_BOOTS.get());

                        pOutput.accept(ModItems.INVISIBLE_DIAMOND_HELMET.get());
                        pOutput.accept(ModItems.INVISIBLE_DIAMOND_CHESTPLATE.get());
                        pOutput.accept(ModItems.INVISIBLE_DIAMOND_LEGGINGS.get());
                        pOutput.accept(ModItems.INVISIBLE_DIAMOND_BOOTS.get());

                        pOutput.accept(ModItems.INVISIBLE_NETHERITE_HELMET.get());
                        pOutput.accept(ModItems.INVISIBLE_NETHERITE_CHESTPLATE.get());
                        pOutput.accept(ModItems.INVISIBLE_NETHERITE_LEGGINGS.get());
                        pOutput.accept(ModItems.INVISIBLE_NETHERITE_BOOTS.get());

                        pOutput.accept(ModItems.INVISIBLE_TURTLE_HELMET.get());

                        // horse armors
                        pOutput.accept(ModItems.INVISIBLE_LEATHER_HORSE_ARMOR.get());
                        pOutput.accept(ModItems.INVISIBLE_IRON_HORSE_ARMOR.get());
                        pOutput.accept(ModItems.INVISIBLE_GOLDEN_HORSE_ARMOR.get());
                        pOutput.accept(ModItems.INVISIBLE_DIAMOND_HORSE_ARMOR.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MOD_TABS.register(eventBus);
    }
}