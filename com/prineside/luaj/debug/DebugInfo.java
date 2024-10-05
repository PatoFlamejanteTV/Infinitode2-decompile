/*    */ package com.prineside.luaj.debug;
/*    */ 
/*    */ import com.prineside.luaj.FPrototype;
/*    */ import com.prineside.luaj.LuaFunction;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class DebugInfo
/*    */ {
/*    */   String a;
/*    */   String b;
/*    */   private int c;
/*    */   
/*    */   public final void funcinfo(LuaFunction paramLuaFunction) {
/*    */     FPrototype fPrototype;
/* 22 */     if (paramLuaFunction.isclosure()) {
/*    */       
/* 24 */       if ((fPrototype = (paramLuaFunction.checkclosure()).p).source != null) fPrototype.source.tojstring(); 
/* 25 */       this.c = fPrototype.linedefined;
/*    */ 
/*    */       
/* 28 */       fPrototype.shortsource();
/*    */       return;
/*    */     } 
/* 31 */     this.c = -1;
/*    */ 
/*    */     
/* 34 */     fPrototype.name();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\debug\DebugInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */