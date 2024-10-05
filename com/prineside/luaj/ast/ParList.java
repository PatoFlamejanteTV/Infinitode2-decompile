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
/*    */ public class ParList
/*    */   extends SyntaxElement
/*    */ {
/* 28 */   public static final List<Name> EMPTY_NAMELIST = new ArrayList<>();
/* 29 */   public static final ParList EMPTY_PARLIST = new ParList(EMPTY_NAMELIST, false);
/*    */   
/*    */   public final List<Name> names;
/*    */   public final boolean isvararg;
/*    */   
/*    */   public ParList(List<Name> paramList, boolean paramBoolean) {
/* 35 */     this.names = paramList;
/* 36 */     this.isvararg = paramBoolean;
/*    */   }
/*    */   
/*    */   public void accept(Visitor paramVisitor) {
/* 40 */     paramVisitor.visit(this);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\ast\ParList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */