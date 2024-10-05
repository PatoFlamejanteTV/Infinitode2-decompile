/*     */ package com.vladsch.flexmark.util.misc;
/*     */ 
/*     */ import java.awt.AlphaComposite;
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Image;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.datatransfer.DataFlavor;
/*     */ import java.awt.datatransfer.Transferable;
/*     */ import java.awt.datatransfer.UnsupportedFlavorException;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.RoundRectangle2D;
/*     */ import java.awt.image.AffineTransformOp;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.FilteredImageSource;
/*     */ import java.awt.image.ImageObserver;
/*     */ import java.awt.image.RGBImageFilter;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.Base64;
/*     */ import java.util.regex.Pattern;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ImageUtils
/*     */ {
/*  59 */   public static Color TRANSPARENT = new Color(0, 0, 0, 0);
/*     */   
/*     */   public static Image getImageFromClipboard() {
/*     */     Transferable transferable;
/*  63 */     return getImageFromTransferable(transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null));
/*     */   }
/*     */   
/*     */   public static Image getImageFromTransferable(Transferable paramTransferable) {
/*     */     try {
/*  68 */       if (paramTransferable != null && paramTransferable.isDataFlavorSupported(DataFlavor.imageFlavor)) {
/*  69 */         return (Image)paramTransferable.getTransferData(DataFlavor.imageFlavor);
/*     */       }
/*  71 */       return null;
/*     */     }
/*  73 */     catch (UnsupportedFlavorException unsupportedFlavorException) {
/*  74 */       (paramTransferable = null).printStackTrace();
/*  75 */     } catch (IOException iOException) {
/*  76 */       throw new RuntimeException();
/*     */     } 
/*     */     
/*  79 */     return null;
/*     */   }
/*     */   
/*     */   public static BufferedImage scaleImage(BufferedImage paramBufferedImage, int paramInt1, int paramInt2, int paramInt3) {
/*  83 */     if (paramBufferedImage == null) {
/*  84 */       return null;
/*     */     }
/*     */     
/*  87 */     if (paramInt1 == 0 || paramInt2 == 0) {
/*  88 */       return null;
/*     */     }
/*     */     
/*  91 */     AffineTransform affineTransform = AffineTransform.getScaleInstance(paramInt1 / paramBufferedImage
/*  92 */         .getWidth(null), paramInt2 / paramBufferedImage
/*  93 */         .getHeight(null));
/*     */ 
/*     */     
/*     */     AffineTransformOp affineTransformOp;
/*     */     
/*  98 */     return (affineTransformOp = new AffineTransformOp(affineTransform, (paramInt3 != 0) ? paramInt3 : 2)).filter(paramBufferedImage, (BufferedImage)null);
/*     */   }
/*     */   
/*     */   public static BufferedImage toBufferedImage(Image paramImage) {
/* 102 */     if (paramImage == null)
/* 103 */       return null; 
/* 104 */     if (paramImage instanceof BufferedImage) {
/* 105 */       return (BufferedImage)paramImage;
/*     */     }
/*     */     
/* 108 */     int i = paramImage.getWidth(null);
/* 109 */     int j = paramImage.getHeight(null);
/* 110 */     if (i < 0 || j < 0) {
/* 111 */       return null;
/*     */     }
/*     */     
/*     */     BufferedImage bufferedImage;
/*     */     
/*     */     Graphics2D graphics2D;
/* 117 */     (graphics2D = (bufferedImage = new BufferedImage(i, j, 2)).createGraphics()).drawImage(paramImage, 0, 0, (ImageObserver)null);
/* 118 */     graphics2D.dispose();
/*     */     
/* 120 */     return bufferedImage;
/*     */   }
/*     */   
/*     */   public static void save(BufferedImage paramBufferedImage, File paramFile, String paramString) {
/*     */     try {
/* 125 */       ImageIO.write(paramBufferedImage, paramString, paramFile); return;
/* 126 */     } catch (Throwable throwable) {
/* 127 */       System.out.println("Write error for " + paramFile.getPath() + ": " + throwable.getMessage());
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BufferedImage loadImageFromFile(File paramFile) {
/* 137 */     if (paramFile == null || !paramFile.isFile()) {
/* 138 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 143 */       for (byte b = 0; b < 3; ) {
/*     */         BufferedImage bufferedImage;
/*     */         try {
/* 146 */           bufferedImage = ImageIO.read(paramFile);
/* 147 */         } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
/* 148 */           System.err.print("*");
/* 149 */           System.err.println("could not read" + paramFile);
/*     */         } 
/*     */ 
/*     */         
/* 153 */         if (b > 0) System.err.println();
/*     */         
/* 155 */         return bufferedImage;
/*     */       } 
/* 157 */     } catch (Throwable throwable) {
/*     */ 
/*     */       
/* 160 */       return null;
/*     */     } 
/*     */     
/* 163 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BufferedImage loadImageFromContent(byte[] paramArrayOfbyte, String paramString) {
/* 172 */     if (paramArrayOfbyte == null) {
/* 173 */       return null;
/*     */     }
/*     */     
/* 176 */     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfbyte);
/*     */     
/*     */     try {
/* 179 */       return ImageIO.read(byteArrayInputStream);
/* 180 */     } catch (IndexOutOfBoundsException|IOException indexOutOfBoundsException) {
/* 181 */       System.err.print("*");
/* 182 */       System.err.println("could not read from image bytes for " + paramString);
/*     */     } finally {
/*     */       try {
/* 185 */         byteArrayInputStream.close();
/* 186 */       } catch (IOException iOException) {
/* 187 */         (byteArrayInputStream = null).printStackTrace();
/*     */       } 
/*     */     } 
/*     */     
/* 191 */     return null;
/*     */   }
/*     */   
/*     */   public static String base64Encode(BufferedImage paramBufferedImage) {
/* 195 */     String str = null;
/* 196 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */     
/*     */     try {
/* 199 */       ImageIO.write(paramBufferedImage, "PNG", byteArrayOutputStream);
/* 200 */       byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
/*     */       
/* 202 */       str = Base64.getEncoder().encodeToString(arrayOfByte).replace("\r", "").replace("\n", "");
/* 203 */       byteArrayOutputStream.close();
/* 204 */     } catch (IOException iOException) {
/* 205 */       (paramBufferedImage = null).printStackTrace();
/*     */     } 
/*     */     
/* 208 */     return "data:image/png;base64," + str;
/*     */   }
/*     */   
/*     */   public static String base64Encode(File paramFile) {
/* 212 */     if (paramFile == null || !paramFile.isFile()) {
/* 213 */       return null;
/*     */     }
/*     */     
/*     */     try {
/* 217 */       FileInputStream fileInputStream = new FileInputStream(paramFile);
/* 218 */       byte[] arrayOfByte = new byte[(int)paramFile.length()];
/* 219 */       if (fileInputStream.read(arrayOfByte) != -1)
/*     */       {
/* 221 */         return "data:image/png;base64," + Base64.getEncoder().encodeToString(arrayOfByte).replace("\r", "").replace("\n", "");
/*     */       }
/* 223 */       return null;
/* 224 */     } catch (Throwable throwable) {
/* 225 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static BufferedImage base64Decode(File paramFile) {
/* 230 */     if (paramFile == null || !paramFile.isFile()) {
/* 231 */       return null;
/*     */     }
/*     */     
/*     */     try {
/* 235 */       FileInputStream fileInputStream = new FileInputStream(paramFile);
/* 236 */       byte[] arrayOfByte = new byte[(int)paramFile.length()]; String str; int i;
/* 237 */       if (fileInputStream.read(arrayOfByte) != -1 && (
/*     */ 
/*     */         
/* 240 */         i = (str = new String(arrayOfByte, StandardCharsets.UTF_8)).indexOf(',')) >= 0) {
/* 241 */         str = str.substring(i + 1);
/* 242 */         byte[] arrayOfByte1 = Base64.getDecoder().decode(str);
/*     */         
/*     */         ByteArrayInputStream byteArrayInputStream;
/* 245 */         BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream = new ByteArrayInputStream(arrayOfByte1));
/* 246 */         byteArrayInputStream.close();
/* 247 */         return bufferedImage;
/*     */       } 
/*     */       
/* 250 */       return null;
/* 251 */     } catch (Throwable throwable) {
/* 252 */       return null;
/*     */     } 
/*     */   }
/*     */   
/* 256 */   private static final Pattern BASE64_ENCODING_PATTERN = Pattern.compile("^data:image/[a-z0-9_-]+;base64,", 2);
/*     */   
/*     */   public static boolean isEncodedImage(String paramString) {
/* 259 */     return (paramString != null && paramString.startsWith("data:image/") && BASE64_ENCODING_PATTERN.matcher(paramString).find());
/*     */   }
/*     */   
/*     */   public static boolean isPossiblyEncodedImage(String paramString) {
/* 263 */     return (paramString != null && paramString.startsWith("data:image/"));
/*     */   }
/*     */   
/*     */   public static BufferedImage base64Decode(String paramString) {
/* 267 */     if (paramString == null || paramString.isEmpty()) {
/* 268 */       return null;
/*     */     }
/*     */     
/*     */     try {
/*     */       int i;
/* 273 */       if ((i = paramString.indexOf(',')) >= 0) {
/* 274 */         paramString = paramString.substring(i + 1);
/* 275 */         byte[] arrayOfByte = Base64.getDecoder().decode(paramString);
/*     */         
/*     */         ByteArrayInputStream byteArrayInputStream;
/* 278 */         BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream = new ByteArrayInputStream(arrayOfByte));
/* 279 */         byteArrayInputStream.close();
/* 280 */         return bufferedImage;
/*     */       } 
/* 282 */       return null;
/* 283 */     } catch (Throwable throwable) {
/* 284 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static BufferedImage loadImageFromURL(String paramString) {
/* 289 */     return loadImageFromURL(paramString, false);
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
/*     */   public static BufferedImage loadImageFromURL(String paramString, boolean paramBoolean) {
/* 302 */     if (paramString != null) {
/*     */       try {
/*     */         BufferedImage bufferedImage;
/* 305 */         return toBufferedImage(bufferedImage = ImageIO.read(new URL(paramString)));
/* 306 */       } catch (IOException iOException) {
/* 307 */         if (paramBoolean) {
/* 308 */           iOException.printStackTrace();
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 313 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BufferedImage makeRoundedCorner(BufferedImage paramBufferedImage, int paramInt1, int paramInt2) {
/* 320 */     if (paramInt1 == 0.0F) return paramBufferedImage;
/*     */     
/* 322 */     paramInt2 = paramBufferedImage.getWidth();
/* 323 */     int i = paramBufferedImage.getHeight();
/*     */ 
/*     */ 
/*     */     
/*     */     BufferedImage bufferedImage;
/*     */ 
/*     */ 
/*     */     
/*     */     Graphics2D graphics2D;
/*     */ 
/*     */     
/* 334 */     (graphics2D = (bufferedImage = new BufferedImage(paramInt2, i, 2)).createGraphics()).setComposite(AlphaComposite.Src);
/* 335 */     graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/* 336 */     graphics2D.setColor(Color.WHITE);
/*     */     
/* 338 */     graphics2D.fill(new RoundRectangle2D.Float(0.0F, 0.0F, paramInt2, i, paramInt1, paramInt1));
/*     */ 
/*     */ 
/*     */     
/* 342 */     graphics2D.setComposite(AlphaComposite.SrcAtop);
/* 343 */     graphics2D.drawImage(paramBufferedImage, 0, 0, (ImageObserver)null);
/*     */     
/* 345 */     graphics2D.dispose();
/*     */     
/* 347 */     return bufferedImage;
/*     */   }
/*     */   
/*     */   public static BufferedImage addBorder(BufferedImage paramBufferedImage, Color paramColor, int paramInt1, int paramInt2) {
/* 351 */     int k = paramBufferedImage.getWidth() + (paramInt1 << 1);
/* 352 */     int m = paramBufferedImage.getHeight() + (paramInt1 << 1);
/*     */     
/*     */     BufferedImage bufferedImage;
/*     */     Graphics2D graphics2D;
/* 356 */     (graphics2D = (bufferedImage = new BufferedImage(k, m, 2)).createGraphics()).setColor(paramColor);
/* 357 */     graphics2D.drawImage(paramBufferedImage, paramInt1, paramInt1, paramBufferedImage.getWidth(), paramBufferedImage.getHeight(), null);
/* 358 */     graphics2D.setStroke(new BasicStroke(paramInt1, 2, 0, paramInt1));
/* 359 */     graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*     */ 
/*     */ 
/*     */     
/* 363 */     int i = k - paramInt1 - 1;
/* 364 */     int j = m - paramInt1 - 1;
/* 365 */     k = paramInt1 / 2;
/* 366 */     if (paramInt2 > 0) {
/* 367 */       paramInt1 = paramInt2 + paramInt1;
/* 368 */       graphics2D.drawRoundRect(k, k, i, j, paramInt1, paramInt1);
/*     */     } else {
/* 370 */       graphics2D.drawRect(k, k, i, j);
/*     */     } 
/* 372 */     graphics2D.dispose();
/* 373 */     return bufferedImage;
/*     */   }
/*     */ 
/*     */   
/*     */   public static BufferedImage drawRectangle(BufferedImage paramBufferedImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Color paramColor, int paramInt5, int paramInt6) {
/* 378 */     return drawRectangle(paramBufferedImage, paramInt1, paramInt2, paramInt3, paramInt4, paramColor, paramInt5, paramInt6, null, 0.0F);
/*     */   }
/*     */   
/*     */   public static BufferedImage drawRectangle(BufferedImage paramBufferedImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Color paramColor, int paramInt5, int paramInt6, float[] paramArrayOffloat, float paramFloat) {
/*     */     Color color;
/*     */     BufferedImage bufferedImage;
/* 384 */     Graphics2D graphics2D = (bufferedImage = new BufferedImage(paramBufferedImage.getWidth(), paramBufferedImage.getHeight(), 2)).createGraphics();
/*     */     
/*     */     boolean bool;
/* 387 */     if (bool = (paramColor == null) ? true : false) {
/*     */       
/* 389 */       int i = paramBufferedImage.getRGB(paramInt1 + paramInt3 / 2, paramInt2 + paramInt4 / 2);
/* 390 */       color = Color.getColor("", i & 0xFFFFFF ^ 0xFFFFFFFF);
/*     */     } 
/*     */     
/* 393 */     graphics2D.drawImage(paramBufferedImage, 0, 0, (ImageObserver)null);
/* 394 */     if (paramArrayOffloat != null) {
/* 395 */       graphics2D.setStroke(new BasicStroke(paramInt5, 2, 0, paramInt5, paramArrayOffloat, paramFloat));
/*     */     } else {
/* 397 */       graphics2D.setStroke(new BasicStroke(paramInt5, 2, 0, paramInt5));
/*     */     } 
/*     */     
/* 400 */     graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 405 */     graphics2D.setColor(color);
/* 406 */     if (paramInt6 > 0) {
/* 407 */       graphics2D.drawRoundRect(paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramInt6);
/*     */     } else {
/* 409 */       graphics2D.drawRect(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */     } 
/* 411 */     graphics2D.dispose();
/* 412 */     return bufferedImage;
/*     */   }
/*     */   
/*     */   public static BufferedImage drawOval(BufferedImage paramBufferedImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Color paramColor, int paramInt5, float[] paramArrayOffloat, float paramFloat) {
/*     */     Color color;
/*     */     BufferedImage bufferedImage;
/* 418 */     Graphics2D graphics2D = (bufferedImage = new BufferedImage(paramBufferedImage.getWidth(), paramBufferedImage.getHeight(), 2)).createGraphics();
/*     */     
/*     */     boolean bool;
/* 421 */     if (bool = (paramColor == null) ? true : false) {
/*     */       
/* 423 */       int i = paramBufferedImage.getRGB(paramInt1 + paramInt3 / 2, paramInt2 + paramInt4 / 2);
/* 424 */       color = Color.getColor("", i & 0xFFFFFF ^ 0xFFFFFFFF);
/*     */     } 
/*     */     
/* 427 */     graphics2D.drawImage(paramBufferedImage, 0, 0, (ImageObserver)null);
/* 428 */     if (paramArrayOffloat != null) {
/* 429 */       graphics2D.setStroke(new BasicStroke(paramInt5, 2, 0, paramInt5, paramArrayOffloat, paramFloat));
/*     */     } else {
/* 431 */       graphics2D.setStroke(new BasicStroke(paramInt5, 2, 0, paramInt5));
/*     */     } 
/*     */     
/* 434 */     graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 439 */     graphics2D.setColor(color);
/* 440 */     graphics2D.drawOval(paramInt1, paramInt2, paramInt3, paramInt4);
/* 441 */     graphics2D.dispose();
/* 442 */     return bufferedImage;
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
/*     */   public static BufferedImage drawHighlightRectangle(BufferedImage paramBufferedImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Color paramColor1, int paramInt5, int paramInt6, Color paramColor2) {
/*     */     BufferedImage bufferedImage;
/*     */     Graphics2D graphics2D;
/* 456 */     (graphics2D = (bufferedImage = new BufferedImage(paramBufferedImage.getWidth(), paramBufferedImage.getHeight(), 2)).createGraphics()).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 461 */     boolean bool = (paramColor2.getAlpha() != 0) ? true : false;
/*     */     
/* 463 */     graphics2D.drawImage(paramBufferedImage, 0, 0, (ImageObserver)null);
/*     */     
/* 465 */     if (paramInt6 > 0) {
/* 466 */       if (bool) {
/* 467 */         graphics2D.setColor(paramColor2);
/* 468 */         graphics2D.fillRoundRect(paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramInt6);
/*     */       } 
/*     */       
/* 471 */       if (paramInt5 > 0) {
/* 472 */         graphics2D.setColor(paramColor1);
/* 473 */         graphics2D.setStroke(new BasicStroke(paramInt5, 2, 0, paramInt5));
/* 474 */         graphics2D.drawRoundRect(paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramInt6);
/*     */       } 
/*     */     } else {
/* 477 */       if (bool) {
/* 478 */         graphics2D.setColor(paramColor2);
/* 479 */         graphics2D.fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */       } 
/*     */       
/* 482 */       if (paramInt5 > 0) {
/* 483 */         graphics2D.setColor(paramColor1);
/* 484 */         graphics2D.setStroke(new BasicStroke(paramInt5, 2, 0, paramInt5));
/* 485 */         graphics2D.drawRect(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */       } 
/*     */     } 
/*     */     
/* 489 */     graphics2D.dispose();
/* 490 */     return bufferedImage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BufferedImage drawHighlightOval(BufferedImage paramBufferedImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Color paramColor1, int paramInt5, Color paramColor2) {
/*     */     BufferedImage bufferedImage;
/*     */     Graphics2D graphics2D;
/* 503 */     (graphics2D = (bufferedImage = new BufferedImage(paramBufferedImage.getWidth(), paramBufferedImage.getHeight(), 2)).createGraphics()).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 508 */     boolean bool = (paramColor2.getAlpha() != 0) ? true : false;
/*     */     
/* 510 */     graphics2D.drawImage(paramBufferedImage, 0, 0, (ImageObserver)null);
/*     */     
/* 512 */     if (bool) {
/* 513 */       graphics2D.setColor(paramColor2);
/* 514 */       graphics2D.fillOval(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */     } 
/*     */     
/* 517 */     if (paramInt5 > 0) {
/* 518 */       graphics2D.setColor(paramColor1);
/* 519 */       graphics2D.setStroke(new BasicStroke(paramInt5, 2, 0, paramInt5));
/* 520 */       graphics2D.drawOval(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */     } 
/*     */     
/* 523 */     graphics2D.dispose();
/* 524 */     return bufferedImage;
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
/*     */   public static BufferedImage punchOuterHighlightRectangle(BufferedImage paramBufferedImage1, BufferedImage paramBufferedImage2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Color paramColor, int paramInt7, int paramInt8, boolean paramBoolean) {
/*     */     boolean bool;
/* 538 */     if (!(bool = (paramColor.getAlpha() != 0) ? true : false)) {
/* 539 */       return paramBufferedImage2;
/*     */     }
/*     */     
/* 542 */     BufferedImage bufferedImage = (paramBufferedImage2 != null) ? paramBufferedImage2 : new BufferedImage(paramBufferedImage1.getWidth(), paramBufferedImage1.getHeight(), 2);
/* 543 */     int i = paramBufferedImage1.getWidth();
/* 544 */     int j = paramBufferedImage1.getHeight();
/*     */     
/*     */     Graphics2D graphics2D;
/*     */     
/* 548 */     (graphics2D = bufferedImage.createGraphics()).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 553 */     if (paramBufferedImage2 == null) {
/*     */       
/* 555 */       graphics2D.setColor(paramColor);
/* 556 */       if (paramInt8 > 0) {
/* 557 */         graphics2D.fillRoundRect(paramInt7, paramInt7, i - 2 * paramInt7, j - 2 * paramInt7, paramInt8, paramInt8);
/*     */       } else {
/* 559 */         graphics2D.fillRect(paramInt7, paramInt7, i - 2 * paramInt7, j - 2 * paramInt7);
/*     */       } 
/*     */     } 
/*     */     
/* 563 */     if (paramInt6 > 0) {
/* 564 */       graphics2D.setColor(TRANSPARENT);
/* 565 */       graphics2D.setComposite(AlphaComposite.Src);
/* 566 */       graphics2D.fillRoundRect(Utils.minLimit(0, new int[] { paramInt1 - paramInt5 / 2 }), Utils.minLimit(0, new int[] { paramInt2 - paramInt5 / 2 }), paramInt3 + paramInt5, paramInt4 + paramInt5, paramInt6 + paramInt5, paramInt6 + paramInt5);
/*     */     } else {
/* 568 */       graphics2D.setColor(TRANSPARENT);
/* 569 */       graphics2D.setComposite(AlphaComposite.Src);
/* 570 */       graphics2D.fillRect(Utils.minLimit(0, new int[] { paramInt1 - paramInt5 / 2 }), Utils.minLimit(0, new int[] { paramInt2 - paramInt5 / 2 }), paramInt3 + paramInt5, paramInt4 + paramInt5);
/*     */     } 
/*     */     
/* 573 */     if (paramBoolean) {
/*     */       
/* 575 */       graphics2D.setComposite(AlphaComposite.DstOver);
/* 576 */       graphics2D.drawImage(paramBufferedImage1, 0, 0, (ImageObserver)null);
/*     */     } 
/*     */     
/* 579 */     graphics2D.dispose();
/* 580 */     return bufferedImage;
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
/*     */   public static BufferedImage punchOuterHighlightOval(BufferedImage paramBufferedImage1, BufferedImage paramBufferedImage2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Color paramColor, int paramInt6, int paramInt7, boolean paramBoolean) {
/*     */     boolean bool;
/* 594 */     if (!(bool = (paramColor.getAlpha() != 0) ? true : false)) {
/* 595 */       return paramBufferedImage2;
/*     */     }
/*     */     
/* 598 */     BufferedImage bufferedImage = (paramBufferedImage2 != null) ? paramBufferedImage2 : new BufferedImage(paramBufferedImage1.getWidth(), paramBufferedImage1.getHeight(), 2);
/* 599 */     int i = paramBufferedImage1.getWidth();
/* 600 */     int j = paramBufferedImage1.getHeight();
/*     */     
/*     */     Graphics2D graphics2D;
/*     */     
/* 604 */     (graphics2D = bufferedImage.createGraphics()).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 609 */     if (paramBufferedImage2 == null) {
/*     */       
/* 611 */       graphics2D.setColor(paramColor);
/* 612 */       if (paramInt7 > 0) {
/* 613 */         graphics2D.fillRoundRect(paramInt6, paramInt6, i - 2 * paramInt6, j - 2 * paramInt6, paramInt7, paramInt7);
/*     */       } else {
/* 615 */         graphics2D.fillRect(paramInt6, paramInt6, i - 2 * paramInt6, j - 2 * paramInt6);
/*     */       } 
/*     */     } 
/*     */     
/* 619 */     graphics2D.setColor(TRANSPARENT);
/* 620 */     graphics2D.setComposite(AlphaComposite.Src);
/* 621 */     graphics2D.fillOval(Utils.minLimit(0, new int[] { paramInt1 - paramInt5 / 2 }), Utils.minLimit(0, new int[] { paramInt2 - paramInt5 / 2 }), paramInt3 + paramInt5, paramInt4 + paramInt5);
/*     */     
/* 623 */     if (paramBoolean) {
/*     */       
/* 625 */       graphics2D.setComposite(AlphaComposite.DstOver);
/* 626 */       graphics2D.drawImage(paramBufferedImage1, 0, 0, (ImageObserver)null);
/*     */     } 
/*     */     
/* 629 */     graphics2D.dispose();
/* 630 */     return bufferedImage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BufferedImage cropImage(BufferedImage paramBufferedImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 638 */     return paramBufferedImage = paramBufferedImage.getSubimage(paramInt1, paramInt3, paramBufferedImage.getWidth() - paramInt1 - paramInt2, paramBufferedImage.getHeight() - paramInt3 - paramInt4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BufferedImage removeAlpha(BufferedImage paramBufferedImage) {
/*     */     BufferedImage bufferedImage;
/*     */     Graphics2D graphics2D;
/* 647 */     (graphics2D = (bufferedImage = new BufferedImage(paramBufferedImage.getWidth(null), paramBufferedImage.getHeight(null), 1)).createGraphics()).drawImage(paramBufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), Color.WHITE, null);
/* 648 */     graphics2D.dispose();
/*     */     
/* 650 */     return bufferedImage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Image toTransparent(BufferedImage paramBufferedImage, final Color color, final int tolerance) {
/* 657 */     RGBImageFilter rGBImageFilter = new RGBImageFilter()
/*     */       {
/*     */         
/* 660 */         public final int markerRGB = color.getRGB() | 0xFF000000;
/* 661 */         final int radius = tolerance * tolerance * 3;
/*     */         
/*     */         public final int filterRGB(int param1Int1, int param1Int2, int param1Int3) {
/* 664 */           if (tolerance == 0 && (param1Int3 | 0xFF000000) == this.markerRGB)
/*     */           {
/* 666 */             return 0xFFFFFF & param1Int3;
/*     */           }
/* 668 */           if ((param1Int3 & 0xFF000000) == -16777216) {
/*     */             
/* 670 */             param1Int1 = (param1Int3 >> 16 & 0xFF) - (this.markerRGB >> 16 & 0xFF);
/* 671 */             param1Int2 = (param1Int3 >> 8 & 0xFF) - (this.markerRGB >> 8 & 0xFF);
/* 672 */             int i = (param1Int3 & 0xFF) - (this.markerRGB & 0xFF);
/*     */ 
/*     */             
/* 675 */             if ((param1Int1 = param1Int1 * param1Int1 + param1Int2 * param1Int2 + i * i) <= this.radius)
/*     */             {
/* 677 */               return 0xFFFFFF & param1Int3;
/*     */             }
/*     */           } 
/*     */           
/* 681 */           return param1Int3;
/*     */         }
/*     */       };
/*     */     
/* 685 */     FilteredImageSource filteredImageSource = new FilteredImageSource(paramBufferedImage.getSource(), rGBImageFilter);
/* 686 */     return Toolkit.getDefaultToolkit().createImage(filteredImageSource);
/*     */   }
/*     */   
/*     */   public static byte[] getImageBytes(BufferedImage paramBufferedImage) {
/* 690 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */     
/*     */     try {
/* 693 */       ImageIO.write(paramBufferedImage, "PNG", byteArrayOutputStream);
/* 694 */       byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
/*     */       
/* 696 */       byteArrayOutputStream.close();
/* 697 */       return arrayOfByte;
/* 698 */     } catch (IOException iOException) {
/* 699 */       (paramBufferedImage = null).printStackTrace();
/*     */ 
/*     */       
/* 702 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\misc\ImageUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */