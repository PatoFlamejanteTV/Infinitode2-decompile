/*    */ package com.d.i;
/*    */ 
/*    */ import com.d.c.f.d;
/*    */ import java.awt.Rectangle;
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
/*    */ public final class ae
/*    */   extends c
/*    */ {
/*    */   private final Rectangle a;
/*    */   
/*    */   public ae(Rectangle paramRectangle) {
/* 33 */     this.a = paramRectangle;
/*    */   }
/*    */   
/*    */   public final int Q() {
/* 37 */     return this.a.width;
/*    */   }
/*    */   
/*    */   public final int as() {
/* 41 */     return this.a.height;
/*    */   }
/*    */   
/*    */   public final int d_() {
/* 45 */     return this.a.width;
/*    */   }
/*    */   
/*    */   public final Rectangle c(int paramInt1, int paramInt2, d paramd) {
/* 49 */     return new Rectangle(-this.a.x, -this.a.y, this.a.width, this.a.height);
/*    */   }
/*    */   
/*    */   public final Rectangle b(int paramInt1, int paramInt2, d paramd) {
/* 53 */     return new Rectangle(-this.a.x, -this.a.y, this.a.width, this.a.height);
/*    */   }
/*    */   
/*    */   protected final int l(d paramd) {
/* 57 */     return this.a.width;
/*    */   }
/*    */   
/*    */   public final c c() {
/* 61 */     throw new IllegalArgumentException("cannot be copied");
/*    */   }
/*    */   
/*    */   public final boolean b_() {
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   protected final int h(d paramd) {
/* 69 */     return this.a.height;
/*    */   }
/*    */   
/*    */   protected final boolean ax() {
/* 73 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\ae.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */