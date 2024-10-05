/*     */ package net.bytebuddy.implementation.bytecode.assign.primitive;
/*     */ 
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.StackSize;
/*     */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
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
/*     */ public enum PrimitiveBoxingDelegate
/*     */ {
/*  35 */   BOOLEAN(Boolean.class, StackSize.ZERO, "valueOf", "(Z)Ljava/lang/Boolean;"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   BYTE(Byte.class, StackSize.ZERO, "valueOf", "(B)Ljava/lang/Byte;"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  45 */   SHORT(Short.class, StackSize.ZERO, "valueOf", "(S)Ljava/lang/Short;"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  50 */   CHARACTER(Character.class, StackSize.ZERO, "valueOf", "(C)Ljava/lang/Character;"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   INTEGER(Integer.class, StackSize.ZERO, "valueOf", "(I)Ljava/lang/Integer;"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   LONG(Long.class, StackSize.SINGLE, "valueOf", "(J)Ljava/lang/Long;"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  65 */   FLOAT(Float.class, StackSize.ZERO, "valueOf", "(F)Ljava/lang/Float;"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  70 */   DOUBLE(Double.class, StackSize.SINGLE, "valueOf", "(D)Ljava/lang/Double;");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final TypeDescription wrapperType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final StackManipulation.Size size;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String boxingMethodName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String boxingMethodDescriptor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PrimitiveBoxingDelegate(Class<?> paramClass, StackSize paramStackSize, String paramString1, String paramString2) {
/* 104 */     this.wrapperType = TypeDescription.ForLoadedType.of(paramClass);
/* 105 */     this.size = paramStackSize.toDecreasingSize();
/* 106 */     this.boxingMethodName = paramString1;
/* 107 */     this.boxingMethodDescriptor = paramString2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PrimitiveBoxingDelegate forPrimitive(TypeDefinition paramTypeDefinition) {
/* 117 */     if (paramTypeDefinition.represents(boolean.class))
/* 118 */       return BOOLEAN; 
/* 119 */     if (paramTypeDefinition.represents(byte.class))
/* 120 */       return BYTE; 
/* 121 */     if (paramTypeDefinition.represents(short.class))
/* 122 */       return SHORT; 
/* 123 */     if (paramTypeDefinition.represents(char.class))
/* 124 */       return CHARACTER; 
/* 125 */     if (paramTypeDefinition.represents(int.class))
/* 126 */       return INTEGER; 
/* 127 */     if (paramTypeDefinition.represents(long.class))
/* 128 */       return LONG; 
/* 129 */     if (paramTypeDefinition.represents(float.class))
/* 130 */       return FLOAT; 
/* 131 */     if (paramTypeDefinition.represents(double.class)) {
/* 132 */       return DOUBLE;
/*     */     }
/* 134 */     throw new IllegalArgumentException("Not a non-void, primitive type: " + paramTypeDefinition);
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
/*     */   
/*     */   public final StackManipulation assignBoxedTo(TypeDescription.Generic paramGeneric, Assigner paramAssigner, Assigner.Typing paramTyping) {
/* 148 */     return new BoxingStackManipulation(this, paramAssigner.assign(this.wrapperType.asGenericType(), paramGeneric, paramTyping));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class BoxingStackManipulation
/*     */     implements StackManipulation
/*     */   {
/*     */     private final StackManipulation stackManipulation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public BoxingStackManipulation(PrimitiveBoxingDelegate this$0, StackManipulation param1StackManipulation) {
/* 168 */       this.stackManipulation = param1StackManipulation;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isValid() {
/* 175 */       return this.stackManipulation.isValid();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 182 */       param1MethodVisitor.visitMethodInsn(184, 
/* 183 */           PrimitiveBoxingDelegate.a(this.a).getInternalName(), 
/* 184 */           PrimitiveBoxingDelegate.b(this.a), 
/* 185 */           PrimitiveBoxingDelegate.c(this.a), false);
/*     */       
/* 187 */       return PrimitiveBoxingDelegate.d(this.a).aggregate(this.stackManipulation.apply(param1MethodVisitor, param1Context));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\assign\primitive\PrimitiveBoxingDelegate.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */