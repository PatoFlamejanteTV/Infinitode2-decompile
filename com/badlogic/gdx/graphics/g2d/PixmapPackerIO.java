/*     */ package com.badlogic.gdx.graphics.g2d;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.PixmapIO;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import java.io.Writer;
/*     */ import java.util.regex.Matcher;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PixmapPackerIO
/*     */ {
/*     */   public enum ImageFormat
/*     */   {
/*  21 */     CIM(".cim"),
/*     */     
/*  23 */     PNG(".png");
/*     */     
/*     */     private final String extension;
/*     */ 
/*     */     
/*     */     public final String getExtension() {
/*  29 */       return this.extension;
/*     */     }
/*     */     
/*     */     ImageFormat(String param1String1) {
/*  33 */       this.extension = param1String1;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class SaveParameters
/*     */   {
/*  39 */     public PixmapPackerIO.ImageFormat format = PixmapPackerIO.ImageFormat.PNG;
/*  40 */     public Texture.TextureFilter minFilter = Texture.TextureFilter.Nearest;
/*  41 */     public Texture.TextureFilter magFilter = Texture.TextureFilter.Nearest;
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean useIndexes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FileHandle paramFileHandle, PixmapPacker paramPixmapPacker) {
/*  52 */     save(paramFileHandle, paramPixmapPacker, new SaveParameters());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FileHandle paramFileHandle, PixmapPacker paramPixmapPacker, SaveParameters paramSaveParameters) {
/*  63 */     Writer writer = paramFileHandle.writer(false);
/*  64 */     byte b = 0;
/*  65 */     for (Array.ArrayIterator<PixmapPacker.Page> arrayIterator = paramPixmapPacker.pages.iterator(); arrayIterator.hasNext();) {
/*  66 */       if ((page = arrayIterator.next()).rects.size > 0) {
/*  67 */         FileHandle fileHandle = paramFileHandle.sibling(paramFileHandle.nameWithoutExtension() + "_" + ++b + paramSaveParameters.format.getExtension());
/*  68 */         switch (paramSaveParameters.format) {
/*     */           case CIM:
/*  70 */             PixmapIO.writeCIM(fileHandle, page.image);
/*     */             break;
/*     */           
/*     */           case PNG:
/*  74 */             PixmapIO.writePNG(fileHandle, page.image);
/*     */             break;
/*     */         } 
/*     */         
/*  78 */         writer.write("\n");
/*  79 */         writer.write(fileHandle.name() + "\n");
/*  80 */         writer.write("size: " + page.image.getWidth() + "," + page.image.getHeight() + "\n");
/*  81 */         writer.write("format: " + paramPixmapPacker.pageFormat.name() + "\n");
/*  82 */         writer.write("filter: " + paramSaveParameters.minFilter.name() + "," + paramSaveParameters.magFilter.name() + "\n");
/*  83 */         writer.write("repeat: none\n");
/*  84 */         for (ObjectMap.Keys<String> keys = page.rects.keys().iterator(); keys.hasNext(); ) { String str1 = keys.next();
/*  85 */           int i = -1;
/*  86 */           String str2 = str1; Matcher matcher;
/*  87 */           if (paramSaveParameters.useIndexes && (
/*     */             
/*  89 */             matcher = PixmapPacker.indexPattern.matcher(str2)).matches()) {
/*  90 */             str2 = matcher.group(1);
/*  91 */             i = Integer.parseInt(matcher.group(2));
/*     */           } 
/*     */           
/*  94 */           writer.write(str2 + "\n");
/*  95 */           PixmapPacker.PixmapPackerRectangle pixmapPackerRectangle = (PixmapPacker.PixmapPackerRectangle)page.rects.get(str1);
/*  96 */           writer.write("  rotate: false\n");
/*  97 */           writer.write("  xy: " + (int)pixmapPackerRectangle.x + "," + (int)pixmapPackerRectangle.y + "\n");
/*  98 */           writer.write("  size: " + (int)pixmapPackerRectangle.width + "," + (int)pixmapPackerRectangle.height + "\n");
/*  99 */           if (pixmapPackerRectangle.splits != null) {
/* 100 */             writer.write("  split: " + pixmapPackerRectangle.splits[0] + ", " + pixmapPackerRectangle.splits[1] + ", " + pixmapPackerRectangle.splits[2] + ", " + pixmapPackerRectangle.splits[3] + "\n");
/*     */             
/* 102 */             if (pixmapPackerRectangle.pads != null) {
/* 103 */               writer
/* 104 */                 .write("  pad: " + pixmapPackerRectangle.pads[0] + ", " + pixmapPackerRectangle.pads[1] + ", " + pixmapPackerRectangle.pads[2] + ", " + pixmapPackerRectangle.pads[3] + "\n");
/*     */             }
/*     */           } 
/* 107 */           writer.write("  orig: " + pixmapPackerRectangle.originalWidth + ", " + pixmapPackerRectangle.originalHeight + "\n");
/* 108 */           writer.write("  offset: " + pixmapPackerRectangle.offsetX + ", " + (int)(pixmapPackerRectangle.originalHeight - pixmapPackerRectangle.height - pixmapPackerRectangle.offsetY) + "\n");
/*     */           
/* 110 */           writer.write("  index: " + i + "\n"); }
/*     */       
/*     */       } 
/*     */     } 
/* 114 */     writer.close();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\PixmapPackerIO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */