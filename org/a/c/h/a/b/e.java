/*    */ package org.a.c.h.a.b;
/*    */ 
/*    */ import org.a.c.b.b;
/*    */ import org.a.c.h.a.b.a.a;
/*    */ import org.a.c.h.a.b.a.d;
/*    */ import org.a.c.h.a.b.a.e;
/*    */ import org.a.c.h.a.b.a.g;
/*    */ import org.a.c.h.a.g;
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
/*    */ public final class e
/*    */   extends a
/*    */ {
/* 37 */   private static final g a = new g();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final d b;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public e(b paramb) {
/* 49 */     super(paramb);
/* 50 */     byte[] arrayOfByte = c().g();
/* 51 */     String str = new String(arrayOfByte, "ISO-8859-1");
/* 52 */     this.b = e.a(str);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final int a() {
/* 60 */     return 4;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final float[] a(float[] paramArrayOffloat) {
/* 69 */     a a1 = new a(a); int j;
/* 70 */     for (j = 0; j < paramArrayOffloat.length; j++) {
/*    */       
/* 72 */       g g1 = b(j);
/* 73 */       float f = a(paramArrayOffloat[j], g1.a(), g1.b());
/* 74 */       a1.a().push(Float.valueOf(f));
/*    */     } 
/*    */ 
/*    */     
/* 78 */     this.b.a(a1);
/*    */ 
/*    */     
/* 81 */     j = d();
/*    */     int k;
/* 83 */     if ((k = a1.a().size()) < j)
/*    */     {
/* 85 */       throw new IllegalStateException("The type 4 function returned " + k + " values but the Range entry indicates that " + j + " values be returned.");
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 90 */     float[] arrayOfFloat = new float[j];
/* 91 */     for (int i = j - 1; i >= 0; i--) {
/*    */       
/* 93 */       g g1 = a(i);
/* 94 */       arrayOfFloat[i] = a1.e();
/* 95 */       arrayOfFloat[i] = a(arrayOfFloat[i], g1.a(), g1.b());
/*    */     } 
/*    */ 
/*    */     
/* 99 */     return arrayOfFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\a\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */