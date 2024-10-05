/*    */ package com.badlogic.gdx.graphics.glutils;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Pixmap;
/*    */ import com.badlogic.gdx.graphics.TextureData;
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*    */ public class PixmapTextureData
/*    */   implements TextureData
/*    */ {
/*    */   final Pixmap pixmap;
/*    */   final Pixmap.Format format;
/*    */   final boolean useMipMaps;
/*    */   final boolean disposePixmap;
/*    */   final boolean managed;
/*    */   
/*    */   public PixmapTextureData(Pixmap paramPixmap, Pixmap.Format paramFormat, boolean paramBoolean1, boolean paramBoolean2) {
/* 32 */     this(paramPixmap, paramFormat, paramBoolean1, paramBoolean2, false);
/*    */   }
/*    */   
/*    */   public PixmapTextureData(Pixmap paramPixmap, Pixmap.Format paramFormat, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 36 */     this.pixmap = paramPixmap;
/* 37 */     this.format = (paramFormat == null) ? paramPixmap.getFormat() : paramFormat;
/* 38 */     this.useMipMaps = paramBoolean1;
/* 39 */     this.disposePixmap = paramBoolean2;
/* 40 */     this.managed = paramBoolean3;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean disposePixmap() {
/* 45 */     return this.disposePixmap;
/*    */   }
/*    */ 
/*    */   
/*    */   public Pixmap consumePixmap() {
/* 50 */     return this.pixmap;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getWidth() {
/* 55 */     return this.pixmap.getWidth();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 60 */     return this.pixmap.getHeight();
/*    */   }
/*    */ 
/*    */   
/*    */   public Pixmap.Format getFormat() {
/* 65 */     return this.format;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean useMipMaps() {
/* 70 */     return this.useMipMaps;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isManaged() {
/* 75 */     return this.managed;
/*    */   }
/*    */ 
/*    */   
/*    */   public TextureData.TextureDataType getType() {
/* 80 */     return TextureData.TextureDataType.Pixmap;
/*    */   }
/*    */ 
/*    */   
/*    */   public void consumeCustomData(int paramInt) {
/* 85 */     throw new GdxRuntimeException("This TextureData implementation does not upload data itself");
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isPrepared() {
/* 90 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void prepare() {
/* 95 */     throw new GdxRuntimeException("prepare() must not be called on a PixmapTextureData instance as it is already prepared.");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\PixmapTextureData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */