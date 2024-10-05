package com.esotericsoftware.asm;

final class FieldWriter extends FieldVisitor {
  private final ClassWriter b;
  
  private final int c;
  
  private final int d;
  
  private final int e;
  
  private int f;
  
  private int g;
  
  private AnnotationWriter h;
  
  private AnnotationWriter i;
  
  private AnnotationWriter k;
  
  private AnnotationWriter l;
  
  private Attribute j;
  
  FieldWriter(ClassWriter paramClassWriter, int paramInt, String paramString1, String paramString2, String paramString3, Object paramObject) {
    super(327680);
    if (paramClassWriter.B == null) {
      paramClassWriter.B = this;
    } else {
      paramClassWriter.C.fv = this;
    } 
    paramClassWriter.C = this;
    this.b = paramClassWriter;
    this.c = paramInt;
    this.d = paramClassWriter.newUTF8(paramString1);
    this.e = paramClassWriter.newUTF8(paramString2);
    if (paramString3 != null)
      this.f = paramClassWriter.newUTF8(paramString3); 
    if (paramObject != null)
      this.g = (paramClassWriter.a(paramObject)).a; 
  }
  
  public final AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean) {
    ByteVector byteVector;
    (byteVector = new ByteVector()).putShort(this.b.newUTF8(paramString)).putShort(0);
    AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, 2);
    if (paramBoolean) {
      annotationWriter.g = this.h;
      this.h = annotationWriter;
    } else {
      annotationWriter.g = this.i;
      this.i = annotationWriter;
    } 
    return annotationWriter;
  }
  
  public final AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
    ByteVector byteVector = new ByteVector();
    AnnotationWriter.a(paramInt, paramTypePath, byteVector);
    byteVector.putShort(this.b.newUTF8(paramString)).putShort(0);
    AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, byteVector.b - 2);
    if (paramBoolean) {
      annotationWriter.g = this.k;
      this.k = annotationWriter;
    } else {
      annotationWriter.g = this.l;
      this.l = annotationWriter;
    } 
    return annotationWriter;
  }
  
  public final void visitAttribute(Attribute paramAttribute) {
    paramAttribute.a = this.j;
    this.j = paramAttribute;
  }
  
  public final void visitEnd() {}
  
  final int a() {
    int i = 8;
    if (this.g != 0) {
      this.b.newUTF8("ConstantValue");
      i += 8;
    } 
    if ((this.c & 0x1000) != 0 && ((this.b.b & 0xFFFF) < 49 || (this.c & 0x40000) != 0)) {
      this.b.newUTF8("Synthetic");
      i += 6;
    } 
    if ((this.c & 0x20000) != 0) {
      this.b.newUTF8("Deprecated");
      i += 6;
    } 
    if (this.f != 0) {
      this.b.newUTF8("Signature");
      i += 8;
    } 
    if (this.h != null) {
      this.b.newUTF8("RuntimeVisibleAnnotations");
      i += 8 + this.h.a();
    } 
    if (this.i != null) {
      this.b.newUTF8("RuntimeInvisibleAnnotations");
      i += 8 + this.i.a();
    } 
    if (this.k != null) {
      this.b.newUTF8("RuntimeVisibleTypeAnnotations");
      i += 8 + this.k.a();
    } 
    if (this.l != null) {
      this.b.newUTF8("RuntimeInvisibleTypeAnnotations");
      i += 8 + this.l.a();
    } 
    if (this.j != null)
      i += this.j.a(this.b, null, 0, -1, -1); 
    return i;
  }
  
  final void a(ByteVector paramByteVector) {
    int i = 0x60000 | (this.c & 0x40000) / 64;
    paramByteVector.putShort(this.c & (i ^ 0xFFFFFFFF)).putShort(this.d).putShort(this.e);
    i = 0;
    if (this.g != 0)
      i++; 
    if ((this.c & 0x1000) != 0 && ((this.b.b & 0xFFFF) < 49 || (this.c & 0x40000) != 0))
      i++; 
    if ((this.c & 0x20000) != 0)
      i++; 
    if (this.f != 0)
      i++; 
    if (this.h != null)
      i++; 
    if (this.i != null)
      i++; 
    if (this.k != null)
      i++; 
    if (this.l != null)
      i++; 
    if (this.j != null)
      i += this.j.a(); 
    paramByteVector.putShort(i);
    if (this.g != 0) {
      paramByteVector.putShort(this.b.newUTF8("ConstantValue"));
      paramByteVector.putInt(2).putShort(this.g);
    } 
    if ((this.c & 0x1000) != 0 && ((this.b.b & 0xFFFF) < 49 || (this.c & 0x40000) != 0))
      paramByteVector.putShort(this.b.newUTF8("Synthetic")).putInt(0); 
    if ((this.c & 0x20000) != 0)
      paramByteVector.putShort(this.b.newUTF8("Deprecated")).putInt(0); 
    if (this.f != 0) {
      paramByteVector.putShort(this.b.newUTF8("Signature"));
      paramByteVector.putInt(2).putShort(this.f);
    } 
    if (this.h != null) {
      paramByteVector.putShort(this.b.newUTF8("RuntimeVisibleAnnotations"));
      this.h.a(paramByteVector);
    } 
    if (this.i != null) {
      paramByteVector.putShort(this.b.newUTF8("RuntimeInvisibleAnnotations"));
      this.i.a(paramByteVector);
    } 
    if (this.k != null) {
      paramByteVector.putShort(this.b.newUTF8("RuntimeVisibleTypeAnnotations"));
      this.k.a(paramByteVector);
    } 
    if (this.l != null) {
      paramByteVector.putShort(this.b.newUTF8("RuntimeInvisibleTypeAnnotations"));
      this.l.a(paramByteVector);
    } 
    if (this.j != null)
      this.j.a(this.b, null, 0, -1, -1, paramByteVector); 
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\asm\FieldWriter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */