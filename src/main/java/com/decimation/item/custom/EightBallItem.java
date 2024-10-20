package com.decimation.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class EightBallItem extends Item {

    public EightBallItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            outputRandNum(player);
            player.getCooldowns().addCooldown(this, 20);
        }
        return super.use(level, player, hand);
    }

    private int getRandNumb() {
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }

    private void outputRandNum(@NotNull Player player){
        player.sendSystemMessage(Component.literal("Ваш номер: " + getRandNumb()));
    }

}
