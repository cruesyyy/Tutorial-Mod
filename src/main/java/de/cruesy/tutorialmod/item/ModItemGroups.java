package de.cruesy.tutorialmod.item;

import de.cruesy.tutorialmod.TutorialMod;
import de.cruesy.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup PINK_DIAMONDS_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "pink_diamond_diamonds"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_DIAMOND))
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_diamond_items"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.PINK_DIAMOND);
                        entries.add(ModBlocks.PINK_DIAMOND_BLOCK);
                        entries.add(ModBlocks.PINK_DIAMOND_ORE);
                        entries.add(ModBlocks.PINK_DIAMOND_DEEPSLATE_ORE);

                    }).build());





    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Regestering Item Groups for " + TutorialMod.MOD_ID);
    }
}
