/*     */ package net.bytebuddy.implementation;
/*     */ 
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*     */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*     */ import net.bytebuddy.implementation.bytecode.Removal;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodReturn;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
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
/*     */ public enum SuperMethodCall
/*     */   implements Implementation.Composable
/*     */ {
/*  43 */   INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final InstrumentedType prepare(InstrumentedType paramInstrumentedType) {
/*  49 */     return paramInstrumentedType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ByteCodeAppender appender(Implementation.Target paramTarget) {
/*  56 */     return new Appender(paramTarget, Appender.TerminationHandler.RETURNING);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Implementation andThen(Implementation paramImplementation) {
/*  63 */     return new Implementation.Compound(new Implementation[] { WithoutReturn.INSTANCE, paramImplementation });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Implementation.Composable andThen(Implementation.Composable paramComposable) {
/*  70 */     return new Implementation.Compound.Composable(WithoutReturn.INSTANCE, paramComposable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected enum WithoutReturn
/*     */     implements Implementation
/*     */   {
/*  81 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/*  87 */       return param1InstrumentedType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ByteCodeAppender appender(Implementation.Target param1Target) {
/*  94 */       return new SuperMethodCall.Appender(param1Target, SuperMethodCall.Appender.TerminationHandler.DROPPING);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class Appender
/*     */     implements ByteCodeAppender
/*     */   {
/*     */     private final Implementation.Target implementationTarget;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final TerminationHandler terminationHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Appender(Implementation.Target param1Target, TerminationHandler param1TerminationHandler) {
/* 121 */       this.implementationTarget = param1Target;
/* 122 */       this.terminationHandler = param1TerminationHandler;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/*     */       Implementation.SpecialMethodInvocation specialMethodInvocation;
/* 132 */       if (!(specialMethodInvocation = this.implementationTarget.invokeDominant(param1MethodDescription.asSignatureToken()).withCheckedCompatibilityTo(param1MethodDescription.asTypeToken())).isValid()) {
/* 133 */         throw new IllegalStateException("Cannot call super (or default) method for " + param1MethodDescription);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 139 */       StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.allArgumentsOf(param1MethodDescription).prependThisReference(), specialMethodInvocation, this.terminationHandler.of(param1MethodDescription) })).apply(param1MethodVisitor, param1Context);
/* 140 */       return new ByteCodeAppender.Size(size.getMaximalSize(), param1MethodDescription.getStackSize());
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.terminationHandler.equals(((Appender)param1Object).terminationHandler) ? false : (!!this.implementationTarget.equals(((Appender)param1Object).implementationTarget)))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.implementationTarget.hashCode()) * 31 + this.terminationHandler.hashCode();
/*     */     }
/*     */     
/* 151 */     protected enum TerminationHandler { RETURNING
/*     */       {
/*     */         protected final StackManipulation of(MethodDescription param3MethodDescription) {
/* 154 */           return MethodReturn.of((TypeDefinition)param3MethodDescription.getReturnType());
/*     */         }
/*     */       },
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 161 */       DROPPING
/*     */       {
/*     */         protected final StackManipulation of(MethodDescription param3MethodDescription) {
/* 164 */           return Removal.of((TypeDefinition)param3MethodDescription.getReturnType()); } }; protected abstract StackManipulation of(MethodDescription param2MethodDescription); } } protected enum TerminationHandler { RETURNING { protected final StackManipulation of(MethodDescription param3MethodDescription) { return Removal.of((TypeDefinition)param3MethodDescription.getReturnType()); }
/*     */        }
/*     */     ,
/*     */     DROPPING {
/*     */       protected final StackManipulation of(MethodDescription param3MethodDescription) {
/*     */         return MethodReturn.of((TypeDefinition)param3MethodDescription.getReturnType());
/*     */       }
/*     */     };
/*     */     
/*     */     protected abstract StackManipulation of(MethodDescription param1MethodDescription); }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\SuperMethodCall.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */