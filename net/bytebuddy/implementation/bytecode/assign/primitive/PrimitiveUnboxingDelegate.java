/*     */ package net.bytebuddy.implementation.bytecode.assign.primitive;
/*     */ 
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.StackSize;
/*     */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
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
/*     */ public enum PrimitiveUnboxingDelegate
/*     */   implements StackManipulation
/*     */ {
/*  36 */   BOOLEAN(Boolean.class, boolean.class, StackSize.ZERO, "booleanValue", "()Z"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   BYTE(Byte.class, byte.class, StackSize.ZERO, "byteValue", "()B"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   SHORT(Short.class, short.class, StackSize.ZERO, "shortValue", "()S"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   CHARACTER(Character.class, char.class, StackSize.ZERO, "charValue", "()C"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  56 */   INTEGER(Integer.class, int.class, StackSize.ZERO, "intValue", "()I"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   LONG(Long.class, long.class, StackSize.SINGLE, "longValue", "()J"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   FLOAT(Float.class, float.class, StackSize.ZERO, "floatValue", "()F"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   DOUBLE(Double.class, double.class, StackSize.SINGLE, "doubleValue", "()D");
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
/*     */   private final TypeDescription primitiveType;
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
/*     */   private final String unboxingMethodName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String unboxingMethodDescriptor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PrimitiveUnboxingDelegate(Class<?> paramClass1, Class<?> paramClass2, StackSize paramStackSize, String paramString1, String paramString2) {
/* 112 */     this.size = paramStackSize.toIncreasingSize();
/* 113 */     this.wrapperType = TypeDescription.ForLoadedType.of(paramClass1);
/* 114 */     this.primitiveType = TypeDescription.ForLoadedType.of(paramClass2);
/* 115 */     this.unboxingMethodName = paramString1;
/* 116 */     this.unboxingMethodDescriptor = paramString2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PrimitiveUnboxingDelegate forPrimitive(TypeDefinition paramTypeDefinition) {
/* 126 */     if (paramTypeDefinition.represents(boolean.class))
/* 127 */       return BOOLEAN; 
/* 128 */     if (paramTypeDefinition.represents(byte.class))
/* 129 */       return BYTE; 
/* 130 */     if (paramTypeDefinition.represents(short.class))
/* 131 */       return SHORT; 
/* 132 */     if (paramTypeDefinition.represents(char.class))
/* 133 */       return CHARACTER; 
/* 134 */     if (paramTypeDefinition.represents(int.class))
/* 135 */       return INTEGER; 
/* 136 */     if (paramTypeDefinition.represents(long.class))
/* 137 */       return LONG; 
/* 138 */     if (paramTypeDefinition.represents(float.class))
/* 139 */       return FLOAT; 
/* 140 */     if (paramTypeDefinition.represents(double.class)) {
/* 141 */       return DOUBLE;
/*     */     }
/* 143 */     throw new IllegalArgumentException("Expected non-void primitive type instead of " + paramTypeDefinition);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static UnboxingResponsible forReferenceType(TypeDefinition paramTypeDefinition) {
/* 162 */     if (paramTypeDefinition.isPrimitive())
/* 163 */       throw new IllegalArgumentException("Expected reference type instead of " + paramTypeDefinition); 
/* 164 */     if (paramTypeDefinition.represents(Boolean.class))
/* 165 */       return ExplicitlyTypedUnboxingResponsible.BOOLEAN; 
/* 166 */     if (paramTypeDefinition.represents(Byte.class))
/* 167 */       return ExplicitlyTypedUnboxingResponsible.BYTE; 
/* 168 */     if (paramTypeDefinition.represents(Short.class))
/* 169 */       return ExplicitlyTypedUnboxingResponsible.SHORT; 
/* 170 */     if (paramTypeDefinition.represents(Character.class))
/* 171 */       return ExplicitlyTypedUnboxingResponsible.CHARACTER; 
/* 172 */     if (paramTypeDefinition.represents(Integer.class))
/* 173 */       return ExplicitlyTypedUnboxingResponsible.INTEGER; 
/* 174 */     if (paramTypeDefinition.represents(Long.class))
/* 175 */       return ExplicitlyTypedUnboxingResponsible.LONG; 
/* 176 */     if (paramTypeDefinition.represents(Float.class))
/* 177 */       return ExplicitlyTypedUnboxingResponsible.FLOAT; 
/* 178 */     if (paramTypeDefinition.represents(Double.class)) {
/* 179 */       return ExplicitlyTypedUnboxingResponsible.DOUBLE;
/*     */     }
/* 181 */     return new ImplicitlyTypedUnboxingResponsible(paramTypeDefinition.asGenericType());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final TypeDescription.Generic getWrapperType() {
/* 191 */     return this.wrapperType.asGenericType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isValid() {
/* 198 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/* 205 */     paramMethodVisitor.visitMethodInsn(182, this.wrapperType
/* 206 */         .asErasure().getInternalName(), this.unboxingMethodName, this.unboxingMethodDescriptor, false);
/*     */ 
/*     */ 
/*     */     
/* 210 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected enum ExplicitlyTypedUnboxingResponsible
/*     */     implements UnboxingResponsible
/*     */   {
/* 221 */     BOOLEAN((String)PrimitiveUnboxingDelegate.BOOLEAN),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 226 */     BYTE((String)PrimitiveUnboxingDelegate.BYTE),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 231 */     SHORT((String)PrimitiveUnboxingDelegate.SHORT),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 236 */     CHARACTER((String)PrimitiveUnboxingDelegate.CHARACTER),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 241 */     INTEGER((String)PrimitiveUnboxingDelegate.INTEGER),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 246 */     LONG((String)PrimitiveUnboxingDelegate.LONG),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 251 */     FLOAT((String)PrimitiveUnboxingDelegate.FLOAT),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 256 */     DOUBLE((String)PrimitiveUnboxingDelegate.DOUBLE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final PrimitiveUnboxingDelegate primitiveUnboxingDelegate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ExplicitlyTypedUnboxingResponsible(PrimitiveUnboxingDelegate param1PrimitiveUnboxingDelegate) {
/* 269 */       this.primitiveUnboxingDelegate = param1PrimitiveUnboxingDelegate;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final StackManipulation assignUnboxedTo(TypeDescription.Generic param1Generic, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 276 */       return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.primitiveUnboxingDelegate, 
/*     */             
/* 278 */             PrimitiveWideningDelegate.forPrimitive((TypeDefinition)PrimitiveUnboxingDelegate.a(this.primitiveUnboxingDelegate)).widenTo((TypeDefinition)param1Generic) });
/*     */     }
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
/*     */   public static interface UnboxingResponsible
/*     */   {
/*     */     StackManipulation assignUnboxedTo(TypeDescription.Generic param1Generic, Assigner param1Assigner, Assigner.Typing param1Typing);
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
/*     */   @Enhance
/*     */   protected static class ImplicitlyTypedUnboxingResponsible
/*     */     implements UnboxingResponsible
/*     */   {
/*     */     private final TypeDescription.Generic originalType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ImplicitlyTypedUnboxingResponsible(TypeDescription.Generic param1Generic) {
/* 319 */       this.originalType = param1Generic;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation assignUnboxedTo(TypeDescription.Generic param1Generic, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 326 */       PrimitiveUnboxingDelegate primitiveUnboxingDelegate = PrimitiveUnboxingDelegate.forPrimitive((TypeDefinition)param1Generic);
/* 327 */       return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { param1Assigner
/* 328 */             .assign(this.originalType, primitiveUnboxingDelegate.getWrapperType(), param1Typing), primitiveUnboxingDelegate });
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.originalType.equals(((ImplicitlyTypedUnboxingResponsible)param1Object).originalType))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.originalType.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\assign\primitive\PrimitiveUnboxingDelegate.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */