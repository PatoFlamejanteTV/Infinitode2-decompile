/*     */ package net.bytebuddy.build;
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
/*     */ import net.bytebuddy.dynamic.ClassFileLocator;
/*     */ import net.bytebuddy.dynamic.DynamicType;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.ToStringMethod;
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
/*     */ @Enhance
/*     */ public class ToStringPlugin
/*     */   implements Plugin, Plugin.Factory
/*     */ {
/*     */   private static final MethodDescription.InDefinedShape ENHANCE_PREFIX;
/*     */   private static final MethodDescription.InDefinedShape ENHANCE_INCLUDE_SYNTHETIC_FIELDS;
/*     */   
/*     */   static {
/*     */     MethodList methodList;
/*  55 */     ENHANCE_PREFIX = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Enhance.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("prefix"))).getOnly();
/*  56 */     ENHANCE_INCLUDE_SYNTHETIC_FIELDS = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("includeSyntheticFields"))).getOnly();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Plugin make() {
/*  63 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(@MaybeNull TypeDescription paramTypeDescription) {
/*  70 */     return (paramTypeDescription != null && paramTypeDescription.getDeclaredAnnotations().isAnnotationPresent(Enhance.class));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder<?> apply(DynamicType.Builder<?> paramBuilder, TypeDescription paramTypeDescription, ClassFileLocator paramClassFileLocator) {
/*     */     DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition receiverTypeDefinition;
/*  77 */     AnnotationDescription.Loadable loadable = paramTypeDescription.getDeclaredAnnotations().ofType(Enhance.class);
/*  78 */     if (((MethodList)paramTypeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isToString())).isEmpty()) {
/*  79 */       receiverTypeDefinition = paramBuilder.method((ElementMatcher)ElementMatchers.isToString()).intercept((Implementation)ToStringMethod.prefixedBy((ToStringMethod.PrefixResolver)((Enhance.Prefix)loadable.getValue(ENHANCE_PREFIX)
/*  80 */             .load(Enhance.class.getClassLoader())
/*  81 */             .resolve(Enhance.Prefix.class))
/*  82 */             .getPrefixResolver())
/*  83 */           .withIgnoredFields(((Boolean)loadable.getValue(ENHANCE_INCLUDE_SYNTHETIC_FIELDS).resolve(Boolean.class)).booleanValue() ? 
/*  84 */             (ElementMatcher)ElementMatchers.none() : 
/*  85 */             (ElementMatcher)ElementMatchers.isSynthetic())
/*  86 */           .withIgnoredFields((ElementMatcher)ElementMatchers.isAnnotatedWith(Exclude.class)));
/*     */     }
/*  88 */     return (DynamicType.Builder<?>)receiverTypeDefinition;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : (!(getClass() != paramObject.getClass())));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Documented
/*     */   @Target({ElementType.FIELD})
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   public static @interface Exclude {}
/*     */ 
/*     */ 
/*     */   
/*     */   @Documented
/*     */   @Target({ElementType.TYPE})
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   public static @interface Enhance
/*     */   {
/*     */     Prefix prefix() default Prefix.SIMPLE;
/*     */ 
/*     */     
/*     */     boolean includeSyntheticFields() default false;
/*     */ 
/*     */     
/*     */     public enum Prefix
/*     */     {
/* 129 */       FULLY_QUALIFIED((String)ToStringMethod.PrefixResolver.Default.FULLY_QUALIFIED_CLASS_NAME),
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 134 */       CANONICAL((String)ToStringMethod.PrefixResolver.Default.CANONICAL_CLASS_NAME),
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 139 */       SIMPLE((String)ToStringMethod.PrefixResolver.Default.SIMPLE_CLASS_NAME);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final ToStringMethod.PrefixResolver.Default prefixResolver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       Prefix(ToStringMethod.PrefixResolver.Default param2Default) {
/* 152 */         this.prefixResolver = param2Default;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected final ToStringMethod.PrefixResolver.Default getPrefixResolver()
/*     */       {
/* 161 */         return this.prefixResolver; } } } public enum Prefix { protected final ToStringMethod.PrefixResolver.Default getPrefixResolver() { return this.prefixResolver; }
/*     */ 
/*     */     
/*     */     FULLY_QUALIFIED((String)ToStringMethod.PrefixResolver.Default.FULLY_QUALIFIED_CLASS_NAME),
/*     */     CANONICAL((String)ToStringMethod.PrefixResolver.Default.CANONICAL_CLASS_NAME),
/*     */     SIMPLE((String)ToStringMethod.PrefixResolver.Default.SIMPLE_CLASS_NAME);
/*     */     private final ToStringMethod.PrefixResolver.Default prefixResolver;
/*     */     
/*     */     Prefix(ToStringMethod.PrefixResolver.Default param1Default) {
/*     */       this.prefixResolver = param1Default;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\build\ToStringPlugin.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */