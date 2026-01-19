package net.matowo.invisiblearmor.datagen;


import net.matowo.invisiblearmor.MatowosInvisibleArmor;
import net.matowo.invisiblearmor.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {

    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                               CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, MatowosInvisibleArmor.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(
                        ModItems.INVISIBLE_LEATHER_HELMET.get(), ModItems.INVISIBLE_LEATHER_CHESTPLATE.get(),
                        ModItems.INVISIBLE_LEATHER_LEGGINGS.get(),  ModItems.INVISIBLE_LEATHER_BOOTS.get(),

                        ModItems.INVISIBLE_CHAINMAIL_HELMET.get(), ModItems.INVISIBLE_CHAINMAIL_CHESTPLATE.get(),
                        ModItems.INVISIBLE_CHAINMAIL_LEGGINGS.get(),  ModItems.INVISIBLE_CHAINMAIL_BOOTS.get(),

                        ModItems.INVISIBLE_IRON_HELMET.get(), ModItems.INVISIBLE_IRON_CHESTPLATE.get(),
                        ModItems.INVISIBLE_IRON_LEGGINGS.get(),  ModItems.INVISIBLE_IRON_BOOTS.get(),

                        ModItems.INVISIBLE_GOLDEN_HELMET.get(), ModItems.INVISIBLE_GOLDEN_CHESTPLATE.get(),
                        ModItems.INVISIBLE_GOLDEN_LEGGINGS.get(),  ModItems.INVISIBLE_GOLDEN_BOOTS.get(),

                        ModItems.INVISIBLE_DIAMOND_HELMET.get(), ModItems.INVISIBLE_DIAMOND_CHESTPLATE.get(),
                        ModItems.INVISIBLE_DIAMOND_LEGGINGS.get(),  ModItems.INVISIBLE_DIAMOND_BOOTS.get(),

                        ModItems.INVISIBLE_NETHERITE_HELMET.get(), ModItems.INVISIBLE_NETHERITE_CHESTPLATE.get(),
                        ModItems.INVISIBLE_NETHERITE_LEGGINGS.get(),  ModItems.INVISIBLE_NETHERITE_BOOTS.get(),

                        ModItems.INVISIBLE_TURTLE_HELMET.get()
                );
    }
}
