/*    */ package com.prineside.luaj.ast;
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
/*    */ public class Chunk
/*    */   extends SyntaxElement
/*    */ {
/*    */   public final Block block;
/*    */   
/*    */   public Chunk(Block paramBlock) {
/* 28 */     this.block = paramBlock;
/*    */   }
/*    */   
/*    */   public void accept(Visitor paramVisitor) {
/* 32 */     paramVisitor.visit(this);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\ast\Chunk.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */