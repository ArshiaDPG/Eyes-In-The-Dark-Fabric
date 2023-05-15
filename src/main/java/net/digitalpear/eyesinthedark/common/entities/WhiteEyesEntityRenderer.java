package net.digitalpear.eyesinthedark.common.entities;

import net.digitalpear.eyesinthedark.EyesInTheDark;
import net.digitalpear.eyesinthedark.client.EyesInTheDarkClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class WhiteEyesEntityRenderer  extends MobEntityRenderer<WhiteEyesEntity, WhiteEyesEntityModel> {

    public static final Identifier TEXTURE = EyesInTheDark.id("textures/entity/white_eyes/white_eyes.png");

    public WhiteEyesEntityRenderer(EntityRendererFactory.Context entityRenderDispatcher) {
        super(entityRenderDispatcher, new WhiteEyesEntityModel(entityRenderDispatcher.getPart(EyesInTheDarkClient.MAIN)), 1.4f);
        this.addFeature(new WhiteEyesFeatureRenderer(this));
    }

    @Override
    public Identifier getTexture(WhiteEyesEntity entity) {
        return TEXTURE;
    }
}