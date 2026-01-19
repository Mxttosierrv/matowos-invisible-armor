package net.matowo.invisiblearmor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.matowo.invisiblearmor.item.ModItems;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR).add(
                ModItems.INVISIBLE_LEATHER_HELMET, ModItems.INVISIBLE_LEATHER_CHESTPLATE,
                ModItems.INVISIBLE_LEATHER_LEGGINGS, ModItems.INVISIBLE_LEATHER_BOOTS,

                ModItems.INVISIBLE_CHAINMAIL_HELMET, ModItems.INVISIBLE_CHAINMAIL_CHESTPLATE,
                ModItems.INVISIBLE_CHAINMAIL_LEGGINGS, ModItems.INVISIBLE_CHAINMAIL_BOOTS,

                ModItems.INVISIBLE_IRON_HELMET, ModItems.INVISIBLE_IRON_CHESTPLATE,
                ModItems.INVISIBLE_IRON_LEGGINGS, ModItems.INVISIBLE_IRON_BOOTS,

                ModItems.INVISIBLE_GOLDEN_HELMET, ModItems.INVISIBLE_GOLDEN_CHESTPLATE,
                ModItems.INVISIBLE_GOLDEN_LEGGINGS, ModItems.INVISIBLE_GOLDEN_BOOTS,

                ModItems.INVISIBLE_DIAMOND_HELMET, ModItems.INVISIBLE_DIAMOND_CHESTPLATE,
                ModItems.INVISIBLE_DIAMOND_LEGGINGS, ModItems.INVISIBLE_DIAMOND_BOOTS,

                ModItems.INVISIBLE_TURTLE_HELMET,

                ModItems.INVISIBLE_NETHERITE_HELMET, ModItems.INVISIBLE_NETHERITE_CHESTPLATE,
                ModItems.INVISIBLE_NETHERITE_LEGGINGS, ModItems.INVISIBLE_NETHERITE_BOOTS
                );
    }
}
