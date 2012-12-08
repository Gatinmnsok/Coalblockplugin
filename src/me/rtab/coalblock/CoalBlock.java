package me.rtab.coalblock;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.material.MaterialData;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

public class CoalBlock extends GenericCubeCustomBlock{
		
	public CoalBlock(Plugin plugin) {
        super(plugin, "CoalBlock", "http://www.ishetalfryday.nl/texture.png", 16);
        this.setStepSound(MaterialData.coalOre.getStepSound());
        this.setHardness(MaterialData.coalOre.getHardness());        
    }
 
	public void onNeighborBlockChange(World world, int x, int y, int z, int changedId) { 
	}
 
    public void onBlockPlace(World world, int x, int y, int z) { }
 
    public void onBlockPlace(World world, int x, int y, int z, LivingEntity living) { }
 
    public void onBlockDestroyed(World world, int x, int y, int z) {
    	
    }
 
    public boolean onBlockInteract(World world, int x, int y, int z, SpoutPlayer player) {       	
    	if(player.getItemInHand().getTypeId() == MaterialData.flintAndSteel.getRawId()) {
    		//player.sendMessage("fire!");
    		if(y+1 <= world.getMaxHeight()) {
    			//player.sendMessage("y ok");
    			if(world.getBlockAt(x, y+1, z).getTypeId() == MaterialData.air.getRawId()) {
    				//player.sendMessage("all ok");
    				Block toBeFire = world.getBlockAt(x, y+1, z);
    				toBeFire.setTypeId(51);//Fire == 51    			
    				//player.sendMessage("should be on fire by now");
    			}
    		}
    	}
    	if(player.getFireTicks() > 0) {
    		player.sendMessage("you're on fire");
    	}
    	
    	return true;
    }
 
    public void onEntityMoveAt(World world, int x, int y, int z, Entity entity) { }
 
    public void onBlockClicked(World world, int x, int y, int z, SpoutPlayer player) { 
    }
 
    public boolean isProvidingPowerTo(World world, int x, int y, int z, BlockFace face) {
        return false;
    }
 
    public boolean isIndirectlyProvidingPowerTo(World world, int x, int y, int z, BlockFace face) {
        return false;
    }
}
