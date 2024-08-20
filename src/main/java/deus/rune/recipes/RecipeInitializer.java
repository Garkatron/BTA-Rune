package deus.rune.recipes;

import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.RecipeBuilder;

import static deus.rune.RuneMod.MOD_ID;
import static deus.rune.item.RuneItems.*;

public class RecipeInitializer {
	public static void initialize() {

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"rrr",
				"rdr",
				"rrr")
			.addInput('r', runePebble)
			.addInput('d', Item.foodAppleGold)
			.create("RecipeLittleBerkano", little_berkano.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"rrr",
				"rdr",
				"rrr")
			.addInput('r', runeRock)
			.addInput('d', Item.foodAppleGold)
			.create("RecipeBerkano", berkano.getDefaultStack());

		//

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"rrr",
				"rdr",
				"rrr")
			.addInput('r', runeRock)
			.addInput('d', Item.armorChestplateSteel)
			.create("RecipeSowilo", sowilo.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"rrr",
				"fdf",
				"rrr")
			.addInput('r', runeRock)
			.addInput('d', Item.bucketLava)
			.addInput('f', Item.lanternFireflyRed)
			.create("RecipeArT0", art0.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"rnr",
				"ndn",
				"rnr")
			.addInput('r', runeRock)
			.addInput('d', Item.bucketLava)
			.addInput('n', Item.nethercoal)
			.create("RecipeArT1", art1.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"rnr",
				"ndn",
				"rnr")
			.addInput('r', runeRock)
			.addInput('d', art1)
			.addInput('n', Item.nethercoal)
			.create("RecipeArT2", art2.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"rnr",
				"ndn",
				"rnr")
			.addInput('r', runeRock)
			.addInput('d', Item.foodAppleGold)
			.addInput('n', Item.diamond)
			.create("RecipeHeart", heart.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"rnr",
				"ndn",
				"rnr")
			.addInput('r', Item.ingotSteel)
			.addInput('d', heart)
			.addInput('n', Item.toolSwordSteel)
			.create("RecipeVengeanceHeart", vengeanceHeart.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"nnn",
				"ndn",
				"nnn")
			.addInput('d', Item.slimeball)
			.addInput('n', runeRock)
			.create("RecipeAlcarin", alcarin.getDefaultStack());
	}
}
