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
/*    */ public class FuncBody
/*    */   extends SyntaxElement
/*    */ {
/*    */   public ParList parlist;
/*    */   public Block block;
/*    */   public NameScope scope;
/*    */   
/*    */   public FuncBody(ParList paramParList, Block paramBlock) {
/* 30 */     this.parlist = (paramParList != null) ? paramParList : ParList.EMPTY_PARLIST;
/* 31 */     this.block = paramBlock;
/*    */   }
/*    */   public void accept(Visitor paramVisitor) {
/* 34 */     paramVisitor.visit(this);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\ast\FuncBody.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */