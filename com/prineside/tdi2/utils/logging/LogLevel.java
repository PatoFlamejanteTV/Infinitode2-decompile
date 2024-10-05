/*    */ package com.prineside.tdi2.utils.logging;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class LogLevel
/*    */ {
/*    */   public static final byte DEBUG = 0;
/*    */   public static final byte INFO = 1;
/*    */   public static final byte WARNING = 2;
/*    */   public static final byte ERROR = 3;
/*    */   
/*    */   public static String getName(byte paramByte) {
/* 18 */     switch (paramByte) { case 0:
/* 19 */         return "DEBUG";
/* 20 */       case 2: return "WARN";
/* 21 */       case 3: return "ERROR"; }
/* 22 */      return "INFO";
/*    */   }
/*    */ 
/*    */   
/*    */   public static char getShortName(byte paramByte) {
/* 27 */     switch (paramByte) { case 0:
/* 28 */         return 'D';
/* 29 */       case 2: return 'W';
/* 30 */       case 3: return 'E'; }
/* 31 */      return 'I';
/*    */   }
/*    */ 
/*    */   
/*    */   public static byte shortNameToLevel(char paramChar) {
/* 36 */     switch (paramChar) { case 'D':
/* 37 */         return 0;
/* 38 */       case 'W': return 2;
/* 39 */       case 'E': return 3; }
/* 40 */      return 1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 45 */   private static byte a = 0;
/*    */   
/*    */   public static boolean isDebug() {
/* 48 */     return (a <= 0);
/*    */   }
/*    */   
/*    */   public static void setCurrent(byte paramByte) {
/* 52 */     a = paramByte;
/*    */   }
/*    */   
/*    */   public static byte getCurrent() {
/* 56 */     return a;
/*    */   }
/*    */   
/*    */   public static boolean isInfo() {
/* 60 */     return (a <= 1);
/*    */   }
/*    */   
/*    */   public static boolean isWarning() {
/* 64 */     return (a <= 2);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\logging\LogLevel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */