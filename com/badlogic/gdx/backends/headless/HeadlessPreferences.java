/*     */ package com.badlogic.gdx.backends.headless;
/*     */ 
/*     */ import com.badlogic.gdx.Files;
/*     */ import com.badlogic.gdx.Preferences;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.StreamUtils;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
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
/*     */ public class HeadlessPreferences
/*     */   implements Preferences
/*     */ {
/*  36 */   private final Properties properties = new Properties();
/*     */   private final FileHandle file;
/*     */   
/*     */   public HeadlessPreferences(String paramString1, String paramString2) {
/*  40 */     this(new HeadlessFileHandle(new File(paramString2, paramString1), Files.FileType.External));
/*     */   }
/*     */   
/*     */   public HeadlessPreferences(FileHandle paramFileHandle) {
/*  44 */     this.file = paramFileHandle;
/*  45 */     if (!paramFileHandle.exists())
/*  46 */       return;  BufferedInputStream bufferedInputStream = null;
/*     */     try {
/*  48 */       bufferedInputStream = new BufferedInputStream(paramFileHandle.read());
/*  49 */       this.properties.loadFromXML(bufferedInputStream); return;
/*  50 */     } catch (Throwable throwable) {
/*  51 */       (paramFileHandle = null).printStackTrace(); return;
/*     */     } finally {
/*  53 */       StreamUtils.closeQuietly(bufferedInputStream);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Preferences putBoolean(String paramString, boolean paramBoolean) {
/*  59 */     this.properties.put(paramString, Boolean.toString(paramBoolean));
/*  60 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Preferences putInteger(String paramString, int paramInt) {
/*  65 */     this.properties.put(paramString, Integer.toString(paramInt));
/*  66 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Preferences putLong(String paramString, long paramLong) {
/*  71 */     this.properties.put(paramString, Long.toString(paramLong));
/*  72 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Preferences putFloat(String paramString, float paramFloat) {
/*  77 */     this.properties.put(paramString, Float.toString(paramFloat));
/*  78 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Preferences putString(String paramString1, String paramString2) {
/*  83 */     this.properties.put(paramString1, paramString2);
/*  84 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Preferences put(Map<String, ?> paramMap) {
/*  89 */     for (Iterator<Map.Entry> iterator = paramMap.entrySet().iterator(); iterator.hasNext(); ) {
/*  90 */       Map.Entry entry; if ((entry = iterator.next()).getValue() instanceof Boolean) putBoolean((String)entry.getKey(), ((Boolean)entry.getValue()).booleanValue()); 
/*  91 */       if (entry.getValue() instanceof Integer) putInteger((String)entry.getKey(), ((Integer)entry.getValue()).intValue()); 
/*  92 */       if (entry.getValue() instanceof Long) putLong((String)entry.getKey(), ((Long)entry.getValue()).longValue()); 
/*  93 */       if (entry.getValue() instanceof String) putString((String)entry.getKey(), (String)entry.getValue()); 
/*  94 */       if (entry.getValue() instanceof Float) putFloat((String)entry.getKey(), ((Float)entry.getValue()).floatValue()); 
/*     */     } 
/*  96 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getBoolean(String paramString) {
/* 101 */     return getBoolean(paramString, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getInteger(String paramString) {
/* 106 */     return getInteger(paramString, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLong(String paramString) {
/* 111 */     return getLong(paramString, 0L);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getFloat(String paramString) {
/* 116 */     return getFloat(paramString, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString(String paramString) {
/* 121 */     return getString(paramString, "");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getBoolean(String paramString, boolean paramBoolean) {
/* 126 */     return Boolean.parseBoolean(this.properties.getProperty(paramString, Boolean.toString(paramBoolean)));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getInteger(String paramString, int paramInt) {
/* 131 */     return Integer.parseInt(this.properties.getProperty(paramString, Integer.toString(paramInt)));
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLong(String paramString, long paramLong) {
/* 136 */     return Long.parseLong(this.properties.getProperty(paramString, Long.toString(paramLong)));
/*     */   }
/*     */ 
/*     */   
/*     */   public float getFloat(String paramString, float paramFloat) {
/* 141 */     return Float.parseFloat(this.properties.getProperty(paramString, Float.toString(paramFloat)));
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString(String paramString1, String paramString2) {
/* 146 */     return this.properties.getProperty(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, ?> get() {
/* 151 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 152 */     for (Iterator<Map.Entry<Object, Object>> iterator = this.properties.entrySet().iterator(); iterator.hasNext(); ) {
/* 153 */       Map.Entry entry; if ((entry = iterator.next()).getValue() instanceof Boolean)
/* 154 */         hashMap.put(entry.getKey(), Boolean.valueOf(Boolean.parseBoolean((String)entry.getValue()))); 
/* 155 */       if (entry.getValue() instanceof Integer) hashMap.put(entry.getKey(), Integer.valueOf(Integer.parseInt((String)entry.getValue()))); 
/* 156 */       if (entry.getValue() instanceof Long) hashMap.put(entry.getKey(), Long.valueOf(Long.parseLong((String)entry.getValue()))); 
/* 157 */       if (entry.getValue() instanceof String) hashMap.put(entry.getKey(), entry.getValue()); 
/* 158 */       if (entry.getValue() instanceof Float) hashMap.put(entry.getKey(), Float.valueOf(Float.parseFloat((String)entry.getValue())));
/*     */     
/*     */     } 
/* 161 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(String paramString) {
/* 166 */     return this.properties.containsKey(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 171 */     this.properties.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void flush() {
/* 176 */     BufferedOutputStream bufferedOutputStream = null;
/*     */     try {
/* 178 */       bufferedOutputStream = new BufferedOutputStream(this.file.write(false));
/* 179 */       this.properties.storeToXML(bufferedOutputStream, null); return;
/* 180 */     } catch (Exception exception) {
/* 181 */       throw new GdxRuntimeException("Error writing preferences: " + this.file, exception);
/*     */     } finally {
/* 183 */       StreamUtils.closeQuietly(bufferedOutputStream);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(String paramString) {
/* 189 */     this.properties.remove(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\headless\HeadlessPreferences.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */