/*    */ package com.prineside.tdi2.utils.mapeditor;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.prineside.tdi2.Gate;
/*    */ 
/*    */ public final class SelectionOutline {
/*  7 */   public final Array<Edge> edges = new Array(true, 1, Edge.class);
/*    */   
/*    */   public final void add(int paramInt1, int paramInt2, Edge.Side paramSide) {
/* 10 */     this.edges.add(new Edge(paramInt1, paramInt2, paramSide));
/*    */   }
/*    */   
/*    */   public final void removeOverGate(Gate paramGate) {
/* 14 */     if (!paramGate.isLeftSide()) {
/*    */       
/* 16 */       for (int j = this.edges.size - 1; j >= 0; j--) {
/*    */         Edge edge;
/* 18 */         if ((edge = ((Edge[])this.edges.items)[j]).side == Edge.Side.BOTTOM && edge.x == paramGate.getX() && edge.y == paramGate.getY()) {
/* 19 */           this.edges.removeIndex(j);
/* 20 */         } else if (edge.side == Edge.Side.TOP && edge.x == paramGate.getX() && edge.y + 1 == paramGate.getY()) {
/* 21 */           this.edges.removeIndex(j);
/*    */         } 
/*    */       } 
/*    */       return;
/*    */     } 
/* 26 */     for (int i = this.edges.size - 1; i >= 0; i--) {
/*    */       Edge edge;
/* 28 */       if ((edge = ((Edge[])this.edges.items)[i]).side == Edge.Side.LEFT && edge.x == paramGate.getX() && edge.y == paramGate.getY()) {
/* 29 */         this.edges.removeIndex(i);
/* 30 */       } else if (edge.side == Edge.Side.RIGHT && edge.x + 1 == paramGate.getX() && edge.y == paramGate.getY()) {
/* 31 */         this.edges.removeIndex(i);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   public static class Edge { public int x;
/*    */     public int y;
/*    */     public Side side;
/*    */     
/* 39 */     public enum Side { LEFT,
/* 40 */       RIGHT,
/* 41 */       TOP,
/* 42 */       BOTTOM; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public Edge(int param1Int1, int param1Int2, Side param1Side) {
/* 50 */       this.x = param1Int1;
/* 51 */       this.y = param1Int2;
/* 52 */       this.side = param1Side;
/*    */     } }
/*    */ 
/*    */   
/*    */   public enum Side {
/*    */     LEFT, RIGHT, TOP, BOTTOM;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\mapeditor\SelectionOutline.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */