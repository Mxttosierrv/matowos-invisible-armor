package net.matowo.invisiblearmor.mixin;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArmorFeatureRenderer.class)
public abstract class ArmorFeatureRendererMixin<T extends LivingEntity, M extends BipedEntityModel<T>, A extends BipedEntityModel<T>>
        extends FeatureRenderer<T, M> {

    public ArmorFeatureRendererMixin(FeatureRendererContext<T, M> context) {
        super(context);
    }

    /**
     * PUNTO 1: Intercepta el método render principal ANTES de cualquier procesamiento
     **/
    @Inject(
            method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void matowos$beforeMainRender(
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light,
            T entity,
            float limbAngle,
            float limbDistance,
            float tickDelta,
            float animationProgress,
            float headYaw,
            float headPitch,
            CallbackInfo ci
    ) {
        boolean hasArmor = false;
        boolean allInvisible = true;

        for (EquipmentSlot slot : EquipmentSlot.values()) {
            if (slot.getType() == EquipmentSlot.Type.ARMOR) {
                ItemStack stack = entity.getEquippedStack(slot);
                if (!stack.isEmpty()) {
                    hasArmor = true;
                    if (!hasInvisibleTag(stack)) {
                        allInvisible = false;
                        break;
                    }
                }
            }
        }

        if (hasArmor && allInvisible) {
            ci.cancel();
        }
    }

    /**
     * PUNTO 2: Intercepta renderArmor para cada pieza individual
     **/
    @Inject(
            method = "renderArmor(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/entity/EquipmentSlot;ILnet/minecraft/client/render/entity/model/BipedEntityModel;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void matowos$beforeRenderArmor(
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            T entity,
            EquipmentSlot armorSlot,
            int light,
            A model,
            CallbackInfo ci
    ) {
        ItemStack armorStack = entity.getEquippedStack(armorSlot);

        if (hasInvisibleTag(armorStack)) {
            ci.cancel();
        }
    }

    /**
     * PUNTO 3: Intercepta renderArmorParts
     **/
    @Inject(
            method = "renderArmorParts(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/item/ArmorItem;ZLnet/minecraft/client/render/entity/model/BipedEntityModel;ZFFFLjava/lang/String;)V",
            at = @At("HEAD"),
            cancellable = true,
            require = 0  // No requerido - puede no existir en todas las versiones
    )
    private void matowos$beforeRenderArmorParts(CallbackInfo ci) {
    }

    private boolean hasInvisibleTag(ItemStack stack) {
        if (stack.isEmpty()) {
            return false;
        }

        if (!stack.hasNbt()) {
            return false;
        }

        return stack.getNbt().getBoolean("InvisibleArmor");
    }
}