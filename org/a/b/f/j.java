/*     */ package org.a.b.f;
/*     */ 
/*     */ import org.a.a.a.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class j
/*     */   extends i
/*     */ {
/*     */   private int[] a;
/*     */   private byte[] b;
/*     */   private short[] c;
/*     */   private short[] d;
/*     */   private final int e;
/*     */   
/*     */   static {
/*  35 */     c.a(j.class);
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
/*     */   public j(short paramShort1, ak paramak, short paramShort2) {
/*  53 */     super(paramShort1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  60 */     if (paramShort1 == 0) {
/*     */       
/*  62 */       this.e = 0;
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  67 */     this.a = paramak.c(paramShort1);
/*     */     
/*  69 */     int m = this.a[paramShort1 - 1];
/*  70 */     if (paramShort1 == 1 && m == 65535) {
/*     */ 
/*     */       
/*  73 */       this.e = 0;
/*     */       
/*     */       return;
/*     */     } 
/*  77 */     this.e = m + 1;
/*     */     
/*  79 */     this.b = new byte[this.e];
/*  80 */     this.c = new short[this.e];
/*  81 */     this.d = new short[this.e];
/*     */     
/*  83 */     int k = paramak.c();
/*  84 */     a(paramak, k);
/*  85 */     a(this.e, paramak);
/*  86 */     a(this.e, paramak, paramShort2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a(int paramInt) {
/*  95 */     return this.a[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final byte b(int paramInt) {
/* 104 */     return this.b[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final short c(int paramInt) {
/* 113 */     return this.c[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final short d(int paramInt) {
/* 122 */     return this.d[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean b() {
/* 131 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int c() {
/* 140 */     return this.e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(int paramInt, ak paramak, short paramShort) {
/* 148 */     paramShort = paramShort;
/* 149 */     short s = 0; byte b;
/* 150 */     for (b = 0; b < paramInt; b++) {
/*     */       
/* 152 */       if ((this.b[b] & 0x10) != 0) {
/*     */         
/* 154 */         if ((this.b[b] & 0x2) != 0)
/*     */         {
/* 156 */           paramShort = (short)(paramShort + (short)paramak.j());
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 161 */       else if ((this.b[b] & 0x2) != 0) {
/*     */         
/* 163 */         paramShort = (short)(paramShort + (short)-((short)paramak.j()));
/*     */       }
/*     */       else {
/*     */         
/* 167 */         paramShort = (short)(paramShort + paramak.d());
/*     */       } 
/*     */       
/* 170 */       this.c[b] = paramShort;
/*     */     } 
/*     */     
/* 173 */     for (b = 0; b < paramInt; b++) {
/*     */       
/* 175 */       if ((this.b[b] & 0x20) != 0) {
/*     */         
/* 177 */         if ((this.b[b] & 0x4) != 0)
/*     */         {
/* 179 */           s = (short)(s + (short)paramak.j());
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 184 */       else if ((this.b[b] & 0x4) != 0) {
/*     */         
/* 186 */         s = (short)(s + (short)-((short)paramak.j()));
/*     */       }
/*     */       else {
/*     */         
/* 190 */         s = (short)(s + paramak.d());
/*     */       } 
/*     */       
/* 193 */       this.d[b] = s;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(int paramInt, ak paramak) {
/* 202 */     for (int k = 0; k < paramInt; k++) {
/*     */       
/* 204 */       this.b[k] = (byte)paramak.j();
/* 205 */       if ((this.b[k] & 0x8) != 0) {
/*     */         
/* 207 */         int m = paramak.j();
/* 208 */         for (byte b = 1; b <= m && k + b < this.b.length; b++)
/*     */         {
/* 210 */           this.b[k + b] = this.b[k];
/*     */         }
/* 212 */         k += m;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */