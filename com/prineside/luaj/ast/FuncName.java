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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FuncName
/*    */   extends SyntaxElement
/*    */ {
/*    */   public final Name name;
/*    */   public List<String> dots;
/*    */   public String method;
/*    */   
/*    */   public FuncName(String paramString) {
/* 40 */     this.name = new Name(paramString);
/*    */   }
/*    */   
/*    */   public void adddot(String paramString) {
/* 44 */     if (this.dots == null)
/* 45 */       this.dots = new ArrayList<>(); 
/* 46 */     this.dots.add(paramString);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\ast\FuncName.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */