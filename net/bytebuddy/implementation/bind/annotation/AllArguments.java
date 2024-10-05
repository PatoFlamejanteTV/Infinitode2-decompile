/*     */ package net.bytebuddy.implementation.bind.annotation;
/*     */ 
/*     */ import java.lang.annotation.Documented;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.method.ParameterDescription;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bind.MethodDelegationBinder;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*     */ import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
/*     */ import net.bytebuddy.implementation.bytecode.constant.NullConstant;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ import net.bytebuddy.utility.CompoundList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public @interface AllArguments
/*     */ {
/*     */   Assignment value() default Assignment.STRICT;
/*     */   
/*     */   boolean includeSelf() default false;
/*     */   
/*     */   boolean nullIfEmpty() default false;
/*     */   
/*     */   public enum Assignment
/*     */   {
/* 103 */     STRICT(true),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     SLACK(false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final boolean strict;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Assignment(boolean param1Boolean) {
/* 124 */       this.strict = param1Boolean;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final boolean isStrict() {
/* 133 */       return this.strict;
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
/*     */   public enum Binder
/*     */     implements TargetMethodAnnotationDrivenBinder.ParameterBinder<AllArguments>
/*     */   {
/* 149 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape NULL_IF_EMPTY;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape INCLUDE_SELF;
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
/* 171 */       VALUE = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(AllArguments.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("value"))).getOnly();
/* 172 */       INCLUDE_SELF = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("includeSelf"))).getOnly();
/* 173 */       NULL_IF_EMPTY = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("nullIfEmpty"))).getOnly();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Class<AllArguments> getHandledType() {
/* 180 */       return AllArguments.class;
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
/*     */     public final MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<AllArguments> param1Loadable, MethodDescription param1MethodDescription, ParameterDescription param1ParameterDescription, Implementation.Target param1Target, Assigner param1Assigner, Assigner.Typing param1Typing) {
/*     */       TypeDescription.Generic generic;
/* 193 */       if (param1ParameterDescription.getType().represents(Object.class)) {
/* 194 */         generic = TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class);
/* 195 */       } else if (generic.getType().isArray()) {
/* 196 */         generic = generic.getType().getComponentType();
/*     */       } else {
/* 198 */         throw new IllegalStateException("Expected an array type for all argument annotation on " + param1MethodDescription);
/*     */       } 
/*     */       boolean bool;
/* 201 */       if (!(bool = (!param1MethodDescription.isStatic() && ((Boolean)param1Loadable.getValue(INCLUDE_SELF).resolve(Boolean.class)).booleanValue()) ? true : false) && param1MethodDescription.getParameters().isEmpty() && ((Boolean)param1Loadable.getValue(NULL_IF_EMPTY).resolve(Boolean.class)).booleanValue()) {
/* 202 */         return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous((StackManipulation)NullConstant.INSTANCE);
/*     */       }
/* 204 */       ArrayList<StackManipulation.Compound> arrayList = new ArrayList(param1MethodDescription.getParameters().size() + (bool ? 1 : 0));
/* 205 */       int i = (param1MethodDescription.isStatic() || bool) ? 0 : 1;
/* 206 */       for (TypeDescription.Generic generic1 : bool ? 
/* 207 */         (Object<?>)CompoundList.of(param1Target.getInstrumentedType().asGenericType(), (List)param1MethodDescription.getParameters().asTypeList()) : (Object<?>)param1MethodDescription
/* 208 */         .getParameters().asTypeList()) {
/*     */         StackManipulation.Compound compound;
/*     */ 
/*     */ 
/*     */         
/* 213 */         if ((compound = new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.of((TypeDefinition)generic1).loadFrom(i), param1Assigner.assign(generic1, generic, param1Typing) })).isValid()) {
/* 214 */           arrayList.add(compound);
/* 215 */         } else if (((AllArguments.Assignment)param1Loadable.getValue(VALUE).load(AllArguments.class.getClassLoader()).resolve(AllArguments.Assignment.class)).isStrict()) {
/* 216 */           return (MethodDelegationBinder.ParameterBinding<?>)MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
/*     */         } 
/* 218 */         i += generic1.getStackSize().getSize();
/*     */       } 
/* 220 */       return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous(ArrayFactory.forType(generic).withValues(arrayList));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\AllArguments.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */