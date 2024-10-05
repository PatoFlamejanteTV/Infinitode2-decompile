package com.esotericsoftware.asm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Type {
  public static final int VOID = 0;
  
  public static final int BOOLEAN = 1;
  
  public static final int CHAR = 2;
  
  public static final int BYTE = 3;
  
  public static final int SHORT = 4;
  
  public static final int INT = 5;
  
  public static final int FLOAT = 6;
  
  public static final int LONG = 7;
  
  public static final int DOUBLE = 8;
  
  public static final int ARRAY = 9;
  
  public static final int OBJECT = 10;
  
  public static final int METHOD = 11;
  
  public static final Type VOID_TYPE = new Type(0, null, 1443168256, 1);
  
  public static final Type BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
  
  public static final Type CHAR_TYPE = new Type(2, null, 1124075009, 1);
  
  public static final Type BYTE_TYPE = new Type(3, null, 1107297537, 1);
  
  public static final Type SHORT_TYPE = new Type(4, null, 1392510721, 1);
  
  public static final Type INT_TYPE = new Type(5, null, 1224736769, 1);
  
  public static final Type FLOAT_TYPE = new Type(6, null, 1174536705, 1);
  
  public static final Type LONG_TYPE = new Type(7, null, 1241579778, 1);
  
  public static final Type DOUBLE_TYPE = new Type(8, null, 1141048066, 1);
  
  private final int a;
  
  private final char[] b;
  
  private final int c;
  
  private final int d;
  
  private Type(int paramInt1, char[] paramArrayOfchar, int paramInt2, int paramInt3) {
    this.a = paramInt1;
    this.b = paramArrayOfchar;
    this.c = paramInt2;
    this.d = paramInt3;
  }
  
  public static Type getType(String paramString) {
    return a(paramString.toCharArray(), 0);
  }
  
  public static Type getObjectType(String paramString) {
    char[] arrayOfChar = paramString.toCharArray();
    return new Type((arrayOfChar[0] == '[') ? 9 : 10, arrayOfChar, 0, arrayOfChar.length);
  }
  
  public static Type getMethodType(String paramString) {
    return a(paramString.toCharArray(), 0);
  }
  
  public static Type getMethodType(Type paramType, Type... paramVarArgs) {
    return getType(getMethodDescriptor(paramType, paramVarArgs));
  }
  
  public static Type getType(Class paramClass) {
    return paramClass.isPrimitive() ? ((paramClass == int.class) ? INT_TYPE : ((paramClass == void.class) ? VOID_TYPE : ((paramClass == boolean.class) ? BOOLEAN_TYPE : ((paramClass == byte.class) ? BYTE_TYPE : ((paramClass == char.class) ? CHAR_TYPE : ((paramClass == short.class) ? SHORT_TYPE : ((paramClass == double.class) ? DOUBLE_TYPE : ((paramClass == float.class) ? FLOAT_TYPE : LONG_TYPE)))))))) : getType(getDescriptor(paramClass));
  }
  
  public static Type getType(Constructor paramConstructor) {
    return getType(getConstructorDescriptor(paramConstructor));
  }
  
  public static Type getType(Method paramMethod) {
    return getType(getMethodDescriptor(paramMethod));
  }
  
  public static Type[] getArgumentTypes(String paramString) {
    char[] arrayOfChar = paramString.toCharArray();
    int i = 1;
    byte b = 0;
    char c;
    while ((c = arrayOfChar[i++]) != ')') {
      if (c == 'L') {
        do {
        
        } while (arrayOfChar[i++] != ';');
        b++;
        continue;
      } 
      if (c != '[')
        b++; 
    } 
    Type[] arrayOfType = new Type[b];
    i = 1;
    for (b = 0; arrayOfChar[i] != ')'; b++) {
      arrayOfType[b] = a(arrayOfChar, i);
      i += (arrayOfType[b]).d + (((arrayOfType[b]).a == 10) ? 2 : 0);
    } 
    return arrayOfType;
  }
  
  public static Type[] getArgumentTypes(Method paramMethod) {
    Class[] arrayOfClass;
    Type[] arrayOfType = new Type[(arrayOfClass = paramMethod.getParameterTypes()).length];
    for (int i = arrayOfClass.length - 1; i >= 0; i--)
      arrayOfType[i] = getType(arrayOfClass[i]); 
    return arrayOfType;
  }
  
  public static Type getReturnType(String paramString) {
    char[] arrayOfChar;
    return a(arrayOfChar = paramString.toCharArray(), paramString.indexOf(')') + 1);
  }
  
  public static Type getReturnType(Method paramMethod) {
    return getType(paramMethod.getReturnType());
  }
  
  public static int getArgumentsAndReturnSizes(String paramString) {
    byte b1 = 1;
    byte b2 = 1;
    while (true) {
      char c;
      if ((c = paramString.charAt(b2++)) == ')') {
        c = paramString.charAt(b2);
        return b1 << 2 | ((c == 'V') ? 0 : ((c == 'D' || c == 'J') ? 2 : 1));
      } 
      if (c == 'L') {
        do {
        
        } while (paramString.charAt(b2++) != ';');
        b1++;
        continue;
      } 
      if (c == '[') {
        while ((c = paramString.charAt(b2)) == '[')
          b2++; 
        if (c == 'D' || c == 'J')
          b1--; 
        continue;
      } 
      if (c == 'D' || c == 'J') {
        b1 += 2;
        continue;
      } 
      b1++;
    } 
  }
  
  private static Type a(char[] paramArrayOfchar, int paramInt) {
    byte b;
    switch (paramArrayOfchar[paramInt]) {
      case 'V':
        return VOID_TYPE;
      case 'Z':
        return BOOLEAN_TYPE;
      case 'C':
        return CHAR_TYPE;
      case 'B':
        return BYTE_TYPE;
      case 'S':
        return SHORT_TYPE;
      case 'I':
        return INT_TYPE;
      case 'F':
        return FLOAT_TYPE;
      case 'J':
        return LONG_TYPE;
      case 'D':
        return DOUBLE_TYPE;
      case '[':
        for (b = 1; paramArrayOfchar[paramInt + b] == '['; b++);
        if (paramArrayOfchar[paramInt + b] == 'L')
          while (paramArrayOfchar[paramInt + ++b] != ';')
            b++;  
        return new Type(9, paramArrayOfchar, paramInt, b + 1);
      case 'L':
        for (b = 1; paramArrayOfchar[paramInt + b] != ';'; b++);
        return new Type(10, paramArrayOfchar, paramInt + 1, b - 1);
    } 
    return new Type(11, paramArrayOfchar, paramInt, paramArrayOfchar.length - paramInt);
  }
  
  public int getSort() {
    return this.a;
  }
  
  public int getDimensions() {
    byte b;
    for (b = 1; this.b[this.c + b] == '['; b++);
    return b;
  }
  
  public Type getElementType() {
    return a(this.b, this.c + getDimensions());
  }
  
  public String getClassName() {
    StringBuffer stringBuffer;
    int i;
    switch (this.a) {
      case 0:
        return "void";
      case 1:
        return "boolean";
      case 2:
        return "char";
      case 3:
        return "byte";
      case 4:
        return "short";
      case 5:
        return "int";
      case 6:
        return "float";
      case 7:
        return "long";
      case 8:
        return "double";
      case 9:
        stringBuffer = new StringBuffer(getElementType().getClassName());
        for (i = getDimensions(); i > 0; i--)
          stringBuffer.append("[]"); 
        return stringBuffer.toString();
      case 10:
        return (new String(this.b, this.c, this.d)).replace('/', '.');
    } 
    return null;
  }
  
  public String getInternalName() {
    return new String(this.b, this.c, this.d);
  }
  
  public Type[] getArgumentTypes() {
    return getArgumentTypes(getDescriptor());
  }
  
  public Type getReturnType() {
    return getReturnType(getDescriptor());
  }
  
  public int getArgumentsAndReturnSizes() {
    return getArgumentsAndReturnSizes(getDescriptor());
  }
  
  public String getDescriptor() {
    StringBuffer stringBuffer = new StringBuffer();
    a(stringBuffer);
    return stringBuffer.toString();
  }
  
  public static String getMethodDescriptor(Type paramType, Type... paramVarArgs) {
    StringBuffer stringBuffer;
    (stringBuffer = new StringBuffer()).append('(');
    for (byte b = 0; b < paramVarArgs.length; b++)
      paramVarArgs[b].a(stringBuffer); 
    stringBuffer.append(')');
    paramType.a(stringBuffer);
    return stringBuffer.toString();
  }
  
  private void a(StringBuffer paramStringBuffer) {
    if (this.b == null) {
      paramStringBuffer.append((char)((this.c & 0xFF000000) >>> 24));
      return;
    } 
    if (this.a == 10) {
      paramStringBuffer.append('L');
      paramStringBuffer.append(this.b, this.c, this.d);
      paramStringBuffer.append(';');
      return;
    } 
    paramStringBuffer.append(this.b, this.c, this.d);
  }
  
  public static String getInternalName(Class paramClass) {
    return paramClass.getName().replace('.', '/');
  }
  
  public static String getDescriptor(Class paramClass) {
    StringBuffer stringBuffer;
    a(stringBuffer = new StringBuffer(), paramClass);
    return stringBuffer.toString();
  }
  
  public static String getConstructorDescriptor(Constructor paramConstructor) {
    Class[] arrayOfClass = paramConstructor.getParameterTypes();
    StringBuffer stringBuffer;
    (stringBuffer = new StringBuffer()).append('(');
    for (byte b = 0; b < arrayOfClass.length; b++)
      a(stringBuffer, arrayOfClass[b]); 
    return stringBuffer.append(")V").toString();
  }
  
  public static String getMethodDescriptor(Method paramMethod) {
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    StringBuffer stringBuffer;
    (stringBuffer = new StringBuffer()).append('(');
    for (byte b = 0; b < arrayOfClass.length; b++)
      a(stringBuffer, arrayOfClass[b]); 
    stringBuffer.append(')');
    a(stringBuffer, paramMethod.getReturnType());
    return stringBuffer.toString();
  }
  
  private static void a(StringBuffer paramStringBuffer, Class paramClass) {
    // Byte code:
    //   0: aload_1
    //   1: astore_1
    //   2: aload_1
    //   3: invokevirtual isPrimitive : ()Z
    //   6: ifeq -> 123
    //   9: aload_1
    //   10: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   13: if_acmpne -> 22
    //   16: bipush #73
    //   18: istore_1
    //   19: goto -> 116
    //   22: aload_1
    //   23: getstatic java/lang/Void.TYPE : Ljava/lang/Class;
    //   26: if_acmpne -> 35
    //   29: bipush #86
    //   31: istore_1
    //   32: goto -> 116
    //   35: aload_1
    //   36: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   39: if_acmpne -> 48
    //   42: bipush #90
    //   44: istore_1
    //   45: goto -> 116
    //   48: aload_1
    //   49: getstatic java/lang/Byte.TYPE : Ljava/lang/Class;
    //   52: if_acmpne -> 61
    //   55: bipush #66
    //   57: istore_1
    //   58: goto -> 116
    //   61: aload_1
    //   62: getstatic java/lang/Character.TYPE : Ljava/lang/Class;
    //   65: if_acmpne -> 74
    //   68: bipush #67
    //   70: istore_1
    //   71: goto -> 116
    //   74: aload_1
    //   75: getstatic java/lang/Short.TYPE : Ljava/lang/Class;
    //   78: if_acmpne -> 87
    //   81: bipush #83
    //   83: istore_1
    //   84: goto -> 116
    //   87: aload_1
    //   88: getstatic java/lang/Double.TYPE : Ljava/lang/Class;
    //   91: if_acmpne -> 100
    //   94: bipush #68
    //   96: istore_1
    //   97: goto -> 116
    //   100: aload_1
    //   101: getstatic java/lang/Float.TYPE : Ljava/lang/Class;
    //   104: if_acmpne -> 113
    //   107: bipush #70
    //   109: istore_1
    //   110: goto -> 116
    //   113: bipush #74
    //   115: istore_1
    //   116: aload_0
    //   117: iload_1
    //   118: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   121: pop
    //   122: return
    //   123: aload_1
    //   124: invokevirtual isArray : ()Z
    //   127: ifeq -> 145
    //   130: aload_0
    //   131: bipush #91
    //   133: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   136: pop
    //   137: aload_1
    //   138: invokevirtual getComponentType : ()Ljava/lang/Class;
    //   141: astore_1
    //   142: goto -> 2
    //   145: aload_0
    //   146: bipush #76
    //   148: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   151: pop
    //   152: aload_1
    //   153: invokevirtual getName : ()Ljava/lang/String;
    //   156: dup
    //   157: astore_1
    //   158: invokevirtual length : ()I
    //   161: istore_2
    //   162: iconst_0
    //   163: istore_3
    //   164: iload_3
    //   165: iload_2
    //   166: if_icmpge -> 201
    //   169: aload_1
    //   170: iload_3
    //   171: invokevirtual charAt : (I)C
    //   174: istore #4
    //   176: aload_0
    //   177: iload #4
    //   179: bipush #46
    //   181: if_icmpne -> 189
    //   184: bipush #47
    //   186: goto -> 191
    //   189: iload #4
    //   191: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   194: pop
    //   195: iinc #3, 1
    //   198: goto -> 164
    //   201: aload_0
    //   202: bipush #59
    //   204: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   207: pop
    //   208: return
  }
  
  public int getSize() {
    return (this.b == null) ? (this.c & 0xFF) : 1;
  }
  
  public int getOpcode(int paramInt) {
    return (paramInt == 46 || paramInt == 79) ? (paramInt + ((this.b == null) ? (this.c >> 8 & 0xFF) : 4)) : (paramInt + ((this.b == null) ? (this.c >> 16 & 0xFF) : 4));
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof Type))
      return false; 
    paramObject = paramObject;
    if (this.a != ((Type)paramObject).a)
      return false; 
    if (this.a >= 9) {
      if (this.d != ((Type)paramObject).d)
        return false; 
      int i = this.c;
      int j = ((Type)paramObject).c;
      int k = i + this.d;
      while (i < k) {
        if (this.b[i] != ((Type)paramObject).b[j])
          return false; 
        i++;
        j++;
      } 
    } 
    return true;
  }
  
  public int hashCode() {
    int i = 13 * this.a;
    if (this.a >= 9) {
      int j;
      int k = (j = this.c) + this.d;
      while (j < k) {
        i = 17 * (i + this.b[j]);
        j++;
      } 
    } 
    return i;
  }
  
  public String toString() {
    return getDescriptor();
  }
  
  static void _clinit_() {}
  
  static {
    _clinit_();
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\asm\Type.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */