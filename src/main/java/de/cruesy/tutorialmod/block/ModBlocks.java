package de.cruesy.tutorialmod.block;

import de.cruesy.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block PINK_DIAMOND_BLOCK = registerBlock("pink_diamond_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(5f, 1f)
                    .requiresTool()
                    .instrument(NoteBlockInstrument.BASEDRUM)));

public static final Block PINK_DIAMOND_ORE = registerBlock("pink_diamond_ore",
        new ExperienceDroppingBlock(UniformIntProvider.create(5, 7),
                AbstractBlock.Settings.create()
                        .strength(4f)
                        .requiresTool()));
public static final Block PINK_DIAMOND_DEEPSLATE_ORE = registerBlock("pink_diamond_deepslate_ore",
        new ExperienceDroppingBlock(UniformIntProvider.create(5, 7),
                AbstractBlock.Settings.create()
                        .strength(5f)
                        .sounds(BlockSoundGroup.DEEPSLATE)
                        .requiresTool()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(PINK_DIAMOND_BLOCK);
        });
    }
}



