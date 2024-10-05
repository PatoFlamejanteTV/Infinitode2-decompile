/*    */ package com.prineside.tdi2.pathfinding;
/*    */ 
/*    */ import com.badlogic.gdx.ai.pfa.Connection;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoSerializable;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(arrayLevels = 2)
/*    */ public final class HeavyPathNode implements KryoSerializable {
/* 13 */   public Array<Connection<HeavyPathNode>> connections = new Array(PathConnection.class);
/*    */   
/*    */   public int index;
/*    */   public short x;
/*    */   public short y;
/*    */   public float cost;
/* 19 */   public int[] teleportIndices = new int[] { -1, -1, -1, -1 };
/*    */ 
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 23 */     paramKryo.writeObject(paramOutput, this.connections);
/* 24 */     paramOutput.writeVarInt(this.index, true);
/* 25 */     paramOutput.writeShort(this.x);
/* 26 */     paramOutput.writeShort(this.y);
/* 27 */     paramOutput.writeFloat(this.cost);
/* 28 */     paramKryo.writeObject(paramOutput, this.teleportIndices);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 33 */     this.connections = (Array<Connection<HeavyPathNode>>)paramKryo.readObject(paramInput, Array.class);
/* 34 */     this.index = paramInput.readVarInt(true);
/* 35 */     this.x = paramInput.readShort();
/* 36 */     this.y = paramInput.readShort();
/* 37 */     this.cost = paramInput.readFloat();
/* 38 */     this.teleportIndices = (int[])paramKryo.readObject(paramInput, int[].class);
/*    */   }
/*    */ 
/*    */   
/*    */   public final int hashCode() {
/* 43 */     return this.y * 14923 + this.x;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean equals(Object paramObject) {
/* 54 */     if (paramObject == this) return true; 
/* 55 */     if (!(paramObject instanceof HeavyPathNode)) return false;
/*    */     
/* 57 */     if (((HeavyPathNode)(paramObject = paramObject)).index != this.index) return false; 
/* 58 */     if (((HeavyPathNode)paramObject).x != this.x) return false; 
/* 59 */     if (((HeavyPathNode)paramObject).y != this.y) return false; 
/* 60 */     if (((HeavyPathNode)paramObject).cost != this.cost) return false; 
/* 61 */     for (byte b = 0; b < this.teleportIndices.length; b++) {
/* 62 */       if (((HeavyPathNode)paramObject).teleportIndices[b] != this.teleportIndices[b]) {
/* 63 */         return false;
/*    */       }
/*    */     } 
/* 66 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final void setup(int paramInt, short paramShort1, short paramShort2, float paramFloat) {
/* 72 */     this.index = paramInt;
/* 73 */     this.x = paramShort1;
/* 74 */     this.y = paramShort2;
/* 75 */     this.cost = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 80 */     return this.x + ":" + this.y + " (tp: " + this.teleportIndices[0] + ", " + this.teleportIndices[1] + ", " + this.teleportIndices[2] + ", " + this.teleportIndices[3] + ")";
/*    */   }
/*    */   
/*    */   public final PathNode toLightNode() {
/* 84 */     boolean bool = false; int arrayOfInt[], i; byte b;
/* 85 */     for (i = (arrayOfInt = this.teleportIndices).length, b = 0; b < i; b++) {
/* 86 */       int j; if ((j = arrayOfInt[b]) != -1) {
/* 87 */         bool = true;
/*    */         break;
/*    */       } 
/*    */     } 
/* 91 */     if (bool) {
/* 92 */       return new PathNodeWithTeleports(this.x, this.y, this.teleportIndices);
/*    */     }
/* 94 */     return new PathNodeWithoutTeleports(this.x, this.y);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\pathfinding\HeavyPathNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */