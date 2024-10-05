/*     */ package net.bytebuddy.dynamic.scaffold;
/*     */ 
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
/*     */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*     */ import net.bytebuddy.jar.asm.ClassVisitor;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface TypeInitializer
/*     */   extends ByteCodeAppender
/*     */ {
/*     */   boolean isDefined();
/*     */   
/*     */   TypeInitializer expandWith(ByteCodeAppender paramByteCodeAppender);
/*     */   
/*     */   TypeWriter.MethodPool.Record wrap(TypeWriter.MethodPool.Record paramRecord);
/*     */   
/*     */   public static interface Drain
/*     */   {
/*     */     void apply(ClassVisitor param1ClassVisitor, TypeInitializer param1TypeInitializer, Implementation.Context param1Context);
/*     */     
/*     */     @Enhance
/*     */     public static class Default
/*     */       implements Drain
/*     */     {
/*     */       protected final TypeDescription instrumentedType;
/*     */       protected final TypeWriter.MethodPool methodPool;
/*     */       protected final AnnotationValueFilter.Factory annotationValueFilterFactory;
/*     */       
/*     */       public Default(TypeDescription param2TypeDescription, TypeWriter.MethodPool param2MethodPool, AnnotationValueFilter.Factory param2Factory) {
/* 101 */         this.instrumentedType = param2TypeDescription;
/* 102 */         this.methodPool = param2MethodPool;
/* 103 */         this.annotationValueFilterFactory = param2Factory;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void apply(ClassVisitor param2ClassVisitor, TypeInitializer param2TypeInitializer, Implementation.Context param2Context) {
/* 110 */         param2TypeInitializer.wrap(this.methodPool.target((MethodDescription)new MethodDescription.Latent.TypeInitializer(this.instrumentedType))).apply(param2ClassVisitor, param2Context, this.annotationValueFilterFactory);
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.instrumentedType.equals(((Default)param2Object).instrumentedType) ? false : (!this.methodPool.equals(((Default)param2Object).methodPool) ? false : (!!this.annotationValueFilterFactory.equals(((Default)param2Object).annotationValueFilterFactory))))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return ((getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.methodPool.hashCode()) * 31 + this.annotationValueFilterFactory.hashCode();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public enum None
/*     */     implements TypeInitializer {
/* 125 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isDefined() {
/* 131 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final TypeInitializer expandWith(ByteCodeAppender param1ByteCodeAppender) {
/* 138 */       return new TypeInitializer.Simple(param1ByteCodeAppender);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final TypeWriter.MethodPool.Record wrap(TypeWriter.MethodPool.Record param1Record) {
/* 145 */       return param1Record;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/* 152 */       return ByteCodeAppender.Size.ZERO;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Simple
/*     */     implements TypeInitializer
/*     */   {
/*     */     private final ByteCodeAppender byteCodeAppender;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Simple(ByteCodeAppender param1ByteCodeAppender) {
/* 173 */       this.byteCodeAppender = param1ByteCodeAppender;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isDefined() {
/* 180 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeInitializer expandWith(ByteCodeAppender param1ByteCodeAppender) {
/* 187 */       return new Simple((ByteCodeAppender)new ByteCodeAppender.Compound(new ByteCodeAppender[] { this.byteCodeAppender, param1ByteCodeAppender }));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeWriter.MethodPool.Record wrap(TypeWriter.MethodPool.Record param1Record) {
/* 194 */       return param1Record.prepend(this.byteCodeAppender);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/* 201 */       return this.byteCodeAppender.apply(param1MethodVisitor, param1Context, param1MethodDescription);
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.byteCodeAppender.equals(((Simple)param1Object).byteCodeAppender))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.byteCodeAppender.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\TypeInitializer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */