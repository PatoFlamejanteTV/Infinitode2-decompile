/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.events.game.EnemyLootAdd;
/*     */ import com.prineside.tdi2.events.game.EnemyReachTarget;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.StringWriter;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HeadlessReplayReportGenerator
/*     */ {
/*  19 */   private static final TLog a = TLog.forClass(HeadlessReplayReportGenerator.class);
/*     */   
/*  21 */   private static Array<Frame> b = new Array(Frame.class);
/*  22 */   private static Array<PassedEnemy> c = new Array(PassedEnemy.class);
/*     */   
/*     */   private static int d;
/*     */   private static int e;
/*  26 */   private static final int[] f = new int[RarityType.values.length];
/*     */   
/*     */   public static void start(GameSystemProvider paramGameSystemProvider) {
/*  29 */     a.i("start", new Object[0]);
/*  30 */     b.clear();
/*  31 */     c.clear();
/*     */ 
/*     */     
/*  34 */     paramGameSystemProvider.events.getListeners(EnemyReachTarget.class).add(paramEnemyReachTarget -> {
/*     */           if (paramEnemyReachTarget.getEnemy().getCurrentTile() instanceof com.prineside.tdi2.tiles.TargetTile) {
/*     */             PassedEnemy passedEnemy;
/*     */             
/*     */             (passedEnemy = new PassedEnemy((byte)0)).enemyType = (paramEnemyReachTarget.getEnemy()).type;
/*     */             passedEnemy.healthCoeff = paramEnemyReachTarget.getEnemy().getHealth() / (paramEnemyReachTarget.getEnemy()).maxHealth;
/*     */             passedEnemy.time = (float)paramGameSystemProvider.statistics.getCurrentGameStatistic(StatisticsType.PT);
/*     */             c.add(passedEnemy);
/*     */           } 
/*     */         });
/*  44 */     paramGameSystemProvider.events.getListeners(EnemyLootAdd.class).add(paramEnemyLootAdd -> {
/*     */           Item item = paramEnemyLootAdd.getItem();
/*     */           int i = paramEnemyLootAdd.getCount();
/*     */           if (item == Item.D.GREEN_PAPER) {
/*     */             e += i;
/*     */           } else if (item == Item.D.BIT_DUST) {
/*     */             d += i;
/*     */           } 
/*     */           f[item.getRarity().ordinal()] = f[item.getRarity().ordinal()] + 1;
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Frame a(GameSystemProvider paramGameSystemProvider) {
/*     */     Frame frame;
/*  60 */     Frame.a(frame = new Frame((byte)0), (int)paramGameSystemProvider.damage.getTowersMaxDps());
/*  61 */     Frame.a(frame, (long)paramGameSystemProvider.statistics.getStatistic(StatisticsType.SG_EK));
/*  62 */     Frame.b(frame, (long)paramGameSystemProvider.statistics.getStatistic(StatisticsType.SG_RM));
/*  63 */     Frame.c(frame, (long)paramGameSystemProvider.statistics.getStatistic(StatisticsType.SG_WCA));
/*  64 */     Frame.d(frame, (long)paramGameSystemProvider.statistics.getStatistic(StatisticsType.SG_WCL));
/*  65 */     Frame.b(frame, (int)paramGameSystemProvider.statistics.getStatistic(StatisticsType.CG_B));
/*  66 */     Frame.c(frame, (int)paramGameSystemProvider.statistics.getStatistic(StatisticsType.CG_EK));
/*  67 */     Frame.d(frame, (int)paramGameSystemProvider.statistics.getStatistic(StatisticsType.CG_WC));
/*  68 */     Frame.e(frame, (long)paramGameSystemProvider.statistics.getStatistic(StatisticsType.XPG_EK));
/*  69 */     Frame.f(frame, (long)paramGameSystemProvider.statistics.getStatistic(StatisticsType.XPG_EM));
/*  70 */     Frame.g(frame, (long)paramGameSystemProvider.statistics.getStatistic(StatisticsType.XPG_TG));
/*  71 */     Frame.h(frame, (int)paramGameSystemProvider.statistics.getStatistic(StatisticsType.CG_U));
/*  72 */     Frame.e(frame, d);
/*  73 */     Frame.f(frame, e);
/*  74 */     System.arraycopy(f, 0, Frame.a(frame), 0, (Frame.a(frame)).length);
/*     */     
/*  76 */     return frame;
/*     */   }
/*     */   
/*     */   public static void interval(GameSystemProvider paramGameSystemProvider) {
/*  80 */     b.add(a(paramGameSystemProvider));
/*     */   }
/*     */   
/*     */   public static String stop(GameSystemProvider paramGameSystemProvider) {
/*  84 */     if (paramGameSystemProvider == null) {
/*  85 */       a.e("S is null", new Object[0]);
/*  86 */       return null;
/*     */     } 
/*     */     
/*  89 */     a.i("stop", new Object[0]);
/*  90 */     StringWriter stringWriter = new StringWriter();
/*     */     Json json;
/*  92 */     (json = new Json(JsonWriter.OutputType.json)).setWriter(stringWriter);
/*     */     
/*  94 */     json.writeObjectStart();
/*  95 */     json.writeValue("frameInterval", Integer.valueOf(1800));
/*  96 */     json.writeValue("researches", Integer.valueOf(paramGameSystemProvider.gameState.gameStartProgressSnapshot.getResearchLevelsCount()));
/*  97 */     json.writeValue("sumProgressTime", Integer.valueOf(paramGameSystemProvider.gameState.gameStartProgressSnapshot.statsPlayRealTime));
/*     */     
/*  99 */     json.writeArrayStart("frames"); byte b2;
/* 100 */     for (b2 = 0; b2 < b.size; b2++) {
/* 101 */       Frame frame = ((Frame[])b.items)[b2];
/*     */       
/* 103 */       json.writeArrayStart();
/* 104 */       Frame.a(frame, json);
/* 105 */       json.writeArrayEnd();
/*     */     } 
/* 107 */     json.writeArrayEnd();
/*     */     
/* 109 */     json.writeArrayStart("passedEnemies");
/* 110 */     for (b2 = 0; b2 < c.size; b2++) {
/* 111 */       PassedEnemy passedEnemy = ((PassedEnemy[])c.items)[b2];
/*     */       
/* 113 */       json.writeObjectStart();
/* 114 */       json.writeValue("type", passedEnemy.enemyType.name());
/* 115 */       json.writeValue("health", Float.valueOf(passedEnemy.healthCoeff));
/* 116 */       json.writeValue("time", Float.valueOf(passedEnemy.time));
/* 117 */       json.writeObjectEnd();
/*     */     } 
/* 119 */     json.writeArrayEnd();
/*     */     
/* 121 */     json.writeArrayStart("lastFrame");
/* 122 */     Frame.a(a(paramGameSystemProvider), json);
/* 123 */     json.writeArrayEnd();
/*     */     
/* 125 */     json.writeArrayStart("towers");
/* 126 */     for (b2 = 0; b2 < paramGameSystemProvider.tower.towers.size; b2++) {
/* 127 */       Tower tower = ((Tower[])paramGameSystemProvider.tower.towers.items)[b2];
/* 128 */       json.writeObjectStart();
/* 129 */       json.writeValue("type", tower.type.name());
/* 130 */       json.writeValue("x", Integer.valueOf(tower.getTile().getX()));
/* 131 */       json.writeValue("y", Integer.valueOf(tower.getTile().getY()));
/* 132 */       json.writeValue("upgradeLevel", Byte.valueOf(tower.getUpgradeLevel()));
/* 133 */       json.writeValue("xpLevel", Short.valueOf(tower.getLevel()));
/* 134 */       json.writeValue("mdps", Float.valueOf(tower.mdps));
/* 135 */       json.writeValue("kills", Integer.valueOf(tower.enemiesKilled));
/* 136 */       json.writeValue("damage", Float.valueOf(tower.damageGiven));
/* 137 */       json.writeValue("moneySpent", Integer.valueOf(tower.moneySpentOn));
/* 138 */       json.writeValue("aimStrategy", tower.aimStrategy.name());
/* 139 */       json.writeArrayStart("abilities");
/* 140 */       for (byte b = 0; b < 6; b++) {
/* 141 */         if (tower.isAbilityInstalled(b)) {
/* 142 */           json.writeValue(Integer.valueOf(b));
/*     */         }
/*     */       } 
/* 145 */       json.writeArrayEnd();
/* 146 */       json.writeObjectEnd();
/*     */     } 
/* 148 */     json.writeArrayEnd();
/*     */     
/* 150 */     json.writeArrayStart("modifiers");
/* 151 */     for (b2 = 0; b2 < paramGameSystemProvider.modifier.modifiers.size; b2++) {
/* 152 */       Modifier modifier = ((Modifier[])paramGameSystemProvider.modifier.modifiers.items)[b2];
/* 153 */       json.writeObjectStart();
/* 154 */       json.writeValue("type", modifier.type.name());
/* 155 */       json.writeValue("x", Integer.valueOf(modifier.getTile().getX()));
/* 156 */       json.writeValue("y", Integer.valueOf(modifier.getTile().getY()));
/* 157 */       json.writeObjectEnd();
/*     */     } 
/* 159 */     json.writeArrayEnd();
/*     */     
/* 161 */     json.writeObjectStart("statistics"); StatisticsType[] arrayOfStatisticsType; int i; byte b3;
/* 162 */     for (i = (arrayOfStatisticsType = StatisticsType.values).length, b3 = 0; b3 < i; ) { StatisticsType statisticsType = arrayOfStatisticsType[b3];
/*     */       double d;
/* 164 */       if ((d = paramGameSystemProvider.statistics.getStatistic(statisticsType)) != 0.0D)
/* 165 */         json.writeValue(statisticsType.name(), Double.valueOf(d)); 
/*     */       b3++; }
/*     */     
/* 168 */     json.writeObjectEnd();
/*     */     
/* 170 */     json.writeObjectStart("abilitiesUsed");
/* 171 */     for (byte b1 = 0; b1 < paramGameSystemProvider.ability.abilitiesConfiguration.slots.length; b1++) {
/*     */       AbilityType abilityType;
/* 173 */       if ((abilityType = paramGameSystemProvider.ability.abilitiesConfiguration.slots[b1]) != null && paramGameSystemProvider.ability.abilitiesUsed[b1] > 0) {
/* 174 */         json.writeValue(abilityType.name(), Integer.valueOf(paramGameSystemProvider.ability.abilitiesUsed[b1]));
/*     */       }
/*     */     } 
/* 177 */     json.writeObjectEnd();
/*     */     
/* 179 */     json.writeObjectEnd();
/*     */     
/* 181 */     return stringWriter.toString();
/*     */   }
/*     */   
/*     */   private static class Frame {
/*     */     private long a;
/*     */     private long b;
/*     */     private long c;
/*     */     private long d;
/*     */     private int e;
/*     */     private int f;
/*     */     private int g;
/*     */     private int h;
/*     */     private long i;
/*     */     private long j;
/*     */     private long k;
/*     */     private long l;
/*     */     private int m;
/*     */     private int n;
/* 199 */     private final int[] o = new int[RarityType.values.length];
/*     */     
/*     */     private void a(Json param1Json) {
/* 202 */       param1Json.writeValue(Long.valueOf(this.a));
/* 203 */       param1Json.writeValue(Long.valueOf(this.b));
/* 204 */       param1Json.writeValue(Long.valueOf(this.c));
/* 205 */       param1Json.writeValue(Long.valueOf(this.d));
/* 206 */       param1Json.writeValue(Integer.valueOf(this.e));
/* 207 */       param1Json.writeValue(Integer.valueOf(this.f));
/* 208 */       param1Json.writeValue(Integer.valueOf(this.g));
/* 209 */       param1Json.writeValue(Integer.valueOf(this.h));
/* 210 */       param1Json.writeValue(Long.valueOf(this.i));
/* 211 */       param1Json.writeValue(Long.valueOf(this.j));
/* 212 */       param1Json.writeValue(Long.valueOf(this.k));
/* 213 */       param1Json.writeValue(Long.valueOf(this.l));
/* 214 */       param1Json.writeValue(Integer.valueOf(this.m));
/* 215 */       param1Json.writeValue(Integer.valueOf(this.n));
/* 216 */       param1Json.writeValue(this.o);
/*     */     }
/*     */     
/*     */     private Frame() {}
/*     */   }
/*     */   
/*     */   private static class PassedEnemy {
/*     */     public EnemyType enemyType;
/*     */     public float healthCoeff;
/*     */     public float time;
/*     */     
/*     */     private PassedEnemy() {}
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\HeadlessReplayReportGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */