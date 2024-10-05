/*     */ package net.bytebuddy.implementation.bind.annotation;
/*     */ 
/*     */ import java.lang.annotation.Documented;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.method.ParameterDescription;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bind.ArgumentTypeResolver;
/*     */ import net.bytebuddy.implementation.bind.MethodDelegationBinder;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
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
/*     */ @Documented
/*     */ @Retention(RetentionPolicy.RUNTIME)
/*     */ @Target({ElementType.PARAMETER})
/*     */ public @interface Argument
/*     */ {
/*     */   int value();
/*     */   
/*     */   BindingMechanic bindingMechanic() default BindingMechanic.UNIQUE;
/*     */   
/*     */   public enum BindingMechanic
/*     */   {
/*  99 */     UNIQUE
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected final MethodDelegationBinder.ParameterBinding<?> makeBinding(TypeDescription.Generic param2Generic1, TypeDescription.Generic param2Generic2, int param2Int1, Assigner param2Assigner, Assigner.Typing param2Typing, int param2Int2)
/*     */       {
/* 107 */         return (MethodDelegationBinder.ParameterBinding<?>)MethodDelegationBinder.ParameterBinding.Unique.of((StackManipulation)new StackManipulation.Compound(new StackManipulation[] {
/*     */                 
/* 109 */                 MethodVariableAccess.of((TypeDefinition)param2Generic1).loadFrom(param2Int2), param2Assigner
/* 110 */                 .assign(param2Generic1, param2Generic2, param2Typing) }), new ArgumentTypeResolver.ParameterIndexToken(param2Int1));
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 119 */     ANONYMOUS
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected final MethodDelegationBinder.ParameterBinding<?> makeBinding(TypeDescription.Generic param2Generic1, TypeDescription.Generic param2Generic2, int param2Int1, Assigner param2Assigner, Assigner.Typing param2Typing, int param2Int2)
/*     */       {
/* 127 */         return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous((StackManipulation)new StackManipulation.Compound(new StackManipulation[] {
/* 128 */                 MethodVariableAccess.of((TypeDefinition)param2Generic1).loadFrom(param2Int2), param2Assigner.assign(param2Generic1, param2Generic2, param2Typing)
/*     */               }));
/*     */       }
/*     */     };
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
/*     */     protected abstract MethodDelegationBinder.ParameterBinding<?> makeBinding(TypeDescription.Generic param1Generic1, TypeDescription.Generic param1Generic2, int param1Int1, Assigner param1Assigner, Assigner.Typing param1Typing, int param1Int2);
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
/*     */   public enum Binder
/*     */     implements TargetMethodAnnotationDrivenBinder.ParameterBinder<Argument>
/*     */   {
/* 164 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape BINDING_MECHANIC;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape VALUE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */       MethodList methodList;
/* 181 */       VALUE = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Argument.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("value"))).getOnly();
/* 182 */       BINDING_MECHANIC = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("bindingMechanic"))).getOnly();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Class<Argument> getHandledType() {
/* 189 */       return Argument.class;
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
/*     */     public final MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<Argument> param1Loadable, MethodDescription param1MethodDescription, ParameterDescription param1ParameterDescription, Implementation.Target param1Target, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 201 */       if (((Integer)param1Loadable.getValue(VALUE).resolve(Integer.class)).intValue() < 0)
/* 202 */         throw new IllegalArgumentException("@Argument annotation on " + param1ParameterDescription + " specifies negative index"); 
/* 203 */       if (param1MethodDescription.getParameters().size() <= ((Integer)param1Loadable.getValue(VALUE).resolve(Integer.class)).intValue()) {
/* 204 */         return (MethodDelegationBinder.ParameterBinding<?>)MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
/*     */       }
/* 206 */       return ((Argument.BindingMechanic)param1Loadable.getValue(BINDING_MECHANIC)
/* 207 */         .load(Argument.class.getClassLoader())
/* 208 */         .resolve(Argument.BindingMechanic.class))
/* 209 */         .makeBinding(((ParameterDescription)param1MethodDescription.getParameters().get(((Integer)param1Loadable.getValue(VALUE).resolve(Integer.class)).intValue())).getType(), param1ParameterDescription
/* 210 */           .getType(), ((Integer)param1Loadable
/* 211 */           .getValue(VALUE).resolve(Integer.class)).intValue(), param1Assigner, param1Typing, ((ParameterDescription)param1MethodDescription
/*     */ 
/*     */           
/* 214 */           .getParameters().get(((Integer)param1Loadable.getValue(VALUE).resolve(Integer.class)).intValue())).getOffset());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\Argument.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */