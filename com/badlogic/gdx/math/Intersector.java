/*      */ package com.badlogic.gdx.math;
/*      */ 
/*      */ import com.badlogic.gdx.math.collision.BoundingBox;
/*      */ import com.badlogic.gdx.math.collision.OrientedBoundingBox;
/*      */ import com.badlogic.gdx.math.collision.Ray;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.FloatArray;
/*      */ import java.util.Arrays;
/*      */ import java.util.List;
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
/*      */ public final class Intersector
/*      */ {
/*   37 */   private static final Vector3 v0 = new Vector3();
/*   38 */   private static final Vector3 v1 = new Vector3();
/*   39 */   private static final Vector3 v2 = new Vector3();
/*   40 */   private static final FloatArray floatArray = new FloatArray();
/*   41 */   private static final FloatArray floatArray2 = new FloatArray();
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
/*      */   public static boolean isPointInTriangle(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34) {
/*   53 */     v0.set(paramVector32).sub(paramVector31);
/*   54 */     v1.set(paramVector33).sub(paramVector31);
/*   55 */     v2.set(paramVector34).sub(paramVector31);
/*      */     
/*   57 */     v1.crs(v2);
/*   58 */     v2.crs(v0);
/*      */     
/*   60 */     if (v1.dot(v2) < 0.0F) return false; 
/*   61 */     v0.crs(v2.set(paramVector33).sub(paramVector31));
/*   62 */     return (v1.dot(v0) >= 0.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isPointInTriangle(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24) {
/*   67 */     return isPointInTriangle(paramVector21.x, paramVector21.y, paramVector22.x, paramVector22.y, paramVector23.x, paramVector23.y, paramVector24.x, paramVector24.y);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isPointInTriangle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
/*   72 */     float f1 = paramFloat1 - paramFloat3;
/*   73 */     float f2 = paramFloat2 - paramFloat4;
/*   74 */     boolean bool = ((paramFloat5 - paramFloat3) * f2 - (paramFloat6 - paramFloat4) * f1 > 0.0F) ? true : false;
/*   75 */     if ((((paramFloat7 - paramFloat3) * f2 - (paramFloat8 - paramFloat4) * f1 > 0.0F) ? true : false) == bool) return false; 
/*   76 */     if ((((paramFloat7 - paramFloat5) * (paramFloat2 - paramFloat6) - (paramFloat8 - paramFloat6) * (paramFloat1 - paramFloat5) > 0.0F) ? true : false) != bool) return false; 
/*   77 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean intersectSegmentPlane(Vector3 paramVector31, Vector3 paramVector32, Plane paramPlane, Vector3 paramVector33) {
/*      */     float f2;
/*   83 */     if ((f2 = (paramVector32 = v0.set(paramVector32).sub(paramVector31)).dot(paramPlane.getNormal())) == 0.0F) return false; 
/*      */     float f1;
/*   85 */     if ((f1 = -(paramVector31.dot(paramPlane.getNormal()) + paramPlane.getD()) / f2) < 0.0F || f1 > 1.0F) return false;
/*      */     
/*   87 */     paramVector33.set(paramVector31).add(paramVector32.scl(f1));
/*   88 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int pointLineSide(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23) {
/*   95 */     return (int)Math.signum((paramVector22.x - paramVector21.x) * (paramVector23.y - paramVector21.y) - (paramVector22.y - paramVector21.y) * (paramVector23.x - paramVector21.x));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int pointLineSide(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/*  101 */     return 
/*  102 */       (int)Math.signum((paramFloat3 - paramFloat1) * (paramFloat6 - paramFloat2) - (paramFloat4 - paramFloat2) * (paramFloat5 - paramFloat1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isPointInPolygon(Array<Vector2> paramArray, Vector2 paramVector2) {
/*  109 */     Vector2 vector2 = (Vector2)paramArray.peek();
/*  110 */     float f2 = paramVector2.x, f1 = paramVector2.y;
/*  111 */     boolean bool = false;
/*  112 */     for (byte b = 0; b < paramArray.size; b++) {
/*      */       Vector2 vector21;
/*  114 */       if ((((vector21 = (Vector2)paramArray.get(b)).y < f1 && vector2.y >= f1) || (vector2.y < f1 && vector21.y >= f1)) && 
/*  115 */         vector21.x + (f1 - vector21.y) / (vector2.y - vector21.y) * (vector2.x - vector21.x) < f2) bool = !bool ? true : false;
/*      */       
/*  117 */       vector2 = vector21;
/*      */     } 
/*  119 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isPointInPolygon(float[] paramArrayOffloat, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2) {
/*  126 */     boolean bool = false;
/*  127 */     float f1 = paramArrayOffloat[paramInt1], f2 = paramArrayOffloat[paramInt1 + 1], f3 = f2;
/*  128 */     int i = paramInt1 + 3;
/*  129 */     for (paramInt1 += paramInt2; i < paramInt1; i += 2) {
/*      */       float f4; float f5;
/*  131 */       if ((((f4 = paramArrayOffloat[i]) < paramFloat2 && f3 >= paramFloat2) || (f3 < paramFloat2 && f4 >= paramFloat2)) && (
/*      */         
/*  133 */         f5 = paramArrayOffloat[i - 1]) + (paramFloat2 - f4) / (f3 - f4) * (paramArrayOffloat[i - 3] - f5) < paramFloat1) bool = !bool ? true : false;
/*      */       
/*  135 */       f3 = f4;
/*      */     } 
/*  137 */     if (((f2 < paramFloat2 && f3 >= paramFloat2) || (f3 < paramFloat2 && f2 >= paramFloat2)) && 
/*  138 */       f1 + (paramFloat2 - f2) / (f3 - f2) * (paramArrayOffloat[i - 3] - f1) < paramFloat1) bool = !bool ? true : false;
/*      */     
/*  140 */     return bool;
/*      */   }
/*      */   
/*  143 */   private static final Vector2 ip = new Vector2();
/*  144 */   private static final Vector2 ep1 = new Vector2();
/*  145 */   private static final Vector2 ep2 = new Vector2();
/*  146 */   private static final Vector2 s = new Vector2();
/*  147 */   private static final Vector2 e = new Vector2();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectPolygons(Polygon paramPolygon1, Polygon paramPolygon2, Polygon paramPolygon3) {
/*  156 */     if ((paramPolygon1.getVertices()).length == 0 || (paramPolygon2.getVertices()).length == 0) {
/*  157 */       return false;
/*      */     }
/*  159 */     Vector2 vector21 = ip, vector22 = ep1, vector23 = ep2, vector24 = s, vector25 = e;
/*  160 */     FloatArray floatArray1 = floatArray, floatArray2 = floatArray2;
/*  161 */     floatArray1.clear();
/*  162 */     floatArray2.clear();
/*  163 */     floatArray2.addAll(paramPolygon1.getTransformedVertices());
/*  164 */     float[] arrayOfFloat = paramPolygon2.getTransformedVertices(); byte b; int i;
/*  165 */     for (b = 0, i = arrayOfFloat.length - 2; b <= i; b += 2) {
/*  166 */       vector22.set(arrayOfFloat[b], arrayOfFloat[b + 1]);
/*      */       
/*  168 */       if (b < i) {
/*  169 */         vector23.set(arrayOfFloat[b + 2], arrayOfFloat[b + 3]);
/*      */       } else {
/*  171 */         vector23.set(arrayOfFloat[0], arrayOfFloat[1]);
/*  172 */       }  if (floatArray2.size == 0) return false; 
/*  173 */       vector24.set(floatArray2.get(floatArray2.size - 2), floatArray2.get(floatArray2.size - 1));
/*  174 */       for (byte b1 = 0; b1 < floatArray2.size; b1 += 2) {
/*  175 */         vector25.set(floatArray2.get(b1), floatArray2.get(b1 + 1));
/*      */         
/*  177 */         boolean bool = (pointLineSide(vector23, vector22, vector24) > 0) ? true : false;
/*  178 */         if (pointLineSide(vector23, vector22, vector25) > 0) {
/*  179 */           if (!bool) {
/*  180 */             intersectLines(vector24, vector25, vector22, vector23, vector21);
/*  181 */             if (floatArray1.size < 2 || floatArray1.get(floatArray1.size - 2) != vector21.x || floatArray1
/*  182 */               .get(floatArray1.size - 1) != vector21.y) {
/*  183 */               floatArray1.add(vector21.x);
/*  184 */               floatArray1.add(vector21.y);
/*      */             } 
/*      */           } 
/*  187 */           floatArray1.add(vector25.x);
/*  188 */           floatArray1.add(vector25.y);
/*  189 */         } else if (bool) {
/*  190 */           intersectLines(vector24, vector25, vector22, vector23, vector21);
/*  191 */           floatArray1.add(vector21.x);
/*  192 */           floatArray1.add(vector21.y);
/*      */         } 
/*  194 */         vector24.set(vector25.x, vector25.y);
/*      */       } 
/*  196 */       floatArray2.clear();
/*  197 */       floatArray2.addAll(floatArray1);
/*  198 */       floatArray1.clear();
/*      */     } 
/*      */     
/*  201 */     if (floatArray2.size >= 6) {
/*  202 */       if (paramPolygon3 != null)
/*  203 */         if ((paramPolygon3.getVertices()).length == floatArray2.size) {
/*  204 */           System.arraycopy(floatArray2.items, 0, paramPolygon3.getVertices(), 0, floatArray2.size);
/*      */         } else {
/*  206 */           paramPolygon3.setVertices(floatArray2.toArray());
/*      */         }  
/*  208 */       return true;
/*      */     } 
/*  210 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean intersectPolygons(FloatArray paramFloatArray1, FloatArray paramFloatArray2) {
/*  215 */     if (isPointInPolygon(paramFloatArray1.items, 0, paramFloatArray1.size, paramFloatArray2.items[0], paramFloatArray2.items[1])) return true; 
/*  216 */     if (isPointInPolygon(paramFloatArray2.items, 0, paramFloatArray2.size, paramFloatArray1.items[0], paramFloatArray1.items[1])) return true; 
/*  217 */     return intersectPolygonEdges(paramFloatArray1, paramFloatArray2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean intersectPolygonEdges(FloatArray paramFloatArray1, FloatArray paramFloatArray2) {
/*  222 */     int i = paramFloatArray1.size - 2, j = paramFloatArray2.size - 2;
/*  223 */     float[] arrayOfFloat1 = paramFloatArray1.items, arrayOfFloat2 = paramFloatArray2.items;
/*  224 */     float f1 = arrayOfFloat1[i], f2 = arrayOfFloat1[i + 1];
/*  225 */     for (byte b = 0; b <= i; b += 2) {
/*  226 */       float f3 = arrayOfFloat1[b], f4 = arrayOfFloat1[b + 1];
/*  227 */       float f5 = arrayOfFloat2[j], f6 = arrayOfFloat2[j + 1];
/*  228 */       for (byte b1 = 0; b1 <= j; b1 += 2) {
/*  229 */         float f7 = arrayOfFloat2[b1], f8 = arrayOfFloat2[b1 + 1];
/*  230 */         if (intersectSegments(f1, f2, f3, f4, f5, f6, f7, f8, null)) return true; 
/*  231 */         f5 = f7;
/*  232 */         f6 = f8;
/*      */       } 
/*  234 */       f1 = f3;
/*  235 */       f2 = f4;
/*      */     } 
/*  237 */     return false;
/*      */   }
/*      */   
/*  240 */   static Vector2 v2a = new Vector2();
/*  241 */   static Vector2 v2b = new Vector2();
/*  242 */   static Vector2 v2c = new Vector2();
/*  243 */   static Vector2 v2d = new Vector2();
/*      */ 
/*      */   
/*      */   public static float distanceLinePoint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/*  247 */     float f = Vector2.len(paramFloat3 - paramFloat1, paramFloat4 - paramFloat2);
/*  248 */     return Math.abs((paramFloat5 - paramFloat1) * (paramFloat4 - paramFloat2) - (paramFloat6 - paramFloat2) * (paramFloat3 - paramFloat1)) / f;
/*      */   }
/*      */ 
/*      */   
/*      */   public static float distanceSegmentPoint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/*  253 */     return nearestSegmentPoint(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, v2a).dst(paramFloat5, paramFloat6);
/*      */   }
/*      */ 
/*      */   
/*      */   public static float distanceSegmentPoint(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23) {
/*  258 */     return nearestSegmentPoint(paramVector21, paramVector22, paramVector23, v2a).dst(paramVector23);
/*      */   }
/*      */ 
/*      */   
/*      */   public static Vector2 nearestSegmentPoint(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24) {
/*      */     float f2;
/*  264 */     if ((f2 = paramVector21.dst2(paramVector22)) == 0.0F) return paramVector24.set(paramVector21); 
/*      */     float f1;
/*  266 */     if ((f1 = ((paramVector23.x - paramVector21.x) * (paramVector22.x - paramVector21.x) + (paramVector23.y - paramVector21.y) * (paramVector22.y - paramVector21.y)) / f2) <= 0.0F) return paramVector24.set(paramVector21); 
/*  267 */     if (f1 >= 1.0F) return paramVector24.set(paramVector22); 
/*  268 */     return paramVector24.set(paramVector21.x + f1 * (paramVector22.x - paramVector21.x), paramVector21.y + f1 * (paramVector22.y - paramVector21.y));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static Vector2 nearestSegmentPoint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Vector2 paramVector2) {
/*  274 */     float f1 = paramFloat3 - paramFloat1;
/*  275 */     float f2 = paramFloat4 - paramFloat2;
/*      */     float f3;
/*  277 */     if ((f3 = f1 * f1 + f2 * f2) == 0.0F) return paramVector2.set(paramFloat1, paramFloat2);
/*      */     
/*  279 */     if ((paramFloat5 = ((paramFloat5 - paramFloat1) * f1 + (paramFloat6 - paramFloat2) * f2) / f3) <= 0.0F) return paramVector2.set(paramFloat1, paramFloat2); 
/*  280 */     if (paramFloat5 >= 1.0F) return paramVector2.set(paramFloat3, paramFloat4); 
/*  281 */     return paramVector2.set(paramFloat1 + paramFloat5 * f1, paramFloat2 + paramFloat5 * f2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectSegmentCircle(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, float paramFloat) {
/*  291 */     tmp.set(paramVector22.x - paramVector21.x, paramVector22.y - paramVector21.y, 0.0F);
/*  292 */     tmp1.set(paramVector23.x - paramVector21.x, paramVector23.y - paramVector21.y, 0.0F);
/*  293 */     float f3 = tmp.len();
/*      */     float f4;
/*  295 */     if ((f4 = tmp1.dot(tmp.nor())) <= 0.0F) {
/*  296 */       tmp2.set(paramVector21.x, paramVector21.y, 0.0F);
/*  297 */     } else if (f4 >= f3) {
/*  298 */       tmp2.set(paramVector22.x, paramVector22.y, 0.0F);
/*      */     } else {
/*  300 */       tmp3.set(tmp.scl(f4));
/*  301 */       tmp2.set(tmp3.x + paramVector21.x, tmp3.y + paramVector21.y, 0.0F);
/*      */     } 
/*      */     
/*  304 */     float f1 = paramVector23.x - tmp2.x;
/*  305 */     float f2 = paramVector23.y - tmp2.y;
/*      */     
/*  307 */     return (f1 * f1 + f2 * f2 <= paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectSegmentCircle(Vector2 paramVector21, Vector2 paramVector22, Circle paramCircle, MinimumTranslationVector paramMinimumTranslationVector) {
/*  317 */     v2a.set(paramVector22).sub(paramVector21);
/*  318 */     v2b.set(paramCircle.x - paramVector21.x, paramCircle.y - paramVector21.y);
/*  319 */     float f1 = v2a.len();
/*      */     float f2;
/*  321 */     if ((f2 = v2b.dot(v2a.nor())) <= 0.0F) {
/*  322 */       v2c.set(paramVector21);
/*  323 */     } else if (f2 >= f1) {
/*  324 */       v2c.set(paramVector22);
/*      */     } else {
/*  326 */       v2d.set(v2a.scl(f2));
/*  327 */       v2c.set(v2d).add(paramVector21);
/*      */     } 
/*      */     
/*  330 */     v2a.set(v2c.x - paramCircle.x, v2c.y - paramCircle.y);
/*      */     
/*  332 */     if (paramMinimumTranslationVector != null)
/*      */     {
/*  334 */       if (v2a.equals(Vector2.Zero)) {
/*  335 */         v2d.set(paramVector22.y - paramVector21.y, paramVector21.x - paramVector22.x);
/*  336 */         paramMinimumTranslationVector.normal.set(v2d).nor();
/*  337 */         paramMinimumTranslationVector.depth = paramCircle.radius;
/*      */       } else {
/*  339 */         paramMinimumTranslationVector.normal.set(v2a).nor();
/*  340 */         paramMinimumTranslationVector.depth = paramCircle.radius - v2a.len();
/*      */       } 
/*      */     }
/*      */     
/*  344 */     return (v2a.len2() <= paramCircle.radius * paramCircle.radius);
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
/*      */   public static boolean intersectFrustumBounds(Frustum paramFrustum, BoundingBox paramBoundingBox) {
/*      */     boolean bool;
/*  358 */     if (bool = (paramFrustum.pointInFrustum(paramBoundingBox.getCorner000(tmp)) || paramFrustum.pointInFrustum(paramBoundingBox.getCorner001(tmp)) || paramFrustum.pointInFrustum(paramBoundingBox.getCorner010(tmp)) || paramFrustum.pointInFrustum(paramBoundingBox.getCorner011(tmp)) || paramFrustum.pointInFrustum(paramBoundingBox.getCorner100(tmp)) || paramFrustum.pointInFrustum(paramBoundingBox.getCorner101(tmp)) || paramFrustum.pointInFrustum(paramBoundingBox.getCorner110(tmp)) || paramFrustum.pointInFrustum(paramBoundingBox.getCorner111(tmp)))) {
/*  359 */       return true;
/*      */     }
/*      */     
/*  362 */     bool = false; Vector3[] arrayOfVector3; int i; byte b;
/*  363 */     for (i = (arrayOfVector3 = paramFrustum.planePoints).length, b = 0; b < i; ) { Vector3 vector3 = arrayOfVector3[b];
/*  364 */       bool |= paramBoundingBox.contains(vector3); b++; }
/*      */     
/*  366 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectFrustumBounds(Frustum paramFrustum, OrientedBoundingBox paramOrientedBoundingBox) {
/*  375 */     boolean bool1 = false; Vector3[] arrayOfVector31;
/*      */     int j;
/*  377 */     for (int i = (arrayOfVector31 = paramOrientedBoundingBox.getVertices()).length; j < i; ) { Vector3 vector3 = arrayOfVector31[j];
/*  378 */       bool1 |= paramFrustum.pointInFrustum(vector3);
/*      */       j++; }
/*      */     
/*  381 */     if (bool1) {
/*  382 */       return true;
/*      */     }
/*      */     
/*  385 */     boolean bool2 = false; Vector3[] arrayOfVector32; byte b;
/*  386 */     for (j = (arrayOfVector32 = paramFrustum.planePoints).length, b = 0; b < j; ) { Vector3 vector3 = arrayOfVector32[b];
/*  387 */       bool2 |= paramOrientedBoundingBox.contains(vector3);
/*      */       b++; }
/*      */     
/*  390 */     return bool2;
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
/*      */   public static float intersectRayRay(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24) {
/*  403 */     float f4 = paramVector23.x - paramVector21.x;
/*  404 */     float f1 = paramVector23.y - paramVector21.y;
/*      */     float f2;
/*  406 */     if ((f2 = paramVector22.x * paramVector24.y - paramVector22.y * paramVector24.x) == 0.0F) {
/*  407 */       return Float.POSITIVE_INFINITY;
/*      */     }
/*  409 */     float f3 = paramVector24.x / f2;
/*  410 */     f2 = paramVector24.y / f2;
/*  411 */     return f4 * f2 - f1 * f3;
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
/*      */   public static boolean intersectRayPlane(Ray paramRay, Plane paramPlane, Vector3 paramVector3) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: getfield direction : Lcom/badlogic/gdx/math/Vector3;
/*      */     //   4: aload_1
/*      */     //   5: invokevirtual getNormal : ()Lcom/badlogic/gdx/math/Vector3;
/*      */     //   8: invokevirtual dot : (Lcom/badlogic/gdx/math/Vector3;)F
/*      */     //   11: dup
/*      */     //   12: fstore_3
/*      */     //   13: fconst_0
/*      */     //   14: fcmpl
/*      */     //   15: ifeq -> 78
/*      */     //   18: aload_0
/*      */     //   19: getfield origin : Lcom/badlogic/gdx/math/Vector3;
/*      */     //   22: aload_1
/*      */     //   23: invokevirtual getNormal : ()Lcom/badlogic/gdx/math/Vector3;
/*      */     //   26: invokevirtual dot : (Lcom/badlogic/gdx/math/Vector3;)F
/*      */     //   29: aload_1
/*      */     //   30: invokevirtual getD : ()F
/*      */     //   33: fadd
/*      */     //   34: fneg
/*      */     //   35: fload_3
/*      */     //   36: fdiv
/*      */     //   37: dup
/*      */     //   38: fstore_1
/*      */     //   39: fconst_0
/*      */     //   40: fcmpg
/*      */     //   41: ifge -> 46
/*      */     //   44: iconst_0
/*      */     //   45: ireturn
/*      */     //   46: aload_2
/*      */     //   47: ifnull -> 76
/*      */     //   50: aload_2
/*      */     //   51: aload_0
/*      */     //   52: getfield origin : Lcom/badlogic/gdx/math/Vector3;
/*      */     //   55: invokevirtual set : (Lcom/badlogic/gdx/math/Vector3;)Lcom/badlogic/gdx/math/Vector3;
/*      */     //   58: getstatic com/badlogic/gdx/math/Intersector.v0 : Lcom/badlogic/gdx/math/Vector3;
/*      */     //   61: aload_0
/*      */     //   62: getfield direction : Lcom/badlogic/gdx/math/Vector3;
/*      */     //   65: invokevirtual set : (Lcom/badlogic/gdx/math/Vector3;)Lcom/badlogic/gdx/math/Vector3;
/*      */     //   68: fload_1
/*      */     //   69: invokevirtual scl : (F)Lcom/badlogic/gdx/math/Vector3;
/*      */     //   72: invokevirtual add : (Lcom/badlogic/gdx/math/Vector3;)Lcom/badlogic/gdx/math/Vector3;
/*      */     //   75: pop
/*      */     //   76: iconst_1
/*      */     //   77: ireturn
/*      */     //   78: aload_1
/*      */     //   79: aload_0
/*      */     //   80: getfield origin : Lcom/badlogic/gdx/math/Vector3;
/*      */     //   83: invokevirtual testPoint : (Lcom/badlogic/gdx/math/Vector3;)Lcom/badlogic/gdx/math/Plane$PlaneSide;
/*      */     //   86: getstatic com/badlogic/gdx/math/Plane$PlaneSide.OnPlane : Lcom/badlogic/gdx/math/Plane$PlaneSide;
/*      */     //   89: if_acmpne -> 107
/*      */     //   92: aload_2
/*      */     //   93: ifnull -> 105
/*      */     //   96: aload_2
/*      */     //   97: aload_0
/*      */     //   98: getfield origin : Lcom/badlogic/gdx/math/Vector3;
/*      */     //   101: invokevirtual set : (Lcom/badlogic/gdx/math/Vector3;)Lcom/badlogic/gdx/math/Vector3;
/*      */     //   104: pop
/*      */     //   105: iconst_1
/*      */     //   106: ireturn
/*      */     //   107: iconst_0
/*      */     //   108: ireturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #419	-> 0
/*      */     //   #420	-> 12
/*      */     //   #421	-> 18
/*      */     //   #422	-> 38
/*      */     //   #424	-> 46
/*      */     //   #425	-> 76
/*      */     //   #426	-> 78
/*      */     //   #427	-> 92
/*      */     //   #428	-> 105
/*      */     //   #430	-> 107
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
/*      */   public static float intersectLinePlane(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Plane paramPlane, Vector3 paramVector3) {
/*  438 */     Vector3 vector32 = tmp.set(paramFloat4, paramFloat5, paramFloat6).sub(paramFloat1, paramFloat2, paramFloat3);
/*  439 */     Vector3 vector31 = tmp2.set(paramFloat1, paramFloat2, paramFloat3);
/*      */     
/*  441 */     if ((paramFloat2 = vector32.dot(paramPlane.getNormal())) != 0.0F) {
/*  442 */       paramFloat2 = -(vector31.dot(paramPlane.getNormal()) + paramPlane.getD()) / paramFloat2;
/*  443 */       if (paramVector3 != null) paramVector3.set(vector31).add(vector32.scl(paramFloat2)); 
/*  444 */       return paramFloat2;
/*  445 */     }  if (paramPlane.testPoint(vector31) == Plane.PlaneSide.OnPlane) {
/*  446 */       if (paramVector3 != null) paramVector3.set(vector31); 
/*  447 */       return 0.0F;
/*      */     } 
/*      */     
/*  450 */     return -1.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectPlanes(Plane paramPlane1, Plane paramPlane2, Plane paramPlane3, Vector3 paramVector3) {
/*  457 */     tmp1.set(paramPlane1.normal).crs(paramPlane2.normal);
/*  458 */     tmp2.set(paramPlane2.normal).crs(paramPlane3.normal);
/*  459 */     tmp3.set(paramPlane3.normal).crs(paramPlane1.normal);
/*      */     
/*      */     float f;
/*  462 */     if (Math.abs(f = -paramPlane1.normal.dot(tmp2)) < 1.0E-6F) {
/*  463 */       return false;
/*      */     }
/*      */     
/*  466 */     tmp1.scl(paramPlane3.d);
/*  467 */     tmp2.scl(paramPlane1.d);
/*  468 */     tmp3.scl(paramPlane2.d);
/*      */     
/*  470 */     paramVector3.set(tmp1.x + tmp2.x + tmp3.x, tmp1.y + tmp2.y + tmp3.y, tmp1.z + tmp2.z + tmp3.z);
/*  471 */     paramVector3.scl(1.0F / f);
/*  472 */     return true;
/*      */   }
/*      */   
/*  475 */   private static final Plane p = new Plane(new Vector3(), 0.0F);
/*  476 */   private static final Vector3 i = new Vector3();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectRayTriangle(Ray paramRay, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34) {
/*  485 */     Vector3 vector31 = v0.set(paramVector32).sub(paramVector31);
/*  486 */     Vector3 vector32 = v1.set(paramVector33).sub(paramVector31);
/*      */     
/*  488 */     Vector3 vector33 = v2.set(paramRay.direction).crs(vector32);
/*      */     float f4;
/*  490 */     if (MathUtils.isZero(f4 = vector31.dot(vector33))) {
/*  491 */       p.set(paramVector31, paramVector32, paramVector33);
/*  492 */       if (p.testPoint(paramRay.origin) == Plane.PlaneSide.OnPlane && isPointInTriangle(paramRay.origin, paramVector31, paramVector32, paramVector33)) {
/*  493 */         if (paramVector34 != null) paramVector34.set(paramRay.origin); 
/*  494 */         return true;
/*      */       } 
/*  496 */       return false;
/*      */     } 
/*      */     
/*  499 */     f4 = 1.0F / f4;
/*      */     
/*      */     float f2;
/*      */     
/*  503 */     if ((f2 = (paramVector31 = i.set(paramRay.origin).sub(paramVector31)).dot(vector33) * f4) < 0.0F || f2 > 1.0F) return false;
/*      */     
/*  505 */     paramVector31 = paramVector31.crs(vector31);
/*      */     float f3;
/*  507 */     if ((f3 = paramRay.direction.dot(paramVector31) * f4) < 0.0F || f2 + f3 > 1.0F) return false;
/*      */     
/*      */     float f1;
/*  510 */     if ((f1 = vector32.dot(paramVector31) * f4) < 0.0F) return false;
/*      */     
/*  512 */     if (paramVector34 != null) {
/*  513 */       if (f1 <= 1.0E-6F) {
/*  514 */         paramVector34.set(paramRay.origin);
/*      */       } else {
/*  516 */         paramRay.getEndPoint(paramVector34, f1);
/*      */       } 
/*      */     }
/*      */     
/*  520 */     return true;
/*      */   }
/*      */   
/*  523 */   private static final Vector3 dir = new Vector3();
/*  524 */   private static final Vector3 start = new Vector3();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectRaySphere(Ray paramRay, Vector3 paramVector31, float paramFloat, Vector3 paramVector32) {
/*      */     float f2;
/*  534 */     if ((f2 = paramRay.direction.dot(paramVector31.x - paramRay.origin.x, paramVector31.y - paramRay.origin.y, paramVector31.z - paramRay.origin.z)) < 0.0F)
/*  535 */       return false; 
/*  536 */     float f1 = paramVector31.dst2(paramRay.origin.x + paramRay.direction.x * f2, paramRay.origin.y + paramRay.direction.y * f2, paramRay.origin.z + paramRay.direction.z * f2);
/*      */     
/*  538 */     paramFloat *= paramFloat;
/*  539 */     if (f1 > paramFloat) return false; 
/*  540 */     if (paramVector32 != null) paramVector32.set(paramRay.direction).scl(f2 - (float)Math.sqrt((paramFloat - f1))).add(paramRay.origin); 
/*  541 */     return true;
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
/*      */   public static boolean intersectRayBounds(Ray paramRay, BoundingBox paramBoundingBox, Vector3 paramVector3) {
/*  559 */     if (paramBoundingBox.contains(paramRay.origin)) {
/*  560 */       if (paramVector3 != null) paramVector3.set(paramRay.origin); 
/*  561 */       return true;
/*      */     } 
/*  563 */     float f1 = 0.0F;
/*  564 */     boolean bool = false;
/*      */     
/*      */     float f2;
/*  567 */     if (paramRay.origin.x <= paramBoundingBox.min.x && paramRay.direction.x > 0.0F && (
/*      */       
/*  569 */       f2 = (paramBoundingBox.min.x - paramRay.origin.x) / paramRay.direction.x) >= 0.0F) {
/*  570 */       v2.set(paramRay.direction).scl(f2).add(paramRay.origin);
/*  571 */       if (v2.y >= paramBoundingBox.min.y && v2.y <= paramBoundingBox.max.y && v2.z >= paramBoundingBox.min.z && v2.z <= paramBoundingBox.max.z) {
/*  572 */         bool = true;
/*  573 */         f1 = f2;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  578 */     if (paramRay.origin.x >= paramBoundingBox.max.x && paramRay.direction.x < 0.0F && (
/*      */       
/*  580 */       f2 = (paramBoundingBox.max.x - paramRay.origin.x) / paramRay.direction.x) >= 0.0F) {
/*  581 */       v2.set(paramRay.direction).scl(f2).add(paramRay.origin);
/*  582 */       if (v2.y >= paramBoundingBox.min.y && v2.y <= paramBoundingBox.max.y && v2.z >= paramBoundingBox.min.z && v2.z <= paramBoundingBox.max.z && (!bool || f2 < f1)) {
/*  583 */         bool = true;
/*  584 */         f1 = f2;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  589 */     if (paramRay.origin.y <= paramBoundingBox.min.y && paramRay.direction.y > 0.0F && (
/*      */       
/*  591 */       f2 = (paramBoundingBox.min.y - paramRay.origin.y) / paramRay.direction.y) >= 0.0F) {
/*  592 */       v2.set(paramRay.direction).scl(f2).add(paramRay.origin);
/*  593 */       if (v2.x >= paramBoundingBox.min.x && v2.x <= paramBoundingBox.max.x && v2.z >= paramBoundingBox.min.z && v2.z <= paramBoundingBox.max.z && (!bool || f2 < f1)) {
/*  594 */         bool = true;
/*  595 */         f1 = f2;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  600 */     if (paramRay.origin.y >= paramBoundingBox.max.y && paramRay.direction.y < 0.0F && (
/*      */       
/*  602 */       f2 = (paramBoundingBox.max.y - paramRay.origin.y) / paramRay.direction.y) >= 0.0F) {
/*  603 */       v2.set(paramRay.direction).scl(f2).add(paramRay.origin);
/*  604 */       if (v2.x >= paramBoundingBox.min.x && v2.x <= paramBoundingBox.max.x && v2.z >= paramBoundingBox.min.z && v2.z <= paramBoundingBox.max.z && (!bool || f2 < f1)) {
/*  605 */         bool = true;
/*  606 */         f1 = f2;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  611 */     if (paramRay.origin.z <= paramBoundingBox.min.z && paramRay.direction.z > 0.0F && (
/*      */       
/*  613 */       f2 = (paramBoundingBox.min.z - paramRay.origin.z) / paramRay.direction.z) >= 0.0F) {
/*  614 */       v2.set(paramRay.direction).scl(f2).add(paramRay.origin);
/*  615 */       if (v2.x >= paramBoundingBox.min.x && v2.x <= paramBoundingBox.max.x && v2.y >= paramBoundingBox.min.y && v2.y <= paramBoundingBox.max.y && (!bool || f2 < f1)) {
/*  616 */         bool = true;
/*  617 */         f1 = f2;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  622 */     if (paramRay.origin.z >= paramBoundingBox.max.z && paramRay.direction.z < 0.0F && (
/*      */       
/*  624 */       f2 = (paramBoundingBox.max.z - paramRay.origin.z) / paramRay.direction.z) >= 0.0F) {
/*  625 */       v2.set(paramRay.direction).scl(f2).add(paramRay.origin);
/*  626 */       if (v2.x >= paramBoundingBox.min.x && v2.x <= paramBoundingBox.max.x && v2.y >= paramBoundingBox.min.y && v2.y <= paramBoundingBox.max.y && (!bool || f2 < f1)) {
/*  627 */         bool = true;
/*  628 */         f1 = f2;
/*      */       } 
/*      */     } 
/*      */     
/*  632 */     if (bool && paramVector3 != null) {
/*  633 */       paramVector3.set(paramRay.direction).scl(f1).add(paramRay.origin);
/*  634 */       if (paramVector3.x < paramBoundingBox.min.x) {
/*  635 */         paramVector3.x = paramBoundingBox.min.x;
/*  636 */       } else if (paramVector3.x > paramBoundingBox.max.x) {
/*  637 */         paramVector3.x = paramBoundingBox.max.x;
/*      */       } 
/*  639 */       if (paramVector3.y < paramBoundingBox.min.y) {
/*  640 */         paramVector3.y = paramBoundingBox.min.y;
/*  641 */       } else if (paramVector3.y > paramBoundingBox.max.y) {
/*  642 */         paramVector3.y = paramBoundingBox.max.y;
/*      */       } 
/*  644 */       if (paramVector3.z < paramBoundingBox.min.z) {
/*  645 */         paramVector3.z = paramBoundingBox.min.z;
/*  646 */       } else if (paramVector3.z > paramBoundingBox.max.z) {
/*  647 */         paramVector3.z = paramBoundingBox.max.z;
/*      */       } 
/*      */     } 
/*  650 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectRayBoundsFast(Ray paramRay, BoundingBox paramBoundingBox) {
/*  656 */     return intersectRayBoundsFast(paramRay, paramBoundingBox.getCenter(tmp1), paramBoundingBox.getDimensions(tmp2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectRayBoundsFast(Ray paramRay, Vector3 paramVector31, Vector3 paramVector32) {
/*  664 */     float f3 = 1.0F / paramRay.direction.x;
/*  665 */     float f4 = 1.0F / paramRay.direction.y;
/*  666 */     float f5 = 1.0F / paramRay.direction.z;
/*      */     
/*  668 */     float f6 = (paramVector31.x - paramVector32.x * 0.5F - paramRay.origin.x) * f3;
/*  669 */     f3 = (paramVector31.x + paramVector32.x * 0.5F - paramRay.origin.x) * f3;
/*  670 */     if (f6 > f3) {
/*  671 */       float f = f6;
/*  672 */       f6 = f3;
/*  673 */       f3 = f;
/*      */     } 
/*      */     
/*  676 */     float f7 = (paramVector31.y - paramVector32.y * 0.5F - paramRay.origin.y) * f4;
/*  677 */     f4 = (paramVector31.y + paramVector32.y * 0.5F - paramRay.origin.y) * f4;
/*  678 */     if (f7 > f4) {
/*  679 */       float f = f7;
/*  680 */       f7 = f4;
/*  681 */       f4 = f;
/*      */     } 
/*      */     
/*  684 */     float f8 = (paramVector31.z - paramVector32.z * 0.5F - paramRay.origin.z) * f5;
/*  685 */     float f1 = (paramVector31.z + paramVector32.z * 0.5F - paramRay.origin.z) * f5;
/*  686 */     if (f8 > f1) {
/*  687 */       float f = f8;
/*  688 */       f8 = f1;
/*  689 */       f1 = f;
/*      */     } 
/*      */     
/*  692 */     float f2 = Math.max(Math.max(f6, f7), f8);
/*      */ 
/*      */     
/*  695 */     if ((f1 = Math.min(Math.min(f3, f4), f1)) >= 0.0F && f1 >= f2) return true;  return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectRayOrientedBoundsFast(Ray paramRay, OrientedBoundingBox paramOrientedBoundingBox) {
/*  702 */     return intersectRayOrientedBounds(paramRay, paramOrientedBoundingBox, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectRayOrientedBoundsFast(Ray paramRay, BoundingBox paramBoundingBox, Matrix4 paramMatrix4) {
/*  710 */     return intersectRayOrientedBounds(paramRay, paramBoundingBox, paramMatrix4, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectRayOrientedBounds(Ray paramRay, OrientedBoundingBox paramOrientedBoundingBox, Vector3 paramVector3) {
/*  718 */     BoundingBox boundingBox = paramOrientedBoundingBox.getBounds();
/*  719 */     Matrix4 matrix4 = paramOrientedBoundingBox.getTransform();
/*  720 */     return intersectRayOrientedBounds(paramRay, boundingBox, matrix4, paramVector3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectRayOrientedBounds(Ray paramRay, BoundingBox paramBoundingBox, Matrix4 paramMatrix4, Vector3 paramVector3) {
/*  729 */     float f1, f2 = 0.0F;
/*  730 */     float f3 = Float.MAX_VALUE;
/*      */ 
/*      */ 
/*      */     
/*  734 */     Vector3 vector31, vector32 = (vector31 = paramMatrix4.getTranslation(tmp)).sub(paramRay.origin);
/*      */ 
/*      */     
/*  737 */     vector31 = tmp1;
/*  738 */     tmp1.set(paramMatrix4.val[0], paramMatrix4.val[1], paramMatrix4.val[2]);
/*  739 */     float f4 = vector31.dot(vector32);
/*      */     
/*      */     float f7;
/*  742 */     if (Math.abs(f7 = paramRay.direction.dot(vector31)) > 1.0E-6F) {
/*  743 */       float f = (f4 + paramBoundingBox.min.x) / f7;
/*  744 */       f4 = (f4 + paramBoundingBox.max.x) / f7;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  749 */       if (f > f4) {
/*  750 */         f7 = f;
/*  751 */         f = f4;
/*  752 */         f4 = f7;
/*      */       } 
/*      */       
/*  755 */       if (f4 < Float.MAX_VALUE) {
/*  756 */         f3 = f4;
/*      */       }
/*      */       
/*  759 */       if (f > 0.0F) {
/*  760 */         f2 = f;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  765 */       if (f3 < f2) {
/*  766 */         return false;
/*      */       }
/*      */     }
/*  769 */     else if (-f4 + paramBoundingBox.min.x > 0.0F || -f4 + paramBoundingBox.max.x < 0.0F) {
/*  770 */       return false;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  775 */     Vector3 vector34 = tmp2;
/*  776 */     tmp2.set(paramMatrix4.val[4], paramMatrix4.val[5], paramMatrix4.val[6]);
/*      */     
/*  778 */     f4 = vector34.dot(vector32);
/*      */     
/*      */     float f6;
/*  781 */     if (Math.abs(f6 = paramRay.direction.dot(vector34)) > 1.0E-6F) {
/*  782 */       float f = (f4 + paramBoundingBox.min.y) / f6;
/*  783 */       f4 = (f4 + paramBoundingBox.max.y) / f6;
/*      */       
/*  785 */       if (f > f4) {
/*  786 */         f6 = f;
/*  787 */         f = f4;
/*  788 */         f4 = f6;
/*      */       } 
/*  790 */       if (f4 < f3) {
/*  791 */         f3 = f4;
/*      */       }
/*  793 */       if (f > f2) {
/*  794 */         f2 = f;
/*      */       }
/*  796 */       if (f2 > f3) {
/*  797 */         return false;
/*      */       }
/*      */     }
/*  800 */     else if (-f4 + paramBoundingBox.min.y > 0.0F || -f4 + paramBoundingBox.max.y < 0.0F) {
/*  801 */       return false;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  806 */     Vector3 vector33 = tmp3;
/*  807 */     tmp3.set(paramMatrix4.val[8], paramMatrix4.val[9], paramMatrix4.val[10]);
/*      */     
/*  809 */     f4 = vector33.dot(vector32);
/*      */     
/*      */     float f5;
/*  812 */     if (Math.abs(f5 = paramRay.direction.dot(vector33)) > 1.0E-6F) {
/*  813 */       float f = (f4 + paramBoundingBox.min.z) / f5;
/*  814 */       f4 = (f4 + paramBoundingBox.max.z) / f5;
/*      */       
/*  816 */       if (f > f4) {
/*  817 */         f1 = f;
/*  818 */         f = f4;
/*  819 */         f4 = f1;
/*      */       } 
/*  821 */       if (f4 < f3) {
/*  822 */         f3 = f4;
/*      */       }
/*  824 */       if (f > f2) {
/*  825 */         f2 = f;
/*      */       }
/*  827 */       if (f2 > f3) {
/*  828 */         return false;
/*      */       }
/*  830 */     } else if (-f4 + f1.min.z > 0.0F || -f4 + f1.max.z < 0.0F) {
/*  831 */       return false;
/*      */     } 
/*      */     
/*  834 */     if (paramVector3 != null) {
/*  835 */       paramRay.getEndPoint(paramVector3, f2);
/*      */     }
/*      */     
/*  838 */     return true;
/*      */   }
/*      */   
/*  841 */   static Vector3 best = new Vector3();
/*  842 */   static Vector3 tmp = new Vector3();
/*  843 */   static Vector3 tmp1 = new Vector3();
/*  844 */   static Vector3 tmp2 = new Vector3();
/*  845 */   static Vector3 tmp3 = new Vector3();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectRayTriangles(Ray paramRay, float[] paramArrayOffloat, Vector3 paramVector3) {
/*  853 */     float f = Float.MAX_VALUE;
/*  854 */     boolean bool = false;
/*      */     
/*  856 */     if (paramArrayOffloat.length % 9 != 0) throw new RuntimeException("triangles array size is not a multiple of 9");
/*      */     
/*  858 */     for (byte b = 0; b < paramArrayOffloat.length; b += 9) {
/*      */       float f1;
/*      */       
/*      */       boolean bool1;
/*      */       
/*  863 */       if ((bool1 = intersectRayTriangle(paramRay, tmp1.set(paramArrayOffloat[b], paramArrayOffloat[b + 1], paramArrayOffloat[b + 2]), tmp2.set(paramArrayOffloat[b + 3], paramArrayOffloat[b + 4], paramArrayOffloat[b + 5]), tmp3.set(paramArrayOffloat[b + 6], paramArrayOffloat[b + 7], paramArrayOffloat[b + 8]), tmp)) && (
/*      */         
/*  865 */         f1 = paramRay.origin.dst2(tmp)) < f) {
/*  866 */         f = f1;
/*  867 */         best.set(tmp);
/*  868 */         bool = true;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  873 */     if (!bool) {
/*  874 */       return false;
/*      */     }
/*  876 */     if (paramVector3 != null) paramVector3.set(best); 
/*  877 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectRayTriangles(Ray paramRay, float[] paramArrayOffloat, short[] paramArrayOfshort, int paramInt, Vector3 paramVector3) {
/*  888 */     float f = Float.MAX_VALUE;
/*  889 */     boolean bool = false;
/*      */     
/*  891 */     if (paramArrayOfshort.length % 3 != 0) throw new RuntimeException("triangle list size is not a multiple of 3");
/*      */     
/*  893 */     for (byte b = 0; b < paramArrayOfshort.length; b += 3) {
/*  894 */       int i = paramArrayOfshort[b] * paramInt;
/*  895 */       int j = paramArrayOfshort[b + 1] * paramInt;
/*  896 */       int k = paramArrayOfshort[b + 2] * paramInt;
/*      */       
/*      */       float f1;
/*      */       
/*      */       boolean bool1;
/*      */       
/*  902 */       if ((bool1 = intersectRayTriangle(paramRay, tmp1.set(paramArrayOffloat[i], paramArrayOffloat[i + 1], paramArrayOffloat[i + 2]), tmp2.set(paramArrayOffloat[j], paramArrayOffloat[j + 1], paramArrayOffloat[j + 2]), tmp3.set(paramArrayOffloat[k], paramArrayOffloat[k + 1], paramArrayOffloat[k + 2]), tmp)) && (
/*      */         
/*  904 */         f1 = paramRay.origin.dst2(tmp)) < f) {
/*  905 */         f = f1;
/*  906 */         best.set(tmp);
/*  907 */         bool = true;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  912 */     if (!bool) {
/*  913 */       return false;
/*      */     }
/*  915 */     if (paramVector3 != null) paramVector3.set(best); 
/*  916 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectRayTriangles(Ray paramRay, List<Vector3> paramList, Vector3 paramVector3) {
/*  925 */     float f = Float.MAX_VALUE;
/*  926 */     boolean bool = false;
/*      */     
/*  928 */     if (paramList.size() % 3 != 0) throw new RuntimeException("triangle list size is not a multiple of 3");
/*      */     
/*  930 */     for (byte b = 0; b < paramList.size(); b += 3) {
/*      */       float f1;
/*      */       boolean bool1;
/*  933 */       if ((bool1 = intersectRayTriangle(paramRay, paramList.get(b), paramList.get(b + 1), paramList.get(b + 2), tmp)) && (
/*      */         
/*  935 */         f1 = paramRay.origin.dst2(tmp)) < f) {
/*  936 */         f = f1;
/*  937 */         best.set(tmp);
/*  938 */         bool = true;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  943 */     if (!bool) {
/*  944 */       return false;
/*      */     }
/*  946 */     if (paramVector3 != null) paramVector3.set(best); 
/*  947 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectBoundsPlaneFast(BoundingBox paramBoundingBox, Plane paramPlane) {
/*  954 */     return intersectBoundsPlaneFast(paramBoundingBox.getCenter(tmp1), paramBoundingBox.getDimensions(tmp2).scl(0.5F), paramPlane.normal, paramPlane.d);
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
/*      */   public static boolean intersectBoundsPlaneFast(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, float paramFloat) {
/*  966 */     float f2 = paramVector32.x * Math.abs(paramVector33.x) + paramVector32.y * Math.abs(paramVector33.y) + paramVector32.z * Math.abs(paramVector33.z);
/*      */ 
/*      */     
/*      */     float f1;
/*      */ 
/*      */     
/*  972 */     return (Math.abs(f1 = paramVector33.dot(paramVector31) - paramFloat) <= f2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectLines(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24, Vector2 paramVector25) {
/*  983 */     return intersectLines(paramVector21.x, paramVector21.y, paramVector22.x, paramVector22.y, paramVector23.x, paramVector23.y, paramVector24.x, paramVector24.y, paramVector25);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectLines(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, Vector2 paramVector2) {
/*      */     float f;
/*  992 */     if ((f = (paramFloat8 - paramFloat6) * (paramFloat3 - paramFloat1) - (paramFloat7 - paramFloat5) * (paramFloat4 - paramFloat2)) == 0.0F) return false;
/*      */     
/*  994 */     if (paramVector2 != null) {
/*  995 */       paramFloat5 = ((paramFloat7 - paramFloat5) * (paramFloat2 - paramFloat6) - (paramFloat8 - paramFloat6) * (paramFloat1 - paramFloat5)) / f;
/*  996 */       paramVector2.set(paramFloat1 + (paramFloat3 - paramFloat1) * paramFloat5, paramFloat2 + (paramFloat4 - paramFloat2) * paramFloat5);
/*      */     } 
/*  998 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectLinePolygon(Vector2 paramVector21, Vector2 paramVector22, Polygon paramPolygon) {
/* 1006 */     float[] arrayOfFloat = paramPolygon.getTransformedVertices();
/* 1007 */     float f3 = paramVector21.x, f1 = paramVector21.y, f4 = paramVector22.x, f2 = paramVector22.y;
/* 1008 */     int i = arrayOfFloat.length;
/* 1009 */     float f5 = arrayOfFloat[i - 2], f6 = arrayOfFloat[i - 1];
/* 1010 */     for (byte b = 0; b < i; b += 2) {
/* 1011 */       float f7 = arrayOfFloat[b];
/*      */ 
/*      */       
/* 1014 */       float f10 = f1 - f6;
/* 1015 */       float f11 = f3 - f5;
/*      */       float f8, f9;
/* 1017 */       if ((f9 = ((f8 = arrayOfFloat[b + 1]) - f6) * (f4 - f3) - (f7 - f5) * (f2 - f1)) != 0.0F && (f5 = ((f7 - f5) * f10 - (f8 - f6) * f11) / f9) >= 0.0F && f5 <= 1.0F) {
/* 1018 */         return true;
/*      */       }
/*      */       
/* 1021 */       f5 = f7;
/* 1022 */       f6 = f8;
/*      */     } 
/* 1024 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectRectangles(Rectangle paramRectangle1, Rectangle paramRectangle2, Rectangle paramRectangle3) {
/* 1031 */     if (paramRectangle1.overlaps(paramRectangle2)) {
/* 1032 */       paramRectangle3.x = Math.max(paramRectangle1.x, paramRectangle2.x);
/* 1033 */       paramRectangle3.width = Math.min(paramRectangle1.x + paramRectangle1.width, paramRectangle2.x + paramRectangle2.width) - paramRectangle3.x;
/* 1034 */       paramRectangle3.y = Math.max(paramRectangle1.y, paramRectangle2.y);
/* 1035 */       paramRectangle3.height = Math.min(paramRectangle1.y + paramRectangle1.height, paramRectangle2.y + paramRectangle2.height) - paramRectangle3.y;
/* 1036 */       return true;
/*      */     } 
/* 1038 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectSegmentRectangle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Rectangle paramRectangle) {
/* 1049 */     float f1 = paramRectangle.x + paramRectangle.width;
/* 1050 */     float f2 = paramRectangle.y + paramRectangle.height;
/*      */     
/* 1052 */     if (intersectSegments(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramRectangle.x, paramRectangle.y, paramRectangle.x, f2, null)) return true;
/*      */     
/* 1054 */     if (intersectSegments(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramRectangle.x, paramRectangle.y, f1, paramRectangle.y, null)) return true;
/*      */     
/* 1056 */     if (intersectSegments(paramFloat1, paramFloat2, paramFloat3, paramFloat4, f1, paramRectangle.y, f1, f2, null)) {
/* 1057 */       return true;
/*      */     }
/* 1059 */     if (intersectSegments(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramRectangle.x, f2, f1, f2, null)) {
/* 1060 */       return true;
/*      */     }
/* 1062 */     return paramRectangle.contains(paramFloat1, paramFloat2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean intersectSegmentRectangle(Vector2 paramVector21, Vector2 paramVector22, Rectangle paramRectangle) {
/* 1067 */     return intersectSegmentRectangle(paramVector21.x, paramVector21.y, paramVector22.x, paramVector22.y, paramRectangle);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectSegmentPolygon(Vector2 paramVector21, Vector2 paramVector22, Polygon paramPolygon) {
/* 1075 */     float[] arrayOfFloat = paramPolygon.getTransformedVertices();
/* 1076 */     float f3 = paramVector21.x, f1 = paramVector21.y, f4 = paramVector22.x, f2 = paramVector22.y;
/* 1077 */     int i = arrayOfFloat.length;
/* 1078 */     float f5 = arrayOfFloat[i - 2], f6 = arrayOfFloat[i - 1];
/* 1079 */     for (byte b = 0; b < i; b += 2) {
/* 1080 */       float f7 = arrayOfFloat[b];
/*      */ 
/*      */       
/* 1083 */       float f10 = f1 - f6;
/* 1084 */       float f11 = f3 - f5;
/*      */       float f8, f9;
/* 1086 */       if ((f9 = ((f8 = arrayOfFloat[b + 1]) - f6) * (f4 - f3) - (f7 - f5) * (f2 - f1)) != 0.0F && (f5 = ((f7 - f5) * f10 - (f8 - f6) * f11) / f9) >= 0.0F && f5 <= 1.0F && (
/*      */         
/* 1088 */         f5 = ((f4 - f3) * f10 - (f2 - f1) * f11) / f9) >= 0.0F && f5 <= 1.0F) {
/* 1089 */         return true;
/*      */       }
/*      */ 
/*      */       
/* 1093 */       f5 = f7;
/* 1094 */       f6 = f8;
/*      */     } 
/* 1096 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectSegments(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24, Vector2 paramVector25) {
/* 1107 */     return intersectSegments(paramVector21.x, paramVector21.y, paramVector22.x, paramVector22.y, paramVector23.x, paramVector23.y, paramVector24.x, paramVector24.y, paramVector25);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean intersectSegments(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, Vector2 paramVector2) {
/*      */     float f1;
/* 1114 */     if ((f1 = (paramFloat8 - paramFloat6) * (paramFloat3 - paramFloat1) - (paramFloat7 - paramFloat5) * (paramFloat4 - paramFloat2)) == 0.0F) return false;
/*      */     
/* 1116 */     float f2 = paramFloat2 - paramFloat6;
/* 1117 */     float f3 = paramFloat1 - paramFloat5;
/*      */     
/* 1119 */     if ((paramFloat5 = ((paramFloat7 - paramFloat5) * f2 - (paramFloat8 - paramFloat6) * f3) / f1) < 0.0F || paramFloat5 > 1.0F) return false;
/*      */ 
/*      */     
/* 1122 */     if ((paramFloat6 = ((paramFloat3 - paramFloat1) * f2 - (paramFloat4 - paramFloat2) * f3) / f1) < 0.0F || paramFloat6 > 1.0F) return false;
/*      */     
/* 1124 */     if (paramVector2 != null) paramVector2.set(paramFloat1 + (paramFloat3 - paramFloat1) * paramFloat5, paramFloat2 + (paramFloat4 - paramFloat2) * paramFloat5); 
/* 1125 */     return true;
/*      */   }
/*      */   
/*      */   static float det(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 1129 */     return paramFloat1 * paramFloat4 - paramFloat2 * paramFloat3;
/*      */   }
/*      */   
/*      */   static double detd(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
/* 1133 */     return paramDouble1 * paramDouble4 - paramDouble2 * paramDouble3;
/*      */   }
/*      */   
/*      */   public static boolean overlaps(Circle paramCircle1, Circle paramCircle2) {
/* 1137 */     return paramCircle1.overlaps(paramCircle2);
/*      */   }
/*      */   
/*      */   public static boolean overlaps(Rectangle paramRectangle1, Rectangle paramRectangle2) {
/* 1141 */     return paramRectangle1.overlaps(paramRectangle2);
/*      */   }
/*      */   
/*      */   public static boolean overlaps(Circle paramCircle, Rectangle paramRectangle) {
/* 1145 */     float f1 = paramCircle.x;
/* 1146 */     float f2 = paramCircle.y;
/*      */     
/* 1148 */     if (paramCircle.x < paramRectangle.x) {
/* 1149 */       f1 = paramRectangle.x;
/* 1150 */     } else if (paramCircle.x > paramRectangle.x + paramRectangle.width) {
/* 1151 */       f1 = paramRectangle.x + paramRectangle.width;
/*      */     } 
/*      */     
/* 1154 */     if (paramCircle.y < paramRectangle.y) {
/* 1155 */       f2 = paramRectangle.y;
/* 1156 */     } else if (paramCircle.y > paramRectangle.y + paramRectangle.height) {
/* 1157 */       f2 = paramRectangle.y + paramRectangle.height;
/*      */     } 
/*      */ 
/*      */     
/* 1161 */     f1 = (f1 = f1 - paramCircle.x) * f1;
/*      */     
/* 1163 */     f2 = (f2 = f2 - paramCircle.y) * f2;
/*      */     
/* 1165 */     return (f1 + f2 < paramCircle.radius * paramCircle.radius);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean overlapConvexPolygons(Polygon paramPolygon1, Polygon paramPolygon2) {
/* 1173 */     return overlapConvexPolygons(paramPolygon1, paramPolygon2, (MinimumTranslationVector)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean overlapConvexPolygons(Polygon paramPolygon1, Polygon paramPolygon2, MinimumTranslationVector paramMinimumTranslationVector) {
/* 1184 */     return overlapConvexPolygons(paramPolygon1.getTransformedVertices(), paramPolygon2.getTransformedVertices(), paramMinimumTranslationVector);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean overlapConvexPolygons(float[] paramArrayOffloat1, float[] paramArrayOffloat2, MinimumTranslationVector paramMinimumTranslationVector) {
/* 1189 */     return overlapConvexPolygons(paramArrayOffloat1, 0, paramArrayOffloat1.length, paramArrayOffloat2, 0, paramArrayOffloat2.length, paramMinimumTranslationVector);
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
/*      */   public static boolean overlapConvexPolygons(float[] paramArrayOffloat1, int paramInt1, int paramInt2, float[] paramArrayOffloat2, int paramInt3, int paramInt4, MinimumTranslationVector paramMinimumTranslationVector) {
/* 1206 */     if (paramMinimumTranslationVector != null) {
/* 1207 */       paramMinimumTranslationVector.depth = Float.MAX_VALUE;
/* 1208 */       paramMinimumTranslationVector.normal.setZero();
/*      */     } 
/*      */     boolean bool;
/* 1211 */     if (bool = overlapsOnAxisOfShape(paramArrayOffloat2, paramInt3, paramInt4, paramArrayOffloat1, paramInt1, paramInt2, paramMinimumTranslationVector, true)) {
/* 1212 */       bool = overlapsOnAxisOfShape(paramArrayOffloat1, paramInt1, paramInt2, paramArrayOffloat2, paramInt3, paramInt4, paramMinimumTranslationVector, false);
/*      */     }
/*      */     
/* 1215 */     if (!bool) {
/* 1216 */       if (paramMinimumTranslationVector != null) {
/* 1217 */         paramMinimumTranslationVector.depth = 0.0F;
/* 1218 */         paramMinimumTranslationVector.normal.setZero();
/*      */       } 
/* 1220 */       return false;
/*      */     } 
/* 1222 */     return true;
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
/*      */   private static boolean overlapsOnAxisOfShape(float[] paramArrayOffloat1, int paramInt1, int paramInt2, float[] paramArrayOffloat2, int paramInt3, int paramInt4, MinimumTranslationVector paramMinimumTranslationVector, boolean paramBoolean) {
/* 1234 */     int i = paramInt1 + paramInt2;
/* 1235 */     paramInt4 = paramInt3 + paramInt4;
/*      */     
/* 1237 */     for (int j = paramInt1; j < i; j += 2) {
/* 1238 */       float f1 = paramArrayOffloat1[j];
/* 1239 */       float f2 = paramArrayOffloat1[j + 1];
/* 1240 */       float f3 = paramArrayOffloat1[(j + 2) % paramInt2];
/* 1241 */       float f4 = paramArrayOffloat1[(j + 3) % paramInt2];
/*      */ 
/*      */       
/* 1244 */       f2 -= f4;
/* 1245 */       f1 = -(f1 - f3);
/*      */       
/* 1247 */       f3 = Vector2.len(f2, f1);
/*      */       
/* 1249 */       f2 /= f3;
/* 1250 */       f1 /= f3;
/* 1251 */       f3 = Float.MAX_VALUE;
/* 1252 */       f4 = -3.4028235E38F;
/*      */       
/* 1254 */       for (int k = paramInt1; k < i; k += 2) {
/* 1255 */         float f = paramArrayOffloat1[k] * f2 + paramArrayOffloat1[k + 1] * f1;
/* 1256 */         f3 = Math.min(f3, f);
/* 1257 */         f4 = Math.max(f4, f);
/*      */       } 
/*      */       
/* 1260 */       float f5 = Float.MAX_VALUE;
/* 1261 */       float f6 = -3.4028235E38F;
/*      */ 
/*      */       
/* 1264 */       for (int m = paramInt3; m < paramInt4; m += 2) {
/* 1265 */         float f = paramArrayOffloat2[m] * f2 + paramArrayOffloat2[m + 1] * f1;
/* 1266 */         f5 = Math.min(f5, f);
/* 1267 */         f6 = Math.max(f6, f);
/*      */       } 
/*      */       
/* 1270 */       if (f4 < f5 || f6 < f3) {
/* 1271 */         return false;
/*      */       }
/* 1273 */       if (paramMinimumTranslationVector != null) {
/* 1274 */         float f7 = Math.min(f4, f6) - Math.max(f3, f5);
/* 1275 */         boolean bool1 = (f3 < f5 && f4 > f6) ? true : false;
/* 1276 */         boolean bool2 = (f5 < f3 && f6 > f4) ? true : false;
/*      */         
/* 1278 */         float f8 = 0.0F;
/* 1279 */         float f9 = 0.0F;
/* 1280 */         if (bool1 || bool2) {
/* 1281 */           f8 = Math.abs(f3 - f5);
/* 1282 */           f9 = Math.abs(f4 - f6);
/* 1283 */           f7 += Math.min(f8, f9);
/*      */         } 
/*      */         
/* 1286 */         if (paramMinimumTranslationVector.depth > f7) {
/* 1287 */           boolean bool; paramMinimumTranslationVector.depth = f7;
/*      */           
/* 1289 */           if (paramBoolean) {
/*      */             
/* 1291 */             f2 = (bool = (f3 < f5) ? true : false) ? f2 : -f2;
/* 1292 */             f1 = bool ? f1 : -f1;
/*      */           } else {
/*      */             
/* 1295 */             f2 = (bool = (bool > f5) ? true : false) ? f2 : -f2;
/* 1296 */             f1 = bool ? f1 : -f1;
/*      */           } 
/*      */           
/* 1299 */           if (bool1 || bool2) {
/*      */             
/* 1301 */             f2 = (bool = (f8 > f9) ? true : false) ? f2 : -f2;
/* 1302 */             f1 = bool ? f1 : -f1;
/*      */           } 
/*      */           
/* 1305 */           paramMinimumTranslationVector.normal.set(f2, f1);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1310 */     return true;
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
/*      */   public static void splitTriangle(float[] paramArrayOffloat, Plane paramPlane, SplitTriangle paramSplitTriangle) {
/* 1330 */     int i = paramArrayOffloat.length / 3;
/* 1331 */     int j = (paramPlane.testPoint(paramArrayOffloat[0], paramArrayOffloat[1], paramArrayOffloat[2]) == Plane.PlaneSide.Back) ? 1 : 0;
/* 1332 */     int k = (paramPlane.testPoint(paramArrayOffloat[i + 0], paramArrayOffloat[i + 1], paramArrayOffloat[i + 2]) == Plane.PlaneSide.Back) ? 1 : 0;
/* 1333 */     byte b = (paramPlane.testPoint(paramArrayOffloat[0 + (i << 1)], paramArrayOffloat[1 + (i << 1)], paramArrayOffloat[2 + (i << 1)]) == Plane.PlaneSide.Back) ? 1 : 0;
/*      */ 
/*      */     
/* 1336 */     paramSplitTriangle.reset();
/*      */ 
/*      */     
/* 1339 */     if (j == k && k == b) {
/* 1340 */       paramSplitTriangle.total = 1;
/* 1341 */       if (j) {
/* 1342 */         paramSplitTriangle.numBack = 1;
/* 1343 */         System.arraycopy(paramArrayOffloat, 0, paramSplitTriangle.back, 0, paramArrayOffloat.length); return;
/*      */       } 
/* 1345 */       paramSplitTriangle.numFront = 1;
/* 1346 */       System.arraycopy(paramArrayOffloat, 0, paramSplitTriangle.front, 0, paramArrayOffloat.length);
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1352 */     paramSplitTriangle.total = 3;
/* 1353 */     paramSplitTriangle.numFront = (j ? 0 : 1) + (k ? 0 : 1) + (b ? 0 : 1);
/* 1354 */     paramSplitTriangle.numBack = paramSplitTriangle.total - paramSplitTriangle.numFront;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1359 */     paramSplitTriangle.setSide(!j);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1364 */     if (j != k) {
/*      */       
/* 1366 */       splitEdge(paramArrayOffloat, 0, i, i, paramPlane, paramSplitTriangle.edgeSplit, 0);
/*      */ 
/*      */       
/* 1369 */       paramSplitTriangle.add(paramArrayOffloat, 0, i);
/* 1370 */       paramSplitTriangle.add(paramSplitTriangle.edgeSplit, 0, i);
/*      */ 
/*      */       
/* 1373 */       paramSplitTriangle.setSide(!paramSplitTriangle.getSide());
/* 1374 */       paramSplitTriangle.add(paramSplitTriangle.edgeSplit, 0, i);
/*      */     } else {
/*      */       
/* 1377 */       paramSplitTriangle.add(paramArrayOffloat, 0, i);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1382 */     int m = i + i;
/* 1383 */     if (k != b) {
/*      */       
/* 1385 */       splitEdge(paramArrayOffloat, i, m, i, paramPlane, paramSplitTriangle.edgeSplit, 0);
/*      */ 
/*      */       
/* 1388 */       paramSplitTriangle.add(paramArrayOffloat, i, i);
/* 1389 */       paramSplitTriangle.add(paramSplitTriangle.edgeSplit, 0, i);
/*      */ 
/*      */       
/* 1392 */       paramSplitTriangle.setSide(!paramSplitTriangle.getSide());
/* 1393 */       paramSplitTriangle.add(paramSplitTriangle.edgeSplit, 0, i);
/*      */     } else {
/*      */       
/* 1396 */       paramSplitTriangle.add(paramArrayOffloat, i, i);
/*      */     } 
/*      */ 
/*      */     
/* 1400 */     k = m;
/*      */     
/* 1402 */     if (b != j) {
/*      */       
/* 1404 */       splitEdge(paramArrayOffloat, k, 0, i, paramPlane, paramSplitTriangle.edgeSplit, 0);
/*      */ 
/*      */       
/* 1407 */       paramSplitTriangle.add(paramArrayOffloat, k, i);
/* 1408 */       paramSplitTriangle.add(paramSplitTriangle.edgeSplit, 0, i);
/*      */ 
/*      */       
/* 1411 */       paramSplitTriangle.setSide(!paramSplitTriangle.getSide());
/* 1412 */       paramSplitTriangle.add(paramSplitTriangle.edgeSplit, 0, i);
/*      */     } else {
/*      */       
/* 1415 */       paramSplitTriangle.add(paramArrayOffloat, k, i);
/*      */     } 
/*      */ 
/*      */     
/* 1419 */     if (paramSplitTriangle.numFront == 2) {
/* 1420 */       System.arraycopy(paramSplitTriangle.front, i << 1, paramSplitTriangle.front, i * 3, i << 1);
/* 1421 */       System.arraycopy(paramSplitTriangle.front, 0, paramSplitTriangle.front, i * 5, i); return;
/*      */     } 
/* 1423 */     System.arraycopy(paramSplitTriangle.back, i << 1, paramSplitTriangle.back, i * 3, i << 1);
/* 1424 */     System.arraycopy(paramSplitTriangle.back, 0, paramSplitTriangle.back, i * 5, i);
/*      */   }
/*      */ 
/*      */   
/* 1428 */   static Vector3 intersection = new Vector3();
/*      */   
/*      */   private static void splitEdge(float[] paramArrayOffloat1, int paramInt1, int paramInt2, int paramInt3, Plane paramPlane, float[] paramArrayOffloat2, int paramInt4) {
/* 1431 */     float f = intersectLinePlane(paramArrayOffloat1[paramInt1], paramArrayOffloat1[paramInt1 + 1], paramArrayOffloat1[paramInt1 + 2], paramArrayOffloat1[paramInt2], paramArrayOffloat1[paramInt2 + 1], paramArrayOffloat1[paramInt2 + 2], paramPlane, intersection);
/*      */     
/* 1433 */     paramArrayOffloat2[paramInt4] = intersection.x;
/* 1434 */     paramArrayOffloat2[paramInt4 + 1] = intersection.y;
/* 1435 */     paramArrayOffloat2[paramInt4 + 2] = intersection.z;
/* 1436 */     for (byte b = 3; b < paramInt3; b++) {
/* 1437 */       float f1 = paramArrayOffloat1[paramInt1 + b];
/* 1438 */       float f2 = paramArrayOffloat1[paramInt2 + b];
/* 1439 */       paramArrayOffloat2[paramInt4 + b] = f1 + f * (f2 - f1);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static class SplitTriangle {
/*      */     public float[] front;
/*      */     public float[] back;
/*      */     float[] edgeSplit;
/*      */     public int numFront;
/*      */     public int numBack;
/*      */     public int total;
/*      */     boolean frontCurrent = false;
/* 1451 */     int frontOffset = 0;
/* 1452 */     int backOffset = 0;
/*      */ 
/*      */ 
/*      */     
/*      */     public SplitTriangle(int param1Int) {
/* 1457 */       this.front = new float[param1Int * 3 << 1];
/* 1458 */       this.back = new float[param1Int * 3 << 1];
/* 1459 */       this.edgeSplit = new float[param1Int];
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1464 */       return "SplitTriangle [front=" + Arrays.toString(this.front) + ", back=" + Arrays.toString(this.back) + ", numFront=" + this.numFront + ", numBack=" + this.numBack + ", total=" + this.total + "]";
/*      */     }
/*      */ 
/*      */     
/*      */     void setSide(boolean param1Boolean) {
/* 1469 */       this.frontCurrent = param1Boolean;
/*      */     }
/*      */     
/*      */     boolean getSide() {
/* 1473 */       return this.frontCurrent;
/*      */     }
/*      */     
/*      */     void add(float[] param1ArrayOffloat, int param1Int1, int param1Int2) {
/* 1477 */       if (this.frontCurrent) {
/* 1478 */         System.arraycopy(param1ArrayOffloat, param1Int1, this.front, this.frontOffset, param1Int2);
/* 1479 */         this.frontOffset += param1Int2; return;
/*      */       } 
/* 1481 */       System.arraycopy(param1ArrayOffloat, param1Int1, this.back, this.backOffset, param1Int2);
/* 1482 */       this.backOffset += param1Int2;
/*      */     }
/*      */ 
/*      */     
/*      */     void reset() {
/* 1487 */       this.frontCurrent = false;
/* 1488 */       this.frontOffset = 0;
/* 1489 */       this.backOffset = 0;
/* 1490 */       this.numFront = 0;
/* 1491 */       this.numBack = 0;
/* 1492 */       this.total = 0;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class MinimumTranslationVector
/*      */   {
/* 1499 */     public Vector2 normal = new Vector2();
/*      */     
/* 1501 */     public float depth = 0.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean hasOverlap(Vector3[] paramArrayOfVector31, Vector3[] paramArrayOfVector32, Vector3[] paramArrayOfVector33) {
/*      */     int i;
/*      */     byte b;
/* 1513 */     for (i = (paramArrayOfVector31 = paramArrayOfVector31).length, b = 0; b < i; ) { Vector3 vector3 = paramArrayOfVector31[b];
/* 1514 */       float f1 = Float.MAX_VALUE;
/* 1515 */       float f2 = -3.4028235E38F; Vector3[] arrayOfVector31; int j;
/*      */       byte b1;
/* 1517 */       for (j = (arrayOfVector31 = paramArrayOfVector32).length, b1 = 0; b1 < j; b1++) {
/* 1518 */         Vector3 vector31; float f = (vector31 = arrayOfVector31[b1]).dot(vector3);
/* 1519 */         f1 = Math.min(f1, f);
/* 1520 */         f2 = Math.max(f2, f);
/*      */       } 
/*      */       
/* 1523 */       float f3 = Float.MAX_VALUE;
/* 1524 */       float f4 = -3.4028235E38F; Vector3[] arrayOfVector32; int k;
/*      */       byte b2;
/* 1526 */       for (k = (arrayOfVector32 = paramArrayOfVector33).length, b2 = 0; b2 < k; b2++) {
/* 1527 */         Vector3 vector31; float f = (vector31 = arrayOfVector32[b2]).dot(vector3);
/* 1528 */         f3 = Math.min(f3, f);
/* 1529 */         f4 = Math.max(f4, f);
/*      */       } 
/*      */       
/* 1532 */       if (f2 < f3 || f4 < f1)
/*      */       {
/* 1534 */         return false;
/*      */       }
/*      */       b++; }
/*      */     
/* 1538 */     return true;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Intersector.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */