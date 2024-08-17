package deus.rune.item;

import deus.rune.item.runes.Berkano;
import deus.rune.item.runes.LittleBerkano;
import deus.rune.item.runes.Sowilo;
import deus.rune.item.runes.core.ItemRune;
import turniplabs.halplibe.helper.CreativeHelper;
import turniplabs.halplibe.helper.ItemBuilder;

import static deus.rune.RuneMod.MOD_ID;

public class RuneItems {

	ItemBuilder genericItemBuilder = new ItemBuilder(MOD_ID);

	public static ItemRune berkano = new ItemRune("berkano",11000, new Berkano());
	public static ItemRune little_berkano = new ItemRune("little.berkano",11001, new LittleBerkano());
	public static ItemRune sowilo = new ItemRune("sowilo",11002, new Sowilo(26));

	public RuneItems() {
		berkano = genericItemBuilder.build(berkano);
		little_berkano = genericItemBuilder.build(little_berkano);
		sowilo = genericItemBuilder.build(sowilo);
		CreativeHelper.setPriority(berkano, 1001);
		CreativeHelper.setPriority(little_berkano, 1002);
		CreativeHelper.setPriority(sowilo, 1003);
	}
}
