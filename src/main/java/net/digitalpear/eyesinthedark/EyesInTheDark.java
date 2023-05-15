package net.digitalpear.eyesinthedark;

import net.digitalpear.eyesinthedark.common.entities.WhiteEyesEntity;
import net.digitalpear.eyesinthedark.init.EyesStatusEffects;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EyesInTheDark implements ModInitializer {

    public static final String MOD_ID = "eyesinthedark";
    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }


    public static final EntityType<WhiteEyesEntity> WHITE_EYES = Registry.register(
            Registries.ENTITY_TYPE,
            id("white_eyes"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC)
                    .entityFactory(WhiteEyesEntity::new)
                    .dimensions(EntityDimensions.fixed(2f, 1.6f))
                    .disableSaving()
                    .fireImmune()
                    .spawnableFarFromPlayer()
                    .trackRangeBlocks(200)
                    .build()
    );




    @Override
    public void onInitialize() {
        EyesStatusEffects.init();


        FabricDefaultAttributeRegistry.register(WHITE_EYES, WhiteEyesEntity.createWhiteEyesAttributes());
    }
}
