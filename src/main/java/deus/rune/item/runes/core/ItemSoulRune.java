package deus.rune.item.runes.core;

import deus.rune.interfaces.IEntityPlayerAccessor;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

import static deus.rune.RuneMod.MOD_CONFIG;

public class ItemSoulRune extends Item {

	Rune rune;

	public ItemSoulRune(String name, int id, Rune rune) {
		super(name, id);
		this.rune = rune;
	}

	@Override
	public ItemStack onUseItem(ItemStack itemstack, World world, EntityPlayer entityplayer) {

		IEntityPlayerAccessor customPlayer = (IEntityPlayerAccessor) entityplayer;


		if(!MOD_CONFIG.verifyPlayerWithPermanentRune(entityplayer.username, rune)) {
			rune.effect(entityplayer);
			customPlayer.Rune$addPermanentRune(rune);
			MOD_CONFIG.addPlayerWithPermanentRune(entityplayer.username, rune);
			itemstack.consumeItem(entityplayer);
		} else {
			entityplayer.sendMessage("You already possess this soul rune in your soul. It cannot be consumed again.");
		}


		return itemstack;
	}
}
