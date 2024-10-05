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
/*    */ @Enhance
/*    */ public class NegatingMatcher<T>
/*    */   extends ElementMatcher.Junction.AbstractBase<T>
/*    */ {
/*    */   private final ElementMatcher<? super T> matcher;
/*    */   
/*    */   public NegatingMatcher(ElementMatcher<? super T> paramElementMatcher) {
/* 40 */     this.matcher = paramElementMatcher;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean matches(@MaybeNull T paramT) {
/* 47 */     return !this.matcher.matches(paramT);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 52 */     return "not(" + this.matcher + ')';
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.matcher.equals(((NegatingMatcher)paramObject).matcher))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return getClass().hashCode() * 31 + this.matcher.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\NegatingMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */