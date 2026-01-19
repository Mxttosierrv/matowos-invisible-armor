package net.matowo.invisiblearmor.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.matowo.invisiblearmor.MatowosInvisibleArmor;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Util;

import java.util.List;

import static net.matowo.invisiblearmor.MatowosInvisibleArmor.MOD_ID;

public class ModItems {
    // VARIABLES
    private static final Formatting TITLE_FORMATTING = Formatting.GRAY;
    private static final Formatting DESCRIPTION_FORMATTING = Formatting.BLUE;

    private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE = new Identifier("item/empty_armor_slot_helmet");
    private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = new Identifier("item/empty_armor_slot_chestplate");
    private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = new Identifier("item/empty_armor_slot_leggings");
    private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = new Identifier("item/empty_armor_slot_boots");
    private static  final Identifier EMPTY_SLOT_INGOT_TEXTURE = new Identifier("item/empty_slot_ingot");
    private static  final Identifier EMPTY_SLOT_ELYTRA_TEXTURE = new Identifier("matowos_invisible_armor","item/empty_slot_elytra");
    private static  final Identifier EMPTY_SLOT_HORSE_ARMOR_TEXTURE = new Identifier("matowos_invisible_armor","item/empty_slot_horse_armor");


    private static List<Identifier> getEmptySlots() {
        return List.of(
                EMPTY_ARMOR_SLOT_HELMET_TEXTURE,
                EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
                EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE,
                EMPTY_ARMOR_SLOT_BOOTS_TEXTURE,
                EMPTY_SLOT_ELYTRA_TEXTURE,
                EMPTY_SLOT_HORSE_ARMOR_TEXTURE
        );
    }


    private static List<Identifier> getEmptyAdditionSlots() {
        return List.of(
                EMPTY_SLOT_INGOT_TEXTURE
        );
    }


    // SMITHING TEMPLATE
    public static final Item INVISIBLE_ARMOR_SMITHING_TEMPLATE = registerItem(
            "invisible_armor_smithing_template", new SmithingTemplateItem(
                    Text.translatable(Util.createTranslationKey("item", new Identifier("invisible_smithing_template.applies_to"))).formatted(DESCRIPTION_FORMATTING),
                    Text.translatable(Util.createTranslationKey("item", new Identifier("invisible_smithing_template.ingredients"))).formatted(DESCRIPTION_FORMATTING),
                    Text.translatable(Util.createTranslationKey("item", new Identifier("invisible_smithing_template.tittle"))).formatted(TITLE_FORMATTING),
                    Text.translatable(Util.createTranslationKey("item", new Identifier("invisible_smithing_template.base_slot_description"))),
                    Text.translatable(Util.createTranslationKey("item", new Identifier("invisible_smithing_template.additions_slot_description"))),
                    getEmptySlots(),
                    getEmptyAdditionSlots()
            ));

    public static final Item VISIBLE_ARMOR_SMITHING_TEMPLATE = registerItem(
            "visible_armor_smithing_template", new SmithingTemplateItem(
                    Text.translatable(Util.createTranslationKey("item", new Identifier("visible_smithing_template.applies_to"))).formatted(DESCRIPTION_FORMATTING),
                    Text.translatable(Util.createTranslationKey("item", new Identifier("visible_smithing_template.ingredients"))).formatted(DESCRIPTION_FORMATTING),
                    Text.translatable(Util.createTranslationKey("item", new Identifier("visible_smithing_template.tittle"))).formatted(TITLE_FORMATTING),
                    Text.translatable(Util.createTranslationKey("item", new Identifier("visible_smithing_template.base_slot_description"))),
                    Text.translatable(Util.createTranslationKey("item", new Identifier("visible_smithing_template.additions_slot_description"))),
                    getEmptySlots(),
                    getEmptyAdditionSlots()
            ));


    // ELYTRA
    public static final Item INVISIBLE_ELYTRA = registerItem("invisible_elytra", new ModElytraItem(
            new Item.Settings().maxDamage(432).rarity(Rarity.UNCOMMON)));


    // HORSE ARMORS
    public static final DyeableHorseArmorItem INVISIBLE_LEATHER_HORSE_ARMOR = (DyeableHorseArmorItem) registerItem("invisible_leather_horse_armor",
            new DyeableHorseArmorItem(3, "invisible", new FabricItemSettings().maxCount(1)));
    public static final HorseArmorItem INVISIBLE_IRON_HORSE_ARMOR = (HorseArmorItem) registerItem("invisible_iron_horse_armor",
            new HorseArmorItem(5, "invisible", new FabricItemSettings().maxCount(1)));
    public static final HorseArmorItem INVISIBLE_GOLDEN_HORSE_ARMOR = (HorseArmorItem) registerItem("invisible_golden_horse_armor",
            new HorseArmorItem(7, "invisible", new FabricItemSettings().maxCount(1)));
    public static final HorseArmorItem INVISIBLE_DIAMOND_HORSE_ARMOR = (HorseArmorItem) registerItem("invisible_diamond_horse_armor",
            new HorseArmorItem(11, "invisible", new FabricItemSettings().maxCount(1)));

    // ARMORS
    public static final DyeableArmorItem INVISIBLE_LEATHER_HELMET = (DyeableArmorItem) registerItem("invisible_leather_helmet",
            new DyeableArmorItem(ModArmorMaterials.INVISIBLE_LEATHER, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final DyeableArmorItem INVISIBLE_LEATHER_CHESTPLATE = (DyeableArmorItem) registerItem("invisible_leather_chestplate",
            new DyeableArmorItem(ModArmorMaterials.INVISIBLE_LEATHER, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final DyeableArmorItem INVISIBLE_LEATHER_LEGGINGS = (DyeableArmorItem) registerItem("invisible_leather_leggings",
            new DyeableArmorItem(ModArmorMaterials.INVISIBLE_LEATHER, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final DyeableArmorItem INVISIBLE_LEATHER_BOOTS = (DyeableArmorItem) registerItem("invisible_leather_boots",
            new DyeableArmorItem(ModArmorMaterials.INVISIBLE_LEATHER, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item INVISIBLE_CHAINMAIL_HELMET = registerItem("invisible_chainmail_helmet",
            new ArmorItem(ModArmorMaterials.INVISIBLE_CHAINMAIL, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item INVISIBLE_CHAINMAIL_CHESTPLATE = registerItem("invisible_chainmail_chestplate",
            new ArmorItem(ModArmorMaterials.INVISIBLE_CHAINMAIL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item INVISIBLE_CHAINMAIL_LEGGINGS = registerItem("invisible_chainmail_leggings",
            new ArmorItem(ModArmorMaterials.INVISIBLE_CHAINMAIL, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item INVISIBLE_CHAINMAIL_BOOTS = registerItem("invisible_chainmail_boots",
            new ArmorItem(ModArmorMaterials.INVISIBLE_CHAINMAIL, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item INVISIBLE_IRON_HELMET = registerItem("invisible_iron_helmet",
            new ArmorItem(ModArmorMaterials.INVISIBLE_IRON, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item INVISIBLE_IRON_CHESTPLATE = registerItem("invisible_iron_chestplate",
            new ArmorItem(ModArmorMaterials.INVISIBLE_IRON, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item INVISIBLE_IRON_LEGGINGS = registerItem("invisible_iron_leggings",
            new ArmorItem(ModArmorMaterials.INVISIBLE_IRON, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item INVISIBLE_IRON_BOOTS = registerItem("invisible_iron_boots",
            new ArmorItem(ModArmorMaterials.INVISIBLE_IRON, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item INVISIBLE_GOLDEN_HELMET = registerItem("invisible_golden_helmet",
            new ArmorItem(ModArmorMaterials.INVISIBLE_GOLD, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item INVISIBLE_GOLDEN_CHESTPLATE = registerItem("invisible_golden_chestplate",
            new ArmorItem(ModArmorMaterials.INVISIBLE_GOLD, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item INVISIBLE_GOLDEN_LEGGINGS = registerItem("invisible_golden_leggings",
            new ArmorItem(ModArmorMaterials.INVISIBLE_GOLD, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item INVISIBLE_GOLDEN_BOOTS = registerItem("invisible_golden_boots",
            new ArmorItem(ModArmorMaterials.INVISIBLE_GOLD, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item INVISIBLE_DIAMOND_HELMET = registerItem("invisible_diamond_helmet",
            new ArmorItem(ModArmorMaterials.INVISIBLE_DIAMOND, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item INVISIBLE_DIAMOND_CHESTPLATE = registerItem("invisible_diamond_chestplate",
            new ArmorItem(ModArmorMaterials.INVISIBLE_DIAMOND, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item INVISIBLE_DIAMOND_LEGGINGS = registerItem("invisible_diamond_leggings",
            new ArmorItem(ModArmorMaterials.INVISIBLE_DIAMOND, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item INVISIBLE_DIAMOND_BOOTS = registerItem("invisible_diamond_boots",
            new ArmorItem(ModArmorMaterials.INVISIBLE_DIAMOND, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item INVISIBLE_NETHERITE_HELMET = registerItem("invisible_netherite_helmet",
            new ArmorItem(ModArmorMaterials.INVISIBLE_NETHERITE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item INVISIBLE_NETHERITE_CHESTPLATE = registerItem("invisible_netherite_chestplate",
            new ArmorItem(ModArmorMaterials.INVISIBLE_NETHERITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item INVISIBLE_NETHERITE_LEGGINGS = registerItem("invisible_netherite_leggings",
            new ArmorItem(ModArmorMaterials.INVISIBLE_NETHERITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item INVISIBLE_NETHERITE_BOOTS = registerItem("invisible_netherite_boots",
            new ArmorItem(ModArmorMaterials.INVISIBLE_NETHERITE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item INVISIBLE_TURTLE_HELMET = registerItem("invisible_turtle_helmet",
            new ArmorItem(ModArmorMaterials.INVISIBLE_TURTLE, ArmorItem.Type.HELMET, new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item);
    }
    public static void registerModItems() {
        MatowosInvisibleArmor.LOGGER.info("Registering Mod Items for " + MOD_ID);
    }
}
