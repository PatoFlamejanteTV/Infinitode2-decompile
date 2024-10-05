/*     */ package net.bytebuddy.dynamic.scaffold.subclass;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import net.bytebuddy.ClassFileVersion;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.scaffold.MethodGraph;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
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
/*     */ @Enhance
/*     */ public class SubclassImplementationTarget
/*     */   extends Implementation.Target.AbstractBase
/*     */ {
/*     */   protected final OriginTypeResolver originTypeResolver;
/*     */   
/*     */   protected SubclassImplementationTarget(TypeDescription paramTypeDescription, MethodGraph.Linked paramLinked, Implementation.Target.AbstractBase.DefaultMethodInvocation paramDefaultMethodInvocation, OriginTypeResolver paramOriginTypeResolver) {
/*  54 */     super(paramTypeDescription, paramLinked, paramDefaultMethodInvocation);
/*  55 */     this.originTypeResolver = paramOriginTypeResolver;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Implementation.SpecialMethodInvocation invokeSuper(MethodDescription.SignatureToken paramSignatureToken) {
/*  62 */     if (paramSignatureToken.getName().equals("<init>"))
/*  63 */       return invokeConstructor(paramSignatureToken); 
/*  64 */     return invokeMethod(paramSignatureToken);
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
/*     */   private Implementation.SpecialMethodInvocation invokeConstructor(MethodDescription.SignatureToken paramSignatureToken) {
/*     */     TypeDescription.Generic generic;
/*  78 */     if ((paramSignatureToken = ((generic = this.instrumentedType.getSuperClass()) == null) ? (MethodDescription.SignatureToken)new MethodList.Empty() : (MethodDescription.SignatureToken)generic.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.hasSignature(paramSignatureToken).and((ElementMatcher)ElementMatchers.isVisibleTo(this.instrumentedType)))).size() == 1)
/*  79 */       return Implementation.SpecialMethodInvocation.Simple.of((MethodDescription)paramSignatureToken.getOnly(), generic.asErasure());  return (Implementation.SpecialMethodInvocation)Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming super class for given instance.")
/*     */   private Implementation.SpecialMethodInvocation invokeMethod(MethodDescription.SignatureToken paramSignatureToken) {
/*     */     MethodGraph.Node node;
/*  92 */     if ((node = this.methodGraph.getSuperClassGraph().locate(paramSignatureToken)).getSort().isUnique())
/*  93 */       return Implementation.SpecialMethodInvocation.Simple.of(node.getRepresentative(), this.instrumentedType.getSuperClass().asErasure());  return (Implementation.SpecialMethodInvocation)Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeDefinition getOriginType() {
/* 101 */     return this.originTypeResolver.identify(this.instrumentedType);
/*     */   }
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.originTypeResolver.equals(((SubclassImplementationTarget)paramObject).originTypeResolver)))));
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*     */     return super.hashCode() * 31 + this.originTypeResolver.hashCode();
/*     */   }
/*     */   
/*     */   public enum OriginTypeResolver {
/* 113 */     SUPER_CLASS
/*     */     {
/*     */       @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming super class for given instance.")
/*     */       protected final TypeDefinition identify(TypeDescription param2TypeDescription) {
/* 117 */         return (TypeDefinition)param2TypeDescription.getSuperClass();
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 124 */     LEVEL_TYPE
/*     */     {
/*     */       protected final TypeDefinition identify(TypeDescription param2TypeDescription) {
/* 127 */         return (TypeDefinition)param2TypeDescription;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract TypeDefinition identify(TypeDescription param1TypeDescription);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Factory
/*     */     implements Implementation.Target.Factory
/*     */   {
/* 148 */     SUPER_CLASS((String)SubclassImplementationTarget.OriginTypeResolver.SUPER_CLASS),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 153 */     LEVEL_TYPE((String)SubclassImplementationTarget.OriginTypeResolver.LEVEL_TYPE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final SubclassImplementationTarget.OriginTypeResolver originTypeResolver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Factory(SubclassImplementationTarget.OriginTypeResolver param1OriginTypeResolver) {
/* 166 */       this.originTypeResolver = param1OriginTypeResolver;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Implementation.Target make(TypeDescription param1TypeDescription, MethodGraph.Linked param1Linked, ClassFileVersion param1ClassFileVersion) {
/* 173 */       return (Implementation.Target)new SubclassImplementationTarget(param1TypeDescription, param1Linked, Implementation.Target.AbstractBase.DefaultMethodInvocation.of(param1ClassFileVersion), this.originTypeResolver);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\subclass\SubclassImplementationTarget.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */