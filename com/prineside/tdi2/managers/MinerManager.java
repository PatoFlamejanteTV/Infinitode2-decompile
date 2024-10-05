/*     */ package com.prineside.tdi2.managers;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.graphics.g2d.Sprite;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.Miner;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.MinerType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.miners.InfiarMiner;
/*     */ import com.prineside.tdi2.miners.MatrixMiner;
/*     */ import com.prineside.tdi2.miners.ScalarMiner;
/*     */ import com.prineside.tdi2.miners.TensorMiner;
/*     */ import com.prineside.tdi2.miners.VectorMiner;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = MinerManager.Serializer.class)
/*     */ public class MinerManager extends Manager.ManagerAdapter {
/*     */   public static class Serializer extends SingletonSerializer<MinerManager> { public MinerManager read() {
/*  30 */       return Game.i.minerManager;
/*     */     } }
/*     */   
/*  33 */   private final Miner.Factory[] a = new Miner.Factory[MinerType.values.length];
/*     */   
/*  35 */   public final Factories F = new Factories();
/*     */   public static class Factories {
/*     */     public ScalarMiner.ScalarMinerFactory SCALAR; public VectorMiner.VectorMinerFactory VECTOR; public MatrixMiner.MatrixMinerFactory MATRIX;
/*     */     public TensorMiner.TensorMinerFactory TENSOR;
/*     */     public InfiarMiner.InfiarMinerFactory INFIAR; }
/*     */   private final StatisticsType[] b;
/*     */   private final StatisticsType[] c;
/*     */   private final StatisticsType[] d;
/*     */   private final GameValueType[] e;
/*  44 */   public final ObjectMap<MinerType, String> SHORT_MINER_ALIASES = new ObjectMap(); private final String[] f; public ParticleEffectPool[] highlightParticles;
/*     */   public MinerManager() {
/*  46 */     this.SHORT_MINER_ALIASES.put(MinerType.SCALAR, "S");
/*  47 */     this.SHORT_MINER_ALIASES.put(MinerType.VECTOR, "V");
/*  48 */     this.SHORT_MINER_ALIASES.put(MinerType.MATRIX, "M");
/*  49 */     this.SHORT_MINER_ALIASES.put(MinerType.TENSOR, "T");
/*  50 */     this.SHORT_MINER_ALIASES.put(MinerType.INFIAR, "I");
/*     */ 
/*     */     
/*  53 */     this.b = new StatisticsType[MinerType.values.length];
/*  54 */     this.c = new StatisticsType[MinerType.values.length];
/*  55 */     this.d = new StatisticsType[MinerType.values.length];
/*     */     
/*  57 */     this.e = new GameValueType[MinerType.values.length];
/*     */     
/*  59 */     this.f = new String[MinerType.values.length];
/*     */     
/*  61 */     this.highlightParticles = new ParticleEffectPool[TowerType.values.length];
/*     */     
/*     */     MinerType[] arrayOfMinerType;
/*     */     
/*     */     int i;
/*     */     byte b;
/*  67 */     for (i = (arrayOfMinerType = MinerType.values).length, b = 0; b < i; ) { MinerType minerType = arrayOfMinerType[b];
/*  68 */       String str = (String)this.SHORT_MINER_ALIASES.get(minerType);
/*  69 */       this.b[minerType.ordinal()] = StatisticsType.valueOf("MMS_" + str);
/*  70 */       this.c[minerType.ordinal()] = StatisticsType.valueOf("MB_" + str);
/*  71 */       this.d[minerType.ordinal()] = StatisticsType.valueOf("MU_" + str);
/*     */       b++; }
/*     */     
/*  74 */     this.a[MinerType.SCALAR.ordinal()] = (Miner.Factory)(this.F.SCALAR = new ScalarMiner.ScalarMinerFactory());
/*  75 */     this.a[MinerType.VECTOR.ordinal()] = (Miner.Factory)(this.F.VECTOR = new VectorMiner.VectorMinerFactory());
/*  76 */     this.a[MinerType.MATRIX.ordinal()] = (Miner.Factory)(this.F.MATRIX = new MatrixMiner.MatrixMinerFactory());
/*  77 */     this.a[MinerType.TENSOR.ordinal()] = (Miner.Factory)(this.F.TENSOR = new TensorMiner.TensorMinerFactory());
/*  78 */     this.a[MinerType.INFIAR.ordinal()] = (Miner.Factory)(this.F.INFIAR = new InfiarMiner.InfiarMinerFactory());
/*     */     
/*  80 */     for (i = (arrayOfMinerType = MinerType.values).length, b = 0; b < i; ) { MinerType minerType = arrayOfMinerType[b];
/*  81 */       if (this.a[minerType.ordinal()] == null) {
/*  82 */         throw new RuntimeException("Not all miner factories were created");
/*     */       }
/*     */       b++; }
/*     */     
/*  86 */     for (i = (arrayOfMinerType = MinerType.values).length, b = 0; b < i; ) { MinerType minerType = arrayOfMinerType[b];
/*  87 */       this.f[minerType.ordinal()] = "miner_name_" + minerType.name();
/*  88 */       this.e[minerType.ordinal()] = GameValueType.valueOf("MINER_" + minerType.name() + "_INSTALL_DURATION");
/*     */       b++; }
/*     */   
/*     */   } public ParticleEffectPool minedResourceParticleEffectPool; public ParticleEffectPool doubleSpeedParticleEffectPool;
/*     */   public boolean isMinerOpened(MinerType paramMinerType, GameValueProvider paramGameValueProvider) {
/*  93 */     switch (null.a[paramMinerType.ordinal()]) { case 1:
/*  94 */         return (paramGameValueProvider.getIntValue(GameValueType.MINER_COUNT_SCALAR) > 0);
/*  95 */       case 2: return (paramGameValueProvider.getIntValue(GameValueType.MINER_COUNT_VECTOR) > 0);
/*  96 */       case 3: return (paramGameValueProvider.getIntValue(GameValueType.MINER_COUNT_MATRIX) > 0);
/*  97 */       case 4: return (paramGameValueProvider.getIntValue(GameValueType.MINER_COUNT_TENSOR) > 0);
/*  98 */       case 5: return (paramGameValueProvider.getIntValue(GameValueType.MINER_COUNT_INFIAR) > 0); }
/*     */     
/* 100 */     return false;
/*     */   } public void setup() {
/*     */     Miner.Factory[] arrayOfFactory;
/*     */     int i;
/*     */     byte b;
/* 105 */     for (i = (arrayOfFactory = this.a).length, b = 0; b < i; b++) {
/* 106 */       Miner.Factory factory; (factory = arrayOfFactory[b]).setup();
/*     */     } 
/*     */     
/* 109 */     if (Game.i.assetManager != null) {
/*     */       
/* 111 */       this.minedResourceParticleEffectPool = Game.i.assetManager.getParticleEffectPool("mined-resource.prt");
/* 112 */       this.doubleSpeedParticleEffectPool = Game.i.assetManager.getParticleEffectPool("miner-double-speed.prt");
/*     */       MinerType[] arrayOfMinerType;
/* 114 */       for (i = (arrayOfMinerType = MinerType.values).length, b = 0; b < i; ) { MinerType minerType = arrayOfMinerType[b];
/*     */         ParticleEffect particleEffect;
/* 116 */         (particleEffect = new ParticleEffect()).load(Gdx.files.internal("particles/building-highlight.prt"), Game.i.assetManager.getTextureRegion("tower-basic-base").getAtlas());
/* 117 */         particleEffect.setEmittersCleanUpBlendFunction(false);
/* 118 */         ((ParticleEmitter)particleEffect.getEmitters().first()).setSprites(new Array((Object[])new Sprite[] { new Sprite(Game.i.minerManager
/* 119 */                   .getFactory(minerType).getTexture()) }));
/*     */         
/* 121 */         this.highlightParticles[minerType.ordinal()] = Game.i.assetManager.getParticleEffectPoolWithTemplate("building-highlight.prt@minerType:" + minerType.name(), particleEffect);
/*     */         b++; }
/*     */     
/*     */     } 
/*     */   }
/*     */   public Miner.Factory<? extends Miner> getFactory(MinerType paramMinerType) {
/* 127 */     return this.a[paramMinerType.ordinal()];
/*     */   }
/*     */   
/*     */   public String getTitle(MinerType paramMinerType) {
/* 131 */     int i = paramMinerType.ordinal();
/* 132 */     return Game.i.localeManager.i18n.get(this.f[i]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean minersAndEnergyAvailable() {
/* 140 */     return (Game.i.gameValueManager.getSnapshot().getIntValue(GameValueType.MINER_COUNT_SCALAR) > 0);
/*     */   }
/*     */   
/*     */   public GameValueType getInstallDurationGameValueType(MinerType paramMinerType) {
/* 144 */     int i = paramMinerType.ordinal();
/* 145 */     return this.e[i];
/*     */   }
/*     */   
/*     */   public StatisticsType getBuiltStatisticType(MinerType paramMinerType) {
/* 149 */     return this.c[paramMinerType.ordinal()];
/*     */   }
/*     */   
/*     */   public StatisticsType getMoneySpentStatisticType(MinerType paramMinerType) {
/* 153 */     return this.b[paramMinerType.ordinal()];
/*     */   }
/*     */   
/*     */   public StatisticsType getUpgradedStatisticType(MinerType paramMinerType) {
/* 157 */     return this.d[paramMinerType.ordinal()];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void test() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Miner fromJson(JsonValue paramJsonValue) {
/* 176 */     MinerType minerType = MinerType.valueOf(paramJsonValue.getString("type"));
/*     */     
/*     */     Miner miner;
/* 179 */     (miner = getFactory(minerType).create()).loadFromJson(paramJsonValue);
/*     */     
/* 181 */     return miner;
/*     */   }
/*     */   
/*     */   public void dispose() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\MinerManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */