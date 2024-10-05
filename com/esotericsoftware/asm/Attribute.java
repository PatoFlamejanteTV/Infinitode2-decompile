package com.esotericsoftware.asm;

public class Attribute {
  public final String type;
  
  byte[] b;
  
  Attribute a;
  
  protected Attribute(String paramString) {
    this.type = paramString;
  }
  
  public boolean isUnknown() {
    return true;
  }
  
  public boolean isCodeAttribute() {
    return false;
  }
  
  protected Label[] getLabels() {
    return null;
  }
  
  protected Attribute read(ClassReader paramClassReader, int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3, Label[] paramArrayOfLabel) {
    Attribute attribute;
    (attribute = new Attribute(this.type)).b = new byte[paramInt2];
    System.arraycopy(paramClassReader.b, paramInt1, attribute.b, 0, paramInt2);
    return attribute;
  }
  
  protected ByteVector write(ClassWriter paramClassWriter, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    ByteVector byteVector;
    (byteVector = new ByteVector()).a = this.b;
    byteVector.b = this.b.length;
    return byteVector;
  }
  
  final int a() {
    byte b = 0;
    for (Attribute attribute = this; attribute != null; attribute = attribute.a)
      b++; 
    return b;
  }
  
  final int a(ClassWriter paramClassWriter, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    Attribute attribute = this;
    int i = 0;
    while (attribute != null) {
      paramClassWriter.newUTF8(attribute.type);
      i += (attribute.write(paramClassWriter, paramArrayOfbyte, paramInt1, paramInt2, paramInt3)).b + 6;
      attribute = attribute.a;
    } 
    return i;
  }
  
  final void a(ClassWriter paramClassWriter, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, ByteVector paramByteVector) {
    for (Attribute attribute = this; attribute != null; attribute = attribute.a) {
      ByteVector byteVector = attribute.write(paramClassWriter, paramArrayOfbyte, paramInt1, paramInt2, paramInt3);
      paramByteVector.putShort(paramClassWriter.newUTF8(attribute.type)).putInt(byteVector.b);
      paramByteVector.putByteArray(byteVector.a, 0, byteVector.b);
    } 
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\asm\Attribute.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */