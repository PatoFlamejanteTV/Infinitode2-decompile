/*    */ package com.prineside.tdi2.waves.templates;
/*    */ 
/*    */ import com.prineside.tdi2.WaveTemplates;
/*    */ import com.prineside.tdi2.enums.EnemyType;
/*    */ 
/*    */ public class ToxicMedium extends WaveTemplates.WaveTemplate {
/*  7 */   private final WaveTemplates.EnemyGroupConfig[] a = new WaveTemplates.EnemyGroupConfig[] { new WaveTemplates.EnemyGroupConfig(this) {
/*    */         public EnemyType getEnemyType() {
/*  9 */           return EnemyType.TOXIC;
/* 10 */         } public float getInterval(int param1Int, float param1Float1, float param1Float2) { return 0.5F; }
/* 11 */         public int getCount(int param1Int, float param1Float1, float param1Float2) { return 12 + (int)StrictMath.pow(param1Int, 0.65D); }
/* 12 */         public float getHealth(int param1Int, float param1Float1, float param1Float2) { return 15.0F + (float)StrictMath.pow(param1Float2 * 10.0D, 1.26D) * 0.07F; }
/* 13 */         public float getBounty(int param1Int, float param1Float1, float param1Float2) { return 2.0F + param1Int * 0.05F; }
/* 14 */         public float getDelay(int param1Int, float param1Float1, float param1Float2) { return 0.0F; }
/* 15 */         public float getSpeed(int param1Int, float param1Float1, float param1Float2) { return 1.0F; }
/* 16 */         public float getKillExp(int param1Int, float param1Float1, float param1Float2) { return 1.0F + param1Int * 0.01F; } public int getKillScore(int param1Int, float param1Float1, float param1Float2) {
/* 17 */           return 10;
/*    */         }
/*    */       } };
/*    */ 
/*    */   
/*    */   public int getProbability(int paramInt, float paramFloat1, float paramFloat2) {
/* 23 */     return WaveTemplates.calculateProbability(paramInt, paramFloat2, 1, 0.02F, 0.65F, 0.2F, 30.0F, 30.0F, 0.03F, 7);
/*    */   }
/*    */   
/*    */   public WaveTemplates.EnemyGroupConfig[] getEnemyGroupConfigs() {
/* 27 */     return this.a;
/*    */   }
/*    */   public String getWaveMessage() {
/* 30 */     return null;
/*    */   }
/*    */   public String getWaveName() {
/* 33 */     return "ToxicMedium";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\waves\templates\ToxicMedium.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */