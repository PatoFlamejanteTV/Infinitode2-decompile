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
/*    */ @Enhance
/*    */ public class BooleanMatcher<T>
/*    */   extends ElementMatcher.Junction.AbstractBase<T>
/*    */ {
/* 32 */   private static final BooleanMatcher<?> TRUE = new BooleanMatcher(true);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 37 */   private static final BooleanMatcher<?> FALSE = new BooleanMatcher(false);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final boolean matches;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> ElementMatcher.Junction<T> of(boolean paramBoolean) {
/* 48 */     return (ElementMatcher.Junction)(paramBoolean ? TRUE : FALSE);
/*    */   }
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
/*    */   public BooleanMatcher(boolean paramBoolean) {
/* 62 */     this.matches = paramBoolean;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean matches(@MaybeNull T paramT) {
/* 69 */     return this.matches;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 74 */     return Boolean.toString(this.matches);
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!(this.matches != ((BooleanMatcher)paramObject).matches))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return getClass().hashCode() * 31 + this.matches;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\BooleanMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */