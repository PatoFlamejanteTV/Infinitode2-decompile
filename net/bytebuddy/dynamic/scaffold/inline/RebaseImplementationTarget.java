/*     */ package net.bytebuddy.dynamic.scaffold.inline;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.bytebuddy.ClassFileVersion;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.description.type.TypeList;
/*     */ import net.bytebuddy.dynamic.scaffold.MethodGraph;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.utility.CompoundList;
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
/*     */ @Enhance
/*     */ public class RebaseImplementationTarget
/*     */   extends Implementation.Target.AbstractBase
/*     */ {
/*     */   private final Map<MethodDescription.SignatureToken, MethodRebaseResolver.Resolution> rebaseableMethods;
/*     */   
/*     */   protected RebaseImplementationTarget(TypeDescription paramTypeDescription, MethodGraph.Linked paramLinked, Implementation.Target.AbstractBase.DefaultMethodInvocation paramDefaultMethodInvocation, Map<MethodDescription.SignatureToken, MethodRebaseResolver.Resolution> paramMap) {
/*  65 */     super(paramTypeDescription, paramLinked, paramDefaultMethodInvocation);
/*  66 */     this.rebaseableMethods = paramMap;
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
/*     */   protected static Implementation.Target of(TypeDescription paramTypeDescription, MethodGraph.Linked paramLinked, ClassFileVersion paramClassFileVersion, MethodRebaseResolver paramMethodRebaseResolver) {
/*  82 */     return (Implementation.Target)new RebaseImplementationTarget(paramTypeDescription, paramLinked, Implementation.Target.AbstractBase.DefaultMethodInvocation.of(paramClassFileVersion), paramMethodRebaseResolver.asTokenMap());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Implementation.SpecialMethodInvocation invokeSuper(MethodDescription.SignatureToken paramSignatureToken) {
/*     */     MethodRebaseResolver.Resolution resolution;
/*  90 */     if ((resolution = this.rebaseableMethods.get(paramSignatureToken)) == null)
/*  91 */       return invokeSuper(this.methodGraph.getSuperClassGraph().locate(paramSignatureToken)); 
/*  92 */     return invokeSuper(resolution);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Implementation.SpecialMethodInvocation invokeSuper(MethodGraph.Node paramNode) {
/* 102 */     TypeDescription.Generic generic = this.instrumentedType.getSuperClass();
/* 103 */     if (paramNode.getSort().isResolved() && generic != null)
/* 104 */       return Implementation.SpecialMethodInvocation.Simple.of(paramNode.getRepresentative(), generic.asErasure());  return (Implementation.SpecialMethodInvocation)Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Implementation.SpecialMethodInvocation invokeSuper(MethodRebaseResolver.Resolution paramResolution) {
/* 115 */     if (paramResolution.isRebased())
/* 116 */       return RebasedMethodInvocation.of((MethodDescription)paramResolution.getResolvedMethod(), this.instrumentedType, paramResolution.getAppendedParameters()); 
/* 117 */     return Implementation.SpecialMethodInvocation.Simple.of((MethodDescription)paramResolution.getResolvedMethod(), this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeDescription getOriginType() {
/* 124 */     return this.instrumentedType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.rebaseableMethods.equals(((RebaseImplementationTarget)paramObject).rebaseableMethods)))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return super.hashCode() * 31 + this.rebaseableMethods.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class RebasedMethodInvocation
/*     */     extends Implementation.SpecialMethodInvocation.AbstractBase
/*     */   {
/*     */     private final MethodDescription methodDescription;
/*     */ 
/*     */ 
/*     */     
/*     */     private final TypeDescription instrumentedType;
/*     */ 
/*     */ 
/*     */     
/*     */     private final StackManipulation stackManipulation;
/*     */ 
/*     */ 
/*     */     
/*     */     private final TypeList prependedParameters;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected RebasedMethodInvocation(MethodDescription param1MethodDescription, TypeDescription param1TypeDescription, StackManipulation param1StackManipulation, TypeList param1TypeList) {
/* 165 */       this.methodDescription = param1MethodDescription;
/* 166 */       this.instrumentedType = param1TypeDescription;
/* 167 */       this.stackManipulation = param1StackManipulation;
/* 168 */       this.prependedParameters = param1TypeList;
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
/*     */ 
/*     */     
/*     */     protected static Implementation.SpecialMethodInvocation of(MethodDescription param1MethodDescription, TypeDescription param1TypeDescription, TypeList param1TypeList) {
/*     */       StackManipulation stackManipulation;
/* 183 */       if ((stackManipulation = (StackManipulation)(param1MethodDescription.isStatic() ? MethodInvocation.invoke(param1MethodDescription) : MethodInvocation.invoke(param1MethodDescription).special(param1TypeDescription))).isValid()) {
/* 184 */         ArrayList<StackManipulation> arrayList = new ArrayList(param1TypeList.size() + 1);
/* 185 */         for (TypeDescription typeDescription : param1TypeList) {
/* 186 */           arrayList.add(DefaultValue.of((TypeDefinition)typeDescription));
/*     */         }
/* 188 */         arrayList.add(stackManipulation);
/* 189 */         return (Implementation.SpecialMethodInvocation)new RebasedMethodInvocation(param1MethodDescription, param1TypeDescription, (StackManipulation)new StackManipulation.Compound(arrayList), param1TypeList);
/*     */       } 
/* 191 */       return (Implementation.SpecialMethodInvocation)Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MethodDescription getMethodDescription() {
/* 199 */       return this.methodDescription;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDescription getTypeDescription() {
/* 206 */       return this.instrumentedType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 213 */       return this.stackManipulation.apply(param1MethodVisitor, param1Context);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Implementation.SpecialMethodInvocation withCheckedCompatibilityTo(MethodDescription.TypeToken param1TypeToken) {
/* 220 */       if (this.methodDescription.asTypeToken().equals(new MethodDescription.TypeToken(param1TypeToken.getReturnType(), 
/* 221 */             CompoundList.of(param1TypeToken.getParameterTypes(), (List)this.prependedParameters)))) {
/* 222 */         return (Implementation.SpecialMethodInvocation)this;
/*     */       }
/* 224 */       return (Implementation.SpecialMethodInvocation)Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Factory
/*     */     implements Implementation.Target.Factory
/*     */   {
/*     */     private final MethodRebaseResolver methodRebaseResolver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Factory(MethodRebaseResolver param1MethodRebaseResolver) {
/* 246 */       this.methodRebaseResolver = param1MethodRebaseResolver;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Implementation.Target make(TypeDescription param1TypeDescription, MethodGraph.Linked param1Linked, ClassFileVersion param1ClassFileVersion) {
/* 253 */       return RebaseImplementationTarget.of(param1TypeDescription, param1Linked, param1ClassFileVersion, this.methodRebaseResolver);
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.methodRebaseResolver.equals(((Factory)param1Object).methodRebaseResolver))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.methodRebaseResolver.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\inline\RebaseImplementationTarget.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */