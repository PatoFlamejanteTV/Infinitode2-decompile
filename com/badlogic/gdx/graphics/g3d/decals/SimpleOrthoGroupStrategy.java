/*     */ package com.badlogic.gdx.graphics.g3d.decals;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Sort;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SimpleOrthoGroupStrategy
/*     */   implements GroupStrategy
/*     */ {
/*  72 */   private Comparator comparator = new Comparator();
/*     */   
/*     */   private static final int GROUP_OPAQUE = 0;
/*     */   private static final int GROUP_BLEND = 1;
/*     */   
/*     */   public int decideGroup(Decal paramDecal) {
/*  78 */     return paramDecal.getMaterial().isOpaque() ? 0 : 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void beforeGroup(int paramInt, Array<Decal> paramArray) {
/*  83 */     if (paramInt == 1) {
/*  84 */       Sort.instance().sort(paramArray, this.comparator);
/*  85 */       Gdx.gl.glEnable(3042);
/*     */ 
/*     */       
/*  88 */       Gdx.gl.glDepthMask(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void afterGroup(int paramInt) {
/*  96 */     if (paramInt == 1) {
/*  97 */       Gdx.gl.glDepthMask(true);
/*  98 */       Gdx.gl.glDisable(3042);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void beforeGroups() {
/* 104 */     Gdx.gl.glEnable(3553);
/*     */   }
/*     */ 
/*     */   
/*     */   public void afterGroups() {
/* 109 */     Gdx.gl.glDisable(3553);
/*     */   }
/*     */   
/*     */   class Comparator
/*     */     implements java.util.Comparator<Decal> {
/*     */     public int compare(Decal param1Decal1, Decal param1Decal2) {
/* 115 */       if (param1Decal1.getZ() == param1Decal2.getZ()) return 0; 
/* 116 */       return (param1Decal1.getZ() - param1Decal2.getZ() < 0.0F) ? -1 : 1;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ShaderProgram getGroupShader(int paramInt) {
/* 122 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\decals\SimpleOrthoGroupStrategy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */