/*     */ package com.a.a.c.c.a;
/*     */ 
/*     */ import com.a.a.a.al;
/*     */ import com.a.a.a.an;
/*     */ import com.a.a.c.c.w;
/*     */ import com.a.a.c.j;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class z
/*     */ {
/*     */   private al.a a;
/*     */   private LinkedList<a> b;
/*     */   private an c;
/*     */   
/*     */   public z(al.a parama) {
/*  33 */     this.a = parama;
/*     */   }
/*     */   
/*     */   public final void a(an paraman) {
/*  37 */     this.c = paraman;
/*     */   }
/*     */   
/*     */   public final al.a a() {
/*  41 */     return this.a;
/*     */   }
/*     */   
/*     */   public final void a(a parama) {
/*  45 */     if (this.b == null) {
/*  46 */       this.b = new LinkedList<>();
/*     */     }
/*  48 */     this.b.add(parama);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject) {
/*  57 */     this.c.a(this.a, paramObject);
/*     */     
/*  59 */     Object object = this.a.a;
/*  60 */     if (this.b != null) {
/*  61 */       Iterator<a> iterator = this.b.iterator();
/*  62 */       this.b = null;
/*  63 */       while (iterator.hasNext()) {
/*  64 */         ((a)iterator.next()).a(object, paramObject);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public final Object b() {
/*  70 */     return this.c.a(this.a);
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
/*     */   public final String toString() {
/* 119 */     return String.valueOf(this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class a
/*     */   {
/*     */     private final w a;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a(w param1w, Class<?> param1Class) {
/* 133 */       this.a = param1w;
/*     */     }
/*     */ 
/*     */     
/*     */     public a(w param1w, j param1j) {
/* 138 */       this.a = param1w;
/* 139 */       param1j.b();
/*     */     }
/*     */ 
/*     */     
/*     */     public abstract void a(Object param1Object1, Object param1Object2);
/*     */ 
/*     */     
/*     */     public final boolean b(Object param1Object) {
/* 147 */       return param1Object.equals(this.a.f());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\z.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */