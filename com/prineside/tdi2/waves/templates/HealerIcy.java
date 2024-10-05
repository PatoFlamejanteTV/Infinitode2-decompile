/*    */ package com.prineside.tdi2.waves.templates;
/*    */ 
/*    */ import com.badlogic.gdx.math.MathUtils;
/*    */ import com.prineside.tdi2.WaveTemplates;
/*    */ import com.prineside.tdi2.enums.EnemyType;
/*    */ 
/*    */ public class HealerIcy extends WaveTemplates.WaveTemplate {
/*  8 */   private final WaveTemplates.EnemyGroupConfig[] a = new WaveTemplates.EnemyGroupConfig[] { new WaveTemplates.EnemyGroupConfig(this)
/*    */       {
/*    */         private static float a(int param1Int)
/*    */         {
/* 12 */           return MathUtils.clamp(0.6F + param1Int / 25.0F * 0.4F, 0.0F, 1.0F);
/*    */         }
/*    */         private float b(int param1Int) {
/* 15 */           return 1.0F / a(param1Int);
/*    */         }
/*    */         
/* 18 */         public EnemyType getEnemyType() { return EnemyType.ICY; }
/* 19 */         public float getInterval(int param1Int, float param1Float1, float param1Float2) { return 0.67F * b(param1Int); }
/* 20 */         public int getCount(int param1Int, float param1Float1, float param1Float2) { return (int)((9 + (int)StrictMath.pow((param1Int * 0.95F), 0.6D)) * a(param1Int)); }
/* 21 */         public float getHealth(int param1Int, float param1Float1, float param1Float2) { return 9.0F + (float)StrictMath.pow(param1Float2 * 10.0D, 1.29D) * 0.05F; }
/* 22 */         public float getBounty(int param1Int, float param1Float1, float param1Float2) { return (1.3F + param1Int * 0.035F) * b(param1Int); }
/* 23 */         public float getDelay(int param1Int, float param1Float1, float param1Float2) { return 0.0F; }
/* 24 */         public float getSpeed(int param1Int, float param1Float1, float param1Float2) { return 0.9F; }
/* 25 */         public float getKillExp(int param1Int, float param1Float1, float param1Float2) { return (0.7F + param1Int * 0.007F) * b(param1Int); } public int getKillScore(int param1Int, float param1Float1, float param1Float2) {
/* 26 */           return 7;
/*    */         }
/*    */       }, new WaveTemplates.EnemyGroupConfig(this)
/*    */       {
/*    */         private static float a(int param1Int) {
/* 31 */           return MathUtils.clamp(0.6F + param1Int / 25.0F * 0.4F, 0.0F, 1.0F);
/*    */         }
/*    */         private float b(int param1Int) {
/* 34 */           return 1.0F / a(param1Int);
/*    */         }
/*    */         
/* 37 */         public EnemyType getEnemyType() { return EnemyType.HEALER; }
/* 38 */         public float getInterval(int param1Int, float param1Float1, float param1Float2) { return 1.1F * b(param1Int); }
/* 39 */         public int getCount(int param1Int, float param1Float1, float param1Float2) { return (int)((4 + (int)StrictMath.pow((param1Int * 0.9F), 0.52D)) * 0.8D * a(param1Int)); }
/* 40 */         public float getHealth(int param1Int, float param1Float1, float param1Float2) { return 14.0F + (float)StrictMath.pow(param1Float2 * 10.0D, 1.23D) * 0.07F; }
/* 41 */         public float getBounty(int param1Int, float param1Float1, float param1Float2) { return (2.5F + param1Int * 0.075F) * b(param1Int); }
/* 42 */         public float getDelay(int param1Int, float param1Float1, float param1Float2) { return 0.0F; }
/* 43 */         public float getSpeed(int param1Int, float param1Float1, float param1Float2) { return 0.9F; }
/* 44 */         public float getKillExp(int param1Int, float param1Float1, float param1Float2) { return (1.2F + param1Int * 0.012F) * b(param1Int); } public int getKillScore(int param1Int, float param1Float1, float param1Float2) {
/* 45 */           return (int)(15.0F * b(param1Int));
/*    */         }
/*    */       } };
/*    */ 
/*    */   
/*    */   public int getProbability(int paramInt, float paramFloat1, float paramFloat2) {
/* 51 */     return WaveTemplates.calculateProbability(paramInt, paramFloat2, 3, 0.05F, 0.65F, 0.2F, -10.0F, 28.0F, 0.1F, 4);
/*    */   }
/*    */   
/*    */   public WaveTemplates.EnemyGroupConfig[] getEnemyGroupConfigs() {
/* 55 */     return this.a;
/*    */   }
/*    */   public String getWaveMessage() {
/* 58 */     return null;
/*    */   }
/*    */   public String getWaveName() {
/* 61 */     return "HealerIcy";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\waves\templates\HealerIcy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */