package me.louw.mm1.render;

import me.louw.mm1.entity.EntityHermes;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHermes extends RenderLiving
{
    private static final ResourceLocation hermesTextures = new ResourceLocation("mm1", "textures/entity/hermes/hermes.png");

    public RenderHermes(ModelBase modelBase, float shadowSize)
    {    	
        super(modelBase, shadowSize);
    }

    protected ResourceLocation getHermesTextures(EntityHermes par1EntityHermes)
    {
        return hermesTextures;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getHermesTextures((EntityHermes)par1Entity);
    }
}
