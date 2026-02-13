package net.matowo.invisiblearmor.recipe;

import net.matowo.invisiblearmor.item.ModItems;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmithingTransformRecipe;
import net.minecraft.world.level.Level;

public class VisibleArmorRecipe extends SmithingTransformRecipe {

    public VisibleArmorRecipe(ResourceLocation id, Ingredient template, Ingredient base, Ingredient addition, ItemStack result) {
        super(id, template, base, addition, result);
    }

    public VisibleArmorRecipe(ResourceLocation id) {
        this(
                id,
                Ingredient.of(ModItems.VISIBLE_ARMOR_SMITHING_TEMPLATE.get()),
                Ingredient.EMPTY,
                Ingredient.of(Items.COPPER_INGOT),
                ItemStack.EMPTY
        );
    }

    @Override
    public boolean isBaseIngredient(ItemStack stack) {
        if (stack.isEmpty()) return false;
        if (!isArmorLikeItem(stack)) return false;

        // Solo acepta armaduras que ya son invisibles
        return stack.hasTag() && stack.getTag().getBoolean("InvisibleArmor");
    }

    @Override
    public boolean isTemplateIngredient(ItemStack stack) {
        return Ingredient.of(ModItems.VISIBLE_ARMOR_SMITHING_TEMPLATE.get()).test(stack);
    }

    @Override
    public boolean isAdditionIngredient(ItemStack stack) {
        return Ingredient.of(Items.COPPER_INGOT).test(stack);
    }

    @Override
    public boolean matches(Container container, Level level) {
        ItemStack templateStack = container.getItem(0);
        ItemStack baseStack = container.getItem(1);
        ItemStack additionStack = container.getItem(2);

        if (!isTemplateIngredient(templateStack)) {
            return false;
        }

        if (baseStack.isEmpty() || !isArmorLikeItem(baseStack)) {
            return false;
        }

        if (!baseStack.hasTag() || !baseStack.getTag().getBoolean("InvisibleArmor")) {
            return false;
        }

        if (!isAdditionIngredient(additionStack)) {
            return false;
        }

        return true;
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess registryAccess) {
        ItemStack baseStack = container.getItem(1);
        ItemStack result = baseStack.copy();

        if (result.hasTag()) {
            result.getTag().remove("InvisibleArmor");

            if (result.getTag().isEmpty()) {
                result.setTag(null);
            }
        }

        result.resetHoverName();

        return result;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.VISIBLE_ARMOR_RECIPE_SERIALIZER.get();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean isIncomplete() {
        return false;
    }

    private static boolean isArmorLikeItem(ItemStack stack) {
        if (stack.isEmpty()) return false;
        Item item = stack.getItem();
        if (item instanceof ArmorItem) return true;

        EquipmentSlot slot = LivingEntity.getEquipmentSlotForItem(stack);
        return slot.getType() == EquipmentSlot.Type.ARMOR;
    }
}