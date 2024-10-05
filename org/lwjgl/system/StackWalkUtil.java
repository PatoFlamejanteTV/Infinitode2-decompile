/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class StackWalkUtil
/*     */ {
/*     */   static StackTraceElement[] stackWalkArray(Object[] paramArrayOfObject) {
/*  21 */     return (StackTraceElement[])paramArrayOfObject;
/*     */   }
/*     */   
/*     */   static Object stackWalkGetMethod(Class<?> paramClass) {
/*  25 */     StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
/*     */     
/*  27 */     for (byte b = 3; b < arrayOfStackTraceElement.length; b++) {
/*  28 */       if (!arrayOfStackTraceElement[b].getClassName().startsWith(paramClass.getName())) {
/*  29 */         return arrayOfStackTraceElement[b];
/*     */       }
/*     */     } 
/*     */     
/*  33 */     throw new IllegalStateException();
/*     */   }
/*     */   
/*     */   private static boolean isSameMethod(StackTraceElement paramStackTraceElement1, StackTraceElement paramStackTraceElement2) {
/*  37 */     return isSameMethod(paramStackTraceElement1, paramStackTraceElement2, paramStackTraceElement2.getMethodName());
/*     */   }
/*     */   
/*     */   private static boolean isSameMethod(StackTraceElement paramStackTraceElement1, StackTraceElement paramStackTraceElement2, String paramString) {
/*  41 */     if (paramStackTraceElement1.getMethodName().equals(paramString) && paramStackTraceElement1
/*  42 */       .getClassName().equals(paramStackTraceElement2.getClassName()) && 
/*  43 */       Objects.equals(paramStackTraceElement1.getFileName(), paramStackTraceElement2.getFileName())) return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   private static boolean isAutoCloseable(StackTraceElement paramStackTraceElement1, StackTraceElement paramStackTraceElement2) {
/*  48 */     if (isSameMethod(paramStackTraceElement1, paramStackTraceElement2, "$closeResource")) {
/*  49 */       return true;
/*     */     }
/*     */ 
/*     */     
/*  53 */     if ("closeFinally".equals(paramStackTraceElement1.getMethodName()) && "AutoCloseable.kt".equals(paramStackTraceElement1.getFileName())) {
/*  54 */       return true;
/*     */     }
/*     */     
/*  57 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   static Object stackWalkCheckPop(Class<?> paramClass, Object paramObject) {
/*  62 */     StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
/*     */     
/*  64 */     for (byte b = 3; b < arrayOfStackTraceElement.length; b++) {
/*     */       StackTraceElement stackTraceElement;
/*  66 */       if (!(stackTraceElement = arrayOfStackTraceElement[b]).getClassName().startsWith(paramClass.getName())) {
/*     */ 
/*     */ 
/*     */         
/*  70 */         StackTraceElement stackTraceElement1 = (StackTraceElement)paramObject;
/*  71 */         if (isSameMethod(stackTraceElement, stackTraceElement1)) {
/*  72 */           return null;
/*     */         }
/*     */         
/*  75 */         if (isAutoCloseable(stackTraceElement, stackTraceElement1) && b + 1 < arrayOfStackTraceElement.length) {
/*     */ 
/*     */ 
/*     */           
/*  79 */           stackTraceElement = arrayOfStackTraceElement[b + 1];
/*  80 */           if (isSameMethod(stackTraceElement1, arrayOfStackTraceElement[b + 1])) {
/*  81 */             return null;
/*     */           }
/*     */         } 
/*     */         
/*  85 */         return stackTraceElement;
/*     */       } 
/*     */     } 
/*  88 */     throw new IllegalStateException();
/*     */   }
/*     */   
/*     */   static Object[] stackWalkGetTrace() {
/*  92 */     StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
/*     */     
/*  94 */     byte b = 3;
/*  95 */     for (; b < arrayOfStackTraceElement.length && 
/*  96 */       arrayOfStackTraceElement[b].getClassName().startsWith("org.lwjgl.system.Memory"); b++);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 101 */     return Arrays.copyOfRange((Object[])arrayOfStackTraceElement, b, arrayOfStackTraceElement.length);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\StackWalkUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */