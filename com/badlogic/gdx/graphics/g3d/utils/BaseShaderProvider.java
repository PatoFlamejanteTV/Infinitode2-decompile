/*    */ package com.badlogic.gdx.graphics.g3d.utils;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g3d.Renderable;
/*    */ import com.badlogic.gdx.graphics.g3d.Shader;
/*    */ import com.badlogic.gdx.utils.Array;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class BaseShaderProvider
/*    */   implements ShaderProvider
/*    */ {
/* 25 */   protected Array<Shader> shaders = new Array();
/*    */ 
/*    */   
/*    */   public Shader getShader(Renderable paramRenderable) {
/*    */     Shader shader2;
/* 30 */     if ((shader2 = paramRenderable.shader) != null && shader2.canRender(paramRenderable)) return shader2; 
/* 31 */     for (Array.ArrayIterator<Shader> arrayIterator = this.shaders.iterator(); arrayIterator.hasNext();) {
/* 32 */       if ((shader = arrayIterator.next()).canRender(paramRenderable)) return shader; 
/*    */     } 
/*    */     Shader shader1;
/* 35 */     if (!(shader1 = createShader(paramRenderable)).canRender(paramRenderable)) throw new GdxRuntimeException("unable to provide a shader for this renderable"); 
/* 36 */     shader1.init();
/* 37 */     this.shaders.add(shader1);
/* 38 */     return shader1;
/*    */   }
/*    */ 
/*    */   
/*    */   protected abstract Shader createShader(Renderable paramRenderable);
/*    */   
/*    */   public void dispose() {
/* 45 */     for (Array.ArrayIterator<Shader> arrayIterator = this.shaders.iterator(); arrayIterator.hasNext();) {
/* 46 */       (shader = arrayIterator.next()).dispose();
/*    */     }
/* 48 */     this.shaders.clear();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\BaseShaderProvider.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */