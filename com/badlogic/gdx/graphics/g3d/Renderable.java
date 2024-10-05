/*     */ package com.badlogic.gdx.graphics.g3d;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g3d.model.MeshPart;
/*     */ import com.badlogic.gdx.math.Matrix4;
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
/*     */ public class Renderable
/*     */ {
/*  74 */   public final Matrix4 worldTransform = new Matrix4();
/*     */   
/*  76 */   public final MeshPart meshPart = new MeshPart();
/*     */ 
/*     */ 
/*     */   
/*     */   public Material material;
/*     */ 
/*     */   
/*     */   public Environment environment;
/*     */ 
/*     */   
/*     */   public Matrix4[] bones;
/*     */ 
/*     */   
/*     */   public Shader shader;
/*     */ 
/*     */   
/*     */   public Object userData;
/*     */ 
/*     */ 
/*     */   
/*     */   public Renderable set(Renderable paramRenderable) {
/*  97 */     this.worldTransform.set(paramRenderable.worldTransform);
/*  98 */     this.material = paramRenderable.material;
/*  99 */     this.meshPart.set(paramRenderable.meshPart);
/* 100 */     this.bones = paramRenderable.bones;
/* 101 */     this.environment = paramRenderable.environment;
/* 102 */     this.shader = paramRenderable.shader;
/* 103 */     this.userData = paramRenderable.userData;
/* 104 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\Renderable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */