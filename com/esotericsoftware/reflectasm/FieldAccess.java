/*     */ package com.esotericsoftware.reflectasm;
/*     */ 
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
/*     */ public abstract class FieldAccess
/*     */ {
/*     */   private String[] fieldNames;
/*     */   private Class[] fieldTypes;
/*     */   private Field[] fields;
/*     */   
/*     */   public int getIndex(String paramString) {
/*     */     byte b;
/*     */     int i;
/*  34 */     for (b = 0, i = this.fieldNames.length; b < i; b++) {
/*  35 */       if (this.fieldNames[b].equals(paramString)) return b; 
/*  36 */     }  throw new IllegalArgumentException("Unable to find non-private field: " + paramString);
/*     */   } public int getIndex(Field paramField) {
/*     */     byte b;
/*     */     int i;
/*  40 */     for (b = 0, i = this.fields.length; b < i; b++) {
/*  41 */       if (this.fields[b].equals(paramField)) return b; 
/*  42 */     }  throw new IllegalArgumentException("Unable to find non-private field: " + paramField);
/*     */   }
/*     */   
/*     */   public void set(Object paramObject1, String paramString, Object paramObject2) {
/*  46 */     set(paramObject1, getIndex(paramString), paramObject2);
/*     */   }
/*     */   
/*     */   public Object get(Object paramObject, String paramString) {
/*  50 */     return get(paramObject, getIndex(paramString));
/*     */   }
/*     */   
/*     */   public String[] getFieldNames() {
/*  54 */     return this.fieldNames;
/*     */   }
/*     */   
/*     */   public Class[] getFieldTypes() {
/*  58 */     return this.fieldTypes;
/*     */   }
/*     */   
/*     */   public int getFieldCount() {
/*  62 */     return this.fieldTypes.length;
/*     */   }
/*     */   
/*     */   public Field[] getFields() {
/*  66 */     return this.fields;
/*     */   }
/*     */   
/*     */   public void setFields(Field[] paramArrayOfField) {
/*  70 */     this.fields = paramArrayOfField;
/*     */   }
/*     */   
/*     */   public abstract void set(Object paramObject1, int paramInt, Object paramObject2);
/*     */   
/*     */   public abstract void setBoolean(Object paramObject, int paramInt, boolean paramBoolean);
/*     */   
/*     */   public abstract void setByte(Object paramObject, int paramInt, byte paramByte);
/*     */   
/*     */   public abstract void setShort(Object paramObject, int paramInt, short paramShort);
/*     */   
/*     */   public abstract void setInt(Object paramObject, int paramInt1, int paramInt2);
/*     */   
/*     */   public abstract void setLong(Object paramObject, int paramInt, long paramLong);
/*     */   
/*     */   public abstract void setDouble(Object paramObject, int paramInt, double paramDouble);
/*     */   
/*     */   public abstract void setFloat(Object paramObject, int paramInt, float paramFloat);
/*     */   
/*     */   public abstract void setChar(Object paramObject, int paramInt, char paramChar);
/*     */   
/*     */   public abstract Object get(Object paramObject, int paramInt);
/*     */   
/*     */   public abstract String getString(Object paramObject, int paramInt);
/*     */   
/*     */   public abstract char getChar(Object paramObject, int paramInt);
/*     */   
/*     */   public abstract boolean getBoolean(Object paramObject, int paramInt);
/*     */   
/*     */   public abstract byte getByte(Object paramObject, int paramInt);
/*     */   
/*     */   public abstract short getShort(Object paramObject, int paramInt);
/*     */   
/*     */   public abstract int getInt(Object paramObject, int paramInt);
/*     */   
/*     */   public abstract long getLong(Object paramObject, int paramInt);
/*     */   
/*     */   public abstract double getDouble(Object paramObject, int paramInt);
/*     */   
/*     */   public abstract float getFloat(Object paramObject, int paramInt);
/*     */   
/*     */   public static FieldAccess get(Class<Object> paramClass) {
/*     */     Class<FieldAccess> clazz1;
/* 113 */     if (paramClass.getSuperclass() == null) {
/* 114 */       throw new IllegalArgumentException("The type must not be the Object class, an interface, a primitive type, or void.");
/*     */     }
/* 116 */     ArrayList<Field> arrayList = new ArrayList();
/* 117 */     Class<Object> clazz = paramClass;
/* 118 */     while (clazz != Object.class) {
/* 119 */       Field[] arrayOfField = clazz.getDeclaredFields(); byte b1; int j;
/* 120 */       for (b1 = 0, j = arrayOfField.length; b1 < j; b1++) {
/*     */         Field field;
/*     */         int k;
/* 123 */         if (!Modifier.isStatic(k = (field = arrayOfField[b1]).getModifiers()) && 
/* 124 */           !Modifier.isPrivate(k))
/* 125 */           arrayList.add(field); 
/*     */       } 
/* 127 */       clazz = (Class)clazz.getSuperclass();
/*     */     } 
/*     */     
/* 130 */     String[] arrayOfString = new String[arrayList.size()];
/* 131 */     Class[] arrayOfClass = new Class[arrayList.size()]; byte b; int i;
/* 132 */     for (b = 0, i = arrayOfString.length; b < i; b++) {
/* 133 */       arrayOfString[b] = ((Field)arrayList.get(b)).getName();
/* 134 */       arrayOfClass[b] = ((Field)arrayList.get(b)).getType();
/*     */     } 
/*     */     
/* 137 */     String str1 = paramClass.getName();
/*     */     String str2;
/* 139 */     if ((str2 = str1 + "FieldAccess").startsWith("java.")) str2 = "reflectasm." + str2;
/*     */ 
/*     */ 
/*     */     
/* 143 */     synchronized (null = AccessClassLoader.get(paramClass)) {
/*     */       
/* 145 */       if ((clazz1 = null.loadAccessClass(str2)) == null) {
/* 146 */         String str = str2.replace('.', '/');
/* 147 */         str1 = str1.replace('.', '/');
/*     */         
/*     */         ClassWriter classWriter;
/* 150 */         (classWriter = new ClassWriter(0)).visit(196653, 33, str, null, "com/esotericsoftware/reflectasm/FieldAccess", null);
/*     */         
/* 152 */         insertConstructor(classWriter);
/* 153 */         insertGetObject(classWriter, str1, arrayList);
/* 154 */         insertSetObject(classWriter, str1, arrayList);
/* 155 */         insertGetPrimitive(classWriter, str1, arrayList, Type.BOOLEAN_TYPE);
/* 156 */         insertSetPrimitive(classWriter, str1, arrayList, Type.BOOLEAN_TYPE);
/* 157 */         insertGetPrimitive(classWriter, str1, arrayList, Type.BYTE_TYPE);
/* 158 */         insertSetPrimitive(classWriter, str1, arrayList, Type.BYTE_TYPE);
/* 159 */         insertGetPrimitive(classWriter, str1, arrayList, Type.SHORT_TYPE);
/* 160 */         insertSetPrimitive(classWriter, str1, arrayList, Type.SHORT_TYPE);
/* 161 */         insertGetPrimitive(classWriter, str1, arrayList, Type.INT_TYPE);
/* 162 */         insertSetPrimitive(classWriter, str1, arrayList, Type.INT_TYPE);
/* 163 */         insertGetPrimitive(classWriter, str1, arrayList, Type.LONG_TYPE);
/* 164 */         insertSetPrimitive(classWriter, str1, arrayList, Type.LONG_TYPE);
/* 165 */         insertGetPrimitive(classWriter, str1, arrayList, Type.DOUBLE_TYPE);
/* 166 */         insertSetPrimitive(classWriter, str1, arrayList, Type.DOUBLE_TYPE);
/* 167 */         insertGetPrimitive(classWriter, str1, arrayList, Type.FLOAT_TYPE);
/* 168 */         insertSetPrimitive(classWriter, str1, arrayList, Type.FLOAT_TYPE);
/* 169 */         insertGetPrimitive(classWriter, str1, arrayList, Type.CHAR_TYPE);
/* 170 */         insertSetPrimitive(classWriter, str1, arrayList, Type.CHAR_TYPE);
/* 171 */         insertGetString(classWriter, str1, arrayList);
/* 172 */         classWriter.visitEnd();
/* 173 */         clazz1 = null.defineAccessClass(str2, classWriter.toByteArray());
/*     */       } 
/*     */     } 
/*     */     try {
/*     */       FieldAccess fieldAccess;
/* 178 */       (fieldAccess = clazz1.newInstance()).fieldNames = arrayOfString;
/* 179 */       fieldAccess.fieldTypes = arrayOfClass;
/* 180 */       fieldAccess.fields = arrayList.<Field>toArray(new Field[arrayList.size()]);
/* 181 */       return fieldAccess;
/* 182 */     } catch (Throwable throwable) {
/* 183 */       throw new RuntimeException("Error constructing field access class: " + str2, throwable);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void insertConstructor(ClassWriter paramClassWriter) {
/*     */     MethodVisitor methodVisitor;
/* 189 */     (methodVisitor = paramClassWriter.visitMethod(1, "<init>", "()V", null, null)).visitCode();
/* 190 */     methodVisitor.visitVarInsn(25, 0);
/* 191 */     methodVisitor.visitMethodInsn(183, "com/esotericsoftware/reflectasm/FieldAccess", "<init>", "()V");
/* 192 */     methodVisitor.visitInsn(177);
/* 193 */     methodVisitor.visitMaxs(1, 1);
/* 194 */     methodVisitor.visitEnd();
/*     */   }
/*     */   
/*     */   private static void insertSetObject(ClassWriter paramClassWriter, String paramString, ArrayList<Field> paramArrayList) {
/* 198 */     byte b = 6;
/*     */     MethodVisitor methodVisitor;
/* 200 */     (methodVisitor = paramClassWriter.visitMethod(1, "set", "(Ljava/lang/Object;ILjava/lang/Object;)V", null, null)).visitCode();
/* 201 */     methodVisitor.visitVarInsn(21, 2);
/*     */     
/* 203 */     if (!paramArrayList.isEmpty()) {
/* 204 */       b--;
/* 205 */       Label[] arrayOfLabel = new Label[paramArrayList.size()]; int i;
/* 206 */       for (byte b1 = 0; b1 < i; b1++)
/* 207 */         arrayOfLabel[b1] = new Label(); 
/* 208 */       Label label = new Label();
/* 209 */       methodVisitor.visitTableSwitchInsn(0, i - 1, label, arrayOfLabel);
/*     */       int j;
/* 211 */       for (i = 0, j = arrayOfLabel.length; i < j; i++) {
/*     */         Field field;
/* 213 */         Type type = Type.getType((field = paramArrayList.get(i)).getType());
/*     */         
/* 215 */         methodVisitor.visitLabel(arrayOfLabel[i]);
/* 216 */         methodVisitor.visitFrame(3, 0, null, 0, null);
/* 217 */         methodVisitor.visitVarInsn(25, 1);
/* 218 */         methodVisitor.visitTypeInsn(192, paramString);
/* 219 */         methodVisitor.visitVarInsn(25, 3);
/*     */         
/* 221 */         switch (type.getSort()) {
/*     */           case 1:
/* 223 */             methodVisitor.visitTypeInsn(192, "java/lang/Boolean");
/* 224 */             methodVisitor.visitMethodInsn(182, "java/lang/Boolean", "booleanValue", "()Z");
/*     */             break;
/*     */           case 3:
/* 227 */             methodVisitor.visitTypeInsn(192, "java/lang/Byte");
/* 228 */             methodVisitor.visitMethodInsn(182, "java/lang/Byte", "byteValue", "()B");
/*     */             break;
/*     */           case 2:
/* 231 */             methodVisitor.visitTypeInsn(192, "java/lang/Character");
/* 232 */             methodVisitor.visitMethodInsn(182, "java/lang/Character", "charValue", "()C");
/*     */             break;
/*     */           case 4:
/* 235 */             methodVisitor.visitTypeInsn(192, "java/lang/Short");
/* 236 */             methodVisitor.visitMethodInsn(182, "java/lang/Short", "shortValue", "()S");
/*     */             break;
/*     */           case 5:
/* 239 */             methodVisitor.visitTypeInsn(192, "java/lang/Integer");
/* 240 */             methodVisitor.visitMethodInsn(182, "java/lang/Integer", "intValue", "()I");
/*     */             break;
/*     */           case 6:
/* 243 */             methodVisitor.visitTypeInsn(192, "java/lang/Float");
/* 244 */             methodVisitor.visitMethodInsn(182, "java/lang/Float", "floatValue", "()F");
/*     */             break;
/*     */           case 7:
/* 247 */             methodVisitor.visitTypeInsn(192, "java/lang/Long");
/* 248 */             methodVisitor.visitMethodInsn(182, "java/lang/Long", "longValue", "()J");
/*     */             break;
/*     */           case 8:
/* 251 */             methodVisitor.visitTypeInsn(192, "java/lang/Double");
/* 252 */             methodVisitor.visitMethodInsn(182, "java/lang/Double", "doubleValue", "()D");
/*     */             break;
/*     */           case 9:
/* 255 */             methodVisitor.visitTypeInsn(192, type.getDescriptor());
/*     */             break;
/*     */           case 10:
/* 258 */             methodVisitor.visitTypeInsn(192, type.getInternalName());
/*     */             break;
/*     */         } 
/*     */         
/* 262 */         methodVisitor.visitFieldInsn(181, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), type
/* 263 */             .getDescriptor());
/* 264 */         methodVisitor.visitInsn(177);
/*     */       } 
/*     */       
/* 267 */       methodVisitor.visitLabel(label);
/* 268 */       methodVisitor.visitFrame(3, 0, null, 0, null);
/*     */     } 
/*     */     
/* 271 */     (methodVisitor = insertThrowExceptionForFieldNotFound(methodVisitor)).visitMaxs(b, 4);
/* 272 */     methodVisitor.visitEnd();
/*     */   }
/*     */   
/*     */   private static void insertGetObject(ClassWriter paramClassWriter, String paramString, ArrayList<Field> paramArrayList) {
/* 276 */     byte b = 6;
/*     */     MethodVisitor methodVisitor;
/* 278 */     (methodVisitor = paramClassWriter.visitMethod(1, "get", "(Ljava/lang/Object;I)Ljava/lang/Object;", null, null)).visitCode();
/* 279 */     methodVisitor.visitVarInsn(21, 2);
/*     */     
/* 281 */     if (!paramArrayList.isEmpty()) {
/* 282 */       b--;
/* 283 */       Label[] arrayOfLabel = new Label[paramArrayList.size()]; int i;
/* 284 */       for (byte b1 = 0; b1 < i; b1++)
/* 285 */         arrayOfLabel[b1] = new Label(); 
/* 286 */       Label label = new Label();
/* 287 */       methodVisitor.visitTableSwitchInsn(0, i - 1, label, arrayOfLabel);
/*     */       int j;
/* 289 */       for (i = 0, j = arrayOfLabel.length; i < j; i++) {
/* 290 */         Field field = paramArrayList.get(i);
/*     */         
/* 292 */         methodVisitor.visitLabel(arrayOfLabel[i]);
/* 293 */         methodVisitor.visitFrame(3, 0, null, 0, null);
/* 294 */         methodVisitor.visitVarInsn(25, 1);
/* 295 */         methodVisitor.visitTypeInsn(192, paramString);
/* 296 */         methodVisitor.visitFieldInsn(180, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), 
/* 297 */             Type.getDescriptor(field.getType()));
/*     */         
/*     */         Type type;
/* 300 */         switch ((type = Type.getType(field.getType())).getSort()) {
/*     */           case 1:
/* 302 */             methodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
/*     */             break;
/*     */           case 3:
/* 305 */             methodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
/*     */             break;
/*     */           case 2:
/* 308 */             methodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
/*     */             break;
/*     */           case 4:
/* 311 */             methodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
/*     */             break;
/*     */           case 5:
/* 314 */             methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
/*     */             break;
/*     */           case 6:
/* 317 */             methodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
/*     */             break;
/*     */           case 7:
/* 320 */             methodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
/*     */             break;
/*     */           case 8:
/* 323 */             methodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
/*     */             break;
/*     */         } 
/*     */         
/* 327 */         methodVisitor.visitInsn(176);
/*     */       } 
/*     */       
/* 330 */       methodVisitor.visitLabel(label);
/* 331 */       methodVisitor.visitFrame(3, 0, null, 0, null);
/*     */     } 
/* 333 */     insertThrowExceptionForFieldNotFound(methodVisitor);
/* 334 */     methodVisitor.visitMaxs(b, 3);
/* 335 */     methodVisitor.visitEnd();
/*     */   }
/*     */   
/*     */   private static void insertGetString(ClassWriter paramClassWriter, String paramString, ArrayList<Field> paramArrayList) {
/* 339 */     byte b = 6;
/*     */     MethodVisitor methodVisitor;
/* 341 */     (methodVisitor = paramClassWriter.visitMethod(1, "getString", "(Ljava/lang/Object;I)Ljava/lang/String;", null, null)).visitCode();
/* 342 */     methodVisitor.visitVarInsn(21, 2);
/*     */     
/* 344 */     if (!paramArrayList.isEmpty()) {
/* 345 */       b--;
/* 346 */       Label[] arrayOfLabel = new Label[paramArrayList.size()];
/* 347 */       Label label1 = new Label();
/* 348 */       boolean bool = false; int i;
/* 349 */       for (byte b1 = 0; b1 < i; b1++) {
/* 350 */         if (((Field)paramArrayList.get(b1)).getType().equals(String.class)) {
/* 351 */           arrayOfLabel[b1] = new Label();
/*     */         } else {
/* 353 */           arrayOfLabel[b1] = label1;
/* 354 */           bool = true;
/*     */         } 
/*     */       } 
/* 357 */       Label label2 = new Label();
/* 358 */       methodVisitor.visitTableSwitchInsn(0, i - 1, label2, arrayOfLabel);
/*     */       int j;
/* 360 */       for (i = 0, j = arrayOfLabel.length; i < j; i++) {
/* 361 */         if (!arrayOfLabel[i].equals(label1)) {
/* 362 */           Field field = paramArrayList.get(i);
/* 363 */           methodVisitor.visitLabel(arrayOfLabel[i]);
/* 364 */           methodVisitor.visitFrame(3, 0, null, 0, null);
/* 365 */           methodVisitor.visitVarInsn(25, 1);
/* 366 */           methodVisitor.visitTypeInsn(192, paramString);
/* 367 */           methodVisitor.visitFieldInsn(180, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), "Ljava/lang/String;");
/*     */           
/* 369 */           methodVisitor.visitInsn(176);
/*     */         } 
/*     */       } 
/*     */       
/* 373 */       if (bool) {
/* 374 */         methodVisitor.visitLabel(label1);
/* 375 */         methodVisitor.visitFrame(3, 0, null, 0, null);
/* 376 */         insertThrowExceptionForFieldType(methodVisitor, "String");
/*     */       } 
/*     */       
/* 379 */       methodVisitor.visitLabel(label2);
/* 380 */       methodVisitor.visitFrame(3, 0, null, 0, null);
/*     */     } 
/* 382 */     insertThrowExceptionForFieldNotFound(methodVisitor);
/* 383 */     methodVisitor.visitMaxs(b, 3);
/* 384 */     methodVisitor.visitEnd();
/*     */   }
/*     */   
/*     */   private static void insertSetPrimitive(ClassWriter paramClassWriter, String paramString, ArrayList<Field> paramArrayList, Type paramType) {
/*     */     String str2;
/* 389 */     byte b3, b1 = 6;
/* 390 */     byte b2 = 4;
/*     */     
/* 392 */     String str1 = paramType.getDescriptor();
/*     */     
/* 394 */     switch (paramType.getSort()) {
/*     */       case 1:
/* 396 */         str2 = "setBoolean";
/* 397 */         b3 = 21;
/*     */         break;
/*     */       case 3:
/* 400 */         str2 = "setByte";
/* 401 */         b3 = 21;
/*     */         break;
/*     */       case 2:
/* 404 */         str2 = "setChar";
/* 405 */         b3 = 21;
/*     */         break;
/*     */       case 4:
/* 408 */         str2 = "setShort";
/* 409 */         b3 = 21;
/*     */         break;
/*     */       case 5:
/* 412 */         str2 = "setInt";
/* 413 */         b3 = 21;
/*     */         break;
/*     */       case 6:
/* 416 */         str2 = "setFloat";
/* 417 */         b3 = 23;
/*     */         break;
/*     */       case 7:
/* 420 */         str2 = "setLong";
/* 421 */         b3 = 22;
/* 422 */         b2++;
/*     */         break;
/*     */       case 8:
/* 425 */         str2 = "setDouble";
/* 426 */         b3 = 24;
/* 427 */         b2++;
/*     */         break;
/*     */       default:
/* 430 */         str2 = "set";
/* 431 */         b3 = 25;
/*     */         break;
/*     */     } 
/*     */     
/*     */     MethodVisitor methodVisitor;
/* 436 */     (methodVisitor = paramClassWriter.visitMethod(1, str2, "(Ljava/lang/Object;I" + str1 + ")V", null, null)).visitCode();
/* 437 */     methodVisitor.visitVarInsn(21, 2);
/*     */     
/* 439 */     if (!paramArrayList.isEmpty()) {
/* 440 */       b1--;
/* 441 */       Label[] arrayOfLabel = new Label[paramArrayList.size()];
/* 442 */       Label label1 = new Label();
/* 443 */       boolean bool = false; int i;
/* 444 */       for (byte b = 0; b < i; b++) {
/* 445 */         if (Type.getType(((Field)paramArrayList.get(b)).getType()).equals(paramType)) {
/* 446 */           arrayOfLabel[b] = new Label();
/*     */         } else {
/* 448 */           arrayOfLabel[b] = label1;
/* 449 */           bool = true;
/*     */         } 
/*     */       } 
/* 452 */       Label label2 = new Label();
/* 453 */       methodVisitor.visitTableSwitchInsn(0, arrayOfLabel.length - 1, label2, arrayOfLabel);
/*     */       int j;
/* 455 */       for (i = 0, j = arrayOfLabel.length; i < j; i++) {
/* 456 */         if (!arrayOfLabel[i].equals(label1)) {
/* 457 */           Field field = paramArrayList.get(i);
/* 458 */           methodVisitor.visitLabel(arrayOfLabel[i]);
/* 459 */           methodVisitor.visitFrame(3, 0, null, 0, null);
/* 460 */           methodVisitor.visitVarInsn(25, 1);
/* 461 */           methodVisitor.visitTypeInsn(192, paramString);
/* 462 */           methodVisitor.visitVarInsn(b3, 3);
/* 463 */           methodVisitor.visitFieldInsn(181, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), str1);
/*     */           
/* 465 */           methodVisitor.visitInsn(177);
/*     */         } 
/*     */       } 
/*     */       
/* 469 */       if (bool) {
/* 470 */         methodVisitor.visitLabel(label1);
/* 471 */         methodVisitor.visitFrame(3, 0, null, 0, null);
/* 472 */         insertThrowExceptionForFieldType(methodVisitor, paramType.getClassName());
/*     */       } 
/*     */       
/* 475 */       methodVisitor.visitLabel(label2);
/* 476 */       methodVisitor.visitFrame(3, 0, null, 0, null);
/*     */     } 
/*     */     
/* 479 */     (methodVisitor = insertThrowExceptionForFieldNotFound(methodVisitor)).visitMaxs(b1, b2);
/* 480 */     methodVisitor.visitEnd();
/*     */   }
/*     */   private static void insertGetPrimitive(ClassWriter paramClassWriter, String paramString, ArrayList<Field> paramArrayList, Type paramType) {
/*     */     String str2;
/*     */     char c;
/* 485 */     byte b = 6;
/*     */     
/* 487 */     String str1 = paramType.getDescriptor();
/*     */     
/* 489 */     switch (paramType.getSort()) {
/*     */       case 1:
/* 491 */         str2 = "getBoolean";
/* 492 */         c = '¬';
/*     */         break;
/*     */       case 3:
/* 495 */         str2 = "getByte";
/* 496 */         c = '¬';
/*     */         break;
/*     */       case 2:
/* 499 */         str2 = "getChar";
/* 500 */         c = '¬';
/*     */         break;
/*     */       case 4:
/* 503 */         str2 = "getShort";
/* 504 */         c = '¬';
/*     */         break;
/*     */       case 5:
/* 507 */         str2 = "getInt";
/* 508 */         c = '¬';
/*     */         break;
/*     */       case 6:
/* 511 */         str2 = "getFloat";
/* 512 */         c = '®';
/*     */         break;
/*     */       case 7:
/* 515 */         str2 = "getLong";
/* 516 */         c = '­';
/*     */         break;
/*     */       case 8:
/* 519 */         str2 = "getDouble";
/* 520 */         c = '¯';
/*     */         break;
/*     */       default:
/* 523 */         str2 = "get";
/* 524 */         c = '°';
/*     */         break;
/*     */     } 
/*     */     MethodVisitor methodVisitor;
/* 528 */     (methodVisitor = paramClassWriter.visitMethod(1, str2, "(Ljava/lang/Object;I)" + str1, null, null)).visitCode();
/* 529 */     methodVisitor.visitVarInsn(21, 2);
/*     */     
/* 531 */     if (!paramArrayList.isEmpty()) {
/* 532 */       b--;
/* 533 */       Label[] arrayOfLabel = new Label[paramArrayList.size()];
/* 534 */       Label label1 = new Label();
/* 535 */       boolean bool = false; int i;
/* 536 */       for (byte b1 = 0; b1 < i; b1++) {
/* 537 */         if (Type.getType(((Field)paramArrayList.get(b1)).getType()).equals(paramType)) {
/* 538 */           arrayOfLabel[b1] = new Label();
/*     */         } else {
/* 540 */           arrayOfLabel[b1] = label1;
/* 541 */           bool = true;
/*     */         } 
/*     */       } 
/* 544 */       Label label2 = new Label();
/* 545 */       methodVisitor.visitTableSwitchInsn(0, arrayOfLabel.length - 1, label2, arrayOfLabel);
/*     */       int j;
/* 547 */       for (i = 0, j = arrayOfLabel.length; i < j; i++) {
/* 548 */         Field field = paramArrayList.get(i);
/* 549 */         if (!arrayOfLabel[i].equals(label1)) {
/* 550 */           methodVisitor.visitLabel(arrayOfLabel[i]);
/* 551 */           methodVisitor.visitFrame(3, 0, null, 0, null);
/* 552 */           methodVisitor.visitVarInsn(25, 1);
/* 553 */           methodVisitor.visitTypeInsn(192, paramString);
/* 554 */           methodVisitor.visitFieldInsn(180, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), str1);
/*     */           
/* 556 */           methodVisitor.visitInsn(c);
/*     */         } 
/*     */       } 
/*     */       
/* 560 */       if (bool) {
/* 561 */         methodVisitor.visitLabel(label1);
/* 562 */         methodVisitor.visitFrame(3, 0, null, 0, null);
/* 563 */         insertThrowExceptionForFieldType(methodVisitor, paramType.getClassName());
/*     */       } 
/*     */       
/* 566 */       methodVisitor.visitLabel(label2);
/* 567 */       methodVisitor.visitFrame(3, 0, null, 0, null);
/*     */     } 
/*     */     
/* 570 */     (methodVisitor = insertThrowExceptionForFieldNotFound(methodVisitor)).visitMaxs(b, 3);
/* 571 */     methodVisitor.visitEnd();
/*     */   }
/*     */   
/*     */   private static MethodVisitor insertThrowExceptionForFieldNotFound(MethodVisitor paramMethodVisitor) {
/* 575 */     paramMethodVisitor.visitTypeInsn(187, "java/lang/IllegalArgumentException");
/* 576 */     paramMethodVisitor.visitInsn(89);
/* 577 */     paramMethodVisitor.visitTypeInsn(187, "java/lang/StringBuilder");
/* 578 */     paramMethodVisitor.visitInsn(89);
/* 579 */     paramMethodVisitor.visitLdcInsn("Field not found: ");
/* 580 */     paramMethodVisitor.visitMethodInsn(183, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
/* 581 */     paramMethodVisitor.visitVarInsn(21, 2);
/* 582 */     paramMethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
/* 583 */     paramMethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
/* 584 */     paramMethodVisitor.visitMethodInsn(183, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
/* 585 */     paramMethodVisitor.visitInsn(191);
/* 586 */     return paramMethodVisitor;
/*     */   }
/*     */   
/*     */   private static MethodVisitor insertThrowExceptionForFieldType(MethodVisitor paramMethodVisitor, String paramString) {
/* 590 */     paramMethodVisitor.visitTypeInsn(187, "java/lang/IllegalArgumentException");
/* 591 */     paramMethodVisitor.visitInsn(89);
/* 592 */     paramMethodVisitor.visitTypeInsn(187, "java/lang/StringBuilder");
/* 593 */     paramMethodVisitor.visitInsn(89);
/* 594 */     paramMethodVisitor.visitLdcInsn("Field not declared as " + paramString + ": ");
/* 595 */     paramMethodVisitor.visitMethodInsn(183, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
/* 596 */     paramMethodVisitor.visitVarInsn(21, 2);
/* 597 */     paramMethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
/* 598 */     paramMethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
/* 599 */     paramMethodVisitor.visitMethodInsn(183, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
/* 600 */     paramMethodVisitor.visitInsn(191);
/* 601 */     return paramMethodVisitor;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\reflectasm\FieldAccess.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */