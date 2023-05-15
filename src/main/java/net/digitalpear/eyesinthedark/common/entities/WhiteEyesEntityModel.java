package net.digitalpear.eyesinthedark.common.entities;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class WhiteEyesEntityModel extends EntityModel<WhiteEyesEntity> {

    private final ModelPart base;
    private final ModelPart body;
    private final ModelPart head;

    private final ModelPart leftLegs;
    private final ModelPart leftBackLeg;
    private final ModelPart leftFrontLeg;
    private final ModelPart leftMiddleLeg;

    private final ModelPart rightLegs;
    private final ModelPart rightBackLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart rightMiddleLeg;

//    private final ModelPart cube_r1;
//    private final ModelPart cube_r2;
//    private final ModelPart cube_r3;
//    private final ModelPart cube_r4;
//    private final ModelPart cube_r5;
//    private final ModelPart cube_r6;

    public WhiteEyesEntityModel(ModelPart root) {
        this.base = root.getChild("base");
        this.body = base.getChild("body");
        this.head = body.getChild("head");



        //Left Legs
        this.leftLegs = base.getChild("leftLegs");

        this.leftBackLeg = leftLegs.getChild("leftBackLeg");
        this.leftMiddleLeg = leftLegs.getChild("leftMiddleLeg");
        this.leftFrontLeg = leftLegs.getChild("leftFrontLeg");

        //Right Legs
        this.rightLegs = base.getChild("rightLegs");

        this.rightBackLeg = rightLegs.getChild("rightBackLeg");
        this.rightMiddleLeg = rightLegs.getChild("rightMiddleLeg");
        this.rightFrontLeg = rightLegs.getChild("rightFrontLeg");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData base = modelPartData.addChild("base", ModelPartBuilder.create().uv(0, 22).cuboid(-2.0F, -14.0F, -5.0F, 9.0F, 8.0F, 10.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(7.0F, -16.0F, -6.0F, 15.0F, 10.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, 24.0F, 0.0F));

        ModelPartData body = base.addChild("body", ModelPartBuilder.create().uv(0, 76).cuboid(-5.0F, -12.0F, -4.0F, 4.0F, 12.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, -0.3054F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(68, 72).cuboid(-5.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -12.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

        ModelPartData leftLegs = base.addChild("leftLegs", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, -7.0F, -5.0F));

        ModelPartData leftBackLeg = leftLegs.addChild("leftBackLeg", ModelPartBuilder.create().uv(60, 46).cuboid(-1.0F, -1.0F, -16.0F, 2.0F, 2.0F, 16.0F, new Dilation(0.0F))
                .uv(0, 4).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 0.0F, 0.0F, -0.4363F, -0.3491F, 0.0F));

        ModelPartData cube_r1 = leftBackLeg.addChild("cube_r1", ModelPartBuilder.create().uv(20, 60).cuboid(-1.0F, -2.0F, -15.0F, 2.0F, 2.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData leftFrontLeg = leftLegs.addChild("leftFrontLeg", ModelPartBuilder.create().uv(58, 0).cuboid(-1.0F, -1.0F, -16.0F, 2.0F, 2.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 0.0F, 0.0F, -0.4363F, 0.3491F, 0.0F));

        ModelPartData cube_r2 = leftFrontLeg.addChild("cube_r2", ModelPartBuilder.create().uv(0, 58).cuboid(-1.0F, -2.0F, -15.0F, 2.0F, 2.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData leftMiddleLeg = leftLegs.addChild("leftMiddleLeg", ModelPartBuilder.create().uv(40, 62).cuboid(-1.0F, -1.0F, -16.0F, 2.0F, 2.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

        ModelPartData cube_r3 = leftMiddleLeg.addChild("cube_r3", ModelPartBuilder.create().uv(62, 18).cuboid(-1.0F, -2.0F, -15.0F, 2.0F, 2.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -14.0F, 1.8326F, 0.0F, 0.0F));

        ModelPartData rightLegs = base.addChild("rightLegs", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, -7.0F, 5.0F));

        ModelPartData rightBackLeg = rightLegs.addChild("rightBackLeg", ModelPartBuilder.create().uv(40, 44).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 16.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 0.0F, 0.0F, 0.4363F, 0.3491F, 0.0F));

        ModelPartData cube_r4 = rightBackLeg.addChild("cube_r4", ModelPartBuilder.create().uv(42, 26).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 14.0F, -1.5708F, 0.0F, 0.0F));

        ModelPartData rightFrontLeg = rightLegs.addChild("rightFrontLeg", ModelPartBuilder.create().uv(20, 42).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 0.0F, 0.0F, 0.4363F, -0.3491F, 0.0F));

        ModelPartData cube_r5 = rightFrontLeg.addChild("cube_r5", ModelPartBuilder.create().uv(0, 40).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 14.0F, -1.5708F, 0.0F, 0.0F));

        ModelPartData rightMiddleLeg = rightLegs.addChild("rightMiddleLeg", ModelPartBuilder.create().uv(38, 6).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

        ModelPartData cube_r6 = rightMiddleLeg.addChild("cube_r6", ModelPartBuilder.create().uv(22, 24).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 14.0F, -1.8326F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(WhiteEyesEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch) {
        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}