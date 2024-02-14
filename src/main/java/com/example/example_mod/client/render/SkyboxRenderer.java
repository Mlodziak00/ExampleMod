package com.example.example_mod.client.render;

import com.example.example_mod.ExampleMod;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ludocrypt.limlib.render.special.SpecialModelRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.ShaderProgram;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.*;
import net.minecraft.util.registry.Registry;

import java.util.Objects;

public class SkyboxRenderer extends SpecialModelRenderer {

	private final String id;

	public SkyboxRenderer(String id) {
		this.id = id;
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void setup(MatrixStack matrices, ShaderProgram shader) {
		for (int i = 0; i < 6; i++) {
			RenderSystem.setShaderTexture(i, ExampleMod.id("textures/sky/" + id + "_" + i + ".png"));
		}


		MinecraftClient client = MinecraftClient.getInstance();
		Camera camera = client.gameRenderer.getCamera();

		Matrix4f matrix = new MatrixStack().peek().getPosition();

		matrix.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(camera.getPitch()));
		matrix.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(camera.getYaw() + 180.0F));

		if (shader.getUniform("RotMat") != null) {
			shader.getUniform("RotMat").setMat4x4(matrix);
		}
	}
}

