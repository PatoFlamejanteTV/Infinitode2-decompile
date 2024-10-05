/*     */ package com.badlogic.gdx.graphics;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.assets.loaders.TextureLoader;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.glutils.PixmapTextureData;
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
/*     */ public class Texture
/*     */   extends GLTexture
/*     */ {
/*     */   private static AssetManager assetManager;
/*  50 */   static final Map<Application, Array<Texture>> managedTextures = new HashMap<>();
/*     */   TextureData data;
/*     */   
/*     */   public enum TextureFilter {
/*  54 */     Nearest(9728),
/*     */ 
/*     */     
/*  57 */     Linear(9729),
/*     */ 
/*     */     
/*  60 */     MipMap(9987),
/*     */ 
/*     */ 
/*     */     
/*  64 */     MipMapNearestNearest(9984),
/*     */ 
/*     */ 
/*     */     
/*  68 */     MipMapLinearNearest(9985),
/*     */ 
/*     */ 
/*     */     
/*  72 */     MipMapNearestLinear(9986),
/*     */ 
/*     */ 
/*     */     
/*  76 */     MipMapLinearLinear(9987);
/*     */     
/*     */     final int glEnum;
/*     */     
/*     */     TextureFilter(int param1Int1) {
/*  81 */       this.glEnum = param1Int1;
/*     */     }
/*     */     
/*     */     public final boolean isMipMap() {
/*  85 */       return (this.glEnum != 9728 && this.glEnum != 9729);
/*     */     }
/*     */     
/*     */     public final int getGLEnum() {
/*  89 */       return this.glEnum;
/*     */     }
/*     */   }
/*     */   
/*     */   public enum TextureWrap {
/*  94 */     MirroredRepeat(33648), ClampToEdge(33071), Repeat(10497);
/*     */     
/*     */     final int glEnum;
/*     */     
/*     */     TextureWrap(int param1Int1) {
/*  99 */       this.glEnum = param1Int1;
/*     */     }
/*     */     
/*     */     public final int getGLEnum() {
/* 103 */       return this.glEnum;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Texture() {
/* 110 */     super(0, 0);
/*     */   }
/*     */   
/*     */   public Texture(String paramString) {
/* 114 */     this(Gdx.files.internal(paramString));
/*     */   }
/*     */   
/*     */   public Texture(FileHandle paramFileHandle) {
/* 118 */     this(paramFileHandle, (Pixmap.Format)null, false);
/*     */   }
/*     */   
/*     */   public Texture(FileHandle paramFileHandle, boolean paramBoolean) {
/* 122 */     this(paramFileHandle, (Pixmap.Format)null, paramBoolean);
/*     */   }
/*     */   
/*     */   public Texture(FileHandle paramFileHandle, Pixmap.Format paramFormat, boolean paramBoolean) {
/* 126 */     this(TextureData.Factory.loadFromFile(paramFileHandle, paramFormat, paramBoolean));
/*     */   }
/*     */   
/*     */   public Texture(Pixmap paramPixmap) {
/* 130 */     this((TextureData)new PixmapTextureData(paramPixmap, null, false, false));
/*     */   }
/*     */   
/*     */   public Texture(Pixmap paramPixmap, boolean paramBoolean) {
/* 134 */     this((TextureData)new PixmapTextureData(paramPixmap, null, paramBoolean, false));
/*     */   }
/*     */   
/*     */   public Texture(Pixmap paramPixmap, Pixmap.Format paramFormat, boolean paramBoolean) {
/* 138 */     this((TextureData)new PixmapTextureData(paramPixmap, paramFormat, paramBoolean, false));
/*     */   }
/*     */   
/*     */   public Texture(int paramInt1, int paramInt2, Pixmap.Format paramFormat) {
/* 142 */     this((TextureData)new PixmapTextureData(new Pixmap(paramInt1, paramInt2, paramFormat), null, false, true));
/*     */   }
/*     */   
/*     */   public Texture(TextureData paramTextureData) {
/* 146 */     this(3553, Gdx.gl.glGenTexture(), paramTextureData);
/*     */   }
/*     */   
/*     */   protected Texture(int paramInt1, int paramInt2, TextureData paramTextureData) {
/* 150 */     super(paramInt1, paramInt2);
/* 151 */     load(paramTextureData);
/* 152 */     if (paramTextureData.isManaged()) addManagedTexture(Gdx.app, this); 
/*     */   }
/*     */   
/*     */   public void load(TextureData paramTextureData) {
/* 156 */     if (this.data != null && paramTextureData.isManaged() != this.data.isManaged())
/* 157 */       throw new GdxRuntimeException("New data must have the same managed status as the old data"); 
/* 158 */     this.data = paramTextureData;
/*     */     
/* 160 */     if (!paramTextureData.isPrepared()) paramTextureData.prepare();
/*     */     
/* 162 */     bind();
/* 163 */     uploadImageData(3553, paramTextureData);
/*     */     
/* 165 */     unsafeSetFilter(this.minFilter, this.magFilter, true);
/* 166 */     unsafeSetWrap(this.uWrap, this.vWrap, true);
/* 167 */     unsafeSetAnisotropicFilter(this.anisotropicFilterLevel, true);
/* 168 */     Gdx.gl.glBindTexture(this.glTarget, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void reload() {
/* 175 */     if (!isManaged()) throw new GdxRuntimeException("Tried to reload unmanaged Texture"); 
/* 176 */     this.glHandle = Gdx.gl.glGenTexture();
/* 177 */     load(this.data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Pixmap paramPixmap, int paramInt1, int paramInt2) {
/* 187 */     if (this.data.isManaged()) throw new GdxRuntimeException("can't draw to a managed texture");
/*     */     
/* 189 */     bind();
/* 190 */     Gdx.gl.glTexSubImage2D(this.glTarget, 0, paramInt1, paramInt2, paramPixmap.getWidth(), paramPixmap.getHeight(), paramPixmap.getGLFormat(), paramPixmap.getGLType(), paramPixmap
/* 191 */         .getPixels());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 196 */     return this.data.getWidth();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 201 */     return this.data.getHeight();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDepth() {
/* 206 */     return 0;
/*     */   }
/*     */   
/*     */   public TextureData getTextureData() {
/* 210 */     return this.data;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isManaged() {
/* 215 */     return this.data.isManaged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 224 */     if (this.glHandle == 0)
/* 225 */       return;  delete();
/* 226 */     if (this.data.isManaged() && managedTextures.get(Gdx.app) != null) ((Array)managedTextures.get(Gdx.app)).removeValue(this, true); 
/*     */   }
/*     */   
/*     */   public String toString() {
/* 230 */     if (this.data instanceof com.badlogic.gdx.graphics.glutils.FileTextureData) return this.data.toString(); 
/* 231 */     return super.toString();
/*     */   }
/*     */   
/*     */   private static void addManagedTexture(Application paramApplication, Texture paramTexture) {
/*     */     Array<Texture> array;
/* 236 */     if ((array = managedTextures.get(paramApplication)) == null) array = new Array(); 
/* 237 */     array.add(paramTexture);
/* 238 */     managedTextures.put(paramApplication, array);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void clearAllTextures(Application paramApplication) {
/* 243 */     managedTextures.remove(paramApplication);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void invalidateAllTextures(Application paramApplication) {
/*     */     Array array1;
/* 249 */     if ((array1 = managedTextures.get(paramApplication)) == null)
/*     */       return; 
/* 251 */     if (assetManager == null) {
/* 252 */       for (byte b = 0; b < array1.size; b++) {
/*     */         Texture texture;
/* 254 */         (texture = (Texture)array1.get(b)).reload();
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 260 */     assetManager.finishLoading();
/*     */ 
/*     */     
/*     */     Array array2;
/*     */     
/* 265 */     for (Array.ArrayIterator<Texture> arrayIterator = (array2 = new Array(array1)).iterator(); arrayIterator.hasNext(); ) { Texture texture = arrayIterator.next();
/*     */       String str;
/* 267 */       if ((str = assetManager.getAssetFileName(texture)) == null) {
/* 268 */         texture.reload();
/*     */ 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 274 */       final int refCount = assetManager.getReferenceCount(str);
/* 275 */       assetManager.setReferenceCount(str, 0);
/* 276 */       texture.glHandle = 0;
/*     */ 
/*     */       
/*     */       TextureLoader.TextureParameter textureParameter;
/*     */       
/* 281 */       (textureParameter = new TextureLoader.TextureParameter()).textureData = texture.getTextureData();
/* 282 */       textureParameter.minFilter = texture.getMinFilter();
/* 283 */       textureParameter.magFilter = texture.getMagFilter();
/* 284 */       textureParameter.wrapU = texture.getUWrap();
/* 285 */       textureParameter.wrapV = texture.getVWrap();
/* 286 */       textureParameter.genMipMaps = texture.data.useMipMaps();
/* 287 */       textureParameter.texture = texture;
/* 288 */       textureParameter.loadedCallback = new AssetLoaderParameters.LoadedCallback()
/*     */         {
/*     */           public void finishedLoading(AssetManager param1AssetManager, String param1String, Class param1Class) {
/* 291 */             param1AssetManager.setReferenceCount(param1String, refCount);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 296 */       assetManager.unload(str);
/* 297 */       texture.glHandle = Gdx.gl.glGenTexture();
/* 298 */       assetManager.load(str, Texture.class, (AssetLoaderParameters)textureParameter); }
/*     */ 
/*     */     
/* 301 */     array1.clear();
/* 302 */     array1.addAll(array2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setAssetManager(AssetManager paramAssetManager) {
/* 311 */     assetManager = paramAssetManager;
/*     */   }
/*     */   
/*     */   public static String getManagedStatus() {
/*     */     StringBuilder stringBuilder;
/* 316 */     (stringBuilder = new StringBuilder()).append("Managed textures/app: { ");
/* 317 */     for (Application application : managedTextures.keySet()) {
/* 318 */       stringBuilder.append(((Array)managedTextures.get(application)).size);
/* 319 */       stringBuilder.append(" ");
/*     */     } 
/* 321 */     stringBuilder.append("}");
/* 322 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getNumManagedTextures() {
/* 327 */     return ((Array)managedTextures.get(Gdx.app)).size;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\Texture.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */