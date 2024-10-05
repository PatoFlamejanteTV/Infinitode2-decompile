/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.MissingResourceException;
/*     */ import java.util.Set;
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
/*     */ public class I18NBundle
/*     */ {
/*     */   private static final String DEFAULT_ENCODING = "UTF-8";
/*  71 */   private static final Locale ROOT_LOCALE = new Locale("", "", "");
/*     */ 
/*     */   
/*     */   private static boolean simpleFormatter = false;
/*     */ 
/*     */   
/*     */   private static boolean exceptionOnMissingKey = true;
/*     */ 
/*     */   
/*     */   private I18NBundle parent;
/*     */ 
/*     */   
/*     */   private Locale locale;
/*     */   
/*     */   private ObjectMap<String, String> properties;
/*     */   
/*     */   private TextFormatter formatter;
/*     */ 
/*     */   
/*     */   public static boolean getSimpleFormatter() {
/*  91 */     return simpleFormatter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setSimpleFormatter(boolean paramBoolean) {
/*  98 */     simpleFormatter = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean getExceptionOnMissingKey() {
/* 105 */     return exceptionOnMissingKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setExceptionOnMissingKey(boolean paramBoolean) {
/* 112 */     exceptionOnMissingKey = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static I18NBundle createBundle(FileHandle paramFileHandle) {
/* 122 */     return createBundleImpl(paramFileHandle, Locale.getDefault(), "UTF-8");
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
/*     */   public static I18NBundle createBundle(FileHandle paramFileHandle, Locale paramLocale) {
/* 134 */     return createBundleImpl(paramFileHandle, paramLocale, "UTF-8");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static I18NBundle createBundle(FileHandle paramFileHandle, String paramString) {
/* 145 */     return createBundleImpl(paramFileHandle, Locale.getDefault(), paramString);
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
/*     */   public static I18NBundle createBundle(FileHandle paramFileHandle, Locale paramLocale, String paramString) {
/* 158 */     return createBundleImpl(paramFileHandle, paramLocale, paramString);
/*     */   }
/*     */   private static I18NBundle createBundleImpl(FileHandle paramFileHandle, Locale paramLocale, String paramString) {
/*     */     I18NBundle i18NBundle1;
/* 162 */     if (paramFileHandle == null || paramLocale == null || paramString == null) throw new NullPointerException();
/*     */ 
/*     */     
/* 165 */     I18NBundle i18NBundle2 = null;
/* 166 */     Locale locale = paramLocale;
/*     */     
/*     */     do {
/* 169 */       List<Locale> list = getCandidateLocales(locale);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 175 */       if ((i18NBundle1 = loadBundleChain(paramFileHandle, paramString, list, 0, i18NBundle2)) == null)
/*     */         continue; 
/*     */       Locale locale1;
/*     */       boolean bool;
/* 179 */       if ((bool = (locale1 = i18NBundle1.getLocale()).equals(ROOT_LOCALE)) && !locale1.equals(paramLocale)) {
/*     */ 
/*     */ 
/*     */         
/* 183 */         if (list.size() != 1 || !locale1.equals(list.get(0))) {
/*     */ 
/*     */ 
/*     */           
/* 187 */           if (bool && i18NBundle2 == null)
/*     */           {
/* 189 */             i18NBundle2 = i18NBundle1; } 
/*     */         } else {
/*     */           break;
/*     */         } 
/*     */       } else {
/*     */         break;
/*     */       } 
/* 196 */     } while ((locale = getFallbackLocale(locale)) != null);
/*     */     
/* 198 */     if (i18NBundle1 == null) {
/* 199 */       if (i18NBundle2 == null)
/*     */       {
/* 201 */         throw new MissingResourceException("Can't find bundle for base file handle " + paramFileHandle
/* 202 */             .path() + ", locale " + paramLocale, paramFileHandle + "_" + paramLocale, "");
/*     */       }
/*     */ 
/*     */       
/* 206 */       i18NBundle1 = i18NBundle2;
/*     */     } 
/*     */     
/* 209 */     return i18NBundle1;
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
/*     */   private static List<Locale> getCandidateLocales(Locale paramLocale) {
/* 261 */     String str1 = paramLocale.getLanguage();
/* 262 */     String str2 = paramLocale.getCountry();
/* 263 */     String str3 = paramLocale.getVariant();
/*     */     
/* 265 */     ArrayList<Locale> arrayList = new ArrayList(4);
/* 266 */     if (str3.length() > 0) {
/* 267 */       arrayList.add(paramLocale);
/*     */     }
/* 269 */     if (str2.length() > 0) {
/* 270 */       arrayList.add(arrayList.isEmpty() ? paramLocale : new Locale(str1, str2));
/*     */     }
/* 272 */     if (str1.length() > 0) {
/* 273 */       arrayList.add(arrayList.isEmpty() ? paramLocale : new Locale(str1));
/*     */     }
/* 275 */     arrayList.add(ROOT_LOCALE);
/* 276 */     return arrayList;
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
/*     */   private static Locale getFallbackLocale(Locale paramLocale) {
/* 293 */     Locale locale = Locale.getDefault();
/* 294 */     return paramLocale.equals(locale) ? null : locale;
/*     */   }
/*     */ 
/*     */   
/*     */   private static I18NBundle loadBundleChain(FileHandle paramFileHandle, String paramString, List<Locale> paramList, int paramInt, I18NBundle paramI18NBundle) {
/* 299 */     Locale locale = paramList.get(paramInt);
/* 300 */     I18NBundle i18NBundle2 = null;
/* 301 */     if (paramInt != paramList.size() - 1) {
/*     */       
/* 303 */       i18NBundle2 = loadBundleChain(paramFileHandle, paramString, paramList, paramInt + 1, paramI18NBundle);
/* 304 */     } else if (paramI18NBundle != null && locale.equals(ROOT_LOCALE)) {
/* 305 */       return paramI18NBundle;
/*     */     } 
/*     */     
/*     */     I18NBundle i18NBundle1;
/*     */     
/* 310 */     if ((i18NBundle1 = loadBundle(paramFileHandle, paramString, locale)) != null) {
/* 311 */       i18NBundle1.parent = i18NBundle2;
/* 312 */       return i18NBundle1;
/*     */     } 
/*     */     
/* 315 */     return i18NBundle2;
/*     */   }
/*     */ 
/*     */   
/*     */   private static I18NBundle loadBundle(FileHandle paramFileHandle, String paramString, Locale paramLocale) {
/* 320 */     I18NBundle i18NBundle = null;
/* 321 */     Reader reader = null;
/*     */     
/*     */     try {
/* 324 */       if (checkFileExistence(paramFileHandle = toFileHandle(paramFileHandle, paramLocale))) {
/*     */         
/* 326 */         i18NBundle = new I18NBundle();
/*     */ 
/*     */         
/* 329 */         reader = paramFileHandle.reader(paramString);
/* 330 */         i18NBundle.load(reader);
/*     */       } 
/* 332 */     } catch (IOException iOException) {
/* 333 */       throw new GdxRuntimeException(iOException);
/*     */     } finally {
/* 335 */       StreamUtils.closeQuietly(reader);
/*     */     } 
/* 337 */     if (i18NBundle != null) {
/* 338 */       i18NBundle.setLocale(paramLocale);
/*     */     }
/*     */     
/* 341 */     return i18NBundle;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean checkFileExistence(FileHandle paramFileHandle) {
/*     */     try {
/* 348 */       paramFileHandle.read().close();
/* 349 */       return true;
/* 350 */     } catch (Exception exception) {
/* 351 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(Reader paramReader) {
/* 362 */     this.properties = new ObjectMap<>();
/* 363 */     PropertiesUtils.load(this.properties, paramReader);
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
/*     */   private static FileHandle toFileHandle(FileHandle paramFileHandle, Locale paramLocale) {
/* 384 */     StringBuilder stringBuilder = new StringBuilder(paramFileHandle.name());
/* 385 */     if (!paramLocale.equals(ROOT_LOCALE)) {
/* 386 */       String str2 = paramLocale.getLanguage();
/* 387 */       String str3 = paramLocale.getCountry();
/* 388 */       String str1 = paramLocale.getVariant();
/* 389 */       boolean bool1 = "".equals(str2);
/* 390 */       boolean bool2 = "".equals(str3);
/* 391 */       boolean bool3 = "".equals(str1);
/*     */       
/* 393 */       if (!bool1 || !bool2 || !bool3) {
/* 394 */         stringBuilder.append('_');
/* 395 */         if (!bool3) {
/* 396 */           stringBuilder.append(str2).append('_').append(str3).append('_').append(str1);
/* 397 */         } else if (!bool2) {
/* 398 */           stringBuilder.append(str2).append('_').append(str3);
/*     */         } else {
/* 400 */           stringBuilder.append(str2);
/*     */         } 
/*     */       } 
/*     */     } 
/* 404 */     return paramFileHandle.sibling(stringBuilder.append(".properties").toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Locale getLocale() {
/* 412 */     return this.locale;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setLocale(Locale paramLocale) {
/* 419 */     this.locale = paramLocale;
/* 420 */     this.formatter = new TextFormatter(paramLocale, !simpleFormatter);
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
/*     */   public String get(String paramString) {
/*     */     String str;
/* 433 */     if ((str = this.properties.<String>get(paramString)) == null) {
/* 434 */       if (this.parent != null) str = this.parent.get(paramString); 
/* 435 */       if (str == null) {
/* 436 */         if (exceptionOnMissingKey) {
/* 437 */           throw new MissingResourceException("Can't find bundle key " + paramString, getClass().getName(), paramString);
/*     */         }
/* 439 */         return "???" + paramString + "???";
/*     */       } 
/*     */     } 
/* 442 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<String> keys() {
/* 449 */     LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
/*     */     ObjectMap.Keys<String> keys;
/* 451 */     if ((keys = this.properties.keys()) != null) {
/* 452 */       for (keys = keys.iterator(); keys.hasNext(); ) { String str = keys.next();
/* 453 */         linkedHashSet.add(str); }
/*     */     
/*     */     }
/* 456 */     return linkedHashSet;
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
/*     */   public String format(String paramString, Object... paramVarArgs) {
/* 468 */     return this.formatter.format(get(paramString), paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void debug(String paramString) {
/*     */     ObjectMap.Keys<String> keys;
/* 477 */     if ((keys = this.properties.keys()) == null)
/*     */       return; 
/* 479 */     for (keys = keys.iterator(); keys.hasNext(); ) { String str = keys.next();
/* 480 */       this.properties.put(str, paramString); }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\I18NBundle.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */