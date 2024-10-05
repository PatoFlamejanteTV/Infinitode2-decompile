/*     */ package com.prineside.tdi2.managers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.tiles.BossTile;
/*     */ import com.prineside.tdi2.tiles.CoreTile;
/*     */ import com.prineside.tdi2.tiles.DummyTile;
/*     */ import com.prineside.tdi2.tiles.EqualizerTile;
/*     */ import com.prineside.tdi2.tiles.GameValueTile;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.tiles.QuadTile;
/*     */ import com.prineside.tdi2.tiles.RoadTile;
/*     */ import com.prineside.tdi2.tiles.ScriptTile;
/*     */ import com.prineside.tdi2.tiles.SourceTile;
/*     */ import com.prineside.tdi2.tiles.SpawnTile;
/*     */ import com.prineside.tdi2.tiles.TargetTile;
/*     */ import com.prineside.tdi2.tiles.XmMusicTrackTile;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = TileManager.Serializer.class)
/*     */ public class TileManager extends Manager.ManagerAdapter {
/*     */   public static class Serializer extends SingletonSerializer<TileManager> {
/*     */     public TileManager read() {
/*  31 */       return Game.i.tileManager;
/*     */     } }
/*     */   
/*  34 */   public final Factories F = new Factories();
/*     */   
/*     */   public static class Factories {
/*     */     public RoadTile.RoadTileFactory ROAD;
/*     */     public PlatformTile.SpaceTileFactory PLATFORM;
/*     */     public SpawnTile.SpawnTileFactory SPAWN;
/*     */     public TargetTile.TargetTileFactory TARGET;
/*     */     public SourceTile.SourceTileFactory SOURCE;
/*     */     public XmMusicTrackTile.XmMusicTrackTileFactory XM_MUSIC_TRACK;
/*     */     public CoreTile.CoreTileFactory CORE;
/*     */     public GameValueTile.GameValueTileFactory GAME_VALUE;
/*     */     public ScriptTile.ScriptTileFactory SCRIPT;
/*     */     public BossTile.BossTileFactory BOSS;
/*     */     public DummyTile.DummyTileFactory DUMMY;
/*     */     public QuadTile.QuadTileFactory QUAD;
/*     */     public EqualizerTile.EqualizerTileFactory EQUALIZER;
/*     */   }
/*  51 */   private final Tile.Factory[] a = new Tile.Factory[TileType.values.length];
/*  52 */   private final TextureRegion[] b = new TextureRegion[16];
/*     */   
/*     */   public TileManager() {
/*  55 */     this.a[TileType.ROAD.ordinal()] = (Tile.Factory)(this.F.ROAD = new RoadTile.RoadTileFactory());
/*  56 */     this.a[TileType.PLATFORM.ordinal()] = (Tile.Factory)(this.F.PLATFORM = new PlatformTile.SpaceTileFactory());
/*  57 */     this.a[TileType.SPAWN.ordinal()] = (Tile.Factory)(this.F.SPAWN = new SpawnTile.SpawnTileFactory());
/*  58 */     this.a[TileType.TARGET.ordinal()] = (Tile.Factory)(this.F.TARGET = new TargetTile.TargetTileFactory());
/*  59 */     this.a[TileType.SOURCE.ordinal()] = (Tile.Factory)(this.F.SOURCE = new SourceTile.SourceTileFactory());
/*  60 */     this.a[TileType.XM_MUSIC_TRACK.ordinal()] = (Tile.Factory)(this.F.XM_MUSIC_TRACK = new XmMusicTrackTile.XmMusicTrackTileFactory());
/*  61 */     this.a[TileType.CORE.ordinal()] = (Tile.Factory)(this.F.CORE = new CoreTile.CoreTileFactory());
/*  62 */     this.a[TileType.GAME_VALUE.ordinal()] = (Tile.Factory)(this.F.GAME_VALUE = new GameValueTile.GameValueTileFactory());
/*  63 */     this.a[TileType.BOSS.ordinal()] = (Tile.Factory)(this.F.BOSS = new BossTile.BossTileFactory());
/*  64 */     this.a[TileType.SCRIPT.ordinal()] = (Tile.Factory)(this.F.SCRIPT = new ScriptTile.ScriptTileFactory());
/*  65 */     this.a[TileType.DUMMY.ordinal()] = (Tile.Factory)(this.F.DUMMY = new DummyTile.DummyTileFactory());
/*  66 */     this.a[TileType.QUAD.ordinal()] = (Tile.Factory)(this.F.QUAD = new QuadTile.QuadTileFactory());
/*  67 */     this.a[TileType.EQUALIZER.ordinal()] = (Tile.Factory)(this.F.EQUALIZER = new EqualizerTile.EqualizerTileFactory()); TileType[] arrayOfTileType; int i;
/*     */     byte b;
/*  69 */     for (i = (arrayOfTileType = TileType.values).length, b = 0; b < i; ) { TileType tileType = arrayOfTileType[b];
/*  70 */       if (this.a[tileType.ordinal()] == null) {
/*  71 */         throw new RuntimeException("Not all tile factories were created");
/*     */       }
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void setup() {
/*  79 */     if (Game.i.assetManager != null)
/*  80 */       for (byte b1 = 0; b1 < 16; b1++) {
/*  81 */         String str = "";
/*  82 */         str = str + (((b1 & 0x8) != 0) ? "x" : "o");
/*  83 */         str = str + (((b1 & 0x4) != 0) ? "x" : "o");
/*  84 */         str = str + (((b1 & 0x2) != 0) ? "x" : "o");
/*  85 */         str = str + (((b1 & 0x1) != 0) ? "x" : "o");
/*  86 */         this.b[b1] = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-road-" + str);
/*     */       }   Tile.Factory[] arrayOfFactory;
/*     */     int i;
/*     */     byte b;
/*  90 */     for (i = (arrayOfFactory = this.a).length, b = 0; b < i; b++) {
/*  91 */       Tile.Factory factory; (factory = arrayOfFactory[b]).setup();
/*     */     } 
/*     */   }
/*     */   
/*     */   public Tile.Factory<? extends Tile> getFactory(TileType paramTileType) {
/*  96 */     return this.a[paramTileType.ordinal()];
/*     */   }
/*     */   
/*     */   public Tile createTileFromJsonString(String paramString) {
/* 100 */     return createTileFromJson((new JsonReader()).parse(paramString));
/*     */   }
/*     */   
/*     */   public Tile createTileFromJson(JsonValue paramJsonValue) {
/* 104 */     if (!paramJsonValue.isObject()) {
/* 105 */       throw new IllegalArgumentException("JsonValue must be an object");
/*     */     }
/*     */     
/* 108 */     TileType tileType = TileType.valueOf(paramJsonValue.getString("type"));
/*     */     
/* 110 */     return getFactory(tileType).fromJson(paramJsonValue);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public Tile[][] createTileArrayFromJson(JsonValue paramJsonValue, boolean paramBoolean) {
/* 115 */     if (!paramJsonValue.isObject()) {
/* 116 */       throw new IllegalArgumentException("JsonValue must be an object");
/*     */     }
/*     */     
/* 119 */     int i = paramJsonValue.getInt("width");
/* 120 */     int j = paramJsonValue.getInt("height");
/* 121 */     paramJsonValue = paramJsonValue.get("tiles");
/*     */     
/* 123 */     Tile[][] arrayOfTile = new Tile[j][i];
/* 124 */     for (JsonValue.JsonIterator<JsonValue> jsonIterator = paramJsonValue.iterator(); jsonIterator.hasNext(); ) {
/* 125 */       JsonValue jsonValue; int k = (jsonValue = jsonIterator.next()).getInt("x");
/* 126 */       int m = jsonValue.getInt("y");
/*     */       
/* 128 */       if (paramBoolean) {
/* 129 */         m = j - m - 1;
/*     */       }
/*     */       
/* 132 */       if (arrayOfTile[m][k] == null) {
/* 133 */         arrayOfTile[m][k] = createTileFromJson(jsonValue); continue;
/*     */       } 
/* 135 */       throw new IllegalArgumentException("Duplicate tile " + k + ":" + m);
/*     */     } 
/*     */ 
/*     */     
/* 139 */     return arrayOfTile;
/*     */   }
/*     */   
/*     */   public TextureRegion getRoadTexture(Tile paramTile1, Tile paramTile2, Tile paramTile3, Tile paramTile4) {
/* 143 */     byte b = 0;
/* 144 */     if (paramTile3 != null && paramTile3.isRoadType()) b += true; 
/* 145 */     if (paramTile2 != null && paramTile2.isRoadType()) b += true; 
/* 146 */     if (paramTile4 != null && paramTile4.isRoadType()) b += true; 
/* 147 */     if (paramTile1 != null && paramTile1.isRoadType()) b++;
/*     */     
/* 149 */     return this.b[b];
/*     */   }
/*     */   
/*     */   public Tile createRandomTile(float paramFloat, RandomXS128 paramRandomXS128, ProgressManager.InventoryStatistics paramInventoryStatistics) {
/* 153 */     if (paramFloat < 0.0F) {
/* 154 */       paramFloat = 0.0F;
/* 155 */     } else if (paramFloat > 1.0F) {
/* 156 */       paramFloat = 1.0F;
/*     */     } 
/*     */     
/* 159 */     int i = 0; Tile.Factory[] arrayOfFactory1; int m;
/* 160 */     for (int k = (arrayOfFactory1 = this.a).length; m < k; ) { Tile.Factory factory = arrayOfFactory1[m];
/* 161 */       i += factory.getProbabilityForPrize(paramFloat, paramInventoryStatistics);
/*     */       m++; }
/*     */     
/* 164 */     int j = paramRandomXS128.nextInt(i + 1); Tile.Factory[] arrayOfFactory2;
/*     */     byte b;
/* 166 */     for (m = (arrayOfFactory2 = this.a).length, b = 0; b < m; b++) {
/* 167 */       Tile.Factory factory; int n = (factory = arrayOfFactory2[b]).getProbabilityForPrize(paramFloat, paramInventoryStatistics);
/*     */       
/* 169 */       if ((j = j - n) <= 0 && n > 0) {
/*     */         Tile tile;
/* 171 */         if ((tile = factory.createRandom(paramFloat, paramRandomXS128)) != null) {
/* 172 */           return tile;
/*     */         }
/*     */         
/* 175 */         return createRandomTile(paramFloat, paramRandomXS128, paramInventoryStatistics);
/*     */       } 
/*     */     } 
/*     */     
/* 179 */     return null;
/*     */   }
/*     */   
/*     */   public void dispose() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\TileManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */