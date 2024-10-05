/*     */ package com.badlogic.gdx.graphics.g3d.utils;public interface MeshPartBuilder { MeshPart getMeshPart();
/*     */   int getPrimitiveType();
/*     */   VertexAttributes getAttributes();
/*     */   void setColor(Color paramColor);
/*     */   void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
/*     */   void setUVRange(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
/*     */   void setUVRange(TextureRegion paramTextureRegion);
/*     */   Matrix4 getVertexTransform(Matrix4 paramMatrix4);
/*     */   void setVertexTransform(Matrix4 paramMatrix4);
/*     */   
/*     */   boolean isVertexTransformationEnabled();
/*     */   
/*     */   void setVertexTransformationEnabled(boolean paramBoolean);
/*     */   
/*     */   void ensureVertices(int paramInt);
/*     */   
/*     */   void ensureIndices(int paramInt);
/*     */   
/*     */   void ensureCapacity(int paramInt1, int paramInt2);
/*     */   
/*     */   void ensureTriangleIndices(int paramInt);
/*     */   
/*     */   void ensureRectangleIndices(int paramInt);
/*     */   
/*     */   short vertex(float... paramVarArgs);
/*     */   
/*     */   short vertex(Vector3 paramVector31, Vector3 paramVector32, Color paramColor, Vector2 paramVector2);
/*     */   
/*     */   short vertex(VertexInfo paramVertexInfo);
/*     */   
/*     */   int lastIndex();
/*     */   
/*     */   void index(short paramShort);
/*     */   
/*     */   void index(short paramShort1, short paramShort2);
/*     */   
/*     */   void index(short paramShort1, short paramShort2, short paramShort3);
/*     */   
/*     */   void index(short paramShort1, short paramShort2, short paramShort3, short paramShort4);
/*     */   
/*     */   void index(short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5, short paramShort6);
/*     */   
/*     */   void index(short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5, short paramShort6, short paramShort7, short paramShort8);
/*     */   
/*     */   void line(short paramShort1, short paramShort2);
/*     */   
/*     */   void line(VertexInfo paramVertexInfo1, VertexInfo paramVertexInfo2);
/*     */   
/*     */   void line(Vector3 paramVector31, Vector3 paramVector32);
/*     */   
/*     */   void line(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
/*     */   
/*     */   void line(Vector3 paramVector31, Color paramColor1, Vector3 paramVector32, Color paramColor2);
/*     */   
/*     */   void triangle(short paramShort1, short paramShort2, short paramShort3);
/*     */   
/*     */   void triangle(VertexInfo paramVertexInfo1, VertexInfo paramVertexInfo2, VertexInfo paramVertexInfo3);
/*     */   
/*     */   void triangle(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33);
/*     */   
/*     */   void triangle(Vector3 paramVector31, Color paramColor1, Vector3 paramVector32, Color paramColor2, Vector3 paramVector33, Color paramColor3);
/*     */   
/*     */   void rect(short paramShort1, short paramShort2, short paramShort3, short paramShort4);
/*     */   
/*     */   void rect(VertexInfo paramVertexInfo1, VertexInfo paramVertexInfo2, VertexInfo paramVertexInfo3, VertexInfo paramVertexInfo4);
/*     */   
/*     */   void rect(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, Vector3 paramVector35);
/*     */   
/*     */   void rect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15);
/*     */   
/*     */   void addMesh(Mesh paramMesh);
/*     */   
/*     */   void addMesh(MeshPart paramMeshPart);
/*     */   
/*     */   void addMesh(Mesh paramMesh, int paramInt1, int paramInt2);
/*     */   
/*     */   void addMesh(float[] paramArrayOffloat, short[] paramArrayOfshort);
/*     */   
/*     */   void addMesh(float[] paramArrayOffloat, short[] paramArrayOfshort, int paramInt1, int paramInt2);
/*     */   
/*     */   @Deprecated
/*     */   void patch(VertexInfo paramVertexInfo1, VertexInfo paramVertexInfo2, VertexInfo paramVertexInfo3, VertexInfo paramVertexInfo4, int paramInt1, int paramInt2);
/*     */   
/*     */   @Deprecated
/*     */   void patch(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, Vector3 paramVector35, int paramInt1, int paramInt2);
/*     */   
/*     */   @Deprecated
/*     */   void patch(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, int paramInt1, int paramInt2);
/*     */   
/*     */   @Deprecated
/*     */   void box(VertexInfo paramVertexInfo1, VertexInfo paramVertexInfo2, VertexInfo paramVertexInfo3, VertexInfo paramVertexInfo4, VertexInfo paramVertexInfo5, VertexInfo paramVertexInfo6, VertexInfo paramVertexInfo7, VertexInfo paramVertexInfo8);
/*     */   
/*     */   @Deprecated
/*     */   void box(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, Vector3 paramVector35, Vector3 paramVector36, Vector3 paramVector37, Vector3 paramVector38);
/*     */   
/*     */   @Deprecated
/*     */   void box(Matrix4 paramMatrix4);
/*     */   
/*     */   @Deprecated
/*     */   void box(float paramFloat1, float paramFloat2, float paramFloat3);
/*     */   
/*     */   @Deprecated
/*     */   void box(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
/*     */   
/*     */   @Deprecated
/*     */   void circle(float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7);
/*     */   
/*     */   @Deprecated
/*     */   void circle(float paramFloat, int paramInt, Vector3 paramVector31, Vector3 paramVector32);
/*     */   
/*     */   @Deprecated
/*     */   void circle(float paramFloat, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34);
/*     */   
/*     */   @Deprecated
/*     */   void circle(float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13);
/*     */   
/*     */   @Deprecated
/*     */   void circle(float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9);
/*     */   
/*     */   @Deprecated
/*     */   void circle(float paramFloat1, int paramInt, Vector3 paramVector31, Vector3 paramVector32, float paramFloat2, float paramFloat3);
/*     */   
/*     */   @Deprecated
/*     */   void circle(float paramFloat1, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, float paramFloat2, float paramFloat3);
/*     */   
/*     */   @Deprecated
/*     */   void circle(float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15);
/*     */   
/*     */   @Deprecated
/*     */   void ellipse(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8);
/*     */   
/*     */   @Deprecated
/*     */   void ellipse(float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32);
/*     */   
/*     */   @Deprecated
/*     */   void ellipse(float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34);
/*     */   
/*     */   @Deprecated
/*     */   void ellipse(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14);
/*     */   
/*     */   @Deprecated
/*     */   void ellipse(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10);
/*     */   
/*     */   @Deprecated
/*     */   void ellipse(float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32, float paramFloat3, float paramFloat4);
/*     */   
/*     */   @Deprecated
/*     */   void ellipse(float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, float paramFloat3, float paramFloat4);
/*     */   
/*     */   @Deprecated
/*     */   void ellipse(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16);
/*     */   
/*     */   @Deprecated
/*     */   void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16, float paramFloat17, float paramFloat18);
/*     */   
/*     */   @Deprecated
/*     */   void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12);
/*     */   
/*     */   @Deprecated
/*     */   void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10);
/*     */   
/*     */   @Deprecated
/*     */   void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, Vector3 paramVector31, Vector3 paramVector32);
/*     */   
/*     */   @Deprecated
/*     */   void cylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt);
/*     */   
/*     */   @Deprecated
/*     */   void cylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, float paramFloat4, float paramFloat5);
/*     */   
/*     */   @Deprecated
/*     */   void cylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, float paramFloat4, float paramFloat5, boolean paramBoolean);
/*     */   
/*     */   @Deprecated
/*     */   void cone(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt);
/*     */   
/*     */   @Deprecated
/*     */   void cone(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, float paramFloat4, float paramFloat5);
/*     */   
/*     */   @Deprecated
/*     */   void sphere(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2);
/*     */   
/*     */   @Deprecated
/*     */   void sphere(Matrix4 paramMatrix4, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2);
/*     */   
/*     */   @Deprecated
/*     */   void sphere(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7);
/*     */   
/*     */   @Deprecated
/*     */   void sphere(Matrix4 paramMatrix4, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7);
/*     */   
/*     */   @Deprecated
/*     */   void capsule(float paramFloat1, float paramFloat2, int paramInt);
/*     */   
/*     */   @Deprecated
/*     */   void arrow(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt);
/*     */   
/* 198 */   public static class VertexInfo implements Pool.Poolable { public final Vector3 position = new Vector3();
/*     */     public boolean hasPosition;
/* 200 */     public final Vector3 normal = new Vector3(0.0F, 1.0F, 0.0F);
/*     */     public boolean hasNormal;
/* 202 */     public final Color color = new Color(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     public boolean hasColor;
/* 204 */     public final Vector2 uv = new Vector2();
/*     */     
/*     */     public boolean hasUV;
/*     */     
/*     */     public void reset() {
/* 209 */       this.position.set(0.0F, 0.0F, 0.0F);
/* 210 */       this.normal.set(0.0F, 1.0F, 0.0F);
/* 211 */       this.color.set(1.0F, 1.0F, 1.0F, 1.0F);
/* 212 */       this.uv.set(0.0F, 0.0F);
/*     */     }
/*     */     
/*     */     public VertexInfo set(Vector3 param1Vector31, Vector3 param1Vector32, Color param1Color, Vector2 param1Vector2) {
/* 216 */       reset();
/* 217 */       this.hasPosition = (param1Vector31 != null);
/* 218 */       if (this.hasPosition) this.position.set(param1Vector31); 
/* 219 */       this.hasNormal = (param1Vector32 != null);
/* 220 */       if (this.hasNormal) this.normal.set(param1Vector32); 
/* 221 */       this.hasColor = (param1Color != null);
/* 222 */       if (this.hasColor) this.color.set(param1Color); 
/* 223 */       this.hasUV = (param1Vector2 != null);
/* 224 */       if (this.hasUV) this.uv.set(param1Vector2); 
/* 225 */       return this;
/*     */     }
/*     */     
/*     */     public VertexInfo set(VertexInfo param1VertexInfo) {
/* 229 */       if (param1VertexInfo == null) return set(null, null, null, null); 
/* 230 */       this.hasPosition = param1VertexInfo.hasPosition;
/* 231 */       this.position.set(param1VertexInfo.position);
/* 232 */       this.hasNormal = param1VertexInfo.hasNormal;
/* 233 */       this.normal.set(param1VertexInfo.normal);
/* 234 */       this.hasColor = param1VertexInfo.hasColor;
/* 235 */       this.color.set(param1VertexInfo.color);
/* 236 */       this.hasUV = param1VertexInfo.hasUV;
/* 237 */       this.uv.set(param1VertexInfo.uv);
/* 238 */       return this;
/*     */     }
/*     */     
/*     */     public VertexInfo setPos(float param1Float1, float param1Float2, float param1Float3) {
/* 242 */       this.position.set(param1Float1, param1Float2, param1Float3);
/* 243 */       this.hasPosition = true;
/* 244 */       return this;
/*     */     }
/*     */     
/*     */     public VertexInfo setPos(Vector3 param1Vector3) {
/* 248 */       this.hasPosition = (param1Vector3 != null);
/* 249 */       if (this.hasPosition) this.position.set(param1Vector3); 
/* 250 */       return this;
/*     */     }
/*     */     
/*     */     public VertexInfo setNor(float param1Float1, float param1Float2, float param1Float3) {
/* 254 */       this.normal.set(param1Float1, param1Float2, param1Float3);
/* 255 */       this.hasNormal = true;
/* 256 */       return this;
/*     */     }
/*     */     
/*     */     public VertexInfo setNor(Vector3 param1Vector3) {
/* 260 */       this.hasNormal = (param1Vector3 != null);
/* 261 */       if (this.hasNormal) this.normal.set(param1Vector3); 
/* 262 */       return this;
/*     */     }
/*     */     
/*     */     public VertexInfo setCol(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/* 266 */       this.color.set(param1Float1, param1Float2, param1Float3, param1Float4);
/* 267 */       this.hasColor = true;
/* 268 */       return this;
/*     */     }
/*     */     
/*     */     public VertexInfo setCol(Color param1Color) {
/* 272 */       this.hasColor = (param1Color != null);
/* 273 */       if (this.hasColor) this.color.set(param1Color); 
/* 274 */       return this;
/*     */     }
/*     */     
/*     */     public VertexInfo setUV(float param1Float1, float param1Float2) {
/* 278 */       this.uv.set(param1Float1, param1Float2);
/* 279 */       this.hasUV = true;
/* 280 */       return this;
/*     */     }
/*     */     
/*     */     public VertexInfo setUV(Vector2 param1Vector2) {
/* 284 */       this.hasUV = (param1Vector2 != null);
/* 285 */       if (this.hasUV) this.uv.set(param1Vector2); 
/* 286 */       return this;
/*     */     }
/*     */     
/*     */     public VertexInfo lerp(VertexInfo param1VertexInfo, float param1Float) {
/* 290 */       if (this.hasPosition && param1VertexInfo.hasPosition) this.position.lerp(param1VertexInfo.position, param1Float); 
/* 291 */       if (this.hasNormal && param1VertexInfo.hasNormal) this.normal.lerp(param1VertexInfo.normal, param1Float); 
/* 292 */       if (this.hasColor && param1VertexInfo.hasColor) this.color.lerp(param1VertexInfo.color, param1Float); 
/* 293 */       if (this.hasUV && param1VertexInfo.hasUV) this.uv.lerp(param1VertexInfo.uv, param1Float); 
/* 294 */       return this;
/*     */     } }
/*     */    }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\MeshPartBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */