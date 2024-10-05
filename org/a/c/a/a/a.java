/*     */ package org.a.c.a.a;
/*     */ 
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import org.a.c.b.d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ {
/*     */   private final String a;
/*     */   private byte[] b;
/*     */   private d c;
/*  36 */   private static final ConcurrentMap<String, a> d = new ConcurrentHashMap<String, a>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a(String paramString) {
/*  46 */     this.a = paramString;
/*  47 */     if (paramString.startsWith("/"))
/*     */     {
/*  49 */       throw new IllegalArgumentException("Operators are not allowed to start with / '" + paramString + "'");
/*     */     }
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
/*     */   public static a a(String paramString) {
/*     */     a a1;
/*  63 */     if (paramString.equals("ID") || "BI"
/*  64 */       .equals(paramString)) {
/*     */ 
/*     */       
/*  67 */       a1 = new a(paramString);
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*  72 */     else if ((a1 = d.get(paramString)) == null) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  77 */       if ((a1 = d.putIfAbsent(paramString, new a(paramString))) == null)
/*     */       {
/*  79 */         a1 = d.get(paramString);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  84 */     return a1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/*  94 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 105 */     return "PDFOperator{" + this.a + "}";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final byte[] b() {
/* 116 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(byte[] paramArrayOfbyte) {
/* 126 */     this.b = paramArrayOfbyte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d c() {
/* 136 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(d paramd) {
/* 146 */     this.c = paramd;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */