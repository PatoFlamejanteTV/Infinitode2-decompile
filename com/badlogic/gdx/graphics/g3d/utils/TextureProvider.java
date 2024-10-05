/*    */ package com.badlogic.gdx.graphics.g3d.utils;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.assets.AssetManager;
/*    */ import com.badlogic.gdx.graphics.Texture;
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
/*    */ public interface TextureProvider
/*    */ {
/*    */   Texture load(String paramString);
/*    */   
/*    */   public static class FileTextureProvider
/*    */     implements TextureProvider
/*    */   {
/*    */     private Texture.TextureFilter minFilter;
/*    */     private Texture.TextureFilter magFilter;
/*    */     private Texture.TextureWrap uWrap;
/*    */     private Texture.TextureWrap vWrap;
/*    */     private boolean useMipMaps;
/*    */     
/*    */     public FileTextureProvider() {
/* 36 */       this.minFilter = this.magFilter = Texture.TextureFilter.Linear;
/* 37 */       this.uWrap = this.vWrap = Texture.TextureWrap.Repeat;
/* 38 */       this.useMipMaps = false;
/*    */     }
/*    */ 
/*    */     
/*    */     public FileTextureProvider(Texture.TextureFilter param1TextureFilter1, Texture.TextureFilter param1TextureFilter2, Texture.TextureWrap param1TextureWrap1, Texture.TextureWrap param1TextureWrap2, boolean param1Boolean) {
/* 43 */       this.minFilter = param1TextureFilter1;
/* 44 */       this.magFilter = param1TextureFilter2;
/* 45 */       this.uWrap = param1TextureWrap1;
/* 46 */       this.vWrap = param1TextureWrap2;
/* 47 */       this.useMipMaps = param1Boolean;
/*    */     }
/*    */ 
/*    */     
/*    */     public Texture load(String param1String) {
/*    */       Texture texture;
/* 53 */       (texture = new Texture(Gdx.files.internal(param1String), this.useMipMaps)).setFilter(this.minFilter, this.magFilter);
/* 54 */       texture.setWrap(this.uWrap, this.vWrap);
/* 55 */       return texture;
/*    */     }
/*    */   }
/*    */   
/*    */   public static class AssetTextureProvider implements TextureProvider {
/*    */     public final AssetManager assetManager;
/*    */     
/*    */     public AssetTextureProvider(AssetManager param1AssetManager) {
/* 63 */       this.assetManager = param1AssetManager;
/*    */     }
/*    */ 
/*    */     
/*    */     public Texture load(String param1String) {
/* 68 */       return (Texture)this.assetManager.get(param1String, Texture.class);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\TextureProvider.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */