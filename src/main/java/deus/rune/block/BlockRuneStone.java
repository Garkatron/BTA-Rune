package deus.rune.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

import java.util.Random;

import static deus.rune.item.RuneItems.runePebble;
import static deus.rune.item.RuneItems.runeRock;

public class BlockRuneStone extends Block {
	public BlockRuneStone(String key, int id, Material material) {
		super(key, id, material);
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		Random rand = new Random();
		int random = rand.nextInt(100);

		if (random < 80) { // 70% chance
			return new ItemStack[]{new ItemStack(runePebble, rand.nextInt(8))};
		} else { // 30% chance
			return new ItemStack[]{new ItemStack(runeRock, rand.nextInt(3))};
		}
	}

}
