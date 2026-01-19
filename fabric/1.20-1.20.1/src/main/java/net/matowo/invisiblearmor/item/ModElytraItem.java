package net.matowo.invisiblearmor.item;

import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;


public class ModElytraItem extends ElytraItem implements FabricElytraItem {

    public ModElytraItem(Settings settings) {
        super(settings);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
    }

    @Override
    public boolean useCustomElytra(LivingEntity entity, ItemStack chestStack, boolean tickElytra) {
        return FabricElytraItem.super.useCustomElytra(entity, chestStack, tickElytra);
    }

    @Override
    public void doVanillaElytraTick(LivingEntity entity, ItemStack chestStack) {
        FabricElytraItem.super.doVanillaElytraTick(entity, chestStack);
    }

    public static boolean isUsable(ItemStack stack) {
        return stack.getDamage() < stack.getMaxDamage() - 1;
    }

}