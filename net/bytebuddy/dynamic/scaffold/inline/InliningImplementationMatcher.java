/*    */ package net.bytebuddy.dynamic.scaffold.inline;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.description.method.MethodDescription;
/*    */ import net.bytebuddy.description.type.TypeDescription;
/*    */ import net.bytebuddy.matcher.ElementMatcher;
/*    */ import net.bytebuddy.matcher.ElementMatchers;
/*    */ import net.bytebuddy.matcher.LatentMatcher;
/*    */ import net.bytebuddy.utility.nullability.MaybeNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Enhance
/*    */ public class InliningImplementationMatcher
/*    */   implements LatentMatcher<MethodDescription>
/*    */ {
/*    */   private final LatentMatcher<? super MethodDescription> ignoredMethods;
/*    */   private final ElementMatcher<? super MethodDescription> predefinedMethodSignatures;
/*    */   
/*    */   protected InliningImplementationMatcher(LatentMatcher<? super MethodDescription> paramLatentMatcher, ElementMatcher<? super MethodDescription> paramElementMatcher) {
/* 51 */     this.ignoredMethods = paramLatentMatcher;
/* 52 */     this.predefinedMethodSignatures = paramElementMatcher;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected static LatentMatcher<MethodDescription> of(LatentMatcher<? super MethodDescription> paramLatentMatcher, TypeDescription paramTypeDescription) {
/* 65 */     ElementMatcher.Junction junction = ElementMatchers.none();
/* 66 */     for (Iterator<MethodDescription> iterator = paramTypeDescription.getDeclaredMethods().iterator(); iterator.hasNext(); ) {
/*    */       MethodDescription methodDescription;
/*    */ 
/*    */ 
/*    */       
/* 71 */       ElementMatcher.Junction junction1 = (junction1 = (junction1 = (methodDescription = iterator.next()).isConstructor() ? ElementMatchers.isConstructor() : ElementMatchers.named(methodDescription.getName())).and((ElementMatcher)ElementMatchers.returns(methodDescription.getReturnType().asErasure()))).and((ElementMatcher)ElementMatchers.takesArguments((Iterable)methodDescription.getParameters().asTypeList().asErasures()));
/* 72 */       junction = junction.or((ElementMatcher)junction1);
/*    */     } 
/* 74 */     return new InliningImplementationMatcher(paramLatentMatcher, (ElementMatcher<? super MethodDescription>)junction);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ElementMatcher<? super MethodDescription> resolve(TypeDescription paramTypeDescription) {
/* 81 */     return (ElementMatcher<? super MethodDescription>)ElementMatchers.not(this.ignoredMethods.resolve(paramTypeDescription))
/* 82 */       .and((ElementMatcher)ElementMatchers.isVirtual().and((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isFinal())).or((ElementMatcher)ElementMatchers.isDeclaredBy(paramTypeDescription)))
/* 83 */       .or((ElementMatcher)ElementMatchers.isDeclaredBy(paramTypeDescription).and((ElementMatcher)ElementMatchers.not(this.predefinedMethodSignatures)));
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.ignoredMethods.equals(((InliningImplementationMatcher)paramObject).ignoredMethods) ? false : (!!this.predefinedMethodSignatures.equals(((InliningImplementationMatcher)paramObject).predefinedMethodSignatures)))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return (getClass().hashCode() * 31 + this.ignoredMethods.hashCode()) * 31 + this.predefinedMethodSignatures.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\inline\InliningImplementationMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */