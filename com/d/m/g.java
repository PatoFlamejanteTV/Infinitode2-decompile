/*     */ package com.d.m;
/*     */ 
/*     */ import com.a.a.b.c.a;
/*     */ import com.d.h.w;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.logging.Formatter;
/*     */ import java.util.logging.Handler;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
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
/*     */ public class g
/*     */   implements m
/*     */ {
/*     */   private static boolean a = true;
/*     */   
/*     */   public final void a(String paramString1, Level paramLevel, String paramString2) {
/*  50 */     if (a) {
/*  51 */       a();
/*     */     }
/*     */     
/*  54 */     a(paramString1).log(paramLevel, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(String paramString1, Level paramLevel, String paramString2, Throwable paramThrowable) {
/*  59 */     if (a) {
/*  60 */       a();
/*     */     }
/*     */     
/*  63 */     a(paramString1).log(paramLevel, paramString2, paramThrowable);
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
/*     */   private static Logger a(String paramString) {
/*  80 */     return Logger.getLogger(paramString);
/*     */   }
/*     */   
/*     */   private static void a() {
/*  84 */     synchronized (g.class) {
/*  85 */       if (!a) {
/*     */         return;
/*     */       }
/*     */       
/*  89 */       a = false;
/*     */       try {
/*  91 */         Properties properties = b();
/*     */         
/*  93 */         if (!l.b()) {
/*  94 */           b.a(Logger.getLogger(l.a));
/*     */           return;
/*     */         } 
/*  97 */         a(properties);
/*     */         
/*  99 */         b.a(Logger.getLogger(l.a));
/* 100 */       } catch (SecurityException securityException) {
/*     */       
/* 102 */       } catch (FileNotFoundException fileNotFoundException) {
/* 103 */         throw new w.a("Could not initialize logs. " + fileNotFoundException.getLocalizedMessage(), fileNotFoundException);
/* 104 */       } catch (IOException iOException) {
/* 105 */         throw new w.a("Could not initialize logs. " + iOException.getLocalizedMessage(), iOException);
/*     */       } 
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static Properties b() {
/*     */     String str;
/* 114 */     Iterator<String> iterator = b.b(str = "xr.util-logging.");
/* 115 */     Properties properties = new Properties();
/* 116 */     while (iterator.hasNext()) {
/*     */       
/* 118 */       String str1, str2 = (str1 = iterator.next()).substring(str.length());
/* 119 */       str1 = b.a(str1);
/* 120 */       properties.setProperty(str2, str1);
/*     */     } 
/* 122 */     return properties;
/*     */   }
/*     */   
/*     */   private static void a(Properties paramProperties) {
/* 126 */     List list = c();
/*     */     
/* 128 */     a(paramProperties, list);
/*     */ 
/*     */     
/* 131 */     Enumeration<Object> enumeration = paramProperties.keys();
/* 132 */     Map map = new HashMap<>();
/* 133 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 134 */     while (enumeration.hasMoreElements()) {
/* 135 */       String str1 = (String)enumeration.nextElement();
/* 136 */       String str2 = paramProperties.getProperty(str1);
/* 137 */       if (str1.endsWith("level")) {
/* 138 */         a(str1.substring(0, str1.lastIndexOf(".")), str2); continue;
/* 139 */       }  if (str1.endsWith("handlers")) {
/* 140 */         map = a(list, str2); continue;
/* 141 */       }  if (str1.endsWith("formatter")) {
/* 142 */         String str = str1.substring(0, str1.length() - 10);
/* 143 */         hashMap.put(str, str2);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 149 */     for (String str1 : hashMap.keySet()) {
/*     */       
/* 151 */       String str2 = (String)hashMap.get(str1);
/* 152 */       a(map, str1, str2);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void a(Properties paramProperties, List paramList) {
/*     */     String str;
/* 159 */     boolean bool = ((str = paramProperties.getProperty("use-parent-handler")) == null) ? false : Boolean.valueOf(str).booleanValue();
/* 160 */     for (Iterator<Logger> iterator = paramList.iterator(); iterator.hasNext();)
/*     */     {
/* 162 */       (logger = iterator.next()).setUseParentHandlers(bool);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void a(Map paramMap, String paramString1, String paramString2) {
/*     */     Handler handler;
/* 168 */     if ((handler = (Handler)paramMap.get(paramString1)) != null) {
/*     */       try {
/*     */         Class<?> clazz;
/* 171 */         Formatter formatter = (Formatter)(clazz = Class.forName(paramString2)).newInstance();
/* 172 */         handler.setFormatter(formatter); return;
/* 173 */       } catch (ClassNotFoundException classNotFoundException) {
/* 174 */         throw new w.a("Could not initialize logging properties; Formatter class not found: " + paramString2);
/*     */       }
/* 176 */       catch (IllegalAccessException illegalAccessException) {
/* 177 */         throw new w.a("Could not initialize logging properties; Can't instantiate Formatter class (IllegalAccessException): " + paramString2);
/*     */       }
/* 179 */       catch (InstantiationException instantiationException) {
/* 180 */         throw new w.a("Could not initialize logging properties; Can't instantiate Formatter class (InstantiationException): " + paramString2);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static List c() {
/* 191 */     List<String> list = l.a();
/* 192 */     ArrayList<Logger> arrayList = new ArrayList(list.size());
/* 193 */     Iterator<String> iterator = list.iterator();
/* 194 */     while (iterator.hasNext()) {
/* 195 */       String str = iterator.next();
/* 196 */       arrayList.add(Logger.getLogger(str));
/*     */     } 
/* 198 */     return arrayList;
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
/*     */   private static Map a(List paramList, String paramString) {
/* 212 */     String[] arrayOfString = paramString.split(" ");
/* 213 */     HashMap<Object, Object> hashMap = new HashMap<>(arrayOfString.length);
/* 214 */     for (byte b = 0; b < arrayOfString.length; b++) {
/* 215 */       String str = arrayOfString[b];
/*     */       try {
/*     */         Class<?> clazz;
/* 218 */         Handler handler = (Handler)(clazz = Class.forName(str)).newInstance();
/* 219 */         hashMap.put(str, handler);
/* 220 */         String str1 = b.a("xr.util-logging." + str + ".level", "INFO");
/* 221 */         handler.setLevel(a.a(str1, Level.INFO));
/* 222 */       } catch (ClassNotFoundException classNotFoundException) {
/* 223 */         throw new w.a("Could not initialize logging properties; Handler class not found: " + str);
/*     */       }
/* 225 */       catch (IllegalAccessException illegalAccessException) {
/* 226 */         throw new w.a("Could not initialize logging properties; Can't instantiate Handler class (IllegalAccessException): " + str);
/*     */       }
/* 228 */       catch (InstantiationException instantiationException) {
/* 229 */         throw new w.a("Could not initialize logging properties; Can't instantiate Handler class (InstantiationException): " + str);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 235 */     for (Logger logger : paramList) {
/*     */       
/* 237 */       for (Handler handler : hashMap.values())
/*     */       {
/* 239 */         logger.addHandler(handler);
/*     */       }
/*     */     } 
/* 242 */     return hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(String paramString1, String paramString2) {
/* 250 */     Level level = a.a(paramString2, Level.OFF);
/*     */     Logger logger;
/* 252 */     (logger = Logger.getLogger(paramString1)).setLevel(level);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\m\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */