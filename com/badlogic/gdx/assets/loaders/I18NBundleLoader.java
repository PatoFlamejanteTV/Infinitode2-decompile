/*    */ package com.badlogic.gdx.assets.loaders;
/*    */ 
/*    */ import com.badlogic.gdx.assets.AssetDescriptor;
/*    */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*    */ import com.badlogic.gdx.assets.AssetManager;
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.I18NBundle;
/*    */ import java.util.Locale;
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
/*    */ public class I18NBundleLoader
/*    */   extends AsynchronousAssetLoader<I18NBundle, I18NBundleLoader.I18NBundleParameter>
/*    */ {
/*    */   I18NBundle bundle;
/*    */   
/*    */   public I18NBundleLoader(FileHandleResolver paramFileHandleResolver) {
/* 48 */     super(paramFileHandleResolver);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, I18NBundleParameter paramI18NBundleParameter) {
/*    */     Locale locale;
/* 55 */     this.bundle = null;
/*    */ 
/*    */     
/* 58 */     if (paramI18NBundleParameter == null) {
/* 59 */       locale = Locale.getDefault();
/* 60 */       paramString = null;
/*    */     } else {
/* 62 */       locale = (paramI18NBundleParameter.locale == null) ? Locale.getDefault() : paramI18NBundleParameter.locale;
/* 63 */       paramString = paramI18NBundleParameter.encoding;
/*    */     } 
/* 65 */     if (paramString == null) {
/* 66 */       this.bundle = I18NBundle.createBundle(paramFileHandle, locale); return;
/*    */     } 
/* 68 */     this.bundle = I18NBundle.createBundle(paramFileHandle, locale, paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public I18NBundle loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, I18NBundleParameter paramI18NBundleParameter) {
/* 74 */     I18NBundle i18NBundle = this.bundle;
/* 75 */     this.bundle = null;
/* 76 */     return i18NBundle;
/*    */   }
/*    */ 
/*    */   
/*    */   public Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, I18NBundleParameter paramI18NBundleParameter) {
/* 81 */     return null;
/*    */   }
/*    */   
/*    */   public static class I18NBundleParameter extends AssetLoaderParameters<I18NBundle> {
/*    */     public final Locale locale;
/*    */     public final String encoding;
/*    */     
/*    */     public I18NBundleParameter() {
/* 89 */       this(null, null);
/*    */     }
/*    */     
/*    */     public I18NBundleParameter(Locale param1Locale) {
/* 93 */       this(param1Locale, null);
/*    */     }
/*    */     
/*    */     public I18NBundleParameter(Locale param1Locale, String param1String) {
/* 97 */       this.locale = param1Locale;
/* 98 */       this.encoding = param1String;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\loaders\I18NBundleLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */