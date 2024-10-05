/*     */ package net.bytebuddy.implementation;
/*     */ 
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.modifier.Visibility;
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
/*     */ public interface MethodAccessorFactory
/*     */ {
/*     */   MethodDescription.InDefinedShape registerAccessorFor(Implementation.SpecialMethodInvocation paramSpecialMethodInvocation, AccessType paramAccessType);
/*     */   
/*     */   MethodDescription.InDefinedShape registerGetterFor(FieldDescription paramFieldDescription, AccessType paramAccessType);
/*     */   
/*     */   MethodDescription.InDefinedShape registerSetterFor(FieldDescription paramFieldDescription, AccessType paramAccessType);
/*     */   
/*     */   public enum AccessType
/*     */   {
/*  73 */     PUBLIC((String)Visibility.PUBLIC),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  78 */     DEFAULT((String)Visibility.PACKAGE_PRIVATE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final Visibility visibility;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     AccessType(Visibility param1Visibility) {
/*  91 */       this.visibility = param1Visibility;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Visibility getVisibility() {
/* 100 */       return this.visibility;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Illegal
/*     */     implements MethodAccessorFactory
/*     */   {
/* 112 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final MethodDescription.InDefinedShape registerAccessorFor(Implementation.SpecialMethodInvocation param1SpecialMethodInvocation, MethodAccessorFactory.AccessType param1AccessType) {
/* 118 */       throw new IllegalStateException("It is illegal to register an accessor for this type");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final MethodDescription.InDefinedShape registerGetterFor(FieldDescription param1FieldDescription, MethodAccessorFactory.AccessType param1AccessType) {
/* 125 */       throw new IllegalStateException("It is illegal to register a field getter for this type");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final MethodDescription.InDefinedShape registerSetterFor(FieldDescription param1FieldDescription, MethodAccessorFactory.AccessType param1AccessType) {
/* 132 */       throw new IllegalStateException("It is illegal to register a field setter for this type");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\MethodAccessorFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */