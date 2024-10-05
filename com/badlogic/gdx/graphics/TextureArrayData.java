/*    */ package com.badlogic.gdx.graphics;
/*    */ 
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ import com.badlogic.gdx.graphics.glutils.FileTextureArrayData;
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
/*    */ public interface TextureArrayData
/*    */ {
/*    */   boolean isPrepared();
/*    */   
/*    */   void prepare();
/*    */   
/*    */   void consumeTextureArrayData();
/*    */   
/*    */   int getWidth();
/*    */   
/*    */   int getHeight();
/*    */   
/*    */   int getDepth();
/*    */   
/*    */   boolean isManaged();
/*    */   
/*    */   int getInternalFormat();
/*    */   
/*    */   int getGLType();
/*    */   
/*    */   public static class Factory
/*    */   {
/*    */     public static TextureArrayData loadFromFiles(Pixmap.Format param1Format, boolean param1Boolean, FileHandle... param1VarArgs) {
/* 70 */       return (TextureArrayData)new FileTextureArrayData(param1Format, param1Boolean, param1VarArgs);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\TextureArrayData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */