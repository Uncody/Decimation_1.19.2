package com.decimation.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class JumpyBlock extends Block {
    public JumpyBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (!level.isClientSide()) {
            //Проверка на руку бесполезна, отправляться будет лишь 1 раз если есть проверка на уровень.
            player.sendSystemMessage(Component.literal("Test Text, must be sended in chat only 1 time at click"));
        }
        return super.use(state, level, pos, player, hand, result);
    }

    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, @NotNull Entity entity){
        //в void функциях удобнее так делать.
        if(!(entity instanceof LivingEntity livingEntity)) return;
        //Проверка на сервер, чтобы не было возможных проблем.
        if(level.isClientSide()) return;

        livingEntity.addEffect(new MobEffectInstance(MobEffects.JUMP, 200));

        super.stepOn(level, blockPos, blockState, entity);
    }
}
