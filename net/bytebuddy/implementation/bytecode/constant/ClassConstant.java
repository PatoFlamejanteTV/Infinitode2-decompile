/*     */ package net.bytebuddy.implementation.bytecode.constant;
/*     */ 
/*     */ import net.bytebuddy.ClassFileVersion;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.StackSize;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.jar.asm.Type;
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
/*     */ public enum ClassConstant
/*     */   implements StackManipulation
/*     */ {
/*  36 */   VOID(Void.class),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   BOOLEAN(Boolean.class),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   BYTE(Byte.class),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   SHORT(Short.class),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  56 */   CHARACTER(Character.class),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   INTEGER(Integer.class),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   LONG(Long.class),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   FLOAT(Float.class),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  76 */   DOUBLE(Double.class);
/*     */   private static final StackManipulation.Size SIZE;
/*     */   private static final String PRIMITIVE_TYPE_FIELD = "TYPE";
/*     */   
/*     */   static {
/*  81 */     SIZE = StackSize.SINGLE.toIncreasingSize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String CLASS_TYPE_INTERNAL_NAME = "Ljava/lang/Class;";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String fieldOwnerInternalName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ClassConstant(Class<?> paramClass) {
/* 104 */     this.fieldOwnerInternalName = Type.getInternalName(paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StackManipulation of(TypeDescription paramTypeDescription) {
/* 115 */     if (!paramTypeDescription.isPrimitive())
/* 116 */       return new ForReferenceType(paramTypeDescription); 
/* 117 */     if (paramTypeDescription.represents(boolean.class))
/* 118 */       return BOOLEAN; 
/* 119 */     if (paramTypeDescription.represents(byte.class))
/* 120 */       return BYTE; 
/* 121 */     if (paramTypeDescription.represents(short.class))
/* 122 */       return SHORT; 
/* 123 */     if (paramTypeDescription.represents(char.class))
/* 124 */       return CHARACTER; 
/* 125 */     if (paramTypeDescription.represents(int.class))
/* 126 */       return INTEGER; 
/* 127 */     if (paramTypeDescription.represents(long.class))
/* 128 */       return LONG; 
/* 129 */     if (paramTypeDescription.represents(float.class))
/* 130 */       return FLOAT; 
/* 131 */     if (paramTypeDescription.represents(double.class)) {
/* 132 */       return DOUBLE;
/*     */     }
/* 134 */     return VOID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isValid() {
/* 142 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/* 149 */     paramMethodVisitor.visitFieldInsn(178, this.fieldOwnerInternalName, "TYPE", "Ljava/lang/Class;");
/* 150 */     return SIZE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class ForReferenceType
/*     */     implements StackManipulation
/*     */   {
/*     */     private final TypeDescription typeDescription;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ForReferenceType(TypeDescription param1TypeDescription) {
/* 170 */       this.typeDescription = param1TypeDescription;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isValid() {
/* 177 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 184 */       if (param1Context.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V5) && this.typeDescription.isVisibleTo(param1Context.getInstrumentedType())) {
/* 185 */         param1MethodVisitor.visitLdcInsn(Type.getType(this.typeDescription.getDescriptor()));
/*     */       } else {
/* 187 */         param1MethodVisitor.visitLdcInsn(this.typeDescription.getName());
/* 188 */         param1MethodVisitor.visitMethodInsn(184, "java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false);
/*     */       } 
/* 190 */       return ClassConstant.a();
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.typeDescription.equals(((ForReferenceType)param1Object).typeDescription))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\constant\ClassConstant.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */