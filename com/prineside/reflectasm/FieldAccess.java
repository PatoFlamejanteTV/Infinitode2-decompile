/*     */ package com.prineside.reflectasm;
/*     */ 
/*     */ import com.badlogic.gdx.utils.IdentityMap;
/*     */ import com.esotericsoftware.asm.ClassWriter;
/*     */ import com.esotericsoftware.asm.Label;
/*     */ import com.esotericsoftware.asm.MethodVisitor;
/*     */ import com.esotericsoftware.asm.Type;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
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
/*     */ public abstract class FieldAccess
/*     */ {
/*     */   private String[] a;
/*     */   private Class[] b;
/*     */   private Field[] c;
/*     */   
/*     */   public int getIndex(String paramString) {
/*     */     byte b;
/*     */     int i;
/*  59 */     for (b = 0, i = this.a.length; b < i; b++) {
/*  60 */       if (this.a[b].equals(paramString)) return b; 
/*  61 */     }  throw new IllegalArgumentException("Unable to find non-private field: " + paramString);
/*     */   } public int getIndex(Field paramField) {
/*     */     byte b;
/*     */     int i;
/*  65 */     for (b = 0, i = this.c.length; b < i; b++) {
/*  66 */       if (this.c[b].equals(paramField)) return b; 
/*  67 */     }  throw new IllegalArgumentException("Unable to find non-private field: " + paramField);
/*     */   }
/*     */   
/*     */   public void set(Object paramObject1, String paramString, Object paramObject2) {
/*  71 */     set(paramObject1, getIndex(paramString), paramObject2);
/*     */   }
/*     */   
/*     */   public Object get(Object paramObject, String paramString) {
/*  75 */     return get(paramObject, getIndex(paramString));
/*     */   }
/*     */   
/*     */   public String[] getFieldNames() {
/*  79 */     return this.a;
/*     */   }
/*     */   
/*     */   public Class[] getFieldTypes() {
/*  83 */     return this.b;
/*     */   }
/*     */   
/*     */   public int getFieldCount() {
/*  87 */     return this.b.length;
/*     */   }
/*     */   
/*     */   public Field[] getFields() {
/*  91 */     return this.c;
/*     */   }
/*     */   
/*     */   public void setFields(Field[] paramArrayOfField) {
/*  95 */     this.c = paramArrayOfField;
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
/* 136 */   private static final IdentityMap<Class<?>, FieldAccess> d = new IdentityMap(); public abstract void set(Object paramObject1, int paramInt, Object paramObject2); public abstract void setBoolean(Object paramObject, int paramInt, boolean paramBoolean); public abstract void setByte(Object paramObject, int paramInt, byte paramByte); public abstract void setShort(Object paramObject, int paramInt, short paramShort); public abstract void setInt(Object paramObject, int paramInt1, int paramInt2); public abstract void setLong(Object paramObject, int paramInt, long paramLong); public abstract void setDouble(Object paramObject, int paramInt, double paramDouble); public abstract void setFloat(Object paramObject, int paramInt, float paramFloat);
/*     */   public abstract void setChar(Object paramObject, int paramInt, char paramChar);
/*     */   public static FieldAccess get(Class<Object> paramClass) {
/*     */     Class<FieldAccess> clazz1;
/*     */     FieldAccess fieldAccess;
/* 141 */     if ((fieldAccess = (FieldAccess)d.get(paramClass)) != null) {
/* 142 */       return fieldAccess;
/*     */     }
/*     */     
/* 145 */     if (paramClass.getSuperclass() == null) {
/* 146 */       throw new IllegalArgumentException("The type must not be the Object class, an interface, a primitive type, or void.");
/*     */     }
/* 148 */     ArrayList<Field> arrayList = new ArrayList();
/* 149 */     Class<Object> clazz = paramClass;
/* 150 */     while (clazz != Object.class) {
/* 151 */       Field[] arrayOfField = clazz.getDeclaredFields(); byte b1; int j;
/* 152 */       for (b1 = 0, j = arrayOfField.length; b1 < j; b1++) {
/*     */         Field field;
/*     */         int k;
/* 155 */         if (!Modifier.isStatic(k = (field = arrayOfField[b1]).getModifiers()) && 
/* 156 */           !Modifier.isPrivate(k))
/* 157 */           arrayList.add(field); 
/*     */       } 
/* 159 */       clazz = (Class)clazz.getSuperclass();
/*     */     } 
/*     */     
/* 162 */     String[] arrayOfString = new String[arrayList.size()];
/* 163 */     Class[] arrayOfClass = new Class[arrayList.size()]; byte b; int i;
/* 164 */     for (b = 0, i = arrayOfString.length; b < i; b++) {
/* 165 */       arrayOfString[b] = ((Field)arrayList.get(b)).getName();
/* 166 */       arrayOfClass[b] = ((Field)arrayList.get(b)).getType();
/*     */     } 
/*     */     
/* 169 */     String str1 = paramClass.getName();
/*     */     String str2;
/* 171 */     if ((str2 = str1 + "FieldAccess").startsWith("java.")) str2 = "reflectasm." + str2;
/*     */ 
/*     */     
/*     */     AccessClassLoader accessClassLoader;
/* 175 */     synchronized (accessClassLoader = AccessClassLoader.a(paramClass)) {
/*     */       
/* 177 */       if ((clazz1 = accessClassLoader.a(str2)) == null) {
/* 178 */         String str = str2.replace('.', '/');
/* 179 */         str1 = str1.replace('.', '/');
/*     */         
/*     */         ClassWriter classWriter;
/* 182 */         (classWriter = new ClassWriter(0)).visit(50, 4129, str, null, "com/prineside/reflectasm/FieldAccess", null);
/*     */         
/* 184 */         a(classWriter);
/* 185 */         b(classWriter, str1, arrayList);
/* 186 */         a(classWriter, str1, arrayList);
/* 187 */         b(classWriter, str1, arrayList, Type.BOOLEAN_TYPE);
/* 188 */         a(classWriter, str1, arrayList, Type.BOOLEAN_TYPE);
/* 189 */         b(classWriter, str1, arrayList, Type.BYTE_TYPE);
/* 190 */         a(classWriter, str1, arrayList, Type.BYTE_TYPE);
/* 191 */         b(classWriter, str1, arrayList, Type.SHORT_TYPE);
/* 192 */         a(classWriter, str1, arrayList, Type.SHORT_TYPE);
/* 193 */         b(classWriter, str1, arrayList, Type.INT_TYPE);
/* 194 */         a(classWriter, str1, arrayList, Type.INT_TYPE);
/* 195 */         b(classWriter, str1, arrayList, Type.LONG_TYPE);
/* 196 */         a(classWriter, str1, arrayList, Type.LONG_TYPE);
/* 197 */         b(classWriter, str1, arrayList, Type.DOUBLE_TYPE);
/* 198 */         a(classWriter, str1, arrayList, Type.DOUBLE_TYPE);
/* 199 */         b(classWriter, str1, arrayList, Type.FLOAT_TYPE);
/* 200 */         a(classWriter, str1, arrayList, Type.FLOAT_TYPE);
/* 201 */         b(classWriter, str1, arrayList, Type.CHAR_TYPE);
/* 202 */         a(classWriter, str1, arrayList, Type.CHAR_TYPE);
/* 203 */         c(classWriter, str1, arrayList);
/* 204 */         classWriter.visitEnd();
/* 205 */         clazz1 = accessClassLoader.a(str2, classWriter.toByteArray());
/*     */       } 
/*     */     } 
/*     */     try {
/*     */       FieldAccess fieldAccess1;
/* 210 */       (fieldAccess1 = clazz1.newInstance()).a = arrayOfString;
/* 211 */       fieldAccess1.b = arrayOfClass;
/* 212 */       fieldAccess1.c = arrayList.<Field>toArray(new Field[arrayList.size()]);
/* 213 */       d.put(paramClass, fieldAccess1);
/* 214 */       return fieldAccess1;
/* 215 */     } catch (Throwable throwable) {
/* 216 */       throw new RuntimeException("Error constructing field access class: " + str2, throwable);
/*     */     } 
/*     */   } public abstract Object get(Object paramObject, int paramInt); public abstract String getString(Object paramObject, int paramInt); public abstract char getChar(Object paramObject, int paramInt); public abstract boolean getBoolean(Object paramObject, int paramInt); public abstract byte getByte(Object paramObject, int paramInt); public abstract short getShort(Object paramObject, int paramInt); public abstract int getInt(Object paramObject, int paramInt); public abstract long getLong(Object paramObject, int paramInt); public abstract double getDouble(Object paramObject, int paramInt);
/*     */   public abstract float getFloat(Object paramObject, int paramInt);
/*     */   private static void a(ClassWriter paramClassWriter) {
/*     */     MethodVisitor methodVisitor;
/* 222 */     (methodVisitor = paramClassWriter.visitMethod(1, "<init>", "()V", null, null)).visitCode();
/* 223 */     methodVisitor.visitVarInsn(25, 0);
/* 224 */     methodVisitor.visitMethodInsn(183, "com/prineside/reflectasm/FieldAccess", "<init>", "()V");
/* 225 */     methodVisitor.visitInsn(177);
/* 226 */     methodVisitor.visitMaxs(1, 1);
/* 227 */     methodVisitor.visitEnd();
/*     */   }
/*     */   
/*     */   private static void a(ClassWriter paramClassWriter, String paramString, ArrayList<Field> paramArrayList) {
/* 231 */     byte b = 6;
/*     */     MethodVisitor methodVisitor;
/* 233 */     (methodVisitor = paramClassWriter.visitMethod(1, "set", "(Ljava/lang/Object;ILjava/lang/Object;)V", null, null)).visitCode();
/* 234 */     methodVisitor.visitVarInsn(21, 2);
/*     */     
/* 236 */     if (!paramArrayList.isEmpty()) {
/* 237 */       b--;
/* 238 */       Label[] arrayOfLabel = new Label[paramArrayList.size()]; int i;
/* 239 */       for (byte b1 = 0; b1 < i; b1++)
/* 240 */         arrayOfLabel[b1] = new Label(); 
/* 241 */       Label label = new Label();
/* 242 */       methodVisitor.visitTableSwitchInsn(0, i - 1, label, arrayOfLabel);
/*     */       int j;
/* 244 */       for (i = 0, j = arrayOfLabel.length; i < j; i++) {
/*     */         Field field;
/* 246 */         Type type = Type.getType((field = paramArrayList.get(i)).getType());
/*     */         
/* 248 */         methodVisitor.visitLabel(arrayOfLabel[i]);
/* 249 */         methodVisitor.visitFrame(3, 0, null, 0, null);
/* 250 */         methodVisitor.visitVarInsn(25, 1);
/* 251 */         methodVisitor.visitTypeInsn(192, paramString);
/* 252 */         methodVisitor.visitVarInsn(25, 3);
/*     */         
/* 254 */         switch (type.getSort()) {
/*     */           case 1:
/* 256 */             methodVisitor.visitTypeInsn(192, "java/lang/Boolean");
/* 257 */             methodVisitor.visitMethodInsn(182, "java/lang/Boolean", "booleanValue", "()Z");
/*     */             break;
/*     */           case 3:
/* 260 */             methodVisitor.visitTypeInsn(192, "java/lang/Byte");
/* 261 */             methodVisitor.visitMethodInsn(182, "java/lang/Byte", "byteValue", "()B");
/*     */             break;
/*     */           case 2:
/* 264 */             methodVisitor.visitTypeInsn(192, "java/lang/Character");
/* 265 */             methodVisitor.visitMethodInsn(182, "java/lang/Character", "charValue", "()C");
/*     */             break;
/*     */           case 4:
/* 268 */             methodVisitor.visitTypeInsn(192, "java/lang/Short");
/* 269 */             methodVisitor.visitMethodInsn(182, "java/lang/Short", "shortValue", "()S");
/*     */             break;
/*     */           case 5:
/* 272 */             methodVisitor.visitTypeInsn(192, "java/lang/Integer");
/* 273 */             methodVisitor.visitMethodInsn(182, "java/lang/Integer", "intValue", "()I");
/*     */             break;
/*     */           case 6:
/* 276 */             methodVisitor.visitTypeInsn(192, "java/lang/Float");
/* 277 */             methodVisitor.visitMethodInsn(182, "java/lang/Float", "floatValue", "()F");
/*     */             break;
/*     */           case 7:
/* 280 */             methodVisitor.visitTypeInsn(192, "java/lang/Long");
/* 281 */             methodVisitor.visitMethodInsn(182, "java/lang/Long", "longValue", "()J");
/*     */             break;
/*     */           case 8:
/* 284 */             methodVisitor.visitTypeInsn(192, "java/lang/Double");
/* 285 */             methodVisitor.visitMethodInsn(182, "java/lang/Double", "doubleValue", "()D");
/*     */             break;
/*     */           case 9:
/* 288 */             methodVisitor.visitTypeInsn(192, type.getDescriptor());
/*     */             break;
/*     */           case 10:
/* 291 */             methodVisitor.visitTypeInsn(192, type.getInternalName());
/*     */             break;
/*     */         } 
/*     */         
/* 295 */         methodVisitor.visitFieldInsn(181, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), type
/* 296 */             .getDescriptor());
/* 297 */         methodVisitor.visitInsn(177);
/*     */       } 
/*     */       
/* 300 */       methodVisitor.visitLabel(label);
/* 301 */       methodVisitor.visitFrame(3, 0, null, 0, null);
/*     */     } 
/*     */     
/* 304 */     (methodVisitor = a(methodVisitor)).visitMaxs(b, 4);
/* 305 */     methodVisitor.visitEnd();
/*     */   }
/*     */   
/*     */   private static void b(ClassWriter paramClassWriter, String paramString, ArrayList<Field> paramArrayList) {
/* 309 */     byte b = 6;
/*     */     MethodVisitor methodVisitor;
/* 311 */     (methodVisitor = paramClassWriter.visitMethod(1, "get", "(Ljava/lang/Object;I)Ljava/lang/Object;", null, null)).visitCode();
/* 312 */     methodVisitor.visitVarInsn(21, 2);
/*     */     
/* 314 */     if (!paramArrayList.isEmpty()) {
/* 315 */       b--;
/* 316 */       Label[] arrayOfLabel = new Label[paramArrayList.size()]; int i;
/* 317 */       for (byte b1 = 0; b1 < i; b1++)
/* 318 */         arrayOfLabel[b1] = new Label(); 
/* 319 */       Label label = new Label();
/* 320 */       methodVisitor.visitTableSwitchInsn(0, i - 1, label, arrayOfLabel);
/*     */       int j;
/* 322 */       for (i = 0, j = arrayOfLabel.length; i < j; i++) {
/* 323 */         Field field = paramArrayList.get(i);
/*     */         
/* 325 */         methodVisitor.visitLabel(arrayOfLabel[i]);
/* 326 */         methodVisitor.visitFrame(3, 0, null, 0, null);
/* 327 */         methodVisitor.visitVarInsn(25, 1);
/* 328 */         methodVisitor.visitTypeInsn(192, paramString);
/* 329 */         methodVisitor.visitFieldInsn(180, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), 
/* 330 */             Type.getDescriptor(field.getType()));
/*     */         
/*     */         Type type;
/* 333 */         switch ((type = Type.getType(field.getType())).getSort()) {
/*     */           case 1:
/* 335 */             methodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
/*     */             break;
/*     */           case 3:
/* 338 */             methodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
/*     */             break;
/*     */           case 2:
/* 341 */             methodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
/*     */             break;
/*     */           case 4:
/* 344 */             methodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
/*     */             break;
/*     */           case 5:
/* 347 */             methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
/*     */             break;
/*     */           case 6:
/* 350 */             methodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
/*     */             break;
/*     */           case 7:
/* 353 */             methodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
/*     */             break;
/*     */           case 8:
/* 356 */             methodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
/*     */             break;
/*     */         } 
/*     */         
/* 360 */         methodVisitor.visitInsn(176);
/*     */       } 
/*     */       
/* 363 */       methodVisitor.visitLabel(label);
/* 364 */       methodVisitor.visitFrame(3, 0, null, 0, null);
/*     */     } 
/* 366 */     a(methodVisitor);
/* 367 */     methodVisitor.visitMaxs(b, 3);
/* 368 */     methodVisitor.visitEnd();
/*     */   }
/*     */   
/*     */   private static void c(ClassWriter paramClassWriter, String paramString, ArrayList<Field> paramArrayList) {
/* 372 */     byte b = 6;
/*     */     MethodVisitor methodVisitor;
/* 374 */     (methodVisitor = paramClassWriter.visitMethod(1, "getString", "(Ljava/lang/Object;I)Ljava/lang/String;", null, null)).visitCode();
/* 375 */     methodVisitor.visitVarInsn(21, 2);
/*     */     
/* 377 */     if (!paramArrayList.isEmpty()) {
/* 378 */       b--;
/* 379 */       Label[] arrayOfLabel = new Label[paramArrayList.size()];
/* 380 */       Label label1 = new Label();
/* 381 */       boolean bool = false; int i;
/* 382 */       for (byte b1 = 0; b1 < i; b1++) {
/* 383 */         if (((Field)paramArrayList.get(b1)).getType().equals(String.class)) {
/* 384 */           arrayOfLabel[b1] = new Label();
/*     */         } else {
/* 386 */           arrayOfLabel[b1] = label1;
/* 387 */           bool = true;
/*     */         } 
/*     */       } 
/* 390 */       Label label2 = new Label();
/* 391 */       methodVisitor.visitTableSwitchInsn(0, i - 1, label2, arrayOfLabel);
/*     */       int j;
/* 393 */       for (i = 0, j = arrayOfLabel.length; i < j; i++) {
/* 394 */         if (!arrayOfLabel[i].equals(label1)) {
/* 395 */           Field field = paramArrayList.get(i);
/* 396 */           methodVisitor.visitLabel(arrayOfLabel[i]);
/* 397 */           methodVisitor.visitFrame(3, 0, null, 0, null);
/* 398 */           methodVisitor.visitVarInsn(25, 1);
/* 399 */           methodVisitor.visitTypeInsn(192, paramString);
/* 400 */           methodVisitor.visitFieldInsn(180, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), "Ljava/lang/String;");
/*     */           
/* 402 */           methodVisitor.visitInsn(176);
/*     */         } 
/*     */       } 
/*     */       
/* 406 */       if (bool) {
/* 407 */         methodVisitor.visitLabel(label1);
/* 408 */         methodVisitor.visitFrame(3, 0, null, 0, null);
/* 409 */         a(methodVisitor, "String");
/*     */       } 
/*     */       
/* 412 */       methodVisitor.visitLabel(label2);
/* 413 */       methodVisitor.visitFrame(3, 0, null, 0, null);
/*     */     } 
/* 415 */     a(methodVisitor);
/* 416 */     methodVisitor.visitMaxs(b, 3);
/* 417 */     methodVisitor.visitEnd();
/*     */   }
/*     */   
/*     */   private static void a(ClassWriter paramClassWriter, String paramString, ArrayList<Field> paramArrayList, Type paramType) {
/*     */     String str1;
/* 422 */     byte b3, b1 = 6;
/* 423 */     byte b2 = 4;
/*     */     
/* 425 */     String str2 = paramType.getDescriptor();
/*     */     
/* 427 */     switch (paramType.getSort()) {
/*     */       case 1:
/* 429 */         str1 = "setBoolean";
/* 430 */         b3 = 21;
/*     */         break;
/*     */       case 3:
/* 433 */         str1 = "setByte";
/* 434 */         b3 = 21;
/*     */         break;
/*     */       case 2:
/* 437 */         str1 = "setChar";
/* 438 */         b3 = 21;
/*     */         break;
/*     */       case 4:
/* 441 */         str1 = "setShort";
/* 442 */         b3 = 21;
/*     */         break;
/*     */       case 5:
/* 445 */         str1 = "setInt";
/* 446 */         b3 = 21;
/*     */         break;
/*     */       case 6:
/* 449 */         str1 = "setFloat";
/* 450 */         b3 = 23;
/*     */         break;
/*     */       case 7:
/* 453 */         str1 = "setLong";
/* 454 */         b3 = 22;
/* 455 */         b2++;
/*     */         break;
/*     */       case 8:
/* 458 */         str1 = "setDouble";
/* 459 */         b3 = 24;
/* 460 */         b2++;
/*     */         break;
/*     */       default:
/* 463 */         str1 = "set";
/* 464 */         b3 = 25;
/*     */         break;
/*     */     } 
/*     */     
/*     */     MethodVisitor methodVisitor;
/* 469 */     (methodVisitor = paramClassWriter.visitMethod(1, str1, "(Ljava/lang/Object;I" + str2 + ")V", null, null)).visitCode();
/* 470 */     methodVisitor.visitVarInsn(21, 2);
/*     */     
/* 472 */     if (!paramArrayList.isEmpty()) {
/* 473 */       b1--;
/* 474 */       Label[] arrayOfLabel = new Label[paramArrayList.size()];
/* 475 */       Label label1 = new Label();
/* 476 */       boolean bool = false; int i;
/* 477 */       for (byte b = 0; b < i; b++) {
/* 478 */         if (Type.getType(((Field)paramArrayList.get(b)).getType()).equals(paramType)) {
/* 479 */           arrayOfLabel[b] = new Label();
/*     */         } else {
/* 481 */           arrayOfLabel[b] = label1;
/* 482 */           bool = true;
/*     */         } 
/*     */       } 
/* 485 */       Label label2 = new Label();
/* 486 */       methodVisitor.visitTableSwitchInsn(0, arrayOfLabel.length - 1, label2, arrayOfLabel);
/*     */       int j;
/* 488 */       for (i = 0, j = arrayOfLabel.length; i < j; i++) {
/* 489 */         if (!arrayOfLabel[i].equals(label1)) {
/* 490 */           Field field = paramArrayList.get(i);
/* 491 */           methodVisitor.visitLabel(arrayOfLabel[i]);
/* 492 */           methodVisitor.visitFrame(3, 0, null, 0, null);
/* 493 */           methodVisitor.visitVarInsn(25, 1);
/* 494 */           methodVisitor.visitTypeInsn(192, paramString);
/* 495 */           methodVisitor.visitVarInsn(b3, 3);
/* 496 */           methodVisitor.visitFieldInsn(181, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), str2);
/*     */           
/* 498 */           methodVisitor.visitInsn(177);
/*     */         } 
/*     */       } 
/*     */       
/* 502 */       if (bool) {
/* 503 */         methodVisitor.visitLabel(label1);
/* 504 */         methodVisitor.visitFrame(3, 0, null, 0, null);
/* 505 */         a(methodVisitor, paramType.getClassName());
/*     */       } 
/*     */       
/* 508 */       methodVisitor.visitLabel(label2);
/* 509 */       methodVisitor.visitFrame(3, 0, null, 0, null);
/*     */     } 
/*     */     
/* 512 */     (methodVisitor = a(methodVisitor)).visitMaxs(b1, b2);
/* 513 */     methodVisitor.visitEnd();
/*     */   }
/*     */   private static void b(ClassWriter paramClassWriter, String paramString, ArrayList<Field> paramArrayList, Type paramType) {
/*     */     String str1;
/*     */     char c;
/* 518 */     byte b = 6;
/*     */     
/* 520 */     String str2 = paramType.getDescriptor();
/*     */     
/* 522 */     switch (paramType.getSort()) {
/*     */       case 1:
/* 524 */         str1 = "getBoolean";
/* 525 */         c = '¬';
/*     */         break;
/*     */       case 3:
/* 528 */         str1 = "getByte";
/* 529 */         c = '¬';
/*     */         break;
/*     */       case 2:
/* 532 */         str1 = "getChar";
/* 533 */         c = '¬';
/*     */         break;
/*     */       case 4:
/* 536 */         str1 = "getShort";
/* 537 */         c = '¬';
/*     */         break;
/*     */       case 5:
/* 540 */         str1 = "getInt";
/* 541 */         c = '¬';
/*     */         break;
/*     */       case 6:
/* 544 */         str1 = "getFloat";
/* 545 */         c = '®';
/*     */         break;
/*     */       case 7:
/* 548 */         str1 = "getLong";
/* 549 */         c = '­';
/*     */         break;
/*     */       case 8:
/* 552 */         str1 = "getDouble";
/* 553 */         c = '¯';
/*     */         break;
/*     */       default:
/* 556 */         str1 = "get";
/* 557 */         c = '°';
/*     */         break;
/*     */     } 
/*     */     MethodVisitor methodVisitor;
/* 561 */     (methodVisitor = paramClassWriter.visitMethod(1, str1, "(Ljava/lang/Object;I)" + str2, null, null)).visitCode();
/* 562 */     methodVisitor.visitVarInsn(21, 2);
/*     */     
/* 564 */     if (!paramArrayList.isEmpty()) {
/* 565 */       b--;
/* 566 */       Label[] arrayOfLabel = new Label[paramArrayList.size()];
/* 567 */       Label label1 = new Label();
/* 568 */       boolean bool = false; int i;
/* 569 */       for (byte b1 = 0; b1 < i; b1++) {
/* 570 */         if (Type.getType(((Field)paramArrayList.get(b1)).getType()).equals(paramType)) {
/* 571 */           arrayOfLabel[b1] = new Label();
/*     */         } else {
/* 573 */           arrayOfLabel[b1] = label1;
/* 574 */           bool = true;
/*     */         } 
/*     */       } 
/* 577 */       Label label2 = new Label();
/* 578 */       methodVisitor.visitTableSwitchInsn(0, arrayOfLabel.length - 1, label2, arrayOfLabel);
/*     */       int j;
/* 580 */       for (i = 0, j = arrayOfLabel.length; i < j; i++) {
/* 581 */         Field field = paramArrayList.get(i);
/* 582 */         if (!arrayOfLabel[i].equals(label1)) {
/* 583 */           methodVisitor.visitLabel(arrayOfLabel[i]);
/* 584 */           methodVisitor.visitFrame(3, 0, null, 0, null);
/* 585 */           methodVisitor.visitVarInsn(25, 1);
/* 586 */           methodVisitor.visitTypeInsn(192, paramString);
/* 587 */           methodVisitor.visitFieldInsn(180, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), str2);
/*     */           
/* 589 */           methodVisitor.visitInsn(c);
/*     */         } 
/*     */       } 
/*     */       
/* 593 */       if (bool) {
/* 594 */         methodVisitor.visitLabel(label1);
/* 595 */         methodVisitor.visitFrame(3, 0, null, 0, null);
/* 596 */         a(methodVisitor, paramType.getClassName());
/*     */       } 
/*     */       
/* 599 */       methodVisitor.visitLabel(label2);
/* 600 */       methodVisitor.visitFrame(3, 0, null, 0, null);
/*     */     } 
/*     */     
/* 603 */     (methodVisitor = a(methodVisitor)).visitMaxs(b, 3);
/* 604 */     methodVisitor.visitEnd();
/*     */   }
/*     */   
/*     */   private static MethodVisitor a(MethodVisitor paramMethodVisitor) {
/* 608 */     paramMethodVisitor.visitTypeInsn(187, "java/lang/IllegalArgumentException");
/* 609 */     paramMethodVisitor.visitInsn(89);
/* 610 */     paramMethodVisitor.visitTypeInsn(187, "java/lang/StringBuilder");
/* 611 */     paramMethodVisitor.visitInsn(89);
/* 612 */     paramMethodVisitor.visitLdcInsn("Field not found: ");
/* 613 */     paramMethodVisitor.visitMethodInsn(183, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
/* 614 */     paramMethodVisitor.visitVarInsn(21, 2);
/* 615 */     paramMethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
/* 616 */     paramMethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
/* 617 */     paramMethodVisitor.visitMethodInsn(183, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
/* 618 */     paramMethodVisitor.visitInsn(191);
/* 619 */     return paramMethodVisitor;
/*     */   }
/*     */   
/*     */   private static MethodVisitor a(MethodVisitor paramMethodVisitor, String paramString) {
/* 623 */     paramMethodVisitor.visitTypeInsn(187, "java/lang/IllegalArgumentException");
/* 624 */     paramMethodVisitor.visitInsn(89);
/* 625 */     paramMethodVisitor.visitTypeInsn(187, "java/lang/StringBuilder");
/* 626 */     paramMethodVisitor.visitInsn(89);
/* 627 */     paramMethodVisitor.visitLdcInsn("Field not declared as " + paramString + ": ");
/* 628 */     paramMethodVisitor.visitMethodInsn(183, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
/* 629 */     paramMethodVisitor.visitVarInsn(21, 2);
/* 630 */     paramMethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
/* 631 */     paramMethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
/* 632 */     paramMethodVisitor.visitMethodInsn(183, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
/* 633 */     paramMethodVisitor.visitInsn(191);
/* 634 */     return paramMethodVisitor;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\reflectasm\FieldAccess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */