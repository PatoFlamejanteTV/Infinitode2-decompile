package com.esotericsoftware.asm;

final class Item {
  int a;
  
  int b;
  
  int c;
  
  long d;
  
  String g;
  
  String h;
  
  String i;
  
  int j;
  
  Item k;
  
  Item() {}
  
  Item(int paramInt) {
    this.a = paramInt;
  }
  
  Item(int paramInt, Item paramItem) {
    this.a = paramInt;
    this.b = paramItem.b;
    this.c = paramItem.c;
    this.d = paramItem.d;
    this.g = paramItem.g;
    this.h = paramItem.h;
    this.i = paramItem.i;
    this.j = paramItem.j;
  }
  
  final void a(int paramInt) {
    this.b = 3;
    this.c = paramInt;
    this.j = Integer.MAX_VALUE & this.b + paramInt;
  }
  
  final void a(long paramLong) {
    this.b = 5;
    this.d = paramLong;
    this.j = Integer.MAX_VALUE & this.b + (int)paramLong;
  }
  
  final void a(float paramFloat) {
    this.b = 4;
    this.c = Float.floatToRawIntBits(paramFloat);
    this.j = Integer.MAX_VALUE & this.b + (int)paramFloat;
  }
  
  final void a(double paramDouble) {
    this.b = 6;
    this.d = Double.doubleToRawLongBits(paramDouble);
    this.j = Integer.MAX_VALUE & this.b + (int)paramDouble;
  }
  
  final void a(int paramInt, String paramString1, String paramString2, String paramString3) {
    this.b = paramInt;
    this.g = paramString1;
    this.h = paramString2;
    this.i = paramString3;
    switch (paramInt) {
      case 7:
        this.c = 0;
      case 1:
      case 8:
      case 16:
      case 30:
        this.j = Integer.MAX_VALUE & paramInt + paramString1.hashCode();
        return;
      case 12:
        this.j = Integer.MAX_VALUE & paramInt + paramString1.hashCode() * paramString2.hashCode();
        return;
    } 
    this.j = Integer.MAX_VALUE & paramInt + paramString1.hashCode() * paramString2.hashCode() * paramString3.hashCode();
  }
  
  final void a(String paramString1, String paramString2, int paramInt) {
    this.b = 18;
    this.d = paramInt;
    this.g = paramString1;
    this.h = paramString2;
    this.j = Integer.MAX_VALUE & 18 + paramInt * this.g.hashCode() * this.h.hashCode();
  }
  
  final void a(int paramInt1, int paramInt2) {
    this.b = 33;
    this.c = paramInt1;
    this.j = paramInt2;
  }
  
  final boolean a(Item paramItem) {
    switch (this.b) {
      case 1:
      case 7:
      case 8:
      case 16:
      case 30:
        return paramItem.g.equals(this.g);
      case 5:
      case 6:
      case 32:
        return (paramItem.d == this.d);
      case 3:
      case 4:
        return (paramItem.c == this.c);
      case 31:
        return (paramItem.c == this.c && paramItem.g.equals(this.g));
      case 12:
        return (paramItem.g.equals(this.g) && paramItem.h.equals(this.h));
      case 18:
        return (paramItem.d == this.d && paramItem.g.equals(this.g) && paramItem.h.equals(this.h));
    } 
    return (paramItem.g.equals(this.g) && paramItem.h.equals(this.h) && paramItem.i.equals(this.i));
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\asm\Item.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */