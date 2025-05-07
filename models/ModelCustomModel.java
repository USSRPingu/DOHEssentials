// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelCustomModel extends EntityModel<Entity> {
	private final ModelRenderer h;
	private final ModelRenderer b;
	private final ModelRenderer ra;
	private final ModelRenderer la;
	private final ModelRenderer rl;
	private final ModelRenderer ll;

	public ModelCustomModel() {
		textureWidth = 64;
		textureHeight = 64;

		h = new ModelRenderer(this);
		h.setRotationPoint(0.0F, 24.0F, 0.0F);
		h.setTextureOffset(0, 0).addBox(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		b = new ModelRenderer(this);
		b.setRotationPoint(0.0F, 24.0F, 0.0F);
		b.setTextureOffset(16, 16).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		ra = new ModelRenderer(this);
		ra.setRotationPoint(0.0F, 24.0F, 0.0F);
		ra.setTextureOffset(40, 16).addBox(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		la = new ModelRenderer(this);
		la.setRotationPoint(0.0F, 24.0F, 0.0F);
		la.setTextureOffset(32, 48).addBox(4.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		rl = new ModelRenderer(this);
		rl.setRotationPoint(0.0F, 24.0F, 0.0F);
		rl.setTextureOffset(0, 16).addBox(-3.9F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		ll = new ModelRenderer(this);
		ll.setRotationPoint(0.0F, 24.0F, 0.0F);
		ll.setTextureOffset(16, 48).addBox(-0.1F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		h.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		b.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		ra.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		la.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rl.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		ll.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.ll.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.la.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.h.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.h.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.rl.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.ra.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}