/*     */ package com.esotericsoftware.reflectasm;
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
/*     */ public abstract class ConstructorAccess<T>
/*     */ {
/*     */   boolean isNonStaticMemberClass;
/*     */   
/*     */   public boolean isNonStaticMemberClass() {
/*  29 */     return this.isNonStaticMemberClass;
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
/*     */     ConstructorAccess<T> constructorAccess;
/*     */     Class<ConstructorAccess> clazz1;
/*     */     Class<?> clazz;
/*  46 */     boolean bool = ((clazz = paramClass.getEnclosingClass()) != null && paramClass.isMemberClass() && !Modifier.isStatic(paramClass.getModifiers())) ? true : false;
/*     */     
/*  48 */     String str1 = paramClass.getName();
/*     */     String str2;
/*  50 */     if ((str2 = str1 + "ConstructorAccess").startsWith("java.")) str2 = "reflectasm." + str2;
/*     */ 
/*     */     
/*     */     AccessClassLoader accessClassLoader;
/*  54 */     synchronized (accessClassLoader = AccessClassLoader.get(paramClass)) {
/*     */       
/*  56 */       if ((clazz1 = accessClassLoader.loadAccessClass(str2)) == null) {
/*  57 */         String str5, str4 = str2.replace('.', '/');
/*  58 */         str1 = str1.replace('.', '/');
/*     */ 
/*     */ 
/*     */         
/*  62 */         if (!bool) {
/*  63 */           str5 = null;
/*     */           try {
/*     */             Constructor<T> constructor;
/*  66 */             int i = (constructor = paramClass.getDeclaredConstructor((Class[])null)).getModifiers();
/*  67 */           } catch (Exception null) {
/*  68 */             throw new RuntimeException("Class cannot be created (missing no-arg constructor): " + paramClass.getName(), exception);
/*     */           } 
/*  70 */           if (Modifier.isPrivate(exception)) {
/*  71 */             throw new RuntimeException("Class cannot be created (the no-arg constructor is private): " + paramClass.getName());
/*     */           }
/*     */         } else {
/*  74 */           str5 = exception.getName().replace('.', '/');
/*     */           try {
/*     */             Constructor<T> constructor;
/*  77 */             int i = (constructor = paramClass.getDeclaredConstructor(new Class[] { (Class)exception })).getModifiers();
/*  78 */           } catch (Exception exception) {
/*  79 */             throw new RuntimeException("Non-static member class cannot be created (missing enclosing class constructor): " + paramClass
/*  80 */                 .getName(), exception);
/*     */           } 
/*  82 */           if (Modifier.isPrivate(exception)) {
/*  83 */             throw new RuntimeException("Non-static member class cannot be created (the enclosing class constructor is private): " + paramClass
/*  84 */                 .getName());
/*     */           }
/*     */         } 
/*  87 */         String str3 = Modifier.isPublic(exception) ? "com/esotericsoftware/reflectasm/PublicConstructorAccess" : "com/esotericsoftware/reflectasm/ConstructorAccess";
/*     */ 
/*     */         
/*     */         ClassWriter classWriter;
/*     */         
/*  92 */         (classWriter = new ClassWriter(0)).visit(196653, 33, str4, null, str3, null);
/*     */         
/*  94 */         insertConstructor(classWriter, str3);
/*  95 */         insertNewInstance(classWriter, str1);
/*  96 */         insertNewInstanceInner(classWriter, str1, str5);
/*     */         
/*  98 */         classWriter.visitEnd();
/*  99 */         clazz1 = accessClassLoader.defineAccessClass(str2, classWriter.toByteArray());
/*     */       } 
/*     */     } 
/*     */     
/*     */     try {
/* 104 */       constructorAccess = clazz1.newInstance();
/* 105 */     } catch (Throwable throwable) {
/* 106 */       throw new RuntimeException("Exception constructing constructor access class: " + str2, throwable);
/*     */     } 
/* 108 */     if (!(constructorAccess instanceof PublicConstructorAccess) && !AccessClassLoader.areInSameRuntimeClassLoader(paramClass, (Class)throwable))
/*     */     {
/*     */       
/* 111 */       throw new RuntimeException((!bool ? "Class cannot be created (the no-arg constructor is protected or package-protected, and its ConstructorAccess could not be defined in the same class loader): " : "Non-static member class cannot be created (the enclosing class constructor is protected or package-protected, and its ConstructorAccess could not be defined in the same class loader): ") + paramClass
/*     */ 
/*     */           
/* 114 */           .getName());
/*     */     }
/* 116 */     constructorAccess.isNonStaticMemberClass = bool;
/* 117 */     return constructorAccess;
/*     */   }
/*     */   
/*     */   private static void insertConstructor(ClassWriter paramClassWriter, String paramString) {
/*     */     MethodVisitor methodVisitor;
/* 122 */     (methodVisitor = paramClassWriter.visitMethod(1, "<init>", "()V", null, null)).visitCode();
/* 123 */     methodVisitor.visitVarInsn(25, 0);
/* 124 */     methodVisitor.visitMethodInsn(183, paramString, "<init>", "()V");
/* 125 */     methodVisitor.visitInsn(177);
/* 126 */     methodVisitor.visitMaxs(1, 1);
/* 127 */     methodVisitor.visitEnd();
/*     */   }
/*     */   
/*     */   static void insertNewInstance(ClassWriter paramClassWriter, String paramString) {
/*     */     MethodVisitor methodVisitor;
/* 132 */     (methodVisitor = paramClassWriter.visitMethod(1, "newInstance", "()Ljava/lang/Object;", null, null)).visitCode();
/* 133 */     methodVisitor.visitTypeInsn(187, paramString);
/* 134 */     methodVisitor.visitInsn(89);
/* 135 */     methodVisitor.visitMethodInsn(183, paramString, "<init>", "()V");
/* 136 */     methodVisitor.visitInsn(176);
/* 137 */     methodVisitor.visitMaxs(2, 1);
/* 138 */     methodVisitor.visitEnd();
/*     */   }
/*     */   
/*     */   static void insertNewInstanceInner(ClassWriter paramClassWriter, String paramString1, String paramString2) {
/*     */     MethodVisitor methodVisitor;
/* 143 */     (methodVisitor = paramClassWriter.visitMethod(1, "newInstance", "(Ljava/lang/Object;)Ljava/lang/Object;", null, null)).visitCode();
/* 144 */     if (paramString2 != null) {
/* 145 */       methodVisitor.visitTypeInsn(187, paramString1);
/* 146 */       methodVisitor.visitInsn(89);
/* 147 */       methodVisitor.visitVarInsn(25, 1);
/* 148 */       methodVisitor.visitTypeInsn(192, paramString2);
/* 149 */       methodVisitor.visitInsn(89);
/* 150 */       methodVisitor.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
/* 151 */       methodVisitor.visitInsn(87);
/* 152 */       methodVisitor.visitMethodInsn(183, paramString1, "<init>", "(L" + paramString2 + ";)V");
/* 153 */       methodVisitor.visitInsn(176);
/* 154 */       methodVisitor.visitMaxs(4, 2);
/*     */     } else {
/* 156 */       methodVisitor.visitTypeInsn(187, "java/lang/UnsupportedOperationException");
/* 157 */       methodVisitor.visitInsn(89);
/* 158 */       methodVisitor.visitLdcInsn("Not an inner class.");
/* 159 */       methodVisitor.visitMethodInsn(183, "java/lang/UnsupportedOperationException", "<init>", "(Ljava/lang/String;)V");
/* 160 */       methodVisitor.visitInsn(191);
/* 161 */       methodVisitor.visitMaxs(3, 2);
/*     */     } 
/* 163 */     methodVisitor.visitEnd();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\reflectasm\ConstructorAccess.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */