/*   */ package com.vladsch.flexmark.util.options;
/*   */ import java.text.MessageFormat;
/*   */ 
/*   */ public interface MessageProvider {
/*   */   static {
/* 6 */     DEFAULT = ((paramString1, paramString2, paramArrayOfObject) -> (paramArrayOfObject.length > 0 && paramString2.indexOf('{') >= 0) ? MessageFormat.format(paramString2, paramArrayOfObject) : paramString2);
/*   */   }
/*   */   
/*   */   public static final MessageProvider DEFAULT;
/*   */   
/*   */   String message(String paramString1, String paramString2, Object... paramVarArgs);
/*   */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\options\MessageProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */