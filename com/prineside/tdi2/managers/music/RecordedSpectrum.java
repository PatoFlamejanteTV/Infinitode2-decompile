/*    */ package com.prineside.tdi2.managers.music;
/*    */ 
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ import com.badlogic.gdx.math.MathUtils;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.prineside.kryo.FixedInput;
/*    */ import com.prineside.tdi2.managers.MusicManager;
/*    */ import com.prineside.tdi2.utils.FastRandom;
/*    */ import com.prineside.tdi2.utils.logging.TLog;
/*    */ 
/*    */ public final class RecordedSpectrum {
/* 12 */   private static final TLog a = TLog.forClass(RecordedSpectrum.class);
/*    */   
/*    */   private final Array<MusicManager.FrequencyRange> b;
/*    */   private final float c;
/*    */   private final float d;
/*    */   private final int e;
/*    */   private final float[] f;
/*    */   
/*    */   public RecordedSpectrum(byte[] paramArrayOfbyte) {
/*    */     FixedInput fixedInput;
/* 22 */     int i = (fixedInput = new FixedInput(paramArrayOfbyte)).readInt();
/* 23 */     a.i("reading spectrum, frequency count: " + i, new Object[0]);
/*    */     
/* 25 */     this.b = new Array(true, i, MusicManager.FrequencyRange.class); byte b;
/* 26 */     for (b = 0; b < i; b++) {
/* 27 */       float f1 = fixedInput.readFloat();
/* 28 */       float f2 = fixedInput.readFloat();
/* 29 */       this.b.add(new MusicManager.FrequencyRange(f1, f2));
/*    */     } 
/* 31 */     this.c = fixedInput.readFloat();
/* 32 */     this.e = fixedInput.readInt();
/* 33 */     this.f = new float[(this.e << 1) * i];
/* 34 */     for (b = 0; b < this.f.length; b++) {
/* 35 */       this.f[b] = fixedInput.readFloat();
/*    */     }
/* 37 */     this.d = this.c * this.e / 1000.0F;
/*    */ 
/*    */     
/* 40 */     for (b = 0; b < 500000; b++) {
/* 41 */       int k = FastRandom.getFairInt(this.e);
/* 42 */       int m = FastRandom.getFairInt(this.b.size);
/* 43 */       int j = FastRandom.getFairInt(2);
/* 44 */       getSpectrumValue(k, m, j);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final float getSpectrumValue(int paramInt1, int paramInt2, int paramInt3) {
/* 52 */     return this.f[(paramInt1 * this.b.size << 1) + (paramInt2 << 1) + paramInt3];
/*    */   }
/*    */ 
/*    */   
/*    */   public final void generateSpectrum(float paramFloat, float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
/* 57 */     int i = MathUtils.clamp(MathUtils.floor((paramFloat = paramFloat % this.d) / this.d * this.e), 0, this.e - 1);
/* 58 */     float f = this.b.size / paramArrayOffloat1.length;
/* 59 */     for (byte b = 0; b < paramArrayOffloat1.length; b++) {
/*    */       int j;
/* 61 */       if ((j = MathUtils.round(b * f)) > this.b.size - 1) {
/* 62 */         j = this.b.size - 1;
/*    */       }
/* 64 */       paramArrayOffloat1[b] = getSpectrumValue(i, j, 0);
/* 65 */       paramArrayOffloat2[b] = getSpectrumValue(i, j, 1);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static RecordedSpectrum fromFile(FileHandle paramFileHandle) {
/* 70 */     return new RecordedSpectrum(paramFileHandle.readBytes());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\music\RecordedSpectrum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */