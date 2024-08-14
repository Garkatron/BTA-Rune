package deus.rune.runes.curative;

import deus.rune.enums.RuneDamageType;
import deus.rune.runes.Rune;
import net.minecraft.core.entity.player.EntityPlayer;

public class Berkano extends Rune {

	public Berkano() {
		setChargeSpentValue(1000);
		setChargeAmount(50);
		setMaxCharge(1000);
	}

	@Override
	public void effect(EntityPlayer player) {
		player.heal(2);

	}
}
