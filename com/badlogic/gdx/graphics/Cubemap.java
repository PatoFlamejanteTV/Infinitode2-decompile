/*     */ package com.badlogic.gdx.graphics;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.assets.loaders.CubemapLoader;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.glutils.FacedCubemapData;
/*     */ import com.badlogic.gdx.graphics.glutils.PixmapTextureData;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public class Cubemap
/*     */   extends GLTexture
/*     */ {
/*     */   private static AssetManager assetManager;
/*  40 */   static final Map<Application, Array<Cubemap>> managedCubemaps = new HashMap<>();
/*     */   protected CubemapData data;
/*     */   
/*     */   public enum CubemapSide
/*     */   {
/*  45 */     PositiveX(0, 34069, 0.0F, -1.0F, 0.0F, 1.0F, 0.0F, 0.0F),
/*     */     
/*  47 */     NegativeX(1, 34070, 0.0F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F),
/*     */     
/*  49 */     PositiveY(2, 34071, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F),
/*     */     
/*  51 */     NegativeY(3, 34072, 0.0F, 0.0F, -1.0F, 0.0F, -1.0F, 0.0F),
/*     */     
/*  53 */     PositiveZ(4, 34073, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F),
/*     */     
/*  55 */     NegativeZ(5, 34074, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, -1.0F);
/*     */     
/*     */     public final int index;
/*     */     
/*     */     public final int glEnum;
/*     */     
/*     */     public final Vector3 up;
/*     */     
/*     */     public final Vector3 direction;
/*     */ 
/*     */     
/*     */     CubemapSide(int param1Int1, int param1Int2, float param1Float1, float param1Float2, float param1Float3, float param1Float4, float param1Float5, float param1Float6) {
/*  67 */       this.index = param1Int1;
/*  68 */       this.glEnum = param1Int2;
/*  69 */       this.up = new Vector3(param1Float1, param1Float2, param1Float3);
/*  70 */       this.direction = new Vector3(param1Float4, param1Float5, param1Float6);
/*     */     }
/*     */ 
/*     */     
/*     */     public final int getGLEnum() {
/*  75 */       return this.glEnum;
/*     */     }
/*     */ 
/*     */     
/*     */     public final Vector3 getUp(Vector3 param1Vector3) {
/*  80 */       return param1Vector3.set(this.up);
/*     */     }
/*     */ 
/*     */     
/*     */     public final Vector3 getDirection(Vector3 param1Vector3) {
/*  85 */       return param1Vector3.set(this.direction);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Cubemap(CubemapData paramCubemapData) {
/*  93 */     super(34067);
/*  94 */     this.data = paramCubemapData;
/*  95 */     load(paramCubemapData);
/*  96 */     if (paramCubemapData.isManaged()) addManagedCubemap(Gdx.app, this);
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public Cubemap(FileHandle paramFileHandle1, FileHandle paramFileHandle2, FileHandle paramFileHandle3, FileHandle paramFileHandle4, FileHandle paramFileHandle5, FileHandle paramFileHandle6) {
/* 102 */     this(paramFileHandle1, paramFileHandle2, paramFileHandle3, paramFileHandle4, paramFileHandle5, paramFileHandle6, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Cubemap(FileHandle paramFileHandle1, FileHandle paramFileHandle2, FileHandle paramFileHandle3, FileHandle paramFileHandle4, FileHandle paramFileHandle5, FileHandle paramFileHandle6, boolean paramBoolean) {
/* 108 */     this(TextureData.Factory.loadFromFile(paramFileHandle1, paramBoolean), TextureData.Factory.loadFromFile(paramFileHandle2, paramBoolean), 
/* 109 */         TextureData.Factory.loadFromFile(paramFileHandle3, paramBoolean), TextureData.Factory.loadFromFile(paramFileHandle4, paramBoolean), 
/* 110 */         TextureData.Factory.loadFromFile(paramFileHandle5, paramBoolean), TextureData.Factory.loadFromFile(paramFileHandle6, paramBoolean));
/*     */   }
/*     */ 
/*     */   
/*     */   public Cubemap(Pixmap paramPixmap1, Pixmap paramPixmap2, Pixmap paramPixmap3, Pixmap paramPixmap4, Pixmap paramPixmap5, Pixmap paramPixmap6) {
/* 115 */     this(paramPixmap1, paramPixmap2, paramPixmap3, paramPixmap4, paramPixmap5, paramPixmap6, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Cubemap(Pixmap paramPixmap1, Pixmap paramPixmap2, Pixmap paramPixmap3, Pixmap paramPixmap4, Pixmap paramPixmap5, Pixmap paramPixmap6, boolean paramBoolean) {
/* 121 */     this((paramPixmap1 == null) ? null : (TextureData)new PixmapTextureData(paramPixmap1, null, paramBoolean, false), 
/* 122 */         (paramPixmap2 == null) ? null : (TextureData)new PixmapTextureData(paramPixmap2, null, paramBoolean, false), 
/* 123 */         (paramPixmap3 == null) ? null : (TextureData)new PixmapTextureData(paramPixmap3, null, paramBoolean, false), 
/* 124 */         (paramPixmap4 == null) ? null : (TextureData)new PixmapTextureData(paramPixmap4, null, paramBoolean, false), 
/* 125 */         (paramPixmap5 == null) ? null : (TextureData)new PixmapTextureData(paramPixmap5, null, paramBoolean, false), 
/* 126 */         (paramPixmap6 == null) ? null : (TextureData)new PixmapTextureData(paramPixmap6, null, paramBoolean, false));
/*     */   }
/*     */ 
/*     */   
/*     */   public Cubemap(int paramInt1, int paramInt2, int paramInt3, Pixmap.Format paramFormat) {
/* 131 */     this((TextureData)new PixmapTextureData(new Pixmap(paramInt3, paramInt2, paramFormat), null, false, true), (TextureData)new PixmapTextureData(new Pixmap(paramInt3, paramInt2, paramFormat), null, false, true), (TextureData)new PixmapTextureData(new Pixmap(paramInt1, paramInt3, paramFormat), null, false, true), (TextureData)new PixmapTextureData(new Pixmap(paramInt1, paramInt3, paramFormat), null, false, true), (TextureData)new PixmapTextureData(new Pixmap(paramInt1, paramInt2, paramFormat), null, false, true), (TextureData)new PixmapTextureData(new Pixmap(paramInt1, paramInt2, paramFormat), null, false, true));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Cubemap(TextureData paramTextureData1, TextureData paramTextureData2, TextureData paramTextureData3, TextureData paramTextureData4, TextureData paramTextureData5, TextureData paramTextureData6) {
/* 142 */     this((CubemapData)new FacedCubemapData(paramTextureData1, paramTextureData2, paramTextureData3, paramTextureData4, paramTextureData5, paramTextureData6));
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(CubemapData paramCubemapData) {
/* 147 */     if (!paramCubemapData.isPrepared()) paramCubemapData.prepare(); 
/* 148 */     bind();
/* 149 */     unsafeSetFilter(this.minFilter, this.magFilter, true);
/* 150 */     unsafeSetWrap(this.uWrap, this.vWrap, true);
/* 151 */     unsafeSetAnisotropicFilter(this.anisotropicFilterLevel, true);
/* 152 */     paramCubemapData.consumeCubemapData();
/* 153 */     Gdx.gl.glBindTexture(this.glTarget, 0);
/*     */   }
/*     */   
/*     */   public CubemapData getCubemapData() {
/* 157 */     return this.data;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isManaged() {
/* 162 */     return this.data.isManaged();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void reload() {
/* 167 */     if (!isManaged()) throw new GdxRuntimeException("Tried to reload an unmanaged Cubemap"); 
/* 168 */     this.glHandle = Gdx.gl.glGenTexture();
/* 169 */     load(this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 174 */     return this.data.getWidth();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 179 */     return this.data.getHeight();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDepth() {
/* 184 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 194 */     if (this.glHandle == 0)
/* 195 */       return;  delete();
/* 196 */     if (this.data.isManaged() && managedCubemaps.get(Gdx.app) != null) ((Array)managedCubemaps.get(Gdx.app)).removeValue(this, true); 
/*     */   }
/*     */   
/*     */   private static void addManagedCubemap(Application paramApplication, Cubemap paramCubemap) {
/*     */     Array<Cubemap> array;
/* 201 */     if ((array = managedCubemaps.get(paramApplication)) == null) array = new Array(); 
/* 202 */     array.add(paramCubemap);
/* 203 */     managedCubemaps.put(paramApplication, array);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void clearAllCubemaps(Application paramApplication) {
/* 208 */     managedCubemaps.remove(paramApplication);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void invalidateAllCubemaps(Application paramApplication) {
/*     */     Array array1;
/* 214 */     if ((array1 = managedCubemaps.get(paramApplication)) == null)
/*     */       return; 
/* 216 */     if (assetManager == null) {
/* 217 */       for (byte b = 0; b < array1.size; b++) {
/*     */         Cubemap cubemap;
/* 219 */         (cubemap = (Cubemap)array1.get(b)).reload();
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 225 */     assetManager.finishLoading();
/*     */ 
/*     */     
/*     */     Array array2;
/*     */     
/* 230 */     for (Array.ArrayIterator<Cubemap> arrayIterator = (array2 = new Array(array1)).iterator(); arrayIterator.hasNext(); ) { Cubemap cubemap = arrayIterator.next();
/*     */       String str;
/* 232 */       if ((str = assetManager.getAssetFileName(cubemap)) == null) {
/* 233 */         cubemap.reload();
/*     */ 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 239 */       final int refCount = assetManager.getReferenceCount(str);
/* 240 */       assetManager.setReferenceCount(str, 0);
/* 241 */       cubemap.glHandle = 0;
/*     */ 
/*     */       
/*     */       CubemapLoader.CubemapParameter cubemapParameter;
/*     */       
/* 246 */       (cubemapParameter = new CubemapLoader.CubemapParameter()).cubemapData = cubemap.getCubemapData();
/* 247 */       cubemapParameter.minFilter = cubemap.getMinFilter();
/* 248 */       cubemapParameter.magFilter = cubemap.getMagFilter();
/* 249 */       cubemapParameter.wrapU = cubemap.getUWrap();
/* 250 */       cubemapParameter.wrapV = cubemap.getVWrap();
/* 251 */       cubemapParameter.cubemap = cubemap;
/* 252 */       cubemapParameter.loadedCallback = new AssetLoaderParameters.LoadedCallback()
/*     */         {
/*     */           public void finishedLoading(AssetManager param1AssetManager, String param1String, Class param1Class) {
/* 255 */             param1AssetManager.setReferenceCount(param1String, refCount);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 260 */       assetManager.unload(str);
/* 261 */       cubemap.glHandle = Gdx.gl.glGenTexture();
/* 262 */       assetManager.load(str, Cubemap.class, (AssetLoaderParameters)cubemapParameter); }
/*     */ 
/*     */     
/* 265 */     array1.clear();
/* 266 */     array1.addAll(array2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setAssetManager(AssetManager paramAssetManager) {
/* 275 */     assetManager = paramAssetManager;
/*     */   }
/*     */   
/*     */   public static String getManagedStatus() {
/*     */     StringBuilder stringBuilder;
/* 280 */     (stringBuilder = new StringBuilder()).append("Managed cubemap/app: { ");
/* 281 */     for (Application application : managedCubemaps.keySet()) {
/* 282 */       stringBuilder.append(((Array)managedCubemaps.get(application)).size);
/* 283 */       stringBuilder.append(" ");
/*     */     } 
/* 285 */     stringBuilder.append("}");
/* 286 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getNumManagedCubemaps() {
/* 291 */     return ((Array)managedCubemaps.get(Gdx.app)).size;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\Cubemap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */