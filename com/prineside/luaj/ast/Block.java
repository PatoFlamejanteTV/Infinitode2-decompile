/*    */ package com.prineside.luaj.ast;
/*    */ 
/*    */ import java.util.ArrayList;
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
/*    */ 
/*    */ public class Block
/*    */   extends Stat
/*    */ {
/* 29 */   public List<Stat> stats = new ArrayList<>();
/*    */   public NameScope scope;
/*    */   
/*    */   public void add(Stat paramStat) {
/* 33 */     if (paramStat == null)
/*    */       return; 
/* 35 */     this.stats.add(paramStat);
/*    */   }
/*    */   
/*    */   public void accept(Visitor paramVisitor) {
/* 39 */     paramVisitor.visit(this);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\ast\Block.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */