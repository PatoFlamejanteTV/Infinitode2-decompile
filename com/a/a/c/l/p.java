/*     */ package com.a.a.c.l;
/*     */ 
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.m.i;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.StringTokenizer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class p
/*     */   implements Serializable
/*     */ {
/*     */   private o a;
/*     */   
/*     */   public p(o paramo) {
/*  20 */     this.a = paramo;
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
/*     */   public final j a(String paramString) {
/*  32 */     a a = new a(paramString.trim());
/*  33 */     j j = a(a);
/*     */     
/*  35 */     if (a.hasMoreTokens()) {
/*  36 */       throw a(a, "Unexpected tokens after complete type");
/*     */     }
/*  38 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private j a(a parama) {
/*  44 */     if (!parama.hasMoreTokens()) {
/*  45 */       throw a(parama, "Unexpected end-of-string");
/*     */     }
/*  47 */     Class<?> clazz = a(parama.nextToken(), parama);
/*     */ 
/*     */     
/*  50 */     if (parama.hasMoreTokens()) {
/*  51 */       n n; String str = parama.nextToken();
/*  52 */       if ("<".equals(str)) {
/*  53 */         List<j> list = b(parama);
/*  54 */         n = n.a(clazz, list);
/*  55 */         return this.a.a((c)null, clazz, n);
/*     */       } 
/*     */       
/*  58 */       n.a(str);
/*     */     } 
/*  60 */     return this.a.a((c)null, clazz, n.a());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private List<j> b(a parama) {
/*  66 */     ArrayList<j> arrayList = new ArrayList();
/*  67 */     while (parama.hasMoreTokens()) {
/*  68 */       arrayList.add(a(parama));
/*  69 */       if (parama.hasMoreTokens()) {
/*  70 */         String str = parama.nextToken();
/*  71 */         if (">".equals(str)) return arrayList; 
/*  72 */         if (!",".equals(str))
/*  73 */           throw a(parama, "Unexpected token '" + str + "', expected ',' or '>')"); 
/*     */       } 
/*     */     } 
/*  76 */     throw a(parama, "Unexpected end-of-string");
/*     */   }
/*     */ 
/*     */   
/*     */   private Class<?> a(String paramString, a parama) {
/*     */     try {
/*  82 */       return this.a.a(paramString);
/*  83 */     } catch (Exception exception2) {
/*  84 */       Exception exception1; i.b(exception1 = null);
/*  85 */       throw a(parama, "Cannot locate class '" + paramString + "', problem: " + exception1.getMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static IllegalArgumentException a(a parama, String paramString) {
/*  91 */     return new IllegalArgumentException(String.format("Failed to parse type '%s' (remaining: '%s'): %s", new Object[] { parama
/*  92 */             .a(), parama.b(), paramString }));
/*     */   }
/*     */ 
/*     */   
/*     */   static final class a
/*     */     extends StringTokenizer
/*     */   {
/*     */     private String a;
/*     */     private int b;
/*     */     private String c;
/*     */     
/*     */     public a(String param1String) {
/* 104 */       super(param1String, "<,>", true);
/* 105 */       this.a = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean hasMoreTokens() {
/* 110 */       return (this.c != null || super.hasMoreTokens());
/*     */     }
/*     */ 
/*     */     
/*     */     public final String nextToken() {
/*     */       String str;
/* 116 */       if (this.c != null) {
/* 117 */         str = this.c;
/* 118 */         this.c = null;
/*     */       } else {
/* 120 */         str = super.nextToken();
/* 121 */         this.b += str.length();
/* 122 */         str = str.trim();
/*     */       } 
/* 124 */       return str;
/*     */     }
/*     */     
/*     */     public final void a(String param1String) {
/* 128 */       this.c = param1String;
/*     */     }
/*     */     
/*     */     public final String a() {
/* 132 */       return this.a;
/*     */     } public final String b() {
/* 134 */       return this.a.substring(this.b);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\l\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */