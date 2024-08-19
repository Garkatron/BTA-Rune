package deus.rune.util;

import deus.rune.item.runes.core.Rune;
import turniplabs.halplibe.util.ConfigUpdater;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static deus.rune.RuneMod.MOD_ID;

public class ConfigHandler {

	private int BLOCK_ID;
	private int ITEM_ID;

	private static final TomlConfigHandler config;
	private static File players;

	static {
		Toml toml = new Toml(MOD_ID.toUpperCase(Locale.ROOT));

		toml.addCategory("IDs")
			.addEntry("startBlockId", 12000)
			.addEntry("startItemId", 11000);

		config = new TomlConfigHandler(null, MOD_ID, toml);

		// Inicializa el archivo de jugadores
		try {
			// Reemplaza el nombre del archivo en la ruta de configuración
			File playersFile = replaceFileName(config.getFilePath(), "permanent_rune_player.txt");
			players = new File(playersFile.getAbsolutePath());
			if (!players.exists()) {
				players.createNewFile(); // Crea el archivo si no existe
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static File replaceFileName(String oldFilePath, String newFileName) throws IOException {
		File oldFile = new File(oldFilePath);
		String directoryPath = oldFile.getParent();

		if (directoryPath == null) {
			throw new IOException("Invalid file path: " + oldFilePath);
		}

		return new File(directoryPath, newFileName);
	}

	public ConfigHandler() {
		BLOCK_ID = config.getInt("IDs.startBlockId");
		ITEM_ID = config.getInt("IDs.startItemId");
	}

	public void addPlayerWithPermanentRune(String playerName, Rune rune) {
		if (playerName == null || rune == null) {
			throw new IllegalArgumentException("Player name and rune cannot be null");
		}

		String entry = playerName + "/" + rune.getClass().getSimpleName();
		boolean entryExists = false;

		// Verificar si la entrada ya existe en el archivo
		try (BufferedReader reader = new BufferedReader(new FileReader(players))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.equals(entry)) {
					entryExists = true;
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace(); // Maneja el error de manera apropiada
		}

		// Si la entrada no existe, añadirla al archivo
		if (!entryExists) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(players, true))) {
				writer.write(entry);
				writer.newLine(); // Añade una nueva línea para separar entradas
			} catch (IOException e) {
				e.printStackTrace(); // Maneja el error de manera apropiada
			}
		} else {
			System.out.println("Entry already exists: " + entry);
		}
	}

	public boolean verifyPlayerWithPermanentRune(String playerName, Rune rune) {
		if (playerName == null || rune == null) {
			throw new IllegalArgumentException("Player name and rune cannot be null");
		}

		String entry = playerName + "/" + rune.getClass().getSimpleName();
		boolean entryExists = false;

		// Verificar si la entrada ya existe en el archivo
		try (BufferedReader reader = new BufferedReader(new FileReader(players))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.equals(entry)) {
					entryExists = true;
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace(); // Maneja el error de manera apropiada
		}
		return entryExists;

	}
	public List<String> getPlayerPermanentRunes(String playerName) {
		if (playerName == null) {
			throw new IllegalArgumentException("Player name cannot be null");
		}

		String entryPrefix = playerName + "/";
		List<String> runeNames = new ArrayList<>();

		System.out.println("EN---->"+entryPrefix);

		try (BufferedReader reader = new BufferedReader(new FileReader(players))) {
			String line;
			while ((line = reader.readLine()) != null) {

				// Verificar si la línea contiene el nombre del jugador y extraer la runa
				if (line.startsWith(entryPrefix)) {
					// Extraer la parte de la runa después del '/'
					String runeName = line.substring(entryPrefix.length());
					runeNames.add(runeName);

				}
			}
		} catch (IOException e) {
			e.printStackTrace(); // Maneja el error de manera apropiada
		}

		return runeNames;
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
