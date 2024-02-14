package com.example.example_mod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class SinglePlankBlock extends Block {
	public static final DirectionProperty FACING;
	protected static final VoxelShape EAST_WEST_SHAPE;
	protected static final VoxelShape SOUTH_NORTH_SHAPE;

	public SinglePlankBlock(Settings settings) {
		super(settings);
		this.setDefaultState((this.stateManager.getDefaultState()).with(FACING, Direction.NORTH));
	}
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return (BlockState)this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
	}
	public BlockState rotate(BlockState state, BlockRotation rotation) {
		return (BlockState)state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
	}
	public BlockState mirror(BlockState state, BlockMirror mirror) {
		return state.rotate(mirror.getRotation((Direction)state.get(FACING)));
	}

	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		if (state.get(FACING).equals(Direction.NORTH) || state.get(FACING).equals(Direction.SOUTH)){
			return SOUTH_NORTH_SHAPE;
		} else {
			return EAST_WEST_SHAPE;
		}
	}

	static {
		FACING = HorizontalFacingBlock.FACING;
		EAST_WEST_SHAPE = VoxelShapes.union(VoxelShapes.empty(), VoxelShapes.cuboid(0, 0, 0.4375, 1, 0.125, 0.5625));
		SOUTH_NORTH_SHAPE = VoxelShapes.union(VoxelShapes.empty(), VoxelShapes.cuboid(0.4375, 0, 0, 0.5625, 0.125, 1));
	}
}
