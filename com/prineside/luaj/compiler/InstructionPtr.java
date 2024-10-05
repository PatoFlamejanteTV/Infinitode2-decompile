/*    */ package com.prineside.luaj.compiler;
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
/*    */ class InstructionPtr
/*    */ {
/*    */   final int[] a;
/*    */   final int b;
/*    */   
/*    */   InstructionPtr(int[] paramArrayOfint, int paramInt) {
/* 28 */     this.a = paramArrayOfint;
/* 29 */     this.b = paramInt;
/*    */   }
/*    */   final int a() {
/* 32 */     return this.a[this.b];
/*    */   }
/*    */   final void a(int paramInt) {
/* 35 */     this.a[this.b] = paramInt;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\compiler\InstructionPtr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */