/*     */ package com.crashinvaders.basisu.gdx;
/*     */ 
/*     */ import com.crashinvaders.basisu.wrapper.BasisuFileInfo;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuImageInfo;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuTextureFormat;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuTranscoderTextureFormat;
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
/*     */ public interface BasisuTextureFormatSelector
/*     */ {
/*     */   BasisuTranscoderTextureFormat resolveTextureFormat(BasisuData paramBasisuData, int paramInt);
/*     */   
/*     */   BasisuTranscoderTextureFormat resolveTextureFormat(Ktx2Data paramKtx2Data);
/*     */   
/*     */   public static class Default
/*     */     implements BasisuTextureFormatSelector
/*     */   {
/*     */     public BasisuTranscoderTextureFormat resolveTextureFormat(BasisuData param1BasisuData, int param1Int) {
/*  46 */       BasisuFileInfo basisuFileInfo = param1BasisuData.getFileInfo();
/*  47 */       BasisuImageInfo basisuImageInfo = param1BasisuData.getImageInfo(param1Int);
/*  48 */       BasisuTextureFormat basisuTextureFormat = basisuFileInfo.getTextureFormat();
/*  49 */       int i = basisuImageInfo.getWidth();
/*  50 */       int j = basisuImageInfo.getHeight();
/*  51 */       boolean bool = basisuImageInfo.hasAlphaFlag();
/*  52 */       return resolveTextureFormat(basisuTextureFormat, i, j, bool);
/*     */     }
/*     */ 
/*     */     
/*     */     public BasisuTranscoderTextureFormat resolveTextureFormat(Ktx2Data param1Ktx2Data) {
/*  57 */       BasisuTextureFormat basisuTextureFormat = param1Ktx2Data.getTextureFormat();
/*  58 */       int i = param1Ktx2Data.getImageWidth();
/*  59 */       int j = param1Ktx2Data.getImageHeight();
/*  60 */       boolean bool = param1Ktx2Data.hasAlpha();
/*  61 */       return resolveTextureFormat(basisuTextureFormat, i, j, bool);
/*     */     }
/*     */     
/*     */     private BasisuTranscoderTextureFormat resolveTextureFormat(BasisuTextureFormat param1BasisuTextureFormat, int param1Int1, int param1Int2, boolean param1Boolean) {
/*  65 */       switch (param1BasisuTextureFormat) {
/*     */         case ETC1S:
/*  67 */           return resolveForEtc1s(param1Int1, param1Int2, param1Boolean);
/*     */         case UASTC4x4:
/*  69 */           return resolveForUastc(param1Int1, param1Int2, param1Boolean);
/*     */       } 
/*  71 */       throw new BasisuGdxException("Unexpected texture format: " + param1BasisuTextureFormat);
/*     */     }
/*     */ 
/*     */     
/*     */     private static BasisuTranscoderTextureFormat resolveForEtc1s(int param1Int1, int param1Int2, boolean param1Boolean) {
/*  76 */       BasisuTextureFormat basisuTextureFormat = BasisuTextureFormat.ETC1S;
/*     */ 
/*     */       
/*  79 */       if (param1Boolean) {
/*     */ 
/*     */         
/*  82 */         if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.ETC2_RGBA, basisuTextureFormat)) {
/*  83 */           return BasisuTranscoderTextureFormat.ETC2_RGBA;
/*     */         }
/*     */         
/*  86 */         if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.BC7_RGBA, basisuTextureFormat)) {
/*  87 */           return BasisuTranscoderTextureFormat.BC7_RGBA;
/*     */         }
/*     */         
/*  90 */         if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.BC3_RGBA, basisuTextureFormat) && 
/*  91 */           BasisuGdxUtils.isMultipleOfFour(param1Int1, param1Int2)) {
/*  92 */           return BasisuTranscoderTextureFormat.BC3_RGBA;
/*     */         }
/*  94 */         if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.ASTC_4x4_RGBA, basisuTextureFormat)) {
/*  95 */           return BasisuTranscoderTextureFormat.ASTC_4x4_RGBA;
/*     */         }
/*     */         
/*  98 */         if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.ATC_RGBA, basisuTextureFormat)) {
/*  99 */           return BasisuTranscoderTextureFormat.ATC_RGBA;
/*     */         }
/*     */         
/* 102 */         if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.PVRTC1_4_RGBA, basisuTextureFormat) && 
/* 103 */           BasisuGdxUtils.isSquareAndPowerOfTwo(param1Int1, param1Int2)) {
/* 104 */           return BasisuTranscoderTextureFormat.PVRTC1_4_RGBA;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 109 */         if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.PVRTC2_4_RGBA, basisuTextureFormat)) {
/* 110 */           return BasisuTranscoderTextureFormat.PVRTC2_4_RGBA;
/*     */         }
/* 112 */         return BasisuTranscoderTextureFormat.RGBA32;
/*     */       } 
/*     */ 
/*     */       
/* 116 */       if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.ETC1_RGB, basisuTextureFormat)) {
/* 117 */         return BasisuTranscoderTextureFormat.ETC1_RGB;
/*     */       }
/*     */ 
/*     */       
/* 121 */       if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.BC1_RGB, basisuTextureFormat) && 
/* 122 */         BasisuGdxUtils.isMultipleOfFour(param1Int1, param1Int2)) {
/* 123 */         return BasisuTranscoderTextureFormat.BC1_RGB;
/*     */       }
/*     */       
/* 126 */       if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.ATC_RGB, basisuTextureFormat)) {
/* 127 */         return BasisuTranscoderTextureFormat.ATC_RGB;
/*     */       }
/*     */       
/* 130 */       if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.PVRTC2_4_RGB, basisuTextureFormat)) {
/* 131 */         return BasisuTranscoderTextureFormat.PVRTC2_4_RGB;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 140 */       if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.PVRTC1_4_RGB, basisuTextureFormat) && 
/* 141 */         BasisuGdxUtils.isSquareAndPowerOfTwo(param1Int1, param1Int2)) {
/* 142 */         return BasisuTranscoderTextureFormat.PVRTC1_4_RGB;
/*     */       }
/* 144 */       return BasisuTranscoderTextureFormat.RGB565;
/*     */     }
/*     */ 
/*     */     
/*     */     private BasisuTranscoderTextureFormat resolveForUastc(int param1Int1, int param1Int2, boolean param1Boolean) {
/* 149 */       BasisuTextureFormat basisuTextureFormat = BasisuTextureFormat.UASTC4x4;
/*     */ 
/*     */       
/* 152 */       if (param1Boolean) {
/* 153 */         if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.ASTC_4x4_RGBA, basisuTextureFormat)) {
/* 154 */           return BasisuTranscoderTextureFormat.ASTC_4x4_RGBA;
/*     */         }
/* 156 */         if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.BC7_RGBA, basisuTextureFormat)) {
/* 157 */           return BasisuTranscoderTextureFormat.BC7_RGBA;
/*     */         }
/* 159 */         if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.BC3_RGBA, basisuTextureFormat) && 
/* 160 */           BasisuGdxUtils.isMultipleOfFour(param1Int1, param1Int2)) {
/* 161 */           return BasisuTranscoderTextureFormat.BC3_RGBA;
/*     */         }
/* 163 */         if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.ETC2_RGBA, basisuTextureFormat)) {
/* 164 */           return BasisuTranscoderTextureFormat.ETC2_RGBA;
/*     */         }
/*     */         
/* 167 */         if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.ATC_RGBA, basisuTextureFormat)) {
/* 168 */           return BasisuTranscoderTextureFormat.ATC_RGBA;
/*     */         }
/*     */         
/* 171 */         if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.PVRTC1_4_RGBA, basisuTextureFormat) && 
/* 172 */           BasisuGdxUtils.isSquareAndPowerOfTwo(param1Int1, param1Int2)) {
/* 173 */           return BasisuTranscoderTextureFormat.PVRTC1_4_RGBA;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 178 */         if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.PVRTC2_4_RGBA, basisuTextureFormat)) {
/* 179 */           return BasisuTranscoderTextureFormat.PVRTC2_4_RGBA;
/*     */         }
/* 181 */         return BasisuTranscoderTextureFormat.RGBA32;
/*     */       } 
/*     */       
/* 184 */       if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.BC1_RGB, basisuTextureFormat) && 
/* 185 */         BasisuGdxUtils.isMultipleOfFour(param1Int1, param1Int2)) {
/* 186 */         return BasisuTranscoderTextureFormat.BC1_RGB;
/*     */       }
/* 188 */       if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.ETC1_RGB, basisuTextureFormat)) {
/* 189 */         return BasisuTranscoderTextureFormat.ETC1_RGB;
/*     */       }
/* 191 */       if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.ATC_RGB, basisuTextureFormat)) {
/* 192 */         return BasisuTranscoderTextureFormat.ATC_RGB;
/*     */       }
/* 194 */       if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.PVRTC2_4_RGB, basisuTextureFormat)) {
/* 195 */         return BasisuTranscoderTextureFormat.PVRTC2_4_RGB;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 203 */       if (BasisuGdxUtils.isBasisuFormatSupported(BasisuTranscoderTextureFormat.PVRTC1_4_RGB, basisuTextureFormat) && 
/* 204 */         BasisuGdxUtils.isSquareAndPowerOfTwo(param1Int1, param1Int2)) {
/* 205 */         return BasisuTranscoderTextureFormat.PVRTC1_4_RGB;
/*     */       }
/* 207 */       return BasisuTranscoderTextureFormat.RGB565;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Fixed
/*     */     implements BasisuTextureFormatSelector
/*     */   {
/*     */     private final BasisuTranscoderTextureFormat format;
/*     */     
/*     */     public Fixed(BasisuTranscoderTextureFormat param1BasisuTranscoderTextureFormat) {
/* 217 */       this.format = param1BasisuTranscoderTextureFormat;
/*     */     }
/*     */ 
/*     */     
/*     */     public BasisuTranscoderTextureFormat resolveTextureFormat(BasisuData param1BasisuData, int param1Int) {
/* 222 */       return this.format;
/*     */     }
/*     */ 
/*     */     
/*     */     public BasisuTranscoderTextureFormat resolveTextureFormat(Ktx2Data param1Ktx2Data) {
/* 227 */       return this.format;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\gdx\BasisuTextureFormatSelector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */