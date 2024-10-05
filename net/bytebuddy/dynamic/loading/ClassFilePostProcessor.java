/*     */ package net.bytebuddy.dynamic.loading;
/*     */ 
/*     */ import java.lang.instrument.ClassFileTransformer;
/*     */ import java.lang.instrument.IllegalClassFormatException;
/*     */ import java.security.AllPermission;
/*     */ import java.security.Permission;
/*     */ import java.security.PermissionCollection;
/*     */ import java.security.ProtectionDomain;
/*     */ import java.util.Collections;
/*     */ import java.util.Enumeration;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.utility.nullability.AlwaysNull;
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
/*     */ public interface ClassFilePostProcessor
/*     */ {
/*     */   byte[] transform(@MaybeNull ClassLoader paramClassLoader, String paramString, @MaybeNull ProtectionDomain paramProtectionDomain, byte[] paramArrayOfbyte);
/*     */   
/*     */   public enum NoOp
/*     */     implements ClassFilePostProcessor
/*     */   {
/*  55 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final byte[] transform(@MaybeNull ClassLoader param1ClassLoader, String param1String, @MaybeNull ProtectionDomain param1ProtectionDomain, byte[] param1ArrayOfbyte) {
/*  61 */       return param1ArrayOfbyte;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class ForClassFileTransformer
/*     */     implements ClassFilePostProcessor
/*     */   {
/*  74 */     protected static final ProtectionDomain ALL_PRIVILEGES = new ProtectionDomain(null, new AllPermissionsCollection());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @AlwaysNull
/*  80 */     private static final Class<?> UNLOADED_TYPE = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final ClassFileTransformer classFileTransformer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForClassFileTransformer(ClassFileTransformer param1ClassFileTransformer) {
/*  93 */       this.classFileTransformer = param1ClassFileTransformer;
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
/*     */     public byte[] transform(@MaybeNull ClassLoader param1ClassLoader, String param1String, @MaybeNull ProtectionDomain param1ProtectionDomain, byte[] param1ArrayOfbyte) {
/*     */       try {
/*     */         byte[] arrayOfByte;
/* 107 */         return ((arrayOfByte = this.classFileTransformer.transform(param1ClassLoader, param1String.replace('.', '/'), UNLOADED_TYPE, (param1ProtectionDomain == null) ? ALL_PRIVILEGES : param1ProtectionDomain, param1ArrayOfbyte)) == null) ? param1ArrayOfbyte : arrayOfByte;
/* 108 */       } catch (IllegalClassFormatException illegalClassFormatException) {
/* 109 */         throw new IllegalStateException("Failed to transform " + param1String, illegalClassFormatException);
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.classFileTransformer.equals(((ForClassFileTransformer)param1Object).classFileTransformer))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.classFileTransformer.hashCode();
/*     */     }
/*     */     
/*     */     @Enhance
/*     */     protected static class AllPermissionsCollection extends PermissionCollection {
/*     */       private static final long serialVersionUID = 1L;
/*     */       
/*     */       public void add(Permission param2Permission) {
/* 126 */         throw new UnsupportedOperationException("add");
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean implies(Permission param2Permission) {
/* 131 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public Enumeration<Permission> elements() {
/* 136 */         return Collections.enumeration(Collections.singleton(new AllPermission()));
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : (!(getClass() != param2Object.getClass())));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\loading\ClassFilePostProcessor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */