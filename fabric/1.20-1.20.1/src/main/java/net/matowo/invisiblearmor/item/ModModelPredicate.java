package net.matowo.invisiblearmor.item;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicate {
    private static final Identifier BROKEN_ELYTRA_PREDICATE = new Identifier("broken");

    public static void registerBrokenElytraPredicate() {
        FabricModelPredicateProviderRegistry.register(ModItems.INVISIBLE_ELYTRA, BROKEN_ELYTRA_PREDICATE, (stack, world, entity, seed) -> {
            return ModElytraItem.isUsable(stack) ? 0.0f : 1.0f;
        });
    }
}
