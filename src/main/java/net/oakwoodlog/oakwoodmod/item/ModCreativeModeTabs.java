package net.oakwoodlog.oakwoodmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.oakwoodlog.oakwoodmod.OakWoodMod;
import net.oakwoodlog.oakwoodmod.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OakWoodMod.MOD_ID);

    public static final Supplier<CreativeModeTab> DANIEL_ITEMS_TAB = CREATIVE_MODE_TAB.register("daniel_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DANIEL.get()))
                    .title(Component.translatable("creativetab.oakwoodmod.daniel_items"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.DANIEL);
                        output.accept(ModItems.ANTIDANIEL);

                    }).build());

    public static final Supplier<CreativeModeTab> DANIEL_BLOCKS_TAB = CREATIVE_MODE_TAB.register("daniel_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.DANIEL_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(OakWoodMod.MOD_ID, "daniel_items_tab"))
                    .title(Component.translatable("creativetab.oakwoodmod.daniel_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModBlocks.DANIEL_BLOCK);
                        output.accept(ModBlocks.ANTIDANIEL_BLOCK);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
