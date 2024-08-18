package deus.rune.interfaces;

public interface IEntityPlayerAccessor {

	void Rune$setExtraStrengthFromRune(int value);
	void Rune$addExtraStrengthFromRune(int amount);
	int Rune$getExtraStrengthFromRune();
	boolean Rune$getFireHeal();
	void Rune$setFireHeal(boolean value);

	void Rune$setNetherOverpowered(boolean value);
	boolean Rune$getNetherOverpowered();

}
