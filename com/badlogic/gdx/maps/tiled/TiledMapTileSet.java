/*    */ package com.badlogic.gdx.maps.tiled;
/*    */ 
/*    */ import com.badlogic.gdx.maps.MapProperties;
/*    */ import com.badlogic.gdx.utils.IntMap;
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
/*    */ public class TiledMapTileSet
/*    */   implements Iterable<TiledMapTile>
/*    */ {
/*    */   private String name;
/*    */   private IntMap<TiledMapTile> tiles;
/*    */   private MapProperties properties;
/*    */   
/*    */   public String getName() {
/* 34 */     return this.name;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setName(String paramString) {
/* 39 */     this.name = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public MapProperties getProperties() {
/* 44 */     return this.properties;
/*    */   }
/*    */ 
/*    */   
/*    */   public TiledMapTileSet() {
/* 49 */     this.tiles = new IntMap();
/* 50 */     this.properties = new MapProperties();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TiledMapTile getTile(int paramInt) {
/* 58 */     return (TiledMapTile)this.tiles.get(paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Iterator<TiledMapTile> iterator() {
/* 64 */     return this.tiles.values().iterator();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void putTile(int paramInt, TiledMapTile paramTiledMapTile) {
/* 72 */     this.tiles.put(paramInt, paramTiledMapTile);
/*    */   }
/*    */ 
/*    */   
/*    */   public void removeTile(int paramInt) {
/* 77 */     this.tiles.remove(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public int size() {
/* 82 */     return this.tiles.size;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\TiledMapTileSet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */