/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.items.TileItem;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public class UserMap {
/*  14 */   private static final TLog a = TLog.forClass(UserMap.class);
/*     */   
/*     */   public String id;
/*     */   public String name;
/*     */   public long creationTimestamp;
/*     */   public Map map;
/*     */   public boolean submittedOnline;
/*     */   
/*     */   public UserMap cpy() {
/*     */     UserMap userMap;
/*  24 */     (userMap = new UserMap()).id = this.id;
/*  25 */     userMap.name = this.name;
/*  26 */     userMap.creationTimestamp = this.creationTimestamp;
/*  27 */     userMap.map = this.map.cpy();
/*  28 */     userMap.submittedOnline = this.submittedOnline;
/*  29 */     return userMap;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UserMap(String paramString) {
/*  35 */     this.id = "M-" + FastRandom.generateUniqueDistinguishableId();
/*  36 */     this.name = paramString;
/*  37 */     this.creationTimestamp = Game.getTimestampMillis();
/*  38 */     this.map = new Map(Game.i.userMapManager.getMaxMapSize(), Game.i.userMapManager.getMaxMapSize());
/*     */ 
/*     */     
/*  41 */     int i = this.map.getWidth() / 2 - 1;
/*  42 */     int j = this.map.getHeight() / 2 - 1;
/*     */     
/*  44 */     Tile tile1 = null;
/*  45 */     Tile tile2 = null;
/*     */     
/*  47 */     DelayedRemovalArray delayedRemovalArray = Game.i.progressManager.getItemsByType(ItemType.TILE);
/*  48 */     for (byte b = 0; b < delayedRemovalArray.size; b++) {
/*     */       Tile tile;
/*  50 */       if ((tile = ((TileItem)((ItemStack)delayedRemovalArray.get(b)).getItem()).tile).type == TileType.SPAWN) {
/*  51 */         tile1 = tile;
/*  52 */       } else if (tile.type == TileType.TARGET) {
/*  53 */         tile2 = tile;
/*     */       } 
/*     */     } 
/*     */     
/*  57 */     this.map.setTile(i, j, tile1);
/*  58 */     this.map.setTile(i + 1, j, tile2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private UserMap() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeUnexistentTilesFromMap() {
/*  68 */     boolean bool = false;
/*     */     
/*  70 */     Array array = new Array();
/*  71 */     DelayedRemovalArray delayedRemovalArray = Game.i.progressManager.getItemsByType(ItemType.TILE); byte b;
/*  72 */     for (b = 0; b < delayedRemovalArray.size; b++) {
/*  73 */       array.add(((ItemStack)delayedRemovalArray.get(b)).cpy());
/*     */     }
/*     */     
/*  76 */     for (b = 0; b < this.map.getHeight(); b++) {
/*  77 */       for (byte b1 = 0; b1 < this.map.getWidth(); b1++) {
/*     */         Tile tile;
/*  79 */         if ((tile = this.map.getTile(b1, b)) != null) {
/*     */           
/*  81 */           boolean bool1 = false;
/*  82 */           for (byte b2 = 0; b2 < array.size; b2++) {
/*     */             ItemStack itemStack;
/*     */             TileItem tileItem;
/*  85 */             if ((tileItem = (TileItem)(itemStack = (ItemStack)array.get(b2)).getItem()).tile.sameAs(tile)) {
/*  86 */               if (itemStack.getCount() > 0) {
/*  87 */                 itemStack.setCount(itemStack.getCount() - 1);
/*  88 */                 bool1 = true;
/*     */               } 
/*     */               break;
/*     */             } 
/*     */           } 
/*  93 */           if (!bool1) {
/*  94 */             bool = true;
/*  95 */             this.map.setTile(b1, b, null);
/*  96 */             a.i("removed tile at " + b1 + ":" + b + " (" + tile.toString() + ")", new Object[0]);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 101 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 108 */     paramJson.writeValue("id", this.id);
/* 109 */     paramJson.writeValue("name", this.name);
/* 110 */     paramJson.writeValue("creationTimestamp", Long.valueOf(this.creationTimestamp));
/* 111 */     paramJson.writeValue("submittedOnline", Boolean.valueOf(this.submittedOnline));
/* 112 */     paramJson.writeObjectStart("map");
/* 113 */     this.map.toJson(paramJson);
/* 114 */     paramJson.writeObjectEnd();
/*     */   }
/*     */   
/*     */   public static UserMap fromJson(JsonValue paramJsonValue) {
/*     */     UserMap userMap;
/* 119 */     (userMap = new UserMap()).id = paramJsonValue.getString("id");
/* 120 */     userMap.name = paramJsonValue.getString("name");
/* 121 */     userMap.creationTimestamp = paramJsonValue.getLong("creationTimestamp");
/* 122 */     userMap.submittedOnline = paramJsonValue.getBoolean("submittedOnline");
/* 123 */     userMap.map = Map.fromJson(paramJsonValue.get("map"));
/*     */     
/* 125 */     return userMap;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\UserMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */