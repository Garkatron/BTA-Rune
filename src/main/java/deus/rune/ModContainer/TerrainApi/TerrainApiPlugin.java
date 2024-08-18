package deus.rune.ModContainer.TerrainApi;

import deus.rune.block.BlockInitializer;
import useless.terrainapi.api.TerrainAPI;
import useless.terrainapi.generation.overworld.OverworldConfig;
import useless.terrainapi.generation.overworld.api.ChunkDecoratorOverworldAPI;

import static deus.rune.RuneMod.MOD_ID;
import static deus.rune.block.BlockInitializer.runeBlock;


public class TerrainApiPlugin implements TerrainAPI {
	@Override
	public String getModID() {
		return MOD_ID;
	}

	public static final OverworldConfig overworldConfig = ChunkDecoratorOverworldAPI.overworldConfig;

	@Override
	public void onInitialize() {

		ChunkDecoratorOverworldAPI.oreFeatures.addManagedOreFeature(getModID(), runeBlock, 8, 32, 0.0f, 1.0f, false);

	}
}
