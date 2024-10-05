/*    */ package com.prineside.tdi2.waves.templates;
/*    */ 
/*    */ import com.prineside.tdi2.WaveTemplates;
/*    */ import com.prineside.tdi2.enums.EnemyType;
/*    */ 
/*    */ public class ToxicHigh extends WaveTemplates.WaveTemplate {
/*  7 */   private final WaveTemplates.EnemyGroupConfig[] a = new WaveTemplates.EnemyGroupConfig[] { new WaveTemplates.EnemyGroupConfig(this) {
/*    */         public EnemyType getEnemyType() {
/*  9 */           return EnemyType.TOXIC;
/* 10 */         } public float getInterval(int param1Int, float param1Float1, float param1Float2) { return 0.3F; }
/* 11 */         public int getCount(int param1Int, float param1Float1, float param1Float2) { return 16 + (int)StrictMath.pow(param1Int, 0.7D); }
/* 12 */         public float getHealth(int param1Int, float param1Float1, float param1Float2) { return 8.0F + (float)StrictMath.pow(param1Float2 * 10.0D, 1.27D) * 0.051F; }
/* 13 */         public float getBounty(int param1Int, float param1Float1, float param1Float2) { return 1.7F + param1Int * 0.04F; }
/* 14 */         public float getDelay(int param1Int, float param1Float1, float param1Float2) { return 0.0F; }
/* 15 */         public float getSpeed(int param1Int, float param1Float1, float param1Float2) { return 1.0F; }
/* 16 */         public float getKillExp(int param1Int, float param1Float1, float param1Float2) { return 0.8F + param1Int * 0.0085F; } public int getKillScore(int param1Int, float param1Float1, float param1Float2) {
/* 17 */           return 8;
/*    */         }
/*    */       } };
/*    */ 
/*    */   
/*    */   public int getProbability(int paramInt, float paramFloat1, float paramFloat2) {
/* 23 */     return WaveTemplates.calculateProbability(paramInt, paramFloat2, 5, 0.022F, 0.5F, 0.25F, 45.0F, 25.0F, 0.035F, 5);
/*    */   }
/*    */   
/*    */   public WaveTemplates.EnemyGroupConfig[] getEnemyGroupConfigs() {
/* 27 */     return this.a;
/*    */   }
/*    */   public String getWaveMessage() {
/* 30 */     return null;
/*    */   }
/*    */   public String getWaveName() {
/* 33 */     return "ToxicHigh";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\waves\templates\ToxicHigh.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */