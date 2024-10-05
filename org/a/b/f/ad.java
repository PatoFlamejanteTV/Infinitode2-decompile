/*    */ package org.a.b.f;
/*    */ 
/*    */ import java.awt.geom.GeneralPath;
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
/*    */ public final class ad
/*    */   extends ap
/*    */ {
/*    */   private boolean b;
/*    */   
/*    */   ad(ak paramak) {
/* 37 */     super(paramak);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   final void a(float paramFloat) {
/* 43 */     this.b = (Float.floatToIntBits(paramFloat) == 1184802985);
/* 44 */     super.a(paramFloat);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final b a() {
/* 54 */     if (!this.b)
/*    */     {
/* 56 */       throw new UnsupportedOperationException("TTF fonts do not have a CFF table");
/*    */     }
/* 58 */     return (b)d("CFF ");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final p e() {
/* 64 */     if (this.b)
/*    */     {
/* 66 */       throw new UnsupportedOperationException("OTF fonts do not have a glyf table");
/*    */     }
/* 68 */     return super.e();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final GeneralPath c(String paramString) {
/* 74 */     int i = e(paramString);
/* 75 */     return a().a().c(i).b();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean f() {
/* 83 */     return this.a.containsKey("CFF ");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean g() {
/* 91 */     if (this.a.containsKey("BASE") || this.a
/* 92 */       .containsKey("GDEF") || this.a
/* 93 */       .containsKey("GPOS") || this.a
/* 94 */       .containsKey("GSUB") || this.a
/* 95 */       .containsKey("JSTF")) return true; 
/*    */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */