package deus.rune;

import deus.rune.runes.ItemRune;
import deus.rune.runes.curative.Berkano;
import turniplabs.halplibe.helper.CreativeHelper;
import turniplabs.halplibe.helper.ItemBuilder;

import static deus.rune.RuneMod.MOD_ID;

public class RuneItems {

	ItemBuilder genericItemBuilder = new ItemBuilder(MOD_ID);

	public static ItemRune berkano = new ItemRune("berkano",11000,new Berkano());


	public RuneItems() {
		berkano = genericItemBuilder.build(berkano);
		CreativeHelper.setPriority(berkano, 1001);
	}
}
