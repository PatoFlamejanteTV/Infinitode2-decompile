/*     */ package org.a.c.h.f.a;
/*     */ 
/*     */ import java.awt.color.ColorSpace;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.ColorConvertOp;
/*     */ import java.awt.image.ComponentColorModel;
/*     */ import java.awt.image.WritableRaster;
/*     */ import java.io.IOException;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.m;
/*     */ import org.a.c.h.a;
/*     */ import org.a.c.h.a.c;
/*     */ import org.a.c.h.j;
/*     */ import org.a.c.h.k;
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
/*     */ public abstract class f
/*     */   implements c
/*     */ {
/*     */   protected a e;
/*     */   
/*     */   public static f a(b paramb) {
/*  53 */     return a(paramb, (j)null);
/*     */   }
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
/*     */   public static f a(b paramb, j paramj) {
/*  70 */     return a(paramb, paramj, false);
/*     */   }
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
/*     */   public static f a(b paramb, j paramj, boolean paramBoolean) {
/*     */     j j1;
/*     */     a a1;
/*  90 */     if (paramb instanceof m)
/*     */     {
/*  92 */       return a((m)paramb, paramj);
/*     */     }
/*  94 */     if (paramb instanceof j) {
/*     */       
/*  96 */       j1 = (j)paramb;
/*     */ 
/*     */       
/*  99 */       if (paramj != null) {
/*     */         
/* 101 */         j j2 = null;
/* 102 */         if (j1.equals(j.aA) && paramj
/* 103 */           .c(j.as)) {
/*     */           
/* 105 */           j2 = j.as;
/*     */         }
/* 107 */         else if (j1.equals(j.aD) && paramj
/* 108 */           .c(j.av)) {
/*     */           
/* 110 */           j2 = j.av;
/*     */         }
/* 112 */         else if (j1.equals(j.aB) && paramj
/* 113 */           .c(j.au)) {
/*     */           
/* 115 */           j2 = j.au;
/*     */         } 
/*     */         
/* 118 */         if (paramj.c(j2) && !paramBoolean)
/*     */         {
/* 120 */           return paramj.a(j2, true);
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 125 */       if (j1 == j.aA)
/*     */       {
/* 127 */         return g.a;
/*     */       }
/* 129 */       if (j1 == j.aD)
/*     */       {
/* 131 */         return m.a;
/*     */       }
/* 133 */       if (j1 == j.aB)
/*     */       {
/* 135 */         return i.a;
/*     */       }
/* 137 */       if (j1 == j.cQ)
/*     */       {
/* 139 */         return new t(paramj);
/*     */       }
/* 141 */       if (paramj != null) {
/*     */         
/* 143 */         if (!paramj.c(j1))
/*     */         {
/* 145 */           throw new a("Missing color space: " + j1.a());
/*     */         }
/* 147 */         return paramj.b(j1);
/*     */       } 
/*     */ 
/*     */       
/* 151 */       throw new a("Unknown color space: " + j1.a());
/*     */     } 
/*     */     
/* 154 */     if (j1 instanceof a) {
/*     */ 
/*     */       
/* 157 */       if ((a1 = (a)j1).b() == 0)
/*     */       {
/* 159 */         throw new IOException("Colorspace array is empty");
/*     */       }
/*     */       b b1;
/* 162 */       if (!(b1 = a1.a(0) instanceof j))
/*     */       {
/* 164 */         throw new IOException("First element in colorspace array must be a name");
/*     */       }
/*     */ 
/*     */       
/*     */       j j2;
/*     */       
/* 170 */       if ((j2 = (j)b1) == j.K)
/*     */       {
/* 172 */         return new c(a1);
/*     */       }
/* 174 */       if (j2 == j.L)
/*     */       {
/* 176 */         return new d(a1);
/*     */       }
/* 178 */       if (j2 == j.aC)
/*     */       {
/* 180 */         return new j(a1);
/*     */       }
/* 182 */       if (j2 == j.bH)
/*     */       {
/* 184 */         return new p(a1, paramj);
/*     */       }
/* 186 */       if (j2 == j.dp)
/*     */       {
/* 188 */         return new u(a1);
/*     */       }
/* 190 */       if (j2 == j.bz)
/*     */       {
/* 192 */         return o.a(a1, paramj);
/*     */       }
/* 194 */       if (j2 == j.bT)
/*     */       {
/* 196 */         return new r(a1);
/*     */       }
/* 198 */       if (j2 == j.cQ) {
/*     */         
/* 200 */         if (a1.b() == 1)
/*     */         {
/* 202 */           return new t(paramj);
/*     */         }
/*     */ 
/*     */         
/* 206 */         return new t(paramj, a(a1.b(1)));
/*     */       } 
/*     */       
/* 209 */       if (j2 == j.aA || j2 == j.aD || j2 == j.aB)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 214 */         return a((b)j2, paramj, paramBoolean);
/*     */       }
/*     */ 
/*     */       
/* 218 */       throw new IOException("Invalid color space kind: " + j2);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 223 */     throw new IOException("Expected a name or array but got: " + a1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static f a(m paramm, j paramj) {
/* 231 */     if (paramj != null && paramj.b() != null) {
/*     */       f f2;
/*     */       
/*     */       k k;
/* 235 */       if ((f2 = (k = paramj.b()).b(paramm)) != null)
/*     */       {
/* 237 */         return f2;
/*     */       }
/*     */     } 
/* 240 */     f f1 = a(paramm.a(), paramj);
/* 241 */     if (paramj != null && paramj.b() != null && f1 != null) {
/*     */       k k;
/*     */       
/* 244 */       (k = paramj.b()).a(paramm, f1);
/*     */     } 
/* 246 */     return f1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int b();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract e c();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract float[] a(float[] paramArrayOffloat);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract BufferedImage a(WritableRaster paramWritableRaster);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BufferedImage a(WritableRaster paramWritableRaster, ColorSpace paramColorSpace) {
/* 308 */     ComponentColorModel componentColorModel = new ComponentColorModel(paramColorSpace, false, false, 1, paramWritableRaster.getDataBuffer().getDataType());
/*     */     
/* 310 */     BufferedImage bufferedImage2 = new BufferedImage(componentColorModel, paramWritableRaster, false, null);
/* 311 */     BufferedImage bufferedImage1 = new BufferedImage(paramWritableRaster.getWidth(), paramWritableRaster.getHeight(), 1);
/*     */     
/*     */     ColorConvertOp colorConvertOp;
/* 314 */     (colorConvertOp = new ColorConvertOp(null)).filter(bufferedImage2, bufferedImage1);
/* 315 */     return bufferedImage1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public b f() {
/* 321 */     return (b)this.e;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */