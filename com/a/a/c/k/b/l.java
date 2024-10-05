/*    */ package com.a.a.c.k.b;
/*    */ 
/*    */ import com.a.a.b.h;
/*    */ import com.a.a.c.a.a;
/*    */ import com.a.a.c.aa;
/*    */ import java.text.DateFormat;
/*    */ import java.util.Date;
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
/*    */ @a
/*    */ public final class l
/*    */   extends m<Date>
/*    */ {
/* 24 */   public static final l a = new l();
/*    */   
/*    */   public l() {
/* 27 */     this((Boolean)null, (DateFormat)null);
/*    */   }
/*    */   
/*    */   private l(Boolean paramBoolean, DateFormat paramDateFormat) {
/* 31 */     super(Date.class, paramBoolean, paramDateFormat);
/*    */   }
/*    */ 
/*    */   
/*    */   private static l b(Boolean paramBoolean, DateFormat paramDateFormat) {
/* 36 */     return new l(paramBoolean, paramDateFormat);
/*    */   }
/*    */ 
/*    */   
/*    */   private static long a(Date paramDate) {
/* 41 */     return (paramDate == null) ? 0L : paramDate.getTime();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void b(Date paramDate, h paramh, aa paramaa) {
/* 47 */     if (a(paramaa)) {
/* 48 */       paramh.b(a(paramDate));
/*    */       return;
/*    */     } 
/* 51 */     a(paramDate, paramh, paramaa);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */