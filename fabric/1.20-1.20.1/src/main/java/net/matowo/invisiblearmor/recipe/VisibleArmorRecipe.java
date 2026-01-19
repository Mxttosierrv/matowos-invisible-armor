package net.matowo.invisiblearmor.recipe;

import com.google.gson.JsonObject;
import net.matowo.invisiblearmor.item.ModItems;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class VisibleArmorRecipe implements SmithingRecipe {

    private final Identifier id;
    private final Ingredient template;
    private final Ingredient base;
    private final Ingredient addition;

    public VisibleArmorRecipe(Identifier id) {
        this.id = id;
        this.template = Ingredient.ofItems(ModItems.VISIBLE_ARMOR_SMITHING_TEMPLATE);
        this.base = Ingredient.EMPTY;
        this.addition = Ingredient.ofItems(Items.COPPER_INGOT);
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        ItemStack templateStack = inventory.getStack(0);
        if (!template.test(templateStack)) {
            return false;
        }

        ItemStack baseStack = inventory.getStack(1);
        if (baseStack.isEmpty() || !(baseStack.getItem() instanceof ArmorItem)) {
            return false;
        }

        if (!baseStack.hasNbt() || !baseStack.getNbt().getBoolean("InvisibleArmor")) {
            return false;
        }

        ItemStack additionStack = inventory.getStack(2);
        if (!addition.test(additionStack)) {
            return false;
        }

        return true;
    }

    @Override
    public ItemStack craft(Inventory inventory, DynamicRegistryManager registryManager) {
        ItemStack baseStack = inventory.getStack(1);

        ItemStack result = baseStack.copy();

        if (result.hasNbt()) {
            result.getNbt().remove("InvisibleArmor");

            if (result.getNbt().isEmpty()) {
                result.setNbt(null);
            }
        }

        result.removeCustomName();

        return result;
    }

    @Override
    public boolean fits(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean testTemplate(ItemStack stack) {
        return this.template.test(stack);
    }

    @Override
    public boolean testBase(ItemStack stack) {
        if (!(stack.getItem() instanceof ArmorItem)) {
            return false;
        }
        return stack.hasNbt() && stack.getNbt().getBoolean("InvisibleArmor");
    }

    @Override
    public boolean testAddition(ItemStack stack) {
        return this.addition.test(stack);
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.VISIBLE_ARMOR_RECIPE_SERIALIZER;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public static class Serializer implements RecipeSerializer<VisibleArmorRecipe> {

        @Override
        public VisibleArmorRecipe read(Identifier id, JsonObject json) {
            return new VisibleArmorRecipe(id);
        }

        @Override
        public VisibleArmorRecipe read(Identifier id, PacketByteBuf buf) {
            return new VisibleArmorRecipe(id);
        }

        @Override
        public void write(PacketByteBuf buf, VisibleArmorRecipe recipe) {
        }
    }
}