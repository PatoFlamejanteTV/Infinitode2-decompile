/*     */ package com.badlogic.gdx.graphics;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.glutils.CustomTexture3DData;
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
/*     */ public class Texture3D
/*     */   extends GLTexture
/*     */ {
/*  33 */   static final Map<Application, Array<Texture3D>> managedTexture3Ds = new HashMap<>();
/*     */   
/*     */   private Texture3DData data;
/*     */   
/*  37 */   protected Texture.TextureWrap rWrap = Texture.TextureWrap.ClampToEdge;
/*     */   
/*     */   public Texture3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/*  40 */     this((Texture3DData)new CustomTexture3DData(paramInt1, paramInt2, paramInt3, 0, paramInt4, paramInt5, paramInt6));
/*     */   }
/*     */   
/*     */   public Texture3D(Texture3DData paramTexture3DData) {
/*  44 */     super(32879, Gdx.gl.glGenTexture());
/*     */     
/*  46 */     if (Gdx.gl30 == null) {
/*  47 */       throw new GdxRuntimeException("Texture3D requires a device running with GLES 3.0 compatibilty");
/*     */     }
/*     */     
/*  50 */     load(paramTexture3DData);
/*     */     
/*  52 */     if (paramTexture3DData.isManaged()) addManagedTexture(Gdx.app, this); 
/*     */   }
/*     */   
/*     */   private void load(Texture3DData paramTexture3DData) {
/*  56 */     if (this.data != null && paramTexture3DData.isManaged() != this.data.isManaged())
/*  57 */       throw new GdxRuntimeException("New data must have the same managed status as the old data"); 
/*  58 */     this.data = paramTexture3DData;
/*     */     
/*  60 */     bind();
/*     */     
/*  62 */     if (!paramTexture3DData.isPrepared()) paramTexture3DData.prepare();
/*     */     
/*  64 */     paramTexture3DData.consume3DData();
/*     */     
/*  66 */     setFilter(this.minFilter, this.magFilter);
/*  67 */     setWrap(this.uWrap, this.vWrap, this.rWrap);
/*     */     
/*  69 */     Gdx.gl.glBindTexture(this.glTarget, 0);
/*     */   }
/*     */   
/*     */   public Texture3DData getData() {
/*  73 */     return this.data;
/*     */   }
/*     */   
/*     */   public void upload() {
/*  77 */     bind();
/*  78 */     this.data.consume3DData();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/*  83 */     return this.data.getWidth();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  88 */     return this.data.getHeight();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDepth() {
/*  93 */     return this.data.getDepth();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isManaged() {
/*  98 */     return this.data.isManaged();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void reload() {
/* 103 */     if (!isManaged()) throw new GdxRuntimeException("Tried to reload an unmanaged TextureArray"); 
/* 104 */     this.glHandle = Gdx.gl.glGenTexture();
/* 105 */     load(this.data);
/*     */   }
/*     */   
/*     */   private static void addManagedTexture(Application paramApplication, Texture3D paramTexture3D) {
/*     */     Array<Texture3D> array;
/* 110 */     if ((array = managedTexture3Ds.get(paramApplication)) == null) array = new Array(); 
/* 111 */     array.add(paramTexture3D);
/* 112 */     managedTexture3Ds.put(paramApplication, array);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void clearAllTextureArrays(Application paramApplication) {
/* 117 */     managedTexture3Ds.remove(paramApplication);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void invalidateAllTextureArrays(Application paramApplication) {
/*     */     Array array;
/* 123 */     if ((array = managedTexture3Ds.get(paramApplication)) == null)
/*     */       return; 
/* 125 */     for (byte b = 0; b < array.size; b++) {
/*     */       Texture3D texture3D;
/* 127 */       (texture3D = (Texture3D)array.get(b)).reload();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String getManagedStatus() {
/*     */     StringBuilder stringBuilder;
/* 133 */     (stringBuilder = new StringBuilder()).append("Managed TextureArrays/app: { ");
/* 134 */     for (Application application : managedTexture3Ds.keySet()) {
/* 135 */       stringBuilder.append(((Array)managedTexture3Ds.get(application)).size);
/* 136 */       stringBuilder.append(" ");
/*     */     } 
/* 138 */     stringBuilder.append("}");
/* 139 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getNumManagedTextures3D() {
/* 144 */     return ((Array)managedTexture3Ds.get(Gdx.app)).size;
/*     */   }
/*     */   
/*     */   public void setWrap(Texture.TextureWrap paramTextureWrap1, Texture.TextureWrap paramTextureWrap2, Texture.TextureWrap paramTextureWrap3) {
/* 148 */     this.rWrap = paramTextureWrap3;
/* 149 */     setWrap(paramTextureWrap1, paramTextureWrap2);
/* 150 */     Gdx.gl.glTexParameteri(this.glTarget, 32882, paramTextureWrap3.getGLEnum());
/*     */   }
/*     */   
/*     */   public void unsafeSetWrap(Texture.TextureWrap paramTextureWrap1, Texture.TextureWrap paramTextureWrap2, Texture.TextureWrap paramTextureWrap3, boolean paramBoolean) {
/* 154 */     unsafeSetWrap(paramTextureWrap1, paramTextureWrap2, paramBoolean);
/* 155 */     if (paramTextureWrap3 != null && (paramBoolean || this.rWrap != paramTextureWrap3)) {
/* 156 */       Gdx.gl.glTexParameteri(this.glTarget, 32882, paramTextureWrap1.getGLEnum());
/* 157 */       this.rWrap = paramTextureWrap3;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void unsafeSetWrap(Texture.TextureWrap paramTextureWrap1, Texture.TextureWrap paramTextureWrap2, Texture.TextureWrap paramTextureWrap3) {
/* 162 */     unsafeSetWrap(paramTextureWrap1, paramTextureWrap2, paramTextureWrap3, false);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\Texture3D.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */