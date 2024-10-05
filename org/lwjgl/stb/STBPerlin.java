/*    */ package org.lwjgl.stb;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
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
/*    */ public class STBPerlin
/*    */ {
/*    */   static {
/* 17 */     LibSTB.initialize();
/*    */   }
/*    */   protected STBPerlin() {
/* 20 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static native float stb_perlin_noise3_wrap_nonpow2(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, int paramInt3, @NativeType("unsigned char") byte paramByte);
/*    */   
/*    */   public static native float stb_perlin_turbulence_noise3(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt);
/*    */   
/*    */   public static native float stb_perlin_fbm_noise3(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt);
/*    */   
/*    */   public static native float stb_perlin_ridge_noise3(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt);
/*    */   
/*    */   public static native float stb_perlin_noise3_seed(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*    */   
/*    */   public static native float stb_perlin_noise3(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, int paramInt3);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBPerlin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */