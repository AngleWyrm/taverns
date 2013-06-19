package mods.taverns;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureVillagePieceWeight;
import cpw.mods.fml.common.registry.VillagerRegistry;


public class VillageHandlerBarWench implements VillagerRegistry.IVillageCreationHandler, VillagerRegistry.IVillageTradeHandler 
{
	public static final int BAR_WENCH = 42;

	@Override
	public void manipulateTradesForVillager(EntityVillager villager,
			MerchantRecipeList recipeList, Random random) 
	{
		recipeList.add(new MerchantRecipe(
				new ItemStack(Item.potion, 3, 16), // Awkward potion 
				new ItemStack(Item.emerald, 2)));
		recipeList.add(new MerchantRecipe(
				new ItemStack(Item.emerald, 1),
				new ItemStack(Item.potion, 2, 33))); // night vision
		recipeList.add(new MerchantRecipe(
				new ItemStack(Item.emerald, 1),
				new ItemStack(Item.bakedPotato, 32)));
/*
 * ID numbers are subject to change without notice :(		
		if(Taverns.config.minecraftComesAlive){
			recipeList.add(new MerchantRecipe(
					new ItemStack(Item.emerald, 1), 
					new ItemStack(Item.potion, 2, 987)));
		}
*/
 	}

	@Override
	public StructureVillagePieceWeight getVillagePieceWeight(Random random,
			int i) {
        return new StructureVillagePieceWeight(ComponentVillageTavern.class, 3, MathHelper.getRandomIntegerInRange(random, 0, 1));
	}

	@Override
	public Class<?> getComponentClass() {
		return ComponentVillageTavern.class;
	}

	@Override
	public Object buildComponent(StructureVillagePieceWeight villagePiece,
			ComponentVillageStartPiece startPiece, List pieces, Random random,
			int p1, int p2, int p3, int p4, int p5) {
	       return ComponentVillageTavern.buildComponent(startPiece, pieces, random, p1, p2, p3, p4, p5);
	}
}
