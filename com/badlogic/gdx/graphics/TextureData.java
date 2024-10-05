/*     */ package com.badlogic.gdx.graphics;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.glutils.ETC1TextureData;
/*     */ import com.badlogic.gdx.graphics.glutils.FileTextureData;
/*     */ import com.badlogic.gdx.graphics.glutils.KTXTextureData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface TextureData
/*     */ {
/*     */   TextureDataType getType();
/*     */   
/*     */   boolean isPrepared();
/*     */   
/*     */   void prepare();
/*     */   
/*     */   Pixmap consumePixmap();
/*     */   
/*     */   boolean disposePixmap();
/*     */   
/*     */   void consumeCustomData(int paramInt);
/*     */   
/*     */   int getWidth();
/*     */   
/*     */   int getHeight();
/*     */   
/*     */   Pixmap.Format getFormat();
/*     */   
/*     */   boolean useMipMaps();
/*     */   
/*     */   boolean isManaged();
/*     */   
/*     */   public enum TextureDataType
/*     */   {
/*  46 */     Pixmap, Custom;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */   {
/*     */     public static TextureData loadFromFile(FileHandle param1FileHandle, boolean param1Boolean) {
/*  93 */       return loadFromFile(param1FileHandle, null, param1Boolean);
/*     */     }
/*     */     
/*     */     public static TextureData loadFromFile(FileHandle param1FileHandle, Pixmap.Format param1Format, boolean param1Boolean) {
/*  97 */       if (param1FileHandle == null) return null; 
/*  98 */       if (param1FileHandle.name().endsWith(".cim")) return (TextureData)new FileTextureData(param1FileHandle, PixmapIO.readCIM(param1FileHandle), param1Format, param1Boolean); 
/*  99 */       if (param1FileHandle.name().endsWith(".etc1")) return (TextureData)new ETC1TextureData(param1FileHandle, param1Boolean); 
/* 100 */       if (param1FileHandle.name().endsWith(".ktx") || param1FileHandle.name().endsWith(".zktx")) return (TextureData)new KTXTextureData(param1FileHandle, param1Boolean); 
/* 101 */       return (TextureData)new FileTextureData(param1FileHandle, new Pixmap(param1FileHandle), param1Format, param1Boolean);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\TextureData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */