/*    */ package org.a.b.f;
/*    */ 
/*    */ import org.a.a.a.a;
/*    */ import org.a.a.a.c;
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
/*    */ public class v
/*    */   extends an
/*    */ {
/* 32 */   private static final a c = c.a(v.class);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private u[] d;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   v(ap paramap) {
/* 43 */     super(paramap);
/*    */   }
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
/*    */   public final void a(ap paramap, ak paramak) {
/*    */     int i;
/* 57 */     if ((i = paramak.c()) != 0)
/*    */     {
/* 59 */       i = i << 16 | paramak.c();
/*    */     }
/* 61 */     int j = 0;
/* 62 */     if (i == 0) {
/*    */       
/* 64 */       j = paramak.c();
/*    */     }
/* 66 */     else if (i == 1) {
/*    */       
/* 68 */       j = (int)paramak.k();
/*    */     }
/*    */     else {
/*    */       
/* 72 */       (new StringBuilder("Skipped kerning table due to an unsupported kerning table version: ")).append(i);
/*    */     } 
/* 74 */     if (j > 0) {
/*    */       
/* 76 */       this.d = new u[j];
/* 77 */       for (byte b = 0; b < j; b++) {
/*    */         u u1;
/*    */         
/* 80 */         (u1 = new u()).a(paramak, i);
/* 81 */         this.d[b] = u1;
/*    */       } 
/*    */     } 
/* 84 */     this.a = true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */