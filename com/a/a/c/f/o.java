/*    */ package com.a.a.c.f;
/*    */ 
/*    */ import com.a.a.c.j;
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
/*    */ public abstract class o
/*    */   extends j
/*    */ {
/*    */   protected final aa[] c;
/*    */   
/*    */   protected o(an paraman, aa paramaa, aa[] paramArrayOfaa) {
/* 31 */     super(paraman, paramaa);
/* 32 */     this.c = paramArrayOfaa;
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
/*    */   protected final n a(int paramInt, aa paramaa) {
/* 65 */     this.c[paramInt] = paramaa;
/* 66 */     return c(paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private aa d(int paramInt) {
/* 77 */     if (this.c != null && 
/* 78 */       paramInt >= 0 && paramInt < this.c.length) {
/* 79 */       return this.c[paramInt];
/*    */     }
/*    */     
/* 82 */     return null;
/*    */   }
/*    */   
/*    */   public final n c(int paramInt) {
/* 86 */     return new n(this, b(paramInt), this.a, 
/* 87 */         d(paramInt), paramInt);
/*    */   }
/*    */   
/*    */   public abstract int f();
/*    */   
/*    */   public abstract Class<?> a(int paramInt);
/*    */   
/*    */   public abstract j b(int paramInt);
/*    */   
/*    */   public abstract Object g();
/*    */   
/*    */   public abstract Object a(Object[] paramArrayOfObject);
/*    */   
/*    */   public abstract Object a(Object paramObject);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */