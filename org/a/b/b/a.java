/*     */ package org.a.b.b;
/*     */ 
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.a.b.g.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */   extends i
/*     */ {
/*     */   private String f;
/*     */   private String g;
/*     */   private int h;
/*  40 */   private List<Map<String, Object>> i = new LinkedList<Map<String, Object>>();
/*  41 */   private List<Map<String, Object>> j = new LinkedList<Map<String, Object>>();
/*     */   
/*     */   private s k;
/*  44 */   private final Map<Integer, p> l = new ConcurrentHashMap<Integer, p>();
/*     */ 
/*     */   
/*  47 */   private final a m = new a((byte)0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/*  55 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void c(String paramString) {
/*  65 */     this.f = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String e() {
/*  75 */     return this.g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void d(String paramString) {
/*  85 */     this.g = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int f() {
/*  95 */     return this.h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void a(int paramInt) {
/* 105 */     this.h = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<Map<String, Object>> g() {
/* 115 */     return this.i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void a(List<Map<String, Object>> paramList) {
/* 125 */     this.i = paramList;
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
/*     */   final void b(List<Map<String, Object>> paramList) {
/* 145 */     this.j = paramList;
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
/*     */   final void a(s params) {
/* 165 */     this.k = params;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int d(int paramInt) {
/* 176 */     if ((paramInt = this.k.a(paramInt)) == -1)
/*     */     {
/* 178 */       return 1000;
/*     */     }
/*     */     Map<?, ?> map;
/* 181 */     return (map = this.j.get(paramInt)).containsKey("defaultWidthX") ? ((Number)map.get("defaultWidthX")).intValue() : 1000;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int e(int paramInt) {
/* 192 */     if ((paramInt = this.k.a(paramInt)) == -1)
/*     */     {
/* 194 */       return 0;
/*     */     }
/*     */     Map<?, ?> map;
/* 197 */     return (map = this.j.get(paramInt)).containsKey("nominalWidthX") ? ((Number)map.get("nominalWidthX")).intValue() : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private byte[][] f(int paramInt) {
/* 208 */     if ((paramInt = this.k.a(paramInt)) == -1)
/*     */     {
/* 210 */       return (byte[][])null;
/*     */     }
/*     */     Map<?, byte[][]> map;
/* 213 */     return (map = (Map)this.j.get(paramInt)).get("Subrs");
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
/*     */   public final p b(int paramInt) {
/*     */     p p;
/* 226 */     if ((p = this.l.get(Integer.valueOf(paramInt))) == null) {
/*     */       
/* 228 */       int j = this.c.c(paramInt);
/*     */       
/*     */       byte[] arrayOfByte;
/* 231 */       if ((arrayOfByte = this.d[j]) == null)
/*     */       {
/* 233 */         arrayOfByte = this.d[0];
/*     */       }
/*     */       y y;
/* 236 */       List<Object> list = (y = new y(this.a, paramInt)).a(arrayOfByte, this.e, f(j));
/*     */       
/* 238 */       p = new p(this.m, this.a, paramInt, j, list, d(j), e(j));
/* 239 */       this.l.put(Integer.valueOf(paramInt), p);
/*     */     } 
/* 241 */     return p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<Number> d() {
/* 248 */     return (List<Number>)this.b.get("FontMatrix");
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
/*     */   public final float a(String paramString) {
/* 261 */     int j = f(paramString);
/* 262 */     return b(j).a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean b(String paramString) {
/*     */     int j;
/* 269 */     return ((j = f(paramString)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int f(String paramString) {
/* 277 */     if (!paramString.startsWith("\\"))
/*     */     {
/* 279 */       throw new IllegalArgumentException("Invalid selector");
/*     */     }
/* 281 */     return Integer.parseInt(paramString.substring(1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   class a
/*     */     implements c
/*     */   {
/*     */     private a(a this$0) {}
/*     */ 
/*     */     
/*     */     public final t a_(String param1String) {
/* 293 */       return this.a.b(0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */