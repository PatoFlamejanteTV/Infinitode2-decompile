/*     */ package com.badlogic.gdx.graphics;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.nio.Buffer;
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
/*     */ public class TextureArray
/*     */   extends GLTexture
/*     */ {
/*  32 */   static final Map<Application, Array<TextureArray>> managedTextureArrays = new HashMap<>();
/*     */   
/*     */   private TextureArrayData data;
/*     */   
/*     */   public TextureArray(String... paramVarArgs) {
/*  37 */     this(getInternalHandles(paramVarArgs));
/*     */   }
/*     */   
/*     */   public TextureArray(FileHandle... paramVarArgs) {
/*  41 */     this(false, paramVarArgs);
/*     */   }
/*     */   
/*     */   public TextureArray(boolean paramBoolean, FileHandle... paramVarArgs) {
/*  45 */     this(paramBoolean, Pixmap.Format.RGBA8888, paramVarArgs);
/*     */   }
/*     */   
/*     */   public TextureArray(boolean paramBoolean, Pixmap.Format paramFormat, FileHandle... paramVarArgs) {
/*  49 */     this(TextureArrayData.Factory.loadFromFiles(paramFormat, paramBoolean, paramVarArgs));
/*     */   }
/*     */   
/*     */   public TextureArray(TextureArrayData paramTextureArrayData) {
/*  53 */     super(35866, Gdx.gl.glGenTexture());
/*     */     
/*  55 */     if (Gdx.gl30 == null) {
/*  56 */       throw new GdxRuntimeException("TextureArray requires a device running with GLES 3.0 compatibilty");
/*     */     }
/*     */     
/*  59 */     load(paramTextureArrayData);
/*     */     
/*  61 */     if (paramTextureArrayData.isManaged()) addManagedTexture(Gdx.app, this); 
/*     */   }
/*     */   
/*     */   private static FileHandle[] getInternalHandles(String... paramVarArgs) {
/*  65 */     FileHandle[] arrayOfFileHandle = new FileHandle[paramVarArgs.length];
/*  66 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/*  67 */       arrayOfFileHandle[b] = Gdx.files.internal(paramVarArgs[b]);
/*     */     }
/*  69 */     return arrayOfFileHandle;
/*     */   }
/*     */   
/*     */   private void load(TextureArrayData paramTextureArrayData) {
/*  73 */     if (this.data != null && paramTextureArrayData.isManaged() != this.data.isManaged())
/*  74 */       throw new GdxRuntimeException("New data must have the same managed status as the old data"); 
/*  75 */     this.data = paramTextureArrayData;
/*     */     
/*  77 */     bind();
/*  78 */     Gdx.gl30.glTexImage3D(35866, 0, paramTextureArrayData.getInternalFormat(), paramTextureArrayData.getWidth(), paramTextureArrayData.getHeight(), paramTextureArrayData
/*  79 */         .getDepth(), 0, paramTextureArrayData.getInternalFormat(), paramTextureArrayData.getGLType(), (Buffer)null);
/*     */     
/*  81 */     if (!paramTextureArrayData.isPrepared()) paramTextureArrayData.prepare();
/*     */     
/*  83 */     paramTextureArrayData.consumeTextureArrayData();
/*     */     
/*  85 */     setFilter(this.minFilter, this.magFilter);
/*  86 */     setWrap(this.uWrap, this.vWrap);
/*  87 */     Gdx.gl.glBindTexture(this.glTarget, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/*  92 */     return this.data.getWidth();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  97 */     return this.data.getHeight();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDepth() {
/* 102 */     return this.data.getDepth();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isManaged() {
/* 107 */     return this.data.isManaged();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void reload() {
/* 112 */     if (!isManaged()) throw new GdxRuntimeException("Tried to reload an unmanaged TextureArray"); 
/* 113 */     this.glHandle = Gdx.gl.glGenTexture();
/* 114 */     load(this.data);
/*     */   }
/*     */   
/*     */   private static void addManagedTexture(Application paramApplication, TextureArray paramTextureArray) {
/*     */     Array<TextureArray> array;
/* 119 */     if ((array = managedTextureArrays.get(paramApplication)) == null) array = new Array(); 
/* 120 */     array.add(paramTextureArray);
/* 121 */     managedTextureArrays.put(paramApplication, array);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void clearAllTextureArrays(Application paramApplication) {
/* 126 */     managedTextureArrays.remove(paramApplication);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void invalidateAllTextureArrays(Application paramApplication) {
/*     */     Array array;
/* 132 */     if ((array = managedTextureArrays.get(paramApplication)) == null)
/*     */       return; 
/* 134 */     for (byte b = 0; b < array.size; b++) {
/*     */       TextureArray textureArray;
/* 136 */       (textureArray = (TextureArray)array.get(b)).reload();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String getManagedStatus() {
/*     */     StringBuilder stringBuilder;
/* 142 */     (stringBuilder = new StringBuilder()).append("Managed TextureArrays/app: { ");
/* 143 */     for (Application application : managedTextureArrays.keySet()) {
/* 144 */       stringBuilder.append(((Array)managedTextureArrays.get(application)).size);
/* 145 */       stringBuilder.append(" ");
/*     */     } 
/* 147 */     stringBuilder.append("}");
/* 148 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getNumManagedTextureArrays() {
/* 153 */     return ((Array)managedTextureArrays.get(Gdx.app)).size;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\TextureArray.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */