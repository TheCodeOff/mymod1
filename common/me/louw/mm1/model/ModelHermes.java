package me.louw.mm1.model;

import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelHermes extends ModelQuadruped {

	private Entity entity;
	private ModelRenderer horn1;
	private ModelRenderer horn2;

	public ModelHermes() {
		super(12, 0.0F);
		
		textureWidth = 114;
		textureHeight = 44;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -4F, -6F, 8, 11, 7);
		head.setRotationPoint(0F, 0F, -9F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 30, 0);
		body.addBox(-6F, -10F, -7F, 20, 22, 22);
		body.setRotationPoint(-4F, 5F, 1F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 1.570796F, 0F, 0F);
		leg1 = new ModelRenderer(this, 0, 18);
		leg1.addBox(-3F, 0F, -2F, 4, 12, 4);
		leg1.setRotationPoint(-4F, 12F, 8F);
		leg1.setTextureSize(64, 32);
		leg1.mirror = true;
		setRotation(leg1, 0F, 0F, 0F);
		leg2 = new ModelRenderer(this, 0, 18);
		leg2.addBox(-1F, 0F, -2F, 4, 12, 4);
		leg2.setRotationPoint(4F, 12F, 8F);
		leg2.setTextureSize(64, 32);
		leg2.mirror = true;
		setRotation(leg2, 0F, 0F, 0F);
		leg3 = new ModelRenderer(this, 0, 18);
		leg3.addBox(-3F, 0F, -3F, 4, 12, 4);
		leg3.setRotationPoint(-3F, 12F, -5F);
		leg3.setTextureSize(64, 32);
		leg3.mirror = true;
		setRotation(leg3, 0F, 0F, 0F);
		leg4 = new ModelRenderer(this, 0, 18);
		leg4.addBox(-1F, 0F, -3F, 4, 12, 4);
		leg4.setRotationPoint(3F, 12F, -5F);
		leg4.setTextureSize(64, 32);
		leg4.mirror = true;
		setRotation(leg4, 0F, 0F, 0F);
		horn1 = new ModelRenderer(this, 17, 20);
		horn1.addBox(-4F, -5F, -4F, 1, 3, 1);
		horn1.setRotationPoint(0F, -1F, -7F);
		horn1.setTextureSize(64, 32);
		horn1.mirror = true;
		setRotation(horn1, 0F, 0F, 0F);
		horn2 = new ModelRenderer(this, 22, 20);
		horn2.addBox(3F, -5F, -4F, 1, 3, 1);
		horn2.setRotationPoint(0F, -1F, -7F);
		horn2.setTextureSize(64, 32);
		horn2.mirror = true;
		setRotation(horn2, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.entity = entity;
		setRotationAngles(f, f1, f2, f3, f4, f5);
		head.render(f5);
		body.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
		leg4.render(f5);
		horn1.render(f5);
		horn2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}
