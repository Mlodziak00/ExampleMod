package com.example.example_mod.particles;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.MathHelper;

public class GlowshroomSporeParticle extends SpriteBillboardParticle {
	protected GlowshroomSporeParticle(ClientWorld level, double xCoord, double yCoord, double zCoord, SpriteProvider spriteSet, double xd, double yd, double zd) {
		super(level, xCoord, yCoord, zCoord, xd, yd, zd);

		this.gravityStrength = 3.0E-6F;
		this.velocityX = xd;
		this.velocityY = yd + (double)(this.random.nextFloat() / 500.0F);
		this.velocityZ = zd;
		this.scale = 0.5f;
		this.maxAge = 160;
		this.setSpriteForAge(spriteSet);

		this.colorRed = 1f;
		this.colorGreen = 1f;
		this.colorBlue = 1f;
	}
	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected int getBrightness(float tint) {
		return 255;
	}

	@Override
	public ParticleTextureSheet getType() {
		return ParticleTextureSheet.PARTICLE_SHEET_LIT;
	}
	@Environment(EnvType.CLIENT)
	public static class Factory implements ParticleFactory<DefaultParticleType> {
		private final SpriteProvider sprites;

		public Factory(SpriteProvider spriteSet) {
			this.sprites = spriteSet;
		}

		public Particle createParticle(DefaultParticleType particleType, ClientWorld level, double x, double y, double z,
									   double dx, double dy, double dz) {
			return new GlowshroomSporeParticle(level, x, y, z, this.sprites, dx, dy, dz);
		}
	}
}
