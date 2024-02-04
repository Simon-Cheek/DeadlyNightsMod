package net.simoncheek.deadlynightsmod.item;

import net.minecraft.world.item.Item;
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
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
