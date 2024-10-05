/*     */ package com.prineside.tdi2.managers.preferences.categories.progress;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*     */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.StringWriter;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ public class PP_Statistics
/*     */   implements PrefSubcategory {
/*  16 */   private static final TLog a = TLog.forClass(PP_Statistics.class);
/*     */   
/*  18 */   private final double[] b = new double[StatisticsType.values.length];
/*  19 */   private final double[] c = new double[StatisticsType.values.length];
/*     */   
/*     */   public double getAllTime(StatisticsType paramStatisticsType) {
/*  22 */     return this.b[paramStatisticsType.ordinal()];
/*     */   }
/*     */   
/*     */   public double getMaxOneGame(StatisticsType paramStatisticsType) {
/*  26 */     return this.c[paramStatisticsType.ordinal()];
/*     */   }
/*     */   
/*     */   public synchronized void setMaxOneGame(StatisticsType paramStatisticsType, double paramDouble) {
/*  30 */     this.c[paramStatisticsType.ordinal()] = paramDouble;
/*     */   }
/*     */   
/*     */   public synchronized void addAllTime(StatisticsType paramStatisticsType, double paramDouble) {
/*  34 */     this.b[paramStatisticsType.ordinal()] = this.b[paramStatisticsType.ordinal()] + paramDouble;
/*     */   }
/*     */   
/*     */   public synchronized void setAllTime(StatisticsType paramStatisticsType, double paramDouble) {
/*  38 */     this.b[paramStatisticsType.ordinal()] = paramDouble;
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(PrefMap paramPrefMap) {
/*  43 */     Arrays.fill(this.b, 0.0D);
/*  44 */     Arrays.fill(this.c, 0.0D);
/*     */     
/*     */     String str1;
/*  47 */     if ((str1 = paramPrefMap.get("statsAllTime", null)) != null) {
/*     */       try {
/*     */         JsonValue jsonValue;
/*  50 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str1)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*     */           try {
/*  52 */             StatisticsType statisticsType = StatisticsType.valueOf(jsonValue1.name);
/*  53 */             this.b[statisticsType.ordinal()] = jsonValue1.asDouble();
/*     */             
/*  55 */             if (statisticsType == StatisticsType.PRT && (
/*  56 */               this.b[statisticsType.ordinal()] < 0.0D || this.b[statisticsType.ordinal()] > 3.1536E7D)) {
/*  57 */               a.i("reset PRT statistics - invalid value " + this.b[statisticsType.ordinal()], new Object[0]);
/*  58 */               this.b[statisticsType.ordinal()] = 0.0D;
/*     */             }
/*     */           
/*  61 */           } catch (Exception exception) {
/*  62 */             a.e("skipping all time stat '" + jsonValue1.name + "': " + exception.getMessage(), new Object[0]);
/*     */           }  }
/*     */       
/*  65 */       } catch (Exception exception) {
/*  66 */         a.e("failed to parse json: " + str1, new Object[] { exception });
/*     */       } 
/*     */     }
/*     */     
/*     */     String str2;
/*  71 */     if ((str2 = paramPrefMap.get("statsMaxOneGame", null)) != null) {
/*     */       try {
/*     */         JsonValue jsonValue;
/*  74 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str2)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*     */           try {
/*  76 */             StatisticsType statisticsType = StatisticsType.valueOf(jsonValue1.name);
/*  77 */             this.c[statisticsType.ordinal()] = jsonValue1.asDouble();
/*     */             
/*  79 */             if (statisticsType == StatisticsType.PRT && (
/*  80 */               this.c[statisticsType.ordinal()] < 0.0D || this.b[statisticsType.ordinal()] > 3.1536E7D)) {
/*  81 */               a.i("reset PRT mpg statistics - invalid value " + this.b[statisticsType.ordinal()], new Object[0]);
/*  82 */               this.c[statisticsType.ordinal()] = 0.0D;
/*     */             }
/*     */           
/*  85 */           } catch (Exception exception) {
/*  86 */             a.e("skipping max one game stat '" + jsonValue1.name + "': " + exception.getMessage(), new Object[0]);
/*     */           }  }
/*     */          return;
/*  89 */       } catch (Exception exception) {
/*  90 */         a.e("failed to parse json: " + str1, new Object[] { exception });
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void save(PrefMap paramPrefMap) {
/* 101 */     Json json = new Json(JsonWriter.OutputType.minimal);
/* 102 */     StringWriter stringWriter = new StringWriter();
/* 103 */     json.setWriter(stringWriter);
/* 104 */     json.writeObjectStart(); StatisticsType[] arrayOfStatisticsType; int i; byte b;
/* 105 */     for (i = (arrayOfStatisticsType = StatisticsType.values).length, b = 0; b < i; ) { StatisticsType statisticsType = arrayOfStatisticsType[b];
/* 106 */       if (this.b[statisticsType.ordinal()] != 0.0D)
/* 107 */         json.writeValue(statisticsType.name(), Double.valueOf(this.b[statisticsType.ordinal()]));  b++; }
/*     */     
/* 109 */     json.writeObjectEnd();
/* 110 */     paramPrefMap.set("statsAllTime", stringWriter.toString());
/*     */ 
/*     */     
/* 113 */     json = new Json(JsonWriter.OutputType.minimal);
/* 114 */     stringWriter = new StringWriter();
/* 115 */     json.setWriter(stringWriter);
/* 116 */     json.writeObjectStart();
/* 117 */     for (i = (arrayOfStatisticsType = StatisticsType.values).length, b = 0; b < i; ) { StatisticsType statisticsType = arrayOfStatisticsType[b];
/* 118 */       if (this.c[statisticsType.ordinal()] != 0.0D)
/* 119 */         json.writeValue(statisticsType.name(), Double.valueOf(this.c[statisticsType.ordinal()]));  b++; }
/*     */     
/* 121 */     json.writeObjectEnd();
/* 122 */     paramPrefMap.set("statsMaxOneGame", stringWriter.toString());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\progress\PP_Statistics.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */