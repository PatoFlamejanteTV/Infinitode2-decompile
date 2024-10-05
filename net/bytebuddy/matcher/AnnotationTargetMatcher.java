/*    */ package net.bytebuddy.matcher;
/*    */ 
/*    */ import java.lang.annotation.ElementType;
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.description.annotation.AnnotationDescription;
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
/*    */ public class AnnotationTargetMatcher<T extends AnnotationDescription>
/*    */   extends ElementMatcher.Junction.ForNonNullValues<T>
/*    */ {
/*    */   private final ElementType elementType;
/*    */   
/*    */   public AnnotationTargetMatcher(ElementType paramElementType) {
/* 42 */     this.elementType = paramElementType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean doMatch(T paramT) {
/* 49 */     return paramT.isSupportedOn(this.elementType);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 54 */     return "targetsElement(" + this.elementType + ")";
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.elementType.equals(((AnnotationTargetMatcher)paramObject).elementType)))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return super.hashCode() * 31 + this.elementType.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\AnnotationTargetMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */