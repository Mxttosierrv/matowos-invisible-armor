package net.matowo.invisiblearmor.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.level.block.DispenserBlock;

public class ModElytraItem extends ElytraItem {

    public ModElytraItem(Properties pProperties) {
        super(pProperties);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, LivingEntity pEntity, InteractionHand pHand) {
        return this.swapWithEquipmentSlot((Item) this, pLevel, (Player) pEntity, pHand);
    }

    @Override
    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        return isFlyEnabled(stack);
    }
    

    @Override
    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
        if (!entity.level().isClientSide) {
            int nextFlightTick = flightTicks + 1;
            if (nextFlightTick % 10 == 0) {
                if (nextFlightTick % 20 == 0) {
                    stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.CHEST));
                }
                entity.gameEvent(net.minecraft.world.level.gameevent.GameEvent.ELYTRA_GLIDE);
            }
        }
        return true;
    }


    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_ELYTRA;
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.CHEST;
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(Items.PHANTOM_MEMBRANE);
    }
}
