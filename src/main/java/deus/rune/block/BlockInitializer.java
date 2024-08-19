package deus.rune.block;

import deus.rune.blockModel.CustomBlockModel;
import net.minecraft.client.render.block.model.BlockModel;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import net.minecraft.core.sound.BlockSound;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.CreativeHelper;

import static deus.rune.RuneMod.MOD_CONFIG;
import static deus.rune.RuneMod.MOD_ID;

public class BlockInitializer {

	public static Block runeBlock;
	public static Block netherRuneBlock;

	public void initialize() {

		BlockBuilder genericBlockBuilder = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.STONE)
			.setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.0f))
			.setTags(BlockTags.MINEABLE_BY_PICKAXE)
			;

		runeBlock = genericBlockBuilder
			.setBlockModel(block -> new BlockModelStandard<>(block).withTextures("rune:block/rune_block"))
			.setHardness(3.0f)
			.setResistance(5.0f)
			.build(new BlockRuneStone("rune.block", MOD_CONFIG.newBlockID(), Material.stone));

		netherRuneBlock = genericBlockBuilder
			.setBlockModel(block -> new BlockModelStandard<>(block).withTextures("rune:block/rune_nether_block"))
			.setHardness(3.0f)
			.setResistance(3.0f)
			.build(new BlockNetherRuneStone("rune.nether.block", MOD_CONFIG.newBlockID(), Material.stone));
	}

	public void blockAddDetails() {
		ItemToolPickaxe.miningLevels.put(runeBlock, 1);
		CreativeHelper.setParent(runeBlock, Block.netherrack);
		CreativeHelper.setParent(netherRuneBlock, Block.stone);
		Registries.ITEM_GROUPS.register("rune:rune_ores", Registries.stackListOf(runeBlock));
		Registries.ITEM_GROUPS.register("rune:rune_ores", Registries.stackListOf(netherRuneBlock));
	}
}
