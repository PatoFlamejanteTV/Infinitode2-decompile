/*     */ package org.a.c.b;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.math.BigDecimal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class f
/*     */   extends l
/*     */ {
/*     */   private BigDecimal a;
/*     */   private String b;
/*     */   
/*     */   public f(float paramFloat) {
/*  43 */     this.a = new BigDecimal(String.valueOf(paramFloat));
/*  44 */     this.b = b(this.a.toPlainString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public f(String paramString) {
/*     */     try {
/*  58 */       this.b = paramString;
/*  59 */       this.a = new BigDecimal(this.b);
/*  60 */       d();
/*     */       return;
/*  62 */     } catch (NumberFormatException numberFormatException) {
/*     */       
/*  64 */       if (paramString.startsWith("--")) {
/*     */ 
/*     */         
/*  67 */         this.b = paramString.substring(1);
/*     */       }
/*  69 */       else if (paramString.matches("^0\\.0*\\-\\d+")) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  74 */         this.b = "-" + this.b.replaceFirst("\\-", "");
/*     */       }
/*     */       else {
/*     */         
/*  78 */         throw new IOException("Error expected floating point number actual='" + paramString + "'", numberFormatException);
/*     */       } 
/*     */       
/*     */       try {
/*  82 */         this.a = new BigDecimal(this.b);
/*  83 */         d();
/*     */         return;
/*  85 */       } catch (NumberFormatException numberFormatException1) {
/*     */         
/*  87 */         throw new IOException("Error expected floating point number actual='" + paramString + "'", numberFormatException1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void d() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield a : Ljava/math/BigDecimal;
/*     */     //   4: invokevirtual floatValue : ()F
/*     */     //   7: fstore_1
/*     */     //   8: aload_0
/*     */     //   9: getfield a : Ljava/math/BigDecimal;
/*     */     //   12: invokevirtual doubleValue : ()D
/*     */     //   15: dstore_2
/*     */     //   16: iconst_0
/*     */     //   17: istore #4
/*     */     //   19: fload_1
/*     */     //   20: ldc -Infinity
/*     */     //   22: fcmpl
/*     */     //   23: ifeq -> 33
/*     */     //   26: fload_1
/*     */     //   27: ldc Infinity
/*     */     //   29: fcmpl
/*     */     //   30: ifne -> 62
/*     */     //   33: dload_2
/*     */     //   34: invokestatic abs : (D)D
/*     */     //   37: ldc2_w 3.4028234663852886E38
/*     */     //   40: dcmpl
/*     */     //   41: ifle -> 104
/*     */     //   44: ldc 3.4028235E38
/*     */     //   46: fload_1
/*     */     //   47: ldc Infinity
/*     */     //   49: fcmpl
/*     */     //   50: ifne -> 57
/*     */     //   53: iconst_1
/*     */     //   54: goto -> 58
/*     */     //   57: iconst_m1
/*     */     //   58: i2f
/*     */     //   59: goto -> 99
/*     */     //   62: fload_1
/*     */     //   63: fconst_0
/*     */     //   64: fcmpl
/*     */     //   65: ifne -> 104
/*     */     //   68: dload_2
/*     */     //   69: dconst_0
/*     */     //   70: dcmpl
/*     */     //   71: ifeq -> 104
/*     */     //   74: dload_2
/*     */     //   75: invokestatic abs : (D)D
/*     */     //   78: ldc2_w 1.1754943508222875E-38
/*     */     //   81: dcmpg
/*     */     //   82: ifge -> 104
/*     */     //   85: ldc 1.1754944E-38
/*     */     //   87: dload_2
/*     */     //   88: dconst_0
/*     */     //   89: dcmpl
/*     */     //   90: iflt -> 97
/*     */     //   93: fconst_1
/*     */     //   94: goto -> 99
/*     */     //   97: ldc -1.0
/*     */     //   99: fmul
/*     */     //   100: fstore_1
/*     */     //   101: iconst_1
/*     */     //   102: istore #4
/*     */     //   104: iload #4
/*     */     //   106: ifeq -> 136
/*     */     //   109: aload_0
/*     */     //   110: new java/math/BigDecimal
/*     */     //   113: dup
/*     */     //   114: fload_1
/*     */     //   115: f2d
/*     */     //   116: invokespecial <init> : (D)V
/*     */     //   119: putfield a : Ljava/math/BigDecimal;
/*     */     //   122: aload_0
/*     */     //   123: dup
/*     */     //   124: getfield a : Ljava/math/BigDecimal;
/*     */     //   127: invokevirtual toPlainString : ()Ljava/lang/String;
/*     */     //   130: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   133: putfield b : Ljava/lang/String;
/*     */     //   136: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #94	-> 0
/*     */     //   #95	-> 8
/*     */     //   #96	-> 16
/*     */     //   #98	-> 19
/*     */     //   #101	-> 33
/*     */     //   #103	-> 44
/*     */     //   #104	-> 59
/*     */     //   #108	-> 62
/*     */     //   #110	-> 74
/*     */     //   #113	-> 85
/*     */     //   #114	-> 101
/*     */     //   #117	-> 104
/*     */     //   #119	-> 109
/*     */     //   #120	-> 122
/*     */     //   #122	-> 136
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String b(String paramString) {
/* 127 */     if (paramString.indexOf('.') >= 0 && !paramString.endsWith(".0"))
/*     */     {
/* 129 */       while (paramString.endsWith("0") && !paramString.endsWith(".0"))
/*     */       {
/* 131 */         paramString = paramString.substring(0, paramString.length() - 1);
/*     */       }
/*     */     }
/* 134 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float a() {
/* 145 */     return this.a.floatValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long b() {
/* 167 */     return this.a.longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int c() {
/* 178 */     return this.a.intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 187 */     if (paramObject instanceof f && 
/* 188 */       Float.floatToIntBits(((f)paramObject).a.floatValue()) == Float.floatToIntBits(this.a.floatValue())) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 197 */     return this.a.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 206 */     return "COSFloat{" + this.b + "}";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(u paramu) {
/* 219 */     return paramu.a(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(OutputStream paramOutputStream) {
/* 230 */     paramOutputStream.write(this.b.getBytes("ISO-8859-1"));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */