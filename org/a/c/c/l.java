/*     */ package org.a.c.c;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Iterator;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.imageio.ImageReader;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
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
/*     */ public abstract class l
/*     */ {
/*  43 */   private static final a a = c.a(l.class);
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
/*     */   public abstract k a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd, int paramInt);
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
/*     */   public k a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd, int paramInt, j paramj) {
/*  87 */     return a(paramInputStream, paramOutputStream, paramd, paramInt);
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
/*     */   public final void b(InputStream paramInputStream, OutputStream paramOutputStream, d paramd) {
/* 101 */     a(paramInputStream, paramOutputStream, paramd.i());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd);
/*     */ 
/*     */ 
/*     */   
/*     */   protected static d a(d paramd, int paramInt) {
/*     */     a a1;
/* 112 */     b b2 = paramd.a(j.aY, j.aU);
/* 113 */     b b1 = paramd.a(j.ar, j.aJ);
/* 114 */     if (b2 instanceof j && b1 instanceof d)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 119 */       return (d)b1;
/*     */     }
/* 121 */     if (b2 instanceof a && b1 instanceof a) {
/*     */       
/* 123 */       a1 = (a)b1;
/* 124 */       if (paramInt < a1.b())
/*     */       {
/*     */         
/* 127 */         if (b2 = a1.a(paramInt) instanceof d)
/*     */         {
/* 129 */           return (d)a1.a(paramInt);
/*     */         }
/*     */       }
/*     */     }
/* 133 */     else if (a1 != null && !(b2 instanceof a) && !(a1 instanceof a)) {
/*     */       
/* 135 */       (new StringBuilder("Expected DecodeParams to be an Array or Dictionary but found "))
/* 136 */         .append(a1.getClass().getName());
/*     */     } 
/* 138 */     return new d();
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
/*     */   protected static ImageReader a(String paramString1, String paramString2) {
/* 151 */     Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName(paramString1);
/* 152 */     ImageReader imageReader = null;
/* 153 */     while (iterator.hasNext()) {
/*     */ 
/*     */       
/* 156 */       if ((imageReader = iterator.next()) != null && imageReader.canReadRaster()) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 161 */     if (imageReader == null)
/*     */     {
/* 163 */       throw new s("Cannot read " + paramString1 + " image: " + paramString2);
/*     */     }
/* 165 */     return imageReader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a() {
/* 173 */     int i = -1;
/*     */     
/*     */     try {
/* 176 */       i = Integer.parseInt(System.getProperty("org.apache.pdfbox.filter.deflatelevel", "-1"));
/*     */     }
/* 178 */     catch (NumberFormatException numberFormatException2) {
/*     */       NumberFormatException numberFormatException1;
/* 180 */       (numberFormatException1 = null).getMessage();
/*     */     } 
/* 182 */     return Math.max(-1, Math.min(9, i));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\c\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */