/*    */ package net.bytebuddy.jar.asm;
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
/*    */ final class CurrentFrame
/*    */   extends Frame
/*    */ {
/*    */   CurrentFrame(Label paramLabel) {
/* 40 */     super(paramLabel);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   final void a(int paramInt1, int paramInt2, Symbol paramSymbol, SymbolTable paramSymbolTable) {
/* 51 */     super.a(paramInt1, paramInt2, paramSymbol, paramSymbolTable);
/* 52 */     Frame frame = new Frame(null);
/* 53 */     a(paramSymbolTable, frame, 0);
/* 54 */     a(frame);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\CurrentFrame.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */