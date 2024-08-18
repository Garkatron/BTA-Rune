package deus.rune.item;

import deus.rune.Debug.StaticFieldsExtractor;
import deus.rune.item.runes.Ar;
import deus.rune.item.runes.Berkano;
import deus.rune.item.runes.LittleBerkano;
import deus.rune.item.runes.Sowilo;
import deus.rune.item.runes.core.ItemRune;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.CreativeHelper;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.helper.RecipeBuilder;

import java.lang.reflect.Field;

import static deus.rune.RuneMod.MOD_ID;

public class RuneItems {

	ItemBuilder genericItemBuilder = new ItemBuilder(MOD_ID);

	public static Item runePebble = new Item("rune.pebble", 11001);
	public static Item runeRock = new Item("rune.rock", 11002);
	public static ItemRune berkano = new ItemRune("berkano",11003, new Berkano());
	public static ItemRune little_berkano = new ItemRune("little.berkano",11004, new LittleBerkano());
	public static ItemRune sowilo = new ItemRune("sowilo",11005, new Sowilo(26));
	public static ItemRune art0 = new ItemRune("ar.t0",11006, new Ar(0));
	public static ItemRune art1 = new ItemRune("ar.t1",11007, new Ar(1));
	public static ItemRune art2 = new ItemRune("ar.t2",11008, new Ar(2));

	public RuneItems() {
		berkano = genericItemBuilder.build(berkano);
		little_berkano = genericItemBuilder.build(little_berkano);
		sowilo = genericItemBuilder.build(sowilo);
		art0 = genericItemBuilder.build(art0);
		art1 = genericItemBuilder.build(art1);
		art2 = genericItemBuilder.build(art2);
		runePebble = genericItemBuilder.build(runePebble);
		runeRock = genericItemBuilder.build(runeRock);

		assignPriorities(this.getClass());

	}

	public static void assignPriorities(Class<?> c) {
		int initialPriority = 1001;
		try {
			String[] staticFieldNames = StaticFieldsExtractor.extractor(c);
			for (String fieldName : staticFieldNames) {
				Field field = c.getDeclaredField(fieldName);
				field.setAccessible(true);
				Object value = field.get(null);

				if (value instanceof Item) {
					Item item = (Item) value;
					CreativeHelper.setPriority(item, initialPriority);
					initialPriority++;

				}
			}
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
