package net.simoncheek.deadlynightsmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.simoncheek.deadlynightsmod.DeadlyNightsMod;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DeadlyNightsMod.MODID);

    // NEW CREATIVE MODE TAB HERE TO INSERT ITEMS
    public static final RegistryObject<CreativeModeTab> DEADLY_NIGHTS_TAB =
            CREATIVE_MODE_TABS.register("deadly_nights_tab",
                    () -> CreativeModeTab.builder().icon(
                            () -> new ItemStack(ModItems.ENHANCED_DIAMOND_SWORD.get()))
                            .title(Component.translatable("creativetab.deadly_nights_tab"))
                            .displayItems((pParameters, pOutput) -> {

                                // PUT ALL ITEMS IN THE CREATIVE TAB HERE IN THIS FORMAT

                                pOutput.accept(ModItems.ENHANCED_IRON_SWORD.get());
                                pOutput.accept(ModItems.ENHANCED_GOLD_SWORD.get());
                                pOutput.accept(ModItems.ENHANCED_DIAMOND_SWORD.get());

                            })
                            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
