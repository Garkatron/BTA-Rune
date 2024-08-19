package deus.rune.item.runes.core;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class ItemBloodyRune extends Item {

	private final Rune rune;

	public ItemBloodyRune(String name, int id, Rune rune) {
		super(name, id);
		this.rune = rune;
	}

	@Override
	public ItemStack onUseItem(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		rune.effect(entityplayer);
		itemstack.consumeItem(entityplayer);
		return itemstack;
	}
}
