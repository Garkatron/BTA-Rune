package deus.rune.item.runes;

import deus.rune.interfaces.IEntityPlayerAccesor;
import deus.rune.item.runes.core.Rune;
import net.minecraft.core.entity.player.EntityPlayer;

// Resistance, Reduce damage, add strength

public class Sowilo extends Rune {

	private IEntityPlayerAccesor currentUser;

	private int strength = 0;

	public Sowilo(int strength) {
		setActivationTimeSeconds(2);
		setCooldownTimeSeconds(2);
		this.strength = strength;
	}

	@Override
	public void effect(EntityPlayer player) {
		IEntityPlayerAccesor customPlayer = (IEntityPlayerAccesor) player;
		customPlayer.Rune$addExtraStrengthFromRune(strength);
		player.sendMessage("Strength aumented in:" + strength);
		currentUser = customPlayer;
	}

	@Override
	public void reactivate() {
		super.reactivate();
		currentUser.Rune$setExtraStrengthFromRune(0);
	}
}
