/*    */ package com.badlogic.gdx.assets.loaders;
/*    */ 
/*    */ import com.badlogic.gdx.assets.AssetDescriptor;
/*    */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ import com.badlogic.gdx.utils.Array;
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
/*    */ public abstract class AssetLoader<T, P extends AssetLoaderParameters<T>>
/*    */ {
/*    */   private FileHandleResolver resolver;
/*    */   
/*    */   public AssetLoader(FileHandleResolver paramFileHandleResolver) {
/* 36 */     this.resolver = paramFileHandleResolver;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public FileHandle resolve(String paramString) {
/* 42 */     return this.resolver.resolve(paramString);
/*    */   }
/*    */   
/*    */   public abstract Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, P paramP);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\loaders\AssetLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */