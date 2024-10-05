/*    */ package com.prineside.tdi2.pathfinding;
/*    */ 
/*    */ import com.badlogic.gdx.ai.pfa.DefaultConnection;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(serializer = PathConnection.Serializer.class)
/*    */ public final class PathConnection
/*    */   extends DefaultConnection<HeavyPathNode> {
/*    */   public Array<HeavyPathNode> pathNodes;
/*    */   public boolean isTeleport;
/*    */   public float cost;
/*    */   public int fromIdx;
/*    */   public int toIdx;
/*    */   
/*    */   public static class Serializer extends com.esotericsoftware.kryo.Serializer<PathConnection> {
/*    */     public void write(Kryo param1Kryo, Output param1Output, PathConnection param1PathConnection) {
/* 21 */       param1Kryo.writeObject(param1Output, param1PathConnection.pathNodes);
/* 22 */       param1Output.writeBoolean(param1PathConnection.isTeleport);
/* 23 */       param1Output.writeFloat(param1PathConnection.cost);
/* 24 */       param1Output.writeInt(param1PathConnection.fromIdx);
/* 25 */       param1Output.writeInt(param1PathConnection.toIdx);
/*    */     }
/*    */ 
/*    */     
/*    */     public PathConnection read(Kryo param1Kryo, Input param1Input, Class<? extends PathConnection> param1Class) {
/* 30 */       Array<HeavyPathNode> array = (Array)param1Kryo.readObject(param1Input, Array.class);
/* 31 */       boolean bool = param1Input.readBoolean();
/* 32 */       float f = param1Input.readFloat();
/* 33 */       int j = param1Input.readInt();
/* 34 */       int i = param1Input.readInt();
/* 35 */       return new PathConnection(array, j, i, bool, f);
/*    */     }
/*    */   }
/*    */   
/*    */   public PathConnection(Array<HeavyPathNode> paramArray, int paramInt1, int paramInt2, boolean paramBoolean, float paramFloat) {
/* 40 */     super(null, null);
/* 41 */     this.pathNodes = paramArray;
/* 42 */     this.fromIdx = paramInt1;
/* 43 */     this.toIdx = paramInt2;
/* 44 */     this.isTeleport = paramBoolean;
/* 45 */     this.cost = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public final float getCost() {
/* 50 */     return this.cost;
/*    */   }
/*    */ 
/*    */   
/*    */   public final HeavyPathNode getFromNode() {
/* 55 */     return ((HeavyPathNode[])this.pathNodes.items)[this.fromIdx];
/*    */   }
/*    */ 
/*    */   
/*    */   public final HeavyPathNode getToNode() {
/* 60 */     return ((HeavyPathNode[])this.pathNodes.items)[this.toIdx];
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\pathfinding\PathConnection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */