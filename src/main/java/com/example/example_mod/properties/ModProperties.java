package com.example.example_mod.properties;

import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;

public class ModProperties extends Properties {
	public static final BooleanProperty PRESSED;
	public static final BooleanProperty NEWFACING;
	public ModProperties(){
	}

	static {
		PRESSED = BooleanProperty.of("pressed");
		NEWFACING = BooleanProperty.of("newfacing");
	}

}
