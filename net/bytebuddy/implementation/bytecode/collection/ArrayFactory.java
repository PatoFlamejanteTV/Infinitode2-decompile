/*     */ package net.bytebuddy.implementation.bytecode.collection;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.StackSize;
/*     */ import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
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
/*     */ @Enhance
/*     */ public class ArrayFactory
/*     */   implements CollectionFactory
/*     */ {
/*     */   private final TypeDescription.Generic componentType;
/*     */   private final ArrayCreator arrayCreator;
/*     */   @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
/*     */   private final StackManipulation.Size sizeDecrease;
/*     */   
/*     */   protected ArrayFactory(TypeDescription.Generic paramGeneric, ArrayCreator paramArrayCreator) {
/*  65 */     this.componentType = paramGeneric;
/*  66 */     this.arrayCreator = paramArrayCreator;
/*     */     
/*  68 */     this.sizeDecrease = StackSize.DOUBLE.toDecreasingSize().aggregate(paramGeneric.getStackSize().toDecreasingSize());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ArrayFactory forType(TypeDescription.Generic paramGeneric) {
/*  78 */     return new ArrayFactory(paramGeneric, makeArrayCreatorFor((TypeDefinition)paramGeneric));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ArrayCreator makeArrayCreatorFor(TypeDefinition paramTypeDefinition) {
/*  88 */     if (!paramTypeDefinition.isPrimitive())
/*  89 */       return new ArrayCreator.ForReferenceType(paramTypeDefinition.asErasure()); 
/*  90 */     if (paramTypeDefinition.represents(boolean.class))
/*  91 */       return ArrayCreator.ForPrimitiveType.BOOLEAN; 
/*  92 */     if (paramTypeDefinition.represents(byte.class))
/*  93 */       return ArrayCreator.ForPrimitiveType.BYTE; 
/*  94 */     if (paramTypeDefinition.represents(short.class))
/*  95 */       return ArrayCreator.ForPrimitiveType.SHORT; 
/*  96 */     if (paramTypeDefinition.represents(char.class))
/*  97 */       return ArrayCreator.ForPrimitiveType.CHARACTER; 
/*  98 */     if (paramTypeDefinition.represents(int.class))
/*  99 */       return ArrayCreator.ForPrimitiveType.INTEGER; 
/* 100 */     if (paramTypeDefinition.represents(long.class))
/* 101 */       return ArrayCreator.ForPrimitiveType.LONG; 
/* 102 */     if (paramTypeDefinition.represents(float.class))
/* 103 */       return ArrayCreator.ForPrimitiveType.FLOAT; 
/* 104 */     if (paramTypeDefinition.represents(double.class)) {
/* 105 */       return ArrayCreator.ForPrimitiveType.DOUBLE;
/*     */     }
/* 107 */     throw new IllegalArgumentException("Cannot create array of type " + paramTypeDefinition);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StackManipulation withValues(List<? extends StackManipulation> paramList) {
/* 115 */     return new ArrayStackManipulation(this, paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeDescription.Generic getComponentType() {
/* 122 */     return this.componentType;
/*     */   }
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.componentType.equals(((ArrayFactory)paramObject).componentType) ? false : (!!this.arrayCreator.equals(((ArrayFactory)paramObject).arrayCreator)))));
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*     */     return (getClass().hashCode() * 31 + this.componentType.hashCode()) * 31 + this.arrayCreator.hashCode();
/*     */   }
/*     */   
/*     */   protected static interface ArrayCreator
/*     */     extends StackManipulation {
/* 135 */     public static final StackManipulation.Size ARRAY_CREATION_SIZE_CHANGE = StackSize.ZERO.toDecreasingSize();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int getStorageOpcode();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public enum ForPrimitiveType
/*     */       implements ArrayCreator
/*     */     {
/* 152 */       BOOLEAN(4, 84),
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 157 */       BYTE(8, 84),
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 162 */       SHORT(9, 86),
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 167 */       CHARACTER(5, 85),
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 172 */       INTEGER(10, 79),
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 177 */       LONG(11, 80),
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 182 */       FLOAT(6, 81),
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 187 */       DOUBLE(7, 82);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final int creationOpcode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final int storageOpcode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ForPrimitiveType(int param2Int1, int param2Int2) {
/* 206 */         this.creationOpcode = param2Int1;
/* 207 */         this.storageOpcode = param2Int2;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final boolean isValid() {
/* 214 */         return true;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 221 */         param2MethodVisitor.visitIntInsn(188, this.creationOpcode);
/* 222 */         return ARRAY_CREATION_SIZE_CHANGE;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final int getStorageOpcode() {
/* 229 */         return this.storageOpcode;
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class ForReferenceType
/*     */       extends StackManipulation.AbstractBase
/*     */       implements ArrayCreator
/*     */     {
/*     */       private final String internalTypeName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected ForReferenceType(TypeDescription param2TypeDescription) {
/* 250 */         this.internalTypeName = param2TypeDescription.getInternalName();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 257 */         param2MethodVisitor.visitTypeInsn(189, this.internalTypeName);
/* 258 */         return ARRAY_CREATION_SIZE_CHANGE;
/*     */       }
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.internalTypeName.equals(((ForReferenceType)param2Object).internalTypeName))));
/*     */       } public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.internalTypeName.hashCode();
/*     */       }
/* 265 */       public int getStorageOpcode() { return 83; } } } public enum ForPrimitiveType implements ArrayCreator { BOOLEAN(4, 84), BYTE(8, 84), SHORT(9, 86), CHARACTER(5, 85), INTEGER(10, 79), LONG(11, 80), FLOAT(6, 81), DOUBLE(7, 82); private final int creationOpcode; private final int storageOpcode; ForPrimitiveType(int param1Int1, int param1Int2) { this.creationOpcode = param1Int1; this.storageOpcode = param1Int2; } public final boolean isValid() { return true; } public final StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) { param1MethodVisitor.visitIntInsn(188, this.creationOpcode); return ARRAY_CREATION_SIZE_CHANGE; } public final int getStorageOpcode() { return this.storageOpcode; } } @Enhance public static class ForReferenceType extends StackManipulation.AbstractBase implements ArrayCreator { private final String internalTypeName; public int getStorageOpcode() { return 83; }
/*     */     
/*     */     protected ForReferenceType(TypeDescription param1TypeDescription) {
/*     */       this.internalTypeName = param1TypeDescription.getInternalName();
/*     */     }
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/*     */       param1MethodVisitor.visitTypeInsn(189, this.internalTypeName);
/*     */       return ARRAY_CREATION_SIZE_CHANGE;
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.internalTypeName.equals(((ForReferenceType)param1Object).internalTypeName))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.internalTypeName.hashCode();
/*     */     } }
/*     */   
/*     */   @Enhance(includeSyntheticFields = true)
/*     */   protected class ArrayStackManipulation implements StackManipulation { private final List<? extends StackManipulation> stackManipulations;
/*     */     
/*     */     protected ArrayStackManipulation(ArrayFactory this$0, List<? extends StackManipulation> param1List) {
/* 287 */       this.stackManipulations = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isValid() {
/* 294 */       for (Iterator<? extends StackManipulation> iterator = this.stackManipulations.iterator(); iterator.hasNext();) {
/* 295 */         if (!(stackManipulation = iterator.next()).isValid()) {
/* 296 */           return false;
/*     */         }
/*     */       } 
/* 299 */       return ArrayFactory.a(this.a).isValid();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 308 */       StackManipulation.Size size = (size = IntegerConstant.forValue(this.stackManipulations.size()).apply(param1MethodVisitor, param1Context)).aggregate(ArrayFactory.a(this.a).apply(param1MethodVisitor, param1Context));
/* 309 */       byte b = 0;
/* 310 */       for (StackManipulation stackManipulation : this.stackManipulations) {
/* 311 */         param1MethodVisitor.visitInsn(89);
/*     */ 
/*     */         
/* 314 */         size = (size = (size = size.aggregate(StackSize.SINGLE.toIncreasingSize())).aggregate(IntegerConstant.forValue(b++).apply(param1MethodVisitor, param1Context))).aggregate(stackManipulation.apply(param1MethodVisitor, param1Context));
/* 315 */         param1MethodVisitor.visitInsn(ArrayFactory.a(this.a).getStorageOpcode());
/* 316 */         size = size.aggregate(ArrayFactory.b(this.a));
/*     */       } 
/* 318 */       return size;
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.stackManipulations.equals(((ArrayStackManipulation)param1Object).stackManipulations) ? false : (!!this.a.equals(((ArrayStackManipulation)param1Object).a)))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.stackManipulations.hashCode()) * 31 + this.a.hashCode();
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\collection\ArrayFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */