package deus.rune.item.runes;

import deus.rune.item.runes.core.Rune;
import net.minecraft.core.entity.player.EntityPlayer;

public class Berkano extends Rune {

	public Berkano() {
		setActivationTimeSeconds(12);
		setCooldownTimeSeconds(15);
	}

	@Override
	public void effect(EntityPlayer player) {
		player.heal(2);
	}
}
