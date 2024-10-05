/*     */ package net.bytebuddy.implementation.bytecode.constant;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.utility.nullability.MaybeNull;
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
/*     */ public class FieldConstant
/*     */   extends StackManipulation.AbstractBase
/*     */ {
/*     */   private final FieldDescription.InDefinedShape fieldDescription;
/*     */   
/*     */   public FieldConstant(FieldDescription.InDefinedShape paramInDefinedShape) {
/*  46 */     this.fieldDescription = paramInDefinedShape;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StackManipulation cached() {
/*  55 */     return new Cached((StackManipulation)this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/*     */     try {
/*  63 */       return (new StackManipulation.Compound(new StackManipulation[] {
/*  64 */             ClassConstant.of(this.fieldDescription.getDeclaringType()), (StackManipulation)new TextConstant(this.fieldDescription
/*  65 */               .getInternalName()), 
/*  66 */             (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(Class.class.getMethod("getDeclaredField", new Class[] { String.class })))
/*  67 */           })).apply(paramMethodVisitor, paramContext);
/*  68 */     } catch (NoSuchMethodException noSuchMethodException) {
/*  69 */       throw new IllegalStateException("Cannot locate Class::getDeclaredField", noSuchMethodException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  75 */     return this.fieldDescription.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*  80 */     if (this == paramObject)
/*  81 */       return true; 
/*  82 */     if (paramObject == null || getClass() != paramObject.getClass()) {
/*  83 */       return false;
/*     */     }
/*  85 */     paramObject = paramObject;
/*  86 */     return this.fieldDescription.equals(((FieldConstant)paramObject).fieldDescription);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class Cached
/*     */     implements StackManipulation
/*     */   {
/*     */     private final StackManipulation fieldConstant;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Cached(StackManipulation param1StackManipulation) {
/* 105 */       this.fieldConstant = param1StackManipulation;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isValid() {
/* 112 */       return this.fieldConstant.isValid();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 119 */       return FieldAccess.forField(param1Context.cache(this.fieldConstant, TypeDescription.ForLoadedType.of(Field.class)))
/* 120 */         .read()
/* 121 */         .apply(param1MethodVisitor, param1Context);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 126 */       return this.fieldConstant.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/* 131 */       if (this == param1Object)
/* 132 */         return true; 
/* 133 */       if (param1Object == null || getClass() != param1Object.getClass()) {
/* 134 */         return false;
/*     */       }
/* 136 */       param1Object = param1Object;
/* 137 */       return this.fieldConstant.equals(((Cached)param1Object).fieldConstant);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\constant\FieldConstant.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */