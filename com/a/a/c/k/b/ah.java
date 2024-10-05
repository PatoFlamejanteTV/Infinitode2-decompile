/*     */ package com.a.a.c.k.b;
/*     */ 
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.f.b;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.k.k;
/*     */ import com.a.a.c.o;
/*     */ import java.util.Collection;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ah<T extends Collection<?>>
/*     */   extends ao<T>
/*     */   implements k
/*     */ {
/*     */   protected final Boolean b;
/*     */   
/*     */   protected ah(Class<?> paramClass) {
/*  38 */     super(paramClass, (byte)0);
/*  39 */     this.b = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ah(ah<?> paramah, Boolean paramBoolean) {
/*  47 */     super(paramah);
/*  48 */     this.b = paramBoolean;
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
/*     */   public final o<?> a(aa paramaa, c paramc) {
/*  69 */     o<?> o = null;
/*  70 */     Boolean bool = null;
/*     */ 
/*     */     
/*  73 */     a a = paramaa.d(); Object object;
/*     */     j j;
/*  75 */     if (paramc != null && (j = paramc.e()) != null && (
/*     */       
/*  77 */       object = a.p((b)j)) != null) {
/*  78 */       o = paramaa.b((b)j, object);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  83 */     if ((object = a(paramaa, paramc, a())) != null) {
/*  84 */       bool = object.a(l.a.c);
/*     */     }
/*     */ 
/*     */     
/*  88 */     if ((o = a(paramaa, paramc, o)) == null) {
/*  89 */       o = paramaa.c(String.class, paramc);
/*     */     }
/*     */     
/*  92 */     if (a(o)) {
/*  93 */       if (Objects.equals(bool, this.b)) {
/*  94 */         return this;
/*     */       }
/*  96 */       return a(bool);
/*     */     } 
/*     */ 
/*     */     
/* 100 */     return (o<?>)new k(paramaa.a(String.class), true, null, o);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean b(T paramT) {
/* 106 */     return (paramT == null || paramT.isEmpty());
/*     */   }
/*     */   
/*     */   public abstract o<?> a(Boolean paramBoolean);
/*     */   
/*     */   public abstract void a(T paramT, h paramh, aa paramaa, i parami);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\ah.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */