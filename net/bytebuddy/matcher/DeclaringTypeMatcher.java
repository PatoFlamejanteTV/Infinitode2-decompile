/*    */ package net.bytebuddy.matcher;
/*    */ 
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.description.DeclaredByType;
/*    */ import net.bytebuddy.description.type.TypeDefinition;
/*    */ import net.bytebuddy.description.type.TypeDescription;
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
/*    */ public class DeclaringTypeMatcher<T extends DeclaredByType>
/*    */   extends ElementMatcher.Junction.ForNonNullValues<T>
/*    */ {
/*    */   private final ElementMatcher<? super TypeDescription.Generic> matcher;
/*    */   
/*    */   public DeclaringTypeMatcher(ElementMatcher<? super TypeDescription.Generic> paramElementMatcher) {
/* 43 */     this.matcher = paramElementMatcher;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean doMatch(T paramT) {
/*    */     TypeDefinition typeDefinition;
/* 51 */     if ((typeDefinition = paramT.getDeclaringType()) != null && this.matcher.matches(typeDefinition.asGenericType())) return true;  return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 56 */     return "declaredBy(" + this.matcher + ")";
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.matcher.equals(((DeclaringTypeMatcher)paramObject).matcher)))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return super.hashCode() * 31 + this.matcher.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\DeclaringTypeMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */