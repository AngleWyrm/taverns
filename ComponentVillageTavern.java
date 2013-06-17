package mods.taverns;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentVillage;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentVillageTavern extends ComponentVillage
{
    private int averageGroundLevel = -1;
    private static final int HEIGHT = 10;
	private final int SOUTH = 3;
	private final int WEST  = 0;
	private final int NORTH = 2;
	private final int EAST  = 1;

	protected ComponentVillageTavern(ComponentVillageStartPiece startPiece, int type, Random random, StructureBoundingBox _boundingBox, int direction){
		super(startPiece, type);
        coordBaseMode = direction;
    	boundingBox = _boundingBox;
	}

	public static Object buildComponent(ComponentVillageStartPiece startPiece, List pieces, Random random, int x, int y, int z, int direction, int type) {
        StructureBoundingBox _boundingBox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 14, 10, 8, direction);
        if(canVillageGoDeeper(_boundingBox)){ 
        	if(StructureComponent.findIntersecting(pieces, _boundingBox) == null){
        		return new ComponentVillageTavern(startPiece, type, random, _boundingBox, direction);
        	}
        }
		return null;
	}
	
	@Override
	public boolean addComponentParts(World world, Random random, StructureBoundingBox box) 
	{
		averageGroundLevel = getAverageGroundLevel(world, box);
		boundingBox.offset(0, averageGroundLevel - boundingBox.maxY + HEIGHT - 2, 0);
		
		fillWithBlocks(world, box, 0,0,0, 14,9,7, 0, 0, false);
		
		// floors
		fillWithBlocks(world, box, 0,0,1, 14,0,7, Block.dirt.blockID, Block.dirt.blockID, false);
		fillWithBlocks(world, box, 0,0,0, 14,0,0, Block.gravel.blockID, Block.gravel.blockID, false);
		fillWithBlocks(world, box, 1,0,1, 4,0,6, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
		fillWithBlocks(world, box, 5,0,1, 12,0,6, Block.planks.blockID, Block.planks.blockID, false);
		fillWithBlocks(world, box, 1,4,1, 12,4,6, Block.planks.blockID, Block.planks.blockID, false);	
		fillWithBlocks(world, box, 7,8,1, 12,8,6, Block.planks.blockID, Block.planks.blockID, false);

		// walls
		fillWithBlocks(world, box, 1,1,1, 1,4,1, Block.wood.blockID, Block.wood.blockID, false);
		fillWithBlocks(world, box, 1,1,2, 1,3,5, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
		fillWithBlocks(world, box, 1,1,6, 1,4,6, Block.wood.blockID, Block.wood.blockID, false);
		
		fillWithBlocks(world, box, 2,3,1, 3,3,1, Block.planks.blockID, Block.planks.blockID, false);
		fillWithBlocks(world, box, 2,1,1, 3,1,1, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
		fillWithBlocks(world, box, 2,2,1, 3,2,1, Block.thinGlass.blockID, Block.thinGlass.blockID, false);
		fillWithBlocks(world, box, 4,1,1, 4,3,1, Block.wood.blockID, Block.wood.blockID, false);
		fillWithBlocks(world, box, 5,3,1, 6,3,1, Block.wood.blockID, Block.wood.blockID, false);
		fillWithBlocks(world, box, 7,1,1, 7,7,1, Block.wood.blockID, Block.wood.blockID, false);
        placeBlockAtCurrentPosition(world, Block.wood.blockID, getMetadataWithOffset(Block.wood.blockID, 4), 4, 3, 1, box);
        placeBlockAtCurrentPosition(world, Block.wood.blockID, getMetadataWithOffset(Block.wood.blockID, 4), 7, 3, 1, box);
        fillWithBlocks(world, box, 8,1,1, 11,1,1, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
		fillWithBlocks(world, box, 8,2,1, 11,7,1, Block.planks.blockID, Block.planks.blockID, false);
		fillWithBlocks(world, box, 8,2,1, 11,2,1, Block.thinGlass.blockID, Block.thinGlass.blockID, false);
		fillWithBlocks(world, box, 12,1,1, 12,7,1, Block.wood.blockID, Block.wood.blockID, false);

		fillWithBlocks(world, box, 12,1,2, 12,1,5, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
		fillWithBlocks(world, box, 12,2,2, 12,7,5, Block.planks.blockID, Block.planks.blockID, false);
		fillWithBlocks(world, box, 12,2,3, 12,2,4, Block.thinGlass.blockID, Block.thinGlass.blockID, false);
		fillWithBlocks(world, box, 12,6,3, 12,6,4, Block.thinGlass.blockID, Block.thinGlass.blockID, false);
		fillWithBlocks(world, box, 12,1,6, 12,7,6, Block.wood.blockID, Block.wood.blockID, false);
		
		fillWithBlocks(world, box, 7,1,6, 11,1,6, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
		fillWithBlocks(world, box, 7,2,6, 11,7,6, Block.planks.blockID, Block.planks.blockID, false);
		placeBlockAtCurrentPosition(world, Block.thinGlass.blockID, 0, 10,6,6, box);
		fillWithBlocks(world, box, 6,1,6, 6,8,6, Block.wood.blockID, Block.wood.blockID, false);
		placeBlockAtCurrentPosition(world, Block.wood.blockID, 0, 5,3,6, box);
		fillWithBlocks(world, box, 4,1,6, 4,3,6, Block.wood.blockID, Block.wood.blockID, false);
		fillWithBlocks(world, box, 2,1,6, 3,3,6, Block.cobblestone.blockID, Block.cobblestone.blockID, false);

		fillWithBlocks(world, box, 7,5,2, 7,7,5, Block.planks.blockID, Block.planks.blockID, false);
		fillWithBlocks(world, box, 6,5,5, 6,8,5, Block.planks.blockID, Block.planks.blockID, false);
		
		// roofing
		for(int xx = 0; xx <= 13; xx++){
	        placeBlockAtCurrentPosition(world, Block.stairsWoodOak.blockID, getMetadataWithOffset(Block.stairsWoodOak.blockID, SOUTH), xx, 4, 0, box);
	        placeBlockAtCurrentPosition(world, Block.stairsWoodOak.blockID, getMetadataWithOffset(Block.stairsWoodOak.blockID, NORTH), xx, 4, 7, box);
		}
		for(int zz = 0; zz <= 7; zz++){
	        placeBlockAtCurrentPosition(world, Block.stairsWoodOak.blockID, getMetadataWithOffset(Block.stairsWoodOak.blockID, WEST), 0, 4, zz, box);
            placeBlockAtCurrentPosition(world, Block.stairsWoodOak.blockID, getMetadataWithOffset(Block.stairsWoodOak.blockID, EAST), 13, 4, zz, box);
		}
		
		for(int xx = 6; xx <= 13; xx++){
	        placeBlockAtCurrentPosition(world, Block.stairsWoodOak.blockID, getMetadataWithOffset(Block.stairsWoodOak.blockID, SOUTH), xx, 7, 0, box);
	        placeBlockAtCurrentPosition(world, Block.stairsWoodOak.blockID, getMetadataWithOffset(Block.stairsWoodOak.blockID, NORTH), xx, 7, 7, box);
	        placeBlockAtCurrentPosition(world, Block.stairsWoodOak.blockID, getMetadataWithOffset(Block.stairsWoodOak.blockID, SOUTH), xx, 8, 1, box);
	        placeBlockAtCurrentPosition(world, Block.stairsWoodOak.blockID, getMetadataWithOffset(Block.stairsWoodOak.blockID, NORTH), xx, 8, 6, box);
		}
		for(int xx = 7; xx <= 13; xx++){
	        placeBlockAtCurrentPosition(world, Block.stairsWoodOak.blockID, getMetadataWithOffset(Block.stairsWoodOak.blockID, SOUTH), xx, 9, 2, box);
	        placeBlockAtCurrentPosition(world, Block.stairsWoodOak.blockID, getMetadataWithOffset(Block.stairsWoodOak.blockID, NORTH), xx, 9, 5, box);
		}
		for(int zz = 2; zz <= 5; zz++){
			placeBlockAtCurrentPosition(world, Block.stairsWoodOak.blockID, getMetadataWithOffset(Block.stairsWoodOak.blockID, WEST), 6,8,zz, box);
		}
		for(int zz = 3; zz <= 4; zz++){
	        placeBlockAtCurrentPosition(world, Block.stairsWoodOak.blockID, getMetadataWithOffset(Block.stairsWoodOak.blockID, EAST), 13,9,zz, box);
	        placeBlockAtCurrentPosition(world, Block.stairsWoodOak.blockID, getMetadataWithOffset(Block.stairsWoodOak.blockID, WEST), 12,9,zz, box);	        
	        placeBlockAtCurrentPosition(world, Block.stairsWoodOak.blockID, getMetadataWithOffset(Block.stairsWoodOak.blockID, WEST), 7,9,zz, box);
	        placeBlockAtCurrentPosition(world, Block.stairsWoodOak.blockID, getMetadataWithOffset(Block.stairsWoodOak.blockID, EAST), 8,9,zz, box);
		}
		for(int zz = 5; zz <= 7; zz++){
			placeBlockAtCurrentPosition(world, Block.stairsWoodOak.blockID, getMetadataWithOffset(Block.stairsWoodOak.blockID, WEST), 5,7,zz, box);
		}
		placeBlockAtCurrentPosition(world, 0, 0, 6,8,4, box);

		
		// Interior
		fillWithBlocks(world, box, 6,1,5, 6,3,5, Block.wood.blockID, Block.wood.blockID, true);
		fillWithBlocks(world, box, 9,1,2, 9,3,2, Block.wood.blockID, Block.wood.blockID, true);
		placeBlockAtCurrentPosition(world, Block.stairsWoodOak.blockID, getMetadataWithOffset(Block.stairsWoodOak.blockID, WEST), 7,1,5, box);
		placeBlockAtCurrentPosition(world, Block.planks.blockID, 0, 8,1,5, box);
		return true;
	}

	// TODO: identify desert biome to return sand, possibly others
	private int getGroundID(){
		return Block.grass.blockID;
	}
}
