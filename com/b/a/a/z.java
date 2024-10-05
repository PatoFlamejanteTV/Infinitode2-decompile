/*     */ package com.b.a.a;
/*     */ 
/*     */ import com.b.a.d.c;
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
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
/*     */ public final class z
/*     */ {
/*     */   private int[] b;
/*     */   private int[] c;
/*     */   private byte[] d;
/*     */   private byte[] e;
/*     */   private x f;
/*     */   public static final z a;
/*     */   
/*     */   private z() {
/*  38 */     ByteBuffer byteBuffer = f.a("ubidi.icu");
/*  39 */     a(byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(ByteBuffer paramByteBuffer) {
/*  44 */     f.b(paramByteBuffer, 1114195049, new a((byte)0));
/*     */ 
/*     */     
/*     */     int j;
/*     */     
/*  49 */     if ((j = paramByteBuffer.getInt()) < 16) {
/*  50 */       throw new IOException("indexes[0] too small in ubidi.icu");
/*     */     }
/*  52 */     this.b = new int[j];
/*     */     
/*  54 */     this.b[0] = j; int i;
/*  55 */     for (i = 1; i < j; i++) {
/*  56 */       this.b[i] = paramByteBuffer.getInt();
/*     */     }
/*     */ 
/*     */     
/*  60 */     this.f = x.b(paramByteBuffer);
/*  61 */     i = this.b[2];
/*     */     
/*  63 */     if ((j = this.f.b()) > i) {
/*  64 */       throw new IOException("ubidi.icu: not enough bytes for the trie");
/*     */     }
/*     */     
/*  67 */     f.a(paramByteBuffer, i - j);
/*     */ 
/*     */ 
/*     */     
/*  71 */     if ((j = this.b[3]) > 0) {
/*  72 */       this.c = f.c(paramByteBuffer, j, 0);
/*     */     }
/*     */ 
/*     */     
/*  76 */     j = this.b[5] - this.b[4];
/*  77 */     this.d = new byte[j];
/*  78 */     paramByteBuffer.get(this.d);
/*     */ 
/*     */     
/*  81 */     j = this.b[7] - this.b[6];
/*  82 */     this.e = new byte[j];
/*  83 */     paramByteBuffer.get(this.e);
/*     */   }
/*     */   
/*     */   static final class a implements f.a {
/*     */     private a() {}
/*     */     
/*     */     public final boolean a(byte[] param1ArrayOfbyte) {
/*  90 */       return (param1ArrayOfbyte[0] == 2);
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
/*     */   
/*     */   public final int a(int paramInt) {
/* 171 */     return j(this.f.a(paramInt));
/*     */   }
/*     */   
/*     */   public final boolean b(int paramInt) {
/* 175 */     return b(this.f.a(paramInt), 12);
/*     */   }
/*     */ 
/*     */   
/*     */   private final int a(int paramInt1, int paramInt2) {
/* 180 */     if ((paramInt2 = k(paramInt2)) != -4) {
/* 181 */       return paramInt1 + paramInt2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 188 */     int i = this.b[3];
/*     */ 
/*     */     
/* 191 */     for (byte b = 0; b < i; ) {
/*     */       
/* 193 */       int j = l(paramInt2 = this.c[b]);
/* 194 */       if (paramInt1 == j)
/*     */       {
/* 196 */         return l(this.c[m(paramInt2)]); } 
/* 197 */       if (paramInt1 >= j) {
/*     */         b++;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 203 */     return paramInt1;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int c(int paramInt) {
/* 208 */     int i = this.f.a(paramInt);
/* 209 */     return a(paramInt, i);
/*     */   }
/*     */   
/*     */   public final boolean d(int paramInt) {
/* 213 */     return b(this.f.a(paramInt), 11);
/*     */   }
/*     */   
/*     */   public final boolean e(int paramInt) {
/* 217 */     return b(this.f.a(paramInt), 10);
/*     */   }
/*     */   
/*     */   public final int f(int paramInt) {
/* 221 */     return (this.f.a(paramInt) & 0xE0) >> 5;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int g(int paramInt) {
/* 227 */     int i = this.b[4];
/* 228 */     int j = this.b[5];
/* 229 */     if (i <= paramInt && paramInt < j) {
/* 230 */       return this.d[paramInt - i] & 0xFF;
/*     */     }
/* 232 */     i = this.b[6];
/* 233 */     j = this.b[7];
/* 234 */     if (i <= paramInt && paramInt < j) {
/* 235 */       return this.e[paramInt - i] & 0xFF;
/*     */     }
/* 237 */     return 0;
/*     */   }
/*     */   
/*     */   public final int h(int paramInt) {
/* 241 */     return (this.f.a(paramInt) & 0x300) >> 8;
/*     */   }
/*     */   
/*     */   public final int i(int paramInt) {
/*     */     int i;
/* 246 */     if (((i = this.f.a(paramInt)) & 0x300) == 0) {
/* 247 */       return paramInt;
/*     */     }
/* 249 */     return a(paramInt, i);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int j(int paramInt) {
/* 305 */     return paramInt & 0x1F;
/*     */   }
/*     */   private static final boolean b(int paramInt1, int paramInt2) {
/* 308 */     return ((paramInt1 >> paramInt2 & 0x1) != 0);
/*     */   }
/*     */   private static final int k(int paramInt) {
/* 311 */     return (short)paramInt >> 13;
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
/*     */   private static final int l(int paramInt) {
/* 325 */     return paramInt & 0x1FFFFF;
/*     */   }
/*     */   private static final int m(int paramInt) {
/* 328 */     return paramInt >>> 21;
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
/*     */   static {
/*     */     try {
/* 341 */       a = new z(); return;
/* 342 */     } catch (IOException iOException) {
/* 343 */       throw new c(iOException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\b\a\a\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */