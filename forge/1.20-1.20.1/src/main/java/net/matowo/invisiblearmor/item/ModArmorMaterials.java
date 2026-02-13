package net.matowo.invisiblearmor.item;

import net.matowo.invisiblearmor.MatowosInvisibleArmor;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    INVISIBLE_LEATHER("invisible", 5, new int[] { 1, 3, 2, 1 }, 15,
            SoundEvents.ARMOR_EQUIP_LEATHER, 0f, 0f,
            () -> Ingredient.of(Items.LEATHER)),

    INVISIBLE_CHAINMAIL("invisible", 15, new int[] { 2, 5, 4, 1 }, 12,
            SoundEvents.ARMOR_EQUIP_CHAIN, 0f, 0f,
            () -> Ingredient.of(Items.IRON_INGOT)),

    INVISIBLE_IRON("invisible", 15, new int[] { 2, 6, 5, 2 }, 9,
            SoundEvents.ARMOR_EQUIP_IRON, 0f, 0f,
            () -> Ingredient.of(Items.IRON_INGOT)),

    INVISIBLE_GOLD("invisible", 7, new int[] { 2, 5, 3, 1 }, 25,
            SoundEvents.ARMOR_EQUIP_GOLD, 0f, 0f,
            () -> Ingredient.of(Items.GOLD_INGOT)),

    INVISIBLE_DIAMOND("invisible", 33, new int[] { 3, 8, 6, 3 }, 10,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 0f,
            () -> Ingredient.of(Items.DIAMOND)),

    INVISIBLE_TURTLE("invisible", 25, new int[] { 2, 6, 5, 2 }, 9,
            SoundEvents.ARMOR_EQUIP_TURTLE, 0f, 0f,
            () -> Ingredient.of(Items.SCUTE)),

    INVISIBLE_NETHERITE("invisible", 37, new int[] { 3, 8, 6, 3 }, 15,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0f, 0.1f,
            () -> Ingredient.of(Items.NETHERITE_INGOT))

    ;

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 15, 13 };

    ModArmorMaterials(
            String name,
            int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue,
            SoundEvent equipSound,
            float toughness, float knockbackResistance,
            Supplier<Ingredient> repairIngredient
    ) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return MatowosInvisibleArmor.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}