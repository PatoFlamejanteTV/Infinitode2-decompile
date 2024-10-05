/*     */ package com.google.common.base;
/*     */ 
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.Locale;
/*     */ import java.util.ServiceConfigurationError;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import java.util.regex.Pattern;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ElementTypesAreNonnullByDefault
/*     */ final class Platform
/*     */ {
/*  34 */   private static final Logger logger = Logger.getLogger(Platform.class.getName());
/*  35 */   private static final PatternCompiler patternCompiler = loadPatternCompiler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static long systemNanoTime() {
/*  42 */     return System.nanoTime();
/*     */   }
/*     */   
/*     */   static CharMatcher precomputeCharMatcher(CharMatcher paramCharMatcher) {
/*  46 */     return paramCharMatcher.precomputedInternal();
/*     */   }
/*     */   
/*     */   static <T extends Enum<T>> Optional<T> getEnumIfPresent(Class<T> paramClass, String paramString) {
/*     */     WeakReference weakReference;
/*  51 */     return ((weakReference = Enums.<T>getEnumConstants(paramClass).get(paramString)) == null) ? Optional.absent() : Optional.of(paramClass.cast(weakReference.get()));
/*     */   }
/*     */   
/*     */   static String formatCompact4Digits(double paramDouble) {
/*  55 */     return String.format(Locale.ROOT, "%.4g", new Object[] { Double.valueOf(paramDouble) });
/*     */   }
/*     */   
/*     */   static boolean stringIsNullOrEmpty(String paramString) {
/*  59 */     return (paramString == null || paramString.isEmpty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String nullToEmpty(String paramString) {
/*  69 */     return (paramString == null) ? "" : paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String emptyToNull(String paramString) {
/*  80 */     return stringIsNullOrEmpty(paramString) ? null : paramString;
/*     */   }
/*     */   
/*     */   static CommonPattern compilePattern(String paramString) {
/*  84 */     Preconditions.checkNotNull(paramString);
/*  85 */     return patternCompiler.compile(paramString);
/*     */   }
/*     */   
/*     */   static boolean patternCompilerIsPcreLike() {
/*  89 */     return patternCompiler.isPcreLike();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static PatternCompiler loadPatternCompiler() {
/*  98 */     return new JdkPatternCompiler();
/*     */   }
/*     */   
/*     */   private static void logPatternCompilerError(ServiceConfigurationError paramServiceConfigurationError) {
/* 102 */     logger.log(Level.WARNING, "Error loading regex compiler, falling back to next option", paramServiceConfigurationError);
/*     */   }
/*     */   
/*     */   private static final class JdkPatternCompiler
/*     */     implements PatternCompiler {
/*     */     public final CommonPattern compile(String param1String) {
/* 108 */       return new JdkPattern(Pattern.compile(param1String));
/*     */     }
/*     */     private JdkPatternCompiler() {}
/*     */     
/*     */     public final boolean isPcreLike() {
/* 113 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   static void checkGwtRpcEnabled() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Platform.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */