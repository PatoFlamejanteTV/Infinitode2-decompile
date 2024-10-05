/*    */ package com.google.common.base;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
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
/*    */ @ElementTypesAreNonnullByDefault
/*    */ final class JdkPattern
/*    */   extends CommonPattern
/*    */   implements Serializable
/*    */ {
/*    */   private final Pattern pattern;
/*    */   private static final long serialVersionUID = 0L;
/*    */   
/*    */   JdkPattern(Pattern paramPattern) {
/* 29 */     this.pattern = Preconditions.<Pattern>checkNotNull(paramPattern);
/*    */   }
/*    */ 
/*    */   
/*    */   public final CommonMatcher matcher(CharSequence paramCharSequence) {
/* 34 */     return new JdkMatcher(this.pattern.matcher(paramCharSequence));
/*    */   }
/*    */ 
/*    */   
/*    */   public final String pattern() {
/* 39 */     return this.pattern.pattern();
/*    */   }
/*    */ 
/*    */   
/*    */   public final int flags() {
/* 44 */     return this.pattern.flags();
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 49 */     return this.pattern.toString();
/*    */   }
/*    */   
/*    */   private static final class JdkMatcher extends CommonMatcher {
/*    */     final Matcher matcher;
/*    */     
/*    */     JdkMatcher(Matcher param1Matcher) {
/* 56 */       this.matcher = Preconditions.<Matcher>checkNotNull(param1Matcher);
/*    */     }
/*    */ 
/*    */     
/*    */     public final boolean matches() {
/* 61 */       return this.matcher.matches();
/*    */     }
/*    */ 
/*    */     
/*    */     public final boolean find() {
/* 66 */       return this.matcher.find();
/*    */     }
/*    */ 
/*    */     
/*    */     public final boolean find(int param1Int) {
/* 71 */       return this.matcher.find(param1Int);
/*    */     }
/*    */ 
/*    */     
/*    */     public final String replaceAll(String param1String) {
/* 76 */       return this.matcher.replaceAll(param1String);
/*    */     }
/*    */ 
/*    */     
/*    */     public final int end() {
/* 81 */       return this.matcher.end();
/*    */     }
/*    */ 
/*    */     
/*    */     public final int start() {
/* 86 */       return this.matcher.start();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\JdkPattern.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */