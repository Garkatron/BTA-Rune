package deus.rune.item.runes.core;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class ItemBloodyRune extends ItemFood {

	private final Rune rune;

	public ItemBloodyRune(String name, int id, int healAmount, int ticksPerHeal, boolean favouriteWolfMeat, int maxStackSize, Rune rune) {
		super(name, id, healAmount, ticksPerHeal, favouriteWolfMeat, maxStackSize);
		this.rune = rune;
	}

	@Override
	public ItemStack onUseItem(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		rune.effect(entityplayer);
		itemstack.consumeItem(entityplayer);
		return itemstack;
	}
}
