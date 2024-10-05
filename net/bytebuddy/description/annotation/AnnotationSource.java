/*    */ package net.bytebuddy.description.annotation;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
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
/*    */ public interface AnnotationSource
/*    */ {
/*    */   AnnotationList getDeclaredAnnotations();
/*    */   
/*    */   public enum Empty
/*    */     implements AnnotationSource
/*    */   {
/* 43 */     INSTANCE;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public final AnnotationList getDeclaredAnnotations() {
/* 49 */       return new AnnotationList.Empty();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Enhance
/*    */   public static class Explicit
/*    */     implements AnnotationSource
/*    */   {
/*    */     private final List<? extends AnnotationDescription> annotations;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public Explicit(AnnotationDescription... param1VarArgs) {
/* 70 */       this(Arrays.asList(param1VarArgs));
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public Explicit(List<? extends AnnotationDescription> param1List) {
/* 79 */       this.annotations = param1List;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public AnnotationList getDeclaredAnnotations() {
/* 86 */       return new AnnotationList.Explicit(this.annotations);
/*    */     }
/*    */     
/*    */     public boolean equals(@MaybeNull Object param1Object) {
/*    */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.annotations.equals(((Explicit)param1Object).annotations))));
/*    */     }
/*    */     
/*    */     public int hashCode() {
/*    */       return getClass().hashCode() * 31 + this.annotations.hashCode();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\annotation\AnnotationSource.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */