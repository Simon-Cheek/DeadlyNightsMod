package net.simoncheek.deadlynightsmod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.simoncheek.deadlynightsmod.DeadlyNightsMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DeadlyNightsMod.MODID);

    // THIS IS ITEM SPECIFIC, EDIT THIS LATER TO INPUT OWN ITEM
    public static final RegistryObject<Item> ENHANCED_DIAMOND_SWORD = ITEMS.register("enhanced_diamond_sword",
            () -> new CustomSwordItem(Tiers.DIAMOND,8,-3,
                    new Item.Properties()
                            .stacksTo(1)
                            .defaultDurability(1600)
            ));

    public static final RegistryObject<Item> ENHANCED_GOLD_SWORD = ITEMS.register("enhanced_gold_sword",
            () -> new CustomSwordItem(Tiers.GOLD,8,-3,
                    new Item.Properties()
                            .stacksTo(1)
                            .defaultDurability(200)
            ));

    public static final RegistryObject<Item> ENHANCED_IRON_SWORD = ITEMS.register("enhanced_iron_sword",
            () -> new CustomSwordItem(Tiers.IRON,8,-3,
                    new Item.Properties()
                            .stacksTo(1)
                            .defaultDurability(450)
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
