/*    */ package net.bytebuddy.build;
/*    */ 
/*    */ import net.bytebuddy.asm.MemberAttributeExtension;
/*    */ import net.bytebuddy.description.method.MethodDescription;
/*    */ import net.bytebuddy.description.type.TypeDescription;
/*    */ import net.bytebuddy.dynamic.ClassFileLocator;
/*    */ import net.bytebuddy.dynamic.DynamicType;
/*    */ import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
/*    */ import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
/*    */ import net.bytebuddy.jar.asm.AnnotationVisitor;
/*    */ import net.bytebuddy.jar.asm.MethodVisitor;
/*    */ import net.bytebuddy.jar.asm.Type;
/*    */ import net.bytebuddy.matcher.ElementMatcher;
/*    */ import net.bytebuddy.matcher.ElementMatchers;
/*    */ import net.bytebuddy.utility.dispatcher.JavaDispatcher;
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
/*    */ @Enhance
/*    */ public class DispatcherAnnotationPlugin
/*    */   extends Plugin.ForElementMatcher
/*    */   implements MethodAttributeAppender, MethodAttributeAppender.Factory
/*    */ {
/*    */   public DispatcherAnnotationPlugin() {
/* 44 */     super((ElementMatcher<? super TypeDescription>)ElementMatchers.isAnnotatedWith(JavaDispatcher.Proxied.class));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DynamicType.Builder<?> apply(DynamicType.Builder<?> paramBuilder, TypeDescription paramTypeDescription, ClassFileLocator paramClassFileLocator) {
/* 51 */     return paramBuilder.visit((new MemberAttributeExtension.ForMethod())
/* 52 */         .attribute(this)
/* 53 */         .on((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isAnnotatedWith(JavaDispatcher.Proxied.class)).and((ElementMatcher)ElementMatchers.isAbstract())));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void close() {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MethodAttributeAppender make(TypeDescription paramTypeDescription) {
/* 67 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void apply(MethodVisitor paramMethodVisitor, MethodDescription paramMethodDescription, AnnotationValueFilter paramAnnotationValueFilter) {
/*    */     AnnotationVisitor annotationVisitor;
/* 75 */     if ((annotationVisitor = paramMethodVisitor.visitAnnotation(Type.getDescriptor(JavaDispatcher.Proxied.class), true)) != null) {
/* 76 */       annotationVisitor.visit("value", paramMethodDescription.getName());
/* 77 */       annotationVisitor.visitEnd();
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : (!(getClass() != paramObject.getClass()))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return super.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\build\DispatcherAnnotationPlugin.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */