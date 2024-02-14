package com.example.example_mod.client;

import com.example.example_mod.ExampleMod;
import com.example.example_mod.client.render.SkyboxRenderer;
import com.example.example_mod.particles.GlowshroomSporeParticle;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.ludocrypt.limlib.render.special.SpecialModelRenderer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;

public class ExampleModClient implements ClientModInitializer {

	@Override
	public void onInitializeClient(ModContainer mod) {
		Registry.register(SpecialModelRenderer.SPECIAL_MODEL_RENDERER, ExampleMod.id("sky_example"), new SkyboxRenderer("example"));
		Registry.register(SpecialModelRenderer.SPECIAL_MODEL_RENDERER, ExampleMod.id("sky_woods"), new SkyboxRenderer("woods"));
		ParticleFactoryRegistry.getInstance().register(ExampleMod.GLOWSHROOM_SPORE, GlowshroomSporeParticle.Factory::new);
		BlockRenderLayerMap.put(RenderLayer.getTranslucent(), ExampleMod.GLOWING_BLOCK);
	}
}
