/*     */ package com.crashinvaders.basisu.gdx;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import com.badlogic.gdx.utils.IntSet;
/*     */ import com.badlogic.gdx.utils.StreamUtils;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuTextureFormat;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuTranscoderTextureFormat;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuTranscoderTextureFormatSupportIndex;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.DataInputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BasisuGdxUtils
/*     */ {
/*     */   public static final int GL_TEX_ETC1_RGB8 = 36196;
/*     */   public static final int GL_TEX_ETC2_RGB8 = 37492;
/*     */   public static final int GL_TEX_ETC2_RGBA8 = 37496;
/*     */   public static final int GL_TEX_ETC2_R11 = 37488;
/*     */   public static final int GL_TEX_ETC2_RG11 = 37490;
/*     */   public static final int GL_TEX_BC1_DXT1_RGB = 33776;
/*     */   public static final int GL_TEX_BC3_DXT5_RGBA = 33779;
/*     */   public static final int GL_TEX_BC4_RGTC1_RED = 36283;
/*     */   public static final int GL_TEX_BC5_RGTC2_RG = 36285;
/*     */   public static final int GL_TEX_BC7_BPTC_RGBA = 36492;
/*     */   public static final int GL_TEX_ASTC_4X4_RGBA = 37808;
/*     */   public static final int GL_TEX_ATC_RGB = 35986;
/*     */   public static final int GL_TEX_ATC_RGBA_INTERPOLATED = 34798;
/*     */   public static final int GL_TEX_FXT1_RGB = 34480;
/*     */   public static final int GL_TEX_PVRTC1_4BPP_RGB = 35840;
/*     */   public static final int GL_TEX_PVRTC1_4BPP_RGBA = 35842;
/*     */   public static final int GL_TEX_PVRTC2_4BPP_RGBA = 37176;
/*  78 */   public static BasisuTextureFormatSelector defaultFormatSelector = new BasisuTextureFormatSelector.Default();
/*     */   
/*  80 */   private static final IntSet supportedGlTextureFormats = new IntSet();
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean supportedGlTextureFormatsInitialized = false;
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isTranscoderTextureFormatSupported(BasisuTranscoderTextureFormat paramBasisuTranscoderTextureFormat, BasisuTextureFormat paramBasisuTextureFormat) {
/*  89 */     return BasisuTranscoderTextureFormatSupportIndex.isTextureFormatSupported(paramBasisuTranscoderTextureFormat, paramBasisuTextureFormat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int toGlTextureFormat(BasisuTranscoderTextureFormat paramBasisuTranscoderTextureFormat) {
/*  97 */     switch (paramBasisuTranscoderTextureFormat) {
/*     */       case ETC1_RGB:
/*  99 */         if (Gdx.app.getType() == Application.ApplicationType.Desktop)
/*     */         {
/*     */           
/* 102 */           return 37492;
/*     */         }
/* 104 */         return 36196;
/*     */       
/*     */       case ETC2_RGBA:
/* 107 */         return 37496;
/*     */       case ETC2_EAC_R11:
/* 109 */         return 37488;
/*     */       case ETC2_EAC_RG11:
/* 111 */         return 37490;
/*     */       case BC1_RGB:
/* 113 */         return 33776;
/*     */       case BC3_RGBA:
/* 115 */         return 33779;
/*     */       case BC4_R:
/* 117 */         return 36283;
/*     */       case BC5_RG:
/* 119 */         return 36285;
/*     */       case BC7_RGBA:
/* 121 */         return 36492;
/*     */       case ASTC_4x4_RGBA:
/* 123 */         return 37808;
/*     */       case ATC_RGB:
/* 125 */         return 35986;
/*     */       case ATC_RGBA:
/* 127 */         return 34798;
/*     */ 
/*     */       
/*     */       case PVRTC1_4_RGB:
/* 131 */         return 35840;
/*     */       case PVRTC1_4_RGBA:
/* 133 */         return 35842;
/*     */       case PVRTC2_4_RGB:
/*     */       case PVRTC2_4_RGBA:
/* 136 */         return 37176;
/*     */       case RGB565:
/* 138 */         return 6407;
/*     */       case RGBA32:
/*     */       case RGBA4444:
/* 141 */         return 6408;
/*     */     } 
/* 143 */     throw new BasisuGdxException("Unsupported basis texture format: " + paramBasisuTranscoderTextureFormat);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int toUncompressedGlTextureType(BasisuTranscoderTextureFormat paramBasisuTranscoderTextureFormat) {
/* 148 */     if (paramBasisuTranscoderTextureFormat.isCompressedFormat()) {
/* 149 */       throw new BasisuGdxException("The \"basisuFormat\" parameter is not an uncompressed texture format: " + paramBasisuTranscoderTextureFormat);
/*     */     }
/* 151 */     switch (paramBasisuTranscoderTextureFormat) {
/*     */       case RGB565:
/* 153 */         return 33635;
/*     */       case RGBA32:
/* 155 */         return 5121;
/*     */       case RGBA4444:
/* 157 */         return 32819;
/*     */     } 
/* 159 */     throw new BasisuGdxException("Unexpected basis texture format: " + paramBasisuTranscoderTextureFormat);
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
/*     */   public static boolean isBasisuFormatSupported(BasisuTranscoderTextureFormat paramBasisuTranscoderTextureFormat, BasisuTextureFormat paramBasisuTextureFormat) {
/* 171 */     switch (paramBasisuTranscoderTextureFormat) {
/*     */       case RGB565:
/*     */       case RGBA32:
/*     */       case RGBA4444:
/* 175 */         return true;
/*     */     } 
/*     */     
/*     */     int i;
/* 179 */     if (isGlTextureFormatSupported(i = toGlTextureFormat(paramBasisuTranscoderTextureFormat)) && 
/* 180 */       isTranscoderTextureFormatSupported(paramBasisuTranscoderTextureFormat, paramBasisuTextureFormat)) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static IntSet getSupportedGlTextureFormats() {
/* 187 */     initSupportedGlTextureFormats();
/* 188 */     return supportedGlTextureFormats;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized void initSupportedGlTextureFormats() {
/* 196 */     if (supportedGlTextureFormatsInitialized)
/* 197 */       return;  supportedGlTextureFormatsInitialized = true;
/*     */     
/* 199 */     int[] arrayOfInt = BasisuGdxGl.getSupportedTextureFormats();
/* 200 */     supportedGlTextureFormats.addAll(arrayOfInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isGlTextureFormatSupported(int paramInt) {
/* 207 */     initSupportedGlTextureFormats();
/* 208 */     return supportedGlTextureFormats.contains(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isSquareAndPowerOfTwo(int paramInt1, int paramInt2) {
/* 215 */     return (paramInt1 == paramInt2 && MathUtils.isPowerOfTwo(paramInt1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isMultipleOfFour(int paramInt1, int paramInt2) {
/* 222 */     return (paramInt1 % 4 == 0 && paramInt2 % 4 == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer readFileIntoBuffer(FileHandle paramFileHandle) {
/* 231 */     byte[] arrayOfByte = new byte[10240];
/* 232 */     DataInputStream dataInputStream = null; try {
/*     */       ByteBuffer byteBuffer;
/* 234 */       dataInputStream = new DataInputStream(new BufferedInputStream(paramFileHandle.read()));
/* 235 */       int i = (int)paramFileHandle.length();
/*     */ 
/*     */ 
/*     */       
/* 239 */       if (Gdx.app.getType() == Application.ApplicationType.WebGL) {
/* 240 */         byteBuffer = BufferUtils.newByteBuffer(i);
/*     */       } else {
/*     */         
/* 243 */         byteBuffer = BasisuBufferUtils.newUnsafeByteBuffer(byteBuffer);
/*     */       } 
/*     */       
/*     */       int j;
/* 247 */       while ((j = dataInputStream.read(arrayOfByte)) != -1) {
/* 248 */         byteBuffer.put(arrayOfByte, 0, j);
/*     */       }
/* 250 */       byteBuffer.position(0);
/* 251 */       byteBuffer.limit(byteBuffer.capacity());
/* 252 */       return byteBuffer;
/* 253 */     } catch (Exception exception) {
/* 254 */       throw new BasisuGdxException("Couldn't load file '" + paramFileHandle + "'", exception);
/*     */     } finally {
/* 256 */       StreamUtils.closeQuietly(dataInputStream);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String reportAvailableTranscoderFormats(BasisuTextureFormat paramBasisuTextureFormat) {
/*     */     StringBuilder stringBuilder;
/* 262 */     (stringBuilder = new StringBuilder()).append("===== AVAILABLE TRANSCODER FORMATS | ").append(paramBasisuTextureFormat.name()).append(" | (\"+\" if supported by the platform) =====");
/*     */     
/*     */     ArrayList<?> arrayList;
/* 265 */     Collections.sort(arrayList = new ArrayList(BasisuTranscoderTextureFormatSupportIndex.getSupportedTextureFormats(paramBasisuTextureFormat)), (paramBasisuTranscoderTextureFormat1, paramBasisuTranscoderTextureFormat2) -> paramBasisuTranscoderTextureFormat1.ordinal() - paramBasisuTranscoderTextureFormat2.ordinal());
/* 266 */     for (Iterator<?> iterator = arrayList.iterator(); iterator.hasNext(); ) {
/* 267 */       BasisuTranscoderTextureFormat basisuTranscoderTextureFormat; boolean bool = isBasisuFormatSupported(basisuTranscoderTextureFormat = (BasisuTranscoderTextureFormat)iterator.next(), paramBasisuTextureFormat);
/* 268 */       stringBuilder.append("\n").append(bool ? "+ " : "  ").append(basisuTranscoderTextureFormat);
/*     */     } 
/* 270 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\gdx\BasisuGdxUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */