package net.matowo.invisiblearmor.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HumanoidArmorLayer.class)
public abstract class HumanoidArmorLayerMixin<T extends LivingEntity, M extends HumanoidModel<T>, A extends HumanoidModel<T>> {

    @Inject(
            method = "renderArmorPiece",
            at = @At("HEAD"),
            cancellable = true
    )
    private void matowos$cancelInvisibleArmorPiece(
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            T entity,
            EquipmentSlot slot,
            int packedLight,
            A model,
            CallbackInfo ci
    ) {
        ItemStack armorStack = entity.getItemBySlot(slot);

        if (!armorStack.isEmpty() && matowos$hasInvisibleTag(armorStack)) {
            ci.cancel();
        }
    }

    @Unique
    private static boolean matowos$hasInvisibleTag(ItemStack stack) {
        return stack.hasTag() && stack.getTag().getBoolean("InvisibleArmor");
    }
}