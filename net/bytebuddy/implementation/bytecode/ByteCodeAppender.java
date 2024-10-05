/*     */ package net.bytebuddy.implementation.bytecode;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface ByteCodeAppender
/*     */ {
/*     */   Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext, MethodDescription paramMethodDescription);
/*     */   
/*     */   @Enhance
/*     */   public static class Size
/*     */   {
/*  62 */     public static final Size ZERO = new Size(0, 0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int operandStackSize;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int localVariableSize;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Size(int param1Int1, int param1Int2) {
/*  79 */       this.operandStackSize = param1Int1;
/*  80 */       this.localVariableSize = param1Int2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getOperandStackSize() {
/*  89 */       return this.operandStackSize;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getLocalVariableSize() {
/*  98 */       return this.localVariableSize;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Size merge(Size param1Size) {
/* 108 */       return new Size(Math.max(this.operandStackSize, param1Size.operandStackSize), Math.max(this.localVariableSize, param1Size.localVariableSize));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.operandStackSize != ((Size)param1Object).operandStackSize) ? false : (!(this.localVariableSize != ((Size)param1Object).localVariableSize)))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.operandStackSize) * 31 + this.localVariableSize;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Compound
/*     */     implements ByteCodeAppender
/*     */   {
/*     */     public Compound(ByteCodeAppender... param1VarArgs) {
/* 129 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 138 */     private final List<ByteCodeAppender> byteCodeAppenders = new ArrayList<ByteCodeAppender>(); public Compound(List<? extends ByteCodeAppender> param1List) {
/* 139 */       for (Iterator<? extends ByteCodeAppender> iterator = param1List.iterator(); iterator.hasNext(); ) {
/* 140 */         ByteCodeAppender byteCodeAppender; if (byteCodeAppender = iterator.next() instanceof Compound) {
/* 141 */           this.byteCodeAppenders.addAll(((Compound)byteCodeAppender).byteCodeAppenders); continue;
/*     */         } 
/* 143 */         this.byteCodeAppenders.add(byteCodeAppender);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/* 154 */       ByteCodeAppender.Size size = new ByteCodeAppender.Size(0, param1MethodDescription.getStackSize());
/* 155 */       for (ByteCodeAppender byteCodeAppender : this.byteCodeAppenders) {
/* 156 */         size = size.merge(byteCodeAppender.apply(param1MethodVisitor, param1Context, param1MethodDescription));
/*     */       }
/* 158 */       return size;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.byteCodeAppenders.equals(((Compound)param1Object).byteCodeAppenders))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.byteCodeAppenders.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Simple
/*     */     implements ByteCodeAppender
/*     */   {
/*     */     private final StackManipulation stackManipulation;
/*     */     
/*     */     public Simple(StackManipulation... param1VarArgs) {
/* 180 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Simple(List<? extends StackManipulation> param1List) {
/* 189 */       this.stackManipulation = new StackManipulation.Compound(param1List);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/* 198 */       return new ByteCodeAppender.Size(this.stackManipulation.apply(param1MethodVisitor, param1Context).getMaximalSize(), param1MethodDescription.getStackSize());
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.stackManipulation.equals(((Simple)param1Object).stackManipulation))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.stackManipulation.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\ByteCodeAppender.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */