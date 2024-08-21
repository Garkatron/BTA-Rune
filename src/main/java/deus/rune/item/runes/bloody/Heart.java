package deus.rune.item.runes.bloody;

import deus.rune.interfaces.IEntityPlayerAccessor;
import deus.rune.item.runes.core.Rune;
import net.minecraft.core.entity.player.EntityPlayer;

public class Heart extends Rune {
	@Override
	public void effect(EntityPlayer player) {
		IEntityPlayerAccessor customPlayer = (IEntityPlayerAccessor) player;
		customPlayer.Rune$setMaxHealth(player.getMaxHealth()+2);
	}
}
