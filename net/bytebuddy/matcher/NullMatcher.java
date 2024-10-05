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
/*    */ public class NullMatcher<T>
/*    */   extends ElementMatcher.Junction.AbstractBase<T>
/*    */ {
/* 32 */   private static final NullMatcher<?> INSTANCE = new NullMatcher();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> ElementMatcher.Junction<T> make() {
/* 42 */     return (ElementMatcher.Junction)INSTANCE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean matches(@MaybeNull T paramT) {
/* 49 */     return (paramT == null);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 54 */     return "isNull()";
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : (!(getClass() != paramObject.getClass())));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return getClass().hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\NullMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */