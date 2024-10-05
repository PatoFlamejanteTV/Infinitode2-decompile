/*    */ package com.prineside.luaj.ast;
/*    */ 
/*    */ import com.prineside.luaj.LuaValue;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Variable
/*    */ {
/*    */   public final String name;
/*    */   public final NameScope definingScope;
/*    */   public boolean isupvalue;
/*    */   public boolean hasassignments;
/*    */   public LuaValue initialValue;
/*    */   
/*    */   public Variable(String paramString) {
/* 48 */     this.name = paramString;
/* 49 */     this.definingScope = null;
/*    */   }
/*    */   
/*    */   public Variable(String paramString, NameScope paramNameScope) {
/* 53 */     this.name = paramString;
/* 54 */     this.definingScope = paramNameScope;
/*    */   }
/*    */   public boolean isLocal() {
/* 57 */     return (this.definingScope != null);
/*    */   }
/*    */   public boolean isConstant() {
/* 60 */     return (!this.hasassignments && this.initialValue != null);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\ast\Variable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */