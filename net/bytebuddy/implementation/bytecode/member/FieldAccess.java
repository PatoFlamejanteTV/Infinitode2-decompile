/*     */ package net.bytebuddy.implementation.bytecode.member;
/*     */ 
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.enumeration.EnumerationDescription;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.field.FieldList;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.StackSize;
/*     */ import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
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
/*     */ public enum FieldAccess
/*     */ {
/*  40 */   STATIC(179, 178, StackSize.ZERO),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  45 */   INSTANCE(181, 180, StackSize.SINGLE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int putterOpcode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int getterOpcode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int targetSizeChange;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FieldAccess(int paramInt1, int paramInt2, StackSize paramStackSize) {
/*  72 */     this.putterOpcode = paramInt1;
/*  73 */     this.getterOpcode = paramInt2;
/*  74 */     this.targetSizeChange = paramStackSize.getSize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StackManipulation forEnumeration(EnumerationDescription paramEnumerationDescription) {
/*     */     FieldList fieldList;
/*  87 */     if ((fieldList = (FieldList)paramEnumerationDescription.getEnumerationType().getDeclaredFields().filter((ElementMatcher)ElementMatchers.named(paramEnumerationDescription.getValue()))).size() != 1 || !((FieldDescription.InDefinedShape)fieldList.getOnly()).isStatic() || !((FieldDescription.InDefinedShape)fieldList.getOnly()).isPublic() || !((FieldDescription.InDefinedShape)fieldList.getOnly()).isEnum()) return (StackManipulation)StackManipulation.Illegal.INSTANCE;  STATIC.getClass(); return (new AccessDispatcher(STATIC, (FieldDescription.InDefinedShape)fieldList
/*     */         
/*  89 */         .getOnly())).read();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Defined forField(FieldDescription.InDefinedShape paramInDefinedShape) {
/*  99 */     if (paramInDefinedShape.isStatic()) { STATIC.getClass(); return new AccessDispatcher(STATIC, paramInDefinedShape); }  INSTANCE.getClass(); return new AccessDispatcher(INSTANCE, paramInDefinedShape);
/*     */   }
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
/*     */   public static Defined forField(FieldDescription paramFieldDescription) {
/* 112 */     FieldDescription.InDefinedShape inDefinedShape = (FieldDescription.InDefinedShape)paramFieldDescription.asDefined();
/* 113 */     if (paramFieldDescription.getType().asErasure().equals(inDefinedShape.getType().asErasure()))
/* 114 */       return forField(inDefinedShape); 
/* 115 */     return OfGenericField.of(paramFieldDescription, forField(inDefinedShape));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Defined
/*     */   {
/*     */     StackManipulation read();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     StackManipulation write();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class OfGenericField
/*     */     implements Defined
/*     */   {
/*     */     private final TypeDefinition targetType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final FieldAccess.Defined defined;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected OfGenericField(TypeDefinition param1TypeDefinition, FieldAccess.Defined param1Defined) {
/* 161 */       this.targetType = param1TypeDefinition;
/* 162 */       this.defined = param1Defined;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected static FieldAccess.Defined of(FieldDescription param1FieldDescription, FieldAccess.Defined param1Defined) {
/* 173 */       return new OfGenericField((TypeDefinition)param1FieldDescription.getType(), param1Defined);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation read() {
/* 180 */       return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.defined.read(), TypeCasting.to(this.targetType) });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation write() {
/* 187 */       return this.defined.write();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.targetType.equals(((OfGenericField)param1Object).targetType) ? false : (!!this.defined.equals(((OfGenericField)param1Object).defined)))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.targetType.hashCode()) * 31 + this.defined.hashCode();
/*     */     }
/*     */   }
/*     */   
/*     */   @Enhance(includeSyntheticFields = true)
/*     */   protected class AccessDispatcher
/*     */     implements Defined
/*     */   {
/*     */     private final FieldDescription.InDefinedShape fieldDescription;
/*     */     
/*     */     protected AccessDispatcher(FieldAccess this$0, FieldDescription.InDefinedShape param1InDefinedShape) {
/* 208 */       this.fieldDescription = param1InDefinedShape;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation read() {
/* 215 */       return (StackManipulation)new FieldGetInstruction(this);
/*     */     }
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.a.equals(((AccessDispatcher)param1Object).a) ? false : (!!this.fieldDescription.equals(((AccessDispatcher)param1Object).fieldDescription)))));
/*     */     }
/*     */     
/*     */     public StackManipulation write() {
/* 222 */       return (StackManipulation)new FieldPutInstruction(this);
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.fieldDescription.hashCode()) * 31 + this.a.hashCode();
/*     */     }
/*     */     
/*     */     private abstract class AbstractFieldInstruction
/*     */       extends StackManipulation.AbstractBase {
/*     */       private AbstractFieldInstruction(FieldAccess.AccessDispatcher this$0) {}
/*     */       
/*     */       public StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 234 */         param2MethodVisitor.visitFieldInsn(getOpcode(), 
/* 235 */             FieldAccess.AccessDispatcher.a(this.a).getDeclaringType().getInternalName(), 
/* 236 */             FieldAccess.AccessDispatcher.a(this.a).getInternalName(), 
/* 237 */             FieldAccess.AccessDispatcher.a(this.a).getDescriptor());
/* 238 */         return resolveSize(FieldAccess.AccessDispatcher.a(this.a).getType().getStackSize());
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected abstract int getOpcode();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected abstract StackManipulation.Size resolveSize(StackSize param2StackSize);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance(includeSyntheticFields = true)
/*     */     protected class FieldGetInstruction
/*     */       extends AbstractFieldInstruction
/*     */     {
/*     */       protected FieldGetInstruction(FieldAccess.AccessDispatcher this$0) {
/* 261 */         super(this$0, (byte)0);
/*     */       } public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.a.equals(((FieldGetInstruction)param2Object).a))));
/*     */       } protected int getOpcode() {
/* 265 */         return FieldAccess.a(this.a.a);
/*     */       }
/*     */ 
/*     */       
/*     */       protected StackManipulation.Size resolveSize(StackSize param2StackSize) {
/* 270 */         int i = param2StackSize.getSize() - FieldAccess.b(this.a.a);
/* 271 */         return new StackManipulation.Size(i, i);
/*     */       }
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.a.hashCode();
/*     */       } }
/*     */     
/*     */     @Enhance(includeSyntheticFields = true)
/*     */     protected class FieldPutInstruction extends AbstractFieldInstruction { protected FieldPutInstruction(FieldAccess.AccessDispatcher this$0) {
/* 279 */         super(this$0, (byte)0);
/*     */       }
/*     */       
/*     */       protected int getOpcode() {
/* 283 */         return FieldAccess.c(this.a.a);
/*     */       }
/*     */ 
/*     */       
/*     */       protected StackManipulation.Size resolveSize(StackSize param2StackSize) {
/* 288 */         return new StackManipulation.Size(-1 * (param2StackSize.getSize() + FieldAccess.b(this.a.a)), 0);
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.a.equals(((FieldPutInstruction)param2Object).a))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.a.hashCode();
/*     */       } }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\member\FieldAccess.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */