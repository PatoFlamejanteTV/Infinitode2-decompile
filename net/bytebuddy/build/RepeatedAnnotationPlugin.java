/*     */ package net.bytebuddy.build;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.annotation.Documented;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.ClassFileLocator;
/*     */ import net.bytebuddy.dynamic.DynamicType;
/*     */ import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
/*     */ import net.bytebuddy.implementation.attribute.TypeAttributeAppender;
/*     */ import net.bytebuddy.jar.asm.AnnotationVisitor;
/*     */ import net.bytebuddy.jar.asm.ClassVisitor;
/*     */ import net.bytebuddy.jar.asm.Type;
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
/*     */ @Enhance
/*     */ public class RepeatedAnnotationPlugin
/*     */   extends Plugin.ForElementMatcher
/*     */ {
/*  45 */   private static final MethodDescription.InDefinedShape VALUE = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(Enhance.class)
/*  46 */     .getDeclaredMethods()
/*  47 */     .filter((ElementMatcher)ElementMatchers.named("value")))
/*  48 */     .getOnly();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RepeatedAnnotationPlugin() {
/*  54 */     super((ElementMatcher<? super TypeDescription>)ElementMatchers.isAnnotatedWith(Enhance.class));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Annotation presence is required by matcher.")
/*     */   public DynamicType.Builder<?> apply(DynamicType.Builder<?> paramBuilder, TypeDescription paramTypeDescription, ClassFileLocator paramClassFileLocator) {
/*     */     TypeDescription typeDescription;
/*  66 */     if (!(typeDescription = (TypeDescription)paramTypeDescription.getDeclaredAnnotations().ofType(Enhance.class).getValue(VALUE).resolve(TypeDescription.class)).isAnnotation())
/*  67 */       throw new IllegalStateException("Expected " + typeDescription + " to be an annotation type"); 
/*  68 */     if (typeDescription.getDeclaredMethods().size() != 1 || ((MethodList)typeDescription
/*  69 */       .getDeclaredMethods().filter((ElementMatcher)ElementMatchers.named("value"))).size() != 1 || 
/*  70 */       !((MethodDescription.InDefinedShape)((MethodList)typeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.named("value"))).getOnly()).getReturnType().isArray() || 
/*  71 */       !((MethodDescription.InDefinedShape)((MethodList)typeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.named("value"))).getOnly()).getReturnType().getComponentType().asErasure().equals(paramTypeDescription)) {
/*  72 */       throw new IllegalStateException("Expected " + typeDescription + " to declare exactly one property named value of an array type");
/*     */     }
/*  74 */     return paramBuilder.attribute(new RepeatedAnnotationAppender(typeDescription));
/*     */   }
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
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : (!(getClass() != paramObject.getClass()))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return super.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class RepeatedAnnotationAppender
/*     */     implements TypeAttributeAppender
/*     */   {
/*     */     private final TypeDescription target;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected RepeatedAnnotationAppender(TypeDescription param1TypeDescription) {
/* 117 */       this.target = param1TypeDescription;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void apply(ClassVisitor param1ClassVisitor, TypeDescription param1TypeDescription, AnnotationValueFilter param1AnnotationValueFilter) {
/*     */       AnnotationVisitor annotationVisitor;
/* 125 */       if ((annotationVisitor = param1ClassVisitor.visitAnnotation("Ljava/lang/annotation/Repeatable;", true)) != null) {
/* 126 */         annotationVisitor.visit("value", Type.getType(this.target.getDescriptor()));
/* 127 */         annotationVisitor.visitEnd();
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.target.equals(((RepeatedAnnotationAppender)param1Object).target))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.target.hashCode();
/*     */     }
/*     */   }
/*     */   
/*     */   @Documented
/*     */   @Target({ElementType.ANNOTATION_TYPE})
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   public static @interface Enhance {
/*     */     Class<? extends Annotation> value();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\build\RepeatedAnnotationPlugin.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */