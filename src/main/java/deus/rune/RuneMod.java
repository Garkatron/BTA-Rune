package deus.rune;

import deus.rune.Debug.Debug;
import deus.rune.block.BlockInitializer;
import deus.rune.item.RuneItems;
import deus.rune.util.ConfigHandler;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;


public class RuneMod implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
    public static final String MOD_ID = "rune";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ConfigHandler MOD_CONFIG = new ConfigHandler();

    @Override
    public void onInitialize() {
		Debug.isDebug = true;
		new RuneItems();
		new BlockInitializer().initialize();
		LOGGER.info("RuneMod initialized.");

    }

	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {

		new BlockInitializer().blockAddDetails();
	}

	@Override
	public void onRecipesReady() {
		RecipeInitializer.initialize();
	}

	@Override
	public void initNamespaces() {

	}
}
