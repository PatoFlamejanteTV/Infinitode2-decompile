/*    */ package com.badlogic.gdx.backends.lwjgl3.audio;
/*    */ 
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OpenALUtils
/*    */ {
/*    */   static int determineFormat(int paramInt1, int paramInt2) {
/*    */     int i;
/* 18 */     switch (paramInt1) {
/*    */       case 1:
/* 20 */         switch (paramInt2) { case 8:
/* 21 */             i = 4352; break;
/* 22 */           case 16: i = 4353; break;
/* 23 */           case 32: i = 65552; break;
/* 24 */           case 64: i = 65554; break; }
/* 25 */          throw new GdxRuntimeException("Audio: Bit depth must be 8, 16, 32 or 64.");
/*    */ 
/*    */       
/*    */       case 2:
/* 29 */         switch (paramInt2) { case 8:
/* 30 */             i = 4354; break;
/* 31 */           case 16: i = 4355; break;
/* 32 */           case 32: i = 65553; break;
/* 33 */           case 64: i = 65555; break; }
/* 34 */          throw new GdxRuntimeException("Audio: Bit depth must be 8, 16, 32 or 64.");
/*    */       
/*    */       case 4:
/* 37 */         i = 4613; break;
/* 38 */       case 6: i = 4619; break;
/* 39 */       case 7: i = 4622; break;
/* 40 */       case 8: i = 4625; break;
/* 41 */       default: throw new GdxRuntimeException("Audio: Invalid number of channels. Must be mono, stereo, quad, 5.1, 6.1 or 7.1.");
/*    */     } 
/*    */     
/* 44 */     if (paramInt1 >= 4)
/* 45 */       if (paramInt2 == 8) { i--; }
/* 46 */       else if (paramInt2 == 32) { i++; }
/* 47 */       else if (paramInt2 != 16)
/* 48 */       { throw new GdxRuntimeException("Audio: Bit depth must be 8, 16 or 32 when 4+ channels are present."); }
/*    */        
/* 50 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\audio\OpenALUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */