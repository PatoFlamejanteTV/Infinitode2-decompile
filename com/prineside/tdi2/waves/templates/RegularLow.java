/*    */ package com.prineside.tdi2.waves.templates;
/*    */ 
/*    */ import com.prineside.tdi2.WaveTemplates;
/*    */ import com.prineside.tdi2.enums.EnemyType;
/*    */ 
/*    */ public class RegularLow extends WaveTemplates.WaveTemplate {
/*  7 */   private final WaveTemplates.EnemyGroupConfig[] a = new WaveTemplates.EnemyGroupConfig[] { new WaveTemplates.EnemyGroupConfig(this) {
/*    */         public EnemyType getEnemyType() {
/*  9 */           return EnemyType.REGULAR;
/* 10 */         } public float getInterval(int param1Int, float param1Float1, float param1Float2) { return 1.0F; }
/* 11 */         public int getCount(int param1Int, float param1Float1, float param1Float2) { return 8 + (int)StrictMath.pow(param1Int, 0.59D); }
/* 12 */         public float getHealth(int param1Int, float param1Float1, float param1Float2) { return 26.0F + (float)StrictMath.pow((param1Float2 * 9.5F), 1.26D) * 0.1F; }
/* 13 */         public float getBounty(int param1Int, float param1Float1, float param1Float2) { return 2.9F + param1Int * 0.07F; }
/* 14 */         public float getDelay(int param1Int, float param1Float1, float param1Float2) { return 0.0F; }
/* 15 */         public float getSpeed(int param1Int, float param1Float1, float param1Float2) { return 1.0F; }
/* 16 */         public float getKillExp(int param1Int, float param1Float1, float param1Float2) { return 1.4F + param1Int * 0.014F; } public int getKillScore(int param1Int, float param1Float1, float param1Float2) {
/* 17 */           return 15;
/*    */         }
/*    */       } };
/*    */ 
/*    */   
/*    */   public int getProbability(int paramInt, float paramFloat1, float paramFloat2) {
/* 23 */     return WaveTemplates.calculateProbability(paramInt, paramFloat2, 0, 1.0F, 0.5F, 0.25F, 90.0F, 40.0F, 0.16F, 3);
/*    */   }
/*    */   
/*    */   public WaveTemplates.EnemyGroupConfig[] getEnemyGroupConfigs() {
/* 27 */     return this.a;
/*    */   }
/*    */   public String getWaveMessage() {
/* 30 */     return null;
/*    */   }
/*    */   public String getWaveName() {
/* 33 */     return "RegularLow";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\waves\templates\RegularLow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */