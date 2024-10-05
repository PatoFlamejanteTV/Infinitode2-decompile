/*     */ package com.badlogic.gdx.assets.loaders;
/*     */ 
/*     */ import com.badlogic.gdx.assets.AssetDescriptor;
/*     */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureAtlas;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Skin;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
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
/*     */ public class SkinLoader
/*     */   extends AsynchronousAssetLoader<Skin, SkinLoader.SkinParameter>
/*     */ {
/*     */   public SkinLoader(FileHandleResolver paramFileHandleResolver) {
/*  40 */     super(paramFileHandleResolver);
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, SkinParameter paramSkinParameter) {
/*  45 */     Array<AssetDescriptor> array = new Array();
/*  46 */     if (paramSkinParameter == null || paramSkinParameter.textureAtlasPath == null)
/*  47 */     { array.add(new AssetDescriptor(paramFileHandle.pathWithoutExtension() + ".atlas", TextureAtlas.class)); }
/*  48 */     else if (paramSkinParameter.textureAtlasPath != null) { array.add(new AssetDescriptor(paramSkinParameter.textureAtlasPath, TextureAtlas.class)); }
/*  49 */      return array;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, SkinParameter paramSkinParameter) {}
/*     */ 
/*     */   
/*     */   public Skin loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, SkinParameter paramSkinParameter) {
/*  58 */     paramString = paramFileHandle.pathWithoutExtension() + ".atlas";
/*  59 */     ObjectMap<String, Object> objectMap = null;
/*  60 */     if (paramSkinParameter != null) {
/*  61 */       if (paramSkinParameter.textureAtlasPath != null) {
/*  62 */         paramString = paramSkinParameter.textureAtlasPath;
/*     */       }
/*  64 */       if (paramSkinParameter.resources != null) {
/*  65 */         objectMap = paramSkinParameter.resources;
/*     */       }
/*     */     } 
/*  68 */     TextureAtlas textureAtlas = (TextureAtlas)paramAssetManager.get(paramString, TextureAtlas.class);
/*  69 */     Skin skin = newSkin(textureAtlas);
/*  70 */     if (objectMap != null) {
/*  71 */       for (ObjectMap.Entries<ObjectMap.Entry> entries = objectMap.entries().iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/*  72 */         skin.add((String)entry.key, entry.value); }
/*     */     
/*     */     }
/*  75 */     skin.load(paramFileHandle);
/*  76 */     return skin;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Skin newSkin(TextureAtlas paramTextureAtlas) {
/*  83 */     return new Skin(paramTextureAtlas);
/*     */   }
/*     */   
/*     */   public static class SkinParameter extends AssetLoaderParameters<Skin> {
/*     */     public final String textureAtlasPath;
/*     */     public final ObjectMap<String, Object> resources;
/*     */     
/*     */     public SkinParameter() {
/*  91 */       this(null, null);
/*     */     }
/*     */     
/*     */     public SkinParameter(ObjectMap<String, Object> param1ObjectMap) {
/*  95 */       this(null, param1ObjectMap);
/*     */     }
/*     */     
/*     */     public SkinParameter(String param1String) {
/*  99 */       this(param1String, null);
/*     */     }
/*     */     
/*     */     public SkinParameter(String param1String, ObjectMap<String, Object> param1ObjectMap) {
/* 103 */       this.textureAtlasPath = param1String;
/* 104 */       this.resources = param1ObjectMap;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\loaders\SkinLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */