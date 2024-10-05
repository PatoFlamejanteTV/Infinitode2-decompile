/*     */ package com.esotericsoftware.reflectasm;
/*     */ 
/*     */ import com.esotericsoftware.asm.ClassWriter;
/*     */ import com.esotericsoftware.asm.Label;
/*     */ import com.esotericsoftware.asm.MethodVisitor;
/*     */ import com.esotericsoftware.asm.Type;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class MethodAccess
/*     */ {
/*     */   private String[] methodNames;
/*     */   private Class[][] parameterTypes;
/*     */   private Class[] returnTypes;
/*     */   
/*     */   public abstract Object invoke(Object paramObject, int paramInt, Object... paramVarArgs);
/*     */   
/*     */   public Object invoke(Object paramObject, String paramString, Class[] paramArrayOfClass, Object... paramVarArgs) {
/*  39 */     return invoke(paramObject, getIndex(paramString, paramArrayOfClass), paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object invoke(Object paramObject, String paramString, Object... paramVarArgs) {
/*  44 */     return invoke(paramObject, getIndex(paramString, (paramVarArgs == null) ? 0 : paramVarArgs.length), paramVarArgs);
/*     */   }
/*     */   public int getIndex(String paramString) {
/*     */     byte b;
/*     */     int i;
/*  49 */     for (b = 0, i = this.methodNames.length; b < i; b++) {
/*  50 */       if (this.methodNames[b].equals(paramString)) return b; 
/*  51 */     }  throw new IllegalArgumentException("Unable to find non-private method: " + paramString);
/*     */   }
/*     */   public int getIndex(String paramString, Class... paramVarArgs) {
/*     */     byte b;
/*     */     int i;
/*  56 */     for (b = 0, i = this.methodNames.length; b < i; b++) {
/*  57 */       if (this.methodNames[b].equals(paramString) && Arrays.equals((Object[])paramVarArgs, (Object[])this.parameterTypes[b])) return b; 
/*  58 */     }  throw new IllegalArgumentException("Unable to find non-private method: " + paramString + " " + Arrays.toString(paramVarArgs));
/*     */   }
/*     */   public int getIndex(String paramString, int paramInt) {
/*     */     byte b;
/*     */     int i;
/*  63 */     for (b = 0, i = this.methodNames.length; b < i; b++) {
/*  64 */       if (this.methodNames[b].equals(paramString) && (this.parameterTypes[b]).length == paramInt) return b; 
/*  65 */     }  throw new IllegalArgumentException("Unable to find non-private method: " + paramString + " with " + paramInt + " params.");
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getMethodNames() {
/*  70 */     return this.methodNames;
/*     */   }
/*     */   
/*     */   public Class[][] getParameterTypes() {
/*  74 */     return this.parameterTypes;
/*     */   }
/*     */   
/*     */   public Class[] getReturnTypes() {
/*  78 */     return this.returnTypes;
/*     */   }
/*     */ 
/*     */   
/*     */   public static MethodAccess get(Class<Object> paramClass) {
/*     */     Class<MethodAccess> clazz;
/*     */     boolean bool;
/*  85 */     if (!(bool = paramClass.isInterface()) && paramClass.getSuperclass() == null && paramClass != Object.class) {
/*  86 */       throw new IllegalArgumentException("The type must not be an interface, a primitive type, or void.");
/*     */     }
/*  88 */     ArrayList<Method> arrayList = new ArrayList();
/*  89 */     if (!bool) {
/*  90 */       Class<Object> clazz1 = paramClass;
/*  91 */       while (clazz1 != Object.class) {
/*  92 */         addDeclaredMethodsToList(clazz1, arrayList);
/*  93 */         clazz1 = (Class)clazz1.getSuperclass();
/*     */       } 
/*     */     } else {
/*  96 */       recursiveAddInterfaceMethodsToList(paramClass, arrayList);
/*     */     } 
/*     */     int i;
/*  99 */     String[] arrayOfString = new String[i = arrayList.size()];
/* 100 */     Class[][] arrayOfClass = new Class[i][];
/* 101 */     Class[] arrayOfClass1 = new Class[i];
/* 102 */     for (byte b = 0; b < i; b++) {
/* 103 */       Method method = arrayList.get(b);
/* 104 */       arrayOfString[b] = method.getName();
/* 105 */       arrayOfClass[b] = method.getParameterTypes();
/* 106 */       arrayOfClass1[b] = method.getReturnType();
/*     */     } 
/*     */     
/* 109 */     String str1 = paramClass.getName();
/*     */     String str2;
/* 111 */     if ((str2 = str1 + "MethodAccess").startsWith("java.")) str2 = "reflectasm." + str2;
/*     */ 
/*     */ 
/*     */     
/* 115 */     synchronized (null = AccessClassLoader.get(paramClass)) {
/*     */       
/* 117 */       if ((clazz = null.loadAccessClass(str2)) == null) {
/* 118 */         String str = str2.replace('.', '/');
/* 119 */         str1 = str1.replace('.', '/');
/*     */         
/*     */         ClassWriter classWriter;
/*     */         
/* 123 */         (classWriter = new ClassWriter(1)).visit(196653, 33, str, null, "com/esotericsoftware/reflectasm/MethodAccess", null);
/*     */         
/*     */         MethodVisitor methodVisitor;
/*     */         
/* 127 */         (methodVisitor = classWriter.visitMethod(1, "<init>", "()V", null, null)).visitCode();
/* 128 */         methodVisitor.visitVarInsn(25, 0);
/* 129 */         methodVisitor.visitMethodInsn(183, "com/esotericsoftware/reflectasm/MethodAccess", "<init>", "()V");
/* 130 */         methodVisitor.visitInsn(177);
/* 131 */         methodVisitor.visitMaxs(0, 0);
/* 132 */         methodVisitor.visitEnd();
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 137 */         (methodVisitor = classWriter.visitMethod(129, "invoke", "(Ljava/lang/Object;I[Ljava/lang/Object;)Ljava/lang/Object;", null, null)).visitCode();
/*     */         
/* 139 */         if (!arrayList.isEmpty()) {
/* 140 */           methodVisitor.visitVarInsn(25, 1);
/* 141 */           methodVisitor.visitTypeInsn(192, str1);
/* 142 */           methodVisitor.visitVarInsn(58, 4);
/*     */           
/* 144 */           methodVisitor.visitVarInsn(21, 2);
/* 145 */           Label[] arrayOfLabel = new Label[i];
/* 146 */           for (byte b1 = 0; b1 < i; b1++)
/* 147 */             arrayOfLabel[b1] = new Label(); 
/* 148 */           Label label = new Label();
/* 149 */           methodVisitor.visitTableSwitchInsn(0, i - 1, label, arrayOfLabel);
/*     */           
/* 151 */           StringBuilder stringBuilder = new StringBuilder(128);
/* 152 */           for (byte b2 = 0; b2 < i; b2++) {
/* 153 */             methodVisitor.visitLabel(arrayOfLabel[b2]);
/* 154 */             if (b2 == 0) {
/* 155 */               methodVisitor.visitFrame(1, 1, new Object[] { str1 }, 0, null);
/*     */             } else {
/* 157 */               methodVisitor.visitFrame(3, 0, null, 0, null);
/* 158 */             }  methodVisitor.visitVarInsn(25, 4);
/*     */             
/* 160 */             stringBuilder.setLength(0);
/* 161 */             stringBuilder.append('(');
/*     */             
/* 163 */             Class[] arrayOfClass2 = arrayOfClass[b2];
/* 164 */             Class clazz1 = arrayOfClass1[b2]; char c;
/* 165 */             for (c = Character.MIN_VALUE; c < arrayOfClass2.length; c++) {
/* 166 */               methodVisitor.visitVarInsn(25, 3);
/* 167 */               methodVisitor.visitIntInsn(16, c);
/* 168 */               methodVisitor.visitInsn(50);
/*     */               Type type;
/* 170 */               switch ((type = Type.getType(arrayOfClass2[c])).getSort()) {
/*     */                 case 1:
/* 172 */                   methodVisitor.visitTypeInsn(192, "java/lang/Boolean");
/* 173 */                   methodVisitor.visitMethodInsn(182, "java/lang/Boolean", "booleanValue", "()Z");
/*     */                   break;
/*     */                 case 3:
/* 176 */                   methodVisitor.visitTypeInsn(192, "java/lang/Byte");
/* 177 */                   methodVisitor.visitMethodInsn(182, "java/lang/Byte", "byteValue", "()B");
/*     */                   break;
/*     */                 case 2:
/* 180 */                   methodVisitor.visitTypeInsn(192, "java/lang/Character");
/* 181 */                   methodVisitor.visitMethodInsn(182, "java/lang/Character", "charValue", "()C");
/*     */                   break;
/*     */                 case 4:
/* 184 */                   methodVisitor.visitTypeInsn(192, "java/lang/Short");
/* 185 */                   methodVisitor.visitMethodInsn(182, "java/lang/Short", "shortValue", "()S");
/*     */                   break;
/*     */                 case 5:
/* 188 */                   methodVisitor.visitTypeInsn(192, "java/lang/Integer");
/* 189 */                   methodVisitor.visitMethodInsn(182, "java/lang/Integer", "intValue", "()I");
/*     */                   break;
/*     */                 case 6:
/* 192 */                   methodVisitor.visitTypeInsn(192, "java/lang/Float");
/* 193 */                   methodVisitor.visitMethodInsn(182, "java/lang/Float", "floatValue", "()F");
/*     */                   break;
/*     */                 case 7:
/* 196 */                   methodVisitor.visitTypeInsn(192, "java/lang/Long");
/* 197 */                   methodVisitor.visitMethodInsn(182, "java/lang/Long", "longValue", "()J");
/*     */                   break;
/*     */                 case 8:
/* 200 */                   methodVisitor.visitTypeInsn(192, "java/lang/Double");
/* 201 */                   methodVisitor.visitMethodInsn(182, "java/lang/Double", "doubleValue", "()D");
/*     */                   break;
/*     */                 case 9:
/* 204 */                   methodVisitor.visitTypeInsn(192, type.getDescriptor());
/*     */                   break;
/*     */                 case 10:
/* 207 */                   methodVisitor.visitTypeInsn(192, type.getInternalName());
/*     */                   break;
/*     */               } 
/* 210 */               stringBuilder.append(type.getDescriptor());
/*     */             } 
/*     */             
/* 213 */             stringBuilder.append(')');
/* 214 */             stringBuilder.append(Type.getDescriptor(clazz1));
/*     */             
/* 216 */             if (bool) {
/* 217 */               c = '¹';
/* 218 */             } else if (Modifier.isStatic(((Method)arrayList.get(b2)).getModifiers())) {
/* 219 */               c = '¸';
/*     */             } else {
/* 221 */               c = '¶';
/* 222 */             }  methodVisitor.visitMethodInsn(c, str1, arrayOfString[b2], stringBuilder.toString());
/*     */             
/* 224 */             switch (Type.getType(clazz1).getSort()) {
/*     */               case 0:
/* 226 */                 methodVisitor.visitInsn(1);
/*     */                 break;
/*     */               case 1:
/* 229 */                 methodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
/*     */                 break;
/*     */               case 3:
/* 232 */                 methodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
/*     */                 break;
/*     */               case 2:
/* 235 */                 methodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
/*     */                 break;
/*     */               case 4:
/* 238 */                 methodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
/*     */                 break;
/*     */               case 5:
/* 241 */                 methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
/*     */                 break;
/*     */               case 6:
/* 244 */                 methodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
/*     */                 break;
/*     */               case 7:
/* 247 */                 methodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
/*     */                 break;
/*     */               case 8:
/* 250 */                 methodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
/*     */                 break;
/*     */             } 
/*     */             
/* 254 */             methodVisitor.visitInsn(176);
/*     */           } 
/*     */           
/* 257 */           methodVisitor.visitLabel(label);
/* 258 */           methodVisitor.visitFrame(3, 0, null, 0, null);
/*     */         } 
/* 260 */         methodVisitor.visitTypeInsn(187, "java/lang/IllegalArgumentException");
/* 261 */         methodVisitor.visitInsn(89);
/* 262 */         methodVisitor.visitTypeInsn(187, "java/lang/StringBuilder");
/* 263 */         methodVisitor.visitInsn(89);
/* 264 */         methodVisitor.visitLdcInsn("Method not found: ");
/* 265 */         methodVisitor.visitMethodInsn(183, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
/* 266 */         methodVisitor.visitVarInsn(21, 2);
/* 267 */         methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
/* 268 */         methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
/* 269 */         methodVisitor.visitMethodInsn(183, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
/* 270 */         methodVisitor.visitInsn(191);
/* 271 */         methodVisitor.visitMaxs(0, 0);
/* 272 */         methodVisitor.visitEnd();
/*     */         
/* 274 */         classWriter.visitEnd();
/* 275 */         byte[] arrayOfByte = classWriter.toByteArray();
/* 276 */         clazz = null.defineAccessClass(str2, arrayOfByte);
/*     */       } 
/*     */     } 
/*     */     try {
/*     */       MethodAccess methodAccess;
/* 281 */       (methodAccess = clazz.newInstance()).methodNames = arrayOfString;
/* 282 */       methodAccess.parameterTypes = arrayOfClass;
/* 283 */       methodAccess.returnTypes = arrayOfClass1;
/* 284 */       return methodAccess;
/* 285 */     } catch (Throwable throwable) {
/* 286 */       throw new RuntimeException("Error constructing method access class: " + str2, throwable);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void addDeclaredMethodsToList(Class paramClass, ArrayList<Method> paramArrayList) {
/* 291 */     Method[] arrayOfMethod = paramClass.getDeclaredMethods(); byte b; int i;
/* 292 */     for (b = 0, i = arrayOfMethod.length; b < i; b++) {
/*     */       Method method;
/*     */       
/*     */       int j;
/* 296 */       if (!Modifier.isPrivate(j = (method = arrayOfMethod[b]).getModifiers()))
/* 297 */         paramArrayList.add(method); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void recursiveAddInterfaceMethodsToList(Class paramClass, ArrayList<Method> paramArrayList) {
/* 302 */     addDeclaredMethodsToList(paramClass, paramArrayList); Class[] arrayOfClass; int i; byte b;
/* 303 */     for (i = (arrayOfClass = paramClass.getInterfaces()).length, b = 0; b < i; b++) {
/* 304 */       Class clazz; recursiveAddInterfaceMethodsToList(clazz = arrayOfClass[b], paramArrayList);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\reflectasm\MethodAccess.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */