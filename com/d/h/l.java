/*    */ package com.d.h;
/*    */ 
/*    */ import com.a.a.c.f.w;
/*    */ import com.d.d.n;
/*    */ import com.d.e.aa;
/*    */ import com.d.e.v;
/*    */ import com.d.i.ab;
/*    */ import com.d.i.c;
/*    */ import com.d.l.b;
/*    */ import java.awt.Point;
/*    */ import java.awt.Shape;
/*    */ import java.util.Map;
/*    */ import org.w3c.dom.Element;
/*    */ 
/*    */ 
/*    */ public final class l
/*    */   implements n, k.a
/*    */ {
/*    */   private final Element a;
/* 20 */   private Point b = new Point(0, 0);
/*    */   
/*    */   private final w.a c;
/*    */   private final int d;
/*    */   private final int e;
/*    */   private final int f;
/*    */   private Map<Shape, String> g;
/*    */   
/*    */   public l(Element paramElement, w.a parama, int paramInt1, int paramInt2, aa paramaa) {
/* 29 */     this.a = paramElement;
/* 30 */     this.g = b.a(paramElement, paramaa);
/* 31 */     this.c = parama;
/* 32 */     this.d = paramInt1;
/* 33 */     this.e = paramInt2;
/* 34 */     this.f = paramaa.s();
/*    */   }
/*    */ 
/*    */   
/*    */   public final int a() {
/* 39 */     return this.d;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int b() {
/* 44 */     return this.e;
/*    */   }
/*    */ 
/*    */   
/*    */   public final Point c() {
/* 49 */     return this.b;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void a(int paramInt1, int paramInt2) {
/* 54 */     this.b.setLocation(paramInt1, paramInt2);
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
/*    */   public final void a(v paramv) {}
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
/*    */   public final void a(ab paramab, m paramm, c paramc) {
/* 78 */     this.b.getX(); this.b.getY(); a(); b(); Map<Shape, String> map;
/* 79 */     if ((map = this.c.w()) != null) {
/* 80 */       this.g = map;
/*    */     }
/*    */   }
/*    */   
/*    */   public final Map<Shape, String> d() {
/* 85 */     return this.g;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\h\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */