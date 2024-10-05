/*    */ package com.badlogic.gdx.utils.reflect;
/*    */ 
/*    */ import java.lang.annotation.Annotation;
/*    */ 
/*    */ 
/*    */ public final class Annotation
/*    */ {
/*    */   private Annotation annotation;
/*    */   
/*    */   Annotation(Annotation paramAnnotation) {
/* 11 */     this.annotation = paramAnnotation;
/*    */   }
/*    */ 
/*    */   
/*    */   public final <T extends Annotation> T getAnnotation(Class<T> paramClass) {
/* 16 */     if (this.annotation.annotationType().equals(paramClass)) {
/* 17 */       return (T)this.annotation;
/*    */     }
/* 19 */     return null;
/*    */   }
/*    */   
/*    */   public final Class<? extends Annotation> getAnnotationType() {
/* 23 */     return this.annotation.annotationType();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\reflect\Annotation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */