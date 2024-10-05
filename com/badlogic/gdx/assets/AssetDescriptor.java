/*    */ package com.badlogic.gdx.assets;
/*    */ 
/*    */ import com.badlogic.gdx.files.FileHandle;
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
/*    */ public class AssetDescriptor<T>
/*    */ {
/*    */   public final String fileName;
/*    */   public final Class<T> type;
/*    */   public final AssetLoaderParameters params;
/*    */   public FileHandle file;
/*    */   
/*    */   public AssetDescriptor(String paramString, Class<T> paramClass) {
/* 32 */     this(paramString, paramClass, (AssetLoaderParameters<T>)null);
/*    */   }
/*    */ 
/*    */   
/*    */   public AssetDescriptor(FileHandle paramFileHandle, Class<T> paramClass) {
/* 37 */     this(paramFileHandle, paramClass, (AssetLoaderParameters<T>)null);
/*    */   }
/*    */   
/*    */   public AssetDescriptor(String paramString, Class<T> paramClass, AssetLoaderParameters<T> paramAssetLoaderParameters) {
/* 41 */     this.fileName = paramString;
/* 42 */     this.type = paramClass;
/* 43 */     this.params = paramAssetLoaderParameters;
/*    */   }
/*    */ 
/*    */   
/*    */   public AssetDescriptor(FileHandle paramFileHandle, Class<T> paramClass, AssetLoaderParameters<T> paramAssetLoaderParameters) {
/* 48 */     this.fileName = paramFileHandle.path();
/* 49 */     this.file = paramFileHandle;
/* 50 */     this.type = paramClass;
/* 51 */     this.params = paramAssetLoaderParameters;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/*    */     StringBuilder stringBuilder;
/* 57 */     (stringBuilder = new StringBuilder()).append(this.fileName);
/* 58 */     stringBuilder.append(", ");
/* 59 */     stringBuilder.append(this.type.getName());
/* 60 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\AssetDescriptor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */