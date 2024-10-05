/*     */ package com.prineside.reflectasm;
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
/*     */   private String[] a;
/*     */   private Class[][] b;
/*     */   private Class[] c;
/*     */   
/*     */   public abstract Object invoke(Object paramObject, int paramInt, Object... paramVarArgs);
/*     */   
/*     */   public Object invoke(Object paramObject, String paramString, Class[] paramArrayOfClass, Object... paramVarArgs) {
/*  58 */     return invoke(paramObject, getIndex(paramString, paramArrayOfClass), paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object invoke(Object paramObject, String paramString, Object... paramVarArgs) {
/*  63 */     return invoke(paramObject, getIndex(paramString, (paramVarArgs == null) ? 0 : paramVarArgs.length), paramVarArgs);
/*     */   }
/*     */   public int getIndex(String paramString) {
/*     */     byte b;
/*     */     int i;
/*  68 */     for (b = 0, i = this.a.length; b < i; b++) {
/*  69 */       if (this.a[b].equals(paramString)) return b; 
/*  70 */     }  throw new IllegalArgumentException("Unable to find non-private method: " + paramString);
/*     */   }
/*     */   public int getIndex(String paramString, Class... paramVarArgs) {
/*     */     byte b;
/*     */     int i;
/*  75 */     for (b = 0, i = this.a.length; b < i; b++) {
/*  76 */       if (this.a[b].equals(paramString) && Arrays.equals((Object[])paramVarArgs, (Object[])this.b[b])) return b; 
/*  77 */     }  throw new IllegalArgumentException("Unable to find non-private method: " + paramString + " " + Arrays.toString(paramVarArgs));
/*     */   }
/*     */   public int getIndex(String paramString, int paramInt) {
/*     */     byte b;
/*     */     int i;
/*  82 */     for (b = 0, i = this.a.length; b < i; b++) {
/*  83 */       if (this.a[b].equals(paramString) && (this.b[b]).length == paramInt) return b; 
/*  84 */     }  throw new IllegalArgumentException("Unable to find non-private method: " + paramString + " with " + paramInt + " params.");
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getMethodNames() {
/*  89 */     return this.a;
/*     */   }
/*     */   
/*     */   public Class[][] getParameterTypes() {
/*  93 */     return this.b;
/*     */   }
/*     */   
/*     */   public Class[] getReturnTypes() {
/*  97 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static MethodAccess get(Class<Object> paramClass) {
/*     */     boolean bool;
/* 104 */     if (!(bool = paramClass.isInterface()) && paramClass.getSuperclass() == null && paramClass != Object.class) {
/* 105 */       throw new IllegalArgumentException("The type must not be an interface, a primitive type, or void.");
/*     */     }
/* 107 */     ArrayList<Method> arrayList = new ArrayList();
/* 108 */     if (!bool) {
/* 109 */       Class<Object> clazz = paramClass;
/* 110 */       while (clazz != Object.class) {
/* 111 */         a(clazz, arrayList);
/* 112 */         clazz = (Class)clazz.getSuperclass();
/*     */       } 
/*     */     } else {
/* 115 */       b(paramClass, arrayList);
/*     */     } 
/*     */     int i;
/* 118 */     String[] arrayOfString = new String[i = arrayList.size()];
/* 119 */     Class[][] arrayOfClass = new Class[i][];
/* 120 */     Class[] arrayOfClass1 = new Class[i];
/* 121 */     for (byte b = 0; b < i; b++) {
/* 122 */       Method method = arrayList.get(b);
/* 123 */       arrayOfString[b] = method.getName();
/* 124 */       arrayOfClass[b] = method.getParameterTypes();
/* 125 */       arrayOfClass1[b] = method.getReturnType();
/*     */     } 
/*     */     
/* 128 */     String str1 = paramClass.getName();
/*     */     String str2;
/* 130 */     if ((str2 = str1 + "MethodAccess").startsWith("java.")) str2 = "reflectasm." + str2;
/*     */ 
/*     */     
/*     */     AccessClassLoader accessClassLoader;
/* 134 */     synchronized (accessClassLoader = AccessClassLoader.a(paramClass)) {
/*     */       
/* 136 */       if ((paramClass = accessClassLoader.a(str2)) == null) {
/* 137 */         String str = str2.replace('.', '/');
/* 138 */         str1 = str1.replace('.', '/');
/*     */         
/*     */         ClassWriter classWriter;
/*     */         
/* 142 */         (classWriter = new ClassWriter(1)).visit(50, 33, str, null, "com/prineside/reflectasm/MethodAccess", null);
/*     */         
/*     */         MethodVisitor methodVisitor;
/*     */         
/* 146 */         (methodVisitor = classWriter.visitMethod(1, "<init>", "()V", null, null)).visitCode();
/* 147 */         methodVisitor.visitVarInsn(25, 0);
/* 148 */         methodVisitor.visitMethodInsn(183, "com/prineside/reflectasm/MethodAccess", "<init>", "()V");
/* 149 */         methodVisitor.visitInsn(177);
/* 150 */         methodVisitor.visitMaxs(0, 0);
/* 151 */         methodVisitor.visitEnd();
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 156 */         (methodVisitor = classWriter.visitMethod(129, "invoke", "(Ljava/lang/Object;I[Ljava/lang/Object;)Ljava/lang/Object;", null, null)).visitCode();
/*     */         
/* 158 */         if (!arrayList.isEmpty()) {
/* 159 */           methodVisitor.visitVarInsn(25, 1);
/* 160 */           methodVisitor.visitTypeInsn(192, str1);
/* 161 */           methodVisitor.visitVarInsn(58, 4);
/*     */           
/* 163 */           methodVisitor.visitVarInsn(21, 2);
/* 164 */           Label[] arrayOfLabel = new Label[i];
/* 165 */           for (byte b1 = 0; b1 < i; b1++)
/* 166 */             arrayOfLabel[b1] = new Label(); 
/* 167 */           Label label = new Label();
/* 168 */           methodVisitor.visitTableSwitchInsn(0, i - 1, label, arrayOfLabel);
/*     */           
/* 170 */           StringBuilder stringBuilder = new StringBuilder(128);
/* 171 */           for (byte b2 = 0; b2 < i; b2++) {
/* 172 */             methodVisitor.visitLabel(arrayOfLabel[b2]);
/* 173 */             if (b2 == 0) {
/* 174 */               methodVisitor.visitFrame(1, 1, new Object[] { str1 }, 0, null);
/*     */             } else {
/* 176 */               methodVisitor.visitFrame(3, 0, null, 0, null);
/* 177 */             }  methodVisitor.visitVarInsn(25, 4);
/*     */             
/* 179 */             stringBuilder.setLength(0);
/* 180 */             stringBuilder.append('(');
/*     */             
/* 182 */             Class[] arrayOfClass2 = arrayOfClass[b2];
/* 183 */             Class clazz1 = arrayOfClass1[b2]; char c;
/* 184 */             for (c = Character.MIN_VALUE; c < arrayOfClass2.length; c++) {
/* 185 */               methodVisitor.visitVarInsn(25, 3);
/* 186 */               methodVisitor.visitIntInsn(16, c);
/* 187 */               methodVisitor.visitInsn(50);
/*     */               Type type;
/* 189 */               switch ((type = Type.getType(arrayOfClass2[c])).getSort()) {
/*     */                 case 1:
/* 191 */                   methodVisitor.visitTypeInsn(192, "java/lang/Boolean");
/* 192 */                   methodVisitor.visitMethodInsn(182, "java/lang/Boolean", "booleanValue", "()Z");
/*     */                   break;
/*     */                 case 3:
/* 195 */                   methodVisitor.visitTypeInsn(192, "java/lang/Byte");
/* 196 */                   methodVisitor.visitMethodInsn(182, "java/lang/Byte", "byteValue", "()B");
/*     */                   break;
/*     */                 case 2:
/* 199 */                   methodVisitor.visitTypeInsn(192, "java/lang/Character");
/* 200 */                   methodVisitor.visitMethodInsn(182, "java/lang/Character", "charValue", "()C");
/*     */                   break;
/*     */                 case 4:
/* 203 */                   methodVisitor.visitTypeInsn(192, "java/lang/Short");
/* 204 */                   methodVisitor.visitMethodInsn(182, "java/lang/Short", "shortValue", "()S");
/*     */                   break;
/*     */                 case 5:
/* 207 */                   methodVisitor.visitTypeInsn(192, "java/lang/Integer");
/* 208 */                   methodVisitor.visitMethodInsn(182, "java/lang/Integer", "intValue", "()I");
/*     */                   break;
/*     */                 case 6:
/* 211 */                   methodVisitor.visitTypeInsn(192, "java/lang/Float");
/* 212 */                   methodVisitor.visitMethodInsn(182, "java/lang/Float", "floatValue", "()F");
/*     */                   break;
/*     */                 case 7:
/* 215 */                   methodVisitor.visitTypeInsn(192, "java/lang/Long");
/* 216 */                   methodVisitor.visitMethodInsn(182, "java/lang/Long", "longValue", "()J");
/*     */                   break;
/*     */                 case 8:
/* 219 */                   methodVisitor.visitTypeInsn(192, "java/lang/Double");
/* 220 */                   methodVisitor.visitMethodInsn(182, "java/lang/Double", "doubleValue", "()D");
/*     */                   break;
/*     */                 case 9:
/* 223 */                   methodVisitor.visitTypeInsn(192, type.getDescriptor());
/*     */                   break;
/*     */                 case 10:
/* 226 */                   methodVisitor.visitTypeInsn(192, type.getInternalName());
/*     */                   break;
/*     */               } 
/* 229 */               stringBuilder.append(type.getDescriptor());
/*     */             } 
/*     */             
/* 232 */             stringBuilder.append(')');
/* 233 */             stringBuilder.append(Type.getDescriptor(clazz1));
/*     */             
/* 235 */             if (bool) {
/* 236 */               c = '¹';
/* 237 */             } else if (Modifier.isStatic(((Method)arrayList.get(b2)).getModifiers())) {
/* 238 */               c = '¸';
/*     */             } else {
/* 240 */               c = '¶';
/* 241 */             }  methodVisitor.visitMethodInsn(c, str1, arrayOfString[b2], stringBuilder.toString());
/*     */             
/* 243 */             switch (Type.getType(clazz1).getSort()) {
/*     */               case 0:
/* 245 */                 methodVisitor.visitInsn(1);
/*     */                 break;
/*     */               case 1:
/* 248 */                 methodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
/*     */                 break;
/*     */               case 3:
/* 251 */                 methodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
/*     */                 break;
/*     */               case 2:
/* 254 */                 methodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
/*     */                 break;
/*     */               case 4:
/* 257 */                 methodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
/*     */                 break;
/*     */               case 5:
/* 260 */                 methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
/*     */                 break;
/*     */               case 6:
/* 263 */                 methodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
/*     */                 break;
/*     */               case 7:
/* 266 */                 methodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
/*     */                 break;
/*     */               case 8:
/* 269 */                 methodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
/*     */                 break;
/*     */             } 
/*     */             
/* 273 */             methodVisitor.visitInsn(176);
/*     */           } 
/*     */           
/* 276 */           methodVisitor.visitLabel(label);
/* 277 */           methodVisitor.visitFrame(3, 0, null, 0, null);
/*     */         } 
/* 279 */         methodVisitor.visitTypeInsn(187, "java/lang/IllegalArgumentException");
/* 280 */         methodVisitor.visitInsn(89);
/* 281 */         methodVisitor.visitTypeInsn(187, "java/lang/StringBuilder");
/* 282 */         methodVisitor.visitInsn(89);
/* 283 */         methodVisitor.visitLdcInsn("Method not found: ");
/* 284 */         methodVisitor.visitMethodInsn(183, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
/* 285 */         methodVisitor.visitVarInsn(21, 2);
/* 286 */         methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
/* 287 */         methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
/* 288 */         methodVisitor.visitMethodInsn(183, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
/* 289 */         methodVisitor.visitInsn(191);
/* 290 */         methodVisitor.visitMaxs(0, 0);
/* 291 */         methodVisitor.visitEnd();
/*     */         
/* 293 */         classWriter.visitEnd();
/* 294 */         byte[] arrayOfByte = classWriter.toByteArray();
/* 295 */         Class clazz = accessClassLoader.a(str2, arrayOfByte);
/*     */       } 
/*     */     } 
/*     */     try {
/*     */       MethodAccess methodAccess;
/* 300 */       (methodAccess = (MethodAccess)paramClass.newInstance()).a = arrayOfString;
/* 301 */       methodAccess.b = arrayOfClass;
/* 302 */       methodAccess.c = arrayOfClass1;
/* 303 */       return methodAccess;
/* 304 */     } catch (Throwable throwable) {
/* 305 */       throw new RuntimeException("Error constructing method access class: " + str2, throwable);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void a(Class paramClass, ArrayList<Method> paramArrayList) {
/* 310 */     Method[] arrayOfMethod = paramClass.getDeclaredMethods(); byte b; int i;
/* 311 */     for (b = 0, i = arrayOfMethod.length; b < i; b++) {
/*     */       Method method;
/*     */       
/*     */       int j;
/* 315 */       if (!Modifier.isPrivate(j = (method = arrayOfMethod[b]).getModifiers()))
/* 316 */         paramArrayList.add(method); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void b(Class paramClass, ArrayList<Method> paramArrayList) {
/* 321 */     a(paramClass, paramArrayList); Class[] arrayOfClass; int i; byte b;
/* 322 */     for (i = (arrayOfClass = paramClass.getInterfaces()).length, b = 0; b < i; b++) {
/* 323 */       Class clazz; b(clazz = arrayOfClass[b], paramArrayList);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\reflectasm\MethodAccess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */