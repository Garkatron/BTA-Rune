package deus.rune.util;

import deus.rune.Debug.Debug;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

import java.util.Locale;

import static deus.rune.RuneMod.MOD_ID;

public class ConfigHandler {

	private int BLOCK_ID;
	private int ITEM_ID;

	private static final TomlConfigHandler config;

	static {
		Toml toml = new Toml(MOD_ID.toUpperCase(Locale.ROOT));

		toml.addCategory("IDs")
			.addEntry("startBlockId", 12000)
			.addEntry("startItemId", 11000)
		;
		config = new TomlConfigHandler(null, MOD_ID, toml);
	}

	public ConfigHandler() {
		BLOCK_ID = config.getInt("IDs.startBlockId");
		ITEM_ID = config.getInt("IDs.startItemId");
	}


	public TomlConfigHandler getConfig() {
		return config;
	}

	public int newBlockID() {
		BLOCK_ID = BLOCK_ID + 1;
		return BLOCK_ID;
	}

	public int newItemID() {
		ITEM_ID = ITEM_ID + 1;
		return ITEM_ID;
	}

}
