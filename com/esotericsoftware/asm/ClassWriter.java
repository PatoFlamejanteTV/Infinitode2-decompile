package com.esotericsoftware.asm;

public class ClassWriter extends ClassVisitor {
  public static final int COMPUTE_MAXS = 1;
  
  public static final int COMPUTE_FRAMES = 2;
  
  static final byte[] a;
  
  ClassReader M;
  
  int b;
  
  int c = 1;
  
  final ByteVector d = new ByteVector();
  
  Item[] e = new Item[256];
  
  int f = (int)(0.75D * this.e.length);
  
  final Item g = new Item();
  
  final Item h = new Item();
  
  final Item i = new Item();
  
  final Item j = new Item();
  
  Item[] H;
  
  private short G;
  
  private int k;
  
  private int l;
  
  String I;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private int[] p;
  
  private int q;
  
  private ByteVector r;
  
  private int s;
  
  private int t;
  
  private AnnotationWriter u;
  
  private AnnotationWriter v;
  
  private AnnotationWriter N;
  
  private AnnotationWriter O;
  
  private Attribute w;
  
  private int x;
  
  private ByteVector y;
  
  int z;
  
  ByteVector A;
  
  FieldWriter B;
  
  FieldWriter C;
  
  MethodWriter D;
  
  MethodWriter E;
  
  private boolean K;
  
  private boolean J;
  
  boolean L;
  
  public ClassWriter(int paramInt) {
    super(327680);
    this.K = ((paramInt & 0x1) != 0);
    this.J = ((paramInt & 0x2) != 0);
  }
  
  public ClassWriter(ClassReader paramClassReader, int paramInt) {
    this(paramInt);
    paramClassReader.a(this);
    this.M = paramClassReader;
  }
  
  public final void visit(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString) {
    this.b = paramInt1;
    this.k = paramInt2;
    this.l = newClass(paramString1);
    this.I = paramString1;
    if (paramString2 != null)
      this.m = newUTF8(paramString2); 
    this.n = (paramString3 == null) ? 0 : newClass(paramString3);
    if (paramArrayOfString != null && paramArrayOfString.length > 0) {
      this.o = paramArrayOfString.length;
      this.p = new int[this.o];
      for (paramInt1 = 0; paramInt1 < this.o; paramInt1++)
        this.p[paramInt1] = newClass(paramArrayOfString[paramInt1]); 
    } 
  }
  
  public final void visitSource(String paramString1, String paramString2) {
    if (paramString1 != null)
      this.q = newUTF8(paramString1); 
    if (paramString2 != null)
      this.r = (new ByteVector()).c(paramString2, 0, 2147483647); 
  }
  
  public final void visitOuterClass(String paramString1, String paramString2, String paramString3) {
    this.s = newClass(paramString1);
    if (paramString2 != null && paramString3 != null)
      this.t = newNameType(paramString2, paramString3); 
  }
  
  public final AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean) {
    ByteVector byteVector;
    (byteVector = new ByteVector()).putShort(newUTF8(paramString)).putShort(0);
    AnnotationWriter annotationWriter = new AnnotationWriter(this, true, byteVector, byteVector, 2);
    if (paramBoolean) {
      annotationWriter.g = this.u;
      this.u = annotationWriter;
    } else {
      annotationWriter.g = this.v;
      this.v = annotationWriter;
    } 
    return annotationWriter;
  }
  
  public final AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
    ByteVector byteVector = new ByteVector();
    AnnotationWriter.a(paramInt, paramTypePath, byteVector);
    byteVector.putShort(newUTF8(paramString)).putShort(0);
    AnnotationWriter annotationWriter = new AnnotationWriter(this, true, byteVector, byteVector, byteVector.b - 2);
    if (paramBoolean) {
      annotationWriter.g = this.N;
      this.N = annotationWriter;
    } else {
      annotationWriter.g = this.O;
      this.O = annotationWriter;
    } 
    return annotationWriter;
  }
  
  public final void visitAttribute(Attribute paramAttribute) {
    paramAttribute.a = this.w;
    this.w = paramAttribute;
  }
  
  public final void visitInnerClass(String paramString1, String paramString2, String paramString3, int paramInt) {
    if (this.y == null)
      this.y = new ByteVector(); 
    Item item;
    if ((item = a(paramString1)).c == 0) {
      this.x++;
      this.y.putShort(item.a);
      this.y.putShort((paramString2 == null) ? 0 : newClass(paramString2));
      this.y.putShort((paramString3 == null) ? 0 : newUTF8(paramString3));
      this.y.putShort(paramInt);
      item.c = this.x;
    } 
  }
  
  public final FieldVisitor visitField(int paramInt, String paramString1, String paramString2, String paramString3, Object paramObject) {
    return new FieldWriter(this, paramInt, paramString1, paramString2, paramString3, paramObject);
  }
  
  public final MethodVisitor visitMethod(int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString) {
    return new MethodWriter(this, paramInt, paramString1, paramString2, paramString3, paramArrayOfString, this.K, this.J);
  }
  
  public final void visitEnd() {}
  
  public byte[] toByteArray() {
    if (this.c > 65535)
      throw new RuntimeException("Class file too large!"); 
    int i = 24 + 2 * this.o;
    byte b1 = 0;
    for (FieldWriter fieldWriter2 = this.B; fieldWriter2 != null; fieldWriter2 = (FieldWriter)fieldWriter2.fv) {
      b1++;
      i += fieldWriter2.a();
    } 
    byte b2 = 0;
    for (MethodWriter methodWriter2 = this.D; methodWriter2 != null; methodWriter2 = (MethodWriter)methodWriter2.mv) {
      b2++;
      i += methodWriter2.a();
    } 
    int k = 0;
    if (this.A != null) {
      k++;
      i += 8 + this.A.b;
      newUTF8("BootstrapMethods");
    } 
    if (this.m != 0) {
      k++;
      i += 8;
      newUTF8("Signature");
    } 
    if (this.q != 0) {
      k++;
      i += 8;
      newUTF8("SourceFile");
    } 
    if (this.r != null) {
      k++;
      i += this.r.b + 6;
      newUTF8("SourceDebugExtension");
    } 
    if (this.s != 0) {
      k++;
      i += 10;
      newUTF8("EnclosingMethod");
    } 
    if ((this.k & 0x20000) != 0) {
      k++;
      i += 6;
      newUTF8("Deprecated");
    } 
    if ((this.k & 0x1000) != 0 && ((this.b & 0xFFFF) < 49 || (this.k & 0x40000) != 0)) {
      k++;
      i += 6;
      newUTF8("Synthetic");
    } 
    if (this.y != null) {
      k++;
      i += 8 + this.y.b;
      newUTF8("InnerClasses");
    } 
    if (this.u != null) {
      k++;
      i += 8 + this.u.a();
      newUTF8("RuntimeVisibleAnnotations");
    } 
    if (this.v != null) {
      k++;
      i += 8 + this.v.a();
      newUTF8("RuntimeInvisibleAnnotations");
    } 
    if (this.N != null) {
      k++;
      i += 8 + this.N.a();
      newUTF8("RuntimeVisibleTypeAnnotations");
    } 
    if (this.O != null) {
      k++;
      i += 8 + this.O.a();
      newUTF8("RuntimeInvisibleTypeAnnotations");
    } 
    if (this.w != null) {
      k += this.w.a();
      i += this.w.a(this, null, 0, -1, -1);
    } 
    i += this.d.b;
    ByteVector byteVector;
    (byteVector = new ByteVector(i)).putInt(-889275714).putInt(this.b);
    byteVector.putShort(this.c).putByteArray(this.d.a, 0, this.d.b);
    int j = 0x60000 | (this.k & 0x40000) / 64;
    byteVector.putShort(this.k & (j ^ 0xFFFFFFFF)).putShort(this.l).putShort(this.n);
    byteVector.putShort(this.o);
    for (j = 0; j < this.o; j++)
      byteVector.putShort(this.p[j]); 
    byteVector.putShort(b1);
    for (FieldWriter fieldWriter1 = this.B; fieldWriter1 != null; fieldWriter1 = (FieldWriter)fieldWriter1.fv)
      fieldWriter1.a(byteVector); 
    byteVector.putShort(b2);
    for (MethodWriter methodWriter1 = this.D; methodWriter1 != null; methodWriter1 = (MethodWriter)methodWriter1.mv)
      methodWriter1.a(byteVector); 
    byteVector.putShort(k);
    if (this.A != null) {
      byteVector.putShort(newUTF8("BootstrapMethods"));
      byteVector.putInt(this.A.b + 2).putShort(this.z);
      byteVector.putByteArray(this.A.a, 0, this.A.b);
    } 
    if (this.m != 0)
      byteVector.putShort(newUTF8("Signature")).putInt(2).putShort(this.m); 
    if (this.q != 0)
      byteVector.putShort(newUTF8("SourceFile")).putInt(2).putShort(this.q); 
    if (this.r != null) {
      int m = this.r.b;
      byteVector.putShort(newUTF8("SourceDebugExtension")).putInt(m);
      byteVector.putByteArray(this.r.a, 0, m);
    } 
    if (this.s != 0) {
      byteVector.putShort(newUTF8("EnclosingMethod")).putInt(4);
      byteVector.putShort(this.s).putShort(this.t);
    } 
    if ((this.k & 0x20000) != 0)
      byteVector.putShort(newUTF8("Deprecated")).putInt(0); 
    if ((this.k & 0x1000) != 0 && ((this.b & 0xFFFF) < 49 || (this.k & 0x40000) != 0))
      byteVector.putShort(newUTF8("Synthetic")).putInt(0); 
    if (this.y != null) {
      byteVector.putShort(newUTF8("InnerClasses"));
      byteVector.putInt(this.y.b + 2).putShort(this.x);
      byteVector.putByteArray(this.y.a, 0, this.y.b);
    } 
    if (this.u != null) {
      byteVector.putShort(newUTF8("RuntimeVisibleAnnotations"));
      this.u.a(byteVector);
    } 
    if (this.v != null) {
      byteVector.putShort(newUTF8("RuntimeInvisibleAnnotations"));
      this.v.a(byteVector);
    } 
    if (this.N != null) {
      byteVector.putShort(newUTF8("RuntimeVisibleTypeAnnotations"));
      this.N.a(byteVector);
    } 
    if (this.O != null) {
      byteVector.putShort(newUTF8("RuntimeInvisibleTypeAnnotations"));
      this.O.a(byteVector);
    } 
    if (this.w != null)
      this.w.a(this, null, 0, -1, -1, byteVector); 
    if (this.L) {
      this.u = null;
      this.v = null;
      this.w = null;
      this.x = 0;
      this.y = null;
      this.z = 0;
      this.A = null;
      this.B = null;
      this.C = null;
      this.D = null;
      this.E = null;
      this.K = false;
      this.J = true;
      this.L = false;
      (new ClassReader(byteVector.a)).accept(this, 4);
      return toByteArray();
    } 
    return byteVector.a;
  }
  
  Item a(Object paramObject) {
    int i;
    float f;
    Type type;
    Handle handle;
    if (paramObject instanceof Integer) {
      i = ((Integer)paramObject).intValue();
      return a(i);
    } 
    if (i instanceof Byte) {
      i = ((Byte)i).intValue();
      return a(i);
    } 
    if (i instanceof Character) {
      i = ((Character)i).charValue();
      return a(i);
    } 
    if (i instanceof Short) {
      i = ((Short)i).intValue();
      return a(i);
    } 
    if (i instanceof Boolean) {
      i = ((Boolean)i).booleanValue() ? 1 : 0;
      return a(i);
    } 
    if (i instanceof Float) {
      f = ((Float)i).floatValue();
      return a(f);
    } 
    if (f instanceof Long) {
      long l = ((Long)f).longValue();
      return a(l);
    } 
    if (f instanceof Double) {
      double d = ((Double)f).doubleValue();
      return a(d);
    } 
    if (f instanceof String)
      return b((String)f); 
    if (f instanceof Type) {
      int j;
      return ((j = (type = (Type)f).getSort()) == 10) ? a(type.getInternalName()) : ((j == 11) ? c(type.getDescriptor()) : a(type.getDescriptor()));
    } 
    if (type instanceof Handle) {
      handle = (Handle)type;
      return a(handle.a, handle.b, handle.c, handle.d, handle.e);
    } 
    throw new IllegalArgumentException("value " + handle);
  }
  
  public int newConst(Object paramObject) {
    return (a(paramObject)).a;
  }
  
  public int newUTF8(String paramString) {
    this.g.a(1, paramString, null, null);
    Item item;
    if ((item = a(this.g)) == null) {
      this.d.putByte(1).putUTF8(paramString);
      item = new Item(this.c++, this.g);
      b(item);
    } 
    return item.a;
  }
  
  Item a(String paramString) {
    this.h.a(7, paramString, null, null);
    Item item;
    if ((item = a(this.h)) == null) {
      this.d.b(7, newUTF8(paramString));
      item = new Item(this.c++, this.h);
      b(item);
    } 
    return item;
  }
  
  public int newClass(String paramString) {
    return (a(paramString)).a;
  }
  
  Item c(String paramString) {
    this.h.a(16, paramString, null, null);
    Item item;
    if ((item = a(this.h)) == null) {
      this.d.b(16, newUTF8(paramString));
      item = new Item(this.c++, this.h);
      b(item);
    } 
    return item;
  }
  
  public int newMethodType(String paramString) {
    return (c(paramString)).a;
  }
  
  Item a(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    this.j.a(paramInt + 20, paramString1, paramString2, paramString3);
    Item item;
    if ((item = a(this.j)) == null) {
      if (paramInt <= 4) {
        b(15, paramInt, newField(paramString1, paramString2, paramString3));
      } else {
        b(15, paramInt, newMethod(paramString1, paramString2, paramString3, paramBoolean));
      } 
      item = new Item(this.c++, this.j);
      b(item);
    } 
    return item;
  }
  
  public int newHandle(int paramInt, String paramString1, String paramString2, String paramString3) {
    return newHandle(paramInt, paramString1, paramString2, paramString3, (paramInt == 9));
  }
  
  public int newHandle(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    return (a(paramInt, paramString1, paramString2, paramString3, paramBoolean)).a;
  }
  
  Item a(String paramString1, String paramString2, Handle paramHandle, Object... paramVarArgs) {
    int j;
    ByteVector byteVector;
    if ((byteVector = this.A) == null)
      byteVector = this.A = new ByteVector(); 
    int k = byteVector.b;
    int m = paramHandle.hashCode();
    byteVector.putShort(newHandle(paramHandle.a, paramHandle.b, paramHandle.c, paramHandle.d, paramHandle.isInterface()));
    int i = paramVarArgs.length;
    byteVector.putShort(i);
    for (byte b = 0; b < i; b++) {
      Object object = paramVarArgs[b];
      m ^= object.hashCode();
      byteVector.putShort(newConst(object));
    } 
    byte[] arrayOfByte = byteVector.a;
    int n = i + 2 << 1;
    m &= Integer.MAX_VALUE;
    Item item = this.e[m % this.e.length];
    label32: while (item != null) {
      if (item.b != 33 || item.j != m) {
        item = item.k;
        continue;
      } 
      j = item.c;
      for (byte b1 = 0; b1 < n; b1++) {
        if (arrayOfByte[k + b1] != arrayOfByte[j + b1]) {
          item = item.k;
          continue label32;
        } 
      } 
    } 
    if (item != null) {
      j = item.a;
      byteVector.b = k;
    } else {
      j = this.z++;
      (item = new Item(j)).a(k, m);
      b(item);
    } 
    this.i.a(paramString1, paramString2, j);
    if ((item = a(this.i)) == null) {
      a(18, j, newNameType(paramString1, paramString2));
      item = new Item(this.c++, this.i);
      b(item);
    } 
    return item;
  }
  
  public int newInvokeDynamic(String paramString1, String paramString2, Handle paramHandle, Object... paramVarArgs) {
    return (a(paramString1, paramString2, paramHandle, paramVarArgs)).a;
  }
  
  Item a(String paramString1, String paramString2, String paramString3) {
    this.i.a(9, paramString1, paramString2, paramString3);
    Item item;
    if ((item = a(this.i)) == null) {
      a(9, newClass(paramString1), newNameType(paramString2, paramString3));
      item = new Item(this.c++, this.i);
      b(item);
    } 
    return item;
  }
  
  public int newField(String paramString1, String paramString2, String paramString3) {
    return (a(paramString1, paramString2, paramString3)).a;
  }
  
  Item a(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    byte b = paramBoolean ? 11 : 10;
    this.i.a(b, paramString1, paramString2, paramString3);
    Item item;
    if ((item = a(this.i)) == null) {
      a(b, newClass(paramString1), newNameType(paramString2, paramString3));
      item = new Item(this.c++, this.i);
      b(item);
    } 
    return item;
  }
  
  public int newMethod(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    return (a(paramString1, paramString2, paramString3, paramBoolean)).a;
  }
  
  Item a(int paramInt) {
    this.g.a(paramInt);
    Item item;
    if ((item = a(this.g)) == null) {
      this.d.putByte(3).putInt(paramInt);
      item = new Item(this.c++, this.g);
      b(item);
    } 
    return item;
  }
  
  Item a(float paramFloat) {
    this.g.a(paramFloat);
    Item item;
    if ((item = a(this.g)) == null) {
      this.d.putByte(4).putInt(this.g.c);
      item = new Item(this.c++, this.g);
      b(item);
    } 
    return item;
  }
  
  Item a(long paramLong) {
    this.g.a(paramLong);
    Item item;
    if ((item = a(this.g)) == null) {
      this.d.putByte(5).putLong(paramLong);
      item = new Item(this.c, this.g);
      this.c += 2;
      b(item);
    } 
    return item;
  }
  
  Item a(double paramDouble) {
    this.g.a(paramDouble);
    Item item;
    if ((item = a(this.g)) == null) {
      this.d.putByte(6).putLong(this.g.d);
      item = new Item(this.c, this.g);
      this.c += 2;
      b(item);
    } 
    return item;
  }
  
  private Item b(String paramString) {
    this.h.a(8, paramString, null, null);
    Item item;
    if ((item = a(this.h)) == null) {
      this.d.b(8, newUTF8(paramString));
      item = new Item(this.c++, this.h);
      b(item);
    } 
    return item;
  }
  
  public int newNameType(String paramString1, String paramString2) {
    return (a(paramString1, paramString2)).a;
  }
  
  Item a(String paramString1, String paramString2) {
    this.h.a(12, paramString1, paramString2, null);
    Item item;
    if ((item = a(this.h)) == null) {
      a(12, newUTF8(paramString1), newUTF8(paramString2));
      item = new Item(this.c++, this.h);
      b(item);
    } 
    return item;
  }
  
  int c(String paramString) {
    this.g.a(30, paramString, null, null);
    Item item;
    if ((item = a(this.g)) == null)
      item = c(this.g); 
    return item.a;
  }
  
  int a(String paramString, int paramInt) {
    this.g.b = 31;
    this.g.c = paramInt;
    this.g.g = paramString;
    this.g.j = Integer.MAX_VALUE & 31 + paramString.hashCode() + paramInt;
    Item item;
    if ((item = a(this.g)) == null)
      item = c(this.g); 
    return item.a;
  }
  
  private Item c(Item paramItem) {
    this.G = (short)(this.G + 1);
    paramItem = new Item(this.G, this.g);
    b(paramItem);
    if (this.H == null)
      this.H = new Item[16]; 
    if (this.G == this.H.length) {
      Item[] arrayOfItem = new Item[2 * this.H.length];
      System.arraycopy(this.H, 0, arrayOfItem, 0, this.H.length);
      this.H = arrayOfItem;
    } 
    this.H[this.G] = paramItem;
    return paramItem;
  }
  
  int a(int paramInt1, int paramInt2) {
    this.h.b = 32;
    this.h.d = paramInt1 | paramInt2 << 32L;
    this.h.j = Integer.MAX_VALUE & paramInt1 + 32 + paramInt2;
    Item item;
    if ((item = a(this.h)) == null) {
      String str1 = (this.H[paramInt1]).g;
      String str2 = (this.H[paramInt2]).g;
      this.h.c = c(getCommonSuperClass(str1, str2));
      item = new Item(0, this.h);
      b(item);
    } 
    return item.c;
  }
  
  protected String getCommonSuperClass(String paramString1, String paramString2) {
    Class clazz1;
    ClassLoader classLoader = getClass().getClassLoader();
    try {
      clazz2 = Class.forName(paramString1.replace('/', '.'), false, classLoader);
      clazz1 = Class.forName(paramString2.replace('/', '.'), false, classLoader);
    } catch (Exception exception) {
      throw new RuntimeException(exception.toString());
    } 
    if (clazz2.isAssignableFrom(clazz1))
      return (String)exception; 
    if (clazz1.isAssignableFrom(clazz2))
      return paramString2; 
    if (clazz2.isInterface() || clazz1.isInterface())
      return "java/lang/Object"; 
    Class clazz2;
    do {
    
    } while (!(clazz2 = clazz2.getSuperclass()).isAssignableFrom(clazz1));
    return clazz2.getName().replace('.', '/');
  }
  
  private Item a(Item paramItem) {
    Item item;
    for (item = this.e[paramItem.j % this.e.length]; item != null && (item.b != paramItem.b || !paramItem.a(item)); item = item.k);
    return item;
  }
  
  private void b(Item paramItem) {
    if (this.c + this.G > this.f) {
      int j;
      int k;
      Item[] arrayOfItem = new Item[k = ((j = this.e.length) << 1) + 1];
      while (--j >= 0) {
        for (Item item = this.e[j]; item != null; item = item1) {
          int m = item.j % k;
          Item item1 = item.k;
          item.k = arrayOfItem[m];
          arrayOfItem[m] = item;
        } 
        j--;
      } 
      this.e = arrayOfItem;
      this.f = (int)(k * 0.75D);
    } 
    int i = paramItem.j % this.e.length;
    paramItem.k = this.e[i];
    this.e[i] = paramItem;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3) {
    this.d.b(paramInt1, paramInt2).putShort(paramInt3);
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3) {
    this.d.a(paramInt1, paramInt2).putShort(paramInt3);
  }
  
  static {
    _clinit_();
    byte[] arrayOfByte = new byte[220];
    String str = "AAAAAAAAAAAAAAAABCLMMDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANAAAAAAAAAAAAAAAAAAAAJJJJJJJJJJJJJJJJDOPAAAAAAGGGGGGGHIFBFAAFFAARQJJKKJJJJJJJJJJJJJJJJJJ";
    for (byte b = 0; b < 'Ü'; b++)
      arrayOfByte[b] = (byte)(str.charAt(b) - 65); 
    a = arrayOfByte;
  }
  
  static void _clinit_() {}
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\asm\ClassWriter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */