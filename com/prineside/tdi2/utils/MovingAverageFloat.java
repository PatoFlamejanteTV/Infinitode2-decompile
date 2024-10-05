/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoSerializable;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ @REGS
/*    */ public final class MovingAverageFloat
/*    */   implements KryoSerializable {
/*    */   private float[] a;
/*    */   private double b;
/*    */   private int c;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 16 */     paramKryo.writeObject(paramOutput, this.a);
/* 17 */     paramOutput.writeDouble(this.b);
/* 18 */     paramOutput.writeVarInt(this.c, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 23 */     this.a = (float[])paramKryo.readObject(paramInput, float[].class);
/* 24 */     this.b = paramInput.readDouble();
/* 25 */     this.c = paramInput.readVarInt(true);
/*    */   }
/*    */   
/*    */   private MovingAverageFloat() {}
/*    */   
/*    */   public MovingAverageFloat(int paramInt) {
/* 31 */     this.a = new float[paramInt];
/*    */   }
/*    */   
/*    */   public final void push(float paramFloat) {
/* 35 */     if (this.c == this.a.length) {
/* 36 */       this.b -= this.a[0];
/* 37 */       System.arraycopy(this.a, 1, this.a, 0, this.a.length - 1);
/* 38 */       this.a[this.a.length - 1] = paramFloat;
/*    */     } else {
/* 40 */       this.a[this.c++] = paramFloat;
/*    */     } 
/* 42 */     this.b += paramFloat;
/*    */   }
/*    */   
/*    */   public final float getAverage() {
/* 46 */     return (this.c == 0) ? 0.0F : (float)(this.b / this.c);
/*    */   }
/*    */   
/*    */   public final int getCount() {
/* 50 */     return this.c;
/*    */   }
/*    */   
/*    */   public final void reset() {
/* 54 */     this.b = 0.0D;
/* 55 */     this.c = 0;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\MovingAverageFloat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */