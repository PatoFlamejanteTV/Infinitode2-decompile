package com.esotericsoftware.asm;

public class TypePath {
  public static final int ARRAY_ELEMENT = 0;
  
  public static final int INNER_TYPE = 1;
  
  public static final int WILDCARD_BOUND = 2;
  
  public static final int TYPE_ARGUMENT = 3;
  
  byte[] a;
  
  int b;
  
  TypePath(byte[] paramArrayOfbyte, int paramInt) {
    this.a = paramArrayOfbyte;
    this.b = paramInt;
  }
  
  public int getLength() {
    return this.a[this.b];
  }
  
  public int getStep(int paramInt) {
    return this.a[this.b + 2 * paramInt + 1];
  }
  
  public int getStepArgument(int paramInt) {
    return this.a[this.b + 2 * paramInt + 2];
  }
  
  public static TypePath fromString(String paramString) {
    if (paramString == null || paramString.length() == 0)
      return null; 
    int i = paramString.length();
    ByteVector byteVector;
    (byteVector = new ByteVector(i)).putByte(0);
    byte b = 0;
    while (b < i) {
      char c;
      if ((c = paramString.charAt(b++)) == '[') {
        byteVector.a(0, 0);
        continue;
      } 
      if (c == '.') {
        byteVector.a(1, 0);
        continue;
      } 
      if (c == '*') {
        byteVector.a(2, 0);
        continue;
      } 
      if (c >= '0' && c <= '9') {
        int j = c - 48;
        while (b < i && (c = paramString.charAt(b)) >= '0' && c <= '9') {
          j = j * 10 + c - 48;
          b++;
        } 
        if (b < i && paramString.charAt(b) == ';')
          b++; 
        byteVector.a(3, j);
      } 
    } 
    byteVector.a[0] = (byte)(byteVector.b / 2);
    return new TypePath(byteVector.a, 0);
  }
  
  public String toString() {
    int i = getLength();
    StringBuffer stringBuffer = new StringBuffer(i << 1);
    for (byte b = 0; b < i; b++) {
      switch (getStep(b)) {
        case 0:
          stringBuffer.append('[');
          break;
        case 1:
          stringBuffer.append('.');
          break;
        case 2:
          stringBuffer.append('*');
          break;
        case 3:
          stringBuffer.append(getStepArgument(b)).append(';');
          break;
        default:
          stringBuffer.append('_');
          break;
      } 
    } 
    return stringBuffer.toString();
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\asm\TypePath.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */