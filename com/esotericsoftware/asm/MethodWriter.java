package com.esotericsoftware.asm;

class MethodWriter extends MethodVisitor {
  final ClassWriter b;
  
  private int c;
  
  private final int d;
  
  private final int e;
  
  private final String f;
  
  String g;
  
  int h;
  
  int i;
  
  int j;
  
  int[] k;
  
  private ByteVector l;
  
  private AnnotationWriter m;
  
  private AnnotationWriter n;
  
  private AnnotationWriter U;
  
  private AnnotationWriter V;
  
  private AnnotationWriter[] o;
  
  private AnnotationWriter[] p;
  
  private int S;
  
  private Attribute q;
  
  private ByteVector r = new ByteVector();
  
  private int s;
  
  private int t;
  
  private int T;
  
  private int u;
  
  private ByteVector v;
  
  private int w;
  
  private int[] x;
  
  private int[] z;
  
  private int A;
  
  private Handler B;
  
  private Handler C;
  
  private int Z;
  
  private ByteVector $;
  
  private int D;
  
  private ByteVector E;
  
  private int F;
  
  private ByteVector G;
  
  private int H;
  
  private ByteVector I;
  
  private int Y;
  
  private AnnotationWriter W;
  
  private AnnotationWriter X;
  
  private Attribute J;
  
  private boolean K;
  
  private int L;
  
  private final int M;
  
  private Label N;
  
  private Label O;
  
  private Label P;
  
  private int Q;
  
  private int R;
  
  MethodWriter(ClassWriter paramClassWriter, int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2) {
    super(327680);
    if (paramClassWriter.D == null) {
      paramClassWriter.D = this;
    } else {
      paramClassWriter.E.mv = this;
    } 
    paramClassWriter.E = this;
    this.b = paramClassWriter;
    this.c = paramInt;
    if ("<init>".equals(paramString1))
      this.c |= 0x80000; 
    this.d = paramClassWriter.newUTF8(paramString1);
    this.e = paramClassWriter.newUTF8(paramString2);
    this.f = paramString2;
    this.g = paramString3;
    if (paramArrayOfString != null && paramArrayOfString.length > 0) {
      this.j = paramArrayOfString.length;
      this.k = new int[this.j];
      for (byte b = 0; b < this.j; b++)
        this.k[b] = paramClassWriter.newClass(paramArrayOfString[b]); 
    } 
    this.M = paramBoolean2 ? 0 : (paramBoolean1 ? 1 : 2);
    if (paramBoolean1 || paramBoolean2) {
      int i = Type.getArgumentsAndReturnSizes(this.f) >> 2;
      if ((paramInt & 0x8) != 0)
        i--; 
      this.t = i;
      this.T = i;
      this.N = new Label();
      this.N.a |= 0x8;
      visitLabel(this.N);
    } 
  }
  
  public void visitParameter(String paramString, int paramInt) {
    if (this.$ == null)
      this.$ = new ByteVector(); 
    this.Z++;
    this.$.putShort((paramString == null) ? 0 : this.b.newUTF8(paramString)).putShort(paramInt);
  }
  
  public AnnotationVisitor visitAnnotationDefault() {
    this.l = new ByteVector();
    return new AnnotationWriter(this.b, false, this.l, null, 0);
  }
  
  public AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean) {
    ByteVector byteVector;
    (byteVector = new ByteVector()).putShort(this.b.newUTF8(paramString)).putShort(0);
    AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, 2);
    if (paramBoolean) {
      annotationWriter.g = this.m;
      this.m = annotationWriter;
    } else {
      annotationWriter.g = this.n;
      this.n = annotationWriter;
    } 
    return annotationWriter;
  }
  
  public AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
    ByteVector byteVector = new ByteVector();
    AnnotationWriter.a(paramInt, paramTypePath, byteVector);
    byteVector.putShort(this.b.newUTF8(paramString)).putShort(0);
    AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, byteVector.b - 2);
    if (paramBoolean) {
      annotationWriter.g = this.U;
      this.U = annotationWriter;
    } else {
      annotationWriter.g = this.V;
      this.V = annotationWriter;
    } 
    return annotationWriter;
  }
  
  public AnnotationVisitor visitParameterAnnotation(int paramInt, String paramString, boolean paramBoolean) {
    ByteVector byteVector = new ByteVector();
    if ("Ljava/lang/Synthetic;".equals(paramString)) {
      this.S = Math.max(this.S, paramInt + 1);
      return new AnnotationWriter(this.b, false, byteVector, null, 0);
    } 
    byteVector.putShort(this.b.newUTF8(paramString)).putShort(0);
    AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, 2);
    if (paramBoolean) {
      if (this.o == null)
        this.o = new AnnotationWriter[(Type.getArgumentTypes(this.f)).length]; 
      annotationWriter.g = this.o[paramInt];
      this.o[paramInt] = annotationWriter;
    } else {
      if (this.p == null)
        this.p = new AnnotationWriter[(Type.getArgumentTypes(this.f)).length]; 
      annotationWriter.g = this.p[paramInt];
      this.p[paramInt] = annotationWriter;
    } 
    return annotationWriter;
  }
  
  public void visitAttribute(Attribute paramAttribute) {
    if (paramAttribute.isCodeAttribute()) {
      paramAttribute.a = this.J;
      this.J = paramAttribute;
      return;
    } 
    paramAttribute.a = this.q;
    this.q = paramAttribute;
  }
  
  public void visitCode() {}
  
  public void visitFrame(int paramInt1, int paramInt2, Object[] paramArrayOfObject1, int paramInt3, Object[] paramArrayOfObject2) {
    if (this.M == 0)
      return; 
    if (paramInt1 == -1) {
      if (this.x == null)
        f(); 
      this.T = paramInt2;
      int i = a(this.r.b, paramInt2, paramInt3);
      for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
        if (paramArrayOfObject1[paramInt1] instanceof String) {
          this.z[i++] = 0x1700000 | this.b.c((String)paramArrayOfObject1[paramInt1]);
        } else if (paramArrayOfObject1[paramInt1] instanceof Integer) {
          this.z[i++] = ((Integer)paramArrayOfObject1[paramInt1]).intValue();
        } else {
          this.z[i++] = 0x1800000 | this.b.a("", ((Label)paramArrayOfObject1[paramInt1]).c);
        } 
      } 
      for (paramInt1 = 0; paramInt1 < paramInt3; paramInt1++) {
        if (paramArrayOfObject2[paramInt1] instanceof String) {
          this.z[i++] = 0x1700000 | this.b.c((String)paramArrayOfObject2[paramInt1]);
        } else if (paramArrayOfObject2[paramInt1] instanceof Integer) {
          this.z[i++] = ((Integer)paramArrayOfObject2[paramInt1]).intValue();
        } else {
          this.z[i++] = 0x1800000 | this.b.a("", ((Label)paramArrayOfObject2[paramInt1]).c);
        } 
      } 
      b();
    } else {
      int i;
      if (this.v == null) {
        this.v = new ByteVector();
        i = this.r.b;
      } else if ((i = this.r.b - this.w - 1) < 0) {
        if (paramInt1 == 3)
          return; 
        throw new IllegalStateException();
      } 
      switch (paramInt1) {
        case 0:
          this.T = paramInt2;
          this.v.putByte(255).putShort(i).putShort(paramInt2);
          for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++)
            a(paramArrayOfObject1[paramInt1]); 
          this.v.putShort(paramInt3);
          for (paramInt1 = 0; paramInt1 < paramInt3; paramInt1++)
            a(paramArrayOfObject2[paramInt1]); 
          break;
        case 1:
          this.T += paramInt2;
          this.v.putByte(paramInt2 + 251).putShort(i);
          for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++)
            a(paramArrayOfObject1[paramInt1]); 
          break;
        case 2:
          this.T -= paramInt2;
          this.v.putByte(251 - paramInt2).putShort(i);
          break;
        case 3:
          if (i < 64) {
            this.v.putByte(i);
            break;
          } 
          this.v.putByte(251).putShort(i);
          break;
        case 4:
          if (i < 64) {
            this.v.putByte(i + 64);
          } else {
            this.v.putByte(247).putShort(i);
          } 
          a(paramArrayOfObject2[0]);
          break;
      } 
      this.w = this.r.b;
      this.u++;
    } 
    this.s = Math.max(this.s, paramInt3);
    this.t = Math.max(this.t, this.T);
  }
  
  public void visitInsn(int paramInt) {
    this.Y = this.r.b;
    this.r.putByte(paramInt);
    if (this.P != null) {
      if (this.M == 0) {
        this.P.h.a(paramInt, 0, (ClassWriter)null, (Item)null);
      } else {
        int i;
        if ((i = this.Q + Frame.a[paramInt]) > this.R)
          this.R = i; 
        this.Q = i;
      } 
      if ((paramInt >= 172 && paramInt <= 177) || paramInt == 191)
        e(); 
    } 
  }
  
  public void visitIntInsn(int paramInt1, int paramInt2) {
    this.Y = this.r.b;
    if (this.P != null)
      if (this.M == 0) {
        this.P.h.a(paramInt1, paramInt2, (ClassWriter)null, (Item)null);
      } else if (paramInt1 != 188) {
        int i;
        if ((i = this.Q + 1) > this.R)
          this.R = i; 
        this.Q = i;
      }  
    if (paramInt1 == 17) {
      this.r.b(paramInt1, paramInt2);
      return;
    } 
    this.r.a(paramInt1, paramInt2);
  }
  
  public void visitVarInsn(int paramInt1, int paramInt2) {
    this.Y = this.r.b;
    if (this.P != null)
      if (this.M == 0) {
        this.P.h.a(paramInt1, paramInt2, (ClassWriter)null, (Item)null);
      } else if (paramInt1 == 169) {
        this.P.a |= 0x100;
        this.P.f = this.Q;
        e();
      } else {
        int i;
        if ((i = this.Q + Frame.a[paramInt1]) > this.R)
          this.R = i; 
        this.Q = i;
      }  
    if (this.M != 2) {
      int i;
      if (paramInt1 == 22 || paramInt1 == 24 || paramInt1 == 55 || paramInt1 == 57) {
        i = paramInt2 + 2;
      } else {
        i = paramInt2 + 1;
      } 
      if (i > this.t)
        this.t = i; 
    } 
    if (paramInt2 < 4 && paramInt1 != 169) {
      int i;
      if (paramInt1 < 54) {
        i = 26 + (paramInt1 - 21 << 2) + paramInt2;
      } else {
        i = 59 + (paramInt1 - 54 << 2) + paramInt2;
      } 
      this.r.putByte(i);
    } else if (paramInt2 >= 256) {
      this.r.putByte(196).b(paramInt1, paramInt2);
    } else {
      this.r.a(paramInt1, paramInt2);
    } 
    if (paramInt1 >= 54 && this.M == 0 && this.A > 0)
      visitLabel(new Label()); 
  }
  
  public void visitTypeInsn(int paramInt, String paramString) {
    this.Y = this.r.b;
    Item item = this.b.a(paramString);
    if (this.P != null)
      if (this.M == 0) {
        this.P.h.a(paramInt, this.r.b, this.b, item);
      } else if (paramInt == 187) {
        int i;
        if ((i = this.Q + 1) > this.R)
          this.R = i; 
        this.Q = i;
      }  
    this.r.b(paramInt, item.a);
  }
  
  public void visitFieldInsn(int paramInt, String paramString1, String paramString2, String paramString3) {
    this.Y = this.r.b;
    Item item = this.b.a(paramString1, paramString2, paramString3);
    if (this.P != null)
      if (this.M == 0) {
        this.P.h.a(paramInt, 0, this.b, item);
      } else {
        int i;
        char c = paramString3.charAt(0);
        switch (paramInt) {
          case 178:
            i = this.Q + ((c == 'D' || c == 'J') ? 2 : 1);
            break;
          case 179:
            i = this.Q + ((i == 68 || i == 74) ? -2 : -1);
            break;
          case 180:
            i = this.Q + ((i == 68 || i == 74) ? 1 : 0);
            break;
          default:
            i = this.Q + ((i == 68 || i == 74) ? -3 : -2);
            break;
        } 
        if (i > this.R)
          this.R = i; 
        this.Q = i;
      }  
    this.r.b(paramInt, item.a);
  }
  
  public void visitMethodInsn(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    this.Y = this.r.b;
    Item item;
    int i = (item = this.b.a(paramString1, paramString2, paramString3, paramBoolean)).c;
    if (this.P != null)
      if (this.M == 0) {
        this.P.h.a(paramInt, 0, this.b, item);
      } else {
        int j;
        if (i == 0) {
          i = Type.getArgumentsAndReturnSizes(paramString3);
          item.c = i;
        } 
        if (paramInt == 184) {
          j = this.Q - (i >> 2) + (i & 0x3) + 1;
        } else {
          j = this.Q - (i >> 2) + (i & 0x3);
        } 
        if (j > this.R)
          this.R = j; 
        this.Q = j;
      }  
    if (paramInt == 185) {
      if (i == 0) {
        i = Type.getArgumentsAndReturnSizes(paramString3);
        item.c = i;
      } 
      this.r.b(185, item.a).a(i >> 2, 0);
      return;
    } 
    this.r.b(paramInt, item.a);
  }
  
  public void visitInvokeDynamicInsn(String paramString1, String paramString2, Handle paramHandle, Object... paramVarArgs) {
    this.Y = this.r.b;
    Item item;
    int i = (item = this.b.a(paramString1, paramString2, paramHandle, paramVarArgs)).c;
    if (this.P != null)
      if (this.M == 0) {
        this.P.h.a(186, 0, this.b, item);
      } else {
        if (i == 0) {
          i = Type.getArgumentsAndReturnSizes(paramString2);
          item.c = i;
        } 
        int j;
        if ((j = this.Q - (i >> 2) + (i & 0x3) + 1) > this.R)
          this.R = j; 
        this.Q = j;
      }  
    this.r.b(186, item.a);
    this.r.putShort(0);
  }
  
  public void visitJumpInsn(int paramInt, Label paramLabel) {
    this.Y = this.r.b;
    Label label = null;
    if (this.P != null)
      if (this.M == 0) {
        this.P.h.a(paramInt, 0, (ClassWriter)null, (Item)null);
        (paramLabel.a()).a |= 0x10;
        a(0, paramLabel);
        if (paramInt != 167)
          label = new Label(); 
      } else if (paramInt == 168) {
        if ((paramLabel.a & 0x200) == 0) {
          paramLabel.a |= 0x200;
          this.L++;
        } 
        this.P.a |= 0x80;
        a(this.Q + 1, paramLabel);
        label = new Label();
      } else {
        this.Q += Frame.a[paramInt];
        a(this.Q, paramLabel);
      }  
    if ((paramLabel.a & 0x2) != 0 && paramLabel.c - this.r.b < -32768) {
      if (paramInt == 167) {
        this.r.putByte(200);
      } else if (paramInt == 168) {
        this.r.putByte(201);
      } else {
        if (label != null)
          label.a |= 0x10; 
        this.r.putByte((paramInt <= 166) ? ((paramInt + 1 ^ 0x1) - 1) : (paramInt ^ 0x1));
        this.r.putShort(8);
        this.r.putByte(200);
      } 
      paramLabel.a(this, this.r, this.r.b - 1, true);
    } else {
      this.r.putByte(paramInt);
      paramLabel.a(this, this.r, this.r.b - 1, false);
    } 
    if (this.P != null) {
      if (label != null)
        visitLabel(label); 
      if (paramInt == 167)
        e(); 
    } 
  }
  
  public void visitLabel(Label paramLabel) {
    this.K |= paramLabel.a(this, this.r.b, this.r.a);
    if ((paramLabel.a & 0x1) != 0)
      return; 
    if (this.M == 0) {
      if (this.P != null) {
        if (paramLabel.c == this.P.c) {
          this.P.a |= paramLabel.a & 0x10;
          paramLabel.h = this.P.h;
          return;
        } 
        a(0, paramLabel);
      } 
      this.P = paramLabel;
      if (paramLabel.h == null) {
        paramLabel.h = new Frame();
        paramLabel.h.b = paramLabel;
      } 
      if (this.O != null) {
        if (paramLabel.c == this.O.c) {
          this.O.a |= paramLabel.a & 0x10;
          paramLabel.h = this.O.h;
          this.P = this.O;
          return;
        } 
        this.O.i = paramLabel;
      } 
      this.O = paramLabel;
      return;
    } 
    if (this.M == 1) {
      if (this.P != null) {
        this.P.g = this.R;
        a(this.Q, paramLabel);
      } 
      this.P = paramLabel;
      this.Q = 0;
      this.R = 0;
      if (this.O != null)
        this.O.i = paramLabel; 
      this.O = paramLabel;
    } 
  }
  
  public void visitLdcInsn(Object paramObject) {
    this.Y = this.r.b;
    paramObject = this.b.a(paramObject);
    if (this.P != null)
      if (this.M == 0) {
        this.P.h.a(18, 0, this.b, (Item)paramObject);
      } else {
        int j;
        if (((Item)paramObject).b == 5 || ((Item)paramObject).b == 6) {
          j = this.Q + 2;
        } else {
          j = this.Q + 1;
        } 
        if (j > this.R)
          this.R = j; 
        this.Q = j;
      }  
    int i = ((Item)paramObject).a;
    if (((Item)paramObject).b == 5 || ((Item)paramObject).b == 6) {
      this.r.b(20, i);
      return;
    } 
    if (i >= 256) {
      this.r.b(19, i);
      return;
    } 
    this.r.a(18, i);
  }
  
  public void visitIincInsn(int paramInt1, int paramInt2) {
    this.Y = this.r.b;
    if (this.P != null && this.M == 0)
      this.P.h.a(132, paramInt1, (ClassWriter)null, (Item)null); 
    int i;
    if (this.M != 2 && (i = paramInt1 + 1) > this.t)
      this.t = i; 
    if (paramInt1 > 255 || paramInt2 > 127 || paramInt2 < -128) {
      this.r.putByte(196).b(132, paramInt1).putShort(paramInt2);
      return;
    } 
    this.r.putByte(132).a(paramInt1, paramInt2);
  }
  
  public void visitTableSwitchInsn(int paramInt1, int paramInt2, Label paramLabel, Label... paramVarArgs) {
    this.Y = this.r.b;
    int i = this.r.b;
    this.r.putByte(170);
    this.r.putByteArray(null, 0, (4 - this.r.b % 4) % 4);
    paramLabel.a(this, this.r, i, true);
    this.r.putInt(paramInt1).putInt(paramInt2);
    for (paramInt1 = 0; paramInt1 < paramVarArgs.length; paramInt1++)
      paramVarArgs[paramInt1].a(this, this.r, i, true); 
    a(paramLabel, paramVarArgs);
  }
  
  public void visitLookupSwitchInsn(Label paramLabel, int[] paramArrayOfint, Label[] paramArrayOfLabel) {
    this.Y = this.r.b;
    int i = this.r.b;
    this.r.putByte(171);
    this.r.putByteArray(null, 0, (4 - this.r.b % 4) % 4);
    paramLabel.a(this, this.r, i, true);
    this.r.putInt(paramArrayOfLabel.length);
    for (byte b = 0; b < paramArrayOfLabel.length; b++) {
      this.r.putInt(paramArrayOfint[b]);
      paramArrayOfLabel[b].a(this, this.r, i, true);
    } 
    a(paramLabel, paramArrayOfLabel);
  }
  
  private void a(Label paramLabel, Label[] paramArrayOfLabel) {
    if (this.P != null) {
      byte b;
      if (this.M == 0) {
        this.P.h.a(171, 0, (ClassWriter)null, (Item)null);
        a(0, paramLabel);
        (paramLabel.a()).a |= 0x10;
        for (b = 0; b < paramArrayOfLabel.length; b++) {
          a(0, paramArrayOfLabel[b]);
          (paramArrayOfLabel[b].a()).a |= 0x10;
        } 
      } else {
        this.Q--;
        a(this.Q, b);
        for (b = 0; b < paramArrayOfLabel.length; b++)
          a(this.Q, paramArrayOfLabel[b]); 
      } 
      e();
    } 
  }
  
  public void visitMultiANewArrayInsn(String paramString, int paramInt) {
    this.Y = this.r.b;
    Item item = this.b.a(paramString);
    if (this.P != null)
      if (this.M == 0) {
        this.P.h.a(197, paramInt, this.b, item);
      } else {
        this.Q += 1 - paramInt;
      }  
    this.r.b(197, item.a).putByte(paramInt);
  }
  
  public AnnotationVisitor visitInsnAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
    ByteVector byteVector = new ByteVector();
    AnnotationWriter.a(paramInt = paramInt & 0xFF0000FF | this.Y << 8, paramTypePath, byteVector);
    byteVector.putShort(this.b.newUTF8(paramString)).putShort(0);
    AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, byteVector.b - 2);
    if (paramBoolean) {
      annotationWriter.g = this.W;
      this.W = annotationWriter;
    } else {
      annotationWriter.g = this.X;
      this.X = annotationWriter;
    } 
    return annotationWriter;
  }
  
  public void visitTryCatchBlock(Label paramLabel1, Label paramLabel2, Label paramLabel3, String paramString) {
    this.A++;
    Handler handler;
    (handler = new Handler()).a = paramLabel1;
    handler.b = paramLabel2;
    handler.c = paramLabel3;
    handler.d = paramString;
    handler.e = (paramString != null) ? this.b.newClass(paramString) : 0;
    if (this.C == null) {
      this.B = handler;
    } else {
      this.C.f = handler;
    } 
    this.C = handler;
  }
  
  public AnnotationVisitor visitTryCatchAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
    ByteVector byteVector = new ByteVector();
    AnnotationWriter.a(paramInt, paramTypePath, byteVector);
    byteVector.putShort(this.b.newUTF8(paramString)).putShort(0);
    AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, byteVector.b - 2);
    if (paramBoolean) {
      annotationWriter.g = this.W;
      this.W = annotationWriter;
    } else {
      annotationWriter.g = this.X;
      this.X = annotationWriter;
    } 
    return annotationWriter;
  }
  
  public void visitLocalVariable(String paramString1, String paramString2, String paramString3, Label paramLabel1, Label paramLabel2, int paramInt) {
    if (paramString3 != null) {
      if (this.G == null)
        this.G = new ByteVector(); 
      this.F++;
      this.G.putShort(paramLabel1.c).putShort(paramLabel2.c - paramLabel1.c).putShort(this.b.newUTF8(paramString1)).putShort(this.b.newUTF8(paramString3)).putShort(paramInt);
    } 
    if (this.E == null)
      this.E = new ByteVector(); 
    this.D++;
    this.E.putShort(paramLabel1.c).putShort(paramLabel2.c - paramLabel1.c).putShort(this.b.newUTF8(paramString1)).putShort(this.b.newUTF8(paramString2)).putShort(paramInt);
    if (this.M != 2) {
      char c = paramString2.charAt(0);
      int i;
      if ((i = paramInt + ((c == 'J' || c == 'D') ? 2 : 1)) > this.t)
        this.t = i; 
    } 
  }
  
  public AnnotationVisitor visitLocalVariableAnnotation(int paramInt, TypePath paramTypePath, Label[] paramArrayOfLabel1, Label[] paramArrayOfLabel2, int[] paramArrayOfint, String paramString, boolean paramBoolean) {
    ByteVector byteVector;
    (byteVector = new ByteVector()).putByte(paramInt >>> 24).putShort(paramArrayOfLabel1.length);
    for (paramInt = 0; paramInt < paramArrayOfLabel1.length; paramInt++)
      byteVector.putShort((paramArrayOfLabel1[paramInt]).c).putShort((paramArrayOfLabel2[paramInt]).c - (paramArrayOfLabel1[paramInt]).c).putShort(paramArrayOfint[paramInt]); 
    if (paramTypePath == null) {
      byteVector.putByte(0);
    } else {
      paramInt = (paramTypePath.a[paramTypePath.b] << 1) + 1;
      byteVector.putByteArray(paramTypePath.a, paramTypePath.b, paramInt);
    } 
    byteVector.putShort(this.b.newUTF8(paramString)).putShort(0);
    AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, byteVector.b - 2);
    if (paramBoolean) {
      annotationWriter.g = this.W;
      this.W = annotationWriter;
    } else {
      annotationWriter.g = this.X;
      this.X = annotationWriter;
    } 
    return annotationWriter;
  }
  
  public void visitLineNumber(int paramInt, Label paramLabel) {
    if (this.I == null)
      this.I = new ByteVector(); 
    this.H++;
    this.I.putShort(paramLabel.c);
    this.I.putShort(paramInt);
  }
  
  public void visitMaxs(int paramInt1, int paramInt2) {
    Handler handler;
    if (this.K)
      d(); 
    if (this.M == 0) {
      for (handler = this.B; handler != null; handler = handler.f) {
        Label label3 = handler.a.a();
        Label label4 = handler.c.a();
        Label label5 = handler.b.a();
        String str = (handler.d == null) ? "java/lang/Throwable" : handler.d;
        int j = 0x1700000 | this.b.c(str);
        label4.a |= 0x10;
        while (label3 != label5) {
          Edge edge;
          (edge = new Edge()).a = j;
          edge.b = label4;
          edge.c = label3.j;
          label3.j = edge;
          label3 = label3.i;
        } 
      } 
      Frame frame = this.N.h;
      Type[] arrayOfType = Type.getArgumentTypes(this.f);
      frame.a(this.b, this.c, arrayOfType, this.t);
      b(frame);
      int i = 0;
      Label label1 = this.N;
      while (label1 != null) {
        Label label = label1;
        label1 = label1.k;
        label.k = null;
        frame = label.h;
        if ((label.a & 0x10) != 0)
          label.a |= 0x20; 
        label.a |= 0x40;
        int j;
        if ((j = frame.d.length + label.g) > i)
          i = j; 
        for (Edge edge = label.j; edge != null; edge = edge.c) {
          Label label3 = edge.b.a();
          boolean bool;
          if ((bool = frame.a(this.b, label3.h, edge.a)) && label3.k == null) {
            label3.k = label1;
            label1 = label3;
          } 
        } 
      } 
      for (Label label2 = this.N; label2 != null; label2 = label2.i) {
        frame = label2.h;
        if ((label2.a & 0x20) != 0)
          b(frame); 
        if ((label2.a & 0x40) == 0) {
          Label label = label2.i;
          paramInt1 = label2.c;
          int j;
          if ((j = ((label == null) ? this.r.b : label.c) - 1) >= paramInt1) {
            i = Math.max(i, 1);
            int k;
            for (k = paramInt1; k < j; k++)
              this.r.a[k] = 0; 
            this.r.a[j] = -65;
            k = a(paramInt1, 0, 1);
            this.z[k] = 0x1700000 | this.b.c("java/lang/Throwable");
            b();
            this.B = Handler.a(this.B, label2, label);
          } 
        } 
      } 
      handler = this.B;
      this.A = 0;
      while (handler != null) {
        this.A++;
        handler = handler.f;
      } 
      this.s = i;
      return;
    } 
    if (this.M == 1) {
      for (handler = this.B; handler != null; handler = handler.f) {
        Label label1 = handler.a;
        Label label2 = handler.c;
        Label label3 = handler.b;
        while (label1 != label3) {
          Edge edge;
          (edge = new Edge()).a = Integer.MAX_VALUE;
          edge.b = label2;
          if ((label1.a & 0x80) == 0) {
            edge.c = label1.j;
            label1.j = edge;
          } else {
            edge.c = label1.j.c.c;
            label1.j.c.c = edge;
          } 
          label1 = label1.i;
        } 
      } 
      if (this.L > 0) {
        byte b = 0;
        this.N.b(null, 1L, this.L);
        Label label1;
        for (label1 = this.N; label1 != null; label1 = label1.i) {
          Label label2;
          if ((label1.a & 0x80) != 0 && ((label2 = label1.j.c.b).a & 0x400) == 0)
            label2.b(null, ++b / 32L << 32L | 1L << b % 32, this.L); 
        } 
        for (label1 = this.N; label1 != null; label1 = label1.i) {
          if ((label1.a & 0x80) != 0) {
            for (Label label2 = this.N; label2 != null; label2 = label2.i)
              label2.a &= 0xFFFFF7FF; 
            Label label3;
            (label3 = label1.j.c.b).b(label1, 0L, this.L);
          } 
        } 
      } 
      int i = 0;
      Label label = this.N;
      while (label != null) {
        Label label1 = label;
        label = label.k;
        int j;
        int k;
        if ((k = (j = label1.f) + label1.g) > i)
          i = k; 
        Edge edge = label1.j;
        if ((label1.a & 0x80) != 0)
          edge = edge.c; 
        while (edge != null) {
          if (((label1 = edge.b).a & 0x8) == 0) {
            label1.f = (edge.a == Integer.MAX_VALUE) ? 1 : (j + edge.a);
            label1.a |= 0x8;
            label1.k = label;
            label = label1;
          } 
          edge = edge.c;
        } 
      } 
      this.s = Math.max(paramInt1, i);
      return;
    } 
    this.s = paramInt1;
    this.t = handler;
  }
  
  public void visitEnd() {}
  
  private void a(int paramInt, Label paramLabel) {
    Edge edge;
    (edge = new Edge()).a = paramInt;
    edge.b = paramLabel;
    edge.c = this.P.j;
    this.P.j = edge;
  }
  
  private void e() {
    if (this.M == 0) {
      Label label;
      (label = new Label()).h = new Frame();
      label.h.b = label;
      label.a(this, this.r.b, this.r.a);
      this.O.i = label;
      this.O = label;
    } else {
      this.P.g = this.R;
    } 
    this.P = null;
  }
  
  private void b(Frame paramFrame) {
    byte b1 = 0;
    int j = 0;
    byte b2 = 0;
    int[] arrayOfInt1 = paramFrame.c;
    int[] arrayOfInt2 = paramFrame.d;
    byte b3;
    for (b3 = 0; b3 < arrayOfInt1.length; b3++) {
      int k;
      if ((k = arrayOfInt1[b3]) == 16777216) {
        b1++;
      } else {
        j += b1 + 1;
        b1 = 0;
      } 
      if (k == 16777220 || k == 16777219)
        b3++; 
    } 
    for (b3 = 0; b3 < arrayOfInt2.length; b3++) {
      int k = arrayOfInt2[b3];
      b2++;
      if (k == 16777220 || k == 16777219)
        b3++; 
    } 
    int i = a(paramFrame.b.c, j, b2);
    b3 = 0;
    while (j > 0) {
      int k = arrayOfInt1[b3];
      this.z[i++] = k;
      if (k == 16777220 || k == 16777219)
        b3++; 
      b3++;
      j--;
    } 
    for (b3 = 0; b3 < arrayOfInt2.length; b3++) {
      int k = arrayOfInt2[b3];
      this.z[i++] = k;
      if (k == 16777220 || k == 16777219)
        b3++; 
    } 
    b();
  }
  
  private void f() {
    int i = a(0, this.f.length() + 1, 0);
    if ((this.c & 0x8) == 0)
      if ((this.c & 0x80000) == 0) {
        this.z[i++] = 0x1700000 | this.b.c(this.b.I);
      } else {
        this.z[i++] = 6;
      }  
    byte b = 1;
    while (true) {
      byte b1 = b;
      switch (this.f.charAt(b++)) {
        case 'B':
        case 'C':
        case 'I':
        case 'S':
        case 'Z':
          this.z[i++] = 1;
          continue;
        case 'F':
          this.z[i++] = 2;
          continue;
        case 'J':
          this.z[i++] = 4;
          continue;
        case 'D':
          this.z[i++] = 3;
          continue;
        case '[':
          while (this.f.charAt(b) == '[')
            b++; 
          if (this.f.charAt(b) == 'L')
            while (this.f.charAt(++b) != ';')
              b++;  
          this.z[i++] = 0x1700000 | this.b.c(this.f.substring(b1, ++b));
          continue;
        case 'L':
          while (this.f.charAt(b) != ';')
            b++; 
          this.z[i++] = 0x1700000 | this.b.c(this.f.substring(b1 + 1, b++));
          continue;
      } 
      this.z[1] = i - 3;
      b();
      return;
    } 
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3) {
    int i = paramInt2 + 3 + paramInt3;
    if (this.z == null || this.z.length < i)
      this.z = new int[i]; 
    this.z[0] = paramInt1;
    this.z[1] = paramInt2;
    this.z[2] = paramInt3;
    return 3;
  }
  
  private void b() {
    if (this.x != null) {
      if (this.v == null)
        this.v = new ByteVector(); 
      c();
      this.u++;
    } 
    this.x = this.z;
    this.z = null;
  }
  
  private void c() {
    int n;
    int i = this.z[1];
    int j = this.z[2];
    if ((this.b.b & 0xFFFF) < 50) {
      this.v.putShort(this.z[0]).putShort(i);
      a(3, i + 3);
      this.v.putShort(j);
      a(i + 3, i + 3 + j);
      return;
    } 
    int k = this.x[1];
    char c = 'ÿ';
    int m = 0;
    if (this.u == 0) {
      n = this.z[0];
    } else {
      n = this.z[0] - this.x[0] - 1;
    } 
    if (j == 0) {
      switch (m = i - k) {
        case -3:
        case -2:
        case -1:
          c = 'ø';
          k = i;
          break;
        case 0:
          c = (n < 64) ? Character.MIN_VALUE : 'û';
          break;
        case 1:
        case 2:
        case 3:
          c = 'ü';
          break;
      } 
    } else if (i == k && j == 1) {
      c = (n < 63) ? '@' : '÷';
    } 
    if (c != 'ÿ') {
      byte b1 = 3;
      for (byte b2 = 0; b2 < k; b2++) {
        if (this.z[b1] != this.x[b1]) {
          c = 'ÿ';
          break;
        } 
        b1++;
      } 
    } 
    switch (c) {
      case '\000':
        this.v.putByte(n);
        return;
      case '@':
        this.v.putByte(n + 64);
        a(i + 3, i + 4);
        return;
      case '÷':
        this.v.putByte(247).putShort(n);
        a(i + 3, i + 4);
        return;
      case 'û':
        this.v.putByte(251).putShort(n);
        return;
      case 'ø':
        this.v.putByte(m + 251).putShort(n);
        return;
      case 'ü':
        this.v.putByte(m + 251).putShort(n);
        a(k + 3, i + 3);
        return;
    } 
    this.v.putByte(255).putShort(n).putShort(i);
    a(3, i + 3);
    this.v.putShort(j);
    a(i + 3, i + 3 + j);
  }
  
  private void a(int paramInt1, int paramInt2) {
    for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
      int i;
      int j;
      if ((j = (i = this.z[paramInt1]) & 0xF0000000) == 0) {
        int k = i & 0xFFFFF;
        switch (i & 0xFF00000) {
          case 24117248:
            this.v.putByte(7).putShort(this.b.newClass((this.b.H[k]).g));
            break;
          case 25165824:
            this.v.putByte(8).putShort((this.b.H[k]).c);
            break;
          default:
            this.v.putByte(k);
            break;
        } 
      } else {
        StringBuffer stringBuffer = new StringBuffer();
        j >>= 28;
        while (j-- > 0)
          stringBuffer.append('['); 
        if ((i & 0xFF00000) == 24117248) {
          stringBuffer.append('L');
          stringBuffer.append((this.b.H[i & 0xFFFFF]).g);
          stringBuffer.append(';');
        } else {
          switch (i & 0xF) {
            case 1:
              stringBuffer.append('I');
              break;
            case 2:
              stringBuffer.append('F');
              break;
            case 3:
              stringBuffer.append('D');
              break;
            case 9:
              stringBuffer.append('Z');
              break;
            case 10:
              stringBuffer.append('B');
              break;
            case 11:
              stringBuffer.append('C');
              break;
            case 12:
              stringBuffer.append('S');
              break;
            default:
              stringBuffer.append('J');
              break;
          } 
        } 
        this.v.putByte(7).putShort(this.b.newClass(stringBuffer.toString()));
      } 
    } 
  }
  
  private void a(Object paramObject) {
    if (paramObject instanceof String) {
      this.v.putByte(7).putShort(this.b.newClass((String)paramObject));
      return;
    } 
    if (paramObject instanceof Integer) {
      this.v.putByte(((Integer)paramObject).intValue());
      return;
    } 
    this.v.putByte(8).putShort(((Label)paramObject).c);
  }
  
  final int a() {
    if (this.h != 0)
      return 6 + this.i; 
    int i = 8;
    if (this.r.b > 0) {
      if (this.r.b > 65535)
        throw new RuntimeException("Method code too large!"); 
      this.b.newUTF8("Code");
      i = 8 + 18 + this.r.b + 8 * this.A;
      if (this.E != null) {
        this.b.newUTF8("LocalVariableTable");
        i += 8 + this.E.b;
      } 
      if (this.G != null) {
        this.b.newUTF8("LocalVariableTypeTable");
        i += 8 + this.G.b;
      } 
      if (this.I != null) {
        this.b.newUTF8("LineNumberTable");
        i += 8 + this.I.b;
      } 
      if (this.v != null) {
        boolean bool = ((this.b.b & 0xFFFF) >= 50) ? true : false;
        this.b.newUTF8(bool ? "StackMapTable" : "StackMap");
        i += 8 + this.v.b;
      } 
      if (this.W != null) {
        this.b.newUTF8("RuntimeVisibleTypeAnnotations");
        i += 8 + this.W.a();
      } 
      if (this.X != null) {
        this.b.newUTF8("RuntimeInvisibleTypeAnnotations");
        i += 8 + this.X.a();
      } 
      if (this.J != null)
        i += this.J.a(this.b, this.r.a, this.r.b, this.s, this.t); 
    } 
    if (this.j > 0) {
      this.b.newUTF8("Exceptions");
      i += 8 + 2 * this.j;
    } 
    if ((this.c & 0x1000) != 0 && ((this.b.b & 0xFFFF) < 49 || (this.c & 0x40000) != 0)) {
      this.b.newUTF8("Synthetic");
      i += 6;
    } 
    if ((this.c & 0x20000) != 0) {
      this.b.newUTF8("Deprecated");
      i += 6;
    } 
    if (this.g != null) {
      this.b.newUTF8("Signature");
      this.b.newUTF8(this.g);
      i += 8;
    } 
    if (this.$ != null) {
      this.b.newUTF8("MethodParameters");
      i += 7 + this.$.b;
    } 
    if (this.l != null) {
      this.b.newUTF8("AnnotationDefault");
      i += 6 + this.l.b;
    } 
    if (this.m != null) {
      this.b.newUTF8("RuntimeVisibleAnnotations");
      i += 8 + this.m.a();
    } 
    if (this.n != null) {
      this.b.newUTF8("RuntimeInvisibleAnnotations");
      i += 8 + this.n.a();
    } 
    if (this.U != null) {
      this.b.newUTF8("RuntimeVisibleTypeAnnotations");
      i += 8 + this.U.a();
    } 
    if (this.V != null) {
      this.b.newUTF8("RuntimeInvisibleTypeAnnotations");
      i += 8 + this.V.a();
    } 
    if (this.o != null) {
      this.b.newUTF8("RuntimeVisibleParameterAnnotations");
      i += 7 + 2 * (this.o.length - this.S);
      for (int j = this.o.length - 1; j >= this.S; j--)
        i += (this.o[j] == null) ? 0 : this.o[j].a(); 
    } 
    if (this.p != null) {
      this.b.newUTF8("RuntimeInvisibleParameterAnnotations");
      i += 7 + 2 * (this.p.length - this.S);
      for (int j = this.p.length - 1; j >= this.S; j--)
        i += (this.p[j] == null) ? 0 : this.p[j].a(); 
    } 
    if (this.q != null)
      i += this.q.a(this.b, null, 0, -1, -1); 
    return i;
  }
  
  final void a(ByteVector paramByteVector) {
    int i = 0xE0000 | (this.c & 0x40000) / 64;
    paramByteVector.putShort(this.c & (i ^ 0xFFFFFFFF)).putShort(this.d).putShort(this.e);
    if (this.h != 0) {
      paramByteVector.putByteArray(this.b.M.b, this.h, this.i);
      return;
    } 
    i = 0;
    if (this.r.b > 0)
      i++; 
    if (this.j > 0)
      i++; 
    if ((this.c & 0x1000) != 0 && ((this.b.b & 0xFFFF) < 49 || (this.c & 0x40000) != 0))
      i++; 
    if ((this.c & 0x20000) != 0)
      i++; 
    if (this.g != null)
      i++; 
    if (this.$ != null)
      i++; 
    if (this.l != null)
      i++; 
    if (this.m != null)
      i++; 
    if (this.n != null)
      i++; 
    if (this.U != null)
      i++; 
    if (this.V != null)
      i++; 
    if (this.o != null)
      i++; 
    if (this.p != null)
      i++; 
    if (this.q != null)
      i += this.q.a(); 
    paramByteVector.putShort(i);
    if (this.r.b > 0) {
      i = 12 + this.r.b + 8 * this.A;
      if (this.E != null)
        i += 8 + this.E.b; 
      if (this.G != null)
        i += 8 + this.G.b; 
      if (this.I != null)
        i += 8 + this.I.b; 
      if (this.v != null)
        i += 8 + this.v.b; 
      if (this.W != null)
        i += 8 + this.W.a(); 
      if (this.X != null)
        i += 8 + this.X.a(); 
      if (this.J != null)
        i += this.J.a(this.b, this.r.a, this.r.b, this.s, this.t); 
      paramByteVector.putShort(this.b.newUTF8("Code")).putInt(i);
      paramByteVector.putShort(this.s).putShort(this.t);
      paramByteVector.putInt(this.r.b).putByteArray(this.r.a, 0, this.r.b);
      paramByteVector.putShort(this.A);
      if (this.A > 0)
        for (Handler handler = this.B; handler != null; handler = handler.f)
          paramByteVector.putShort(handler.a.c).putShort(handler.b.c).putShort(handler.c.c).putShort(handler.e);  
      i = 0;
      if (this.E != null)
        i++; 
      if (this.G != null)
        i++; 
      if (this.I != null)
        i++; 
      if (this.v != null)
        i++; 
      if (this.W != null)
        i++; 
      if (this.X != null)
        i++; 
      if (this.J != null)
        i += this.J.a(); 
      paramByteVector.putShort(i);
      if (this.E != null) {
        paramByteVector.putShort(this.b.newUTF8("LocalVariableTable"));
        paramByteVector.putInt(this.E.b + 2).putShort(this.D);
        paramByteVector.putByteArray(this.E.a, 0, this.E.b);
      } 
      if (this.G != null) {
        paramByteVector.putShort(this.b.newUTF8("LocalVariableTypeTable"));
        paramByteVector.putInt(this.G.b + 2).putShort(this.F);
        paramByteVector.putByteArray(this.G.a, 0, this.G.b);
      } 
      if (this.I != null) {
        paramByteVector.putShort(this.b.newUTF8("LineNumberTable"));
        paramByteVector.putInt(this.I.b + 2).putShort(this.H);
        paramByteVector.putByteArray(this.I.a, 0, this.I.b);
      } 
      if (this.v != null) {
        i = ((this.b.b & 0xFFFF) >= 50) ? 1 : 0;
        paramByteVector.putShort(this.b.newUTF8((i != 0) ? "StackMapTable" : "StackMap"));
        paramByteVector.putInt(this.v.b + 2).putShort(this.u);
        paramByteVector.putByteArray(this.v.a, 0, this.v.b);
      } 
      if (this.W != null) {
        paramByteVector.putShort(this.b.newUTF8("RuntimeVisibleTypeAnnotations"));
        this.W.a(paramByteVector);
      } 
      if (this.X != null) {
        paramByteVector.putShort(this.b.newUTF8("RuntimeInvisibleTypeAnnotations"));
        this.X.a(paramByteVector);
      } 
      if (this.J != null)
        this.J.a(this.b, this.r.a, this.r.b, this.t, this.s, paramByteVector); 
    } 
    if (this.j > 0) {
      paramByteVector.putShort(this.b.newUTF8("Exceptions")).putInt(2 * this.j + 2);
      paramByteVector.putShort(this.j);
      for (i = 0; i < this.j; i++)
        paramByteVector.putShort(this.k[i]); 
    } 
    if ((this.c & 0x1000) != 0 && ((this.b.b & 0xFFFF) < 49 || (this.c & 0x40000) != 0))
      paramByteVector.putShort(this.b.newUTF8("Synthetic")).putInt(0); 
    if ((this.c & 0x20000) != 0)
      paramByteVector.putShort(this.b.newUTF8("Deprecated")).putInt(0); 
    if (this.g != null)
      paramByteVector.putShort(this.b.newUTF8("Signature")).putInt(2).putShort(this.b.newUTF8(this.g)); 
    if (this.$ != null) {
      paramByteVector.putShort(this.b.newUTF8("MethodParameters"));
      paramByteVector.putInt(this.$.b + 1).putByte(this.Z);
      paramByteVector.putByteArray(this.$.a, 0, this.$.b);
    } 
    if (this.l != null) {
      paramByteVector.putShort(this.b.newUTF8("AnnotationDefault"));
      paramByteVector.putInt(this.l.b);
      paramByteVector.putByteArray(this.l.a, 0, this.l.b);
    } 
    if (this.m != null) {
      paramByteVector.putShort(this.b.newUTF8("RuntimeVisibleAnnotations"));
      this.m.a(paramByteVector);
    } 
    if (this.n != null) {
      paramByteVector.putShort(this.b.newUTF8("RuntimeInvisibleAnnotations"));
      this.n.a(paramByteVector);
    } 
    if (this.U != null) {
      paramByteVector.putShort(this.b.newUTF8("RuntimeVisibleTypeAnnotations"));
      this.U.a(paramByteVector);
    } 
    if (this.V != null) {
      paramByteVector.putShort(this.b.newUTF8("RuntimeInvisibleTypeAnnotations"));
      this.V.a(paramByteVector);
    } 
    if (this.o != null) {
      paramByteVector.putShort(this.b.newUTF8("RuntimeVisibleParameterAnnotations"));
      AnnotationWriter.a(this.o, this.S, paramByteVector);
    } 
    if (this.p != null) {
      paramByteVector.putShort(this.b.newUTF8("RuntimeInvisibleParameterAnnotations"));
      AnnotationWriter.a(this.p, this.S, paramByteVector);
    } 
    if (this.q != null)
      this.q.a(this.b, null, 0, -1, -1, paramByteVector); 
  }
  
  private void d() {
    int i;
    int k;
    ByteVector byteVector;
    int n;
    int i1;
    byte[] arrayOfByte = this.r.a;
    int[] arrayOfInt1 = new int[0];
    int[] arrayOfInt2 = new int[0];
    boolean[] arrayOfBoolean = new boolean[this.r.b];
    int j = 3;
    while (true) {
      if (j == 3)
        j = 2; 
      k = 0;
      while (k < arrayOfByte.length) {
        int i4;
        int i2 = arrayOfByte[k] & 0xFF;
        int i3 = 0;
        switch (ClassWriter.a[i2]) {
          case 0:
          case 4:
            k++;
            break;
          case 9:
            if (i2 > 201) {
              i2 = (i2 < 218) ? (i2 - 49) : (i2 - 20);
              n = k + c(arrayOfByte, k + 1);
            } else {
              n = k + b(arrayOfByte, k + 1);
            } 
            if (((i4 = a(arrayOfInt1, arrayOfInt2, k, n)) < -32768 || i4 > 32767) && !arrayOfBoolean[k]) {
              if (i2 == 167 || i2 == 168) {
                i3 = 2;
              } else {
                i3 = 5;
              } 
              arrayOfBoolean[k] = true;
            } 
            k += 3;
            break;
          case 10:
            k += 5;
            break;
          case 14:
            if (j == 1) {
              i3 = -((i4 = a(arrayOfInt1, arrayOfInt2, 0, k)) & 0x3);
            } else if (!arrayOfBoolean[k]) {
              i3 = k & 0x3;
              arrayOfBoolean[k] = true;
            } 
            k = (k = k + 4 - (k & 0x3)) + 4 * (a(arrayOfByte, k + 8) - a(arrayOfByte, k + 4) + 1) + 12;
            break;
          case 15:
            if (j == 1) {
              i3 = -((i4 = a(arrayOfInt1, arrayOfInt2, 0, k)) & 0x3);
            } else if (!arrayOfBoolean[k]) {
              i3 = k & 0x3;
              arrayOfBoolean[k] = true;
            } 
            k = (k = k + 4 - (k & 0x3)) + 8 * a(arrayOfByte, k + 4) + 8;
            break;
          case 17:
            if ((i2 = arrayOfByte[k + 1] & 0xFF) == 132) {
              k += 6;
              break;
            } 
            k += 4;
            break;
          case 1:
          case 3:
          case 11:
            k += 2;
            break;
          case 2:
          case 5:
          case 6:
          case 12:
          case 13:
            k += 3;
            break;
          case 7:
          case 8:
            k += 5;
            break;
          default:
            k += 4;
            break;
        } 
        if (i3 != 0) {
          int[] arrayOfInt4 = new int[arrayOfInt1.length + 1];
          int[] arrayOfInt3 = new int[arrayOfInt2.length + 1];
          System.arraycopy(arrayOfInt1, 0, arrayOfInt4, 0, arrayOfInt1.length);
          System.arraycopy(arrayOfInt2, 0, arrayOfInt3, 0, arrayOfInt2.length);
          arrayOfInt4[arrayOfInt1.length] = k;
          arrayOfInt3[arrayOfInt2.length] = i3;
          arrayOfInt1 = arrayOfInt4;
          arrayOfInt2 = arrayOfInt3;
          if (i3 > 0)
            j = 3; 
        } 
      } 
      if (j < 3)
        j--; 
      if (j == 0) {
        byteVector = new ByteVector(this.r.b);
        for (k = 0;; k += 4)
          byteVector.putByteArray(arrayOfByte, k, 4); 
        if (this.M == 0) {
          for (Label label = this.N; label != null; label = label.i) {
            if ((k = label.c - 3) >= 0 && arrayOfBoolean[k])
              label.a |= 0x10; 
            a(arrayOfInt1, arrayOfInt2, label);
          } 
          if (this.b.H != null)
            for (byte b = 0; b < this.b.H.length; b++) {
              Item item;
              if ((item = this.b.H[b]) != null && item.b == 31)
                item.c = a(arrayOfInt1, arrayOfInt2, 0, item.c); 
            }  
        } else if (this.u > 0) {
          this.b.L = true;
        } 
        for (Handler handler = this.B; handler != null; handler = handler.f) {
          a(arrayOfInt1, arrayOfInt2, handler.a);
          a(arrayOfInt1, arrayOfInt2, handler.b);
          a(arrayOfInt1, arrayOfInt2, handler.c);
        } 
        for (i = 0; i < 2; i++) {
          ByteVector byteVector1;
          if ((byteVector1 = (ByteVector)((i == 0) ? this.E : this.G)) != null) {
            arrayOfByte = byteVector1.a;
            for (k = 0; k < byteVector1.b; k += 10) {
              n = c(arrayOfByte, k);
              int i2 = a(arrayOfInt1, arrayOfInt2, 0, n);
              a(arrayOfByte, k, i2);
              n += c(arrayOfByte, k + 2);
              i2 = a(arrayOfInt1, arrayOfInt2, 0, n) - i2;
              a(arrayOfByte, k + 2, i2);
            } 
          } 
        } 
        if (this.I != null) {
          arrayOfByte = this.I.a;
          for (k = 0; k < this.I.b; k += 4)
            a(arrayOfByte, k, a(arrayOfInt1, arrayOfInt2, 0, c(arrayOfByte, k))); 
        } 
        for (Attribute attribute = this.J; attribute != null; attribute = attribute.a) {
          Label[] arrayOfLabel;
          if ((arrayOfLabel = attribute.getLabels()) != null)
            for (i = arrayOfLabel.length - 1; i >= 0; i--)
              a(arrayOfInt1, arrayOfInt2, arrayOfLabel[i]);  
        } 
        this.r = byteVector;
        return;
      } 
    } 
    int m = arrayOfByte[k] & 0xFF;
    switch (ClassWriter.a[m]) {
      case 0:
      case 4:
        byteVector.putByte(m);
        k++;
        continue;
      case 9:
        if (m > 201) {
          m = (m < 218) ? (m - 49) : (m - 20);
          n = k + c(arrayOfByte, k + 1);
        } else {
          n = k + b(arrayOfByte, k + 1);
        } 
        i1 = a(arrayOfInt1, arrayOfInt2, k, n);
        if (i[k] != 0) {
          if (m == 167) {
            byteVector.putByte(200);
          } else if (m == 168) {
            byteVector.putByte(201);
          } else {
            byteVector.putByte((m <= 166) ? ((m + 1 ^ 0x1) - 1) : (m ^ 0x1));
            byteVector.putShort(8);
            byteVector.putByte(200);
            i1 -= 3;
          } 
          byteVector.putInt(i1);
        } else {
          byteVector.putByte(m);
          byteVector.putShort(i1);
        } 
        k += 3;
        continue;
      case 10:
        n = k + a(arrayOfByte, k + 1);
        i1 = a(arrayOfInt1, arrayOfInt2, k, n);
        byteVector.putByte(m);
        byteVector.putInt(i1);
        k += 5;
        continue;
      case 14:
        j = k;
        k = k + 4 - (j & 0x3);
        byteVector.putByte(170);
        byteVector.putByteArray(null, 0, (4 - byteVector.b % 4) % 4);
        n = j + a(arrayOfByte, k);
        k += 4;
        i1 = a(arrayOfInt1, arrayOfInt2, j, n);
        byteVector.putInt(i1);
        m = a(arrayOfByte, k);
        k += 4;
        byteVector.putInt(m);
        m = a(arrayOfByte, k) - m + 1;
        k += 4;
        byteVector.putInt(a(arrayOfByte, k - 4));
        while (m > 0) {
          n = j + a(arrayOfByte, k);
          k += 4;
          i1 = a(arrayOfInt1, arrayOfInt2, j, n);
          byteVector.putInt(i1);
          m--;
        } 
        continue;
      case 15:
        j = k;
        k = k + 4 - (j & 0x3);
        byteVector.putByte(171);
        byteVector.putByteArray(null, 0, (4 - byteVector.b % 4) % 4);
        n = j + a(arrayOfByte, k);
        k += 4;
        i1 = a(arrayOfInt1, arrayOfInt2, j, n);
        byteVector.putInt(i1);
        m = a(arrayOfByte, k);
        k += 4;
        byteVector.putInt(m);
        while (m > 0) {
          byteVector.putInt(a(arrayOfByte, k));
          k += 4;
          n = j + a(arrayOfByte, k);
          k += 4;
          i1 = a(arrayOfInt1, arrayOfInt2, j, n);
          byteVector.putInt(i1);
          m--;
        } 
        continue;
      case 17:
        if ((m = arrayOfByte[k + 1] & 0xFF) == 132) {
          byteVector.putByteArray(arrayOfByte, k, 6);
          k += 6;
          continue;
        } 
        byteVector.putByteArray(arrayOfByte, k, 4);
        k += 4;
        continue;
      case 1:
      case 3:
      case 11:
        byteVector.putByteArray(arrayOfByte, k, 2);
        k += 2;
        continue;
      case 2:
      case 5:
      case 6:
      case 12:
      case 13:
        byteVector.putByteArray(arrayOfByte, k, 3);
        k += 3;
        continue;
      case 7:
      case 8:
        byteVector.putByteArray(arrayOfByte, k, 5);
        k += 5;
        continue;
    } 
    continue;
  }
  
  static int c(byte[] paramArrayOfbyte, int paramInt) {
    return (paramArrayOfbyte[paramInt] & 0xFF) << 8 | paramArrayOfbyte[paramInt + 1] & 0xFF;
  }
  
  static short b(byte[] paramArrayOfbyte, int paramInt) {
    return (short)((paramArrayOfbyte[paramInt] & 0xFF) << 8 | paramArrayOfbyte[paramInt + 1] & 0xFF);
  }
  
  static int a(byte[] paramArrayOfbyte, int paramInt) {
    return (paramArrayOfbyte[paramInt] & 0xFF) << 24 | (paramArrayOfbyte[paramInt + 1] & 0xFF) << 16 | (paramArrayOfbyte[paramInt + 2] & 0xFF) << 8 | paramArrayOfbyte[paramInt + 3] & 0xFF;
  }
  
  static void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    paramArrayOfbyte[paramInt1] = (byte)(paramInt2 >>> 8);
    paramArrayOfbyte[paramInt1 + 1] = (byte)paramInt2;
  }
  
  static int a(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt1, int paramInt2) {
    int i = paramInt2 - paramInt1;
    for (byte b = 0; b < paramArrayOfint1.length; b++) {
      if (paramInt1 < paramArrayOfint1[b] && paramArrayOfint1[b] <= paramInt2) {
        i += paramArrayOfint2[b];
      } else if (paramInt2 < paramArrayOfint1[b] && paramArrayOfint1[b] <= paramInt1) {
        i -= paramArrayOfint2[b];
      } 
    } 
    return i;
  }
  
  static void a(int[] paramArrayOfint1, int[] paramArrayOfint2, Label paramLabel) {
    if ((paramLabel.a & 0x4) == 0) {
      paramLabel.c = a(paramArrayOfint1, paramArrayOfint2, 0, paramLabel.c);
      paramLabel.a |= 0x4;
    } 
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\asm\MethodWriter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */