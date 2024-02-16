package net.simoncheek.deadlynightsmod.item;


import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.Random;
import java.util.logging.Level;


public class CustomSwordItem extends SwordItem {

    float modifiedDamage = calculateModifiedDamage();
    boolean modified = false;

    public CustomSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }


    private float calculateModifiedDamage(){
        float baseDamage = this.getDamage();
        Random creationRand = new Random();
        int creationInt = creationRand.nextInt(100);
        if (creationInt <= 50) {
            baseDamage += 100;
            this.modified = true;
        }
        return baseDamage;
    }


    @Override
    public void appendHoverText(ItemStack pStack, @org.jetbrains.annotations.Nullable net.minecraft.world.level.Level pLevel, java.util.List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (this.modified) {
            pTooltipComponents.add(Component.literal("Modified!"));
        }
        pTooltipComponents.add(Component.literal("Basic"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }


    // method that makes it so 1/10 attacks deal extra damage !

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        float baseDamage = this.getDamage();
        // create random chance generator for extra damage (90% chance atm)
        Random rand = new Random();
        int rand_chance = rand.nextInt(100);
        if (rand_chance <= 10) {
            baseDamage *= 1.8f;
        }

        target.hurt(attacker.damageSources().playerAttack((Player) attacker), baseDamage);

        return super.hurtEnemy(stack, target, attacker);
    }

}
