/*     */ package com.d.c.d.a;
/*     */ 
/*     */ import com.d.c.d.d;
/*     */ import com.d.c.d.j;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class k
/*     */ {
/*  32 */   private static k a = new k((d)new j((short)7, 148.0F, "148mm"), (d)new j((short)7, 210.0F, "210mm"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  39 */   private static k b = new k((d)new j((short)7, 210.0F, "210mm"), (d)new j((short)7, 297.0F, "297mm"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   private static k c = new k((d)new j((short)7, 297.0F, "297mm"), (d)new j((short)7, 420.0F, "420mm"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   private static k d = new k((d)new j((short)7, 176.0F, "176mm"), (d)new j((short)7, 250.0F, "250mm"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   private static k e = new k((d)new j((short)7, 250.0F, "250mm"), (d)new j((short)7, 353.0F, "353mm"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  67 */   private static k f = new k((d)new j((short)8, 8.5F, "8.5in"), (d)new j((short)8, 11.0F, "11in"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  74 */   private static k g = new k((d)new j((short)8, 8.5F, "8.5in"), (d)new j((short)8, 14.0F, "14in"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   private static k h = new k((d)new j((short)8, 11.0F, "11in"), (d)new j((short)8, 17.0F, "17in"));
/*     */   
/*     */   private static final Map i;
/*     */   
/*     */   private d j;
/*     */   private d k;
/*     */   
/*     */   static {
/*  89 */     (i = new HashMap<>()).put("a3", c);
/*  90 */     i.put("a4", b);
/*  91 */     i.put("a5", a);
/*  92 */     i.put("b3", d);
/*  93 */     i.put("b4", e);
/*  94 */     i.put("letter", f);
/*  95 */     i.put("legal", g);
/*  96 */     i.put("ledger", h);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private k(d paramd1, d paramd2) {
/* 103 */     this.j = paramd1;
/* 104 */     this.k = paramd2;
/*     */   }
/*     */ 
/*     */   
/*     */   private k() {}
/*     */   
/*     */   public final d a() {
/* 111 */     return this.k;
/*     */   }
/*     */   
/*     */   public final d b() {
/* 115 */     return this.j;
/*     */   }
/*     */   
/*     */   public static k a(String paramString) {
/* 119 */     return (k)i.get(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\d\a\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */