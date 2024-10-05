/*      */ package net.bytebuddy.build;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.Closeable;
/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.PrintStream;
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.annotation.Documented;
/*      */ import java.lang.annotation.ElementType;
/*      */ import java.lang.annotation.Retention;
/*      */ import java.lang.annotation.RetentionPolicy;
/*      */ import java.lang.annotation.Target;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Enumeration;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.Callable;
/*      */ import java.util.concurrent.CompletionService;
/*      */ import java.util.concurrent.ExecutionException;
/*      */ import java.util.concurrent.Executor;
/*      */ import java.util.concurrent.ExecutorCompletionService;
/*      */ import java.util.concurrent.ExecutorService;
/*      */ import java.util.concurrent.Executors;
/*      */ import java.util.concurrent.Future;
/*      */ import java.util.jar.JarEntry;
/*      */ import java.util.jar.JarFile;
/*      */ import java.util.jar.JarOutputStream;
/*      */ import java.util.jar.Manifest;
/*      */ import net.bytebuddy.ByteBuddy;
/*      */ import net.bytebuddy.ClassFileVersion;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.dynamic.ClassFileLocator;
/*      */ import net.bytebuddy.dynamic.DynamicType;
/*      */ import net.bytebuddy.dynamic.TypeResolutionStrategy;
/*      */ import net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer;
/*      */ import net.bytebuddy.implementation.LoadedTypeInitializer;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.matcher.ElementMatchers;
/*      */ import net.bytebuddy.pool.TypePool;
/*      */ import net.bytebuddy.utility.CompoundList;
/*      */ import net.bytebuddy.utility.FileSystem;
/*      */ import net.bytebuddy.utility.nullability.AlwaysNull;
/*      */ import net.bytebuddy.utility.nullability.MaybeNull;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public interface Plugin
/*      */   extends Closeable, ElementMatcher<TypeDescription>
/*      */ {
/*      */   DynamicType.Builder<?> apply(DynamicType.Builder<?> paramBuilder, TypeDescription paramTypeDescription, ClassFileLocator paramClassFileLocator);
/*      */   
/*      */   public static interface WithPreprocessor
/*      */     extends Plugin
/*      */   {
/*      */     void onPreprocess(TypeDescription param1TypeDescription, ClassFileLocator param1ClassFileLocator);
/*      */   }
/*      */   
/*      */   public static interface WithInitialization
/*      */     extends Plugin
/*      */   {
/*      */     Map<TypeDescription, byte[]> initialize(ClassFileLocator param1ClassFileLocator);
/*      */   }
/*      */   
/*      */   public static interface Factory
/*      */   {
/*      */     Plugin make();
/*      */     
/*      */     @Enhance
/*      */     public static class Simple
/*      */       implements Factory
/*      */     {
/*      */       private final Plugin plugin;
/*      */       
/*      */       public Simple(Plugin param2Plugin) {
/*  143 */         this.plugin = param2Plugin;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Plugin make() {
/*  150 */         return this.plugin;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.plugin.equals(((Simple)param2Object).plugin))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.plugin.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class UsingReflection
/*      */       implements Factory
/*      */     {
/*      */       private final Class<? extends Plugin> type;
/*      */       
/*      */       private final List<ArgumentResolver> argumentResolvers;
/*      */ 
/*      */       
/*      */       public UsingReflection(Class<? extends Plugin> param2Class) {
/*  176 */         this(param2Class, Collections.emptyList());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected UsingReflection(Class<? extends Plugin> param2Class, List<ArgumentResolver> param2List) {
/*  186 */         this.type = param2Class;
/*  187 */         this.argumentResolvers = param2List;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public UsingReflection with(ArgumentResolver... param2VarArgs) {
/*  197 */         return with(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public UsingReflection with(List<? extends ArgumentResolver> param2List) {
/*  207 */         return new UsingReflection(this.type, CompoundList.of(param2List, this.argumentResolvers));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Plugin make() {
/*  215 */         Instantiator instantiator = new Instantiator.Unresolved(this.type); Constructor[] arrayOfConstructor; int i;
/*      */         byte b;
/*  217 */         for (i = (arrayOfConstructor = (Constructor[])this.type.getConstructors()).length, b = 0; b < i; b++) {
/*  218 */           Constructor<?> constructor; if (!(constructor = arrayOfConstructor[b]).isSynthetic()) {
/*  219 */             ArrayList<Object> arrayList = new ArrayList((constructor.getParameterTypes()).length);
/*  220 */             byte b1 = 0; Class[] arrayOfClass;
/*  221 */             int j = (arrayOfClass = constructor.getParameterTypes()).length; byte b2 = 0; while (true) { if (b2 < j) { Class<?> clazz = arrayOfClass[b2];
/*  222 */                 boolean bool = false;
/*  223 */                 for (Iterator<ArgumentResolver> iterator = this.argumentResolvers.iterator(); iterator.hasNext();) {
/*      */                   
/*  225 */                   if ((resolution = (argumentResolver = iterator.next()).resolve(b1, clazz)).isResolved()) {
/*  226 */                     arrayList.add(resolution.getArgument());
/*  227 */                     bool = true;
/*      */                     break;
/*      */                   } 
/*      */                 } 
/*  231 */                 if (bool) {
/*  232 */                   b1++;
/*      */                   b2++;
/*      */                 } 
/*      */                 break; }
/*      */               
/*  237 */               instantiator = instantiator.replaceBy(new Instantiator.Resolved((Constructor)constructor, arrayList)); break; }
/*      */           
/*      */           } 
/*  240 */         }  return instantiator.instantiate();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.type.equals(((UsingReflection)param2Object).type) ? false : (!!this.argumentResolvers.equals(((UsingReflection)param2Object).argumentResolvers)))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.type.hashCode()) * 31 + this.argumentResolvers.hashCode();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class Unresolved
/*      */         implements Instantiator
/*      */       {
/*      */         private final Class<? extends Plugin> type;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected Unresolved(Class<? extends Plugin> param3Class) {
/*  280 */           this.type = param3Class;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Plugin.Factory.UsingReflection.Instantiator replaceBy(Plugin.Factory.UsingReflection.Instantiator.Resolved param3Resolved) {
/*  287 */           return param3Resolved;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public Plugin instantiate()
/*      */         {
/*  294 */           throw new IllegalStateException("No constructor resolvable for " + this.type); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.type.equals(((Unresolved)param3Object).type)))); } public int hashCode() { return getClass().hashCode() * 31 + this.type.hashCode(); } } protected static interface Instantiator { Instantiator replaceBy(Resolved param3Resolved); Plugin instantiate(); @Enhance public static class Unresolved implements Instantiator { private final Class<? extends Plugin> type; protected Unresolved(Class<? extends Plugin> param4Class) { this.type = param4Class; } public Plugin.Factory.UsingReflection.Instantiator replaceBy(Plugin.Factory.UsingReflection.Instantiator.Resolved param4Resolved) { return param4Resolved; } public Plugin instantiate() { throw new IllegalStateException("No constructor resolvable for " + this.type); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.type.equals(((Unresolved)param4Object).type))));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.type.hashCode();
/*      */           } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class Ambiguous
/*      */           implements Instantiator
/*      */         {
/*      */           private final Constructor<?> left;
/*      */ 
/*      */           
/*      */           private final Constructor<?> right;
/*      */ 
/*      */           
/*      */           private final int priority;
/*      */ 
/*      */           
/*      */           private final int parameters;
/*      */ 
/*      */ 
/*      */           
/*      */           protected Ambiguous(Constructor<?> param4Constructor1, Constructor<?> param4Constructor2, int param4Int1, int param4Int2) {
/*  333 */             this.left = param4Constructor1;
/*  334 */             this.right = param4Constructor2;
/*  335 */             this.priority = param4Int1;
/*  336 */             this.parameters = param4Int2;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Plugin.Factory.UsingReflection.Instantiator replaceBy(Plugin.Factory.UsingReflection.Instantiator.Resolved param4Resolved) {
/*      */             Plugin.Factory.UsingReflection.Priority priority;
/*  344 */             if ((((priority = param4Resolved.getConstructor().<Annotation>getAnnotation(Plugin.Factory.UsingReflection.Priority.class)) == null) ? 0 : priority.value()) > this.priority)
/*  345 */               return param4Resolved; 
/*  346 */             if (((priority == null) ? 0 : priority.value()) < this.priority)
/*  347 */               return this; 
/*  348 */             if ((param4Resolved.getConstructor().getParameterTypes()).length > this.parameters) {
/*  349 */               return param4Resolved;
/*      */             }
/*  351 */             return this;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Plugin instantiate() {
/*  359 */             throw new IllegalStateException("Ambiguous constructors " + this.left + " and " + this.right);
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : ((this.priority != ((Ambiguous)param4Object).priority) ? false : ((this.parameters != ((Ambiguous)param4Object).parameters) ? false : (!this.left.equals(((Ambiguous)param4Object).left) ? false : (!!this.right.equals(((Ambiguous)param4Object).right)))))));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return (((getClass().hashCode() * 31 + this.left.hashCode()) * 31 + this.right.hashCode()) * 31 + this.priority) * 31 + this.parameters;
/*      */           }
/*      */         }
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class Resolved
/*      */           implements Instantiator
/*      */         {
/*      */           private final Constructor<? extends Plugin> constructor;
/*      */           
/*      */           private final List<?> arguments;
/*      */ 
/*      */           
/*      */           protected Resolved(Constructor<? extends Plugin> param4Constructor, List<?> param4List) {
/*  386 */             this.constructor = param4Constructor;
/*  387 */             this.arguments = param4List;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected Constructor<? extends Plugin> getConstructor() {
/*  396 */             return this.constructor;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Plugin.Factory.UsingReflection.Instantiator replaceBy(Resolved param4Resolved) {
/*  403 */             Plugin.Factory.UsingReflection.Priority priority1 = this.constructor.<Plugin.Factory.UsingReflection.Priority>getAnnotation(Plugin.Factory.UsingReflection.Priority.class), priority2 = param4Resolved.getConstructor().<Plugin.Factory.UsingReflection.Priority>getAnnotation(Plugin.Factory.UsingReflection.Priority.class);
/*  404 */             byte b1 = (priority1 == null) ? 0 : priority1.value(), b2 = (priority2 == null) ? 0 : priority2.value();
/*  405 */             if (b1 > b2)
/*  406 */               return this; 
/*  407 */             if (b1 < b2)
/*  408 */               return param4Resolved; 
/*  409 */             if ((this.constructor.getParameterTypes()).length > (param4Resolved.getConstructor().getParameterTypes()).length)
/*  410 */               return this; 
/*  411 */             if ((this.constructor.getParameterTypes()).length < (param4Resolved.getConstructor().getParameterTypes()).length) {
/*  412 */               return param4Resolved;
/*      */             }
/*  414 */             return new Plugin.Factory.UsingReflection.Instantiator.Ambiguous(this.constructor, param4Resolved.getConstructor(), b1, (this.constructor.getParameterTypes()).length);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Plugin instantiate()
/*      */           {
/*      */             
/*  423 */             try { return this.constructor.newInstance(this.arguments.toArray(new Object[0])); }
/*  424 */             catch (InstantiationException instantiationException)
/*  425 */             { throw new IllegalStateException("Failed to instantiate plugin via " + this.constructor, instantiationException); }
/*  426 */             catch (IllegalAccessException illegalAccessException)
/*  427 */             { throw new IllegalStateException("Failed to access " + this.constructor, illegalAccessException); }
/*  428 */             catch (InvocationTargetException invocationTargetException)
/*  429 */             { throw new IllegalStateException("Error during construction of" + this.constructor, invocationTargetException.getTargetException()); }  } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.constructor.equals(((Resolved)param4Object).constructor) ? false : (!!this.arguments.equals(((Resolved)param4Object).arguments))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.constructor.hashCode()) * 31 + this.arguments.hashCode(); } } } @Enhance public static class Resolved implements Instantiator { private final Constructor<? extends Plugin> constructor; private final List<?> arguments; public Plugin instantiate() { try { return this.constructor.newInstance(this.arguments.toArray(new Object[0])); } catch (InstantiationException instantiationException) { throw new IllegalStateException("Failed to instantiate plugin via " + this.constructor, instantiationException); } catch (IllegalAccessException illegalAccessException) { throw new IllegalStateException("Failed to access " + this.constructor, illegalAccessException); } catch (InvocationTargetException invocationTargetException) { throw new IllegalStateException("Error during construction of" + this.constructor, invocationTargetException.getTargetException()); }
/*      */            }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected Resolved(Constructor<? extends Plugin> param3Constructor, List<?> param3List) {
/*      */           this.constructor = param3Constructor;
/*      */           this.arguments = param3List;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected Constructor<? extends Plugin> getConstructor() {
/*      */           return this.constructor;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Plugin.Factory.UsingReflection.Instantiator replaceBy(Resolved param3Resolved) {
/*      */           Plugin.Factory.UsingReflection.Priority priority1 = this.constructor.<Plugin.Factory.UsingReflection.Priority>getAnnotation(Plugin.Factory.UsingReflection.Priority.class), priority2 = param3Resolved.getConstructor().<Plugin.Factory.UsingReflection.Priority>getAnnotation(Plugin.Factory.UsingReflection.Priority.class);
/*      */           byte b1 = (priority1 == null) ? 0 : priority1.value(), b2 = (priority2 == null) ? 0 : priority2.value();
/*      */           if (b1 > b2) {
/*      */             return this;
/*      */           }
/*      */           if (b1 < b2) {
/*      */             return param3Resolved;
/*      */           }
/*      */           if ((this.constructor.getParameterTypes()).length > (param3Resolved.getConstructor().getParameterTypes()).length) {
/*      */             return this;
/*      */           }
/*      */           if ((this.constructor.getParameterTypes()).length < (param3Resolved.getConstructor().getParameterTypes()).length) {
/*      */             return param3Resolved;
/*      */           }
/*      */           return new Plugin.Factory.UsingReflection.Instantiator.Ambiguous(this.constructor, param3Resolved.getConstructor(), b1, (this.constructor.getParameterTypes()).length);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.constructor.equals(((Resolved)param3Object).constructor) ? false : (!!this.arguments.equals(((Resolved)param3Object).arguments)))));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return (getClass().hashCode() * 31 + this.constructor.hashCode()) * 31 + this.arguments.hashCode();
/*      */         } }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static interface Resolution
/*      */       {
/*      */         boolean isResolved();
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         Object getArgument();
/*      */ 
/*      */ 
/*      */         
/*      */         public enum Unresolved
/*      */           implements Resolution
/*      */         {
/*  498 */           INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public final boolean isResolved() {
/*  504 */             return false;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public final Object getArgument() {
/*  511 */             throw new IllegalStateException("Cannot get the argument for an unresolved parameter");
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class Resolved
/*      */           implements Resolution
/*      */         {
/*      */           @MaybeNull
/*      */           @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*      */           private final Object argument;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Resolved(@MaybeNull Object param5Object) {
/*  534 */             this.argument = param5Object;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isResolved() {
/*  541 */             return true;
/*      */           }
/*      */           public boolean equals(@MaybeNull Object param5Object) { Object object; if (this == param5Object)
/*      */               return true;  if (param5Object == null)
/*      */               return false;  if (getClass() != param5Object.getClass())
/*      */               return false;  param5Object = ((Resolved)param5Object).argument; if (param5Object != null) { if ((object = this.argument) != null) { if (!object.equals(param5Object))
/*      */                   return false;  } else { return false; }  }
/*      */             else if ((object = this.argument) != null) { return false; }
/*  549 */              return true; } public int hashCode() { Object object; if ((object = this.argument) != null); return getClass().hashCode() * 31 + object.hashCode(); } @MaybeNull public Object getArgument() { return this.argument; } } } public static interface ArgumentResolver { Resolution resolve(int param3Int, Class<?> param3Class); public static interface Resolution { boolean isResolved(); @MaybeNull Object getArgument(); public enum Unresolved implements Resolution { INSTANCE; public final boolean isResolved() { return false; } public final Object getArgument() { throw new IllegalStateException("Cannot get the argument for an unresolved parameter"); } } @Enhance public static class Resolved implements Resolution { @MaybeNull @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY) private final Object argument; public Resolved(@MaybeNull Object param5Object) { this.argument = param5Object; } public boolean isResolved() { return true; } @MaybeNull public Object getArgument() { return this.argument; } public boolean equals(@MaybeNull Object param5Object) { Object object; if (this == param5Object)
/*      */                 return true;  if (param5Object == null)
/*      */                 return false;  if (getClass() != param5Object.getClass())
/*      */                 return false;  param5Object = ((Resolved)param5Object).argument; if (param5Object != null) { if ((object = this.argument) != null) {
/*      */                   if (!object.equals(param5Object))
/*      */                     return false; 
/*      */                 } else {
/*      */                   return false;
/*      */                 }  }
/*      */               else if ((object = this.argument) != null)
/*      */               { return false; }
/*      */                return true; }
/*      */             public int hashCode() { Object object; if ((object = this.argument) != null); return getClass().hashCode() * 31 + object.hashCode(); } } }
/*  562 */         public enum NoOp implements ArgumentResolver { INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public final Plugin.Factory.UsingReflection.ArgumentResolver.Resolution resolve(int param4Int, Class<?> param4Class) {
/*  568 */             return Plugin.Factory.UsingReflection.ArgumentResolver.Resolution.Unresolved.INSTANCE;
/*      */           } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class ForType<T>
/*      */           implements ArgumentResolver
/*      */         {
/*      */           private final Class<? extends T> type;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final T value;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected ForType(Class<? extends T> param4Class, T param4T) {
/*  597 */             this.type = param4Class;
/*  598 */             this.value = param4T;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public static <S> Plugin.Factory.UsingReflection.ArgumentResolver of(Class<? extends S> param4Class, S param4S) {
/*  610 */             return new ForType<S>(param4Class, param4S);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Plugin.Factory.UsingReflection.ArgumentResolver.Resolution resolve(int param4Int, Class<?> param4Class) {
/*  617 */             return (Plugin.Factory.UsingReflection.ArgumentResolver.Resolution)((param4Class == this.type) ? new Plugin.Factory.UsingReflection.ArgumentResolver.Resolution.Resolved(this.value) : Plugin.Factory.UsingReflection.ArgumentResolver.Resolution.Unresolved.INSTANCE);
/*      */           }
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.type.equals(((ForType)param4Object).type) ? false : (!!this.value.equals(((ForType)param4Object).value)))));
/*      */           }
/*      */           
/*      */           public int hashCode() {
/*      */             return (getClass().hashCode() * 31 + this.type.hashCode()) * 31 + this.value.hashCode();
/*      */           }
/*      */         }
/*      */         
/*      */         @Enhance
/*      */         public static class ForIndex
/*      */           implements ArgumentResolver {
/*      */           private static final Map<Class<?>, Class<?>> WRAPPER_TYPES;
/*      */           private final int index;
/*      */           @MaybeNull
/*      */           @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*      */           private final Object value;
/*      */           
/*      */           static {
/*  639 */             (WRAPPER_TYPES = new HashMap<Class<?>, Class<?>>()).put(boolean.class, Boolean.class);
/*  640 */             WRAPPER_TYPES.put(byte.class, Byte.class);
/*  641 */             WRAPPER_TYPES.put(short.class, Short.class);
/*  642 */             WRAPPER_TYPES.put(char.class, Character.class);
/*  643 */             WRAPPER_TYPES.put(int.class, Integer.class);
/*  644 */             WRAPPER_TYPES.put(long.class, Long.class);
/*  645 */             WRAPPER_TYPES.put(float.class, Float.class);
/*  646 */             WRAPPER_TYPES.put(double.class, Double.class);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public ForIndex(int param4Int, @MaybeNull Object param4Object) {
/*  668 */             this.index = param4Int;
/*  669 */             this.value = param4Object;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Plugin.Factory.UsingReflection.ArgumentResolver.Resolution resolve(int param4Int, Class<?> param4Class) {
/*  676 */             if (this.index != param4Int)
/*  677 */               return Plugin.Factory.UsingReflection.ArgumentResolver.Resolution.Unresolved.INSTANCE; 
/*  678 */             if (param4Class.isPrimitive()) {
/*  679 */               return (Plugin.Factory.UsingReflection.ArgumentResolver.Resolution)(((Class)WRAPPER_TYPES.get(param4Class)).isInstance(this.value) ? new Plugin.Factory.UsingReflection.ArgumentResolver.Resolution.Resolved(this.value) : Plugin.Factory.UsingReflection.ArgumentResolver.Resolution.Unresolved.INSTANCE);
/*      */             }
/*      */ 
/*      */             
/*  683 */             return (Plugin.Factory.UsingReflection.ArgumentResolver.Resolution)((this.value == null || param4Class.isInstance(this.value)) ? new Plugin.Factory.UsingReflection.ArgumentResolver.Resolution.Resolved(this.value) : Plugin.Factory.UsingReflection.ArgumentResolver.Resolution.Unresolved.INSTANCE);
/*      */           } public boolean equals(@MaybeNull Object param4Object) {
/*      */             Object object;
/*      */             if (this == param4Object)
/*      */               return true; 
/*      */             if (param4Object == null)
/*      */               return false; 
/*      */             if (getClass() != param4Object.getClass())
/*      */               return false; 
/*      */             if (this.index != ((ForIndex)param4Object).index)
/*      */               return false; 
/*      */             param4Object = ((ForIndex)param4Object).value;
/*      */             if (param4Object != null) {
/*      */               if ((object = this.value) != null) {
/*      */                 if (!object.equals(param4Object))
/*      */                   return false; 
/*      */               } else {
/*      */                 return false;
/*      */               } 
/*      */             } else if ((object = this.value) != null) {
/*      */               return false;
/*      */             } 
/*      */             return true;
/*      */           } public int hashCode() {
/*      */             Object object;
/*      */             if ((object = this.value) != null);
/*      */             return (getClass().hashCode() * 31 + this.index) * 31 + object.hashCode();
/*      */           }
/*      */           @Enhance
/*      */           public static class WithDynamicType implements Plugin.Factory.UsingReflection.ArgumentResolver { private final int index; @MaybeNull
/*      */             @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*      */             private final String value;
/*      */             public WithDynamicType(int param5Int, @MaybeNull String param5String) {
/*  716 */               this.index = param5Int;
/*  717 */               this.value = param5String;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public Plugin.Factory.UsingReflection.ArgumentResolver.Resolution resolve(int param5Int, Class<?> param5Class) {
/*  724 */               if (this.index != param5Int)
/*  725 */                 return Plugin.Factory.UsingReflection.ArgumentResolver.Resolution.Unresolved.INSTANCE; 
/*  726 */               if (param5Class == char.class || param5Class == Character.class) {
/*  727 */                 return (Plugin.Factory.UsingReflection.ArgumentResolver.Resolution)((this.value != null && this.value.length() == 1) ? new Plugin.Factory.UsingReflection.ArgumentResolver.Resolution.Resolved(
/*  728 */                     Character.valueOf(this.value.charAt(0))) : Plugin.Factory.UsingReflection.ArgumentResolver.Resolution.Unresolved.INSTANCE);
/*      */               }
/*  730 */               if (param5Class == String.class)
/*  731 */                 return new Plugin.Factory.UsingReflection.ArgumentResolver.Resolution.Resolved(this.value); 
/*  732 */               if (param5Class.isPrimitive()) {
/*  733 */                 param5Class = (Class)Plugin.Factory.UsingReflection.ArgumentResolver.ForIndex.a().get(param5Class);
/*      */               }
/*      */               try {
/*      */                 Method method;
/*  737 */                 if (Modifier.isStatic((method = param5Class.getMethod("valueOf", new Class[] { String.class })).getModifiers()) && param5Class.isAssignableFrom(method.getReturnType())) return new Plugin.Factory.UsingReflection.ArgumentResolver.Resolution.Resolved(method
/*  738 */                       .invoke(null, new Object[] { this.value }));  return Plugin.Factory.UsingReflection.ArgumentResolver.Resolution.Unresolved.INSTANCE;
/*      */               }
/*  740 */               catch (IllegalAccessException illegalAccessException) {
/*  741 */                 throw new IllegalStateException(illegalAccessException);
/*  742 */               } catch (InvocationTargetException invocationTargetException) {
/*  743 */                 throw new IllegalStateException(invocationTargetException.getTargetException());
/*  744 */               } catch (NoSuchMethodException noSuchMethodException) {
/*  745 */                 return Plugin.Factory.UsingReflection.ArgumentResolver.Resolution.Unresolved.INSTANCE;
/*      */               } 
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/*      */               String str;
/*      */               if (this == param5Object) {
/*      */                 return true;
/*      */               }
/*      */               if (param5Object == null) {
/*      */                 return false;
/*      */               }
/*      */               if (getClass() != param5Object.getClass()) {
/*      */                 return false;
/*      */               }
/*      */               if (this.index != ((WithDynamicType)param5Object).index) {
/*      */                 return false;
/*      */               }
/*      */               param5Object = ((WithDynamicType)param5Object).value;
/*      */               if (param5Object != null) {
/*      */                 if ((str = this.value) != null) {
/*      */                   if (!str.equals(param5Object)) {
/*      */                     return false;
/*      */                   }
/*      */                 } else {
/*      */                   return false;
/*      */                 } 
/*      */               } else if ((str = this.value) != null) {
/*      */                 return false;
/*      */               } 
/*      */               return true;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public int hashCode() {
/*      */               String str;
/*      */               if ((str = this.value) != null);
/*      */               return (getClass().hashCode() * 31 + this.index) * 31 + str.hashCode();
/*      */             } }
/*      */         
/*      */         } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Documented
/*      */       @Target({ElementType.CONSTRUCTOR})
/*      */       @Retention(RetentionPolicy.RUNTIME)
/*      */       public static @interface Priority
/*      */       {
/*      */         public static final int DEFAULT = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         int value();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface Engine
/*      */   {
/*      */     public static final String CLASS_FILE_EXTENSION = ".class";
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static final String MODULE_INFO = "module-info.class";
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static final String PACKAGE_INFO = "package-info.class";
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static final String PLUGIN_FILE = "META-INF/net.bytebuddy/build.plugins";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Engine with(ByteBuddy param1ByteBuddy);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Engine with(TypeStrategy param1TypeStrategy);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Engine with(PoolStrategy param1PoolStrategy);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Engine with(ClassFileLocator param1ClassFileLocator);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Engine with(Listener param1Listener);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Engine withoutErrorHandlers();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Engine withErrorHandlers(ErrorHandler... param1VarArgs);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Engine withErrorHandlers(List<? extends ErrorHandler> param1List);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Engine withParallelTransformation(int param1Int);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Engine with(Dispatcher.Factory param1Factory);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Engine ignore(ElementMatcher<? super TypeDescription> param1ElementMatcher);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Summary apply(File param1File1, File param1File2, Plugin.Factory... param1VarArgs);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Summary apply(File param1File1, File param1File2, List<? extends Plugin.Factory> param1List);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Summary apply(Source param1Source, Target param1Target, Plugin.Factory... param1VarArgs);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Summary apply(Source param1Source, Target param1Target, List<? extends Plugin.Factory> param1List);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface Factory
/*      */     {
/*      */       Plugin.Engine.Dispatcher make(Plugin.Engine.Target.Sink param2Sink, List<TypeDescription> param2List, Map<TypeDescription, List<Throwable>> param2Map, List<String> param2List1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface TypeStrategy
/*      */     {
/*      */       DynamicType.Builder<?> builder(ByteBuddy param2ByteBuddy, TypeDescription param2TypeDescription, ClassFileLocator param2ClassFileLocator);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum Default
/*      */         implements TypeStrategy
/*      */       {
/*  935 */         REDEFINE
/*      */         {
/*      */           
/*      */           public final DynamicType.Builder<?> builder(ByteBuddy param4ByteBuddy, TypeDescription param4TypeDescription, ClassFileLocator param4ClassFileLocator)
/*      */           {
/*  940 */             return param4ByteBuddy.redefine(param4TypeDescription, param4ClassFileLocator);
/*      */           }
/*      */         },
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  947 */         REBASE
/*      */         {
/*      */           
/*      */           public final DynamicType.Builder<?> builder(ByteBuddy param4ByteBuddy, TypeDescription param4TypeDescription, ClassFileLocator param4ClassFileLocator)
/*      */           {
/*  952 */             return param4ByteBuddy.rebase(param4TypeDescription, param4ClassFileLocator);
/*      */           }
/*      */         },
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  959 */         DECORATE
/*      */         {
/*      */           
/*      */           public final DynamicType.Builder<?> builder(ByteBuddy param4ByteBuddy, TypeDescription param4TypeDescription, ClassFileLocator param4ClassFileLocator)
/*      */           {
/*  964 */             return param4ByteBuddy.decorate(param4TypeDescription, param4ClassFileLocator);
/*      */           }
/*      */         };
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class ForEntryPoint
/*      */         implements TypeStrategy
/*      */       {
/*      */         private final EntryPoint entryPoint;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final MethodNameTransformer methodNameTransformer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ForEntryPoint(EntryPoint param3EntryPoint, MethodNameTransformer param3MethodNameTransformer) {
/*  992 */           this.entryPoint = param3EntryPoint;
/*  993 */           this.methodNameTransformer = param3MethodNameTransformer;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<?> builder(ByteBuddy param3ByteBuddy, TypeDescription param3TypeDescription, ClassFileLocator param3ClassFileLocator) {
/* 1000 */           return this.entryPoint.transform(param3TypeDescription, param3ByteBuddy, param3ClassFileLocator, this.methodNameTransformer);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.entryPoint.equals(((ForEntryPoint)param3Object).entryPoint) ? false : (!!this.methodNameTransformer.equals(((ForEntryPoint)param3Object).methodNameTransformer)))));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return (getClass().hashCode() * 31 + this.entryPoint.hashCode()) * 31 + this.methodNameTransformer.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public static interface PoolStrategy
/*      */     {
/*      */       TypePool typePool(ClassFileLocator param2ClassFileLocator);
/*      */ 
/*      */       
/*      */       public enum Default
/*      */         implements PoolStrategy
/*      */       {
/* 1026 */         FAST((String)TypePool.Default.ReaderMode.FAST),
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1031 */         EXTENDED((String)TypePool.Default.ReaderMode.EXTENDED);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypePool.Default.ReaderMode readerMode;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         Default(TypePool.Default.ReaderMode param3ReaderMode) {
/* 1044 */           this.readerMode = param3ReaderMode;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final TypePool typePool(ClassFileLocator param3ClassFileLocator) {
/* 1051 */           return (TypePool)new TypePool.Default.WithLazyResolution((TypePool.CacheProvider)new TypePool.CacheProvider.Simple(), param3ClassFileLocator, this.readerMode, 
/*      */ 
/*      */               
/* 1054 */               TypePool.ClassLoading.ofPlatformLoader());
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum Eager
/*      */         implements PoolStrategy
/*      */       {
/* 1067 */         FAST((String)TypePool.Default.ReaderMode.FAST),
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1072 */         EXTENDED((String)TypePool.Default.ReaderMode.EXTENDED);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypePool.Default.ReaderMode readerMode;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         Eager(TypePool.Default.ReaderMode param3ReaderMode) {
/* 1085 */           this.readerMode = param3ReaderMode;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final TypePool typePool(ClassFileLocator param3ClassFileLocator) {
/* 1092 */           return (TypePool)new TypePool.Default((TypePool.CacheProvider)new TypePool.CacheProvider.Simple(), param3ClassFileLocator, this.readerMode, 
/*      */ 
/*      */               
/* 1095 */               TypePool.ClassLoading.ofPlatformLoader());
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface ErrorHandler
/*      */     {
/*      */       void onError(TypeDescription param2TypeDescription, Plugin param2Plugin, Throwable param2Throwable);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void onError(TypeDescription param2TypeDescription, List<Throwable> param2List);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void onError(Map<TypeDescription, List<Throwable>> param2Map);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void onError(Plugin param2Plugin, Throwable param2Throwable);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void onLiveInitializer(TypeDescription param2TypeDescription1, TypeDescription param2TypeDescription2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void onUnresolved(String param2String);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void onManifest(@MaybeNull Manifest param2Manifest);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void onResource(String param2String);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum Failing
/*      */         implements ErrorHandler
/*      */       {
/* 1174 */         FAIL_FAST
/*      */         {
/*      */           
/*      */           public final void onError(TypeDescription param4TypeDescription, Plugin param4Plugin, Throwable param4Throwable)
/*      */           {
/* 1179 */             throw new IllegalStateException("Failed to transform " + param4TypeDescription + " using " + param4Plugin, param4Throwable);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public final void onError(TypeDescription param4TypeDescription, List<Throwable> param4List) {
/* 1186 */             throw new UnsupportedOperationException("onError");
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public final void onError(Map<TypeDescription, List<Throwable>> param4Map) {
/* 1193 */             throw new UnsupportedOperationException("onError");
/*      */           }
/*      */         },
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1200 */         FAIL_AFTER_TYPE
/*      */         {
/*      */           public final void onError(TypeDescription param4TypeDescription, Plugin param4Plugin, Throwable param4Throwable) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public final void onError(TypeDescription param4TypeDescription, List<Throwable> param4List) {
/* 1212 */             throw new IllegalStateException("Failed to transform " + param4TypeDescription + ": " + param4List);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public final void onError(Map<TypeDescription, List<Throwable>> param4Map) {
/* 1219 */             throw new UnsupportedOperationException("onError");
/*      */           }
/*      */         },
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1226 */         FAIL_LAST
/*      */         {
/*      */           public final void onError(TypeDescription param4TypeDescription, Plugin param4Plugin, Throwable param4Throwable) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public final void onError(TypeDescription param4TypeDescription, List<Throwable> param4List) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public final void onError(Map<TypeDescription, List<Throwable>> param4Map) {
/* 1245 */             throw new IllegalStateException("Failed to transform at least one type: " + param4Map);
/*      */           }
/*      */         };
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onError(Plugin param3Plugin, Throwable param3Throwable) {
/* 1253 */           throw new IllegalStateException("Failed to close plugin " + param3Plugin, param3Throwable);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onLiveInitializer(TypeDescription param3TypeDescription1, TypeDescription param3TypeDescription2) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onUnresolved(String param3String) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onManifest(Manifest param3Manifest) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onResource(String param3String) {}
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum Enforcing
/*      */         implements ErrorHandler
/*      */       {
/* 1293 */         ALL_TYPES_RESOLVED
/*      */         {
/*      */           public final void onUnresolved(String param4String) {
/* 1296 */             throw new IllegalStateException("Failed to resolve type description for " + param4String);
/*      */           }
/*      */         },
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1303 */         NO_LIVE_INITIALIZERS
/*      */         {
/*      */           public final void onLiveInitializer(TypeDescription param4TypeDescription1, TypeDescription param4TypeDescription2) {
/* 1306 */             throw new IllegalStateException("Failed to instrument " + param4TypeDescription1 + " due to live initializer for " + param4TypeDescription2);
/*      */           }
/*      */         },
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1313 */         CLASS_FILES_ONLY
/*      */         {
/*      */           public final void onResource(String param4String) {
/* 1316 */             throw new IllegalStateException("Discovered a resource when only class files were allowed: " + param4String);
/*      */           }
/*      */         },
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1323 */         MANIFEST_REQUIRED
/*      */         {
/*      */           public final void onManifest(@MaybeNull Manifest param4Manifest) {
/* 1326 */             if (param4Manifest == null) {
/* 1327 */               throw new IllegalStateException("Required a manifest but no manifest was found");
/*      */             }
/*      */           }
/*      */         };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onError(TypeDescription param3TypeDescription, Plugin param3Plugin, Throwable param3Throwable) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onError(TypeDescription param3TypeDescription, List<Throwable> param3List) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onError(Map<TypeDescription, List<Throwable>> param3Map) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onError(Plugin param3Plugin, Throwable param3Throwable) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onLiveInitializer(TypeDescription param3TypeDescription1, TypeDescription param3TypeDescription2) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onUnresolved(String param3String) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onManifest(@MaybeNull Manifest param3Manifest) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onResource(String param3String) {}
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static class Compound
/*      */         implements ErrorHandler
/*      */       {
/*      */         public Compound(Plugin.Engine.ErrorHandler... param3VarArgs) {
/* 1405 */           this(Arrays.asList(param3VarArgs));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1414 */         private final List<Plugin.Engine.ErrorHandler> errorHandlers = new ArrayList<Plugin.Engine.ErrorHandler>(); public Compound(List<? extends Plugin.Engine.ErrorHandler> param3List) {
/* 1415 */           for (Iterator<? extends Plugin.Engine.ErrorHandler> iterator = param3List.iterator(); iterator.hasNext(); ) {
/* 1416 */             Plugin.Engine.ErrorHandler errorHandler; if (errorHandler = iterator.next() instanceof Compound) {
/* 1417 */               this.errorHandlers.addAll(((Compound)errorHandler).errorHandlers); continue;
/* 1418 */             }  if (!(errorHandler instanceof Plugin.Engine.Listener.NoOp)) {
/* 1419 */               this.errorHandlers.add(errorHandler);
/*      */             }
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onError(TypeDescription param3TypeDescription, Plugin param3Plugin, Throwable param3Throwable) {
/* 1428 */           for (Iterator<Plugin.Engine.ErrorHandler> iterator = this.errorHandlers.iterator(); iterator.hasNext();) {
/* 1429 */             (errorHandler = iterator.next()).onError(param3TypeDescription, param3Plugin, param3Throwable);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onError(TypeDescription param3TypeDescription, List<Throwable> param3List) {
/* 1437 */           for (Iterator<Plugin.Engine.ErrorHandler> iterator = this.errorHandlers.iterator(); iterator.hasNext();) {
/* 1438 */             (errorHandler = iterator.next()).onError(param3TypeDescription, param3List);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onError(Map<TypeDescription, List<Throwable>> param3Map) {
/* 1446 */           for (Iterator<Plugin.Engine.ErrorHandler> iterator = this.errorHandlers.iterator(); iterator.hasNext();) {
/* 1447 */             (errorHandler = iterator.next()).onError(param3Map);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onError(Plugin param3Plugin, Throwable param3Throwable) {
/* 1456 */           for (Iterator<Plugin.Engine.ErrorHandler> iterator = this.errorHandlers.iterator(); iterator.hasNext();) {
/* 1457 */             (errorHandler = iterator.next()).onError(param3Plugin, param3Throwable);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onLiveInitializer(TypeDescription param3TypeDescription1, TypeDescription param3TypeDescription2) {
/* 1465 */           for (Iterator<Plugin.Engine.ErrorHandler> iterator = this.errorHandlers.iterator(); iterator.hasNext();) {
/* 1466 */             (errorHandler = iterator.next()).onLiveInitializer(param3TypeDescription1, param3TypeDescription2);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onUnresolved(String param3String) {
/* 1474 */           for (Iterator<Plugin.Engine.ErrorHandler> iterator = this.errorHandlers.iterator(); iterator.hasNext();) {
/* 1475 */             (errorHandler = iterator.next()).onUnresolved(param3String);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onManifest(@MaybeNull Manifest param3Manifest) {
/* 1483 */           for (Iterator<Plugin.Engine.ErrorHandler> iterator = this.errorHandlers.iterator(); iterator.hasNext();) {
/* 1484 */             (errorHandler = iterator.next()).onManifest(param3Manifest);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onResource(String param3String) {
/* 1492 */           for (Iterator<Plugin.Engine.ErrorHandler> iterator = this.errorHandlers.iterator(); iterator.hasNext();) {
/* 1493 */             (errorHandler = iterator.next()).onResource(param3String);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface Listener
/*      */       extends ErrorHandler
/*      */     {
/*      */       void onDiscovery(String param2String);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void onTransformation(TypeDescription param2TypeDescription, Plugin param2Plugin);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void onTransformation(TypeDescription param2TypeDescription, List<Plugin> param2List);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void onIgnored(TypeDescription param2TypeDescription, Plugin param2Plugin);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void onIgnored(TypeDescription param2TypeDescription, List<Plugin> param2List);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void onComplete(TypeDescription param2TypeDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum NoOp
/*      */         implements Listener
/*      */       {
/* 1560 */         INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void onDiscovery(String param3String) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void onTransformation(TypeDescription param3TypeDescription, Plugin param3Plugin) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void onTransformation(TypeDescription param3TypeDescription, List<Plugin> param3List) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void onIgnored(TypeDescription param3TypeDescription, Plugin param3Plugin) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void onIgnored(TypeDescription param3TypeDescription, List<Plugin> param3List) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void onError(TypeDescription param3TypeDescription, Plugin param3Plugin, Throwable param3Throwable) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void onError(TypeDescription param3TypeDescription, List<Throwable> param3List) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void onError(Map<TypeDescription, List<Throwable>> param3Map) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void onError(Plugin param3Plugin, Throwable param3Throwable) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void onLiveInitializer(TypeDescription param3TypeDescription1, TypeDescription param3TypeDescription2) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void onComplete(TypeDescription param3TypeDescription) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void onUnresolved(String param3String) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void onManifest(@MaybeNull Manifest param3Manifest) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void onResource(String param3String) {}
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static abstract class Adapter
/*      */         implements Listener
/*      */       {
/*      */         public void onDiscovery(String param3String) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onTransformation(TypeDescription param3TypeDescription, Plugin param3Plugin) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onTransformation(TypeDescription param3TypeDescription, List<Plugin> param3List) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onIgnored(TypeDescription param3TypeDescription, Plugin param3Plugin) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onIgnored(TypeDescription param3TypeDescription, List<Plugin> param3List) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onError(TypeDescription param3TypeDescription, Plugin param3Plugin, Throwable param3Throwable) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onError(TypeDescription param3TypeDescription, List<Throwable> param3List) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onError(Map<TypeDescription, List<Throwable>> param3Map) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onError(Plugin param3Plugin, Throwable param3Throwable) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onLiveInitializer(TypeDescription param3TypeDescription1, TypeDescription param3TypeDescription2) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onComplete(TypeDescription param3TypeDescription) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onUnresolved(String param3String) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onManifest(@MaybeNull Manifest param3Manifest) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onResource(String param3String) {}
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class StreamWriting
/*      */         extends Adapter
/*      */       {
/*      */         protected static final String PREFIX = "[Byte Buddy]";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final PrintStream printStream;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public StreamWriting(PrintStream param3PrintStream) {
/* 1787 */           this.printStream = param3PrintStream;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static StreamWriting toSystemOut() {
/* 1796 */           return new StreamWriting(System.out);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static StreamWriting toSystemError() {
/* 1805 */           return new StreamWriting(System.err);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Plugin.Engine.Listener withTransformationsOnly() {
/* 1814 */           return new Plugin.Engine.Listener.WithTransformationsOnly(this);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Plugin.Engine.Listener withErrorsOnly() {
/* 1823 */           return new Plugin.Engine.Listener.WithErrorsOnly(this);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onDiscovery(String param3String) {
/* 1830 */           this.printStream.printf("[Byte Buddy] DISCOVERY %s", new Object[] { param3String });
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onTransformation(TypeDescription param3TypeDescription, Plugin param3Plugin) {
/* 1837 */           this.printStream.printf("[Byte Buddy] TRANSFORM %s for %s", new Object[] { param3TypeDescription, param3Plugin });
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onIgnored(TypeDescription param3TypeDescription, Plugin param3Plugin) {
/* 1844 */           this.printStream.printf("[Byte Buddy] IGNORE %s for %s", new Object[] { param3TypeDescription, param3Plugin });
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onError(TypeDescription param3TypeDescription, Plugin param3Plugin, Throwable param3Throwable) {
/* 1851 */           synchronized (this.printStream) {
/* 1852 */             this.printStream.printf("[Byte Buddy] ERROR %s for %s", new Object[] { param3TypeDescription, param3Plugin });
/* 1853 */             param3Throwable.printStackTrace(this.printStream);
/*      */             return;
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public void onError(Plugin param3Plugin, Throwable param3Throwable) {
/* 1861 */           synchronized (this.printStream) {
/* 1862 */             this.printStream.printf("[Byte Buddy] ERROR %s", new Object[] { param3Plugin });
/* 1863 */             param3Throwable.printStackTrace(this.printStream);
/*      */             return;
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public void onUnresolved(String param3String) {
/* 1871 */           this.printStream.printf("[Byte Buddy] UNRESOLVED %s", new Object[] { param3String });
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onLiveInitializer(TypeDescription param3TypeDescription1, TypeDescription param3TypeDescription2) {
/* 1878 */           this.printStream.printf("[Byte Buddy] LIVE %s on %s", new Object[] { param3TypeDescription1, param3TypeDescription2 });
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onComplete(TypeDescription param3TypeDescription) {
/* 1885 */           this.printStream.printf("[Byte Buddy] COMPLETE %s", new Object[] { param3TypeDescription });
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onManifest(@MaybeNull Manifest param3Manifest) {
/* 1892 */           this.printStream.printf("[Byte Buddy] MANIFEST %b", new Object[] { Boolean.valueOf((param3Manifest != null)) });
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onResource(String param3String) {
/* 1899 */           this.printStream.printf("[Byte Buddy] RESOURCE %s", new Object[] { param3String });
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.printStream.equals(((StreamWriting)param3Object).printStream))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.printStream.hashCode();
/*      */         }
/*      */       }
/*      */       
/*      */       @Enhance
/*      */       public static class WithTransformationsOnly
/*      */         extends Adapter
/*      */       {
/*      */         private final Plugin.Engine.Listener delegate;
/*      */         
/*      */         public WithTransformationsOnly(Plugin.Engine.Listener param3Listener) {
/* 1920 */           this.delegate = param3Listener;
/*      */         }
/*      */ 
/*      */         
/*      */         public void onTransformation(TypeDescription param3TypeDescription, Plugin param3Plugin) {
/* 1925 */           this.delegate.onTransformation(param3TypeDescription, param3Plugin);
/*      */         }
/*      */ 
/*      */         
/*      */         public void onTransformation(TypeDescription param3TypeDescription, List<Plugin> param3List) {
/* 1930 */           this.delegate.onTransformation(param3TypeDescription, param3List);
/*      */         }
/*      */ 
/*      */         
/*      */         public void onError(TypeDescription param3TypeDescription, Plugin param3Plugin, Throwable param3Throwable) {
/* 1935 */           this.delegate.onError(param3TypeDescription, param3Plugin, param3Throwable);
/*      */         }
/*      */ 
/*      */         
/*      */         public void onError(TypeDescription param3TypeDescription, List<Throwable> param3List) {
/* 1940 */           this.delegate.onError(param3TypeDescription, param3List);
/*      */         }
/*      */ 
/*      */         
/*      */         public void onError(Map<TypeDescription, List<Throwable>> param3Map) {
/* 1945 */           this.delegate.onError(param3Map);
/*      */         }
/*      */ 
/*      */         
/*      */         public void onError(Plugin param3Plugin, Throwable param3Throwable) {
/* 1950 */           this.delegate.onError(param3Plugin, param3Throwable);
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.delegate.equals(((WithTransformationsOnly)param3Object).delegate))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.delegate.hashCode();
/*      */         }
/*      */       }
/*      */       
/*      */       @Enhance
/*      */       public static class WithErrorsOnly
/*      */         extends Adapter
/*      */       {
/*      */         private final Plugin.Engine.Listener delegate;
/*      */         
/*      */         public WithErrorsOnly(Plugin.Engine.Listener param3Listener) {
/* 1971 */           this.delegate = param3Listener;
/*      */         }
/*      */ 
/*      */         
/*      */         public void onError(TypeDescription param3TypeDescription, Plugin param3Plugin, Throwable param3Throwable) {
/* 1976 */           this.delegate.onError(param3TypeDescription, param3Plugin, param3Throwable);
/*      */         }
/*      */ 
/*      */         
/*      */         public void onError(TypeDescription param3TypeDescription, List<Throwable> param3List) {
/* 1981 */           this.delegate.onError(param3TypeDescription, param3List);
/*      */         }
/*      */ 
/*      */         
/*      */         public void onError(Map<TypeDescription, List<Throwable>> param3Map) {
/* 1986 */           this.delegate.onError(param3Map);
/*      */         }
/*      */ 
/*      */         
/*      */         public void onError(Plugin param3Plugin, Throwable param3Throwable) {
/* 1991 */           this.delegate.onError(param3Plugin, param3Throwable);
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.delegate.equals(((WithErrorsOnly)param3Object).delegate))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.delegate.hashCode();
/*      */         }
/*      */       }
/*      */       
/*      */       @Enhance
/*      */       public static class ForErrorHandler
/*      */         extends Adapter
/*      */       {
/*      */         private final Plugin.Engine.ErrorHandler errorHandler;
/*      */         
/*      */         public ForErrorHandler(Plugin.Engine.ErrorHandler param3ErrorHandler) {
/* 2012 */           this.errorHandler = param3ErrorHandler;
/*      */         }
/*      */ 
/*      */         
/*      */         public void onError(TypeDescription param3TypeDescription, Plugin param3Plugin, Throwable param3Throwable) {
/* 2017 */           this.errorHandler.onError(param3TypeDescription, param3Plugin, param3Throwable);
/*      */         }
/*      */ 
/*      */         
/*      */         public void onError(TypeDescription param3TypeDescription, List<Throwable> param3List) {
/* 2022 */           this.errorHandler.onError(param3TypeDescription, param3List);
/*      */         }
/*      */ 
/*      */         
/*      */         public void onError(Map<TypeDescription, List<Throwable>> param3Map) {
/* 2027 */           this.errorHandler.onError(param3Map);
/*      */         }
/*      */ 
/*      */         
/*      */         public void onError(Plugin param3Plugin, Throwable param3Throwable) {
/* 2032 */           this.errorHandler.onError(param3Plugin, param3Throwable);
/*      */         }
/*      */ 
/*      */         
/*      */         public void onLiveInitializer(TypeDescription param3TypeDescription1, TypeDescription param3TypeDescription2) {
/* 2037 */           this.errorHandler.onLiveInitializer(param3TypeDescription1, param3TypeDescription2);
/*      */         }
/*      */ 
/*      */         
/*      */         public void onUnresolved(String param3String) {
/* 2042 */           this.errorHandler.onUnresolved(param3String);
/*      */         }
/*      */ 
/*      */         
/*      */         public void onManifest(@MaybeNull Manifest param3Manifest) {
/* 2047 */           this.errorHandler.onManifest(param3Manifest);
/*      */         }
/*      */ 
/*      */         
/*      */         public void onResource(String param3String) {
/* 2052 */           this.errorHandler.onResource(param3String);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.errorHandler.equals(((ForErrorHandler)param3Object).errorHandler))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.errorHandler.hashCode();
/*      */         }
/*      */       }
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class Compound
/*      */         implements Listener
/*      */       {
/*      */         public Compound(Plugin.Engine.Listener... param3VarArgs) {
/* 2073 */           this(Arrays.asList(param3VarArgs));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2082 */         private final List<Plugin.Engine.Listener> listeners = new ArrayList<Plugin.Engine.Listener>(); public Compound(List<? extends Plugin.Engine.Listener> param3List) {
/* 2083 */           for (Iterator<? extends Plugin.Engine.Listener> iterator = param3List.iterator(); iterator.hasNext(); ) {
/* 2084 */             Plugin.Engine.Listener listener; if (listener = iterator.next() instanceof Compound) {
/* 2085 */               this.listeners.addAll(((Compound)listener).listeners); continue;
/* 2086 */             }  if (!(listener instanceof Plugin.Engine.Listener.NoOp)) {
/* 2087 */               this.listeners.add(listener);
/*      */             }
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onDiscovery(String param3String) {
/* 2096 */           for (Iterator<Plugin.Engine.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 2097 */             (listener = iterator.next()).onDiscovery(param3String);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onTransformation(TypeDescription param3TypeDescription, Plugin param3Plugin) {
/* 2105 */           for (Iterator<Plugin.Engine.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 2106 */             (listener = iterator.next()).onTransformation(param3TypeDescription, param3Plugin);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onTransformation(TypeDescription param3TypeDescription, List<Plugin> param3List) {
/* 2114 */           for (Iterator<Plugin.Engine.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 2115 */             (listener = iterator.next()).onTransformation(param3TypeDescription, param3List);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onIgnored(TypeDescription param3TypeDescription, Plugin param3Plugin) {
/* 2123 */           for (Iterator<Plugin.Engine.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 2124 */             (listener = iterator.next()).onIgnored(param3TypeDescription, param3Plugin);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onIgnored(TypeDescription param3TypeDescription, List<Plugin> param3List) {
/* 2132 */           for (Iterator<Plugin.Engine.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 2133 */             (listener = iterator.next()).onIgnored(param3TypeDescription, param3List);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onError(TypeDescription param3TypeDescription, Plugin param3Plugin, Throwable param3Throwable) {
/* 2141 */           for (Iterator<Plugin.Engine.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 2142 */             (listener = iterator.next()).onError(param3TypeDescription, param3Plugin, param3Throwable);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onError(TypeDescription param3TypeDescription, List<Throwable> param3List) {
/* 2150 */           for (Iterator<Plugin.Engine.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 2151 */             (listener = iterator.next()).onError(param3TypeDescription, param3List);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onError(Map<TypeDescription, List<Throwable>> param3Map) {
/* 2159 */           for (Iterator<Plugin.Engine.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 2160 */             (listener = iterator.next()).onError(param3Map);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onError(Plugin param3Plugin, Throwable param3Throwable) {
/* 2168 */           for (Iterator<Plugin.Engine.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 2169 */             (listener = iterator.next()).onError(param3Plugin, param3Throwable);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onLiveInitializer(TypeDescription param3TypeDescription1, TypeDescription param3TypeDescription2) {
/* 2177 */           for (Iterator<Plugin.Engine.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 2178 */             (listener = iterator.next()).onLiveInitializer(param3TypeDescription1, param3TypeDescription2);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onComplete(TypeDescription param3TypeDescription) {
/* 2186 */           for (Iterator<Plugin.Engine.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 2187 */             (listener = iterator.next()).onComplete(param3TypeDescription);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onUnresolved(String param3String) {
/* 2195 */           for (Iterator<Plugin.Engine.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 2196 */             (listener = iterator.next()).onUnresolved(param3String);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onManifest(@MaybeNull Manifest param3Manifest) {
/* 2204 */           for (Iterator<Plugin.Engine.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 2205 */             (listener = iterator.next()).onManifest(param3Manifest);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onResource(String param3String) {
/* 2213 */           for (Iterator<Plugin.Engine.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 2214 */             (listener = iterator.next()).onResource(param3String);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.listeners.equals(((Compound)param3Object).listeners))));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.listeners.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public static interface Source
/*      */     {
/*      */       Origin read();
/*      */ 
/*      */       
/*      */       public static interface Origin
/*      */         extends Closeable, Iterable<Element>
/*      */       {
/*      */         @AlwaysNull
/* 2242 */         public static final Manifest NO_MANIFEST = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         Manifest getManifest();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         ClassFileLocator getClassFileLocator();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static class ForJarFile
/*      */           implements Origin
/*      */         {
/*      */           private final JarFile file;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public ForJarFile(JarFile param4JarFile) {
/* 2277 */             this.file = param4JarFile;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           public Manifest getManifest() {
/* 2285 */             return this.file.getManifest();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public ClassFileLocator getClassFileLocator() {
/* 2292 */             return (ClassFileLocator)new ClassFileLocator.ForJarFile(this.file);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void close() {
/* 2299 */             this.file.close();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Iterator<Plugin.Engine.Source.Element> iterator() {
/* 2306 */             return new JarFileIterator(this, this.file.entries());
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected class JarFileIterator
/*      */             implements Iterator<Plugin.Engine.Source.Element>
/*      */           {
/*      */             private final Enumeration<JarEntry> enumeration;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected JarFileIterator(Plugin.Engine.Source.Origin.ForJarFile this$0, Enumeration<JarEntry> param5Enumeration) {
/* 2325 */               this.enumeration = param5Enumeration;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean hasNext() {
/* 2332 */               return this.enumeration.hasMoreElements();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public Plugin.Engine.Source.Element next() {
/* 2339 */               return new Plugin.Engine.Source.Element.ForJarEntry(Plugin.Engine.Source.Origin.ForJarFile.a(this.a), this.enumeration.nextElement());
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public void remove() {
/* 2346 */               throw new UnsupportedOperationException("remove");
/*      */             }
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class Filtering
/*      */           implements Origin
/*      */         {
/*      */           private final Plugin.Engine.Source.Origin delegate;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final ElementMatcher<Plugin.Engine.Source.Element> matcher;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final boolean manifest;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Filtering(Plugin.Engine.Source.Origin param4Origin, ElementMatcher<Plugin.Engine.Source.Element> param4ElementMatcher) {
/* 2379 */             this(param4Origin, param4ElementMatcher, true);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Filtering(Plugin.Engine.Source.Origin param4Origin, ElementMatcher<Plugin.Engine.Source.Element> param4ElementMatcher, boolean param4Boolean) {
/* 2390 */             this.delegate = param4Origin;
/* 2391 */             this.matcher = param4ElementMatcher;
/* 2392 */             this.manifest = param4Boolean;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           public Manifest getManifest() {
/* 2400 */             return this.manifest ? this.delegate.getManifest() : NO_MANIFEST;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public ClassFileLocator getClassFileLocator() {
/* 2407 */             return this.delegate.getClassFileLocator();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void close() {
/* 2414 */             this.delegate.close();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Iterator<Plugin.Engine.Source.Element> iterator() {
/* 2421 */             return new FilteringIterator(this.delegate.iterator(), this.matcher, (byte)0);
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : ((this.manifest != ((Filtering)param4Object).manifest) ? false : (!this.delegate.equals(((Filtering)param4Object).delegate) ? false : (!!this.matcher.equals(((Filtering)param4Object).matcher))))));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return ((getClass().hashCode() * 31 + this.delegate.hashCode()) * 31 + this.matcher.hashCode()) * 31 + this.manifest;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           private static class FilteringIterator
/*      */             implements Iterator<Plugin.Engine.Source.Element>
/*      */           {
/*      */             private final Iterator<Plugin.Engine.Source.Element> iterator;
/*      */ 
/*      */             
/*      */             private final ElementMatcher<Plugin.Engine.Source.Element> matcher;
/*      */ 
/*      */             
/*      */             @MaybeNull
/*      */             private Plugin.Engine.Source.Element current;
/*      */ 
/*      */             
/*      */             private FilteringIterator(Iterator<Plugin.Engine.Source.Element> param5Iterator, ElementMatcher<Plugin.Engine.Source.Element> param5ElementMatcher) {
/* 2452 */               this.iterator = param5Iterator;
/* 2453 */               this.matcher = param5ElementMatcher;
/*      */               
/* 2455 */               while (param5Iterator.hasNext()) {
/* 2456 */                 Plugin.Engine.Source.Element element = param5Iterator.next();
/* 2457 */                 if (param5ElementMatcher.matches(element)) {
/* 2458 */                   this.current = element;
/*      */                   break;
/*      */                 } 
/*      */               } 
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean hasNext() {
/* 2468 */               return (this.current != null);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public Plugin.Engine.Source.Element next() {
/* 2475 */               if (this.current == null) {
/* 2476 */                 throw new NoSuchElementException();
/*      */               }
/*      */               try {
/* 2479 */                 return this.current;
/*      */               } finally {
/* 2481 */                 this.current = null;
/*      */                 
/* 2483 */                 while (this.iterator.hasNext()) {
/* 2484 */                   Plugin.Engine.Source.Element element = this.iterator.next();
/* 2485 */                   if (this.matcher.matches(element)) {
/* 2486 */                     this.current = element;
/*      */                     break;
/*      */                   } 
/*      */                 } 
/*      */               } 
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public void remove() {
/* 2497 */               this.iterator.remove();
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static interface Element
/*      */       {
/*      */         String getName();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         InputStream getInputStream();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         <T> T resolveAs(Class<T> param3Class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         @SuppressFBWarnings(value = {"EI_EXPOSE_REP2"}, justification = "The array is not modified by class contract.")
/*      */         public static class ForByteArray
/*      */           implements Element
/*      */         {
/*      */           private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final byte[] binaryRepresentation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public ForByteArray(String param4String, byte[] param4ArrayOfbyte) {
/* 2558 */             this.name = param4String;
/* 2559 */             this.binaryRepresentation = param4ArrayOfbyte;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public String getName() {
/* 2566 */             return this.name;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public InputStream getInputStream() {
/* 2573 */             return new ByteArrayInputStream(this.binaryRepresentation);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @AlwaysNull
/*      */           public <T> T resolveAs(Class<T> param4Class) {
/* 2581 */             return null;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.name.equals(((ForByteArray)param4Object).name) ? false : (!!Arrays.equals(this.binaryRepresentation, ((ForByteArray)param4Object).binaryRepresentation)))));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return (getClass().hashCode() * 31 + this.name.hashCode()) * 31 + Arrays.hashCode(this.binaryRepresentation);
/*      */           }
/*      */         }
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class ForFile
/*      */           implements Element
/*      */         {
/*      */           private final File root;
/*      */           
/*      */           private final File file;
/*      */ 
/*      */           
/*      */           public ForFile(File param4File1, File param4File2) {
/* 2608 */             this.root = param4File1;
/* 2609 */             this.file = param4File2;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public String getName() {
/* 2616 */             return this.root.getAbsoluteFile().toURI().relativize(this.file.getAbsoluteFile().toURI()).getPath();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public InputStream getInputStream() {
/* 2623 */             return new FileInputStream(this.file);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           public <T> T resolveAs(Class<T> param4Class) {
/* 2632 */             return (T)(File.class.isAssignableFrom(param4Class) ? this.file : null);
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.root.equals(((ForFile)param4Object).root) ? false : (!!this.file.equals(((ForFile)param4Object).file)))));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return (getClass().hashCode() * 31 + this.root.hashCode()) * 31 + this.file.hashCode();
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class ForJarEntry
/*      */           implements Element
/*      */         {
/*      */           private final JarFile file;
/*      */ 
/*      */           
/*      */           private final JarEntry entry;
/*      */ 
/*      */           
/*      */           public ForJarEntry(JarFile param4JarFile, JarEntry param4JarEntry) {
/* 2661 */             this.file = param4JarFile;
/* 2662 */             this.entry = param4JarEntry;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public String getName() {
/* 2669 */             return this.entry.getName();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public InputStream getInputStream() {
/* 2676 */             return this.file.getInputStream(this.entry);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           public <T> T resolveAs(Class<T> param4Class) {
/* 2685 */             return (T)(JarEntry.class.isAssignableFrom(param4Class) ? this.entry : null);
/*      */           }
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.file.equals(((ForJarEntry)param4Object).file) ? false : (!!this.entry.equals(((ForJarEntry)param4Object).entry)))));
/*      */           }
/*      */           
/*      */           public int hashCode() {
/*      */             return (getClass().hashCode() * 31 + this.file.hashCode()) * 31 + this.entry.hashCode();
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*      */       public enum Empty
/*      */         implements Source, Origin {
/* 2700 */         INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final Plugin.Engine.Source.Origin read() {
/* 2706 */           return this;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final ClassFileLocator getClassFileLocator() {
/* 2713 */           return (ClassFileLocator)ClassFileLocator.NoOp.INSTANCE;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public final Manifest getManifest() {
/* 2721 */           return NO_MANIFEST;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final Iterator<Plugin.Engine.Source.Element> iterator() {
/* 2728 */           return Collections.<Plugin.Engine.Source.Element>emptySet().iterator();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void close() {}
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class Compound
/*      */         implements Source
/*      */       {
/*      */         private final Collection<? extends Plugin.Engine.Source> sources;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Compound(Collection<? extends Plugin.Engine.Source> param3Collection) {
/* 2756 */           this.sources = param3Collection;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public Plugin.Engine.Source.Origin read() {
/*      */           Plugin.Engine.Source.Origin origin;
/* 2763 */           if (this.sources.isEmpty()) {
/* 2764 */             return Plugin.Engine.Source.Empty.INSTANCE;
/*      */           }
/* 2766 */           ArrayList<Plugin.Engine.Source.Origin> arrayList = new ArrayList(this.sources.size());
/*      */           try {
/* 2768 */             for (Plugin.Engine.Source source : this.sources) {
/* 2769 */               arrayList.add(source.read());
/*      */             }
/* 2771 */           } catch (IOException iOException) {
/* 2772 */             for (Iterator<Plugin.Engine.Source.Origin> iterator = arrayList.iterator(); iterator.hasNext();) {
/* 2773 */               (origin = iterator.next()).close();
/*      */             }
/* 2775 */             throw iOException;
/*      */           } 
/* 2777 */           return new Origin((List<Plugin.Engine.Source.Origin>)origin);
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.sources.equals(((Compound)param3Object).sources))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.sources.hashCode();
/*      */         }
/*      */         
/*      */         @Enhance
/*      */         protected static class Origin
/*      */           implements Plugin.Engine.Source.Origin
/*      */         {
/*      */           private final List<Plugin.Engine.Source.Origin> origins;
/*      */           
/*      */           protected Origin(List<Plugin.Engine.Source.Origin> param4List) {
/* 2797 */             this.origins = param4List;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Manifest getManifest() {
/* 2804 */             for (Iterator<Plugin.Engine.Source.Origin> iterator = this.origins.iterator(); iterator.hasNext();) {
/*      */               
/* 2806 */               if ((manifest = (origin = iterator.next()).getManifest()) != null) {
/* 2807 */                 return manifest;
/*      */               }
/*      */             } 
/* 2810 */             return NO_MANIFEST;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public ClassFileLocator getClassFileLocator() {
/* 2817 */             ArrayList<ClassFileLocator> arrayList = new ArrayList(this.origins.size());
/* 2818 */             for (Plugin.Engine.Source.Origin origin : this.origins) {
/* 2819 */               arrayList.add(origin.getClassFileLocator());
/*      */             }
/* 2821 */             return (ClassFileLocator)new ClassFileLocator.Compound(arrayList);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Iterator<Plugin.Engine.Source.Element> iterator() {
/* 2828 */             return new CompoundIterator((List)this.origins);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void close() {
/* 2835 */             for (Iterator<Plugin.Engine.Source.Origin> iterator = this.origins.iterator(); iterator.hasNext();) {
/* 2836 */               (origin = iterator.next()).close();
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.origins.equals(((Origin)param4Object).origins))));
/*      */           }
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.origins.hashCode();
/*      */           }
/*      */ 
/*      */           
/*      */           protected static class CompoundIterator
/*      */             implements Iterator<Plugin.Engine.Source.Element>
/*      */           {
/*      */             @MaybeNull
/*      */             private Iterator<? extends Plugin.Engine.Source.Element> current;
/*      */             
/*      */             private final List<? extends Iterable<? extends Plugin.Engine.Source.Element>> backlog;
/*      */ 
/*      */             
/*      */             protected CompoundIterator(List<? extends Iterable<? extends Plugin.Engine.Source.Element>> param5List) {
/* 2862 */               this.backlog = param5List;
/* 2863 */               forward();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean hasNext() {
/* 2870 */               return (this.current != null && this.current.hasNext());
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public Plugin.Engine.Source.Element next() {
/*      */               try {
/* 2878 */                 if (this.current != null) {
/* 2879 */                   return this.current.next();
/*      */                 }
/* 2881 */                 throw new NoSuchElementException();
/*      */               } finally {
/*      */                 
/* 2884 */                 forward();
/*      */               } 
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private void forward() {
/* 2892 */               while ((this.current == null || !this.current.hasNext()) && !this.backlog.isEmpty()) {
/* 2893 */                 this.current = ((Iterable<? extends Plugin.Engine.Source.Element>)this.backlog.remove(0)).iterator();
/*      */               }
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public void remove() {
/* 2901 */               throw new UnsupportedOperationException("remove");
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class InMemory
/*      */         implements Source, Origin
/*      */       {
/*      */         private final Map<String, byte[]> storage;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public InMemory(Map<String, byte[]> param3Map) {
/* 2924 */           this.storage = param3Map;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static Plugin.Engine.Source ofTypes(Class<?>... param3VarArgs) {
/* 2934 */           return ofTypes(Arrays.asList(param3VarArgs));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static Plugin.Engine.Source ofTypes(Collection<? extends Class<?>> param3Collection) {
/* 2944 */           HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 2945 */           for (Class<?> clazz : param3Collection) {
/* 2946 */             hashMap.put(TypeDescription.ForLoadedType.of(clazz), ClassFileLocator.ForClassLoader.read(clazz));
/*      */           }
/* 2948 */           return ofTypes((Map)hashMap);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static Plugin.Engine.Source ofTypes(Map<TypeDescription, byte[]> param3Map) {
/* 2958 */           HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 2959 */           for (Map.Entry<TypeDescription, byte> entry : param3Map.entrySet()) {
/* 2960 */             hashMap.put(((TypeDescription)entry.getKey()).getInternalName() + ".class", entry.getValue());
/*      */           }
/* 2962 */           return new InMemory((Map)hashMap);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Plugin.Engine.Source.Origin read() {
/* 2969 */           return this;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ClassFileLocator getClassFileLocator() {
/* 2976 */           return ClassFileLocator.Simple.ofResources(this.storage);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public Manifest getManifest() {
/*      */           byte[] arrayOfByte;
/* 2985 */           if ((arrayOfByte = this.storage.get("META-INF/MANIFEST.MF")) == null) {
/* 2986 */             return NO_MANIFEST;
/*      */           }
/* 2988 */           return new Manifest(new ByteArrayInputStream(arrayOfByte));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Iterator<Plugin.Engine.Source.Element> iterator() {
/* 2996 */           return new MapEntryIterator(this.storage.entrySet().iterator());
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public void close() {}
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.storage.equals(((InMemory)param3Object).storage))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.storage.hashCode();
/*      */         }
/*      */ 
/*      */         
/*      */         protected static class MapEntryIterator
/*      */           implements Iterator<Plugin.Engine.Source.Element>
/*      */         {
/*      */           private final Iterator<Map.Entry<String, byte[]>> iterator;
/*      */ 
/*      */           
/*      */           protected MapEntryIterator(Iterator<Map.Entry<String, byte[]>> param4Iterator) {
/* 3022 */             this.iterator = param4Iterator;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean hasNext() {
/* 3029 */             return this.iterator.hasNext();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Plugin.Engine.Source.Element next() {
/* 3036 */             Map.Entry entry = this.iterator.next();
/* 3037 */             return new Plugin.Engine.Source.Element.ForByteArray((String)entry.getKey(), (byte[])entry.getValue());
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void remove() {
/* 3044 */             throw new UnsupportedOperationException("remove");
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class ForFolder
/*      */         implements Source, Origin
/*      */       {
/*      */         private final File folder;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ForFolder(File param3File) {
/* 3066 */           this.folder = param3File;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Plugin.Engine.Source.Origin read() {
/* 3075 */           return this;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ClassFileLocator getClassFileLocator() {
/* 3082 */           return (ClassFileLocator)new ClassFileLocator.ForFolder(this.folder);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public Manifest getManifest() {
/*      */           File file;
/* 3091 */           if ((file = new File(this.folder, "META-INF/MANIFEST.MF")).exists()) {
/* 3092 */             FileInputStream fileInputStream = new FileInputStream(file);
/*      */             try {
/* 3094 */               return new Manifest(fileInputStream);
/*      */             } finally {
/* 3096 */               fileInputStream.close();
/*      */             } 
/*      */           } 
/* 3099 */           return NO_MANIFEST;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Iterator<Plugin.Engine.Source.Element> iterator() {
/* 3107 */           return new FolderIterator(this, this.folder);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public void close() {}
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.folder.equals(((ForFolder)param3Object).folder))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.folder.hashCode();
/*      */         }
/*      */ 
/*      */         
/*      */         protected class FolderIterator
/*      */           implements Iterator<Plugin.Engine.Source.Element>
/*      */         {
/*      */           private final List<File> files;
/*      */ 
/*      */           
/*      */           protected FolderIterator(Plugin.Engine.Source.ForFolder this$0, File param4File) {
/* 3133 */             this.files = new ArrayList<File>(Collections.singleton(param4File));
/*      */             
/*      */             do {
/*      */               File[] arrayOfFile;
/*      */               File file;
/* 3138 */               if ((arrayOfFile = (file = this.files.remove(this.files.size() - 1)).listFiles()) == null)
/* 3139 */                 continue;  this.files.addAll(Arrays.asList(arrayOfFile));
/*      */             }
/* 3141 */             while (!this.files.isEmpty() && (((File)this.files.get(this.files.size() - 1)).isDirectory() || ((File)this.files.get(this.files.size() - 1)).equals(new File(param4File, "META-INF/MANIFEST.MF"))));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean hasNext() {
/* 3148 */             return !this.files.isEmpty();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @SuppressFBWarnings(value = {"IT_NO_SUCH_ELEMENT"}, justification = "Exception is thrown by invoking removeFirst on an empty list.")
/*      */           public Plugin.Engine.Source.Element next() {
/*      */             try {
/* 3157 */               return new Plugin.Engine.Source.Element.ForFile(Plugin.Engine.Source.ForFolder.a(this.a), this.files.remove(this.files.size() - 1));
/*      */             } finally {
/* 3159 */               while (!this.files.isEmpty() && (((File)this.files.get(this.files.size() - 1)).isDirectory() || ((File)this.files.get(this.files.size() - 1)).equals(new File(Plugin.Engine.Source.ForFolder.a(this.a), "META-INF/MANIFEST.MF")))) {
/*      */                 File file;
/*      */                 File[] arrayOfFile;
/* 3162 */                 if ((arrayOfFile = (file = this.files.remove(this.files.size() - 1)).listFiles()) != null) {
/* 3163 */                   this.files.addAll(Arrays.asList(arrayOfFile));
/*      */                 }
/*      */               } 
/*      */             } 
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void remove() {
/* 3173 */             throw new UnsupportedOperationException("remove");
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class ForJarFile
/*      */         implements Source
/*      */       {
/*      */         private final File file;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ForJarFile(File param3File) {
/* 3195 */           this.file = param3File;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Plugin.Engine.Source.Origin read() {
/* 3202 */           return new Plugin.Engine.Source.Origin.ForJarFile(new JarFile(this.file));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.file.equals(((ForJarFile)param3Object).file))));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.file.hashCode();
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class Filtering
/*      */         implements Source
/*      */       {
/*      */         private final Plugin.Engine.Source delegate;
/*      */ 
/*      */         
/*      */         private final ElementMatcher<Plugin.Engine.Source.Element> matcher;
/*      */ 
/*      */         
/*      */         private final boolean manifest;
/*      */ 
/*      */         
/*      */         public Filtering(Plugin.Engine.Source param3Source, ElementMatcher<Plugin.Engine.Source.Element> param3ElementMatcher) {
/* 3234 */           this(param3Source, param3ElementMatcher, true);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Filtering(Plugin.Engine.Source param3Source, ElementMatcher<Plugin.Engine.Source.Element> param3ElementMatcher, boolean param3Boolean) {
/* 3245 */           this.delegate = param3Source;
/* 3246 */           this.matcher = param3ElementMatcher;
/* 3247 */           this.manifest = param3Boolean;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Plugin.Engine.Source.Origin read() {
/* 3254 */           return new Plugin.Engine.Source.Origin.Filtering(this.delegate.read(), this.matcher, this.manifest);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.manifest != ((Filtering)param3Object).manifest) ? false : (!this.delegate.equals(((Filtering)param3Object).delegate) ? false : (!!this.matcher.equals(((Filtering)param3Object).matcher))))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return ((getClass().hashCode() * 31 + this.delegate.hashCode()) * 31 + this.matcher.hashCode()) * 31 + this.manifest;
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface Target
/*      */     {
/*      */       Sink write(@MaybeNull Manifest param2Manifest);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static interface Sink
/*      */         extends Closeable
/*      */       {
/*      */         void store(Map<TypeDescription, byte[]> param3Map);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         void retain(Plugin.Engine.Source.Element param3Element);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static class ForJarOutputStream
/*      */           implements Sink
/*      */         {
/*      */           private final JarOutputStream outputStream;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public ForJarOutputStream(JarOutputStream param4JarOutputStream) {
/* 3310 */             this.outputStream = param4JarOutputStream;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void store(Map<TypeDescription, byte[]> param4Map) {
/* 3317 */             for (Map.Entry<TypeDescription, byte> entry : param4Map.entrySet()) {
/* 3318 */               this.outputStream.putNextEntry(new JarEntry(((TypeDescription)entry.getKey()).getInternalName() + ".class"));
/* 3319 */               this.outputStream.write((byte[])entry.getValue());
/* 3320 */               this.outputStream.closeEntry();
/*      */             } 
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void retain(Plugin.Engine.Source.Element param4Element) {
/* 3328 */             JarEntry jarEntry = param4Element.<JarEntry>resolveAs(JarEntry.class);
/* 3329 */             this.outputStream.putNextEntry((jarEntry == null) ? new JarEntry(param4Element
/* 3330 */                   .getName()) : jarEntry);
/*      */             
/* 3332 */             InputStream inputStream = param4Element.getInputStream();
/*      */             try {
/* 3334 */               byte[] arrayOfByte = new byte[1024];
/*      */               int i;
/* 3336 */               while ((i = inputStream.read(arrayOfByte)) != -1) {
/* 3337 */                 this.outputStream.write(arrayOfByte, 0, i);
/*      */               }
/*      */             } finally {
/* 3340 */               inputStream.close();
/*      */             } 
/* 3342 */             this.outputStream.closeEntry();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void close() {
/* 3349 */             this.outputStream.close();
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum Discarding
/*      */         implements Target, Sink
/*      */       {
/* 3362 */         INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final Plugin.Engine.Target.Sink write(@MaybeNull Manifest param3Manifest) {
/* 3368 */           return this;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void store(Map<TypeDescription, byte[]> param3Map) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void retain(Plugin.Engine.Source.Element param3Element) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void close() {}
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class InMemory
/*      */         implements Target, Sink
/*      */       {
/*      */         private final Map<String, byte[]> storage;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public InMemory() {
/* 3408 */           this((Map)new HashMap<String, byte>());
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public InMemory(Map<String, byte[]> param3Map) {
/* 3417 */           this.storage = param3Map;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Plugin.Engine.Target.Sink write(@MaybeNull Manifest param3Manifest) {
/* 3424 */           if (param3Manifest != null) {
/* 3425 */             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*      */             try {
/* 3427 */               param3Manifest.write(byteArrayOutputStream);
/*      */             } finally {
/* 3429 */               byteArrayOutputStream.close();
/*      */             } 
/* 3431 */             this.storage.put("META-INF/MANIFEST.MF", byteArrayOutputStream.toByteArray());
/*      */           } 
/* 3433 */           return this;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void store(Map<TypeDescription, byte[]> param3Map) {
/* 3440 */           for (Map.Entry<TypeDescription, byte> entry : param3Map.entrySet()) {
/* 3441 */             this.storage.put(((TypeDescription)entry.getKey()).getInternalName() + ".class", (byte[])entry.getValue());
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void retain(Plugin.Engine.Source.Element param3Element) {
/*      */           String str;
/* 3450 */           if (!(str = param3Element.getName()).endsWith("/")) {
/* 3451 */             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*      */             try {
/* 3453 */               InputStream inputStream = param3Element.getInputStream();
/*      */               try {
/* 3455 */                 byte[] arrayOfByte = new byte[1024];
/*      */                 int i;
/* 3457 */                 while ((i = inputStream.read(arrayOfByte)) != -1) {
/* 3458 */                   byteArrayOutputStream.write(arrayOfByte, 0, i);
/*      */                 }
/*      */               } finally {
/* 3461 */                 inputStream.close();
/*      */               } 
/*      */             } finally {
/* 3464 */               byteArrayOutputStream.close();
/*      */             } 
/* 3466 */             this.storage.put(param3Element.getName(), byteArrayOutputStream.toByteArray());
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void close() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Map<String, byte[]> getStorage() {
/* 3483 */           return this.storage;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Map<String, byte[]> toTypeMap() {
/* 3492 */           HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 3493 */           for (Iterator<Map.Entry> iterator = this.storage.entrySet().iterator(); iterator.hasNext();) {
/* 3494 */             if (((String)(entry = iterator.next()).getKey()).endsWith(".class")) {
/* 3495 */               hashMap.put(((String)entry.getKey())
/* 3496 */                   .substring(0, ((String)entry.getKey()).length() - 6)
/* 3497 */                   .replace('/', '.'), entry.getValue());
/*      */             }
/*      */           } 
/* 3500 */           return (Map)hashMap;
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.storage.equals(((InMemory)param3Object).storage))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.storage.hashCode();
/*      */         }
/*      */       }
/*      */       
/*      */       @Enhance
/*      */       public static class ForFolder
/*      */         implements Target, Sink
/*      */       {
/*      */         private final File folder;
/*      */         
/*      */         public ForFolder(File param3File) {
/* 3521 */           this.folder = param3File;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Plugin.Engine.Target.Sink write(@MaybeNull Manifest param3Manifest) {
/* 3528 */           if (param3Manifest != null) {
/*      */             File file;
/* 3530 */             if (!(file = new File(this.folder, "META-INF/MANIFEST.MF")).getParentFile().isDirectory() && !file.getParentFile().mkdirs()) {
/* 3531 */               throw new IOException("Could not create directory: " + file.getParent());
/*      */             }
/* 3533 */             FileOutputStream fileOutputStream = new FileOutputStream(file);
/*      */             try {
/* 3535 */               param3Manifest.write(fileOutputStream);
/*      */             } finally {
/* 3537 */               fileOutputStream.close();
/*      */             } 
/*      */           } 
/* 3540 */           return this;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void store(Map<TypeDescription, byte[]> param3Map) {
/*      */           // Byte code:
/*      */           //   0: aload_1
/*      */           //   1: invokeinterface entrySet : ()Ljava/util/Set;
/*      */           //   6: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */           //   11: astore_1
/*      */           //   12: aload_1
/*      */           //   13: invokeinterface hasNext : ()Z
/*      */           //   18: ifeq -> 165
/*      */           //   21: aload_1
/*      */           //   22: invokeinterface next : ()Ljava/lang/Object;
/*      */           //   27: checkcast java/util/Map$Entry
/*      */           //   30: astore_2
/*      */           //   31: new java/io/File
/*      */           //   34: dup
/*      */           //   35: aload_0
/*      */           //   36: getfield folder : Ljava/io/File;
/*      */           //   39: new java/lang/StringBuilder
/*      */           //   42: dup
/*      */           //   43: invokespecial <init> : ()V
/*      */           //   46: aload_2
/*      */           //   47: invokeinterface getKey : ()Ljava/lang/Object;
/*      */           //   52: checkcast net/bytebuddy/description/type/TypeDescription
/*      */           //   55: invokeinterface getInternalName : ()Ljava/lang/String;
/*      */           //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */           //   63: ldc '.class'
/*      */           //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */           //   68: invokevirtual toString : ()Ljava/lang/String;
/*      */           //   71: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
/*      */           //   74: dup
/*      */           //   75: astore_3
/*      */           //   76: invokevirtual getParentFile : ()Ljava/io/File;
/*      */           //   79: invokevirtual isDirectory : ()Z
/*      */           //   82: ifne -> 122
/*      */           //   85: aload_3
/*      */           //   86: invokevirtual getParentFile : ()Ljava/io/File;
/*      */           //   89: invokevirtual mkdirs : ()Z
/*      */           //   92: ifne -> 122
/*      */           //   95: new java/io/IOException
/*      */           //   98: dup
/*      */           //   99: new java/lang/StringBuilder
/*      */           //   102: dup
/*      */           //   103: ldc 'Could not create directory: '
/*      */           //   105: invokespecial <init> : (Ljava/lang/String;)V
/*      */           //   108: aload_3
/*      */           //   109: invokevirtual getParent : ()Ljava/lang/String;
/*      */           //   112: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */           //   115: invokevirtual toString : ()Ljava/lang/String;
/*      */           //   118: invokespecial <init> : (Ljava/lang/String;)V
/*      */           //   121: athrow
/*      */           //   122: new java/io/FileOutputStream
/*      */           //   125: dup
/*      */           //   126: aload_3
/*      */           //   127: invokespecial <init> : (Ljava/io/File;)V
/*      */           //   130: astore_3
/*      */           //   131: aload_3
/*      */           //   132: aload_2
/*      */           //   133: invokeinterface getValue : ()Ljava/lang/Object;
/*      */           //   138: checkcast [B
/*      */           //   141: invokevirtual write : ([B)V
/*      */           //   144: jsr -> 158
/*      */           //   147: goto -> 12
/*      */           //   150: astore #4
/*      */           //   152: jsr -> 158
/*      */           //   155: aload #4
/*      */           //   157: athrow
/*      */           //   158: astore_2
/*      */           //   159: aload_3
/*      */           //   160: invokevirtual close : ()V
/*      */           //   163: ret #2
/*      */           //   165: return
/*      */           // Line number table:
/*      */           //   Java source line number -> byte code offset
/*      */           //   #3547	-> 0
/*      */           //   #3548	-> 31
/*      */           //   #3549	-> 75
/*      */           //   #3550	-> 95
/*      */           //   #3552	-> 122
/*      */           //   #3554	-> 131
/*      */           //   #3555	-> 144
/*      */           //   #3557	-> 147
/*      */           //   #3556	-> 150
/*      */           //   #3557	-> 155
/*      */           //   #3556	-> 159
/*      */           //   #3559	-> 165
/*      */           // Exception table:
/*      */           //   from	to	target	type
/*      */           //   131	147	150	finally
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void retain(Plugin.Engine.Source.Element param3Element) {
/*      */           String str;
/* 3566 */           if (!(str = param3Element.getName()).endsWith("/")) {
/* 3567 */             File file1 = new File(this.folder, str), file2 = param3Element.<File>resolveAs(File.class);
/* 3568 */             if (!file1.getCanonicalPath().startsWith(this.folder.getCanonicalPath() + File.separatorChar))
/* 3569 */               throw new IllegalArgumentException(file1 + " is not a subdirectory of " + this.folder); 
/* 3570 */             if (!file1.getParentFile().isDirectory() && !file1.getParentFile().mkdirs())
/* 3571 */               throw new IOException("Could not create directory: " + file1.getParent()); 
/* 3572 */             if (file2 != null && !file2.equals(file1)) {
/* 3573 */               FileSystem.getInstance().copy(file2, file1); return;
/* 3574 */             }  if (!file1.equals(file2)) {
/* 3575 */               InputStream inputStream = param3Element.getInputStream();
/*      */               try {
/* 3577 */                 FileOutputStream fileOutputStream = new FileOutputStream(file1);
/*      */                 try {
/* 3579 */                   byte[] arrayOfByte = new byte[1024];
/*      */                   int i;
/* 3581 */                   while ((i = inputStream.read(arrayOfByte)) != -1) {
/* 3582 */                     fileOutputStream.write(arrayOfByte, 0, i);
/*      */                   }
/*      */                 } finally {
/* 3585 */                   fileOutputStream.close();
/*      */                 }  return;
/*      */               } finally {
/* 3588 */                 inputStream.close();
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public void close() {}
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.folder.equals(((ForFolder)param3Object).folder))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.folder.hashCode();
/*      */         }
/*      */       }
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class ForJarFile
/*      */         implements Target
/*      */       {
/*      */         private final File file;
/*      */ 
/*      */         
/*      */         public ForJarFile(File param3File) {
/* 3619 */           this.file = param3File;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Plugin.Engine.Target.Sink write(@MaybeNull Manifest param3Manifest) {
/* 3626 */           return (param3Manifest == null) ? new Plugin.Engine.Target.Sink.ForJarOutputStream(new JarOutputStream(new FileOutputStream(this.file))) : new Plugin.Engine.Target.Sink.ForJarOutputStream(new JarOutputStream(new FileOutputStream(this.file), param3Manifest));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.file.equals(((ForJarFile)param3Object).file))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.file.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface Dispatcher
/*      */       extends Closeable
/*      */     {
/*      */       void accept(Callable<? extends Callable<? extends Materializable>> param2Callable, boolean param2Boolean);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void complete();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static interface Materializable
/*      */       {
/*      */         void materialize(Plugin.Engine.Target.Sink param3Sink, List<TypeDescription> param3List, Map<TypeDescription, List<Throwable>> param3Map, List<String> param3List1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static class ForTransformedElement
/*      */           implements Materializable
/*      */         {
/*      */           private final DynamicType dynamicType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected ForTransformedElement(DynamicType param4DynamicType) {
/* 3692 */             this.dynamicType = param4DynamicType;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void materialize(Plugin.Engine.Target.Sink param4Sink, List<TypeDescription> param4List, Map<TypeDescription, List<Throwable>> param4Map, List<String> param4List1) {
/* 3703 */             param4Sink.store(this.dynamicType.getAllTypes());
/* 3704 */             param4List.add(this.dynamicType.getTypeDescription());
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static class ForRetainedElement
/*      */           implements Materializable
/*      */         {
/*      */           private final Plugin.Engine.Source.Element element;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected ForRetainedElement(Plugin.Engine.Source.Element param4Element) {
/* 3724 */             this.element = param4Element;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void materialize(Plugin.Engine.Target.Sink param4Sink, List<TypeDescription> param4List, Map<TypeDescription, List<Throwable>> param4Map, List<String> param4List1) {
/* 3735 */             param4Sink.retain(this.element);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static class ForFailedElement
/*      */           implements Materializable
/*      */         {
/*      */           private final Plugin.Engine.Source.Element element;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final TypeDescription typeDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final List<Throwable> errored;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected ForFailedElement(Plugin.Engine.Source.Element param4Element, TypeDescription param4TypeDescription, List<Throwable> param4List) {
/* 3767 */             this.element = param4Element;
/* 3768 */             this.typeDescription = param4TypeDescription;
/* 3769 */             this.errored = param4List;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void materialize(Plugin.Engine.Target.Sink param4Sink, List<TypeDescription> param4List, Map<TypeDescription, List<Throwable>> param4Map, List<String> param4List1) {
/* 3780 */             param4Sink.retain(this.element);
/* 3781 */             param4Map.put(this.typeDescription, this.errored);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static class ForUnresolvedElement
/*      */           implements Materializable
/*      */         {
/*      */           private final Plugin.Engine.Source.Element element;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final String typeName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected ForUnresolvedElement(Plugin.Engine.Source.Element param4Element, String param4String) {
/* 3807 */             this.element = param4Element;
/* 3808 */             this.typeName = param4String;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void materialize(Plugin.Engine.Target.Sink param4Sink, List<TypeDescription> param4List, Map<TypeDescription, List<Throwable>> param4Map, List<String> param4List1) {
/* 3819 */             param4Sink.retain(this.element);
/* 3820 */             param4List1.add(this.typeName);
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static interface Factory
/*      */       {
/*      */         Plugin.Engine.Dispatcher make(Plugin.Engine.Target.Sink param3Sink, List<TypeDescription> param3List, Map<TypeDescription, List<Throwable>> param3Map, List<String> param3List1);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static class ForSerialTransformation
/*      */         implements Dispatcher
/*      */       {
/*      */         private final Plugin.Engine.Target.Sink sink;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<TypeDescription> transformed;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<TypeDescription, List<Throwable>> failed;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<String> unresolved;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<Callable<? extends Plugin.Engine.Dispatcher.Materializable>> preprocessings;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected ForSerialTransformation(Plugin.Engine.Target.Sink param3Sink, List<TypeDescription> param3List, Map<TypeDescription, List<Throwable>> param3Map, List<String> param3List1) {
/* 3888 */           this.sink = param3Sink;
/* 3889 */           this.transformed = param3List;
/* 3890 */           this.failed = param3Map;
/* 3891 */           this.unresolved = param3List1;
/* 3892 */           this.preprocessings = new ArrayList<Callable<? extends Plugin.Engine.Dispatcher.Materializable>>();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void accept(Callable<? extends Callable<? extends Plugin.Engine.Dispatcher.Materializable>> param3Callable, boolean param3Boolean) {
/*      */           try {
/* 3900 */             param3Callable = (Callable<? extends Callable<? extends Plugin.Engine.Dispatcher.Materializable>>)param3Callable.call();
/* 3901 */             if (param3Boolean) {
/* 3902 */               ((Plugin.Engine.Dispatcher.Materializable)param3Callable.call()).materialize(this.sink, this.transformed, this.failed, this.unresolved);
/*      */             } else {
/* 3904 */               this.preprocessings.add(param3Callable); return;
/*      */             } 
/* 3906 */           } catch (Exception exception) {
/* 3907 */             if (param3Callable = null instanceof IOException)
/* 3908 */               throw (IOException)param3Callable; 
/* 3909 */             if (param3Callable instanceof RuntimeException) {
/* 3910 */               throw (RuntimeException)param3Callable;
/*      */             }
/* 3912 */             throw new IllegalStateException(param3Callable);
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void complete() {
/*      */           Iterator<Callable<? extends Plugin.Engine.Dispatcher.Materializable>> iterator;
/* 3921 */           for (iterator = this.preprocessings.iterator(); iterator.hasNext(); ) { Callable<Plugin.Engine.Dispatcher.Materializable> callable = (Callable)iterator.next();
/* 3922 */             if (Thread.interrupted()) {
/* 3923 */               Thread.currentThread().interrupt();
/* 3924 */               throw new IllegalStateException("Interrupted during plugin engine completion");
/*      */             } 
/*      */             try {
/* 3927 */               ((Plugin.Engine.Dispatcher.Materializable)callable.call()).materialize(this.sink, this.transformed, this.failed, this.unresolved);
/* 3928 */             } catch (Exception exception) {
/* 3929 */               if (iterator = null instanceof IOException)
/* 3930 */                 throw (IOException)iterator; 
/* 3931 */               if (iterator instanceof RuntimeException) {
/* 3932 */                 throw (RuntimeException)iterator;
/*      */               }
/* 3934 */               throw new IllegalStateException(iterator);
/*      */             }  }
/*      */         
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void close() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public enum Factory
/*      */           implements Plugin.Engine.Dispatcher.Factory
/*      */         {
/* 3955 */           INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public final Plugin.Engine.Dispatcher make(Plugin.Engine.Target.Sink param4Sink, List<TypeDescription> param4List, Map<TypeDescription, List<Throwable>> param4Map, List<String> param4List1) {
/* 3965 */             return new Plugin.Engine.Dispatcher.ForSerialTransformation(param4Sink, param4List, param4Map, param4List1);
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static class ForParallelTransformation
/*      */         implements Dispatcher
/*      */       {
/*      */         private final Plugin.Engine.Target.Sink sink;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<TypeDescription> transformed;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<TypeDescription, List<Throwable>> failed;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<String> unresolved;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final CompletionService<Callable<Plugin.Engine.Dispatcher.Materializable>> preprocessings;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final CompletionService<Plugin.Engine.Dispatcher.Materializable> materializers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private int deferred;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Set<Future<?>> futures;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected ForParallelTransformation(Executor param3Executor, Plugin.Engine.Target.Sink param3Sink, List<TypeDescription> param3List, Map<TypeDescription, List<Throwable>> param3Map, List<String> param3List1) {
/* 4030 */           this.sink = param3Sink;
/* 4031 */           this.transformed = param3List;
/* 4032 */           this.failed = param3Map;
/* 4033 */           this.unresolved = param3List1;
/* 4034 */           this.preprocessings = new ExecutorCompletionService<Callable<Plugin.Engine.Dispatcher.Materializable>>(param3Executor);
/* 4035 */           this.materializers = new ExecutorCompletionService<Plugin.Engine.Dispatcher.Materializable>(param3Executor);
/* 4036 */           this.futures = new HashSet<Future<?>>();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void accept(Callable<? extends Callable<? extends Plugin.Engine.Dispatcher.Materializable>> param3Callable, boolean param3Boolean) {
/* 4044 */           if (param3Boolean) {
/* 4045 */             this.futures.add(this.materializers.submit(new EagerWork(param3Callable))); return;
/*      */           } 
/* 4047 */           this.deferred++;
/* 4048 */           this.futures.add(this.preprocessings.submit(param3Callable));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void complete() {
/*      */           try {
/* 4057 */             ArrayList arrayList = new ArrayList(this.deferred);
/* 4058 */             while (this.deferred-- > 0) {
/* 4059 */               Future<Callable<Plugin.Engine.Dispatcher.Materializable>> future = this.preprocessings.take();
/* 4060 */               this.futures.remove(future);
/* 4061 */               arrayList.add(future.get());
/*      */             } 
/* 4063 */             for (Callable<?> callable : (Iterable<Callable<?>>)arrayList) {
/* 4064 */               this.futures.add(this.materializers.submit(callable));
/*      */             }
/* 4066 */             while (!this.futures.isEmpty()) {
/* 4067 */               Future<Plugin.Engine.Dispatcher.Materializable> future = this.materializers.take();
/* 4068 */               this.futures.remove(future);
/* 4069 */               ((Plugin.Engine.Dispatcher.Materializable)future.get()).materialize(this.sink, this.transformed, this.failed, this.unresolved);
/*      */             }  return;
/* 4071 */           } catch (InterruptedException interruptedException) {
/* 4072 */             Thread.currentThread().interrupt();
/* 4073 */             throw new IllegalStateException(interruptedException);
/* 4074 */           } catch (ExecutionException executionException2) {
/*      */             ExecutionException executionException1; Throwable throwable;
/* 4076 */             if (throwable = (executionException1 = null).getCause() instanceof IOException)
/* 4077 */               throw (IOException)throwable; 
/* 4078 */             if (throwable instanceof RuntimeException)
/* 4079 */               throw (RuntimeException)throwable; 
/* 4080 */             if (throwable instanceof Error) {
/* 4081 */               throw (Error)throwable;
/*      */             }
/* 4083 */             throw new IllegalStateException(throwable);
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void close() {
/* 4092 */           for (Iterator<Future<?>> iterator = this.futures.iterator(); iterator.hasNext();) {
/* 4093 */             (future = iterator.next()).cancel(true);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class WithThrowawayExecutorService
/*      */           extends ForParallelTransformation
/*      */         {
/*      */           private final ExecutorService executorService;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected WithThrowawayExecutorService(ExecutorService param4ExecutorService, Plugin.Engine.Target.Sink param4Sink, List<TypeDescription> param4List, Map<TypeDescription, List<Throwable>> param4Map, List<String> param4List1) {
/* 4122 */             super(param4ExecutorService, param4Sink, param4List, param4Map, param4List1);
/* 4123 */             this.executorService = param4ExecutorService;
/*      */           }
/*      */ 
/*      */           
/*      */           public void close() {
/*      */             try {
/* 4129 */               super.close(); return;
/*      */             } finally {
/* 4131 */               this.executorService.shutdown();
/*      */             } 
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.executorService.equals(((WithThrowawayExecutorService)param4Object).executorService))));
/*      */           }
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.executorService.hashCode();
/*      */           }
/*      */           
/*      */           @Enhance
/*      */           public static class Factory
/*      */             implements Plugin.Engine.Dispatcher.Factory
/*      */           {
/*      */             private final int threads;
/*      */             
/*      */             public Factory(int param5Int) {
/* 4152 */               this.threads = param5Int;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public Plugin.Engine.Dispatcher make(Plugin.Engine.Target.Sink param5Sink, List<TypeDescription> param5List, Map<TypeDescription, List<Throwable>> param5Map, List<String> param5List1) {
/* 4162 */               return new Plugin.Engine.Dispatcher.ForParallelTransformation.WithThrowawayExecutorService(Executors.newFixedThreadPool(this.threads), param5Sink, param5List, param5Map, param5List1);
/*      */             }
/*      */ 
/*      */             
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/*      */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!(this.threads != ((Factory)param5Object).threads))));
/*      */             }
/*      */ 
/*      */             
/*      */             public int hashCode() {
/*      */               return getClass().hashCode() * 31 + this.threads;
/*      */             }
/*      */           }
/*      */         }
/*      */         
/*      */         @Enhance
/*      */         public static class Factory
/*      */           implements Plugin.Engine.Dispatcher.Factory
/*      */         {
/*      */           private final Executor executor;
/*      */           
/*      */           public Factory(Executor param4Executor) {
/* 4184 */             this.executor = param4Executor;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Plugin.Engine.Dispatcher make(Plugin.Engine.Target.Sink param4Sink, List<TypeDescription> param4List, Map<TypeDescription, List<Throwable>> param4Map, List<String> param4List1) {
/* 4194 */             return new Plugin.Engine.Dispatcher.ForParallelTransformation(this.executor, param4Sink, param4List, param4Map, param4List1);
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.executor.equals(((Factory)param4Object).executor))));
/*      */           }
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.executor.hashCode();
/*      */           }
/*      */         }
/*      */         
/*      */         @Enhance
/*      */         protected static class EagerWork
/*      */           implements Callable<Plugin.Engine.Dispatcher.Materializable>
/*      */         {
/*      */           private final Callable<? extends Callable<? extends Plugin.Engine.Dispatcher.Materializable>> work;
/*      */           
/*      */           protected EagerWork(Callable<? extends Callable<? extends Plugin.Engine.Dispatcher.Materializable>> param4Callable) {
/* 4215 */             this.work = param4Callable;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Plugin.Engine.Dispatcher.Materializable call() {
/* 4222 */             return ((Callable<Plugin.Engine.Dispatcher.Materializable>)this.work.call()).call();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.work.equals(((EagerWork)param4Object).work))));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.work.hashCode();
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static class Summary
/*      */     {
/*      */       private final List<TypeDescription> transformed;
/*      */ 
/*      */       
/*      */       private final Map<TypeDescription, List<Throwable>> failed;
/*      */ 
/*      */       
/*      */       private final List<String> unresolved;
/*      */ 
/*      */ 
/*      */       
/*      */       public Summary(List<TypeDescription> param2List, Map<TypeDescription, List<Throwable>> param2Map, List<String> param2List1) {
/* 4256 */         this.transformed = param2List;
/* 4257 */         this.failed = param2Map;
/* 4258 */         this.unresolved = param2List1;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public List<TypeDescription> getTransformed() {
/* 4267 */         return this.transformed;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Map<TypeDescription, List<Throwable>> getFailed() {
/* 4276 */         return this.failed;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public List<String> getUnresolved() {
/* 4285 */         return this.unresolved;
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/* 4290 */         int i = this.transformed.hashCode();
/* 4291 */         i = i * 31 + this.failed.hashCode();
/*      */         
/* 4293 */         return i = i * 31 + this.unresolved.hashCode();
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/* 4298 */         if (this == param2Object)
/* 4299 */           return true; 
/* 4300 */         if (param2Object == null || getClass() != param2Object.getClass()) {
/* 4301 */           return false;
/*      */         }
/* 4303 */         param2Object = param2Object;
/* 4304 */         if (this.transformed.equals(((Summary)param2Object).transformed) && this.failed
/* 4305 */           .equals(((Summary)param2Object).failed) && this.unresolved
/* 4306 */           .equals(((Summary)param2Object).unresolved)) return true;
/*      */         
/*      */         return false;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static abstract class AbstractBase
/*      */       implements Engine
/*      */     {
/*      */       public Plugin.Engine withErrorHandlers(Plugin.Engine.ErrorHandler... param2VarArgs) {
/* 4319 */         return withErrorHandlers(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Plugin.Engine withParallelTransformation(int param2Int) {
/* 4326 */         if (param2Int <= 0) {
/* 4327 */           throw new IllegalArgumentException("Number of threads must be positive: " + param2Int);
/*      */         }
/* 4329 */         return with(new Plugin.Engine.Dispatcher.ForParallelTransformation.WithThrowawayExecutorService.Factory(param2Int));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Plugin.Engine.Summary apply(File param2File1, File param2File2, Plugin.Factory... param2VarArgs) {
/* 4336 */         return apply(param2File1, param2File2, Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Plugin.Engine.Summary apply(File param2File1, File param2File2, List<? extends Plugin.Factory> param2List) {
/* 4343 */         return apply(param2File1.isDirectory() ? new Plugin.Engine.Source.ForFolder(param2File1) : new Plugin.Engine.Source.ForJarFile(param2File1), 
/*      */             
/* 4345 */             param2File2.isDirectory() ? new Plugin.Engine.Target.ForFolder(param2File2) : new Plugin.Engine.Target.ForJarFile(param2File2), param2List);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Plugin.Engine.Summary apply(Plugin.Engine.Source param2Source, Plugin.Engine.Target param2Target, Plugin.Factory... param2VarArgs) {
/* 4354 */         return apply(param2Source, param2Target, Arrays.asList(param2VarArgs));
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class Default
/*      */       extends AbstractBase
/*      */     {
/*      */       private final ByteBuddy byteBuddy;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Plugin.Engine.TypeStrategy typeStrategy;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Plugin.Engine.PoolStrategy poolStrategy;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final ClassFileLocator classFileLocator;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Plugin.Engine.Listener listener;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Plugin.Engine.ErrorHandler errorHandler;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Plugin.Engine.Dispatcher.Factory dispatcherFactory;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final ElementMatcher.Junction<? super TypeDescription> ignoredTypeMatcher;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Default() {
/* 4408 */         this(new ByteBuddy());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Default(ByteBuddy param2ByteBuddy) {
/* 4417 */         this(param2ByteBuddy, Plugin.Engine.TypeStrategy.Default.REBASE);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected Default(ByteBuddy param2ByteBuddy, Plugin.Engine.TypeStrategy param2TypeStrategy) {
/* 4427 */         this(param2ByteBuddy, param2TypeStrategy, Plugin.Engine.PoolStrategy.Default.FAST, (ClassFileLocator)ClassFileLocator.NoOp.INSTANCE, Plugin.Engine.Listener.NoOp.INSTANCE, new Plugin.Engine.ErrorHandler.Compound(new Plugin.Engine.ErrorHandler[] { Plugin.Engine.ErrorHandler.Failing.FAIL_FAST, Plugin.Engine.ErrorHandler.Enforcing.ALL_TYPES_RESOLVED, Plugin.Engine.ErrorHandler.Enforcing.NO_LIVE_INITIALIZERS }, ), Plugin.Engine.Dispatcher.ForSerialTransformation.Factory.INSTANCE, 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 4436 */             ElementMatchers.none());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected Default(ByteBuddy param2ByteBuddy, Plugin.Engine.TypeStrategy param2TypeStrategy, Plugin.Engine.PoolStrategy param2PoolStrategy, ClassFileLocator param2ClassFileLocator, Plugin.Engine.Listener param2Listener, Plugin.Engine.ErrorHandler param2ErrorHandler, Plugin.Engine.Dispatcher.Factory param2Factory, ElementMatcher.Junction<? super TypeDescription> param2Junction) {
/* 4459 */         this.byteBuddy = param2ByteBuddy;
/* 4460 */         this.typeStrategy = param2TypeStrategy;
/* 4461 */         this.poolStrategy = param2PoolStrategy;
/* 4462 */         this.classFileLocator = param2ClassFileLocator;
/* 4463 */         this.listener = param2Listener;
/* 4464 */         this.errorHandler = param2ErrorHandler;
/* 4465 */         this.dispatcherFactory = param2Factory;
/* 4466 */         this.ignoredTypeMatcher = param2Junction;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static Plugin.Engine of(EntryPoint param2EntryPoint, ClassFileVersion param2ClassFileVersion, MethodNameTransformer param2MethodNameTransformer) {
/* 4478 */         return new Default(param2EntryPoint.byteBuddy(param2ClassFileVersion), new Plugin.Engine.TypeStrategy.ForEntryPoint(param2EntryPoint, param2MethodNameTransformer));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static Set<String> scan(ClassLoader param2ClassLoader) {
/*      */         // Byte code:
/*      */         //   0: new java/util/HashSet
/*      */         //   3: dup
/*      */         //   4: invokespecial <init> : ()V
/*      */         //   7: astore_1
/*      */         //   8: aload_0
/*      */         //   9: ldc 'META-INF/net.bytebuddy/build.plugins'
/*      */         //   11: invokevirtual getResources : (Ljava/lang/String;)Ljava/util/Enumeration;
/*      */         //   14: astore_0
/*      */         //   15: aload_0
/*      */         //   16: invokeinterface hasMoreElements : ()Z
/*      */         //   21: ifeq -> 94
/*      */         //   24: new java/io/BufferedReader
/*      */         //   27: dup
/*      */         //   28: new java/io/InputStreamReader
/*      */         //   31: dup
/*      */         //   32: aload_0
/*      */         //   33: invokeinterface nextElement : ()Ljava/lang/Object;
/*      */         //   38: checkcast java/net/URL
/*      */         //   41: invokevirtual openStream : ()Ljava/io/InputStream;
/*      */         //   44: ldc 'UTF-8'
/*      */         //   46: invokespecial <init> : (Ljava/io/InputStream;Ljava/lang/String;)V
/*      */         //   49: invokespecial <init> : (Ljava/io/Reader;)V
/*      */         //   52: astore_2
/*      */         //   53: aload_2
/*      */         //   54: invokevirtual readLine : ()Ljava/lang/String;
/*      */         //   57: dup
/*      */         //   58: astore_3
/*      */         //   59: ifnull -> 73
/*      */         //   62: aload_1
/*      */         //   63: aload_3
/*      */         //   64: invokeinterface add : (Ljava/lang/Object;)Z
/*      */         //   69: pop
/*      */         //   70: goto -> 53
/*      */         //   73: jsr -> 87
/*      */         //   76: goto -> 15
/*      */         //   79: astore #4
/*      */         //   81: jsr -> 87
/*      */         //   84: aload #4
/*      */         //   86: athrow
/*      */         //   87: astore_3
/*      */         //   88: aload_2
/*      */         //   89: invokevirtual close : ()V
/*      */         //   92: ret #3
/*      */         //   94: aload_1
/*      */         //   95: areturn
/*      */         // Line number table:
/*      */         //   Java source line number -> byte code offset
/*      */         //   #4489	-> 0
/*      */         //   #4490	-> 8
/*      */         //   #4491	-> 15
/*      */         //   #4492	-> 24
/*      */         //   #4495	-> 53
/*      */         //   #4496	-> 62
/*      */         //   #4498	-> 73
/*      */         //   #4500	-> 76
/*      */         //   #4499	-> 79
/*      */         //   #4500	-> 84
/*      */         //   #4499	-> 88
/*      */         //   #4502	-> 94
/*      */         // Exception table:
/*      */         //   from	to	target	type
/*      */         //   53	76	79	finally
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static void main(String... param2VarArgs) {
/* 4515 */         if (param2VarArgs.length < 2) {
/* 4516 */           throw new IllegalArgumentException("Expected arguments: <source> <target> [<plugin>, ...]");
/*      */         }
/* 4518 */         ArrayList<Plugin.Factory.UsingReflection> arrayList = new ArrayList(param2VarArgs.length - 2);
/* 4519 */         for (String str : Arrays.<String>asList(param2VarArgs).subList(2, param2VarArgs.length)) {
/* 4520 */           arrayList.add(new Plugin.Factory.UsingReflection((Class)Class.forName(str)));
/*      */         }
/* 4522 */         (new Default()).apply(new File(param2VarArgs[0]), new File(param2VarArgs[1]), (List)arrayList);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Plugin.Engine with(ByteBuddy param2ByteBuddy) {
/* 4529 */         return new Default(param2ByteBuddy, this.typeStrategy, this.poolStrategy, this.classFileLocator, this.listener, this.errorHandler, this.dispatcherFactory, this.ignoredTypeMatcher);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Plugin.Engine with(Plugin.Engine.TypeStrategy param2TypeStrategy) {
/* 4543 */         return new Default(this.byteBuddy, param2TypeStrategy, this.poolStrategy, this.classFileLocator, this.listener, this.errorHandler, this.dispatcherFactory, this.ignoredTypeMatcher);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Plugin.Engine with(Plugin.Engine.PoolStrategy param2PoolStrategy) {
/* 4557 */         return new Default(this.byteBuddy, this.typeStrategy, param2PoolStrategy, this.classFileLocator, this.listener, this.errorHandler, this.dispatcherFactory, this.ignoredTypeMatcher);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Plugin.Engine with(ClassFileLocator param2ClassFileLocator) {
/* 4571 */         return new Default(this.byteBuddy, this.typeStrategy, this.poolStrategy, (ClassFileLocator)new ClassFileLocator.Compound(new ClassFileLocator[] { this.classFileLocator, param2ClassFileLocator }, ), this.listener, this.errorHandler, this.dispatcherFactory, this.ignoredTypeMatcher);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Plugin.Engine with(Plugin.Engine.Listener param2Listener) {
/* 4585 */         return new Default(this.byteBuddy, this.typeStrategy, this.poolStrategy, this.classFileLocator, new Plugin.Engine.Listener.Compound(new Plugin.Engine.Listener[] { this.listener, param2Listener }, ), this.errorHandler, this.dispatcherFactory, this.ignoredTypeMatcher);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Plugin.Engine withoutErrorHandlers() {
/* 4599 */         return new Default(this.byteBuddy, this.typeStrategy, this.poolStrategy, this.classFileLocator, this.listener, Plugin.Engine.Listener.NoOp.INSTANCE, this.dispatcherFactory, this.ignoredTypeMatcher);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Plugin.Engine withErrorHandlers(List<? extends Plugin.Engine.ErrorHandler> param2List) {
/* 4613 */         return new Default(this.byteBuddy, this.typeStrategy, this.poolStrategy, this.classFileLocator, this.listener, new Plugin.Engine.ErrorHandler.Compound(param2List), this.dispatcherFactory, this.ignoredTypeMatcher);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Plugin.Engine with(Plugin.Engine.Dispatcher.Factory param2Factory) {
/* 4627 */         return new Default(this.byteBuddy, this.typeStrategy, this.poolStrategy, this.classFileLocator, this.listener, this.errorHandler, param2Factory, this.ignoredTypeMatcher);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Plugin.Engine ignore(ElementMatcher<? super TypeDescription> param2ElementMatcher) {
/* 4641 */         return new Default(this.byteBuddy, this.typeStrategy, this.poolStrategy, this.classFileLocator, this.listener, this.errorHandler, this.dispatcherFactory, this.ignoredTypeMatcher
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 4648 */             .or(param2ElementMatcher));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Plugin.Engine.Summary apply(Plugin.Engine.Source param2Source, Plugin.Engine.Target param2Target, List<? extends Plugin.Factory> param2List) {
/* 4655 */         Plugin.Engine.Listener.Compound compound = new Plugin.Engine.Listener.Compound(new Plugin.Engine.Listener[] { this.listener, new Plugin.Engine.Listener.ForErrorHandler(this.errorHandler) });
/* 4656 */         ArrayList<TypeDescription> arrayList = new ArrayList();
/* 4657 */         LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/* 4658 */         ArrayList<String> arrayList1 = new ArrayList();
/* 4659 */         Object object = null;
/* 4660 */         ArrayList<Plugin> arrayList2 = new ArrayList(param2List.size());
/* 4661 */         ArrayList<Plugin.WithInitialization> arrayList3 = new ArrayList();
/* 4662 */         ArrayList<Plugin.WithPreprocessor> arrayList4 = new ArrayList();
/*      */         try {
/* 4664 */           for (Iterator<? extends Plugin.Factory> iterator = param2List.iterator(); iterator.hasNext(); ) {
/* 4665 */             Plugin.Factory factory; Plugin plugin = (factory = iterator.next()).make();
/* 4666 */             arrayList2.add(plugin);
/* 4667 */             if (plugin instanceof Plugin.WithPreprocessor) {
/* 4668 */               arrayList4.add((Plugin.WithPreprocessor)plugin);
/*      */             }
/* 4670 */             if (plugin instanceof Plugin.WithInitialization) {
/* 4671 */               arrayList3.add((Plugin.WithInitialization)plugin);
/*      */             }
/*      */           } 
/* 4674 */           Plugin.Engine.Source.Origin origin = param2Source.read();
/*      */           try {
/* 4676 */             ClassFileLocator.Compound compound1 = new ClassFileLocator.Compound(new ClassFileLocator[] { origin.getClassFileLocator(), this.classFileLocator });
/* 4677 */             TypePool typePool = this.poolStrategy.typePool((ClassFileLocator)compound1);
/* 4678 */             Manifest manifest = origin.getManifest();
/* 4679 */             compound.onManifest(manifest);
/* 4680 */             Plugin.Engine.Target.Sink sink = param2Target.write(manifest);
/*      */             try {
/* 4682 */               for (Plugin.WithInitialization withInitialization : arrayList3) {
/* 4683 */                 sink.store(withInitialization.initialize((ClassFileLocator)compound1));
/*      */               }
/* 4685 */               Plugin.Engine.Dispatcher dispatcher = this.dispatcherFactory.make(sink, arrayList, (Map)linkedHashMap, arrayList1);
/*      */               try {
/* 4687 */                 for (Plugin.Engine.Source.Element element : origin) {
/* 4688 */                   if (Thread.interrupted()) {
/* 4689 */                     Thread.currentThread().interrupt();
/* 4690 */                     throw new IllegalStateException("Thread interrupted during plugin engine application");
/*      */                   } 
/* 4692 */                   String str = element.getName();
/* 4693 */                   while (str.startsWith("/")) {
/* 4694 */                     str = str.substring(1);
/*      */                   }
/* 4696 */                   if (str.endsWith(".class") && !str.endsWith("package-info.class") && !str.equals("module-info.class")) {
/* 4697 */                     dispatcher.accept(new Preprocessor(element, str
/* 4698 */                           .substring(0, str.length() - 6).replace('/', '.'), (ClassFileLocator)compound1, typePool, compound, arrayList2, arrayList4, (byte)0), arrayList4
/*      */ 
/*      */ 
/*      */ 
/*      */                         
/* 4703 */                         .isEmpty()); continue;
/* 4704 */                   }  if (!str.equals("META-INF/MANIFEST.MF")) {
/* 4705 */                     compound.onResource(str);
/* 4706 */                     sink.retain(element);
/*      */                   } 
/*      */                 } 
/* 4709 */                 dispatcher.complete();
/*      */               } finally {
/* 4711 */                 dispatcher.close();
/*      */               } 
/* 4713 */               if (!linkedHashMap.isEmpty()) {
/* 4714 */                 compound.onError((Map)linkedHashMap);
/*      */               }
/*      */             } finally {
/* 4717 */               sink.close();
/*      */             } 
/*      */           } finally {
/* 4720 */             origin.close();
/*      */           } 
/*      */         } finally {
/* 4723 */           for (Plugin plugin : arrayList2) {
/*      */             try {
/* 4725 */               plugin.close();
/* 4726 */             } catch (Throwable throwable) {
/*      */               try {
/* 4728 */                 compound.onError(plugin, throwable);
/* 4729 */               } catch (Throwable throwable1) {
/* 4730 */                 object = (object == null) ? throwable1 : object;
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/* 4737 */         if (object == null)
/* 4738 */           return new Plugin.Engine.Summary(arrayList, (Map)linkedHashMap, arrayList1); 
/* 4739 */         if (object instanceof IOException)
/* 4740 */           throw (IOException)object; 
/* 4741 */         if (object instanceof RuntimeException) {
/* 4742 */           throw (RuntimeException)object;
/*      */         }
/* 4744 */         throw new IllegalStateException(object);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.byteBuddy.equals(((Default)param2Object).byteBuddy) ? false : (!this.typeStrategy.equals(((Default)param2Object).typeStrategy) ? false : (!this.poolStrategy.equals(((Default)param2Object).poolStrategy) ? false : (!this.classFileLocator.equals(((Default)param2Object).classFileLocator) ? false : (!this.listener.equals(((Default)param2Object).listener) ? false : (!this.errorHandler.equals(((Default)param2Object).errorHandler) ? false : (!this.dispatcherFactory.equals(((Default)param2Object).dispatcherFactory) ? false : (!!this.ignoredTypeMatcher.equals(((Default)param2Object).ignoredTypeMatcher)))))))))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (((((((getClass().hashCode() * 31 + this.byteBuddy.hashCode()) * 31 + this.typeStrategy.hashCode()) * 31 + this.poolStrategy.hashCode()) * 31 + this.classFileLocator.hashCode()) * 31 + this.listener.hashCode()) * 31 + this.errorHandler.hashCode()) * 31 + this.dispatcherFactory.hashCode()) * 31 + this.ignoredTypeMatcher.hashCode();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private class Preprocessor
/*      */         implements Callable<Callable<? extends Plugin.Engine.Dispatcher.Materializable>>
/*      */       {
/*      */         private final Plugin.Engine.Source.Element element;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String typeName;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final ClassFileLocator classFileLocator;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Plugin.Engine.Listener listener;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<Plugin> plugins;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<Plugin.WithPreprocessor> preprocessors;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private Preprocessor(Plugin.Engine.Default this$0, Plugin.Engine.Source.Element param3Element, String param3String, ClassFileLocator param3ClassFileLocator, TypePool param3TypePool, Plugin.Engine.Listener param3Listener, List<Plugin> param3List, List<Plugin.WithPreprocessor> param3List1) {
/* 4806 */           this.element = param3Element;
/* 4807 */           this.typeName = param3String;
/* 4808 */           this.classFileLocator = param3ClassFileLocator;
/* 4809 */           this.typePool = param3TypePool;
/* 4810 */           this.listener = param3Listener;
/* 4811 */           this.plugins = param3List;
/* 4812 */           this.preprocessors = param3List1;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Callable<Plugin.Engine.Dispatcher.Materializable> call() {
/* 4819 */           this.listener.onDiscovery(this.typeName);
/*      */           TypePool.Resolution resolution;
/* 4821 */           if ((resolution = this.typePool.describe(this.typeName)).isResolved()) {
/* 4822 */             TypeDescription typeDescription = resolution.resolve();
/*      */             try {
/* 4824 */               if (!Plugin.Engine.Default.a(this.a).matches(typeDescription)) {
/* 4825 */                 for (Iterator<Plugin.WithPreprocessor> iterator = this.preprocessors.iterator(); iterator.hasNext();) {
/* 4826 */                   (withPreprocessor = iterator.next()).onPreprocess(typeDescription, this.classFileLocator);
/*      */                 }
/* 4828 */                 return new Resolved(typeDescription, (byte)0);
/*      */               } 
/* 4830 */               return new Ignored(typeDescription, (byte)0);
/*      */             }
/* 4832 */             catch (Throwable throwable) {
/* 4833 */               this.listener.onComplete(typeDescription);
/* 4834 */               if (throwable instanceof Exception)
/* 4835 */                 throw (Exception)throwable; 
/* 4836 */               if (throwable instanceof Error) {
/* 4837 */                 throw (Error)throwable;
/*      */               }
/* 4839 */               throw new IllegalStateException(throwable);
/*      */             } 
/*      */           } 
/*      */           
/* 4843 */           return new Unresolved((byte)0);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private class Resolved
/*      */           implements Callable<Plugin.Engine.Dispatcher.Materializable>
/*      */         {
/*      */           private final TypeDescription typeDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private Resolved(Plugin.Engine.Default.Preprocessor this$0, TypeDescription param4TypeDescription) {
/* 4863 */             this.typeDescription = param4TypeDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Plugin.Engine.Dispatcher.Materializable call() {
/* 4870 */             ArrayList<Plugin> arrayList1 = new ArrayList(), arrayList2 = new ArrayList();
/* 4871 */             ArrayList<Throwable> arrayList = new ArrayList();
/*      */             try {
/* 4873 */               DynamicType.Builder<?> builder = Plugin.Engine.Default.c(this.a.a).builder(Plugin.Engine.Default.b(this.a.a), this.typeDescription, Plugin.Engine.Default.Preprocessor.a(this.a));
/* 4874 */               for (Plugin plugin : Plugin.Engine.Default.Preprocessor.b(this.a)) {
/*      */                 try {
/* 4876 */                   if (plugin.matches(this.typeDescription)) {
/* 4877 */                     builder = plugin.apply(builder, this.typeDescription, Plugin.Engine.Default.Preprocessor.a(this.a));
/* 4878 */                     Plugin.Engine.Default.Preprocessor.c(this.a).onTransformation(this.typeDescription, plugin);
/* 4879 */                     arrayList1.add(plugin); continue;
/*      */                   } 
/* 4881 */                   Plugin.Engine.Default.Preprocessor.c(this.a).onIgnored(this.typeDescription, plugin);
/* 4882 */                   arrayList2.add(plugin);
/*      */                 }
/* 4884 */                 catch (Throwable throwable) {
/* 4885 */                   Plugin.Engine.Default.Preprocessor.c(this.a).onError(this.typeDescription, plugin, throwable);
/* 4886 */                   arrayList.add(throwable);
/*      */                 } 
/*      */               } 
/* 4889 */               if (!arrayList.isEmpty()) {
/* 4890 */                 Plugin.Engine.Default.Preprocessor.c(this.a).onError(this.typeDescription, arrayList);
/* 4891 */                 return new Plugin.Engine.Dispatcher.Materializable.ForFailedElement(Plugin.Engine.Default.Preprocessor.d(this.a), this.typeDescription, arrayList);
/* 4892 */               }  if (!arrayList1.isEmpty()) {
/* 4893 */                 DynamicType.Unloaded unloaded = builder.make((TypeResolutionStrategy)TypeResolutionStrategy.Disabled.INSTANCE, Plugin.Engine.Default.Preprocessor.e(this.a));
/* 4894 */                 Plugin.Engine.Default.Preprocessor.c(this.a).onTransformation(this.typeDescription, arrayList1);
/* 4895 */                 for (Iterator<Map.Entry> iterator = unloaded.getLoadedTypeInitializers().entrySet().iterator(); iterator.hasNext();) {
/* 4896 */                   if (((LoadedTypeInitializer)(entry = iterator.next()).getValue()).isAlive()) {
/* 4897 */                     Plugin.Engine.Default.Preprocessor.c(this.a).onLiveInitializer(this.typeDescription, (TypeDescription)entry.getKey());
/*      */                   }
/*      */                 } 
/* 4900 */                 return new Plugin.Engine.Dispatcher.Materializable.ForTransformedElement((DynamicType)unloaded);
/*      */               } 
/* 4902 */               Plugin.Engine.Default.Preprocessor.c(this.a).onIgnored(this.typeDescription, arrayList2);
/* 4903 */               return new Plugin.Engine.Dispatcher.Materializable.ForRetainedElement(Plugin.Engine.Default.Preprocessor.d(this.a));
/*      */             } finally {
/*      */               
/* 4906 */               Plugin.Engine.Default.Preprocessor.c(this.a).onComplete(this.typeDescription);
/*      */             } 
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private class Ignored
/*      */           implements Callable<Plugin.Engine.Dispatcher.Materializable>
/*      */         {
/*      */           private final TypeDescription typeDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private Ignored(Plugin.Engine.Default.Preprocessor this$0, TypeDescription param4TypeDescription) {
/* 4927 */             this.typeDescription = param4TypeDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Plugin.Engine.Dispatcher.Materializable call() {
/*      */             try {
/* 4935 */               Plugin.Engine.Default.Preprocessor.c(this.a).onIgnored(this.typeDescription, Plugin.Engine.Default.Preprocessor.b(this.a));
/*      */             } finally {
/* 4937 */               Plugin.Engine.Default.Preprocessor.c(this.a).onComplete(this.typeDescription);
/*      */             } 
/* 4939 */             return new Plugin.Engine.Dispatcher.Materializable.ForRetainedElement(Plugin.Engine.Default.Preprocessor.d(this.a));
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         private class Unresolved
/*      */           implements Callable<Plugin.Engine.Dispatcher.Materializable>
/*      */         {
/*      */           private Unresolved(Plugin.Engine.Default.Preprocessor this$0) {}
/*      */ 
/*      */           
/*      */           public Plugin.Engine.Dispatcher.Materializable call() {
/* 4952 */             Plugin.Engine.Default.Preprocessor.c(this.a).onUnresolved(Plugin.Engine.Default.Preprocessor.f(this.a));
/* 4953 */             return new Plugin.Engine.Dispatcher.Materializable.ForUnresolvedElement(Plugin.Engine.Default.Preprocessor.d(this.a), Plugin.Engine.Default.Preprocessor.f(this.a));
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class NoOp
/*      */     implements Plugin, Factory
/*      */   {
/*      */     public Plugin make() {
/* 4970 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean matches(@MaybeNull TypeDescription param1TypeDescription) {
/* 4977 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public DynamicType.Builder<?> apply(DynamicType.Builder<?> param1Builder, TypeDescription param1TypeDescription, ClassFileLocator param1ClassFileLocator) {
/* 4984 */       throw new IllegalStateException("Cannot apply non-operational plugin");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {}
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : (!(getClass() != param1Object.getClass())));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static abstract class ForElementMatcher
/*      */     implements Plugin
/*      */   {
/*      */     private final ElementMatcher<? super TypeDescription> matcher;
/*      */ 
/*      */     
/*      */     protected ForElementMatcher(ElementMatcher<? super TypeDescription> param1ElementMatcher) {
/* 5012 */       this.matcher = param1ElementMatcher;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean matches(@MaybeNull TypeDescription param1TypeDescription) {
/* 5019 */       return this.matcher.matches(param1TypeDescription);
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.matcher.equals(((ForElementMatcher)param1Object).matcher))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.matcher.hashCode();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\build\Plugin.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */