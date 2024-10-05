/*    */ package org.jsoup.helper;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ValidationException
/*    */   extends IllegalArgumentException
/*    */ {
/* 11 */   public static final String Validator = Validate.class.getName();
/*    */   
/*    */   public ValidationException(String paramString) {
/* 14 */     super(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public synchronized Throwable fillInStackTrace() {
/* 21 */     super.fillInStackTrace();
/*    */     
/* 23 */     StackTraceElement[] arrayOfStackTraceElement = getStackTrace();
/* 24 */     ArrayList<StackTraceElement> arrayList = new ArrayList(); int i; byte b;
/* 25 */     for (i = (arrayOfStackTraceElement = arrayOfStackTraceElement).length, b = 0; b < i; b++) {
/* 26 */       StackTraceElement stackTraceElement; if (!(stackTraceElement = arrayOfStackTraceElement[b]).getClassName().equals(Validator)) {
/* 27 */         arrayList.add(stackTraceElement);
/*    */       }
/*    */     } 
/* 30 */     setStackTrace(arrayList.<StackTraceElement>toArray(new StackTraceElement[0]));
/*    */     
/* 32 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\helper\ValidationException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */