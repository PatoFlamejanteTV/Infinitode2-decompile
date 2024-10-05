/*     */ package net.bytebuddy.implementation.attribute;
/*     */ 
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.annotation.AnnotationValue;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.type.RecordComponentDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface AnnotationValueFilter
/*     */ {
/*     */   boolean isRelevant(AnnotationDescription paramAnnotationDescription, MethodDescription.InDefinedShape paramInDefinedShape);
/*     */   
/*     */   public enum Default
/*     */     implements AnnotationValueFilter, Factory
/*     */   {
/*  85 */     SKIP_DEFAULTS
/*     */     {
/*     */       public final boolean isRelevant(AnnotationDescription param2AnnotationDescription, MethodDescription.InDefinedShape param2InDefinedShape) {
/*     */         AnnotationValue annotationValue;
/*  89 */         if ((annotationValue = param2InDefinedShape.getDefaultValue()) == null || !annotationValue.equals(param2AnnotationDescription.getValue(param2InDefinedShape))) return true;  return false;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     APPEND_DEFAULTS
/*     */     {
/*     */       public final boolean isRelevant(AnnotationDescription param2AnnotationDescription, MethodDescription.InDefinedShape param2InDefinedShape) {
/*  99 */         return true;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationValueFilter on(TypeDescription param1TypeDescription) {
/* 107 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationValueFilter on(FieldDescription param1FieldDescription) {
/* 114 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationValueFilter on(MethodDescription param1MethodDescription) {
/* 121 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationValueFilter on(RecordComponentDescription param1RecordComponentDescription) {
/* 128 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface Factory {
/*     */     AnnotationValueFilter on(TypeDescription param1TypeDescription);
/*     */     
/*     */     AnnotationValueFilter on(FieldDescription param1FieldDescription);
/*     */     
/*     */     AnnotationValueFilter on(MethodDescription param1MethodDescription);
/*     */     
/*     */     AnnotationValueFilter on(RecordComponentDescription param1RecordComponentDescription);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\attribute\AnnotationValueFilter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */