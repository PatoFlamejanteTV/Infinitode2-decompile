/*    */ package b.a.a;
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
/*    */ public final class d
/*    */ {
/* 28 */   private static short a = -32763;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 35 */   private short b = -1;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void a(int paramInt1, int paramInt2) {
/* 42 */     paramInt2 = 1 << paramInt2 - 1;
/*    */     do {
/* 44 */       if (((((this.b & 0x8000) == 0) ? 1 : 0) ^ (((paramInt1 & paramInt2) == 0) ? 1 : 0)) != 0)
/* 45 */       { this.b = (short)(this.b << 1);
/* 46 */         this.b = (short)(this.b ^ a); }
/*    */       else
/* 48 */       { this.b = (short)(this.b << 1); } 
/* 49 */     } while ((paramInt2 >>>= 1) != 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final short a() {
/* 56 */     short s = this.b;
/* 57 */     this.b = -1;
/* 58 */     return s;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\b\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */