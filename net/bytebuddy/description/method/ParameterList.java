/*     */ package net.bytebuddy.description.method;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*     */ import net.bytebuddy.description.ByteCodeElement;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.description.type.TypeList;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.FilterableList;
/*     */ import net.bytebuddy.utility.dispatcher.JavaDispatcher;
/*     */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Instance;
/*     */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface ParameterList<T extends ParameterDescription>
/*     */   extends FilterableList<T, ParameterList<T>>
/*     */ {
/*     */   TypeList.Generic asTypeList();
/*     */   
/*     */   ByteCodeElement.Token.TokenList<ParameterDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> paramElementMatcher);
/*     */   
/*     */   ParameterList<ParameterDescription.InDefinedShape> asDefined();
/*     */   
/*     */   boolean hasExplicitMetaData();
/*     */   
/*     */   public static abstract class AbstractBase<S extends ParameterDescription>
/*     */     extends FilterableList.AbstractBase<S, ParameterList<S>>
/*     */     implements ParameterList<S>
/*     */   {
/*     */     public boolean hasExplicitMetaData() {
/*  82 */       for (Iterator<ParameterDescription> iterator = iterator(); iterator.hasNext();) {
/*  83 */         if (!(parameterDescription = iterator.next()).isNamed() || !parameterDescription.hasModifiers()) {
/*  84 */           return false;
/*     */         }
/*     */       } 
/*  87 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeElement.Token.TokenList<ParameterDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> param1ElementMatcher) {
/*  94 */       ArrayList<ByteCodeElement.Token> arrayList = new ArrayList(size());
/*  95 */       for (ParameterDescription parameterDescription : this) {
/*  96 */         arrayList.add(parameterDescription.asToken(param1ElementMatcher));
/*     */       }
/*  98 */       return new ByteCodeElement.Token.TokenList(arrayList);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeList.Generic asTypeList() {
/* 105 */       ArrayList<TypeDescription.Generic> arrayList = new ArrayList(size());
/* 106 */       for (ParameterDescription parameterDescription : this) {
/* 107 */         arrayList.add(parameterDescription.getType());
/*     */       }
/* 109 */       return (TypeList.Generic)new TypeList.Generic.Explicit(arrayList);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ParameterList<ParameterDescription.InDefinedShape> asDefined() {
/* 116 */       ArrayList<ByteCodeElement.TypeDependant> arrayList = new ArrayList(size());
/* 117 */       for (ParameterDescription parameterDescription : this) {
/* 118 */         arrayList.add(parameterDescription.asDefined());
/*     */       }
/* 120 */       return (ParameterList)new ParameterList.Explicit<ByteCodeElement.TypeDependant>(arrayList);
/*     */     }
/*     */ 
/*     */     
/*     */     protected ParameterList<S> wrap(List<S> param1List) {
/* 125 */       return new ParameterList.Explicit<S>(param1List);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class ForLoadedExecutable<T>
/*     */     extends AbstractBase<ParameterDescription.InDefinedShape>
/*     */   {
/* 139 */     protected static final Executable EXECUTABLE = doPrivileged(JavaDispatcher.of(Executable.class)); static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*     */        }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final T executable;
/*     */ 
/*     */ 
/*     */     
/*     */     protected final ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource;
/*     */ 
/*     */     
/*     */     private static final boolean ACCESS_CONTROLLER;
/*     */ 
/*     */ 
/*     */     
/*     */     protected ForLoadedExecutable(T param1T, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource param1ParameterAnnotationSource) {
/* 158 */       this.executable = param1T;
/* 159 */       this.parameterAnnotationSource = param1ParameterAnnotationSource;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     private static <T> T doPrivileged(PrivilegedAction<T> param1PrivilegedAction) {
/* 171 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ParameterList<ParameterDescription.InDefinedShape> of(Constructor<?> param1Constructor) {
/* 181 */       return of(param1Constructor, new ParameterDescription.ForLoadedParameter.ParameterAnnotationSource.ForLoadedConstructor(param1Constructor));
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
/*     */     public static ParameterList<ParameterDescription.InDefinedShape> of(Constructor<?> param1Constructor, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource param1ParameterAnnotationSource) {
/* 193 */       return (ParameterList<ParameterDescription.InDefinedShape>)(EXECUTABLE.isInstance(param1Constructor) ? new OfConstructor(param1Constructor, param1ParameterAnnotationSource) : new OfLegacyVmConstructor(param1Constructor, param1ParameterAnnotationSource));
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
/*     */     public static ParameterList<ParameterDescription.InDefinedShape> of(Method param1Method) {
/* 205 */       return of(param1Method, new ParameterDescription.ForLoadedParameter.ParameterAnnotationSource.ForLoadedMethod(param1Method));
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
/*     */     public static ParameterList<ParameterDescription.InDefinedShape> of(Method param1Method, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource param1ParameterAnnotationSource) {
/* 217 */       return (ParameterList<ParameterDescription.InDefinedShape>)(EXECUTABLE.isInstance(param1Method) ? new OfMethod(param1Method, param1ParameterAnnotationSource) : new OfLegacyVmMethod(param1Method, param1ParameterAnnotationSource));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 226 */       return EXECUTABLE.getParameterCount(this.executable);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Proxied("java.lang.reflect.Executable")
/*     */     protected static interface Executable
/*     */     {
/*     */       @Instance
/*     */       @Proxied("isInstance")
/*     */       boolean isInstance(Object param2Object);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @Proxied("getParameterCount")
/*     */       int getParameterCount(Object param2Object);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @Proxied("getParameters")
/*     */       Object[] getParameters(Object param2Object);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected static class OfConstructor
/*     */       extends ForLoadedExecutable<Constructor<?>>
/*     */     {
/*     */       protected OfConstructor(Constructor<?> param2Constructor, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource param2ParameterAnnotationSource) {
/* 273 */         super(param2Constructor, param2ParameterAnnotationSource);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ParameterDescription.InDefinedShape get(int param2Int) {
/* 280 */         return new ParameterDescription.ForLoadedParameter.OfConstructor(this.executable, param2Int, this.parameterAnnotationSource);
/*     */       }
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
/*     */     protected static class OfMethod
/*     */       extends ForLoadedExecutable<Method>
/*     */     {
/*     */       protected OfMethod(Method param2Method, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource param2ParameterAnnotationSource) {
/* 296 */         super(param2Method, param2ParameterAnnotationSource);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ParameterDescription.InDefinedShape get(int param2Int) {
/* 303 */         return new ParameterDescription.ForLoadedParameter.OfMethod(this.executable, param2Int, this.parameterAnnotationSource);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected static class OfLegacyVmConstructor
/*     */       extends ParameterList.AbstractBase<ParameterDescription.InDefinedShape>
/*     */     {
/*     */       private final Constructor<?> constructor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final Class<?>[] parameterType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected OfLegacyVmConstructor(Constructor<?> param2Constructor, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource param2ParameterAnnotationSource) {
/* 335 */         this.constructor = param2Constructor;
/* 336 */         this.parameterType = param2Constructor.getParameterTypes();
/* 337 */         this.parameterAnnotationSource = param2ParameterAnnotationSource;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ParameterDescription.InDefinedShape get(int param2Int) {
/* 344 */         return new ParameterDescription.ForLoadedParameter.OfLegacyVmConstructor(this.constructor, param2Int, this.parameterType, this.parameterAnnotationSource);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int size() {
/* 351 */         return this.parameterType.length;
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected static class OfLegacyVmMethod
/*     */       extends ParameterList.AbstractBase<ParameterDescription.InDefinedShape>
/*     */     {
/*     */       private final Method method;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final Class<?>[] parameterType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected OfLegacyVmMethod(Method param2Method, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource param2ParameterAnnotationSource) {
/* 383 */         this.method = param2Method;
/* 384 */         this.parameterType = param2Method.getParameterTypes();
/* 385 */         this.parameterAnnotationSource = param2ParameterAnnotationSource;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ParameterDescription.InDefinedShape get(int param2Int) {
/* 392 */         return new ParameterDescription.ForLoadedParameter.OfLegacyVmMethod(this.method, param2Int, this.parameterType, this.parameterAnnotationSource);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int size() {
/* 399 */         return this.parameterType.length;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Explicit<S extends ParameterDescription>
/*     */     extends AbstractBase<S>
/*     */   {
/*     */     private final List<? extends S> parameterDescriptions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Explicit(S... param1VarArgs) {
/* 423 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Explicit(List<? extends S> param1List) {
/* 432 */       this.parameterDescriptions = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public S get(int param1Int) {
/* 439 */       return this.parameterDescriptions.get(param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 446 */       return this.parameterDescriptions.size();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ForTypes
/*     */       extends ParameterList.AbstractBase<ParameterDescription.InDefinedShape>
/*     */     {
/*     */       private final MethodDescription.InDefinedShape methodDescription;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final List<? extends TypeDefinition> typeDefinitions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ForTypes(MethodDescription.InDefinedShape param2InDefinedShape, TypeDefinition... param2VarArgs) {
/* 471 */         this(param2InDefinedShape, Arrays.asList(param2VarArgs));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ForTypes(MethodDescription.InDefinedShape param2InDefinedShape, List<? extends TypeDefinition> param2List) {
/* 481 */         this.methodDescription = param2InDefinedShape;
/* 482 */         this.typeDefinitions = param2List;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ParameterDescription.InDefinedShape get(int param2Int) {
/* 489 */         int i = this.methodDescription.isStatic() ? 0 : 1;
/* 490 */         for (byte b = 0; b < param2Int; b++) {
/* 491 */           i += ((TypeDefinition)this.typeDefinitions.get(b)).getStackSize().getSize();
/*     */         }
/* 493 */         return new ParameterDescription.Latent(this.methodDescription, ((TypeDefinition)this.typeDefinitions.get(param2Int)).asGenericType(), param2Int, i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int size() {
/* 500 */         return this.typeDefinitions.size();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ForTokens
/*     */     extends AbstractBase<ParameterDescription.InDefinedShape>
/*     */   {
/*     */     private final MethodDescription.InDefinedShape declaringMethod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<? extends ParameterDescription.Token> tokens;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForTokens(MethodDescription.InDefinedShape param1InDefinedShape, List<? extends ParameterDescription.Token> param1List) {
/* 527 */       this.declaringMethod = param1InDefinedShape;
/* 528 */       this.tokens = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ParameterDescription.InDefinedShape get(int param1Int) {
/* 535 */       int i = this.declaringMethod.isStatic() ? 0 : 1;
/* 536 */       for (ParameterDescription.Token token : this.tokens.subList(0, param1Int)) {
/* 537 */         i += token.getType().getStackSize().getSize();
/*     */       }
/* 539 */       return new ParameterDescription.Latent(this.declaringMethod, this.tokens.get(param1Int), param1Int, i);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 546 */       return this.tokens.size();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class TypeSubstituting
/*     */     extends AbstractBase<ParameterDescription.InGenericShape>
/*     */   {
/*     */     private final MethodDescription.InGenericShape declaringMethod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<? extends ParameterDescription> parameterDescriptions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeSubstituting(MethodDescription.InGenericShape param1InGenericShape, List<? extends ParameterDescription> param1List, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param1Visitor) {
/* 580 */       this.declaringMethod = param1InGenericShape;
/* 581 */       this.parameterDescriptions = param1List;
/* 582 */       this.visitor = param1Visitor;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ParameterDescription.InGenericShape get(int param1Int) {
/* 589 */       return new ParameterDescription.TypeSubstituting(this.declaringMethod, this.parameterDescriptions.get(param1Int), this.visitor);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 596 */       return this.parameterDescriptions.size();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Empty<S extends ParameterDescription>
/*     */     extends FilterableList.Empty<S, ParameterList<S>>
/*     */     implements ParameterList<S>
/*     */   {
/*     */     public boolean hasExplicitMetaData() {
/* 611 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeList.Generic asTypeList() {
/* 618 */       return (TypeList.Generic)new TypeList.Generic.Empty();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeElement.Token.TokenList<ParameterDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> param1ElementMatcher) {
/* 625 */       return new ByteCodeElement.Token.TokenList((ByteCodeElement.Token[])new ParameterDescription.Token[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ParameterList<ParameterDescription.InDefinedShape> asDefined() {
/* 633 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\method\ParameterList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */