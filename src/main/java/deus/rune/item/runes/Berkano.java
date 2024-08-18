package deus.rune.item.runes;

import deus.rune.Debug.Debug;
import deus.rune.item.runes.core.Rune;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.EntityPlayer;

public class Berkano extends Rune {

	public Berkano() {
		setActivationTimeSeconds(5);
		setCooldownTimeSeconds(15);
		setIsOvertime(true);
	}



	@Override
	public void effect(EntityPlayer player) {
		player.heal(2);
	}
}
