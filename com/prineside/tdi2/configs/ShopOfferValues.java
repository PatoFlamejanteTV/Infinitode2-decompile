/*    */ package com.prineside.tdi2.configs;
/*    */ 
/*    */ 
/*    */ public final class ShopOfferValues
/*    */ {
/*  6 */   public static final PlayStageFunction REGULAR_BLUEPRINT_VALUE = new PlayStageFunction(0.004166667F, 0.0038461538F, 0.0035714286F, 0.0033333334F, 0.003125F, 0.0029411765F, 0.0027777778F, 0.002631579F, 0.0025F, 0.0023809525F, 0.0022727272F);
/*    */   
/*  8 */   public static final PlayStageFunction REGULAR_BLUEPRINT_QUANTITY = new PlayStageFunction(5.0F, 8.0F, 13.0F, 20.0F, 25.0F, 35.0F, 50.0F, 70.0F, 100.0F, 140.0F, 200.0F);
/*    */   
/* 10 */   public static final PlayStageFunction SPECIAL_BLUEPRINT_VALUE = new PlayStageFunction(0.05F, 0.04761905F, 0.045454547F, 0.04347826F, 0.041666668F, 0.04F, 0.03846154F, 0.037037037F, 0.035714287F, 0.03448276F, 0.033333335F);
/*    */   
/* 12 */   public static final PlayStageFunction SPECIAL_BLUEPRINT_QUANTITY = new PlayStageFunction(1.0F, 1.5F, 2.0F, 2.5F, 3.0F, 3.5F, 4.0F, 5.0F, 6.0F, 7.0F, 8.0F);
/*    */   
/* 14 */   public static final PlayStageFunction ACCELERATOR_VALUE = new PlayStageFunction(0.05F, 0.051282052F, 0.05263158F, 0.054054055F, 0.055555556F, 0.057142857F, 0.05882353F, 0.060606062F, 0.0625F, 0.06451613F, 0.06666667F);
/*    */   
/* 16 */   public static final PlayStageFunction GREEN_PAPERS_VALUE = new PlayStageFunction(1.4285714E-5F, 1.0526316E-5F, 4.5454544E-6F, 3.174603E-6F, 2.0E-6F, 1.1111111E-6F, 6.6666666E-7F, 3.3333333E-7F, 1.6666667E-7F, 8.333333E-8F, 5.0E-8F);
/*    */   
/* 18 */   public static final PlayStageFunction GREEN_PAPERS_QUANTITY = new PlayStageFunction(20000.0F, 30000.0F, 50000.0F, 80000.0F, 150000.0F, 250000.0F, 400000.0F, 600000.0F, 800000.0F, 1000000.0F, 1500000.0F);
/*    */   
/* 20 */   public static final PlayStageFunction RESOURCE_VALUE = new PlayStageFunction(3.3333333E-4F, 2.8571428E-4F, 2.5E-4F, 2.2222222E-4F, 1.8181818E-4F, 1.3333333E-4F, 1.0E-4F, 7.6923076E-5F, 5.882353E-5F, 4.5454544E-5F, 3.3333334E-5F);
/*    */   
/* 22 */   public static final PlayStageFunction BIT_DUST_VALUE = new PlayStageFunction(0.04F, 0.033333335F, 0.028571429F, 0.025F, 0.022222223F, 0.02F, 0.018181818F, 0.016666668F, 0.015384615F, 0.014285714F, 0.013333334F);
/*    */   
/* 24 */   public static final PlayStageFunction BIT_DUST_QUANTITY = new PlayStageFunction(1.0F, 3.0F, 10.0F, 20.0F, 40.0F, 80.0F, 130.0F, 200.0F, 300.0F, 600.0F, 1000.0F);
/*    */   
/* 26 */   public static final PlayStageFunction CASE_VALUE = new PlayStageFunction(1.0F, 0.95F, 0.9F, 0.85F, 0.8F, 0.75F, 0.7F, 0.65F, 0.6F, 0.55F, 0.5F);
/*    */   
/* 28 */   public static final PlayStageFunction CASE_QUANTITY = new PlayStageFunction(0.5F, 0.7F, 1.0F, 1.5F, 2.0F, 2.5F, 3.0F, 3.5F, 4.2F, 5.0F, 7.0F);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final class PlayStageFunction
/*    */   {
/* 45 */     private final float[] a = new float[11];
/*    */     
/*    */     public PlayStageFunction(float param1Float1, float param1Float2, float param1Float3, float param1Float4, float param1Float5, float param1Float6, float param1Float7, float param1Float8, float param1Float9, float param1Float10, float param1Float11) {
/* 48 */       this.a[0] = param1Float1;
/* 49 */       this.a[1] = param1Float2;
/* 50 */       this.a[2] = param1Float3;
/* 51 */       this.a[3] = param1Float4;
/* 52 */       this.a[4] = param1Float5;
/* 53 */       this.a[5] = param1Float6;
/* 54 */       this.a[6] = param1Float7;
/* 55 */       this.a[7] = param1Float8;
/* 56 */       this.a[8] = param1Float9;
/* 57 */       this.a[9] = param1Float10;
/* 58 */       this.a[10] = param1Float11;
/*    */     }
/*    */ 
/*    */     
/*    */     public final float calculate(int param1Int) {
/*    */       double d;
/* 64 */       if ((param1Int = (int)((d = getStage(param1Int)) + 1.0E-4D)) + 1 < this.a.length) {
/* 65 */         return (float)((this.a[param1Int + 1] - this.a[param1Int]) * d % 1.0D + this.a[param1Int]);
/*    */       }
/* 67 */       return this.a[this.a.length - 1];
/*    */     }
/*    */ 
/*    */     
/*    */     public static double getStage(int param1Int) {
/*    */       double d;
/* 73 */       if ((d = (param1Int / 60.0F / 60.0F)) <= 1.0E-5D)
/* 74 */         return 0.0D; 
/* 75 */       if (d < 4.0D)
/* 76 */         return d / 4.0D; 
/* 77 */       if (d < 10.0D)
/* 78 */         return 1.0D + (d - 4.0D) / 6.0D; 
/* 79 */       if (d < 20.0D)
/* 80 */         return 2.0D + (d - 10.0D) / 10.0D; 
/* 81 */       if (d < 40.0D)
/* 82 */         return 3.0D + (d - 20.0D) / 20.0D; 
/* 83 */       if (d < 80.0D)
/* 84 */         return 4.0D + (d - 40.0D) / 40.0D; 
/* 85 */       if (d < 160.0D)
/* 86 */         return 5.0D + (d - 80.0D) / 80.0D; 
/* 87 */       if (d < 320.0D)
/* 88 */         return 6.0D + (d - 160.0D) / 160.0D; 
/* 89 */       if (d < 640.0D)
/* 90 */         return 7.0D + (d - 320.0D) / 320.0D; 
/* 91 */       if (d < 1280.0D)
/* 92 */         return 8.0D + (d - 640.0D) / 640.0D; 
/* 93 */       if (d < 2560.0D) {
/* 94 */         return 9.0D + (d - 1280.0D) / 1280.0D;
/*    */       }
/* 96 */       return 10.0D;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\configs\ShopOfferValues.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */