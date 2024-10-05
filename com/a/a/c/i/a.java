/*     */ package com.a.a.c.i;
/*     */ 
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.j;
/*     */ import java.io.Closeable;
/*     */ import java.io.Serializable;
/*     */ import java.util.HashSet;
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
/*     */ public final class a
/*     */   extends c
/*     */   implements Serializable
/*     */ {
/*     */   public final c.b a(q<?> paramq, j paramj) {
/*  31 */     if (a(paramj)) {
/*  32 */       return c.b.b;
/*     */     }
/*     */ 
/*     */     
/*  36 */     return c.b.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final c.b a() {
/*  43 */     return c.b.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final c.b a(q<?> paramq, j paramj1, j paramj2) {
/*  50 */     return c.b.a;
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
/*     */   private static boolean a(j paramj) {
/*  77 */     return a.a.a(paramj.b());
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
/*     */   static final class a
/*     */   {
/*     */     private a() {
/*  98 */       this.b = new HashSet<>();
/*     */ 
/*     */       
/* 101 */       this.b.add(Object.class.getName());
/* 102 */       this.b.add(Closeable.class.getName());
/* 103 */       this.b.add(Serializable.class.getName());
/* 104 */       this.b.add(AutoCloseable.class.getName());
/* 105 */       this.b.add(Cloneable.class.getName());
/*     */ 
/*     */ 
/*     */       
/* 109 */       this.b.add("java.util.logging.Handler");
/* 110 */       this.b.add("javax.naming.Referenceable");
/* 111 */       this.b.add("javax.sql.DataSource");
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean a(Class<?> param1Class) {
/* 116 */       return this.b.contains(param1Class.getName());
/*     */     }
/*     */     
/*     */     public static final a a = new a();
/*     */     private final Set<String> b;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\i\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */