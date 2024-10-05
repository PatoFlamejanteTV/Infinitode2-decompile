/*     */ package com.d.m;
/*     */ 
/*     */ import java.awt.AlphaComposite;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.GraphicsConfiguration;
/*     */ import java.awt.GraphicsDevice;
/*     */ import java.awt.GraphicsEnvironment;
/*     */ import java.awt.Image;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.ImageObserver;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.Base64;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.logging.Level;
/*     */ import javax.imageio.ImageIO;
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
/*     */ public final class f
/*     */ {
/*     */   private static final Map a;
/*     */   
/*     */   static {
/*  46 */     (a = new HashMap<>()).put(d.c, new e());
/*  47 */     a.put(d.a, new d());
/*  48 */     a.put(d.b, new c());
/*  49 */     a.put(d.d, new b());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BufferedImage a(BufferedImage paramBufferedImage) {
/*     */     BufferedImage bufferedImage;
/*  76 */     if (GraphicsEnvironment.isHeadless()) {
/*  77 */       bufferedImage = a(paramBufferedImage.getWidth(), paramBufferedImage.getHeight(), paramBufferedImage.getTransparency());
/*     */     } else {
/*  79 */       GraphicsConfiguration graphicsConfiguration = a();
/*  80 */       if (paramBufferedImage.getColorModel().equals(graphicsConfiguration.getColorModel())) {
/*  81 */         return paramBufferedImage;
/*     */       }
/*  83 */       bufferedImage = graphicsConfiguration.createCompatibleImage(paramBufferedImage.getWidth(), paramBufferedImage.getHeight(), paramBufferedImage.getTransparency());
/*     */     } 
/*     */     
/*     */     Graphics graphics;
/*  87 */     (graphics = bufferedImage.getGraphics()).drawImage(paramBufferedImage, 0, 0, null);
/*  88 */     graphics.dispose();
/*  89 */     return bufferedImage;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BufferedImage a(int paramInt1, int paramInt2, int paramInt3) {
/*     */     BufferedImage bufferedImage;
/*     */     GraphicsEnvironment graphicsEnvironment;
/* 113 */     if ((graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment()).isHeadlessInstance()) {
/* 114 */       bufferedImage = new BufferedImage(paramInt1, paramInt2, paramInt3);
/*     */     } else {
/* 116 */       GraphicsConfiguration graphicsConfiguration = a();
/*     */ 
/*     */ 
/*     */       
/* 120 */       paramInt3 = (paramInt3 == 2 || paramInt3 == 3) ? 3 : 1;
/*     */       
/* 122 */       bufferedImage = graphicsConfiguration.createCompatibleImage(bufferedImage, paramInt2, paramInt3);
/*     */     } 
/*     */     
/* 125 */     return bufferedImage;
/*     */   }
/*     */   
/*     */   private static GraphicsConfiguration a() {
/*     */     GraphicsConfiguration graphicsConfiguration;
/*     */     GraphicsEnvironment graphicsEnvironment;
/*     */     GraphicsDevice graphicsDevice;
/* 132 */     return graphicsConfiguration = (graphicsDevice = (graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment()).getDefaultScreenDevice()).getDefaultConfiguration();
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
/*     */   private static BufferedImage a(h paramh, BufferedImage paramBufferedImage) {
/* 166 */     int i = paramBufferedImage.getWidth((ImageObserver)null);
/* 167 */     int j = paramBufferedImage.getHeight((ImageObserver)null);
/*     */     
/* 169 */     if (paramh.a(i, j)) {
/* 170 */       return paramBufferedImage;
/*     */     }
/*     */     
/* 173 */     i = (paramh.b() <= 0) ? i : paramh.b();
/* 174 */     j = (paramh.c() <= 0) ? j : paramh.c();
/*     */     
/* 176 */     f f1 = (f)a.get(paramh.a());
/* 177 */     paramh.a(i);
/* 178 */     paramh.b(j);
/*     */     
/* 180 */     return f1.a(paramBufferedImage, paramh);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BufferedImage a(BufferedImage paramBufferedImage, int paramInt1, int paramInt2) {
/*     */     String str;
/* 203 */     d d = d.a(str = b.a("xr.image.scale", d.a.a()), d.a);
/*     */     
/* 205 */     Object object = b.a("xr.image.render-quality", RenderingHints.VALUE_INTERPOLATION_BICUBIC);
/*     */ 
/*     */     
/*     */     h h;
/*     */     
/* 210 */     return a(h = new h(paramInt1, paramInt2, d, object), paramBufferedImage);
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
/*     */   public static BufferedImage a(Image paramImage, int paramInt) {
/*     */     BufferedImage bufferedImage;
/* 249 */     if (paramImage instanceof BufferedImage) {
/* 250 */       bufferedImage = (BufferedImage)paramImage;
/*     */     } else {
/*     */       Graphics2D graphics2D;
/*     */       
/* 254 */       (graphics2D = (bufferedImage = a(paramImage.getWidth(null), paramImage.getHeight(null), bufferedImage)).createGraphics()).drawImage(paramImage, 0, 0, null, null);
/* 255 */       graphics2D.dispose();
/*     */     } 
/* 257 */     return bufferedImage;
/*     */   }
/*     */   
/*     */   public static BufferedImage a(int paramInt1, int paramInt2) {
/*     */     BufferedImage bufferedImage;
/* 262 */     Graphics2D graphics2D = (bufferedImage = a(1, 1, 2)).createGraphics();
/*     */ 
/*     */     
/* 265 */     Color color = new Color(0, 0, 0, 0);
/* 266 */     graphics2D.setColor(color);
/* 267 */     graphics2D.setComposite(AlphaComposite.Src);
/* 268 */     graphics2D.fillRect(0, 0, 1, 1);
/* 269 */     graphics2D.dispose();
/* 270 */     return bufferedImage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean a(String paramString) {
/* 280 */     return (paramString != null && paramString.startsWith("data:image/"));
/*     */   }
/*     */   
/*     */   public static boolean b(String paramString) {
/* 284 */     return (paramString != null && paramString.startsWith("data:"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] c(String paramString) {
/*     */     int i;
/* 295 */     if ((i = paramString.indexOf("base64,")) != -1) {
/* 296 */       paramString = paramString.substring(i + 7);
/* 297 */       return Base64.getMimeDecoder().decode(paramString);
/*     */     } 
/* 299 */     l.e(Level.SEVERE, "Embedded data uris must be encoded in base 64.");
/*     */     
/* 301 */     return null;
/*     */   }
/*     */   
/*     */   public static byte[] d(String paramString) {
/* 305 */     return c(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BufferedImage e(String paramString) {
/*     */     try {
/*     */       byte[] arrayOfByte;
/* 317 */       if ((arrayOfByte = c(paramString)) != null) {
/* 318 */         return ImageIO.read(new ByteArrayInputStream(arrayOfByte));
/*     */       }
/* 320 */     } catch (IOException iOException) {
/* 321 */       l.a("Can't read XHTML embedded image", iOException);
/*     */     } 
/* 323 */     return null;
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
/*     */   static interface f
/*     */   {
/*     */     BufferedImage a(BufferedImage param1BufferedImage, h param1h);
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
/*     */   static abstract class a
/*     */     implements f
/*     */   {
/*     */     public final BufferedImage a(BufferedImage param1BufferedImage, h param1h) {
/*     */       Image image;
/* 360 */       return f.a(image = param1BufferedImage.getScaledInstance(param1h.b(), param1h.c(), a()), param1BufferedImage.getType());
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract int a();
/*     */   }
/*     */   
/*     */   static class e
/*     */     extends a
/*     */   {
/*     */     protected final int a() {
/* 371 */       return 2;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class b
/*     */     extends a
/*     */   {
/*     */     protected final int a() {
/* 380 */       return 16;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class c
/*     */     implements f
/*     */   {
/*     */     public final BufferedImage a(BufferedImage param1BufferedImage, h param1h) {
/* 393 */       int i = param1h.b();
/* 394 */       int j = param1h.c();
/*     */       
/*     */       BufferedImage bufferedImage;
/* 397 */       Graphics2D graphics2D = (bufferedImage = f.a(i, j, param1BufferedImage.getType())).createGraphics();
/* 398 */       param1h.a(graphics2D);
/* 399 */       graphics2D.drawImage(param1BufferedImage, 0, 0, i, j, null);
/* 400 */       graphics2D.dispose();
/*     */       
/* 402 */       return bufferedImage;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class d
/*     */     implements f
/*     */   {
/*     */     public final BufferedImage a(BufferedImage param1BufferedImage, h param1h) {
/* 412 */       int i = param1BufferedImage.getWidth((ImageObserver)null);
/* 413 */       int j = param1BufferedImage.getHeight((ImageObserver)null);
/*     */ 
/*     */       
/* 416 */       if (param1h.b() < i && param1h.c() < j) {
/*     */ 
/*     */ 
/*     */         
/* 420 */         i = i;
/* 421 */         j = j;
/*     */       }
/*     */       else {
/*     */         
/* 425 */         i = param1h.b();
/* 426 */         j = param1h.c();
/*     */       } 
/*     */       
/* 429 */       BufferedImage bufferedImage = param1BufferedImage;
/*     */       
/*     */       while (true) {
/* 432 */         if (i > param1h.b() && (
/*     */           
/* 434 */           i = i / 2) < param1h.b()) {
/* 435 */           i = param1h.b();
/*     */         }
/*     */ 
/*     */         
/* 439 */         if (j > param1h.c() && (
/*     */           
/* 441 */           j = j / 2) < param1h.c()) {
/* 442 */           j = param1h.c();
/*     */         }
/*     */         
/*     */         BufferedImage bufferedImage1;
/*     */         
/* 447 */         Graphics2D graphics2D = (bufferedImage1 = f.a(i, j, param1BufferedImage.getType())).createGraphics();
/* 448 */         param1h.a(graphics2D);
/* 449 */         graphics2D.drawImage(bufferedImage, 0, 0, i, j, null);
/* 450 */         graphics2D.dispose();
/*     */         
/* 452 */         bufferedImage = bufferedImage1;
/*     */         
/* 454 */         if (i == param1h.b() && j == param1h.c())
/* 455 */           return bufferedImage; 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\m\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */