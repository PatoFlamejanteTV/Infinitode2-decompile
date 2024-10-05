/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ac
/*     */   extends ai<StackTraceElement>
/*     */ {
/*     */   private k<?> a;
/*     */   
/*     */   @Deprecated
/*     */   public ac() {
/*  22 */     this((k<?>)null);
/*     */   }
/*     */ 
/*     */   
/*     */   private ac(k<?> paramk) {
/*  27 */     super(StackTraceElement.class);
/*  28 */     this.a = paramk;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static k<?> d(g paramg) {
/*  36 */     if (paramg == null) {
/*  37 */       return new ac();
/*     */     }
/*  39 */     k<?> k1 = paramg.a(paramg.b(a.class));
/*  40 */     return new ac(k1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private StackTraceElement c(l paraml, g paramg) {
/*     */     a a;
/*     */     o o;
/*  49 */     if ((o = paraml.k()) == o.b || o == o.f) {
/*     */ 
/*     */       
/*  52 */       if (this.a == null) {
/*  53 */         a = (a)paramg.b(paraml, a.class);
/*     */       } else {
/*  55 */         a = (a)this.a.a(paraml, paramg);
/*     */       } 
/*  57 */       return a(paramg, a);
/*  58 */     }  if (a == o.d && paramg.a(i.q)) {
/*  59 */       paraml.g();
/*  60 */       StackTraceElement stackTraceElement = c(paraml, paramg);
/*  61 */       if (paraml.g() != o.e) {
/*  62 */         j(paramg);
/*     */       }
/*  64 */       return stackTraceElement;
/*     */     } 
/*  66 */     return (StackTraceElement)paramg.a(this.s, paraml);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private StackTraceElement a(g paramg, a parama) {
/*  75 */     return a(parama.a, parama.c, parama.b, parama.d);
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
/*     */   private static StackTraceElement a(String paramString1, String paramString2, String paramString3, int paramInt) {
/* 100 */     return new StackTraceElement(paramString1, paramString2, paramString3, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class a
/*     */   {
/* 111 */     public String a = "";
/*     */     
/* 113 */     public String b = ""; public String c = "";
/* 114 */     public int d = -1;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\ac.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */