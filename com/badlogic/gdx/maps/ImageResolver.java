/*    */ package com.badlogic.gdx.maps;
/*    */ 
/*    */ import com.badlogic.gdx.assets.AssetManager;
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureAtlas;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.badlogic.gdx.utils.ObjectMap;
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
/*    */ public interface ImageResolver
/*    */ {
/*    */   TextureRegion getImage(String paramString);
/*    */   
/*    */   public static class DirectImageResolver
/*    */     implements ImageResolver
/*    */   {
/*    */     private final ObjectMap<String, Texture> images;
/*    */     
/*    */     public DirectImageResolver(ObjectMap<String, Texture> param1ObjectMap) {
/* 36 */       this.images = param1ObjectMap;
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getImage(String param1String) {
/* 41 */       return new TextureRegion((Texture)this.images.get(param1String));
/*    */     }
/*    */   }
/*    */   
/*    */   public static class AssetManagerImageResolver implements ImageResolver {
/*    */     private final AssetManager assetManager;
/*    */     
/*    */     public AssetManagerImageResolver(AssetManager param1AssetManager) {
/* 49 */       this.assetManager = param1AssetManager;
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getImage(String param1String) {
/* 54 */       return new TextureRegion((Texture)this.assetManager.get(param1String, Texture.class));
/*    */     }
/*    */   }
/*    */   
/*    */   public static class TextureAtlasImageResolver implements ImageResolver {
/*    */     private final TextureAtlas atlas;
/*    */     
/*    */     public TextureAtlasImageResolver(TextureAtlas param1TextureAtlas) {
/* 62 */       this.atlas = param1TextureAtlas;
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getImage(String param1String) {
/* 67 */       return (TextureRegion)this.atlas.findRegion(param1String);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\ImageResolver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */