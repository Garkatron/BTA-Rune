package deus.rune.item.runes.normal;

import deus.rune.item.runes.core.Rune;
import net.minecraft.core.entity.player.EntityPlayer;

public class LittleBerkano extends Rune {

	public LittleBerkano() {
		setActivationTimeSeconds(1);
		setCooldownTimeSeconds(5);
	}

	@Override
	public void effect(EntityPlayer player) {
		player.heal(2);
	}
}
