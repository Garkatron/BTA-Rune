package deus.rune.util;

import deus.rune.item.runes.*;
import deus.rune.item.runes.core.Rune;

import java.util.HashMap;
import java.util.Map;

public class RuneUtils {
	// A map to store the association between rune names and their corresponding classes
	private static final Map<String, Class<? extends Rune>> runeMap = new HashMap<>();

	// Static block to register all available runes
	static {
		registerRune(Berserker.class);
		registerRune(Berkano.class);
		registerRune(LittleBerkano.class);
		registerRune(Sowilo.class);
		registerRune(Ar.class);
		registerRune(VengeanceHeart.class);
		registerRune(Heart.class);
		registerRune(Nether.class);
	}

	// Method to register a rune by associating its class with its simple name
	private static void registerRune(Class<? extends Rune> runeClass) {
		runeMap.put(runeClass.getSimpleName(), runeClass);
	}

	/**
	 * Retrieves a Rune instance based on the rune's class name.
	 * @param name The simple name of the rune class.
	 * @return A new instance of the Rune, or null if the class is not found or instantiation fails.
	 */
	public static Rune getRuneFromName(String name) {
		Class<? extends Rune> runeClass = runeMap.get(name);
		if (runeClass != null) {
			try {
				// Create a new instance of the rune using the default constructor
				return runeClass.getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				// Handle instantiation exceptions (e.g., no default constructor, access issues)
				e.printStackTrace();
			}
		}
		return null; // Return null if the rune class is not found or instantiation fails
	}
}
