/*     */ package b.a.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class m
/*     */ {
/*     */   private Float a;
/*     */   private int b;
/*     */   private byte[] c;
/*     */   private int[] d;
/*     */   private boolean e;
/*     */   
/*     */   public m(int paramInt, boolean paramBoolean) {
/*  45 */     this.b = paramInt;
/*  46 */     this.e = false;
/*  47 */     this.c = new byte[paramInt * 2304];
/*  48 */     this.d = new int[paramInt];
/*  49 */     b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(int paramInt, short paramShort) {
/*     */     byte b;
/*  58 */     if (this.e) {
/*  59 */       b = (byte)(paramShort >>> 8);
/*  60 */       paramShort = (byte)paramShort;
/*     */     } else {
/*  62 */       b = (byte)paramShort;
/*  63 */       paramShort = (byte)(paramShort >>> 8);
/*     */     } 
/*  65 */     this.c[this.d[paramInt]] = b;
/*  66 */     this.c[this.d[paramInt] + 1] = paramShort;
/*  67 */     this.d[paramInt] = this.d[paramInt] + (this.b << 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(int paramInt, float[] paramArrayOffloat) {
/*  75 */     if (this.a != null) {
/*  76 */       for (byte b1 = 0; b1 < 32; ) {
/*  77 */         short s = a(paramArrayOffloat[b1++] * this.a.floatValue());
/*  78 */         a(paramInt, s);
/*     */       }  return;
/*     */     } 
/*  81 */     for (byte b = 0; b < 32; ) {
/*  82 */       short s = a(paramArrayOffloat[b++]);
/*  83 */       a(paramInt, s);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final byte[] a() {
/*  89 */     return this.c;
/*     */   }
/*     */   
/*     */   public final int b() {
/*     */     
/*  94 */     try { int i = this.b - 1;
/*  95 */       i = this.d[i] - (i << 1);
/*     */ 
/*     */       
/*  98 */       return i; } finally { for (byte b = 0; b < this.b; b++) {
/*  99 */         this.d[b] = b << 1;
/*     */       } }
/*     */   
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
/*     */   private static short a(float paramFloat) {
/* 113 */     return (paramFloat > 32767.0F) ? Short.MAX_VALUE : ((paramFloat < -32768.0F) ? Short.MIN_VALUE : (short)(int)paramFloat);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\b\a\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */