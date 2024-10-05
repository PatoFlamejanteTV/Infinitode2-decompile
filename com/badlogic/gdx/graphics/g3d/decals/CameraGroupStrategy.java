/*     */ package com.badlogic.gdx.graphics.g3d.decals;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import java.util.Comparator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CameraGroupStrategy
/*     */   implements GroupStrategy, Disposable
/*     */ {
/*     */   private static final int GROUP_OPAQUE = 0;
/*     */   private static final int GROUP_BLEND = 1;
/*     */   
/*  87 */   Pool<Array<Decal>> arrayPool = new Pool<Array<Decal>>(16)
/*     */     {
/*     */       protected Array<Decal> newObject() {
/*  90 */         return new Array();
/*     */       }
/*     */     };
/*  93 */   Array<Array<Decal>> usedArrays = new Array();
/*  94 */   ObjectMap<DecalMaterial, Array<Decal>> materialGroups = new ObjectMap();
/*     */   
/*     */   Camera camera;
/*     */   ShaderProgram shader;
/*     */   private final Comparator<Decal> cameraSorter;
/*     */   
/*     */   public CameraGroupStrategy(Camera paramCamera) {
/* 101 */     this.camera = paramCamera;
/* 102 */     this.cameraSorter = new Comparator<Decal>()
/*     */       {
/*     */         public int compare(Decal param1Decal1, Decal param1Decal2) {
/* 105 */           float f1 = CameraGroupStrategy.this.camera.position.dst(param1Decal1.position);
/*     */           float f2;
/* 107 */           return (int)Math.signum((f2 = CameraGroupStrategy.this.camera.position.dst(param1Decal2.position)) - f1);
/*     */         }
/*     */       };
/* 110 */     createDefaultShader();
/*     */   }
/*     */   
/*     */   public CameraGroupStrategy(Camera paramCamera, Comparator<Decal> paramComparator) {
/* 114 */     this.camera = paramCamera;
/* 115 */     this.cameraSorter = paramComparator;
/* 116 */     createDefaultShader();
/*     */   }
/*     */   
/*     */   public void setCamera(Camera paramCamera) {
/* 120 */     this.camera = paramCamera;
/*     */   }
/*     */   
/*     */   public Camera getCamera() {
/* 124 */     return this.camera;
/*     */   }
/*     */ 
/*     */   
/*     */   public int decideGroup(Decal paramDecal) {
/* 129 */     return paramDecal.getMaterial().isOpaque() ? 0 : 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void beforeGroup(int paramInt, Array<Decal> paramArray) {
/* 134 */     if (paramInt == 1) {
/* 135 */       Gdx.gl.glEnable(3042);
/* 136 */       Gdx.gl.glDepthMask(false);
/* 137 */       paramArray.sort(this.cameraSorter); return;
/*     */     }  int i;
/* 139 */     for (paramInt = 0, i = paramArray.size; paramInt < i; paramInt++) {
/* 140 */       Decal decal = (Decal)paramArray.get(paramInt);
/*     */       Array array;
/* 142 */       if ((array = (Array)this.materialGroups.get(decal.material)) == null) {
/*     */         
/* 144 */         (array = (Array)this.arrayPool.obtain()).clear();
/* 145 */         this.usedArrays.add(array);
/* 146 */         this.materialGroups.put(decal.material, array);
/*     */       } 
/* 148 */       array.add(decal);
/*     */     } 
/*     */     
/* 151 */     paramArray.clear();
/* 152 */     for (ObjectMap.Values<Array> values = this.materialGroups.values().iterator(); values.hasNext(); ) { Array array = values.next();
/* 153 */       paramArray.addAll(array); }
/*     */ 
/*     */     
/* 156 */     this.materialGroups.clear();
/* 157 */     this.arrayPool.freeAll(this.usedArrays);
/* 158 */     this.usedArrays.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void afterGroup(int paramInt) {
/* 164 */     if (paramInt == 1) {
/* 165 */       Gdx.gl.glDisable(3042);
/* 166 */       Gdx.gl.glDepthMask(true);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void beforeGroups() {
/* 172 */     Gdx.gl.glEnable(2929);
/* 173 */     this.shader.bind();
/* 174 */     this.shader.setUniformMatrix("u_projectionViewMatrix", this.camera.combined);
/* 175 */     this.shader.setUniformi("u_texture", 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void afterGroups() {
/* 180 */     Gdx.gl.glDisable(2929);
/*     */   }
/*     */   
/*     */   private void createDefaultShader() {
/* 184 */     String str1 = "attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projectionViewMatrix;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main()\n{\n   v_color = a_color;\n   v_color.a = v_color.a * (255.0/254.0);\n   v_texCoords = a_texCoord0;\n   gl_Position =  u_projectionViewMatrix * a_position;\n}\n";
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
/* 198 */     String str2 = "#ifdef GL_ES\nprecision mediump float;\n#endif\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nvoid main()\n{\n  gl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n}";
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
/* 209 */     this.shader = new ShaderProgram(str1, str2);
/* 210 */     if (!this.shader.isCompiled()) throw new IllegalArgumentException("couldn't compile shader: " + this.shader.getLog());
/*     */   
/*     */   }
/*     */   
/*     */   public ShaderProgram getGroupShader(int paramInt) {
/* 215 */     return this.shader;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 220 */     if (this.shader != null) this.shader.dispose(); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\decals\CameraGroupStrategy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */