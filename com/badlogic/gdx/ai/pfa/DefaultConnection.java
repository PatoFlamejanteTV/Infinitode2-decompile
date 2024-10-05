/*    */ package com.badlogic.gdx.ai.pfa;
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
/*    */ public class DefaultConnection<N>
/*    */   implements Connection<N>
/*    */ {
/*    */   protected N fromNode;
/*    */   protected N toNode;
/*    */   
/*    */   public DefaultConnection(N paramN1, N paramN2) {
/* 30 */     this.fromNode = paramN1;
/* 31 */     this.toNode = paramN2;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getCost() {
/* 36 */     return 1.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public N getFromNode() {
/* 41 */     return this.fromNode;
/*    */   }
/*    */ 
/*    */   
/*    */   public N getToNode() {
/* 46 */     return this.toNode;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\pfa\DefaultConnection.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */