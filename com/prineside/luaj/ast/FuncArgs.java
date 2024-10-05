/*    */ package com.prineside.luaj.ast;
/*    */ 
/*    */ import com.prineside.luaj.LuaString;
/*    */ import com.prineside.luaj.LuaValue;
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
/*    */ public class FuncArgs
/*    */   extends SyntaxElement
/*    */ {
/*    */   public final List<Exp> exps;
/*    */   
/*    */   public static FuncArgs explist(List<Exp> paramList) {
/* 35 */     return new FuncArgs(paramList);
/*    */   }
/*    */ 
/*    */   
/*    */   public static FuncArgs tableconstructor(TableConstructor paramTableConstructor) {
/* 40 */     return new FuncArgs(paramTableConstructor);
/*    */   }
/*    */ 
/*    */   
/*    */   public static FuncArgs string(LuaString paramLuaString) {
/* 45 */     return new FuncArgs(paramLuaString);
/*    */   }
/*    */   
/*    */   public FuncArgs(List<Exp> paramList) {
/* 49 */     this.exps = paramList;
/*    */   }
/*    */   
/*    */   public FuncArgs(LuaString paramLuaString) {
/* 53 */     this.exps = new ArrayList<>();
/* 54 */     this.exps.add(Exp.constant((LuaValue)paramLuaString));
/*    */   }
/*    */   
/*    */   public FuncArgs(TableConstructor paramTableConstructor) {
/* 58 */     this.exps = new ArrayList<>();
/* 59 */     this.exps.add(paramTableConstructor);
/*    */   }
/*    */   
/*    */   public void accept(Visitor paramVisitor) {
/* 63 */     paramVisitor.visit(this);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\ast\FuncArgs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */