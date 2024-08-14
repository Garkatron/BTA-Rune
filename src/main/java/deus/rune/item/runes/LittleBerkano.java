package deus.rune.item.runes;

import deus.rune.item.runes.core.Rune;
import net.minecraft.core.entity.player.EntityPlayer;

public class LittleBerkano extends Rune {

	public LittleBerkano() {
		setChargeSpentValue(500);
		setChargeAmount(10);
		setMaxCharge(500);
	}

	@Override
	public void effect(EntityPlayer player) {
		player.heal(2);
	}
}
