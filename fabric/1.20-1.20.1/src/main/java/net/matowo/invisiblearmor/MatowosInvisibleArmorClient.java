package net.matowo.invisiblearmor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.matowo.invisiblearmor.item.ModItems;
import net.matowo.invisiblearmor.item.ModModelPredicate;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.DyeableHorseArmorItem;
import net.minecraft.util.Identifier;


public class MatowosInvisibleArmorClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // 1) Predicate para Elytra rota
        ModModelPredicate.registerBrokenElytraPredicate();

        // 2) ColorProvider para armaduras de cuero invisibles
        ItemColorProvider armorColorProvider = (stack, tintIndex) -> {
            if (!(stack.getItem() instanceof DyeableArmorItem)) {
                return -1;
            }
            DyeableArmorItem item = (DyeableArmorItem) stack.getItem();
            if (tintIndex == 0) {
                return item.hasColor(stack)
                        ? item.getColor(stack)
                        : DyeableArmorItem.DEFAULT_COLOR;
            }
            return -1;
        };
        ColorProviderRegistry.ITEM.register(
                armorColorProvider,
                ModItems.INVISIBLE_LEATHER_HELMET,
                ModItems.INVISIBLE_LEATHER_CHESTPLATE,
                ModItems.INVISIBLE_LEATHER_LEGGINGS,
                ModItems.INVISIBLE_LEATHER_BOOTS
        );

        ItemColorProvider horseArmorColorProvider = (stack, tintIndex) -> {
            if (!(stack.getItem() instanceof DyeableHorseArmorItem)) {
                return -1;
            }
            DyeableHorseArmorItem item = (DyeableHorseArmorItem) stack.getItem();
            if (tintIndex == 0) {
                return item.hasColor(stack)
                        ? item.getColor(stack)
                        : DyeableHorseArmorItem.DEFAULT_COLOR;
            }
            return -1;
        };
        ColorProviderRegistry.ITEM.register(
                horseArmorColorProvider,
                ModItems.INVISIBLE_LEATHER_HORSE_ARMOR
        );

        // 3) Predicate GLOBAL para TODAS las armaduras
        ModelPredicateProviderRegistry.register(
                new Identifier("matowos_invisible_armor", "invisible"),
                (stack, world, entity, seed) -> {
                    if (stack.hasNbt() && stack.getNbt().getBoolean("InvisibleArmor")) {
                        return 1.0F;
                    }
                    return 0.0F;
                }
        );
    }
}
