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
/*    */ 
/*    */ public class TableField
/*    */   extends SyntaxElement
/*    */ {
/*    */   public final Exp index;
/*    */   public final String name;
/*    */   public final Exp rhs;
/*    */   
/*    */   public TableField(Exp paramExp1, String paramString, Exp paramExp2) {
/* 31 */     this.index = paramExp1;
/* 32 */     this.name = paramString;
/* 33 */     this.rhs = paramExp2;
/*    */   }
/*    */   
/*    */   public static TableField keyedField(Exp paramExp1, Exp paramExp2) {
/* 37 */     return new TableField(paramExp1, null, paramExp2);
/*    */   }
/*    */   
/*    */   public static TableField namedField(String paramString, Exp paramExp) {
/* 41 */     return new TableField(null, paramString, paramExp);
/*    */   }
/*    */   
/*    */   public static TableField listField(Exp paramExp) {
/* 45 */     return new TableField(null, null, paramExp);
/*    */   }
/*    */   
/*    */   public void accept(Visitor paramVisitor) {
/* 49 */     paramVisitor.visit(this);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\ast\TableField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */