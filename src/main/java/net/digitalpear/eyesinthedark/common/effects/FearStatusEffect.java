package net.digitalpear.eyesinthedark.common.effects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import org.jetbrains.annotations.Nullable;

public class FearStatusEffect extends StatusEffect {

    @Nullable
    protected Entity source;
    public FearStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);

    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.dismountVehicle();
    }
}
