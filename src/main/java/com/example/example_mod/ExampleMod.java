package com.example.example_mod;

import com.example.example_mod.block.GlowingBlock;
import com.example.example_mod.block.GlowshroomBlock;
import com.example.example_mod.block.SinglePlankBlock;
import com.example.example_mod.block.SkyboxGlassBlock;
import com.example.example_mod.sounds.ModSounds;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ExampleMod implements ModInitializer {
	public static String MOD_ID = "example_mod";

	public static final Block GLOWSHROOM = new GlowshroomBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
			QuiltBlockSettings.of(Material.PLANT, MapColor.ORANGE).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)
					.emissiveLighting((blockState, blockView, blockPos) -> {return !blockState.get(Properties.POWERED);}).luminance(value -> {
						if (!value.get(Properties.POWERED)){
							return 8;
						} else {
							return 0;
						}
					}));
	public static final Block DIRTY_PATH = new DirtPathBlock(QuiltBlockSettings.copyOf(Blocks.DIRT_PATH));
	public static final Block GRASSY_DIRT = new Block(QuiltBlockSettings.copyOf(Blocks.DIRT));
	public static final Block COBBLED_DIRT = new Block(QuiltBlockSettings.copyOf(Blocks.DIRT));
	public static final Block SLIGHTLY_COBBLED_DIRT = new Block(QuiltBlockSettings.copyOf(Blocks.DIRT));
	public static final Block SINGLE_PLANK = new SinglePlankBlock(QuiltBlockSettings.copyOf(Blocks.OAK_PLANKS));
	public static final Block EXAMPLE_SKYBOX_BLOCK = new SkyboxGlassBlock(QuiltBlockSettings.copyOf(Blocks.BEDROCK).luminance(8));
	public static final Block WOODS_SKYBOX_BLOCK = new SkyboxGlassBlock(QuiltBlockSettings.copyOf(Blocks.BEDROCK).luminance(8));
	public static final Block GLOWING_BLOCK = new GlowingBlock(QuiltBlockSettings.copyOf(Blocks.GLOWSTONE).sounds(BlockSoundGroup.GLASS).emissiveLighting((blockState, blockView, blockPos) -> {
		return true;
	}).luminance(8));
	public static final DefaultParticleType GLOWSHROOM_SPORE = FabricParticleTypes.simple();


	@Override
	public void onInitialize(ModContainer mod) {
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "glowshroom"), GLOWSHROOM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "glowshroom"), new BlockItem(GLOWSHROOM ,new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "dirty_path"), DIRTY_PATH);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "dirty_path"), new BlockItem(DIRTY_PATH ,new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "single_plank"), SINGLE_PLANK);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "single_plank"), new BlockItem(SINGLE_PLANK ,new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "grassy_dirt"), GRASSY_DIRT);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "grassy_dirt"), new BlockItem(GRASSY_DIRT ,new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "cobbled_dirt"), COBBLED_DIRT);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cobbled_dirt"), new BlockItem(COBBLED_DIRT ,new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "slightly_cobbled_dirt"), SLIGHTLY_COBBLED_DIRT);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "slightly_cobbled_dirt"), new BlockItem(SLIGHTLY_COBBLED_DIRT ,new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "glowing_block"), GLOWING_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "glowing_block"), new BlockItem(GLOWING_BLOCK ,new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.BLOCK, id("example_glass"), EXAMPLE_SKYBOX_BLOCK);
		Registry.register(Registry.ITEM, id("example_glass"), new BlockItem(EXAMPLE_SKYBOX_BLOCK, new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.BLOCK, id("woods_sky_box"), WOODS_SKYBOX_BLOCK);
		Registry.register(Registry.ITEM, id("woods_sky_box"), new BlockItem(WOODS_SKYBOX_BLOCK, new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
		ModSounds.registerSounds();
		Registry.register(Registry.PARTICLE_TYPE, new Identifier(ExampleMod.MOD_ID, "glowshroom_spore"), GLOWSHROOM_SPORE);
	}

	public static Identifier id(String id) {
		return new Identifier("example_mod", id);
	}
}
