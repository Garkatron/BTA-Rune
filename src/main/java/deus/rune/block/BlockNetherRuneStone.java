package deus.rune.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

import java.util.Random;

import static deus.rune.item.RuneItems.*;

public class BlockNetherRuneStone extends Block {
	public BlockNetherRuneStone(String key, int id, Material material) {
		super(key, id, material);
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		Random rand = new Random();
		int random = rand.nextInt(100000);

		if (random < 1) {
			return new ItemStack[]{new ItemStack(nether, rand.nextInt(1))};
		} else {
			return new ItemStack[]{new ItemStack(netherrack, rand.nextInt(1))};
		}
	}
}
