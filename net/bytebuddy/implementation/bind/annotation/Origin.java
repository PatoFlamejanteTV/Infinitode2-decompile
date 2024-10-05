/*     */ package net.bytebuddy.implementation.bind.annotation;
/*     */ 
/*     */ import java.lang.annotation.Documented;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.method.ParameterDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bind.MethodDelegationBinder;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*     */ import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.JavaConstantValue;
/*     */ import net.bytebuddy.implementation.bytecode.constant.MethodConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.TextConstant;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ import net.bytebuddy.utility.JavaConstant;
/*     */ import net.bytebuddy.utility.JavaType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public @interface Origin
/*     */ {
/*     */   boolean cache() default true;
/*     */   
/*     */   boolean privileged() default false;
/*     */   
/*     */   public enum Binder
/*     */     implements TargetMethodAnnotationDrivenBinder.ParameterBinder<Origin>
/*     */   {
/* 113 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape PRIVILEGED;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape CACHE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */       MethodList methodList;
/* 130 */       CACHE = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Origin.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("cache"))).getOnly();
/* 131 */       PRIVILEGED = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("privileged"))).getOnly();
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
/*     */     private static StackManipulation methodConstant(AnnotationDescription.Loadable<Origin> param1Loadable, MethodDescription.InDefinedShape param1InDefinedShape) {
/* 144 */       MethodConstant.CanCache canCache = ((Boolean)param1Loadable.getValue(PRIVILEGED).resolve(Boolean.class)).booleanValue() ? MethodConstant.ofPrivileged(param1InDefinedShape) : MethodConstant.of(param1InDefinedShape);
/* 145 */       if (((Boolean)param1Loadable.getValue(CACHE).resolve(Boolean.class)).booleanValue())
/* 146 */         return canCache.cached();  return (StackManipulation)canCache;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Class<Origin> getHandledType() {
/* 154 */       return Origin.class;
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
/*     */     public final MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<Origin> param1Loadable, MethodDescription param1MethodDescription, ParameterDescription param1ParameterDescription, Implementation.Target param1Target, Assigner param1Assigner, Assigner.Typing param1Typing) {
/*     */       TypeDescription typeDescription;
/* 167 */       if ((typeDescription = param1ParameterDescription.getType().asErasure()).represents(Class.class))
/* 168 */         return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous(ClassConstant.of(param1Target.getOriginType().asErasure())); 
/* 169 */       if (typeDescription.represents(Method.class)) {
/* 170 */         return (MethodDelegationBinder.ParameterBinding<?>)(param1MethodDescription.isMethod() ? new MethodDelegationBinder.ParameterBinding.Anonymous(
/* 171 */             methodConstant(param1Loadable, (MethodDescription.InDefinedShape)param1MethodDescription.asDefined())) : MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE);
/*     */       }
/* 173 */       if (typeDescription.represents(Constructor.class)) {
/* 174 */         return (MethodDelegationBinder.ParameterBinding<?>)(param1MethodDescription.isConstructor() ? new MethodDelegationBinder.ParameterBinding.Anonymous(
/* 175 */             methodConstant(param1Loadable, (MethodDescription.InDefinedShape)param1MethodDescription.asDefined())) : MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE);
/*     */       }
/* 177 */       if (JavaType.EXECUTABLE.getTypeStub().equals(typeDescription))
/* 178 */         return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous(methodConstant(param1Loadable, (MethodDescription.InDefinedShape)param1MethodDescription.asDefined())); 
/* 179 */       if (typeDescription.represents(String.class))
/* 180 */         return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous((StackManipulation)new TextConstant(param1MethodDescription.toString())); 
/* 181 */       if (typeDescription.represents(int.class))
/* 182 */         return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous(IntegerConstant.forValue(param1MethodDescription.getModifiers())); 
/* 183 */       if (typeDescription.equals(JavaType.METHOD_HANDLE.getTypeStub()))
/* 184 */         return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous((StackManipulation)new JavaConstantValue((JavaConstant)JavaConstant.MethodHandle.of((MethodDescription.InDefinedShape)param1MethodDescription.asDefined()))); 
/* 185 */       if (typeDescription.equals(JavaType.METHOD_TYPE.getTypeStub()))
/* 186 */         return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous((StackManipulation)new JavaConstantValue((JavaConstant)JavaConstant.MethodType.of((MethodDescription)param1MethodDescription.asDefined()))); 
/* 187 */       if (typeDescription.equals(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub())) {
/* 188 */         return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous(MethodInvocation.lookup());
/*     */       }
/* 190 */       throw new IllegalStateException("The " + param1ParameterDescription + " method's " + param1ParameterDescription.getIndex() + " parameter is annotated with a Origin annotation with an argument not representing a Class, Method, Constructor, String, int, MethodType or MethodHandle type");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\Origin.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */