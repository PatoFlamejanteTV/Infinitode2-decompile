/*     */ package net.bytebuddy.dynamic.loading;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.lang.reflect.Method;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ import net.bytebuddy.utility.nullability.MaybeNull;
/*     */ import net.bytebuddy.utility.nullability.UnknownNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MultipleParentClassLoader
/*     */   extends InjectionClassLoader
/*     */ {
/*     */   private final List<? extends ClassLoader> parents;
/*     */   
/*     */   static {
/*  58 */     doRegisterAsParallelCapable();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SuppressFBWarnings(value = {"DP_DO_INSIDE_DO_PRIVILEGED"}, justification = "Must be invoked from targeting class loader type.")
/*     */   private static void doRegisterAsParallelCapable() {
/*     */     try {
/*     */       Method method;
/*  68 */       (method = ClassLoader.class.getDeclaredMethod("registerAsParallelCapable", new Class[0])).setAccessible(true);
/*  69 */       method.invoke(null, new Object[0]); return;
/*  70 */     } catch (Throwable throwable) {
/*     */       return;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MultipleParentClassLoader(List<? extends ClassLoader> paramList) {
/*  87 */     this(ClassLoadingStrategy.BOOTSTRAP_LOADER, paramList);
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
/*     */   public MultipleParentClassLoader(@MaybeNull ClassLoader paramClassLoader, List<? extends ClassLoader> paramList) {
/*  99 */     this(paramClassLoader, paramList, true);
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
/*     */   public MultipleParentClassLoader(@MaybeNull ClassLoader paramClassLoader, List<? extends ClassLoader> paramList, boolean paramBoolean) {
/* 112 */     super(paramClassLoader, paramBoolean);
/* 113 */     this.parents = paramList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Class<?> loadClass(String paramString, boolean paramBoolean) {
/* 120 */     for (ClassLoader classLoader : this.parents) {
/*     */       try {
/* 122 */         Class<?> clazz = classLoader.loadClass(paramString);
/* 123 */         if (paramBoolean) {
/* 124 */           resolveClass(clazz);
/*     */         }
/* 126 */         return clazz;
/* 127 */       } catch (ClassNotFoundException classNotFoundException) {}
/*     */     } 
/*     */ 
/*     */     
/* 131 */     return super.loadClass(paramString, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URL getResource(String paramString) {
/* 138 */     for (Iterator<? extends ClassLoader> iterator = this.parents.iterator(); iterator.hasNext();) {
/*     */       
/* 140 */       if ((uRL = (classLoader = iterator.next()).getResource(paramString)) != null) {
/* 141 */         return uRL;
/*     */       }
/*     */     } 
/* 144 */     return super.getResource(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Enumeration<URL> getResources(String paramString) {
/* 151 */     ArrayList<Enumeration<URL>> arrayList = new ArrayList(this.parents.size() + 1);
/* 152 */     for (ClassLoader classLoader : this.parents) {
/* 153 */       arrayList.add(classLoader.getResources(paramString));
/*     */     }
/* 155 */     arrayList.add(super.getResources(paramString));
/* 156 */     return new CompoundEnumeration(arrayList);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Map<String, Class<?>> doDefineClasses(Map<String, byte[]> paramMap) {
/* 161 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 162 */     for (Map.Entry<String, byte> entry : paramMap.entrySet()) {
/* 163 */       hashMap.put(entry.getKey(), defineClass((String)entry.getKey(), (byte[])entry.getValue(), 0, ((byte[])entry.getValue()).length));
/*     */     }
/* 165 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class CompoundEnumeration
/*     */     implements Enumeration<URL>
/*     */   {
/*     */     private static final int FIRST = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<Enumeration<URL>> enumerations;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @UnknownNull
/*     */     private Enumeration<URL> current;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected CompoundEnumeration(List<Enumeration<URL>> param1List) {
/* 195 */       this.enumerations = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasMoreElements() {
/* 202 */       if (this.current != null && this.current.hasMoreElements())
/* 203 */         return true; 
/* 204 */       if (!this.enumerations.isEmpty()) {
/* 205 */         this.current = this.enumerations.remove(0);
/* 206 */         return hasMoreElements();
/*     */       } 
/* 208 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @SuppressFBWarnings(value = {"UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"}, justification = "Null reference is avoided by element check.")
/*     */     public URL nextElement() {
/* 217 */       if (hasMoreElements()) {
/* 218 */         return this.current.nextElement();
/*     */       }
/* 220 */       throw new NoSuchElementException();
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
/*     */   @Enhance
/*     */   public static class Builder
/*     */   {
/*     */     private final boolean sealed;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<? extends ClassLoader> classLoaders;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder() {
/* 250 */       this(true);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder(boolean param1Boolean) {
/* 259 */       this(Collections.emptyList(), param1Boolean);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Builder(List<? extends ClassLoader> param1List, boolean param1Boolean) {
/* 269 */       this.classLoaders = param1List;
/* 270 */       this.sealed = param1Boolean;
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
/*     */     public Builder append(Class<?>... param1VarArgs) {
/* 282 */       return append(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder append(Collection<? extends Class<?>> param1Collection) {
/* 293 */       ArrayList<ClassLoader> arrayList = new ArrayList(param1Collection.size());
/* 294 */       for (Class<?> clazz : param1Collection) {
/* 295 */         arrayList.add(clazz.getClassLoader());
/*     */       }
/* 297 */       return append(arrayList);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder append(ClassLoader... param1VarArgs) {
/* 308 */       return append(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder append(List<? extends ClassLoader> param1List) {
/*     */       ArrayList<ClassLoader> arrayList;
/* 320 */       (arrayList = new ArrayList<ClassLoader>(this.classLoaders.size() + param1List.size())).addAll(this.classLoaders);
/* 321 */       HashSet<ClassLoader> hashSet = new HashSet<ClassLoader>(this.classLoaders);
/* 322 */       for (Iterator<? extends ClassLoader> iterator = param1List.iterator(); iterator.hasNext();) {
/* 323 */         if ((classLoader = iterator.next()) != null && hashSet.add(classLoader)) {
/* 324 */           arrayList.add(classLoader);
/*     */         }
/*     */       } 
/* 327 */       return new Builder(arrayList, this.sealed);
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
/*     */     public Builder appendMostSpecific(Class<?>... param1VarArgs) {
/* 340 */       return appendMostSpecific(Arrays.asList(param1VarArgs));
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
/*     */     public Builder appendMostSpecific(Collection<? extends Class<?>> param1Collection) {
/* 352 */       ArrayList<ClassLoader> arrayList = new ArrayList(param1Collection.size());
/* 353 */       for (Class<?> clazz : param1Collection) {
/* 354 */         arrayList.add(clazz.getClassLoader());
/*     */       }
/* 356 */       return appendMostSpecific(arrayList);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder appendMostSpecific(ClassLoader... param1VarArgs) {
/* 367 */       return appendMostSpecific(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder appendMostSpecific(List<? extends ClassLoader> param1List) {
/*     */       ArrayList<ClassLoader> arrayList;
/* 379 */       (arrayList = new ArrayList<ClassLoader>(this.classLoaders.size() + param1List.size())).addAll(this.classLoaders);
/*     */       Iterator<? extends ClassLoader> iterator;
/* 381 */       label30: for (iterator = param1List.iterator(); iterator.hasNext();) {
/* 382 */         if ((classLoader = iterator.next()) != null) {
/*     */ 
/*     */           
/* 385 */           ClassLoader classLoader1 = classLoader;
/*     */           while (true) {
/* 387 */             Iterator<ClassLoader> iterator1 = arrayList.iterator();
/* 388 */             while (iterator1.hasNext()) {
/*     */               ClassLoader classLoader2;
/* 390 */               if ((classLoader2 = iterator1.next()).equals(classLoader1)) {
/* 391 */                 iterator1.remove();
/*     */               }
/*     */             } 
/* 394 */             if ((classLoader1 = classLoader1.getParent()) == null)
/* 395 */             { label27: for (ClassLoader classLoader2 : arrayList)
/*     */               
/* 397 */               { while (!classLoader2.equals(classLoader))
/*     */                 
/*     */                 { 
/* 400 */                   if ((classLoader2 = classLoader2.getParent()) == null)
/*     */                     continue label27;  }  continue label30; }  break; } 
/* 402 */           }  arrayList.add(classLoader);
/*     */         } 
/* 404 */       }  return new Builder(arrayList, this.sealed);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder filter(ElementMatcher<? super ClassLoader> param1ElementMatcher) {
/* 414 */       ArrayList<ClassLoader> arrayList = new ArrayList(this.classLoaders.size());
/* 415 */       for (ClassLoader classLoader : this.classLoaders) {
/* 416 */         if (param1ElementMatcher.matches(classLoader)) {
/* 417 */           arrayList.add(classLoader);
/*     */         }
/*     */       } 
/* 420 */       return new Builder(arrayList, this.sealed);
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
/*     */     public ClassLoader build() {
/* 438 */       return (this.classLoaders.size() == 1) ? this.classLoaders
/* 439 */         .get(0) : 
/* 440 */         doBuild(ClassLoadingStrategy.BOOTSTRAP_LOADER);
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
/*     */     public ClassLoader build(ClassLoader param1ClassLoader) {
/* 459 */       return (this.classLoaders.isEmpty() || (this.classLoaders.size() == 1 && this.classLoaders.contains(param1ClassLoader))) ? param1ClassLoader : 
/*     */         
/* 461 */         filter((ElementMatcher<? super ClassLoader>)ElementMatchers.not((ElementMatcher)ElementMatchers.is(param1ClassLoader))).doBuild(param1ClassLoader);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @SuppressFBWarnings(value = {"DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"}, justification = "Assuring privilege is explicit user responsibility.")
/*     */     private ClassLoader doBuild(@MaybeNull ClassLoader param1ClassLoader) {
/* 472 */       return new MultipleParentClassLoader(param1ClassLoader, this.classLoaders, this.sealed);
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.sealed != ((Builder)param1Object).sealed) ? false : (!!this.classLoaders.equals(((Builder)param1Object).classLoaders)))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.sealed) * 31 + this.classLoaders.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\loading\MultipleParentClassLoader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */