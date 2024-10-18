package net.romhenri.alexandriteore.block.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;

public class AlexandriteTorchBlock extends TorchBlock {

    public AlexandriteTorchBlock() {
        super(BlockBehaviour.Properties
                        .of()
                        .noCollission()
                        .instabreak()
                        .lightLevel((state) -> 15)
                        .sound(SoundType.WOOD),
                ParticleTypes.FLAME);
    }
}