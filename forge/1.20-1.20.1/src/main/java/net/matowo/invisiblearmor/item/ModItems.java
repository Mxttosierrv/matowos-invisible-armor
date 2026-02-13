package net.matowo.invisiblearmor.item;

import net.matowo.invisiblearmor.MatowosInvisibleArmor;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MatowosInvisibleArmor.MOD_ID);


    private static final Style TITLE_FORMATTING = Style.EMPTY.withColor(net.minecraft.ChatFormatting.GRAY);
    private static final Style DESCRIPTION_FORMATTING = Style.EMPTY.withColor(net.minecraft.ChatFormatting.BLUE);

    private static final ResourceLocation EMPTY_ARMOR_SLOT_HELMET_TEXTURE = new ResourceLocation("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = new ResourceLocation("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = new ResourceLocation("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = new ResourceLocation("item/empty_armor_slot_boots");
    private static  final ResourceLocation EMPTY_SLOT_INGOT_TEXTURE = new ResourceLocation("item/empty_slot_ingot");
    private static  final ResourceLocation EMPTY_SLOT_ELYTRA_TEXTURE = new ResourceLocation("matowos_invisible_armor","item/empty_slot_elytra");
    private static  final ResourceLocation EMPTY_SLOT_HORSE_ARMOR_TEXTURE = new ResourceLocation("matowos_invisible_armor","item/empty_slot_horse_armor");


    private static List<ResourceLocation> getEmptyArmorSlots() {
        return List.of(
                EMPTY_ARMOR_SLOT_HELMET_TEXTURE,
                EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
                EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE,
                EMPTY_ARMOR_SLOT_BOOTS_TEXTURE,
                EMPTY_SLOT_ELYTRA_TEXTURE,
                EMPTY_SLOT_HORSE_ARMOR_TEXTURE
        );
    }
    private static List<ResourceLocation> getEmptyAdditionSlots() {
        return List.of(
                EMPTY_SLOT_INGOT_TEXTURE
        );
    }

    // SMITHING TEMPLATES
    public static final RegistryObject<SmithingTemplateItem> INVISIBLE_ARMOR_SMITHING_TEMPLATE = ITEMS.register("invisible_armor_smithing_template",
            () -> new SmithingTemplateItem(
                    Component.translatable("item.minecraft.invisible_smithing_template.applies_to").withStyle(DESCRIPTION_FORMATTING),
                    Component.translatable("item.minecraft.invisible_smithing_template.ingredients").withStyle(DESCRIPTION_FORMATTING),
                    Component.translatable("item.minecraft.invisible_smithing_template.tittle").withStyle(TITLE_FORMATTING),
                    Component.translatable("item.minecraft.invisible_smithing_template.base_slot_description"),
                    Component.translatable("item.minecraft.invisible_smithing_template.additions_slot_description"),
                    getEmptyArmorSlots(),
                    getEmptyAdditionSlots()
            ));
    public static final RegistryObject<SmithingTemplateItem> VISIBLE_ARMOR_SMITHING_TEMPLATE = ITEMS.register("visible_armor_smithing_template",
            () -> new SmithingTemplateItem(
                    Component.translatable("item.minecraft.visible_smithing_template.applies_to").withStyle(DESCRIPTION_FORMATTING),
                    Component.translatable("item.minecraft.visible_smithing_template.ingredients").withStyle(DESCRIPTION_FORMATTING),
                    Component.translatable("item.minecraft.visible_smithing_template.tittle").withStyle(TITLE_FORMATTING),
                    Component.translatable("item.minecraft.visible_smithing_template.base_slot_description"),
                    Component.translatable("item.minecraft.visible_smithing_template.additions_slot_description"),
                    getEmptyArmorSlots(),
                    getEmptyAdditionSlots()
            ));


    // ELYTRA - maxDamage = 432
    public static final RegistryObject<Item> INVISIBLE_ELYTRA = ITEMS.register("invisible_elytra", () ->
            new ModElytraItem(new Item.Properties().durability(432).rarity(Rarity.UNCOMMON)));


    // HORSE ARMORS
    public static final RegistryObject<Item> INVISIBLE_LEATHER_HORSE_ARMOR = ITEMS.register("invisible_leather_horse_armor",
            () -> new DyeableHorseArmorItem(3, "invisible", new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_IRON_HORSE_ARMOR = ITEMS.register("invisible_iron_horse_armor",
            () -> new HorseArmorItem(5, "invisible", new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_GOLDEN_HORSE_ARMOR = ITEMS.register("invisible_golden_horse_armor",
            () -> new HorseArmorItem(7, "invisible", new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_DIAMOND_HORSE_ARMOR = ITEMS.register("invisible_diamond_horse_armor",
            () -> new HorseArmorItem(11, "invisible", new Item.Properties()));


    // ARMORS
    public static final RegistryObject<Item> INVISIBLE_LEATHER_HELMET = ITEMS.register("invisible_leather_helmet",
            () -> new DyeableArmorItem(ModArmorMaterials.INVISIBLE_LEATHER, DyeableArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_LEATHER_CHESTPLATE = ITEMS.register("invisible_leather_chestplate",
            () -> new DyeableArmorItem(ModArmorMaterials.INVISIBLE_LEATHER, DyeableArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_LEATHER_LEGGINGS = ITEMS.register("invisible_leather_leggings",
            () -> new DyeableArmorItem(ModArmorMaterials.INVISIBLE_LEATHER, DyeableArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_LEATHER_BOOTS = ITEMS.register("invisible_leather_boots",
            () -> new DyeableArmorItem(ModArmorMaterials.INVISIBLE_LEATHER, DyeableArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> INVISIBLE_CHAINMAIL_HELMET = ITEMS.register("invisible_chainmail_helmet",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_CHAINMAIL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_CHAINMAIL_CHESTPLATE = ITEMS.register("invisible_chainmail_chestplate",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_CHAINMAIL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_CHAINMAIL_LEGGINGS = ITEMS.register("invisible_chainmail_leggings",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_CHAINMAIL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_CHAINMAIL_BOOTS = ITEMS.register("invisible_chainmail_boots",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_CHAINMAIL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> INVISIBLE_IRON_HELMET = ITEMS.register("invisible_iron_helmet",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_IRON, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_IRON_CHESTPLATE = ITEMS.register("invisible_iron_chestplate",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_IRON, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_IRON_LEGGINGS = ITEMS.register("invisible_iron_leggings",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_IRON, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_IRON_BOOTS = ITEMS.register("invisible_iron_boots",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_IRON, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> INVISIBLE_GOLDEN_HELMET = ITEMS.register("invisible_golden_helmet",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_GOLD, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_GOLDEN_CHESTPLATE = ITEMS.register("invisible_golden_chestplate",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_GOLD, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_GOLDEN_LEGGINGS = ITEMS.register("invisible_golden_leggings",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_GOLD, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_GOLDEN_BOOTS = ITEMS.register("invisible_golden_boots",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_GOLD, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> INVISIBLE_DIAMOND_HELMET = ITEMS.register("invisible_diamond_helmet",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_DIAMOND_CHESTPLATE = ITEMS.register("invisible_diamond_chestplate",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_DIAMOND_LEGGINGS = ITEMS.register("invisible_diamond_leggings",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_DIAMOND_BOOTS = ITEMS.register("invisible_diamond_boots",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> INVISIBLE_NETHERITE_HELMET = ITEMS.register("invisible_netherite_helmet",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_NETHERITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_NETHERITE_CHESTPLATE = ITEMS.register("invisible_netherite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_NETHERITE_LEGGINGS = ITEMS.register("invisible_netherite_leggings",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_NETHERITE_BOOTS = ITEMS.register("invisible_netherite_boots",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_NETHERITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> INVISIBLE_TURTLE_HELMET = ITEMS.register("invisible_turtle_helmet",
            () -> new ArmorItem(ModArmorMaterials.INVISIBLE_TURTLE, ArmorItem.Type.HELMET, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}