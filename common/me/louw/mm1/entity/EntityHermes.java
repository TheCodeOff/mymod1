package me.louw.mm1.entity;

import me.louw.mm1.block.Blocks;
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
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityHermes extends EntityAnimal {
	
	public EntityHermes(World par1World) {
		super(par1World);
		this.setSize(1.2F, 4F);
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
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.08D);
		// 0D and up, default 32D, max 2048D
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(32D);
	}

	protected String getLivingSound() {
		return "mob.cow.say";
	}

	protected String getHurtSound() {
		return "mob.cow.hurt";
	}

	protected String getDeathSound() {
		return "mob.cow.hurt";
	}

	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.playSound("mob.cow.step", 0.15F, 1.0F);
	}

	protected float getSoundVolume() {
		return 0.4F;
	}

	protected int getDropItemId() {
		return Blocks.grens.blockID;
	}

	public EntityHermes spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
		return new EntityHermes(this.worldObj);
	}

	public EntityAgeable createChild(EntityAgeable par1EntityAgeable) {
		return this.spawnBabyAnimal(par1EntityAgeable);
	}

	protected void dropFewItems(boolean par1, int par2) {
		int j = this.rand.nextInt(2) + this.rand.nextInt(1 + par2);
		int k;
		// Drop Grens maybe
		for (k = 0; k < j; ++k) {
			this.dropItem(Blocks.grens.blockID, 1);
		}
		j = this.rand.nextInt(2) + 1 + this.rand.nextInt(1 + par2);

		// Drop beef maybe
		for (k = 0; k < j; ++k) {
			if (this.isBurning()) {
				this.dropItem(Item.beefCooked.itemID, 1);
			} else {
				this.dropItem(Item.beefRaw.itemID, 1);
			}
		}
	}

	public boolean interact(EntityPlayer par1EntityPlayer) {
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
		// Has something in hand
		if (itemstack != null) {
			// Shears
			if(Item.itemsList[itemstack.itemID].getStatName() == "Shears"){
				this.dropItem(Blocks.grens.blockID, this.rand.nextInt(6));
				this.setHealth(0F);
			}
			return true;
		} else {
			return super.interact(par1EntityPlayer);
		}
	}

}
