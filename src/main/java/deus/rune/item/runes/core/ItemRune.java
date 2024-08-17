package deus.rune.item.runes.core;

import net.minecraft.core.entity.Entity;
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

	public ItemRune(String name, int id, Rune rune) {
		super(name, id);
		this.rune = rune;
	}

	@Override
	public ItemStack onUseItem(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		rune.activate(entityplayer);
		return super.onUseItem(itemstack, world, entityplayer);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
		rune.update(entity);
		super.inventoryTick(itemstack, world, entity, i, flag);
	}
}
