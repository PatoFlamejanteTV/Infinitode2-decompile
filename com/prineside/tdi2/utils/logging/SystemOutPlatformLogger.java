/*    */ package com.prineside.tdi2.utils.logging;
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
/*    */ public final class SystemOutPlatformLogger
/*    */   implements PlatformLogger
/*    */ {
/*    */   private final boolean a;
/*    */   private final boolean b;
/*    */   
/*    */   public SystemOutPlatformLogger(boolean paramBoolean1, boolean paramBoolean2) {
/* 19 */     this.a = paramBoolean1;
/* 20 */     this.b = paramBoolean2;
/*    */   }
/*    */   
/*    */   private StringBuilder a(byte paramByte, String paramString1, String paramString2, String paramString3) {
/* 24 */     StringBuilder stringBuilder = new StringBuilder();
/* 25 */     if (this.a)
/* 26 */       switch (paramByte) { case 0:
/* 27 */           stringBuilder.append("\033[37m"); break;
/* 28 */         case 2: stringBuilder.append("\033[33m"); break;
/* 29 */         case 3: stringBuilder.append("\033[31m");
/*    */           break; }
/*    */        
/* 32 */     stringBuilder.append("[").append(paramString1).append("]");
/* 33 */     if (this.b && (
/* 34 */       paramByte == 2 || paramByte == 1)) {
/* 35 */       stringBuilder.append(' ');
/*    */     }
/*    */     
/* 38 */     stringBuilder.append("[").append(paramString2).append("]");
/* 39 */     if (this.b) {
/* 40 */       for (int i = paramString2.length(); i < 20; i++) {
/* 41 */         stringBuilder.append(' ');
/*    */       }
/*    */     }
/* 44 */     stringBuilder.append(' ').append(paramString3);
/* 45 */     if (this.a) {
/* 46 */       stringBuilder.append("\033[0m");
/*    */     }
/* 48 */     return stringBuilder;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void debug(String paramString1, String paramString2) {
/* 53 */     System.out.println(a((byte)0, "debug", paramString1, paramString2));
/*    */   }
/*    */ 
/*    */   
/*    */   public final void info(String paramString1, String paramString2) {
/* 58 */     System.out.println(a((byte)1, "info", paramString1, paramString2));
/*    */   }
/*    */ 
/*    */   
/*    */   public final void warn(String paramString1, String paramString2) {
/* 63 */     System.out.println(a((byte)2, "warn", paramString1, paramString2));
/*    */   }
/*    */ 
/*    */   
/*    */   public final void error(String paramString1, String paramString2) {
/* 68 */     System.out.println(a((byte)3, "error", paramString1, paramString2));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\logging\SystemOutPlatformLogger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */