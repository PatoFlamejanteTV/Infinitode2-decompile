/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoSerializable;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.utils.logging.TLog;
/*    */ 
/*    */ @REGS(arrayLevels = 1)
/*    */ public final class CheatSafeInt implements KryoSerializable {
/* 11 */   private static final TLog a = TLog.forClass(CheatSafeInt.class);
/*    */   
/*    */   private int b;
/*    */   
/*    */   private int c;
/*    */   
/*    */   private int d;
/*    */   private int e;
/*    */   private int f;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 22 */     paramOutput.writeVarInt(this.e, false);
/* 23 */     paramOutput.writeVarInt(this.f, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 28 */     this.e = paramInput.readVarInt(false);
/* 29 */     set(paramInput.readVarInt(false));
/*    */   }
/*    */   
/*    */   private CheatSafeInt() {}
/*    */   
/*    */   public CheatSafeInt(int paramInt1, int paramInt2) {
/* 35 */     this.e = -paramInt2;
/* 36 */     set(paramInt1);
/*    */   }
/*    */   
/*    */   public final int getSetOnCheat() {
/* 40 */     return -this.e;
/*    */   }
/*    */   
/*    */   private boolean a() {
/* 44 */     return ((this.f * 31 + this.b) * 31 + this.c + hashCode() != this.d);
/*    */   }
/*    */   
/*    */   public final int get() {
/* 48 */     if (a()) {
/*    */       
/* 50 */       int i = -this.e;
/* 51 */       set(i);
/* 52 */       return i;
/*    */     } 
/*    */     
/* 55 */     return this.f;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void set(int paramInt) {
/* 60 */     this.f = paramInt;
/*    */     
/* 62 */     this.b = FastRandom.getInt(8192);
/* 63 */     this.c = FastRandom.getInt(8192);
/* 64 */     this.d = (this.f * 31 + this.b) * 31 + this.c + hashCode();
/*    */     
/* 66 */     if (a()) {
/* 67 */       a.e("invalid on " + paramInt, new Object[0]);
/*    */     }
/*    */   }
/*    */   
/*    */   public final void add(int paramInt) {
/* 72 */     if (get() >= 0 && paramInt >= 0 && get() + paramInt < 0)
/*    */     {
/* 74 */       paramInt = Integer.MAX_VALUE - get();
/*    */     }
/* 76 */     set(get() + paramInt);
/*    */   }
/*    */   
/*    */   public final void sub(int paramInt) {
/* 80 */     set(get() - paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 85 */     return PMath.toString(get());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\CheatSafeInt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */