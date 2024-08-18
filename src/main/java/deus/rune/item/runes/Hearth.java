package deus.rune.item.runes;

import deus.rune.interfaces.IEntityPlayerAccessor;
import deus.rune.item.runes.core.Rune;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.util.helper.DamageType;

public class Hearth extends Rune {
	@Override
	public void effect(EntityPlayer player) {
		IEntityPlayerAccessor customPlayer = (IEntityPlayerAccessor) player;


		customPlayer.Rune$setMaxHealth(30);

	}
}
