package me.louw.mm1.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityPredator extends EntityAnimal {
	public EntityPredator(World par1World) {
		super(par1World);
		this.setSize(1F, 1F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Item.wheat.itemID, false));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
	}

	public boolean isAIEnabled() {
		return true;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		// 0D and up, default 20D
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(20.0D);
		// 0D and up, default 0.699D, max 1D
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.3D);
		// 0D and up, default 32D, max 2048D
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(32D);
	}

	protected String getLivingSound() {
		return "mob.enderman.say";
	}

	protected String getHurtSound() {
		return "mob.enderman.hurt";
	}

	protected String getDeathSound() {
		return "mob.enderman.hurt";
	}

	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.playSound("mob.cow.step", 0.15F, 1.0F);
	}

	protected float getSoundVolume() {
		return 0.4F;
	}

	protected int getDropItemId() {
		return Item.leather.itemID;
	}

	public EntityPredator spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
		return new EntityPredator(this.worldObj);
	}

	public EntityAgeable createChild(EntityAgeable par1EntityAgeable) {
		return this.spawnBabyAnimal(par1EntityAgeable);
	}
}
