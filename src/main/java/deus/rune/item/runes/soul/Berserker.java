package deus.rune.item.runes.soul;

import deus.rune.interfaces.IEntityPlayerAccessor;
import deus.rune.item.runes.core.Rune;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.util.helper.DamageType;

public class Berserker extends Rune {

	private IEntityPlayerAccessor currentUser;

	private int strength = 0;
	private int maxHealth = 0;

	public Berserker() {

		this.strength = 26;
		this.maxHealth = 2;
	}

	@Override
	public void effect(EntityPlayer player) {
		IEntityPlayerAccessor customPlayer = (IEntityPlayerAccessor) player;

		int difference = player.getHealth() - maxHealth;

		customPlayer.Rune$setExtraStrengthFromRune(strength);
		player.hurt((Entity) null, difference, DamageType.COMBAT);
		customPlayer.Rune$setMaxHealth(maxHealth);

		//player.sendMessage("Strength aumented in:" + strength);

		currentUser = customPlayer;
	}

	@Override
	public void reactivate() {
		super.reactivate();
		//currentUser.Rune$setExtraStrengthFromRune(0);
	}
}
