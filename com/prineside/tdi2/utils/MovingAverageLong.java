/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoSerializable;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ @REGS
/*    */ public final class MovingAverageLong
/*    */   implements KryoSerializable {
/*    */   private long[] a;
/*    */   private long b;
/*    */   private int c;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 16 */     paramKryo.writeObject(paramOutput, this.a);
/* 17 */     paramOutput.writeVarLong(this.b, true);
/* 18 */     paramOutput.writeVarInt(this.c, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 23 */     this.a = (long[])paramKryo.readObject(paramInput, long[].class);
/* 24 */     this.b = paramInput.readVarLong(true);
/* 25 */     this.c = paramInput.readVarInt(true);
/*    */   }
/*    */   
/*    */   private MovingAverageLong() {}
/*    */   
/*    */   public MovingAverageLong(int paramInt) {
/* 31 */     this.a = new long[paramInt];
/*    */   }
/*    */   
/*    */   public final void push(long paramLong) {
/* 35 */     if (this.c == this.a.length) {
/* 36 */       this.b -= this.a[0];
/* 37 */       System.arraycopy(this.a, 1, this.a, 0, this.a.length - 1);
/* 38 */       this.a[this.a.length - 1] = paramLong;
/*    */     } else {
/* 40 */       this.a[this.c++] = paramLong;
/*    */     } 
/* 42 */     this.b += paramLong;
/*    */   }
/*    */   
/*    */   public final long getAverage() {
/* 46 */     return (this.c == 0) ? 0L : (int)(this.b / this.c);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\MovingAverageLong.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */