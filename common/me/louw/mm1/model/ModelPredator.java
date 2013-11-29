package me.louw.mm1.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPredator extends ModelBase {

	private ModelRenderer bipedHead, bipedBody, bipedLeftArm, bipedRightArm, bipedLeftLeg, bipedRightLeg;

	public ModelPredator() {
		textureWidth = 78;
		textureHeight = 66;

		bipedHead = new ModelRenderer(this, 0, 34); // ModelBase, Texture Offset
		bipedHead.addBox(-4F, -8F, -11F, 8, 8, 24); // Offset and Dimensions
		bipedHead.setRotationPoint(0F, -26F, 0F); // Position
		bipedHead.mirror = true;
		setRotation(bipedHead, 45F, 0F, 0F); // Rotation
		bipedBody = new ModelRenderer(this, 0, 0);
		bipedBody.addBox(-4F, 0F, -2F, 20, 23, 11);
		bipedBody.setRotationPoint(-6F, -24F, 0F);
		bipedBody.mirror = true;
		setRotation(bipedBody, 0F, 0F, 0F);
		bipedLeftArm = new ModelRenderer(this, 62, 0);
		bipedLeftArm.addBox(-1F, -2F, -1F, 2, 16, 2);
		bipedLeftArm.setRotationPoint(11F, -21F, 0F);
		bipedLeftArm.mirror = true;
		setRotation(bipedLeftArm, 0F, 0F, 0F);
		bipedRightArm = new ModelRenderer(this, 62, 0);
		bipedRightArm.addBox(-1F, -2F, -1F, 2, 16, 2);
		bipedRightArm.setRotationPoint(-11F, -21F, 0F);
		bipedRightArm.mirror = true;
		setRotation(bipedRightArm, 0F, 0F, 0F);
		bipedLeftLeg = new ModelRenderer(this, 70, 0);
		bipedLeftLeg.addBox(0F, 0F, 0F, 2, 30, 2);
		bipedLeftLeg.setRotationPoint(2F, -2F, 0F);
		bipedLeftLeg.mirror = true;
		setRotation(bipedLeftLeg, 0F, 0F, 0F);
		bipedRightLeg = new ModelRenderer(this, 70, 0);
		bipedRightLeg.addBox(-1F, 0F, -1F, 2, 30, 2);
		bipedRightLeg.setRotationPoint(-2F, -2F, 0F);
		bipedRightLeg.mirror = true;
		setRotation(bipedRightLeg, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		bipedHead.render(f5);
		bipedBody.render(f5);
		bipedLeftArm.render(f5);
		bipedRightArm.render(f5);
		bipedLeftLeg.render(f5);
		bipedRightLeg.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity e) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, e);
	}

}
