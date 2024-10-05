/*    */ package com.a.a.c.f;
/*    */ 
/*    */ import com.a.a.a.al;
/*    */ import com.a.a.a.an;
/*    */ import com.a.a.a.aq;
/*    */ import com.a.a.c.m.i;
/*    */ import com.a.a.c.w;
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
/*    */ public final class ad
/*    */ {
/*    */   private w a;
/*    */   private Class<? extends al<?>> b;
/*    */   private Class<? extends an> c;
/*    */   private Class<?> d;
/*    */   private boolean e;
/* 26 */   private static final ad f = new ad(w.b, Object.class, null, false, null);
/*    */ 
/*    */ 
/*    */   
/*    */   public ad(w paramw, Class<?> paramClass, Class<? extends al<?>> paramClass1, Class<? extends an> paramClass2) {
/* 31 */     this(paramw, paramClass, paramClass1, false, paramClass2);
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
/*    */   private ad(w paramw, Class<?> paramClass, Class<? extends al<?>> paramClass1, boolean paramBoolean, Class<? extends an> paramClass2) {
/*    */     Class<aq> clazz;
/* 44 */     this.a = paramw;
/* 45 */     this.d = paramClass;
/* 46 */     this.b = paramClass1;
/* 47 */     this.e = paramBoolean;
/* 48 */     if (paramClass2 == null) {
/* 49 */       clazz = aq.class;
/*    */     }
/* 51 */     this.c = (Class)clazz;
/*    */   }
/*    */   
/*    */   public static ad a() {
/* 55 */     return f;
/*    */   }
/*    */   
/*    */   public final ad a(boolean paramBoolean) {
/* 59 */     if (this.e == paramBoolean) {
/* 60 */       return this;
/*    */     }
/* 62 */     return new ad(this.a, this.d, this.b, paramBoolean, this.c);
/*    */   }
/*    */   
/* 65 */   public final w b() { return this.a; }
/* 66 */   public final Class<?> c() { return this.d; }
/* 67 */   public final Class<? extends al<?>> d() { return this.b; }
/* 68 */   public final Class<? extends an> e() { return this.c; } public final boolean f() {
/* 69 */     return this.e;
/*    */   }
/*    */   
/*    */   public final String toString() {
/* 73 */     return "ObjectIdInfo: propName=" + this.a + ", scope=" + 
/* 74 */       i.g(this.d) + ", generatorType=" + 
/* 75 */       i.g(this.b) + ", alwaysAsId=" + this.e;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\ad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */