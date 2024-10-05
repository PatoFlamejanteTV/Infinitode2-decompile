/*     */ package com.prineside.reflectasm;
/*     */ 
/*     */ import com.esotericsoftware.asm.ClassWriter;
/*     */ import com.esotericsoftware.asm.MethodVisitor;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Modifier;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ConstructorAccess<T>
/*     */ {
/*     */   private boolean a;
/*     */   
/*     */   public boolean isNonStaticMemberClass() {
/*  41 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract T newInstance();
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract T newInstance(Object paramObject);
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> ConstructorAccess<T> get(Class<T> paramClass) {
/*     */     Class<ConstructorAccess> clazz1;
/*     */     ConstructorAccess<T> constructorAccess;
/*     */     Class<?> clazz;
/*  58 */     boolean bool = ((clazz = paramClass.getEnclosingClass()) != null && paramClass.isMemberClass() && !Modifier.isStatic(paramClass.getModifiers())) ? true : false;
/*     */     
/*  60 */     String str1 = paramClass.getName();
/*     */     String str2;
/*  62 */     if ((str2 = str1 + "ConstructorAccess").startsWith("java.")) str2 = "reflectasm." + str2;
/*     */ 
/*     */     
/*     */     AccessClassLoader accessClassLoader;
/*  66 */     synchronized (accessClassLoader = AccessClassLoader.a(paramClass)) {
/*     */       
/*  68 */       if ((clazz1 = accessClassLoader.a(str2)) == null) {
/*  69 */         String str5, str4 = str2.replace('.', '/');
/*  70 */         str1 = str1.replace('.', '/');
/*     */ 
/*     */ 
/*     */         
/*  74 */         if (!bool) {
/*  75 */           str5 = null;
/*     */           try {
/*     */             Constructor<T> constructor;
/*  78 */             int i = (constructor = paramClass.getDeclaredConstructor((Class[])null)).getModifiers();
/*  79 */           } catch (Exception null) {
/*  80 */             throw new RuntimeException("Class cannot be created (missing no-arg constructor): " + paramClass.getName(), exception);
/*     */           } 
/*  82 */           if (Modifier.isPrivate(exception)) {
/*  83 */             throw new RuntimeException("Class cannot be created (the no-arg constructor is private): " + paramClass.getName());
/*     */           }
/*     */         } else {
/*  86 */           str5 = exception.getName().replace('.', '/');
/*     */           try {
/*     */             Constructor<T> constructor;
/*  89 */             int i = (constructor = paramClass.getDeclaredConstructor(new Class[] { (Class)exception })).getModifiers();
/*  90 */           } catch (Exception exception) {
/*  91 */             throw new RuntimeException("Non-static member class cannot be created (missing enclosing class constructor): " + paramClass
/*  92 */                 .getName(), exception);
/*     */           } 
/*  94 */           if (Modifier.isPrivate(exception)) {
/*  95 */             throw new RuntimeException("Non-static member class cannot be created (the enclosing class constructor is private): " + paramClass
/*  96 */                 .getName());
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 101 */         String str3 = Modifier.isPublic(exception) ? "com/prineside/reflectasm/PublicConstructorAccess" : "com/prineside/reflectasm/ConstructorAccess";
/*     */         
/*     */         ClassWriter classWriter;
/* 104 */         (classWriter = new ClassWriter(0)).visit(50, 33, str4, null, str3, null);
/*     */         
/* 106 */         a(classWriter, str3);
/* 107 */         b(classWriter, str1);
/* 108 */         a(classWriter, str1, str5);
/*     */         
/* 110 */         classWriter.visitEnd();
/* 111 */         clazz1 = accessClassLoader.a(str2, classWriter.toByteArray());
/*     */       } 
/*     */     } 
/*     */     
/*     */     try {
/* 116 */       constructorAccess = clazz1.newInstance();
/* 117 */     } catch (Throwable throwable) {
/* 118 */       throw new RuntimeException("Exception constructing constructor access class: " + str2, throwable);
/*     */     } 
/* 120 */     if (!(constructorAccess instanceof PublicConstructorAccess) && !AccessClassLoader.a(paramClass, (Class)throwable))
/*     */     {
/*     */       
/* 123 */       throw new RuntimeException((!bool ? 
/* 124 */           "Class cannot be created (the no-arg constructor is protected or package-protected, and its ConstructorAccess could not be defined in the same class loader): " : 
/* 125 */           "Non-static member class cannot be created (the enclosing class constructor is protected or package-protected, and its ConstructorAccess could not be defined in the same class loader): ") + paramClass
/* 126 */           .getName());
/*     */     }
/* 128 */     constructorAccess.a = bool;
/* 129 */     return constructorAccess;
/*     */   }
/*     */   
/*     */   private static void a(ClassWriter paramClassWriter, String paramString) {
/*     */     MethodVisitor methodVisitor;
/* 134 */     (methodVisitor = paramClassWriter.visitMethod(1, "<init>", "()V", null, null)).visitCode();
/* 135 */     methodVisitor.visitVarInsn(25, 0);
/* 136 */     methodVisitor.visitMethodInsn(183, paramString, "<init>", "()V");
/* 137 */     methodVisitor.visitInsn(177);
/* 138 */     methodVisitor.visitMaxs(1, 1);
/* 139 */     methodVisitor.visitEnd();
/*     */   }
/*     */   
/*     */   private static void b(ClassWriter paramClassWriter, String paramString) {
/*     */     MethodVisitor methodVisitor;
/* 144 */     (methodVisitor = paramClassWriter.visitMethod(1, "newInstance", "()Ljava/lang/Object;", null, null)).visitCode();
/* 145 */     methodVisitor.visitTypeInsn(187, paramString);
/* 146 */     methodVisitor.visitInsn(89);
/* 147 */     methodVisitor.visitMethodInsn(183, paramString, "<init>", "()V");
/* 148 */     methodVisitor.visitInsn(176);
/* 149 */     methodVisitor.visitMaxs(2, 1);
/* 150 */     methodVisitor.visitEnd();
/*     */   }
/*     */   
/*     */   private static void a(ClassWriter paramClassWriter, String paramString1, String paramString2) {
/*     */     MethodVisitor methodVisitor;
/* 155 */     (methodVisitor = paramClassWriter.visitMethod(1, "newInstance", "(Ljava/lang/Object;)Ljava/lang/Object;", null, null)).visitCode();
/* 156 */     if (paramString2 != null) {
/* 157 */       methodVisitor.visitTypeInsn(187, paramString1);
/* 158 */       methodVisitor.visitInsn(89);
/* 159 */       methodVisitor.visitVarInsn(25, 1);
/* 160 */       methodVisitor.visitTypeInsn(192, paramString2);
/* 161 */       methodVisitor.visitInsn(89);
/* 162 */       methodVisitor.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
/* 163 */       methodVisitor.visitInsn(87);
/* 164 */       methodVisitor.visitMethodInsn(183, paramString1, "<init>", "(L" + paramString2 + ";)V");
/* 165 */       methodVisitor.visitInsn(176);
/* 166 */       methodVisitor.visitMaxs(4, 2);
/*     */     } else {
/* 168 */       methodVisitor.visitTypeInsn(187, "java/lang/UnsupportedOperationException");
/* 169 */       methodVisitor.visitInsn(89);
/* 170 */       methodVisitor.visitLdcInsn("Not an inner class.");
/* 171 */       methodVisitor.visitMethodInsn(183, "java/lang/UnsupportedOperationException", "<init>", "(Ljava/lang/String;)V");
/* 172 */       methodVisitor.visitInsn(191);
/* 173 */       methodVisitor.visitMaxs(3, 2);
/*     */     } 
/* 175 */     methodVisitor.visitEnd();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\reflectasm\ConstructorAccess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */