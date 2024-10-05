/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.CubemapData;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.TextureData;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.StreamUtils;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.DataInputStream;
/*     */ import java.nio.Buffer;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.IntBuffer;
/*     */ import java.util.zip.GZIPInputStream;
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
/*     */ public class KTXTextureData
/*     */   implements CubemapData, TextureData
/*     */ {
/*     */   private FileHandle file;
/*     */   private int glType;
/*     */   private int glTypeSize;
/*     */   private int glFormat;
/*     */   private int glInternalFormat;
/*     */   private int glBaseInternalFormat;
/*  44 */   private int pixelWidth = -1;
/*  45 */   private int pixelHeight = -1;
/*  46 */   private int pixelDepth = -1;
/*     */   private int numberOfArrayElements;
/*     */   private int numberOfFaces;
/*     */   private int numberOfMipmapLevels;
/*     */   private int imagePos;
/*     */   private ByteBuffer compressedData;
/*     */   private boolean useMipMaps;
/*     */   private static final int GL_TEXTURE_1D = 4660;
/*     */   private static final int GL_TEXTURE_3D = 4660;
/*     */   private static final int GL_TEXTURE_1D_ARRAY_EXT = 4660;
/*     */   private static final int GL_TEXTURE_2D_ARRAY_EXT = 4660;
/*     */   
/*     */   public KTXTextureData(FileHandle paramFileHandle, boolean paramBoolean) {
/*  59 */     this.file = paramFileHandle;
/*  60 */     this.useMipMaps = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureData.TextureDataType getType() {
/*  65 */     return TextureData.TextureDataType.Custom;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPrepared() {
/*  70 */     return (this.compressedData != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepare() {
/*  75 */     if (this.compressedData != null) throw new GdxRuntimeException("Already prepared"); 
/*  76 */     if (this.file == null) throw new GdxRuntimeException("Need a file to load from");
/*     */     
/*  78 */     if (this.file.name().endsWith(".zktx")) {
/*  79 */       null = new byte[10240];
/*  80 */       DataInputStream dataInputStream = null;
/*     */       
/*     */       try {
/*  83 */         int k = (dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(this.file.read())))).readInt();
/*  84 */         this.compressedData = BufferUtils.newUnsafeByteBuffer(k);
/*     */         int m;
/*  86 */         while ((m = dataInputStream.read(null)) != -1)
/*  87 */           this.compressedData.put(null, 0, m); 
/*  88 */         this.compressedData.position(0);
/*  89 */         this.compressedData.limit(this.compressedData.capacity());
/*  90 */       } catch (Exception exception) {
/*  91 */         throw new GdxRuntimeException("Couldn't load zktx file '" + this.file + "'", exception);
/*     */       } finally {
/*  93 */         StreamUtils.closeQuietly(dataInputStream);
/*     */       } 
/*     */     } else {
/*  96 */       this.compressedData = ByteBuffer.wrap(this.file.readBytes());
/*     */     } 
/*  98 */     if (this.compressedData.get() != -85) throw new GdxRuntimeException("Invalid KTX Header"); 
/*  99 */     if (this.compressedData.get() != 75) throw new GdxRuntimeException("Invalid KTX Header"); 
/* 100 */     if (this.compressedData.get() != 84) throw new GdxRuntimeException("Invalid KTX Header"); 
/* 101 */     if (this.compressedData.get() != 88) throw new GdxRuntimeException("Invalid KTX Header"); 
/* 102 */     if (this.compressedData.get() != 32) throw new GdxRuntimeException("Invalid KTX Header"); 
/* 103 */     if (this.compressedData.get() != 49) throw new GdxRuntimeException("Invalid KTX Header"); 
/* 104 */     if (this.compressedData.get() != 49) throw new GdxRuntimeException("Invalid KTX Header"); 
/* 105 */     if (this.compressedData.get() != -69) throw new GdxRuntimeException("Invalid KTX Header"); 
/* 106 */     if (this.compressedData.get() != 13) throw new GdxRuntimeException("Invalid KTX Header"); 
/* 107 */     if (this.compressedData.get() != 10) throw new GdxRuntimeException("Invalid KTX Header"); 
/* 108 */     if (this.compressedData.get() != 26) throw new GdxRuntimeException("Invalid KTX Header"); 
/* 109 */     if (this.compressedData.get() != 10) throw new GdxRuntimeException("Invalid KTX Header"); 
/*     */     int i;
/* 111 */     if ((i = this.compressedData.getInt()) != 67305985 && i != 16909060) throw new GdxRuntimeException("Invalid KTX Header"); 
/* 112 */     if (i != 67305985)
/* 113 */       this.compressedData.order((this.compressedData.order() == ByteOrder.BIG_ENDIAN) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN); 
/* 114 */     this.glType = this.compressedData.getInt();
/* 115 */     this.glTypeSize = this.compressedData.getInt();
/* 116 */     this.glFormat = this.compressedData.getInt();
/* 117 */     this.glInternalFormat = this.compressedData.getInt();
/* 118 */     this.glBaseInternalFormat = this.compressedData.getInt();
/* 119 */     this.pixelWidth = this.compressedData.getInt();
/* 120 */     this.pixelHeight = this.compressedData.getInt();
/* 121 */     this.pixelDepth = this.compressedData.getInt();
/* 122 */     this.numberOfArrayElements = this.compressedData.getInt();
/* 123 */     this.numberOfFaces = this.compressedData.getInt();
/* 124 */     this.numberOfMipmapLevels = this.compressedData.getInt();
/* 125 */     if (this.numberOfMipmapLevels == 0) {
/* 126 */       this.numberOfMipmapLevels = 1;
/* 127 */       this.useMipMaps = true;
/*     */     } 
/* 129 */     int j = this.compressedData.getInt();
/* 130 */     this.imagePos = this.compressedData.position() + j;
/* 131 */     if (!this.compressedData.isDirect()) {
/* 132 */       int k = this.imagePos;
/* 133 */       for (byte b = 0; b < this.numberOfMipmapLevels; b++) {
/*     */         
/* 135 */         i = (i = this.compressedData.getInt(k)) + 3 & 0xFFFFFFFC;
/* 136 */         k += i * this.numberOfFaces + 4;
/*     */       } 
/* 138 */       this.compressedData.limit(k);
/* 139 */       this.compressedData.position(0);
/*     */       ByteBuffer byteBuffer;
/* 141 */       (byteBuffer = BufferUtils.newUnsafeByteBuffer(k)).order(this.compressedData.order());
/* 142 */       byteBuffer.put(this.compressedData);
/* 143 */       this.compressedData = byteBuffer;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void consumeCubemapData() {
/* 154 */     consumeCustomData(34067);
/*     */   }
/*     */ 
/*     */   
/*     */   public void consumeCustomData(int paramInt) {
/* 159 */     if (this.compressedData == null) throw new GdxRuntimeException("Call prepare() before calling consumeCompressedData()"); 
/* 160 */     IntBuffer intBuffer = BufferUtils.newIntBuffer(16);
/*     */ 
/*     */     
/* 163 */     boolean bool = false;
/* 164 */     if (this.glType == 0 || this.glFormat == 0) {
/* 165 */       if (this.glType + this.glFormat != 0) throw new GdxRuntimeException("either both or none of glType, glFormat must be zero"); 
/* 166 */       bool = true;
/*     */     } 
/*     */ 
/*     */     
/* 170 */     byte b1 = 1;
/* 171 */     int j = 4660;
/* 172 */     if (this.pixelHeight > 0) {
/* 173 */       b1 = 2;
/* 174 */       j = 3553;
/*     */     } 
/* 176 */     if (this.pixelDepth > 0) {
/* 177 */       b1 = 3;
/* 178 */       j = 4660;
/*     */     } 
/* 180 */     if (this.numberOfFaces == 6) {
/* 181 */       if (b1 == 2)
/* 182 */       { j = 34067; }
/*     */       else
/* 184 */       { throw new GdxRuntimeException("cube map needs 2D faces"); } 
/* 185 */     } else if (this.numberOfFaces != 1) {
/* 186 */       throw new GdxRuntimeException("numberOfFaces must be either 1 or 6");
/*     */     } 
/* 188 */     if (this.numberOfArrayElements > 0) {
/* 189 */       if (j == 4660) {
/* 190 */         j = 4660;
/* 191 */       } else if (j == 3553) {
/* 192 */         j = 4660;
/*     */       } else {
/* 194 */         throw new GdxRuntimeException("No API for 3D and cube arrays yet");
/* 195 */       }  b1++;
/*     */     } 
/* 197 */     if (j == 4660) {
/* 198 */       throw new GdxRuntimeException("Unsupported texture format (only 2D texture are supported in LibGdx for the time being)");
/*     */     }
/* 200 */     int k = -1;
/* 201 */     if (this.numberOfFaces == 6 && paramInt != 34067) {
/*     */       
/* 203 */       if (34069 > paramInt || paramInt > 34074) {
/* 204 */         throw new GdxRuntimeException("You must specify either GL_TEXTURE_CUBE_MAP to bind all 6 faces of the cube or the requested face GL_TEXTURE_CUBE_MAP_POSITIVE_X and followings.");
/*     */       }
/* 206 */       k = paramInt - 34069;
/* 207 */       paramInt = 34069;
/* 208 */     } else if (this.numberOfFaces == 6 && paramInt == 34067) {
/*     */       
/* 210 */       paramInt = 34069;
/*     */     
/*     */     }
/* 213 */     else if (paramInt != j && (34069 > paramInt || paramInt > 34074 || paramInt != 3553)) {
/*     */       
/* 215 */       throw new GdxRuntimeException("Invalid target requested : 0x" + Integer.toHexString(paramInt) + ", expecting : 0x" + 
/* 216 */           Integer.toHexString(j));
/*     */     } 
/*     */ 
/*     */     
/* 220 */     Gdx.gl.glGetIntegerv(3317, intBuffer);
/*     */     int i;
/* 222 */     if ((i = intBuffer.get(0)) != 4) Gdx.gl.glPixelStorei(3317, 4); 
/* 223 */     j = this.glInternalFormat;
/* 224 */     int m = this.glFormat;
/* 225 */     int n = this.imagePos;
/* 226 */     for (byte b2 = 0; b2 < this.numberOfMipmapLevels; b2++) {
/* 227 */       int i1 = Math.max(1, this.pixelWidth >> b2);
/* 228 */       int i2 = Math.max(1, this.pixelHeight >> b2);
/* 229 */       Math.max(1, this.pixelDepth >> b2);
/* 230 */       this.compressedData.position(n);
/*     */       
/* 232 */       int i3, i4 = (i3 = this.compressedData.getInt()) + 3 & 0xFFFFFFFC;
/* 233 */       n += 4;
/* 234 */       for (byte b = 0; b < this.numberOfFaces; b++) {
/* 235 */         this.compressedData.position(n);
/* 236 */         n += i4;
/* 237 */         if (k == -1 || k == b) {
/*     */           ByteBuffer byteBuffer;
/* 239 */           (byteBuffer = this.compressedData.slice()).limit(i4);
/* 240 */           if (b1 != 1)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 246 */             if (b1 == 2) {
/* 247 */               Pixmap pixmap; if (this.numberOfArrayElements > 0) i2 = this.numberOfArrayElements; 
/* 248 */               if (bool) {
/* 249 */                 if (j == ETC1.ETC1_RGB8_OES) {
/* 250 */                   if (!Gdx.graphics.supportsExtension("GL_OES_compressed_ETC1_RGB8_texture")) {
/*     */                     ETC1.ETC1Data eTC1Data;
/* 252 */                     pixmap = ETC1.decodeImage(eTC1Data = new ETC1.ETC1Data(i1, i2, byteBuffer, 0), Pixmap.Format.RGB888);
/* 253 */                     Gdx.gl.glTexImage2D(paramInt + b, b2, pixmap.getGLInternalFormat(), pixmap.getWidth(), pixmap
/* 254 */                         .getHeight(), 0, pixmap.getGLFormat(), pixmap.getGLType(), pixmap.getPixels());
/* 255 */                     pixmap.dispose();
/*     */                   } else {
/* 257 */                     Gdx.gl.glCompressedTexImage2D(paramInt + b, b2, j, i1, i2, 0, i3, (Buffer)pixmap);
/*     */                   }
/*     */                 
/*     */                 } else {
/*     */                   
/* 262 */                   Gdx.gl.glCompressedTexImage2D(paramInt + b, b2, j, i1, i2, 0, i3, (Buffer)pixmap);
/*     */                 } 
/*     */               } else {
/*     */                 
/* 266 */                 Gdx.gl.glTexImage2D(paramInt + b, b2, j, i1, i2, 0, m, this.glType, (Buffer)pixmap);
/*     */               } 
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 278 */     if (i != 4) Gdx.gl.glPixelStorei(3317, i); 
/* 279 */     if (useMipMaps()) Gdx.gl.glGenerateMipmap(paramInt);
/*     */ 
/*     */     
/* 282 */     disposePreparedData();
/*     */   }
/*     */   
/*     */   public void disposePreparedData() {
/* 286 */     if (this.compressedData != null) BufferUtils.disposeUnsafeByteBuffer(this.compressedData); 
/* 287 */     this.compressedData = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Pixmap consumePixmap() {
/* 292 */     throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean disposePixmap() {
/* 297 */     throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 302 */     return this.pixelWidth;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 307 */     return this.pixelHeight;
/*     */   }
/*     */   
/*     */   public int getNumberOfMipMapLevels() {
/* 311 */     return this.numberOfMipmapLevels;
/*     */   }
/*     */   
/*     */   public int getNumberOfFaces() {
/* 315 */     return this.numberOfFaces;
/*     */   }
/*     */   
/*     */   public int getGlInternalFormat() {
/* 319 */     return this.glInternalFormat;
/*     */   }
/*     */   
/*     */   public ByteBuffer getData(int paramInt1, int paramInt2) {
/* 323 */     int i = this.imagePos;
/* 324 */     for (byte b = 0; b < this.numberOfMipmapLevels; b++) {
/*     */       
/* 326 */       int j = (j = this.compressedData.getInt(i)) + 3 & 0xFFFFFFFC;
/* 327 */       i += 4;
/* 328 */       if (b == paramInt1) {
/* 329 */         for (byte b1 = 0; b1 < this.numberOfFaces; b1++) {
/* 330 */           if (b1 == paramInt2) {
/* 331 */             this.compressedData.position(i);
/*     */             ByteBuffer byteBuffer;
/* 333 */             (byteBuffer = this.compressedData.slice()).limit(j);
/* 334 */             return byteBuffer;
/*     */           } 
/* 336 */           i += j;
/*     */         } 
/*     */       } else {
/* 339 */         i += j * this.numberOfFaces;
/*     */       } 
/*     */     } 
/* 342 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Pixmap.Format getFormat() {
/* 347 */     throw new GdxRuntimeException("This TextureData implementation directly handles texture formats.");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useMipMaps() {
/* 352 */     return this.useMipMaps;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isManaged() {
/* 357 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\KTXTextureData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */