package com.example.examplemod;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import net.minecraft.server.MinecraftServer;

import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

import net.minecraft.block.*;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION, acceptableRemoteVersions = "*")
public class ExampleMod {
    public static final String MODID = "ServerPlugins";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
    }
	
	@SubscribeEvent
	public void onLivingDrops(LivingDropsEvent event) {
		Entity mob = event.entityLiving;
		Entity killer = event.source.getEntity();
		
		if(!(mob instanceof EntityBat || mob instanceof EntityBlaze || mob instanceof EntityCaveSpider || 
			mob instanceof EntityGhast || mob instanceof EntityMagmaCube || mob instanceof EntityPigZombie || 
			mob instanceof EntitySilverfish || mob instanceof EntitySkeleton || mob instanceof EntitySlime || 
			mob instanceof EntitySpider || mob instanceof EntitySquid || mob instanceof EntityZombie || mob instanceof EntitySheep))
			event.drops.add(new EntityItem(mob.worldObj, mob.posX, mob.posY, mob.posZ, new ItemStack(Items.bone, 3)));
		
		if(mob instanceof EntitySheep) {
			event.drops.add(new EntityItem(mob.worldObj, mob.posX, mob.posY, mob.posZ, new ItemStack(Items.bone, ThreadLocalRandom.current().nextInt(0, 4))));
			event.drops.add(new EntityItem(mob.worldObj, mob.posX, mob.posY, mob.posZ, new ItemStack(Items.leather, ThreadLocalRandom.current().nextInt(0, 2))));
			ItemStack mutton = new ItemStack(Items.beef, ThreadLocalRandom.current().nextInt(0, 3));
			mutton = mutton.setStackDisplayName("Cordero");
			event.drops.add(new EntityItem(mob.worldObj, mob.posX, mob.posY, mob.posZ, mutton));
		}
	}
	
	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent event) {
		event.player.addChatMessage( new ChatComponentText("Bienvenido!! Hay " + MinecraftServer.getServer().getCurrentPlayerCount() + " jugadores en linea!"));
	}
}
