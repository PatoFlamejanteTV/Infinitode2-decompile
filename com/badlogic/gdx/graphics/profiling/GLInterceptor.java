/*    */ package com.badlogic.gdx.graphics.profiling;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.GL20;
/*    */ import com.badlogic.gdx.math.FloatCounter;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class GLInterceptor
/*    */   implements GL20
/*    */ {
/*    */   protected int calls;
/*    */   protected int textureBindings;
/*    */   protected int drawCalls;
/*    */   protected int shaderSwitches;
/* 28 */   protected final FloatCounter vertexCount = new FloatCounter(0);
/*    */   
/*    */   protected GLProfiler glProfiler;
/*    */   
/*    */   protected GLInterceptor(GLProfiler paramGLProfiler) {
/* 33 */     this.glProfiler = paramGLProfiler;
/*    */   }
/*    */   
/*    */   public static String resolveErrorNumber(int paramInt) {
/* 37 */     switch (paramInt) {
/*    */       case 1281:
/* 39 */         return "GL_INVALID_VALUE";
/*    */       case 1282:
/* 41 */         return "GL_INVALID_OPERATION";
/*    */       case 1286:
/* 43 */         return "GL_INVALID_FRAMEBUFFER_OPERATION";
/*    */       case 1280:
/* 45 */         return "GL_INVALID_ENUM";
/*    */       case 1285:
/* 47 */         return "GL_OUT_OF_MEMORY";
/*    */     } 
/* 49 */     return "number " + paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getCalls() {
/* 54 */     return this.calls;
/*    */   }
/*    */   
/*    */   public int getTextureBindings() {
/* 58 */     return this.textureBindings;
/*    */   }
/*    */   
/*    */   public int getDrawCalls() {
/* 62 */     return this.drawCalls;
/*    */   }
/*    */   
/*    */   public int getShaderSwitches() {
/* 66 */     return this.shaderSwitches;
/*    */   }
/*    */   
/*    */   public FloatCounter getVertexCount() {
/* 70 */     return this.vertexCount;
/*    */   }
/*    */   
/*    */   public void reset() {
/* 74 */     this.calls = 0;
/* 75 */     this.textureBindings = 0;
/* 76 */     this.drawCalls = 0;
/* 77 */     this.shaderSwitches = 0;
/* 78 */     this.vertexCount.reset();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\profiling\GLInterceptor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */