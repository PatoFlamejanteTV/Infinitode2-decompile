/*     */ package org.a.c.c;
/*     */ 
/*     */ import java.io.FilterOutputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Arrays;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
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
/*     */ public class t
/*     */ {
/*     */   static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  53 */     if (paramInt1 == 1) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  59 */     int i = ((i = paramInt2 * paramInt3) + 7) / 8;
/*  60 */     int j = paramArrayOfbyte1.length;
/*  61 */     switch (paramInt1) {
/*     */ 
/*     */       
/*     */       case 2:
/*  65 */         if (paramInt3 == 8) {
/*     */ 
/*     */           
/*  68 */           for (paramInt1 = i; paramInt1 < j; paramInt1++) {
/*     */             
/*  70 */             paramInt4 = paramArrayOfbyte1[paramInt1] & 0xFF;
/*  71 */             int k = paramArrayOfbyte1[paramInt1 - i] & 0xFF;
/*  72 */             paramArrayOfbyte1[paramInt1] = (byte)(paramInt4 + k);
/*     */           } 
/*     */           return;
/*     */         } 
/*  76 */         if (paramInt3 == 16) {
/*     */           
/*  78 */           for (paramInt1 = i; paramInt1 < j; paramInt1 += 2) {
/*     */             
/*  80 */             paramInt4 = ((paramArrayOfbyte1[paramInt1] & 0xFF) << 8) + (paramArrayOfbyte1[paramInt1 + 1] & 0xFF);
/*  81 */             int k = ((paramArrayOfbyte1[paramInt1 - i] & 0xFF) << 8) + (paramArrayOfbyte1[paramInt1 - i + 1] & 0xFF);
/*     */             
/*  83 */             paramArrayOfbyte1[paramInt1] = (byte)(paramInt4 + k >> 8);
/*  84 */             paramArrayOfbyte1[paramInt1 + 1] = (byte)(paramInt4 + k);
/*     */           } 
/*     */           return;
/*     */         } 
/*  88 */         if (paramInt3 == 1 && paramInt2 == 1) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  94 */           for (paramInt1 = 0; paramInt1 < j; paramInt1++) {
/*     */             
/*  96 */             for (paramInt4 = 7; paramInt4 >= 0; paramInt4--) {
/*     */               
/*  98 */               int k = paramArrayOfbyte1[paramInt1] >> paramInt4 & 0x1;
/*  99 */               if (paramInt1 != 0 || paramInt4 != 7) {
/*     */                 int m;
/*     */ 
/*     */ 
/*     */                 
/* 104 */                 if (paramInt4 == 7) {
/*     */ 
/*     */                   
/* 107 */                   m = paramArrayOfbyte1[paramInt1 - 1] & 0x1;
/*     */                 
/*     */                 }
/*     */                 else {
/*     */                   
/* 112 */                   m = paramArrayOfbyte1[paramInt1] >> paramInt4 + 1 & 0x1;
/*     */                 } 
/* 114 */                 if ((k + m & 0x1) == 0) {
/*     */ 
/*     */                   
/* 117 */                   paramArrayOfbyte1[paramInt1] = (byte)(paramArrayOfbyte1[paramInt1] & (1 << paramInt4 ^ 0xFFFFFFFF));
/*     */                 
/*     */                 }
/*     */                 else {
/*     */                   
/* 122 */                   paramArrayOfbyte1[paramInt1] = (byte)(paramArrayOfbyte1[paramInt1] | 1 << paramInt4);
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           return;
/*     */         } 
/* 129 */         paramInt1 = paramInt4 * paramInt2;
/* 130 */         for (paramInt4 = paramInt2; paramInt4 < paramInt1; paramInt4++) {
/*     */           
/* 132 */           int k = paramInt4 * paramInt3 / 8;
/* 133 */           int m = 8 - paramInt4 * paramInt3 % 8 - paramInt3;
/* 134 */           int n = (paramInt4 - paramInt2) * paramInt3 / 8;
/* 135 */           int i1 = 8 - (paramInt4 - paramInt2) * paramInt3 % 8 - paramInt3;
/*     */           
/* 137 */           int i2 = b(paramArrayOfbyte1[k], m, paramInt3);
/* 138 */           int i3 = b(paramArrayOfbyte1[n], i1, paramInt3);
/* 139 */           paramArrayOfbyte1[k] = (byte)a(paramArrayOfbyte1[k], m, paramInt3, i2 + i3);
/*     */         } 
/*     */         return;
/*     */ 
/*     */       
/*     */       case 10:
/*     */         return;
/*     */       
/*     */       case 11:
/* 148 */         for (paramInt4 = i; paramInt4 < j; paramInt4++) {
/*     */           
/* 150 */           byte b1 = paramArrayOfbyte1[paramInt4];
/* 151 */           byte b2 = paramArrayOfbyte1[paramInt4 - i];
/* 152 */           paramArrayOfbyte1[paramInt4] = (byte)(b1 + b2);
/*     */         } 
/*     */         return;
/*     */       
/*     */       case 12:
/* 157 */         for (paramInt4 = 0; paramInt4 < j; paramInt4++) {
/*     */           
/* 159 */           int k = paramArrayOfbyte1[paramInt4] & 0xFF;
/* 160 */           int m = paramArrayOfbyte2[paramInt4] & 0xFF;
/* 161 */           paramArrayOfbyte1[paramInt4] = (byte)(k + m);
/*     */         } 
/*     */         return;
/*     */       
/*     */       case 13:
/* 166 */         for (paramInt4 = 0; paramInt4 < j; paramInt4++) {
/*     */           
/* 168 */           int k = paramArrayOfbyte1[paramInt4] & 0xFF;
/* 169 */           byte b = (paramInt4 - i >= 0) ? (paramArrayOfbyte1[paramInt4 - i] & 0xFF) : 0;
/* 170 */           int m = paramArrayOfbyte2[paramInt4] & 0xFF;
/* 171 */           paramArrayOfbyte1[paramInt4] = (byte)(k + (b + m) / 2);
/*     */         } 
/*     */         return;
/*     */       
/*     */       case 14:
/* 176 */         for (paramInt4 = 0; paramInt4 < j; paramInt4++) {
/*     */           
/* 178 */           int k = paramArrayOfbyte1[paramInt4] & 0xFF;
/* 179 */           byte b1 = (paramInt4 - i >= 0) ? (paramArrayOfbyte1[paramInt4 - i] & 0xFF) : 0;
/* 180 */           int m = paramArrayOfbyte2[paramInt4] & 0xFF;
/* 181 */           byte b2 = (paramInt4 - i >= 0) ? (paramArrayOfbyte2[paramInt4 - i] & 0xFF) : 0;
/*     */           
/* 183 */           int n, i1 = Math.abs((n = b1 + m - b2) - b1);
/* 184 */           paramInt1 = Math.abs(n - m);
/* 185 */           paramInt2 = Math.abs(n - b2);
/*     */           
/* 187 */           if (i1 <= paramInt1 && i1 <= paramInt2) {
/*     */             
/* 189 */             paramArrayOfbyte1[paramInt4] = (byte)(k + b1);
/*     */           }
/* 191 */           else if (paramInt1 <= paramInt2) {
/*     */             
/* 193 */             paramArrayOfbyte1[paramInt4] = (byte)(k + m);
/*     */           }
/*     */           else {
/*     */             
/* 197 */             paramArrayOfbyte1[paramInt4] = (byte)(k + b2);
/*     */           } 
/*     */         } 
/*     */         break;
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
/*     */   static int a(int paramInt1, int paramInt2, int paramInt3) {
/* 255 */     paramInt1 *= paramInt2;
/* 256 */     return (paramInt3 * paramInt1 + 7) / 8;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int b(int paramInt1, int paramInt2, int paramInt3) {
/* 262 */     paramInt3 = (1 << paramInt3) - 1;
/* 263 */     return paramInt1 >>> paramInt2 & paramInt3;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 269 */     paramInt3 = (1 << paramInt3) - 1;
/* 270 */     paramInt4 &= paramInt3;
/* 271 */     paramInt3 = paramInt3 << paramInt2 ^ 0xFFFFFFFF;
/* 272 */     return paramInt1 & paramInt3 | paramInt4 << paramInt2;
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
/*     */   static OutputStream a(OutputStream paramOutputStream, d paramd) {
/*     */     int i;
/* 287 */     if ((i = paramd.j(j.cT)) > 1) {
/*     */       
/* 289 */       int k = Math.min(paramd.b(j.ab, 1), 32);
/* 290 */       int m = paramd.b(j.z, 8);
/* 291 */       int j = paramd.b(j.ad, 1);
/*     */       
/* 293 */       return new a(paramOutputStream, i, k, m, j);
/*     */     } 
/*     */ 
/*     */     
/* 297 */     return paramOutputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static final class a
/*     */     extends FilterOutputStream
/*     */   {
/*     */     private int a;
/*     */ 
/*     */     
/*     */     private final int b;
/*     */     
/*     */     private final int c;
/*     */     
/*     */     private final int d;
/*     */     
/*     */     private final int e;
/*     */     
/*     */     private final boolean f;
/*     */     
/*     */     private byte[] g;
/*     */     
/*     */     private byte[] h;
/*     */     
/* 322 */     private int i = 0;
/*     */     
/*     */     private boolean j = false;
/*     */ 
/*     */     
/*     */     a(OutputStream param1OutputStream, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 328 */       super(param1OutputStream);
/* 329 */       this.a = param1Int1;
/* 330 */       this.b = param1Int2;
/* 331 */       this.c = param1Int3;
/* 332 */       this.d = param1Int4;
/* 333 */       this.e = t.a(param1Int2, param1Int3, param1Int4);
/* 334 */       this.f = (param1Int1 >= 10);
/* 335 */       this.g = new byte[this.e];
/* 336 */       this.h = new byte[this.e];
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final void write(byte[] param1ArrayOfbyte) {
/* 342 */       write(param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 348 */       int i = param1Int1;
/* 349 */       param1Int1 += param1Int2;
/* 350 */       while (i < param1Int1) {
/*     */         
/* 352 */         if (this.f && this.i == 0 && !this.j) {
/*     */ 
/*     */ 
/*     */           
/* 356 */           this.a = param1ArrayOfbyte[i] + 10;
/* 357 */           i++;
/* 358 */           this.j = true;
/*     */           
/*     */           continue;
/*     */         } 
/* 362 */         param1Int2 = Math.min(this.e - this.i, param1Int1 - i);
/* 363 */         System.arraycopy(param1ArrayOfbyte, i, this.g, this.i, param1Int2);
/* 364 */         this.i += param1Int2;
/* 365 */         i += param1Int2;
/*     */ 
/*     */ 
/*     */         
/* 369 */         if (this.i == this.g.length)
/*     */         {
/* 371 */           a();
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void a() {
/* 379 */       t.a(this.a, this.b, this.c, this.d, this.g, this.h);
/* 380 */       this.out.write(this.g);
/* 381 */       b();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void b() {
/* 390 */       byte[] arrayOfByte = this.h;
/* 391 */       this.h = this.g;
/* 392 */       this.g = arrayOfByte;
/* 393 */       this.i = 0;
/* 394 */       this.j = false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void flush() {
/* 401 */       if (this.i > 0) {
/*     */         
/* 403 */         Arrays.fill(this.g, this.i, this.e, (byte)0);
/* 404 */         a();
/*     */       } 
/* 406 */       super.flush();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final void write(int param1Int) {
/* 412 */       throw new UnsupportedOperationException("Not supported");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\c\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */