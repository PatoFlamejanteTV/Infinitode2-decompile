/*      */ package com.badlogic.gdx.math;
/*      */ 
/*      */ import java.io.Serializable;
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
/*      */ public class Matrix4
/*      */   implements Serializable
/*      */ {
/*      */   private static final long serialVersionUID = -2717655254359579617L;
/*      */   public static final int M00 = 0;
/*      */   public static final int M01 = 4;
/*      */   public static final int M02 = 8;
/*      */   public static final int M03 = 12;
/*      */   public static final int M10 = 1;
/*      */   public static final int M11 = 5;
/*      */   public static final int M12 = 9;
/*      */   public static final int M13 = 13;
/*      */   public static final int M20 = 2;
/*      */   public static final int M21 = 6;
/*      */   public static final int M22 = 10;
/*      */   public static final int M23 = 14;
/*      */   public static final int M30 = 3;
/*      */   public static final int M31 = 7;
/*      */   public static final int M32 = 11;
/*      */   public static final int M33 = 15;
/*   76 */   static final Quaternion quat = new Quaternion();
/*   77 */   static final Quaternion quat2 = new Quaternion();
/*   78 */   static final Vector3 l_vez = new Vector3();
/*   79 */   static final Vector3 l_vex = new Vector3();
/*   80 */   static final Vector3 l_vey = new Vector3();
/*   81 */   static final Vector3 tmpVec = new Vector3();
/*   82 */   static final Matrix4 tmpMat = new Matrix4();
/*   83 */   static final Vector3 right = new Vector3();
/*   84 */   static final Vector3 tmpForward = new Vector3();
/*   85 */   static final Vector3 tmpUp = new Vector3();
/*      */   
/*   87 */   public final float[] val = new float[16];
/*      */ 
/*      */   
/*      */   public Matrix4() {
/*   91 */     this.val[0] = 1.0F;
/*   92 */     this.val[5] = 1.0F;
/*   93 */     this.val[10] = 1.0F;
/*   94 */     this.val[15] = 1.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4(Matrix4 paramMatrix4) {
/*  100 */     set(paramMatrix4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4(float[] paramArrayOffloat) {
/*  108 */     set(paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4(Quaternion paramQuaternion) {
/*  114 */     set(paramQuaternion);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4(Vector3 paramVector31, Quaternion paramQuaternion, Vector3 paramVector32) {
/*  122 */     set(paramVector31, paramQuaternion, paramVector32);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 set(Matrix4 paramMatrix4) {
/*  129 */     return set(paramMatrix4.val);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 set(float[] paramArrayOffloat) {
/*  139 */     System.arraycopy(paramArrayOffloat, 0, this.val, 0, this.val.length);
/*  140 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 set(Quaternion paramQuaternion) {
/*  147 */     return set(paramQuaternion.x, paramQuaternion.y, paramQuaternion.z, paramQuaternion.w);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  158 */     return set(0.0F, 0.0F, 0.0F, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 set(Vector3 paramVector3, Quaternion paramQuaternion) {
/*  166 */     return set(paramVector3.x, paramVector3.y, paramVector3.z, paramQuaternion.x, paramQuaternion.y, paramQuaternion.z, paramQuaternion.w);
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
/*      */   public Matrix4 set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/*  180 */     float f1 = paramFloat4 * 2.0F, f2 = paramFloat5 * 2.0F, f3 = paramFloat6 * 2.0F;
/*  181 */     float f4 = paramFloat7 * f1, f5 = paramFloat7 * f2; paramFloat7 *= f3;
/*  182 */     f1 = paramFloat4 * f1; float f6 = paramFloat4 * f2; paramFloat4 *= f3;
/*  183 */     f2 = paramFloat5 * f2; paramFloat5 *= f3; paramFloat6 *= f3;
/*      */     
/*  185 */     this.val[0] = 1.0F - f2 + paramFloat6;
/*  186 */     this.val[4] = f6 - paramFloat7;
/*  187 */     this.val[8] = paramFloat4 + f5;
/*  188 */     this.val[12] = paramFloat1;
/*      */     
/*  190 */     this.val[1] = f6 + paramFloat7;
/*  191 */     this.val[5] = 1.0F - f1 + paramFloat6;
/*  192 */     this.val[9] = paramFloat5 - f4;
/*  193 */     this.val[13] = paramFloat2;
/*      */     
/*  195 */     this.val[2] = paramFloat4 - f5;
/*  196 */     this.val[6] = paramFloat5 + f4;
/*  197 */     this.val[10] = 1.0F - f1 + f2;
/*  198 */     this.val[14] = paramFloat3;
/*      */     
/*  200 */     this.val[3] = 0.0F;
/*  201 */     this.val[7] = 0.0F;
/*  202 */     this.val[11] = 0.0F;
/*  203 */     this.val[15] = 1.0F;
/*  204 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 set(Vector3 paramVector31, Quaternion paramQuaternion, Vector3 paramVector32) {
/*  213 */     return set(paramVector31.x, paramVector31.y, paramVector31.z, paramQuaternion.x, paramQuaternion.y, paramQuaternion.z, paramQuaternion.w, paramVector32.x, paramVector32.y, paramVector32.z);
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
/*      */   public Matrix4 set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10) {
/*  231 */     float f1 = paramFloat4 * 2.0F, f2 = paramFloat5 * 2.0F, f3 = paramFloat6 * 2.0F;
/*  232 */     float f4 = paramFloat7 * f1, f5 = paramFloat7 * f2; paramFloat7 *= f3;
/*  233 */     f1 = paramFloat4 * f1; float f6 = paramFloat4 * f2; paramFloat4 *= f3;
/*  234 */     f2 = paramFloat5 * f2; paramFloat5 *= f3; paramFloat6 *= f3;
/*      */     
/*  236 */     this.val[0] = paramFloat8 * (1.0F - f2 + paramFloat6);
/*  237 */     this.val[4] = paramFloat9 * (f6 - paramFloat7);
/*  238 */     this.val[8] = paramFloat10 * (paramFloat4 + f5);
/*  239 */     this.val[12] = paramFloat1;
/*      */     
/*  241 */     this.val[1] = paramFloat8 * (f6 + paramFloat7);
/*  242 */     this.val[5] = paramFloat9 * (1.0F - f1 + paramFloat6);
/*  243 */     this.val[9] = paramFloat10 * (paramFloat5 - f4);
/*  244 */     this.val[13] = paramFloat2;
/*      */     
/*  246 */     this.val[2] = paramFloat8 * (paramFloat4 - f5);
/*  247 */     this.val[6] = paramFloat9 * (paramFloat5 + f4);
/*  248 */     this.val[10] = paramFloat10 * (1.0F - f1 + f2);
/*  249 */     this.val[14] = paramFloat3;
/*      */     
/*  251 */     this.val[3] = 0.0F;
/*  252 */     this.val[7] = 0.0F;
/*  253 */     this.val[11] = 0.0F;
/*  254 */     this.val[15] = 1.0F;
/*  255 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 set(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34) {
/*  265 */     this.val[0] = paramVector31.x;
/*  266 */     this.val[4] = paramVector31.y;
/*  267 */     this.val[8] = paramVector31.z;
/*  268 */     this.val[1] = paramVector32.x;
/*  269 */     this.val[5] = paramVector32.y;
/*  270 */     this.val[9] = paramVector32.z;
/*  271 */     this.val[2] = paramVector33.x;
/*  272 */     this.val[6] = paramVector33.y;
/*  273 */     this.val[10] = paramVector33.z;
/*  274 */     this.val[12] = paramVector34.x;
/*  275 */     this.val[13] = paramVector34.y;
/*  276 */     this.val[14] = paramVector34.z;
/*  277 */     this.val[3] = 0.0F;
/*  278 */     this.val[7] = 0.0F;
/*  279 */     this.val[11] = 0.0F;
/*  280 */     this.val[15] = 1.0F;
/*  281 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Matrix4 cpy() {
/*  286 */     return new Matrix4(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 trn(Vector3 paramVector3) {
/*  293 */     this.val[12] = this.val[12] + paramVector3.x;
/*  294 */     this.val[13] = this.val[13] + paramVector3.y;
/*  295 */     this.val[14] = this.val[14] + paramVector3.z;
/*  296 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 trn(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  305 */     this.val[12] = this.val[12] + paramFloat1;
/*  306 */     this.val[13] = this.val[13] + paramFloat2;
/*  307 */     this.val[14] = this.val[14] + paramFloat3;
/*  308 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public float[] getValues() {
/*  313 */     return this.val;
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
/*      */   public Matrix4 mul(Matrix4 paramMatrix4) {
/*  325 */     mul(this.val, paramMatrix4.val);
/*  326 */     return this;
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
/*      */   public Matrix4 mulLeft(Matrix4 paramMatrix4) {
/*  338 */     tmpMat.set(paramMatrix4);
/*  339 */     mul(tmpMat.val, this.val);
/*  340 */     return set(tmpMat);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 tra() {
/*  346 */     float f1 = this.val[4];
/*  347 */     float f2 = this.val[8];
/*  348 */     float f3 = this.val[12];
/*  349 */     float f4 = this.val[9];
/*  350 */     float f5 = this.val[13];
/*  351 */     float f6 = this.val[14];
/*  352 */     this.val[4] = this.val[1];
/*  353 */     this.val[8] = this.val[2];
/*  354 */     this.val[12] = this.val[3];
/*  355 */     this.val[1] = f1;
/*  356 */     this.val[9] = this.val[6];
/*  357 */     this.val[13] = this.val[7];
/*  358 */     this.val[2] = f2;
/*  359 */     this.val[6] = f4;
/*  360 */     this.val[14] = this.val[11];
/*  361 */     this.val[3] = f3;
/*  362 */     this.val[7] = f5;
/*  363 */     this.val[11] = f6;
/*  364 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 idt() {
/*  370 */     this.val[0] = 1.0F;
/*  371 */     this.val[4] = 0.0F;
/*  372 */     this.val[8] = 0.0F;
/*  373 */     this.val[12] = 0.0F;
/*  374 */     this.val[1] = 0.0F;
/*  375 */     this.val[5] = 1.0F;
/*  376 */     this.val[9] = 0.0F;
/*  377 */     this.val[13] = 0.0F;
/*  378 */     this.val[2] = 0.0F;
/*  379 */     this.val[6] = 0.0F;
/*  380 */     this.val[10] = 1.0F;
/*  381 */     this.val[14] = 0.0F;
/*  382 */     this.val[3] = 0.0F;
/*  383 */     this.val[7] = 0.0F;
/*  384 */     this.val[11] = 0.0F;
/*  385 */     this.val[15] = 1.0F;
/*  386 */     return this;
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
/*      */   public Matrix4 inv() {
/*      */     float f1;
/*  405 */     if ((f1 = this.val[3] * this.val[6] * this.val[9] * this.val[12] - this.val[2] * this.val[7] * this.val[9] * this.val[12] - this.val[3] * this.val[5] * this.val[10] * this.val[12] + this.val[1] * this.val[7] * this.val[10] * this.val[12] + this.val[2] * this.val[5] * this.val[11] * this.val[12] - this.val[1] * this.val[6] * this.val[11] * this.val[12] - this.val[3] * this.val[6] * this.val[8] * this.val[13] + this.val[2] * this.val[7] * this.val[8] * this.val[13] + this.val[3] * this.val[4] * this.val[10] * this.val[13] - this.val[0] * this.val[7] * this.val[10] * this.val[13] - this.val[2] * this.val[4] * this.val[11] * this.val[13] + this.val[0] * this.val[6] * this.val[11] * this.val[13] + this.val[3] * this.val[5] * this.val[8] * this.val[14] - this.val[1] * this.val[7] * this.val[8] * this.val[14] - this.val[3] * this.val[4] * this.val[9] * this.val[14] + this.val[0] * this.val[7] * this.val[9] * this.val[14] + this.val[1] * this.val[4] * this.val[11] * this.val[14] - this.val[0] * this.val[5] * this.val[11] * this.val[14] - this.val[2] * this.val[5] * this.val[8] * this.val[15] + this.val[1] * this.val[6] * this.val[8] * this.val[15] + this.val[2] * this.val[4] * this.val[9] * this.val[15] - this.val[0] * this.val[6] * this.val[9] * this.val[15] - this.val[1] * this.val[4] * this.val[10] * this.val[15] + this.val[0] * this.val[5] * this.val[10] * this.val[15]) == 0.0F) throw new RuntimeException("non-invertible matrix"); 
/*  406 */     float f2 = this.val[9] * this.val[14] * this.val[7] - this.val[13] * this.val[10] * this.val[7] + this.val[13] * this.val[6] * this.val[11] - this.val[5] * this.val[14] * this.val[11] - this.val[9] * this.val[6] * this.val[15] + this.val[5] * this.val[10] * this.val[15];
/*      */     
/*  408 */     float f3 = this.val[12] * this.val[10] * this.val[7] - this.val[8] * this.val[14] * this.val[7] - this.val[12] * this.val[6] * this.val[11] + this.val[4] * this.val[14] * this.val[11] + this.val[8] * this.val[6] * this.val[15] - this.val[4] * this.val[10] * this.val[15];
/*      */     
/*  410 */     float f4 = this.val[8] * this.val[13] * this.val[7] - this.val[12] * this.val[9] * this.val[7] + this.val[12] * this.val[5] * this.val[11] - this.val[4] * this.val[13] * this.val[11] - this.val[8] * this.val[5] * this.val[15] + this.val[4] * this.val[9] * this.val[15];
/*      */     
/*  412 */     float f5 = this.val[12] * this.val[9] * this.val[6] - this.val[8] * this.val[13] * this.val[6] - this.val[12] * this.val[5] * this.val[10] + this.val[4] * this.val[13] * this.val[10] + this.val[8] * this.val[5] * this.val[14] - this.val[4] * this.val[9] * this.val[14];
/*      */     
/*  414 */     float f6 = this.val[13] * this.val[10] * this.val[3] - this.val[9] * this.val[14] * this.val[3] - this.val[13] * this.val[2] * this.val[11] + this.val[1] * this.val[14] * this.val[11] + this.val[9] * this.val[2] * this.val[15] - this.val[1] * this.val[10] * this.val[15];
/*      */     
/*  416 */     float f7 = this.val[8] * this.val[14] * this.val[3] - this.val[12] * this.val[10] * this.val[3] + this.val[12] * this.val[2] * this.val[11] - this.val[0] * this.val[14] * this.val[11] - this.val[8] * this.val[2] * this.val[15] + this.val[0] * this.val[10] * this.val[15];
/*      */     
/*  418 */     float f8 = this.val[12] * this.val[9] * this.val[3] - this.val[8] * this.val[13] * this.val[3] - this.val[12] * this.val[1] * this.val[11] + this.val[0] * this.val[13] * this.val[11] + this.val[8] * this.val[1] * this.val[15] - this.val[0] * this.val[9] * this.val[15];
/*      */     
/*  420 */     float f9 = this.val[8] * this.val[13] * this.val[2] - this.val[12] * this.val[9] * this.val[2] + this.val[12] * this.val[1] * this.val[10] - this.val[0] * this.val[13] * this.val[10] - this.val[8] * this.val[1] * this.val[14] + this.val[0] * this.val[9] * this.val[14];
/*      */     
/*  422 */     float f10 = this.val[5] * this.val[14] * this.val[3] - this.val[13] * this.val[6] * this.val[3] + this.val[13] * this.val[2] * this.val[7] - this.val[1] * this.val[14] * this.val[7] - this.val[5] * this.val[2] * this.val[15] + this.val[1] * this.val[6] * this.val[15];
/*      */     
/*  424 */     float f11 = this.val[12] * this.val[6] * this.val[3] - this.val[4] * this.val[14] * this.val[3] - this.val[12] * this.val[2] * this.val[7] + this.val[0] * this.val[14] * this.val[7] + this.val[4] * this.val[2] * this.val[15] - this.val[0] * this.val[6] * this.val[15];
/*      */     
/*  426 */     float f12 = this.val[4] * this.val[13] * this.val[3] - this.val[12] * this.val[5] * this.val[3] + this.val[12] * this.val[1] * this.val[7] - this.val[0] * this.val[13] * this.val[7] - this.val[4] * this.val[1] * this.val[15] + this.val[0] * this.val[5] * this.val[15];
/*      */     
/*  428 */     float f13 = this.val[12] * this.val[5] * this.val[2] - this.val[4] * this.val[13] * this.val[2] - this.val[12] * this.val[1] * this.val[6] + this.val[0] * this.val[13] * this.val[6] + this.val[4] * this.val[1] * this.val[14] - this.val[0] * this.val[5] * this.val[14];
/*      */     
/*  430 */     float f14 = this.val[9] * this.val[6] * this.val[3] - this.val[5] * this.val[10] * this.val[3] - this.val[9] * this.val[2] * this.val[7] + this.val[1] * this.val[10] * this.val[7] + this.val[5] * this.val[2] * this.val[11] - this.val[1] * this.val[6] * this.val[11];
/*      */     
/*  432 */     float f15 = this.val[4] * this.val[10] * this.val[3] - this.val[8] * this.val[6] * this.val[3] + this.val[8] * this.val[2] * this.val[7] - this.val[0] * this.val[10] * this.val[7] - this.val[4] * this.val[2] * this.val[11] + this.val[0] * this.val[6] * this.val[11];
/*      */     
/*  434 */     float f16 = this.val[8] * this.val[5] * this.val[3] - this.val[4] * this.val[9] * this.val[3] - this.val[8] * this.val[1] * this.val[7] + this.val[0] * this.val[9] * this.val[7] + this.val[4] * this.val[1] * this.val[11] - this.val[0] * this.val[5] * this.val[11];
/*      */     
/*  436 */     float f17 = this.val[4] * this.val[9] * this.val[2] - this.val[8] * this.val[5] * this.val[2] + this.val[8] * this.val[1] * this.val[6] - this.val[0] * this.val[9] * this.val[6] - this.val[4] * this.val[1] * this.val[10] + this.val[0] * this.val[5] * this.val[10];
/*      */     
/*  438 */     f1 = 1.0F / f1;
/*  439 */     this.val[0] = f2 * f1;
/*  440 */     this.val[1] = f6 * f1;
/*  441 */     this.val[2] = f10 * f1;
/*  442 */     this.val[3] = f14 * f1;
/*  443 */     this.val[4] = f3 * f1;
/*  444 */     this.val[5] = f7 * f1;
/*  445 */     this.val[6] = f11 * f1;
/*  446 */     this.val[7] = f15 * f1;
/*  447 */     this.val[8] = f4 * f1;
/*  448 */     this.val[9] = f8 * f1;
/*  449 */     this.val[10] = f12 * f1;
/*  450 */     this.val[11] = f16 * f1;
/*  451 */     this.val[12] = f5 * f1;
/*  452 */     this.val[13] = f9 * f1;
/*  453 */     this.val[14] = f13 * f1;
/*  454 */     this.val[15] = f17 * f1;
/*  455 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public float det() {
/*  460 */     return this.val[3] * this.val[6] * this.val[9] * this.val[12] - this.val[2] * this.val[7] * this.val[9] * this.val[12] - this.val[3] * this.val[5] * this.val[10] * this.val[12] + this.val[1] * this.val[7] * this.val[10] * this.val[12] + this.val[2] * this.val[5] * this.val[11] * this.val[12] - this.val[1] * this.val[6] * this.val[11] * this.val[12] - this.val[3] * this.val[6] * this.val[8] * this.val[13] + this.val[2] * this.val[7] * this.val[8] * this.val[13] + this.val[3] * this.val[4] * this.val[10] * this.val[13] - this.val[0] * this.val[7] * this.val[10] * this.val[13] - this.val[2] * this.val[4] * this.val[11] * this.val[13] + this.val[0] * this.val[6] * this.val[11] * this.val[13] + this.val[3] * this.val[5] * this.val[8] * this.val[14] - this.val[1] * this.val[7] * this.val[8] * this.val[14] - this.val[3] * this.val[4] * this.val[9] * this.val[14] + this.val[0] * this.val[7] * this.val[9] * this.val[14] + this.val[1] * this.val[4] * this.val[11] * this.val[14] - this.val[0] * this.val[5] * this.val[11] * this.val[14] - this.val[2] * this.val[5] * this.val[8] * this.val[15] + this.val[1] * this.val[6] * this.val[8] * this.val[15] + this.val[2] * this.val[4] * this.val[9] * this.val[15] - this.val[0] * this.val[6] * this.val[9] * this.val[15] - this.val[1] * this.val[4] * this.val[10] * this.val[15] + this.val[0] * this.val[5] * this.val[10] * this.val[15];
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
/*      */   public float det3x3() {
/*  476 */     return this.val[0] * this.val[5] * this.val[10] + this.val[4] * this.val[9] * this.val[2] + this.val[8] * this.val[1] * this.val[6] - this.val[0] * this.val[9] * this.val[6] - this.val[4] * this.val[1] * this.val[10] - this.val[8] * this.val[5] * this.val[2];
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
/*      */   public Matrix4 setToProjection(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  489 */     idt();
/*  490 */     paramFloat3 = (float)(1.0D / Math.tan(paramFloat3 * 0.017453292519943295D / 2.0D));
/*  491 */     float f = (paramFloat2 + paramFloat1) / (paramFloat1 - paramFloat2);
/*  492 */     paramFloat1 = paramFloat2 * 2.0F * paramFloat1 / (paramFloat1 - paramFloat2);
/*  493 */     this.val[0] = paramFloat3 / paramFloat4;
/*  494 */     this.val[1] = 0.0F;
/*  495 */     this.val[2] = 0.0F;
/*  496 */     this.val[3] = 0.0F;
/*  497 */     this.val[4] = 0.0F;
/*  498 */     this.val[5] = paramFloat3;
/*  499 */     this.val[6] = 0.0F;
/*  500 */     this.val[7] = 0.0F;
/*  501 */     this.val[8] = 0.0F;
/*  502 */     this.val[9] = 0.0F;
/*  503 */     this.val[10] = f;
/*  504 */     this.val[11] = -1.0F;
/*  505 */     this.val[12] = 0.0F;
/*  506 */     this.val[13] = 0.0F;
/*  507 */     this.val[14] = paramFloat1;
/*  508 */     this.val[15] = 0.0F;
/*  509 */     return this;
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
/*      */   public Matrix4 setToProjection(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/*  523 */     float f1 = paramFloat5 * 2.0F / (paramFloat2 - paramFloat1);
/*  524 */     float f2 = paramFloat5 * 2.0F / (paramFloat4 - paramFloat3);
/*  525 */     paramFloat1 = (paramFloat2 + paramFloat1) / (paramFloat2 - paramFloat1);
/*  526 */     paramFloat2 = (paramFloat4 + paramFloat3) / (paramFloat4 - paramFloat3);
/*  527 */     paramFloat3 = (paramFloat6 + paramFloat5) / (paramFloat5 - paramFloat6);
/*  528 */     paramFloat4 = paramFloat6 * 2.0F * paramFloat5 / (paramFloat5 - paramFloat6);
/*  529 */     this.val[0] = f1;
/*  530 */     this.val[1] = 0.0F;
/*  531 */     this.val[2] = 0.0F;
/*  532 */     this.val[3] = 0.0F;
/*  533 */     this.val[4] = 0.0F;
/*  534 */     this.val[5] = f2;
/*  535 */     this.val[6] = 0.0F;
/*  536 */     this.val[7] = 0.0F;
/*  537 */     this.val[8] = paramFloat1;
/*  538 */     this.val[9] = paramFloat2;
/*  539 */     this.val[10] = paramFloat3;
/*  540 */     this.val[11] = -1.0F;
/*  541 */     this.val[12] = 0.0F;
/*  542 */     this.val[13] = 0.0F;
/*  543 */     this.val[14] = paramFloat4;
/*  544 */     this.val[15] = 0.0F;
/*  545 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 setToOrtho2D(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  556 */     setToOrtho(paramFloat1, paramFloat1 + paramFloat3, paramFloat2, paramFloat2 + paramFloat4, 0.0F, 1.0F);
/*  557 */     return this;
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
/*      */   public Matrix4 setToOrtho2D(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/*  570 */     setToOrtho(paramFloat1, paramFloat1 + paramFloat3, paramFloat2, paramFloat2 + paramFloat4, paramFloat5, paramFloat6);
/*  571 */     return this;
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
/*      */   public Matrix4 setToOrtho(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/*  584 */     float f1 = 2.0F / (paramFloat2 - paramFloat1);
/*  585 */     float f2 = 2.0F / (paramFloat4 - paramFloat3);
/*  586 */     float f3 = -2.0F / (paramFloat6 - paramFloat5);
/*      */     
/*  588 */     paramFloat1 = -(paramFloat2 + paramFloat1) / (paramFloat2 - paramFloat1);
/*  589 */     paramFloat2 = -(paramFloat4 + paramFloat3) / (paramFloat4 - paramFloat3);
/*  590 */     paramFloat3 = -(paramFloat6 + paramFloat5) / (paramFloat6 - paramFloat5);
/*      */     
/*  592 */     this.val[0] = f1;
/*  593 */     this.val[1] = 0.0F;
/*  594 */     this.val[2] = 0.0F;
/*  595 */     this.val[3] = 0.0F;
/*  596 */     this.val[4] = 0.0F;
/*  597 */     this.val[5] = f2;
/*  598 */     this.val[6] = 0.0F;
/*  599 */     this.val[7] = 0.0F;
/*  600 */     this.val[8] = 0.0F;
/*  601 */     this.val[9] = 0.0F;
/*  602 */     this.val[10] = f3;
/*  603 */     this.val[11] = 0.0F;
/*  604 */     this.val[12] = paramFloat1;
/*  605 */     this.val[13] = paramFloat2;
/*  606 */     this.val[14] = paramFloat3;
/*  607 */     this.val[15] = 1.0F;
/*  608 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 setTranslation(Vector3 paramVector3) {
/*  615 */     this.val[12] = paramVector3.x;
/*  616 */     this.val[13] = paramVector3.y;
/*  617 */     this.val[14] = paramVector3.z;
/*  618 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 setTranslation(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  627 */     this.val[12] = paramFloat1;
/*  628 */     this.val[13] = paramFloat2;
/*  629 */     this.val[14] = paramFloat3;
/*  630 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 setToTranslation(Vector3 paramVector3) {
/*  638 */     idt();
/*  639 */     this.val[12] = paramVector3.x;
/*  640 */     this.val[13] = paramVector3.y;
/*  641 */     this.val[14] = paramVector3.z;
/*  642 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 setToTranslation(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  652 */     idt();
/*  653 */     this.val[12] = paramFloat1;
/*  654 */     this.val[13] = paramFloat2;
/*  655 */     this.val[14] = paramFloat3;
/*  656 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 setToTranslationAndScaling(Vector3 paramVector31, Vector3 paramVector32) {
/*  665 */     idt();
/*  666 */     this.val[12] = paramVector31.x;
/*  667 */     this.val[13] = paramVector31.y;
/*  668 */     this.val[14] = paramVector31.z;
/*  669 */     this.val[0] = paramVector32.x;
/*  670 */     this.val[5] = paramVector32.y;
/*  671 */     this.val[10] = paramVector32.z;
/*  672 */     return this;
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
/*      */   public Matrix4 setToTranslationAndScaling(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/*  686 */     idt();
/*  687 */     this.val[12] = paramFloat1;
/*  688 */     this.val[13] = paramFloat2;
/*  689 */     this.val[14] = paramFloat3;
/*  690 */     this.val[0] = paramFloat4;
/*  691 */     this.val[5] = paramFloat5;
/*  692 */     this.val[10] = paramFloat6;
/*  693 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 setToRotation(Vector3 paramVector3, float paramFloat) {
/*  701 */     if (paramFloat == 0.0F) {
/*  702 */       idt();
/*  703 */       return this;
/*      */     } 
/*  705 */     return set(quat.set(paramVector3, paramFloat));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 setToRotationRad(Vector3 paramVector3, float paramFloat) {
/*  713 */     if (paramFloat == 0.0F) {
/*  714 */       idt();
/*  715 */       return this;
/*      */     } 
/*  717 */     return set(quat.setFromAxisRad(paramVector3, paramFloat));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 setToRotation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  727 */     if (paramFloat4 == 0.0F) {
/*  728 */       idt();
/*  729 */       return this;
/*      */     } 
/*  731 */     return set(quat.setFromAxis(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 setToRotationRad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  741 */     if (paramFloat4 == 0.0F) {
/*  742 */       idt();
/*  743 */       return this;
/*      */     } 
/*  745 */     return set(quat.setFromAxisRad(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 setToRotation(Vector3 paramVector31, Vector3 paramVector32) {
/*  753 */     return set(quat.setFromCross(paramVector31, paramVector32));
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
/*      */   public Matrix4 setToRotation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/*  765 */     return set(quat.setFromCross(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 setFromEulerAngles(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  774 */     quat.setEulerAngles(paramFloat1, paramFloat2, paramFloat3);
/*  775 */     return set(quat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 setFromEulerAnglesRad(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  784 */     quat.setEulerAnglesRad(paramFloat1, paramFloat2, paramFloat3);
/*  785 */     return set(quat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 setToScaling(Vector3 paramVector3) {
/*  792 */     idt();
/*  793 */     this.val[0] = paramVector3.x;
/*  794 */     this.val[5] = paramVector3.y;
/*  795 */     this.val[10] = paramVector3.z;
/*  796 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 setToScaling(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  805 */     idt();
/*  806 */     this.val[0] = paramFloat1;
/*  807 */     this.val[5] = paramFloat2;
/*  808 */     this.val[10] = paramFloat3;
/*  809 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 setToLookAt(Vector3 paramVector31, Vector3 paramVector32) {
/*  818 */     l_vez.set(paramVector31).nor();
/*  819 */     l_vex.set(paramVector31).crs(paramVector32).nor();
/*  820 */     l_vey.set(l_vex).crs(l_vez).nor();
/*  821 */     idt();
/*  822 */     this.val[0] = l_vex.x;
/*  823 */     this.val[4] = l_vex.y;
/*  824 */     this.val[8] = l_vex.z;
/*  825 */     this.val[1] = l_vey.x;
/*  826 */     this.val[5] = l_vey.y;
/*  827 */     this.val[9] = l_vey.z;
/*  828 */     this.val[2] = -l_vez.x;
/*  829 */     this.val[6] = -l_vez.y;
/*  830 */     this.val[10] = -l_vez.z;
/*  831 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 setToLookAt(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33) {
/*  840 */     tmpVec.set(paramVector32).sub(paramVector31);
/*  841 */     setToLookAt(tmpVec, paramVector33);
/*  842 */     mul(tmpMat.setToTranslation(-paramVector31.x, -paramVector31.y, -paramVector31.z));
/*  843 */     return this;
/*      */   }
/*      */   
/*      */   public Matrix4 setToWorld(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33) {
/*  847 */     tmpForward.set(paramVector32).nor();
/*  848 */     right.set(tmpForward).crs(paramVector33).nor();
/*  849 */     tmpUp.set(right).crs(tmpForward).nor();
/*  850 */     set(right, tmpUp, tmpForward.scl(-1.0F), paramVector31);
/*  851 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 lerp(Matrix4 paramMatrix4, float paramFloat) {
/*  859 */     for (byte b = 0; b < 16; b++)
/*  860 */       this.val[b] = this.val[b] * (1.0F - paramFloat) + paramMatrix4.val[b] * paramFloat; 
/*  861 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 avg(Matrix4 paramMatrix4, float paramFloat) {
/*  870 */     getScale(tmpVec);
/*  871 */     paramMatrix4.getScale(tmpForward);
/*      */     
/*  873 */     getRotation(quat);
/*  874 */     paramMatrix4.getRotation(quat2);
/*      */     
/*  876 */     getTranslation(tmpUp);
/*  877 */     paramMatrix4.getTranslation(right);
/*      */     
/*  879 */     setToScaling(tmpVec.scl(paramFloat).add(tmpForward.scl(1.0F - paramFloat)));
/*  880 */     rotate(quat.slerp(quat2, 1.0F - paramFloat));
/*  881 */     setTranslation(tmpUp.scl(paramFloat).add(right.scl(1.0F - paramFloat)));
/*  882 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 avg(Matrix4[] paramArrayOfMatrix4) {
/*  890 */     float f = 1.0F / paramArrayOfMatrix4.length;
/*      */     
/*  892 */     tmpVec.set(paramArrayOfMatrix4[0].getScale(tmpUp).scl(f));
/*  893 */     quat.set(paramArrayOfMatrix4[0].getRotation(quat2).exp(f));
/*  894 */     tmpForward.set(paramArrayOfMatrix4[0].getTranslation(tmpUp).scl(f));
/*      */     
/*  896 */     for (byte b = 1; b < paramArrayOfMatrix4.length; b++) {
/*  897 */       tmpVec.add(paramArrayOfMatrix4[b].getScale(tmpUp).scl(f));
/*  898 */       quat.mul(paramArrayOfMatrix4[b].getRotation(quat2).exp(f));
/*  899 */       tmpForward.add(paramArrayOfMatrix4[b].getTranslation(tmpUp).scl(f));
/*      */     } 
/*  901 */     quat.nor();
/*      */     
/*  903 */     setToScaling(tmpVec);
/*  904 */     rotate(quat);
/*  905 */     setTranslation(tmpForward);
/*  906 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 avg(Matrix4[] paramArrayOfMatrix4, float[] paramArrayOffloat) {
/*  916 */     tmpVec.set(paramArrayOfMatrix4[0].getScale(tmpUp).scl(paramArrayOffloat[0]));
/*  917 */     quat.set(paramArrayOfMatrix4[0].getRotation(quat2).exp(paramArrayOffloat[0]));
/*  918 */     tmpForward.set(paramArrayOfMatrix4[0].getTranslation(tmpUp).scl(paramArrayOffloat[0]));
/*      */     
/*  920 */     for (byte b = 1; b < paramArrayOfMatrix4.length; b++) {
/*  921 */       tmpVec.add(paramArrayOfMatrix4[b].getScale(tmpUp).scl(paramArrayOffloat[b]));
/*  922 */       quat.mul(paramArrayOfMatrix4[b].getRotation(quat2).exp(paramArrayOffloat[b]));
/*  923 */       tmpForward.add(paramArrayOfMatrix4[b].getTranslation(tmpUp).scl(paramArrayOffloat[b]));
/*      */     } 
/*  925 */     quat.nor();
/*      */     
/*  927 */     setToScaling(tmpVec);
/*  928 */     rotate(quat);
/*  929 */     setTranslation(tmpForward);
/*  930 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 set(Matrix3 paramMatrix3) {
/*  936 */     this.val[0] = paramMatrix3.val[0];
/*  937 */     this.val[1] = paramMatrix3.val[1];
/*  938 */     this.val[2] = paramMatrix3.val[2];
/*  939 */     this.val[3] = 0.0F;
/*  940 */     this.val[4] = paramMatrix3.val[3];
/*  941 */     this.val[5] = paramMatrix3.val[4];
/*  942 */     this.val[6] = paramMatrix3.val[5];
/*  943 */     this.val[7] = 0.0F;
/*  944 */     this.val[8] = 0.0F;
/*  945 */     this.val[9] = 0.0F;
/*  946 */     this.val[10] = 1.0F;
/*  947 */     this.val[11] = 0.0F;
/*  948 */     this.val[12] = paramMatrix3.val[6];
/*  949 */     this.val[13] = paramMatrix3.val[7];
/*  950 */     this.val[14] = 0.0F;
/*  951 */     this.val[15] = paramMatrix3.val[8];
/*  952 */     return this;
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
/*      */   public Matrix4 set(Affine2 paramAffine2) {
/*  967 */     this.val[0] = paramAffine2.m00;
/*  968 */     this.val[1] = paramAffine2.m10;
/*  969 */     this.val[2] = 0.0F;
/*  970 */     this.val[3] = 0.0F;
/*  971 */     this.val[4] = paramAffine2.m01;
/*  972 */     this.val[5] = paramAffine2.m11;
/*  973 */     this.val[6] = 0.0F;
/*  974 */     this.val[7] = 0.0F;
/*  975 */     this.val[8] = 0.0F;
/*  976 */     this.val[9] = 0.0F;
/*  977 */     this.val[10] = 1.0F;
/*  978 */     this.val[11] = 0.0F;
/*  979 */     this.val[12] = paramAffine2.m02;
/*  980 */     this.val[13] = paramAffine2.m12;
/*  981 */     this.val[14] = 0.0F;
/*  982 */     this.val[15] = 1.0F;
/*  983 */     return this;
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
/*      */   public Matrix4 setAsAffine(Affine2 paramAffine2) {
/*  999 */     this.val[0] = paramAffine2.m00;
/* 1000 */     this.val[1] = paramAffine2.m10;
/* 1001 */     this.val[4] = paramAffine2.m01;
/* 1002 */     this.val[5] = paramAffine2.m11;
/* 1003 */     this.val[12] = paramAffine2.m02;
/* 1004 */     this.val[13] = paramAffine2.m12;
/* 1005 */     return this;
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
/*      */   public Matrix4 setAsAffine(Matrix4 paramMatrix4) {
/* 1020 */     this.val[0] = paramMatrix4.val[0];
/* 1021 */     this.val[1] = paramMatrix4.val[1];
/* 1022 */     this.val[4] = paramMatrix4.val[4];
/* 1023 */     this.val[5] = paramMatrix4.val[5];
/* 1024 */     this.val[12] = paramMatrix4.val[12];
/* 1025 */     this.val[13] = paramMatrix4.val[13];
/* 1026 */     return this;
/*      */   }
/*      */   
/*      */   public Matrix4 scl(Vector3 paramVector3) {
/* 1030 */     this.val[0] = this.val[0] * paramVector3.x;
/* 1031 */     this.val[5] = this.val[5] * paramVector3.y;
/* 1032 */     this.val[10] = this.val[10] * paramVector3.z;
/* 1033 */     return this;
/*      */   }
/*      */   
/*      */   public Matrix4 scl(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 1037 */     this.val[0] = this.val[0] * paramFloat1;
/* 1038 */     this.val[5] = this.val[5] * paramFloat2;
/* 1039 */     this.val[10] = this.val[10] * paramFloat3;
/* 1040 */     return this;
/*      */   }
/*      */   
/*      */   public Matrix4 scl(float paramFloat) {
/* 1044 */     this.val[0] = this.val[0] * paramFloat;
/* 1045 */     this.val[5] = this.val[5] * paramFloat;
/* 1046 */     this.val[10] = this.val[10] * paramFloat;
/* 1047 */     return this;
/*      */   }
/*      */   
/*      */   public Vector3 getTranslation(Vector3 paramVector3) {
/* 1051 */     paramVector3.x = this.val[12];
/* 1052 */     paramVector3.y = this.val[13];
/* 1053 */     paramVector3.z = this.val[14];
/* 1054 */     return paramVector3;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Quaternion getRotation(Quaternion paramQuaternion, boolean paramBoolean) {
/* 1062 */     return paramQuaternion.setFromMatrix(paramBoolean, this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Quaternion getRotation(Quaternion paramQuaternion) {
/* 1069 */     return paramQuaternion.setFromMatrix(this);
/*      */   }
/*      */ 
/*      */   
/*      */   public float getScaleXSquared() {
/* 1074 */     return this.val[0] * this.val[0] + this.val[4] * this.val[4] + this.val[8] * this.val[8];
/*      */   }
/*      */ 
/*      */   
/*      */   public float getScaleYSquared() {
/* 1079 */     return this.val[1] * this.val[1] + this.val[5] * this.val[5] + this.val[9] * this.val[9];
/*      */   }
/*      */ 
/*      */   
/*      */   public float getScaleZSquared() {
/* 1084 */     return this.val[2] * this.val[2] + this.val[6] * this.val[6] + this.val[10] * this.val[10];
/*      */   }
/*      */ 
/*      */   
/*      */   public float getScaleX() {
/* 1089 */     return (MathUtils.isZero(this.val[4]) && MathUtils.isZero(this.val[8])) ? Math.abs(this.val[0]) : 
/* 1090 */       (float)Math.sqrt(getScaleXSquared());
/*      */   }
/*      */ 
/*      */   
/*      */   public float getScaleY() {
/* 1095 */     return (MathUtils.isZero(this.val[1]) && MathUtils.isZero(this.val[9])) ? Math.abs(this.val[5]) : 
/* 1096 */       (float)Math.sqrt(getScaleYSquared());
/*      */   }
/*      */ 
/*      */   
/*      */   public float getScaleZ() {
/* 1101 */     return (MathUtils.isZero(this.val[2]) && MathUtils.isZero(this.val[6])) ? Math.abs(this.val[10]) : 
/* 1102 */       (float)Math.sqrt(getScaleZSquared());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Vector3 getScale(Vector3 paramVector3) {
/* 1108 */     return paramVector3.set(getScaleX(), getScaleY(), getScaleZ());
/*      */   }
/*      */ 
/*      */   
/*      */   public Matrix4 toNormalMatrix() {
/* 1113 */     this.val[12] = 0.0F;
/* 1114 */     this.val[13] = 0.0F;
/* 1115 */     this.val[14] = 0.0F;
/* 1116 */     return inv().tra();
/*      */   }
/*      */   
/*      */   public String toString() {
/* 1120 */     return "[" + this.val[0] + "|" + this.val[4] + "|" + this.val[8] + "|" + this.val[12] + "]\n[" + this.val[1] + "|" + this.val[5] + "|" + this.val[9] + "|" + this.val[13] + "]\n[" + this.val[2] + "|" + this.val[6] + "|" + this.val[10] + "|" + this.val[14] + "]\n[" + this.val[3] + "|" + this.val[7] + "|" + this.val[11] + "|" + this.val[15] + "]\n";
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
/*      */   public static native void mulVec(float[] paramArrayOffloat1, float[] paramArrayOffloat2, int paramInt1, int paramInt2, int paramInt3);
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
/*      */   public static native void prj(float[] paramArrayOffloat1, float[] paramArrayOffloat2, int paramInt1, int paramInt2, int paramInt3);
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
/*      */   public static native void rot(float[] paramArrayOffloat1, float[] paramArrayOffloat2, int paramInt1, int paramInt2, int paramInt3);
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
/*      */   public static void mul(float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
/* 1260 */     float f2 = paramArrayOffloat1[0] * paramArrayOffloat2[0] + paramArrayOffloat1[4] * paramArrayOffloat2[1] + paramArrayOffloat1[8] * paramArrayOffloat2[2] + paramArrayOffloat1[12] * paramArrayOffloat2[3];
/* 1261 */     float f3 = paramArrayOffloat1[0] * paramArrayOffloat2[4] + paramArrayOffloat1[4] * paramArrayOffloat2[5] + paramArrayOffloat1[8] * paramArrayOffloat2[6] + paramArrayOffloat1[12] * paramArrayOffloat2[7];
/* 1262 */     float f4 = paramArrayOffloat1[0] * paramArrayOffloat2[8] + paramArrayOffloat1[4] * paramArrayOffloat2[9] + paramArrayOffloat1[8] * paramArrayOffloat2[10] + paramArrayOffloat1[12] * paramArrayOffloat2[11];
/* 1263 */     float f5 = paramArrayOffloat1[0] * paramArrayOffloat2[12] + paramArrayOffloat1[4] * paramArrayOffloat2[13] + paramArrayOffloat1[8] * paramArrayOffloat2[14] + paramArrayOffloat1[12] * paramArrayOffloat2[15];
/* 1264 */     float f6 = paramArrayOffloat1[1] * paramArrayOffloat2[0] + paramArrayOffloat1[5] * paramArrayOffloat2[1] + paramArrayOffloat1[9] * paramArrayOffloat2[2] + paramArrayOffloat1[13] * paramArrayOffloat2[3];
/* 1265 */     float f7 = paramArrayOffloat1[1] * paramArrayOffloat2[4] + paramArrayOffloat1[5] * paramArrayOffloat2[5] + paramArrayOffloat1[9] * paramArrayOffloat2[6] + paramArrayOffloat1[13] * paramArrayOffloat2[7];
/* 1266 */     float f8 = paramArrayOffloat1[1] * paramArrayOffloat2[8] + paramArrayOffloat1[5] * paramArrayOffloat2[9] + paramArrayOffloat1[9] * paramArrayOffloat2[10] + paramArrayOffloat1[13] * paramArrayOffloat2[11];
/* 1267 */     float f9 = paramArrayOffloat1[1] * paramArrayOffloat2[12] + paramArrayOffloat1[5] * paramArrayOffloat2[13] + paramArrayOffloat1[9] * paramArrayOffloat2[14] + paramArrayOffloat1[13] * paramArrayOffloat2[15];
/* 1268 */     float f10 = paramArrayOffloat1[2] * paramArrayOffloat2[0] + paramArrayOffloat1[6] * paramArrayOffloat2[1] + paramArrayOffloat1[10] * paramArrayOffloat2[2] + paramArrayOffloat1[14] * paramArrayOffloat2[3];
/* 1269 */     float f11 = paramArrayOffloat1[2] * paramArrayOffloat2[4] + paramArrayOffloat1[6] * paramArrayOffloat2[5] + paramArrayOffloat1[10] * paramArrayOffloat2[6] + paramArrayOffloat1[14] * paramArrayOffloat2[7];
/* 1270 */     float f12 = paramArrayOffloat1[2] * paramArrayOffloat2[8] + paramArrayOffloat1[6] * paramArrayOffloat2[9] + paramArrayOffloat1[10] * paramArrayOffloat2[10] + paramArrayOffloat1[14] * paramArrayOffloat2[11];
/* 1271 */     float f13 = paramArrayOffloat1[2] * paramArrayOffloat2[12] + paramArrayOffloat1[6] * paramArrayOffloat2[13] + paramArrayOffloat1[10] * paramArrayOffloat2[14] + paramArrayOffloat1[14] * paramArrayOffloat2[15];
/* 1272 */     float f14 = paramArrayOffloat1[3] * paramArrayOffloat2[0] + paramArrayOffloat1[7] * paramArrayOffloat2[1] + paramArrayOffloat1[11] * paramArrayOffloat2[2] + paramArrayOffloat1[15] * paramArrayOffloat2[3];
/* 1273 */     float f15 = paramArrayOffloat1[3] * paramArrayOffloat2[4] + paramArrayOffloat1[7] * paramArrayOffloat2[5] + paramArrayOffloat1[11] * paramArrayOffloat2[6] + paramArrayOffloat1[15] * paramArrayOffloat2[7];
/* 1274 */     float f16 = paramArrayOffloat1[3] * paramArrayOffloat2[8] + paramArrayOffloat1[7] * paramArrayOffloat2[9] + paramArrayOffloat1[11] * paramArrayOffloat2[10] + paramArrayOffloat1[15] * paramArrayOffloat2[11];
/* 1275 */     float f1 = paramArrayOffloat1[3] * paramArrayOffloat2[12] + paramArrayOffloat1[7] * paramArrayOffloat2[13] + paramArrayOffloat1[11] * paramArrayOffloat2[14] + paramArrayOffloat1[15] * paramArrayOffloat2[15];
/* 1276 */     paramArrayOffloat1[0] = f2;
/* 1277 */     paramArrayOffloat1[1] = f6;
/* 1278 */     paramArrayOffloat1[2] = f10;
/* 1279 */     paramArrayOffloat1[3] = f14;
/* 1280 */     paramArrayOffloat1[4] = f3;
/* 1281 */     paramArrayOffloat1[5] = f7;
/* 1282 */     paramArrayOffloat1[6] = f11;
/* 1283 */     paramArrayOffloat1[7] = f15;
/* 1284 */     paramArrayOffloat1[8] = f4;
/* 1285 */     paramArrayOffloat1[9] = f8;
/* 1286 */     paramArrayOffloat1[10] = f12;
/* 1287 */     paramArrayOffloat1[11] = f16;
/* 1288 */     paramArrayOffloat1[12] = f5;
/* 1289 */     paramArrayOffloat1[13] = f9;
/* 1290 */     paramArrayOffloat1[14] = f13;
/* 1291 */     paramArrayOffloat1[15] = f1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void mulVec(float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
/* 1301 */     float f2 = paramArrayOffloat2[0] * paramArrayOffloat1[0] + paramArrayOffloat2[1] * paramArrayOffloat1[4] + paramArrayOffloat2[2] * paramArrayOffloat1[8] + paramArrayOffloat1[12];
/* 1302 */     float f3 = paramArrayOffloat2[0] * paramArrayOffloat1[1] + paramArrayOffloat2[1] * paramArrayOffloat1[5] + paramArrayOffloat2[2] * paramArrayOffloat1[9] + paramArrayOffloat1[13];
/* 1303 */     float f1 = paramArrayOffloat2[0] * paramArrayOffloat1[2] + paramArrayOffloat2[1] * paramArrayOffloat1[6] + paramArrayOffloat2[2] * paramArrayOffloat1[10] + paramArrayOffloat1[14];
/* 1304 */     paramArrayOffloat2[0] = f2;
/* 1305 */     paramArrayOffloat2[1] = f3;
/* 1306 */     paramArrayOffloat2[2] = f1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void prj(float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
/* 1316 */     float f2 = 1.0F / (paramArrayOffloat2[0] * paramArrayOffloat1[3] + paramArrayOffloat2[1] * paramArrayOffloat1[7] + paramArrayOffloat2[2] * paramArrayOffloat1[11] + paramArrayOffloat1[15]);
/* 1317 */     float f3 = (paramArrayOffloat2[0] * paramArrayOffloat1[0] + paramArrayOffloat2[1] * paramArrayOffloat1[4] + paramArrayOffloat2[2] * paramArrayOffloat1[8] + paramArrayOffloat1[12]) * f2;
/* 1318 */     float f4 = (paramArrayOffloat2[0] * paramArrayOffloat1[1] + paramArrayOffloat2[1] * paramArrayOffloat1[5] + paramArrayOffloat2[2] * paramArrayOffloat1[9] + paramArrayOffloat1[13]) * f2;
/* 1319 */     float f1 = (paramArrayOffloat2[0] * paramArrayOffloat1[2] + paramArrayOffloat2[1] * paramArrayOffloat1[6] + paramArrayOffloat2[2] * paramArrayOffloat1[10] + paramArrayOffloat1[14]) * f2;
/* 1320 */     paramArrayOffloat2[0] = f3;
/* 1321 */     paramArrayOffloat2[1] = f4;
/* 1322 */     paramArrayOffloat2[2] = f1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void rot(float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
/* 1332 */     float f2 = paramArrayOffloat2[0] * paramArrayOffloat1[0] + paramArrayOffloat2[1] * paramArrayOffloat1[4] + paramArrayOffloat2[2] * paramArrayOffloat1[8];
/* 1333 */     float f3 = paramArrayOffloat2[0] * paramArrayOffloat1[1] + paramArrayOffloat2[1] * paramArrayOffloat1[5] + paramArrayOffloat2[2] * paramArrayOffloat1[9];
/* 1334 */     float f1 = paramArrayOffloat2[0] * paramArrayOffloat1[2] + paramArrayOffloat2[1] * paramArrayOffloat1[6] + paramArrayOffloat2[2] * paramArrayOffloat1[10];
/* 1335 */     paramArrayOffloat2[0] = f2;
/* 1336 */     paramArrayOffloat2[1] = f3;
/* 1337 */     paramArrayOffloat2[2] = f1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean inv(float[] paramArrayOffloat) {
/*      */     float f1;
/* 1346 */     if ((f1 = det(paramArrayOffloat)) == 0.0F) return false; 
/* 1347 */     float f2 = paramArrayOffloat[9] * paramArrayOffloat[14] * paramArrayOffloat[7] - paramArrayOffloat[13] * paramArrayOffloat[10] * paramArrayOffloat[7] + paramArrayOffloat[13] * paramArrayOffloat[6] * paramArrayOffloat[11] - paramArrayOffloat[5] * paramArrayOffloat[14] * paramArrayOffloat[11] - paramArrayOffloat[9] * paramArrayOffloat[6] * paramArrayOffloat[15] + paramArrayOffloat[5] * paramArrayOffloat[10] * paramArrayOffloat[15];
/*      */ 
/*      */     
/* 1350 */     float f3 = paramArrayOffloat[12] * paramArrayOffloat[10] * paramArrayOffloat[7] - paramArrayOffloat[8] * paramArrayOffloat[14] * paramArrayOffloat[7] - paramArrayOffloat[12] * paramArrayOffloat[6] * paramArrayOffloat[11] + paramArrayOffloat[4] * paramArrayOffloat[14] * paramArrayOffloat[11] + paramArrayOffloat[8] * paramArrayOffloat[6] * paramArrayOffloat[15] - paramArrayOffloat[4] * paramArrayOffloat[10] * paramArrayOffloat[15];
/*      */ 
/*      */     
/* 1353 */     float f4 = paramArrayOffloat[8] * paramArrayOffloat[13] * paramArrayOffloat[7] - paramArrayOffloat[12] * paramArrayOffloat[9] * paramArrayOffloat[7] + paramArrayOffloat[12] * paramArrayOffloat[5] * paramArrayOffloat[11] - paramArrayOffloat[4] * paramArrayOffloat[13] * paramArrayOffloat[11] - paramArrayOffloat[8] * paramArrayOffloat[5] * paramArrayOffloat[15] + paramArrayOffloat[4] * paramArrayOffloat[9] * paramArrayOffloat[15];
/*      */ 
/*      */     
/* 1356 */     float f5 = paramArrayOffloat[12] * paramArrayOffloat[9] * paramArrayOffloat[6] - paramArrayOffloat[8] * paramArrayOffloat[13] * paramArrayOffloat[6] - paramArrayOffloat[12] * paramArrayOffloat[5] * paramArrayOffloat[10] + paramArrayOffloat[4] * paramArrayOffloat[13] * paramArrayOffloat[10] + paramArrayOffloat[8] * paramArrayOffloat[5] * paramArrayOffloat[14] - paramArrayOffloat[4] * paramArrayOffloat[9] * paramArrayOffloat[14];
/*      */ 
/*      */     
/* 1359 */     float f6 = paramArrayOffloat[13] * paramArrayOffloat[10] * paramArrayOffloat[3] - paramArrayOffloat[9] * paramArrayOffloat[14] * paramArrayOffloat[3] - paramArrayOffloat[13] * paramArrayOffloat[2] * paramArrayOffloat[11] + paramArrayOffloat[1] * paramArrayOffloat[14] * paramArrayOffloat[11] + paramArrayOffloat[9] * paramArrayOffloat[2] * paramArrayOffloat[15] - paramArrayOffloat[1] * paramArrayOffloat[10] * paramArrayOffloat[15];
/*      */ 
/*      */     
/* 1362 */     float f7 = paramArrayOffloat[8] * paramArrayOffloat[14] * paramArrayOffloat[3] - paramArrayOffloat[12] * paramArrayOffloat[10] * paramArrayOffloat[3] + paramArrayOffloat[12] * paramArrayOffloat[2] * paramArrayOffloat[11] - paramArrayOffloat[0] * paramArrayOffloat[14] * paramArrayOffloat[11] - paramArrayOffloat[8] * paramArrayOffloat[2] * paramArrayOffloat[15] + paramArrayOffloat[0] * paramArrayOffloat[10] * paramArrayOffloat[15];
/*      */ 
/*      */     
/* 1365 */     float f8 = paramArrayOffloat[12] * paramArrayOffloat[9] * paramArrayOffloat[3] - paramArrayOffloat[8] * paramArrayOffloat[13] * paramArrayOffloat[3] - paramArrayOffloat[12] * paramArrayOffloat[1] * paramArrayOffloat[11] + paramArrayOffloat[0] * paramArrayOffloat[13] * paramArrayOffloat[11] + paramArrayOffloat[8] * paramArrayOffloat[1] * paramArrayOffloat[15] - paramArrayOffloat[0] * paramArrayOffloat[9] * paramArrayOffloat[15];
/*      */ 
/*      */     
/* 1368 */     float f9 = paramArrayOffloat[8] * paramArrayOffloat[13] * paramArrayOffloat[2] - paramArrayOffloat[12] * paramArrayOffloat[9] * paramArrayOffloat[2] + paramArrayOffloat[12] * paramArrayOffloat[1] * paramArrayOffloat[10] - paramArrayOffloat[0] * paramArrayOffloat[13] * paramArrayOffloat[10] - paramArrayOffloat[8] * paramArrayOffloat[1] * paramArrayOffloat[14] + paramArrayOffloat[0] * paramArrayOffloat[9] * paramArrayOffloat[14];
/*      */ 
/*      */     
/* 1371 */     float f10 = paramArrayOffloat[5] * paramArrayOffloat[14] * paramArrayOffloat[3] - paramArrayOffloat[13] * paramArrayOffloat[6] * paramArrayOffloat[3] + paramArrayOffloat[13] * paramArrayOffloat[2] * paramArrayOffloat[7] - paramArrayOffloat[1] * paramArrayOffloat[14] * paramArrayOffloat[7] - paramArrayOffloat[5] * paramArrayOffloat[2] * paramArrayOffloat[15] + paramArrayOffloat[1] * paramArrayOffloat[6] * paramArrayOffloat[15];
/*      */ 
/*      */     
/* 1374 */     float f11 = paramArrayOffloat[12] * paramArrayOffloat[6] * paramArrayOffloat[3] - paramArrayOffloat[4] * paramArrayOffloat[14] * paramArrayOffloat[3] - paramArrayOffloat[12] * paramArrayOffloat[2] * paramArrayOffloat[7] + paramArrayOffloat[0] * paramArrayOffloat[14] * paramArrayOffloat[7] + paramArrayOffloat[4] * paramArrayOffloat[2] * paramArrayOffloat[15] - paramArrayOffloat[0] * paramArrayOffloat[6] * paramArrayOffloat[15];
/*      */ 
/*      */     
/* 1377 */     float f12 = paramArrayOffloat[4] * paramArrayOffloat[13] * paramArrayOffloat[3] - paramArrayOffloat[12] * paramArrayOffloat[5] * paramArrayOffloat[3] + paramArrayOffloat[12] * paramArrayOffloat[1] * paramArrayOffloat[7] - paramArrayOffloat[0] * paramArrayOffloat[13] * paramArrayOffloat[7] - paramArrayOffloat[4] * paramArrayOffloat[1] * paramArrayOffloat[15] + paramArrayOffloat[0] * paramArrayOffloat[5] * paramArrayOffloat[15];
/*      */ 
/*      */     
/* 1380 */     float f13 = paramArrayOffloat[12] * paramArrayOffloat[5] * paramArrayOffloat[2] - paramArrayOffloat[4] * paramArrayOffloat[13] * paramArrayOffloat[2] - paramArrayOffloat[12] * paramArrayOffloat[1] * paramArrayOffloat[6] + paramArrayOffloat[0] * paramArrayOffloat[13] * paramArrayOffloat[6] + paramArrayOffloat[4] * paramArrayOffloat[1] * paramArrayOffloat[14] - paramArrayOffloat[0] * paramArrayOffloat[5] * paramArrayOffloat[14];
/*      */ 
/*      */     
/* 1383 */     float f14 = paramArrayOffloat[9] * paramArrayOffloat[6] * paramArrayOffloat[3] - paramArrayOffloat[5] * paramArrayOffloat[10] * paramArrayOffloat[3] - paramArrayOffloat[9] * paramArrayOffloat[2] * paramArrayOffloat[7] + paramArrayOffloat[1] * paramArrayOffloat[10] * paramArrayOffloat[7] + paramArrayOffloat[5] * paramArrayOffloat[2] * paramArrayOffloat[11] - paramArrayOffloat[1] * paramArrayOffloat[6] * paramArrayOffloat[11];
/*      */ 
/*      */     
/* 1386 */     float f15 = paramArrayOffloat[4] * paramArrayOffloat[10] * paramArrayOffloat[3] - paramArrayOffloat[8] * paramArrayOffloat[6] * paramArrayOffloat[3] + paramArrayOffloat[8] * paramArrayOffloat[2] * paramArrayOffloat[7] - paramArrayOffloat[0] * paramArrayOffloat[10] * paramArrayOffloat[7] - paramArrayOffloat[4] * paramArrayOffloat[2] * paramArrayOffloat[11] + paramArrayOffloat[0] * paramArrayOffloat[6] * paramArrayOffloat[11];
/*      */ 
/*      */     
/* 1389 */     float f16 = paramArrayOffloat[8] * paramArrayOffloat[5] * paramArrayOffloat[3] - paramArrayOffloat[4] * paramArrayOffloat[9] * paramArrayOffloat[3] - paramArrayOffloat[8] * paramArrayOffloat[1] * paramArrayOffloat[7] + paramArrayOffloat[0] * paramArrayOffloat[9] * paramArrayOffloat[7] + paramArrayOffloat[4] * paramArrayOffloat[1] * paramArrayOffloat[11] - paramArrayOffloat[0] * paramArrayOffloat[5] * paramArrayOffloat[11];
/*      */ 
/*      */     
/* 1392 */     float f17 = paramArrayOffloat[4] * paramArrayOffloat[9] * paramArrayOffloat[2] - paramArrayOffloat[8] * paramArrayOffloat[5] * paramArrayOffloat[2] + paramArrayOffloat[8] * paramArrayOffloat[1] * paramArrayOffloat[6] - paramArrayOffloat[0] * paramArrayOffloat[9] * paramArrayOffloat[6] - paramArrayOffloat[4] * paramArrayOffloat[1] * paramArrayOffloat[10] + paramArrayOffloat[0] * paramArrayOffloat[5] * paramArrayOffloat[10];
/*      */ 
/*      */     
/* 1395 */     f1 = 1.0F / f1;
/* 1396 */     paramArrayOffloat[0] = f2 * f1;
/* 1397 */     paramArrayOffloat[1] = f6 * f1;
/* 1398 */     paramArrayOffloat[2] = f10 * f1;
/* 1399 */     paramArrayOffloat[3] = f14 * f1;
/* 1400 */     paramArrayOffloat[4] = f3 * f1;
/* 1401 */     paramArrayOffloat[5] = f7 * f1;
/* 1402 */     paramArrayOffloat[6] = f11 * f1;
/* 1403 */     paramArrayOffloat[7] = f15 * f1;
/* 1404 */     paramArrayOffloat[8] = f4 * f1;
/* 1405 */     paramArrayOffloat[9] = f8 * f1;
/* 1406 */     paramArrayOffloat[10] = f12 * f1;
/* 1407 */     paramArrayOffloat[11] = f16 * f1;
/* 1408 */     paramArrayOffloat[12] = f5 * f1;
/* 1409 */     paramArrayOffloat[13] = f9 * f1;
/* 1410 */     paramArrayOffloat[14] = f13 * f1;
/* 1411 */     paramArrayOffloat[15] = f17 * f1;
/* 1412 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float det(float[] paramArrayOffloat) {
/* 1420 */     return paramArrayOffloat[3] * paramArrayOffloat[6] * paramArrayOffloat[9] * paramArrayOffloat[12] - paramArrayOffloat[2] * paramArrayOffloat[7] * paramArrayOffloat[9] * paramArrayOffloat[12] - paramArrayOffloat[3] * paramArrayOffloat[5] * paramArrayOffloat[10] * paramArrayOffloat[12] + paramArrayOffloat[1] * paramArrayOffloat[7] * paramArrayOffloat[10] * paramArrayOffloat[12] + paramArrayOffloat[2] * paramArrayOffloat[5] * paramArrayOffloat[11] * paramArrayOffloat[12] - paramArrayOffloat[1] * paramArrayOffloat[6] * paramArrayOffloat[11] * paramArrayOffloat[12] - paramArrayOffloat[3] * paramArrayOffloat[6] * paramArrayOffloat[8] * paramArrayOffloat[13] + paramArrayOffloat[2] * paramArrayOffloat[7] * paramArrayOffloat[8] * paramArrayOffloat[13] + paramArrayOffloat[3] * paramArrayOffloat[4] * paramArrayOffloat[10] * paramArrayOffloat[13] - paramArrayOffloat[0] * paramArrayOffloat[7] * paramArrayOffloat[10] * paramArrayOffloat[13] - paramArrayOffloat[2] * paramArrayOffloat[4] * paramArrayOffloat[11] * paramArrayOffloat[13] + paramArrayOffloat[0] * paramArrayOffloat[6] * paramArrayOffloat[11] * paramArrayOffloat[13] + paramArrayOffloat[3] * paramArrayOffloat[5] * paramArrayOffloat[8] * paramArrayOffloat[14] - paramArrayOffloat[1] * paramArrayOffloat[7] * paramArrayOffloat[8] * paramArrayOffloat[14] - paramArrayOffloat[3] * paramArrayOffloat[4] * paramArrayOffloat[9] * paramArrayOffloat[14] + paramArrayOffloat[0] * paramArrayOffloat[7] * paramArrayOffloat[9] * paramArrayOffloat[14] + paramArrayOffloat[1] * paramArrayOffloat[4] * paramArrayOffloat[11] * paramArrayOffloat[14] - paramArrayOffloat[0] * paramArrayOffloat[5] * paramArrayOffloat[11] * paramArrayOffloat[14] - paramArrayOffloat[2] * paramArrayOffloat[5] * paramArrayOffloat[8] * paramArrayOffloat[15] + paramArrayOffloat[1] * paramArrayOffloat[6] * paramArrayOffloat[8] * paramArrayOffloat[15] + paramArrayOffloat[2] * paramArrayOffloat[4] * paramArrayOffloat[9] * paramArrayOffloat[15] - paramArrayOffloat[0] * paramArrayOffloat[6] * paramArrayOffloat[9] * paramArrayOffloat[15] - paramArrayOffloat[1] * paramArrayOffloat[4] * paramArrayOffloat[10] * paramArrayOffloat[15] + paramArrayOffloat[0] * paramArrayOffloat[5] * paramArrayOffloat[10] * paramArrayOffloat[15];
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
/*      */   public Matrix4 translate(Vector3 paramVector3) {
/* 1440 */     return translate(paramVector3.x, paramVector3.y, paramVector3.z);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 translate(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 1450 */     this.val[12] = this.val[12] + this.val[0] * paramFloat1 + this.val[4] * paramFloat2 + this.val[8] * paramFloat3;
/* 1451 */     this.val[13] = this.val[13] + this.val[1] * paramFloat1 + this.val[5] * paramFloat2 + this.val[9] * paramFloat3;
/* 1452 */     this.val[14] = this.val[14] + this.val[2] * paramFloat1 + this.val[6] * paramFloat2 + this.val[10] * paramFloat3;
/* 1453 */     this.val[15] = this.val[15] + this.val[3] * paramFloat1 + this.val[7] * paramFloat2 + this.val[11] * paramFloat3;
/* 1454 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 rotate(Vector3 paramVector3, float paramFloat) {
/* 1463 */     if (paramFloat == 0.0F) return this; 
/* 1464 */     quat.set(paramVector3, paramFloat);
/* 1465 */     return rotate(quat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 rotateRad(Vector3 paramVector3, float paramFloat) {
/* 1474 */     if (paramFloat == 0.0F) return this; 
/* 1475 */     quat.setFromAxisRad(paramVector3, paramFloat);
/* 1476 */     return rotate(quat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 1487 */     if (paramFloat4 == 0.0F) return this; 
/* 1488 */     quat.setFromAxis(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 1489 */     return rotate(quat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 rotateRad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 1500 */     if (paramFloat4 == 0.0F) return this; 
/* 1501 */     quat.setFromAxisRad(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 1502 */     return rotate(quat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 rotate(Quaternion paramQuaternion) {
/* 1510 */     float f2 = paramQuaternion.x, f3 = paramQuaternion.y, f4 = paramQuaternion.z, f1 = paramQuaternion.w;
/* 1511 */     float f5 = f2 * f2;
/* 1512 */     float f6 = f2 * f3;
/* 1513 */     float f7 = f2 * f4;
/* 1514 */     f2 *= f1;
/* 1515 */     float f8 = f3 * f3;
/* 1516 */     float f9 = f3 * f4;
/* 1517 */     f3 *= f1;
/* 1518 */     float f10 = f4 * f4;
/* 1519 */     f1 = f4 * f1;
/*      */     
/* 1521 */     f4 = 1.0F - 2.0F * (f8 + f10);
/* 1522 */     float f11 = 2.0F * (f6 - f1);
/* 1523 */     float f12 = 2.0F * (f7 + f3);
/* 1524 */     f1 = 2.0F * (f6 + f1);
/* 1525 */     f6 = 1.0F - 2.0F * (f5 + f10);
/* 1526 */     f10 = 2.0F * (f9 - f2);
/* 1527 */     f3 = 2.0F * (f7 - f3);
/* 1528 */     f2 = 2.0F * (f9 + f2);
/* 1529 */     f5 = 1.0F - 2.0F * (f5 + f8);
/* 1530 */     f7 = this.val[0] * f4 + this.val[4] * f1 + this.val[8] * f3;
/* 1531 */     f8 = this.val[0] * f11 + this.val[4] * f6 + this.val[8] * f2;
/* 1532 */     f9 = this.val[0] * f12 + this.val[4] * f10 + this.val[8] * f5;
/* 1533 */     float f13 = this.val[1] * f4 + this.val[5] * f1 + this.val[9] * f3;
/* 1534 */     float f14 = this.val[1] * f11 + this.val[5] * f6 + this.val[9] * f2;
/* 1535 */     float f15 = this.val[1] * f12 + this.val[5] * f10 + this.val[9] * f5;
/* 1536 */     float f16 = this.val[2] * f4 + this.val[6] * f1 + this.val[10] * f3;
/* 1537 */     float f17 = this.val[2] * f11 + this.val[6] * f6 + this.val[10] * f2;
/* 1538 */     float f18 = this.val[2] * f12 + this.val[6] * f10 + this.val[10] * f5;
/* 1539 */     f1 = this.val[3] * f4 + this.val[7] * f1 + this.val[11] * f3;
/* 1540 */     f2 = this.val[3] * f11 + this.val[7] * f6 + this.val[11] * f2;
/* 1541 */     f3 = this.val[3] * f12 + this.val[7] * f10 + this.val[11] * f5;
/* 1542 */     this.val[0] = f7;
/* 1543 */     this.val[1] = f13;
/* 1544 */     this.val[2] = f16;
/* 1545 */     this.val[3] = f1;
/* 1546 */     this.val[4] = f8;
/* 1547 */     this.val[5] = f14;
/* 1548 */     this.val[6] = f17;
/* 1549 */     this.val[7] = f2;
/* 1550 */     this.val[8] = f9;
/* 1551 */     this.val[9] = f15;
/* 1552 */     this.val[10] = f18;
/* 1553 */     this.val[11] = f3;
/* 1554 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 rotate(Vector3 paramVector31, Vector3 paramVector32) {
/* 1562 */     return rotate(quat.setFromCross(paramVector31, paramVector32));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 rotateTowardDirection(Vector3 paramVector31, Vector3 paramVector32) {
/* 1570 */     l_vez.set(paramVector31).nor();
/* 1571 */     l_vex.set(paramVector31).crs(paramVector32).nor();
/* 1572 */     l_vey.set(l_vex).crs(l_vez).nor();
/* 1573 */     float f1 = this.val[0] * l_vex.x + this.val[4] * l_vex.y + this.val[8] * l_vex.z;
/* 1574 */     float f2 = this.val[0] * l_vey.x + this.val[4] * l_vey.y + this.val[8] * l_vey.z;
/* 1575 */     float f3 = this.val[0] * -l_vez.x + this.val[4] * -l_vez.y + this.val[8] * -l_vez.z;
/* 1576 */     float f4 = this.val[1] * l_vex.x + this.val[5] * l_vex.y + this.val[9] * l_vex.z;
/* 1577 */     float f5 = this.val[1] * l_vey.x + this.val[5] * l_vey.y + this.val[9] * l_vey.z;
/* 1578 */     float f6 = this.val[1] * -l_vez.x + this.val[5] * -l_vez.y + this.val[9] * -l_vez.z;
/* 1579 */     float f7 = this.val[2] * l_vex.x + this.val[6] * l_vex.y + this.val[10] * l_vex.z;
/* 1580 */     float f8 = this.val[2] * l_vey.x + this.val[6] * l_vey.y + this.val[10] * l_vey.z;
/* 1581 */     float f9 = this.val[2] * -l_vez.x + this.val[6] * -l_vez.y + this.val[10] * -l_vez.z;
/* 1582 */     float f10 = this.val[3] * l_vex.x + this.val[7] * l_vex.y + this.val[11] * l_vex.z;
/* 1583 */     float f11 = this.val[3] * l_vey.x + this.val[7] * l_vey.y + this.val[11] * l_vey.z;
/* 1584 */     float f12 = this.val[3] * -l_vez.x + this.val[7] * -l_vez.y + this.val[11] * -l_vez.z;
/* 1585 */     this.val[0] = f1;
/* 1586 */     this.val[1] = f4;
/* 1587 */     this.val[2] = f7;
/* 1588 */     this.val[3] = f10;
/* 1589 */     this.val[4] = f2;
/* 1590 */     this.val[5] = f5;
/* 1591 */     this.val[6] = f8;
/* 1592 */     this.val[7] = f11;
/* 1593 */     this.val[8] = f3;
/* 1594 */     this.val[9] = f6;
/* 1595 */     this.val[10] = f9;
/* 1596 */     this.val[11] = f12;
/* 1597 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 rotateTowardTarget(Vector3 paramVector31, Vector3 paramVector32) {
/* 1605 */     tmpVec.set(paramVector31.x - this.val[12], paramVector31.y - this.val[13], paramVector31.z - this.val[14]);
/* 1606 */     return rotateTowardDirection(tmpVec, paramVector32);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Matrix4 scale(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 1616 */     this.val[0] = this.val[0] * paramFloat1;
/* 1617 */     this.val[4] = this.val[4] * paramFloat2;
/* 1618 */     this.val[8] = this.val[8] * paramFloat3;
/* 1619 */     this.val[1] = this.val[1] * paramFloat1;
/* 1620 */     this.val[5] = this.val[5] * paramFloat2;
/* 1621 */     this.val[9] = this.val[9] * paramFloat3;
/* 1622 */     this.val[2] = this.val[2] * paramFloat1;
/* 1623 */     this.val[6] = this.val[6] * paramFloat2;
/* 1624 */     this.val[10] = this.val[10] * paramFloat3;
/* 1625 */     this.val[3] = this.val[3] * paramFloat1;
/* 1626 */     this.val[7] = this.val[7] * paramFloat2;
/* 1627 */     this.val[11] = this.val[11] * paramFloat3;
/* 1628 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void extract4x3Matrix(float[] paramArrayOffloat) {
/* 1634 */     paramArrayOffloat[0] = this.val[0];
/* 1635 */     paramArrayOffloat[1] = this.val[1];
/* 1636 */     paramArrayOffloat[2] = this.val[2];
/* 1637 */     paramArrayOffloat[3] = this.val[4];
/* 1638 */     paramArrayOffloat[4] = this.val[5];
/* 1639 */     paramArrayOffloat[5] = this.val[6];
/* 1640 */     paramArrayOffloat[6] = this.val[8];
/* 1641 */     paramArrayOffloat[7] = this.val[9];
/* 1642 */     paramArrayOffloat[8] = this.val[10];
/* 1643 */     paramArrayOffloat[9] = this.val[12];
/* 1644 */     paramArrayOffloat[10] = this.val[13];
/* 1645 */     paramArrayOffloat[11] = this.val[14];
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasRotationOrScaling() {
/* 1650 */     if (!MathUtils.isEqual(this.val[0], 1.0F) || !MathUtils.isEqual(this.val[5], 1.0F) || !MathUtils.isEqual(this.val[10], 1.0F) || 
/* 1651 */       !MathUtils.isZero(this.val[4]) || !MathUtils.isZero(this.val[8]) || !MathUtils.isZero(this.val[1]) || !MathUtils.isZero(this.val[9]) || 
/* 1652 */       !MathUtils.isZero(this.val[2]) || !MathUtils.isZero(this.val[6])) return true; 
/*      */     return false;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Matrix4.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */