package net.simoncheek.deadlynightsmod.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import java.util.Random;


public class CustomSwordItem extends SwordItem {

    public CustomSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }


    // method that makes it so 1/10 attacks deal extra damage !

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        float baseDamage = this.getDamage();
        // create random chance generator for extra damage (90% chance atm)
        Random rand = new Random();
        int rand_chance = rand.nextInt(100);
        if (rand_chance <= 10) {
            baseDamage *= 1.5f;
        }

        target.hurt(attacker.damageSources().playerAttack((Player) attacker), baseDamage);

        return super.hurtEnemy(stack, target, attacker);
    }

}
