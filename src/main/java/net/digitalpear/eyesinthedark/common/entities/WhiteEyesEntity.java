package net.digitalpear.eyesinthedark.common.entities;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;

import java.util.List;

public class WhiteEyesEntity extends PathAwareEntity {
    protected float distanceToDisappear = 3.0f;

    int cooldownMultiplier = 6;
    protected UniformIntProvider lookingCooldown = UniformIntProvider.create(1000 * cooldownMultiplier,1200 * cooldownMultiplier);

    public WhiteEyesEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }


    boolean isPlayerStaring(PlayerEntity player) {
        ItemStack itemStack = player.getInventory().armor.get(3);
        if (itemStack.isOf(Blocks.CARVED_PUMPKIN.asItem())) {
            return false;
        } else {
            Vec3d vec3d = player.getRotationVec(1.0F).normalize();
            Vec3d vec3d2 = new Vec3d(this.getX() - player.getX(), this.getEyeY() - player.getEyeY(), this.getZ() - player.getZ());
            double d = vec3d2.length();
            vec3d2 = vec3d2.normalize();
            double e = vec3d.dotProduct(vec3d2);
            return e > 1.0D - 0.025D / d && player.canSee(this);
        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new LookAtEntityGoal(this, PlayerEntity.class, 16.0F));
        this.goalSelector.add(2, new LookAroundGoal(this));
    }

    public boolean isAnyPlayerValid(){
        return world.getPlayers().stream().anyMatch(this::isPlayerValid);
    }

    public boolean isPlayerValid(PlayerEntity player){
        return
                isPlayerStaring(player)
                || !player.isCreative()
                || !player.isSpectator()
                || !player.hasStatusEffect(StatusEffects.DARKNESS);
    }
    public boolean shouldDespawn(){
        return isAnyPlayerValid() || isInLava() || isSubmergedInWater();
    }


    @Override
    protected void mobTick() {
        super.mobTick();
        for (PlayerEntity playerEntity : world.getPlayers()) {
            if (this.isPlayerStaring(playerEntity)) {
                StatusEffectInstance statusEffectInstance = new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 6000, 2);
                List<ServerPlayerEntity> list = StatusEffectUtil.addEffectToPlayersWithinDistance((ServerWorld)this.world, this, this.getPos(), 50.0D, statusEffectInstance, 1200);
                list.forEach((serverPlayerEntity) -> serverPlayerEntity.networkHandler.sendPacket(new GameStateChangeS2CPacket(GameStateChangeS2CPacket.ELDER_GUARDIAN_EFFECT, this.isSilent() ? 0.0F : 1.0F)));
//                this.remove(RemovalReason.CHANGED_DIMENSION);
            }
        }
    }

//    @Override
//    public void tick() {
//        for (PlayerEntity playerEntity : world.getPlayers()) {
//            if (this.isPlayerStaring(playerEntity)) {
//                int thisCooldown = lookingCooldown.get(random);
//                playerEntity.addStatusEffect(new StatusEffectInstance(EyesStatusEffects.FEAR, 400), this);
//                playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 800), this);
//                playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), this);
//                playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 400), this);
//                while (thisCooldown > 0) {
//                    playSound(SoundEvents.ENTITY_ENDERMAN_SCREAM, 0.6f, 3.0f);
//                    playerEntity.lookAt(EntityAnchorArgumentType.EntityAnchor.EYES, this.getPos());
//                    thisCooldown--;
//                }
//                this.remove(RemovalReason.CHANGED_DIMENSION);
//
//            }
//        }
//        super.tick();
//    }

    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 1.5F;
    }

    @Override
    public boolean isInvulnerable() {
        return true;
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return shouldDespawn();
    }

    public static DefaultAttributeContainer.Builder createWhiteEyesAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100000.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.0D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1000000);
    }
}
