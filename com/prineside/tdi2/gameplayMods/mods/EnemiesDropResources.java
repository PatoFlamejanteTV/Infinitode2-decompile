/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemySpawn;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.GenericGameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*     */ import com.prineside.tdi2.items.ResourceItem;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.tiles.SourceTile;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.ObjectSupplier;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ @REGS
/*     */ public final class EnemiesDropResources
/*     */   extends GenericGameplayMod implements Listener<EnemySpawn> {
/*  40 */   public float resourceCountMultiplier = 0.025F;
/*  41 */   public float resourceCountDispersion = 0.25F;
/*  42 */   public float maxResourcesPerPower = 50.0F;
/*  43 */   public int baseEnemyInterval = 5;
/*  44 */   public float enemyIntervalDeltaPerPower = -1.0F;
/*  45 */   public int minEnemyInterval = 3;
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   private GameSystemProvider a;
/*     */ 
/*     */   
/*  53 */   private int[] b = new int[ResourceType.values.length];
/*     */   
/*     */   private int c;
/*     */   private int d;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  59 */     super.write(paramKryo, paramOutput);
/*  60 */     paramOutput.writeFloat(this.resourceCountMultiplier);
/*  61 */     paramOutput.writeFloat(this.resourceCountDispersion);
/*  62 */     paramOutput.writeFloat(this.maxResourcesPerPower);
/*  63 */     paramOutput.writeVarInt(this.baseEnemyInterval, true);
/*  64 */     paramOutput.writeFloat(this.enemyIntervalDeltaPerPower);
/*  65 */     paramOutput.writeVarInt(this.minEnemyInterval, true);
/*  66 */     paramKryo.writeObjectOrNull(paramOutput, this.a, GameSystemProvider.class);
/*  67 */     paramKryo.writeObject(paramOutput, this.b);
/*  68 */     paramOutput.writeVarInt(this.c, true);
/*  69 */     paramOutput.writeVarInt(this.d, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  74 */     super.read(paramKryo, paramInput);
/*  75 */     this.resourceCountMultiplier = paramInput.readFloat();
/*  76 */     this.resourceCountDispersion = paramInput.readFloat();
/*  77 */     this.maxResourcesPerPower = paramInput.readFloat();
/*  78 */     this.baseEnemyInterval = paramInput.readVarInt(true);
/*  79 */     this.enemyIntervalDeltaPerPower = paramInput.readFloat();
/*  80 */     this.minEnemyInterval = paramInput.readVarInt(true);
/*  81 */     this.a = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*  82 */     this.b = (int[])paramKryo.readObject(paramInput, int[].class);
/*  83 */     this.c = paramInput.readVarInt(true);
/*  84 */     this.d = paramInput.readVarInt(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/*  89 */     return GameplayModCategory.LOOTING;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  94 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.EnemiesDropResources");
/*     */   }
/*     */   
/*     */   public final int getMaxTotalResourcesPercentage() {
/*  98 */     return (int)(this.power * this.maxResourcesPerPower);
/*     */   }
/*     */   
/*     */   private void a(Enemy paramEnemy) {
/* 102 */     this.c++;
/* 103 */     if (this.c >= this.baseEnemyInterval) {
/* 104 */       this.c -= this.baseEnemyInterval;
/*     */       
/* 106 */       int i = 0; int arrayOfInt[], k, m;
/* 107 */       for (k = (arrayOfInt = this.b).length, m = 0; m < k; ) { int i1 = arrayOfInt[m];
/* 108 */         i += i1; m++; }
/*     */       
/* 110 */       if (i == 0)
/* 111 */         return;  int j = this.a.gameState.randomInt(i);
/* 112 */       k = 0;
/* 113 */       m = 0; int n;
/* 114 */       for (n = 0; n < this.b.length; n++) {
/* 115 */         i = this.b[n];
/* 116 */         if (k + i > j) {
/* 117 */           m = n;
/*     */           break;
/*     */         } 
/* 120 */         k += i;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 125 */       i = Math.max(1, MathUtils.round(this.b[m] * (1.0F - this.resourceCountDispersion) * this.resourceCountMultiplier));
/*     */ 
/*     */       
/* 128 */       if ((i = ((j = Math.max(1, MathUtils.round(this.b[m] * (1.0F + this.resourceCountDispersion) * this.resourceCountMultiplier))) == i) ? i : (i + this.a.gameState.randomInt(j - i + 1))) > 0) {
/*     */         ResourceItem resourceItem;
/* 130 */         j = 0; ResourceType[] arrayOfResourceType; byte b;
/* 131 */         for (n = (arrayOfResourceType = ResourceType.values).length, b = 0; b < n; ) { ResourceType resourceType = arrayOfResourceType[b];
/* 132 */           j += this.a.gameState.getResources(resourceType); b++; }
/*     */         
/* 134 */         if ((this.d + i) > (j * getMaxTotalResourcesPercentage()) * 0.01F) {
/*     */           return;
/*     */         }
/*     */         
/* 138 */         switch (null.a[ResourceType.values[m].ordinal()]) {
/*     */           case 1:
/* 140 */             resourceItem = Item.D.RESOURCE_VECTOR;
/*     */             break;
/*     */           case 2:
/* 143 */             resourceItem = Item.D.RESOURCE_MATRIX;
/*     */             break;
/*     */           case 3:
/* 146 */             resourceItem = Item.D.RESOURCE_TENSOR;
/*     */             break;
/*     */           case 4:
/* 149 */             resourceItem = Item.D.RESOURCE_INFIAR;
/*     */             break;
/*     */           default:
/* 152 */             resourceItem = Item.D.RESOURCE_SCALAR; break;
/*     */         } 
/*     */         ItemStack itemStack;
/* 155 */         if ((itemStack = this.a.loot.addLoot(paramEnemy, (Item)resourceItem, i)) != null) {
/* 156 */           itemStack.covered = false;
/*     */         }
/* 158 */         this.d += i;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getEnemyInterval() {
/*     */     int i;
/* 166 */     if ((i = (i = this.baseEnemyInterval) + (int)(this.enemyIntervalDeltaPerPower * (this.power - 1))) < this.minEnemyInterval) {
/* 167 */       i = this.minEnemyInterval;
/*     */     }
/* 169 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/* 174 */     return Game.i.localeManager.i18n.format("gmod_descr_enemies_drop_resources", new Object[] { Game.i.localeManager.formatNthEnemy(getEnemyInterval()), Integer.valueOf(getMaxTotalResourcesPercentage()) });
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayMod cpy() {
/* 179 */     EnemiesDropResources enemiesDropResources = new EnemiesDropResources();
/* 180 */     a(enemiesDropResources);
/* 181 */     enemiesDropResources.resourceCountMultiplier = this.resourceCountMultiplier;
/* 182 */     enemiesDropResources.resourceCountDispersion = this.resourceCountDispersion;
/* 183 */     enemiesDropResources.maxResourcesPerPower = this.maxResourcesPerPower;
/* 184 */     enemiesDropResources.baseEnemyInterval = this.baseEnemyInterval;
/* 185 */     enemiesDropResources.enemyIntervalDeltaPerPower = this.enemyIntervalDeltaPerPower;
/* 186 */     enemiesDropResources.minEnemyInterval = this.minEnemyInterval;
/*     */     
/* 188 */     return (GameplayMod)enemiesDropResources;
/*     */   }
/*     */ 
/*     */   
/*     */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/* 193 */     if ((paramGameSystemProvider.map.getMap().getTilesByType(SourceTile.class)).size == 0) {
/* 194 */       return () -> Game.i.localeManager.i18n.get("gpmod_precondition_no_source_tiles_on_map");
/*     */     }
/* 196 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*     */     Map map;
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 203 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(EnemiesDropResources.class, paramString)) == null) {
/*     */       
/* 205 */       this.a = paramGameSystemProvider;
/* 206 */       Arrays.fill(this.b, 0);
/*     */       
/* 208 */       map = paramGameSystemProvider.map.getMap();
/* 209 */       float[] arrayOfFloat = new float[ResourceType.values.length]; byte b; int i;
/* 210 */       for (b = 0, i = (map.getAllTiles()).size; b < i; b++) {
/*     */         Tile tile;
/* 212 */         if (tile = ((Tile[])(map.getAllTiles()).items)[b] instanceof SourceTile) {
/*     */           SourceTile sourceTile;
/* 214 */           float f = (sourceTile = (SourceTile)tile).getResourceDensity();
/*     */           
/* 216 */           int j = 0; ResourceType[] arrayOfResourceType; int k; byte b1;
/* 217 */           for (k = (arrayOfResourceType = ResourceType.values).length, b1 = 0; b1 < k; ) { ResourceType resourceType = arrayOfResourceType[b1];
/* 218 */             j += sourceTile.getResourcesCount(resourceType); b1++; }
/*     */           
/* 220 */           for (k = (arrayOfResourceType = ResourceType.values).length, b1 = 0; b1 < k; ) { ResourceType resourceType = arrayOfResourceType[b1];
/* 221 */             arrayOfFloat[resourceType.ordinal()] = arrayOfFloat[resourceType.ordinal()] + sourceTile.getResourcesCount(resourceType) / j * f; b1++; }
/*     */         
/*     */         } 
/*     */       } 
/* 225 */       for (b = 0; b < arrayOfFloat.length; b++) {
/* 226 */         this.b[b] = (int)(arrayOfFloat[b] * 100.0F);
/*     */       }
/*     */       
/* 229 */       paramGameSystemProvider.events.getListeners(EnemySpawn.class).addStateAffecting(this).setDescription("Fills enemies with resources");
/* 230 */       return true;
/*     */     } 
/*     */     
/* 233 */     ((EnemiesDropResources)map.getMod()).power = this.power;
/* 234 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final EnemiesDropResources applyConfig(JsonValue paramJsonValue) {
/* 240 */     super.applyConfig(paramJsonValue);
/* 241 */     this.resourceCountMultiplier = paramJsonValue.getFloat("resourceCountMultiplier", this.resourceCountMultiplier);
/* 242 */     this.resourceCountDispersion = paramJsonValue.getFloat("resourceCountDispersion", this.resourceCountDispersion);
/* 243 */     this.maxResourcesPerPower = paramJsonValue.getFloat("maxResourcesPerPower", this.maxResourcesPerPower);
/* 244 */     this.baseEnemyInterval = paramJsonValue.getInt("baseEnemyInterval", this.baseEnemyInterval);
/* 245 */     this.enemyIntervalDeltaPerPower = paramJsonValue.getFloat("enemyIntervalDeltaPerPower", this.enemyIntervalDeltaPerPower);
/* 246 */     this.minEnemyInterval = paramJsonValue.getInt("minEnemyInterval", this.minEnemyInterval);
/* 247 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void handleEvent(EnemySpawn paramEnemySpawn) {
/* 252 */     a(paramEnemySpawn.getEnemy());
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable { private static final BonusProvider a;
/*     */     
/*     */     static {
/* 259 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 262 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 267 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("EnemiesDropResources");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */       
/* 276 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new EnemiesDropResources()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(1.0F)).setPowerUpProbabilityMultiplier(0.9F).applyConfig(jsonValue))) != null)
/* 277 */         param1Array1.add(probableBonus); 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\EnemiesDropResources.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */