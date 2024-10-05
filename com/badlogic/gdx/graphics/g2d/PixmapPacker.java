/*     */ package com.badlogic.gdx.graphics.g2d;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.TextureData;
/*     */ import com.badlogic.gdx.graphics.glutils.PixmapTextureData;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.OrderedMap;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PixmapPacker
/*     */   implements Disposable
/*     */ {
/*     */   boolean packToTexture;
/*     */   boolean disposed;
/*     */   int pageWidth;
/*     */   int pageHeight;
/*     */   Pixmap.Format pageFormat;
/*     */   int padding;
/*     */   boolean duplicateBorder;
/*     */   boolean stripWhitespaceX;
/*     */   boolean stripWhitespaceY;
/*     */   int alphaThreshold;
/* 109 */   Color transparentColor = new Color(0.0F, 0.0F, 0.0F, 0.0F);
/* 110 */   final Array<Page> pages = new Array();
/*     */   
/*     */   PackStrategy packStrategy;
/* 113 */   static Pattern indexPattern = Pattern.compile("(.+)_(\\d+)$");
/*     */   
/*     */   private Color c;
/*     */   
/*     */   public PixmapPacker(int paramInt1, int paramInt2, Pixmap.Format paramFormat, int paramInt3, boolean paramBoolean) {
/* 118 */     this(paramInt1, paramInt2, paramFormat, paramInt3, paramBoolean, false, false, new GuillotineStrategy());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PixmapPacker(int paramInt1, int paramInt2, Pixmap.Format paramFormat, int paramInt3, boolean paramBoolean, PackStrategy paramPackStrategy) {
/* 125 */     this(paramInt1, paramInt2, paramFormat, paramInt3, paramBoolean, false, false, paramPackStrategy);
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
/*     */   public void sort(Array<Pixmap> paramArray) {
/* 150 */     this.packStrategy.sort(paramArray);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized PixmapPackerRectangle pack(Pixmap paramPixmap) {
/* 156 */     return pack(null, paramPixmap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized PixmapPackerRectangle pack(String paramString, Pixmap paramPixmap) {
/*     */     PixmapPackerRectangle pixmapPackerRectangle;
/* 166 */     if (this.disposed) return null; 
/* 167 */     if (paramString != null && getRect(paramString) != null) {
/* 168 */       throw new GdxRuntimeException("Pixmap has already been packed with name: " + paramString);
/*     */     }
/*     */     
/* 171 */     Pixmap pixmap = null;
/* 172 */     if (paramString != null && paramString.endsWith(".9")) {
/* 173 */       pixmapPackerRectangle = new PixmapPackerRectangle(0, 0, paramPixmap.getWidth() - 2, paramPixmap.getHeight() - 2);
/*     */       
/* 175 */       (pixmap = new Pixmap(paramPixmap.getWidth() - 2, paramPixmap.getHeight() - 2, paramPixmap.getFormat())).setBlending(Pixmap.Blending.None);
/* 176 */       pixmapPackerRectangle.splits = getSplits(paramPixmap);
/* 177 */       pixmapPackerRectangle.pads = getPads(paramPixmap, pixmapPackerRectangle.splits);
/* 178 */       pixmap.drawPixmap(paramPixmap, 0, 0, 1, 1, paramPixmap.getWidth() - 1, paramPixmap.getHeight() - 1);
/* 179 */       paramPixmap = pixmap;
/* 180 */       paramString = paramString.split("\\.")[0];
/*     */     }
/* 182 */     else if (this.stripWhitespaceX || this.stripWhitespaceY) {
/* 183 */       int i1 = paramPixmap.getWidth();
/* 184 */       int i2 = paramPixmap.getHeight();
/*     */       
/* 186 */       byte b1 = 0;
/* 187 */       int i3 = paramPixmap.getHeight();
/* 188 */       if (this.stripWhitespaceY) {
/*     */         int i6;
/* 190 */         label95: for (i6 = 0; i6 < paramPixmap.getHeight(); i6++) {
/* 191 */           for (byte b = 0; b < paramPixmap.getWidth(); ) {
/*     */             int i7;
/*     */             int i8;
/* 194 */             if ((i7 = (i8 = paramPixmap.getPixel(b, i6)) & 0xFF) <= this.alphaThreshold) { b++; continue; }
/*     */              break label95;
/* 196 */           }  b1++;
/*     */         } 
/*     */         
/* 199 */         for (i6 = paramPixmap.getHeight(); --i6 >= b1; ) {
/* 200 */           for (byte b = 0; b < paramPixmap.getWidth(); ) {
/*     */             int i7;
/*     */             int i8;
/* 203 */             if ((i7 = (i8 = paramPixmap.getPixel(b, i6)) & 0xFF) <= this.alphaThreshold) { b++; continue; }
/*     */              // Byte code: goto -> 343
/* 205 */           }  i3--;
/*     */         } 
/*     */       } 
/* 208 */       byte b2 = 0;
/* 209 */       int i4 = paramPixmap.getWidth();
/* 210 */       if (this.stripWhitespaceX) {
/*     */         int i6;
/* 212 */         label96: for (i6 = 0; i6 < paramPixmap.getWidth(); i6++) {
/* 213 */           for (byte b = b1; b < i3; ) {
/*     */             int i7;
/*     */             
/* 216 */             if ((i7 = (i7 = paramPixmap.getPixel(i6, b)) & 0xFF) <= this.alphaThreshold) { b++; continue; }
/*     */              break label96;
/* 218 */           }  b2++;
/*     */         } 
/*     */         
/* 221 */         for (i6 = paramPixmap.getWidth(); --i6 >= b2; ) {
/* 222 */           for (byte b = b1; b < i3; ) {
/*     */             int i7;
/*     */             
/* 225 */             if ((i7 = (i7 = paramPixmap.getPixel(i6, b)) & 0xFF) <= this.alphaThreshold) { b++; continue; }
/*     */              // Byte code: goto -> 480
/* 227 */           }  i4--;
/*     */         } 
/*     */       } 
/*     */       
/* 231 */       int i5 = i4 - b2;
/* 232 */       int n = i3 - b1;
/*     */ 
/*     */       
/* 235 */       (pixmap = new Pixmap(i5, n, paramPixmap.getFormat())).setBlending(Pixmap.Blending.None);
/* 236 */       pixmap.drawPixmap(paramPixmap, 0, 0, b2, b1, i5, n);
/* 237 */       paramPixmap = pixmap;
/*     */       
/* 239 */       pixmapPackerRectangle = new PixmapPackerRectangle(0, 0, i5, n, b2, b1, i1, i2);
/*     */     } else {
/* 241 */       pixmapPackerRectangle = new PixmapPackerRectangle(0, 0, paramPixmap.getWidth(), paramPixmap.getHeight());
/*     */     } 
/*     */ 
/*     */     
/* 245 */     if (pixmapPackerRectangle.getWidth() > this.pageWidth || pixmapPackerRectangle.getHeight() > this.pageHeight) {
/* 246 */       if (paramString == null) throw new GdxRuntimeException("Page size too small for pixmap."); 
/* 247 */       throw new GdxRuntimeException("Page size too small for pixmap: " + paramString);
/*     */     } 
/*     */     
/* 250 */     Page page = this.packStrategy.pack(this, paramString, pixmapPackerRectangle);
/* 251 */     if (paramString != null) {
/* 252 */       page.rects.put(paramString, pixmapPackerRectangle);
/* 253 */       page.addedRects.add(paramString);
/*     */     } 
/*     */     
/* 256 */     int i = (int)pixmapPackerRectangle.x, j = (int)pixmapPackerRectangle.y, k = (int)pixmapPackerRectangle.width, m = (int)pixmapPackerRectangle.height;
/*     */     
/* 258 */     if (this.packToTexture && !this.duplicateBorder && page.texture != null && !page.dirty) {
/* 259 */       page.texture.bind();
/* 260 */       Gdx.gl.glTexSubImage2D(page.texture.glTarget, 0, i, j, k, m, paramPixmap.getGLFormat(), paramPixmap
/* 261 */           .getGLType(), paramPixmap.getPixels());
/*     */     } else {
/* 263 */       page.dirty = true;
/*     */     } 
/* 265 */     page.image.drawPixmap(paramPixmap, i, j);
/*     */     
/* 267 */     if (this.duplicateBorder) {
/* 268 */       int n = paramPixmap.getWidth(), i1 = paramPixmap.getHeight();
/*     */       
/* 270 */       page.image.drawPixmap(paramPixmap, 0, 0, 1, 1, i - 1, j - 1, 1, 1);
/* 271 */       page.image.drawPixmap(paramPixmap, n - 1, 0, 1, 1, i + k, j - 1, 1, 1);
/* 272 */       page.image.drawPixmap(paramPixmap, 0, i1 - 1, 1, 1, i - 1, j + m, 1, 1);
/* 273 */       page.image.drawPixmap(paramPixmap, n - 1, i1 - 1, 1, 1, i + k, j + m, 1, 1);
/*     */       
/* 275 */       page.image.drawPixmap(paramPixmap, 0, 0, n, 1, i, j - 1, k, 1);
/* 276 */       page.image.drawPixmap(paramPixmap, 0, i1 - 1, n, 1, i, j + m, k, 1);
/* 277 */       page.image.drawPixmap(paramPixmap, 0, 0, 1, i1, i - 1, j, 1, m);
/* 278 */       page.image.drawPixmap(paramPixmap, n - 1, 0, 1, i1, i + k, j, 1, m);
/*     */     } 
/*     */     
/* 281 */     if (pixmap != null) {
/* 282 */       pixmap.dispose();
/*     */     }
/*     */     
/* 285 */     pixmapPackerRectangle.page = page;
/* 286 */     return pixmapPackerRectangle;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<Page> getPages() {
/* 292 */     return this.pages;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized Rectangle getRect(String paramString) {
/* 298 */     for (Array.ArrayIterator<Page> arrayIterator = this.pages.iterator(); arrayIterator.hasNext();) {
/*     */       
/* 300 */       if ((rectangle = (Rectangle)(page = arrayIterator.next()).rects.get(paramString)) != null) return rectangle; 
/*     */     } 
/* 302 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized Page getPage(String paramString) {
/* 308 */     for (Array.ArrayIterator<Page> arrayIterator = this.pages.iterator(); arrayIterator.hasNext();) {
/*     */       
/* 310 */       if ((rectangle = (Rectangle)(page = arrayIterator.next()).rects.get(paramString)) != null) return page; 
/*     */     } 
/* 312 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized int getPageIndex(String paramString) {
/* 319 */     for (byte b = 0; b < this.pages.size; b++) {
/*     */       Rectangle rectangle;
/* 321 */       if ((rectangle = (Rectangle)((Page)this.pages.get(b)).rects.get(paramString)) != null) return b; 
/*     */     } 
/* 323 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void dispose() {
/* 329 */     for (Array.ArrayIterator<Page> arrayIterator = this.pages.iterator(); arrayIterator.hasNext();) {
/* 330 */       if ((page = arrayIterator.next()).texture == null) {
/* 331 */         page.image.dispose();
/*     */       }
/*     */     } 
/* 334 */     this.disposed = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized TextureAtlas generateTextureAtlas(Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2, boolean paramBoolean) {
/* 340 */     TextureAtlas textureAtlas = new TextureAtlas();
/* 341 */     updateTextureAtlas(textureAtlas, paramTextureFilter1, paramTextureFilter2, paramBoolean);
/* 342 */     return textureAtlas;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void updateTextureAtlas(TextureAtlas paramTextureAtlas, Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2, boolean paramBoolean) {
/* 351 */     updateTextureAtlas(paramTextureAtlas, paramTextureFilter1, paramTextureFilter2, paramBoolean, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void updateTextureAtlas(TextureAtlas paramTextureAtlas, Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2, boolean paramBoolean1, boolean paramBoolean2) {
/* 360 */     updatePageTextures(paramTextureFilter1, paramTextureFilter2, paramBoolean1);
/* 361 */     for (Array.ArrayIterator<Page> arrayIterator = this.pages.iterator(); arrayIterator.hasNext();) {
/* 362 */       if ((page = arrayIterator.next()).addedRects.size > 0) {
/* 363 */         for (Array.ArrayIterator<String> arrayIterator1 = page.addedRects.iterator(); arrayIterator1.hasNext(); ) { String str = arrayIterator1.next();
/* 364 */           PixmapPackerRectangle pixmapPackerRectangle = (PixmapPackerRectangle)page.rects.get(str);
/* 365 */           TextureAtlas.AtlasRegion atlasRegion = new TextureAtlas.AtlasRegion(page.texture, (int)pixmapPackerRectangle.x, (int)pixmapPackerRectangle.y, (int)pixmapPackerRectangle.width, (int)pixmapPackerRectangle.height);
/*     */ 
/*     */           
/* 368 */           if (pixmapPackerRectangle.splits != null) {
/* 369 */             atlasRegion.names = new String[] { "split", "pad" };
/* 370 */             atlasRegion.values = new int[][] { pixmapPackerRectangle.splits, pixmapPackerRectangle.pads };
/*     */           } 
/*     */           
/* 373 */           int i = -1;
/* 374 */           str = str;
/*     */           Matcher matcher;
/* 376 */           if (paramBoolean2 && (
/*     */             
/* 378 */             matcher = indexPattern.matcher(str)).matches()) {
/* 379 */             str = matcher.group(1);
/* 380 */             i = Integer.parseInt(matcher.group(2));
/*     */           } 
/*     */ 
/*     */           
/* 384 */           atlasRegion.name = str;
/* 385 */           atlasRegion.index = i;
/* 386 */           atlasRegion.offsetX = pixmapPackerRectangle.offsetX;
/* 387 */           atlasRegion.offsetY = (int)(pixmapPackerRectangle.originalHeight - pixmapPackerRectangle.height - pixmapPackerRectangle.offsetY);
/* 388 */           atlasRegion.originalWidth = pixmapPackerRectangle.originalWidth;
/* 389 */           atlasRegion.originalHeight = pixmapPackerRectangle.originalHeight;
/*     */           
/* 391 */           paramTextureAtlas.getRegions().add(atlasRegion); }
/*     */         
/* 393 */         page.addedRects.clear();
/* 394 */         paramTextureAtlas.getTextures().add(page.texture);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void updateTextureRegions(Array<TextureRegion> paramArray, Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2, boolean paramBoolean) {
/* 403 */     updatePageTextures(paramTextureFilter1, paramTextureFilter2, paramBoolean);
/* 404 */     while (paramArray.size < this.pages.size) {
/* 405 */       paramArray.add(new TextureRegion(((Page)this.pages.get(paramArray.size)).texture));
/*     */     }
/*     */   }
/*     */   
/*     */   public synchronized void updatePageTextures(Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2, boolean paramBoolean) {
/* 410 */     for (Array.ArrayIterator<Page> arrayIterator = this.pages.iterator(); arrayIterator.hasNext();)
/* 411 */       (page = arrayIterator.next()).updateTexture(paramTextureFilter1, paramTextureFilter2, paramBoolean); 
/*     */   }
/*     */   
/*     */   public int getPageWidth() {
/* 415 */     return this.pageWidth;
/*     */   }
/*     */   
/*     */   public void setPageWidth(int paramInt) {
/* 419 */     this.pageWidth = paramInt;
/*     */   }
/*     */   
/*     */   public int getPageHeight() {
/* 423 */     return this.pageHeight;
/*     */   }
/*     */   
/*     */   public void setPageHeight(int paramInt) {
/* 427 */     this.pageHeight = paramInt;
/*     */   }
/*     */   
/*     */   public Pixmap.Format getPageFormat() {
/* 431 */     return this.pageFormat;
/*     */   }
/*     */   
/*     */   public void setPageFormat(Pixmap.Format paramFormat) {
/* 435 */     this.pageFormat = paramFormat;
/*     */   }
/*     */   
/*     */   public int getPadding() {
/* 439 */     return this.padding;
/*     */   }
/*     */   
/*     */   public void setPadding(int paramInt) {
/* 443 */     this.padding = paramInt;
/*     */   }
/*     */   
/*     */   public boolean getDuplicateBorder() {
/* 447 */     return this.duplicateBorder;
/*     */   }
/*     */   
/*     */   public void setDuplicateBorder(boolean paramBoolean) {
/* 451 */     this.duplicateBorder = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean getPackToTexture() {
/* 455 */     return this.packToTexture;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPackToTexture(boolean paramBoolean) {
/* 462 */     this.packToTexture = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Page
/*     */   {
/* 469 */     OrderedMap<String, PixmapPacker.PixmapPackerRectangle> rects = new OrderedMap();
/*     */     Pixmap image;
/*     */     Texture texture;
/* 472 */     final Array<String> addedRects = new Array();
/*     */     
/*     */     boolean dirty;
/*     */     
/*     */     public Page(PixmapPacker param1PixmapPacker) {
/* 477 */       this.image = new Pixmap(param1PixmapPacker.pageWidth, param1PixmapPacker.pageHeight, param1PixmapPacker.pageFormat);
/* 478 */       this.image.setBlending(Pixmap.Blending.None);
/* 479 */       this.image.setColor(param1PixmapPacker.getTransparentColor());
/* 480 */       this.image.fill();
/*     */     }
/*     */     
/*     */     public Pixmap getPixmap() {
/* 484 */       return this.image;
/*     */     }
/*     */     
/*     */     public OrderedMap<String, PixmapPacker.PixmapPackerRectangle> getRects() {
/* 488 */       return this.rects;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Texture getTexture() {
/* 494 */       return this.texture;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean updateTexture(Texture.TextureFilter param1TextureFilter1, Texture.TextureFilter param1TextureFilter2, boolean param1Boolean) {
/* 501 */       if (this.texture != null) {
/* 502 */         if (!this.dirty) return false; 
/* 503 */         this.texture.load(this.texture.getTextureData());
/*     */       } else {
/* 505 */         this.texture = new Texture((TextureData)new PixmapTextureData(this.image, this.image.getFormat(), param1Boolean, false, true))
/*     */           {
/*     */             public void dispose() {
/* 508 */               super.dispose();
/* 509 */               PixmapPacker.Page.this.image.dispose();
/*     */             }
/*     */           };
/* 512 */         this.texture.setFilter(param1TextureFilter1, param1TextureFilter2);
/*     */       } 
/* 514 */       this.dirty = false;
/* 515 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class GuillotineStrategy
/*     */     implements PackStrategy
/*     */   {
/*     */     Comparator<Pixmap> comparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void sort(Array<Pixmap> param1Array) {
/* 537 */       if (this.comparator == null) {
/* 538 */         this.comparator = new Comparator<Pixmap>() {
/*     */             public int compare(Pixmap param2Pixmap1, Pixmap param2Pixmap2) {
/* 540 */               return Math.max(param2Pixmap1.getWidth(), param2Pixmap1.getHeight()) - Math.max(param2Pixmap2.getWidth(), param2Pixmap2.getHeight());
/*     */             }
/*     */           };
/*     */       }
/* 544 */       param1Array.sort(this.comparator);
/*     */     }
/*     */     
/*     */     public PixmapPacker.Page pack(PixmapPacker param1PixmapPacker, String param1String, Rectangle param1Rectangle) {
/*     */       GuillotinePage guillotinePage;
/* 549 */       if (param1PixmapPacker.pages.size == 0) {
/*     */         
/* 551 */         guillotinePage = new GuillotinePage(param1PixmapPacker);
/* 552 */         param1PixmapPacker.pages.add(guillotinePage);
/*     */       } else {
/*     */         
/* 555 */         guillotinePage = (GuillotinePage)param1PixmapPacker.pages.peek();
/*     */       } 
/*     */       
/* 558 */       int i = param1PixmapPacker.padding;
/* 559 */       param1Rectangle.width += i;
/* 560 */       param1Rectangle.height += i;
/*     */       Node node;
/* 562 */       if ((node = insert(guillotinePage.root, param1Rectangle)) == null) {
/*     */         
/* 564 */         guillotinePage = new GuillotinePage(param1PixmapPacker);
/* 565 */         param1PixmapPacker.pages.add(guillotinePage);
/* 566 */         node = insert(guillotinePage.root, param1Rectangle);
/*     */       } 
/* 568 */       node.full = true;
/* 569 */       param1Rectangle.set(node.rect.x, node.rect.y, node.rect.width - i, node.rect.height - i);
/* 570 */       return guillotinePage;
/*     */     }
/*     */     
/*     */     private Node insert(Node param1Node, Rectangle param1Rectangle) {
/* 574 */       if (!param1Node.full && param1Node.leftChild != null && param1Node.rightChild != null) {
/*     */         Node node;
/* 576 */         if ((node = insert(param1Node.leftChild, param1Rectangle)) == null) node = insert(param1Node.rightChild, param1Rectangle); 
/* 577 */         return node;
/*     */       } 
/* 579 */       if (param1Node.full) return null; 
/* 580 */       if (param1Node.rect.width == param1Rectangle.width && param1Node.rect.height == param1Rectangle.height) return param1Node; 
/* 581 */       if (param1Node.rect.width < param1Rectangle.width || param1Node.rect.height < param1Rectangle.height) return null;
/*     */       
/* 583 */       param1Node.leftChild = new Node();
/* 584 */       param1Node.rightChild = new Node();
/*     */       
/* 586 */       int i = (int)param1Node.rect.width - (int)param1Rectangle.width;
/* 587 */       int j = (int)param1Node.rect.height - (int)param1Rectangle.height;
/* 588 */       if (i > j) {
/* 589 */         param1Node.leftChild.rect.x = param1Node.rect.x;
/* 590 */         param1Node.leftChild.rect.y = param1Node.rect.y;
/* 591 */         param1Node.leftChild.rect.width = param1Rectangle.width;
/* 592 */         param1Node.leftChild.rect.height = param1Node.rect.height;
/*     */         
/* 594 */         param1Node.rect.x += param1Rectangle.width;
/* 595 */         param1Node.rightChild.rect.y = param1Node.rect.y;
/* 596 */         param1Node.rect.width -= param1Rectangle.width;
/* 597 */         param1Node.rightChild.rect.height = param1Node.rect.height;
/*     */       } else {
/* 599 */         param1Node.leftChild.rect.x = param1Node.rect.x;
/* 600 */         param1Node.leftChild.rect.y = param1Node.rect.y;
/* 601 */         param1Node.leftChild.rect.width = param1Node.rect.width;
/* 602 */         param1Node.leftChild.rect.height = param1Rectangle.height;
/*     */         
/* 604 */         param1Node.rightChild.rect.x = param1Node.rect.x;
/* 605 */         param1Node.rect.y += param1Rectangle.height;
/* 606 */         param1Node.rightChild.rect.width = param1Node.rect.width;
/* 607 */         param1Node.rect.height -= param1Rectangle.height;
/*     */       } 
/*     */       
/* 610 */       return insert(param1Node.leftChild, param1Rectangle);
/*     */     }
/*     */     static final class Node { public Node leftChild; public Node rightChild;
/*     */       public final Rectangle rect;
/*     */       public boolean full;
/*     */       
/*     */       Node() {
/* 617 */         this.rect = new Rectangle();
/*     */       } }
/*     */ 
/*     */     
/*     */     static class GuillotinePage extends PixmapPacker.Page {
/*     */       PixmapPacker.GuillotineStrategy.Node root;
/*     */       
/*     */       public GuillotinePage(PixmapPacker param2PixmapPacker) {
/* 625 */         super(param2PixmapPacker);
/* 626 */         this.root = new PixmapPacker.GuillotineStrategy.Node();
/* 627 */         this.root.rect.x = param2PixmapPacker.padding;
/* 628 */         this.root.rect.y = param2PixmapPacker.padding;
/* 629 */         this.root.rect.width = (param2PixmapPacker.pageWidth - (param2PixmapPacker.padding << 1));
/* 630 */         this.root.rect.height = (param2PixmapPacker.pageHeight - (param2PixmapPacker.padding << 1));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static class SkylineStrategy
/*     */     implements PackStrategy
/*     */   {
/*     */     Comparator<Pixmap> comparator;
/*     */     
/*     */     public void sort(Array<Pixmap> param1Array) {
/* 641 */       if (this.comparator == null) {
/* 642 */         this.comparator = new Comparator<Pixmap>() {
/*     */             public int compare(Pixmap param2Pixmap1, Pixmap param2Pixmap2) {
/* 644 */               return param2Pixmap1.getHeight() - param2Pixmap2.getHeight();
/*     */             }
/*     */           };
/*     */       }
/* 648 */       param1Array.sort(this.comparator);
/*     */     }
/*     */     
/*     */     public PixmapPacker.Page pack(PixmapPacker param1PixmapPacker, String param1String, Rectangle param1Rectangle) {
/* 652 */       int i = param1PixmapPacker.padding;
/* 653 */       int j = param1PixmapPacker.pageWidth - (i << 1), k = param1PixmapPacker.pageHeight - (i << 1);
/* 654 */       int m = (int)param1Rectangle.width + i, n = (int)param1Rectangle.height + i; byte b; int i1;
/* 655 */       for (b = 0, i1 = param1PixmapPacker.pages.size; b < i1; b++) {
/* 656 */         SkylinePage skylinePage1 = (SkylinePage)param1PixmapPacker.pages.get(b);
/* 657 */         SkylinePage.Row row1 = null; byte b1;
/*     */         int i2;
/* 659 */         for (b1 = 0, i2 = skylinePage1.rows.size - 1; b1 < i2; b1++) {
/*     */           SkylinePage.Row row2;
/* 661 */           if ((row2 = (SkylinePage.Row)skylinePage1.rows.get(b1)).x + m < j && 
/* 662 */             row2.y + n < k && 
/* 663 */             n <= row2.height && (
/* 664 */             row1 == null || row2.height < row1.height)) row1 = row2; 
/*     */         } 
/* 666 */         if (row1 == null) {
/*     */           SkylinePage.Row row2;
/*     */           
/* 669 */           if ((row2 = (SkylinePage.Row)skylinePage1.rows.peek()).y + n < k)
/* 670 */           { if (row2.x + m < j)
/* 671 */             { row2.height = Math.max(row2.height, n);
/* 672 */               row1 = row2; }
/* 673 */             else if (row2.y + row2.height + n < k)
/*     */             
/*     */             { 
/* 676 */               row2.y += row2.height;
/* 677 */               row1.height = n;
/* 678 */               skylinePage1.rows.add(row1); }  }
/*     */           else { continue; }
/*     */         
/* 681 */         }  if (row1 != null) {
/* 682 */           param1Rectangle.x = row1.x;
/* 683 */           param1Rectangle.y = row1.y;
/* 684 */           row1.x += m;
/* 685 */           return skylinePage1;
/*     */         } 
/*     */         continue;
/*     */       } 
/* 689 */       SkylinePage skylinePage = new SkylinePage(param1PixmapPacker);
/* 690 */       param1PixmapPacker.pages.add(skylinePage);
/*     */       SkylinePage.Row row;
/* 692 */       (row = new SkylinePage.Row()).x = i + m;
/* 693 */       row.y = i;
/* 694 */       row.height = n;
/* 695 */       skylinePage.rows.add(row);
/* 696 */       param1Rectangle.x = i;
/* 697 */       param1Rectangle.y = i;
/* 698 */       return skylinePage;
/*     */     }
/*     */     
/*     */     static class SkylinePage extends PixmapPacker.Page {
/* 702 */       Array<Row> rows = new Array();
/*     */       
/*     */       public SkylinePage(PixmapPacker param2PixmapPacker) {
/* 705 */         super(param2PixmapPacker);
/*     */       }
/*     */       static class Row {
/*     */         int x; int y;
/*     */         int height; }
/*     */     }
/*     */     
/*     */     static class Row { int x;
/*     */       int y;
/*     */       int height; } }
/*     */   
/*     */   public Color getTransparentColor() {
/* 717 */     return this.transparentColor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransparentColor(Color paramColor) {
/* 724 */     this.transparentColor.set(paramColor);
/*     */   }
/*     */ 
/*     */   
/*     */   private int[] getSplits(Pixmap paramPixmap) {
/* 729 */     int i = getSplitPoint(paramPixmap, 1, 0, true, true);
/* 730 */     int j = getSplitPoint(paramPixmap, i, 0, false, true);
/* 731 */     int k = getSplitPoint(paramPixmap, 0, 1, true, false);
/* 732 */     int m = getSplitPoint(paramPixmap, 0, k, false, false);
/*     */ 
/*     */     
/* 735 */     getSplitPoint(paramPixmap, j + 1, 0, true, true);
/* 736 */     getSplitPoint(paramPixmap, 0, m + 1, true, false);
/*     */ 
/*     */     
/* 739 */     if (i == 0 && j == 0 && k == 0 && m == 0) return null;
/*     */ 
/*     */     
/* 742 */     if (i != 0) {
/* 743 */       i--;
/* 744 */       j = paramPixmap.getWidth() - 2 - j - 1;
/*     */     } else {
/*     */       
/* 747 */       j = paramPixmap.getWidth() - 2;
/*     */     } 
/* 749 */     if (k != 0) {
/* 750 */       k--;
/* 751 */       m = paramPixmap.getHeight() - 2 - m - 1;
/*     */     } else {
/*     */       
/* 754 */       m = paramPixmap.getHeight() - 2;
/*     */     } 
/*     */     
/* 757 */     return new int[] { i, j, k, m };
/*     */   }
/*     */ 
/*     */   
/*     */   private int[] getPads(Pixmap paramPixmap, int[] paramArrayOfint) {
/* 762 */     int i = paramPixmap.getHeight() - 1;
/* 763 */     int j = paramPixmap.getWidth() - 1;
/*     */     
/* 765 */     int k = getSplitPoint(paramPixmap, 1, i, true, true);
/* 766 */     int m = getSplitPoint(paramPixmap, j, 1, true, false);
/*     */ 
/*     */     
/* 769 */     int n = 0;
/* 770 */     int i1 = 0;
/* 771 */     if (k != 0) n = getSplitPoint(paramPixmap, k + 1, i, false, true); 
/* 772 */     if (m != 0) i1 = getSplitPoint(paramPixmap, j, m + 1, false, false);
/*     */ 
/*     */     
/* 775 */     getSplitPoint(paramPixmap, n + 1, i, true, true);
/* 776 */     getSplitPoint(paramPixmap, j, i1 + 1, true, false);
/*     */ 
/*     */     
/* 779 */     if (k == 0 && n == 0 && m == 0 && i1 == 0) {
/* 780 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 784 */     if (k == 0 && n == 0) {
/* 785 */       k = -1;
/* 786 */       n = -1;
/*     */     }
/* 788 */     else if (k > 0) {
/* 789 */       k--;
/* 790 */       n = paramPixmap.getWidth() - 2 - n - 1;
/*     */     } else {
/*     */       
/* 793 */       n = paramPixmap.getWidth() - 2;
/*     */     } 
/*     */     
/* 796 */     if (m == 0 && i1 == 0) {
/* 797 */       m = -1;
/* 798 */       i1 = -1;
/*     */     }
/* 800 */     else if (m > 0) {
/* 801 */       m--;
/* 802 */       i1 = paramPixmap.getHeight() - 2 - i1 - 1;
/*     */     } else {
/*     */       
/* 805 */       i1 = paramPixmap.getHeight() - 2;
/*     */     } 
/*     */ 
/*     */     
/* 809 */     int[] arrayOfInt = { k, n, m, i1 };
/*     */     
/* 811 */     if (paramArrayOfint != null && Arrays.equals(arrayOfInt, paramArrayOfint)) {
/* 812 */       return null;
/*     */     }
/*     */     
/* 815 */     return arrayOfInt;
/*     */   }
/*     */   
/* 818 */   public PixmapPacker(int paramInt1, int paramInt2, Pixmap.Format paramFormat, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, PackStrategy paramPackStrategy) { this.c = new Color(); this.pageWidth = paramInt1; this.pageHeight = paramInt2; this.pageFormat = paramFormat; this.padding = paramInt3; this.duplicateBorder = paramBoolean1;
/*     */     this.stripWhitespaceX = paramBoolean2;
/*     */     this.stripWhitespaceY = paramBoolean3;
/* 821 */     this.packStrategy = paramPackStrategy; } private int getSplitPoint(Pixmap paramPixmap, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) { int[] arrayOfInt = new int[4];
/*     */     
/* 823 */     int i = paramBoolean2 ? paramInt1 : paramInt2;
/* 824 */     int j = paramBoolean2 ? paramPixmap.getWidth() : paramPixmap.getHeight();
/* 825 */     boolean bool = paramBoolean1 ? true : false;
/*     */     
/* 827 */     paramInt1 = paramInt1;
/* 828 */     paramInt2 = paramInt2;
/* 829 */     while (i != j) {
/* 830 */       if (paramBoolean2) {
/* 831 */         paramInt1 = i;
/*     */       } else {
/* 833 */         paramInt2 = i;
/*     */       } 
/* 835 */       int k = paramPixmap.getPixel(paramInt1, paramInt2);
/* 836 */       this.c.set(k);
/* 837 */       arrayOfInt[0] = (int)(this.c.r * 255.0F);
/* 838 */       arrayOfInt[1] = (int)(this.c.g * 255.0F);
/* 839 */       arrayOfInt[2] = (int)(this.c.b * 255.0F);
/* 840 */       arrayOfInt[3] = (int)(this.c.a * 255.0F);
/* 841 */       if (arrayOfInt[3] == bool) return i;
/*     */       
/* 843 */       if (!paramBoolean1 && (arrayOfInt[0] != 0 || arrayOfInt[1] != 0 || arrayOfInt[2] != 0 || arrayOfInt[3] != 255)) {
/* 844 */         System.out.println(paramInt1 + "  " + paramInt2 + " " + arrayOfInt + " ");
/*     */       }
/* 846 */       i++;
/*     */     } 
/*     */     
/* 849 */     return 0; }
/*     */   
/*     */   public static class PixmapPackerRectangle extends Rectangle { public PixmapPacker.Page page;
/*     */     public int[] splits;
/*     */     public int[] pads;
/*     */     public int offsetX;
/*     */     public int offsetY;
/*     */     public int originalWidth;
/*     */     public int originalHeight;
/*     */     
/*     */     PixmapPackerRectangle(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 860 */       super(param1Int1, param1Int2, param1Int3, param1Int4);
/* 861 */       this.offsetX = 0;
/* 862 */       this.offsetY = 0;
/* 863 */       this.originalWidth = param1Int3;
/* 864 */       this.originalHeight = param1Int4;
/*     */     }
/*     */     
/*     */     PixmapPackerRectangle(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, int param1Int7, int param1Int8) {
/* 868 */       super(param1Int1, param1Int2, param1Int3, param1Int4);
/* 869 */       this.offsetX = param1Int5;
/* 870 */       this.offsetY = param1Int6;
/* 871 */       this.originalWidth = param1Int7;
/* 872 */       this.originalHeight = param1Int8;
/*     */     } }
/*     */ 
/*     */   
/*     */   public static interface PackStrategy {
/*     */     void sort(Array<Pixmap> param1Array);
/*     */     
/*     */     PixmapPacker.Page pack(PixmapPacker param1PixmapPacker, String param1String, Rectangle param1Rectangle);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\PixmapPacker.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */