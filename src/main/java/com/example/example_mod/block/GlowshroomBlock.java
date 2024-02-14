package com.example.example_mod.block;

import com.example.example_mod.ExampleMod;
import com.example.example_mod.properties.ModProperties;
import com.example.example_mod.sounds.ModSounds;
import com.example.example_mod.util.Easing;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.particle.CampfireSmokeParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class GlowshroomBlock extends PressurePlateBlock {

	public GlowshroomBlock(ActivationRule rule, Settings settings) {
		super(rule, settings);
	}

	@Override
	protected void playPressSound(WorldAccess world, BlockPos pos) {
		float min = 0.6F;
		float max = 1.6F;
		Random r = new Random();
		float random = (float) (min + r.nextDouble() * (max - min));
		world.playSound((PlayerEntity)null, pos, ModSounds.GLOWSHROOM_STEP, SoundCategory.BLOCKS, 0.5F, random);
	}

	@Override
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		double min = 0.0d;
		double max = 0.035d;
		Random r = new Random();
		if (!world.isClient) {
			int i = this.getRedstoneOutput(state);
			if (i == 0) {
				this.updatePlateState(entity, world, pos, state, i);
			}

		}
		if (world.isClient){
			for(int c = 0; c < 360; c++) {
				int i = this.getRedstoneOutput(state);
				if (i == 0) {
					if (c % 72 == 0) {
						float random1 = (float) (min + r.nextDouble() * (max - min));
						float random2 = (float) (0.01d + r.nextDouble() * (0.035d - 0.02d));
						world.addParticle(ExampleMod.GLOWSHROOM_SPORE,
								pos.getX() + 0.5d, pos.getY() + 0.3d, pos.getZ() + 0.5d,
								Math.cos(c) * random1, random2, Math.sin(c) * random1);
					}
				}
			}
		}
	}


	@Override
	protected void playDepressSound(WorldAccess world, BlockPos pos) {
		world.playSound((PlayerEntity)null, pos, ModSounds.GLOWSHROOM_STEP, SoundCategory.BLOCKS, 0.0F, 1.0F);
	}

	@Override
	protected int getTickRate() {
		return 5;
	}
}
