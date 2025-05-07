package net.mcreator.dawnofhumanity.client.model;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports
public class Modelbarrelgas<T extends Entity> extends EntityModel<T> {
	public final ModelRenderer bb_main;
	public final ModelRenderer cube_r1;
	public final ModelRenderer cube_r2;
	public final ModelRenderer cube_r3;
	public final ModelRenderer cube_r4;

	public Modelbarrelgas() {
		textureWidth = 16;
		textureHeight = 16;
		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 8).addBox(-3.0F, -4.0F, 2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-3.5F, -3.0F, 8.5F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 1.5708F, 0.0F);
		cube_r1.setTextureOffset(0, 6).addBox(1.5F, -1.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-6.0F, 0.0F, 6.0F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 1.5708F, 0.0F);
		cube_r2.setTextureOffset(0, 0).addBox(-1.0F, -3.0F, 4.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-3.5F, -3.0F, 3.5F);
		bb_main.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 1.5708F, 0.0F);
		cube_r3.setTextureOffset(0, 6).addBox(1.5F, -1.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-6.0F, 0.0F, 1.0F);
		bb_main.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 1.5708F, 0.0F);
		cube_r4.setTextureOffset(0, 0).addBox(-1.0F, -3.0F, 4.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T e, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

}
