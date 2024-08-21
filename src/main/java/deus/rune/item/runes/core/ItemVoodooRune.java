package deus.rune.item.runes.core;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFood;

public class ItemVoodooRune extends Item {

	private final boolean isWolfsFavoriteMeat;

	public ItemVoodooRune(String name, int id, boolean isWolfsFavoriteMeat) {
		super(name, id);

		this.isWolfsFavoriteMeat = isWolfsFavoriteMeat;
	}

	public boolean getIsWolfsFavoriteMeat() {
		return this.isWolfsFavoriteMeat;
	}

}
