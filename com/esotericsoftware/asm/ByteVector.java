package com.esotericsoftware.asm;

public class ByteVector {
  byte[] a = new byte[64];
  
  int b;
  
  public ByteVector() {}
  
  public ByteVector(int paramInt) {}
  
  public ByteVector putByte(int paramInt) {
    int i;
    if ((i = this.b) + 1 > this.a.length)
      a(1); 
    this.a[i++] = (byte)paramInt;
    this.b = i;
    return this;
  }
  
  ByteVector a(int paramInt1, int paramInt2) {
    int i;
    if ((i = this.b) + 2 > this.a.length)
      a(2); 
    byte[] arrayOfByte;
    (arrayOfByte = this.a)[i++] = (byte)paramInt1;
    arrayOfByte[i++] = (byte)paramInt2;
    this.b = i;
    return this;
  }
  
  public ByteVector putShort(int paramInt) {
    int i;
    if ((i = this.b) + 2 > this.a.length)
      a(2); 
    byte[] arrayOfByte;
    (arrayOfByte = this.a)[i++] = (byte)(paramInt >>> 8);
    arrayOfByte[i++] = (byte)paramInt;
    this.b = i;
    return this;
  }
  
  ByteVector b(int paramInt1, int paramInt2) {
    int i;
    if ((i = this.b) + 3 > this.a.length)
      a(3); 
    byte[] arrayOfByte;
    (arrayOfByte = this.a)[i++] = (byte)paramInt1;
    arrayOfByte[i++] = (byte)(paramInt2 >>> 8);
    arrayOfByte[i++] = (byte)paramInt2;
    this.b = i;
    return this;
  }
  
  public ByteVector putInt(int paramInt) {
    int i;
    if ((i = this.b) + 4 > this.a.length)
      a(4); 
    byte[] arrayOfByte;
    (arrayOfByte = this.a)[i++] = (byte)(paramInt >>> 24);
    arrayOfByte[i++] = (byte)(paramInt >>> 16);
    arrayOfByte[i++] = (byte)(paramInt >>> 8);
    arrayOfByte[i++] = (byte)paramInt;
    this.b = i;
    return this;
  }
  
  public ByteVector putLong(long paramLong) {
    int i;
    if ((i = this.b) + 8 > this.a.length)
      a(8); 
    byte[] arrayOfByte = this.a;
    int j = (int)(paramLong >>> 32L);
    arrayOfByte[i++] = (byte)(j >>> 24);
    arrayOfByte[i++] = (byte)(j >>> 16);
    arrayOfByte[i++] = (byte)(j >>> 8);
    arrayOfByte[i++] = (byte)j;
    j = (int)paramLong;
    arrayOfByte[i++] = (byte)(j >>> 24);
    arrayOfByte[i++] = (byte)(j >>> 16);
    arrayOfByte[i++] = (byte)(j >>> 8);
    arrayOfByte[i++] = (byte)j;
    this.b = i;
    return this;
  }
  
  public ByteVector putUTF8(String paramString) {
    int i;
    if ((i = paramString.length()) > 65535)
      throw new IllegalArgumentException(); 
    int j;
    if ((j = this.b) + 2 + i > this.a.length)
      a(i + 2); 
    byte[] arrayOfByte;
    (arrayOfByte = this.a)[j++] = (byte)(i >>> 8);
    arrayOfByte[j++] = (byte)i;
    for (byte b = 0; b < i; b++) {
      char c;
      if ((c = paramString.charAt(b)) > '\000' && c <= '') {
        arrayOfByte[j++] = (byte)c;
      } else {
        this.b = j;
        return c(paramString, b, 65535);
      } 
    } 
    this.b = j;
    return this;
  }
  
  ByteVector c(String paramString, int paramInt1, int paramInt2) {
    int i = paramString.length();
    int j = paramInt1;
    int k;
    for (k = paramInt1; k < i; k++) {
      char c;
      if ((c = paramString.charAt(k)) > '\000' && c <= '') {
        j++;
      } else if (c > '߿') {
        j += 3;
      } else {
        j += 2;
      } 
    } 
    if (j > paramInt2)
      throw new IllegalArgumentException(); 
    if ((k = this.b - paramInt1 - 2) >= 0) {
      this.a[k] = (byte)(j >>> 8);
      this.a[k + 1] = (byte)j;
    } 
    if (this.b + j - paramInt1 > this.a.length)
      a(j - paramInt1); 
    paramInt2 = this.b;
    for (paramInt1 = paramInt1; paramInt1 < i; paramInt1++) {
      char c;
      if ((c = paramString.charAt(paramInt1)) > '\000' && c <= '') {
        this.a[paramInt2++] = (byte)c;
      } else if (c > '߿') {
        this.a[paramInt2++] = (byte)(0xE0 | c >> 12 & 0xF);
        this.a[paramInt2++] = (byte)(0x80 | c >> 6 & 0x3F);
        this.a[paramInt2++] = (byte)(0x80 | c & 0x3F);
      } else {
        this.a[paramInt2++] = (byte)(0xC0 | c >> 6 & 0x1F);
        this.a[paramInt2++] = (byte)(0x80 | c & 0x3F);
      } 
    } 
    this.b = paramInt2;
    return this;
  }
  
  public ByteVector putByteArray(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (this.b + paramInt2 > this.a.length)
      a(paramInt2); 
    if (paramArrayOfbyte != null)
      System.arraycopy(paramArrayOfbyte, paramInt1, this.a, this.b, paramInt2); 
    this.b += paramInt2;
    return this;
  }
  
  private void a(int paramInt) {
    int i = 2 * this.a.length;
    paramInt = this.b + paramInt;
    byte[] arrayOfByte = new byte[(i > paramInt) ? i : paramInt];
    System.arraycopy(this.a, 0, arrayOfByte, 0, this.b);
    this.a = arrayOfByte;
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\asm\ByteVector.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */