/*     */ package com.badlogic.gdx.math.collision;
/*     */ 
/*     */ import com.badlogic.gdx.math.Intersector;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import java.io.Serializable;
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
/*     */ public class OrientedBoundingBox
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 3864065514676250557L;
/*  28 */   private static final Vector3[] tempAxes = new Vector3[15];
/*  29 */   private static final Vector3[] tempVertices = new Vector3[8];
/*  30 */   private static final Vector3[] tmpVectors = new Vector3[9]; static {
/*     */     byte b;
/*  32 */     for (b = 0; b < tmpVectors.length; b++) {
/*  33 */       tmpVectors[b] = new Vector3();
/*     */     }
/*  35 */     for (b = 0; b < tempVertices.length; b++) {
/*  36 */       tempVertices[b] = new Vector3();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*  41 */   private final BoundingBox bounds = new BoundingBox();
/*     */   
/*  43 */   public final Matrix4 transform = new Matrix4();
/*  44 */   private final Matrix4 inverseTransform = new Matrix4();
/*     */   
/*  46 */   private final Vector3[] axes = new Vector3[3];
/*  47 */   private final Vector3[] vertices = new Vector3[8];
/*     */ 
/*     */   
/*     */   public OrientedBoundingBox() {
/*  51 */     this.bounds.clr();
/*  52 */     init();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OrientedBoundingBox(BoundingBox paramBoundingBox) {
/*  59 */     this.bounds.set(paramBoundingBox.min, paramBoundingBox.max);
/*  60 */     init();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OrientedBoundingBox(BoundingBox paramBoundingBox, Matrix4 paramMatrix4) {
/*  68 */     this.bounds.set(paramBoundingBox.min, paramBoundingBox.max);
/*  69 */     this.transform.set(paramMatrix4);
/*  70 */     init();
/*     */   }
/*     */   private void init() {
/*     */     byte b;
/*  74 */     for (b = 0; b < this.axes.length; b++) {
/*  75 */       this.axes[b] = new Vector3();
/*     */     }
/*  77 */     for (b = 0; b < this.vertices.length; b++) {
/*  78 */       this.vertices[b] = new Vector3();
/*     */     }
/*  80 */     update();
/*     */   }
/*     */   
/*     */   public Vector3[] getVertices() {
/*  84 */     return this.vertices;
/*     */   }
/*     */ 
/*     */   
/*     */   public BoundingBox getBounds() {
/*  89 */     return this.bounds;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBounds(BoundingBox paramBoundingBox) {
/*  96 */     this.bounds.set(paramBoundingBox);
/*  97 */     paramBoundingBox.getCorner000(this.vertices[0]).mul(this.transform);
/*  98 */     paramBoundingBox.getCorner001(this.vertices[1]).mul(this.transform);
/*  99 */     paramBoundingBox.getCorner010(this.vertices[2]).mul(this.transform);
/* 100 */     paramBoundingBox.getCorner011(this.vertices[3]).mul(this.transform);
/* 101 */     paramBoundingBox.getCorner100(this.vertices[4]).mul(this.transform);
/* 102 */     paramBoundingBox.getCorner101(this.vertices[5]).mul(this.transform);
/* 103 */     paramBoundingBox.getCorner110(this.vertices[6]).mul(this.transform);
/* 104 */     paramBoundingBox.getCorner111(this.vertices[7]).mul(this.transform);
/*     */   }
/*     */ 
/*     */   
/*     */   public Matrix4 getTransform() {
/* 109 */     return this.transform;
/*     */   }
/*     */   
/*     */   public void setTransform(Matrix4 paramMatrix4) {
/* 113 */     this.transform.set(paramMatrix4);
/* 114 */     update();
/*     */   }
/*     */   
/*     */   public OrientedBoundingBox set(BoundingBox paramBoundingBox, Matrix4 paramMatrix4) {
/* 118 */     setBounds(paramBoundingBox);
/* 119 */     setTransform(paramMatrix4);
/* 120 */     return this;
/*     */   }
/*     */   
/*     */   public Vector3 getCorner000(Vector3 paramVector3) {
/* 124 */     return paramVector3.set(this.vertices[0]);
/*     */   }
/*     */   
/*     */   public Vector3 getCorner001(Vector3 paramVector3) {
/* 128 */     return paramVector3.set(this.vertices[1]);
/*     */   }
/*     */   
/*     */   public Vector3 getCorner010(Vector3 paramVector3) {
/* 132 */     return paramVector3.set(this.vertices[2]);
/*     */   }
/*     */   
/*     */   public Vector3 getCorner011(Vector3 paramVector3) {
/* 136 */     return paramVector3.set(this.vertices[3]);
/*     */   }
/*     */   
/*     */   public Vector3 getCorner100(Vector3 paramVector3) {
/* 140 */     return paramVector3.set(this.vertices[4]);
/*     */   }
/*     */   
/*     */   public Vector3 getCorner101(Vector3 paramVector3) {
/* 144 */     return paramVector3.set(this.vertices[5]);
/*     */   }
/*     */   
/*     */   public Vector3 getCorner110(Vector3 paramVector3) {
/* 148 */     return paramVector3.set(this.vertices[6]);
/*     */   }
/*     */   
/*     */   public Vector3 getCorner111(Vector3 paramVector3) {
/* 152 */     return paramVector3.set(this.vertices[7]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Vector3 paramVector3) {
/* 159 */     return contains(paramVector3, this.inverseTransform);
/*     */   }
/*     */   
/*     */   private boolean contains(Vector3 paramVector3, Matrix4 paramMatrix4) {
/* 163 */     paramVector3 = tmpVectors[0].set(paramVector3).mul(paramMatrix4);
/* 164 */     return this.bounds.contains(paramVector3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(BoundingBox paramBoundingBox) {
/* 171 */     Vector3 vector3 = tmpVectors[0];
/* 172 */     if (contains(paramBoundingBox.getCorner000(vector3), this.inverseTransform) && contains(paramBoundingBox.getCorner001(vector3), this.inverseTransform) && 
/* 173 */       contains(paramBoundingBox.getCorner010(vector3), this.inverseTransform) && contains(paramBoundingBox.getCorner011(vector3), this.inverseTransform) && 
/* 174 */       contains(paramBoundingBox.getCorner100(vector3), this.inverseTransform) && contains(paramBoundingBox.getCorner101(vector3), this.inverseTransform) && 
/* 175 */       contains(paramBoundingBox.getCorner110(vector3), this.inverseTransform) && contains(paramBoundingBox.getCorner111(vector3), this.inverseTransform)) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(OrientedBoundingBox paramOrientedBoundingBox) {
/* 182 */     if (contains(paramOrientedBoundingBox.getCorner000(tmpVectors[0]), this.inverseTransform) && 
/* 183 */       contains(paramOrientedBoundingBox.getCorner001(tmpVectors[0]), this.inverseTransform) && 
/* 184 */       contains(paramOrientedBoundingBox.getCorner010(tmpVectors[0]), this.inverseTransform) && 
/* 185 */       contains(paramOrientedBoundingBox.getCorner011(tmpVectors[0]), this.inverseTransform) && 
/* 186 */       contains(paramOrientedBoundingBox.getCorner100(tmpVectors[0]), this.inverseTransform) && 
/* 187 */       contains(paramOrientedBoundingBox.getCorner101(tmpVectors[0]), this.inverseTransform) && 
/* 188 */       contains(paramOrientedBoundingBox.getCorner110(tmpVectors[0]), this.inverseTransform) && 
/* 189 */       contains(paramOrientedBoundingBox.getCorner111(tmpVectors[0]), this.inverseTransform)) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean intersects(BoundingBox paramBoundingBox) {
/* 196 */     Vector3[] arrayOfVector32 = this.axes;
/*     */     
/* 198 */     tempAxes[0] = arrayOfVector32[0];
/* 199 */     tempAxes[1] = arrayOfVector32[1];
/* 200 */     tempAxes[2] = arrayOfVector32[2];
/* 201 */     tempAxes[3] = Vector3.X;
/* 202 */     tempAxes[4] = Vector3.Y;
/* 203 */     tempAxes[5] = Vector3.Z;
/* 204 */     tempAxes[6] = tmpVectors[0].set(arrayOfVector32[0]).crs(Vector3.X);
/* 205 */     tempAxes[7] = tmpVectors[1].set(arrayOfVector32[0]).crs(Vector3.Y);
/* 206 */     tempAxes[8] = tmpVectors[2].set(arrayOfVector32[0]).crs(Vector3.Z);
/* 207 */     tempAxes[9] = tmpVectors[3].set(arrayOfVector32[1]).crs(Vector3.X);
/* 208 */     tempAxes[10] = tmpVectors[4].set(arrayOfVector32[1]).crs(Vector3.Y);
/* 209 */     tempAxes[11] = tmpVectors[5].set(arrayOfVector32[1]).crs(Vector3.Z);
/* 210 */     tempAxes[12] = tmpVectors[6].set(arrayOfVector32[2]).crs(Vector3.X);
/* 211 */     tempAxes[13] = tmpVectors[7].set(arrayOfVector32[2]).crs(Vector3.Y);
/* 212 */     tempAxes[14] = tmpVectors[8].set(arrayOfVector32[2]).crs(Vector3.Z);
/*     */     
/* 214 */     arrayOfVector32 = getVertices();
/* 215 */     Vector3[] arrayOfVector31 = getVertices(paramBoundingBox);
/*     */     
/* 217 */     return Intersector.hasOverlap(tempAxes, arrayOfVector32, arrayOfVector31);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean intersects(OrientedBoundingBox paramOrientedBoundingBox) {
/* 224 */     Vector3[] arrayOfVector31 = this.axes;
/* 225 */     Vector3[] arrayOfVector32 = paramOrientedBoundingBox.axes;
/*     */     
/* 227 */     tempAxes[0] = arrayOfVector31[0];
/* 228 */     tempAxes[1] = arrayOfVector31[1];
/* 229 */     tempAxes[2] = arrayOfVector31[2];
/* 230 */     tempAxes[3] = arrayOfVector32[0];
/* 231 */     tempAxes[4] = arrayOfVector32[1];
/* 232 */     tempAxes[5] = arrayOfVector32[2];
/* 233 */     tempAxes[6] = tmpVectors[0].set(arrayOfVector31[0]).crs(arrayOfVector32[0]);
/* 234 */     tempAxes[7] = tmpVectors[1].set(arrayOfVector31[0]).crs(arrayOfVector32[1]);
/* 235 */     tempAxes[8] = tmpVectors[2].set(arrayOfVector31[0]).crs(arrayOfVector32[2]);
/* 236 */     tempAxes[9] = tmpVectors[3].set(arrayOfVector31[1]).crs(arrayOfVector32[0]);
/* 237 */     tempAxes[10] = tmpVectors[4].set(arrayOfVector31[1]).crs(arrayOfVector32[1]);
/* 238 */     tempAxes[11] = tmpVectors[5].set(arrayOfVector31[1]).crs(arrayOfVector32[2]);
/* 239 */     tempAxes[12] = tmpVectors[6].set(arrayOfVector31[2]).crs(arrayOfVector32[0]);
/* 240 */     tempAxes[13] = tmpVectors[7].set(arrayOfVector31[2]).crs(arrayOfVector32[1]);
/* 241 */     tempAxes[14] = tmpVectors[8].set(arrayOfVector31[2]).crs(arrayOfVector32[2]);
/*     */     
/* 243 */     return Intersector.hasOverlap(tempAxes, this.vertices, paramOrientedBoundingBox.vertices);
/*     */   }
/*     */   
/*     */   private Vector3[] getVertices(BoundingBox paramBoundingBox) {
/* 247 */     paramBoundingBox.getCorner000(tempVertices[0]);
/* 248 */     paramBoundingBox.getCorner001(tempVertices[1]);
/* 249 */     paramBoundingBox.getCorner010(tempVertices[2]);
/* 250 */     paramBoundingBox.getCorner011(tempVertices[3]);
/* 251 */     paramBoundingBox.getCorner100(tempVertices[4]);
/* 252 */     paramBoundingBox.getCorner101(tempVertices[5]);
/* 253 */     paramBoundingBox.getCorner110(tempVertices[6]);
/* 254 */     paramBoundingBox.getCorner111(tempVertices[7]);
/* 255 */     return tempVertices;
/*     */   }
/*     */   
/*     */   public void mul(Matrix4 paramMatrix4) {
/* 259 */     this.transform.mul(paramMatrix4);
/* 260 */     update();
/*     */   }
/*     */ 
/*     */   
/*     */   private void update() {
/* 265 */     this.bounds.getCorner000(this.vertices[0]).mul(this.transform);
/* 266 */     this.bounds.getCorner001(this.vertices[1]).mul(this.transform);
/* 267 */     this.bounds.getCorner010(this.vertices[2]).mul(this.transform);
/* 268 */     this.bounds.getCorner011(this.vertices[3]).mul(this.transform);
/* 269 */     this.bounds.getCorner100(this.vertices[4]).mul(this.transform);
/* 270 */     this.bounds.getCorner101(this.vertices[5]).mul(this.transform);
/* 271 */     this.bounds.getCorner110(this.vertices[6]).mul(this.transform);
/* 272 */     this.bounds.getCorner111(this.vertices[7]).mul(this.transform);
/*     */     
/* 274 */     this.axes[0].set(this.transform.val[0], this.transform.val[1], this.transform.val[2]).nor();
/* 275 */     this.axes[1].set(this.transform.val[4], this.transform.val[5], this.transform.val[6]).nor();
/* 276 */     this.axes[2].set(this.transform.val[8], this.transform.val[9], this.transform.val[10]).nor();
/*     */     
/* 278 */     this.inverseTransform.set(this.transform).inv();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\collision\OrientedBoundingBox.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */