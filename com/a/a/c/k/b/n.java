/*     */ package com.a.a.c.k.b;
/*     */ 
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.k.k;
/*     */ import com.a.a.c.m.m;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.y;
/*     */ import com.a.a.c.z;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ public final class n
/*     */   extends an<Enum<?>>
/*     */   implements k
/*     */ {
/*     */   private m a;
/*     */   private Boolean b;
/*     */   
/*     */   private n(m paramm, Boolean paramBoolean) {
/*  60 */     super(paramm.a(), (byte)0);
/*  61 */     this.a = paramm;
/*  62 */     this.b = paramBoolean;
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
/*     */   public static n a(Class<?> paramClass, y paramy, l.d paramd) {
/*  79 */     m m1 = m.a((q)paramy, paramClass);
/*  80 */     Boolean bool = a(paramClass, paramd, true, (Boolean)null);
/*  81 */     return new n(m1, bool);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final o<?> a(aa paramaa, c paramc) {
/*     */     l.d d;
/*     */     Boolean bool;
/*     */     Class<Enum<?>> clazz;
/*  95 */     if ((d = a(paramaa, paramc, a())) != null && 
/*     */ 
/*     */ 
/*     */       
/*  99 */       !Objects.equals(bool = a(clazz = a(), d, false, this.b), this.b)) {
/* 100 */       return new n(this.a, bool);
/*     */     }
/*     */     
/* 103 */     return this;
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
/*     */   private void a(Enum<?> paramEnum, h paramh, aa paramaa) {
/* 124 */     if (a(paramaa)) {
/* 125 */       paramh.c(paramEnum.ordinal());
/*     */       
/*     */       return;
/*     */     } 
/* 129 */     if (paramaa.a(z.m)) {
/* 130 */       paramh.b(paramEnum.toString());
/*     */       return;
/*     */     } 
/* 133 */     paramh.c(this.a.a(paramEnum));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(aa paramaa) {
/* 198 */     if (this.b != null) {
/* 199 */       return this.b.booleanValue();
/*     */     }
/* 201 */     return paramaa.a(z.n);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Boolean a(Class<?> paramClass, l.d paramd, boolean paramBoolean, Boolean paramBoolean1) {
/*     */     l.c c;
/* 213 */     if ((c = (l.c)((paramd == null) ? null : paramd.c())) == null) {
/* 214 */       return paramBoolean1;
/*     */     }
/*     */     
/* 217 */     if (c == l.c.a || c == l.c.c) {
/* 218 */       return paramBoolean1;
/*     */     }
/*     */     
/* 221 */     if (c == l.c.h || c == l.c.b) {
/* 222 */       return Boolean.FALSE;
/*     */     }
/*     */     
/* 225 */     if (c.a() || c == l.c.d) {
/* 226 */       return Boolean.TRUE;
/*     */     }
/*     */     
/* 229 */     throw new IllegalArgumentException(String.format("Unsupported serialization shape (%s) for Enum %s, not supported as %s annotation", new Object[] { c, paramClass
/*     */             
/* 231 */             .getName(), paramBoolean ? "class" : "property" }));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */