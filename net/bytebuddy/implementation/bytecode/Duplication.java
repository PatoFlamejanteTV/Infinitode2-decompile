/*     */ package net.bytebuddy.implementation.bytecode;
/*     */ 
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.implementation.Implementation;
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
/*     */ public enum Duplication
/*     */   implements StackManipulation
/*     */ {
/*  31 */   ZERO(StackSize.ZERO, 0)
/*     */   {
/*     */     public final StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/*  34 */       return this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     public final StackManipulation flipOver(TypeDefinition param1TypeDefinition) {
/*  39 */       throw new IllegalStateException("Cannot flip zero value");
/*     */     }
/*     */   },
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   SINGLE(StackSize.SINGLE, 89)
/*     */   {
/*     */     public final StackManipulation flipOver(TypeDefinition param1TypeDefinition) {
/*  49 */       switch (null.a[param1TypeDefinition.getStackSize().ordinal()]) {
/*     */         case 1:
/*  51 */           return WithFlip.SINGLE_SINGLE;
/*     */         case 2:
/*  53 */           return WithFlip.SINGLE_DOUBLE;
/*     */       } 
/*  55 */       throw new IllegalArgumentException("Cannot flip: " + param1TypeDefinition);
/*     */     }
/*     */   },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   DOUBLE(StackSize.DOUBLE, 92)
/*     */   {
/*     */     public final StackManipulation flipOver(TypeDefinition param1TypeDefinition) {
/*  66 */       switch (null.a[param1TypeDefinition.getStackSize().ordinal()]) {
/*     */         case 1:
/*  68 */           return WithFlip.DOUBLE_SINGLE;
/*     */         case 2:
/*  70 */           return WithFlip.DOUBLE_DOUBLE;
/*     */       } 
/*  72 */       throw new IllegalArgumentException("Cannot flip: " + param1TypeDefinition);
/*     */     }
/*     */   };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final StackManipulation.Size size;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int opcode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Duplication(StackSize paramStackSize, int paramInt1) {
/*  94 */     this.size = paramStackSize.toIncreasingSize();
/*  95 */     this.opcode = paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Duplication of(TypeDefinition paramTypeDefinition) {
/* 105 */     switch (null.a[paramTypeDefinition.getStackSize().ordinal()]) {
/*     */       case 1:
/* 107 */         return SINGLE;
/*     */       case 2:
/* 109 */         return DOUBLE;
/*     */       case 3:
/* 111 */         return ZERO;
/*     */     } 
/* 113 */     throw new AssertionError("Unexpected type: " + paramTypeDefinition);
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
/*     */   public boolean isValid() {
/* 129 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/* 136 */     paramMethodVisitor.visitInsn(this.opcode);
/* 137 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract StackManipulation flipOver(TypeDefinition paramTypeDefinition);
/*     */ 
/*     */   
/*     */   protected enum WithFlip
/*     */     implements StackManipulation
/*     */   {
/* 148 */     SINGLE_SINGLE(90, StackSize.SINGLE),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 153 */     SINGLE_DOUBLE(91, StackSize.SINGLE),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 158 */     DOUBLE_SINGLE(93, StackSize.DOUBLE),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     DOUBLE_DOUBLE(94, StackSize.DOUBLE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int opcode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final StackSize stackSize;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     WithFlip(int param1Int1, StackSize param1StackSize) {
/* 182 */       this.opcode = param1Int1;
/* 183 */       this.stackSize = param1StackSize;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isValid() {
/* 190 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 197 */       param1MethodVisitor.visitInsn(this.opcode);
/* 198 */       return this.stackSize.toIncreasingSize();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\Duplication.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */