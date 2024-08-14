package deus.rune.runes;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class ItemRune extends Item {
	Rune rune;
	public ItemRune(int id, Rune rune) {
		super(id);
		this.rune = rune;
	}

	@Override
	public ItemStack onUseItem(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		return super.onUseItem(itemstack, world, entityplayer);
	}
}
