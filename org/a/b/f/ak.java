/*     */ package org.a.b.f;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.Calendar;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.TimeZone;
/*     */ import org.a.b.h.b;
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
/*     */ abstract class ak
/*     */   implements Closeable
/*     */ {
/*     */   public final float h() {
/*     */     float f;
/*  52 */     return f = (float)((f = d()) + c() / 65536.0D);
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
/*     */   public final String a(int paramInt) {
/*  64 */     return a(paramInt, b.a);
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
/*     */   public final String a(int paramInt, Charset paramCharset) {
/*  91 */     byte[] arrayOfByte = d(paramInt);
/*  92 */     return new String(arrayOfByte, paramCharset);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int b();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract long a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int i() {
/*     */     int i;
/* 119 */     return ((i = b()) <= 127) ? i : (i - 256);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int j() {
/*     */     int i;
/* 131 */     if ((i = b()) == -1)
/*     */     {
/* 133 */       throw new EOFException("premature EOF");
/*     */     }
/* 135 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long k() {
/* 146 */     long l1 = b();
/* 147 */     long l2 = b();
/* 148 */     long l3 = b();
/*     */     long l4;
/* 150 */     if ((l4 = b()) < 0L)
/*     */     {
/* 152 */       throw new EOFException();
/*     */     }
/* 154 */     return (l1 << 24L) + (l2 << 16L) + (l3 << 8L) + l4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int c();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int[] b(int paramInt) {
/* 174 */     int[] arrayOfInt = new int[paramInt];
/* 175 */     for (byte b = 0; b < paramInt; b++)
/*     */     {
/* 177 */       arrayOfInt[b] = b();
/*     */     }
/* 179 */     return arrayOfInt;
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
/*     */   public final int[] c(int paramInt) {
/* 191 */     int[] arrayOfInt = new int[paramInt];
/* 192 */     for (byte b = 0; b < paramInt; b++)
/*     */     {
/* 194 */       arrayOfInt[b] = c();
/*     */     }
/* 196 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract short d();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Calendar l() {
/* 215 */     long l1 = a();
/*     */     Calendar calendar;
/* 217 */     (calendar = GregorianCalendar.getInstance(TimeZone.getTimeZone("UTC"))).set(1904, 0, 1, 0, 0, 0);
/* 218 */     calendar.set(14, 0);
/*     */     
/* 220 */     long l2 = (l2 = calendar.getTimeInMillis()) + l1 * 1000L;
/* 221 */     calendar.setTimeInMillis(l2);
/* 222 */     return calendar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String m() {
/* 231 */     return new String(d(4), b.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void close();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void a(long paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final byte[] d(int paramInt) {
/* 259 */     byte[] arrayOfByte = new byte[paramInt];
/*     */     
/* 261 */     int j = 0;
/*     */     int i;
/* 263 */     while (j < paramInt && (
/* 264 */       i = a(arrayOfByte, j, paramInt - j)) != -1)
/*     */     {
/* 266 */       j += i;
/*     */     }
/* 268 */     if (j == paramInt)
/*     */     {
/* 270 */       return arrayOfByte;
/*     */     }
/*     */ 
/*     */     
/* 274 */     throw new IOException("Unexpected end of TTF stream reached");
/*     */   }
/*     */   
/*     */   public abstract int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
/*     */   
/*     */   public abstract long e();
/*     */   
/*     */   public abstract InputStream f();
/*     */   
/*     */   public abstract long g();
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */