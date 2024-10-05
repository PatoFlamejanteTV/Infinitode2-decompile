/*     */ package net.bytebuddy.implementation;
/*     */ 
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*     */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*     */ import net.bytebuddy.implementation.bytecode.Duplication;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.Throw;
/*     */ import net.bytebuddy.implementation.bytecode.TypeCreation;
/*     */ import net.bytebuddy.implementation.bytecode.constant.TextConstant;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
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
/*     */ @Enhance
/*     */ public class ExceptionMethod
/*     */   implements Implementation, ByteCodeAppender
/*     */ {
/*     */   private final ConstructionDelegate constructionDelegate;
/*     */   
/*     */   public ExceptionMethod(ConstructionDelegate paramConstructionDelegate) {
/*  49 */     this.constructionDelegate = paramConstructionDelegate;
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
/*     */   public static Implementation throwing(Class<? extends Throwable> paramClass) {
/*  62 */     return throwing(TypeDescription.ForLoadedType.of(paramClass));
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
/*     */   public static Implementation throwing(TypeDescription paramTypeDescription) {
/*  75 */     if (!paramTypeDescription.isAssignableTo(Throwable.class)) {
/*  76 */       throw new IllegalArgumentException(paramTypeDescription + " does not extend throwable");
/*     */     }
/*  78 */     return new ExceptionMethod(new ConstructionDelegate.ForDefaultConstructor(paramTypeDescription));
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
/*     */   public static Implementation throwing(Class<? extends Throwable> paramClass, String paramString) {
/*  92 */     return throwing(TypeDescription.ForLoadedType.of(paramClass), paramString);
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
/*     */   public static Implementation throwing(TypeDescription paramTypeDescription, String paramString) {
/* 106 */     if (!paramTypeDescription.isAssignableTo(Throwable.class)) {
/* 107 */       throw new IllegalArgumentException(paramTypeDescription + " does not extend throwable");
/*     */     }
/* 109 */     return new ExceptionMethod(new ConstructionDelegate.ForStringConstructor(paramTypeDescription, paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InstrumentedType prepare(InstrumentedType paramInstrumentedType) {
/* 116 */     return paramInstrumentedType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteCodeAppender appender(Implementation.Target paramTarget) {
/* 123 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteCodeAppender.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext, MethodDescription paramMethodDescription) {
/* 133 */     StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { this.constructionDelegate.make(), (StackManipulation)Throw.INSTANCE })).apply(paramMethodVisitor, paramContext);
/* 134 */     return new ByteCodeAppender.Size(size.getMaximalSize(), paramMethodDescription.getStackSize());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.constructionDelegate.equals(((ExceptionMethod)paramObject).constructionDelegate))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return getClass().hashCode() * 31 + this.constructionDelegate.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class ForDefaultConstructor
/*     */     implements ConstructionDelegate
/*     */   {
/*     */     private final TypeDescription throwableType;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final MethodDescription targetConstructor;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForDefaultConstructor(TypeDescription param1TypeDescription) {
/* 172 */       this.throwableType = param1TypeDescription;
/* 173 */       this
/* 174 */         .targetConstructor = (MethodDescription)((MethodList)param1TypeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor().and((ElementMatcher)ElementMatchers.takesArguments(0)))).getOnly();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation make()
/*     */     {
/* 181 */       return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] {
/* 182 */             TypeCreation.of(this.throwableType), (StackManipulation)Duplication.SINGLE, 
/*     */             
/* 184 */             (StackManipulation)MethodInvocation.invoke(this.targetConstructor) }); } public boolean equals(@MaybeNull Object param1Object) { return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.throwableType.equals(((ForDefaultConstructor)param1Object).throwableType) ? false : (!!this.targetConstructor.equals(((ForDefaultConstructor)param1Object).targetConstructor))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.throwableType.hashCode()) * 31 + this.targetConstructor.hashCode(); } } public static interface ConstructionDelegate { StackManipulation make(); @Enhance public static class ForDefaultConstructor implements ConstructionDelegate { public StackManipulation make() { return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { TypeCreation.of(this.throwableType), (StackManipulation)Duplication.SINGLE, (StackManipulation)MethodInvocation.invoke(this.targetConstructor) }); }
/*     */ 
/*     */ 
/*     */       
/*     */       private final TypeDescription throwableType;
/*     */       
/*     */       private final MethodDescription targetConstructor;
/*     */ 
/*     */       
/*     */       public ForDefaultConstructor(TypeDescription param2TypeDescription) {
/*     */         this.throwableType = param2TypeDescription;
/*     */         this.targetConstructor = (MethodDescription)((MethodList)param2TypeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor().and((ElementMatcher)ElementMatchers.takesArguments(0)))).getOnly();
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.throwableType.equals(((ForDefaultConstructor)param2Object).throwableType) ? false : (!!this.targetConstructor.equals(((ForDefaultConstructor)param2Object).targetConstructor)))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return (getClass().hashCode() * 31 + this.throwableType.hashCode()) * 31 + this.targetConstructor.hashCode();
/*     */       } }
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class ForStringConstructor
/*     */       implements ConstructionDelegate
/*     */     {
/*     */       private final TypeDescription throwableType;
/*     */       private final MethodDescription targetConstructor;
/*     */       private final String message;
/*     */       
/*     */       public ForStringConstructor(TypeDescription param2TypeDescription, String param2String) {
/* 216 */         this.throwableType = param2TypeDescription;
/* 217 */         this
/* 218 */           .targetConstructor = (MethodDescription)((MethodList)param2TypeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor().and((ElementMatcher)ElementMatchers.takesArguments(new Class[] { String.class })))).getOnly();
/* 219 */         this.message = param2String;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public StackManipulation make()
/*     */       {
/* 226 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] {
/* 227 */               TypeCreation.of(this.throwableType), (StackManipulation)Duplication.SINGLE, (StackManipulation)new TextConstant(this.message), 
/*     */ 
/*     */               
/* 230 */               (StackManipulation)MethodInvocation.invoke(this.targetConstructor) }); } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.message.equals(((ForStringConstructor)param2Object).message) ? false : (!this.throwableType.equals(((ForStringConstructor)param2Object).throwableType) ? false : (!!this.targetConstructor.equals(((ForStringConstructor)param2Object).targetConstructor)))))); } public int hashCode() { return ((getClass().hashCode() * 31 + this.throwableType.hashCode()) * 31 + this.targetConstructor.hashCode()) * 31 + this.message.hashCode(); } } } @Enhance public static class ForStringConstructor implements ConstructionDelegate { private final TypeDescription throwableType; public StackManipulation make() { return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { TypeCreation.of(this.throwableType), (StackManipulation)Duplication.SINGLE, (StackManipulation)new TextConstant(this.message), (StackManipulation)MethodInvocation.invoke(this.targetConstructor) }); }
/*     */ 
/*     */     
/*     */     private final MethodDescription targetConstructor;
/*     */     private final String message;
/*     */     
/*     */     public ForStringConstructor(TypeDescription param1TypeDescription, String param1String) {
/*     */       this.throwableType = param1TypeDescription;
/*     */       this.targetConstructor = (MethodDescription)((MethodList)param1TypeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor().and((ElementMatcher)ElementMatchers.takesArguments(new Class[] { String.class })))).getOnly();
/*     */       this.message = param1String;
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.message.equals(((ForStringConstructor)param1Object).message) ? false : (!this.throwableType.equals(((ForStringConstructor)param1Object).throwableType) ? false : (!!this.targetConstructor.equals(((ForStringConstructor)param1Object).targetConstructor))))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return ((getClass().hashCode() * 31 + this.throwableType.hashCode()) * 31 + this.targetConstructor.hashCode()) * 31 + this.message.hashCode();
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\ExceptionMethod.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */