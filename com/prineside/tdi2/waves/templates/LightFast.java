/*    */ package com.prineside.tdi2.waves.templates;
/*    */ 
/*    */ import com.badlogic.gdx.math.MathUtils;
/*    */ import com.prineside.tdi2.WaveTemplates;
/*    */ import com.prineside.tdi2.enums.EnemyType;
/*    */ 
/*    */ public class LightFast extends WaveTemplates.WaveTemplate {
/*  8 */   private final WaveTemplates.EnemyGroupConfig[] a = new WaveTemplates.EnemyGroupConfig[] { new WaveTemplates.EnemyGroupConfig(this)
/*    */       {
/*    */         private static float a(int param1Int)
/*    */         {
/* 12 */           return MathUtils.clamp(0.4F + param1Int / 20.0F * 0.6F, 0.0F, 1.0F);
/*    */         }
/*    */         private float b(int param1Int) {
/* 15 */           return 1.0F / a(param1Int);
/*    */         }
/*    */         
/* 18 */         public EnemyType getEnemyType() { return EnemyType.LIGHT; }
/* 19 */         public float getInterval(int param1Int, float param1Float1, float param1Float2) { return 1.5F * b(param1Int); }
/* 20 */         public int getCount(int param1Int, float param1Float1, float param1Float2) { return (int)(((3 + (int)StrictMath.pow(param1Int * 0.6D, 0.59D)) * a(param1Int)) * 0.6D); }
/* 21 */         public float getHealth(int param1Int, float param1Float1, float param1Float2) { return 15.0F + (float)StrictMath.pow(param1Float2 * 7.0D, 1.265D) * 0.07F; }
/* 22 */         public float getBounty(int param1Int, float param1Float1, float param1Float2) { return (5.5F + param1Int * 0.105F) * b(param1Int); }
/* 23 */         public float getDelay(int param1Int, float param1Float1, float param1Float2) { return 0.0F; }
/* 24 */         public float getSpeed(int param1Int, float param1Float1, float param1Float2) { return 1.101F; }
/* 25 */         public float getKillExp(int param1Int, float param1Float1, float param1Float2) { return (1.9F + param1Int * 0.02F) * b(param1Int); } public int getKillScore(int param1Int, float param1Float1, float param1Float2) {
/* 26 */           return (int)(25.0F * b(param1Int));
/*    */         }
/*    */       }, new WaveTemplates.EnemyGroupConfig(this)
/*    */       {
/*    */         private static float a(int param1Int) {
/* 31 */           return MathUtils.clamp(0.4F + param1Int / 15.0F * 0.6F, 0.0F, 1.0F);
/*    */         }
/*    */         private float b(int param1Int) {
/* 34 */           return 1.0F / a(param1Int);
/*    */         }
/*    */         
/* 37 */         public EnemyType getEnemyType() { return EnemyType.FAST; }
/* 38 */         public float getInterval(int param1Int, float param1Float1, float param1Float2) { return 1.0F * b(param1Int); }
/* 39 */         public int getCount(int param1Int, float param1Float1, float param1Float2) { return (int)((5.7F + (int)StrictMath.pow(param1Int, 0.6D)) * a(param1Int) * 0.7125F); }
/* 40 */         public float getHealth(int param1Int, float param1Float1, float param1Float2) { return 9.9F + (float)StrictMath.pow(param1Float2 * 8.0D, 1.3D) * 0.0495F; }
/* 41 */         public float getBounty(int param1Int, float param1Float1, float param1Float2) { return (2.5F + param1Int * 0.07F) * b(param1Int); }
/* 42 */         public float getDelay(int param1Int, float param1Float1, float param1Float2) { return 0.05F; }
/* 43 */         public float getSpeed(int param1Int, float param1Float1, float param1Float2) { return 1.25F; }
/* 44 */         public float getKillExp(int param1Int, float param1Float1, float param1Float2) { return (1.3F + param1Int * 0.013F) * b(param1Int); } public int getKillScore(int param1Int, float param1Float1, float param1Float2) {
/* 45 */           return (int)(13.0F * b(param1Int));
/*    */         }
/*    */       } };
/*    */ 
/*    */   
/*    */   public int getProbability(int paramInt, float paramFloat1, float paramFloat2) {
/* 51 */     return WaveTemplates.calculateProbability(paramInt, paramFloat2, 3, 0.07F, 0.5F, 0.33F, 45.0F, 17.0F, 0.04F, 6);
/*    */   }
/*    */   
/*    */   public WaveTemplates.EnemyGroupConfig[] getEnemyGroupConfigs() {
/* 55 */     return this.a;
/*    */   }
/*    */   public String getWaveMessage() {
/* 58 */     return null;
/*    */   }
/*    */   public String getWaveName() {
/* 61 */     return "LightFast";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\waves\templates\LightFast.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */