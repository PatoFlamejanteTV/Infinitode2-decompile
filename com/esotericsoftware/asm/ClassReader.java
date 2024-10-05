package com.esotericsoftware.asm;

import java.io.IOException;
import java.io.InputStream;

public class ClassReader {
  public static final int SKIP_CODE = 1;
  
  public static final int SKIP_DEBUG = 2;
  
  public static final int SKIP_FRAMES = 4;
  
  public static final int EXPAND_FRAMES = 8;
  
  public final byte[] b;
  
  private final int[] a;
  
  private final String[] c;
  
  private final int d;
  
  public final int header;
  
  public ClassReader(byte[] paramArrayOfbyte) {
    this(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public ClassReader(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this.b = paramArrayOfbyte;
    if (readShort(paramInt1 + 6) > 52)
      throw new IllegalArgumentException(); 
    this.a = new int[readUnsignedShort(paramInt1 + 8)];
    paramInt2 = this.a.length;
    this.c = new String[paramInt2];
    int i = 0;
    paramInt1 += 10;
    for (byte b = 1; b < paramInt2; b++) {
      int j;
      this.a[b] = paramInt1 + 1;
      switch (paramArrayOfbyte[paramInt1]) {
        case 3:
        case 4:
        case 9:
        case 10:
        case 11:
        case 12:
        case 18:
          j = 5;
          break;
        case 5:
        case 6:
          j = 9;
          b++;
          break;
        case 1:
          if ((j = 3 + readUnsignedShort(paramInt1 + 1)) > i)
            i = j; 
          break;
        case 15:
          j = 4;
          break;
        default:
          j = 3;
          break;
      } 
      paramInt1 += j;
    } 
    this.d = i;
    this.header = paramInt1;
  }
  
  public int getAccess() {
    return readUnsignedShort(this.header);
  }
  
  public String getClassName() {
    return readClass(this.header + 2, new char[this.d]);
  }
  
  public String getSuperName() {
    return readClass(this.header + 4, new char[this.d]);
  }
  
  public String[] getInterfaces() {
    int i = this.header + 6;
    int j;
    String[] arrayOfString = new String[j = readUnsignedShort(i)];
    if (j > 0) {
      char[] arrayOfChar = new char[this.d];
      for (byte b = 0; b < j; b++) {
        i += 2;
        arrayOfString[b] = readClass(i, arrayOfChar);
      } 
    } 
    return arrayOfString;
  }
  
  void a(ClassWriter paramClassWriter) {
    char[] arrayOfChar = new char[this.d];
    int i;
    Item[] arrayOfItem = new Item[i = this.a.length];
    int j;
    for (j = 1; j < i; j++) {
      int m;
      String str;
      int k = this.a[j];
      byte b = this.b[k - 1];
      Item item = new Item(j);
      switch (b) {
        case 9:
        case 10:
        case 11:
          m = this.a[readUnsignedShort(k + 2)];
          item.a(b, readClass(k, arrayOfChar), readUTF8(m, arrayOfChar), readUTF8(m + 2, arrayOfChar));
          break;
        case 3:
          item.a(readInt(k));
          break;
        case 4:
          item.a(Float.intBitsToFloat(readInt(k)));
          break;
        case 12:
          item.a(b, readUTF8(k, arrayOfChar), readUTF8(k + 2, arrayOfChar), null);
          break;
        case 5:
          item.a(readLong(k));
          j++;
          break;
        case 6:
          item.a(Double.longBitsToDouble(readLong(k)));
          j++;
          break;
        case 1:
          if ((str = this.c[j]) == null) {
            k = this.a[j];
            str = this.c[j] = a(k + 2, readUnsignedShort(k), arrayOfChar);
          } 
          item.a(b, str, null, null);
          break;
        case 15:
          n = this.a[readUnsignedShort(k + 1)];
          m = this.a[readUnsignedShort(n + 2)];
          item.a(20 + readByte(k), readClass(n, arrayOfChar), readUTF8(m, arrayOfChar), readUTF8(m + 2, arrayOfChar));
          break;
        case 18:
          if (paramClassWriter.A == null)
            a(paramClassWriter, arrayOfItem, arrayOfChar); 
          m = this.a[readUnsignedShort(k + 2)];
          item.a(readUTF8(m, arrayOfChar), readUTF8(m + 2, arrayOfChar), readUnsignedShort(k));
          break;
        default:
          item.a(b, readUTF8(k, arrayOfChar), null, null);
          break;
      } 
      int n = item.j % i;
      item.k = arrayOfItem[n];
      arrayOfItem[n] = item;
    } 
    j = this.a[1] - 1;
    paramClassWriter.d.putByteArray(this.b, j, this.header - j);
    paramClassWriter.e = arrayOfItem;
    paramClassWriter.f = (int)(0.75D * i);
    paramClassWriter.c = i;
  }
  
  private void a(ClassWriter paramClassWriter, Item[] paramArrayOfItem, char[] paramArrayOfchar) {
    int i = a();
    int j = 0;
    int k;
    for (k = readUnsignedShort(i); k > 0; k--) {
      String str = readUTF8(i + 2, paramArrayOfchar);
      if ("BootstrapMethods".equals(str)) {
        j = 1;
        break;
      } 
      i += 6 + readInt(i + 4);
    } 
    if (!j)
      return; 
    k = readUnsignedShort(i + 8);
    int m = 0;
    j = i + 10;
    while (m < k) {
      int n = j - i - 10;
      int i1 = readConst(readUnsignedShort(j), paramArrayOfchar).hashCode();
      for (int i2 = readUnsignedShort(j + 2); i2 > 0; i2--) {
        i1 ^= readConst(readUnsignedShort(j + 4), paramArrayOfchar).hashCode();
        j += 2;
      } 
      j += 4;
      Item item;
      (item = new Item(m)).a(n, i1 & Integer.MAX_VALUE);
      n = item.j % paramArrayOfItem.length;
      item.k = paramArrayOfItem[n];
      paramArrayOfItem[n] = item;
      m++;
    } 
    m = readInt(i + 4);
    ByteVector byteVector;
    (byteVector = new ByteVector(m + 62)).putByteArray(this.b, i + 10, m - 2);
    paramClassWriter.z = k;
    paramClassWriter.A = byteVector;
  }
  
  public ClassReader(InputStream paramInputStream) {
    this(a(paramInputStream, false));
  }
  
  public ClassReader(String paramString) {
    this(a(ClassLoader.getSystemResourceAsStream(paramString.replace('.', '/') + ".class"), true));
  }
  
  private static byte[] a(InputStream paramInputStream, boolean paramBoolean) {
    if (paramInputStream == null)
      throw new IOException("Class not found"); 
    try {
      byte[] arrayOfByte = new byte[paramInputStream.available()];
      int i = 0;
      while (true) {
        byte[] arrayOfByte1;
        int j;
        if ((j = paramInputStream.read(arrayOfByte, i, arrayOfByte.length - i)) == -1) {
          if (i < arrayOfByte.length) {
            byte[] arrayOfByte2 = new byte[i];
            System.arraycopy(arrayOfByte, 0, arrayOfByte2, 0, i);
            arrayOfByte = arrayOfByte2;
          } 
          arrayOfByte1 = arrayOfByte;
          return arrayOfByte1;
        } 
        if ((i += arrayOfByte1) == arrayOfByte.length) {
          int k;
          if ((k = paramInputStream.read()) < 0)
            return arrayOfByte; 
          byte[] arrayOfByte2 = new byte[arrayOfByte.length + 1000];
          System.arraycopy(arrayOfByte, 0, arrayOfByte2, 0, i);
          arrayOfByte2[i++] = (byte)k;
          arrayOfByte = arrayOfByte2;
        } 
      } 
    } finally {
      if (paramBoolean)
        paramInputStream.close(); 
    } 
  }
  
  public void accept(ClassVisitor paramClassVisitor, int paramInt) {
    accept(paramClassVisitor, new Attribute[0], paramInt);
  }
  
  public void accept(ClassVisitor paramClassVisitor, Attribute[] paramArrayOfAttribute, int paramInt) {
    int i = this.header;
    char[] arrayOfChar = new char[this.d];
    Context context;
    (context = new Context()).a = paramArrayOfAttribute;
    context.b = paramInt;
    context.c = arrayOfChar;
    int j = readUnsignedShort(i);
    String str1 = readClass(i + 2, arrayOfChar);
    String str2 = readClass(i + 4, arrayOfChar);
    String[] arrayOfString = new String[readUnsignedShort(i + 6)];
    i += 8;
    for (byte b = 0; b < arrayOfString.length; b++) {
      arrayOfString[b] = readClass(i, arrayOfChar);
      i += 2;
    } 
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    String str7 = null;
    String str8 = null;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    Attribute attribute = null;
    i = a();
    int i3;
    for (i3 = readUnsignedShort(i); i3 > 0; i3--) {
      String str = readUTF8(i + 2, arrayOfChar);
      if ("SourceFile".equals(str)) {
        str4 = readUTF8(i + 8, arrayOfChar);
      } else if ("InnerClasses".equals(str)) {
        i2 = i + 8;
      } else {
        int i4;
        if ("EnclosingMethod".equals(str)) {
          str6 = readClass(i + 8, arrayOfChar);
          if ((i4 = readUnsignedShort(i + 10)) != 0) {
            str7 = readUTF8(this.a[i4], arrayOfChar);
            str8 = readUTF8(this.a[i4] + 2, arrayOfChar);
          } 
        } else if ("Signature".equals(i4)) {
          str3 = readUTF8(i + 8, arrayOfChar);
        } else if ("RuntimeVisibleAnnotations".equals(i4)) {
          k = i + 8;
        } else if ("RuntimeVisibleTypeAnnotations".equals(i4)) {
          n = i + 8;
        } else if ("Deprecated".equals(i4)) {
          j |= 0x20000;
        } else if ("Synthetic".equals(i4)) {
          j |= 0x41000;
        } else if ("SourceDebugExtension".equals(i4)) {
          i4 = readInt(i + 4);
          str5 = a(i + 8, i4, new char[i4]);
        } else if ("RuntimeInvisibleAnnotations".equals(i4)) {
          m = i + 8;
        } else if ("RuntimeInvisibleTypeAnnotations".equals(i4)) {
          i1 = i + 8;
        } else {
          int[] arrayOfInt;
          if ("BootstrapMethods".equals(i4)) {
            arrayOfInt = new int[readUnsignedShort(i + 8)];
            byte b1 = 0;
            int i5 = i + 10;
            while (b1 < arrayOfInt.length) {
              arrayOfInt[b1] = i5;
              i5 += 2 + readUnsignedShort(i5 + 2) << 1;
              b1++;
            } 
            context.d = arrayOfInt;
          } else {
            Attribute attribute1;
            if ((attribute1 = a(paramArrayOfAttribute, (String)arrayOfInt, i + 8, readInt(i + 4), arrayOfChar, -1, null)) != null) {
              attribute1.a = attribute;
              attribute = attribute1;
            } 
          } 
        } 
      } 
      i += 6 + readInt(i + 4);
    } 
    paramClassVisitor.visit(readInt(this.a[1] - 7), j, str1, str3, str2, arrayOfString);
    if ((paramInt & 0x2) == 0 && (str4 != null || str5 != null))
      paramClassVisitor.visitSource(str4, str5); 
    if (str6 != null)
      paramClassVisitor.visitOuterClass(str6, str7, str8); 
    if (k != 0) {
      i3 = readUnsignedShort(k);
      int i4 = k + 2;
      while (i3 > 0) {
        i4 = a(i4 + 2, arrayOfChar, true, paramClassVisitor.visitAnnotation(readUTF8(i4, arrayOfChar), true));
        i3--;
      } 
    } 
    if (m != 0) {
      i3 = readUnsignedShort(m);
      int i4 = m + 2;
      while (i3 > 0) {
        i4 = a(i4 + 2, arrayOfChar, true, paramClassVisitor.visitAnnotation(readUTF8(i4, arrayOfChar), false));
        i3--;
      } 
    } 
    if (n != 0) {
      i3 = readUnsignedShort(n);
      int i4 = n + 2;
      while (i3 > 0) {
        i4 = a(context, i4);
        i4 = a(i4 + 2, arrayOfChar, true, paramClassVisitor.visitTypeAnnotation(context.i, context.j, readUTF8(i4, arrayOfChar), true));
        i3--;
      } 
    } 
    if (i1 != 0) {
      i3 = readUnsignedShort(i1);
      int i4 = i1 + 2;
      while (i3 > 0) {
        i4 = a(context, i4);
        i4 = a(i4 + 2, arrayOfChar, true, paramClassVisitor.visitTypeAnnotation(context.i, context.j, readUTF8(i4, arrayOfChar), false));
        i3--;
      } 
    } 
    while (attribute != null) {
      Attribute attribute1 = attribute.a;
      attribute.a = null;
      paramClassVisitor.visitAttribute(attribute);
      attribute = attribute1;
    } 
    if (i2 != 0) {
      i3 = i2 + 2;
      for (int i4 = readUnsignedShort(i2); i4 > 0; i4--) {
        paramClassVisitor.visitInnerClass(readClass(i3, arrayOfChar), readClass(i3 + 2, arrayOfChar), readUTF8(i3 + 4, arrayOfChar), readUnsignedShort(i3 + 6));
        i3 += 8;
      } 
    } 
    i = this.header + 10 + 2 * arrayOfString.length;
    for (i3 = readUnsignedShort(i - 2); i3 > 0; i3--)
      i = a(paramClassVisitor, context, i); 
    i += 2;
    for (i3 = readUnsignedShort(i - 2); i3 > 0; i3--)
      i = b(paramClassVisitor, context, i); 
    paramClassVisitor.visitEnd();
  }
  
  private int a(ClassVisitor paramClassVisitor, Context paramContext, int paramInt) {
    char[] arrayOfChar = paramContext.c;
    int i = readUnsignedShort(paramInt);
    String str1 = readUTF8(paramInt + 2, arrayOfChar);
    String str2 = readUTF8(paramInt + 4, arrayOfChar);
    paramInt += 6;
    String str3 = null;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    Object object = null;
    Attribute attribute = null;
    for (int i1 = readUnsignedShort(paramInt); i1 > 0; i1--) {
      String str = readUTF8(paramInt + 2, arrayOfChar);
      if ("ConstantValue".equals(str)) {
        int i2;
        object = ((i2 = readUnsignedShort(paramInt + 8)) == 0) ? null : readConst(i2, arrayOfChar);
      } else if ("Signature".equals(str)) {
        str3 = readUTF8(paramInt + 8, arrayOfChar);
      } else if ("Deprecated".equals(str)) {
        i |= 0x20000;
      } else if ("Synthetic".equals(str)) {
        i |= 0x41000;
      } else if ("RuntimeVisibleAnnotations".equals(str)) {
        j = paramInt + 8;
      } else if ("RuntimeVisibleTypeAnnotations".equals(str)) {
        m = paramInt + 8;
      } else if ("RuntimeInvisibleAnnotations".equals(str)) {
        k = paramInt + 8;
      } else if ("RuntimeInvisibleTypeAnnotations".equals(str)) {
        n = paramInt + 8;
      } else {
        Attribute attribute1;
        if ((attribute1 = a(paramContext.a, str, paramInt + 8, readInt(paramInt + 4), arrayOfChar, -1, null)) != null) {
          attribute1.a = attribute;
          attribute = attribute1;
        } 
      } 
      paramInt += 6 + readInt(paramInt + 4);
    } 
    paramInt += 2;
    FieldVisitor fieldVisitor;
    if ((fieldVisitor = paramClassVisitor.visitField(i, str1, str2, str3, object)) == null)
      return paramInt; 
    if (j != 0) {
      int i2 = readUnsignedShort(j);
      int i3 = j + 2;
      while (i2 > 0) {
        i3 = a(i3 + 2, arrayOfChar, true, fieldVisitor.visitAnnotation(readUTF8(i3, arrayOfChar), true));
        i2--;
      } 
    } 
    if (k != 0) {
      int i2 = readUnsignedShort(k);
      int i3 = k + 2;
      while (i2 > 0) {
        i3 = a(i3 + 2, arrayOfChar, true, fieldVisitor.visitAnnotation(readUTF8(i3, arrayOfChar), false));
        i2--;
      } 
    } 
    if (m != 0) {
      int i2 = readUnsignedShort(m);
      int i3 = m + 2;
      while (i2 > 0) {
        i3 = a(paramContext, i3);
        i3 = a(i3 + 2, arrayOfChar, true, fieldVisitor.visitTypeAnnotation(paramContext.i, paramContext.j, readUTF8(i3, arrayOfChar), true));
        i2--;
      } 
    } 
    if (n != 0) {
      int i2 = readUnsignedShort(n);
      int i3 = n + 2;
      while (i2 > 0) {
        i3 = a(paramContext, i3);
        i3 = a(i3 + 2, arrayOfChar, true, fieldVisitor.visitTypeAnnotation(paramContext.i, paramContext.j, readUTF8(i3, arrayOfChar), false));
        i2--;
      } 
    } 
    while (attribute != null) {
      Attribute attribute1 = attribute.a;
      attribute.a = null;
      fieldVisitor.visitAttribute(attribute);
      attribute = attribute1;
    } 
    fieldVisitor.visitEnd();
    return paramInt;
  }
  
  private int b(ClassVisitor paramClassVisitor, Context paramContext, int paramInt) {
    char[] arrayOfChar = paramContext.c;
    paramContext.e = readUnsignedShort(paramInt);
    paramContext.f = readUTF8(paramInt + 2, arrayOfChar);
    paramContext.g = readUTF8(paramInt + 4, arrayOfChar);
    paramInt += 6;
    int i = 0;
    int j = 0;
    String[] arrayOfString = null;
    String str = null;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = paramInt;
    Attribute attribute = null;
    for (int i7 = readUnsignedShort(paramInt); i7 > 0; i7--) {
      String str1 = readUTF8(paramInt + 2, arrayOfChar);
      if ("Code".equals(str1)) {
        if ((paramContext.b & 0x1) == 0)
          i = paramInt + 8; 
      } else if ("Exceptions".equals(str1)) {
        arrayOfString = new String[readUnsignedShort(paramInt + 8)];
        j = paramInt + 10;
        for (byte b = 0; b < arrayOfString.length; b++) {
          arrayOfString[b] = readClass(j, arrayOfChar);
          j += 2;
        } 
      } else if ("Signature".equals(str1)) {
        str = readUTF8(paramInt + 8, arrayOfChar);
      } else if ("Deprecated".equals(str1)) {
        paramContext.e |= 0x20000;
      } else if ("RuntimeVisibleAnnotations".equals(str1)) {
        m = paramInt + 8;
      } else if ("RuntimeVisibleTypeAnnotations".equals(str1)) {
        i1 = paramInt + 8;
      } else if ("AnnotationDefault".equals(str1)) {
        i3 = paramInt + 8;
      } else if ("Synthetic".equals(str1)) {
        paramContext.e |= 0x41000;
      } else if ("RuntimeInvisibleAnnotations".equals(str1)) {
        n = paramInt + 8;
      } else if ("RuntimeInvisibleTypeAnnotations".equals(str1)) {
        i2 = paramInt + 8;
      } else if ("RuntimeVisibleParameterAnnotations".equals(str1)) {
        i4 = paramInt + 8;
      } else if ("RuntimeInvisibleParameterAnnotations".equals(str1)) {
        i5 = paramInt + 8;
      } else if ("MethodParameters".equals(str1)) {
        k = paramInt + 8;
      } else {
        Attribute attribute1;
        if ((attribute1 = a(paramContext.a, str1, paramInt + 8, readInt(paramInt + 4), arrayOfChar, -1, null)) != null) {
          attribute1.a = attribute;
          attribute = attribute1;
        } 
      } 
      paramInt += 6 + readInt(paramInt + 4);
    } 
    paramInt += 2;
    MethodVisitor methodVisitor;
    if ((methodVisitor = paramClassVisitor.visitMethod(paramContext.e, paramContext.f, paramContext.g, str, arrayOfString)) == null)
      return paramInt; 
    MethodWriter methodWriter;
    if (methodVisitor instanceof MethodWriter && (methodWriter = (MethodWriter)methodVisitor).b.M == this && str == methodWriter.g) {
      boolean bool = false;
      if (arrayOfString == null) {
        bool = (methodWriter.j == 0) ? true : false;
      } else if (arrayOfString.length == methodWriter.j) {
        bool = true;
        for (int i8 = arrayOfString.length - 1; i8 >= 0; i8--) {
          j -= 2;
          if (methodWriter.k[i8] != readUnsignedShort(j)) {
            bool = false;
            break;
          } 
        } 
      } 
      if (bool) {
        methodWriter.h = i6;
        methodWriter.i = paramInt - i6;
        return paramInt;
      } 
    } 
    if (k != 0) {
      int i8 = this.b[k] & 0xFF;
      int i9;
      for (i9 = k + 1; i8 > 0; i9 += 4) {
        methodVisitor.visitParameter(readUTF8(i9, arrayOfChar), readUnsignedShort(i9 + 2));
        i8--;
      } 
    } 
    if (i3 != 0) {
      AnnotationVisitor annotationVisitor = methodVisitor.visitAnnotationDefault();
      a(i3, arrayOfChar, (String)null, annotationVisitor);
      if (annotationVisitor != null)
        annotationVisitor.visitEnd(); 
    } 
    if (m != 0) {
      int i8 = readUnsignedShort(m);
      int i9 = m + 2;
      while (i8 > 0) {
        i9 = a(i9 + 2, arrayOfChar, true, methodVisitor.visitAnnotation(readUTF8(i9, arrayOfChar), true));
        i8--;
      } 
    } 
    if (n != 0) {
      int i8 = readUnsignedShort(n);
      int i9 = n + 2;
      while (i8 > 0) {
        i9 = a(i9 + 2, arrayOfChar, true, methodVisitor.visitAnnotation(readUTF8(i9, arrayOfChar), false));
        i8--;
      } 
    } 
    if (i1 != 0) {
      int i8 = readUnsignedShort(i1);
      int i9 = i1 + 2;
      while (i8 > 0) {
        i9 = a(paramContext, i9);
        i9 = a(i9 + 2, arrayOfChar, true, methodVisitor.visitTypeAnnotation(paramContext.i, paramContext.j, readUTF8(i9, arrayOfChar), true));
        i8--;
      } 
    } 
    if (i2 != 0) {
      int i8 = readUnsignedShort(i2);
      int i9 = i2 + 2;
      while (i8 > 0) {
        i9 = a(paramContext, i9);
        i9 = a(i9 + 2, arrayOfChar, true, methodVisitor.visitTypeAnnotation(paramContext.i, paramContext.j, readUTF8(i9, arrayOfChar), false));
        i8--;
      } 
    } 
    if (i4 != 0)
      b(methodVisitor, paramContext, i4, true); 
    if (i5 != 0)
      b(methodVisitor, paramContext, i5, false); 
    while (attribute != null) {
      Attribute attribute1 = attribute.a;
      attribute.a = null;
      methodVisitor.visitAttribute(attribute);
      attribute = attribute1;
    } 
    if (i != 0) {
      methodVisitor.visitCode();
      a(methodVisitor, paramContext, i);
    } 
    methodVisitor.visitEnd();
    return paramInt;
  }
  
  private void a(MethodVisitor paramMethodVisitor, Context paramContext, int paramInt) {
    byte[] arrayOfByte = this.b;
    char[] arrayOfChar = paramContext.c;
    int i = readUnsignedShort(paramInt);
    int j = readUnsignedShort(paramInt + 2);
    int k = readInt(paramInt + 4);
    paramInt += 8;
    int m = paramInt;
    int n = paramInt + k;
    Label[] arrayOfLabel = paramContext.h = new Label[k + 2];
    readLabel(k + 1, arrayOfLabel);
    while (paramInt < n) {
      int i10;
      int i8 = paramInt - m;
      int i9 = arrayOfByte[paramInt] & 0xFF;
      switch (ClassWriter.a[i9]) {
        case 0:
        case 4:
          paramInt++;
          continue;
        case 9:
          readLabel(i8 + readShort(paramInt + 1), arrayOfLabel);
          paramInt += 3;
          continue;
        case 10:
          readLabel(i8 + readInt(paramInt + 1), arrayOfLabel);
          paramInt += 5;
          continue;
        case 17:
          if ((i9 = arrayOfByte[paramInt + 1] & 0xFF) == 132) {
            paramInt += 6;
            continue;
          } 
          paramInt += 4;
          continue;
        case 14:
          paramInt = paramInt + 4 - (i8 & 0x3);
          readLabel(i8 + readInt(paramInt), arrayOfLabel);
          for (i10 = readInt(paramInt + 8) - readInt(paramInt + 4) + 1; i10 > 0; i10--) {
            readLabel(i8 + readInt(paramInt + 12), arrayOfLabel);
            paramInt += 4;
          } 
          paramInt += 12;
          continue;
        case 15:
          paramInt = paramInt + 4 - (i8 & 0x3);
          readLabel(i8 + readInt(paramInt), arrayOfLabel);
          for (i10 = readInt(paramInt + 4); i10 > 0; i10--) {
            readLabel(i8 + readInt(paramInt + 12), arrayOfLabel);
            paramInt += 8;
          } 
          paramInt += 8;
          continue;
        case 1:
        case 3:
        case 11:
          paramInt += 2;
          continue;
        case 2:
        case 5:
        case 6:
        case 12:
        case 13:
          paramInt += 3;
          continue;
        case 7:
        case 8:
          paramInt += 5;
          continue;
      } 
      paramInt += 4;
    } 
    for (int i1 = readUnsignedShort(paramInt); i1 > 0; i1--) {
      Label label1 = readLabel(readUnsignedShort(paramInt + 2), arrayOfLabel);
      Label label2 = readLabel(readUnsignedShort(paramInt + 4), arrayOfLabel);
      Label label3 = readLabel(readUnsignedShort(paramInt + 6), arrayOfLabel);
      String str = readUTF8(this.a[readUnsignedShort(paramInt + 8)], arrayOfChar);
      paramMethodVisitor.visitTryCatchBlock(label1, label2, label3, str);
      paramInt += 8;
    } 
    paramInt += 2;
    int[] arrayOfInt1 = null;
    int[] arrayOfInt2 = null;
    byte b1 = 0;
    byte b2 = 0;
    byte b3 = -1;
    byte b4 = -1;
    int i2 = 0;
    int i3 = 0;
    boolean bool1 = true;
    boolean bool2 = ((paramContext.b & 0x8) != 0) ? true : false;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    Context context = null;
    Attribute attribute = null;
    int i7;
    for (i7 = readUnsignedShort(paramInt); i7 > 0; i7--) {
      String str = readUTF8(paramInt + 2, arrayOfChar);
      if ("LocalVariableTable".equals(str)) {
        if ((paramContext.b & 0x2) == 0) {
          i2 = paramInt + 8;
          int i8 = readUnsignedShort(paramInt + 8);
          int i9 = paramInt;
          while (i8 > 0) {
            int i10 = readUnsignedShort(i9 + 10);
            if (arrayOfLabel[i10] == null)
              (readLabel(i10, arrayOfLabel)).a |= 0x1; 
            i10 += readUnsignedShort(i9 + 12);
            if (arrayOfLabel[i10] == null)
              (readLabel(i10, arrayOfLabel)).a |= 0x1; 
            i9 += 10;
            i8--;
          } 
        } 
      } else if ("LocalVariableTypeTable".equals(str)) {
        i3 = paramInt + 8;
      } else if ("LineNumberTable".equals(str)) {
        if ((paramContext.b & 0x2) == 0) {
          int i8 = readUnsignedShort(paramInt + 8);
          int i9 = paramInt;
          while (i8 > 0) {
            int i10 = readUnsignedShort(i9 + 10);
            if (arrayOfLabel[i10] == null)
              (readLabel(i10, arrayOfLabel)).a |= 0x1; 
            Label label;
            for (label = arrayOfLabel[i10]; label.b > 0; label = label.k) {
              if (label.k == null)
                label.k = new Label(); 
            } 
            label.b = readUnsignedShort(i9 + 12);
            i9 += 4;
            i8--;
          } 
        } 
      } else if ("RuntimeVisibleTypeAnnotations".equals(str)) {
        b3 = ((arrayOfInt1 = a(paramMethodVisitor, paramContext, paramInt + 8, true)).length == 0 || readByte(arrayOfInt1[0]) < 67) ? -1 : readUnsignedShort(arrayOfInt1[0] + 1);
      } else if ("RuntimeInvisibleTypeAnnotations".equals(str)) {
        b4 = ((arrayOfInt2 = a(paramMethodVisitor, paramContext, paramInt + 8, false)).length == 0 || readByte(arrayOfInt2[0]) < 67) ? -1 : readUnsignedShort(arrayOfInt2[0] + 1);
      } else if ("StackMapTable".equals(str)) {
        if ((paramContext.b & 0x4) == 0) {
          i4 = paramInt + 10;
          i5 = readInt(paramInt + 4);
          i6 = readUnsignedShort(paramInt + 8);
        } 
      } else if ("StackMap".equals(str)) {
        if ((paramContext.b & 0x4) == 0) {
          bool1 = false;
          i4 = paramInt + 10;
          i5 = readInt(paramInt + 4);
          i6 = readUnsignedShort(paramInt + 8);
        } 
      } else {
        for (byte b = 0; b < paramContext.a.length; b++) {
          Attribute attribute1;
          if ((paramContext.a[b]).type.equals(str) && (attribute1 = paramContext.a[b].read(this, paramInt + 8, readInt(paramInt + 4), arrayOfChar, m - 8, arrayOfLabel)) != null) {
            attribute1.a = attribute;
            attribute = attribute1;
          } 
        } 
      } 
      paramInt += 6 + readInt(paramInt + 4);
    } 
    if (i4 != 0) {
      (context = paramContext).o = -1;
      context.p = 0;
      context.q = 0;
      context.r = 0;
      context.t = 0;
      context.s = new Object[j];
      context.u = new Object[i];
      if (bool2)
        a(paramContext); 
      for (i7 = i4; i7 < i4 + i5 - 2; i7++) {
        int i8;
        if (arrayOfByte[i7] == 8 && (i8 = readUnsignedShort(i7 + 1)) >= 0 && i8 < k && (arrayOfByte[m + i8] & 0xFF) == 187)
          readLabel(i8, arrayOfLabel); 
      } 
    } 
    paramInt = m;
    while (paramInt < n) {
      Label[] arrayOfLabel1;
      String str2;
      int i8;
      String str1;
      byte b;
      String str3;
      Object[] arrayOfObject;
      String str4;
      int i10;
      int i11;
      int i12;
      int[] arrayOfInt;
      String str5;
      Handle handle;
      i7 = paramInt - m;
      Label label;
      if ((label = arrayOfLabel[i7]) != null) {
        Label label1 = label.k;
        label.k = null;
        paramMethodVisitor.visitLabel(label);
        if ((paramContext.b & 0x2) == 0 && label.b > 0) {
          paramMethodVisitor.visitLineNumber(label.b, label);
          while (label1 != null) {
            paramMethodVisitor.visitLineNumber(label1.b, label);
            label1 = label1.k;
          } 
        } 
      } 
      while (context != null && (context.o == i7 || context.o == -1)) {
        if (context.o != -1)
          if (!bool1 || bool2) {
            paramMethodVisitor.visitFrame(-1, context.q, context.s, context.t, context.u);
          } else {
            paramMethodVisitor.visitFrame(context.p, context.r, context.s, context.t, context.u);
          }  
        if (i6 > 0) {
          i4 = a(i4, bool1, bool2, context);
          i6--;
          continue;
        } 
        context = null;
      } 
      int i9 = arrayOfByte[paramInt] & 0xFF;
      switch (ClassWriter.a[i9]) {
        case 0:
          paramMethodVisitor.visitInsn(i9);
          paramInt++;
          break;
        case 4:
          if (i9 > 54) {
            i9 -= 59;
            paramMethodVisitor.visitVarInsn(54 + (i9 >> 2), i9 & 0x3);
          } else {
            i9 -= 26;
            paramMethodVisitor.visitVarInsn(21 + (i9 >> 2), i9 & 0x3);
          } 
          paramInt++;
          break;
        case 9:
          paramMethodVisitor.visitJumpInsn(i9, arrayOfLabel[i7 + readShort(paramInt + 1)]);
          paramInt += 3;
          break;
        case 10:
          paramMethodVisitor.visitJumpInsn(i9 - 33, arrayOfLabel[i7 + readInt(paramInt + 1)]);
          paramInt += 5;
          break;
        case 17:
          if ((i9 = arrayOfByte[paramInt + 1] & 0xFF) == 132) {
            paramMethodVisitor.visitIincInsn(readUnsignedShort(paramInt + 2), readShort(paramInt + 4));
            paramInt += 6;
            break;
          } 
          paramMethodVisitor.visitVarInsn(i9, readUnsignedShort(paramInt + 2));
          paramInt += 4;
          break;
        case 14:
          paramInt = paramInt + 4 - (i7 & 0x3);
          i10 = i7 + readInt(paramInt);
          i11 = readInt(paramInt + 4);
          arrayOfLabel1 = new Label[(i12 = readInt(paramInt + 8)) - i11 + 1];
          paramInt += 12;
          for (b = 0; b < arrayOfLabel1.length; b++) {
            arrayOfLabel1[b] = arrayOfLabel[i7 + readInt(paramInt)];
            paramInt += 4;
          } 
          paramMethodVisitor.visitTableSwitchInsn(i11, i12, arrayOfLabel[i10], arrayOfLabel1);
          break;
        case 15:
          paramInt = paramInt + 4 - (i7 & 0x3);
          i10 = i7 + readInt(paramInt);
          arrayOfInt = new int[i11 = readInt(paramInt + 4)];
          arrayOfLabel1 = new Label[i11];
          paramInt += 8;
          for (b = 0; b < i11; b++) {
            arrayOfInt[b] = readInt(paramInt);
            arrayOfLabel1[b] = arrayOfLabel[i7 + readInt(paramInt + 4)];
            paramInt += 8;
          } 
          paramMethodVisitor.visitLookupSwitchInsn(arrayOfLabel[i10], arrayOfInt, arrayOfLabel1);
          break;
        case 3:
          paramMethodVisitor.visitVarInsn(i9, arrayOfByte[paramInt + 1] & 0xFF);
          paramInt += 2;
          break;
        case 1:
          paramMethodVisitor.visitIntInsn(i9, arrayOfByte[paramInt + 1]);
          paramInt += 2;
          break;
        case 2:
          paramMethodVisitor.visitIntInsn(i9, readShort(paramInt + 1));
          paramInt += 3;
          break;
        case 11:
          paramMethodVisitor.visitLdcInsn(readConst(arrayOfByte[paramInt + 1] & 0xFF, arrayOfChar));
          paramInt += 2;
          break;
        case 12:
          paramMethodVisitor.visitLdcInsn(readConst(readUnsignedShort(paramInt + 1), arrayOfChar));
          paramInt += 3;
          break;
        case 6:
        case 7:
          i10 = this.a[readUnsignedShort(paramInt + 1)];
          i11 = (arrayOfByte[i10 - 1] == 11) ? 1 : 0;
          str5 = readClass(i10, arrayOfChar);
          i10 = this.a[readUnsignedShort(i10 + 2)];
          str2 = readUTF8(i10, arrayOfChar);
          str3 = readUTF8(i10 + 2, arrayOfChar);
          if (i9 < 182) {
            paramMethodVisitor.visitFieldInsn(i9, str5, str2, str3);
          } else {
            paramMethodVisitor.visitMethodInsn(i9, str5, str2, str3, i11);
          } 
          if (i9 == 185) {
            paramInt += 5;
            break;
          } 
          paramInt += 3;
          break;
        case 8:
          i10 = this.a[readUnsignedShort(paramInt + 1)];
          i11 = paramContext.d[readUnsignedShort(i10)];
          handle = (Handle)readConst(readUnsignedShort(i11), arrayOfChar);
          arrayOfObject = new Object[i8 = readUnsignedShort(i11 + 2)];
          i11 += 4;
          for (i9 = 0; i9 < i8; i9++) {
            arrayOfObject[i9] = readConst(readUnsignedShort(i11), arrayOfChar);
            i11 += 2;
          } 
          i10 = this.a[readUnsignedShort(i10 + 2)];
          str4 = readUTF8(i10, arrayOfChar);
          str1 = readUTF8(i10 + 2, arrayOfChar);
          paramMethodVisitor.visitInvokeDynamicInsn(str4, str1, handle, arrayOfObject);
          paramInt += 5;
          break;
        case 5:
          paramMethodVisitor.visitTypeInsn(str4, readClass(paramInt + 1, arrayOfChar));
          paramInt += 3;
          break;
        case 13:
          paramMethodVisitor.visitIincInsn(arrayOfByte[paramInt + 1] & 0xFF, arrayOfByte[paramInt + 2]);
          paramInt += 3;
          break;
        default:
          paramMethodVisitor.visitMultiANewArrayInsn(readClass(paramInt + 1, arrayOfChar), arrayOfByte[paramInt + 3] & 0xFF);
          paramInt += 4;
          break;
      } 
      while (arrayOfInt1 != null && b1 < arrayOfInt1.length && b3 <= i7) {
        if (b3 == i7) {
          i10 = a(paramContext, arrayOfInt1[b1]);
          a(i10 + 2, arrayOfChar, true, paramMethodVisitor.visitInsnAnnotation(paramContext.i, paramContext.j, readUTF8(i10, arrayOfChar), true));
        } 
        b3 = (++b1 >= arrayOfInt1.length || readByte(arrayOfInt1[b1]) < 67) ? -1 : readUnsignedShort(arrayOfInt1[b1] + 1);
      } 
      while (arrayOfInt2 != null && b2 < arrayOfInt2.length && b4 <= i7) {
        if (b4 == i7) {
          i10 = a(paramContext, arrayOfInt2[b2]);
          a(i10 + 2, arrayOfChar, true, paramMethodVisitor.visitInsnAnnotation(paramContext.i, paramContext.j, readUTF8(i10, arrayOfChar), false));
        } 
        b4 = (++b2 >= arrayOfInt2.length || readByte(arrayOfInt2[b2]) < 67) ? -1 : readUnsignedShort(arrayOfInt2[b2] + 1);
      } 
    } 
    if (arrayOfLabel[k] != null)
      paramMethodVisitor.visitLabel(arrayOfLabel[k]); 
    if ((paramContext.b & 0x2) == 0 && i2 != 0) {
      int[] arrayOfInt = null;
      if (i3 != 0) {
        paramInt = i3 + 2;
        int i9 = (arrayOfInt = new int[readUnsignedShort(i3) * 3]).length;
        while (i9 > 0) {
          arrayOfInt[--i9] = paramInt + 6;
          arrayOfInt[--i9] = readUnsignedShort(paramInt + 8);
          arrayOfInt[--i9] = readUnsignedShort(paramInt);
          paramInt += 10;
        } 
      } 
      paramInt = i2 + 2;
      for (int i8 = readUnsignedShort(i2); i8 > 0; i8--) {
        int i9 = readUnsignedShort(paramInt);
        int i10 = readUnsignedShort(paramInt + 2);
        int i11 = readUnsignedShort(paramInt + 8);
        String str = null;
        if (arrayOfInt != null)
          for (i5 = 0; i5 < arrayOfInt.length; i5 += 3) {
            if (arrayOfInt[i5] == i9 && arrayOfInt[i5 + 1] == i11) {
              str = readUTF8(arrayOfInt[i5 + 2], arrayOfChar);
              break;
            } 
          }  
        paramMethodVisitor.visitLocalVariable(readUTF8(paramInt + 4, arrayOfChar), readUTF8(paramInt + 6, arrayOfChar), str, arrayOfLabel[i9], arrayOfLabel[i9 + i10], i11);
        paramInt += 10;
      } 
    } 
    if (arrayOfInt1 != null)
      for (i7 = 0; i7 < arrayOfInt1.length; i7++) {
        if (readByte(arrayOfInt1[i7]) >> 1 == 32) {
          int i8 = a(paramContext, arrayOfInt1[i7]);
          a(i8 + 2, arrayOfChar, true, paramMethodVisitor.visitLocalVariableAnnotation(paramContext.i, paramContext.j, paramContext.l, paramContext.m, paramContext.n, readUTF8(i8, arrayOfChar), true));
        } 
      }  
    if (arrayOfInt2 != null)
      for (i7 = 0; i7 < arrayOfInt2.length; i7++) {
        if (readByte(arrayOfInt2[i7]) >> 1 == 32) {
          int i8 = a(paramContext, arrayOfInt2[i7]);
          a(i8 + 2, arrayOfChar, true, paramMethodVisitor.visitLocalVariableAnnotation(paramContext.i, paramContext.j, paramContext.l, paramContext.m, paramContext.n, readUTF8(i8, arrayOfChar), false));
        } 
      }  
    while (attribute != null) {
      Attribute attribute1 = attribute.a;
      attribute.a = null;
      paramMethodVisitor.visitAttribute(attribute);
      attribute = attribute1;
    } 
    paramMethodVisitor.visitMaxs(i, j);
  }
  
  private int[] a(MethodVisitor paramMethodVisitor, Context paramContext, int paramInt, boolean paramBoolean) {
    char[] arrayOfChar = paramContext.c;
    int[] arrayOfInt = new int[readUnsignedShort(paramInt)];
    paramInt += 2;
    for (byte b = 0; b < arrayOfInt.length; b++) {
      arrayOfInt[b] = paramInt;
      int i;
      switch ((i = readInt(paramInt)) >>> 24) {
        case 0:
        case 1:
        case 22:
          paramInt += 2;
          break;
        case 19:
        case 20:
        case 21:
          paramInt++;
          break;
        case 64:
        case 65:
          for (j = readUnsignedShort(paramInt + 1); j > 0; j--) {
            int k = readUnsignedShort(paramInt + 3);
            int m = readUnsignedShort(paramInt + 5);
            readLabel(k, paramContext.h);
            readLabel(k + m, paramContext.h);
            paramInt += 6;
          } 
          paramInt += 3;
          break;
        case 71:
        case 72:
        case 73:
        case 74:
        case 75:
          paramInt += 4;
          break;
        default:
          paramInt += 3;
          break;
      } 
      int j = readByte(paramInt);
      if (i >>> 24 == 66) {
        TypePath typePath = (j == 0) ? null : new TypePath(this.b, paramInt);
        paramInt += 1 + 2 * j;
        paramInt = a(paramInt + 2, arrayOfChar, true, paramMethodVisitor.visitTryCatchAnnotation(i, typePath, readUTF8(paramInt, arrayOfChar), paramBoolean));
      } else {
        paramInt = a(paramInt + 3 + 2 * j, arrayOfChar, true, (AnnotationVisitor)null);
      } 
    } 
    return arrayOfInt;
  }
  
  private int a(Context paramContext, int paramInt) {
    byte b;
    int i;
    switch ((i = readInt(paramInt)) >>> 24) {
      case 0:
      case 1:
      case 22:
        i &= 0xFFFF0000;
        paramInt += 2;
        break;
      case 19:
      case 20:
      case 21:
        i &= 0xFF000000;
        paramInt++;
        break;
      case 64:
      case 65:
        i &= 0xFF000000;
        j = readUnsignedShort(paramInt + 1);
        paramContext.l = new Label[j];
        paramContext.m = new Label[j];
        paramContext.n = new int[j];
        paramInt += 3;
        for (b = 0; b < j; b++) {
          int k = readUnsignedShort(paramInt);
          int m = readUnsignedShort(paramInt + 2);
          paramContext.l[b] = readLabel(k, paramContext.h);
          paramContext.m[b] = readLabel(k + m, paramContext.h);
          paramContext.n[b] = readUnsignedShort(paramInt + 4);
          paramInt += 6;
        } 
        break;
      case 71:
      case 72:
      case 73:
      case 74:
      case 75:
        i &= 0xFF0000FF;
        paramInt += 4;
        break;
      default:
        i &= (i >>> 24 < 67) ? -256 : -16777216;
        paramInt += 3;
        break;
    } 
    int j = readByte(paramInt);
    paramContext.i = i;
    paramContext.j = (j == 0) ? null : new TypePath(this.b, paramInt);
    return paramInt + 1 + 2 * j;
  }
  
  private void b(MethodVisitor paramMethodVisitor, Context paramContext, int paramInt, boolean paramBoolean) {
    int i = this.b[paramInt++] & 0xFF;
    int j = (Type.getArgumentTypes(paramContext.g)).length - i;
    byte b;
    for (b = 0; b < j; b++) {
      AnnotationVisitor annotationVisitor;
      if ((annotationVisitor = paramMethodVisitor.visitParameterAnnotation(b, "Ljava/lang/Synthetic;", false)) != null)
        annotationVisitor.visitEnd(); 
    } 
    char[] arrayOfChar = paramContext.c;
    while (b < i + j) {
      int k = readUnsignedShort(paramInt);
      paramInt += 2;
      while (k > 0) {
        AnnotationVisitor annotationVisitor = paramMethodVisitor.visitParameterAnnotation(b, readUTF8(paramInt, arrayOfChar), paramBoolean);
        paramInt = a(paramInt + 2, arrayOfChar, true, annotationVisitor);
        k--;
      } 
      b++;
    } 
  }
  
  private int a(int paramInt, char[] paramArrayOfchar, boolean paramBoolean, AnnotationVisitor paramAnnotationVisitor) {
    int i = readUnsignedShort(paramInt);
    paramInt += 2;
    if (paramBoolean) {
      while (i > 0) {
        paramInt = a(paramInt + 2, paramArrayOfchar, readUTF8(paramInt, paramArrayOfchar), paramAnnotationVisitor);
        i--;
      } 
    } else {
      while (i > 0) {
        paramInt = a(paramInt, paramArrayOfchar, (String)null, paramAnnotationVisitor);
        i--;
      } 
    } 
    if (paramAnnotationVisitor != null)
      paramAnnotationVisitor.visitEnd(); 
    return paramInt;
  }
  
  private int a(int paramInt, char[] paramArrayOfchar, String paramString, AnnotationVisitor paramAnnotationVisitor) {
    byte[] arrayOfByte;
    boolean[] arrayOfBoolean;
    short[] arrayOfShort;
    char[] arrayOfChar;
    int[] arrayOfInt;
    long[] arrayOfLong;
    float[] arrayOfFloat;
    double[] arrayOfDouble;
    int i;
    byte b;
    if (paramAnnotationVisitor == null) {
      switch (this.b[paramInt] & 0xFF) {
        case 101:
          return paramInt + 5;
        case 64:
          return a(paramInt + 3, paramArrayOfchar, true, (AnnotationVisitor)null);
        case 91:
          return a(paramInt + 1, paramArrayOfchar, false, (AnnotationVisitor)null);
      } 
      return paramInt + 3;
    } 
    switch (this.b[paramInt++] & 0xFF) {
      case 68:
      case 70:
      case 73:
      case 74:
        paramAnnotationVisitor.visit(paramString, readConst(readUnsignedShort(paramInt), paramArrayOfchar));
        paramInt += 2;
        break;
      case 66:
        new Byte();
        super(new Byte());
        paramString.visit((String)new Byte(), new Byte());
        paramInt += 2;
        break;
      case 90:
        paramAnnotationVisitor.visit(paramString, (readInt(this.a[readUnsignedShort(paramInt)]) == 0) ? Boolean.FALSE : Boolean.TRUE);
        paramInt += 2;
        break;
      case 83:
        new Short();
        super(new Short());
        paramString.visit((String)new Short(), new Short());
        paramInt += 2;
        break;
      case 67:
        new Character();
        super(new Character());
        paramString.visit((String)new Character(), new Character());
        paramInt += 2;
        break;
      case 115:
        paramAnnotationVisitor.visit(paramString, readUTF8(paramInt, paramArrayOfchar));
        paramInt += 2;
        break;
      case 101:
        paramAnnotationVisitor.visitEnum(paramString, readUTF8(paramInt, paramArrayOfchar), readUTF8(paramInt + 2, paramArrayOfchar));
        paramInt += 4;
        break;
      case 99:
        paramAnnotationVisitor.visit(paramString, Type.getType(readUTF8(paramInt, paramArrayOfchar)));
        paramInt += 2;
        break;
      case 64:
        paramInt = a(paramInt + 2, paramArrayOfchar, true, paramAnnotationVisitor.visitAnnotation(paramString, readUTF8(paramInt, paramArrayOfchar)));
        break;
      case 91:
        i = readUnsignedShort(paramInt);
        paramInt += 2;
        if (i == 0)
          return a(paramInt - 2, paramArrayOfchar, false, paramAnnotationVisitor.visitArray(paramString)); 
        switch (this.b[paramInt++] & 0xFF) {
          case 66:
            arrayOfByte = new byte[i];
            for (b = 0; b < i; b++) {
              arrayOfByte[b] = (byte)readInt(this.a[readUnsignedShort(paramInt)]);
              paramInt += 3;
            } 
            paramAnnotationVisitor.visit(paramString, arrayOfByte);
            paramInt--;
            break;
          case 90:
            arrayOfBoolean = new boolean[i];
            for (b = 0; b < i; b++) {
              arrayOfBoolean[b] = (readInt(this.a[readUnsignedShort(paramInt)]) != 0);
              paramInt += 3;
            } 
            paramAnnotationVisitor.visit(paramString, arrayOfBoolean);
            paramInt--;
            break;
          case 83:
            arrayOfShort = new short[i];
            for (b = 0; b < i; b++) {
              arrayOfShort[b] = (short)readInt(this.a[readUnsignedShort(paramInt)]);
              paramInt += 3;
            } 
            paramAnnotationVisitor.visit(paramString, arrayOfShort);
            paramInt--;
            break;
          case 67:
            arrayOfChar = new char[i];
            for (b = 0; b < i; b++) {
              arrayOfChar[b] = (char)readInt(this.a[readUnsignedShort(paramInt)]);
              paramInt += 3;
            } 
            paramAnnotationVisitor.visit(paramString, arrayOfChar);
            paramInt--;
            break;
          case 73:
            arrayOfInt = new int[i];
            for (b = 0; b < i; b++) {
              arrayOfInt[b] = readInt(this.a[readUnsignedShort(paramInt)]);
              paramInt += 3;
            } 
            paramAnnotationVisitor.visit(paramString, arrayOfInt);
            paramInt--;
            break;
          case 74:
            arrayOfLong = new long[i];
            for (b = 0; b < i; b++) {
              arrayOfLong[b] = readLong(this.a[readUnsignedShort(paramInt)]);
              paramInt += 3;
            } 
            paramAnnotationVisitor.visit(paramString, arrayOfLong);
            paramInt--;
            break;
          case 70:
            arrayOfFloat = new float[i];
            for (b = 0; b < i; b++) {
              arrayOfFloat[b] = Float.intBitsToFloat(readInt(this.a[readUnsignedShort(paramInt)]));
              paramInt += 3;
            } 
            paramAnnotationVisitor.visit(paramString, arrayOfFloat);
            paramInt--;
            break;
          case 68:
            arrayOfDouble = new double[i];
            for (b = 0; b < i; b++) {
              arrayOfDouble[b] = Double.longBitsToDouble(readLong(this.a[readUnsignedShort(paramInt)]));
              paramInt += 3;
            } 
            paramAnnotationVisitor.visit(paramString, arrayOfDouble);
            paramInt--;
            break;
        } 
        paramInt = a(paramInt - 3, (char[])arrayOfDouble, false, paramAnnotationVisitor.visitArray(paramString));
        break;
    } 
    return paramInt;
  }
  
  private void a(Context paramContext) {
    String str = paramContext.g;
    Object[] arrayOfObject = paramContext.s;
    byte b1 = 0;
    if ((paramContext.e & 0x8) == 0)
      if ("<init>".equals(paramContext.f)) {
        b1++;
        arrayOfObject[0] = Opcodes.UNINITIALIZED_THIS;
      } else {
        b1++;
        arrayOfObject[0] = readClass(this.header + 2, paramContext.c);
      }  
    byte b2 = 1;
    while (true) {
      byte b = b2;
      switch (str.charAt(b2++)) {
        case 'B':
        case 'C':
        case 'I':
        case 'S':
        case 'Z':
          arrayOfObject[b1++] = Opcodes.INTEGER;
          continue;
        case 'F':
          arrayOfObject[b1++] = Opcodes.FLOAT;
          continue;
        case 'J':
          arrayOfObject[b1++] = Opcodes.LONG;
          continue;
        case 'D':
          arrayOfObject[b1++] = Opcodes.DOUBLE;
          continue;
        case '[':
          while (str.charAt(b2) == '[')
            b2++; 
          if (str.charAt(b2) == 'L')
            while (str.charAt(++b2) != ';')
              b2++;  
          arrayOfObject[b1++] = str.substring(b, ++b2);
          continue;
        case 'L':
          while (str.charAt(b2) != ';')
            b2++; 
          arrayOfObject[b1++] = str.substring(b + 1, b2++);
          continue;
      } 
      paramContext.q = b1;
      return;
    } 
  }
  
  private int a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, Context paramContext) {
    char c;
    int i;
    char[] arrayOfChar = paramContext.c;
    Label[] arrayOfLabel = paramContext.h;
    if (paramBoolean1) {
      c = this.b[paramInt++] & 0xFF;
    } else {
      c = 'ÿ';
      paramContext.o = -1;
    } 
    paramContext.r = 0;
    if (c < '@') {
      i = c;
      paramContext.p = 3;
      paramContext.t = 0;
    } else if (c < '') {
      i = c - 64;
      paramInt = a(paramContext.u, 0, paramInt, arrayOfChar, arrayOfLabel);
      paramContext.p = 4;
      paramContext.t = 1;
    } else {
      i = readUnsignedShort(paramInt);
      paramInt += 2;
      if (c == '÷') {
        paramInt = a(paramContext.u, 0, paramInt, arrayOfChar, arrayOfLabel);
        paramContext.p = 4;
        paramContext.t = 1;
      } else if (c >= 'ø' && c < 'û') {
        paramContext.p = 2;
        paramContext.r = 251 - c;
        paramContext.q -= paramContext.r;
        paramContext.t = 0;
      } else if (c == 'û') {
        paramContext.p = 3;
        paramContext.t = 0;
      } else if (c < 'ÿ') {
        paramBoolean2 = paramBoolean2 ? paramContext.q : false;
        for (int j = c - 251; j > 0; j--)
          paramInt = a(paramContext.s, paramBoolean2++, paramInt, arrayOfChar, arrayOfLabel); 
        paramContext.p = 1;
        paramContext.r = c - 251;
        paramContext.q += paramContext.r;
        paramContext.t = 0;
      } else {
        paramContext.p = 0;
        int j = readUnsignedShort(paramInt);
        paramInt += 2;
        paramContext.r = j;
        paramContext.q = j;
        byte b = 0;
        while (j > 0) {
          paramInt = a(paramContext.s, b++, paramInt, arrayOfChar, arrayOfLabel);
          j--;
        } 
        j = readUnsignedShort(paramInt);
        paramInt += 2;
        paramContext.t = j;
        b = 0;
        while (j > 0) {
          paramInt = a(paramContext.u, b++, paramInt, arrayOfChar, arrayOfLabel);
          j--;
        } 
      } 
    } 
    paramContext.o += i + 1;
    readLabel(paramContext.o, arrayOfLabel);
    return paramInt;
  }
  
  private int a(Object[] paramArrayOfObject, int paramInt1, int paramInt2, char[] paramArrayOfchar, Label[] paramArrayOfLabel) {
    int i;
    switch (i = this.b[paramInt2++] & 0xFF) {
      case 0:
        paramArrayOfObject[paramInt1] = Opcodes.TOP;
        return paramInt2;
      case 1:
        paramArrayOfObject[paramInt1] = Opcodes.INTEGER;
        return paramInt2;
      case 2:
        paramArrayOfObject[paramInt1] = Opcodes.FLOAT;
        return paramInt2;
      case 3:
        paramArrayOfObject[paramInt1] = Opcodes.DOUBLE;
        return paramInt2;
      case 4:
        paramArrayOfObject[paramInt1] = Opcodes.LONG;
        return paramInt2;
      case 5:
        paramArrayOfObject[paramInt1] = Opcodes.NULL;
        return paramInt2;
      case 6:
        paramArrayOfObject[paramInt1] = Opcodes.UNINITIALIZED_THIS;
        return paramInt2;
      case 7:
        paramArrayOfObject[paramInt1] = readClass(paramInt2, paramArrayOfchar);
        paramInt2 += 2;
        return paramInt2;
    } 
    paramArrayOfObject[paramInt1] = readLabel(readUnsignedShort(paramInt2), paramArrayOfLabel);
    paramInt2 += 2;
    return paramInt2;
  }
  
  protected Label readLabel(int paramInt, Label[] paramArrayOfLabel) {
    if (paramArrayOfLabel[paramInt] == null)
      paramArrayOfLabel[paramInt] = new Label(); 
    return paramArrayOfLabel[paramInt];
  }
  
  private int a() {
    int i = this.header + 8 + (readUnsignedShort(this.header + 6) << 1);
    int j;
    for (j = readUnsignedShort(i); j > 0; j--) {
      for (int k = readUnsignedShort(i + 8); k > 0; k--)
        i += 6 + readInt(i + 12); 
      i += 8;
    } 
    i += 2;
    for (j = readUnsignedShort(i); j > 0; j--) {
      for (int k = readUnsignedShort(i + 8); k > 0; k--)
        i += 6 + readInt(i + 12); 
      i += 8;
    } 
    return i + 2;
  }
  
  private Attribute a(Attribute[] paramArrayOfAttribute, String paramString, int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3, Label[] paramArrayOfLabel) {
    for (byte b = 0; b < paramArrayOfAttribute.length; b++) {
      if ((paramArrayOfAttribute[b]).type.equals(paramString))
        return paramArrayOfAttribute[b].read(this, paramInt1, paramInt2, paramArrayOfchar, paramInt3, paramArrayOfLabel); 
    } 
    return (new Attribute(paramString)).read(this, paramInt1, paramInt2, null, -1, null);
  }
  
  public int getItemCount() {
    return this.a.length;
  }
  
  public int getItem(int paramInt) {
    return this.a[paramInt];
  }
  
  public int getMaxStringLength() {
    return this.d;
  }
  
  public int readByte(int paramInt) {
    return this.b[paramInt] & 0xFF;
  }
  
  public int readUnsignedShort(int paramInt) {
    byte[] arrayOfByte;
    return ((arrayOfByte = this.b)[paramInt] & 0xFF) << 8 | arrayOfByte[paramInt + 1] & 0xFF;
  }
  
  public short readShort(int paramInt) {
    byte[] arrayOfByte;
    return (short)(((arrayOfByte = this.b)[paramInt] & 0xFF) << 8 | arrayOfByte[paramInt + 1] & 0xFF);
  }
  
  public int readInt(int paramInt) {
    byte[] arrayOfByte;
    return ((arrayOfByte = this.b)[paramInt] & 0xFF) << 24 | (arrayOfByte[paramInt + 1] & 0xFF) << 16 | (arrayOfByte[paramInt + 2] & 0xFF) << 8 | arrayOfByte[paramInt + 3] & 0xFF;
  }
  
  public long readLong(int paramInt) {
    long l1 = readInt(paramInt);
    long l2 = readInt(paramInt + 4) & 0xFFFFFFFFL;
    return l1 << 32L | l2;
  }
  
  public String readUTF8(int paramInt, char[] paramArrayOfchar) {
    int j = readUnsignedShort(paramInt);
    if (paramInt == 0 || j == 0)
      return null; 
    String str;
    if ((str = this.c[j]) != null)
      return str; 
    int i = this.a[j];
    this.c[j] = a(i + 2, readUnsignedShort(i), paramArrayOfchar);
    return a(i + 2, readUnsignedShort(i), paramArrayOfchar);
  }
  
  private String a(int paramInt1, int paramInt2, char[] paramArrayOfchar) {
    paramInt2 = paramInt1 + paramInt2;
    byte[] arrayOfByte = this.b;
    byte b1 = 0;
    byte b2 = 0;
    char c = Character.MIN_VALUE;
    while (paramInt1 < paramInt2) {
      int i;
      byte b = arrayOfByte[paramInt1++];
      switch (b2) {
        case false:
          if ((i = b & 0xFF) < 128) {
            paramArrayOfchar[b1++] = (char)i;
            continue;
          } 
          if (i < 224 && i > 191) {
            c = (char)(i & 0x1F);
            b2 = 1;
            continue;
          } 
          c = (char)(i & 0xF);
          b2 = 2;
        case true:
          paramArrayOfchar[b1++] = (char)(c << 6 | i & 0x3F);
          b2 = 0;
        case true:
          c = (char)(c << 6 | i & 0x3F);
          b2 = 1;
      } 
    } 
    return new String(paramArrayOfchar, 0, b1);
  }
  
  public String readClass(int paramInt, char[] paramArrayOfchar) {
    return readUTF8(this.a[readUnsignedShort(paramInt)], paramArrayOfchar);
  }
  
  public Object readConst(int paramInt, char[] paramArrayOfchar) {
    paramInt = this.a[paramInt];
    switch (this.b[paramInt - 1]) {
      case 3:
        new Integer();
        super(new Integer());
        return new Integer();
      case 4:
        new Float();
        super(new Float());
        return new Float();
      case 5:
        new Long();
        super(new Long());
        return new Long();
      case 6:
        new Double();
        super(new Double());
        return new Double();
      case 7:
        return Type.getObjectType(readUTF8(paramInt, paramArrayOfchar));
      case 8:
        return readUTF8(paramInt, paramArrayOfchar);
      case 16:
        return Type.getMethodType(readUTF8(paramInt, paramArrayOfchar));
    } 
    int i = readByte(paramInt);
    int[] arrayOfInt;
    paramInt = (arrayOfInt = this.a)[readUnsignedShort(paramInt + 1)];
    boolean bool = (this.b[paramInt - 1] == 11) ? true : false;
    String str3 = readClass(paramInt, paramArrayOfchar);
    paramInt = arrayOfInt[readUnsignedShort(paramInt + 2)];
    String str2 = readUTF8(paramInt, paramArrayOfchar);
    String str1 = readUTF8(paramInt + 2, paramArrayOfchar);
    return new Handle(i, str3, str2, str1, bool);
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\asm\ClassReader.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */