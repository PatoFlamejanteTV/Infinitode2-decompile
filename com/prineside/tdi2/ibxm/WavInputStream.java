/*     */ package com.prineside.tdi2.ibxm;
/*     */ 
/*     */ import com.prineside.tdi2.utils.IgnoreMethodOverloadLuaDefWarning;
/*     */ import java.io.InputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WavInputStream
/*     */   extends InputStream
/*     */ {
/*     */   public enum Mode
/*     */   {
/*  13 */     FULL_SONG,
/*  14 */     INTRO_PART,
/*  15 */     LOOPING_PART; static {
/*     */     
/*  17 */     } public static final Mode[] values = values();
/*     */   }
/*     */   
/*  20 */   public static final byte[] header = new byte[] { 82, 73, 70, 70, 0, 0, 0, 0, 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 16, 0, 100, 97, 116, 97, 0, 0, 0, 0 };
/*     */ 
/*     */   
/*     */   private IBXM a;
/*     */ 
/*     */   
/*     */   private int[] b;
/*     */ 
/*     */   
/*     */   private byte[] c;
/*     */ 
/*     */   
/*     */   private int d;
/*     */ 
/*     */   
/*     */   private int e;
/*     */ 
/*     */   
/*     */   private int f;
/*     */   
/*     */   private int g;
/*     */ 
/*     */   
/*     */   public WavInputStream(IBXM paramIBXM, int paramInt, Mode paramMode) {
/*  44 */     int j = -1;
/*  45 */     int k = 0;
/*  46 */     if ((paramIBXM.getModule()).restartPos != 0)
/*     */     {
/*  48 */       if (paramMode == Mode.INTRO_PART && (paramIBXM.getModule()).restartPos != 0) {
/*  49 */         j = 0;
/*  50 */         k = (paramIBXM.getModule()).restartPos - 1;
/*  51 */       } else if (paramMode == Mode.LOOPING_PART) {
/*  52 */         j = (paramIBXM.getModule()).restartPos;
/*  53 */         k = (paramIBXM.getModule()).sequenceLength - 1;
/*     */       } 
/*     */     }
/*  56 */     if (j != -1) {
/*     */       Module module;
/*     */       
/*  59 */       (module = new Module(paramIBXM.getModule())).sequenceLength = k - j + 1;
/*     */       
/*  61 */       int[] arrayOfInt = module.sequence;
/*  62 */       module.sequence = new int[module.sequenceLength];
/*  63 */       System.arraycopy(arrayOfInt, j, module.sequence, 0, module.sequenceLength);
/*     */       
/*  65 */       j = paramIBXM.interpolation;
/*     */       
/*  67 */       (paramIBXM = new IBXM(module, paramIBXM.getSampleRate())).setInterpolation(j);
/*     */     } 
/*     */     
/*  70 */     int i = paramIBXM.calculateSongDuration();
/*     */     
/*  72 */     this.a = paramIBXM;
/*  73 */     this.b = new int[paramIBXM.getMixBufferLength()];
/*  74 */     this.c = new byte[this.b.length << 1];
/*  75 */     k = i << 2;
/*  76 */     j = paramIBXM.getSampleRate();
/*  77 */     System.arraycopy(header, 0, this.c, 0, header.length);
/*  78 */     writeInt32(this.c, 4, k + 36);
/*  79 */     writeInt32(this.c, 24, j);
/*  80 */     writeInt32(this.c, 28, j << 2);
/*  81 */     writeInt32(this.c, 40, k);
/*  82 */     this.d = 0;
/*  83 */     this.e = header.length;
/*  84 */     this.f = header.length + k;
/*  85 */     this.g = (j << 2) * paramInt;
/*     */   }
/*     */   
/*     */   public int getRemain() {
/*  89 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int available() {
/*  99 */     return this.e - this.d;
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public int read() {
/* 105 */     byte b = -1;
/* 106 */     if (this.f > 0) {
/* 107 */       b = this.c[this.d++];
/* 108 */       if (this.d >= this.e) {
/* 109 */         a();
/*     */       }
/* 111 */       this.f--;
/*     */     } 
/* 113 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 119 */     int i = -1;
/* 120 */     if (this.f > 0) {
/*     */       
/* 122 */       if ((i = this.f) > paramInt2) {
/* 123 */         i = paramInt2;
/*     */       }
/* 125 */       paramInt2 = this.e - this.d;
/* 126 */       if (i > paramInt2) {
/* 127 */         i = paramInt2;
/*     */       }
/* 129 */       System.arraycopy(this.c, this.d, paramArrayOfbyte, paramInt1, i);
/* 130 */       this.d += i;
/* 131 */       if (this.d >= this.e) {
/* 132 */         a();
/*     */       }
/* 134 */       this.f -= i;
/*     */     } 
/* 136 */     return i;
/*     */   }
/*     */   
/*     */   private void a() {
/* 140 */     int i = this.a.getAudio(this.b) << 1;
/* 141 */     int j = 1024;
/* 142 */     if (this.f < this.g)
/*     */     {
/* 144 */       j = (j = this.f / (this.g >> 10)) * j * j >> 20;
/*     */     }
/* 146 */     for (byte b1 = 0, b2 = 0; b1 < i; b1++) {
/*     */       int k;
/* 148 */       if ((k = this.b[b1] * j >> 10) > 32767) k = 32767; 
/* 149 */       if (k < -32768) k = -32768; 
/* 150 */       this.c[b2++] = (byte)k;
/* 151 */       this.c[b2++] = (byte)(k >> 8);
/*     */     } 
/* 153 */     this.d = 0;
/* 154 */     this.e = i << 1;
/*     */   }
/*     */   
/*     */   public static void writeInt32(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 158 */     paramArrayOfbyte[paramInt1] = (byte)paramInt2;
/* 159 */     paramArrayOfbyte[paramInt1 + 1] = (byte)(paramInt2 >> 8);
/* 160 */     paramArrayOfbyte[paramInt1 + 2] = (byte)(paramInt2 >> 16);
/* 161 */     paramArrayOfbyte[paramInt1 + 3] = (byte)(paramInt2 >> 24);
/*     */   }
/*     */   
/*     */   public static int readInt32(byte[] paramArrayOfbyte, int paramInt) {
/* 165 */     return paramArrayOfbyte[paramInt + 3] << 24 | (paramArrayOfbyte[paramInt + 2] & 0xFF) << 16 | (paramArrayOfbyte[paramInt + 1] & 0xFF) << 8 | paramArrayOfbyte[paramInt] & 0xFF;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\ibxm\WavInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */