/*    */ package com.crashinvaders.basisu.wrapper;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BasisuTranscoderTextureFormatSupportIndex
/*    */ {
/* 14 */   static final HashMap<BasisuTextureFormat, Set<BasisuTranscoderTextureFormat>> supportMap = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static synchronized boolean isTextureFormatSupported(BasisuTranscoderTextureFormat paramBasisuTranscoderTextureFormat, BasisuTextureFormat paramBasisuTextureFormat) {
/* 20 */     return getSupportedTextureFormats(paramBasisuTextureFormat).contains(paramBasisuTranscoderTextureFormat);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static synchronized Set<BasisuTranscoderTextureFormat> getSupportedTextureFormats(BasisuTextureFormat paramBasisuTextureFormat) {
/*    */     Set<BasisuTranscoderTextureFormat> set;
/* 29 */     if ((set = supportMap.get(paramBasisuTextureFormat)) == null) {
/* 30 */       set = new HashSet();
/* 31 */       collectSupportedTextureFormats(paramBasisuTextureFormat, set);
/* 32 */       supportMap.put(paramBasisuTextureFormat, set);
/*    */     } 
/* 34 */     return set; } private static void collectSupportedTextureFormats(BasisuTextureFormat paramBasisuTextureFormat, Set<BasisuTranscoderTextureFormat> paramSet) {
/*    */     BasisuTranscoderTextureFormat[] arrayOfBasisuTranscoderTextureFormat;
/*    */     int i;
/*    */     byte b;
/* 38 */     for (i = (arrayOfBasisuTranscoderTextureFormat = BasisuTranscoderTextureFormat.values()).length, b = 0; b < i; b++) {
/* 39 */       BasisuTranscoderTextureFormat basisuTranscoderTextureFormat; if (BasisuWrapper.isTranscoderTexFormatSupported(basisuTranscoderTextureFormat = arrayOfBasisuTranscoderTextureFormat[b], paramBasisuTextureFormat))
/* 40 */         paramSet.add(basisuTranscoderTextureFormat); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\wrapper\BasisuTranscoderTextureFormatSupportIndex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */