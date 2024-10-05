/*    */ package org.a.b.f;
/*    */ 
/*    */ import java.io.IOException;
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
/*    */ public final class t
/*    */   extends an
/*    */ {
/*    */   private long[] c;
/*    */   
/*    */   t(ap paramap) {
/* 40 */     super(paramap);
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
/*    */   public final void a(ap paramap, ak paramak) {
/* 52 */     q q = paramap.n();
/* 53 */     int i = paramap.w();
/* 54 */     this.c = new long[i + 1];
/* 55 */     for (byte b = 0; b < i + 1; b++) {
/*    */       
/* 57 */       if (q.f() == 0) {
/*    */         
/* 59 */         this.c[b] = (paramak.c() << 1);
/*    */       }
/* 61 */       else if (q.f() == 1) {
/*    */         
/* 63 */         this.c[b] = paramak.k();
/*    */       }
/*    */       else {
/*    */         
/* 67 */         throw new IOException("Error:TTF.loca unknown offset format.");
/*    */       } 
/*    */     } 
/* 70 */     this.a = true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final long[] a() {
/* 77 */     return this.c;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */