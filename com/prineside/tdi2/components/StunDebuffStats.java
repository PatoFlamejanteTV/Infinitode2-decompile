/*    */ package com.prineside.tdi2.components;
/*    */ 
/*    */ import com.badlogic.gdx.utils.IntIntMap;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoSerializable;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class StunDebuffStats implements KryoSerializable {
/* 12 */   private IntIntMap a = new IntIntMap();
/* 13 */   public byte totalCount = 0;
/*    */   public float passedTilesOnLastStun;
/* 15 */   public float immunity = 0.0F;
/*    */ 
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 19 */     paramKryo.writeObject(paramOutput, this.a);
/* 20 */     paramOutput.writeByte(this.totalCount);
/* 21 */     paramOutput.writeFloat(this.passedTilesOnLastStun);
/* 22 */     paramOutput.writeFloat(this.immunity);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 27 */     this.a = (IntIntMap)paramKryo.readObject(paramInput, IntIntMap.class);
/* 28 */     this.totalCount = paramInput.readByte();
/* 29 */     this.passedTilesOnLastStun = paramInput.readFloat();
/* 30 */     this.immunity = paramInput.readFloat();
/*    */   }
/*    */   
/*    */   public final int getCountByTower(int paramInt) {
/* 34 */     return this.a.get(paramInt, 0);
/*    */   }
/*    */   
/*    */   public final void addStunnedBy(int paramInt) {
/*    */     int i;
/* 39 */     if ((i = this.a.get(paramInt, -1)) == -1) {
/* 40 */       this.a.put(paramInt, 1); return;
/*    */     } 
/* 42 */     this.a.put(paramInt, i + 1);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\components\StunDebuffStats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */