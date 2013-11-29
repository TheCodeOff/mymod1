package me.louw.mm1.render;

import me.louw.mm1.entity.EntityPredator;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPredator extends RenderLiving {
	private static final ResourceLocation textures = new ResourceLocation("mm1",
			"textures/entity/predator/predator.png");

	public RenderPredator(ModelBase modelBase, float shadowSize) {
		super(modelBase, shadowSize);
	}

	protected ResourceLocation getPredatorTextures(EntityPredator par1EntityHermes) {
		return textures;
	}

	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return this.getPredatorTextures((EntityPredator) par1Entity);
	}

}
