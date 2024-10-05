/*     */ package net.bytebuddy.implementation;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.description.type.TypeList;
/*     */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*     */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Enhance
/*     */ public class DefaultMethodCall
/*     */   implements Implementation
/*     */ {
/*     */   private final List<TypeDescription> prioritizedInterfaces;
/*     */   
/*     */   protected DefaultMethodCall(List<TypeDescription> paramList) {
/*  64 */     this.prioritizedInterfaces = paramList;
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
/*     */   public static Implementation prioritize(Class<?>... paramVarArgs) {
/*  79 */     return prioritize((Collection<? extends TypeDescription>)new TypeList.ForLoadedTypes(paramVarArgs));
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
/*     */   public static Implementation prioritize(Iterable<? extends Class<?>> paramIterable) {
/*  94 */     ArrayList<Class<?>> arrayList = new ArrayList();
/*  95 */     for (Class<?> clazz : paramIterable) {
/*  96 */       arrayList.add(clazz);
/*     */     }
/*  98 */     return prioritize((Collection<? extends TypeDescription>)new TypeList.ForLoadedTypes(arrayList));
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
/*     */   public static Implementation prioritize(TypeDescription... paramVarArgs) {
/* 113 */     return prioritize(Arrays.asList(paramVarArgs));
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
/*     */   public static Implementation prioritize(Collection<? extends TypeDescription> paramCollection) {
/* 128 */     return new DefaultMethodCall(new ArrayList<TypeDescription>(paramCollection));
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
/*     */   public static Implementation unambiguousOnly() {
/* 141 */     return new DefaultMethodCall(Collections.emptyList());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InstrumentedType prepare(InstrumentedType paramInstrumentedType) {
/* 148 */     return paramInstrumentedType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteCodeAppender appender(Implementation.Target paramTarget) {
/* 155 */     return new Appender(paramTarget, filterRelevant(paramTarget.getInstrumentedType()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<TypeDescription> filterRelevant(TypeDescription paramTypeDescription) {
/* 166 */     ArrayList<TypeDescription> arrayList = new ArrayList(this.prioritizedInterfaces.size());
/* 167 */     HashSet hashSet = new HashSet((Collection<?>)paramTypeDescription.getInterfaces().asErasures());
/* 168 */     for (TypeDescription typeDescription : this.prioritizedInterfaces) {
/* 169 */       if (hashSet.remove(typeDescription)) {
/* 170 */         arrayList.add(typeDescription);
/*     */       }
/*     */     } 
/* 173 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.prioritizedInterfaces.equals(((DefaultMethodCall)paramObject).prioritizedInterfaces))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return getClass().hashCode() * 31 + this.prioritizedInterfaces.hashCode();
/*     */   }
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
/*     */     private final List<TypeDescription> prioritizedInterfaces;
/*     */ 
/*     */     
/*     */     @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
/*     */     private final Set<TypeDescription> nonPrioritizedInterfaces;
/*     */ 
/*     */     
/*     */     protected Appender(Implementation.Target param1Target, List<TypeDescription> param1List) {
/* 205 */       this.implementationTarget = param1Target;
/* 206 */       this.prioritizedInterfaces = param1List;
/* 207 */       this.nonPrioritizedInterfaces = new HashSet<TypeDescription>((Collection<? extends TypeDescription>)param1Target.getInstrumentedType().getInterfaces().asErasures());
/* 208 */       this.nonPrioritizedInterfaces.removeAll(param1List);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/*     */       StackManipulation stackManipulation;
/* 216 */       if (!(stackManipulation = locateDefault(param1MethodDescription)).isValid()) {
/* 217 */         throw new IllegalStateException("Cannot invoke default method on " + param1MethodDescription);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 223 */       StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.allArgumentsOf(param1MethodDescription).prependThisReference(), stackManipulation, MethodReturn.of((TypeDefinition)param1MethodDescription.getReturnType()) })).apply(param1MethodVisitor, param1Context);
/* 224 */       return new ByteCodeAppender.Size(size.getMaximalSize(), param1MethodDescription.getStackSize());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private StackManipulation locateDefault(MethodDescription param1MethodDescription) {
/* 235 */       MethodDescription.SignatureToken signatureToken = param1MethodDescription.asSignatureToken();
/* 236 */       Implementation.SpecialMethodInvocation specialMethodInvocation = Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
/* 237 */       for (TypeDescription typeDescription : this.prioritizedInterfaces) {
/*     */ 
/*     */ 
/*     */         
/* 241 */         if ((specialMethodInvocation = this.implementationTarget.invokeDefault(signatureToken, typeDescription).withCheckedCompatibilityTo(param1MethodDescription.asTypeToken())).isValid()) {
/* 242 */           return specialMethodInvocation;
/*     */         }
/*     */       } 
/* 245 */       for (TypeDescription typeDescription : this.nonPrioritizedInterfaces) {
/*     */ 
/*     */         
/* 248 */         Implementation.SpecialMethodInvocation specialMethodInvocation1 = this.implementationTarget.invokeDefault(signatureToken, typeDescription).withCheckedCompatibilityTo(param1MethodDescription.asTypeToken());
/* 249 */         if (specialMethodInvocation.isValid() && specialMethodInvocation1.isValid()) {
/* 250 */           throw new IllegalStateException(param1MethodDescription + " has an ambiguous default method with " + specialMethodInvocation1
/* 251 */               .getMethodDescription() + " and " + specialMethodInvocation.getMethodDescription());
/*     */         }
/* 253 */         specialMethodInvocation = specialMethodInvocation1;
/*     */       } 
/* 255 */       return specialMethodInvocation;
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.implementationTarget.equals(((Appender)param1Object).implementationTarget) ? false : (!!this.prioritizedInterfaces.equals(((Appender)param1Object).prioritizedInterfaces)))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.implementationTarget.hashCode()) * 31 + this.prioritizedInterfaces.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\DefaultMethodCall.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */