/*    */ package net.bytebuddy.matcher;
/*    */ 
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
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
/*    */ @Enhance
/*    */ public class SubTypeMatcher<T extends TypeDescription>
/*    */   extends ElementMatcher.Junction.ForNonNullValues<T>
/*    */ {
/*    */   private final TypeDescription typeDescription;
/*    */   
/*    */   public SubTypeMatcher(TypeDescription paramTypeDescription) {
/* 40 */     this.typeDescription = paramTypeDescription;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean doMatch(T paramT) {
/* 47 */     return paramT.isAssignableTo(this.typeDescription);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 52 */     return "isSubTypeOf(" + this.typeDescription + ')';
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.typeDescription.equals(((SubTypeMatcher)paramObject).typeDescription)))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return super.hashCode() * 31 + this.typeDescription.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\SubTypeMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */