package net.digitalpear.eyesinthedark.common.entities;

import net.digitalpear.eyesinthedark.EyesInTheDark;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;

public class WhiteEyesFeatureRenderer extends EyesFeatureRenderer<WhiteEyesEntity, WhiteEyesEntityModel> {
    private static final RenderLayer EYES = RenderLayer.getEyes(EyesInTheDark.id("textures/entity/white_eyes/eyes.png"));


    public WhiteEyesFeatureRenderer(FeatureRendererContext<WhiteEyesEntity, WhiteEyesEntityModel> featureRendererContext) {
        super(featureRendererContext);
    }

    public RenderLayer getEyesTexture() {
        return EYES;
    }
}
