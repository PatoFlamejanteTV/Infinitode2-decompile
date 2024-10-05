/*    */ package com.badlogic.gdx.ai.pfa.indexed;
/*    */ 
/*    */ import com.badlogic.gdx.ai.pfa.HierarchicalGraph;
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
/*    */ public abstract class IndexedHierarchicalGraph<N>
/*    */   implements HierarchicalGraph<N>, IndexedGraph<N>
/*    */ {
/*    */   protected int levelCount;
/*    */   protected int level;
/*    */   
/*    */   public IndexedHierarchicalGraph(int paramInt) {
/* 33 */     this.levelCount = paramInt;
/* 34 */     this.level = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getLevelCount() {
/* 39 */     return this.levelCount;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setLevel(int paramInt) {
/* 44 */     this.level = paramInt;
/*    */   }
/*    */   
/*    */   public abstract N convertNodeBetweenLevels(int paramInt1, N paramN, int paramInt2);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\pfa\indexed\IndexedHierarchicalGraph.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */