/*    */ package com.a.a.c.c.a;
/*    */ 
/*    */ import com.a.a.b.l;
/*    */ import com.a.a.b.o;
/*    */ import com.a.a.c.c.v;
/*    */ import com.a.a.c.g;
/*    */ import com.a.a.c.m.i;
/*    */ import java.lang.reflect.Constructor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class j
/*    */   extends v.a
/*    */ {
/*    */   private transient Constructor<?> h;
/*    */   
/*    */   public j(v paramv, Constructor<?> paramConstructor) {
/* 39 */     super(paramv);
/* 40 */     this.h = paramConstructor;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final v a(v paramv) {
/* 59 */     if (paramv == this.g) {
/* 60 */       return (v)this;
/*    */     }
/* 62 */     return (v)new j(paramv, this.h);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void a(l paraml, g paramg, Object paramObject) {
/*    */     o o;
/* 77 */     if ((o = paraml.k()) == o.m) {
/* 78 */       Object object = this.c.a(paramg);
/* 79 */     } else if (this.d != null) {
/* 80 */       Object object = this.c.a(paraml, paramg, this.d);
/*    */     } else {
/*    */       try {
/* 83 */         o = (o)this.h.newInstance(new Object[] { paramObject });
/* 84 */       } catch (Exception exception) {
/* 85 */         i.a((Throwable)(o = null), String.format("Failed to instantiate class %s, problem: %s", new Object[] { this.h
/*    */                 
/* 87 */                 .getDeclaringClass().getName(), o.getMessage() }));
/* 88 */         o = null;
/*    */       } 
/* 90 */       this.c.a(paraml, paramg, o);
/*    */     } 
/* 92 */     a(paramObject, o);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final Object b(l paraml, g paramg, Object paramObject) {
/* 99 */     return b(paramObject, a(paraml, paramg));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */