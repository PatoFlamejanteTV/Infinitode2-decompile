/*    */ package com.a.a.c.k.b;
/*    */ 
/*    */ import com.a.a.b.h;
/*    */ import com.a.a.c.aa;
/*    */ import com.a.a.c.c;
/*    */ import com.a.a.c.i.i;
/*    */ import com.a.a.c.j;
/*    */ import com.a.a.c.k.j;
/*    */ import com.a.a.c.z;
/*    */ import java.util.EnumSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class o
/*    */   extends b<EnumSet<? extends Enum<?>>>
/*    */ {
/*    */   public o(j paramj) {
/* 18 */     super(EnumSet.class, paramj, true, (i)null, (com.a.a.c.o)null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private o(o paramo, c paramc, i parami, com.a.a.c.o<?> paramo1, Boolean paramBoolean) {
/* 24 */     super(paramo, paramc, parami, paramo1, paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private o d() {
/* 30 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private o b(c paramc, i parami, com.a.a.c.o<?> paramo, Boolean paramBoolean) {
/* 37 */     return new o(this, paramc, parami, paramo, paramBoolean);
/*    */   }
/*    */ 
/*    */   
/*    */   private static boolean a(EnumSet<? extends Enum<?>> paramEnumSet) {
/* 42 */     return paramEnumSet.isEmpty();
/*    */   }
/*    */ 
/*    */   
/*    */   private static boolean b(EnumSet<? extends Enum<?>> paramEnumSet) {
/* 47 */     return (paramEnumSet.size() == 1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void a(EnumSet<? extends Enum<?>> paramEnumSet, h paramh, aa paramaa) {
/*    */     int i;
/* 55 */     if ((i = paramEnumSet.size()) == 1 && ((
/* 56 */       this.c == null && paramaa
/* 57 */       .a(z.r)) || this.c == Boolean.TRUE)) {
/*    */       
/* 59 */       b(paramEnumSet, paramh, paramaa);
/*    */       
/*    */       return;
/*    */     } 
/* 63 */     paramh.a(paramEnumSet, i);
/* 64 */     b(paramEnumSet, paramh, paramaa);
/* 65 */     paramh.h();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void b(EnumSet<? extends Enum<?>> paramEnumSet, h paramh, aa paramaa) {
/* 73 */     com.a.a.c.o o1 = this.e;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 78 */     for (Enum<?> enum_ : paramEnumSet) {
/* 79 */       if (o1 == null)
/*    */       {
/*    */         
/* 82 */         o1 = paramaa.c(enum_.getDeclaringClass(), this.b);
/*    */       }
/* 84 */       o1.a(enum_, paramh, paramaa);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */