/*     */ package com.d.h;
/*     */ 
/*     */ import com.d.c.f.d;
/*     */ import com.d.d.n;
/*     */ import com.d.e.aa;
/*     */ import com.d.e.v;
/*     */ import com.d.i.ab;
/*     */ import com.d.i.c;
/*     */ import com.d.i.f;
/*     */ import com.d.l.b;
/*     */ import com.d.m.l;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Shape;
/*     */ import java.io.IOException;
/*     */ import java.util.Map;
/*     */ import java.util.logging.Level;
/*     */ import org.a.c.e.a;
/*     */ import org.a.c.h.b;
/*     */ import org.a.c.h.c.b;
/*     */ import org.a.c.h.e;
/*     */ import org.a.c.h.f.b.a;
/*     */ import org.w3c.dom.Element;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class n
/*     */   implements n, k.a
/*     */ {
/*     */   private final a a;
/*     */   private final float b;
/*     */   private final float c;
/*     */   private final Map<Shape, String> d;
/*  51 */   private Point e = new Point(0, 0);
/*     */   
/*     */   private n(a parama, Element paramElement, aa paramaa, float paramFloat1, float paramFloat2) {
/*  54 */     this.a = parama;
/*  55 */     this.b = paramFloat1;
/*  56 */     this.c = paramFloat2;
/*  57 */     this.d = b.a(paramElement, paramaa);
/*     */   }
/*     */   
/*     */   private static int a(Element paramElement) {
/*  61 */     if (paramElement.getAttribute("page").isEmpty()) {
/*  62 */       return 0;
/*     */     }
/*     */     
/*     */     try {
/*  66 */       return Integer.parseInt(paramElement.getAttribute("page")) - 1;
/*  67 */     } catch (NumberFormatException numberFormatException) {
/*  68 */       l.a("Unable to parse page of img tag with PDF!", numberFormatException);
/*     */ 
/*     */       
/*  71 */       return 0;
/*     */     } 
/*     */   } public static n a(b paramb, byte[] paramArrayOfbyte, Element paramElement, f paramf, d paramd, aa paramaa) {
/*     */     
/*  75 */     try { b b1 = b.a(paramArrayOfbyte); 
/*     */       try { int i;
/*  77 */         if ((i = a(paramElement)) >= b1.f())
/*  78 */         { l.e(Level.WARNING, "Page does not exist for pdf in img tag. Ignoring!");
/*  79 */           paramd = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  91 */           if (b1 != null) b1.close();  return (n)paramd; }  e e; float f1 = (e = b1.a(i)).e().h() * paramaa.s() * 1.3333334F; float f2 = e.e().i() * paramaa.s() * 1.3333334F; a a2; a a1 = (a2 = new a(paramb)).a(b1, e); n n1 = new n(a1, paramElement, paramaa, f1, f2); if (b1 != null) b1.close();  return n1; } catch (Throwable throwable) { if (b1 != null) try { b1.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (b b1)
/*  92 */     { l.a("Tried to open a password protected document as src for an img!", (Throwable)b1); }
/*  93 */     catch (IOException iOException)
/*  94 */     { l.a("Could not read pdf passed as src for img element!", iOException); }
/*     */ 
/*     */     
/*  97 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int a() {
/* 102 */     return (int)this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int b() {
/* 107 */     return (int)this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Point c() {
/* 112 */     return this.e;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(int paramInt1, int paramInt2) {
/* 117 */     this.e = new Point(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Map<Shape, String> d() {
/* 122 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(v paramv) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(ab paramab, m paramm, c paramc) {
/* 137 */     Rectangle rectangle = paramc.c(paramc.ab(), paramc.aa(), (d)paramab);
/* 138 */     paramm.a(this.a, rectangle, a(), b());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\h\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */