/*     */ package com.prineside.tdi2.managers.preferences.categories.progress;
/*     */ 
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.enums.ResearchType;
/*     */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*     */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.StringWriter;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ public final class PP_Research
/*     */   implements PrefSubcategory {
/*  18 */   private static final TLog a = TLog.forClass(PP_Research.class);
/*     */   @Null
/*     */   private ResearchType b;
/*     */   private long c;
/*  22 */   private final short[] d = new short[ResearchType.values.length];
/*  23 */   private final IntArray[] e = new IntArray[ResearchType.values.length];
/*     */   
/*     */   public final boolean isLevelInstalledForToken(ResearchType paramResearchType, int paramInt) {
/*     */     IntArray intArray;
/*  27 */     if ((intArray = this.e[paramResearchType.ordinal()]) == null) {
/*  28 */       return false;
/*     */     }
/*     */     
/*  31 */     return intArray.contains(paramInt);
/*     */   }
/*     */   
/*     */   public final synchronized void addLevelInstalledForTokens(ResearchType paramResearchType, int paramInt) {
/*  35 */     if (this.e[paramResearchType.ordinal()] == null) {
/*  36 */       this.e[paramResearchType.ordinal()] = new IntArray();
/*     */     }
/*  38 */     if (!this.e[paramResearchType.ordinal()].contains(paramInt)) {
/*  39 */       this.e[paramResearchType.ordinal()].add(paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   public final synchronized void resetLevelsInstalledForTokens(ResearchType paramResearchType) {
/*  44 */     this.e[paramResearchType.ordinal()] = null;
/*     */   }
/*     */   
/*     */   public final synchronized void setInstalledLevel(ResearchType paramResearchType, short paramShort) {
/*  48 */     this.d[paramResearchType.ordinal()] = paramShort;
/*     */   }
/*     */   @Null
/*     */   public final ResearchType getCurrentlyResearching() {
/*  52 */     return this.b;
/*     */   }
/*     */   
/*     */   public final synchronized void setCurrentlyResearching(@Null ResearchType paramResearchType) {
/*  56 */     this.b = paramResearchType;
/*     */   }
/*     */   
/*     */   public final long getCurrentResearchEndTime() {
/*  60 */     return this.c;
/*     */   }
/*     */   
/*     */   public final synchronized void setCurrentResearchEndTime(long paramLong) {
/*  64 */     this.c = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void load(PrefMap paramPrefMap) {
/*  69 */     this.b = null;
/*  70 */     Arrays.fill(this.d, (short)0);
/*  71 */     Arrays.fill((Object[])this.e, (Object)null);
/*  72 */     this.c = 0L;
/*     */     
/*  74 */     String str = paramPrefMap.get("currentlyResearching", null);
/*     */     try {
/*  76 */       if (str != null && str.length() != 0) {
/*  77 */         this.b = ResearchType.valueOf(str);
/*  78 */         this.c = Long.parseLong(paramPrefMap.get("currentResearchEndTime", "0"));
/*  79 */         a.i("currently researching: " + this.b.name(), new Object[0]);
/*     */       } 
/*  81 */     } catch (Exception exception) {
/*  82 */       a.e("failed to load current research", new Object[] { exception });
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  87 */     if ((str = paramPrefMap.get("installedResearches", null)) != null) {
/*     */       try {
/*     */         JsonValue jsonValue;
/*  90 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*     */           try {
/*  92 */             ResearchType researchType = ResearchType.valueOf(jsonValue1.name);
/*  93 */             this.d[researchType.ordinal()] = (short)jsonValue1.asInt();
/*  94 */           } catch (Exception exception) {
/*     */             
/*  96 */             a.i("!!! Saved installed research '" + jsonValue1.name + "' not found and was ignored: " + exception.getMessage(), new Object[0]);
/*     */           }  }
/*     */       
/*  99 */       } catch (Exception exception) {
/* 100 */         a.e("failed to parse json: " + str, new Object[] { exception });
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 106 */     if ((str = paramPrefMap.get("installedResearchesForTokens", null)) != null) {
/*     */       try {
/*     */         JsonValue jsonValue;
/* 109 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*     */           try {
/* 111 */             ResearchType researchType = ResearchType.valueOf(jsonValue1.name);
/* 112 */             for (JsonValue.JsonIterator<JsonValue> jsonIterator1 = jsonValue1.iterator(); jsonIterator1.hasNext(); ) {
/* 113 */               JsonValue jsonValue2; int i = (jsonValue2 = jsonIterator1.next()).asInt();
/* 114 */               if (getInstalledLevel(researchType) >= i) {
/* 115 */                 if (this.e[researchType.ordinal()] == null) {
/* 116 */                   this.e[researchType.ordinal()] = new IntArray();
/*     */                 }
/* 118 */                 this.e[researchType.ordinal()].add(i); continue;
/*     */               } 
/* 120 */               a.e("ilft > research.installedLevel " + jsonValue1.name + ", " + i + " > " + getInstalledLevel(researchType), new Object[0]);
/*     */             }
/*     */           
/* 123 */           } catch (Exception exception) {
/*     */             
/* 125 */             a.e("Saved installed research levels for token '" + jsonValue1.name + "' not found and was ignored: " + exception.getMessage(), new Object[0]);
/*     */           }  }
/*     */          return;
/* 128 */       } catch (Exception exception) {
/* 129 */         a.e("failed to parse json: " + str, new Object[] { exception });
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final synchronized void save(PrefMap paramPrefMap) {
/* 140 */     paramPrefMap.set("currentlyResearching", (this.b == null) ? null : this.b.name());
/* 141 */     if (this.c != 0L) paramPrefMap.set("currentResearchEndTime", String.valueOf(this.c));
/*     */ 
/*     */     
/* 144 */     Json json = new Json(JsonWriter.OutputType.minimal);
/* 145 */     StringWriter stringWriter = new StringWriter();
/* 146 */     json.setWriter(stringWriter);
/* 147 */     json.writeObjectStart(); ResearchType[] arrayOfResearchType; int i; byte b;
/* 148 */     for (i = (arrayOfResearchType = ResearchType.values).length, b = 0; b < i; ) { ResearchType researchType = arrayOfResearchType[b];
/*     */       short s;
/* 150 */       if ((s = this.d[researchType.ordinal()]) != 0)
/* 151 */         json.writeValue(researchType.name(), Integer.valueOf(s)); 
/*     */       b++; }
/*     */     
/* 154 */     json.writeObjectEnd();
/* 155 */     paramPrefMap.set("installedResearches", stringWriter.toString());
/*     */ 
/*     */     
/* 158 */     json = new Json(JsonWriter.OutputType.minimal);
/* 159 */     stringWriter = new StringWriter();
/* 160 */     json.setWriter(stringWriter);
/* 161 */     json.writeObjectStart();
/* 162 */     for (i = (arrayOfResearchType = ResearchType.values()).length, b = 0; b < i; ) { ResearchType researchType = arrayOfResearchType[b];
/*     */       IntArray intArray;
/* 164 */       if ((intArray = this.e[researchType.ordinal()]) != null && intArray.size != 0) {
/* 165 */         json.writeArrayStart(researchType.name());
/* 166 */         for (byte b1 = 0; b1 < intArray.size; b1++) {
/* 167 */           json.writeValue(Integer.valueOf(intArray.items[b1]));
/*     */         }
/* 169 */         json.writeArrayEnd();
/*     */       }  b++; }
/*     */     
/* 172 */     json.writeObjectEnd();
/* 173 */     paramPrefMap.set("installedResearchesForTokens", stringWriter.toString());
/*     */   }
/*     */   
/*     */   public final int getInstalledLevel(ResearchType paramResearchType) {
/* 177 */     return this.d[paramResearchType.ordinal()];
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\progress\PP_Research.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */