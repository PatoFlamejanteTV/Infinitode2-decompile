/*     */ package org.a.c.d;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import org.a.a.a.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends InputStream
/*     */ {
/*  33 */   private static final a a = org.a.a.a.c.a(c.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private final e b;
/*     */ 
/*     */ 
/*     */   
/*     */   private long c;
/*     */ 
/*     */ 
/*     */   
/*     */   public c(e parame) {
/*  46 */     this.b = parame;
/*  47 */     this.c = 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a() {
/*  52 */     this.b.a(this.c);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int available() {
/*  58 */     a();
/*     */     long l;
/*  60 */     if ((l = this.b.c() - this.b.a()) > 2147483647L)
/*     */     {
/*  62 */       return Integer.MAX_VALUE;
/*     */     }
/*  64 */     return (int)l;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int read() {
/*  70 */     a();
/*  71 */     if (this.b.e())
/*     */     {
/*  73 */       return -1;
/*     */     }
/*     */     int i;
/*  76 */     if ((i = this.b.b()) != -1) {
/*     */       
/*  78 */       this.c++;
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/*  84 */       (new StringBuilder("read() returns -1, assumed position: ")).append(this.c).append(", actual position: ")
/*  85 */         .append(this.b.a());
/*     */     } 
/*  87 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  93 */     a();
/*  94 */     if (this.b.e())
/*     */     {
/*  96 */       return -1;
/*     */     }
/*     */     int i;
/*  99 */     if ((i = this.b.a(paramArrayOfbyte, paramInt1, paramInt2)) != -1) {
/*     */       
/* 101 */       this.c += i;
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 107 */       (new StringBuilder("read() returns -1, assumed position: ")).append(this.c).append(", actual position: ")
/* 108 */         .append(this.b.a());
/*     */     } 
/* 110 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long skip(long paramLong) {
/* 116 */     a();
/* 117 */     this.b.a(this.c + paramLong);
/* 118 */     this.c += paramLong;
/* 119 */     return paramLong;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */