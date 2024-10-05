/*     */ package net.bytebuddy.dynamic.scaffold.subclass;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.Transformer;
/*     */ import net.bytebuddy.dynamic.scaffold.MethodRegistry;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.MethodCall;
/*     */ import net.bytebuddy.implementation.SuperMethodCall;
/*     */ import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ import net.bytebuddy.matcher.LatentMatcher;
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
/*     */ public interface ConstructorStrategy
/*     */ {
/*     */   List<MethodDescription.Token> extractConstructors(TypeDescription paramTypeDescription);
/*     */   
/*     */   MethodRegistry inject(TypeDescription paramTypeDescription, MethodRegistry paramMethodRegistry);
/*     */   
/*     */   public enum Default
/*     */     implements ConstructorStrategy
/*     */   {
/*  76 */     NO_CONSTRUCTORS
/*     */     {
/*     */       protected final List<MethodDescription.Token> doExtractConstructors(TypeDescription param2TypeDescription) {
/*  79 */         return Collections.emptyList();
/*     */       }
/*     */ 
/*     */       
/*     */       protected final MethodRegistry doInject(MethodRegistry param2MethodRegistry, MethodAttributeAppender.Factory param2Factory) {
/*  84 */         return param2MethodRegistry;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     DEFAULT_CONSTRUCTOR
/*     */     {
/*     */       protected final List<MethodDescription.Token> doExtractConstructors(TypeDescription param2TypeDescription)
/*     */       {
/*     */         TypeDescription.Generic generic;
/*     */ 
/*     */         
/* 101 */         if ((generic = ((generic = param2TypeDescription.getSuperClass()) == null) ? (TypeDescription.Generic)new MethodList.Empty() : (TypeDescription.Generic)generic.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor().and((ElementMatcher)ElementMatchers.takesArguments(0)).and((ElementMatcher)ElementMatchers.isVisibleTo(param2TypeDescription)))).size() == 1) {
/* 102 */           return Collections.singletonList(new MethodDescription.Token(1));
/*     */         }
/* 104 */         throw new IllegalArgumentException(param2TypeDescription.getSuperClass() + " declares no constructor that is visible to " + param2TypeDescription);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       protected final MethodRegistry doInject(MethodRegistry param2MethodRegistry, MethodAttributeAppender.Factory param2Factory) {
/* 110 */         return param2MethodRegistry.append((LatentMatcher)new LatentMatcher.Resolved((ElementMatcher)ElementMatchers.isConstructor()), (MethodRegistry.Handler)new MethodRegistry.Handler.ForImplementation((Implementation)SuperMethodCall.INSTANCE), param2Factory, 
/*     */ 
/*     */             
/* 113 */             Transformer.NoOp.make());
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 123 */     IMITATE_SUPER_CLASS
/*     */     {
/*     */       protected final List<MethodDescription.Token> doExtractConstructors(TypeDescription param2TypeDescription) {
/*     */         TypeDescription.Generic generic;
/* 127 */         return (List<MethodDescription.Token>)(((generic = param2TypeDescription.getSuperClass()) == null) ? new MethodList.Empty() : generic
/*     */           
/* 129 */           .getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor().and((ElementMatcher)ElementMatchers.isVisibleTo(param2TypeDescription)))).asTokenList((ElementMatcher)ElementMatchers.is(param2TypeDescription));
/*     */       }
/*     */ 
/*     */       
/*     */       public final MethodRegistry doInject(MethodRegistry param2MethodRegistry, MethodAttributeAppender.Factory param2Factory) {
/* 134 */         return param2MethodRegistry.append((LatentMatcher)new LatentMatcher.Resolved((ElementMatcher)ElementMatchers.isConstructor()), (MethodRegistry.Handler)new MethodRegistry.Handler.ForImplementation((Implementation)SuperMethodCall.INSTANCE), param2Factory, 
/*     */ 
/*     */             
/* 137 */             Transformer.NoOp.make());
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 146 */     IMITATE_SUPER_CLASS_PUBLIC
/*     */     {
/*     */       protected final List<MethodDescription.Token> doExtractConstructors(TypeDescription param2TypeDescription) {
/*     */         TypeDescription.Generic generic;
/* 150 */         return (List<MethodDescription.Token>)(((generic = param2TypeDescription.getSuperClass()) == null) ? new MethodList.Empty() : generic
/*     */           
/* 152 */           .getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isPublic().and((ElementMatcher)ElementMatchers.isConstructor()))).asTokenList((ElementMatcher)ElementMatchers.is(param2TypeDescription));
/*     */       }
/*     */ 
/*     */       
/*     */       public final MethodRegistry doInject(MethodRegistry param2MethodRegistry, MethodAttributeAppender.Factory param2Factory) {
/* 157 */         return param2MethodRegistry.append((LatentMatcher)new LatentMatcher.Resolved((ElementMatcher)ElementMatchers.isConstructor()), (MethodRegistry.Handler)new MethodRegistry.Handler.ForImplementation((Implementation)SuperMethodCall.INSTANCE), param2Factory, 
/*     */ 
/*     */             
/* 160 */             Transformer.NoOp.make());
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 169 */     IMITATE_SUPER_CLASS_OPENING
/*     */     {
/*     */       protected final List<MethodDescription.Token> doExtractConstructors(TypeDescription param2TypeDescription) {
/*     */         TypeDescription.Generic generic;
/* 173 */         return (List<MethodDescription.Token>)(((generic = param2TypeDescription.getSuperClass()) == null) ? new MethodList.Empty() : generic
/*     */           
/* 175 */           .getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor().and((ElementMatcher)ElementMatchers.isVisibleTo(param2TypeDescription)))).asTokenList((ElementMatcher)ElementMatchers.is(param2TypeDescription));
/*     */       }
/*     */ 
/*     */       
/*     */       public final MethodRegistry doInject(MethodRegistry param2MethodRegistry, MethodAttributeAppender.Factory param2Factory) {
/* 180 */         return param2MethodRegistry.append((LatentMatcher)new LatentMatcher.Resolved((ElementMatcher)ElementMatchers.isConstructor()), (MethodRegistry.Handler)new MethodRegistry.Handler.ForImplementation((Implementation)SuperMethodCall.INSTANCE), param2Factory, 
/*     */ 
/*     */             
/* 183 */             Transformer.NoOp.make());
/*     */       }
/*     */ 
/*     */       
/*     */       protected final int resolveModifier(int param2Int) {
/* 188 */         return 1;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<MethodDescription.Token> extractConstructors(TypeDescription param1TypeDescription) {
/* 196 */       List<MethodDescription.Token> list = doExtractConstructors(param1TypeDescription); ArrayList<MethodDescription.Token> arrayList = new ArrayList(list.size());
/* 197 */       for (MethodDescription.Token token : list) {
/* 198 */         arrayList.add(new MethodDescription.Token(token.getName(), 
/* 199 */               resolveModifier(token.getModifiers()), (List)token
/* 200 */               .getTypeVariableTokens(), token
/* 201 */               .getReturnType(), (List)token
/* 202 */               .getParameterTokens(), (List)token
/* 203 */               .getExceptionTypes(), (List)token
/* 204 */               .getAnnotations(), token
/* 205 */               .getDefaultValue(), TypeDescription.Generic.UNDEFINED));
/*     */       }
/*     */       
/* 208 */       return arrayList;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected int resolveModifier(int param1Int) {
/* 218 */       return param1Int;
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
/*     */ 
/*     */     
/*     */     public MethodRegistry inject(TypeDescription param1TypeDescription, MethodRegistry param1MethodRegistry) {
/* 233 */       return doInject(param1MethodRegistry, (MethodAttributeAppender.Factory)MethodAttributeAppender.NoOp.INSTANCE);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ConstructorStrategy with(MethodAttributeAppender.Factory param1Factory) {
/* 252 */       return new WithMethodAttributeAppenderFactory(this, param1Factory);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ConstructorStrategy withInheritedAnnotations() {
/* 261 */       return new WithMethodAttributeAppenderFactory(this, (MethodAttributeAppender.Factory)MethodAttributeAppender.ForInstrumentedMethod.EXCLUDING_RECEIVER);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract List<MethodDescription.Token> doExtractConstructors(TypeDescription param1TypeDescription);
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract MethodRegistry doInject(MethodRegistry param1MethodRegistry, MethodAttributeAppender.Factory param1Factory);
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     protected static class WithMethodAttributeAppenderFactory
/*     */       implements ConstructorStrategy
/*     */     {
/*     */       private final ConstructorStrategy.Default delegate;
/*     */ 
/*     */       
/*     */       private final MethodAttributeAppender.Factory methodAttributeAppenderFactory;
/*     */ 
/*     */ 
/*     */       
/*     */       protected WithMethodAttributeAppenderFactory(ConstructorStrategy.Default param2Default, MethodAttributeAppender.Factory param2Factory) {
/* 287 */         this.delegate = param2Default;
/* 288 */         this.methodAttributeAppenderFactory = param2Factory;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public List<MethodDescription.Token> extractConstructors(TypeDescription param2TypeDescription) {
/* 295 */         return this.delegate.extractConstructors(param2TypeDescription);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public MethodRegistry inject(TypeDescription param2TypeDescription, MethodRegistry param2MethodRegistry) {
/* 302 */         return this.delegate.doInject(param2MethodRegistry, this.methodAttributeAppenderFactory);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.delegate.equals(((WithMethodAttributeAppenderFactory)param2Object).delegate) ? false : (!!this.methodAttributeAppenderFactory.equals(((WithMethodAttributeAppenderFactory)param2Object).methodAttributeAppenderFactory)))));
/*     */       }
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return (getClass().hashCode() * 31 + this.delegate.hashCode()) * 31 + this.methodAttributeAppenderFactory.hashCode();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class ForDefaultConstructor
/*     */     implements ConstructorStrategy
/*     */   {
/*     */     private final ElementMatcher<? super MethodDescription> elementMatcher;
/*     */     
/*     */     private final MethodAttributeAppender.Factory methodAttributeAppenderFactory;
/*     */     
/*     */     public ForDefaultConstructor() {
/* 327 */       this((ElementMatcher<? super MethodDescription>)ElementMatchers.any());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForDefaultConstructor(ElementMatcher<? super MethodDescription> param1ElementMatcher) {
/* 336 */       this(param1ElementMatcher, (MethodAttributeAppender.Factory)MethodAttributeAppender.NoOp.INSTANCE);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForDefaultConstructor(MethodAttributeAppender.Factory param1Factory) {
/* 345 */       this((ElementMatcher<? super MethodDescription>)ElementMatchers.any(), param1Factory);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForDefaultConstructor(ElementMatcher<? super MethodDescription> param1ElementMatcher, MethodAttributeAppender.Factory param1Factory) {
/* 356 */       this.elementMatcher = param1ElementMatcher;
/* 357 */       this.methodAttributeAppenderFactory = param1Factory;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<MethodDescription.Token> extractConstructors(TypeDescription param1TypeDescription) {
/*     */       TypeDescription.Generic generic;
/* 365 */       if ((generic = param1TypeDescription.getSuperClass()) == null)
/* 366 */         throw new IllegalArgumentException("Cannot extract constructors for " + param1TypeDescription); 
/* 367 */       if (((MethodList)generic.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor())).isEmpty()) {
/* 368 */         throw new IllegalStateException("Cannot define default constructor for class without super class constructor");
/*     */       }
/* 370 */       return Collections.singletonList(new MethodDescription.Token(1));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public MethodRegistry inject(TypeDescription param1TypeDescription, MethodRegistry param1MethodRegistry) {
/*     */       MethodCall methodCall;
/*     */       TypeDescription.Generic generic;
/* 378 */       if ((generic = param1TypeDescription.getSuperClass()) == null) {
/* 379 */         throw new IllegalArgumentException("Cannot inject constructors for " + param1TypeDescription);
/*     */       }
/*     */       MethodList methodList;
/* 382 */       if ((methodList = (MethodList)generic.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor().and(this.elementMatcher))).isEmpty())
/* 383 */         throw new IllegalStateException("No possible candidate for super constructor invocation in " + generic); 
/* 384 */       if (!((MethodList)methodList.filter((ElementMatcher)ElementMatchers.takesArguments(0))).isEmpty()) {
/* 385 */         methodList = (MethodList)methodList.filter((ElementMatcher)ElementMatchers.takesArguments(0));
/* 386 */       } else if (methodList.size() > 1) {
/* 387 */         throw new IllegalStateException("More than one possible super constructor for constructor delegation: " + methodList);
/*     */       } 
/* 389 */       MethodCall.WithoutSpecifiedTarget withoutSpecifiedTarget = MethodCall.invoke((MethodDescription)methodList.getOnly());
/* 390 */       for (TypeDescription typeDescription : ((MethodDescription)methodList.getOnly()).getParameters().asTypeList().asErasures()) {
/* 391 */         methodCall = withoutSpecifiedTarget.with(new Object[] { typeDescription.getDefaultValue() });
/*     */       } 
/* 393 */       return param1MethodRegistry.append((LatentMatcher)new LatentMatcher.Resolved((ElementMatcher)ElementMatchers.isConstructor().and((ElementMatcher)ElementMatchers.takesArguments(0))), (MethodRegistry.Handler)new MethodRegistry.Handler.ForImplementation((Implementation)methodCall), this.methodAttributeAppenderFactory, 
/*     */ 
/*     */           
/* 396 */           Transformer.NoOp.make());
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.elementMatcher.equals(((ForDefaultConstructor)param1Object).elementMatcher) ? false : (!!this.methodAttributeAppenderFactory.equals(((ForDefaultConstructor)param1Object).methodAttributeAppenderFactory)))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.elementMatcher.hashCode()) * 31 + this.methodAttributeAppenderFactory.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\subclass\ConstructorStrategy.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */