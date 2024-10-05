package com.esotericsoftware.asm;

final class AnnotationWriter extends AnnotationVisitor {
  private final ClassWriter a;
  
  private int b;
  
  private final boolean c;
  
  private final ByteVector d;
  
  private final ByteVector e;
  
  private final int f;
  
  AnnotationWriter g;
  
  AnnotationWriter h;
  
  AnnotationWriter(ClassWriter paramClassWriter, boolean paramBoolean, ByteVector paramByteVector1, ByteVector paramByteVector2, int paramInt) {
    super(327680);
    this.a = paramClassWriter;
    this.c = paramBoolean;
    this.d = paramByteVector1;
    this.e = paramByteVector2;
    this.f = paramInt;
  }
  
  public final void visit(String paramString, Object paramObject) {
    byte b;
    this.b++;
    if (this.c)
      this.d.putShort(this.a.newUTF8(paramString)); 
    if (paramObject instanceof String) {
      this.d.b(115, this.a.newUTF8((String)paramObject));
      return;
    } 
    if (paramObject instanceof Byte) {
      this.d.b(66, (this.a.a(((Byte)paramObject).byteValue())).a);
      return;
    } 
    if (paramObject instanceof Boolean) {
      boolean bool = ((Boolean)paramObject).booleanValue() ? true : false;
      this.d.b(90, (this.a.a(bool)).a);
      return;
    } 
    if (paramObject instanceof Character) {
      this.d.b(67, (this.a.a(((Character)paramObject).charValue())).a);
      return;
    } 
    if (paramObject instanceof Short) {
      this.d.b(83, (this.a.a(((Short)paramObject).shortValue())).a);
      return;
    } 
    if (paramObject instanceof Type) {
      this.d.b(99, this.a.newUTF8(((Type)paramObject).getDescriptor()));
      return;
    } 
    if (paramObject instanceof byte[]) {
      byte[] arrayOfByte = (byte[])paramObject;
      this.d.b(91, arrayOfByte.length);
      for (b = 0; b < arrayOfByte.length; b++)
        this.d.b(66, (this.a.a(arrayOfByte[b])).a); 
      return;
    } 
    if (b instanceof boolean[]) {
      boolean[] arrayOfBoolean = (boolean[])b;
      this.d.b(91, arrayOfBoolean.length);
      for (b = 0; b < arrayOfBoolean.length; b++)
        this.d.b(90, (this.a.a(arrayOfBoolean[b] ? 1 : 0)).a); 
      return;
    } 
    if (b instanceof short[]) {
      short[] arrayOfShort = (short[])b;
      this.d.b(91, arrayOfShort.length);
      for (b = 0; b < arrayOfShort.length; b++)
        this.d.b(83, (this.a.a(arrayOfShort[b])).a); 
      return;
    } 
    if (b instanceof char[]) {
      char[] arrayOfChar = (char[])b;
      this.d.b(91, arrayOfChar.length);
      for (b = 0; b < arrayOfChar.length; b++)
        this.d.b(67, (this.a.a(arrayOfChar[b])).a); 
      return;
    } 
    if (b instanceof int[]) {
      int[] arrayOfInt = (int[])b;
      this.d.b(91, arrayOfInt.length);
      for (b = 0; b < arrayOfInt.length; b++)
        this.d.b(73, (this.a.a(arrayOfInt[b])).a); 
      return;
    } 
    if (b instanceof long[]) {
      long[] arrayOfLong = (long[])b;
      this.d.b(91, arrayOfLong.length);
      for (b = 0; b < arrayOfLong.length; b++)
        this.d.b(74, (this.a.a(arrayOfLong[b])).a); 
      return;
    } 
    if (b instanceof float[]) {
      float[] arrayOfFloat = (float[])b;
      this.d.b(91, arrayOfFloat.length);
      for (b = 0; b < arrayOfFloat.length; b++)
        this.d.b(70, (this.a.a(arrayOfFloat[b])).a); 
      return;
    } 
    if (b instanceof double[]) {
      double[] arrayOfDouble = (double[])b;
      this.d.b(91, arrayOfDouble.length);
      for (b = 0; b < arrayOfDouble.length; b++)
        this.d.b(68, (this.a.a(arrayOfDouble[b])).a); 
      return;
    } 
    Item item = this.a.a(b);
    this.d.b(".s.IFJDCS".charAt(item.b), item.a);
  }
  
  public final void visitEnum(String paramString1, String paramString2, String paramString3) {
    this.b++;
    if (this.c)
      this.d.putShort(this.a.newUTF8(paramString1)); 
    this.d.b(101, this.a.newUTF8(paramString2)).putShort(this.a.newUTF8(paramString3));
  }
  
  public final AnnotationVisitor visitAnnotation(String paramString1, String paramString2) {
    this.b++;
    if (this.c)
      this.d.putShort(this.a.newUTF8(paramString1)); 
    this.d.b(64, this.a.newUTF8(paramString2)).putShort(0);
    return new AnnotationWriter(this.a, true, this.d, this.d, this.d.b - 2);
  }
  
  public final AnnotationVisitor visitArray(String paramString) {
    this.b++;
    if (this.c)
      this.d.putShort(this.a.newUTF8(paramString)); 
    this.d.b(91, 0);
    return new AnnotationWriter(this.a, false, this.d, this.d, this.d.b - 2);
  }
  
  public final void visitEnd() {
    if (this.e != null) {
      byte[] arrayOfByte;
      (arrayOfByte = this.e.a)[this.f] = (byte)(this.b >>> 8);
      arrayOfByte[this.f + 1] = (byte)this.b;
    } 
  }
  
  final int a() {
    int i = 0;
    for (AnnotationWriter annotationWriter = this; annotationWriter != null; annotationWriter = annotationWriter.g)
      i += annotationWriter.d.b; 
    return i;
  }
  
  final void a(ByteVector paramByteVector) {
    byte b = 0;
    int i = 2;
    AnnotationWriter annotationWriter1 = this;
    AnnotationWriter annotationWriter2 = null;
    while (annotationWriter1 != null) {
      b++;
      i += annotationWriter1.d.b;
      annotationWriter1.visitEnd();
      annotationWriter1.h = annotationWriter2;
      annotationWriter2 = annotationWriter1;
      annotationWriter1 = annotationWriter1.g;
    } 
    paramByteVector.putInt(i);
    paramByteVector.putShort(b);
    for (annotationWriter1 = annotationWriter2; annotationWriter1 != null; annotationWriter1 = annotationWriter1.h)
      paramByteVector.putByteArray(annotationWriter1.d.a, 0, annotationWriter1.d.b); 
  }
  
  static void a(AnnotationWriter[] paramArrayOfAnnotationWriter, int paramInt, ByteVector paramByteVector) {
    int i = 1 + 2 * (paramArrayOfAnnotationWriter.length - paramInt);
    int j;
    for (j = paramInt; j < paramArrayOfAnnotationWriter.length; j++)
      i += (paramArrayOfAnnotationWriter[j] == null) ? 0 : paramArrayOfAnnotationWriter[j].a(); 
    paramByteVector.putInt(i).putByte(paramArrayOfAnnotationWriter.length - paramInt);
    for (j = paramInt; j < paramArrayOfAnnotationWriter.length; j++) {
      AnnotationWriter annotationWriter1 = paramArrayOfAnnotationWriter[j];
      AnnotationWriter annotationWriter2 = null;
      byte b = 0;
      while (annotationWriter1 != null) {
        b++;
        annotationWriter1.visitEnd();
        annotationWriter1.h = annotationWriter2;
        annotationWriter2 = annotationWriter1;
        annotationWriter1 = annotationWriter1.g;
      } 
      paramByteVector.putShort(b);
      for (annotationWriter1 = annotationWriter2; annotationWriter1 != null; annotationWriter1 = annotationWriter1.h)
        paramByteVector.putByteArray(annotationWriter1.d.a, 0, annotationWriter1.d.b); 
    } 
  }
  
  static void a(int paramInt, TypePath paramTypePath, ByteVector paramByteVector) {
    switch (paramInt >>> 24) {
      case 0:
      case 1:
      case 22:
        paramByteVector.putShort(paramInt >>> 16);
        break;
      case 19:
      case 20:
      case 21:
        paramByteVector.putByte(paramInt >>> 24);
        break;
      case 71:
      case 72:
      case 73:
      case 74:
      case 75:
        paramByteVector.putInt(paramInt);
        break;
      default:
        paramByteVector.b(paramInt >>> 24, (paramInt & 0xFFFF00) >> 8);
        break;
    } 
    if (paramTypePath == null) {
      paramByteVector.putByte(0);
      return;
    } 
    paramInt = (paramTypePath.a[paramTypePath.b] << 1) + 1;
    paramByteVector.putByteArray(paramTypePath.a, paramTypePath.b, paramInt);
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\asm\AnnotationWriter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */