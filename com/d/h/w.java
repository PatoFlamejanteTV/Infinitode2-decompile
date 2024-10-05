/*      */ package com.d.h;
/*      */ 
/*      */ import com.a.a.c.l;
/*      */ import com.d.m.l;
/*      */ import java.awt.geom.AffineTransform;
/*      */ import java.io.IOException;
/*      */ import org.a.c.h.e.u;
/*      */ import org.a.c.h.f.c.b;
/*      */ import org.a.c.h.g;
/*      */ import org.a.c.i.d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class w
/*      */ {
/*      */   private final g a;
/*      */   private int b;
/*      */   
/*      */   public static class a
/*      */     extends RuntimeException
/*      */   {
/*      */     public a(String param1String, Exception param1Exception) {
/*   27 */       super(param1String, param1Exception);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public a(l param1l) {
/* 1011 */       super((Throwable)param1l);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public a(String param1String) {
/* 1039 */       super(param1String);
/* 1040 */       a(param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public a(String param1String, Throwable param1Throwable) {
/* 1051 */       super(param1String, param1Throwable);
/* 1052 */       a(param1String, param1Throwable);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static void a(String param1String) {
/* 1061 */       l.c("Unhandled exception. " + param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static void a(String param1String, Throwable param1Throwable) {
/* 1073 */       l.a("Unhandled exception. " + param1String, param1Throwable);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void a(String paramString, IOException paramIOException) {
/*      */     l.a("Exception in PDF writing method: " + paramString, paramIOException);
/*      */     throw new a(paramString, paramIOException);
/*      */   }
/*      */   
/*      */   public w(g paramg) {
/*      */     this.b = 0;
/*      */     this.a = paramg;
/*      */   }
/*      */   
/*      */   public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*      */     try {
/*      */       this.a.c(0.0F, 0.0F, 0.0F, 0.0F);
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("addRect", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void a() {
/*      */     try {
/*      */       this.a.i();
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("closeSubpath", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/*      */     try {
/*      */       this.a.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("curveTo(6)", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*      */     try {
/*      */       this.a.d(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("curveTo(4)", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void b() {
/*      */     try {
/*      */       this.a.close();
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("closeContent", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void a(float paramFloat1, float paramFloat2) {
/*      */     try {
/*      */       this.a.c(paramFloat1, paramFloat2);
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("lineTo", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void b(float paramFloat1, float paramFloat2) {
/*      */     try {
/*      */       this.a.b(paramFloat1, paramFloat2);
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("moveTo", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void c() {
/*      */     try {
/*      */       this.a.h();
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("fillEvenOdd", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void d() {
/*      */     try {
/*      */       this.a.g();
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("fillNonZero", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void e() {
/*      */     try {
/*      */       this.a.e();
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("stroke", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void f() {
/*      */     try {
/*      */       this.a.j();
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("clipNonZero", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void g() {
/*      */     try {
/*      */       this.a.k();
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("clipEvenOdd", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void a(int paramInt1, int paramInt2, int paramInt3) {
/*      */     try {
/*      */       this.a.a(paramInt1, paramInt2, paramInt3);
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("setStrokingColor", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*      */     try {
/*      */       this.a.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("setStrokingColor(CMYK)", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void b(int paramInt1, int paramInt2, int paramInt3) {
/*      */     try {
/*      */       this.a.b(paramInt1, paramInt2, paramInt3);
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("setFillColor", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*      */     try {
/*      */       this.a.b(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("setFillColor(CMYK)", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void a(float paramFloat) {
/*      */     try {
/*      */       this.a.a(paramFloat);
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("setLineWidth", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void a(int paramInt) {
/*      */     try {
/*      */       this.a.c(paramInt);
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("setLineCap", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void b(int paramInt) {
/*      */     try {
/*      */       this.a.b(paramInt);
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("setLineJoin", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void a(float[] paramArrayOffloat, float paramFloat) {
/*      */     try {
/*      */       this.a.a(paramArrayOffloat, paramFloat);
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("setLineDash", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void h() {
/*      */     try {
/*      */       this.b--;
/*      */       this.a.d();
/*      */       if (this.b < 0)
/*      */         throw new IllegalStateException("Invalid save/restore pairing!"); 
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("restoreGraphics", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void i() {
/*      */     try {
/*      */       this.b++;
/*      */       this.a.c();
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("saveGraphics", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void j() {
/*      */     try {
/*      */       this.a.a();
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("beginText", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void k() {
/*      */     try {
/*      */       this.a.b();
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("endText", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void a(u paramu, float paramFloat) {
/*      */     try {
/*      */       this.a.a(paramu, paramFloat);
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("setFont", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/*      */     try {
/*      */       d d = new d(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
/*      */       this.a.a(d);
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("setTextMatrix", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void a(org.a.c.h.f.e.a parama) {
/*      */     try {
/*      */       this.a.a(parama);
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("setRenderingMode", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void a(String paramString) {
/*      */     try {
/*      */       this.a.a(paramString);
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("drawString", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void a(b paramb, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*      */     try {
/*      */       this.a.a(paramb, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("drawImage", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void b(float paramFloat) {
/*      */     try {
/*      */       if (paramFloat > 0.0D)
/*      */         this.a.b(paramFloat); 
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("setMiterLimit", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void a(Object[] paramArrayOfObject) {
/*      */     try {
/*      */       this.a.a(paramArrayOfObject);
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("drawStringWithPositioning", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void a(AffineTransform paramAffineTransform) {
/*      */     try {
/*      */       this.a.b(new d(paramAffineTransform));
/*      */       return;
/*      */     } catch (IOException iOException) {
/*      */       a("applyPdfMatrix", iOException);
/*      */       return;
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\h\w.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */