package deus.rune.mixin;

import deus.rune.interfaces.IEntityLivingAccesor;
import net.minecraft.core.entity.EntityLiving;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityLiving.class)
public class EntityLivingMixin implements IEntityLivingAccesor {

	@Unique
	private int jumpCounts = 0;

	@Unique
	private int maxJump = 0;

	@Unique
	private boolean doubleJump = false;

	@Unique
	private double jumpForce = 0.42;

	@Unique
	private double jumpBoots = 0;

	@Redirect(method = "jump()V", at = @At(value = "FIELD", target = "Lnet/minecraft/core/entity/EntityLiving;yd:D", opcode = Opcodes.PUTFIELD), remap = false)
	public void atJump(EntityLiving instance, double value) {
		instance.yd = jumpForce + jumpBoots;
	}

	@Override
	public void setJumpBoost(double value) {
		jumpBoots = value;
	}

	@Override
	public double getJumpBoost() {
		return jumpBoots;
	}

	@Override
	public void addJumpBoost(double value) {
		jumpBoots += value;
	}

	@Override
	public void setJumpForce(double value) {
		jumpForce = value;
	}

	@Override
	public double getJumpForce() {
		return jumpForce;
	}
}


