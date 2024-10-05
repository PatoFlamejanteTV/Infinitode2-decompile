/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.shapes.RangeCircle;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.ui.components.MapEditorItemInfoMenu;
/*     */ import com.prineside.tdi2.ui.shared.ItemCreationOverlay;
/*     */ import com.prineside.tdi2.utils.IntRectangle;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(arrayLevels = 2, classOnly = true)
/*     */ public abstract class Tile
/*     */   extends Registrable
/*     */   implements KryoSerializable
/*     */ {
/*     */   public TileType type;
/*     */   protected int a;
/*     */   protected int b;
/*     */   @NAGS
/*     */   public ParticleEffectPool.PooledEffect highlightParticleA;
/*     */   @NAGS
/*     */   public ParticleEffectPool.PooledEffect highlightParticleB;
/*     */   public int enemyCount;
/*     */   private ObjectMap<String, Object> c;
/*     */   @NAGS
/*  52 */   public Vector2 center = new Vector2(); @NAGS
/*  53 */   public final IntRectangle boundingBox = new IntRectangle();
/*     */   @NAGS
/*     */   public boolean visibleOnScreen = true;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  58 */     super.write(paramKryo, paramOutput);
/*  59 */     paramKryo.writeObject(paramOutput, this.type);
/*  60 */     paramOutput.writeVarInt(this.a, true);
/*  61 */     paramOutput.writeVarInt(this.b, true);
/*  62 */     paramOutput.writeVarInt(this.enemyCount, true);
/*  63 */     paramKryo.writeClassAndObject(paramOutput, this.c);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  68 */     super.read(paramKryo, paramInput);
/*  69 */     this.type = (TileType)paramKryo.readObject(paramInput, TileType.class);
/*  70 */     this.a = paramInput.readVarInt(true);
/*  71 */     this.b = paramInput.readVarInt(true);
/*  72 */     this.enemyCount = paramInput.readVarInt(true);
/*  73 */     a();
/*  74 */     this.c = (ObjectMap<String, Object>)paramKryo.readClassAndObject(paramInput);
/*     */   }
/*     */   
/*     */   public Tile(TileType paramTileType) {
/*  78 */     this.type = paramTileType;
/*     */   }
/*     */   
/*     */   public CharSequence getTitle() {
/*  82 */     return Game.i.tileManager.getFactory(this.type).getTitle();
/*     */   }
/*     */   
/*     */   public CharSequence getDescription() {
/*  86 */     return Game.i.tileManager.getFactory(this.type).getDescription();
/*     */   }
/*     */   
/*     */   public boolean canBeSelected() {
/*  90 */     return true;
/*     */   }
/*     */   
/*     */   public boolean affectedByLuckyWheelMultiplier() {
/*  94 */     return true;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public Object getUserData(String paramString) {
/*  99 */     if (this.c != null) {
/* 100 */       return this.c.get(paramString, null);
/*     */     }
/* 102 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUserData(String paramString, @Null Object paramObject) {
/* 107 */     if (paramObject == null) {
/*     */       
/* 109 */       if (this.c != null) {
/* 110 */         this.c.remove(paramString);
/* 111 */         if (this.c.size == 0) {
/* 112 */           this.c = null; return;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 116 */       if (this.c == null) {
/* 117 */         this.c = new ObjectMap();
/*     */       }
/* 119 */       this.c.put(paramString, paramObject);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void getData(IntArray paramIntArray) {}
/*     */ 
/*     */   
/*     */   public abstract RarityType getRarity();
/*     */ 
/*     */   
/*     */   public void from(Tile paramTile) {
/* 132 */     Preconditions.checkNotNull(paramTile, "copyFrom can not be null");
/* 133 */     this.a = paramTile.a;
/* 134 */     this.b = paramTile.b;
/*     */   }
/*     */   
/*     */   public void fillMapEditorMenu(Table paramTable, MapEditorItemInfoMenu paramMapEditorItemInfoMenu) {}
/*     */   
/*     */   public void fillInventoryWithInfo(Table paramTable, float paramFloat) {}
/*     */   
/*     */   public float getWalkCost(boolean paramBoolean) {
/* 142 */     return 1.3421773E8F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawSelectedRange(Batch paramBatch, RangeCircle paramRangeCircle) {}
/*     */ 
/*     */   
/*     */   public void drawHoveredRange(Batch paramBatch, RangeCircle paramRangeCircle) {}
/*     */ 
/*     */   
/*     */   public abstract ItemSubcategoryType getInventorySubcategory();
/*     */ 
/*     */   
/*     */   public void updateCache() {}
/*     */ 
/*     */   
/*     */   public Tile cloneTile() {
/*     */     Tile tile;
/* 160 */     (tile = (Tile)Game.i.tileManager.getFactory(this.type).create()).from(this);
/* 161 */     return tile;
/*     */   }
/*     */   
/*     */   public void setPos(int paramInt1, int paramInt2) {
/* 165 */     this.a = paramInt1;
/* 166 */     this.b = paramInt2;
/*     */     
/* 168 */     a();
/*     */   }
/*     */   
/*     */   public int getX() {
/* 172 */     return this.a;
/*     */   }
/*     */   
/*     */   public int getY() {
/* 176 */     return this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a() {
/* 181 */     int i, j = (i = this.b << 7) + 128;
/*     */     
/* 183 */     int k, m = (k = this.a << 7) + 128;
/*     */     
/* 185 */     this.boundingBox.set(k, m, i, j);
/* 186 */     this.center.set((k + 64), (i + 64));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int generateSeedSalt() {
/* 193 */     return 0;
/*     */   }
/*     */   
/*     */   public abstract int getSortingScore(ItemSortingType paramItemSortingType);
/*     */   
/*     */   public abstract boolean isRoadType();
/*     */   
/*     */   public void drawStatic(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Map paramMap, MapRenderingSystem.DrawMode paramDrawMode) {
/* 201 */     if (isRoadType()) {
/* 202 */       drawRoadStatic(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramMap);
/*     */     }
/*     */   }
/*     */   
/*     */   public void drawRoadStatic(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Map paramMap) {
/* 207 */     Tile tile1 = null, tile2 = null, tile3 = null, tile4 = null;
/* 208 */     if (paramMap != null) {
/* 209 */       tile1 = paramMap.getTile(this.a - 1, this.b);
/* 210 */       tile2 = paramMap.getTile(this.a + 1, this.b);
/* 211 */       tile3 = paramMap.getTile(this.a, this.b - 1);
/* 212 */       tile4 = paramMap.getTile(this.a, this.b + 1);
/*     */     } 
/*     */     
/* 215 */     TextureRegion textureRegion = Game.i.tileManager.getRoadTexture(tile1, tile2, tile4, tile3);
/* 216 */     paramBatch.draw(textureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public void drawExtras(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, MapRenderingSystem.DrawMode paramDrawMode) {}
/*     */   
/*     */   public void drawBatch(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, MapRenderingSystem.DrawMode paramDrawMode) {}
/*     */   
/*     */   public void postDrawBatch(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, MapRenderingSystem.DrawMode paramDrawMode) {}
/*     */   
/*     */   public Rectangle getBoundingBox() {
/* 226 */     return new Rectangle((this.a << 7), (this.b << 7), 128.0F, 128.0F);
/*     */   }
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
/*     */   public abstract Group generateUiIcon(float paramFloat);
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
/*     */   public boolean sameAs(Tile paramTile) {
/* 252 */     if (paramTile == null) return false; 
/* 253 */     return (this.type == paramTile.type);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean sameAsWithExtras(Tile paramTile) {
/* 260 */     return sameAs(paramTile);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Tile removeExtrasForInventory() {
/* 267 */     return this;
/*     */   }
/*     */   
/*     */   public float getValue() {
/* 271 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSellItems(Array<ItemStack> paramArray) {}
/*     */ 
/*     */   
/*     */   public abstract double getPrestigeScore();
/*     */ 
/*     */   
/*     */   public boolean canBeSold() {
/* 282 */     return true;
/*     */   }
/*     */   public boolean canBeUpgraded() {
/* 285 */     return false;
/*     */   }
/*     */   public Tile createUpgradedTile() {
/* 288 */     throw new IllegalStateException("Not implemented");
/*     */   }
/* 290 */   public int getUpgradePriceInGreenPapers() { return 0; }
/* 291 */   public int getUpgradePriceInAccelerators() { return 1; } public int getUpgradePriceInResources(ResourceType paramResourceType) {
/* 292 */     return 0;
/*     */   }
/*     */   public void fillItemCreationForm(ItemCreationOverlay paramItemCreationOverlay) {}
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 297 */     paramJson.writeValue("type", this.type.name());
/* 298 */     if (this.a != 0) paramJson.writeValue("x", Integer.valueOf(this.a)); 
/* 299 */     if (this.b != 0) paramJson.writeValue("y", Integer.valueOf(this.b));
/*     */   
/*     */   }
/*     */   
/*     */   public String toString() {
/* 304 */     return this.type.name() + " (" + this.a + ":" + this.b + ")";
/*     */   }
/*     */   
/*     */   public static interface Factory<T extends Tile>
/*     */     extends Disposable, EntityFactory {
/*     */     void setup();
/*     */     
/*     */     String getTitle();
/*     */     
/*     */     String getDescription();
/*     */     
/*     */     int getProbabilityForPrize(float param1Float, ProgressManager.InventoryStatistics param1InventoryStatistics);
/*     */     
/*     */     T create();
/*     */     
/*     */     T createRandom(float param1Float, RandomXS128 param1RandomXS128);
/*     */     
/*     */     T fromJson(JsonValue param1JsonValue);
/*     */     
/*     */     public static abstract class AbstractFactory<T extends Tile>
/*     */       implements Factory<T> {
/*     */       private final String a;
/*     */       private final String b;
/*     */       
/*     */       public AbstractFactory(TileType param2TileType) {
/* 329 */         this.a = "tile_name_" + param2TileType.name();
/* 330 */         this.b = "tile_description_" + param2TileType.name();
/*     */       }
/*     */ 
/*     */       
/*     */       public String getTitle() {
/* 335 */         return Game.i.localeManager.i18n.get(this.a);
/*     */       }
/*     */ 
/*     */       
/*     */       public String getDescription() {
/* 340 */         return Game.i.localeManager.i18n.get(this.b);
/*     */       }
/*     */ 
/*     */       
/*     */       public T createRandom(float param2Float, RandomXS128 param2RandomXS128) {
/* 345 */         return create();
/*     */       }
/*     */ 
/*     */       
/*     */       public void setup() {
/* 350 */         if (Game.i.assetManager != null) {
/* 351 */           setupAssets();
/*     */         }
/*     */       }
/*     */ 
/*     */       
/*     */       public void setupAssets() {}
/*     */       
/*     */       public T fromJson(JsonValue param2JsonValue) {
/* 359 */         T t = create();
/* 360 */         int j = param2JsonValue.getInt("x", 0);
/* 361 */         int i = param2JsonValue.getInt("y", 0);
/* 362 */         t.setPos(j, i);
/*     */         
/* 364 */         return t;
/*     */       }
/*     */       
/*     */       public void dispose() {}
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class Pos
/*     */     implements KryoSerializable, MapElementPos
/*     */   {
/*     */     private int a;
/*     */     private int b;
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 379 */       param1Output.writeVarInt(this.a, true);
/* 380 */       param1Output.writeVarInt(this.b, true);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 385 */       this.a = param1Input.readVarInt(true);
/* 386 */       this.b = param1Input.readVarInt(true);
/*     */     }
/*     */     
/*     */     public Pos() {}
/*     */     
/*     */     public Pos(Pos param1Pos) {
/* 392 */       this(param1Pos.getX(), param1Pos.getY());
/*     */     }
/*     */     
/*     */     public Pos(Tile param1Tile) {
/* 396 */       this(param1Tile.getX(), param1Tile.getY());
/*     */     }
/*     */     
/*     */     public Pos(int param1Int1, int param1Int2) {
/* 400 */       this.a = param1Int1;
/* 401 */       this.b = param1Int2;
/*     */     }
/*     */     
/*     */     public void set(Pos param1Pos) {
/* 405 */       Preconditions.checkNotNull(param1Pos);
/* 406 */       this.a = param1Pos.getX();
/* 407 */       this.b = param1Pos.getY();
/*     */     }
/*     */     
/*     */     public int getX() {
/* 411 */       return this.a;
/*     */     }
/*     */     
/*     */     public void setX(int param1Int) {
/* 415 */       this.a = param1Int;
/*     */     }
/*     */     
/*     */     public int getY() {
/* 419 */       return this.b;
/*     */     }
/*     */     
/*     */     public void setY(int param1Int) {
/* 423 */       this.b = param1Int;
/*     */     }
/*     */     
/*     */     public boolean is(int param1Int1, int param1Int2) {
/* 427 */       return (param1Int1 == this.a && param1Int2 == this.b);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 432 */       return super.toString() + " (" + this.a + ":" + this.b + ")";
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 437 */       if (param1Object == this)
/* 438 */         return true; 
/* 439 */       if (!(param1Object instanceof Pos)) {
/* 440 */         return false;
/*     */       }
/* 442 */       if (((Pos)(param1Object = param1Object)).a == this.a && ((Pos)param1Object).b == this.b) return true;  return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 448 */       int i = 961 + this.a;
/*     */       
/* 450 */       return i = i * 31 + this.b;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Tile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */