package net.matowo.invisiblearmor.mixin;

import net.matowo.invisiblearmor.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Item.class)
public abstract class InvisibleTurtleHelmetMixin {

    @Inject(method = "inventoryTick(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Lnet/minecraft/entity/Entity;IZ)V",
            at = @At("HEAD"))
    private void onInventoryTick(ItemStack stack, World world, net.minecraft.entity.Entity entity, int slot, boolean selected, CallbackInfo ci) {
        if (world.isClient) return;
        if (!(entity instanceof LivingEntity living)) return;

        if (stack.getItem() == ModItems.INVISIBLE_TURTLE_HELMET &&
                living.getEquippedStack(EquipmentSlot.HEAD) == stack) {

            BlockPos eyePos = BlockPos.ofFloored(living.getX(), living.getEyeY(), living.getZ());
            FluidState fluidState = world.getFluidState(eyePos);
            boolean headInWater = fluidState.getFluid() == Fluids.WATER || fluidState.getFluid() == Fluids.FLOWING_WATER;

            boolean headInBubbleColumn = world.getBlockState(eyePos).isOf(Blocks.BUBBLE_COLUMN);

            if (!headInWater && !headInBubbleColumn) {
                StatusEffectInstance currentEffect = living.getStatusEffect(StatusEffects.WATER_BREATHING);

                if (currentEffect == null || currentEffect.getDuration() < 300) {
                    living.addStatusEffect(new StatusEffectInstance(
                            StatusEffects.WATER_BREATHING,
                            205,
                            0,
                            false, false, true
                    ));
                }
            }
        }
    }
}
