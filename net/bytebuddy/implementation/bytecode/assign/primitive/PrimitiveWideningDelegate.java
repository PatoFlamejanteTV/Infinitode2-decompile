/*     */ package net.bytebuddy.implementation.bytecode.assign.primitive;
/*     */ 
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.StackSize;
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
/*     */ public enum PrimitiveWideningDelegate
/*     */ {
/*  35 */   BOOLEAN((StackManipulation)StackManipulation.Trivial.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE),
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
/*  47 */   BYTE((StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Trivial.INSTANCE, (StackManipulation)StackManipulation.Trivial.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Trivial.INSTANCE, (StackManipulation)new WideningStackManipulation(133, StackSize.SINGLE
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  52 */       .toIncreasingSize()), (StackManipulation)new WideningStackManipulation(134, StackSize.ZERO
/*  53 */       .toIncreasingSize()), (StackManipulation)new WideningStackManipulation(133, StackSize.SINGLE
/*  54 */       .toIncreasingSize())),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  59 */   SHORT((StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Trivial.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Trivial.INSTANCE, (StackManipulation)new WideningStackManipulation(133, StackSize.SINGLE
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  64 */       .toIncreasingSize()), (StackManipulation)new WideningStackManipulation(134, StackSize.ZERO
/*  65 */       .toIncreasingSize()), (StackManipulation)new WideningStackManipulation(135, StackSize.SINGLE
/*  66 */       .toIncreasingSize())),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   CHARACTER((StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Trivial.INSTANCE, (StackManipulation)StackManipulation.Trivial.INSTANCE, (StackManipulation)new WideningStackManipulation(133, StackSize.SINGLE
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  76 */       .toIncreasingSize()), (StackManipulation)new WideningStackManipulation(134, StackSize.ZERO
/*  77 */       .toIncreasingSize()), (StackManipulation)new WideningStackManipulation(135, StackSize.SINGLE
/*  78 */       .toIncreasingSize())),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  83 */   INTEGER((StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Trivial.INSTANCE, (StackManipulation)new WideningStackManipulation(133, StackSize.SINGLE
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  88 */       .toIncreasingSize()), (StackManipulation)new WideningStackManipulation(134, StackSize.ZERO
/*  89 */       .toIncreasingSize()), (StackManipulation)new WideningStackManipulation(135, StackSize.SINGLE
/*  90 */       .toIncreasingSize())),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   LONG((StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Trivial.INSTANCE, (StackManipulation)new WideningStackManipulation(137, StackSize.SINGLE
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 101 */       .toDecreasingSize()), (StackManipulation)new WideningStackManipulation(138, StackSize.ZERO
/* 102 */       .toIncreasingSize())),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 107 */   FLOAT((StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Trivial.INSTANCE, (StackManipulation)new WideningStackManipulation(141, StackSize.SINGLE
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 114 */       .toIncreasingSize())),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 119 */   DOUBLE((StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Illegal.INSTANCE, (StackManipulation)StackManipulation.Trivial.INSTANCE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final StackManipulation toBooleanStackManipulation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final StackManipulation toByteStackManipulation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final StackManipulation toShortStackManipulation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final StackManipulation toCharacterStackManipulation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final StackManipulation toIntegerStackManipulation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final StackManipulation toLongStackManipulation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final StackManipulation toFloatStackManipulation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final StackManipulation toDoubleStackManipulation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PrimitiveWideningDelegate(StackManipulation paramStackManipulation1, StackManipulation paramStackManipulation2, StackManipulation paramStackManipulation3, StackManipulation paramStackManipulation4, StackManipulation paramStackManipulation5, StackManipulation paramStackManipulation6, StackManipulation paramStackManipulation7, StackManipulation paramStackManipulation8) {
/* 196 */     this.toBooleanStackManipulation = paramStackManipulation1;
/* 197 */     this.toByteStackManipulation = paramStackManipulation2;
/* 198 */     this.toShortStackManipulation = paramStackManipulation3;
/* 199 */     this.toCharacterStackManipulation = paramStackManipulation4;
/* 200 */     this.toIntegerStackManipulation = paramStackManipulation5;
/* 201 */     this.toLongStackManipulation = paramStackManipulation6;
/* 202 */     this.toFloatStackManipulation = paramStackManipulation7;
/* 203 */     this.toDoubleStackManipulation = paramStackManipulation8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PrimitiveWideningDelegate forPrimitive(TypeDefinition paramTypeDefinition) {
/* 213 */     if (paramTypeDefinition.represents(boolean.class))
/* 214 */       return BOOLEAN; 
/* 215 */     if (paramTypeDefinition.represents(byte.class))
/* 216 */       return BYTE; 
/* 217 */     if (paramTypeDefinition.represents(short.class))
/* 218 */       return SHORT; 
/* 219 */     if (paramTypeDefinition.represents(char.class))
/* 220 */       return CHARACTER; 
/* 221 */     if (paramTypeDefinition.represents(int.class))
/* 222 */       return INTEGER; 
/* 223 */     if (paramTypeDefinition.represents(long.class))
/* 224 */       return LONG; 
/* 225 */     if (paramTypeDefinition.represents(float.class))
/* 226 */       return FLOAT; 
/* 227 */     if (paramTypeDefinition.represents(double.class)) {
/* 228 */       return DOUBLE;
/*     */     }
/* 230 */     throw new IllegalArgumentException("Not a primitive, non-void type: " + paramTypeDefinition);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackManipulation widenTo(TypeDefinition paramTypeDefinition) {
/* 241 */     if (paramTypeDefinition.represents(boolean.class))
/* 242 */       return this.toBooleanStackManipulation; 
/* 243 */     if (paramTypeDefinition.represents(byte.class))
/* 244 */       return this.toByteStackManipulation; 
/* 245 */     if (paramTypeDefinition.represents(short.class))
/* 246 */       return this.toShortStackManipulation; 
/* 247 */     if (paramTypeDefinition.represents(char.class))
/* 248 */       return this.toCharacterStackManipulation; 
/* 249 */     if (paramTypeDefinition.represents(int.class))
/* 250 */       return this.toIntegerStackManipulation; 
/* 251 */     if (paramTypeDefinition.represents(long.class))
/* 252 */       return this.toLongStackManipulation; 
/* 253 */     if (paramTypeDefinition.represents(float.class))
/* 254 */       return this.toFloatStackManipulation; 
/* 255 */     if (paramTypeDefinition.represents(double.class)) {
/* 256 */       return this.toDoubleStackManipulation;
/*     */     }
/* 258 */     throw new IllegalArgumentException("Not a primitive non-void type: " + paramTypeDefinition);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class WideningStackManipulation
/*     */     extends StackManipulation.AbstractBase
/*     */   {
/*     */     private final int conversionOpcode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final StackManipulation.Size size;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected WideningStackManipulation(int param1Int, StackManipulation.Size param1Size) {
/* 285 */       this.conversionOpcode = param1Int;
/* 286 */       this.size = param1Size;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 293 */       param1MethodVisitor.visitInsn(this.conversionOpcode);
/* 294 */       return this.size;
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.conversionOpcode != ((WideningStackManipulation)param1Object).conversionOpcode) ? false : (!!this.size.equals(((WideningStackManipulation)param1Object).size)))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.conversionOpcode) * 31 + this.size.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\assign\primitive\PrimitiveWideningDelegate.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */