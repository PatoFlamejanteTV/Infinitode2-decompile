/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.GL20;
/*     */ import com.badlogic.gdx.math.Matrix3;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.math.Vector4;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.ObjectIntMap;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import java.nio.Buffer;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
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
/*     */ public class ShaderProgram
/*     */   implements Disposable
/*     */ {
/*     */   public static final String POSITION_ATTRIBUTE = "a_position";
/*     */   public static final String NORMAL_ATTRIBUTE = "a_normal";
/*     */   public static final String COLOR_ATTRIBUTE = "a_color";
/*     */   public static final String TEXCOORD_ATTRIBUTE = "a_texCoord";
/*     */   public static final String TANGENT_ATTRIBUTE = "a_tangent";
/*     */   public static final String BINORMAL_ATTRIBUTE = "a_binormal";
/*     */   public static final String BONEWEIGHT_ATTRIBUTE = "a_boneWeight";
/*     */   public static boolean pedantic = true;
/*  88 */   public static String prependVertexCode = "";
/*     */ 
/*     */ 
/*     */   
/*  92 */   public static String prependFragmentCode = "";
/*     */ 
/*     */   
/*  95 */   private static final ObjectMap<Application, Array<ShaderProgram>> shaders = new ObjectMap();
/*     */ 
/*     */   
/*  98 */   private String log = "";
/*     */ 
/*     */   
/*     */   private boolean isCompiled;
/*     */ 
/*     */   
/* 104 */   private final ObjectIntMap<String> uniforms = new ObjectIntMap();
/*     */ 
/*     */   
/* 107 */   private final ObjectIntMap<String> uniformTypes = new ObjectIntMap();
/*     */ 
/*     */   
/* 110 */   private final ObjectIntMap<String> uniformSizes = new ObjectIntMap();
/*     */ 
/*     */   
/*     */   private String[] uniformNames;
/*     */ 
/*     */   
/* 116 */   private final ObjectIntMap<String> attributes = new ObjectIntMap();
/*     */ 
/*     */   
/* 119 */   private final ObjectIntMap<String> attributeTypes = new ObjectIntMap();
/*     */ 
/*     */   
/* 122 */   private final ObjectIntMap<String> attributeSizes = new ObjectIntMap();
/*     */ 
/*     */   
/*     */   private String[] attributeNames;
/*     */ 
/*     */   
/*     */   private int program;
/*     */ 
/*     */   
/*     */   private int vertexShaderHandle;
/*     */ 
/*     */   
/*     */   private int fragmentShaderHandle;
/*     */ 
/*     */   
/*     */   private final FloatBuffer matrix;
/*     */ 
/*     */   
/*     */   private final String vertexShaderSource;
/*     */ 
/*     */   
/*     */   private final String fragmentShaderSource;
/*     */ 
/*     */   
/*     */   private boolean invalidated;
/*     */ 
/*     */   
/* 149 */   private int refCount = 0;
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
/*     */   public ShaderProgram(FileHandle paramFileHandle1, FileHandle paramFileHandle2) {
/* 176 */     this(paramFileHandle1.readString(), paramFileHandle2.readString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void compileShaders(String paramString1, String paramString2) {
/* 184 */     this.vertexShaderHandle = loadShader(35633, paramString1);
/* 185 */     this.fragmentShaderHandle = loadShader(35632, paramString2);
/*     */     
/* 187 */     if (this.vertexShaderHandle == -1 || this.fragmentShaderHandle == -1) {
/* 188 */       this.isCompiled = false;
/*     */       
/*     */       return;
/*     */     } 
/* 192 */     this.program = linkProgram(createProgram());
/* 193 */     if (this.program == -1) {
/* 194 */       this.isCompiled = false;
/*     */       
/*     */       return;
/*     */     } 
/* 198 */     this.isCompiled = true;
/*     */   }
/*     */   
/*     */   private int loadShader(int paramInt, String paramString) {
/* 202 */     GL20 gL20 = Gdx.gl20;
/* 203 */     IntBuffer intBuffer = BufferUtils.newIntBuffer(1);
/*     */     
/*     */     int j;
/* 206 */     if ((j = gL20.glCreateShader(paramInt)) == 0) return -1;
/*     */     
/* 208 */     gL20.glShaderSource(j, paramString);
/* 209 */     gL20.glCompileShader(j);
/* 210 */     gL20.glGetShaderiv(j, 35713, intBuffer);
/*     */     
/*     */     int i;
/* 213 */     if ((i = intBuffer.get(0)) == 0) {
/*     */ 
/*     */ 
/*     */       
/* 217 */       String str = gL20.glGetShaderInfoLog(j);
/* 218 */       this.log += (paramInt == 35633) ? "Vertex shader\n" : "Fragment shader:\n";
/* 219 */       this.log += str;
/*     */       
/* 221 */       return -1;
/*     */     } 
/*     */     
/* 224 */     return j;
/*     */   }
/*     */   
/*     */   protected int createProgram() {
/*     */     int i;
/*     */     GL20 gL20;
/* 230 */     return ((i = (gL20 = Gdx.gl20).glCreateProgram()) != 0) ? i : -1;
/*     */   }
/*     */   
/*     */   private int linkProgram(int paramInt) {
/* 234 */     GL20 gL20 = Gdx.gl20;
/* 235 */     if (paramInt == -1) return -1;
/*     */     
/* 237 */     gL20.glAttachShader(paramInt, this.vertexShaderHandle);
/* 238 */     gL20.glAttachShader(paramInt, this.fragmentShaderHandle);
/* 239 */     gL20.glLinkProgram(paramInt);
/*     */     
/*     */     ByteBuffer byteBuffer;
/* 242 */     (byteBuffer = ByteBuffer.allocateDirect(4)).order(ByteOrder.nativeOrder());
/* 243 */     IntBuffer intBuffer = byteBuffer.asIntBuffer();
/*     */     
/* 245 */     gL20.glGetProgramiv(paramInt, 35714, intBuffer);
/*     */     int i;
/* 247 */     if ((i = intBuffer.get(0)) == 0) {
/*     */ 
/*     */ 
/*     */       
/* 251 */       this.log = Gdx.gl20.glGetProgramInfoLog(paramInt);
/*     */       
/* 253 */       return -1;
/*     */     } 
/*     */     
/* 256 */     return paramInt;
/*     */   }
/*     */   
/* 259 */   static final IntBuffer intbuf = BufferUtils.newIntBuffer(1);
/*     */   IntBuffer params;
/*     */   IntBuffer type;
/*     */   
/*     */   public String getLog() {
/* 264 */     if (this.isCompiled) {
/*     */ 
/*     */ 
/*     */       
/* 268 */       this.log = Gdx.gl20.glGetProgramInfoLog(this.program);
/*     */       
/* 270 */       return this.log;
/*     */     } 
/* 272 */     return this.log;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCompiled() {
/* 278 */     return this.isCompiled;
/*     */   }
/*     */   
/*     */   private int fetchAttributeLocation(String paramString) {
/* 282 */     GL20 gL20 = Gdx.gl20;
/*     */     
/*     */     int i;
/*     */     
/* 286 */     if ((i = this.attributes.get(paramString, -2)) == -2) {
/* 287 */       i = gL20.glGetAttribLocation(this.program, paramString);
/* 288 */       this.attributes.put(paramString, i);
/*     */     } 
/* 290 */     return i;
/*     */   }
/*     */   
/*     */   private int fetchUniformLocation(String paramString) {
/* 294 */     return fetchUniformLocation(paramString, pedantic);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int fetchUniformLocation(String paramString, boolean paramBoolean) {
/*     */     int i;
/* 301 */     if ((i = this.uniforms.get(paramString, -2)) == -2) {
/*     */       
/* 303 */       if ((i = Gdx.gl20.glGetUniformLocation(this.program, paramString)) == -1 && paramBoolean) {
/* 304 */         if (this.isCompiled) throw new IllegalArgumentException("No uniform with name '" + paramString + "' in shader"); 
/* 305 */         throw new IllegalStateException("An attempted fetch uniform from uncompiled shader \n" + getLog());
/*     */       } 
/* 307 */       this.uniforms.put(paramString, i);
/*     */     } 
/* 309 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUniformi(String paramString, int paramInt) {
/* 317 */     GL20 gL20 = Gdx.gl20;
/* 318 */     checkManaged();
/* 319 */     int i = fetchUniformLocation(paramString);
/* 320 */     gL20.glUniform1i(i, paramInt);
/*     */   }
/*     */   
/*     */   public void setUniformi(int paramInt1, int paramInt2) {
/* 324 */     GL20 gL20 = Gdx.gl20;
/* 325 */     checkManaged();
/* 326 */     gL20.glUniform1i(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUniformi(String paramString, int paramInt1, int paramInt2) {
/* 335 */     GL20 gL20 = Gdx.gl20;
/* 336 */     checkManaged();
/* 337 */     int i = fetchUniformLocation(paramString);
/* 338 */     gL20.glUniform2i(i, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void setUniformi(int paramInt1, int paramInt2, int paramInt3) {
/* 342 */     GL20 gL20 = Gdx.gl20;
/* 343 */     checkManaged();
/* 344 */     gL20.glUniform2i(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUniformi(String paramString, int paramInt1, int paramInt2, int paramInt3) {
/* 354 */     GL20 gL20 = Gdx.gl20;
/* 355 */     checkManaged();
/* 356 */     int i = fetchUniformLocation(paramString);
/* 357 */     gL20.glUniform3i(i, paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */   
/*     */   public void setUniformi(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 361 */     GL20 gL20 = Gdx.gl20;
/* 362 */     checkManaged();
/* 363 */     gL20.glUniform3i(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUniformi(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 374 */     GL20 gL20 = Gdx.gl20;
/* 375 */     checkManaged();
/* 376 */     int i = fetchUniformLocation(paramString);
/* 377 */     gL20.glUniform4i(i, paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void setUniformi(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 381 */     GL20 gL20 = Gdx.gl20;
/* 382 */     checkManaged();
/* 383 */     gL20.glUniform4i(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUniformf(String paramString, float paramFloat) {
/* 391 */     GL20 gL20 = Gdx.gl20;
/* 392 */     checkManaged();
/* 393 */     int i = fetchUniformLocation(paramString);
/* 394 */     gL20.glUniform1f(i, paramFloat);
/*     */   }
/*     */   
/*     */   public void setUniformf(int paramInt, float paramFloat) {
/* 398 */     GL20 gL20 = Gdx.gl20;
/* 399 */     checkManaged();
/* 400 */     gL20.glUniform1f(paramInt, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUniformf(String paramString, float paramFloat1, float paramFloat2) {
/* 409 */     GL20 gL20 = Gdx.gl20;
/* 410 */     checkManaged();
/* 411 */     int i = fetchUniformLocation(paramString);
/* 412 */     gL20.glUniform2f(i, paramFloat1, paramFloat2);
/*     */   }
/*     */   
/*     */   public void setUniformf(int paramInt, float paramFloat1, float paramFloat2) {
/* 416 */     GL20 gL20 = Gdx.gl20;
/* 417 */     checkManaged();
/* 418 */     gL20.glUniform2f(paramInt, paramFloat1, paramFloat2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUniformf(String paramString, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 428 */     GL20 gL20 = Gdx.gl20;
/* 429 */     checkManaged();
/* 430 */     int i = fetchUniformLocation(paramString);
/* 431 */     gL20.glUniform3f(i, paramFloat1, paramFloat2, paramFloat3);
/*     */   }
/*     */   
/*     */   public void setUniformf(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 435 */     GL20 gL20 = Gdx.gl20;
/* 436 */     checkManaged();
/* 437 */     gL20.glUniform3f(paramInt, paramFloat1, paramFloat2, paramFloat3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUniformf(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 448 */     GL20 gL20 = Gdx.gl20;
/* 449 */     checkManaged();
/* 450 */     int i = fetchUniformLocation(paramString);
/* 451 */     gL20.glUniform4f(i, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public void setUniformf(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 455 */     GL20 gL20 = Gdx.gl20;
/* 456 */     checkManaged();
/* 457 */     gL20.glUniform4f(paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public void setUniform1fv(String paramString, float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 461 */     GL20 gL20 = Gdx.gl20;
/* 462 */     checkManaged();
/* 463 */     int i = fetchUniformLocation(paramString);
/* 464 */     gL20.glUniform1fv(i, paramInt2, paramArrayOffloat, paramInt1);
/*     */   }
/*     */   
/*     */   public void setUniform1fv(int paramInt1, float[] paramArrayOffloat, int paramInt2, int paramInt3) {
/* 468 */     GL20 gL20 = Gdx.gl20;
/* 469 */     checkManaged();
/* 470 */     gL20.glUniform1fv(paramInt1, paramInt3, paramArrayOffloat, paramInt2);
/*     */   }
/*     */   
/*     */   public void setUniform2fv(String paramString, float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 474 */     GL20 gL20 = Gdx.gl20;
/* 475 */     checkManaged();
/* 476 */     int i = fetchUniformLocation(paramString);
/* 477 */     gL20.glUniform2fv(i, paramInt2 / 2, paramArrayOffloat, paramInt1);
/*     */   }
/*     */   
/*     */   public void setUniform2fv(int paramInt1, float[] paramArrayOffloat, int paramInt2, int paramInt3) {
/* 481 */     GL20 gL20 = Gdx.gl20;
/* 482 */     checkManaged();
/* 483 */     gL20.glUniform2fv(paramInt1, paramInt3 / 2, paramArrayOffloat, paramInt2);
/*     */   }
/*     */   
/*     */   public void setUniform3fv(String paramString, float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 487 */     GL20 gL20 = Gdx.gl20;
/* 488 */     checkManaged();
/* 489 */     int i = fetchUniformLocation(paramString);
/* 490 */     gL20.glUniform3fv(i, paramInt2 / 3, paramArrayOffloat, paramInt1);
/*     */   }
/*     */   
/*     */   public void setUniform3fv(int paramInt1, float[] paramArrayOffloat, int paramInt2, int paramInt3) {
/* 494 */     GL20 gL20 = Gdx.gl20;
/* 495 */     checkManaged();
/* 496 */     gL20.glUniform3fv(paramInt1, paramInt3 / 3, paramArrayOffloat, paramInt2);
/*     */   }
/*     */   
/*     */   public void setUniform4fv(String paramString, float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 500 */     GL20 gL20 = Gdx.gl20;
/* 501 */     checkManaged();
/* 502 */     int i = fetchUniformLocation(paramString);
/* 503 */     gL20.glUniform4fv(i, paramInt2 / 4, paramArrayOffloat, paramInt1);
/*     */   }
/*     */   
/*     */   public void setUniform4fv(int paramInt1, float[] paramArrayOffloat, int paramInt2, int paramInt3) {
/* 507 */     GL20 gL20 = Gdx.gl20;
/* 508 */     checkManaged();
/* 509 */     gL20.glUniform4fv(paramInt1, paramInt3 / 4, paramArrayOffloat, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUniformMatrix(String paramString, Matrix4 paramMatrix4) {
/* 517 */     setUniformMatrix(paramString, paramMatrix4, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUniformMatrix(String paramString, Matrix4 paramMatrix4, boolean paramBoolean) {
/* 526 */     setUniformMatrix(fetchUniformLocation(paramString), paramMatrix4, paramBoolean);
/*     */   }
/*     */   
/*     */   public void setUniformMatrix(int paramInt, Matrix4 paramMatrix4) {
/* 530 */     setUniformMatrix(paramInt, paramMatrix4, false);
/*     */   }
/*     */   
/*     */   public void setUniformMatrix(int paramInt, Matrix4 paramMatrix4, boolean paramBoolean) {
/* 534 */     GL20 gL20 = Gdx.gl20;
/* 535 */     checkManaged();
/* 536 */     gL20.glUniformMatrix4fv(paramInt, 1, paramBoolean, paramMatrix4.val, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUniformMatrix(String paramString, Matrix3 paramMatrix3) {
/* 544 */     setUniformMatrix(paramString, paramMatrix3, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUniformMatrix(String paramString, Matrix3 paramMatrix3, boolean paramBoolean) {
/* 553 */     setUniformMatrix(fetchUniformLocation(paramString), paramMatrix3, paramBoolean);
/*     */   }
/*     */   
/*     */   public void setUniformMatrix(int paramInt, Matrix3 paramMatrix3) {
/* 557 */     setUniformMatrix(paramInt, paramMatrix3, false);
/*     */   }
/*     */   
/*     */   public void setUniformMatrix(int paramInt, Matrix3 paramMatrix3, boolean paramBoolean) {
/* 561 */     GL20 gL20 = Gdx.gl20;
/* 562 */     checkManaged();
/* 563 */     gL20.glUniformMatrix3fv(paramInt, 1, paramBoolean, paramMatrix3.val, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUniformMatrix3fv(String paramString, FloatBuffer paramFloatBuffer, int paramInt, boolean paramBoolean) {
/* 572 */     GL20 gL20 = Gdx.gl20;
/* 573 */     checkManaged();
/* 574 */     paramFloatBuffer.position(0);
/* 575 */     int i = fetchUniformLocation(paramString);
/* 576 */     gL20.glUniformMatrix3fv(i, paramInt, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUniformMatrix4fv(String paramString, FloatBuffer paramFloatBuffer, int paramInt, boolean paramBoolean) {
/* 585 */     GL20 gL20 = Gdx.gl20;
/* 586 */     checkManaged();
/* 587 */     paramFloatBuffer.position(0);
/* 588 */     int i = fetchUniformLocation(paramString);
/* 589 */     gL20.glUniformMatrix4fv(i, paramInt, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */   
/*     */   public void setUniformMatrix4fv(int paramInt1, float[] paramArrayOffloat, int paramInt2, int paramInt3) {
/* 593 */     GL20 gL20 = Gdx.gl20;
/* 594 */     checkManaged();
/* 595 */     gL20.glUniformMatrix4fv(paramInt1, paramInt3 / 16, false, paramArrayOffloat, paramInt2);
/*     */   }
/*     */   
/*     */   public void setUniformMatrix4fv(String paramString, float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 599 */     setUniformMatrix4fv(fetchUniformLocation(paramString), paramArrayOffloat, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUniformf(String paramString, Vector2 paramVector2) {
/* 607 */     setUniformf(paramString, paramVector2.x, paramVector2.y);
/*     */   }
/*     */   
/*     */   public void setUniformf(int paramInt, Vector2 paramVector2) {
/* 611 */     setUniformf(paramInt, paramVector2.x, paramVector2.y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUniformf(String paramString, Vector3 paramVector3) {
/* 619 */     setUniformf(paramString, paramVector3.x, paramVector3.y, paramVector3.z);
/*     */   }
/*     */   
/*     */   public void setUniformf(int paramInt, Vector3 paramVector3) {
/* 623 */     setUniformf(paramInt, paramVector3.x, paramVector3.y, paramVector3.z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUniformf(String paramString, Vector4 paramVector4) {
/* 631 */     setUniformf(paramString, paramVector4.x, paramVector4.y, paramVector4.z, paramVector4.w);
/*     */   }
/*     */   
/*     */   public void setUniformf(int paramInt, Vector4 paramVector4) {
/* 635 */     setUniformf(paramInt, paramVector4.x, paramVector4.y, paramVector4.z, paramVector4.w);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUniformf(String paramString, Color paramColor) {
/* 643 */     setUniformf(paramString, paramColor.r, paramColor.g, paramColor.b, paramColor.a);
/*     */   }
/*     */   
/*     */   public void setUniformf(int paramInt, Color paramColor) {
/* 647 */     setUniformf(paramInt, paramColor.r, paramColor.g, paramColor.b, paramColor.a);
/*     */   }
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
/*     */   public void setVertexAttribute(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, Buffer paramBuffer) {
/* 660 */     GL20 gL20 = Gdx.gl20;
/* 661 */     checkManaged();
/*     */     int i;
/* 663 */     if ((i = fetchAttributeLocation(paramString)) == -1)
/* 664 */       return;  gL20.glVertexAttribPointer(i, paramInt1, paramInt2, paramBoolean, paramInt3, paramBuffer);
/*     */   }
/*     */   
/*     */   public void setVertexAttribute(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, Buffer paramBuffer) {
/* 668 */     GL20 gL20 = Gdx.gl20;
/* 669 */     checkManaged();
/* 670 */     gL20.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramBuffer);
/*     */   }
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
/*     */   public void setVertexAttribute(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4) {
/* 683 */     GL20 gL20 = Gdx.gl20;
/* 684 */     checkManaged();
/*     */     int i;
/* 686 */     if ((i = fetchAttributeLocation(paramString)) == -1)
/* 687 */       return;  gL20.glVertexAttribPointer(i, paramInt1, paramInt2, paramBoolean, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void setVertexAttribute(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5) {
/* 691 */     GL20 gL20 = Gdx.gl20;
/* 692 */     checkManaged();
/* 693 */     gL20.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void begin() {
/* 699 */     bind();
/*     */   }
/*     */   
/*     */   public void bind() {
/* 703 */     GL20 gL20 = Gdx.gl20;
/* 704 */     checkManaged();
/* 705 */     gL20.glUseProgram(this.program);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void end() {}
/*     */ 
/*     */   
/*     */   public void dispose() {
/*     */     GL20 gL20;
/* 716 */     (gL20 = Gdx.gl20).glUseProgram(0);
/* 717 */     gL20.glDeleteShader(this.vertexShaderHandle);
/* 718 */     gL20.glDeleteShader(this.fragmentShaderHandle);
/* 719 */     gL20.glDeleteProgram(this.program);
/* 720 */     if (shaders.get(Gdx.app) != null) ((Array)shaders.get(Gdx.app)).removeValue(this, true);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void disableVertexAttribute(String paramString) {
/* 727 */     GL20 gL20 = Gdx.gl20;
/* 728 */     checkManaged();
/*     */     int i;
/* 730 */     if ((i = fetchAttributeLocation(paramString)) == -1)
/* 731 */       return;  gL20.glDisableVertexAttribArray(i);
/*     */   }
/*     */   
/*     */   public void disableVertexAttribute(int paramInt) {
/* 735 */     GL20 gL20 = Gdx.gl20;
/* 736 */     checkManaged();
/* 737 */     gL20.glDisableVertexAttribArray(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void enableVertexAttribute(String paramString) {
/* 744 */     GL20 gL20 = Gdx.gl20;
/* 745 */     checkManaged();
/*     */     int i;
/* 747 */     if ((i = fetchAttributeLocation(paramString)) == -1)
/* 748 */       return;  gL20.glEnableVertexAttribArray(i);
/*     */   }
/*     */   
/*     */   public void enableVertexAttribute(int paramInt) {
/* 752 */     GL20 gL20 = Gdx.gl20;
/* 753 */     checkManaged();
/* 754 */     gL20.glEnableVertexAttribArray(paramInt);
/*     */   }
/*     */   
/*     */   private void checkManaged() {
/* 758 */     if (this.invalidated) {
/* 759 */       compileShaders(this.vertexShaderSource, this.fragmentShaderSource);
/* 760 */       this.invalidated = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void addManagedShader(Application paramApplication, ShaderProgram paramShaderProgram) {
/*     */     Array array;
/* 766 */     if ((array = (Array)shaders.get(paramApplication)) == null) array = new Array(); 
/* 767 */     array.add(paramShaderProgram);
/* 768 */     shaders.put(paramApplication, array);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void invalidateAllShaderPrograms(Application paramApplication) {
/* 774 */     if (Gdx.gl20 == null)
/*     */       return; 
/*     */     Array array;
/* 777 */     if ((array = (Array)shaders.get(paramApplication)) == null)
/*     */       return; 
/* 779 */     for (byte b = 0; b < array.size; b++) {
/* 780 */       ((ShaderProgram)array.get(b)).invalidated = true;
/* 781 */       ((ShaderProgram)array.get(b)).checkManaged();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void clearAllShaderPrograms(Application paramApplication) {
/* 786 */     shaders.remove(paramApplication);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getManagedStatus() {
/*     */     StringBuilder stringBuilder;
/* 792 */     (stringBuilder = new StringBuilder()).append("Managed shaders/app: { ");
/* 793 */     for (ObjectMap.Keys<Application> keys = shaders.keys().iterator(); keys.hasNext(); ) { Application application = keys.next();
/* 794 */       stringBuilder.append(((Array)shaders.get(application)).size);
/* 795 */       stringBuilder.append(" "); }
/*     */     
/* 797 */     stringBuilder.append("}");
/* 798 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getNumManagedShaderPrograms() {
/* 803 */     return ((Array)shaders.get(Gdx.app)).size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttributef(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 814 */     GL20 gL20 = Gdx.gl20;
/* 815 */     int i = fetchAttributeLocation(paramString);
/* 816 */     gL20.glVertexAttrib4f(i, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/* 819 */   public ShaderProgram(String paramString1, String paramString2) { this.params = BufferUtils.newIntBuffer(1);
/* 820 */     this.type = BufferUtils.newIntBuffer(1); if (paramString1 == null) throw new IllegalArgumentException("vertex shader must not be null");  if (paramString2 == null)
/*     */       throw new IllegalArgumentException("fragment shader must not be null");  if (prependVertexCode != null && prependVertexCode.length() > 0)
/*     */       paramString1 = prependVertexCode + paramString1;  if (prependFragmentCode != null && prependFragmentCode.length() > 0)
/* 823 */       paramString2 = prependFragmentCode + paramString2;  this.vertexShaderSource = paramString1; this.fragmentShaderSource = paramString2; this.matrix = BufferUtils.newFloatBuffer(16); compileShaders(paramString1, paramString2); if (isCompiled()) { fetchAttributes(); fetchUniforms(); addManagedShader(Gdx.app, this); }  } private void fetchUniforms() { this.params.clear();
/* 824 */     Gdx.gl20.glGetProgramiv(this.program, 35718, this.params);
/* 825 */     int i = this.params.get(0);
/*     */     
/* 827 */     this.uniformNames = new String[i];
/*     */     
/* 829 */     for (byte b = 0; b < i; b++) {
/* 830 */       this.params.clear();
/* 831 */       this.params.put(0, 1);
/* 832 */       this.type.clear();
/* 833 */       String str = Gdx.gl20.glGetActiveUniform(this.program, b, this.params, this.type);
/* 834 */       int j = Gdx.gl20.glGetUniformLocation(this.program, str);
/* 835 */       this.uniforms.put(str, j);
/* 836 */       this.uniformTypes.put(str, this.type.get(0));
/* 837 */       this.uniformSizes.put(str, this.params.get(0));
/* 838 */       this.uniformNames[b] = str;
/*     */     }  }
/*     */ 
/*     */   
/*     */   private void fetchAttributes() {
/* 843 */     this.params.clear();
/* 844 */     Gdx.gl20.glGetProgramiv(this.program, 35721, this.params);
/* 845 */     int i = this.params.get(0);
/*     */     
/* 847 */     this.attributeNames = new String[i];
/*     */     
/* 849 */     for (byte b = 0; b < i; b++) {
/* 850 */       this.params.clear();
/* 851 */       this.params.put(0, 1);
/* 852 */       this.type.clear();
/* 853 */       String str = Gdx.gl20.glGetActiveAttrib(this.program, b, this.params, this.type);
/* 854 */       int j = Gdx.gl20.glGetAttribLocation(this.program, str);
/* 855 */       this.attributes.put(str, j);
/* 856 */       this.attributeTypes.put(str, this.type.get(0));
/* 857 */       this.attributeSizes.put(str, this.params.get(0));
/* 858 */       this.attributeNames[b] = str;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasAttribute(String paramString) {
/* 865 */     return this.attributes.containsKey(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAttributeType(String paramString) {
/* 871 */     return this.attributeTypes.get(paramString, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAttributeLocation(String paramString) {
/* 877 */     return this.attributes.get(paramString, -1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAttributeSize(String paramString) {
/* 883 */     return this.attributeSizes.get(paramString, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasUniform(String paramString) {
/* 889 */     return this.uniforms.containsKey(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getUniformType(String paramString) {
/* 895 */     return this.uniformTypes.get(paramString, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getUniformLocation(String paramString) {
/* 901 */     return this.uniforms.get(paramString, -1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getUniformSize(String paramString) {
/* 907 */     return this.uniformSizes.get(paramString, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getAttributes() {
/* 912 */     return this.attributeNames;
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getUniforms() {
/* 917 */     return this.uniformNames;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getVertexShaderSource() {
/* 922 */     return this.vertexShaderSource;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFragmentShaderSource() {
/* 927 */     return this.fragmentShaderSource;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHandle() {
/* 932 */     return this.program;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\ShaderProgram.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */