/*     */ package net.bytebuddy.build;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.lang.annotation.Documented;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.util.Comparator;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.ClassFileLocator;
/*     */ import net.bytebuddy.dynamic.DynamicType;
/*     */ import net.bytebuddy.implementation.EqualsMethod;
/*     */ import net.bytebuddy.implementation.HashCodeMethod;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
/*     */ import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
/*     */ import net.bytebuddy.jar.asm.AnnotationVisitor;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class HashCodeAndEqualsPlugin
/*     */   implements Plugin, Plugin.Factory, MethodAttributeAppender, MethodAttributeAppender.Factory
/*     */ {
/*     */   private static final MethodDescription.InDefinedShape ENHANCE_INVOKE_SUPER;
/*     */   private static final MethodDescription.InDefinedShape ENHANCE_SIMPLE_COMPARISON_FIRST;
/*     */   private static final MethodDescription.InDefinedShape ENHANCE_INCLUDE_SYNTHETIC_FIELDS;
/*     */   private static final MethodDescription.InDefinedShape ENHANCE_PERMIT_SUBCLASS_EQUALITY;
/*     */   private static final MethodDescription.InDefinedShape ENHANCE_USE_TYPE_HASH_CONSTANT;
/*     */   
/*     */   static {
/*     */     MethodList methodList;
/*  89 */     ENHANCE_INVOKE_SUPER = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Enhance.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("invokeSuper"))).getOnly();
/*  90 */     ENHANCE_SIMPLE_COMPARISON_FIRST = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("simpleComparisonsFirst"))).getOnly();
/*  91 */     ENHANCE_INCLUDE_SYNTHETIC_FIELDS = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("includeSyntheticFields"))).getOnly();
/*  92 */     ENHANCE_PERMIT_SUBCLASS_EQUALITY = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("permitSubclassEquality"))).getOnly();
/*  93 */     ENHANCE_USE_TYPE_HASH_CONSTANT = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("useTypeHashConstant"))).getOnly();
/*  94 */   } private static final MethodDescription.InDefinedShape VALUE_HANDLING_VALUE = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(ValueHandling.class).getDeclaredMethods().filter((ElementMatcher)ElementMatchers.named("value"))).getOnly();
/*  95 */   private static final MethodDescription.InDefinedShape SORTED_VALUE = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(Sorted.class).getDeclaredMethods().filter((ElementMatcher)ElementMatchers.named("value"))).getOnly();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @MaybeNull
/*     */   @ValueHandling(ValueHandling.Sort.REVERSE_NULLABILITY)
/*     */   private final String annotationType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HashCodeAndEqualsPlugin() {
/* 110 */     this(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HashCodeAndEqualsPlugin(@MaybeNull String paramString) {
/* 121 */     this.annotationType = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Plugin make() {
/* 128 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(@MaybeNull TypeDescription paramTypeDescription) {
/* 135 */     return (paramTypeDescription != null && paramTypeDescription.getDeclaredAnnotations().isAnnotationPresent(Enhance.class));
/*     */   }
/*     */ 
/*     */   
/*     */   @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Annotation presence is required by matcher.")
/*     */   public DynamicType.Builder<?> apply(DynamicType.Builder<?> paramBuilder, TypeDescription paramTypeDescription, ClassFileLocator paramClassFileLocator) {
/*     */     DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition receiverTypeDefinition;
/*     */     DynamicType.Builder.MethodDefinition methodDefinition;
/* 143 */     AnnotationDescription.Loadable loadable = paramTypeDescription.getDeclaredAnnotations().ofType(Enhance.class);
/* 144 */     if (((MethodList)paramTypeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isHashCode())).isEmpty()) {
/* 145 */       receiverTypeDefinition = paramBuilder.method((ElementMatcher)ElementMatchers.isHashCode()).intercept((Implementation)((Enhance.InvokeSuper)loadable.getValue(ENHANCE_INVOKE_SUPER).load(Enhance.class.getClassLoader()).resolve(Enhance.InvokeSuper.class))
/* 146 */           .hashCodeMethod(paramTypeDescription, ((Boolean)loadable
/* 147 */             .getValue(ENHANCE_USE_TYPE_HASH_CONSTANT).resolve(Boolean.class)).booleanValue(), ((Boolean)loadable
/* 148 */             .getValue(ENHANCE_PERMIT_SUBCLASS_EQUALITY).resolve(Boolean.class)).booleanValue())
/* 149 */           .withIgnoredFields(((Boolean)loadable.getValue(ENHANCE_INCLUDE_SYNTHETIC_FIELDS).resolve(Boolean.class)).booleanValue() ? 
/* 150 */             (ElementMatcher)ElementMatchers.none() : 
/* 151 */             (ElementMatcher)ElementMatchers.isSynthetic())
/* 152 */           .withIgnoredFields((ElementMatcher)new ValueMatcher(ValueHandling.Sort.IGNORE))
/* 153 */           .withNonNullableFields(nonNullable((ElementMatcher<FieldDescription>)new ValueMatcher(ValueHandling.Sort.REVERSE_NULLABILITY))));
/*     */     }
/* 155 */     if (((MethodList)paramTypeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isEquals())).isEmpty()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 163 */       EqualsMethod equalsMethod = ((Enhance.InvokeSuper)loadable.getValue(ENHANCE_INVOKE_SUPER).load(Enhance.class.getClassLoader()).resolve(Enhance.InvokeSuper.class)).equalsMethod(paramTypeDescription).withIgnoredFields(((Boolean)loadable.getValue(ENHANCE_INCLUDE_SYNTHETIC_FIELDS).resolve(Boolean.class)).booleanValue() ? (ElementMatcher)ElementMatchers.none() : (ElementMatcher)ElementMatchers.isSynthetic()).withIgnoredFields((ElementMatcher)new ValueMatcher(ValueHandling.Sort.IGNORE)).withNonNullableFields(nonNullable((ElementMatcher<FieldDescription>)new ValueMatcher(ValueHandling.Sort.REVERSE_NULLABILITY))).withFieldOrder(AnnotationOrderComparator.INSTANCE);
/* 164 */       if (((Boolean)loadable.getValue(ENHANCE_SIMPLE_COMPARISON_FIRST).resolve(Boolean.class)).booleanValue())
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 169 */         equalsMethod = equalsMethod.withPrimitiveTypedFieldsFirst().withEnumerationTypedFieldsFirst().withPrimitiveWrapperTypedFieldsFirst().withStringTypedFieldsFirst();
/*     */       }
/*     */ 
/*     */       
/* 173 */       methodDefinition = receiverTypeDefinition.method((ElementMatcher)ElementMatchers.isEquals()).intercept(((Boolean)loadable.getValue(ENHANCE_PERMIT_SUBCLASS_EQUALITY).resolve(Boolean.class)).booleanValue() ? equalsMethod.withSubclassEquality() : (Implementation)equalsMethod).attribute(this);
/*     */     } 
/* 175 */     return (DynamicType.Builder<?>)methodDefinition;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ElementMatcher<FieldDescription> nonNullable(ElementMatcher<FieldDescription> paramElementMatcher) {
/* 185 */     return paramElementMatcher;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MethodAttributeAppender make(TypeDescription paramTypeDescription) {
/* 199 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void apply(MethodVisitor paramMethodVisitor, MethodDescription paramMethodDescription, AnnotationValueFilter paramAnnotationValueFilter) {
/* 206 */     if (this.annotationType != null) {
/*     */       AnnotationVisitor annotationVisitor;
/*     */ 
/*     */       
/* 210 */       if ((annotationVisitor = paramMethodVisitor.visitParameterAnnotation(0, "L" + this.annotationType.replace('.', '/') + ";", true)) != null)
/* 211 */         annotationVisitor.visitEnd(); 
/*     */     } 
/*     */   } public boolean equals(@MaybeNull Object paramObject) { String str; if (this == paramObject)
/*     */       return true;  if (paramObject == null)
/*     */       return false;  if (getClass() != paramObject.getClass())
/*     */       return false;  paramObject = ((HashCodeAndEqualsPlugin)paramObject).annotationType; if (paramObject != null) {
/*     */       if ((str = this.annotationType) != null) {
/*     */         if (!str.equals(paramObject))
/*     */           return false; 
/*     */       } else {
/*     */         return false;
/*     */       } 
/*     */     } else if ((str = this.annotationType) != null) {
/*     */       return false;
/*     */     }  return true; } public int hashCode() { String str; if ((str = this.annotationType) != null); return getClass().hashCode() * 31 + str.hashCode(); }
/* 226 */   @Enhance public static class WithNonNullableFields extends HashCodeAndEqualsPlugin { public WithNonNullableFields() { this(null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WithNonNullableFields(@MaybeNull String param1String) {
/* 237 */       super(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ElementMatcher<FieldDescription> nonNullable(ElementMatcher<FieldDescription> param1ElementMatcher) {
/* 244 */       return (ElementMatcher<FieldDescription>)ElementMatchers.not(param1ElementMatcher);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return !super.equals(param1Object) ? false : ((this == param1Object) ? true : ((param1Object == null) ? false : (!(getClass() != param1Object.getClass()))));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return super.hashCode();
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Documented
/*     */   @Target({ElementType.TYPE})
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   public static @interface Enhance
/*     */   {
/*     */     InvokeSuper invokeSuper() default InvokeSuper.IF_DECLARED;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean simpleComparisonsFirst() default true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean includeSyntheticFields() default false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean permitSubclassEquality() default false;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean useTypeHashConstant() default true;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public enum InvokeSuper
/*     */     {
/* 303 */       IF_DECLARED
/*     */       {
/*     */         protected final HashCodeMethod hashCodeMethod(TypeDescription param3TypeDescription, boolean param3Boolean1, boolean param3Boolean2) {
/* 306 */           TypeDescription.Generic generic = param3TypeDescription.getSuperClass();
/* 307 */           while (generic != null && !generic.represents(Object.class)) {
/* 308 */             if (generic.asErasure().getDeclaredAnnotations().isAnnotationPresent(HashCodeAndEqualsPlugin.Enhance.class)) {
/* 309 */               return HashCodeMethod.usingSuperClassOffset();
/*     */             }
/*     */             MethodList methodList;
/* 312 */             if (!(methodList = (MethodList)generic.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isHashCode())).isEmpty()) {
/* 313 */               if (((MethodDescription)methodList.getOnly()).isAbstract()) { if (param3Boolean1)
/* 314 */                   return HashCodeMethod.usingTypeHashOffset(!param3Boolean2);  return HashCodeMethod.usingDefaultOffset(); }
/* 315 */                return HashCodeMethod.usingSuperClassOffset();
/*     */             } 
/* 317 */             generic = generic.getSuperClass();
/*     */           } 
/* 319 */           return param3Boolean1 ? HashCodeMethod.usingTypeHashOffset(!param3Boolean2) : HashCodeMethod.usingDefaultOffset();
/*     */         }
/*     */ 
/*     */         
/*     */         protected final EqualsMethod equalsMethod(TypeDescription param3TypeDescription) {
/* 324 */           TypeDescription.Generic generic = param3TypeDescription.getSuperClass();
/* 325 */           while (generic != null && !generic.represents(Object.class)) {
/* 326 */             if (generic.asErasure().getDeclaredAnnotations().isAnnotationPresent(HashCodeAndEqualsPlugin.Enhance.class)) {
/* 327 */               return EqualsMethod.requiringSuperClassEquality();
/*     */             }
/*     */             MethodList methodList;
/* 330 */             if (!(methodList = (MethodList)generic.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isHashCode())).isEmpty()) {
/* 331 */               if (((MethodDescription)methodList.getOnly()).isAbstract())
/* 332 */                 return EqualsMethod.isolated(); 
/* 333 */               return EqualsMethod.requiringSuperClassEquality();
/*     */             } 
/* 335 */             generic = generic.getSuperClass();
/*     */           } 
/* 337 */           return EqualsMethod.isolated();
/*     */         }
/*     */       },
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 344 */       IF_ANNOTATED
/*     */       {
/*     */         protected final HashCodeMethod hashCodeMethod(TypeDescription param3TypeDescription, boolean param3Boolean1, boolean param3Boolean2) {
/*     */           TypeDescription.Generic generic;
/* 348 */           if ((generic = param3TypeDescription.getSuperClass()) != null && generic.asErasure().getDeclaredAnnotations().isAnnotationPresent(HashCodeAndEqualsPlugin.Enhance.class))
/* 349 */             return HashCodeMethod.usingSuperClassOffset();  if (param3Boolean1)
/* 350 */             return HashCodeMethod.usingTypeHashOffset(!param3Boolean2);  return HashCodeMethod.usingDefaultOffset();
/*     */         }
/*     */ 
/*     */         
/*     */         protected final EqualsMethod equalsMethod(TypeDescription param3TypeDescription) {
/*     */           TypeDescription.Generic generic;
/* 356 */           if ((generic = param3TypeDescription.getSuperClass()) != null && generic.asErasure().getDeclaredAnnotations().isAnnotationPresent(HashCodeAndEqualsPlugin.Enhance.class))
/* 357 */             return EqualsMethod.requiringSuperClassEquality(); 
/* 358 */           return EqualsMethod.isolated();
/*     */         }
/*     */       },
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 365 */       ALWAYS
/*     */       {
/*     */         protected final HashCodeMethod hashCodeMethod(TypeDescription param3TypeDescription, boolean param3Boolean1, boolean param3Boolean2) {
/* 368 */           return HashCodeMethod.usingSuperClassOffset();
/*     */         }
/*     */ 
/*     */         
/*     */         protected final EqualsMethod equalsMethod(TypeDescription param3TypeDescription) {
/* 373 */           return EqualsMethod.requiringSuperClassEquality();
/*     */         }
/*     */       },
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 380 */       NEVER
/*     */       {
/*     */         protected final HashCodeMethod hashCodeMethod(TypeDescription param3TypeDescription, boolean param3Boolean1, boolean param3Boolean2) {
/* 383 */           return param3Boolean1 ? HashCodeMethod.usingTypeHashOffset(!param3Boolean2) : HashCodeMethod.usingDefaultOffset();
/*     */         }
/*     */         
/*     */         protected final EqualsMethod equalsMethod(TypeDescription param3TypeDescription)
/*     */         {
/* 388 */           return EqualsMethod.isolated(); } }; protected abstract HashCodeMethod hashCodeMethod(TypeDescription param2TypeDescription, boolean param2Boolean1, boolean param2Boolean2); protected abstract EqualsMethod equalsMethod(TypeDescription param2TypeDescription); } } public enum InvokeSuper { IF_DECLARED { protected final HashCodeMethod hashCodeMethod(TypeDescription param3TypeDescription, boolean param3Boolean1, boolean param3Boolean2) { TypeDescription.Generic generic = param3TypeDescription.getSuperClass(); while (generic != null && !generic.represents(Object.class)) { if (generic.asErasure().getDeclaredAnnotations().isAnnotationPresent(HashCodeAndEqualsPlugin.Enhance.class)) return HashCodeMethod.usingSuperClassOffset();  MethodList methodList; if (!(methodList = (MethodList)generic.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isHashCode())).isEmpty()) { if (((MethodDescription)methodList.getOnly()).isAbstract()) { if (param3Boolean1) return HashCodeMethod.usingTypeHashOffset(!param3Boolean2);  return HashCodeMethod.usingDefaultOffset(); }  return HashCodeMethod.usingSuperClassOffset(); }  generic = generic.getSuperClass(); }  return param3Boolean1 ? HashCodeMethod.usingTypeHashOffset(!param3Boolean2) : HashCodeMethod.usingDefaultOffset(); } protected final EqualsMethod equalsMethod(TypeDescription param3TypeDescription) { TypeDescription.Generic generic = param3TypeDescription.getSuperClass(); while (generic != null && !generic.represents(Object.class)) { if (generic.asErasure().getDeclaredAnnotations().isAnnotationPresent(HashCodeAndEqualsPlugin.Enhance.class)) return EqualsMethod.requiringSuperClassEquality();  MethodList methodList; if (!(methodList = (MethodList)generic.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isHashCode())).isEmpty()) { if (((MethodDescription)methodList.getOnly()).isAbstract()) return EqualsMethod.isolated();  return EqualsMethod.requiringSuperClassEquality(); }  generic = generic.getSuperClass(); }  return EqualsMethod.isolated(); } }, IF_ANNOTATED { protected final HashCodeMethod hashCodeMethod(TypeDescription param3TypeDescription, boolean param3Boolean1, boolean param3Boolean2) { TypeDescription.Generic generic; if ((generic = param3TypeDescription.getSuperClass()) != null && generic.asErasure().getDeclaredAnnotations().isAnnotationPresent(HashCodeAndEqualsPlugin.Enhance.class)) return HashCodeMethod.usingSuperClassOffset();  if (param3Boolean1) return HashCodeMethod.usingTypeHashOffset(!param3Boolean2);  return HashCodeMethod.usingDefaultOffset(); } protected final EqualsMethod equalsMethod(TypeDescription param3TypeDescription) { TypeDescription.Generic generic; if ((generic = param3TypeDescription.getSuperClass()) != null && generic.asErasure().getDeclaredAnnotations().isAnnotationPresent(HashCodeAndEqualsPlugin.Enhance.class)) return EqualsMethod.requiringSuperClassEquality();  return EqualsMethod.isolated(); } protected final EqualsMethod equalsMethod(TypeDescription param3TypeDescription) { return EqualsMethod.isolated(); }
/*     */        }
/*     */     ,
/*     */     ALWAYS
/*     */     {
/*     */       protected final HashCodeMethod hashCodeMethod(TypeDescription param3TypeDescription, boolean param3Boolean1, boolean param3Boolean2) {
/*     */         return HashCodeMethod.usingSuperClassOffset();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected final EqualsMethod equalsMethod(TypeDescription param3TypeDescription) {
/*     */         return EqualsMethod.requiringSuperClassEquality();
/*     */       }
/*     */     },
/*     */     NEVER
/*     */     {
/*     */       protected final HashCodeMethod hashCodeMethod(TypeDescription param3TypeDescription, boolean param3Boolean1, boolean param3Boolean2) {
/*     */         return param3Boolean1 ? HashCodeMethod.usingTypeHashOffset(!param3Boolean2) : HashCodeMethod.usingDefaultOffset();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract HashCodeMethod hashCodeMethod(TypeDescription param1TypeDescription, boolean param1Boolean1, boolean param1Boolean2);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract EqualsMethod equalsMethod(TypeDescription param1TypeDescription); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Documented
/*     */   @Target({ElementType.FIELD})
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   public static @interface ValueHandling
/*     */   {
/*     */     Sort value();
/*     */ 
/*     */ 
/*     */     
/*     */     public enum Sort
/*     */     {
/* 435 */       IGNORE,
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 440 */       REVERSE_NULLABILITY; } } public enum Sort { IGNORE, REVERSE_NULLABILITY; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected enum AnnotationOrderComparator
/*     */     implements Comparator<FieldDescription.InDefinedShape>
/*     */   {
/* 476 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int compare(FieldDescription.InDefinedShape param1InDefinedShape1, FieldDescription.InDefinedShape param1InDefinedShape2) {
/* 482 */       AnnotationDescription.Loadable loadable1 = param1InDefinedShape1.getDeclaredAnnotations().ofType(HashCodeAndEqualsPlugin.Sorted.class);
/* 483 */       AnnotationDescription.Loadable loadable2 = param1InDefinedShape2.getDeclaredAnnotations().ofType(HashCodeAndEqualsPlugin.Sorted.class);
/* 484 */       byte b1 = (loadable1 == null) ? 0 : ((Integer)loadable1.getValue(HashCodeAndEqualsPlugin.a()).resolve(Integer.class)).intValue();
/* 485 */       byte b2 = (loadable2 == null) ? 0 : ((Integer)loadable2.getValue(HashCodeAndEqualsPlugin.a()).resolve(Integer.class)).intValue();
/* 486 */       if (b1 > b2)
/* 487 */         return -1; 
/* 488 */       if (b1 < b2) {
/* 489 */         return 1;
/*     */       }
/* 491 */       return 0;
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
/*     */   protected static class ValueMatcher
/*     */     extends ElementMatcher.Junction.ForNonNullValues<FieldDescription>
/*     */   {
/*     */     private final HashCodeAndEqualsPlugin.ValueHandling.Sort sort;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ValueMatcher(HashCodeAndEqualsPlugin.ValueHandling.Sort param1Sort) {
/* 513 */       this.sort = param1Sort;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean doMatch(FieldDescription param1FieldDescription) {
/*     */       AnnotationDescription.Loadable loadable;
/* 521 */       if ((loadable = param1FieldDescription.getDeclaredAnnotations().ofType(HashCodeAndEqualsPlugin.ValueHandling.class)) != null && loadable.getValue(HashCodeAndEqualsPlugin.b()).load(HashCodeAndEqualsPlugin.ValueHandling.class.getClassLoader()).resolve(HashCodeAndEqualsPlugin.ValueHandling.Sort.class) == this.sort) return true;  return false;
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return !super.equals(param1Object) ? false : ((this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.sort.equals(((ValueMatcher)param1Object).sort)))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return super.hashCode() * 31 + this.sort.hashCode();
/*     */     }
/*     */   }
/*     */   
/*     */   @Documented
/*     */   @Target({ElementType.FIELD})
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   public static @interface Sorted {
/*     */     public static final int DEFAULT = 0;
/*     */     
/*     */     int value();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\build\HashCodeAndEqualsPlugin.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */