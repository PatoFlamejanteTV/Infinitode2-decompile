/*    */ package com.badlogic.gdx.maps.tiled;
/*    */ 
/*    */ import com.badlogic.gdx.maps.Map;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.Disposable;
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
/*    */ public class TiledMap
/*    */   extends Map
/*    */ {
/*    */   private TiledMapTileSets tilesets;
/*    */   private Array<? extends Disposable> ownedResources;
/*    */   
/*    */   public TiledMapTileSets getTileSets() {
/* 33 */     return this.tilesets;
/*    */   }
/*    */ 
/*    */   
/*    */   public TiledMap() {
/* 38 */     this.tilesets = new TiledMapTileSets();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setOwnedResources(Array<? extends Disposable> paramArray) {
/* 45 */     this.ownedResources = paramArray;
/*    */   }
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 50 */     if (this.ownedResources != null)
/* 51 */       for (Array.ArrayIterator<Disposable> arrayIterator = this.ownedResources.iterator(); arrayIterator.hasNext();)
/* 52 */         (disposable = arrayIterator.next()).dispose();  
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\TiledMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */