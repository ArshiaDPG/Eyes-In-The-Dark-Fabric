package net.digitalpear.eyesinthedark.client;

import net.digitalpear.eyesinthedark.EyesInTheDark;
import net.digitalpear.eyesinthedark.common.entities.WhiteEyesEntityModel;
import net.digitalpear.eyesinthedark.common.entities.WhiteEyesEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;

@Environment(EnvType.CLIENT)
public class EyesInTheDarkClient implements ClientModInitializer {

    public static final EntityModelLayer EYES = new EntityModelLayer(EyesInTheDark.id("white_eyes"), "eyes");
    public static final EntityModelLayer MAIN = new EntityModelLayer(EyesInTheDark.id("cube"), "cube");

    @Override
    public void onInitializeClient() {

        EntityModelLayerRegistry.registerModelLayer(MAIN, WhiteEyesEntityModel::getTexturedModelData);
//        EntityModelLayerRegistry.registerModelLayer(EYES, WhiteEyesEntityModel::getTexturedModelData);

        EntityRendererRegistry.register(EyesInTheDark.WHITE_EYES, WhiteEyesEntityRenderer::new);
    }
}
