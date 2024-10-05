/*     */ package net.bytebuddy.jar.asm;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
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
/*     */ public final class Type
/*     */ {
/*     */   public static final int VOID = 0;
/*     */   public static final int BOOLEAN = 1;
/*     */   public static final int CHAR = 2;
/*     */   public static final int BYTE = 3;
/*     */   public static final int SHORT = 4;
/*     */   public static final int INT = 5;
/*     */   public static final int FLOAT = 6;
/*     */   public static final int LONG = 7;
/*     */   public static final int DOUBLE = 8;
/*     */   public static final int ARRAY = 9;
/*     */   public static final int OBJECT = 10;
/*     */   public static final int METHOD = 11;
/*     */   private static final int INTERNAL = 12;
/*     */   private static final String PRIMITIVE_DESCRIPTORS = "VZCBSIFJD";
/*  85 */   public static final Type VOID_TYPE = new Type(0, "VZCBSIFJD", 0, 1);
/*     */ 
/*     */   
/*  88 */   public static final Type BOOLEAN_TYPE = new Type(1, "VZCBSIFJD", 1, 2);
/*     */ 
/*     */ 
/*     */   
/*  92 */   public static final Type CHAR_TYPE = new Type(2, "VZCBSIFJD", 2, 3);
/*     */ 
/*     */   
/*  95 */   public static final Type BYTE_TYPE = new Type(3, "VZCBSIFJD", 3, 4);
/*     */ 
/*     */   
/*  98 */   public static final Type SHORT_TYPE = new Type(4, "VZCBSIFJD", 4, 5);
/*     */ 
/*     */   
/* 101 */   public static final Type INT_TYPE = new Type(5, "VZCBSIFJD", 5, 6);
/*     */ 
/*     */   
/* 104 */   public static final Type FLOAT_TYPE = new Type(6, "VZCBSIFJD", 6, 7);
/*     */ 
/*     */   
/* 107 */   public static final Type LONG_TYPE = new Type(7, "VZCBSIFJD", 7, 8);
/*     */ 
/*     */   
/* 110 */   public static final Type DOUBLE_TYPE = new Type(8, "VZCBSIFJD", 8, 9);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int sort;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String valueBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int valueBegin;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int valueEnd;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Type(int paramInt1, String paramString, int paramInt2, int paramInt3) {
/* 160 */     this.sort = paramInt1;
/* 161 */     this.valueBuffer = paramString;
/* 162 */     this.valueBegin = paramInt2;
/* 163 */     this.valueEnd = paramInt3;
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
/*     */   public static Type getType(String paramString) {
/* 177 */     return getTypeInternal(paramString, 0, paramString.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Type getType(Class<?> paramClass) {
/* 187 */     if (paramClass.isPrimitive()) {
/* 188 */       if (paramClass == int.class)
/* 189 */         return INT_TYPE; 
/* 190 */       if (paramClass == void.class)
/* 191 */         return VOID_TYPE; 
/* 192 */       if (paramClass == boolean.class)
/* 193 */         return BOOLEAN_TYPE; 
/* 194 */       if (paramClass == byte.class)
/* 195 */         return BYTE_TYPE; 
/* 196 */       if (paramClass == char.class)
/* 197 */         return CHAR_TYPE; 
/* 198 */       if (paramClass == short.class)
/* 199 */         return SHORT_TYPE; 
/* 200 */       if (paramClass == double.class)
/* 201 */         return DOUBLE_TYPE; 
/* 202 */       if (paramClass == float.class)
/* 203 */         return FLOAT_TYPE; 
/* 204 */       if (paramClass == long.class) {
/* 205 */         return LONG_TYPE;
/*     */       }
/* 207 */       throw new AssertionError();
/*     */     } 
/*     */     
/* 210 */     return getType(getDescriptor(paramClass));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Type getType(Constructor<?> paramConstructor) {
/* 221 */     return getType(getConstructorDescriptor(paramConstructor));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Type getType(Method paramMethod) {
/* 231 */     return getType(getMethodDescriptor(paramMethod));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Type getElementType() {
/* 241 */     int i = getDimensions();
/* 242 */     return getTypeInternal(this.valueBuffer, this.valueBegin + i, this.valueEnd);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Type getObjectType(String paramString) {
/* 252 */     return new Type(
/* 253 */         (paramString.charAt(0) == '[') ? 9 : 12, paramString, 0, paramString.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Type getMethodType(String paramString) {
/* 264 */     return new Type(11, paramString, 0, paramString.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Type getMethodType(Type paramType, Type... paramVarArgs) {
/* 275 */     return getType(getMethodDescriptor(paramType, paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Type[] getArgumentTypes() {
/* 285 */     return getArgumentTypes(getDescriptor());
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
/*     */   public static Type[] getArgumentTypes(String paramString) {
/* 298 */     byte b = 0;
/*     */     
/* 300 */     int i = 1;
/*     */     
/* 302 */     while (paramString.charAt(i) != ')') {
/* 303 */       while (paramString.charAt(i) == '[') {
/* 304 */         i++;
/*     */       }
/* 306 */       if (paramString.charAt(i++) == 'L') {
/*     */         
/* 308 */         int j = paramString.indexOf(';', i);
/* 309 */         i = Math.max(i, j + 1);
/*     */       } 
/* 311 */       b++;
/*     */     } 
/*     */ 
/*     */     
/* 315 */     Type[] arrayOfType = new Type[b];
/*     */     
/* 317 */     i = 1;
/*     */     
/* 319 */     b = 0;
/* 320 */     while (paramString.charAt(i) != ')') {
/* 321 */       int j = i;
/* 322 */       while (paramString.charAt(i) == '[') {
/* 323 */         i++;
/*     */       }
/* 325 */       if (paramString.charAt(i++) == 'L') {
/*     */         
/* 327 */         int k = paramString.indexOf(';', i);
/* 328 */         i = Math.max(i, k + 1);
/*     */       } 
/* 330 */       arrayOfType[b++] = 
/* 331 */         getTypeInternal(paramString, j, i);
/*     */     } 
/* 333 */     return arrayOfType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Type[] getArgumentTypes(Method paramMethod) {
/*     */     Class[] arrayOfClass;
/* 344 */     Type[] arrayOfType = new Type[(arrayOfClass = paramMethod.getParameterTypes()).length];
/* 345 */     for (int i = arrayOfClass.length - 1; i >= 0; i--) {
/* 346 */       arrayOfType[i] = getType(arrayOfClass[i]);
/*     */     }
/* 348 */     return arrayOfType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Type getReturnType() {
/* 358 */     return getReturnType(getDescriptor());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Type getReturnType(String paramString) {
/* 368 */     return getTypeInternal(paramString, 
/* 369 */         a(paramString), paramString.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Type getReturnType(Method paramMethod) {
/* 379 */     return getType(paramMethod.getReturnType());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static int a(String paramString) {
/* 390 */     int i = 1;
/*     */     
/* 392 */     while (paramString.charAt(i) != ')') {
/* 393 */       while (paramString.charAt(i) == '[') {
/* 394 */         i++;
/*     */       }
/* 396 */       if (paramString.charAt(i++) == 'L') {
/*     */         
/* 398 */         int j = paramString.indexOf(';', i);
/* 399 */         i = Math.max(i, j + 1);
/*     */       } 
/*     */     } 
/* 402 */     return i + 1;
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
/*     */   private static Type getTypeInternal(String paramString, int paramInt1, int paramInt2) {
/* 417 */     switch (paramString.charAt(paramInt1)) {
/*     */       case 'V':
/* 419 */         return VOID_TYPE;
/*     */       case 'Z':
/* 421 */         return BOOLEAN_TYPE;
/*     */       case 'C':
/* 423 */         return CHAR_TYPE;
/*     */       case 'B':
/* 425 */         return BYTE_TYPE;
/*     */       case 'S':
/* 427 */         return SHORT_TYPE;
/*     */       case 'I':
/* 429 */         return INT_TYPE;
/*     */       case 'F':
/* 431 */         return FLOAT_TYPE;
/*     */       case 'J':
/* 433 */         return LONG_TYPE;
/*     */       case 'D':
/* 435 */         return DOUBLE_TYPE;
/*     */       case '[':
/* 437 */         return new Type(9, paramString, paramInt1, paramInt2);
/*     */       case 'L':
/* 439 */         return new Type(10, paramString, paramInt1 + 1, paramInt2 - 1);
/*     */       case '(':
/* 441 */         return new Type(11, paramString, paramInt1, paramInt2);
/*     */     } 
/* 443 */     throw new IllegalArgumentException("Invalid descriptor: " + paramString);
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
/*     */   public final String getClassName() {
/*     */     StringBuilder stringBuilder;
/*     */     int i;
/* 458 */     switch (this.sort) {
/*     */       case 0:
/* 460 */         return "void";
/*     */       case 1:
/* 462 */         return "boolean";
/*     */       case 2:
/* 464 */         return "char";
/*     */       case 3:
/* 466 */         return "byte";
/*     */       case 4:
/* 468 */         return "short";
/*     */       case 5:
/* 470 */         return "int";
/*     */       case 6:
/* 472 */         return "float";
/*     */       case 7:
/* 474 */         return "long";
/*     */       case 8:
/* 476 */         return "double";
/*     */       case 9:
/* 478 */         stringBuilder = new StringBuilder(getElementType().getClassName());
/* 479 */         for (i = getDimensions(); i > 0; i--) {
/* 480 */           stringBuilder.append("[]");
/*     */         }
/* 482 */         return stringBuilder.toString();
/*     */       case 10:
/*     */       case 12:
/* 485 */         return this.valueBuffer.substring(this.valueBegin, this.valueEnd).replace('/', '.');
/*     */     } 
/* 487 */     throw new AssertionError();
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
/*     */   public final String getInternalName() {
/* 499 */     return this.valueBuffer.substring(this.valueBegin, this.valueEnd);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getInternalName(Class<?> paramClass) {
/* 510 */     return paramClass.getName().replace('.', '/');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getDescriptor() {
/* 519 */     if (this.sort == 10)
/* 520 */       return this.valueBuffer.substring(this.valueBegin - 1, this.valueEnd + 1); 
/* 521 */     if (this.sort == 12) {
/* 522 */       return "L" + this.valueBuffer.substring(this.valueBegin, this.valueEnd) + ';';
/*     */     }
/* 524 */     return this.valueBuffer.substring(this.valueBegin, this.valueEnd);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getDescriptor(Class<?> paramClass) {
/* 535 */     StringBuilder stringBuilder = new StringBuilder();
/* 536 */     appendDescriptor(paramClass, stringBuilder);
/* 537 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getConstructorDescriptor(Constructor<?> paramConstructor) {
/*     */     StringBuilder stringBuilder;
/* 548 */     (stringBuilder = new StringBuilder()).append('('); Class[] arrayOfClass; int i;
/*     */     byte b;
/* 550 */     for (i = (arrayOfClass = arrayOfClass = paramConstructor.getParameterTypes()).length, b = 0; b < i; b++) {
/* 551 */       Class<?> clazz; appendDescriptor(clazz = arrayOfClass[b], stringBuilder);
/*     */     } 
/* 553 */     return stringBuilder.append(")V").toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getMethodDescriptor(Type paramType, Type... paramVarArgs) {
/*     */     StringBuilder stringBuilder;
/* 565 */     (stringBuilder = new StringBuilder()).append('('); int i; byte b;
/* 566 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/* 567 */       Type type; (type = paramVarArgs[b]).appendDescriptor(stringBuilder);
/*     */     } 
/* 569 */     stringBuilder.append(')');
/* 570 */     paramType.appendDescriptor(stringBuilder);
/* 571 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getMethodDescriptor(Method paramMethod) {
/*     */     StringBuilder stringBuilder;
/* 582 */     (stringBuilder = new StringBuilder()).append('('); Class[] arrayOfClass; int i;
/*     */     byte b;
/* 584 */     for (i = (arrayOfClass = arrayOfClass = paramMethod.getParameterTypes()).length, b = 0; b < i; b++) {
/* 585 */       Class<?> clazz; appendDescriptor(clazz = arrayOfClass[b], stringBuilder);
/*     */     } 
/* 587 */     stringBuilder.append(')');
/* 588 */     appendDescriptor(paramMethod.getReturnType(), stringBuilder);
/* 589 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void appendDescriptor(StringBuilder paramStringBuilder) {
/* 598 */     if (this.sort == 10) {
/* 599 */       paramStringBuilder.append(this.valueBuffer, this.valueBegin - 1, this.valueEnd + 1); return;
/* 600 */     }  if (this.sort == 12) {
/* 601 */       paramStringBuilder.append('L').append(this.valueBuffer, this.valueBegin, this.valueEnd).append(';'); return;
/*     */     } 
/* 603 */     paramStringBuilder.append(this.valueBuffer, this.valueBegin, this.valueEnd);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void appendDescriptor(Class<?> paramClass, StringBuilder paramStringBuilder) {
/*     */     byte b;
/* 614 */     paramClass = paramClass;
/* 615 */     while (paramClass.isArray()) {
/* 616 */       paramStringBuilder.append('[');
/* 617 */       paramClass = paramClass.getComponentType();
/*     */     } 
/* 619 */     if (paramClass.isPrimitive()) {
/*     */       
/* 621 */       if (paramClass == int.class) {
/* 622 */         b = 73;
/* 623 */       } else if (b == void.class) {
/* 624 */         b = 86;
/* 625 */       } else if (b == boolean.class) {
/* 626 */         b = 90;
/* 627 */       } else if (b == byte.class) {
/* 628 */         b = 66;
/* 629 */       } else if (b == char.class) {
/* 630 */         b = 67;
/* 631 */       } else if (b == short.class) {
/* 632 */         b = 83;
/* 633 */       } else if (b == double.class) {
/* 634 */         b = 68;
/* 635 */       } else if (b == float.class) {
/* 636 */         b = 70;
/* 637 */       } else if (b == long.class) {
/* 638 */         b = 74;
/*     */       } else {
/* 640 */         throw new AssertionError();
/*     */       } 
/* 642 */       paramStringBuilder.append(b); return;
/*     */     } 
/* 644 */     paramStringBuilder.append('L').append(getInternalName(b)).append(';');
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
/*     */   public final int getSort() {
/* 660 */     return (this.sort == 12) ? 10 : this.sort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getDimensions() {
/* 670 */     byte b = 1;
/* 671 */     while (this.valueBuffer.charAt(this.valueBegin + b) == '[') {
/* 672 */       b++;
/*     */     }
/* 674 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getSize() {
/* 684 */     switch (this.sort) {
/*     */       case 0:
/* 686 */         return 0;
/*     */       case 1:
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/*     */       case 5:
/*     */       case 6:
/*     */       case 9:
/*     */       case 10:
/*     */       case 12:
/* 696 */         return 1;
/*     */       case 7:
/*     */       case 8:
/* 699 */         return 2;
/*     */     } 
/* 701 */     throw new AssertionError();
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
/*     */   public final int getArgumentsAndReturnSizes() {
/* 715 */     return getArgumentsAndReturnSizes(getDescriptor());
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
/*     */   public static int getArgumentsAndReturnSizes(String paramString) {
/* 728 */     byte b = 1;
/*     */     
/* 730 */     int i = 1;
/* 731 */     char c = paramString.charAt(1);
/*     */     
/* 733 */     while (c != ')') {
/* 734 */       if (c == 'J' || c == 'D') {
/* 735 */         i++;
/* 736 */         b += true;
/*     */       } else {
/* 738 */         while (paramString.charAt(i) == '[') {
/* 739 */           i++;
/*     */         }
/* 741 */         if (paramString.charAt(i++) == 'L') {
/*     */           
/* 743 */           int j = paramString.indexOf(';', i);
/* 744 */           i = Math.max(i, j + 1);
/*     */         } 
/* 746 */         b++;
/*     */       } 
/* 748 */       c = paramString.charAt(i);
/*     */     } 
/*     */     
/* 751 */     if ((c = paramString.charAt(i + 1)) == 'V') {
/* 752 */       return b << 2;
/*     */     }
/* 754 */     c = (c == 'J' || c == 'D') ? '\002' : '\001';
/* 755 */     return b << 2 | c;
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
/*     */   public final int getOpcode(int paramInt) {
/* 771 */     if (paramInt == 46 || paramInt == 79) {
/* 772 */       switch (this.sort) {
/*     */         case 1:
/*     */         case 3:
/* 775 */           return paramInt + 5;
/*     */         case 2:
/* 777 */           return paramInt + 6;
/*     */         case 4:
/* 779 */           return paramInt + 7;
/*     */         case 5:
/* 781 */           return paramInt;
/*     */         case 6:
/* 783 */           return paramInt + 2;
/*     */         case 7:
/* 785 */           return paramInt + 1;
/*     */         case 8:
/* 787 */           return paramInt + 3;
/*     */         case 9:
/*     */         case 10:
/*     */         case 12:
/* 791 */           return paramInt + 4;
/*     */         case 0:
/*     */         case 11:
/* 794 */           throw new UnsupportedOperationException();
/*     */       } 
/* 796 */       throw new AssertionError();
/*     */     } 
/*     */     
/* 799 */     switch (this.sort) {
/*     */       case 0:
/* 801 */         if (paramInt != 172) {
/* 802 */           throw new UnsupportedOperationException();
/*     */         }
/* 804 */         return 177;
/*     */       case 1:
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/*     */       case 5:
/* 810 */         return paramInt;
/*     */       case 6:
/* 812 */         return paramInt + 2;
/*     */       case 7:
/* 814 */         return paramInt + 1;
/*     */       case 8:
/* 816 */         return paramInt + 3;
/*     */       case 9:
/*     */       case 10:
/*     */       case 12:
/* 820 */         if (paramInt != 21 && paramInt != 54 && paramInt != 172) {
/* 821 */           throw new UnsupportedOperationException();
/*     */         }
/* 823 */         return paramInt + 4;
/*     */       case 11:
/* 825 */         throw new UnsupportedOperationException();
/*     */     } 
/* 827 */     throw new AssertionError();
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
/*     */   public final boolean equals(Object paramObject) {
/* 844 */     if (this == paramObject) {
/* 845 */       return true;
/*     */     }
/* 847 */     if (!(paramObject instanceof Type)) {
/* 848 */       return false;
/*     */     }
/* 850 */     paramObject = paramObject;
/* 851 */     if (((this.sort == 12) ? true : this.sort) != ((((Type)paramObject).sort == 12) ? true : ((Type)paramObject).sort)) {
/* 852 */       return false;
/*     */     }
/* 854 */     int i = this.valueBegin;
/* 855 */     int j = this.valueEnd;
/* 856 */     int k = ((Type)paramObject).valueBegin;
/* 857 */     int m = ((Type)paramObject).valueEnd;
/*     */     
/* 859 */     if (j - i != m - k) {
/* 860 */       return false;
/*     */     }
/* 862 */     for (i = i, k = k; i < j; i++, k++) {
/* 863 */       if (this.valueBuffer.charAt(i) != ((Type)paramObject).valueBuffer.charAt(k)) {
/* 864 */         return false;
/*     */       }
/*     */     } 
/* 867 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 877 */     int i = 13 * ((this.sort == 12) ? 10 : this.sort);
/* 878 */     if (this.sort >= 9) {
/* 879 */       for (int j = this.valueBegin, k = this.valueEnd; j < k; j++) {
/* 880 */         i = 17 * (i + this.valueBuffer.charAt(j));
/*     */       }
/*     */     }
/* 883 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 893 */     return getDescriptor();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\Type.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */