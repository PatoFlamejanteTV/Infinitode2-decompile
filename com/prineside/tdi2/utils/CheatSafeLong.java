/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoSerializable;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.utils.logging.TLog;
/*    */ 
/*    */ @REGS(arrayLevels = 1)
/*    */ public final class CheatSafeLong implements KryoSerializable {
/* 11 */   private static final TLog a = TLog.forClass(CheatSafeLong.class);
/*    */   
/*    */   private long b;
/*    */   
/*    */   private long c;
/*    */   
/*    */   private long d;
/*    */   private long e;
/*    */   private long f;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 22 */     paramOutput.writeVarLong(this.e, false);
/* 23 */     paramOutput.writeVarLong(this.f, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 28 */     this.e = paramInput.readVarLong(false);
/* 29 */     set(paramInput.readVarLong(false));
/*    */   }
/*    */   
/*    */   private CheatSafeLong() {}
/*    */   
/*    */   public CheatSafeLong(long paramLong1, long paramLong2) {
/* 35 */     this.e = -paramLong2;
/* 36 */     set(paramLong1);
/*    */   }
/*    */   
/*    */   public final long getSetOnCheat() {
/* 40 */     return -this.e;
/*    */   }
/*    */   
/*    */   private boolean a() {
/* 44 */     return ((this.f * 31L + this.b) * 31L + this.c + hashCode() != this.d);
/*    */   }
/*    */   
/*    */   public final long get() {
/* 48 */     if (a()) {
/*    */       
/* 50 */       long l = -this.e;
/* 51 */       set(l);
/* 52 */       return l;
/*    */     } 
/*    */     
/* 55 */     return this.f;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void set(long paramLong) {
/* 60 */     this.f = paramLong;
/*    */     
/* 62 */     this.b = FastRandom.getInt(8192);
/* 63 */     this.c = FastRandom.getInt(8192);
/* 64 */     this.d = (this.f * 31L + this.b) * 31L + this.c + hashCode();
/*    */     
/* 66 */     if (a()) {
/* 67 */       a.e("invalid on " + paramLong, new Object[0]);
/*    */     }
/*    */   }
/*    */   
/*    */   public final void add(long paramLong) {
/* 72 */     if (get() >= 0L && paramLong >= 0L && get() + paramLong < 0L)
/*    */     {
/* 74 */       paramLong = Long.MAX_VALUE - get();
/*    */     }
/* 76 */     set(get() + paramLong);
/*    */   }
/*    */   
/*    */   public final void sub(long paramLong) {
/* 80 */     set(get() - paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 85 */     return Long.toString(get());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\CheatSafeLong.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */