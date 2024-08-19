package deus.rune.interfaces;

import deus.rune.item.runes.core.Rune;

import java.util.List;

public interface IEntityPlayerAccessor {

	void Rune$setExtraStrengthFromRune(int value);
	void Rune$addExtraStrengthFromRune(int amount);
	int Rune$getExtraStrengthFromRune();
	boolean Rune$getFireHeal();
	void Rune$setFireHeal(boolean value);
	void Rune$setFireHealAlways(boolean value);
	boolean Rune$getFireHealAlways();

	void Rune$setNetherOverpowered(boolean value);
	boolean Rune$getNetherOverpowered();

	void Rune$setMaxHealth(int value);

	void Rune$addPermanentRune(Rune rune);
	Rune Rune$getPermanentRune(int index);
	List<Rune> Rune$getPermanentRunes();

}
