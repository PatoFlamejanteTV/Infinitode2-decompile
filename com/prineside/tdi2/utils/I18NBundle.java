/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.PropertiesUtils;
/*     */ import com.badlogic.gdx.utils.StreamUtils;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.MissingResourceException;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class I18NBundle
/*     */ {
/*  22 */   private static final TLog a = TLog.forClass(I18NBundle.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  28 */   private static final Locale b = new Locale("", "", "");
/*     */   
/*     */   private static boolean c = false;
/*     */   
/*     */   private I18NBundle d;
/*     */   
/*     */   private Locale e;
/*     */   
/*     */   private ObjectMap<String, String> f;
/*     */   private I18NTextFormatter g;
/*  38 */   private final Pattern h = Pattern.compile("\\[@([a-zA-Z0-9_-]+)]");
/*  39 */   private final ObjectMap<String, String> i = new ObjectMap();
/*  40 */   private final ObjectMap<String, String> j = new ObjectMap();
/*     */   
/*     */   private String a(String paramString) {
/*  43 */     Matcher matcher = this.h.matcher(paramString);
/*  44 */     while (matcher.find()) {
/*  45 */       String str = matcher.group(1).trim();
/*  46 */       paramString = paramString.replace("[@" + str + "]", Game.i.localeManager.i18n.get(str));
/*     */     } 
/*     */     
/*  49 */     if (Game.i.assetManager != null) paramString = Game.i.assetManager.replaceRegionAliasesWithChars(paramString).toString();
/*     */     
/*  51 */     return paramString;
/*     */   }
/*     */   
/*     */   public void registerCustom(String paramString1, String paramString2) {
/*     */     String str;
/*  56 */     if ((str = (String)this.f.get(paramString1)) == null) {
/*  57 */       if (this.d != null) str = this.d.get(paramString1); 
/*  58 */       if (str == null || str.startsWith("???")) {
/*  59 */         this.i.put(paramString1, paramString2);
/*  60 */         this.j.remove(paramString1);
/*     */         
/*  62 */         a.i("registered custom: " + paramString1 + "=" + paramString2, new Object[0]);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/*  68 */     a.e("failed to register custom i18n value: " + paramString1 + " - default i18n can't be changed for security purposes. Default: " + str, new Object[0]);
/*     */   }
/*     */   
/*     */   public static boolean getSimpleFormatter() {
/*  72 */     return c;
/*     */   }
/*     */   
/*     */   public static void setSimpleFormatter(boolean paramBoolean) {
/*  76 */     c = paramBoolean;
/*     */   }
/*     */   
/*     */   public static I18NBundle createBundle(FileHandle paramFileHandle) {
/*  80 */     return a(paramFileHandle, Locale.getDefault(), "UTF-8");
/*     */   }
/*     */   
/*     */   public static I18NBundle createBundle(FileHandle paramFileHandle, Locale paramLocale) {
/*  84 */     return a(paramFileHandle, paramLocale, "UTF-8");
/*     */   }
/*     */   private static I18NBundle a(FileHandle paramFileHandle, Locale paramLocale, String paramString) {
/*     */     I18NBundle i18NBundle1;
/*  88 */     if (paramFileHandle == null || paramLocale == null) throw new NullPointerException();
/*     */ 
/*     */     
/*  91 */     I18NBundle i18NBundle2 = null;
/*  92 */     Locale locale = paramLocale;
/*     */     
/*     */     do {
/*  95 */       List<Locale> list = a(locale);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 101 */       if ((i18NBundle1 = a(paramFileHandle, paramString, list, 0, i18NBundle2)) == null)
/*     */         continue; 
/*     */       Locale locale1;
/*     */       boolean bool;
/* 105 */       if ((bool = (locale1 = i18NBundle1.getLocale()).equals(b)) && !locale1.equals(paramLocale)) {
/*     */ 
/*     */ 
/*     */         
/* 109 */         if (list.size() != 1 || !locale1.equals(list.get(0))) {
/*     */ 
/*     */ 
/*     */           
/* 113 */           if (bool && i18NBundle2 == null)
/*     */           {
/* 115 */             i18NBundle2 = i18NBundle1; } 
/*     */         } else {
/*     */           break;
/*     */         } 
/*     */       } else {
/*     */         break;
/*     */       } 
/* 122 */     } while ((locale = b(locale)) != null);
/*     */     
/* 124 */     if (i18NBundle1 == null) {
/* 125 */       if (i18NBundle2 == null)
/*     */       {
/* 127 */         throw new MissingResourceException("Can't find bundle for base file handle " + paramFileHandle.path() + ", locale " + paramLocale, paramFileHandle + "_" + paramLocale, "");
/*     */       }
/*     */ 
/*     */       
/* 131 */       i18NBundle1 = i18NBundle2;
/*     */     } 
/*     */     
/* 134 */     return i18NBundle1;
/*     */   }
/*     */   
/*     */   private static List<Locale> a(Locale paramLocale) {
/* 138 */     String str1 = paramLocale.getLanguage();
/* 139 */     String str2 = paramLocale.getCountry();
/* 140 */     String str3 = paramLocale.getVariant();
/*     */     
/* 142 */     ArrayList<Locale> arrayList = new ArrayList(4);
/* 143 */     if (str3.length() > 0) {
/* 144 */       arrayList.add(paramLocale);
/*     */     }
/* 146 */     if (str2.length() > 0) {
/* 147 */       arrayList.add(arrayList.isEmpty() ? paramLocale : new Locale(str1, str2));
/*     */     }
/* 149 */     if (str1.length() > 0) {
/* 150 */       arrayList.add(arrayList.isEmpty() ? paramLocale : new Locale(str1));
/*     */     }
/* 152 */     arrayList.add(b);
/* 153 */     return arrayList;
/*     */   }
/*     */   
/*     */   private static Locale b(Locale paramLocale) {
/* 157 */     Locale locale = Locale.getDefault();
/* 158 */     return paramLocale.equals(locale) ? null : locale;
/*     */   }
/*     */ 
/*     */   
/*     */   private static I18NBundle a(FileHandle paramFileHandle, String paramString, List<Locale> paramList, int paramInt, I18NBundle paramI18NBundle) {
/* 163 */     Locale locale = paramList.get(paramInt);
/* 164 */     I18NBundle i18NBundle2 = null;
/* 165 */     if (paramInt != paramList.size() - 1) {
/*     */       
/* 167 */       i18NBundle2 = a(paramFileHandle, paramString, paramList, paramInt + 1, paramI18NBundle);
/* 168 */     } else if (paramI18NBundle != null && locale.equals(b)) {
/* 169 */       return paramI18NBundle;
/*     */     } 
/*     */     
/*     */     I18NBundle i18NBundle1;
/*     */     
/* 174 */     if ((i18NBundle1 = a(paramFileHandle, paramString, locale)) != null) {
/* 175 */       i18NBundle1.d = i18NBundle2;
/* 176 */       return i18NBundle1;
/*     */     } 
/*     */     
/* 179 */     return i18NBundle2;
/*     */   }
/*     */   
/*     */   private static I18NBundle a(FileHandle paramFileHandle, String paramString, Locale paramLocale) {
/* 183 */     I18NBundle i18NBundle = null;
/* 184 */     Reader reader = null;
/*     */     
/*     */     try {
/* 187 */       if (a(paramFileHandle = a(paramFileHandle, paramLocale))) {
/*     */         
/* 189 */         i18NBundle = new I18NBundle();
/*     */ 
/*     */         
/* 192 */         reader = paramFileHandle.reader(paramString);
/* 193 */         i18NBundle.a(reader);
/*     */       } 
/* 195 */     } catch (IOException iOException) {
/* 196 */       throw new GdxRuntimeException(iOException);
/*     */     } finally {
/*     */       
/* 199 */       StreamUtils.closeQuietly(reader);
/*     */     } 
/* 201 */     if (i18NBundle != null) {
/* 202 */       i18NBundle.c(paramLocale);
/*     */     }
/*     */     
/* 205 */     return i18NBundle;
/*     */   }
/*     */   
/*     */   private static boolean a(FileHandle paramFileHandle) {
/*     */     try {
/* 210 */       paramFileHandle.read().close();
/* 211 */       return true;
/* 212 */     } catch (Exception exception) {
/* 213 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(Reader paramReader) {
/* 218 */     this.f = new ObjectMap();
/* 219 */     PropertiesUtils.load(this.f, paramReader);
/*     */   }
/*     */   
/*     */   private static FileHandle a(FileHandle paramFileHandle, Locale paramLocale) {
/* 223 */     StringBuilder stringBuilder = new StringBuilder(paramFileHandle.name());
/* 224 */     if (!paramLocale.equals(b)) {
/* 225 */       String str2 = paramLocale.getLanguage();
/* 226 */       String str3 = paramLocale.getCountry();
/* 227 */       String str1 = paramLocale.getVariant();
/* 228 */       boolean bool1 = "".equals(str2);
/* 229 */       boolean bool2 = "".equals(str3);
/* 230 */       boolean bool3 = "".equals(str1);
/*     */       
/* 232 */       if (!bool1 || !bool2 || !bool3) {
/* 233 */         stringBuilder.append('_');
/* 234 */         if (!bool3) {
/* 235 */           stringBuilder.append(str2).append('_').append(str3).append('_').append(str1);
/* 236 */         } else if (!bool2) {
/* 237 */           stringBuilder.append(str2).append('_').append(str3);
/*     */         } else {
/* 239 */           stringBuilder.append(str2);
/*     */         } 
/*     */       } 
/*     */     } 
/* 243 */     return paramFileHandle.sibling(stringBuilder.append(".properties").toString());
/*     */   }
/*     */   
/*     */   public Locale getLocale() {
/* 247 */     return this.e;
/*     */   }
/*     */   
/*     */   private void c(Locale paramLocale) {
/* 251 */     this.e = paramLocale;
/* 252 */     this.g = new I18NTextFormatter(paramLocale, !c);
/*     */   }
/*     */   
/*     */   public boolean has(String paramString) {
/* 256 */     if (paramString == null) {
/* 257 */       throw new IllegalArgumentException("key is null");
/*     */     }
/*     */     
/* 260 */     if (this.i.containsKey(paramString)) {
/* 261 */       return true;
/*     */     }
/* 263 */     if (this.f.get(paramString) != null) {
/* 264 */       return true;
/*     */     }
/*     */     
/* 267 */     if (this.d != null) {
/* 268 */       return this.d.has(paramString);
/*     */     }
/*     */     
/* 271 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String get(String paramString) {
/* 276 */     if (paramString == null) {
/* 277 */       throw new IllegalArgumentException("key is null");
/*     */     }
/*     */     
/* 280 */     if (this.j.containsKey(paramString)) {
/* 281 */       return (String)this.j.get(paramString);
/*     */     }
/*     */ 
/*     */     
/* 285 */     if (this.i.containsKey(paramString)) {
/* 286 */       str = (String)this.i.get(paramString);
/*     */     
/*     */     }
/* 289 */     else if ((str = (String)this.f.get(paramString)) == null && this.d != null) {
/* 290 */       str = this.d.get(paramString);
/*     */     } 
/*     */ 
/*     */     
/* 294 */     if (str == null) {
/* 295 */       return "???" + paramString + "???";
/*     */     }
/*     */     
/* 298 */     String str = a(str);
/* 299 */     this.j.put(paramString, str);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 309 */     return str;
/*     */   }
/*     */   
/*     */   public String formatStr(String paramString, Object... paramVarArgs) {
/* 313 */     byte b = 0;
/* 314 */     while (paramString.contains("{")) {
/*     */       try {
/* 316 */         paramString = a(this.g.format(paramString, paramVarArgs));
/* 317 */       } catch (Exception exception) {
/*     */         
/* 319 */         a.e("failed to format the string: " + paramString, new Object[] { exception });
/* 320 */         paramString = "[#FF0000]" + paramString + "[]";
/*     */       } 
/* 322 */       b++;
/* 323 */       if (b == 3) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 334 */     return paramString;
/*     */   }
/*     */   
/*     */   public String format(String paramString, Object... paramVarArgs) {
/* 338 */     return formatStr(get(paramString), paramVarArgs);
/*     */   }
/*     */   
/*     */   public void debug(String paramString) {
/*     */     ObjectMap.Keys<String> keys;
/* 343 */     if ((keys = this.f.keys()) == null)
/*     */       return; 
/* 345 */     for (keys = keys.iterator(); keys.hasNext(); ) { String str = keys.next();
/* 346 */       this.f.put(str, paramString); }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\I18NBundle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */