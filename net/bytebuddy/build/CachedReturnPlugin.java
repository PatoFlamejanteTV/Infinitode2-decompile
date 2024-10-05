/*     */ package net.bytebuddy.build;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.lang.annotation.Documented;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import net.bytebuddy.asm.Advice;
/*     */ import net.bytebuddy.asm.AsmVisitorWrapper;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.field.FieldList;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.modifier.FieldPersistence;
/*     */ import net.bytebuddy.description.modifier.ModifierContributor;
/*     */ import net.bytebuddy.description.modifier.Ownership;
/*     */ import net.bytebuddy.description.modifier.SyntheticState;
/*     */ import net.bytebuddy.description.modifier.Visibility;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.ClassFileLocator;
/*     */ import net.bytebuddy.dynamic.DynamicType;
/*     */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ import net.bytebuddy.pool.TypePool;
/*     */ import net.bytebuddy.utility.RandomString;
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
/*     */ @Enhance
/*     */ public class CachedReturnPlugin
/*     */   extends Plugin.ForElementMatcher
/*     */   implements Plugin.Factory
/*     */ {
/*     */   private static final String NAME_INFIX = "_";
/*     */   private static final String ADVICE_INFIX = "$Advice$";
/*  62 */   private static final MethodDescription.InDefinedShape ENHANCE_VALUE = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(Enhance.class)
/*  63 */     .getDeclaredMethods()
/*  64 */     .filter((ElementMatcher)ElementMatchers.named("value")))
/*  65 */     .getOnly();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean ignoreExistingFields;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
/*     */   private final RandomString randomString;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ClassFileLocator classFileLocator;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
/*     */   private final Map<TypeDescription, TypeDescription> adviceByType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CachedReturnPlugin() {
/*  97 */     this(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CachedReturnPlugin(boolean paramBoolean) {
/* 106 */     super((ElementMatcher<? super TypeDescription>)ElementMatchers.declaresMethod((ElementMatcher)ElementMatchers.isAnnotatedWith(Enhance.class)));
/* 107 */     this.ignoreExistingFields = paramBoolean;
/* 108 */     this.randomString = new RandomString();
/* 109 */     this.classFileLocator = ClassFileLocator.ForClassLoader.of(CachedReturnPlugin.class.getClassLoader());
/* 110 */     TypePool typePool = TypePool.Default.of(this.classFileLocator);
/* 111 */     this.adviceByType = new HashMap<TypeDescription, TypeDescription>(); Class[] arrayOfClass; byte b;
/* 112 */     for (arrayOfClass = new Class[] { boolean.class, byte.class, short.class, char.class, int.class, long.class, float.class, double.class, Object.class }, b = 0; b < 9; ) { Class clazz = arrayOfClass[b];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 123 */       this.adviceByType.put(TypeDescription.ForLoadedType.of(clazz), typePool.describe(CachedReturnPlugin.class.getName() + "$Advice$" + clazz
/*     */             
/* 125 */             .getSimpleName()).resolve());
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Plugin make() {
/* 133 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Annotation presence is required by matcher.")
/*     */   public DynamicType.Builder<?> apply(DynamicType.Builder<?> paramBuilder, TypeDescription paramTypeDescription, ClassFileLocator paramClassFileLocator) {
/* 142 */     for (Iterator<MethodDescription.InDefinedShape> iterator = ((MethodList)paramTypeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isBridge()).and((ElementMatcher)ElementMatchers.isAnnotatedWith(Enhance.class)))).iterator(); iterator.hasNext(); ) {
/* 143 */       MethodDescription.InDefinedShape inDefinedShape; if ((inDefinedShape = iterator.next()).isAbstract())
/* 144 */         throw new IllegalStateException("Cannot cache the value of an abstract method: " + inDefinedShape); 
/* 145 */       if (!inDefinedShape.getParameters().isEmpty())
/* 146 */         throw new IllegalStateException("Cannot cache the value of a method with parameters: " + inDefinedShape); 
/* 147 */       if (inDefinedShape.getReturnType().represents(void.class)) {
/* 148 */         throw new IllegalStateException("Cannot cache void result for " + inDefinedShape);
/*     */       }
/*     */       
/*     */       String str;
/*     */       
/* 153 */       if ((str = (String)inDefinedShape.getDeclaredAnnotations().ofType(Enhance.class).getValue(ENHANCE_VALUE).resolve(String.class)).length() == 0) {
/* 154 */         str = inDefinedShape.getName() + "_" + this.randomString.nextString();
/* 155 */       } else if (this.ignoreExistingFields && !((FieldList)paramTypeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named(str))).isEmpty()) {
/* 156 */         return paramBuilder;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 164 */       paramBuilder = paramBuilder.defineField(str, (TypeDefinition)inDefinedShape.getReturnType().asErasure(), new ModifierContributor.ForField[] { inDefinedShape.isStatic() ? (ModifierContributor.ForField)Ownership.STATIC : (ModifierContributor.ForField)Ownership.MEMBER, inDefinedShape.isStatic() ? (ModifierContributor.ForField)FieldPersistence.PLAIN : (ModifierContributor.ForField)FieldPersistence.TRANSIENT, (ModifierContributor.ForField)Visibility.PRIVATE, (ModifierContributor.ForField)SyntheticState.SYNTHETIC }).visit((AsmVisitorWrapper)Advice.withCustomMapping()
/* 165 */           .bind(CacheField.class, new CacheFieldOffsetMapping(str))
/* 166 */           .to(this.adviceByType.get(inDefinedShape.getReturnType().isPrimitive() ? inDefinedShape
/* 167 */               .getReturnType().asErasure() : 
/* 168 */               TypeDescription.ForLoadedType.of(Object.class)), this.classFileLocator)
/* 169 */           .on((ElementMatcher)ElementMatchers.is(inDefinedShape)));
/*     */     } 
/* 171 */     return paramBuilder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
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
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : ((this.ignoreExistingFields != ((CachedReturnPlugin)paramObject).ignoreExistingFields) ? false : (!!this.classFileLocator.equals(((CachedReturnPlugin)paramObject).classFileLocator))))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return (super.hashCode() * 31 + this.ignoreExistingFields) * 31 + this.classFileLocator.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class CacheFieldOffsetMapping
/*     */     implements Advice.OffsetMapping
/*     */   {
/*     */     private final String name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected CacheFieldOffsetMapping(String param1String) {
/* 225 */       this.name = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Advice.OffsetMapping.Target resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Advice.ArgumentHandler param1ArgumentHandler, Advice.OffsetMapping.Sort param1Sort) {
/* 236 */       return (Advice.OffsetMapping.Target)new Advice.OffsetMapping.Target.ForField.ReadWrite((FieldDescription)((FieldList)param1TypeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named(this.name))).getOnly());
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.name.equals(((CacheFieldOffsetMapping)param1Object).name))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.name.hashCode();
/*     */     }
/*     */   }
/*     */   
/*     */   @Target({ElementType.PARAMETER})
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   protected static @interface CacheField {}
/*     */   
/*     */   @Documented
/*     */   @Target({ElementType.METHOD})
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   public static @interface Enhance {
/*     */     String value() default "";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\build\CachedReturnPlugin.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */