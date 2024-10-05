/*    */ package com.badlogic.gdx.graphics.g3d.decals;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
/*    */ public class DecalMaterial
/*    */ {
/*    */   public static final int NO_BLEND = -1;
/*    */   protected TextureRegion textureRegion;
/*    */   protected int srcBlendFactor;
/*    */   protected int dstBlendFactor;
/*    */   
/*    */   public void set() {
/* 31 */     this.textureRegion.getTexture().bind(0);
/* 32 */     if (!isOpaque()) {
/* 33 */       Gdx.gl.glBlendFunc(this.srcBlendFactor, this.dstBlendFactor);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOpaque() {
/* 39 */     return (this.srcBlendFactor == -1);
/*    */   }
/*    */   
/*    */   public int getSrcBlendFactor() {
/* 43 */     return this.srcBlendFactor;
/*    */   }
/*    */   
/*    */   public int getDstBlendFactor() {
/* 47 */     return this.dstBlendFactor;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 52 */     if (paramObject == null) return false;
/*    */     
/* 54 */     paramObject = paramObject;
/*    */     
/* 56 */     if (this.dstBlendFactor == ((DecalMaterial)paramObject).dstBlendFactor && this.srcBlendFactor == ((DecalMaterial)paramObject).srcBlendFactor && this.textureRegion
/* 57 */       .getTexture() == ((DecalMaterial)paramObject).textureRegion.getTexture()) return true;
/*    */     
/*    */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int i = (this.textureRegion.getTexture() != null) ? this.textureRegion.getTexture().hashCode() : 0;
/* 64 */     i = i * 31 + this.srcBlendFactor;
/*    */     
/* 66 */     return i = i * 31 + this.dstBlendFactor;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\decals\DecalMaterial.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */