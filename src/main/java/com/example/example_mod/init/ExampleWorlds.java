package com.example.example_mod.init;


import com.example.example_mod.ExampleMod;
import net.ludocrypt.limlib.effects.render.sky.SkyEffects;
import net.ludocrypt.limlib.effects.render.sky.StaticSkyEffects;
import net.ludocrypt.limlib.registry.registration.PreRegistration;
import net.ludocrypt.limlib.render.skybox.Skybox;
import net.ludocrypt.limlib.render.skybox.TexturedSkybox;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

import java.util.Optional;

public class ExampleWorlds implements PreRegistration {
	public static final String SNOW_SKY = "example_sky";
	public static final RegistryKey<World> SNOW_SKY_KEY = RegistryKey.of(Registry.WORLD_KEY, ExampleMod.id(SNOW_SKY));
	public static final Skybox SNOW_SKY_SKYBOX = get(SNOW_SKY, new TexturedSkybox(ExampleMod.id("textures/sky/snow")));
	public static final SkyEffects SNOW_SKY_SKY_EFFECTS = get(SNOW_SKY, new StaticSkyEffects(Optional.empty(), false, "NONE", true, false, false, 1.0F));
	public static final String WOODS_SKY = "woods_sky";
	public static final RegistryKey<World> WOODS_SKY_KEY = RegistryKey.of(Registry.WORLD_KEY, ExampleMod.id(WOODS_SKY));
	public static final Skybox WOODS_SKY_SKYBOX = get(WOODS_SKY, new TexturedSkybox(ExampleMod.id("textures/sky/woods")));
	public static final SkyEffects WOODS_SKY_SKY_EFFECTS = get(WOODS_SKY, new StaticSkyEffects(Optional.empty(), false, "NONE", true, false, false, 0.0F));


	@Override
	public void register() {

	}

	public static <S extends Skybox> S get(String id, S skybox) {
		return Registry.register(Skybox.SKYBOX, ExampleMod.id(id), skybox);
	}

	public static <S extends SkyEffects> S get(String id, S skyEffects) {
		return Registry.register(SkyEffects.SKY_EFFECTS, ExampleMod.id(id), skyEffects);
	}


}
