package me.rtab.coalblock;

import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.inventory.SpoutShapelessRecipe;
import org.getspout.spoutapi.material.MaterialData;

public class CoalBlockPlugin extends JavaPlugin {
		
	@Override
	public void onDisable() {
			
	}

	@Override
	public void onEnable() {
		//recipies
		CoalBlock coalblock = new CoalBlock(this);
		
		SpoutItemStack result = new SpoutItemStack(coalblock);
		SpoutShapedRecipe recipe = new SpoutShapedRecipe(result);	
		recipe.shape("AAA", "AAA", "AAA");
		recipe.setIngredient('A', MaterialData.coal);
		SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
		
		SpoutShapedRecipe recipeChar = new SpoutShapedRecipe(result);	
		recipeChar.shape("AAA", "AAA", "AAA");
		recipeChar.setIngredient('A', MaterialData.charcoal);
		SpoutManager.getMaterialManager().registerSpoutRecipe(recipeChar);
		
		SpoutItemStack resultRedo = new SpoutItemStack(MaterialData.coal, 9);
		SpoutShapelessRecipe recipeRedo = new SpoutShapelessRecipe(resultRedo);
		recipeRedo.addIngredient(coalblock);
		SpoutManager.getMaterialManager().registerSpoutRecipe(recipeRedo);
		//end recipies	
		
	}			
}
