package com.jolee.mymod.common.entity;

import com.jolee.mymod.MyMod;
import com.jolee.mymod.init.EntityInit;
import com.jolee.mymod.init.ItemInit;
import com.jolee.mymod.init.SoundInit;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class ExampleEntity extends Animal {
	
	private static final ResourceLocation LOOT_TABLE = new ResourceLocation(MyMod.MOD_ID, "entities/example_entity");

	public ExampleEntity(EntityType<? extends Animal> entityType, Level level) {
		super(entityType, level);
		
	}
	
	@Override
	protected ResourceLocation getDefaultLootTable() {
		//get the lootTable from example_entity.json lootTable
		return LOOT_TABLE;
	}
	
	@Override
	protected void registerGoals() {
		//method is used for AI behavior of entity
		//can add more from the vanilla class of a mob in Minecraft
		
		//same AI as pig below
		//except tempt goal is a custom item example_item
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1,  new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(3,  new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(ItemInit.EXAMPLE_ITEM.get()), false));
		//this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(Items.CARROT_ON_A_STICK), false));
		//this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, FOOD_ITEMS, false));
		this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.2D));
		this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0f));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		
		//this.goalSelector.addGoal(0, new FloatGoal(this)); //mob can float on water
		//this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));//look around
		//this.goalSelector.addGoal(11, new FollowParentGoal(this, 250));
		//this.goalSelector.addGoal(14, new WaterAvoidingRandomStrollGoal(this, 1.0D));
	}
	
	//attributes for the entity
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.25D);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob parent) {
		return EntityInit.EXAMPLE_ENTITY.get().create(level);
	}
	
	//TODO: add splash sound later
	/*
	@Override
	protected SoundEvent getSwimSplashSound() {
		// TODO Auto-generated method stub
		return super.getSwimSplashSound();
	}
	*/
	
	@Override
	protected SoundEvent getAmbientSound() {
		// TODO Auto-generated method stub
		return SoundInit.EXAMPLE_ENTITY_AMBIENT.get();
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		// TODO Auto-generated method stub
		return SoundInit.EXAMPLE_ENTITY_DEATH.get();
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		// TODO Auto-generated method stub
		return SoundInit.EXAMPLE_ENTITY_HURT.get();
	}

}
