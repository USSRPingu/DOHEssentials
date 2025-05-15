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

import net.mcreator.dawnofhumanity.world.inventory.SquadRegimentChooseMenu;
import net.mcreator.dawnofhumanity.network.SquadRegimentChooseButtonMessage;
import net.mcreator.dawnofhumanity.DohessMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

public class SquadRegimentChooseScreen extends ContainerScreen<SquadRegimentChooseMenu> {
	private final static HashMap<String, Object> guistate = SquadRegimentChooseMenu.guistate;
	private final World world;
	private final int x, y, z;
	private final PlayerEntity entity;
	Button button_scouts;
	Button button_garrison;
	Button button_militarypolice;
	Button button_cadets1;
	Button button_government;
	Button button_other;
	Button button_back;

	public SquadRegimentChooseScreen(SquadRegimentChooseMenu container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("dohess:textures/screens/squad_regiment_choose.png");

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
		button_scouts = new Button(this.guiLeft + 114, this.guiTop + 8, 56, 20, new TranslationTextComponent("gui.dohess.squad_regiment_choose.button_scouts"), e -> {
		});
		guistate.put("button:button_scouts", button_scouts);
		this.addButton(button_scouts);
		button_garrison = new Button(this.guiLeft + 103, this.guiTop + 31, 67, 20, new TranslationTextComponent("gui.dohess.squad_regiment_choose.button_garrison"), e -> {
		});
		guistate.put("button:button_garrison", button_garrison);
		this.addButton(button_garrison);
		button_militarypolice = new Button(this.guiLeft + 72, this.guiTop + 55, 98, 20, new TranslationTextComponent("gui.dohess.squad_regiment_choose.button_militarypolice"), e -> {
		});
		guistate.put("button:button_militarypolice", button_militarypolice);
		this.addButton(button_militarypolice);
		button_cadets1 = new Button(this.guiLeft + 114, this.guiTop + 78, 56, 20, new TranslationTextComponent("gui.dohess.squad_regiment_choose.button_cadets1"), e -> {
		});
		guistate.put("button:button_cadets1", button_cadets1);
		this.addButton(button_cadets1);
		button_government = new Button(this.guiLeft + 93, this.guiTop + 101, 77, 20, new TranslationTextComponent("gui.dohess.squad_regiment_choose.button_government"), e -> {
		});
		guistate.put("button:button_government", button_government);
		this.addButton(button_government);
		button_other = new Button(this.guiLeft + 119, this.guiTop + 124, 51, 20, new TranslationTextComponent("gui.dohess.squad_regiment_choose.button_other"), e -> {
		});
		guistate.put("button:button_other", button_other);
		this.addButton(button_other);
		button_back = new Button(this.guiLeft + 3, this.guiTop + 143, 46, 20, new TranslationTextComponent("gui.dohess.squad_regiment_choose.button_back"), e -> {
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new SquadRegimentChooseButtonMessage(6, x, y, z));
				SquadRegimentChooseButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addButton(button_back);
	}
}
