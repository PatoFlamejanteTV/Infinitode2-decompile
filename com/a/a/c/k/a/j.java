/*    */ package com.a.a.c.k.a;
/*    */ 
/*    */ import com.a.a.a.al;
/*    */ import com.a.a.a.am;
/*    */ import com.a.a.c.f.ad;
/*    */ import com.a.a.c.k.e;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class j
/*    */   extends am.c
/*    */ {
/*    */   private e b;
/*    */   
/*    */   public j(ad paramad, e parame) {
/* 18 */     this(paramad.c(), parame);
/*    */   }
/*    */ 
/*    */   
/*    */   private j(Class<?> paramClass, e parame) {
/* 23 */     super(paramClass);
/* 24 */     this.b = parame;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean a(al<?> paramal) {
/*    */     j j1;
/* 33 */     if (paramal.getClass() == getClass() && (
/*    */       
/* 35 */       j1 = (j)paramal).a() == this.a)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 42 */       return (j1.b == this.b);
/*    */     }
/*    */     
/* 45 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public final Object b(Object paramObject) {
/*    */     try {
/* 51 */       return this.b.a(paramObject);
/* 52 */     } catch (RuntimeException runtimeException) {
/* 53 */       throw paramObject = null;
/* 54 */     } catch (Exception exception) {
/* 55 */       throw new IllegalStateException("Problem accessing property '" + this.b
/* 56 */           .a() + "': " + exception.getMessage(), exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public final al<Object> a(Class<?> paramClass) {
/* 62 */     return (al<Object>)((paramClass == this.a) ? this : new j(paramClass, this.b));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final al<Object> b() {
/* 68 */     return (al<Object>)this;
/*    */   }
/*    */ 
/*    */   
/*    */   public final al.a a(Object paramObject) {
/* 73 */     if (paramObject == null) {
/* 74 */       return null;
/*    */     }
/*    */     
/* 77 */     return new al.a(getClass(), this.a, paramObject);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\a\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */