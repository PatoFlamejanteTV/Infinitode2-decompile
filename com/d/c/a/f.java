/*     */ package com.d.c.a;
/*     */ 
/*     */ import com.d.c.d.d;
/*     */ import com.d.h.w;
/*     */ import com.d.m.e;
/*     */ import com.d.m.l;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import java.util.logging.Level;
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
/*     */ public final class f
/*     */ {
/*     */   public static String a(short paramShort) {
/* 115 */     return (String)b.get(Short.valueOf(paramShort));
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
/*     */   public static boolean b(short paramShort) {
/* 148 */     switch (paramShort) {
/*     */       
/*     */       case 2:
/* 151 */         return false;
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
/*     */       case 1:
/*     */       case 3:
/*     */       case 4:
/*     */       case 5:
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/*     */       case 9:
/*     */       case 10:
/*     */       case 11:
/*     */       case 12:
/*     */       case 13:
/*     */       case 14:
/*     */       case 15:
/*     */       case 16:
/*     */       case 17:
/*     */       case 18:
/*     */       case 19:
/*     */       case 20:
/*     */       case 21:
/*     */       case 22:
/*     */       case 23:
/*     */       case 24:
/*     */       case 25:
/* 193 */         return true;
/*     */       case 0:
/* 195 */         l.c(Level.WARNING, "Asked whether type was absolute, given CSS_UNKNOWN as the type. Might be one of those funny values like background-position.");
/*     */         
/* 197 */         e.a(new Exception());
/*     */         break;
/*     */     } 
/* 200 */     return false;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 256 */     TreeMap<Object, Object> treeMap = new TreeMap<>();
/* 257 */   } private static final List a = new ArrayList(); static {
/*     */     try {
/* 259 */       Field[] arrayOfField = d.class.getFields();
/* 260 */       for (byte b = 0; b < arrayOfField.length; b++) {
/*     */         Field field;
/*     */         int i;
/* 263 */         if (Modifier.isFinal(i = (field = arrayOfField[b]).getModifiers()) && 
/* 264 */           Modifier.isStatic(i) && 
/* 265 */           Modifier.isPublic(i)) {
/*     */           
/* 267 */           Short short_ = (Short)field.get(null);
/*     */           String str;
/* 269 */           if ((str = field.getName()).startsWith("CSS_") && 
/* 270 */             !str.equals("CSS_INHERIT") && 
/* 271 */             !str.equals("CSS_PRIMITIVE_VALUE") && 
/* 272 */             !str.equals("CSS_VALUE_LIST") && 
/* 273 */             !str.equals("CSS_CUSTOM"))
/*     */           {
/* 275 */             treeMap.put(short_, str.substring(4));
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/*     */       ArrayList<Comparable> arrayList;
/*     */       
/* 282 */       Collections.sort(arrayList = new ArrayList<>(treeMap.keySet()));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 287 */       Iterator<Comparable> iterator = arrayList.iterator();
/* 288 */       while (iterator.hasNext()) {
/* 289 */         a.add(treeMap.get(iterator.next()));
/*     */       }
/* 291 */     } catch (Exception exception) {
/* 292 */       throw new w.a("Could not build static list of CSS type descriptions.", exception);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 297 */     (b = new HashMap<>(25)).put(Short.valueOf((short)3), "em");
/* 298 */     b.put(Short.valueOf((short)4), "ex");
/* 299 */     b.put(Short.valueOf((short)5), "px");
/* 300 */     b.put(Short.valueOf((short)2), "%");
/* 301 */     b.put(Short.valueOf((short)8), "in");
/* 302 */     b.put(Short.valueOf((short)6), "cm");
/* 303 */     b.put(Short.valueOf((short)7), "mm");
/* 304 */     b.put(Short.valueOf((short)9), "pt");
/* 305 */     b.put(Short.valueOf((short)10), "pc");
/*     */   }
/*     */   
/*     */   private static final Map b;
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\a\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */