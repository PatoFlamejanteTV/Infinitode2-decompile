/*    */ package com.prineside.luaj.ast;
/*    */ 
/*    */ import java.util.List;
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
/*    */ public class TableConstructor
/*    */   extends Exp
/*    */ {
/*    */   public List<TableField> fields;
/*    */   
/*    */   public void accept(Visitor paramVisitor) {
/* 30 */     paramVisitor.visit(this);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\ast\TableConstructor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */