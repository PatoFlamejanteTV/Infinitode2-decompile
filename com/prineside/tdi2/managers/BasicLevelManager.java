/*      */ package com.prineside.tdi2.managers;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.files.FileHandle;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.RandomXS128;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*      */ import com.badlogic.gdx.utils.Json;
/*      */ import com.badlogic.gdx.utils.JsonReader;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.JsonWriter;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.ObjectMap;
/*      */ import com.badlogic.gdx.utils.ObjectSet;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.prineside.tdi2.BasicLevel;
/*      */ import com.prineside.tdi2.BasicLevelQuestConfig;
/*      */ import com.prineside.tdi2.BasicLevelStage;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameSystemProvider;
/*      */ import com.prineside.tdi2.IssuedItems;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Manager;
/*      */ import com.prineside.tdi2.Map;
/*      */ import com.prineside.tdi2.Requirement;
/*      */ import com.prineside.tdi2.Tile;
/*      */ import com.prineside.tdi2.enums.AchievementType;
/*      */ import com.prineside.tdi2.enums.BasicLevelLootBonusType;
/*      */ import com.prineside.tdi2.enums.DifficultyMode;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.MinerType;
/*      */ import com.prineside.tdi2.enums.ResourceType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.enums.StatisticsType;
/*      */ import com.prineside.tdi2.items.ResourceItem;
/*      */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*      */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_BasicLevel;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*      */ import com.prineside.tdi2.tiles.PlatformTile;
/*      */ import com.prineside.tdi2.tiles.SourceTile;
/*      */ import com.prineside.tdi2.ui.shared.Notifications;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.ObjectPair;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.io.StringWriter;
/*      */ import java.util.concurrent.atomic.AtomicInteger;
/*      */ 
/*      */ @REGS(serializer = BasicLevelManager.Serializer.class)
/*      */ public class BasicLevelManager
/*      */   extends Manager.ManagerAdapter
/*      */ {
/*   58 */   private static final TLog a = TLog.forClass(BasicLevelManager.class); public static final int PREVIEW_WIDTH = 310;
/*      */   public static final int PREVIEW_HEIGHT = 230;
/*      */   
/*      */   public static class Serializer extends SingletonSerializer<BasicLevelManager> { public BasicLevelManager read() {
/*   62 */       return Game.i.basicLevelManager;
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   68 */   public ObjectMap<String, float[]> resourceBonusLevelMultipliers = new ObjectMap(); public final Array<BasicLevelStage> stagesOrdered; private final ObjectMap<String, BasicLevelStage> b; public final Array<String> defaultLevelNames; public final Array<BasicLevel> levelsOrdered;
/*      */   public BasicLevelManager() {
/*      */     ObjectMap<String, float[]> objectMap;
/*   71 */     (objectMap = this.resourceBonusLevelMultipliers).put("1.1", new float[] { 3.5F, 0.0F, 0.0F, 0.0F, 0.0F });
/*   72 */     objectMap.put("1.2", new float[] { 3.0F, 0.0F, 0.0F, 3.0F, 0.0F });
/*   73 */     objectMap.put("1.3", new float[] { 3.5F, 3.5F, 0.0F, 0.0F, 3.0F });
/*   74 */     objectMap.put("1.4", new float[] { 0.0F, 0.0F, 0.0F, 3.5F, 3.5F });
/*   75 */     objectMap.put("1.5", new float[] { 3.5F, 0.0F, 0.0F, 3.5F, 0.0F });
/*   76 */     objectMap.put("1.6", new float[] { 2.5F, 3.0F, 0.0F, 0.0F, 0.0F });
/*   77 */     objectMap.put("1.7", new float[] { 3.0F, 3.0F, 0.0F, 0.0F, 0.0F });
/*   78 */     objectMap.put("1.8", new float[] { 3.0F, 3.5F, 0.0F, 0.0F, 0.0F });
/*   79 */     objectMap.put("2.1", new float[] { 3.0F, 3.5F, 3.5F, 0.0F, 0.0F });
/*   80 */     objectMap.put("2.2", new float[] { 0.0F, 0.0F, 3.0F, 0.0F, 0.0F });
/*   81 */     objectMap.put("2.3", new float[] { 3.5F, 3.0F, 3.5F, 0.0F, 0.0F });
/*   82 */     objectMap.put("2.4", new float[] { 3.0F, 2.5F, 3.0F, 0.0F, 0.0F });
/*   83 */     objectMap.put("2.5", new float[] { 3.0F, 2.5F, 3.0F, 0.0F, 0.0F });
/*   84 */     objectMap.put("2.6", new float[] { 0.0F, 3.0F, 0.0F, 3.0F, 3.5F });
/*   85 */     objectMap.put("2.7", new float[] { 3.0F, 3.0F, 3.0F, 0.0F, 3.5F });
/*   86 */     objectMap.put("2.8", new float[] { 3.5F, 3.0F, 3.0F, 0.0F, 0.0F });
/*   87 */     objectMap.put("3.1", new float[] { 3.5F, 3.0F, 3.5F, 0.0F, 3.0F });
/*   88 */     objectMap.put("3.2", new float[] { 0.0F, 2.5F, 0.0F, 0.0F, 0.0F });
/*   89 */     objectMap.put("3.3", new float[] { 3.0F, 3.5F, 0.0F, 3.0F, 0.0F });
/*   90 */     objectMap.put("3.4", new float[] { 3.5F, 2.5F, 3.5F, 0.0F, 0.0F });
/*   91 */     objectMap.put("3.5", new float[] { 3.0F, 3.5F, 0.0F, 0.0F, 0.0F });
/*   92 */     objectMap.put("3.6", new float[] { 3.0F, 0.0F, 0.0F, 0.0F, 0.0F });
/*   93 */     objectMap.put("3.7", new float[] { 3.5F, 0.0F, 2.5F, 0.0F, 0.0F });
/*   94 */     objectMap.put("3.8", new float[] { 3.0F, 0.0F, 3.0F, 3.5F, 0.0F });
/*   95 */     objectMap.put("4.1", new float[] { 3.0F, 3.0F, 2.0F, 3.5F, 3.5F });
/*   96 */     objectMap.put("4.2", new float[] { 3.0F, 3.5F, 2.5F, 2.5F, 3.0F });
/*   97 */     objectMap.put("4.3", new float[] { 3.5F, 2.5F, 0.0F, 3.0F, 3.0F });
/*   98 */     objectMap.put("4.4", new float[] { 3.0F, 3.0F, 3.5F, 3.5F, 3.5F });
/*   99 */     objectMap.put("4.5", new float[] { 3.0F, 3.0F, 3.0F, 3.0F, 0.0F });
/*  100 */     objectMap.put("4.6", new float[] { 3.0F, 3.5F, 2.5F, 3.0F, 3.0F });
/*  101 */     objectMap.put("4.7", new float[] { 0.0F, 3.0F, 3.0F, 3.5F, 3.5F });
/*  102 */     objectMap.put("4.8", new float[] { 3.5F, 3.5F, 3.5F, 2.5F, 3.0F });
/*  103 */     objectMap.put("5.1", new float[] { 3.0F, 3.0F, 3.0F, 3.0F, 2.5F });
/*  104 */     objectMap.put("5.2", new float[] { 3.5F, 3.0F, 2.5F, 2.5F, 3.0F });
/*  105 */     objectMap.put("5.3", new float[] { 2.5F, 2.5F, 2.0F, 3.0F, 2.5F });
/*  106 */     objectMap.put("5.4", new float[] { 0.0F, 3.0F, 2.5F, 3.0F, 2.5F });
/*  107 */     objectMap.put("5.5", new float[] { 2.0F, 2.0F, 3.0F, 3.0F, 3.0F });
/*  108 */     objectMap.put("5.6", new float[] { 3.5F, 0.0F, 2.5F, 2.0F, 3.0F });
/*  109 */     objectMap.put("5.7", new float[] { 0.0F, 3.5F, 3.0F, 2.5F, 3.0F });
/*  110 */     objectMap.put("5.8", new float[] { 0.0F, 2.0F, 2.0F, 3.0F, 3.0F });
/*  111 */     objectMap.put("6.1", new float[] { 3.5F, 0.0F, 0.0F, 3.5F, 3.5F });
/*  112 */     objectMap.put("6.2", new float[] { 3.0F, 0.0F, 0.0F, 0.0F, 3.5F });
/*  113 */     objectMap.put("6.3", new float[] { 3.5F, 3.5F, 2.5F, 2.5F, 2.5F });
/*  114 */     objectMap.put("6.4", new float[] { 3.5F, 0.0F, 3.0F, 2.5F, 2.5F });
/*  115 */     objectMap.put("6.5", new float[] { 0.0F, 3.0F, 0.0F, 0.0F, 2.0F });
/*  116 */     objectMap.put("6.6", new float[] { 2.5F, 3.0F, 3.0F, 3.0F, 3.5F });
/*      */ 
/*      */     
/*  119 */     this.stagesOrdered = new Array(BasicLevelStage.class);
/*  120 */     this.b = new ObjectMap();
/*      */     
/*  122 */     this.defaultLevelNames = new Array(String.class);
/*  123 */     this.levelsOrdered = new Array(BasicLevel.class);
/*  124 */     this.c = new ObjectMap();
/*      */     
/*  126 */     this.d = new ObjectMap();
/*      */ 
/*      */ 
/*      */     
/*  130 */     this.f = new DelayedRemovalArray(false, 1);
/*      */ 
/*      */ 
/*      */     
/*      */     JsonValue jsonValue;
/*      */ 
/*      */     
/*  137 */     for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(AssetManager.localOrInternalFile("res/basic-level-stages.json"))).iterator(); jsonIterator.hasNext(); ) {
/*  138 */       JsonValue jsonValue1; BasicLevelStage basicLevelStage = BasicLevelStage.fromJson(jsonValue1 = jsonIterator.next());
/*  139 */       if (this.b.containsKey(basicLevelStage.name)) {
/*  140 */         throw new RuntimeException("Stage with name " + basicLevelStage.name + " already exists");
/*      */       }
/*      */       
/*  143 */       this.b.put(basicLevelStage.name, basicLevelStage);
/*  144 */       this.stagesOrdered.add(basicLevelStage);
/*      */     } 
/*      */ 
/*      */     
/*  148 */     this.defaultLevelNames.clear(); int i;
/*      */     FileHandle[] arrayOfFileHandle1, arrayOfFileHandle2;
/*  150 */     for (int j = (arrayOfFileHandle2 = arrayOfFileHandle1 = Gdx.files.internal("levels").list(".json")).length; i < j; ) { FileHandle fileHandle = arrayOfFileHandle2[i];
/*  151 */       this.defaultLevelNames.add(fileHandle.nameWithoutExtension()); i++; }
/*      */      FileHandle[] arrayOfFileHandle3;
/*      */     byte b2;
/*  154 */     for (i = (arrayOfFileHandle3 = arrayOfFileHandle2 = Gdx.files.local("levels").list(".json")).length, b2 = 0; b2 < i; ) { FileHandle fileHandle = arrayOfFileHandle3[b2];
/*  155 */       if (!this.defaultLevelNames.contains(fileHandle.nameWithoutExtension(), false))
/*  156 */         this.defaultLevelNames.add(fileHandle.nameWithoutExtension()); 
/*      */       b2++; }
/*      */     
/*  159 */     this.defaultLevelNames.sort(String::compareTo);
/*      */ 
/*      */     
/*  162 */     for (Array.ArrayIterator<String> arrayIterator = this.defaultLevelNames.iterator(); arrayIterator.hasNext(); ) { String str = arrayIterator.next();
/*  163 */       loadAndRegisterLevelFromJson((new JsonReader()).parse(AssetManager.localOrInternalFile("levels/" + str + ".json").readString("UTF-8"))); }
/*      */ 
/*      */     
/*  166 */     for (byte b1 = 0; b1 < this.stagesOrdered.size; b1++) {
/*  167 */       ((BasicLevelStage[])this.stagesOrdered.items)[b1].sortLevels();
/*      */     }
/*      */ 
/*      */     
/*  171 */     ObjectSet objectSet = new ObjectSet();
/*  172 */     for (i = 0; i < this.levelsOrdered.size; i++) {
/*  173 */       BasicLevel basicLevel = (BasicLevel)this.levelsOrdered.get(i); byte b;
/*  174 */       for (b = 0; b < basicLevel.quests.size; b++) {
/*  175 */         BasicLevelQuestConfig basicLevelQuestConfig = (BasicLevelQuestConfig)basicLevel.quests.get(b);
/*  176 */         if (objectSet.contains(basicLevelQuestConfig.getId())) {
/*  177 */           throw new RuntimeException("Duplicate quest id " + basicLevelQuestConfig.getId());
/*      */         }
/*  179 */         objectSet.add(basicLevelQuestConfig.getId());
/*      */       } 
/*  181 */       for (b = 0; b < basicLevel.waveQuests.size; b++) {
/*  182 */         BasicLevel.WaveQuest waveQuest = (BasicLevel.WaveQuest)basicLevel.waveQuests.get(b);
/*  183 */         if (objectSet.contains(waveQuest.id)) {
/*  184 */           throw new RuntimeException("Duplicate quest id " + waveQuest.id);
/*      */         }
/*  186 */         objectSet.add(waveQuest.id);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  191 */     this.e = 0;
/*  192 */     for (i = 0; i < this.levelsOrdered.size; i++) {
/*  193 */       BasicLevel basicLevel = ((BasicLevel[])this.levelsOrdered.items)[i]; byte b;
/*  194 */       for (b = 0; b < basicLevel.quests.size; b++) {
/*  195 */         for (byte b3 = 0; b3 < (((BasicLevelQuestConfig[])basicLevel.quests.items)[b]).prizes.size; b3++) {
/*      */           ItemStack itemStack;
/*  197 */           if ((itemStack = ((ItemStack[])(((BasicLevelQuestConfig[])basicLevel.quests.items)[b]).prizes.items)[b3]).getItem() instanceof com.prineside.tdi2.items.StarItem) {
/*  198 */             this.e += itemStack.getCount();
/*      */           }
/*      */         } 
/*      */       } 
/*  202 */       for (b = 0; b < basicLevel.waveQuests.size; b++) {
/*  203 */         for (byte b3 = 0; b3 < (((BasicLevel.WaveQuest[])basicLevel.waveQuests.items)[b]).prizes.size; b3++) {
/*      */           ItemStack itemStack;
/*  205 */           if ((itemStack = ((ItemStack[])(((BasicLevel.WaveQuest[])basicLevel.waveQuests.items)[b]).prizes.items)[b3]).getItem() instanceof com.prineside.tdi2.items.StarItem)
/*  206 */             this.e += itemStack.getCount(); 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   private final ObjectMap<String, BasicLevel> c;
/*      */   private final ObjectMap<String, BasicLevelQuestConfig> d;
/*      */   private int e;
/*      */   private final DelayedRemovalArray<BasicLevelManagerListener> f;
/*      */   private static final Array<BasicLevel> g = new Array(BasicLevel.class);
/*      */   
/*      */   public void addStage(BasicLevelStage paramBasicLevelStage) {
/*  218 */     if (this.b.containsKey(paramBasicLevelStage.name)) {
/*  219 */       throw new RuntimeException("Stage with name " + paramBasicLevelStage.name + " already exists");
/*      */     }
/*      */     
/*  222 */     this.b.put(paramBasicLevelStage.name, paramBasicLevelStage);
/*  223 */     this.stagesOrdered.add(paramBasicLevelStage);
/*      */   }
/*      */   
/*      */   public void removeStage(BasicLevelStage paramBasicLevelStage) {
/*  227 */     if (this.stagesOrdered.contains(paramBasicLevelStage, true)) {
/*  228 */       if (this.stagesOrdered.size == 1) {
/*  229 */         throw new IllegalStateException("Can not delete the last stage");
/*      */       }
/*  231 */       this.stagesOrdered.removeValue(paramBasicLevelStage, true);
/*  232 */       this.b.remove(paramBasicLevelStage.name);
/*      */       return;
/*      */     } 
/*  235 */     throw new IllegalArgumentException("Stage not registered");
/*      */   }
/*      */ 
/*      */   
/*      */   public void levelsResourceReport() {
/*      */     class SourceInfo
/*      */     {
/*      */       float a;
/*      */       float b;
/*      */       
/*      */       SourceInfo(BasicLevelManager this$0, float param1Float, int param1Int) {
/*  246 */         this.a = param1Float;
/*      */         
/*  248 */         this.b = param1Float * (1.0F + param1Int * 0.35F);
/*      */       }
/*      */ 
/*      */       
/*      */       public String toString() {
/*  253 */         return StringFormatter.compactNumberWithPrecisionTrimZeros(this.b, 1, true).toString();
/*      */       }
/*      */     };
/*      */     class MapInfo
/*      */     {
/*      */       BasicLevel a;
/*      */       int b;
/*  260 */       Array<BasicLevelManager.SourceInfo>[] c = (Array<BasicLevelManager.SourceInfo>[])new Array[5]; float d; float e;
/*      */       MapInfo(BasicLevelManager this$0, BasicLevel param1BasicLevel) {
/*  262 */         for (byte b = 0; b < this.c.length; b++) {
/*  263 */           this.c[b] = new Array(true, 1, BasicLevelManager.SourceInfo.class);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*  268 */         this.f = new float[5];
/*  269 */         this.g = new float[5];
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  274 */         this.a = param1BasicLevel;
/*      */       }
/*      */       float[] f; float[] g;
/*      */       float h; };
/*  278 */     Array array1 = new Array(true, 1, BasicLevel.class);
/*  279 */     ObjectMap objectMap1 = new ObjectMap();
/*      */     
/*  281 */     Array array2 = new Array(true, 1, MapInfo.class);
/*      */     
/*      */     byte b1;
/*  284 */     for (b1 = 0; b1 < this.levelsOrdered.size; b1++) {
/*      */       BasicLevel basicLevel;
/*  286 */       if (!(basicLevel = (BasicLevel)this.levelsOrdered.get(b1)).isBonus && (
/*  287 */         basicLevel.stageName.equals("1") || basicLevel.stageName.equals("2") || basicLevel.stageName.equals("3") || basicLevel.stageName.equals("4") || basicLevel.stageName.equals("5") || basicLevel.stageName.equals("6"))) {
/*  288 */         array1.add(basicLevel);
/*  289 */         objectMap1.put(basicLevel.name, basicLevel);
/*      */         
/*      */         Map map;
/*  292 */         Array array4 = (map = basicLevel.getMap()).getTilesByType(SourceTile.class);
/*      */         
/*  294 */         MapInfo mapInfo = new MapInfo(this, basicLevel);
/*  295 */         array2.add(mapInfo);
/*      */         
/*  297 */         for (byte b10 = 0; b10 < array4.size; b10++) {
/*  298 */           SourceTile sourceTile = (SourceTile)array4.get(b10); ResourceType[] arrayOfResourceType; int m; byte b;
/*  299 */           for (m = (arrayOfResourceType = ResourceType.values).length, b = 0; b < m; ) { ResourceType resourceType = arrayOfResourceType[b];
/*      */             int n;
/*  301 */             if ((n = sourceTile.getResourcesCount(resourceType)) > 0) {
/*      */               
/*  303 */               float f5 = sourceTile.getResourceDensity();
/*      */ 
/*      */               
/*  306 */               int i1 = 0;
/*  307 */               for (byte b12 = 0; b12 < resourceType.ordinal() - 1; b12++) {
/*  308 */                 ResourceType resourceType1 = ResourceType.values[b12];
/*  309 */                 i1 += sourceTile.getResourcesCount(resourceType1);
/*      */               } 
/*      */               
/*  312 */               float f4 = 1.0F;
/*  313 */               if (i1 != 0) {
/*  314 */                 f4 = n / (i1 + n);
/*      */               }
/*      */               
/*  317 */               AtomicInteger atomicInteger = new AtomicInteger();
/*  318 */               map.traverseNeighborTiles(sourceTile.getX(), sourceTile.getY(), paramTile -> {
/*      */                     if (paramTile instanceof PlatformTile) {
/*      */                       paramAtomicInteger.getAndIncrement();
/*      */                     }
/*      */                     return true;
/*      */                   });
/*  324 */               mapInfo.c[resourceType.ordinal()].add(new SourceInfo(this, f5 * f4, atomicInteger.get()));
/*      */             } 
/*      */             
/*      */             b++; }
/*      */         
/*      */         } 
/*  330 */         Array array5 = map.getTilesByType(PlatformTile.class);
/*  331 */         for (byte b11 = 0; b11 < array5.size; b11++) {
/*  332 */           PlatformTile platformTile = (PlatformTile)array5.get(b11);
/*  333 */           map.traverseNeighborTiles(platformTile.getX(), platformTile.getY(), paramTile -> {
/*      */                 if (paramTile instanceof SourceTile) {
/*      */                   paramMapInfo.b++;
/*      */                 }
/*      */                 
/*      */                 return true;
/*      */               });
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  344 */     for (b1 = 0; b1 < array2.size; b1++) {
/*  345 */       MapInfo mapInfo = (MapInfo)array2.get(b1); ResourceType[] arrayOfResourceType; int m; byte b;
/*  346 */       for (m = (arrayOfResourceType = ResourceType.values).length, b = 0; b < m; ) { ResourceType resourceType = arrayOfResourceType[b];
/*  347 */         Array<SourceInfo> array = mapInfo.c[resourceType.ordinal()];
/*  348 */         for (byte b10 = 0; b10 < array.size; b10++) {
/*  349 */           SourceInfo sourceInfo = (SourceInfo)array.get(b10);
/*  350 */           mapInfo.d += sourceInfo.a;
/*  351 */           mapInfo.e += sourceInfo.b;
/*  352 */           mapInfo.f[resourceType.ordinal()] = mapInfo.f[resourceType.ordinal()] + sourceInfo.a;
/*  353 */           mapInfo.g[resourceType.ordinal()] = mapInfo.g[resourceType.ordinal()] + sourceInfo.b;
/*      */         } 
/*      */         b++; }
/*      */     
/*      */     } 
/*  358 */     float f1 = 0.0F; byte b2;
/*  359 */     for (b2 = 0; b2 < array2.size; b2++) {
/*  360 */       MapInfo mapInfo = (MapInfo)array2.get(b2);
/*  361 */       f1 += mapInfo.e;
/*      */     } 
/*  363 */     f1 /= array2.size;
/*      */     
/*  365 */     for (b2 = 0; b2 < array2.size; b2++) {
/*      */       MapInfo mapInfo;
/*  367 */       (mapInfo = (MapInfo)array2.get(b2)).h = mapInfo.e / f1;
/*      */     } 
/*      */ 
/*      */     
/*  371 */     Array array3 = new Array(true, 1, MapInfo.class);
/*  372 */     for (byte b3 = 0; b3 < array2.size; b3++) {
/*      */       MapInfo mapInfo;
/*  374 */       if ((mapInfo = (MapInfo)array2.get(b3)).h < 0.7F || mapInfo.h > 1.4F) {
/*  375 */         array3.add(mapInfo);
/*      */       }
/*      */     } 
/*  378 */     array3.sort((paramMapInfo1, paramMapInfo2) -> Float.compare(paramMapInfo1.h, paramMapInfo2.h));
/*      */ 
/*      */     
/*  381 */     float[] arrayOfFloat = new float[ResourceType.values.length];
/*  382 */     for (byte b4 = 0; b4 < array2.size; b4++) {
/*  383 */       MapInfo mapInfo = (MapInfo)array2.get(b4);
/*  384 */       for (byte b = 0; b < ResourceType.values.length; b++) {
/*  385 */         arrayOfFloat[b] = arrayOfFloat[b] + mapInfo.g[b];
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  390 */     MapInfo[][] arrayOfMapInfo = new MapInfo[ResourceType.values.length][8];
/*  391 */     float f2 = 0.0F;
/*  392 */     byte b5 = 0; ResourceType[] arrayOfResourceType1; int i; byte b7;
/*  393 */     for (i = (arrayOfResourceType1 = ResourceType.values).length, b7 = 0; b7 < i; ) { ResourceType resourceType = arrayOfResourceType1[b7];
/*  394 */       Array array = new Array(true, 1, ObjectPair.class); byte b;
/*  395 */       for (b = 0; b < array2.size; b++) {
/*      */         MapInfo mapInfo;
/*      */         float f;
/*  398 */         if ((f = (mapInfo = (MapInfo)array2.get(b)).g[resourceType.ordinal()]) != 0.0F) {
/*  399 */           array.add(new ObjectPair(mapInfo, Float.valueOf(f)));
/*      */         }
/*      */       } 
/*  402 */       array.sort((paramObjectPair1, paramObjectPair2) -> Float.compare(((Float)paramObjectPair2.second).floatValue(), ((Float)paramObjectPair1.second).floatValue())); int m;
/*  403 */       for (b = 0, m = Math.min(array.size, (arrayOfMapInfo[0]).length); b < m; b++) {
/*  404 */         arrayOfMapInfo[resourceType.ordinal()][b] = (MapInfo)((ObjectPair)array.get(b)).first;
/*  405 */         f2 += ((Float)((ObjectPair)array.get(b)).second).floatValue();
/*  406 */         b5++;
/*      */       }  b7++; }
/*      */     
/*  409 */     f2 /= b5;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  416 */     a.i("Global amount of resources:", new Object[0]);
/*  417 */     for (i = (arrayOfResourceType1 = ResourceType.values).length, b7 = 0; b7 < i; ) { ResourceType resourceType = arrayOfResourceType1[b7];
/*  418 */       a.i("- " + resourceType.name() + ": " + arrayOfFloat[resourceType.ordinal()], new Object[0]);
/*      */       b7++; }
/*      */     
/*  421 */     a.i("", new Object[0]);
/*  422 */     a.i("Sum resource density outliers:", new Object[0]);
/*  423 */     for (byte b6 = 0; b6 < array3.size; b6++) {
/*      */       String str1, str2;
/*      */       
/*      */       MapInfo mapInfo;
/*  427 */       if ((mapInfo = (MapInfo)array3.get(b6)).h < 1.0F) {
/*  428 */         str1 = "-" + StringFormatter.compactNumberWithPrecisionTrimZeros(((1.0F - mapInfo.h) * 100.0F), 1, false).toString();
/*  429 */         if (mapInfo.h < 0.2F) {
/*  430 */           str2 = "------";
/*  431 */         } else if (mapInfo.h < 0.3F) {
/*  432 */           str2 = "-----";
/*  433 */         } else if (mapInfo.h < 0.4F) {
/*  434 */           str2 = "----";
/*  435 */         } else if (mapInfo.h < 0.5F) {
/*  436 */           str2 = "---";
/*  437 */         } else if (mapInfo.h < 0.6F) {
/*  438 */           str2 = "--";
/*      */         } else {
/*  440 */           str2 = "-";
/*      */         } 
/*      */       } else {
/*  443 */         str1 = "+" + StringFormatter.compactNumberWithPrecisionTrimZeros(((mapInfo.h - 1.0F) * 100.0F), 1, false).toString();
/*  444 */         if (mapInfo.h > 2.6D) {
/*  445 */           str2 = "++++++";
/*  446 */         } else if (mapInfo.h > 2.3D) {
/*  447 */           str2 = "+++++";
/*  448 */         } else if (mapInfo.h > 2.0F) {
/*  449 */           str2 = "++++";
/*  450 */         } else if (mapInfo.h > 1.8D) {
/*  451 */           str2 = "+++";
/*  452 */         } else if (mapInfo.h > 1.5D) {
/*  453 */           str2 = "++";
/*      */         } else {
/*  455 */           str2 = "+";
/*      */         } 
/*      */       } 
/*  458 */       a.i("- " + mapInfo.a.name + ": " + str2 + " / " + str1 + "%", new Object[0]);
/*      */     } 
/*      */ 
/*      */     
/*  462 */     a.i("", new Object[0]);
/*  463 */     a.i("Best levels to farm individual resources (avg meta density: " + StringFormatter.compactNumberWithPrecisionTrimZeros(f2, 1, true) + "):", new Object[0]);
/*      */     
/*  465 */     float f3 = f2 * 0.8F; ResourceType[] arrayOfResourceType2; int k;
/*  466 */     for (int j = (arrayOfResourceType2 = ResourceType.values).length; k < j; ) { ResourceType resourceType = arrayOfResourceType2[k];
/*  467 */       MapInfo[] arrayOfMapInfo2 = arrayOfMapInfo[resourceType.ordinal()];
/*  468 */       float f = 0.0F; int m; MapInfo mapInfo1, arrayOfMapInfo1[];
/*  469 */       for (int n = (arrayOfMapInfo1 = arrayOfMapInfo2).length; m < n && (
/*  470 */         mapInfo1 = arrayOfMapInfo1[m]) != null; m++) {
/*  471 */         f += mapInfo1.g[resourceType.ordinal()];
/*      */       }
/*      */       
/*  474 */       a.i("=== " + resourceType.name() + " (sum: " + StringFormatter.compactNumberWithPrecisionTrimZeros(f, 1, false) + ") ===", new Object[0]);
/*  475 */       byte b11 = 0; byte b10; MapInfo mapInfo2, arrayOfMapInfo3[];
/*  476 */       for (m = (arrayOfMapInfo3 = arrayOfMapInfo2).length, b10 = 0; b10 < m && (
/*  477 */         mapInfo2 = arrayOfMapInfo3[b10]) != null; b10++) {
/*      */         
/*  479 */         float f4 = mapInfo2.g[resourceType.ordinal()];
/*  480 */         a.i("- " + mapInfo2.a.name + ": " + StringFormatter.compactNumberWithPrecisionTrimZeros(f4, 2, false) + " / x" + 
/*  481 */             StringFormatter.compactNumberWithPrecisionTrimZeros((f4 / f2), 2, false) + (
/*  482 */             (f4 > 12.0F) ? " (!!! Too HIGH)" : "") + ((
/*  483 */             b11 < 3 && f4 < f3) ? " (!!! Too LOW)" : ""), new Object[0]);
/*      */         
/*  485 */         b11++;
/*      */       } 
/*      */       k++; }
/*      */     
/*  489 */     a.i("", new Object[0]);
/*  490 */     a.i("Levels which have multiple best farming resource sources (some resources have to be moved to other non-meta maps):", new Object[0]);
/*  491 */     ObjectMap objectMap2 = new ObjectMap(); ResourceType[] arrayOfResourceType3; byte b9;
/*  492 */     for (k = (arrayOfResourceType3 = ResourceType.values).length, b9 = 0; b9 < k; ) { ResourceType resourceType = arrayOfResourceType3[b9]; byte b; MapInfo[] arrayOfMapInfo1, arrayOfMapInfo2;
/*      */       int m;
/*  494 */       for (m = (arrayOfMapInfo1 = arrayOfMapInfo2 = arrayOfMapInfo[resourceType.ordinal()]).length, b = 0; b < m; ) { MapInfo mapInfo = arrayOfMapInfo1[b];
/*  495 */         if (objectMap2.get(mapInfo) == null) {
/*  496 */           objectMap2.put(mapInfo, new Array(true, 1, ResourceType.class));
/*      */         }
/*  498 */         ((Array)objectMap2.get(mapInfo)).add(resourceType); b++; }
/*      */        b9++; }
/*      */      byte b8;
/*  501 */     for (b8 = 0; b8 < array2.size; b8++) {
/*  502 */       MapInfo mapInfo = (MapInfo)array2.get(b8);
/*      */       Array array;
/*  504 */       if ((array = (Array)objectMap2.get(mapInfo)) != null && array.size >= 2) {
/*  505 */         StringBuilder stringBuilder1 = new StringBuilder();
/*  506 */         for (byte b = 0; b < array.size; b++) {
/*  507 */           ResourceType resourceType = (ResourceType)array.get(b);
/*  508 */           float f = mapInfo.g[resourceType.ordinal()];
/*  509 */           if (b != 0) {
/*  510 */             stringBuilder1.append(", ");
/*      */           }
/*  512 */           stringBuilder1.append(resourceType.name())
/*  513 */             .append(" (x").append(String.valueOf(StringFormatter.compactNumberWithPrecisionTrimZeros((f / f2), 2, false)))
/*  514 */             .append(")");
/*      */         } 
/*  516 */         a.i("!!! " + mapInfo.a.name + ": " + stringBuilder1, new Object[0]);
/*      */       } 
/*      */     } 
/*      */     
/*  520 */     a.i("", new Object[0]);
/*  521 */     a.i("Vacant levels to become good farming spots (not listed in top spots to farm any resource ATM):", new Object[0]);
/*      */     
/*  523 */     for (b8 = 0; b8 < array2.size; b8++) {
/*  524 */       MapInfo mapInfo = (MapInfo)array2.get(b8);
/*  525 */       if (objectMap2.get(mapInfo) == null) {
/*  526 */         a.i("- " + mapInfo.a.name, new Object[0]);
/*      */       }
/*      */     } 
/*      */     
/*  530 */     a.i("", new Object[0]);
/*  531 */     a.i("Levels with a too small density of some resource:", new Object[0]);
/*  532 */     for (b8 = 0; b8 < array2.size; b8++) {
/*  533 */       MapInfo mapInfo = (MapInfo)array2.get(b8); ResourceType[] arrayOfResourceType; int m; byte b;
/*  534 */       for (m = (arrayOfResourceType = ResourceType.values).length, b = 0; b < m; ) { ResourceType resourceType = arrayOfResourceType[b];
/*      */         float f;
/*  536 */         if ((f = mapInfo.f[resourceType.ordinal()]) != 0.0F && f < 1.0F) {
/*  537 */           a.i("- " + mapInfo.a.name + " / " + resourceType.name() + " / " + StringFormatter.compactNumberWithPrecisionTrimZeros(f, 1, false), new Object[0]);
/*      */         }
/*      */         b++; }
/*      */     
/*      */     } 
/*  542 */     a.i("", new Object[0]);
/*  543 */     a.i("Individual levels that may suck (check manually for scripted levels):", new Object[0]);
/*  544 */     for (b8 = 0; b8 < array2.size; b8++) {
/*  545 */       MapInfo mapInfo = (MapInfo)array2.get(b8);
/*  546 */       boolean bool = objectMap2.containsKey(mapInfo);
/*  547 */       boolean bool1 = (mapInfo.h >= 0.85F) ? true : false;
/*  548 */       if (!bool && !bool1) {
/*  549 */         a.i("- " + mapInfo.a.name, new Object[0]);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  554 */     StringBuilder stringBuilder = new StringBuilder("\n");
/*      */     
/*  556 */     for (k = 0; k < array2.size; k++) {
/*  557 */       MapInfo mapInfo = (MapInfo)array2.get(k);
/*  558 */       stringBuilder.append("m.put(\"").append(mapInfo.a.name).append("\", new float[]{ ");
/*  559 */       for (byte b = 0; b < ResourceType.values.length; b++) {
/*  560 */         if (b != 0) stringBuilder.append(", "); 
/*      */         float f;
/*  562 */         if ((f = mapInfo.g[b]) < 2.5D) {
/*  563 */           stringBuilder.append("0f");
/*  564 */         } else if (f <= 4.0F) {
/*  565 */           stringBuilder.append("3.5f");
/*  566 */         } else if (f <= 6.0F) {
/*  567 */           stringBuilder.append("3f");
/*  568 */         } else if (f <= 8.0F) {
/*  569 */           stringBuilder.append("2.5f");
/*      */         } else {
/*  571 */           stringBuilder.append("2f");
/*      */         } 
/*      */       } 
/*  574 */       stringBuilder.append(" });\n");
/*      */     } 
/*  576 */     a.i(stringBuilder.toString(), new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleGameOverBonusLoot(GameSystemProvider paramGameSystemProvider, String paramString, Array<IssuedItems> paramArray) {
/*  592 */     PP_BasicLevel pP_BasicLevel = (ProgressPrefs.i()).basicLevel;
/*      */     
/*  594 */     a.i(paramArray.toString(","), new Object[0]);
/*      */     
/*      */     PP_BasicLevel.LevelLootBonus levelLootBonus;
/*  597 */     if ((levelLootBonus = pP_BasicLevel.getLevelLootBonus(paramString)) != null) {
/*  598 */       a.i("giving loot bonus " + levelLootBonus + " for level " + paramString, new Object[0]);
/*  599 */       for (byte b = 0; b < paramArray.size; b++) {
/*      */         IssuedItems issuedItems;
/*  601 */         if ((issuedItems = (IssuedItems)paramArray.get(b)).reason == IssuedItems.IssueReason.GAME_OVER_BASIC_LEVEL) {
/*  602 */           byte b1; a.i("found issued items", new Object[0]);
/*  603 */           IssuedItems issuedItems1 = new IssuedItems(IssuedItems.IssueReason.BASIC_LEVEL_BONUS_ITEMS, Game.getTimestampSeconds());
/*  604 */           switch (null.a[levelLootBonus.type.ordinal()]) {
/*      */             case 1:
/*  606 */               for (b1 = 0; b1 < issuedItems.items.size; b1++) {
/*      */                 ItemStack itemStack;
/*  608 */                 if ((itemStack = (ItemStack)issuedItems.items.get(b1)).getItem() instanceof ResourceItem && ((ResourceItem)itemStack.getItem()).resourceType == ResourceType.SCALAR) {
/*  609 */                   issuedItems1.items.add(new ItemStack(itemStack.getItem(), (int)(itemStack.getCount() * (levelLootBonus.multiplier - 1.0F))));
/*      */                 }
/*      */               } 
/*      */               break;
/*      */             
/*      */             case 2:
/*  615 */               for (b1 = 0; b1 < issuedItems.items.size; b1++) {
/*      */                 ItemStack itemStack;
/*  617 */                 if ((itemStack = (ItemStack)issuedItems.items.get(b1)).getItem() instanceof ResourceItem && ((ResourceItem)itemStack.getItem()).resourceType == ResourceType.VECTOR) {
/*  618 */                   issuedItems1.items.add(new ItemStack(itemStack.getItem(), (int)(itemStack.getCount() * (levelLootBonus.multiplier - 1.0F))));
/*      */                 }
/*      */               } 
/*      */               break;
/*      */             
/*      */             case 3:
/*  624 */               for (b1 = 0; b1 < issuedItems.items.size; b1++) {
/*      */                 ItemStack itemStack;
/*  626 */                 if ((itemStack = (ItemStack)issuedItems.items.get(b1)).getItem() instanceof ResourceItem && ((ResourceItem)itemStack.getItem()).resourceType == ResourceType.MATRIX) {
/*  627 */                   issuedItems1.items.add(new ItemStack(itemStack.getItem(), (int)(itemStack.getCount() * (levelLootBonus.multiplier - 1.0F))));
/*      */                 }
/*      */               } 
/*      */               break;
/*      */             
/*      */             case 4:
/*  633 */               for (b1 = 0; b1 < issuedItems.items.size; b1++) {
/*      */                 ItemStack itemStack;
/*  635 */                 if ((itemStack = (ItemStack)issuedItems.items.get(b1)).getItem() instanceof ResourceItem && ((ResourceItem)itemStack.getItem()).resourceType == ResourceType.TENSOR) {
/*  636 */                   issuedItems1.items.add(new ItemStack(itemStack.getItem(), (int)(itemStack.getCount() * (levelLootBonus.multiplier - 1.0F))));
/*      */                 }
/*      */               } 
/*      */               break;
/*      */             
/*      */             case 5:
/*  642 */               for (b1 = 0; b1 < issuedItems.items.size; b1++) {
/*      */                 ItemStack itemStack;
/*  644 */                 if ((itemStack = (ItemStack)issuedItems.items.get(b1)).getItem() instanceof ResourceItem && ((ResourceItem)itemStack.getItem()).resourceType == ResourceType.INFIAR) {
/*  645 */                   issuedItems1.items.add(new ItemStack(itemStack.getItem(), (int)(itemStack.getCount() * (levelLootBonus.multiplier - 1.0F))));
/*      */                 }
/*      */               } 
/*      */               break;
/*      */             
/*      */             case 6:
/*  651 */               for (b1 = 0; b1 < issuedItems.items.size; b1++) {
/*      */                 ItemStack itemStack;
/*  653 */                 if ((itemStack = (ItemStack)issuedItems.items.get(b1)).getItem() instanceof com.prineside.tdi2.items.GreenPaperItem) {
/*  654 */                   issuedItems1.items.add(new ItemStack(itemStack.getItem(), (int)(itemStack.getCount() * (levelLootBonus.multiplier - 1.0F))));
/*      */                 }
/*      */               } 
/*      */               break;
/*      */             
/*      */             case 7:
/*  660 */               for (b1 = 0; b1 < issuedItems.items.size; b1++) {
/*      */                 ItemStack itemStack;
/*  662 */                 if ((itemStack = (ItemStack)issuedItems.items.get(b1)).getItem() instanceof com.prineside.tdi2.items.BitDustItem) {
/*  663 */                   issuedItems1.items.add(new ItemStack(itemStack.getItem(), (int)(itemStack.getCount() * (levelLootBonus.multiplier - 1.0F))));
/*      */                 }
/*      */               } 
/*      */               break;
/*      */           } 
/*      */ 
/*      */           
/*  670 */           if (issuedItems1.items.size != 0) {
/*  671 */             paramArray.add(issuedItems1);
/*      */           }
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  679 */     pP_BasicLevel.setPlayTimeSinceLevelLootBonusUpdate(pP_BasicLevel.getPlayTimeSinceLevelLootBonusUpdate() + (int)paramGameSystemProvider.statistics.getStatistic(StatisticsType.PT));
/*  680 */     ProgressPrefs.i().requireSave();
/*      */     
/*  682 */     if (pP_BasicLevel.getPlayTimeSinceLevelLootBonusUpdate() > 1200) {
/*      */       
/*  684 */       a.i("generating new loot bonus levels", new Object[0]);
/*      */       
/*  686 */       ObjectMap<String, PP_BasicLevel.LevelLootBonus> objectMap = new ObjectMap();
/*  687 */       if (Game.i.minerManager.isMinerOpened(MinerType.MATRIX, Game.i.gameValueManager.getSnapshot())) {
/*      */         
/*  689 */         Array<BasicLevel> array = new Array(true, 1, BasicLevel.class);
/*  690 */         for (byte b2 = 0; b2 < this.levelsOrdered.size; b2++) {
/*  691 */           BasicLevel basicLevel = (BasicLevel)this.levelsOrdered.get(b2);
/*  692 */           if (isOpened(basicLevel) && !basicLevel.isBonus && (
/*  693 */             basicLevel.stageName.equals("1") || basicLevel.stageName.equals("2") || basicLevel.stageName.equals("3") || basicLevel.stageName.equals("4") || basicLevel.stageName.equals("5") || basicLevel.stageName.equals("6"))) {
/*  694 */             array.add(basicLevel);
/*  695 */             a.i("- opened level: " + basicLevel.name, new Object[0]);
/*      */           } 
/*      */         } 
/*      */         
/*  699 */         RandomXS128 randomXS128 = (ProgressPrefs.i()).progress.getOtherItemsRandom(); byte b1; BasicLevelLootBonusType[] arrayOfBasicLevelLootBonusType;
/*      */         int i;
/*  701 */         for (i = (arrayOfBasicLevelLootBonusType = BasicLevelLootBonusType.values).length, b1 = 0; b1 < i; ) { BasicLevelLootBonusType basicLevelLootBonusType = arrayOfBasicLevelLootBonusType[b1];
/*  702 */           switch (null.a[basicLevelLootBonusType.ordinal()]) {
/*      */             case 7:
/*  704 */               if (Game.i.progressManager.difficultyModeAvailable(DifficultyMode.ENDLESS_I) && array.size != 0) {
/*      */                 
/*  706 */                 int j = randomXS128.nextInt(array.size);
/*  707 */                 BasicLevel basicLevel = (BasicLevel)array.removeIndex(j);
/*  708 */                 objectMap.put(basicLevel.name, new PP_BasicLevel.LevelLootBonus(basicLevelLootBonusType, 2.5F));
/*      */               } 
/*      */               break;
/*      */ 
/*      */             
/*      */             case 6:
/*  714 */               if (array.size != 0) {
/*  715 */                 int j = randomXS128.nextInt(array.size);
/*  716 */                 BasicLevel basicLevel = (BasicLevel)array.removeIndex(j);
/*  717 */                 objectMap.put(basicLevel.name, new PP_BasicLevel.LevelLootBonus(basicLevelLootBonusType, 2.5F));
/*      */               } 
/*      */               break;
/*      */ 
/*      */             
/*      */             case 1:
/*  723 */               selectLootBonusLevelForResource(BasicLevelLootBonusType.RESOURCE_SCALAR, ResourceType.SCALAR, array, randomXS128, objectMap);
/*      */               break;
/*      */             
/*      */             case 2:
/*  727 */               selectLootBonusLevelForResource(BasicLevelLootBonusType.RESOURCE_VECTOR, ResourceType.VECTOR, array, randomXS128, objectMap);
/*      */               break;
/*      */             
/*      */             case 3:
/*  731 */               selectLootBonusLevelForResource(BasicLevelLootBonusType.RESOURCE_MATRIX, ResourceType.MATRIX, array, randomXS128, objectMap);
/*      */               break;
/*      */ 
/*      */             
/*      */             case 4:
/*  736 */               if (Game.i.minerManager.isMinerOpened(MinerType.TENSOR, Game.i.gameValueManager.getSnapshot())) {
/*  737 */                 selectLootBonusLevelForResource(BasicLevelLootBonusType.RESOURCE_TENSOR, ResourceType.TENSOR, array, randomXS128, objectMap); break;
/*      */               } 
/*  739 */               a.i("skipped RESOURCE_TENSOR loot bonus - miner not unlocked", new Object[0]);
/*      */               break;
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             case 5:
/*  746 */               if (Game.i.minerManager.isMinerOpened(MinerType.INFIAR, Game.i.gameValueManager.getSnapshot())) {
/*  747 */                 selectLootBonusLevelForResource(BasicLevelLootBonusType.RESOURCE_INFIAR, ResourceType.INFIAR, array, randomXS128, objectMap); break;
/*      */               } 
/*  749 */               a.i("skipped RESOURCE_INFIAR loot bonus - miner not unlocked", new Object[0]);
/*      */               break;
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/*      */           b1++; }
/*      */         
/*  757 */         boolean bool = (randomXS128.nextFloat() < 0.07F) ? true : false;
/*  758 */         for (ObjectMap.Entries<ObjectMap.Entry> entries = objectMap.iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/*  759 */           if (randomXS128.nextFloat() < 0.15F) {
/*  760 */             ((PP_BasicLevel.LevelLootBonus)entry.value).multiplier += 0.5F;
/*      */           }
/*  762 */           if (bool) {
/*  763 */             ((PP_BasicLevel.LevelLootBonus)entry.value).multiplier++; continue;
/*  764 */           }  if (randomXS128.nextFloat() < 0.15F) {
/*  765 */             ((PP_BasicLevel.LevelLootBonus)entry.value).multiplier++;
/*  766 */             if (randomXS128.nextFloat() < 0.5F) {
/*  767 */               ((PP_BasicLevel.LevelLootBonus)entry.value).multiplier += 0.5F;
/*      */             }
/*      */           }  }
/*      */ 
/*      */         
/*  772 */         ProgressPrefs.i().requireSave();
/*      */       } else {
/*  774 */         a.i("skipped level loot bonus assignation - Matrix not unlocked", new Object[0]);
/*      */       } 
/*  776 */       pP_BasicLevel.setLevelLootBonuses(objectMap);
/*      */       
/*  778 */       pP_BasicLevel.setPlayTimeSinceLevelLootBonusUpdate(0);
/*  779 */       ProgressPrefs.i().requireSave();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void saveStagesConfigOnDisk() {
/*  784 */     StringWriter stringWriter = new StringWriter();
/*      */     Json json;
/*  786 */     (json = new Json(JsonWriter.OutputType.json)).setWriter(stringWriter);
/*  787 */     json.writeArrayStart();
/*  788 */     for (byte b = 0; b < this.stagesOrdered.size; b++) {
/*  789 */       BasicLevelStage basicLevelStage = (BasicLevelStage)this.stagesOrdered.get(b);
/*  790 */       json.writeObjectStart();
/*  791 */       basicLevelStage.toJson(json);
/*  792 */       json.writeObjectEnd();
/*      */     } 
/*  794 */     json.writeArrayEnd();
/*      */     
/*      */     FileHandle fileHandle;
/*  797 */     (fileHandle = Gdx.files.local("res/basic-level-stages.json")).writeString(json.prettyPrint(stringWriter.toString()), false, "UTF-8");
/*      */   }
/*      */   
/*      */   public void selectLootBonusLevelForResource(BasicLevelLootBonusType paramBasicLevelLootBonusType, ResourceType paramResourceType, Array<BasicLevel> paramArray, RandomXS128 paramRandomXS128, ObjectMap<String, PP_BasicLevel.LevelLootBonus> paramObjectMap) {
/*  801 */     a.i("selectLootBonusLevelForResource " + paramResourceType, new Object[0]);
/*  802 */     if (paramArray.size == 0)
/*      */       return; 
/*  804 */     Array array = new Array(true, 1, BasicLevel.class); int i;
/*  805 */     for (i = 0; i < paramArray.size; i++) {
/*  806 */       BasicLevel basicLevel = (BasicLevel)paramArray.get(i); float f;
/*  807 */       if (this.resourceBonusLevelMultipliers.containsKey(basicLevel.name) && (
/*      */         
/*  809 */         f = ((float[])this.resourceBonusLevelMultipliers.get(basicLevel.name))[paramResourceType.ordinal()]) != 0.0F) {
/*  810 */         array.add(basicLevel);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  815 */     if (array.size != 0) {
/*  816 */       i = paramRandomXS128.nextInt(array.size);
/*  817 */       BasicLevel basicLevel = (BasicLevel)array.get(i);
/*  818 */       a.i("selected level: " + basicLevel, new Object[0]);
/*      */       
/*  820 */       float f = ((float[])this.resourceBonusLevelMultipliers.get(basicLevel.name))[paramResourceType.ordinal()];
/*      */       
/*  822 */       paramArray.removeValue(basicLevel, true);
/*      */       
/*  824 */       paramObjectMap.put(basicLevel.name, new PP_BasicLevel.LevelLootBonus(paramBasicLevelLootBonusType, f));
/*      */     } 
/*      */   }
/*      */   @Null
/*      */   public BasicLevel getNextVisibleLevel(BasicLevel paramBasicLevel) {
/*  829 */     paramBasicLevel = getNextLevel(paramBasicLevel);
/*  830 */     while (paramBasicLevel != null && !isLevelVisible(paramBasicLevel)) {
/*  831 */       paramBasicLevel = getNextLevel(paramBasicLevel);
/*      */     }
/*  833 */     return paramBasicLevel;
/*      */   }
/*      */   @Null
/*      */   public BasicLevel getNextLevel(BasicLevel paramBasicLevel) {
/*  837 */     BasicLevelStage basicLevelStage = getStage(paramBasicLevel.stageName);
/*  838 */     for (byte b = 0; b < basicLevelStage.levels.size; b1++) {
/*      */       byte b1; BasicLevel basicLevel;
/*  840 */       if ((basicLevel = (BasicLevel)basicLevelStage.levels.get(b)).name.equals(paramBasicLevel.name)) {
/*      */         BasicLevel basicLevel1;
/*      */         
/*  843 */         if ((basicLevel1 = (BasicLevel)((basicLevelStage.levels.size > b + 1) ? basicLevelStage.levels.get(b + 1) : null)) != null) {
/*  844 */           return basicLevel1;
/*      */         }
/*      */         
/*  847 */         for (b1 = 0; b1 < this.stagesOrdered.size; b1++) {
/*      */           BasicLevelStage basicLevelStage1;
/*  849 */           if ((basicLevelStage1 = (BasicLevelStage)this.stagesOrdered.get(b1)).name.equals(basicLevelStage.name)) {
/*      */ 
/*      */             
/*  852 */             if ((basicLevelStage = (BasicLevelStage)((this.stagesOrdered.size > b1 + 1) ? this.stagesOrdered.get(b1 + 1) : null)) != null && basicLevelStage.levels.size != 0) {
/*      */               BasicLevel basicLevel2;
/*  854 */               if ((basicLevel2 = (BasicLevel)basicLevelStage.levels.first()).dailyQuest == paramBasicLevel.dailyQuest) {
/*  855 */                 return basicLevel2;
/*      */               }
/*  857 */               return null;
/*      */             } 
/*      */             
/*  860 */             return null;
/*      */           } 
/*      */         } 
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*      */     
/*  868 */     return null;
/*      */   }
/*      */   
/*      */   public QuestsPrestigeMilestone[] getQuestsPrestigeMilestones() {
/*  872 */     float f = (float)Game.i.gameValueManager.getSnapshot().getPercentValueAsMultiplier(GameValueType.PRESTIGE_DUST_DROP_RATE);
/*  873 */     return new QuestsPrestigeMilestone[] { new QuestsPrestigeMilestone(20, 
/*  874 */           MathUtils.round(100.0F * f)), new QuestsPrestigeMilestone(50, 
/*  875 */           MathUtils.round(300.0F * f)), new QuestsPrestigeMilestone(75, 
/*  876 */           MathUtils.round(700.0F * f)), new QuestsPrestigeMilestone(100, 
/*  877 */           MathUtils.round(1200.0F * f)) };
/*      */   }
/*      */   
/*      */   @Null
/*      */   public BasicLevelQuestConfig getRegularQuestById(String paramString) {
/*  882 */     return (BasicLevelQuestConfig)this.d.get(paramString, null);
/*      */   }
/*      */   
/*      */   public int getPrestigeMaxCompletedQuests() {
/*  886 */     int i = 0;
/*  887 */     for (byte b = 0; b < this.stagesOrdered.size; b++) {
/*      */       BasicLevelStage basicLevelStage;
/*  889 */       if ((basicLevelStage = ((BasicLevelStage[])this.stagesOrdered.items)[b]).regular) {
/*  890 */         for (byte b1 = 0; b1 < basicLevelStage.levels.size; b1++) {
/*  891 */           BasicLevel basicLevel = ((BasicLevel[])basicLevelStage.levels.items)[b1];
/*  892 */           i += basicLevel.quests.size;
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/*  897 */     return i;
/*      */   }
/*      */   
/*      */   public int getPrestigeCompletedQuests() {
/*  901 */     byte b1 = 0;
/*  902 */     for (byte b2 = 0; b2 < this.stagesOrdered.size; b2++) {
/*      */       BasicLevelStage basicLevelStage;
/*  904 */       if ((basicLevelStage = ((BasicLevelStage[])this.stagesOrdered.items)[b2]).regular) {
/*  905 */         for (byte b = 0; b < basicLevelStage.levels.size; b++) {
/*  906 */           BasicLevel basicLevel = ((BasicLevel[])basicLevelStage.levels.items)[b];
/*  907 */           for (byte b3 = 0; b3 < basicLevel.quests.size; b3++) {
/*      */             BasicLevelQuestConfig basicLevelQuestConfig;
/*  909 */             if ((basicLevelQuestConfig = ((BasicLevelQuestConfig[])basicLevel.quests.items)[b3]).isCompleted()) {
/*  910 */               b1++;
/*      */             }
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/*  917 */     return b1;
/*      */   }
/*      */   
/*      */   public void resetQuestsForPrestige() {
/*  921 */     int i = getPrestigeMaxCompletedQuests();
/*      */     int j;
/*      */     double d;
/*  924 */     i = (int)((d = (j = getPrestigeCompletedQuests()) / i) * 100.0D + 1.0E-4D);
/*      */     
/*      */     QuestsPrestigeMilestone[] arrayOfQuestsPrestigeMilestone;
/*  927 */     for (int k = (arrayOfQuestsPrestigeMilestone = getQuestsPrestigeMilestones()).length - 1; k >= 0; k--) {
/*  928 */       if (i >= (arrayOfQuestsPrestigeMilestone[k]).percentage) {
/*      */         
/*  930 */         i = (arrayOfQuestsPrestigeMilestone[k]).tokensCount;
/*      */ 
/*      */         
/*  933 */         Game.i.progressManager.addItems((Item)Item.D.PRESTIGE_TOKEN, i, "quests_prestige");
/*      */         
/*      */         IssuedItems issuedItems;
/*      */         
/*  937 */         (issuedItems = new IssuedItems(IssuedItems.IssueReason.QUESTS_PRESTIGE, Game.getTimestampSeconds())).items.add(new ItemStack((Item)Item.D.PRESTIGE_TOKEN, i));
/*  938 */         Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/*      */         
/*  940 */         Game.i.statisticsManager.registerDelta(StatisticsType.PQR, 1.0D);
/*  941 */         Game.i.statisticsManager.registerDelta(StatisticsType.PPG, i);
/*      */ 
/*      */         
/*  944 */         for (i = 0; i < this.stagesOrdered.size; i++) {
/*      */           BasicLevelStage basicLevelStage;
/*  946 */           if ((basicLevelStage = ((BasicLevelStage[])this.stagesOrdered.items)[i]).regular) {
/*  947 */             for (k = 0; k < basicLevelStage.levels.size; k++) {
/*  948 */               BasicLevel basicLevel = ((BasicLevel[])basicLevelStage.levels.items)[k]; byte b;
/*  949 */               label33: for (b = 0; b < basicLevel.quests.size; b++) {
/*  950 */                 BasicLevelQuestConfig basicLevelQuestConfig = ((BasicLevelQuestConfig[])basicLevel.quests.items)[b];
/*  951 */                 for (byte b1 = 0; b1 < basicLevelQuestConfig.prizes.size; ) {
/*  952 */                   if (!(((ItemStack[])basicLevelQuestConfig.prizes.items)[b1].getItem() instanceof com.prineside.tdi2.items.StarItem)) {
/*      */                     b1++; continue;
/*      */                   } 
/*      */                   break label33;
/*      */                 } 
/*  957 */                 if (basicLevelQuestConfig.isCompleted()) {
/*  958 */                   basicLevelQuestConfig.setSavedValue(0L);
/*  959 */                   basicLevelQuestConfig.setCompleted(false);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           }
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  968 */         Game.i.dailyQuestManager.setDailyLootQuestCompleted();
/*      */         
/*  970 */         Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*      */         
/*  972 */         Game.i.achievementManager.setProgress(AchievementType.PRESTIGE, 1);
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*      */     
/*  978 */     a.e("no milestone reached, can't prestige quests", new Object[0]);
/*      */   }
/*      */   
/*      */   public void addListener(BasicLevelManagerListener paramBasicLevelManagerListener) {
/*  982 */     if (!this.f.contains(paramBasicLevelManagerListener, true)) {
/*  983 */       this.f.add(paramBasicLevelManagerListener);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeListener(BasicLevelManagerListener paramBasicLevelManagerListener) {
/*  988 */     this.f.removeValue(paramBasicLevelManagerListener, true);
/*      */   }
/*      */   
/*      */   public void unloadLevel(String paramString) {
/*  992 */     if (this.c.containsKey(paramString)) {
/*      */       byte b;
/*  994 */       for (b = 0; b < this.stagesOrdered.size; b++) {
/*  995 */         BasicLevelStage basicLevelStage = (BasicLevelStage)this.stagesOrdered.get(b);
/*  996 */         for (byte b1 = 0; b1 < basicLevelStage.levels.size; b1++) {
/*  997 */           if (((BasicLevel)basicLevelStage.levels.get(b1)).name.equals(paramString)) {
/*  998 */             basicLevelStage.levels.removeIndex(b1);
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/* 1004 */       for (b = 0; b < this.levelsOrdered.size; b++) {
/* 1005 */         if (((BasicLevel)this.levelsOrdered.get(b)).name.equals(paramString)) {
/* 1006 */           this.levelsOrdered.removeIndex(b);
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/* 1011 */       this.c.remove(paramString);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void registerLevel(BasicLevel paramBasicLevel) {
/* 1017 */     for (byte b = 0; b < paramBasicLevel.quests.size; b++) {
/* 1018 */       BasicLevelQuestConfig basicLevelQuestConfig = ((BasicLevelQuestConfig[])paramBasicLevel.quests.items)[b];
/* 1019 */       this.d.put(basicLevelQuestConfig.id, basicLevelQuestConfig);
/*      */     } 
/*      */ 
/*      */     
/* 1023 */     unloadLevel(paramBasicLevel.name);
/*      */     
/*      */     BasicLevelStage basicLevelStage;
/* 1026 */     if ((basicLevelStage = getStage(paramBasicLevel.stageName)) == null) {
/* 1027 */       basicLevelStage = getStage("-1");
/* 1028 */       a.e("Stage " + paramBasicLevel.stageName + " not found for level " + paramBasicLevel.name + ", falling back to stage -1", new Object[0]);
/*      */     } 
/*      */     
/* 1031 */     basicLevelStage.levels.add(paramBasicLevel);
/* 1032 */     this.levelsOrdered.add(paramBasicLevel);
/* 1033 */     this.c.put(paramBasicLevel.name, paramBasicLevel);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public BasicLevel loadAndRegisterLevelFromJson(JsonValue paramJsonValue) {
/* 1039 */     BasicLevel basicLevel = BasicLevel.fromJson(paramJsonValue);
/*      */     
/* 1041 */     registerLevel(basicLevel);
/*      */ 
/*      */     
/* 1044 */     return basicLevel;
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   public String generateLevelsJson() {
/* 1049 */     Json json = new Json(JsonWriter.OutputType.json);
/* 1050 */     StringWriter stringWriter = new StringWriter();
/* 1051 */     json.setWriter(stringWriter);
/*      */     
/* 1053 */     json.writeObjectStart();
/*      */ 
/*      */     
/* 1056 */     json.writeArrayStart("stages");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1061 */     json.writeArrayEnd();
/*      */ 
/*      */     
/* 1064 */     json.writeArrayStart("levels");
/* 1065 */     json.writeArrayEnd();
/*      */     
/* 1067 */     json.writeObjectEnd();
/*      */     
/* 1069 */     return stringWriter.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean mapEditingAvailable() {
/* 1085 */     return Game.i.progressManager.isDeveloperModeEnabled();
/*      */   }
/*      */   
/*      */   public BasicLevelStage getStage(String paramString) {
/* 1089 */     return (BasicLevelStage)this.b.get(paramString);
/*      */   }
/*      */   
/*      */   public BasicLevelStage getLevelStage(String paramString) {
/* 1093 */     return getStage((getLevel(paramString)).stageName);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BasicLevel getLevel(String paramString) {
/* 1101 */     return (BasicLevel)this.c.get(paramString, null);
/*      */   }
/*      */   
/*      */   public int getQuestSkipPrice(BasicLevelQuestConfig paramBasicLevelQuestConfig) {
/* 1105 */     if (paramBasicLevelQuestConfig.scripted) return 0; 
/* 1106 */     if (paramBasicLevelQuestConfig.isCompleted()) return 0; 
/* 1107 */     if (!(getStage(paramBasicLevelQuestConfig.level.stageName)).regular) return 0; 
/*      */     byte b1;
/* 1109 */     for (b1 = 0; b1 < paramBasicLevelQuestConfig.prizes.size; b1++) {
/* 1110 */       if (((ItemStack[])paramBasicLevelQuestConfig.prizes.items)[b1].getItem() instanceof com.prineside.tdi2.items.StarItem) {
/* 1111 */         return 0;
/*      */       }
/*      */     } 
/*      */     
/* 1115 */     b1 = 0;
/* 1116 */     for (byte b2 = 0; b2 < paramBasicLevelQuestConfig.level.quests.size; ) {
/* 1117 */       b1 = b2;
/* 1118 */       if (((BasicLevelQuestConfig[])paramBasicLevelQuestConfig.level.quests.items)[b2] != paramBasicLevelQuestConfig) {
/*      */         b2++;
/*      */       }
/*      */     } 
/*      */     
/* 1123 */     return b1 + 10;
/*      */   }
/*      */   
/*      */   public void skipQuest(BasicLevelQuestConfig paramBasicLevelQuestConfig) {
/* 1127 */     int i = getQuestSkipPrice(paramBasicLevelQuestConfig);
/* 1128 */     if (Game.i.progressManager.removeItems((Item)Item.D.ACCELERATOR, i)) {
/* 1129 */       Game.i.analyticsManager.logCurrencySpent("quest_skip", "accelerator", i);
/* 1130 */       paramBasicLevelQuestConfig.setCompleted(true);
/* 1131 */       if (Game.i.dailyQuestManager.getDailyLootCurrentQuest().equals(paramBasicLevelQuestConfig.id)) {
/* 1132 */         Game.i.dailyQuestManager.setDailyLootQuestCompleted(); return;
/*      */       } 
/*      */     } else {
/* 1135 */       Notifications.i().add(Game.i.localeManager.i18n.get("not_enough_accelerators"), (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isQuestCompleted(String paramString) {
/* 1144 */     return (ProgressPrefs.i()).basicLevel.isQuestCompleted(paramString);
/*      */   }
/*      */   
/*      */   public boolean isQuestEverCompleted(String paramString) {
/* 1148 */     return (ProgressPrefs.i()).basicLevel.isQuestEverCompleted(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setQuestCompleted(String paramString, boolean paramBoolean) {
/* 1157 */     if (paramBoolean) {
/* 1158 */       if (!isQuestCompleted(paramString)) {
/*      */         ProgressPrefs progressPrefs;
/* 1160 */         (progressPrefs = ProgressPrefs.i()).basicLevel.setQuestCompleted(paramString, true);
/* 1161 */         progressPrefs.basicLevel.setQuestEverCompleted(paramString, true);
/* 1162 */         progressPrefs.requireSave();
/*      */ 
/*      */ 
/*      */         
/* 1166 */         Game.i.analyticsManager.logCustomEvent("basic_level_quest_completed", new String[] { "id", paramString }, (Object[])new String[0]);
/*      */         
/* 1168 */         Game.i.progressManager.checkSpecialTrophiesGiven();
/*      */         return;
/*      */       } 
/* 1171 */     } else if (isQuestCompleted(paramString)) {
/* 1172 */       a.i("cleared completed quest: " + paramString, new Object[0]);
/*      */       ProgressPrefs progressPrefs;
/* 1174 */       (progressPrefs = ProgressPrefs.i()).basicLevel.setQuestCompleted(paramString, false);
/* 1175 */       progressPrefs.requireSave();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getGainedStarsOnLevel(BasicLevel paramBasicLevel) {
/* 1184 */     int i = 0; byte b;
/* 1185 */     for (b = 0; b < paramBasicLevel.waveQuests.size; b++) {
/*      */       BasicLevel.WaveQuest waveQuest;
/* 1187 */       if ((waveQuest = (BasicLevel.WaveQuest)paramBasicLevel.waveQuests.get(b)).isCompleted()) {
/* 1188 */         for (byte b1 = 0; b1 < waveQuest.prizes.size; b1++) {
/*      */           ItemStack itemStack;
/* 1190 */           if ((itemStack = (ItemStack)waveQuest.prizes.get(b1)).getItem() instanceof com.prineside.tdi2.items.StarItem) {
/* 1191 */             i += itemStack.getCount();
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/* 1196 */     for (b = 0; b < paramBasicLevel.quests.size; b++) {
/*      */       BasicLevelQuestConfig basicLevelQuestConfig;
/* 1198 */       if ((basicLevelQuestConfig = (BasicLevelQuestConfig)paramBasicLevel.quests.get(b)).isCompleted()) {
/* 1199 */         for (byte b1 = 0; b1 < basicLevelQuestConfig.prizes.size; b1++) {
/*      */           ItemStack itemStack;
/* 1201 */           if ((itemStack = (ItemStack)basicLevelQuestConfig.prizes.get(b1)).getItem() instanceof com.prineside.tdi2.items.StarItem) {
/* 1202 */             i += itemStack.getCount();
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/* 1208 */     return i;
/*      */   }
/*      */   
/*      */   public int getGainedStarsOnStage(BasicLevelStage paramBasicLevelStage) {
/* 1212 */     int i = 0;
/* 1213 */     for (byte b = 0; b < paramBasicLevelStage.levels.size; b++) {
/* 1214 */       if (!(((BasicLevel[])paramBasicLevelStage.levels.items)[b]).dailyQuest)
/*      */       {
/* 1216 */         i += getGainedStarsOnLevel(((BasicLevel[])paramBasicLevelStage.levels.items)[b]);
/*      */       }
/*      */     } 
/* 1219 */     return i;
/*      */   }
/*      */   
/*      */   public int getMaxStars(BasicLevelStage paramBasicLevelStage, boolean paramBoolean) {
/* 1223 */     if (paramBoolean) {
/* 1224 */       paramBoolean = false;
/* 1225 */       for (byte b = 0; b < paramBasicLevelStage.levels.size; b++) {
/* 1226 */         if (Game.i.basicLevelManager.isLevelVisible((BasicLevel)paramBasicLevelStage.levels.get(b))) {
/* 1227 */           paramBoolean += true;
/*      */         }
/*      */       } 
/*      */       
/* 1231 */       return paramBoolean;
/*      */     } 
/* 1233 */     return paramBasicLevelStage.levels.size * 3;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isStageVisible(BasicLevelStage paramBasicLevelStage) {
/* 1241 */     if (Config.isModdingMode() || Game.i.progressManager.isDeveloperModeEnabled()) return true;
/*      */     
/* 1243 */     for (byte b = 0; b < paramBasicLevelStage.showRequirements.size; b++) {
/* 1244 */       if (!((Requirement)paramBasicLevelStage.showRequirements.get(b)).isSatisfied()) {
/* 1245 */         return false;
/*      */       }
/*      */     } 
/* 1248 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isLevelVisible(BasicLevel paramBasicLevel) {
/* 1254 */     if (!isStageVisible(getStage(paramBasicLevel.stageName))) return false;
/*      */     
/* 1256 */     for (byte b = 0; b < paramBasicLevel.showRequirements.size; b++) {
/* 1257 */       if (!((Requirement)paramBasicLevel.showRequirements.get(b)).isSatisfied()) {
/* 1258 */         return false;
/*      */       }
/*      */     } 
/*      */     
/* 1262 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isOpened(BasicLevel paramBasicLevel) {
/* 1272 */     if (paramBasicLevel.isPurchasedOrPlayed()) {
/* 1273 */       return true;
/*      */     }
/*      */     
/* 1276 */     if (paramBasicLevel.priceInMoney > 0) {
/* 1277 */       return false;
/*      */     }
/*      */     byte b;
/* 1280 */     for (b = 0; b < paramBasicLevel.priceInResources.length; b++) {
/* 1281 */       if (paramBasicLevel.priceInResources[b] > 0) return false;
/*      */     
/*      */     } 
/*      */     
/* 1285 */     for (b = 0; b < paramBasicLevel.openRequirements.size; b++) {
/* 1286 */       if (!((Requirement)paramBasicLevel.openRequirements.get(b)).isSatisfied()) {
/* 1287 */         return false;
/*      */       }
/*      */     } 
/*      */     
/* 1291 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canBePurchased(BasicLevel paramBasicLevel) {
/*      */     byte b;
/* 1302 */     for (b = 0; b < paramBasicLevel.openRequirements.size; b++) {
/* 1303 */       if (!((Requirement)paramBasicLevel.openRequirements.get(b)).isSatisfied()) {
/* 1304 */         return false;
/*      */       }
/*      */     } 
/* 1307 */     if (paramBasicLevel.priceInMoney > Game.i.progressManager.getGreenPapers()) {
/* 1308 */       return false;
/*      */     }
/*      */     
/* 1311 */     for (b = 0; b < paramBasicLevel.priceInResources.length; b++) {
/* 1312 */       if (paramBasicLevel.priceInResources[b] > Game.i.progressManager.getResources(ResourceType.values[b])) {
/* 1313 */         return false;
/*      */       }
/*      */     } 
/*      */     
/* 1317 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isMastered(BasicLevel paramBasicLevel) {
/*      */     byte b;
/* 1324 */     for (b = 0; b < paramBasicLevel.quests.size; b++) {
/* 1325 */       if (!((BasicLevelQuestConfig)paramBasicLevel.quests.get(b)).isCompleted()) {
/* 1326 */         return false;
/*      */       }
/*      */     } 
/*      */     
/* 1330 */     for (b = 0; b < paramBasicLevel.waveQuests.size; b++) {
/* 1331 */       if (!((BasicLevel.WaveQuest)paramBasicLevel.waveQuests.get(b)).isCompleted()) {
/* 1332 */         return false;
/*      */       }
/*      */     } 
/*      */     
/* 1336 */     return true;
/*      */   }
/*      */   
/*      */   public Array<BasicLevel> getMasteredLevels() {
/* 1340 */     BasicLevelStage basicLevelStage = getStage("0");
/* 1341 */     g.clear();
/* 1342 */     for (byte b = 0; b < this.levelsOrdered.size; b++) {
/* 1343 */       BasicLevel basicLevel = ((BasicLevel[])this.levelsOrdered.items)[b];
/* 1344 */       if (getStage(basicLevel.stageName) != basicLevelStage && isMastered(basicLevel)) {
/* 1345 */         g.add(basicLevel);
/*      */       }
/*      */     } 
/*      */     
/* 1349 */     return g;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean playedBefore(BasicLevel paramBasicLevel) {
/* 1356 */     return ((ProgressPrefs.i()).basicLevel.getLevelStartsCount(paramBasicLevel.name) > 0);
/*      */   }
/*      */   
/*      */   public int getMaxStarsCount() {
/* 1360 */     return this.e;
/*      */   }
/*      */   
/*      */   public int getMaxReachedWave(String paramString) {
/* 1364 */     if (Config.isHeadless()) return 0;
/*      */     
/* 1366 */     return (ProgressPrefs.i()).basicLevel.getLevelMaxReachedWave(paramString);
/*      */   }
/*      */   
/*      */   public int getGainedStars() {
/* 1370 */     int i = 0;
/* 1371 */     for (byte b = 0; b < this.stagesOrdered.size; b++) {
/* 1372 */       i += getGainedStarsOnStage(((BasicLevelStage[])this.stagesOrdered.items)[b]);
/*      */     }
/*      */     
/* 1375 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMap(BasicLevel paramBasicLevel, Map paramMap) {
/* 1382 */     if (mapEditingAvailable())
/*      */       try {
/* 1384 */         Json json = new Json(JsonWriter.OutputType.json);
/* 1385 */         StringWriter stringWriter = new StringWriter();
/* 1386 */         json.setWriter(stringWriter);
/* 1387 */         json.writeObjectStart();
/* 1388 */         paramMap.toJson(json);
/* 1389 */         json.writeObjectEnd();
/*      */         
/* 1391 */         String str = (new JsonReader()).parse(stringWriter.toString()).prettyPrint(JsonWriter.OutputType.json, 2);
/* 1392 */         Gdx.files.local("levels/maps/" + paramBasicLevel.name + ".json").writeString(str, false, "UTF-8");
/* 1393 */         paramBasicLevel.setMap(paramMap);
/*      */         
/* 1395 */         a.i("map saved", new Object[0]); return;
/* 1396 */       } catch (Exception exception) {
/* 1397 */         a.e("unable to write map", new Object[] { exception });
/*      */         return;
/*      */       }  
/* 1400 */     a.e("unable to set basic level map on this OS or not in developer mode", new Object[0]);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPurchased(BasicLevel paramBasicLevel) {
/* 1405 */     if (!(ProgressPrefs.i()).basicLevel.isLevelPurchased(paramBasicLevel.name)) {
/* 1406 */       (ProgressPrefs.i()).basicLevel.setLevelPurchased(paramBasicLevel.name, true);
/* 1407 */       ProgressPrefs.i().requireSave();
/* 1408 */       Game.i.analyticsManager.logCustomEvent("basic_level_purchased", new String[] { "name", paramBasicLevel.name }, (Object[])new String[0]);
/*      */     } 
/*      */ 
/*      */     
/* 1412 */     Game.i.researchManager.checkResearchesStatus(true);
/*      */   }
/*      */ 
/*      */   
/*      */   public void test() {
/* 1417 */     for (byte b = 0; b < this.levelsOrdered.size; exception++) {
/* 1418 */       BasicLevel basicLevel = (BasicLevel)this.levelsOrdered.get(b);
/*      */       try {
/* 1420 */         basicLevel.getPreview();
/* 1421 */       } catch (Exception exception) {
/* 1422 */         a.e("Test: failed BasicLevel#getPreview() for level " + basicLevel.name, new Object[0]);
/* 1423 */         throw exception;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void dispose() {}
/*      */ 
/*      */ 
/*      */   
/*      */   public static class QuestsPrestigeMilestone
/*      */   {
/*      */     public int percentage;
/*      */     
/*      */     public int tokensCount;
/*      */ 
/*      */     
/*      */     public QuestsPrestigeMilestone(int param1Int1, int param1Int2) {
/* 1442 */       this.percentage = param1Int1;
/* 1443 */       this.tokensCount = param1Int2;
/*      */     }
/*      */   }
/*      */   
/*      */   public static interface BasicLevelManagerListener {}
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\BasicLevelManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */