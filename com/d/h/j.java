/*    */ package com.d.h;
/*    */ 
/*    */ import com.d.c.f.d;
/*    */ import com.d.d.c;
/*    */ import com.d.d.n;
/*    */ import com.d.e.aa;
/*    */ import com.d.e.v;
/*    */ import com.d.i.ab;
/*    */ import com.d.i.c;
/*    */ import com.d.l.b;
/*    */ import java.awt.Point;
/*    */ import java.awt.Rectangle;
/*    */ import java.awt.Shape;
/*    */ import java.util.Map;
/*    */ import org.w3c.dom.Element;
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
/*    */ public final class j
/*    */   implements n, k.a
/*    */ {
/*    */   private final c a;
/*    */   private final boolean b;
/* 39 */   private Point c = new Point(0, 0);
/*    */   private final Map<Shape, String> d;
/*    */   
/*    */   public j(Element paramElement, c paramc, aa paramaa, boolean paramBoolean) {
/* 43 */     this.a = paramc;
/* 44 */     this.b = paramBoolean;
/* 45 */     this.d = b.a(paramElement, paramaa);
/*    */   }
/*    */   
/*    */   public final int a() {
/* 49 */     return this.a.a();
/*    */   }
/*    */   
/*    */   public final int b() {
/* 53 */     return this.a.b();
/*    */   }
/*    */   
/*    */   public final Point c() {
/* 57 */     return this.c;
/*    */   }
/*    */   
/*    */   public final void a(int paramInt1, int paramInt2) {
/* 61 */     this.c = new Point(paramInt1, paramInt2);
/*    */   }
/*    */   
/*    */   private c e() {
/* 65 */     return this.a;
/*    */   }
/*    */ 
/*    */   
/*    */   public final Map<Shape, String> d() {
/* 70 */     return this.d;
/*    */   }
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
/*    */   public final void a(ab paramab, m paramm, c paramc) {
/* 83 */     Rectangle rectangle = paramc.c(paramc.ab(), paramc.aa(), (d)paramab);
/*    */     
/*    */     c c1;
/*    */     n n1;
/* 87 */     (c1 = ((j)(n1 = paramc.E())).e()).a(rectangle.width, rectangle.height);
/*    */     
/* 89 */     paramm.a(c1, rectangle.x, rectangle.y, this.b);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\h\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */