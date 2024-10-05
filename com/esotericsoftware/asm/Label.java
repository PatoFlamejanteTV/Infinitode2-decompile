package com.esotericsoftware.asm;

public class Label {
  public Object info;
  
  int a;
  
  int b;
  
  int c;
  
  private int d;
  
  private int[] e;
  
  int f;
  
  int g;
  
  Frame h;
  
  Label i;
  
  Edge j;
  
  Label k;
  
  public int getOffset() {
    if ((this.a & 0x2) == 0)
      throw new IllegalStateException("Label offset position has not been resolved yet"); 
    return this.c;
  }
  
  void a(MethodWriter paramMethodWriter, ByteVector paramByteVector, int paramInt, boolean paramBoolean) {
    if ((this.a & 0x2) == 0) {
      if (paramBoolean) {
        a(-1 - paramInt, paramByteVector.b);
        paramByteVector.putInt(-1);
        return;
      } 
      a(paramInt, paramByteVector.b);
      paramByteVector.putShort(-1);
      return;
    } 
    if (paramBoolean) {
      paramByteVector.putInt(this.c - paramInt);
      return;
    } 
    paramByteVector.putShort(this.c - paramInt);
  }
  
  private void a(int paramInt1, int paramInt2) {
    if (this.e == null)
      this.e = new int[6]; 
    if (this.d >= this.e.length) {
      int[] arrayOfInt = new int[this.e.length + 6];
      System.arraycopy(this.e, 0, arrayOfInt, 0, this.e.length);
      this.e = arrayOfInt;
    } 
    this.e[this.d++] = paramInt1;
    this.e[this.d++] = paramInt2;
  }
  
  boolean a(MethodWriter paramMethodWriter, int paramInt, byte[] paramArrayOfbyte) {
    int i = 0;
    this.a |= 0x2;
    this.c = paramInt;
    byte b = 0;
    while (b < this.d) {
      int j = this.e[b++];
      int k = this.e[b++];
      if (j >= 0) {
        if ((j = paramInt - j) < -32768 || j > 32767) {
          if ((i = paramArrayOfbyte[k - 1] & 0xFF) <= 168) {
            paramArrayOfbyte[k - 1] = (byte)(i + 49);
          } else {
            paramArrayOfbyte[k - 1] = (byte)(i + 20);
          } 
          i = 1;
        } 
        paramArrayOfbyte[k++] = (byte)(j >>> 8);
        paramArrayOfbyte[k] = (byte)j;
        continue;
      } 
      j = paramInt + j + 1;
      paramArrayOfbyte[k++] = (byte)(j >>> 24);
      paramArrayOfbyte[k++] = (byte)(j >>> 16);
      paramArrayOfbyte[k++] = (byte)(j >>> 8);
      paramArrayOfbyte[k] = (byte)j;
    } 
    return i;
  }
  
  Label a() {
    return (this.h == null) ? this : this.h.b;
  }
  
  boolean a(long paramLong) {
    return ((this.a & 0x400) != 0) ? (((this.e[(int)(paramLong >>> 32L)] & (int)paramLong) != 0)) : false;
  }
  
  boolean a(Label paramLabel) {
    if ((this.a & 0x400) == 0 || (paramLabel.a & 0x400) == 0)
      return false; 
    for (byte b = 0; b < this.e.length; b++) {
      if ((this.e[b] & paramLabel.e[b]) != 0)
        return true; 
    } 
    return false;
  }
  
  void a(long paramLong, int paramInt) {
    if ((this.a & 0x400) == 0) {
      this.a |= 0x400;
      this.e = new int[paramInt / 32 + 1];
    } 
    this.e[(int)(paramLong >>> 32L)] = this.e[(int)(paramLong >>> 32L)] | (int)paramLong;
  }
  
  void b(Label paramLabel, long paramLong, int paramInt) {
    Label label = this;
    while (label != null) {
      Label label1;
      label = (label1 = label).k;
      label1.k = null;
      if (paramLabel != null) {
        if ((label1.a & 0x800) == 0) {
          label1.a |= 0x800;
          if ((label1.a & 0x100) != 0 && !label1.a(paramLabel)) {
            Edge edge1;
            (edge1 = new Edge()).a = label1.f;
            edge1.b = paramLabel.j.b;
            edge1.c = label1.j;
            label1.j = edge1;
          } 
        } else {
          continue;
        } 
      } else if (!label1.a(paramLong)) {
        label1.a(paramLong, paramInt);
      } else {
        continue;
      } 
      for (Edge edge = label1.j; edge != null; edge = edge.c) {
        if (((label1.a & 0x80) == 0 || edge != label1.j.c) && edge.b.k == null) {
          edge.b.k = label;
          label = edge.b;
        } 
      } 
    } 
  }
  
  public String toString() {
    return "L" + System.identityHashCode(this);
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\asm\Label.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */