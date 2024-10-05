/*     */ package net.bytebuddy.implementation.bytecode.constant;
/*     */ 
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
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
/*     */ public enum DefaultValue
/*     */   implements StackManipulation
/*     */ {
/*  32 */   INTEGER(IntegerConstant.ZERO),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  37 */   LONG(LongConstant.ZERO),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  42 */   FLOAT(FloatConstant.ZERO),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   DOUBLE(DoubleConstant.ZERO),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  52 */   VOID((StackManipulation)StackManipulation.Trivial.INSTANCE),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   REFERENCE(NullConstant.INSTANCE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final StackManipulation stackManipulation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   DefaultValue(StackManipulation paramStackManipulation) {
/*  71 */     this.stackManipulation = paramStackManipulation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StackManipulation of(TypeDefinition paramTypeDefinition) {
/*  81 */     if (paramTypeDefinition.isPrimitive()) {
/*  82 */       if (paramTypeDefinition.represents(long.class))
/*  83 */         return LONG; 
/*  84 */       if (paramTypeDefinition.represents(double.class))
/*  85 */         return DOUBLE; 
/*  86 */       if (paramTypeDefinition.represents(float.class))
/*  87 */         return FLOAT; 
/*  88 */       if (paramTypeDefinition.represents(void.class)) {
/*  89 */         return VOID;
/*     */       }
/*  91 */       return INTEGER;
/*     */     } 
/*     */     
/*  94 */     return REFERENCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isValid() {
/* 102 */     return this.stackManipulation.isValid();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/* 109 */     return this.stackManipulation.apply(paramMethodVisitor, paramContext);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\constant\DefaultValue.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */