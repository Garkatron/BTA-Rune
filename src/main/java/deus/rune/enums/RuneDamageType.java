package deus.rune.enums;

import net.minecraft.core.util.helper.DamageType;

public class RuneDamageType extends DamageType {

	public static final DamageType MAGIC = new DamageType("damagetype.magic", false, true, 0);


	public RuneDamageType(String languageKey, boolean shouldDamageArmor, boolean shouldDisplay, int iconIndex) {
		super(languageKey, shouldDamageArmor, shouldDisplay, iconIndex);
	}


}
