/*     */ package org.a.c.c;
/*     */ 
/*     */ import java.io.FilterOutputStream;
/*     */ import java.io.OutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class c
/*     */   extends FilterOutputStream
/*     */ {
/*     */   private int a;
/*     */   private int b;
/*     */   private byte[] c;
/*     */   private byte[] d;
/*     */   private int e;
/*     */   private boolean f;
/*     */   private char g;
/*     */   
/*     */   c(OutputStream paramOutputStream) {
/*  56 */     super(paramOutputStream);
/*  57 */     this.a = 72;
/*  58 */     this.e = 72;
/*  59 */     this.b = 0;
/*  60 */     this.c = new byte[4];
/*  61 */     this.d = new byte[5];
/*  62 */     this.f = true;
/*  63 */     this.g = '~';
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
/*     */   private void a() {
/*     */     long l1;
/* 121 */     if ((l1 = ((this.c[0] << 8 | this.c[1] & 0xFF) << 16 | (this.c[2] & 0xFF) << 8 | this.c[3] & 0xFF) & 0xFFFFFFFFL) == 0L) {
/*     */       
/* 123 */       this.d[0] = 122;
/* 124 */       this.d[1] = 0;
/*     */       
/*     */       return;
/*     */     } 
/* 128 */     long l2 = l1 / 52200625L;
/* 129 */     this.d[0] = (byte)(int)(l2 + 33L);
/*     */ 
/*     */     
/* 132 */     l2 = (l1 = l1 - l2 * 85L * 85L * 85L * 85L) / 614125L;
/* 133 */     this.d[1] = (byte)(int)(l2 + 33L);
/*     */ 
/*     */     
/* 136 */     l2 = (l1 = l1 - l2 * 85L * 85L * 85L) / 7225L;
/* 137 */     this.d[2] = (byte)(int)(l2 + 33L);
/*     */ 
/*     */     
/* 140 */     l2 = (l1 = l1 - l2 * 85L * 85L) / 85L;
/* 141 */     this.d[3] = (byte)(int)(l2 + 33L);
/*     */     
/* 143 */     this.d[4] = (byte)(int)(l1 % 85L + 33L);
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
/*     */   public final void write(int paramInt) {
/* 156 */     this.f = false;
/* 157 */     this.c[this.b++] = (byte)paramInt;
/* 158 */     if (this.b < 4) {
/*     */       return;
/*     */     }
/*     */     
/* 162 */     a();
/* 163 */     for (paramInt = 0; paramInt < 5;) {
/*     */       
/* 165 */       if (this.d[paramInt] != 0) {
/*     */ 
/*     */ 
/*     */         
/* 169 */         this.out.write(this.d[paramInt]);
/* 170 */         if (--this.a == 0) {
/*     */           
/* 172 */           this.out.write(10);
/* 173 */           this.a = this.e;
/*     */         }  paramInt++;
/*     */       } 
/* 176 */     }  this.b = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void flush() {
/* 187 */     if (this.f) {
/*     */       return;
/*     */     }
/*     */     
/* 191 */     if (this.b > 0) {
/*     */       int i;
/* 193 */       for (i = this.b; i < 4; i++)
/*     */       {
/* 195 */         this.c[i] = 0;
/*     */       }
/* 197 */       a();
/* 198 */       if (this.d[0] == 122)
/*     */       {
/* 200 */         for (i = 0; i < 5; i++)
/*     */         {
/* 202 */           this.d[i] = 33;
/*     */         }
/*     */       }
/* 205 */       for (i = 0; i < this.b + 1; i++) {
/*     */         
/* 207 */         this.out.write(this.d[i]);
/* 208 */         if (--this.a == 0) {
/*     */           
/* 210 */           this.out.write(10);
/* 211 */           this.a = this.e;
/*     */         } 
/*     */       } 
/*     */     } 
/* 215 */     if (--this.a == 0)
/*     */     {
/* 217 */       this.out.write(10);
/*     */     }
/* 219 */     this.out.write(this.g);
/* 220 */     this.out.write(62);
/* 221 */     this.out.write(10);
/* 222 */     this.b = 0;
/* 223 */     this.a = this.e;
/* 224 */     this.f = true;
/* 225 */     super.flush();
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
/*     */   public final void close() {
/*     */     try {
/* 238 */       flush();
/* 239 */       super.close();
/*     */       
/*     */       return;
/*     */     } finally {
/* 243 */       this.c = this.d = null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */