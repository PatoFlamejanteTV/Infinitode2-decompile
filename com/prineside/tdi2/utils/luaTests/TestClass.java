/*     */ package com.prineside.tdi2.utils.luaTests;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ 
/*     */ @TestAnnotationRuntimeRetention
/*     */ @TestAnnotationClassRetention
/*     */ public class TestClass implements TestInterfaceWithBlacklistedMethod {
/*     */   @TestAnnotationClassRetention
/*   9 */   public static int SOME_STATIC_VAR = 1337;
/*     */   
/*     */   @TestAnnotationRuntimeRetention
/*     */   public static final int SOME_STATIC_FINAL_VAR = 42;
/*     */   
/*  14 */   public static TestClass SINGLETON = new TestClass(9001);
/*     */   
/*  16 */   public static float SOME_BLACKLISTED_STATIC_FIELD = 17.4F;
/*     */   
/*     */   @TestAnnotationClassRetention
/*     */   public int someField;
/*     */   
/*  21 */   public String someBlacklistedField = "Secret";
/*     */   
/*     */   @TestAnnotationRuntimeRetention
/*     */   public int someOtherField;
/*     */   
/*     */   public TestClass(@TestAnnotationClassRetention int paramInt) {
/*  27 */     this.someField = paramInt;
/*     */   }
/*     */   
/*     */   public TestClass(int... paramVarArgs) {
/*  31 */     if (paramVarArgs.length > 0) {
/*  32 */       this.someField = paramVarArgs[0];
/*     */     }
/*  34 */     if (paramVarArgs.length > 1) {
/*  35 */       this.someOtherField = paramVarArgs[1];
/*     */     }
/*     */   }
/*     */   
/*     */   public TestClass(int paramInt, Object... paramVarArgs) {
/*  40 */     this.someField = paramInt;
/*  41 */     this.someBlacklistedField = Arrays.toString(paramVarArgs);
/*     */   }
/*     */   
/*     */   public TestClass(String paramString) {
/*  45 */     throw new IllegalStateException("Test failed - blacklisted constructor called");
/*     */   }
/*     */   
/*     */   @TestAnnotationClassRetention
/*     */   public int getSomeField() {
/*  50 */     return this.someField;
/*     */   }
/*     */   
/*     */   @TestAnnotationRuntimeRetention
/*     */   public void setSomeField(@TestAnnotationRuntimeRetention int paramInt) {
/*  55 */     this.someField = paramInt;
/*     */   }
/*     */   
/*     */   public void someBlacklistedField() {
/*  59 */     throw new IllegalStateException("Test failed - blacklisted method called");
/*     */   }
/*     */ 
/*     */   
/*     */   public int thisMethodIsWhitelisted() {
/*  64 */     return 777;
/*     */   }
/*     */ 
/*     */   
/*     */   public int thisMethodIsBlacklisted() {
/*  69 */     throw new IllegalStateException("Test failed - blacklisted interface method called");
/*     */   }
/*     */   
/*     */   public String sameNameMethod(int paramInt) {
/*  73 */     return "int|" + paramInt;
/*     */   }
/*     */   
/*     */   public String sameNameMethod(float paramFloat) {
/*  77 */     return "float|" + paramFloat;
/*     */   }
/*     */   
/*     */   public String sameNameMethod(String paramString) {
/*  81 */     return "string|" + paramString;
/*     */   }
/*     */   
/*     */   public String sameNameMethod(int paramInt1, int paramInt2) {
/*  85 */     return "ints|" + paramInt1 + "|" + paramInt2;
/*     */   }
/*     */   
/*     */   public String varArgMethodA(Object... paramVarArgs) {
/*  89 */     return Arrays.toString(paramVarArgs);
/*     */   }
/*     */   
/*     */   public String varArgMethodB(String paramString, Object... paramVarArgs) {
/*  93 */     return paramString + Arrays.toString(paramVarArgs);
/*     */   }
/*     */   
/*     */   public String varArgMethodC(String paramString, String... paramVarArgs) {
/*  97 */     return paramString + Arrays.toString((Object[])paramVarArgs);
/*     */   }
/*     */   
/*     */   public String varArgMethodD(String paramString, TestClass... paramVarArgs) {
/* 101 */     return paramString + Arrays.toString((Object[])paramVarArgs);
/*     */   }
/*     */   
/*     */   public static String staticVarArgMethodA(Object... paramVarArgs) {
/* 105 */     return Arrays.toString(paramVarArgs);
/*     */   }
/*     */   
/*     */   public static String staticVarArgMethodB(String paramString, Object... paramVarArgs) {
/* 109 */     return paramString + Arrays.toString(paramVarArgs);
/*     */   }
/*     */   
/*     */   public static String staticVarArgMethodC(String paramString, String... paramVarArgs) {
/* 113 */     return paramString + Arrays.toString((Object[])paramVarArgs);
/*     */   }
/*     */   
/*     */   public static String staticVarArgMethodD(String paramString, TestClass... paramVarArgs) {
/* 117 */     return paramString + Arrays.toString((Object[])paramVarArgs);
/*     */   }
/*     */   
/*     */   public static String staticVarArgMethodE(String paramString, int[]... paramVarArgs) {
/* 121 */     return paramString + Arrays.toString((Object[])paramVarArgs);
/*     */   }
/*     */   
/*     */   public static String staticVarArgMethodF(String paramString, TestClass[]... paramVarArgs) {
/* 125 */     return paramString + paramVarArgs.length + ((paramVarArgs.length == 0) ? "none" : Arrays.toString((Object[])paramVarArgs[0]));
/*     */   }
/*     */   
/*     */   public String toString() {
/* 129 */     return this.someBlacklistedField + this.someField;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\luaTests\TestClass.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */