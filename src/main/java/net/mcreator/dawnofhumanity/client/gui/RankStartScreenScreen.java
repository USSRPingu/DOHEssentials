package net.mcreator.dawnofhumanity.client.gui;

import net.minecraft.world.World;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.dawnofhumanity.world.inventory.RankStartScreenMenu;
import net.mcreator.dawnofhumanity.network.RankStartScreenButtonMessage;
import net.mcreator.dawnofhumanity.DohessMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

public class RankStartScreenScreen extends ContainerScreen<RankStartScreenMenu> {
	private final static HashMap<String, Object> guistate = RankStartScreenMenu.guistate;
	private final World world;
	private final int x, y, z;
	private final PlayerEntity entity;
	Button button_ranks;
	Button button_squads;

	public RankStartScreenScreen(RankStartScreenMenu container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("dohess:textures/screens/rank_start_screen.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		this.blit(ms, this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		button_ranks = new Button(this.guiLeft + 118, this.guiTop + 8, 51, 20, new TranslationTextComponent("gui.dohess.rank_start_screen.button_ranks"), e -> {
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new RankStartScreenButtonMessage(0, x, y, z));
				RankStartScreenButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_ranks", button_ranks);
		this.addButton(button_ranks);
		button_squads = new Button(this.guiLeft + 113, this.guiTop + 38, 56, 20, new TranslationTextComponent("gui.dohess.rank_start_screen.button_squads"), e -> {
		});
		guistate.put("button:button_squads", button_squads);
		this.addButton(button_squads);
	}
}
