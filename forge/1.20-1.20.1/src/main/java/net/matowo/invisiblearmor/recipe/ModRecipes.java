package net.matowo.invisiblearmor.recipe;

import com.google.gson.JsonObject;
import net.matowo.invisiblearmor.MatowosInvisibleArmor;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MatowosInvisibleArmor.MOD_ID);

    public static final RegistryObject<RecipeSerializer<InvisibleArmorRecipe>> INVISIBLE_ARMOR_RECIPE_SERIALIZER =
            RECIPE_SERIALIZERS.register("invisible_armor", () -> new RecipeSerializer<InvisibleArmorRecipe>() {
                @Override
                public InvisibleArmorRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
                    return new InvisibleArmorRecipe(recipeId);
                }

                @Override
                public InvisibleArmorRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
                    return new InvisibleArmorRecipe(recipeId);
                }

                @Override
                public void toNetwork(FriendlyByteBuf buffer, InvisibleArmorRecipe recipe) {
                }
            });

    public static final RegistryObject<RecipeSerializer<VisibleArmorRecipe>> VISIBLE_ARMOR_RECIPE_SERIALIZER =
            RECIPE_SERIALIZERS.register("visible_armor", () -> new RecipeSerializer<VisibleArmorRecipe>() {
                @Override
                public VisibleArmorRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
                    return new VisibleArmorRecipe(recipeId);
                }

                @Override
                public VisibleArmorRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
                    return new VisibleArmorRecipe(recipeId);
                }

                @Override
                public void toNetwork(FriendlyByteBuf buffer, VisibleArmorRecipe recipe) {
                }
            });

    public static void register(net.minecraftforge.eventbus.api.IEventBus eventBus) {
        RECIPE_SERIALIZERS.register(eventBus);
    }
}