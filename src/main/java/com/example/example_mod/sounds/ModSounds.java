package com.example.example_mod.sounds;

import com.example.example_mod.ExampleMod;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {
	public static final SoundEvent GLOWSHROOM_STEP = registerSound("glowshroom_step");

	private static SoundEvent registerSound(String name){
		Identifier id = new Identifier(ExampleMod.MOD_ID, name);
		return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
	}
	public static void registerSounds(){}
}
