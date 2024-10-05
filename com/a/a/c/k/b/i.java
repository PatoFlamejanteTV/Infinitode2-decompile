/*    */ package com.a.a.c.k.b;
/*    */ 
/*    */ import com.a.a.b.h;
/*    */ import com.a.a.c.a.a;
/*    */ import com.a.a.c.aa;
/*    */ import java.text.DateFormat;
/*    */ import java.util.Calendar;
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
/*    */ public final class i
/*    */   extends m<Calendar>
/*    */ {
/* 21 */   public static final i a = new i();
/*    */   public i() {
/* 23 */     this((Boolean)null, (DateFormat)null);
/*    */   }
/*    */   private i(Boolean paramBoolean, DateFormat paramDateFormat) {
/* 26 */     super(Calendar.class, paramBoolean, paramDateFormat);
/*    */   }
/*    */ 
/*    */   
/*    */   private static i b(Boolean paramBoolean, DateFormat paramDateFormat) {
/* 31 */     return new i(paramBoolean, paramDateFormat);
/*    */   }
/*    */ 
/*    */   
/*    */   private static long a(Calendar paramCalendar) {
/* 36 */     return (paramCalendar == null) ? 0L : paramCalendar.getTimeInMillis();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void a(Calendar paramCalendar, h paramh, aa paramaa) {
/* 42 */     if (a(paramaa)) {
/* 43 */       paramh.b(a(paramCalendar));
/*    */       return;
/*    */     } 
/* 46 */     a(paramCalendar.getTime(), paramh, paramaa);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */