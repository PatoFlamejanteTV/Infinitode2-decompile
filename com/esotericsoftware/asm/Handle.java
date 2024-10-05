package com.esotericsoftware.asm;

public final class Handle {
  final int a;
  
  final String b;
  
  final String c;
  
  final String d;
  
  final boolean e;
  
  public Handle(int paramInt, String paramString1, String paramString2, String paramString3) {
    this(paramInt, paramString1, paramString2, paramString3, (paramInt == 9));
  }
  
  public Handle(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramBoolean;
  }
  
  public final int getTag() {
    return this.a;
  }
  
  public final String getOwner() {
    return this.b;
  }
  
  public final String getName() {
    return this.c;
  }
  
  public final String getDesc() {
    return this.d;
  }
  
  public final boolean isInterface() {
    return this.e;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Handle))
      return false; 
    paramObject = paramObject;
    return (this.a == ((Handle)paramObject).a && this.e == ((Handle)paramObject).e && this.b.equals(((Handle)paramObject).b) && this.c.equals(((Handle)paramObject).c) && this.d.equals(((Handle)paramObject).d));
  }
  
  public final int hashCode() {
    return this.a + (this.e ? 64 : 0) + this.b.hashCode() * this.c.hashCode() * this.d.hashCode();
  }
  
  public final String toString() {
    return this.b + '.' + this.c + this.d + " (" + this.a + (this.e ? " itf" : "") + ')';
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\asm\Handle.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */