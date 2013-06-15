package mods.taverns;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentVillage;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentVillageTavern extends ComponentVillage{

	protected ComponentVillageTavern(ComponentVillageStartPiece startPiece, int type, Random random, StructureBoundingBox _boundingBox, int direction){
		super(startPiece, type);
        coordBaseMode = direction;
        boundingBox = _boundingBox;
	}

	public static Object buildComponent(ComponentVillageStartPiece startPiece, List pieces, Random random, int x, int y, int z, int direction, int type) {
        StructureBoundingBox _boundingBox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 10, 10, 6, direction);
        if(canVillageGoDeeper(_boundingBox)){ 
        	if(StructureComponent.findIntersecting(pieces, _boundingBox) == null){
        		return new ComponentVillageTavern(startPiece, type, random, _boundingBox, direction);
        	}
        }
		return null;
	}
	
	@Override
	public boolean addComponentParts(World world, Random random, StructureBoundingBox boundingBox) {
		fillWithAir(world, boundingBox, 0, 0, 0, 10, 10, 6);
		fillWithBlocks(world, boundingBox, 0, 0, 0, 4, 1, 5, Block.stone.blockID, Block.stone.blockID, false);
		fillWithBlocks(world, boundingBox, 4,1,5, 10,3,6, Block.cobblestone.blockID, Block.cobblestoneMossy.blockID, false);
		return true;
	}


}
