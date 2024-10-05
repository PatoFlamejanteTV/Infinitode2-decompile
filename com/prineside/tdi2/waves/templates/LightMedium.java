/*    */ package com.prineside.tdi2.waves.templates;
/*    */ 
/*    */ import com.badlogic.gdx.math.MathUtils;
/*    */ import com.prineside.tdi2.WaveTemplates;
/*    */ import com.prineside.tdi2.enums.EnemyType;
/*    */ 
/*    */ public class LightMedium extends WaveTemplates.WaveTemplate {
/*  8 */   private final WaveTemplates.EnemyGroupConfig[] a = new WaveTemplates.EnemyGroupConfig[] { new WaveTemplates.EnemyGroupConfig(this)
/*    */       {
/*    */         private static float a(int param1Int)
/*    */         {
/* 12 */           return MathUtils.clamp(0.4F + param1Int / 15.0F * 0.6F, 0.0F, 1.0F);
/*    */         }
/*    */         private float b(int param1Int) {
/* 15 */           return 1.0F / a(param1Int);
/*    */         }
/*    */         
/* 18 */         public EnemyType getEnemyType() { return EnemyType.LIGHT; }
/* 19 */         public float getInterval(int param1Int, float param1Float1, float param1Float2) { return 0.5F * b(param1Int); }
/* 20 */         public int getCount(int param1Int, float param1Float1, float param1Float2) { return (int)((12 + (int)StrictMath.pow(param1Int, 0.65D)) * a(param1Int)); }
/* 21 */         public float getHealth(int param1Int, float param1Float1, float param1Float2) { return 12.0F + (float)StrictMath.pow(param1Float2 * 10.5D, 1.27D) * 0.055F; }
/* 22 */         public float getBounty(int param1Int, float param1Float1, float param1Float2) { return (2.0F + param1Int * 0.05F) * b(param1Int); }
/* 23 */         public float getDelay(int param1Int, float param1Float1, float param1Float2) { return 0.0F; }
/* 24 */         public float getSpeed(int param1Int, float param1Float1, float param1Float2) { return 1.101F; }
/* 25 */         public float getKillExp(int param1Int, float param1Float1, float param1Float2) { return (1.0F + param1Int * 0.01F) * b(param1Int); } public int getKillScore(int param1Int, float param1Float1, float param1Float2) {
/* 26 */           return (int)(10.0F * b(param1Int));
/*    */         }
/*    */       } };
/*    */ 
/*    */   
/*    */   public int getProbability(int paramInt, float paramFloat1, float paramFloat2) {
/* 32 */     return WaveTemplates.calculateProbability(paramInt, paramFloat2, 3, 0.06F, 0.5F, 0.23F, 25.0F, 20.0F, 0.03F, 7);
/*    */   }
/*    */   
/*    */   public WaveTemplates.EnemyGroupConfig[] getEnemyGroupConfigs() {
/* 36 */     return this.a;
/*    */   }
/*    */   public String getWaveMessage() {
/* 39 */     return null;
/*    */   }
/*    */   public String getWaveName() {
/* 42 */     return "LightMedium";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\waves\templates\LightMedium.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */