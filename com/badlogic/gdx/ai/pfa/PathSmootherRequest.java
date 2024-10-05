/*    */ package com.badlogic.gdx.ai.pfa;
/*    */ 
/*    */ import com.badlogic.gdx.math.Vector;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PathSmootherRequest<N, V extends Vector<V>>
/*    */ {
/*    */   public boolean isNew = true;
/*    */   public int outputIndex;
/*    */   public int inputIndex;
/*    */   public SmoothableGraphPath<N, V> path;
/*    */   
/*    */   public void refresh(SmoothableGraphPath<N, V> paramSmoothableGraphPath) {
/* 40 */     this.path = paramSmoothableGraphPath;
/* 41 */     this.isNew = true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\pfa\PathSmootherRequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */