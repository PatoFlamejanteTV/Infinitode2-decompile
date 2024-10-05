/*    */ package com.prineside.tdi2.systems;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.badlogic.gdx.utils.ObjectMap;
/*    */ import com.prineside.tdi2.GameSystem;
/*    */ import com.prineside.tdi2.utils.NAGS;
/*    */ import com.prineside.tdi2.utils.SpriteCacheExtended;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @NAGS
/*    */ public final class CachedRenderingSystem
/*    */   extends GameSystem
/*    */ {
/* 20 */   private final ObjectMap<String, SpriteCacheExtended.CacheArray> a = new ObjectMap();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void removeLayer(String paramString) {
/*    */     SpriteCacheExtended.CacheArray cacheArray;
/* 28 */     if ((cacheArray = getLayer(paramString)) != null) {
/* 29 */       cacheArray.dispose();
/* 30 */       this.a.remove(paramString);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void setLayerDirty(String paramString) {
/*    */     SpriteCacheExtended.CacheArray cacheArray;
/* 39 */     if ((cacheArray = (SpriteCacheExtended.CacheArray)this.a.get(paramString)) != null) {
/* 40 */       cacheArray.dirty = true;
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean isDirty(String paramString) {
/*    */     SpriteCacheExtended.CacheArray cacheArray;
/* 49 */     if ((cacheArray = (SpriteCacheExtended.CacheArray)this.a.get(paramString)) != null) {
/* 50 */       return cacheArray.dirty;
/*    */     }
/* 52 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Null
/*    */   public final SpriteCacheExtended.CacheArray getLayer(String paramString) {
/* 60 */     return (SpriteCacheExtended.CacheArray)this.a.get(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final SpriteCacheExtended.CacheArray getOrAddLayer(String paramString, int paramInt, ShaderProgram paramShaderProgram, boolean paramBoolean) {
/*    */     SpriteCacheExtended.CacheArray cacheArray;
/* 69 */     if ((cacheArray = (SpriteCacheExtended.CacheArray)this.a.get(paramString)) == null) {
/* 70 */       return addLayer(paramString, paramInt, paramShaderProgram, paramBoolean);
/*    */     }
/* 72 */     if (cacheArray.getSizePerCache() < paramInt || paramShaderProgram != cacheArray.getShaderProgram() || paramBoolean != cacheArray.isUseIndices()) {
/* 73 */       removeLayer(paramString);
/* 74 */       return addLayer(paramString, paramInt, paramShaderProgram, paramBoolean);
/*    */     } 
/* 76 */     return cacheArray;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final SpriteCacheExtended.CacheArray addLayer(String paramString, int paramInt, ShaderProgram paramShaderProgram, boolean paramBoolean) {
/* 82 */     if (this.a.containsKey(paramString)) throw new IllegalStateException("Layer " + paramString + " already exists"); 
/* 83 */     SpriteCacheExtended.CacheArray cacheArray = new SpriteCacheExtended.CacheArray(paramString, paramInt, paramShaderProgram, paramBoolean);
/* 84 */     this.a.put(paramString, cacheArray);
/*    */     
/* 86 */     return cacheArray;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean affectsGameState() {
/* 91 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public final String getSystemName() {
/* 96 */     return "CachedRendering";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\CachedRenderingSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */