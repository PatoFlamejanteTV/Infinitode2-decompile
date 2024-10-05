/*    */ package com.badlogic.gdx.graphics.glutils;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.GLTexture;
/*    */ import com.badlogic.gdx.graphics.Pixmap;
/*    */ import com.badlogic.gdx.graphics.TextureData;
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MipMapTextureData
/*    */   implements TextureData
/*    */ {
/*    */   TextureData[] mips;
/*    */   
/*    */   public MipMapTextureData(TextureData... paramVarArgs) {
/* 17 */     this.mips = new TextureData[paramVarArgs.length];
/* 18 */     System.arraycopy(paramVarArgs, 0, this.mips, 0, paramVarArgs.length);
/*    */   }
/*    */ 
/*    */   
/*    */   public TextureData.TextureDataType getType() {
/* 23 */     return TextureData.TextureDataType.Custom;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isPrepared() {
/* 28 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void prepare() {}
/*    */ 
/*    */   
/*    */   public Pixmap consumePixmap() {
/* 37 */     throw new GdxRuntimeException("It's compressed, use the compressed method");
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean disposePixmap() {
/* 42 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void consumeCustomData(int paramInt) {
/* 47 */     for (byte b = 0; b < this.mips.length; b++) {
/* 48 */       GLTexture.uploadImageData(paramInt, this.mips[b], b);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public int getWidth() {
/* 54 */     return this.mips[0].getWidth();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 59 */     return this.mips[0].getHeight();
/*    */   }
/*    */ 
/*    */   
/*    */   public Pixmap.Format getFormat() {
/* 64 */     return this.mips[0].getFormat();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean useMipMaps() {
/* 69 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isManaged() {
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\MipMapTextureData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */