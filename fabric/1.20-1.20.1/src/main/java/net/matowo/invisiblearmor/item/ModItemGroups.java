package net.matowo.invisiblearmor.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.matowo.invisiblearmor.MatowosInvisibleArmor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup INVISIBLE_ARMOR = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MatowosInvisibleArmor.MOD_ID, "invisible_armor"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.invisible_armor"))
                    .icon(() -> new ItemStack(ModItems.INVISIBLE_DIAMOND_CHESTPLATE)).entries((displayContext, entries) -> {

                    // ADD MODITEMS TO CREATIVE TAB
                        // smithing template
                        entries.add(ModItems.INVISIBLE_ARMOR_SMITHING_TEMPLATE);
                        entries.add(ModItems.VISIBLE_ARMOR_SMITHING_TEMPLATE);

                        // elytra
                        entries.add(ModItems.INVISIBLE_ELYTRA);

                        // armors
                        entries.add(ModItems.INVISIBLE_LEATHER_HELMET);
                        entries.add(ModItems.INVISIBLE_LEATHER_CHESTPLATE);
                        entries.add(ModItems.INVISIBLE_LEATHER_LEGGINGS);
                        entries.add(ModItems.INVISIBLE_LEATHER_BOOTS);

                        entries.add(ModItems.INVISIBLE_CHAINMAIL_HELMET);
                        entries.add(ModItems.INVISIBLE_CHAINMAIL_CHESTPLATE);
                        entries.add(ModItems.INVISIBLE_CHAINMAIL_LEGGINGS);
                        entries.add(ModItems.INVISIBLE_CHAINMAIL_BOOTS);

                        entries.add(ModItems.INVISIBLE_IRON_HELMET);
                        entries.add(ModItems.INVISIBLE_IRON_CHESTPLATE);
                        entries.add(ModItems.INVISIBLE_IRON_LEGGINGS);
                        entries.add(ModItems.INVISIBLE_IRON_BOOTS);

                        entries.add(ModItems.INVISIBLE_GOLDEN_HELMET);
                        entries.add(ModItems.INVISIBLE_GOLDEN_CHESTPLATE);
                        entries.add(ModItems.INVISIBLE_GOLDEN_LEGGINGS);
                        entries.add(ModItems.INVISIBLE_GOLDEN_BOOTS);

                        entries.add(ModItems.INVISIBLE_DIAMOND_HELMET);
                        entries.add(ModItems.INVISIBLE_DIAMOND_CHESTPLATE);
                        entries.add(ModItems.INVISIBLE_DIAMOND_LEGGINGS);
                        entries.add(ModItems.INVISIBLE_DIAMOND_BOOTS);

                        entries.add(ModItems.INVISIBLE_NETHERITE_HELMET);
                        entries.add(ModItems.INVISIBLE_NETHERITE_CHESTPLATE);
                        entries.add(ModItems.INVISIBLE_NETHERITE_LEGGINGS);
                        entries.add(ModItems.INVISIBLE_NETHERITE_BOOTS);

                        entries.add(ModItems.INVISIBLE_TURTLE_HELMET);

                        // horse armors
                        entries.add(ModItems.INVISIBLE_LEATHER_HORSE_ARMOR);
                        entries.add(ModItems.INVISIBLE_IRON_HORSE_ARMOR);
                        entries.add(ModItems.INVISIBLE_GOLDEN_HORSE_ARMOR);
                        entries.add(ModItems.INVISIBLE_DIAMOND_HORSE_ARMOR);
                    }).build());

    public static void registerItemGroups() {
        MatowosInvisibleArmor.LOGGER.info("Registering Item Groups for " + MatowosInvisibleArmor.MOD_ID);
    }
}
