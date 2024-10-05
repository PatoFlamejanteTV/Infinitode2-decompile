/*    */ package com.badlogic.gdx.graphics.g2d;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PolygonRegion
/*    */ {
/*    */   final float[] textureCoords;
/*    */   final float[] vertices;
/*    */   final short[] triangles;
/*    */   final TextureRegion region;
/*    */   
/*    */   public PolygonRegion(TextureRegion paramTextureRegion, float[] paramArrayOffloat, short[] paramArrayOfshort) {
/* 34 */     this.region = paramTextureRegion;
/* 35 */     this.vertices = paramArrayOffloat;
/* 36 */     this.triangles = paramArrayOfshort;
/*    */     
/* 38 */     float[] arrayOfFloat = this.textureCoords = new float[paramArrayOffloat.length];
/* 39 */     float f1 = paramTextureRegion.u, f2 = paramTextureRegion.v;
/* 40 */     float f3 = paramTextureRegion.u2 - f1;
/* 41 */     float f4 = paramTextureRegion.v2 - f2;
/* 42 */     int j = paramTextureRegion.regionWidth;
/* 43 */     int i = paramTextureRegion.regionHeight; byte b; int k;
/* 44 */     for (b = 0, k = paramArrayOffloat.length; b < k; b += 2) {
/* 45 */       arrayOfFloat[b] = f1 + f3 * paramArrayOffloat[b] / j;
/* 46 */       arrayOfFloat[b + 1] = f2 + f4 * (1.0F - paramArrayOffloat[b + 1] / i);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public float[] getVertices() {
/* 52 */     return this.vertices;
/*    */   }
/*    */   
/*    */   public short[] getTriangles() {
/* 56 */     return this.triangles;
/*    */   }
/*    */   
/*    */   public float[] getTextureCoords() {
/* 60 */     return this.textureCoords;
/*    */   }
/*    */   
/*    */   public TextureRegion getRegion() {
/* 64 */     return this.region;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\PolygonRegion.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */