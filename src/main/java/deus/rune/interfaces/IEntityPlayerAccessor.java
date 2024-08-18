package deus.rune.interfaces;

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


}
