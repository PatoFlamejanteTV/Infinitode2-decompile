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
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.bind.MethodDelegationBinder;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Documented
/*     */ @Retention(RetentionPolicy.RUNTIME)
/*     */ @Target({ElementType.METHOD})
/*     */ public @interface BindingPriority
/*     */ {
/*     */   public static final int DEFAULT = 1;
/*     */   
/*     */   int value();
/*     */   
/*     */   public enum Resolver
/*     */     implements MethodDelegationBinder.AmbiguityResolver
/*     */   {
/*  65 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     private static final MethodDescription.InDefinedShape VALUE = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(BindingPriority.class)
/*  71 */       .getDeclaredMethods()
/*  72 */       .filter((ElementMatcher)ElementMatchers.named("value")))
/*  73 */       .getOnly();
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */     
/*     */     }
/*     */ 
/*     */     
/*     */     private static int resolve(@MaybeNull AnnotationDescription.Loadable<BindingPriority> param1Loadable) {
/*  83 */       return (param1Loadable == null) ? 1 : ((Integer)param1Loadable
/*     */         
/*  85 */         .getValue(VALUE).resolve(Integer.class)).intValue();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final MethodDelegationBinder.AmbiguityResolver.Resolution resolve(MethodDescription param1MethodDescription, MethodDelegationBinder.MethodBinding param1MethodBinding1, MethodDelegationBinder.MethodBinding param1MethodBinding2) {
/*  94 */       int i = resolve(param1MethodBinding1.getTarget().getDeclaredAnnotations().ofType(BindingPriority.class));
/*  95 */       int j = resolve(param1MethodBinding2.getTarget().getDeclaredAnnotations().ofType(BindingPriority.class));
/*  96 */       if (i == j)
/*  97 */         return MethodDelegationBinder.AmbiguityResolver.Resolution.AMBIGUOUS; 
/*  98 */       if (i < j) {
/*  99 */         return MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT;
/*     */       }
/* 101 */       return MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\BindingPriority.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */