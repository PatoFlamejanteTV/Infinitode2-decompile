/*      */ package com.badlogic.gdx.graphics;
/*      */ 
/*      */ import com.badlogic.gdx.Application;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.glutils.IndexArray;
/*      */ import com.badlogic.gdx.graphics.glutils.IndexBufferObject;
/*      */ import com.badlogic.gdx.graphics.glutils.IndexBufferObjectSubData;
/*      */ import com.badlogic.gdx.graphics.glutils.IndexData;
/*      */ import com.badlogic.gdx.graphics.glutils.InstanceBufferObject;
/*      */ import com.badlogic.gdx.graphics.glutils.InstanceData;
/*      */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*      */ import com.badlogic.gdx.graphics.glutils.VertexArray;
/*      */ import com.badlogic.gdx.graphics.glutils.VertexBufferObject;
/*      */ import com.badlogic.gdx.graphics.glutils.VertexBufferObjectSubData;
/*      */ import com.badlogic.gdx.graphics.glutils.VertexBufferObjectWithVAO;
/*      */ import com.badlogic.gdx.graphics.glutils.VertexData;
/*      */ import com.badlogic.gdx.math.Matrix3;
/*      */ import com.badlogic.gdx.math.Matrix4;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.math.Vector3;
/*      */ import com.badlogic.gdx.math.collision.BoundingBox;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Disposable;
/*      */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Mesh
/*      */   implements Disposable
/*      */ {
/*      */   public enum VertexDataType
/*      */   {
/*   73 */     VertexArray, VertexBufferObject, VertexBufferObjectSubData, VertexBufferObjectWithVAO;
/*      */   }
/*      */ 
/*      */   
/*   77 */   static final Map<Application, Array<Mesh>> meshes = new HashMap<>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final VertexData vertices;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final IndexData indices;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean autoBind = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final boolean isVertexArray;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   InstanceData instances;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isInstanced = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final Vector3 tmpV;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private VertexData makeVertexBuffer(boolean paramBoolean, int paramInt, VertexAttributes paramVertexAttributes) {
/*  144 */     if (Gdx.gl30 != null) {
/*  145 */       return (VertexData)new VertexBufferObjectWithVAO(paramBoolean, paramInt, paramVertexAttributes);
/*      */     }
/*  147 */     return (VertexData)new VertexBufferObject(paramBoolean, paramInt, paramVertexAttributes);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Mesh(VertexDataType paramVertexDataType, boolean paramBoolean, int paramInt1, int paramInt2, VertexAttribute... paramVarArgs) {
/*  160 */     this(paramVertexDataType, paramBoolean, paramInt1, paramInt2, new VertexAttributes(paramVarArgs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Mesh enableInstancedRendering(boolean paramBoolean, int paramInt, VertexAttribute... paramVarArgs) {
/*  199 */     if (!this.isInstanced) {
/*  200 */       this.isInstanced = true;
/*  201 */       this.instances = (InstanceData)new InstanceBufferObject(paramBoolean, paramInt, paramVarArgs);
/*      */     } else {
/*  203 */       throw new GdxRuntimeException("Trying to enable InstancedRendering on same Mesh instance twice. Use disableInstancedRendering to clean up old InstanceData first");
/*      */     } 
/*      */     
/*  206 */     return this;
/*      */   }
/*      */   
/*      */   public Mesh disableInstancedRendering() {
/*  210 */     if (this.isInstanced) {
/*  211 */       this.isInstanced = false;
/*  212 */       this.instances.dispose();
/*  213 */       this.instances = null;
/*      */     } 
/*  215 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Mesh setInstanceData(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/*  225 */     if (this.instances != null) {
/*  226 */       this.instances.setInstanceData(paramArrayOffloat, paramInt1, paramInt2);
/*      */     } else {
/*  228 */       throw new GdxRuntimeException("An InstanceBufferObject must be set before setting instance data!");
/*      */     } 
/*  230 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Mesh setInstanceData(float[] paramArrayOffloat) {
/*  238 */     if (this.instances != null) {
/*  239 */       this.instances.setInstanceData(paramArrayOffloat, 0, paramArrayOffloat.length);
/*      */     } else {
/*  241 */       throw new GdxRuntimeException("An InstanceBufferObject must be set before setting instance data!");
/*      */     } 
/*  243 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Mesh setInstanceData(FloatBuffer paramFloatBuffer, int paramInt) {
/*  252 */     if (this.instances != null) {
/*  253 */       this.instances.setInstanceData(paramFloatBuffer, paramInt);
/*      */     } else {
/*  255 */       throw new GdxRuntimeException("An InstanceBufferObject must be set before setting instance data!");
/*      */     } 
/*  257 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Mesh setInstanceData(FloatBuffer paramFloatBuffer) {
/*  265 */     if (this.instances != null) {
/*  266 */       this.instances.setInstanceData(paramFloatBuffer, paramFloatBuffer.limit());
/*      */     } else {
/*  268 */       throw new GdxRuntimeException("An InstanceBufferObject must be set before setting instance data!");
/*      */     } 
/*      */     
/*  271 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Mesh updateInstanceData(int paramInt, float[] paramArrayOffloat) {
/*  278 */     return updateInstanceData(paramInt, paramArrayOffloat, 0, paramArrayOffloat.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Mesh updateInstanceData(int paramInt1, float[] paramArrayOffloat, int paramInt2, int paramInt3) {
/*  287 */     this.instances.updateInstanceData(paramInt1, paramArrayOffloat, paramInt2, paramInt3);
/*  288 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Mesh updateInstanceData(int paramInt, FloatBuffer paramFloatBuffer) {
/*  295 */     return updateInstanceData(paramInt, paramFloatBuffer, 0, paramFloatBuffer.limit());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Mesh updateInstanceData(int paramInt1, FloatBuffer paramFloatBuffer, int paramInt2, int paramInt3) {
/*  304 */     this.instances.updateInstanceData(paramInt1, paramFloatBuffer, paramInt2, paramInt3);
/*  305 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Mesh setVertices(float[] paramArrayOffloat) {
/*  313 */     this.vertices.setVertices(paramArrayOffloat, 0, paramArrayOffloat.length);
/*      */     
/*  315 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isInstanced() {
/*  320 */     return this.isInstanced;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Mesh setVertices(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/*  330 */     this.vertices.setVertices(paramArrayOffloat, paramInt1, paramInt2);
/*      */     
/*  332 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Mesh updateVertices(int paramInt, float[] paramArrayOffloat) {
/*  339 */     return updateVertices(paramInt, paramArrayOffloat, 0, paramArrayOffloat.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Mesh updateVertices(int paramInt1, float[] paramArrayOffloat, int paramInt2, int paramInt3) {
/*  348 */     this.vertices.updateVertices(paramInt1, paramArrayOffloat, paramInt2, paramInt3);
/*  349 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float[] getVertices(float[] paramArrayOffloat) {
/*  355 */     return getVertices(0, -1, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float[] getVertices(int paramInt, float[] paramArrayOffloat) {
/*  363 */     return getVertices(paramInt, -1, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float[] getVertices(int paramInt1, int paramInt2, float[] paramArrayOffloat) {
/*  372 */     return getVertices(paramInt1, paramInt2, paramArrayOffloat, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float[] getVertices(int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3) {
/*  383 */     int i = getNumVertices() * getVertexSize() / 4;
/*  384 */     if (paramInt2 == -1 && (
/*      */       
/*  386 */       paramInt2 = i - paramInt1) > paramArrayOffloat.length - paramInt3) paramInt2 = paramArrayOffloat.length - paramInt3;
/*      */     
/*  388 */     if (paramInt1 < 0 || paramInt2 <= 0 || paramInt1 + paramInt2 > i || paramInt3 < 0 || paramInt3 >= paramArrayOffloat.length)
/*  389 */       throw new IndexOutOfBoundsException(); 
/*  390 */     if (paramArrayOffloat.length - paramInt3 < paramInt2) throw new IllegalArgumentException("not enough room in vertices array, has " + paramArrayOffloat.length + " floats, needs " + paramInt2);
/*      */     
/*      */     FloatBuffer floatBuffer;
/*  393 */     int j = (floatBuffer = getVerticesBuffer(false)).position();
/*  394 */     floatBuffer.position(paramInt1);
/*  395 */     floatBuffer.get(paramArrayOffloat, paramInt3, paramInt2);
/*  396 */     floatBuffer.position(j);
/*  397 */     return paramArrayOffloat;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Mesh setIndices(short[] paramArrayOfshort) {
/*  405 */     this.indices.setIndices(paramArrayOfshort, 0, paramArrayOfshort.length);
/*      */     
/*  407 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Mesh setIndices(short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/*  417 */     this.indices.setIndices(paramArrayOfshort, paramInt1, paramInt2);
/*      */     
/*  419 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void getIndices(short[] paramArrayOfshort) {
/*  425 */     getIndices(paramArrayOfshort, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void getIndices(short[] paramArrayOfshort, int paramInt) {
/*  433 */     getIndices(0, paramArrayOfshort, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void getIndices(int paramInt1, short[] paramArrayOfshort, int paramInt2) {
/*  442 */     getIndices(paramInt1, -1, paramArrayOfshort, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void getIndices(int paramInt1, int paramInt2, short[] paramArrayOfshort, int paramInt3) {
/*  452 */     int i = getNumIndices();
/*  453 */     if (paramInt2 < 0) paramInt2 = i - paramInt1; 
/*  454 */     if (paramInt1 < 0 || paramInt1 >= i || paramInt1 + paramInt2 > i) throw new IllegalArgumentException("Invalid range specified, offset: " + paramInt1 + ", count: " + paramInt2 + ", max: " + i);
/*      */     
/*  456 */     if (paramArrayOfshort.length - paramInt3 < paramInt2) throw new IllegalArgumentException("not enough room in indices array, has " + paramArrayOfshort.length + " shorts, needs " + paramInt2);
/*      */     
/*      */     ShortBuffer shortBuffer;
/*  459 */     int j = (shortBuffer = getIndicesBuffer(false)).position();
/*  460 */     shortBuffer.position(paramInt1);
/*  461 */     shortBuffer.get(paramArrayOfshort, paramInt3, paramInt2);
/*  462 */     shortBuffer.position(j);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getNumIndices() {
/*  467 */     return this.indices.getNumIndices();
/*      */   }
/*      */ 
/*      */   
/*      */   public int getNumVertices() {
/*  472 */     return this.vertices.getNumVertices();
/*      */   }
/*      */ 
/*      */   
/*      */   public int getMaxVertices() {
/*  477 */     return this.vertices.getNumMaxVertices();
/*      */   }
/*      */ 
/*      */   
/*      */   public int getMaxIndices() {
/*  482 */     return this.indices.getNumMaxIndices();
/*      */   }
/*      */ 
/*      */   
/*      */   public int getVertexSize() {
/*  487 */     return (this.vertices.getAttributes()).vertexSize;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAutoBind(boolean paramBoolean) {
/*  497 */     this.autoBind = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void bind(ShaderProgram paramShaderProgram) {
/*  505 */     bind(paramShaderProgram, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void bind(ShaderProgram paramShaderProgram, int[] paramArrayOfint1, int[] paramArrayOfint2) {
/*  515 */     this.vertices.bind(paramShaderProgram, paramArrayOfint1);
/*  516 */     if (this.instances != null && this.instances.getNumInstances() > 0) this.instances.bind(paramShaderProgram, paramArrayOfint2); 
/*  517 */     if (this.indices.getNumIndices() > 0) this.indices.bind();
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unbind(ShaderProgram paramShaderProgram) {
/*  525 */     unbind(paramShaderProgram, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unbind(ShaderProgram paramShaderProgram, int[] paramArrayOfint1, int[] paramArrayOfint2) {
/*  535 */     this.vertices.unbind(paramShaderProgram, paramArrayOfint1);
/*  536 */     if (this.instances != null && this.instances.getNumInstances() > 0) this.instances.unbind(paramShaderProgram, paramArrayOfint2); 
/*  537 */     if (this.indices.getNumIndices() > 0) this.indices.unbind();
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void render(ShaderProgram paramShaderProgram, int paramInt) {
/*  561 */     render(paramShaderProgram, paramInt, 0, (this.indices.getNumMaxIndices() > 0) ? getNumIndices() : getNumVertices(), this.autoBind);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void render(ShaderProgram paramShaderProgram, int paramInt1, int paramInt2, int paramInt3) {
/*  589 */     render(paramShaderProgram, paramInt1, paramInt2, paramInt3, this.autoBind);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void render(ShaderProgram paramShaderProgram, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
/*  618 */     if (paramInt3 == 0)
/*      */       return; 
/*  620 */     if (paramBoolean) bind(paramShaderProgram);
/*      */     
/*  622 */     if (this.isVertexArray) {
/*  623 */       if (this.indices.getNumIndices() > 0) {
/*      */         ShortBuffer shortBuffer;
/*  625 */         int i = (shortBuffer = this.indices.getBuffer(false)).position();
/*  626 */         shortBuffer.limit();
/*  627 */         shortBuffer.position(paramInt2);
/*  628 */         Gdx.gl20.glDrawElements(paramInt1, paramInt3, 5123, shortBuffer);
/*  629 */         shortBuffer.position(i);
/*      */       } else {
/*  631 */         Gdx.gl20.glDrawArrays(paramInt1, paramInt2, paramInt3);
/*      */       } 
/*      */     } else {
/*  634 */       int i = 0;
/*  635 */       if (this.isInstanced) i = this.instances.getNumInstances();
/*      */       
/*  637 */       if (this.indices.getNumIndices() > 0) {
/*  638 */         if (paramInt3 + paramInt2 > this.indices.getNumMaxIndices()) {
/*  639 */           throw new GdxRuntimeException("Mesh attempting to access memory outside of the index buffer (count: " + paramInt3 + ", offset: " + paramInt2 + ", max: " + this.indices
/*  640 */               .getNumMaxIndices() + ")");
/*      */         }
/*      */         
/*  643 */         if (this.isInstanced && i > 0) {
/*  644 */           Gdx.gl30.glDrawElementsInstanced(paramInt1, paramInt3, 5123, paramInt2 << 1, i);
/*      */         } else {
/*  646 */           Gdx.gl20.glDrawElements(paramInt1, paramInt3, 5123, paramInt2 << 1);
/*      */         }
/*      */       
/*  649 */       } else if (this.isInstanced && i > 0) {
/*  650 */         Gdx.gl30.glDrawArraysInstanced(paramInt1, paramInt2, paramInt3, i);
/*      */       } else {
/*  652 */         Gdx.gl20.glDrawArrays(paramInt1, paramInt2, paramInt3);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  657 */     if (paramBoolean) unbind(paramShaderProgram);
/*      */   
/*      */   }
/*      */   
/*      */   public void dispose() {
/*  662 */     if (meshes.get(Gdx.app) != null) ((Array)meshes.get(Gdx.app)).removeValue(this, true); 
/*  663 */     this.vertices.dispose();
/*  664 */     if (this.instances != null) this.instances.dispose(); 
/*  665 */     this.indices.dispose();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VertexAttribute getVertexAttribute(int paramInt) {
/*      */     VertexAttributes vertexAttributes;
/*  674 */     int i = (vertexAttributes = this.vertices.getAttributes()).size();
/*  675 */     for (byte b = 0; b < i; b++) {
/*  676 */       if ((vertexAttributes.get(b)).usage == paramInt) return vertexAttributes.get(b); 
/*      */     } 
/*  678 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public VertexAttributes getVertexAttributes() {
/*  683 */     return this.vertices.getAttributes();
/*      */   }
/*      */ 
/*      */   
/*      */   public VertexAttributes getInstancedAttributes() {
/*  688 */     return (this.instances != null) ? this.instances.getAttributes() : null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public FloatBuffer getVerticesBuffer() {
/*  695 */     return this.vertices.getBuffer(true);
/*      */   }
/*      */   
/*      */   public FloatBuffer getVerticesBuffer(boolean paramBoolean) {
/*  699 */     return this.vertices.getBuffer(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoundingBox calculateBoundingBox() {
/*  707 */     BoundingBox boundingBox = new BoundingBox();
/*  708 */     calculateBoundingBox(boundingBox);
/*  709 */     return boundingBox;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void calculateBoundingBox(BoundingBox paramBoundingBox) {
/*      */     byte b;
/*      */     int i;
/*  718 */     if ((i = getNumVertices()) == 0) throw new GdxRuntimeException("No vertices defined");
/*      */     
/*  720 */     FloatBuffer floatBuffer = this.vertices.getBuffer(false);
/*  721 */     paramBoundingBox.inf();
/*      */     VertexAttribute vertexAttribute;
/*  723 */     int j = (vertexAttribute = getVertexAttribute(1)).offset / 4;
/*  724 */     int k = (this.vertices.getAttributes()).vertexSize / 4;
/*  725 */     j = j;
/*      */     
/*  727 */     switch (vertexAttribute.numComponents) {
/*      */       case 1:
/*  729 */         for (b = 0; b < i; b++) {
/*  730 */           paramBoundingBox.ext(floatBuffer.get(j), 0.0F, 0.0F);
/*  731 */           j += k;
/*      */         } 
/*      */         return;
/*      */       case 2:
/*  735 */         for (b = 0; b < i; b++) {
/*  736 */           paramBoundingBox.ext(floatBuffer.get(j), floatBuffer.get(j + 1), 0.0F);
/*  737 */           j += k;
/*      */         } 
/*      */         return;
/*      */       case 3:
/*  741 */         for (b = 0; b < i; b++) {
/*  742 */           paramBoundingBox.ext(floatBuffer.get(j), floatBuffer.get(j + 1), floatBuffer.get(j + 2));
/*  743 */           j += k;
/*      */         } 
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoundingBox calculateBoundingBox(BoundingBox paramBoundingBox, int paramInt1, int paramInt2) {
/*  755 */     return extendBoundingBox(paramBoundingBox.inf(), paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoundingBox calculateBoundingBox(BoundingBox paramBoundingBox, int paramInt1, int paramInt2, Matrix4 paramMatrix4) {
/*  764 */     return extendBoundingBox(paramBoundingBox.inf(), paramInt1, paramInt2, paramMatrix4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoundingBox extendBoundingBox(BoundingBox paramBoundingBox, int paramInt1, int paramInt2) {
/*  773 */     return extendBoundingBox(paramBoundingBox, paramInt1, paramInt2, null);
/*      */   }
/*      */   
/*  776 */   protected Mesh(VertexData paramVertexData, IndexData paramIndexData, boolean paramBoolean) { this.tmpV = new Vector3(); this.vertices = paramVertexData; this.indices = paramIndexData; this.isVertexArray = paramBoolean; addManagedMesh(Gdx.app, this); } public Mesh(boolean paramBoolean, int paramInt1, int paramInt2, VertexAttribute... paramVarArgs) { this.tmpV = new Vector3(); this.vertices = makeVertexBuffer(paramBoolean, paramInt1, new VertexAttributes(paramVarArgs)); this.indices = (IndexData)new IndexBufferObject(paramBoolean, paramInt2); this.isVertexArray = false; addManagedMesh(Gdx.app, this); } public Mesh(boolean paramBoolean, int paramInt1, int paramInt2, VertexAttributes paramVertexAttributes) { this.tmpV = new Vector3(); this.vertices = makeVertexBuffer(paramBoolean, paramInt1, paramVertexAttributes); this.indices = (IndexData)new IndexBufferObject(paramBoolean, paramInt2); this.isVertexArray = false; addManagedMesh(Gdx.app, this); } public Mesh(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, VertexAttributes paramVertexAttributes) { this.tmpV = new Vector3(); this.vertices = makeVertexBuffer(paramBoolean1, paramInt1, paramVertexAttributes); this.indices = (IndexData)new IndexBufferObject(paramBoolean2, paramInt2); this.isVertexArray = false; addManagedMesh(Gdx.app, this); } public Mesh(VertexDataType paramVertexDataType, boolean paramBoolean, int paramInt1, int paramInt2, VertexAttributes paramVertexAttributes) { this.tmpV = new Vector3(); switch (paramVertexDataType) { case VertexBufferObject:
/*      */         this.vertices = (VertexData)new VertexBufferObject(paramBoolean, paramInt1, paramVertexAttributes); this.indices = (IndexData)new IndexBufferObject(paramBoolean, paramInt2); this.isVertexArray = false; break;
/*      */       case VertexBufferObjectSubData:
/*      */         this.vertices = (VertexData)new VertexBufferObjectSubData(paramBoolean, paramInt1, paramVertexAttributes); this.indices = (IndexData)new IndexBufferObjectSubData(paramBoolean, paramInt2); this.isVertexArray = false; break;
/*      */       case VertexBufferObjectWithVAO:
/*      */         this.vertices = (VertexData)new VertexBufferObjectWithVAO(paramBoolean, paramInt1, paramVertexAttributes); this.indices = (IndexData)new IndexBufferObjectSubData(paramBoolean, paramInt2); this.isVertexArray = false; break;
/*      */       default:
/*      */         this.vertices = (VertexData)new VertexArray(paramInt1, paramVertexAttributes); this.indices = (IndexData)new IndexArray(paramInt2); this.isVertexArray = true; break; }
/*  784 */      addManagedMesh(Gdx.app, this); } public BoundingBox extendBoundingBox(BoundingBox paramBoundingBox, int paramInt1, int paramInt2, Matrix4 paramMatrix4) { int i = getNumIndices();
/*  785 */     int j = getNumVertices();
/*  786 */     j = (i == 0) ? j : i;
/*  787 */     if (paramInt1 < 0 || paramInt2 <= 0 || paramInt1 + paramInt2 > j) {
/*  788 */       throw new GdxRuntimeException("Invalid part specified ( offset=" + paramInt1 + ", count=" + paramInt2 + ", max=" + j + " )");
/*      */     }
/*  790 */     FloatBuffer floatBuffer = this.vertices.getBuffer(false);
/*  791 */     ShortBuffer shortBuffer = this.indices.getBuffer(false);
/*      */     VertexAttribute vertexAttribute;
/*  793 */     int k = (vertexAttribute = getVertexAttribute(1)).offset / 4;
/*  794 */     int m = (this.vertices.getAttributes()).vertexSize / 4;
/*  795 */     paramInt2 = paramInt1 + paramInt2;
/*      */     
/*  797 */     switch (vertexAttribute.numComponents) {
/*      */       case 1:
/*  799 */         if (i > 0) {
/*  800 */           for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*  801 */             i = (shortBuffer.get(paramInt1) & 0xFFFF) * m + k;
/*  802 */             this.tmpV.set(floatBuffer.get(i), 0.0F, 0.0F);
/*  803 */             if (paramMatrix4 != null) this.tmpV.mul(paramMatrix4); 
/*  804 */             paramBoundingBox.ext(this.tmpV);
/*      */           }  break;
/*      */         } 
/*  807 */         for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*  808 */           i = paramInt1 * m + k;
/*  809 */           this.tmpV.set(floatBuffer.get(i), 0.0F, 0.0F);
/*  810 */           if (paramMatrix4 != null) this.tmpV.mul(paramMatrix4); 
/*  811 */           paramBoundingBox.ext(this.tmpV);
/*      */         } 
/*      */         break;
/*      */       
/*      */       case 2:
/*  816 */         if (i > 0) {
/*  817 */           for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*  818 */             i = (shortBuffer.get(paramInt1) & 0xFFFF) * m + k;
/*  819 */             this.tmpV.set(floatBuffer.get(i), floatBuffer.get(i + 1), 0.0F);
/*  820 */             if (paramMatrix4 != null) this.tmpV.mul(paramMatrix4); 
/*  821 */             paramBoundingBox.ext(this.tmpV);
/*      */           }  break;
/*      */         } 
/*  824 */         for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*  825 */           i = paramInt1 * m + k;
/*  826 */           this.tmpV.set(floatBuffer.get(i), floatBuffer.get(i + 1), 0.0F);
/*  827 */           if (paramMatrix4 != null) this.tmpV.mul(paramMatrix4); 
/*  828 */           paramBoundingBox.ext(this.tmpV);
/*      */         } 
/*      */         break;
/*      */       
/*      */       case 3:
/*  833 */         if (i > 0) {
/*  834 */           for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*  835 */             i = (shortBuffer.get(paramInt1) & 0xFFFF) * m + k;
/*  836 */             this.tmpV.set(floatBuffer.get(i), floatBuffer.get(i + 1), floatBuffer.get(i + 2));
/*  837 */             if (paramMatrix4 != null) this.tmpV.mul(paramMatrix4); 
/*  838 */             paramBoundingBox.ext(this.tmpV);
/*      */           }  break;
/*      */         } 
/*  841 */         for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*  842 */           i = paramInt1 * m + k;
/*  843 */           this.tmpV.set(floatBuffer.get(i), floatBuffer.get(i + 1), floatBuffer.get(i + 2));
/*  844 */           if (paramMatrix4 != null) this.tmpV.mul(paramMatrix4); 
/*  845 */           paramBoundingBox.ext(this.tmpV);
/*      */         } 
/*      */         break;
/*      */     } 
/*      */     
/*  850 */     return paramBoundingBox; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float calculateRadiusSquared(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Matrix4 paramMatrix4) {
/*  862 */     int i = getNumIndices();
/*  863 */     if (paramInt1 < 0 || paramInt2 <= 0 || paramInt1 + paramInt2 > i) throw new GdxRuntimeException("Not enough indices");
/*      */     
/*  865 */     FloatBuffer floatBuffer = this.vertices.getBuffer(false);
/*  866 */     ShortBuffer shortBuffer = this.indices.getBuffer(false);
/*      */     VertexAttribute vertexAttribute;
/*  868 */     int j = (vertexAttribute = getVertexAttribute(1)).offset / 4;
/*  869 */     int k = (this.vertices.getAttributes()).vertexSize / 4;
/*  870 */     paramInt2 = paramInt1 + paramInt2;
/*      */     
/*  872 */     float f = 0.0F;
/*      */     
/*  874 */     switch (vertexAttribute.numComponents) {
/*      */       case 1:
/*  876 */         for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*  877 */           int m = (shortBuffer.get(paramInt1) & 0xFFFF) * k + j;
/*  878 */           this.tmpV.set(floatBuffer.get(m), 0.0F, 0.0F);
/*  879 */           if (paramMatrix4 != null) this.tmpV.mul(paramMatrix4); 
/*      */           float f1;
/*  881 */           if ((f1 = this.tmpV.sub(paramFloat1, paramFloat2, paramFloat3).len2()) > f) f = f1; 
/*      */         } 
/*      */         break;
/*      */       case 2:
/*  885 */         for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*  886 */           int m = (shortBuffer.get(paramInt1) & 0xFFFF) * k + j;
/*  887 */           this.tmpV.set(floatBuffer.get(m), floatBuffer.get(m + 1), 0.0F);
/*  888 */           if (paramMatrix4 != null) this.tmpV.mul(paramMatrix4); 
/*      */           float f1;
/*  890 */           if ((f1 = this.tmpV.sub(paramFloat1, paramFloat2, paramFloat3).len2()) > f) f = f1; 
/*      */         } 
/*      */         break;
/*      */       case 3:
/*  894 */         for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*  895 */           int m = (shortBuffer.get(paramInt1) & 0xFFFF) * k + j;
/*  896 */           this.tmpV.set(floatBuffer.get(m), floatBuffer.get(m + 1), floatBuffer.get(m + 2));
/*  897 */           if (paramMatrix4 != null) this.tmpV.mul(paramMatrix4); 
/*      */           float f1;
/*  899 */           if ((f1 = this.tmpV.sub(paramFloat1, paramFloat2, paramFloat3).len2()) > f) f = f1; 
/*      */         } 
/*      */         break;
/*      */     } 
/*  903 */     return f;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float calculateRadius(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Matrix4 paramMatrix4) {
/*  915 */     return (float)Math.sqrt(calculateRadiusSquared(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, paramMatrix4));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float calculateRadius(Vector3 paramVector3, int paramInt1, int paramInt2, Matrix4 paramMatrix4) {
/*  924 */     return calculateRadius(paramVector3.x, paramVector3.y, paramVector3.z, paramInt1, paramInt2, paramMatrix4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float calculateRadius(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2) {
/*  935 */     return calculateRadius(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float calculateRadius(Vector3 paramVector3, int paramInt1, int paramInt2) {
/*  944 */     return calculateRadius(paramVector3.x, paramVector3.y, paramVector3.z, paramInt1, paramInt2, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float calculateRadius(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  953 */     return calculateRadius(paramFloat1, paramFloat2, paramFloat3, 0, getNumIndices(), null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float calculateRadius(Vector3 paramVector3) {
/*  960 */     return calculateRadius(paramVector3.x, paramVector3.y, paramVector3.z, 0, getNumIndices(), null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public ShortBuffer getIndicesBuffer() {
/*  967 */     return this.indices.getBuffer(true);
/*      */   }
/*      */   
/*      */   public ShortBuffer getIndicesBuffer(boolean paramBoolean) {
/*  971 */     return this.indices.getBuffer(paramBoolean);
/*      */   }
/*      */   
/*      */   private static void addManagedMesh(Application paramApplication, Mesh paramMesh) {
/*      */     Array<Mesh> array;
/*  976 */     if ((array = meshes.get(paramApplication)) == null) array = new Array(); 
/*  977 */     array.add(paramMesh);
/*  978 */     meshes.put(paramApplication, array);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void invalidateAllMeshes(Application paramApplication) {
/*      */     Array array;
/*  985 */     if ((array = meshes.get(paramApplication)) == null)
/*  986 */       return;  for (byte b = 0; b < array.size; b++) {
/*  987 */       ((Mesh)array.get(b)).vertices.invalidate();
/*  988 */       ((Mesh)array.get(b)).indices.invalidate();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void clearAllMeshes(Application paramApplication) {
/*  994 */     meshes.remove(paramApplication);
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getManagedStatus() {
/*      */     StringBuilder stringBuilder;
/* 1000 */     (stringBuilder = new StringBuilder()).append("Managed meshes/app: { ");
/* 1001 */     for (Application application : meshes.keySet()) {
/* 1002 */       stringBuilder.append(((Array)meshes.get(application)).size);
/* 1003 */       stringBuilder.append(" ");
/*      */     } 
/* 1005 */     stringBuilder.append("}");
/* 1006 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void scale(float paramFloat1, float paramFloat2, float paramFloat3) {
/*      */     VertexAttribute vertexAttribute;
/* 1017 */     int j = (vertexAttribute = getVertexAttribute(1)).offset / 4;
/* 1018 */     int i = vertexAttribute.numComponents;
/* 1019 */     int k = getNumVertices();
/* 1020 */     int m = getVertexSize() / 4;
/*      */     
/* 1022 */     float[] arrayOfFloat = new float[k * m];
/* 1023 */     getVertices(arrayOfFloat);
/*      */     
/* 1025 */     j = j;
/* 1026 */     switch (i) {
/*      */       case 1:
/* 1028 */         for (i = 0; i < k; i++) {
/* 1029 */           arrayOfFloat[j] = arrayOfFloat[j] * paramFloat1;
/* 1030 */           j += m;
/*      */         } 
/*      */         break;
/*      */       case 2:
/* 1034 */         for (i = 0; i < k; i++) {
/* 1035 */           arrayOfFloat[j] = arrayOfFloat[j] * paramFloat1;
/* 1036 */           arrayOfFloat[j + 1] = arrayOfFloat[j + 1] * paramFloat2;
/* 1037 */           j += m;
/*      */         } 
/*      */         break;
/*      */       case 3:
/* 1041 */         for (i = 0; i < k; i++) {
/* 1042 */           arrayOfFloat[j] = arrayOfFloat[j] * paramFloat1;
/* 1043 */           arrayOfFloat[j + 1] = arrayOfFloat[j + 1] * paramFloat2;
/* 1044 */           arrayOfFloat[j + 2] = arrayOfFloat[j + 2] * paramFloat3;
/* 1045 */           j += m;
/*      */         } 
/*      */         break;
/*      */     } 
/*      */     
/* 1050 */     setVertices(arrayOfFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void transform(Matrix4 paramMatrix4) {
/* 1058 */     transform(paramMatrix4, 0, getNumVertices());
/*      */   }
/*      */ 
/*      */   
/*      */   public void transform(Matrix4 paramMatrix4, int paramInt1, int paramInt2) {
/*      */     VertexAttribute vertexAttribute;
/* 1064 */     int j = (vertexAttribute = getVertexAttribute(1)).offset / 4;
/* 1065 */     int k = getVertexSize() / 4;
/* 1066 */     int i = vertexAttribute.numComponents;
/* 1067 */     getNumVertices();
/*      */     
/* 1069 */     float[] arrayOfFloat = new float[paramInt2 * k];
/* 1070 */     getVertices(paramInt1 * k, paramInt2 * k, arrayOfFloat);
/*      */     
/* 1072 */     transform(paramMatrix4, arrayOfFloat, k, j, i, 0, paramInt2);
/*      */     
/* 1074 */     updateVertices(paramInt1 * k, arrayOfFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void transform(Matrix4 paramMatrix4, float[] paramArrayOffloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 1088 */     if (paramInt2 < 0 || paramInt3 <= 0 || paramInt2 + paramInt3 > paramInt1) throw new IndexOutOfBoundsException(); 
/* 1089 */     if (paramInt4 < 0 || paramInt5 <= 0 || (paramInt4 + paramInt5) * paramInt1 > paramArrayOffloat.length) throw new IndexOutOfBoundsException("start = " + paramInt4 + ", count = " + paramInt5 + ", vertexSize = " + paramInt1 + ", length = " + paramArrayOffloat.length);
/*      */ 
/*      */     
/* 1092 */     Vector3 vector3 = new Vector3();
/*      */     
/* 1094 */     paramInt2 += paramInt4 * paramInt1;
/* 1095 */     switch (paramInt3) {
/*      */       case 1:
/* 1097 */         for (paramInt3 = 0; paramInt3 < paramInt5; paramInt3++) {
/* 1098 */           vector3.set(paramArrayOffloat[paramInt2], 0.0F, 0.0F).mul(paramMatrix4);
/* 1099 */           paramArrayOffloat[paramInt2] = vector3.x;
/* 1100 */           paramInt2 += paramInt1;
/*      */         } 
/*      */         return;
/*      */       case 2:
/* 1104 */         for (paramInt3 = 0; paramInt3 < paramInt5; paramInt3++) {
/* 1105 */           vector3.set(paramArrayOffloat[paramInt2], paramArrayOffloat[paramInt2 + 1], 0.0F).mul(paramMatrix4);
/* 1106 */           paramArrayOffloat[paramInt2] = vector3.x;
/* 1107 */           paramArrayOffloat[paramInt2 + 1] = vector3.y;
/* 1108 */           paramInt2 += paramInt1;
/*      */         } 
/*      */         return;
/*      */       case 3:
/* 1112 */         for (paramInt3 = 0; paramInt3 < paramInt5; paramInt3++) {
/* 1113 */           vector3.set(paramArrayOffloat[paramInt2], paramArrayOffloat[paramInt2 + 1], paramArrayOffloat[paramInt2 + 2]).mul(paramMatrix4);
/* 1114 */           paramArrayOffloat[paramInt2] = vector3.x;
/* 1115 */           paramArrayOffloat[paramInt2 + 1] = vector3.y;
/* 1116 */           paramArrayOffloat[paramInt2 + 2] = vector3.z;
/* 1117 */           paramInt2 += paramInt1;
/*      */         } 
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void transformUV(Matrix3 paramMatrix3) {
/* 1128 */     transformUV(paramMatrix3, 0, getNumVertices());
/*      */   }
/*      */ 
/*      */   
/*      */   protected void transformUV(Matrix3 paramMatrix3, int paramInt1, int paramInt2) {
/*      */     VertexAttribute vertexAttribute;
/* 1134 */     int i = (vertexAttribute = getVertexAttribute(16)).offset / 4;
/* 1135 */     int j = getVertexSize() / 4;
/*      */     
/*      */     int k;
/* 1138 */     float[] arrayOfFloat = new float[(k = getNumVertices()) * j];
/*      */     
/* 1140 */     getVertices(0, arrayOfFloat.length, arrayOfFloat);
/* 1141 */     transformUV(paramMatrix3, arrayOfFloat, j, i, paramInt1, paramInt2);
/* 1142 */     setVertices(arrayOfFloat, 0, arrayOfFloat.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void transformUV(Matrix3 paramMatrix3, float[] paramArrayOffloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1155 */     if (paramInt3 < 0 || paramInt4 <= 0 || (paramInt3 + paramInt4) * paramInt1 > paramArrayOffloat.length) throw new IndexOutOfBoundsException("start = " + paramInt3 + ", count = " + paramInt4 + ", vertexSize = " + paramInt1 + ", length = " + paramArrayOffloat.length);
/*      */ 
/*      */     
/* 1158 */     Vector2 vector2 = new Vector2();
/*      */     
/* 1160 */     paramInt2 += paramInt3 * paramInt1;
/* 1161 */     for (paramInt3 = 0; paramInt3 < paramInt4; paramInt3++) {
/* 1162 */       vector2.set(paramArrayOffloat[paramInt2], paramArrayOffloat[paramInt2 + 1]).mul(paramMatrix3);
/* 1163 */       paramArrayOffloat[paramInt2] = vector2.x;
/* 1164 */       paramArrayOffloat[paramInt2 + 1] = vector2.y;
/* 1165 */       paramInt2 += paramInt1;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Mesh copy(boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfint) {
/*      */     Mesh mesh;
/* 1178 */     int i = getVertexSize() / 4;
/*      */     int j;
/* 1180 */     float[] arrayOfFloat = new float[(j = getNumVertices()) * i];
/* 1181 */     getVertices(0, arrayOfFloat.length, arrayOfFloat);
/* 1182 */     short[] arrayOfShort1 = null;
/* 1183 */     VertexAttribute[] arrayOfVertexAttribute = null;
/* 1184 */     int k = 0;
/* 1185 */     if (paramArrayOfint != null) {
/* 1186 */       int n = 0;
/* 1187 */       byte b = 0; byte b1;
/* 1188 */       for (b1 = 0; b1 < paramArrayOfint.length; b1++) {
/* 1189 */         if (getVertexAttribute(paramArrayOfint[b1]) != null) {
/* 1190 */           n += (getVertexAttribute(paramArrayOfint[b1])).numComponents;
/* 1191 */           b++;
/*      */         } 
/* 1193 */       }  if (n > 0) {
/* 1194 */         arrayOfVertexAttribute = new VertexAttribute[b];
/* 1195 */         arrayOfShort1 = new short[n];
/* 1196 */         b1 = -1;
/* 1197 */         byte b2 = -1;
/* 1198 */         for (byte b3 = 0; b3 < paramArrayOfint.length; b3++) {
/*      */           VertexAttribute vertexAttribute;
/* 1200 */           if ((vertexAttribute = getVertexAttribute(paramArrayOfint[b3])) != null) {
/* 1201 */             for (byte b4 = 0; b4 < vertexAttribute.numComponents; b4++)
/* 1202 */               arrayOfShort1[++b1] = (short)(vertexAttribute.offset + b4); 
/* 1203 */             arrayOfVertexAttribute[++b2] = vertexAttribute.copy();
/* 1204 */             k += vertexAttribute.numComponents;
/*      */           } 
/*      */         } 
/*      */       } 
/* 1208 */     }  if (arrayOfShort1 == null) {
/* 1209 */       arrayOfShort1 = new short[i]; short s;
/* 1210 */       for (s = 0; s < i; s = (short)(s + 1))
/* 1211 */         arrayOfShort1[s] = s; 
/* 1212 */       k = i;
/*      */     } 
/*      */     
/* 1215 */     int m = getNumIndices();
/* 1216 */     short[] arrayOfShort2 = null;
/* 1217 */     if (m > 0) {
/* 1218 */       arrayOfShort2 = new short[m];
/* 1219 */       getIndices(arrayOfShort2);
/* 1220 */       if (paramBoolean2 || k != i) {
/* 1221 */         float[] arrayOfFloat1 = new float[arrayOfFloat.length];
/* 1222 */         byte b1 = 0;
/* 1223 */         for (byte b2 = 0; b2 < m; b2++) {
/* 1224 */           int n = arrayOfShort2[b2] * i;
/* 1225 */           short s = -1;
/* 1226 */           if (paramBoolean2)
/* 1227 */             for (short s1 = 0; s1 < b1 && s < 0; s1 = (short)(s1 + 1)) {
/* 1228 */               j = s1 * k;
/* 1229 */               boolean bool = true;
/* 1230 */               for (byte b = 0; b < arrayOfShort1.length && bool; b++) {
/* 1231 */                 if (arrayOfFloat1[j + b] != arrayOfFloat[n + arrayOfShort1[b]]) bool = false; 
/*      */               } 
/* 1233 */               if (bool) s = s1;
/*      */             
/*      */             }  
/* 1236 */           if (s > 0) {
/* 1237 */             arrayOfShort2[b2] = s;
/*      */           } else {
/* 1239 */             int i1 = b1 * k;
/* 1240 */             for (j = 0; j < arrayOfShort1.length; j++)
/* 1241 */               arrayOfFloat1[i1 + j] = arrayOfFloat[n + arrayOfShort1[j]]; 
/* 1242 */             arrayOfShort2[b2] = (short)b1;
/* 1243 */             b1++;
/*      */           } 
/*      */         } 
/* 1246 */         arrayOfFloat = arrayOfFloat1;
/* 1247 */         j = b1;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1252 */     if (arrayOfVertexAttribute == null) {
/* 1253 */       mesh = new Mesh(paramBoolean1, j, (arrayOfShort2 == null) ? 0 : arrayOfShort2.length, getVertexAttributes());
/*      */     } else {
/* 1255 */       mesh = new Mesh(paramBoolean1, j, (arrayOfShort2 == null) ? 0 : arrayOfShort2.length, arrayOfVertexAttribute);
/* 1256 */     }  mesh.setVertices(arrayOfFloat, 0, j * k);
/* 1257 */     if (arrayOfShort2 != null) mesh.setIndices(arrayOfShort2); 
/* 1258 */     return mesh;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Mesh copy(boolean paramBoolean) {
/* 1265 */     return copy(paramBoolean, false, null);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\Mesh.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */