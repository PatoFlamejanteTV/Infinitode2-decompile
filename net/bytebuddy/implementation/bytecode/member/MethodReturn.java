/*     */ package net.bytebuddy.implementation.bytecode.member;
/*     */ 
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.StackSize;
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
/*     */ public enum MethodReturn
/*     */   implements StackManipulation
/*     */ {
/*  33 */   INTEGER(172, StackSize.SINGLE),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   DOUBLE(175, StackSize.DOUBLE),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   FLOAT(174, StackSize.SINGLE),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   LONG(173, StackSize.DOUBLE),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   VOID(177, StackSize.ZERO),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   REFERENCE(176, StackSize.SINGLE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int returnOpcode;
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
/*     */   MethodReturn(int paramInt1, StackSize paramStackSize) {
/*  77 */     this.returnOpcode = paramInt1;
/*  78 */     this.size = paramStackSize.toDecreasingSize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StackManipulation of(TypeDefinition paramTypeDefinition) {
/*  88 */     if (paramTypeDefinition.isPrimitive()) {
/*  89 */       if (paramTypeDefinition.represents(long.class))
/*  90 */         return LONG; 
/*  91 */       if (paramTypeDefinition.represents(double.class))
/*  92 */         return DOUBLE; 
/*  93 */       if (paramTypeDefinition.represents(float.class))
/*  94 */         return FLOAT; 
/*  95 */       if (paramTypeDefinition.represents(void.class)) {
/*  96 */         return VOID;
/*     */       }
/*  98 */       return INTEGER;
/*     */     } 
/*     */     
/* 101 */     return REFERENCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isValid() {
/* 109 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/* 116 */     paramMethodVisitor.visitInsn(this.returnOpcode);
/* 117 */     return this.size;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\member\MethodReturn.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */