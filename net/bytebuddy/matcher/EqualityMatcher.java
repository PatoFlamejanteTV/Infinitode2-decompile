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
/*    */ public class EqualityMatcher<T>
/*    */   extends ElementMatcher.Junction.AbstractBase<T>
/*    */ {
/*    */   private final Object value;
/*    */   
/*    */   public EqualityMatcher(Object paramObject) {
/* 40 */     this.value = paramObject;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean matches(@MaybeNull T paramT) {
/* 47 */     return this.value.equals(paramT);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 52 */     return "is(" + this.value + ")";
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.value.equals(((EqualityMatcher)paramObject).value))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return getClass().hashCode() * 31 + this.value.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\EqualityMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */