package deus.rune.item;

import deus.rune.item.runes.*;
import deus.rune.item.runes.core.ItemBloodyRune;
import deus.rune.item.runes.core.ItemSoulRune;
import deus.rune.util.StaticFieldsExtractor;
import deus.rune.item.runes.core.ItemRune;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.CreativeHelper;
import turniplabs.halplibe.helper.ItemBuilder;

import java.lang.reflect.Field;

import static deus.rune.RuneMod.MOD_CONFIG;
import static deus.rune.RuneMod.MOD_ID;

public class RuneItems {

	ItemBuilder genericItemBuilder = new ItemBuilder(MOD_ID);

	public static Item runePebble = new Item("rune.pebble", MOD_CONFIG.newItemID());
	public static Item runeRock = new Item("rune.rock", MOD_CONFIG.newItemID());

	public static ItemRune berkano = new ItemRune("berkano",MOD_CONFIG.newItemID(), new Berkano());
	public static ItemRune little_berkano = new ItemRune("little.berkano",MOD_CONFIG.newItemID(), new LittleBerkano());
	public static ItemRune sowilo = new ItemRune("sowilo",MOD_CONFIG.newItemID(), new Sowilo());
	public static ItemRune art0 = new ItemRune("ar.t0",MOD_CONFIG.newItemID(), new Ar(0));
	public static ItemRune art1 = new ItemRune("ar.t1",MOD_CONFIG.newItemID(), new Ar(1));
	public static ItemRune art2 = new ItemRune("ar.t2",MOD_CONFIG.newItemID(), new Ar(2));

	public static ItemBloodyRune vengeanceHeart = new ItemBloodyRune("heart.vengeance", MOD_CONFIG.newItemID(), new VengeanceHeart());

	public static ItemSoulRune heart = new ItemSoulRune("heart", MOD_CONFIG.newItemID(), new Heart());
	public static ItemSoulRune nether = new ItemSoulRune("nether", MOD_CONFIG.newItemID(), new Nether());
	public static ItemSoulRune berserker = new ItemSoulRune("berserker", MOD_CONFIG.newItemID(), new Berserker());

	public RuneItems() {
		berkano = genericItemBuilder.build(berkano);
		little_berkano = genericItemBuilder.build(little_berkano);
		sowilo = genericItemBuilder.build(sowilo);
		art0 = genericItemBuilder.build(art0);
		art1 = genericItemBuilder.build(art1);
		art2 = genericItemBuilder.build(art2);
		runePebble = genericItemBuilder.build(runePebble);
		runeRock = genericItemBuilder.build(runeRock);
		heart = genericItemBuilder.build(heart);
		vengeanceHeart = genericItemBuilder.build(vengeanceHeart);
		nether = genericItemBuilder.build(nether);
		berserker = genericItemBuilder.build(berserker);

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
