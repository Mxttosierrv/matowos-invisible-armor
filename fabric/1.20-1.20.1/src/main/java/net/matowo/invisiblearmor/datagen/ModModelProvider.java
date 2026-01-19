package net.matowo.invisiblearmor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.matowo.invisiblearmor.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;


public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // SMITHING TEMPLATE
        itemModelGenerator.register(ModItems.INVISIBLE_ARMOR_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VISIBLE_ARMOR_SMITHING_TEMPLATE, Models.GENERATED);

        // ARMORS
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_CHAINMAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_CHAINMAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_CHAINMAIL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_CHAINMAIL_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_IRON_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_IRON_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_IRON_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_IRON_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_GOLDEN_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_GOLDEN_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_GOLDEN_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_GOLDEN_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_DIAMOND_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_DIAMOND_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_DIAMOND_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_DIAMOND_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_TURTLE_HELMET));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_NETHERITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_NETHERITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_NETHERITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INVISIBLE_NETHERITE_BOOTS));
    }
}
