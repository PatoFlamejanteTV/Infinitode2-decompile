/*    */ package com.prineside.luaj.lib.jse;
/*    */ 
/*    */ import com.prineside.luaj.lib.StringLib;
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
/*    */ public final class JseStringLib
/*    */   extends StringLib
/*    */ {
/*    */   protected final String a(String paramString, double paramDouble) {
/*    */     String str;
/*    */     try {
/* 33 */       str = String.format(paramString, new Object[] { Double.valueOf(paramDouble) });
/* 34 */     } catch (Throwable throwable) {
/* 35 */       str = super.a(paramString, paramDouble);
/*    */     } 
/* 37 */     return str;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\jse\JseStringLib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */