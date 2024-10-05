/*      */ package com.badlogic.gdx.graphics.g3d.utils;
/*      */ 
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.Mesh;
/*      */ import com.badlogic.gdx.graphics.VertexAttribute;
/*      */ import com.badlogic.gdx.graphics.VertexAttributes;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.graphics.g3d.model.MeshPart;
/*      */ import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.ArrowShapeBuilder;
/*      */ import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.BoxShapeBuilder;
/*      */ import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.CapsuleShapeBuilder;
/*      */ import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.ConeShapeBuilder;
/*      */ import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.CylinderShapeBuilder;
/*      */ import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.EllipseShapeBuilder;
/*      */ import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.PatchShapeBuilder;
/*      */ import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.SphereShapeBuilder;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.Matrix3;
/*      */ import com.badlogic.gdx.math.Matrix4;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.math.Vector3;
/*      */ import com.badlogic.gdx.math.collision.BoundingBox;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.FloatArray;
/*      */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*      */ import com.badlogic.gdx.utils.IntIntMap;
/*      */ import com.badlogic.gdx.utils.ShortArray;
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
/*      */ public class MeshBuilder
/*      */   implements MeshPartBuilder
/*      */ {
/*      */   public static final int MAX_VERTICES = 65536;
/*      */   public static final int MAX_INDEX = 65535;
/*   59 */   private static final ShortArray tmpIndices = new ShortArray();
/*   60 */   private static final FloatArray tmpVertices = new FloatArray();
/*      */   
/*   62 */   private final MeshPartBuilder.VertexInfo vertTmp1 = new MeshPartBuilder.VertexInfo();
/*   63 */   private final MeshPartBuilder.VertexInfo vertTmp2 = new MeshPartBuilder.VertexInfo();
/*   64 */   private final MeshPartBuilder.VertexInfo vertTmp3 = new MeshPartBuilder.VertexInfo();
/*   65 */   private final MeshPartBuilder.VertexInfo vertTmp4 = new MeshPartBuilder.VertexInfo();
/*      */   
/*   67 */   private final Color tempC1 = new Color();
/*      */ 
/*      */   
/*      */   private VertexAttributes attributes;
/*      */   
/*   72 */   private FloatArray vertices = new FloatArray();
/*      */   
/*   74 */   private ShortArray indices = new ShortArray();
/*      */   
/*      */   private int stride;
/*      */   
/*      */   private int vindex;
/*      */   
/*      */   private int istart;
/*      */   
/*      */   private int posOffset;
/*      */   
/*      */   private int posSize;
/*      */   
/*      */   private int norOffset;
/*      */   
/*      */   private int biNorOffset;
/*      */   
/*      */   private int tangentOffset;
/*      */   
/*      */   private int colOffset;
/*      */   
/*      */   private int colSize;
/*      */   
/*      */   private int cpOffset;
/*      */   
/*      */   private int uvOffset;
/*      */   
/*      */   private MeshPart part;
/*      */   
/*  102 */   private Array<MeshPart> parts = new Array();
/*      */   
/*  104 */   private final Color color = new Color(Color.WHITE);
/*      */   
/*      */   private boolean hasColor = false;
/*      */   
/*      */   private int primitiveType;
/*  109 */   private float uOffset = 0.0F; private float uScale = 1.0F; private float vOffset = 0.0F; private float vScale = 1.0F;
/*      */   
/*      */   private boolean hasUVTransform = false;
/*      */   private float[] vertex;
/*      */   private boolean vertexTransformationEnabled = false;
/*  114 */   private final Matrix4 positionTransform = new Matrix4();
/*  115 */   private final Matrix3 normalTransform = new Matrix3();
/*  116 */   private final BoundingBox bounds = new BoundingBox();
/*      */ 
/*      */ 
/*      */   
/*      */   public static VertexAttributes createAttributes(long paramLong) {
/*  121 */     Array array = new Array();
/*  122 */     if ((paramLong & 0x1L) == 1L)
/*  123 */       array.add(new VertexAttribute(1, 3, "a_position")); 
/*  124 */     if ((paramLong & 0x2L) == 2L)
/*  125 */       array.add(new VertexAttribute(2, 4, "a_color")); 
/*  126 */     if ((paramLong & 0x4L) == 4L)
/*  127 */       array.add(new VertexAttribute(4, 4, "a_color")); 
/*  128 */     if ((paramLong & 0x8L) == 8L) array.add(new VertexAttribute(8, 3, "a_normal")); 
/*  129 */     if ((paramLong & 0x10L) == 16L)
/*  130 */       array.add(new VertexAttribute(16, 2, "a_texCoord0")); 
/*  131 */     VertexAttribute[] arrayOfVertexAttribute = new VertexAttribute[array.size];
/*  132 */     for (byte b = 0; b < arrayOfVertexAttribute.length; b++)
/*  133 */       arrayOfVertexAttribute[b] = (VertexAttribute)array.get(b); 
/*  134 */     return new VertexAttributes(arrayOfVertexAttribute);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void begin(long paramLong) {
/*  141 */     begin(createAttributes(paramLong), -1);
/*      */   }
/*      */ 
/*      */   
/*      */   public void begin(VertexAttributes paramVertexAttributes) {
/*  146 */     begin(paramVertexAttributes, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void begin(long paramLong, int paramInt) {
/*  153 */     begin(createAttributes(paramLong), paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public void begin(VertexAttributes paramVertexAttributes, int paramInt) {
/*  158 */     if (this.attributes != null) throw new RuntimeException("Call end() first"); 
/*  159 */     this.attributes = paramVertexAttributes;
/*  160 */     this.vertices.clear();
/*  161 */     this.indices.clear();
/*  162 */     this.parts.clear();
/*  163 */     this.vindex = 0;
/*  164 */     this.lastIndex = -1;
/*  165 */     this.istart = 0;
/*  166 */     this.part = null;
/*  167 */     this.stride = paramVertexAttributes.vertexSize / 4;
/*  168 */     if (this.vertex == null || this.vertex.length < this.stride) this.vertex = new float[this.stride]; 
/*      */     VertexAttribute vertexAttribute;
/*  170 */     if ((vertexAttribute = paramVertexAttributes.findByUsage(1)) == null) throw new GdxRuntimeException("Cannot build mesh without position attribute"); 
/*  171 */     this.posOffset = vertexAttribute.offset / 4;
/*  172 */     this.posSize = vertexAttribute.numComponents;
/*  173 */     vertexAttribute = paramVertexAttributes.findByUsage(8);
/*  174 */     this.norOffset = (vertexAttribute == null) ? -1 : (vertexAttribute.offset / 4);
/*  175 */     vertexAttribute = paramVertexAttributes.findByUsage(256);
/*  176 */     this.biNorOffset = (vertexAttribute == null) ? -1 : (vertexAttribute.offset / 4);
/*  177 */     vertexAttribute = paramVertexAttributes.findByUsage(128);
/*  178 */     this.tangentOffset = (vertexAttribute == null) ? -1 : (vertexAttribute.offset / 4);
/*  179 */     vertexAttribute = paramVertexAttributes.findByUsage(2);
/*  180 */     this.colOffset = (vertexAttribute == null) ? -1 : (vertexAttribute.offset / 4);
/*  181 */     this.colSize = (vertexAttribute == null) ? 0 : vertexAttribute.numComponents;
/*  182 */     vertexAttribute = paramVertexAttributes.findByUsage(4);
/*  183 */     this.cpOffset = (vertexAttribute == null) ? -1 : (vertexAttribute.offset / 4);
/*  184 */     vertexAttribute = paramVertexAttributes.findByUsage(16);
/*  185 */     this.uvOffset = (vertexAttribute == null) ? -1 : (vertexAttribute.offset / 4);
/*  186 */     setColor(null);
/*  187 */     setVertexTransform(null);
/*  188 */     setUVRange(null);
/*  189 */     this.primitiveType = paramInt;
/*  190 */     this.bounds.inf();
/*      */   }
/*      */   
/*      */   private void endpart() {
/*  194 */     if (this.part != null) {
/*  195 */       this.bounds.getCenter(this.part.center);
/*  196 */       this.bounds.getDimensions(this.part.halfExtents).scl(0.5F);
/*  197 */       this.part.radius = this.part.halfExtents.len();
/*  198 */       this.bounds.inf();
/*  199 */       this.part.offset = this.istart;
/*  200 */       this.part.size = this.indices.size - this.istart;
/*  201 */       this.istart = this.indices.size;
/*  202 */       this.part = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MeshPart part(String paramString, int paramInt) {
/*  210 */     return part(paramString, paramInt, new MeshPart());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MeshPart part(String paramString, int paramInt, MeshPart paramMeshPart) {
/*  219 */     if (this.attributes == null) throw new RuntimeException("Call begin() first"); 
/*  220 */     endpart();
/*      */     
/*  222 */     this.part = paramMeshPart;
/*  223 */     this.part.id = paramString;
/*  224 */     this.primitiveType = this.part.primitiveType = paramInt;
/*  225 */     this.parts.add(this.part);
/*      */     
/*  227 */     setColor(null);
/*  228 */     setVertexTransform(null);
/*  229 */     setUVRange(null);
/*      */     
/*  231 */     return this.part;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Mesh end(Mesh paramMesh) {
/*  238 */     endpart();
/*      */     
/*  240 */     if (this.attributes == null) throw new GdxRuntimeException("Call begin() first"); 
/*  241 */     if (!this.attributes.equals(paramMesh.getVertexAttributes())) throw new GdxRuntimeException("Mesh attributes don't match"); 
/*  242 */     if (paramMesh.getMaxVertices() * this.stride < this.vertices.size) throw new GdxRuntimeException("Mesh can't hold enough vertices: " + paramMesh
/*  243 */           .getMaxVertices() + " * " + this.stride + " < " + this.vertices.size); 
/*  244 */     if (paramMesh.getMaxIndices() < this.indices.size) {
/*  245 */       throw new GdxRuntimeException("Mesh can't hold enough indices: " + paramMesh.getMaxIndices() + " < " + this.indices.size);
/*      */     }
/*  247 */     paramMesh.setVertices(this.vertices.items, 0, this.vertices.size);
/*  248 */     paramMesh.setIndices(this.indices.items, 0, this.indices.size);
/*      */     
/*  250 */     for (Array.ArrayIterator<MeshPart> arrayIterator = this.parts.iterator(); arrayIterator.hasNext();)
/*  251 */       (meshPart = arrayIterator.next()).mesh = paramMesh; 
/*  252 */     this.parts.clear();
/*      */     
/*  254 */     this.attributes = null;
/*  255 */     this.vertices.clear();
/*  256 */     this.indices.clear();
/*      */     
/*  258 */     return paramMesh;
/*      */   }
/*      */ 
/*      */   
/*      */   public Mesh end() {
/*  263 */     return end(new Mesh(true, Math.min(this.vertices.size / this.stride, 65536), this.indices.size, this.attributes));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clear() {
/*  270 */     this.vertices.clear();
/*  271 */     this.indices.clear();
/*  272 */     this.parts.clear();
/*  273 */     this.vindex = 0;
/*  274 */     this.lastIndex = -1;
/*  275 */     this.istart = 0;
/*  276 */     this.part = null;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getFloatsPerVertex() {
/*  281 */     return this.stride;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getNumVertices() {
/*  286 */     return this.vertices.size / this.stride;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void getVertices(float[] paramArrayOffloat, int paramInt) {
/*  294 */     if (this.attributes == null) throw new GdxRuntimeException("Must be called in between #begin and #end"); 
/*  295 */     if (paramInt < 0 || paramInt > paramArrayOffloat.length - this.vertices.size)
/*  296 */       throw new GdxRuntimeException("Array too small or offset out of range"); 
/*  297 */     System.arraycopy(this.vertices.items, 0, paramArrayOffloat, paramInt, this.vertices.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float[] getVertices() {
/*  304 */     return this.vertices.items;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getNumIndices() {
/*  309 */     return this.indices.size;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void getIndices(short[] paramArrayOfshort, int paramInt) {
/*  317 */     if (this.attributes == null) throw new GdxRuntimeException("Must be called in between #begin and #end"); 
/*  318 */     if (paramInt < 0 || paramInt > paramArrayOfshort.length - this.indices.size)
/*  319 */       throw new GdxRuntimeException("Array too small or offset out of range"); 
/*  320 */     System.arraycopy(this.indices.items, 0, paramArrayOfshort, paramInt, this.indices.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected short[] getIndices() {
/*  327 */     return this.indices.items;
/*      */   }
/*      */ 
/*      */   
/*      */   public VertexAttributes getAttributes() {
/*  332 */     return this.attributes;
/*      */   }
/*      */ 
/*      */   
/*      */   public MeshPart getMeshPart() {
/*  337 */     return this.part;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getPrimitiveType() {
/*  342 */     return this.primitiveType;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  347 */     this.color.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*  348 */     this.hasColor = !this.color.equals(Color.WHITE);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setColor(Color paramColor) {
/*  353 */     this.color.set(!(this.hasColor = (paramColor != null)) ? Color.WHITE : paramColor);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setUVRange(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  358 */     this.uOffset = paramFloat1;
/*  359 */     this.vOffset = paramFloat2;
/*  360 */     this.uScale = paramFloat3 - paramFloat1;
/*  361 */     this.vScale = paramFloat4 - paramFloat2;
/*  362 */     this.hasUVTransform = (!MathUtils.isZero(paramFloat1) || !MathUtils.isZero(paramFloat2) || !MathUtils.isEqual(paramFloat3, 1.0F) || !MathUtils.isEqual(paramFloat4, 1.0F));
/*      */   }
/*      */ 
/*      */   
/*      */   public void setUVRange(TextureRegion paramTextureRegion) {
/*  367 */     if (paramTextureRegion == null) {
/*  368 */       this.hasUVTransform = false;
/*  369 */       this.uOffset = this.vOffset = 0.0F;
/*  370 */       this.uScale = this.vScale = 1.0F; return;
/*      */     } 
/*  372 */     this.hasUVTransform = true;
/*  373 */     setUVRange(paramTextureRegion.getU(), paramTextureRegion.getV(), paramTextureRegion.getU2(), paramTextureRegion.getV2());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 getVertexTransform(Matrix4 paramMatrix4) {
/*  379 */     return paramMatrix4.set(this.positionTransform);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setVertexTransform(Matrix4 paramMatrix4) {
/*  384 */     this.vertexTransformationEnabled = (paramMatrix4 != null);
/*  385 */     if (this.vertexTransformationEnabled) {
/*  386 */       this.positionTransform.set(paramMatrix4);
/*  387 */       this.normalTransform.set(paramMatrix4).inv().transpose(); return;
/*      */     } 
/*  389 */     this.positionTransform.idt();
/*  390 */     this.normalTransform.idt();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isVertexTransformationEnabled() {
/*  396 */     return this.vertexTransformationEnabled;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setVertexTransformationEnabled(boolean paramBoolean) {
/*  401 */     this.vertexTransformationEnabled = paramBoolean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void ensureVertices(int paramInt) {
/*  406 */     this.vertices.ensureCapacity(this.stride * paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public void ensureIndices(int paramInt) {
/*  411 */     this.indices.ensureCapacity(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public void ensureCapacity(int paramInt1, int paramInt2) {
/*  416 */     ensureVertices(paramInt1);
/*  417 */     ensureIndices(paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   public void ensureTriangleIndices(int paramInt) {
/*  422 */     if (this.primitiveType == 1) {
/*  423 */       ensureIndices(paramInt * 6); return;
/*  424 */     }  if (this.primitiveType == 4 || this.primitiveType == 0) {
/*  425 */       ensureIndices(3 * paramInt); return;
/*      */     } 
/*  427 */     throw new GdxRuntimeException("Incorrect primtive type");
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void ensureTriangles(int paramInt1, int paramInt2) {
/*  433 */     ensureVertices(paramInt1);
/*  434 */     ensureTriangleIndices(paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void ensureTriangles(int paramInt) {
/*  440 */     ensureVertices(3 * paramInt);
/*  441 */     ensureTriangleIndices(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public void ensureRectangleIndices(int paramInt) {
/*  446 */     if (this.primitiveType == 0) {
/*  447 */       ensureIndices(4 * paramInt); return;
/*  448 */     }  if (this.primitiveType == 1) {
/*  449 */       ensureIndices(paramInt * 8);
/*      */       return;
/*      */     } 
/*  452 */     ensureIndices(paramInt * 6);
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void ensureRectangles(int paramInt1, int paramInt2) {
/*  458 */     ensureVertices(paramInt1);
/*  459 */     ensureRectangleIndices(paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void ensureRectangles(int paramInt) {
/*  465 */     ensureVertices(4 * paramInt);
/*  466 */     ensureRectangleIndices(paramInt);
/*      */   }
/*      */   
/*  469 */   private int lastIndex = -1;
/*      */ 
/*      */   
/*      */   public int lastIndex() {
/*  473 */     return this.lastIndex;
/*      */   }
/*      */   
/*  476 */   private static final Vector3 vTmp = new Vector3();
/*      */   
/*      */   private static final void transformPosition(float[] paramArrayOffloat, int paramInt1, int paramInt2, Matrix4 paramMatrix4) {
/*  479 */     if (paramInt2 > 2) {
/*  480 */       vTmp.set(paramArrayOffloat[paramInt1], paramArrayOffloat[paramInt1 + 1], paramArrayOffloat[paramInt1 + 2]).mul(paramMatrix4);
/*  481 */       paramArrayOffloat[paramInt1] = vTmp.x;
/*  482 */       paramArrayOffloat[paramInt1 + 1] = vTmp.y;
/*  483 */       paramArrayOffloat[paramInt1 + 2] = vTmp.z; return;
/*  484 */     }  if (paramInt2 > 1) {
/*  485 */       vTmp.set(paramArrayOffloat[paramInt1], paramArrayOffloat[paramInt1 + 1], 0.0F).mul(paramMatrix4);
/*  486 */       paramArrayOffloat[paramInt1] = vTmp.x;
/*  487 */       paramArrayOffloat[paramInt1 + 1] = vTmp.y; return;
/*      */     } 
/*  489 */     paramArrayOffloat[paramInt1] = (vTmp.set(paramArrayOffloat[paramInt1], 0.0F, 0.0F).mul(paramMatrix4)).x;
/*      */   }
/*      */   
/*      */   private static final void transformNormal(float[] paramArrayOffloat, int paramInt1, int paramInt2, Matrix3 paramMatrix3) {
/*  493 */     if (paramInt2 > 2) {
/*  494 */       vTmp.set(paramArrayOffloat[paramInt1], paramArrayOffloat[paramInt1 + 1], paramArrayOffloat[paramInt1 + 2]).mul(paramMatrix3).nor();
/*  495 */       paramArrayOffloat[paramInt1] = vTmp.x;
/*  496 */       paramArrayOffloat[paramInt1 + 1] = vTmp.y;
/*  497 */       paramArrayOffloat[paramInt1 + 2] = vTmp.z; return;
/*  498 */     }  if (paramInt2 > 1) {
/*  499 */       vTmp.set(paramArrayOffloat[paramInt1], paramArrayOffloat[paramInt1 + 1], 0.0F).mul(paramMatrix3).nor();
/*  500 */       paramArrayOffloat[paramInt1] = vTmp.x;
/*  501 */       paramArrayOffloat[paramInt1 + 1] = vTmp.y; return;
/*      */     } 
/*  503 */     paramArrayOffloat[paramInt1] = (vTmp.set(paramArrayOffloat[paramInt1], 0.0F, 0.0F).mul(paramMatrix3).nor()).x;
/*      */   }
/*      */   
/*      */   private final void addVertex(float[] paramArrayOffloat, int paramInt) {
/*  507 */     int i = this.vertices.size;
/*  508 */     this.vertices.addAll(paramArrayOffloat, paramInt, this.stride);
/*  509 */     this.lastIndex = this.vindex++;
/*      */     
/*  511 */     if (this.vertexTransformationEnabled) {
/*  512 */       transformPosition(this.vertices.items, i + this.posOffset, this.posSize, this.positionTransform);
/*  513 */       if (this.norOffset >= 0) transformNormal(this.vertices.items, i + this.norOffset, 3, this.normalTransform); 
/*  514 */       if (this.biNorOffset >= 0) transformNormal(this.vertices.items, i + this.biNorOffset, 3, this.normalTransform); 
/*  515 */       if (this.tangentOffset >= 0) transformNormal(this.vertices.items, i + this.tangentOffset, 3, this.normalTransform);
/*      */     
/*      */     } 
/*  518 */     float f1 = this.vertices.items[i + this.posOffset];
/*  519 */     float f2 = (this.posSize > 1) ? this.vertices.items[i + this.posOffset + 1] : 0.0F;
/*  520 */     float f3 = (this.posSize > 2) ? this.vertices.items[i + this.posOffset + 2] : 0.0F;
/*  521 */     this.bounds.ext(f1, f2, f3);
/*      */     
/*  523 */     if (this.hasColor) {
/*  524 */       if (this.colOffset >= 0) {
/*  525 */         this.vertices.items[i + this.colOffset] = this.vertices.items[i + this.colOffset] * this.color.r;
/*  526 */         this.vertices.items[i + this.colOffset + 1] = this.vertices.items[i + this.colOffset + 1] * this.color.g;
/*  527 */         this.vertices.items[i + this.colOffset + 2] = this.vertices.items[i + this.colOffset + 2] * this.color.b;
/*  528 */         if (this.colSize > 3) this.vertices.items[i + this.colOffset + 3] = this.vertices.items[i + this.colOffset + 3] * this.color.a; 
/*  529 */       } else if (this.cpOffset >= 0) {
/*  530 */         Color.abgr8888ToColor(this.tempC1, this.vertices.items[i + this.cpOffset]);
/*  531 */         this.vertices.items[i + this.cpOffset] = this.tempC1.mul(this.color).toFloatBits();
/*      */       } 
/*      */     }
/*      */     
/*  535 */     if (this.hasUVTransform && this.uvOffset >= 0) {
/*  536 */       this.vertices.items[i + this.uvOffset] = this.uOffset + this.uScale * this.vertices.items[i + this.uvOffset];
/*  537 */       this.vertices.items[i + this.uvOffset + 1] = this.vOffset + this.vScale * this.vertices.items[i + this.uvOffset + 1];
/*      */     } 
/*      */   }
/*      */   
/*  541 */   private final Vector3 tmpNormal = new Vector3();
/*      */ 
/*      */   
/*      */   public short vertex(Vector3 paramVector31, Vector3 paramVector32, Color paramColor, Vector2 paramVector2) {
/*  545 */     if (this.vindex > 65535) throw new GdxRuntimeException("Too many vertices used");
/*      */     
/*  547 */     this.vertex[this.posOffset] = paramVector31.x;
/*  548 */     if (this.posSize > 1) this.vertex[this.posOffset + 1] = paramVector31.y; 
/*  549 */     if (this.posSize > 2) this.vertex[this.posOffset + 2] = paramVector31.z;
/*      */     
/*  551 */     if (this.norOffset >= 0) {
/*  552 */       if (paramVector32 == null) paramVector32 = this.tmpNormal.set(paramVector31).nor(); 
/*  553 */       this.vertex[this.norOffset] = paramVector32.x;
/*  554 */       this.vertex[this.norOffset + 1] = paramVector32.y;
/*  555 */       this.vertex[this.norOffset + 2] = paramVector32.z;
/*      */     } 
/*      */     
/*  558 */     if (this.colOffset >= 0) {
/*  559 */       if (paramColor == null) paramColor = Color.WHITE; 
/*  560 */       this.vertex[this.colOffset] = paramColor.r;
/*  561 */       this.vertex[this.colOffset + 1] = paramColor.g;
/*  562 */       this.vertex[this.colOffset + 2] = paramColor.b;
/*  563 */       if (this.colSize > 3) this.vertex[this.colOffset + 3] = paramColor.a; 
/*  564 */     } else if (this.cpOffset > 0) {
/*  565 */       if (paramColor == null) paramColor = Color.WHITE; 
/*  566 */       this.vertex[this.cpOffset] = paramColor.toFloatBits();
/*      */     } 
/*      */     
/*  569 */     if (paramVector2 != null && this.uvOffset >= 0) {
/*  570 */       this.vertex[this.uvOffset] = paramVector2.x;
/*  571 */       this.vertex[this.uvOffset + 1] = paramVector2.y;
/*      */     } 
/*      */     
/*  574 */     addVertex(this.vertex, 0);
/*  575 */     return (short)this.lastIndex;
/*      */   }
/*      */ 
/*      */   
/*      */   public short vertex(float... paramVarArgs) {
/*  580 */     int i = paramVarArgs.length - this.stride;
/*  581 */     for (int j = 0; j <= i; j += this.stride)
/*  582 */       addVertex(paramVarArgs, j); 
/*  583 */     return (short)this.lastIndex;
/*      */   }
/*      */ 
/*      */   
/*      */   public short vertex(MeshPartBuilder.VertexInfo paramVertexInfo) {
/*  588 */     return vertex(paramVertexInfo.hasPosition ? paramVertexInfo.position : null, paramVertexInfo.hasNormal ? paramVertexInfo.normal : null, 
/*  589 */         paramVertexInfo.hasColor ? paramVertexInfo.color : null, paramVertexInfo.hasUV ? paramVertexInfo.uv : null);
/*      */   }
/*      */ 
/*      */   
/*      */   public void index(short paramShort) {
/*  594 */     this.indices.add(paramShort);
/*      */   }
/*      */ 
/*      */   
/*      */   public void index(short paramShort1, short paramShort2) {
/*  599 */     ensureIndices(2);
/*  600 */     this.indices.add(paramShort1);
/*  601 */     this.indices.add(paramShort2);
/*      */   }
/*      */ 
/*      */   
/*      */   public void index(short paramShort1, short paramShort2, short paramShort3) {
/*  606 */     ensureIndices(3);
/*  607 */     this.indices.add(paramShort1);
/*  608 */     this.indices.add(paramShort2);
/*  609 */     this.indices.add(paramShort3);
/*      */   }
/*      */ 
/*      */   
/*      */   public void index(short paramShort1, short paramShort2, short paramShort3, short paramShort4) {
/*  614 */     ensureIndices(4);
/*  615 */     this.indices.add(paramShort1);
/*  616 */     this.indices.add(paramShort2);
/*  617 */     this.indices.add(paramShort3);
/*  618 */     this.indices.add(paramShort4);
/*      */   }
/*      */ 
/*      */   
/*      */   public void index(short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5, short paramShort6) {
/*  623 */     ensureIndices(6);
/*  624 */     this.indices.add(paramShort1);
/*  625 */     this.indices.add(paramShort2);
/*  626 */     this.indices.add(paramShort3);
/*  627 */     this.indices.add(paramShort4);
/*  628 */     this.indices.add(paramShort5);
/*  629 */     this.indices.add(paramShort6);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void index(short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5, short paramShort6, short paramShort7, short paramShort8) {
/*  635 */     ensureIndices(8);
/*  636 */     this.indices.add(paramShort1);
/*  637 */     this.indices.add(paramShort2);
/*  638 */     this.indices.add(paramShort3);
/*  639 */     this.indices.add(paramShort4);
/*  640 */     this.indices.add(paramShort5);
/*  641 */     this.indices.add(paramShort6);
/*  642 */     this.indices.add(paramShort7);
/*  643 */     this.indices.add(paramShort8);
/*      */   }
/*      */ 
/*      */   
/*      */   public void line(short paramShort1, short paramShort2) {
/*  648 */     if (this.primitiveType != 1) throw new GdxRuntimeException("Incorrect primitive type"); 
/*  649 */     index(paramShort1, paramShort2);
/*      */   }
/*      */ 
/*      */   
/*      */   public void line(MeshPartBuilder.VertexInfo paramVertexInfo1, MeshPartBuilder.VertexInfo paramVertexInfo2) {
/*  654 */     ensureVertices(2);
/*  655 */     line(vertex(paramVertexInfo1), vertex(paramVertexInfo2));
/*      */   }
/*      */ 
/*      */   
/*      */   public void line(Vector3 paramVector31, Vector3 paramVector32) {
/*  660 */     line(this.vertTmp1.set(paramVector31, null, null, null), this.vertTmp2.set(paramVector32, null, null, null));
/*      */   }
/*      */ 
/*      */   
/*      */   public void line(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/*  665 */     line(this.vertTmp1.set(null, null, null, null).setPos(paramFloat1, paramFloat2, paramFloat3), this.vertTmp2.set(null, null, null, null).setPos(paramFloat4, paramFloat5, paramFloat6));
/*      */   }
/*      */ 
/*      */   
/*      */   public void line(Vector3 paramVector31, Color paramColor1, Vector3 paramVector32, Color paramColor2) {
/*  670 */     line(this.vertTmp1.set(paramVector31, null, paramColor1, null), this.vertTmp2.set(paramVector32, null, paramColor2, null));
/*      */   }
/*      */ 
/*      */   
/*      */   public void triangle(short paramShort1, short paramShort2, short paramShort3) {
/*  675 */     if (this.primitiveType == 4 || this.primitiveType == 0) {
/*  676 */       index(paramShort1, paramShort2, paramShort3); return;
/*  677 */     }  if (this.primitiveType == 1) {
/*  678 */       index(paramShort1, paramShort2, paramShort2, paramShort3, paramShort3, paramShort1); return;
/*      */     } 
/*  680 */     throw new GdxRuntimeException("Incorrect primitive type");
/*      */   }
/*      */ 
/*      */   
/*      */   public void triangle(MeshPartBuilder.VertexInfo paramVertexInfo1, MeshPartBuilder.VertexInfo paramVertexInfo2, MeshPartBuilder.VertexInfo paramVertexInfo3) {
/*  685 */     ensureVertices(3);
/*  686 */     triangle(vertex(paramVertexInfo1), vertex(paramVertexInfo2), vertex(paramVertexInfo3));
/*      */   }
/*      */ 
/*      */   
/*      */   public void triangle(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33) {
/*  691 */     triangle(this.vertTmp1.set(paramVector31, null, null, null), this.vertTmp2.set(paramVector32, null, null, null), this.vertTmp3.set(paramVector33, null, null, null));
/*      */   }
/*      */ 
/*      */   
/*      */   public void triangle(Vector3 paramVector31, Color paramColor1, Vector3 paramVector32, Color paramColor2, Vector3 paramVector33, Color paramColor3) {
/*  696 */     triangle(this.vertTmp1.set(paramVector31, null, paramColor1, null), this.vertTmp2.set(paramVector32, null, paramColor2, null), this.vertTmp3.set(paramVector33, null, paramColor3, null));
/*      */   }
/*      */ 
/*      */   
/*      */   public void rect(short paramShort1, short paramShort2, short paramShort3, short paramShort4) {
/*  701 */     if (this.primitiveType == 4) {
/*  702 */       index(paramShort1, paramShort2, paramShort3, paramShort3, paramShort4, paramShort1); return;
/*  703 */     }  if (this.primitiveType == 1) {
/*  704 */       index(paramShort1, paramShort2, paramShort2, paramShort3, paramShort3, paramShort4, paramShort4, paramShort1); return;
/*  705 */     }  if (this.primitiveType == 0) {
/*  706 */       index(paramShort1, paramShort2, paramShort3, paramShort4); return;
/*      */     } 
/*  708 */     throw new GdxRuntimeException("Incorrect primitive type");
/*      */   }
/*      */ 
/*      */   
/*      */   public void rect(MeshPartBuilder.VertexInfo paramVertexInfo1, MeshPartBuilder.VertexInfo paramVertexInfo2, MeshPartBuilder.VertexInfo paramVertexInfo3, MeshPartBuilder.VertexInfo paramVertexInfo4) {
/*  713 */     ensureVertices(4);
/*  714 */     rect(vertex(paramVertexInfo1), vertex(paramVertexInfo2), vertex(paramVertexInfo3), vertex(paramVertexInfo4));
/*      */   }
/*      */ 
/*      */   
/*      */   public void rect(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, Vector3 paramVector35) {
/*  719 */     rect(this.vertTmp1.set(paramVector31, paramVector35, null, null).setUV(0.0F, 1.0F), this.vertTmp2.set(paramVector32, paramVector35, null, null).setUV(1.0F, 1.0F), this.vertTmp3
/*  720 */         .set(paramVector33, paramVector35, null, null).setUV(1.0F, 0.0F), this.vertTmp4.set(paramVector34, paramVector35, null, null).setUV(0.0F, 0.0F));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void rect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15) {
/*  726 */     rect(this.vertTmp1.set(null, null, null, null).setPos(paramFloat1, paramFloat2, paramFloat3).setNor(paramFloat13, paramFloat14, paramFloat15).setUV(0.0F, 1.0F), this.vertTmp2
/*  727 */         .set(null, null, null, null).setPos(paramFloat4, paramFloat5, paramFloat6).setNor(paramFloat13, paramFloat14, paramFloat15).setUV(1.0F, 1.0F), this.vertTmp3
/*  728 */         .set(null, null, null, null).setPos(paramFloat7, paramFloat8, paramFloat9).setNor(paramFloat13, paramFloat14, paramFloat15).setUV(1.0F, 0.0F), this.vertTmp4
/*  729 */         .set(null, null, null, null).setPos(paramFloat10, paramFloat11, paramFloat12).setNor(paramFloat13, paramFloat14, paramFloat15).setUV(0.0F, 0.0F));
/*      */   }
/*      */ 
/*      */   
/*      */   public void addMesh(Mesh paramMesh) {
/*  734 */     addMesh(paramMesh, 0, paramMesh.getNumIndices());
/*      */   }
/*      */ 
/*      */   
/*      */   public void addMesh(MeshPart paramMeshPart) {
/*  739 */     if (paramMeshPart.primitiveType != this.primitiveType) throw new GdxRuntimeException("Primitive type doesn't match"); 
/*  740 */     addMesh(paramMeshPart.mesh, paramMeshPart.offset, paramMeshPart.size);
/*      */   }
/*      */ 
/*      */   
/*      */   public void addMesh(Mesh paramMesh, int paramInt1, int paramInt2) {
/*  745 */     if (!this.attributes.equals(paramMesh.getVertexAttributes())) throw new GdxRuntimeException("Vertex attributes do not match"); 
/*  746 */     if (paramInt2 <= 0) {
/*      */       return;
/*      */     }
/*  749 */     int i = paramMesh.getNumVertices() * this.stride;
/*  750 */     tmpVertices.clear();
/*  751 */     tmpVertices.ensureCapacity(i);
/*  752 */     tmpVertices.size = i;
/*  753 */     paramMesh.getVertices(tmpVertices.items);
/*      */     
/*  755 */     tmpIndices.clear();
/*  756 */     tmpIndices.ensureCapacity(paramInt2);
/*  757 */     tmpIndices.size = paramInt2;
/*  758 */     paramMesh.getIndices(paramInt1, paramInt2, tmpIndices.items, 0);
/*      */     
/*  760 */     addMesh(tmpVertices.items, tmpIndices.items, 0, paramInt2);
/*      */   }
/*      */   
/*  763 */   private static IntIntMap indicesMap = null;
/*      */ 
/*      */   
/*      */   public void addMesh(float[] paramArrayOffloat, short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/*  767 */     if (indicesMap == null) {
/*  768 */       indicesMap = new IntIntMap(paramInt2);
/*      */     } else {
/*  770 */       indicesMap.clear();
/*  771 */       indicesMap.ensureCapacity(paramInt2);
/*      */     } 
/*  773 */     ensureIndices(paramInt2);
/*  774 */     int i = paramArrayOffloat.length / this.stride;
/*  775 */     ensureVertices((i < paramInt2) ? i : paramInt2);
/*  776 */     for (i = 0; i < paramInt2; i++) {
/*  777 */       int j = paramArrayOfshort[paramInt1 + i] & 0xFFFF;
/*      */       int k;
/*  779 */       if ((k = indicesMap.get(j, -1)) < 0) {
/*  780 */         addVertex(paramArrayOffloat, j * this.stride);
/*  781 */         indicesMap.put(j, k = this.lastIndex);
/*      */       } 
/*  783 */       index((short)k);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void addMesh(float[] paramArrayOffloat, short[] paramArrayOfshort) {
/*  789 */     int i = this.lastIndex + 1;
/*      */     
/*  791 */     int j = paramArrayOffloat.length / this.stride;
/*  792 */     ensureVertices(j);
/*  793 */     for (j = 0; j < paramArrayOffloat.length; j += this.stride) {
/*  794 */       addVertex(paramArrayOffloat, j);
/*      */     }
/*  796 */     ensureIndices(paramArrayOfshort.length);
/*  797 */     for (j = 0; j < paramArrayOfshort.length; j++) {
/*  798 */       index((short)((paramArrayOfshort[j] & 0xFFFF) + i));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void patch(MeshPartBuilder.VertexInfo paramVertexInfo1, MeshPartBuilder.VertexInfo paramVertexInfo2, MeshPartBuilder.VertexInfo paramVertexInfo3, MeshPartBuilder.VertexInfo paramVertexInfo4, int paramInt1, int paramInt2) {
/*  807 */     PatchShapeBuilder.build(this, paramVertexInfo1, paramVertexInfo2, paramVertexInfo3, paramVertexInfo4, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void patch(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, Vector3 paramVector35, int paramInt1, int paramInt2) {
/*  814 */     PatchShapeBuilder.build(this, paramVector31, paramVector32, paramVector33, paramVector34, paramVector35, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void patch(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, int paramInt1, int paramInt2) {
/*  821 */     PatchShapeBuilder.build(this, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void box(MeshPartBuilder.VertexInfo paramVertexInfo1, MeshPartBuilder.VertexInfo paramVertexInfo2, MeshPartBuilder.VertexInfo paramVertexInfo3, MeshPartBuilder.VertexInfo paramVertexInfo4, MeshPartBuilder.VertexInfo paramVertexInfo5, MeshPartBuilder.VertexInfo paramVertexInfo6, MeshPartBuilder.VertexInfo paramVertexInfo7, MeshPartBuilder.VertexInfo paramVertexInfo8) {
/*  829 */     BoxShapeBuilder.build(this, paramVertexInfo1, paramVertexInfo2, paramVertexInfo3, paramVertexInfo4, paramVertexInfo5, paramVertexInfo6, paramVertexInfo7, paramVertexInfo8);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void box(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, Vector3 paramVector35, Vector3 paramVector36, Vector3 paramVector37, Vector3 paramVector38) {
/*  836 */     BoxShapeBuilder.build(this, paramVector31, paramVector32, paramVector33, paramVector34, paramVector35, paramVector36, paramVector37, paramVector38);
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void box(Matrix4 paramMatrix4) {
/*  842 */     BoxShapeBuilder.build(this, paramMatrix4);
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void box(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  848 */     BoxShapeBuilder.build(this, paramFloat1, paramFloat2, paramFloat3);
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void box(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/*  854 */     BoxShapeBuilder.build(this, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void circle(float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/*  861 */     EllipseShapeBuilder.build(this, paramFloat1, paramInt, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7);
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void circle(float paramFloat, int paramInt, Vector3 paramVector31, Vector3 paramVector32) {
/*  867 */     EllipseShapeBuilder.build(this, paramFloat, paramInt, paramVector31, paramVector32);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void circle(float paramFloat, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34) {
/*  874 */     EllipseShapeBuilder.build(this, paramFloat, paramInt, paramVector31, paramVector32, paramVector33, paramVector34);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void circle(float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13) {
/*  881 */     EllipseShapeBuilder.build(this, paramFloat1, paramInt, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void circle(float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/*  889 */     EllipseShapeBuilder.build(this, paramFloat1, paramInt, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void circle(float paramFloat1, int paramInt, Vector3 paramVector31, Vector3 paramVector32, float paramFloat2, float paramFloat3) {
/*  896 */     EllipseShapeBuilder.build(this, paramFloat1, paramInt, paramVector31, paramVector32, paramFloat2, paramFloat3);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void circle(float paramFloat1, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, float paramFloat2, float paramFloat3) {
/*  903 */     circle(paramFloat1, paramInt, paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z, paramVector33.x, paramVector33.y, paramVector33.z, paramVector34.x, paramVector34.y, paramVector34.z, paramFloat2, paramFloat3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void circle(float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15) {
/*  912 */     EllipseShapeBuilder.build(this, paramFloat1, paramInt, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void ellipse(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
/*  920 */     EllipseShapeBuilder.build(this, paramFloat1, paramFloat2, paramInt, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8);
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void ellipse(float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32) {
/*  926 */     EllipseShapeBuilder.build(this, paramFloat1, paramFloat2, paramInt, paramVector31, paramVector32);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void ellipse(float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34) {
/*  933 */     EllipseShapeBuilder.build(this, paramFloat1, paramFloat2, paramInt, paramVector31, paramVector32, paramVector33, paramVector34);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void ellipse(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14) {
/*  941 */     EllipseShapeBuilder.build(this, paramFloat1, paramFloat2, paramInt, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void ellipse(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10) {
/*  949 */     EllipseShapeBuilder.build(this, paramFloat1, paramFloat2, paramInt, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void ellipse(float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32, float paramFloat3, float paramFloat4) {
/*  957 */     EllipseShapeBuilder.build(this, paramFloat1, paramFloat2, paramInt, paramVector31, paramVector32, paramFloat3, paramFloat4);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void ellipse(float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, float paramFloat3, float paramFloat4) {
/*  964 */     EllipseShapeBuilder.build(this, paramFloat1, paramFloat2, paramInt, paramVector31, paramVector32, paramVector33, paramVector34, paramFloat3, paramFloat4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void ellipse(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16) {
/*  972 */     EllipseShapeBuilder.build(this, paramFloat1, paramFloat2, paramInt, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramFloat16);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, Vector3 paramVector31, Vector3 paramVector32) {
/*  980 */     EllipseShapeBuilder.build(this, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, paramVector31, paramVector32);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10) {
/*  987 */     EllipseShapeBuilder.build(this, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12) {
/*  995 */     EllipseShapeBuilder.build(this, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16, float paramFloat17, float paramFloat18) {
/* 1004 */     EllipseShapeBuilder.build(this, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramFloat16, paramFloat17, paramFloat18);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void cylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt) {
/* 1011 */     CylinderShapeBuilder.build(this, paramFloat1, paramFloat2, paramFloat3, paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void cylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, float paramFloat4, float paramFloat5) {
/* 1017 */     CylinderShapeBuilder.build(this, paramFloat1, paramFloat2, paramFloat3, paramInt, paramFloat4, paramFloat5);
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void cylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, float paramFloat4, float paramFloat5, boolean paramBoolean) {
/* 1023 */     CylinderShapeBuilder.build(this, paramFloat1, paramFloat2, paramFloat3, paramInt, paramFloat4, paramFloat5, paramBoolean);
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void cone(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt) {
/* 1029 */     cone(paramFloat1, paramFloat2, paramFloat3, paramInt, 0.0F, 360.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void cone(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, float paramFloat4, float paramFloat5) {
/* 1035 */     ConeShapeBuilder.build(this, paramFloat1, paramFloat2, paramFloat3, paramInt, paramFloat4, paramFloat5);
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void sphere(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2) {
/* 1041 */     SphereShapeBuilder.build(this, paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void sphere(Matrix4 paramMatrix4, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2) {
/* 1047 */     SphereShapeBuilder.build(this, paramMatrix4, paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void sphere(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/* 1054 */     SphereShapeBuilder.build(this, paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, paramFloat4, paramFloat5, paramFloat6, paramFloat7);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void sphere(Matrix4 paramMatrix4, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/* 1061 */     SphereShapeBuilder.build(this, paramMatrix4, paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, paramFloat4, paramFloat5, paramFloat6, paramFloat7);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void capsule(float paramFloat1, float paramFloat2, int paramInt) {
/* 1068 */     CapsuleShapeBuilder.build(this, paramFloat1, paramFloat2, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void arrow(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt) {
/* 1075 */     ArrowShapeBuilder.build(this, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramInt);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\MeshBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */