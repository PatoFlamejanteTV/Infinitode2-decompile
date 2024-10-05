/*    */ package com.badlogic.gdx.maps.tiled;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import java.util.Iterator;
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
/*    */ public class TiledMapTileSets
/*    */   implements Iterable<TiledMapTileSet>
/*    */ {
/* 30 */   private Array<TiledMapTileSet> tilesets = new Array();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TiledMapTileSet getTileSet(int paramInt) {
/* 36 */     return (TiledMapTileSet)this.tilesets.get(paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public TiledMapTileSet getTileSet(String paramString) {
/* 42 */     for (Array.ArrayIterator<TiledMapTileSet> arrayIterator = this.tilesets.iterator(); arrayIterator.hasNext(); ) { TiledMapTileSet tiledMapTileSet = arrayIterator.next();
/* 43 */       if (paramString.equals(tiledMapTileSet.getName())) {
/* 44 */         return tiledMapTileSet;
/*    */       } }
/*    */     
/* 47 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void addTileSet(TiledMapTileSet paramTiledMapTileSet) {
/* 52 */     this.tilesets.add(paramTiledMapTileSet);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void removeTileSet(int paramInt) {
/* 59 */     this.tilesets.removeIndex(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public void removeTileSet(TiledMapTileSet paramTiledMapTileSet) {
/* 64 */     this.tilesets.removeValue(paramTiledMapTileSet, true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TiledMapTile getTile(int paramInt) {
/* 76 */     for (int i = this.tilesets.size - 1; i >= 0; i--) {
/*    */       TiledMapTile tiledMapTile;
/*    */       TiledMapTileSet tiledMapTileSet;
/* 79 */       if ((tiledMapTile = (tiledMapTileSet = (TiledMapTileSet)this.tilesets.get(i)).getTile(paramInt)) != null) {
/* 80 */         return tiledMapTile;
/*    */       }
/*    */     } 
/* 83 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Iterator<TiledMapTileSet> iterator() {
/* 89 */     return (Iterator<TiledMapTileSet>)this.tilesets.iterator();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\TiledMapTileSets.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */