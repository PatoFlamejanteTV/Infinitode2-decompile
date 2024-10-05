/*     */ package com.d.c.f;
/*     */ 
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.d.j;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class h
/*     */ {
/*  30 */   private static final LinkedHashMap a = new LinkedHashMap<>();
/*  31 */   private static final LinkedHashMap b = new LinkedHashMap<>();
/*     */   
/*  33 */   private static final j c = new j((short)3, 0.8F, "0.8em");
/*  34 */   private static final j d = new j((short)3, 1.2F, "1.2em");
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  39 */     a.put(c.bP, new j((short)5, 9.0F, "9px"));
/*  40 */     a.put(c.bN, new j((short)5, 10.0F, "10px"));
/*  41 */     a.put(c.bF, new j((short)5, 13.0F, "13px"));
/*  42 */     a.put(c.bx, new j((short)5, 16.0F, "16px"));
/*  43 */     a.put(c.bv, new j((short)5, 18.0F, "18px"));
/*  44 */     a.put(c.bM, new j((short)5, 24.0F, "24px"));
/*  45 */     a.put(c.bO, new j((short)5, 32.0F, "32px"));
/*     */     
/*  47 */     b.put(c.bP, new j((short)5, 9.0F, "9px"));
/*  48 */     b.put(c.bN, new j((short)5, 10.0F, "10px"));
/*  49 */     b.put(c.bF, new j((short)5, 12.0F, "12px"));
/*  50 */     b.put(c.bx, new j((short)5, 13.0F, "13px"));
/*  51 */     b.put(c.bv, new j((short)5, 16.0F, "16px"));
/*  52 */     b.put(c.bM, new j((short)5, 20.0F, "20px"));
/*  53 */     b.put(c.bO, new j((short)5, 26.0F, "26px"));
/*     */   }
/*     */   
/*     */   public static c a(c paramc) {
/*  57 */     c c1 = null;
/*  58 */     for (Iterator<c> iterator = a.keySet().iterator(); iterator.hasNext(); ) {
/*     */       c c2;
/*  60 */       if ((c2 = iterator.next()) == paramc) {
/*  61 */         return c1;
/*     */       }
/*  63 */       c1 = c2;
/*     */     } 
/*  65 */     return null;
/*     */   }
/*     */   
/*     */   public static c b(c paramc) {
/*  69 */     for (Iterator<c> iterator = a.keySet().iterator(); iterator.hasNext();) {
/*     */       
/*  71 */       if ((c1 = iterator.next()) == paramc && iterator.hasNext()) {
/*  72 */         return iterator.next();
/*     */       }
/*     */     } 
/*  75 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static j a(c paramc, String[] paramArrayOfString) {
/*     */     boolean bool;
/*  81 */     if (bool = a(paramArrayOfString)) {
/*  82 */       return (j)b.get(paramc);
/*     */     }
/*  84 */     return (j)a.get(paramc);
/*     */   }
/*     */ 
/*     */   
/*     */   public static j c(c paramc) {
/*  89 */     if (paramc == c.bw)
/*  90 */       return d; 
/*  91 */     if (paramc == c.bG) {
/*  92 */       return c;
/*     */     }
/*  94 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean a(String[] paramArrayOfString) {
/*  99 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/* 100 */       if (paramArrayOfString[b].equals("monospace")) {
/* 101 */         return true;
/*     */       }
/*     */     } 
/* 104 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\f\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */