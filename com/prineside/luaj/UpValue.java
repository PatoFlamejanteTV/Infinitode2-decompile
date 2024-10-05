/*     */ package com.prineside.luaj;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.utils.REGS;
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
/*     */ @REGS(arrayLevels = 1)
/*     */ public final class UpValue
/*     */   implements KryoSerializable
/*     */ {
/*     */   private LuaValue[] b;
/*     */   int a;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  44 */     LuaValue.NILLABLE_SERIALIZER.writeClassAndObject(paramKryo, paramOutput, this.b);
/*  45 */     paramOutput.writeInt(this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  50 */     this.b = (LuaValue[])paramKryo.readClassAndObject(paramInput);
/*  51 */     this.a = paramInput.readInt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private UpValue() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public UpValue(LuaValue[] paramArrayOfLuaValue, int paramInt) {
/*  62 */     this.b = paramArrayOfLuaValue;
/*  63 */     this.a = paramInt;
/*     */   }
/*     */   
/*     */   public final String toString() {
/*  67 */     return this.a + "/" + ((this.b != null) ? (this.b.length + " " + this.b[this.a]) : "noArr");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String tojstring() {
/*  76 */     return this.b[this.a].tojstring();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final LuaValue getValue() {
/*  84 */     return this.b[this.a];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setValue(LuaValue paramLuaValue) {
/*  92 */     this.b[this.a] = paramLuaValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void close() {
/*  99 */     LuaValue[] arrayOfLuaValue = this.b;
/* 100 */     this.b = new LuaValue[] { arrayOfLuaValue[this.a] };
/* 101 */     arrayOfLuaValue[this.a] = null;
/* 102 */     this.a = 0;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\UpValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */