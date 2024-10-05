/*     */ package com.badlogic.gdx.math;
/*     */ 
/*     */ import com.badlogic.gdx.math.collision.BoundingBox;
/*     */ import com.badlogic.gdx.math.collision.OrientedBoundingBox;
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
/*     */ public class Frustum
/*     */ {
/*  29 */   protected static final Vector3[] clipSpacePlanePoints = new Vector3[] { new Vector3(-1.0F, -1.0F, -1.0F), new Vector3(1.0F, -1.0F, -1.0F), new Vector3(1.0F, 1.0F, -1.0F), new Vector3(-1.0F, 1.0F, -1.0F), new Vector3(-1.0F, -1.0F, 1.0F), new Vector3(1.0F, -1.0F, 1.0F), new Vector3(1.0F, 1.0F, 1.0F), new Vector3(-1.0F, 1.0F, 1.0F) };
/*     */ 
/*     */   
/*  32 */   protected static final float[] clipSpacePlanePointsArray = new float[24];
/*     */   
/*     */   static {
/*  35 */     byte b1 = 0; Vector3[] arrayOfVector3; int i; byte b2;
/*  36 */     for (i = (arrayOfVector3 = clipSpacePlanePoints).length, b2 = 0; b2 < i; ) { Vector3 vector3 = arrayOfVector3[b2];
/*  37 */       clipSpacePlanePointsArray[b1++] = vector3.x;
/*  38 */       clipSpacePlanePointsArray[b1++] = vector3.y;
/*  39 */       clipSpacePlanePointsArray[b1++] = vector3.z;
/*     */       b2++; }
/*     */   
/*     */   }
/*  43 */   private static final Vector3 tmpV = new Vector3();
/*     */ 
/*     */   
/*  46 */   public final Plane[] planes = new Plane[6];
/*     */ 
/*     */   
/*  49 */   public final Vector3[] planePoints = new Vector3[] { new Vector3(), new Vector3(), new Vector3(), new Vector3(), new Vector3(), new Vector3(), new Vector3(), new Vector3() };
/*     */   
/*  51 */   protected final float[] planePointsArray = new float[24];
/*     */   
/*     */   public Frustum() {
/*  54 */     for (byte b = 0; b < 6; b++) {
/*  55 */       this.planes[b] = new Plane(new Vector3(), 0.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(Matrix4 paramMatrix4) {
/*  63 */     System.arraycopy(clipSpacePlanePointsArray, 0, this.planePointsArray, 0, clipSpacePlanePointsArray.length);
/*  64 */     Matrix4.prj(paramMatrix4.val, this.planePointsArray, 0, 8, 3);
/*  65 */     for (byte b1 = 0, b2 = 0; b1 < 8; b1++) {
/*     */       Vector3 vector3;
/*  67 */       (vector3 = this.planePoints[b1]).x = this.planePointsArray[b2++];
/*  68 */       vector3.y = this.planePointsArray[b2++];
/*  69 */       vector3.z = this.planePointsArray[b2++];
/*     */     } 
/*     */     
/*  72 */     this.planes[0].set(this.planePoints[1], this.planePoints[0], this.planePoints[2]);
/*  73 */     this.planes[1].set(this.planePoints[4], this.planePoints[5], this.planePoints[7]);
/*  74 */     this.planes[2].set(this.planePoints[0], this.planePoints[4], this.planePoints[3]);
/*  75 */     this.planes[3].set(this.planePoints[5], this.planePoints[1], this.planePoints[6]);
/*  76 */     this.planes[4].set(this.planePoints[2], this.planePoints[3], this.planePoints[6]);
/*  77 */     this.planes[5].set(this.planePoints[4], this.planePoints[0], this.planePoints[1]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean pointInFrustum(Vector3 paramVector3) {
/*  85 */     for (byte b = 0; b < this.planes.length; b++) {
/*     */       Plane.PlaneSide planeSide;
/*  87 */       if ((planeSide = this.planes[b].testPoint(paramVector3)) == Plane.PlaneSide.Back) return false; 
/*     */     } 
/*  89 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean pointInFrustum(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  99 */     for (byte b = 0; b < this.planes.length; b++) {
/*     */       Plane.PlaneSide planeSide;
/* 101 */       if ((planeSide = this.planes[b].testPoint(paramFloat1, paramFloat2, paramFloat3)) == Plane.PlaneSide.Back) return false; 
/*     */     } 
/* 103 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean sphereInFrustum(Vector3 paramVector3, float paramFloat) {
/* 112 */     for (byte b = 0; b < 6; b++) {
/* 113 */       if ((this.planes[b]).normal.x * paramVector3.x + (this.planes[b]).normal.y * paramVector3.y + (this.planes[b]).normal.z * paramVector3.z < -paramFloat - (this.planes[b]).d)
/* 114 */         return false; 
/* 115 */     }  return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean sphereInFrustum(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 126 */     for (byte b = 0; b < 6; b++) {
/* 127 */       if ((this.planes[b]).normal.x * paramFloat1 + (this.planes[b]).normal.y * paramFloat2 + (this.planes[b]).normal.z * paramFloat3 < -paramFloat4 - (this.planes[b]).d) return false; 
/* 128 */     }  return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean sphereInFrustumWithoutNearFar(Vector3 paramVector3, float paramFloat) {
/* 137 */     for (byte b = 2; b < 6; b++) {
/* 138 */       if ((this.planes[b]).normal.x * paramVector3.x + (this.planes[b]).normal.y * paramVector3.y + (this.planes[b]).normal.z * paramVector3.z < -paramFloat - (this.planes[b]).d)
/* 139 */         return false; 
/* 140 */     }  return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean sphereInFrustumWithoutNearFar(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 151 */     for (byte b = 2; b < 6; b++) {
/* 152 */       if ((this.planes[b]).normal.x * paramFloat1 + (this.planes[b]).normal.y * paramFloat2 + (this.planes[b]).normal.z * paramFloat3 < -paramFloat4 - (this.planes[b]).d) return false; 
/* 153 */     }  return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean boundsInFrustum(BoundingBox paramBoundingBox) {
/*     */     byte b;
/*     */     int i;
/* 161 */     for (b = 0, i = this.planes.length; b < i; b++) {
/* 162 */       if (this.planes[b].testPoint(paramBoundingBox.getCorner000(tmpV)) == Plane.PlaneSide.Back && 
/* 163 */         this.planes[b].testPoint(paramBoundingBox.getCorner001(tmpV)) == Plane.PlaneSide.Back && 
/* 164 */         this.planes[b].testPoint(paramBoundingBox.getCorner010(tmpV)) == Plane.PlaneSide.Back && 
/* 165 */         this.planes[b].testPoint(paramBoundingBox.getCorner011(tmpV)) == Plane.PlaneSide.Back && 
/* 166 */         this.planes[b].testPoint(paramBoundingBox.getCorner100(tmpV)) == Plane.PlaneSide.Back && 
/* 167 */         this.planes[b].testPoint(paramBoundingBox.getCorner101(tmpV)) == Plane.PlaneSide.Back && 
/* 168 */         this.planes[b].testPoint(paramBoundingBox.getCorner110(tmpV)) == Plane.PlaneSide.Back && 
/* 169 */         this.planes[b].testPoint(paramBoundingBox.getCorner111(tmpV)) == Plane.PlaneSide.Back) {
/* 170 */         return false;
/*     */       }
/*     */     } 
/* 173 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean boundsInFrustum(Vector3 paramVector31, Vector3 paramVector32) {
/* 179 */     return boundsInFrustum(paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x / 2.0F, paramVector32.y / 2.0F, paramVector32.z / 2.0F);
/*     */   }
/*     */   
/*     */   public boolean boundsInFrustum(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/*     */     byte b;
/*     */     int i;
/* 185 */     for (b = 0, i = this.planes.length; b < i; b++) {
/* 186 */       if (this.planes[b].testPoint(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + paramFloat6) == Plane.PlaneSide.Back && 
/* 187 */         this.planes[b].testPoint(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 - paramFloat6) == Plane.PlaneSide.Back && 
/* 188 */         this.planes[b].testPoint(paramFloat1 + paramFloat4, paramFloat2 - paramFloat5, paramFloat3 + paramFloat6) == Plane.PlaneSide.Back && 
/* 189 */         this.planes[b].testPoint(paramFloat1 + paramFloat4, paramFloat2 - paramFloat5, paramFloat3 - paramFloat6) == Plane.PlaneSide.Back && 
/* 190 */         this.planes[b].testPoint(paramFloat1 - paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + paramFloat6) == Plane.PlaneSide.Back && 
/* 191 */         this.planes[b].testPoint(paramFloat1 - paramFloat4, paramFloat2 + paramFloat5, paramFloat3 - paramFloat6) == Plane.PlaneSide.Back && 
/* 192 */         this.planes[b].testPoint(paramFloat1 - paramFloat4, paramFloat2 - paramFloat5, paramFloat3 + paramFloat6) == Plane.PlaneSide.Back && 
/* 193 */         this.planes[b].testPoint(paramFloat1 - paramFloat4, paramFloat2 - paramFloat5, paramFloat3 - paramFloat6) == Plane.PlaneSide.Back) {
/* 194 */         return false;
/*     */       }
/*     */     } 
/* 197 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean boundsInFrustum(OrientedBoundingBox paramOrientedBoundingBox) {
/*     */     byte b;
/*     */     int i;
/* 205 */     for (b = 0, i = this.planes.length; b < i; b++) {
/* 206 */       if (this.planes[b].testPoint(paramOrientedBoundingBox.getCorner000(tmpV)) == Plane.PlaneSide.Back && 
/* 207 */         this.planes[b].testPoint(paramOrientedBoundingBox.getCorner001(tmpV)) == Plane.PlaneSide.Back && 
/* 208 */         this.planes[b].testPoint(paramOrientedBoundingBox.getCorner010(tmpV)) == Plane.PlaneSide.Back && 
/* 209 */         this.planes[b].testPoint(paramOrientedBoundingBox.getCorner011(tmpV)) == Plane.PlaneSide.Back && 
/* 210 */         this.planes[b].testPoint(paramOrientedBoundingBox.getCorner100(tmpV)) == Plane.PlaneSide.Back && 
/* 211 */         this.planes[b].testPoint(paramOrientedBoundingBox.getCorner101(tmpV)) == Plane.PlaneSide.Back && 
/* 212 */         this.planes[b].testPoint(paramOrientedBoundingBox.getCorner110(tmpV)) == Plane.PlaneSide.Back && 
/* 213 */         this.planes[b].testPoint(paramOrientedBoundingBox.getCorner111(tmpV)) == Plane.PlaneSide.Back) {
/* 214 */         return false;
/*     */       }
/*     */     } 
/* 217 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Frustum.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */