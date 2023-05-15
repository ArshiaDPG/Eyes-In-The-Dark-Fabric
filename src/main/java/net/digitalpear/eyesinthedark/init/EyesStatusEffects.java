package net.digitalpear.eyesinthedark.init;

import net.digitalpear.eyesinthedark.EyesInTheDark;
import net.digitalpear.eyesinthedark.common.effects.FearStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class EyesStatusEffects {
    public static final StatusEffect FEAR = register("fear", new FearStatusEffect(StatusEffectCategory.HARMFUL, 0));



    private static StatusEffect register(String id, StatusEffect entry) {
        return Registry.register(Registries.STATUS_EFFECT, EyesInTheDark.id(id), entry);
    }

    public static void init(){}
}
