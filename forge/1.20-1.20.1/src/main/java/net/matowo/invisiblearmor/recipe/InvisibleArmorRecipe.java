package net.matowo.invisiblearmor.recipe;

import net.matowo.invisiblearmor.item.ModItems;
import net.matowo.invisiblearmor.util.InvisibleNameHelper;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
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
import net.minecraftforge.registries.ForgeRegistries;

public class InvisibleArmorRecipe extends SmithingTransformRecipe {

    public InvisibleArmorRecipe(ResourceLocation id, Ingredient template, Ingredient base, Ingredient addition, ItemStack result) {
        super(id, template, base, addition, result);
    }

    public InvisibleArmorRecipe(ResourceLocation id) {
        this(
                id,
                Ingredient.of(ModItems.INVISIBLE_ARMOR_SMITHING_TEMPLATE.get()),
                Ingredient.EMPTY,
                Ingredient.of(Items.COPPER_INGOT),
                ItemStack.EMPTY
        );
    }

    @Override
    public boolean isBaseIngredient(ItemStack stack) {
        if (stack.isEmpty()) return false;

        // Rechazar armaduras vanilla (namespace minecraft)
        ResourceLocation itemId = ForgeRegistries.ITEMS.getKey(stack.getItem());
        if (itemId != null && itemId.getNamespace().equals("minecraft")) {
            return false;
        }

        return isArmorLikeItem(stack);
    }

    @Override
    public boolean isTemplateIngredient(ItemStack stack) {
        return Ingredient.of(ModItems.INVISIBLE_ARMOR_SMITHING_TEMPLATE.get()).test(stack);
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

        ResourceLocation itemId = ForgeRegistries.ITEMS.getKey(baseStack.getItem());
        if (itemId != null && itemId.getNamespace().equals("minecraft")) {
            return false;
        }

        if (baseStack.hasTag() && baseStack.getTag().getBoolean("InvisibleArmor")) {
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

        result.getOrCreateTag().putBoolean("InvisibleArmor", true);

        if (result.getItem() instanceof ArmorItem armorItem) {
            Component invisibleName = InvisibleNameHelper.buildInvisibleName(result, armorItem);
            result.setHoverName(invisibleName);
        } else {
            EquipmentSlot slot = LivingEntity.getEquipmentSlotForItem(result);
            String slotKey = switch (slot) {
                case HEAD -> "helmet";
                case CHEST -> "chestplate";
                case LEGS -> "leggings";
                case FEET -> "boots";
                default -> "helmet";
            };
            Component baseName = Component.translatable(result.getItem().getDescriptionId());
            Component invisibleName = Component.translatable(
                    "item.matowos_invisible_armor.invisible." + slotKey,
                    baseName
            ).withStyle(style -> style.withItalic(false));
            result.setHoverName(invisibleName);
        }

        return result;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.INVISIBLE_ARMOR_RECIPE_SERIALIZER.get();
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