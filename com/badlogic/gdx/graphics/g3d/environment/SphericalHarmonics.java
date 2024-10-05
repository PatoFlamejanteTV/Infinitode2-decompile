/*    */ package com.badlogic.gdx.graphics.g3d.environment;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SphericalHarmonics
/*    */ {
/* 24 */   private static final float[] coeff = new float[] { 0.282095F, 0.488603F, 0.488603F, 0.488603F, 1.092548F, 1.092548F, 1.092548F, 0.315392F, 0.546274F };
/*    */   public final float[] data;
/*    */   
/*    */   private static final float clamp(float paramFloat) {
/* 28 */     return (paramFloat < 0.0F) ? 0.0F : ((paramFloat > 1.0F) ? 1.0F : paramFloat);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public SphericalHarmonics() {
/* 34 */     this.data = new float[27];
/*    */   }
/*    */   
/*    */   public SphericalHarmonics(float[] paramArrayOffloat) {
/* 38 */     if (paramArrayOffloat.length != 27) throw new GdxRuntimeException("Incorrect array size"); 
/* 39 */     this.data = (float[])paramArrayOffloat.clone();
/*    */   }
/*    */   
/*    */   public SphericalHarmonics set(float[] paramArrayOffloat) {
/* 43 */     for (byte b = 0; b < this.data.length; b++)
/* 44 */       this.data[b] = paramArrayOffloat[b]; 
/* 45 */     return this;
/*    */   }
/*    */   
/*    */   public SphericalHarmonics set(AmbientCubemap paramAmbientCubemap) {
/* 49 */     return set(paramAmbientCubemap.data);
/*    */   }
/*    */   
/*    */   public SphericalHarmonics set(Color paramColor) {
/* 53 */     return set(paramColor.r, paramColor.g, paramColor.b);
/*    */   }
/*    */   
/*    */   public SphericalHarmonics set(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 57 */     for (byte b = 0; b < this.data.length; ) {
/* 58 */       this.data[b++] = paramFloat1;
/* 59 */       this.data[b++] = paramFloat2;
/* 60 */       this.data[b++] = paramFloat3;
/*    */     } 
/* 62 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\environment\SphericalHarmonics.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */