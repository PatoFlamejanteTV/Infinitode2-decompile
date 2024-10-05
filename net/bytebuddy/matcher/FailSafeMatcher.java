/*    */ package net.bytebuddy.matcher;
/*    */ 
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.utility.nullability.MaybeNull;
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
/*    */ @Enhance
/*    */ public class FailSafeMatcher<T>
/*    */   extends ElementMatcher.Junction.AbstractBase<T>
/*    */ {
/*    */   private final ElementMatcher<? super T> matcher;
/*    */   private final boolean fallback;
/*    */   
/*    */   public FailSafeMatcher(ElementMatcher<? super T> paramElementMatcher, boolean paramBoolean) {
/* 46 */     this.matcher = paramElementMatcher;
/* 47 */     this.fallback = paramBoolean;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean matches(@MaybeNull T paramT) {
/*    */     try {
/* 55 */       return this.matcher.matches(paramT);
/* 56 */     } catch (Exception exception) {
/* 57 */       return this.fallback;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 63 */     return "failSafe(try(" + this.matcher + ") or " + this.fallback + ")";
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : ((this.fallback != ((FailSafeMatcher)paramObject).fallback) ? false : (!!this.matcher.equals(((FailSafeMatcher)paramObject).matcher)))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return (getClass().hashCode() * 31 + this.matcher.hashCode()) * 31 + this.fallback;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\FailSafeMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */