package net.oakwoodlog.oakwoodmod.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.oakwoodlog.oakwoodmod.OakWoodMod;

public class ModItems {

    // Create a deferred register to register items to my mod ID
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(OakWoodMod.MOD_ID);

    public static final DeferredItem<Item> DANIEL = ITEMS.register("daniel",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ANTIDANIEL = ITEMS.register("antidaniel",
            () -> new Item(new Item.Properties()));

    // Registers the mod event bus to the deferred register
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
