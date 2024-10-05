/*     */ package net.bytebuddy.implementation.bytecode;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
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
/*     */ public interface StackManipulation
/*     */ {
/*     */   boolean isValid();
/*     */   
/*     */   Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext);
/*     */   
/*     */   public enum Illegal
/*     */     implements StackManipulation
/*     */   {
/*  55 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isValid() {
/*  61 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/*  68 */       throw new IllegalStateException("An illegal stack manipulation must not be applied");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Trivial
/*     */     implements StackManipulation
/*     */   {
/*  80 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isValid() {
/*  86 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/*  93 */       return StackSize.ZERO.toIncreasingSize();
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
/*     */   @Enhance
/*     */   public static class Size
/*     */   {
/* 107 */     public static final Size ZERO = new Size(0, 0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int sizeImpact;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int maximalSize;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Size(int param1Int1, int param1Int2) {
/* 130 */       this.sizeImpact = param1Int1;
/* 131 */       this.maximalSize = param1Int2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getSizeImpact() {
/* 140 */       return this.sizeImpact;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getMaximalSize() {
/* 149 */       return this.maximalSize;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Size aggregate(Size param1Size) {
/* 160 */       return aggregate(param1Size.sizeImpact, param1Size.maximalSize);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Size aggregate(int param1Int1, int param1Int2) {
/* 172 */       return new Size(this.sizeImpact + param1Int1, Math.max(this.maximalSize, this.sizeImpact + param1Int2));
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.sizeImpact != ((Size)param1Object).sizeImpact) ? false : (!(this.maximalSize != ((Size)param1Object).maximalSize)))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.sizeImpact) * 31 + this.maximalSize;
/*     */     } }
/*     */   
/*     */   public static abstract class AbstractBase implements StackManipulation {
/*     */     public boolean isValid() {
/* 185 */       return true;
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
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Compound
/*     */     implements StackManipulation
/*     */   {
/*     */     public Compound(StackManipulation... param1VarArgs) {
/* 206 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 215 */     private final List<StackManipulation> stackManipulations = new ArrayList<StackManipulation>(); public Compound(List<? extends StackManipulation> param1List) {
/* 216 */       for (Iterator<? extends StackManipulation> iterator = param1List.iterator(); iterator.hasNext(); ) {
/* 217 */         StackManipulation stackManipulation; if (stackManipulation = iterator.next() instanceof Compound) {
/* 218 */           this.stackManipulations.addAll(((Compound)stackManipulation).stackManipulations); continue;
/* 219 */         }  if (!(stackManipulation instanceof StackManipulation.Trivial)) {
/* 220 */           this.stackManipulations.add(stackManipulation);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isValid() {
/* 229 */       for (Iterator<StackManipulation> iterator = this.stackManipulations.iterator(); iterator.hasNext();) {
/* 230 */         if (!(stackManipulation = iterator.next()).isValid()) {
/* 231 */           return false;
/*     */         }
/*     */       } 
/* 234 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 241 */       StackManipulation.Size size = StackManipulation.Size.ZERO;
/* 242 */       for (StackManipulation stackManipulation : this.stackManipulations) {
/* 243 */         size = size.aggregate(stackManipulation.apply(param1MethodVisitor, param1Context));
/*     */       }
/* 245 */       return size;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.stackManipulations.equals(((Compound)param1Object).stackManipulations))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.stackManipulations.hashCode();
/*     */     }
/*     */   }
/*     */   
/*     */   @Enhance
/*     */   public static class Simple
/*     */     extends AbstractBase
/*     */   {
/*     */     private final Dispatcher dispatcher;
/*     */     
/*     */     public Simple(Dispatcher param1Dispatcher) {
/* 266 */       this.dispatcher = param1Dispatcher;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 273 */       return this.dispatcher.apply(param1MethodVisitor, param1Context);
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.dispatcher.equals(((Simple)param1Object).dispatcher))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.dispatcher.hashCode();
/*     */     }
/*     */     
/*     */     public static interface Dispatcher {
/*     */       StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\StackManipulation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */