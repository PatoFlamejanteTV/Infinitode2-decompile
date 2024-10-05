/*     */ package com.badlogic.gdx.graphics.g2d;
/*     */ 
/*     */ import com.badlogic.gdx.assets.AssetDescriptor;
/*     */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.assets.loaders.FileHandleResolver;
/*     */ import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
/*     */ import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.math.EarClippingTriangulator;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.StreamUtils;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
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
/*     */ public class PolygonRegionLoader
/*     */   extends SynchronousAssetLoader<PolygonRegion, PolygonRegionLoader.PolygonRegionParameters>
/*     */ {
/*     */   public static class PolygonRegionParameters
/*     */     extends AssetLoaderParameters<PolygonRegion>
/*     */   {
/*  43 */     public String texturePrefix = "i ";
/*     */ 
/*     */ 
/*     */     
/*  47 */     public int readerBuffer = 1024;
/*     */ 
/*     */     
/*  50 */     public String[] textureExtensions = new String[] { "png", "PNG", "jpeg", "JPEG", "jpg", "JPG", "cim", "CIM", "etc1", "ETC1", "ktx", "KTX", "zktx", "ZKTX" };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  55 */   private PolygonRegionParameters defaultParameters = new PolygonRegionParameters();
/*     */   
/*  57 */   private EarClippingTriangulator triangulator = new EarClippingTriangulator();
/*     */   
/*     */   public PolygonRegionLoader() {
/*  60 */     this((FileHandleResolver)new InternalFileHandleResolver());
/*     */   }
/*     */   
/*     */   public PolygonRegionLoader(FileHandleResolver paramFileHandleResolver) {
/*  64 */     super(paramFileHandleResolver);
/*     */   }
/*     */ 
/*     */   
/*     */   public PolygonRegion load(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, PolygonRegionParameters paramPolygonRegionParameters) {
/*  69 */     Texture texture = (Texture)paramAssetManager.get((String)paramAssetManager.getDependencies(paramString).first());
/*  70 */     return load(new TextureRegion(texture), paramFileHandle);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, PolygonRegionParameters paramPolygonRegionParameters) {
/*  79 */     if (paramPolygonRegionParameters == null) paramPolygonRegionParameters = this.defaultParameters; 
/*  80 */     String str = null;
/*     */     try {
/*     */       BufferedReader bufferedReader;
/*  83 */       for (String str1 = (bufferedReader = paramFileHandle.reader(paramPolygonRegionParameters.readerBuffer)).readLine(); str1 != null; str1 = bufferedReader.readLine()) {
/*  84 */         if (str1.startsWith(paramPolygonRegionParameters.texturePrefix)) {
/*  85 */           str = str1.substring(paramPolygonRegionParameters.texturePrefix.length()); break;
/*     */         } 
/*     */       } 
/*  88 */       bufferedReader.close();
/*  89 */     } catch (IOException iOException) {
/*  90 */       throw new GdxRuntimeException("Error reading " + paramString, iOException);
/*     */     } 
/*     */     
/*  93 */     if (str == null && paramPolygonRegionParameters.textureExtensions != null) { byte b; String[] arrayOfString; int i; for (i = (arrayOfString = paramPolygonRegionParameters.textureExtensions).length, b = 0; b < i; ) { String str1 = arrayOfString[b];
/*     */         FileHandle fileHandle;
/*  95 */         if ((fileHandle = paramFileHandle.sibling(paramFileHandle.nameWithoutExtension().concat("." + str1))).exists()) str = fileHandle.name();  b++; }
/*     */        }
/*     */     
/*  98 */     if (str != null) {
/*     */       Array<AssetDescriptor> array;
/* 100 */       (array = new Array(1)).add(new AssetDescriptor(paramFileHandle.sibling(str), Texture.class));
/* 101 */       return array;
/*     */     } 
/*     */     
/* 104 */     return null;
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
/*     */   public PolygonRegion load(TextureRegion paramTextureRegion, FileHandle paramFileHandle) {
/* 117 */     BufferedReader bufferedReader = paramFileHandle.reader(256);
/*     */     
/*     */     try {
/*     */       String str;
/* 121 */       while ((str = bufferedReader.readLine()) != null) {
/* 122 */         if (str.startsWith("s")) {
/*     */           String[] arrayOfString;
/*     */           
/* 125 */           float[] arrayOfFloat = new float[(arrayOfString = str.substring(1).trim().split(",")).length]; byte b; int i;
/* 126 */           for (b = 0, i = arrayOfFloat.length; b < i; b++) {
/* 127 */             arrayOfFloat[b] = Float.parseFloat(arrayOfString[b]);
/*     */           }
/* 129 */           return new PolygonRegion(paramTextureRegion, arrayOfFloat, this.triangulator.computeTriangles(arrayOfFloat).toArray());
/*     */         } 
/*     */       } 
/* 132 */     } catch (IOException iOException) {
/* 133 */       throw new GdxRuntimeException("Error reading polygon shape file: " + paramFileHandle, iOException);
/*     */     } finally {
/* 135 */       StreamUtils.closeQuietly(bufferedReader);
/*     */     } 
/* 137 */     throw new GdxRuntimeException("Polygon shape not found: " + paramFileHandle);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\PolygonRegionLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */