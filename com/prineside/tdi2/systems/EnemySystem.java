/*     */ package com.prineside.tdi2.systems;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.CameraController;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.SerializableListener;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.Wave;
/*     */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.BuildingType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.SpecialDamageType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemyDespawn;
/*     */ import com.prineside.tdi2.events.game.EnemyReachTarget;
/*     */ import com.prineside.tdi2.events.game.PathfindingRebuild;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.pathfinding.MoveSide;
/*     */ import com.prineside.tdi2.pathfinding.Path;
/*     */ import com.prineside.tdi2.pathfinding.PathNode;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.tiles.SpawnTile;
/*     */ import com.prineside.tdi2.utils.EntityUtils;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ 
/*     */ @REGS
/*     */ public final class EnemySystem extends GameSystem {
/*     */   public static final int RANDOM_SIDE_SHIFT = -1;
/*     */   public static final int MIDDLE_SIDE_SHIFT = 5;
/*     */   public boolean[] flyingEnemy;
/*     */   @NAGS
/*     */   public Color[] enemyColor;
/*     */   @NAGS
/*     */   public TextureRegion[] enemyTexture;
/*     */   @NAGS
/*     */   public TextureRegion[] enemyHighlightTexture;
/*     */   @NAGS
/*     */   public TextureRegion[] enemyEmojiTexture;
/*     */   public boolean[][] enemyDamageVulnerability;
/*     */   public boolean[][] enemySpecialDamageVulnerability;
/*     */   
/*  72 */   public EnemySystem() { this.flyingEnemy = new boolean[EnemyType.values.length];
/*     */     
/*  74 */     this.flyingEnemy[EnemyType.HELI.ordinal()] = true;
/*  75 */     this.flyingEnemy[EnemyType.JET.ordinal()] = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  82 */     this.enemyColor = new Color[EnemyType.values.length];
/*  83 */     this.enemyTexture = new TextureRegion[EnemyType.values.length];
/*  84 */     this.enemyHighlightTexture = new TextureRegion[EnemyType.values.length];
/*  85 */     this.enemyEmojiTexture = new TextureRegion[EnemyType.values.length];
/*     */     
/*  87 */     if (Game.i.assetManager != null) {
/*  88 */       EnemyType[] arrayOfEnemyType1; int j; byte b1; for (j = (arrayOfEnemyType1 = EnemyType.values).length, b1 = 0; b1 < j; ) { EnemyType enemyType = arrayOfEnemyType1[b1];
/*  89 */         this.enemyColor[enemyType.ordinal()] = Game.i.enemyManager.getFactory(enemyType).getColor();
/*  90 */         this.enemyTexture[enemyType.ordinal()] = Game.i.enemyManager.getFactory(enemyType).getTexture();
/*  91 */         this.enemyHighlightTexture[enemyType.ordinal()] = Game.i.enemyManager.getFactory(enemyType).getHighlightTexture();
/*  92 */         this.enemyEmojiTexture[enemyType.ordinal()] = Game.i.enemyManager.getFactory(enemyType).getEmojiTexture();
/*     */         
/*     */         b1++; }
/*     */     
/*     */     } 
/*  97 */     this.enemyDamageVulnerability = new boolean[EnemyType.values.length][DamageType.values.length]; boolean[][] arrayOfBoolean; int i;
/*     */     byte b;
/*  99 */     for (i = (arrayOfBoolean = this.enemyDamageVulnerability).length, b = 0; b < i; b++) {
/* 100 */       boolean[] arrayOfBoolean1; Arrays.fill(arrayOfBoolean1 = arrayOfBoolean[b], true);
/*     */     } 
/*     */     
/* 103 */     this.enemyDamageVulnerability[EnemyType.ARMORED.ordinal()][DamageType.ELECTRICITY.ordinal()] = false;
/* 104 */     this.enemyDamageVulnerability[EnemyType.HEALER.ordinal()][DamageType.FIRE.ordinal()] = false;
/* 105 */     this.enemyDamageVulnerability[EnemyType.TOXIC.ordinal()][DamageType.POISON.ordinal()] = false;
/*     */ 
/*     */     
/* 108 */     this.enemySpecialDamageVulnerability = new boolean[EnemyType.values.length][SpecialDamageType.values.length];
/*     */     
/* 110 */     for (i = (arrayOfBoolean = this.enemySpecialDamageVulnerability).length, b = 0; b < i; b++) {
/* 111 */       boolean[] arrayOfBoolean1; Arrays.fill(arrayOfBoolean1 = arrayOfBoolean[b], true);
/*     */     } 
/*     */     
/* 114 */     this.enemySpecialDamageVulnerability[EnemyType.BROOT_BOSS.ordinal()][SpecialDamageType.KILLSHOT.ordinal()] = false;
/*     */     
/* 116 */     this.enemySpecialDamageVulnerability[EnemyType.CONSTRUCTOR_BOSS.ordinal()][SpecialDamageType.KILLSHOT.ordinal()] = false;
/*     */     
/* 118 */     this.enemySpecialDamageVulnerability[EnemyType.METAPHOR_BOSS.ordinal()][SpecialDamageType.KILLSHOT.ordinal()] = false;
/* 119 */     this.enemySpecialDamageVulnerability[EnemyType.METAPHOR_BOSS_CREEP.ordinal()][SpecialDamageType.KILLSHOT.ordinal()] = false;
/*     */     
/* 121 */     this.enemySpecialDamageVulnerability[EnemyType.MOBCHAIN_BOSS_HEAD.ordinal()][SpecialDamageType.KILLSHOT.ordinal()] = false;
/* 122 */     this.enemySpecialDamageVulnerability[EnemyType.MOBCHAIN_BOSS_BODY.ordinal()][SpecialDamageType.KILLSHOT.ordinal()] = false;
/* 123 */     this.enemySpecialDamageVulnerability[EnemyType.MOBCHAIN_BOSS_CREEP.ordinal()][SpecialDamageType.KILLSHOT.ordinal()] = false;
/*     */     
/* 125 */     this.enemySpecialDamageVulnerability[EnemyType.SNAKE_BOSS_HEAD.ordinal()][SpecialDamageType.KILLSHOT.ordinal()] = false;
/* 126 */     this.enemySpecialDamageVulnerability[EnemyType.SNAKE_BOSS_BODY.ordinal()][SpecialDamageType.KILLSHOT.ordinal()] = false;
/* 127 */     this.enemySpecialDamageVulnerability[EnemyType.SNAKE_BOSS_TAIL.ordinal()][SpecialDamageType.KILLSHOT.ordinal()] = false;
/*     */ 
/*     */     
/* 130 */     this.enemyBuffVulnerability = new float[EnemyType.values.length][BuffType.values.length];
/*     */     float[][] arrayOfFloat;
/* 132 */     for (i = (arrayOfFloat = this.enemyBuffVulnerability).length, b = 0; b < i; b++) {
/* 133 */       float[] arrayOfFloat1; Arrays.fill(arrayOfFloat1 = arrayOfFloat[b], 1.0F);
/*     */     } 
/*     */     
/* 136 */     this.enemyBuffVulnerability[EnemyType.HEALER.ordinal()][BuffType.BURN.ordinal()] = 0.0F;
/* 137 */     this.enemyBuffVulnerability[EnemyType.TOXIC.ordinal()][BuffType.POISON.ordinal()] = 0.0F;
/* 138 */     this.enemyBuffVulnerability[EnemyType.ICY.ordinal()][BuffType.BURN.ordinal()] = 1.5F;
/*     */     
/* 140 */     this.enemyBuffVulnerability[EnemyType.BROOT_BOSS.ordinal()][BuffType.STUN.ordinal()] = 0.0F;
/* 141 */     this.enemyBuffVulnerability[EnemyType.BROOT_BOSS.ordinal()][BuffType.FREEZING.ordinal()] = 0.0F;
/* 142 */     this.enemyBuffVulnerability[EnemyType.BROOT_BOSS.ordinal()][BuffType.BLIZZARD.ordinal()] = 0.0F;
/* 143 */     this.enemyBuffVulnerability[EnemyType.BROOT_BOSS.ordinal()][BuffType.SNOWBALL.ordinal()] = 0.0F;
/*     */     
/* 145 */     this.enemyBuffVulnerability[EnemyType.CONSTRUCTOR_BOSS.ordinal()][BuffType.STUN.ordinal()] = 0.0F;
/* 146 */     this.enemyBuffVulnerability[EnemyType.CONSTRUCTOR_BOSS.ordinal()][BuffType.FREEZING.ordinal()] = 0.0F;
/* 147 */     this.enemyBuffVulnerability[EnemyType.CONSTRUCTOR_BOSS.ordinal()][BuffType.THROW_BACK.ordinal()] = 0.0F;
/* 148 */     this.enemyBuffVulnerability[EnemyType.CONSTRUCTOR_BOSS.ordinal()][BuffType.SNOWBALL.ordinal()] = 0.0F;
/*     */     EnemyType[] arrayOfEnemyType;
/* 150 */     for (arrayOfEnemyType = new EnemyType[] { EnemyType.METAPHOR_BOSS, EnemyType.METAPHOR_BOSS_CREEP }, b = 0; b < 2; ) { EnemyType enemyType = arrayOfEnemyType[b];
/* 151 */       this.enemyBuffVulnerability[enemyType.ordinal()][BuffType.STUN.ordinal()] = 0.0F;
/* 152 */       this.enemyBuffVulnerability[enemyType.ordinal()][BuffType.FREEZING.ordinal()] = 0.0F;
/* 153 */       this.enemyBuffVulnerability[enemyType.ordinal()][BuffType.THROW_BACK.ordinal()] = 0.0F;
/* 154 */       this.enemyBuffVulnerability[enemyType.ordinal()][BuffType.BLIZZARD.ordinal()] = 0.0F;
/* 155 */       this.enemyBuffVulnerability[enemyType.ordinal()][BuffType.REGENERATION.ordinal()] = 0.0F;
/* 156 */       this.enemyBuffVulnerability[enemyType.ordinal()][BuffType.SNOWBALL.ordinal()] = 0.0F;
/*     */       b++; }
/*     */     
/* 159 */     for (arrayOfEnemyType = new EnemyType[] { EnemyType.MOBCHAIN_BOSS_BODY, EnemyType.MOBCHAIN_BOSS_CREEP, EnemyType.MOBCHAIN_BOSS_HEAD }, b = 0; b < 3; ) { EnemyType enemyType = arrayOfEnemyType[b];
/* 160 */       this.enemyBuffVulnerability[enemyType.ordinal()][BuffType.THROW_BACK.ordinal()] = 0.0F;
/* 161 */       this.enemyBuffVulnerability[enemyType.ordinal()][BuffType.SNOWBALL.ordinal()] = 0.0F;
/* 162 */       this.enemyBuffVulnerability[enemyType.ordinal()][BuffType.BLIZZARD.ordinal()] = 0.0F;
/* 163 */       this.enemyBuffVulnerability[enemyType.ordinal()][BuffType.FREEZING.ordinal()] = 0.0F;
/* 164 */       this.enemyBuffVulnerability[enemyType.ordinal()][BuffType.STUN.ordinal()] = 0.0F;
/*     */       b++; }
/*     */     
/* 167 */     for (arrayOfEnemyType = new EnemyType[] { EnemyType.SNAKE_BOSS_BODY, EnemyType.SNAKE_BOSS_HEAD, EnemyType.SNAKE_BOSS_TAIL }, b = 0; b < 3; ) { EnemyType enemyType = arrayOfEnemyType[b];
/* 168 */       this.enemyBuffVulnerability[enemyType.ordinal()][BuffType.STUN.ordinal()] = 0.0F;
/* 169 */       this.enemyBuffVulnerability[enemyType.ordinal()][BuffType.POISON.ordinal()] = 0.0F;
/* 170 */       this.enemyBuffVulnerability[enemyType.ordinal()][BuffType.BLIZZARD.ordinal()] = 0.0F;
/* 171 */       this.enemyBuffVulnerability[enemyType.ordinal()][BuffType.FREEZING.ordinal()] = 0.0F;
/* 172 */       this.enemyBuffVulnerability[enemyType.ordinal()][BuffType.SNOWBALL.ordinal()] = 0.0F;
/* 173 */       this.enemyBuffVulnerability[enemyType.ordinal()][BuffType.THROW_BACK.ordinal()] = 0.0F;
/*     */       
/*     */       b++; }
/*     */     
/* 177 */     this.a = new DelayedRemovalArray(false, 8, Enemy.EnemyReference.class);
/*     */     
/* 179 */     this.b = 1;
/* 180 */     this.c = new IntArray();
/* 181 */     this.d = false;
/*     */     
/* 183 */     this.e = new Enemy.EnemyReference[16];
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
/* 200 */     this.g = new OnPathfindingRebuild(this, (byte)0);
/* 201 */     this.h = new OnEnemyDespawn(this, (byte)0);
/*     */     
/* 203 */     this.i = new Array(false, 64, Enemy.EnemyReference.class); }
/*     */   public float[][] enemyBuffVulnerability; private DelayedRemovalArray<Enemy.EnemyReference> a; private int b; private IntArray c; @NAGS
/*     */   private boolean d; private Enemy.EnemyReference[] e; private static final Comparator<Enemy.EnemyReference> f; private OnPathfindingRebuild g; private OnEnemyDespawn h; @NAGS
/*     */   private final Array<Enemy.EnemyReference> i; static { TLog.forClass(EnemySystem.class);
/* 207 */     f = ((paramEnemyReference1, paramEnemyReference2) -> Float.compare((paramEnemyReference1.enemy.graphPath == null) ? 0.0F : (paramEnemyReference1.enemy.graphPath.getLengthInTiles() - paramEnemyReference1.enemy.passedTiles), (paramEnemyReference2.enemy.graphPath == null) ? 0.0F : (paramEnemyReference2.enemy.graphPath.getLengthInTiles() - paramEnemyReference2.enemy.passedTiles))); } public final void write(Kryo paramKryo, Output paramOutput) { super.write(paramKryo, paramOutput);
/* 208 */     paramKryo.writeObject(paramOutput, this.flyingEnemy);
/* 209 */     paramKryo.writeObject(paramOutput, this.enemyDamageVulnerability);
/* 210 */     paramKryo.writeObject(paramOutput, this.enemyBuffVulnerability);
/* 211 */     paramKryo.writeObject(paramOutput, this.a);
/* 212 */     paramOutput.writeVarInt(this.b, true);
/* 213 */     paramKryo.writeObject(paramOutput, this.c);
/* 214 */     paramKryo.writeObject(paramOutput, this.e);
/* 215 */     paramKryo.writeObject(paramOutput, this.g);
/* 216 */     paramKryo.writeObject(paramOutput, this.h); }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/* 221 */     super.read(paramKryo, paramInput);
/* 222 */     this.flyingEnemy = (boolean[])paramKryo.readObject(paramInput, boolean[].class);
/* 223 */     this.enemyDamageVulnerability = (boolean[][])paramKryo.readObject(paramInput, boolean[][].class);
/* 224 */     this.enemyBuffVulnerability = (float[][])paramKryo.readObject(paramInput, float[][].class);
/* 225 */     this.a = (DelayedRemovalArray<Enemy.EnemyReference>)paramKryo.readObject(paramInput, DelayedRemovalArray.class);
/* 226 */     this.b = paramInput.readVarInt(true);
/* 227 */     this.c = (IntArray)paramKryo.readObject(paramInput, IntArray.class);
/* 228 */     this.e = (Enemy.EnemyReference[])paramKryo.readObject(paramInput, Enemy.EnemyReference[].class);
/* 229 */     this.g = (OnPathfindingRebuild)paramKryo.readObject(paramInput, OnPathfindingRebuild.class);
/* 230 */     this.h = (OnEnemyDespawn)paramKryo.readObject(paramInput, OnEnemyDespawn.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/* 235 */     return true;
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
/*     */   public final void setup() {
/* 270 */     if (!this.S.CFG.headless) a(); 
/*     */   }
/*     */   
/*     */   private void a() {
/* 274 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.ENEMY_DRAW, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> draw(paramBatch, paramFloat2, paramFloat3)))
/*     */ 
/*     */         
/* 277 */         .setName("Enemy-draw"));
/*     */     
/* 279 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.ENEMY_DRAW_HEALTH, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> {
/*     */ 
/*     */ 
/*     */             
/*     */             if (this.S._input.cameraController.zoom < 2.5D) {
/*     */               drawEnemyHealth(paramBatch);
/*     */             }
/* 286 */           })).setName("Enemy-drawHealth"));
/*     */   }
/*     */ 
/*     */   
/*     */   public final void postSetup() {
/* 291 */     this.S.events.getListeners(PathfindingRebuild.class).addStateAffecting(this.g).setDescription("EnemySystem");
/* 292 */     this.S.events.getListeners(EnemyDespawn.class).addStateAffectingWithPriority(this.h, -3000)
/* 293 */       .setName("EnemySystem - unregister despawned")
/* 294 */       .setDescription("Unregisters despawned enemies");
/*     */     
/* 296 */     b();
/*     */   }
/*     */   
/*     */   private void b() {
/*     */     SimpleDateFormat simpleDateFormat;
/* 301 */     String str = (simpleDateFormat = new SimpleDateFormat("dd/MM", Locale.US)).format(new Date());
/* 302 */     if (this.S.gameValue.getBooleanValue(GameValueType.EMOJI_ENEMIES) || str.equals("01/04")) {
/* 303 */       this.d = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void postStateRestore() {
/* 309 */     super.postStateRestore();
/*     */     
/* 311 */     b();
/* 312 */     a();
/*     */   }
/*     */   
/*     */   private int c() {
/* 316 */     return this.S.gameState.randomInt(11);
/*     */   }
/*     */   
/*     */   public final void registerWithRandomSideShift(Enemy paramEnemy) {
/* 320 */     registerWithSideShift(paramEnemy, c());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Enemy.EnemyReference getReference(Enemy paramEnemy) {
/* 328 */     if (paramEnemy == null) return Enemy.EnemyReference.NULL; 
/* 329 */     if (paramEnemy.id == 0) throw new IllegalArgumentException("Enemy is not registered: " + paramEnemy); 
/* 330 */     return this.e[paramEnemy.id];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Enemy paramEnemy) {
/*     */     int i;
/* 337 */     if (paramEnemy.id != 0) throw new IllegalArgumentException("Enemy " + paramEnemy + " is already registered with id " + paramEnemy.id);
/*     */ 
/*     */     
/* 340 */     if (this.c.size != 0) {
/* 341 */       this.c.sort();
/* 342 */       i = this.c.removeIndex(0);
/*     */     } else {
/* 344 */       i = this.b;
/* 345 */       this.b++;
/*     */     } 
/* 347 */     paramEnemy.id = i;
/*     */     
/*     */     Enemy.EnemyReference enemyReference;
/* 350 */     (enemyReference = new Enemy.EnemyReference()).enemy = paramEnemy;
/* 351 */     if (i >= this.e.length) {
/* 352 */       Enemy.EnemyReference[] arrayOfEnemyReference = new Enemy.EnemyReference[MathUtils.nextPowerOfTwo(i + 1)];
/* 353 */       System.arraycopy(this.e, 0, arrayOfEnemyReference, 0, this.e.length);
/* 354 */       this.e = arrayOfEnemyReference;
/*     */     } 
/* 356 */     this.e[i] = enemyReference;
/*     */   }
/*     */   
/*     */   public final void registerWithSideShift(Enemy paramEnemy, int paramInt) {
/* 360 */     if (paramEnemy.spawnTile == null) {
/* 361 */       throw new IllegalArgumentException("Enemy must have spawnTile set");
/*     */     }
/*     */     
/* 364 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 366 */     a(paramEnemy);
/*     */     
/* 368 */     paramEnemy.setRegistered(this.S);
/*     */     
/* 370 */     if (paramInt == -1) {
/* 371 */       paramInt = c();
/*     */     }
/* 373 */     paramEnemy.graphPath = this.S.pathfinding.findPathToTargetTile((Tile)paramEnemy.spawnTile, paramEnemy.type);
/* 374 */     paramEnemy.sideShiftIndex = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void registerWithPath(Enemy paramEnemy, @Null Path paramPath, int paramInt, float paramFloat) {
/* 379 */     if (paramEnemy.spawnTile == null) {
/* 380 */       throw new IllegalArgumentException("Enemy must have spawnTile set");
/*     */     }
/*     */     
/* 383 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 385 */     a(paramEnemy);
/*     */     
/* 387 */     paramEnemy.setRegistered(this.S);
/*     */     
/* 389 */     if (paramPath != null && 
/* 390 */       paramInt == -1) {
/* 391 */       paramInt = c();
/*     */     }
/*     */     
/* 394 */     paramEnemy.graphPath = paramPath;
/* 395 */     paramEnemy.sideShiftIndex = paramInt;
/* 396 */     paramEnemy.passedTiles = paramFloat;
/* 397 */     paramEnemy.sumPassedTiles = paramFloat;
/*     */     
/* 399 */     if (EnemyType.isBoss(paramEnemy.type) && paramEnemy.hasDrawPriority()) {
/* 400 */       paramEnemy.healthBarScale = 2.0F;
/*     */     }
/*     */   }
/*     */   
/*     */   private void b(Enemy paramEnemy) {
/* 405 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 407 */     Enemy.EnemyReference enemyReference = getReference(paramEnemy);
/*     */     
/* 409 */     paramEnemy.setUnregistered();
/* 410 */     this.a.removeValue(enemyReference, true);
/*     */ 
/*     */     
/* 413 */     enemyReference.enemy = null;
/* 414 */     this.e[paramEnemy.id] = null;
/* 415 */     this.c.add(paramEnemy.id);
/* 416 */     paramEnemy.id = 0;
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
/*     */ 
/*     */   
/*     */   public final void queueAllEnemiesPathfinding() {
/* 432 */     int i = this.S.gameValue.getIntValue(GameValueType.ENEMIES_MAX_PATH_SEARCHES);
/*     */     
/* 434 */     this.a.clear();
/* 435 */     for (byte b = 0; b < this.S.map.spawnedEnemies.size; b++) {
/*     */       Enemy.EnemyReference enemyReference;
/*     */       Enemy enemy;
/* 438 */       if ((enemy = (enemyReference = ((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b]).enemy) != null && !enemy.ignorePathfinding && enemy.pathSearches < i && enemy.graphPath != null) {
/* 439 */         this.a.add(enemyReference);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void addEnemyWithFirstSpawn(Enemy paramEnemy, Tile paramTile, int paramInt) {
/* 450 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 452 */     paramEnemy.spawnTile = (SpawnTile)this.S.map.getMap().getTilesByType(SpawnTile.class).first();
/* 453 */     paramEnemy.wave = null;
/* 454 */     paramEnemy.graphPath = this.S.pathfinding.findPathToTargetTile(paramTile, paramEnemy.type);
/* 455 */     if (paramEnemy.graphPath == null) {
/* 456 */       throw new IllegalArgumentException("Can't find path for " + paramEnemy.type + " from " + paramTile);
/*     */     }
/* 458 */     registerWithPath(paramEnemy, paramEnemy.graphPath, paramInt, 0.0F);
/*     */     
/* 460 */     this.S.loot.fillWithLoot(paramEnemy);
/* 461 */     this.S.map.spawnEnemy(paramEnemy);
/*     */     
/* 463 */     paramEnemy.setPositionToPath();
/*     */   }
/*     */   
/*     */   public final void addStaticEnemy(Enemy paramEnemy, float paramFloat1, float paramFloat2) {
/* 467 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 469 */     paramEnemy.spawnTile = (SpawnTile)this.S.map.getMap().getTilesByType(SpawnTile.class).first();
/* 470 */     paramEnemy.wave = null;
/* 471 */     registerWithPath(paramEnemy, paramEnemy.graphPath, 5, 0.0F);
/*     */     
/* 473 */     this.S.map.spawnEnemy(paramEnemy);
/* 474 */     paramEnemy.setPosition(paramFloat1, paramFloat2);
/*     */   }
/*     */   
/*     */   public final void addEnemy(Enemy paramEnemy, SpawnTile paramSpawnTile, int paramInt, Wave paramWave, float paramFloat) {
/* 478 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 480 */     paramEnemy.spawnTile = paramSpawnTile;
/* 481 */     paramEnemy.wave = paramWave;
/* 482 */     registerWithSideShift(paramEnemy, paramInt);
/* 483 */     this.S.loot.fillWithLoot(paramEnemy);
/* 484 */     this.S.map.spawnEnemy(paramEnemy);
/* 485 */     paramEnemy.passedTiles = paramFloat;
/*     */     
/* 487 */     paramEnemy.setPositionToPath();
/*     */   }
/*     */   
/*     */   public final void addEnemyWithPath(Enemy paramEnemy, @Null SpawnTile paramSpawnTile, @Null Path paramPath, int paramInt, @Null Wave paramWave, float paramFloat) {
/* 491 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 493 */     paramEnemy.spawnTile = paramSpawnTile;
/* 494 */     paramEnemy.wave = paramWave;
/*     */     
/* 496 */     registerWithPath(paramEnemy, paramPath, paramInt, paramFloat);
/* 497 */     this.S.loot.fillWithLoot(paramEnemy);
/* 498 */     this.S.map.spawnEnemy(paramEnemy);
/* 499 */     paramEnemy.passedTiles = paramFloat;
/*     */     
/* 501 */     paramEnemy.setPositionToPath();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 521 */     long l = Game.getRealTickCount();
/* 522 */     this.a.begin(); byte b; int i;
/* 523 */     for (b = 0, i = this.a.size; b < i; b++) {
/*     */       Enemy enemy;
/*     */       
/* 526 */       if ((enemy = (((Enemy.EnemyReference[])this.a.items)[b]).enemy) == null || enemy.disabled.isTrue() || !enemy.dynamicPathfindingAllowed()) {
/*     */         
/* 528 */         this.a.removeIndex(b);
/*     */       }
/*     */       else {
/*     */         
/* 532 */         if (enemy.passedTiles < -0.499999F)
/*     */         {
/* 534 */           enemy.passedTiles = -0.499999F;
/*     */         }
/*     */         
/* 537 */         int j = (int)(enemy.passedTiles + 0.5F);
/*     */         float f;
/* 539 */         if ((f = enemy.getPassedTilesDelta(paramFloat)) >= 0.0F) {
/* 540 */           int k = (int)(enemy.passedTiles + 0.5F + f);
/*     */           
/* 542 */           if (j != k) {
/*     */             SpawnTile spawnTile;
/* 544 */             PathNode pathNode = null;
/* 545 */             if (enemy.graphPath.getCount() > k) {
/* 546 */               pathNode = enemy.graphPath.getByIdx(k);
/*     */             }
/*     */             
/*     */             Tile tile;
/*     */             
/* 551 */             if ((tile = enemy.getCurrentTile()) == null) {
/* 552 */               spawnTile = enemy.spawnTile;
/*     */             }
/* 554 */             k = enemy.graphPath.getMoveSideByPassedTiles(enemy.passedTiles);
/*     */             
/* 556 */             if (spawnTile == null)
/*     */             
/* 558 */             { this.a.removeIndex(b); }
/*     */             
/*     */             else
/*     */             
/* 562 */             { enemy.graphPath = this.S.pathfinding.findPathToTargetTile((Tile)spawnTile, enemy.type);
/*     */ 
/*     */               
/* 565 */               if (pathNode != null) {
/* 566 */                 if (enemy.graphPath.getByIdx(1).getX() == pathNode.getX() && enemy.graphPath.getByIdx(1).getY() == pathNode.getY()) {
/*     */                   
/* 568 */                   enemy.graphPath = enemy.graphPath.copyWithStartingMoveSide(k);
/* 569 */                   enemy.passedTiles -= (int)enemy.passedTiles;
/*     */                 } else {
/*     */                   byte b1;
/*     */ 
/*     */                   
/*     */                   try {
/* 575 */                     b1 = MoveSide.calculateMoveSides(enemy.graphPath.getByIdx(0), pathNode, enemy.graphPath.getByIdx(1));
/* 576 */                   } catch (Exception exception) {
/*     */                     
/* 578 */                     b1 = MoveSide.calculateMoveSides(enemy.graphPath.getByIdx(0), null, enemy.graphPath.getByIdx(1));
/*     */                   } 
/* 580 */                   enemy.graphPath = enemy.graphPath.copyWithStartingMoveSide(b1);
/* 581 */                   enemy.passedTiles = -0.4999F;
/*     */                 } 
/*     */               }
/*     */               
/* 585 */               enemy.pathSearches++;
/* 586 */               this.a.removeIndex(b);
/*     */ 
/*     */               
/* 589 */               if (enemy.passedTiles < 0.0F)
/* 590 */                 enemy.sideShiftIndex = 11 - enemy.sideShiftIndex - 1;  } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 594 */     }  this.a.end();
/* 595 */     if (Game.i.debugManager != null) Game.i.debugManager.registerFrameJob("Pathfinding", Game.getRealTickCount() - l);
/*     */     
/* 597 */     EntityUtils.removeNullRefs((Array)this.S.map.spawnedEnemies);
/* 598 */     this.S.TSH.sort.sort((Array)this.S.map.spawnedEnemies, f);
/*     */     
/* 600 */     this.S.map.spawnedEnemies.begin();
/* 601 */     for (b = 0, i = this.S.map.spawnedEnemies.size; b < i; b++) {
/*     */       Enemy enemy;
/* 603 */       if ((enemy = (((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b]).enemy) != null)
/*     */       {
/* 605 */         if (enemy.disabled.isTrue() || enemy.graphPath == null) {
/*     */           
/* 607 */           enemy.update(paramFloat);
/*     */         }
/*     */         else {
/*     */           
/* 611 */           Path path = enemy.graphPath;
/*     */           
/* 613 */           float f = enemy.getPassedTilesDelta(paramFloat);
/* 614 */           enemy.passedTiles += f;
/* 615 */           enemy.sumPassedTiles += f;
/*     */           
/* 617 */           if (enemy.passedTiles < -0.49999F) {
/* 618 */             f = -0.5F - enemy.passedTiles;
/* 619 */             enemy.sumPassedTiles += f;
/* 620 */             enemy.passedTiles = -0.5F;
/*     */           } 
/*     */           
/* 623 */           if (enemy.passedTiles >= path.getLengthInTiles()) {
/*     */             
/* 625 */             f = enemy.getBaseDamage();
/* 626 */             if (enemy.hasBuffsByType(BuffType.NO_DAMAGE)) f = 0.0F; 
/* 627 */             int j = 0;
/* 628 */             if (f > 0.0F) {
/* 629 */               if (f % 1.0F == 0.0F) {
/*     */                 
/* 631 */                 j = MathUtils.round(f);
/*     */               } else {
/*     */                 
/* 634 */                 j = (int)f;
/* 635 */                 if (this.S.gameState.randomFloat() < f % 1.0F) {
/* 636 */                   j++;
/*     */                 }
/*     */               } 
/*     */             }
/*     */             
/* 641 */             EnemyReachTarget enemyReachTarget = new EnemyReachTarget(enemy, f, j);
/* 642 */             this.S.events.getListeners(EnemyReachTarget.class).trigger((Event)enemyReachTarget);
/*     */             
/* 644 */             if (!enemyReachTarget.isCancelled()) {
/* 645 */               this.S.map.a(enemy);
/*     */             } else {
/* 647 */               enemy.setPositionToPath();
/* 648 */               enemy.update(paramFloat);
/*     */             } 
/* 650 */           } else if (enemy.passedTiles >= -0.5F) {
/*     */ 
/*     */             
/* 653 */             enemy.setPositionToPath();
/*     */ 
/*     */             
/* 656 */             enemy.update(paramFloat);
/*     */           } else {
/*     */             
/* 659 */             throw new IllegalStateException(enemy.passedTiles + " passed tiles");
/*     */           } 
/*     */         }  } 
/* 662 */     }  this.S.map.spawnedEnemies.end();
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/* 667 */     return "Enemy";
/*     */   }
/*     */   
/*     */   public final boolean isEmojiEnemies() {
/* 671 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Color getColor(EnemyType paramEnemyType) {
/* 678 */     return this.enemyColor[paramEnemyType.ordinal()];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final TextureRegion getTexture(EnemyType paramEnemyType) {
/* 685 */     return this.enemyTexture[paramEnemyType.ordinal()];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final TextureRegion getHighlightTexture(EnemyType paramEnemyType) {
/* 692 */     return this.enemyHighlightTexture[paramEnemyType.ordinal()];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final TextureRegion getEmojiTexture(EnemyType paramEnemyType) {
/* 699 */     return this.enemyEmojiTexture[paramEnemyType.ordinal()];
/*     */   }
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat1, float paramFloat2) {
/* 703 */     this.i.clear();
/* 704 */     this.i.addAll((Array)this.S.map.spawnedEnemies);
/* 705 */     EntityUtils.removeNullRefs(this.i);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 711 */     Threads.sortGdxArray(this.i, f);
/*     */ 
/*     */     
/* 714 */     for (byte b = 0; b < this.i.size; b++) {
/* 715 */       (((Enemy.EnemyReference[])this.i.items)[b]).enemy.applyDrawInterpolation(paramFloat2);
/*     */     }
/*     */     
/* 718 */     CameraController cameraController = this.S._input.cameraController; int i;
/* 719 */     for (i = this.i.size - 1; i >= 0; i--) {
/*     */       Enemy enemy;
/* 721 */       if (!(enemy = (((Enemy.EnemyReference[])this.i.items)[i]).enemy).hasDrawPriority() && !enemy.invisible.isTrue() && 
/* 722 */         cameraController.isPointVisible(enemy.drawPosition, enemy.getSize())) {
/* 723 */         enemy.drawBatch(paramBatch, paramFloat1);
/*     */       }
/*     */     } 
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
/* 765 */     for (i = this.i.size - 1; i >= 0; i--) {
/* 766 */       Enemy enemy = (((Enemy.EnemyReference[])this.i.items)[i]).enemy;
/* 767 */       if (cameraController.isPointVisible(enemy.drawPosition, enemy.getSize()) && enemy.hasDrawPriority() && !enemy.invisible.isTrue()) {
/* 768 */         enemy.drawBatch(paramBatch, paramFloat1);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 773 */     if (Game.i.settingsManager.isParticlesDrawing()) {
/* 774 */       paramBatch.flush();
/* 775 */       paramBatch.setBlendFunction(770, 1);
/* 776 */       for (i = this.i.size - 1; i >= 0; i--) {
/* 777 */         Enemy enemy = (((Enemy.EnemyReference[])this.i.items)[i]).enemy;
/* 778 */         if (cameraController.isPointVisible(enemy.drawPosition, enemy.getSize()) && !enemy.invisible.isTrue()) {
/* 779 */           enemy.drawBatchAdditive(paramBatch, paramFloat1);
/*     */         }
/*     */       } 
/*     */       
/* 783 */       paramBatch.flush();
/* 784 */       paramBatch.setBlendFunction(770, 771);
/*     */     } 
/*     */     
/* 787 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_ENEMIES_INFO) != 0.0D) {
/* 788 */       BitmapFont bitmapFont = Game.i.assetManager.getSmallDebugFont();
/* 789 */       int k = this.S.gameValue.getIntValue(GameValueType.ENEMIES_MAX_PATH_SEARCHES);
/* 790 */       bitmapFont.setColor(MaterialColor.BLUE.P500); byte b1; int j;
/* 791 */       for (b1 = 0, j = this.i.size; b1 < j; b1++) {
/* 792 */         Enemy enemy = (((Enemy.EnemyReference[])this.i.items)[b1]).enemy;
/* 793 */         bitmapFont.draw(paramBatch, "PT:" + (StrictMath.round(enemy.passedTiles * 100.0F) / 100.0F) + " SPD:" + (StrictMath.round(enemy.getBuffedSpeed() * 100.0F) * 0.01F) + " PS: " + enemy.pathSearches + "/" + k, (enemy.getPosition()).x - 50.0F, (enemy.getPosition()).y + 30.0F, 100.0F, 1, false);
/* 794 */         bitmapFont.draw(paramBatch, "EN:" + enemy.otherEnemiesNearby, (enemy.getPosition()).x - 50.0F, (enemy.getPosition()).y + 45.0F, 100.0F, 1, false);
/*     */       } 
/* 796 */       bitmapFont.setColor(Color.WHITE);
/*     */     } 
/* 798 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_UNITS_BBOX) != 0.0D) {
/* 799 */       paramBatch.end();
/* 800 */       Game.i.renderingManager.shapeRenderer.setProjectionMatrix(paramBatch.getProjectionMatrix());
/* 801 */       Game.i.renderingManager.shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
/* 802 */       Game.i.renderingManager.shapeRenderer.setColor(MaterialColor.ORANGE.P500.cpy());
/* 803 */       (Game.i.renderingManager.shapeRenderer.getColor()).a = 0.5F; int j;
/* 804 */       for (i = 0, j = this.i.size; i < j; i++) {
/* 805 */         Enemy enemy = (((Enemy.EnemyReference[])this.i.items)[i]).enemy;
/* 806 */         Game.i.renderingManager.shapeRenderer.circle((enemy.getPosition()).x, (enemy.getPosition()).y, enemy.getSize());
/*     */       } 
/* 808 */       Game.i.renderingManager.shapeRenderer.end();
/* 809 */       paramBatch.begin();
/*     */     } 
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
/* 831 */     paramBatch.setColor(Color.WHITE);
/*     */     
/* 833 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_ENEMY_PATHS) != 0.0D) {
/* 834 */       paramBatch.end();
/*     */       
/* 836 */       Game.i.renderingManager.shapeRenderer.setProjectionMatrix(paramBatch.getProjectionMatrix());
/* 837 */       Game.i.renderingManager.shapeRenderer.begin(ShapeRenderer.ShapeType.Line); int j;
/* 838 */       for (i = 0, j = this.i.size; i < j; i++) {
/*     */         Enemy enemy;
/* 840 */         if ((enemy = (((Enemy.EnemyReference[])this.i.items)[i]).enemy).graphPath != null) {
/* 841 */           Vector2 vector2 = new Vector2();
/* 842 */           enemy.graphPath.getPosition(0.0F, enemy.sideShiftIndex, vector2);
/*     */           
/* 844 */           double d = 0.0D;
/* 845 */           while (d <= enemy.graphPath.getLengthInTiles()) {
/* 846 */             float f1 = vector2.x;
/* 847 */             float f2 = vector2.y;
/* 848 */             d += 0.02500000037252903D;
/* 849 */             enemy.graphPath.getPosition((float)d, enemy.sideShiftIndex, vector2);
/* 850 */             if (d < enemy.passedTiles) {
/* 851 */               Game.i.renderingManager.shapeRenderer.line(f1, f2, vector2.x, vector2.y, MaterialColor.CYAN.P500, MaterialColor.CYAN.P500); continue;
/*     */             } 
/* 853 */             Game.i.renderingManager.shapeRenderer.line(f1, f2, vector2.x, vector2.y, MaterialColor.PURPLE.P500, MaterialColor.PURPLE.P500);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 866 */       Game.i.renderingManager.shapeRenderer.end();
/*     */       
/* 868 */       paramBatch.begin();
/*     */     } 
/*     */     PlatformTile platformTile;
/* 871 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_BUILDING_INFO) != 0.0D && 
/* 872 */       this.S._gameMapSelection.getSelectedTile() != null && (this.S._gameMapSelection.getSelectedTile()).type == TileType.PLATFORM && 
/*     */       
/* 874 */       (platformTile = (PlatformTile)this.S._gameMapSelection.getSelectedTile()).building != null && platformTile.building.buildingType == BuildingType.TOWER) {
/* 875 */       Tower tower = (Tower)platformTile.building;
/* 876 */       BitmapFont bitmapFont = Game.i.assetManager.getDebugFont(false);
/* 877 */       for (byte b1 = 0; b1 < this.i.size; b1++) {
/* 878 */         Enemy enemy = (((Enemy.EnemyReference[])this.i.items)[b1]).enemy;
/* 879 */         int j = tower.getEnemyPriority(enemy);
/*     */         
/* 881 */         bitmapFont.setColor(Color.RED);
/* 882 */         bitmapFont.draw(paramBatch, "P:" + j, (enemy.getPosition()).x - 8.0F, (enemy.getPosition()).y, 16.0F, 1, false);
/*     */       } 
/* 884 */       bitmapFont.setColor(Color.WHITE);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 889 */     this.i.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawEnemyHealth(Batch paramBatch) {
/* 894 */     this.i.clear();
/* 895 */     this.i.addAll((Array)this.S.map.spawnedEnemies);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 900 */     Threads.sortGdxArray(this.i, f);
/*     */     
/* 902 */     CameraController cameraController = this.S._input.cameraController; byte b; int i;
/* 903 */     for (b = 0, i = this.i.size; b < i; b++) {
/*     */       Enemy enemy;
/* 905 */       if ((enemy = (((Enemy.EnemyReference[])this.i.items)[b]).enemy) != null && !enemy.hasDrawPriority() && cameraController.isPointVisible(enemy.drawPosition, enemy.getSize()) && 
/* 906 */         enemy.healthBarScale != 0.0F && !enemy.healthBarInvisible) enemy.drawHealth(paramBatch);
/*     */     
/*     */     } 
/*     */     
/* 910 */     for (b = 0, i = this.i.size; b < i; b++) {
/*     */       Enemy enemy;
/* 912 */       if ((enemy = (((Enemy.EnemyReference[])this.i.items)[b]).enemy) != null && enemy.hasDrawPriority() && cameraController.isPointVisible(enemy.drawPosition, enemy.getSize()) && 
/* 913 */         enemy.healthBarScale != 0.0F && !enemy.healthBarInvisible) enemy.drawHealth(paramBatch);
/*     */     
/*     */     } 
/*     */     
/* 917 */     this.i.clear();
/*     */     
/* 919 */     paramBatch.setColor(Color.WHITE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 926 */     this.a.clear();
/*     */     
/* 928 */     Game.i.debugManager.unregisterValue("Towers MDPS");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 935 */     super.dispose();
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class OnPathfindingRebuild extends SerializableListener<EnemySystem> implements Listener<PathfindingRebuild> {
/*     */     private OnPathfindingRebuild() {}
/*     */     
/*     */     private OnPathfindingRebuild(EnemySystem param1EnemySystem) {
/* 943 */       this.a = param1EnemySystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleEvent(PathfindingRebuild param1PathfindingRebuild) {
/* 948 */       if (param1PathfindingRebuild.isDefaultPathsAffected()) ((EnemySystem)this.a).queueAllEnemiesPathfinding(); 
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class OnEnemyDespawn extends SerializableListener<EnemySystem> implements Listener<EnemyDespawn> {
/*     */     private OnEnemyDespawn() {}
/*     */     
/*     */     private OnEnemyDespawn(EnemySystem param1EnemySystem) {
/* 957 */       this.a = param1EnemySystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleEvent(EnemyDespawn param1EnemyDespawn) {
/* 962 */       EnemySystem.a((EnemySystem)this.a, param1EnemyDespawn.getEnemy());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\EnemySystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */