/*     */ package net.bytebuddy.implementation;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.security.AccessControlContext;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.utility.JavaModule;
/*     */ import net.bytebuddy.utility.nullability.MaybeNull;
/*     */ import net.bytebuddy.utility.privilege.SetAccessibleAction;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface LoadedTypeInitializer
/*     */ {
/*     */   void onLoad(Class<?> paramClass);
/*     */   
/*     */   boolean isAlive();
/*     */   
/*     */   public enum NoOp
/*     */     implements LoadedTypeInitializer
/*     */   {
/*  65 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void onLoad(Class<?> param1Class) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isAlive() {
/*  78 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class ForStaticField
/*     */     implements Serializable, LoadedTypeInitializer
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final String fieldName;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final Object value;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
/*     */     private final transient Object accessControlContext;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final boolean ACCESS_CONTROLLER;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForStaticField(String param1String, Object param1Object) {
/* 119 */       this.fieldName = param1String;
/* 120 */       this.value = param1Object;
/* 121 */       this.accessControlContext = getContext();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     @Enhance
/*     */     private static Object getContext() {
/* 132 */       return ACCESS_CONTROLLER ? AccessController.getContext() : null;
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
/*     */     @Enhance
/*     */     private static <T> T doPrivileged(PrivilegedAction<T> param1PrivilegedAction, @MaybeNull Object param1Object) {
/* 145 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction, (AccessControlContext)param1Object) : param1PrivilegedAction.run();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Object readResolve() {
/* 154 */       return new ForStaticField(this.fieldName, this.value);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Modules are assumed available when module system is supported")
/*     */     public void onLoad(Class<?> param1Class) {
/*     */       try {
/*     */         Field field;
/* 164 */         if (!Modifier.isPublic((field = param1Class.getDeclaredField(this.fieldName)).getModifiers()) || 
/* 165 */           !Modifier.isPublic(field.getDeclaringClass().getModifiers()) || (
/* 166 */           JavaModule.isSupported() && 
/* 167 */           !JavaModule.ofType(param1Class).isExported(TypeDescription.ForLoadedType.of(param1Class).getPackage(), JavaModule.ofType(ForStaticField.class)))) {
/* 168 */           doPrivileged((PrivilegedAction<?>)new SetAccessibleAction(field), this.accessControlContext);
/*     */         }
/* 170 */         field.set(null, this.value); return;
/* 171 */       } catch (IllegalAccessException illegalAccessException) {
/* 172 */         throw new IllegalArgumentException("Cannot access " + this.fieldName + " from " + param1Class, illegalAccessException);
/* 173 */       } catch (NoSuchFieldException noSuchFieldException) {
/* 174 */         throw new IllegalStateException("There is no field " + this.fieldName + " defined on " + param1Class, noSuchFieldException);
/*     */       } 
/*     */     } public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.fieldName.equals(((ForStaticField)param1Object).fieldName) ? false : (!!this.value.equals(((ForStaticField)param1Object).value)))));
/*     */     } public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.fieldName.hashCode()) * 31 + this.value.hashCode();
/*     */     }
/*     */     public boolean isAlive() {
/* 182 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */       try {
/*     */         Class.forName("java.security.AccessController", false, (ClassLoader)null);
/*     */         ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
/*     */         return;
/*     */       } catch (ClassNotFoundException classNotFoundException) {
/*     */         ACCESS_CONTROLLER = false;
/*     */         return;
/*     */       } catch (SecurityException securityException) {
/*     */         ACCESS_CONTROLLER = true;
/*     */         return;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   @SuppressFBWarnings(value = {"SE_BAD_FIELD"}, justification = "Serialization is considered opt-in for a rare use case")
/*     */   public static class Compound
/*     */     implements Serializable, LoadedTypeInitializer
/*     */   {
/*     */     public Compound(LoadedTypeInitializer... param1VarArgs) {
/* 210 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/* 219 */     private final List<LoadedTypeInitializer> loadedTypeInitializers = new ArrayList<LoadedTypeInitializer>(); public Compound(List<? extends LoadedTypeInitializer> param1List) {
/* 220 */       for (Iterator<? extends LoadedTypeInitializer> iterator = param1List.iterator(); iterator.hasNext(); ) {
/* 221 */         LoadedTypeInitializer loadedTypeInitializer; if (loadedTypeInitializer = iterator.next() instanceof Compound) {
/* 222 */           this.loadedTypeInitializers.addAll(((Compound)loadedTypeInitializer).loadedTypeInitializers); continue;
/* 223 */         }  if (!(loadedTypeInitializer instanceof LoadedTypeInitializer.NoOp)) {
/* 224 */           this.loadedTypeInitializers.add(loadedTypeInitializer);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onLoad(Class<?> param1Class) {
/* 233 */       for (Iterator<LoadedTypeInitializer> iterator = this.loadedTypeInitializers.iterator(); iterator.hasNext();) {
/* 234 */         (loadedTypeInitializer = iterator.next()).onLoad(param1Class);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isAlive() {
/* 242 */       for (Iterator<LoadedTypeInitializer> iterator = this.loadedTypeInitializers.iterator(); iterator.hasNext();) {
/* 243 */         if ((loadedTypeInitializer = iterator.next()).isAlive()) {
/* 244 */           return true;
/*     */         }
/*     */       } 
/* 247 */       return false;
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.loadedTypeInitializers.equals(((Compound)param1Object).loadedTypeInitializers))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.loadedTypeInitializers.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\LoadedTypeInitializer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */