/*    */ package org.a.b.f;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class as
/*    */   extends an
/*    */ {
/*    */   private Map<Integer, Integer> c;
/*    */   
/*    */   as(ap paramap) {
/* 51 */     super(paramap);
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
/* 64 */     paramak.h();
/* 65 */     paramak.d();
/* 66 */     int i = paramak.c();
/* 67 */     this.c = new ConcurrentHashMap<Integer, Integer>(i);
/* 68 */     for (byte b = 0; b < i; b++) {
/*    */       
/* 70 */       int j = paramak.c();
/* 71 */       short s = paramak.d();
/* 72 */       this.c.put(Integer.valueOf(j), Integer.valueOf(s));
/*    */     } 
/* 74 */     this.a = true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */