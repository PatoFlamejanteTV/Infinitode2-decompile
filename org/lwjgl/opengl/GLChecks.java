/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import org.lwjgl.system.APIUtil;
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
/*     */ final class GLChecks
/*     */ {
/*     */   static int typeToBytes(int paramInt) {
/*  24 */     switch (paramInt) {
/*     */       case 5120:
/*     */       case 5121:
/*  27 */         return 1;
/*     */       case 5122:
/*     */       case 5123:
/*     */       case 5127:
/*     */       case 5131:
/*  32 */         return 2;
/*     */       case 5128:
/*  34 */         return 3;
/*     */       case 5124:
/*     */       case 5125:
/*     */       case 5126:
/*     */       case 5129:
/*     */       case 5132:
/*  40 */         return 4;
/*     */       case 5130:
/*     */       case 5134:
/*     */       case 5135:
/*  44 */         return 8;
/*     */     } 
/*  46 */     throw new IllegalArgumentException(APIUtil.apiUnknownToken("Unsupported OpenGL type", paramInt));
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
/*     */   static int typeToByteShift(int paramInt) {
/*  58 */     switch (paramInt) {
/*     */       case 5120:
/*     */       case 5121:
/*  61 */         return 0;
/*     */       case 5122:
/*     */       case 5123:
/*     */       case 5127:
/*     */       case 5131:
/*  66 */         return 1;
/*     */       case 5124:
/*     */       case 5125:
/*     */       case 5126:
/*     */       case 5129:
/*     */       case 5132:
/*  72 */         return 2;
/*     */       case 5130:
/*     */       case 5134:
/*     */       case 5135:
/*  76 */         return 3;
/*     */     } 
/*  78 */     throw new IllegalArgumentException(APIUtil.apiUnknownToken("Unsupported OpenGL type", paramInt));
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static int getTexLevelParameteri(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*     */     GLCapabilities gLCapabilities;
/*  96 */     if ((gLCapabilities = GL.getCapabilities()).OpenGL45) {
/*  97 */       return GL45.glGetTextureLevelParameteri(paramInt1, paramInt3, paramInt4);
/*     */     }
/*  99 */     if (gLCapabilities.GL_ARB_direct_state_access) {
/* 100 */       return ARBDirectStateAccess.glGetTextureLevelParameteri(paramInt1, paramInt3, paramInt4);
/*     */     }
/* 102 */     if (gLCapabilities.GL_EXT_direct_state_access) {
/* 103 */       return EXTDirectStateAccess.glGetTextureLevelParameteriEXT(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */     }
/*     */     
/* 106 */     return GL41.glGetTexLevelParameteri(paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLChecks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */