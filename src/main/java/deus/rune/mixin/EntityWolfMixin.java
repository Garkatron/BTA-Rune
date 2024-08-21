package deus.rune.mixin;

import net.minecraft.core.entity.animal.EntityWolf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityWolf.class)
public class EntityWolfMixin {

	@Redirect(method = "", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/entity/animal/EntityWolf;isWolfTamed()Z"))
	private void modifyOnEntityLiving() {

	}

}
