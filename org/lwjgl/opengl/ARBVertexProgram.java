/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ARBVertexProgram
/*      */ {
/*      */   public static final int GL_VERTEX_PROGRAM_ARB = 34336;
/*      */   public static final int GL_VERTEX_PROGRAM_POINT_SIZE_ARB = 34370;
/*      */   public static final int GL_VERTEX_PROGRAM_TWO_SIDE_ARB = 34371;
/*      */   public static final int GL_COLOR_SUM_ARB = 33880;
/*      */   public static final int GL_PROGRAM_FORMAT_ASCII_ARB = 34933;
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED_ARB = 34338;
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE_ARB = 34339;
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE_ARB = 34340;
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE_ARB = 34341;
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED_ARB = 34922;
/*      */   public static final int GL_CURRENT_VERTEX_ATTRIB_ARB = 34342;
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER_ARB = 34373;
/*      */   public static final int GL_PROGRAM_LENGTH_ARB = 34343;
/*      */   public static final int GL_PROGRAM_FORMAT_ARB = 34934;
/*      */   public static final int GL_PROGRAM_BINDING_ARB = 34423;
/*      */   public static final int GL_PROGRAM_INSTRUCTIONS_ARB = 34976;
/*      */   public static final int GL_MAX_PROGRAM_INSTRUCTIONS_ARB = 34977;
/*      */   public static final int GL_PROGRAM_NATIVE_INSTRUCTIONS_ARB = 34978;
/*      */   public static final int GL_MAX_PROGRAM_NATIVE_INSTRUCTIONS_ARB = 34979;
/*      */   
/*      */   static {
/*   53 */     GL.initialize();
/*      */   }
/*      */ 
/*      */   
/*      */   public static final int GL_PROGRAM_TEMPORARIES_ARB = 34980;
/*      */   
/*      */   public static final int GL_MAX_PROGRAM_TEMPORARIES_ARB = 34981;
/*      */   
/*      */   public static final int GL_PROGRAM_NATIVE_TEMPORARIES_ARB = 34982;
/*      */   
/*      */   public static final int GL_MAX_PROGRAM_NATIVE_TEMPORARIES_ARB = 34983;
/*      */   
/*      */   public static final int GL_PROGRAM_PARAMETERS_ARB = 34984;
/*      */   
/*      */   public static final int GL_MAX_PROGRAM_PARAMETERS_ARB = 34985;
/*      */   
/*      */   public static final int GL_PROGRAM_NATIVE_PARAMETERS_ARB = 34986;
/*      */   
/*      */   public static final int GL_MAX_PROGRAM_NATIVE_PARAMETERS_ARB = 34987;
/*      */   
/*      */   public static final int GL_PROGRAM_ATTRIBS_ARB = 34988;
/*      */   
/*      */   public static final int GL_MAX_PROGRAM_ATTRIBS_ARB = 34989;
/*      */   
/*      */   public static final int GL_PROGRAM_NATIVE_ATTRIBS_ARB = 34990;
/*      */   
/*      */   public static final int GL_MAX_PROGRAM_NATIVE_ATTRIBS_ARB = 34991;
/*      */   
/*      */   public static final int GL_PROGRAM_ADDRESS_REGISTERS_ARB = 34992;
/*      */   
/*      */   public static final int GL_MAX_PROGRAM_ADDRESS_REGISTERS_ARB = 34993;
/*      */   
/*      */   public static final int GL_PROGRAM_NATIVE_ADDRESS_REGISTERS_ARB = 34994;
/*      */   
/*      */   public static final int GL_MAX_PROGRAM_NATIVE_ADDRESS_REGISTERS_ARB = 34995;
/*      */   
/*      */   public static final int GL_MAX_PROGRAM_LOCAL_PARAMETERS_ARB = 34996;
/*      */   
/*      */   public static final int GL_MAX_PROGRAM_ENV_PARAMETERS_ARB = 34997;
/*      */   
/*      */   public static final int GL_PROGRAM_UNDER_NATIVE_LIMITS_ARB = 34998;
/*      */   
/*      */   public static final int GL_PROGRAM_STRING_ARB = 34344;
/*      */   
/*      */   public static final int GL_PROGRAM_ERROR_POSITION_ARB = 34379;
/*      */   
/*      */   public static final int GL_CURRENT_MATRIX_ARB = 34369;
/*      */   
/*      */   public static final int GL_TRANSPOSE_CURRENT_MATRIX_ARB = 34999;
/*      */   
/*      */   public static final int GL_CURRENT_MATRIX_STACK_DEPTH_ARB = 34368;
/*      */   
/*      */   public static final int GL_MAX_VERTEX_ATTRIBS_ARB = 34921;
/*      */   
/*      */   public static final int GL_MAX_PROGRAM_MATRICES_ARB = 34351;
/*      */   
/*      */   public static final int GL_MAX_PROGRAM_MATRIX_STACK_DEPTH_ARB = 34350;
/*      */   
/*      */   public static final int GL_PROGRAM_ERROR_STRING_ARB = 34932;
/*      */   
/*      */   public static final int GL_MATRIX0_ARB = 35008;
/*      */   
/*      */   public static final int GL_MATRIX1_ARB = 35009;
/*      */   
/*      */   public static final int GL_MATRIX2_ARB = 35010;
/*      */   
/*      */   public static final int GL_MATRIX3_ARB = 35011;
/*      */   
/*      */   public static final int GL_MATRIX4_ARB = 35012;
/*      */   
/*      */   public static final int GL_MATRIX5_ARB = 35013;
/*      */   
/*      */   public static final int GL_MATRIX6_ARB = 35014;
/*      */   
/*      */   public static final int GL_MATRIX7_ARB = 35015;
/*      */   
/*      */   public static final int GL_MATRIX8_ARB = 35016;
/*      */   
/*      */   public static final int GL_MATRIX9_ARB = 35017;
/*      */   
/*      */   public static final int GL_MATRIX10_ARB = 35018;
/*      */   
/*      */   public static final int GL_MATRIX11_ARB = 35019;
/*      */   
/*      */   public static final int GL_MATRIX12_ARB = 35020;
/*      */   
/*      */   public static final int GL_MATRIX13_ARB = 35021;
/*      */   
/*      */   public static final int GL_MATRIX14_ARB = 35022;
/*      */   
/*      */   public static final int GL_MATRIX15_ARB = 35023;
/*      */   
/*      */   public static final int GL_MATRIX16_ARB = 35024;
/*      */   
/*      */   public static final int GL_MATRIX17_ARB = 35025;
/*      */   
/*      */   public static final int GL_MATRIX18_ARB = 35026;
/*      */   
/*      */   public static final int GL_MATRIX19_ARB = 35027;
/*      */   
/*      */   public static final int GL_MATRIX20_ARB = 35028;
/*      */   public static final int GL_MATRIX21_ARB = 35029;
/*      */   public static final int GL_MATRIX22_ARB = 35030;
/*      */   public static final int GL_MATRIX23_ARB = 35031;
/*      */   public static final int GL_MATRIX24_ARB = 35032;
/*      */   public static final int GL_MATRIX25_ARB = 35033;
/*      */   public static final int GL_MATRIX26_ARB = 35034;
/*      */   public static final int GL_MATRIX27_ARB = 35035;
/*      */   public static final int GL_MATRIX28_ARB = 35036;
/*      */   public static final int GL_MATRIX29_ARB = 35037;
/*      */   public static final int GL_MATRIX30_ARB = 35038;
/*      */   public static final int GL_MATRIX31_ARB = 35039;
/*      */   
/*      */   protected ARBVertexProgram() {
/*  167 */     throw new UnsupportedOperationException();
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
/*      */   public static void glVertexAttrib1sARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort) {
/*  179 */     ARBVertexShader.glVertexAttrib1sARB(paramInt, paramShort);
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
/*      */   public static void glVertexAttrib1fARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat) {
/*  191 */     ARBVertexShader.glVertexAttrib1fARB(paramInt, paramFloat);
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
/*      */   public static void glVertexAttrib1dARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble) {
/*  203 */     ARBVertexShader.glVertexAttrib1dARB(paramInt, paramDouble);
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
/*      */   public static void glVertexAttrib2sARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2) {
/*  216 */     ARBVertexShader.glVertexAttrib2sARB(paramInt, paramShort1, paramShort2);
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
/*      */   public static void glVertexAttrib2fARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2) {
/*  229 */     ARBVertexShader.glVertexAttrib2fARB(paramInt, paramFloat1, paramFloat2);
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
/*      */   public static void glVertexAttrib2dARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2) {
/*  242 */     ARBVertexShader.glVertexAttrib2dARB(paramInt, paramDouble1, paramDouble2);
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
/*      */   public static void glVertexAttrib3sARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3) {
/*  256 */     ARBVertexShader.glVertexAttrib3sARB(paramInt, paramShort1, paramShort2, paramShort3);
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
/*      */   public static void glVertexAttrib3fARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3) {
/*  270 */     ARBVertexShader.glVertexAttrib3fARB(paramInt, paramFloat1, paramFloat2, paramFloat3);
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
/*      */   public static void glVertexAttrib3dARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3) {
/*  284 */     ARBVertexShader.glVertexAttrib3dARB(paramInt, paramDouble1, paramDouble2, paramDouble3);
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
/*      */   public static void glVertexAttrib4sARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4) {
/*  299 */     ARBVertexShader.glVertexAttrib4sARB(paramInt, paramShort1, paramShort2, paramShort3, paramShort4);
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
/*      */   public static void glVertexAttrib4fARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4) {
/*  314 */     ARBVertexShader.glVertexAttrib4fARB(paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
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
/*      */   public static void glVertexAttrib4dARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4) {
/*  329 */     ARBVertexShader.glVertexAttrib4dARB(paramInt, paramDouble1, paramDouble2, paramDouble3, paramDouble4);
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
/*      */   public static void glVertexAttrib4NubARB(@NativeType("GLuint") int paramInt, @NativeType("GLubyte") byte paramByte1, @NativeType("GLubyte") byte paramByte2, @NativeType("GLubyte") byte paramByte3, @NativeType("GLubyte") byte paramByte4) {
/*  344 */     ARBVertexShader.glVertexAttrib4NubARB(paramInt, paramByte1, paramByte2, paramByte3, paramByte4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib1svARB(int paramInt, long paramLong) {
/*  351 */     ARBVertexShader.nglVertexAttrib1svARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1svARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  361 */     ARBVertexShader.glVertexAttrib1svARB(paramInt, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib1fvARB(int paramInt, long paramLong) {
/*  368 */     ARBVertexShader.nglVertexAttrib1fvARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1fvARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  378 */     ARBVertexShader.glVertexAttrib1fvARB(paramInt, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib1dvARB(int paramInt, long paramLong) {
/*  385 */     ARBVertexShader.nglVertexAttrib1dvARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1dvARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  395 */     ARBVertexShader.glVertexAttrib1dvARB(paramInt, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib2svARB(int paramInt, long paramLong) {
/*  402 */     ARBVertexShader.nglVertexAttrib2svARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2svARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  412 */     ARBVertexShader.glVertexAttrib2svARB(paramInt, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib2fvARB(int paramInt, long paramLong) {
/*  419 */     ARBVertexShader.nglVertexAttrib2fvARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2fvARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  429 */     ARBVertexShader.glVertexAttrib2fvARB(paramInt, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib2dvARB(int paramInt, long paramLong) {
/*  436 */     ARBVertexShader.nglVertexAttrib2dvARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2dvARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  446 */     ARBVertexShader.glVertexAttrib2dvARB(paramInt, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib3svARB(int paramInt, long paramLong) {
/*  453 */     ARBVertexShader.nglVertexAttrib3svARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3svARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  463 */     ARBVertexShader.glVertexAttrib3svARB(paramInt, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib3fvARB(int paramInt, long paramLong) {
/*  470 */     ARBVertexShader.nglVertexAttrib3fvARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3fvARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  480 */     ARBVertexShader.glVertexAttrib3fvARB(paramInt, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib3dvARB(int paramInt, long paramLong) {
/*  487 */     ARBVertexShader.nglVertexAttrib3dvARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3dvARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  497 */     ARBVertexShader.glVertexAttrib3dvARB(paramInt, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4fvARB(int paramInt, long paramLong) {
/*  504 */     ARBVertexShader.nglVertexAttrib4fvARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4fvARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  514 */     ARBVertexShader.glVertexAttrib4fvARB(paramInt, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4bvARB(int paramInt, long paramLong) {
/*  521 */     ARBVertexShader.nglVertexAttrib4bvARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4bvARB(@NativeType("GLuint") int paramInt, @NativeType("GLbyte const *") ByteBuffer paramByteBuffer) {
/*  531 */     ARBVertexShader.glVertexAttrib4bvARB(paramInt, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4svARB(int paramInt, long paramLong) {
/*  538 */     ARBVertexShader.nglVertexAttrib4svARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4svARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  548 */     ARBVertexShader.glVertexAttrib4svARB(paramInt, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4ivARB(int paramInt, long paramLong) {
/*  555 */     ARBVertexShader.nglVertexAttrib4ivARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4ivARB(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  565 */     ARBVertexShader.glVertexAttrib4ivARB(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4ubvARB(int paramInt, long paramLong) {
/*  572 */     ARBVertexShader.nglVertexAttrib4ubvARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4ubvARB(@NativeType("GLuint") int paramInt, @NativeType("GLubyte const *") ByteBuffer paramByteBuffer) {
/*  582 */     ARBVertexShader.glVertexAttrib4ubvARB(paramInt, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4usvARB(int paramInt, long paramLong) {
/*  589 */     ARBVertexShader.nglVertexAttrib4usvARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4usvARB(@NativeType("GLuint") int paramInt, @NativeType("GLushort const *") ShortBuffer paramShortBuffer) {
/*  599 */     ARBVertexShader.glVertexAttrib4usvARB(paramInt, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4uivARB(int paramInt, long paramLong) {
/*  606 */     ARBVertexShader.nglVertexAttrib4uivARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4uivARB(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  616 */     ARBVertexShader.glVertexAttrib4uivARB(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4dvARB(int paramInt, long paramLong) {
/*  623 */     ARBVertexShader.nglVertexAttrib4dvARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4dvARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  633 */     ARBVertexShader.glVertexAttrib4dvARB(paramInt, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4NbvARB(int paramInt, long paramLong) {
/*  640 */     ARBVertexShader.nglVertexAttrib4NbvARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NbvARB(@NativeType("GLuint") int paramInt, @NativeType("GLbyte const *") ByteBuffer paramByteBuffer) {
/*  650 */     ARBVertexShader.glVertexAttrib4NbvARB(paramInt, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4NsvARB(int paramInt, long paramLong) {
/*  657 */     ARBVertexShader.nglVertexAttrib4NsvARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NsvARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  667 */     ARBVertexShader.glVertexAttrib4NsvARB(paramInt, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4NivARB(int paramInt, long paramLong) {
/*  674 */     ARBVertexShader.nglVertexAttrib4NivARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NivARB(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  684 */     ARBVertexShader.glVertexAttrib4NivARB(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4NubvARB(int paramInt, long paramLong) {
/*  691 */     ARBVertexShader.nglVertexAttrib4NubvARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NubvARB(@NativeType("GLuint") int paramInt, @NativeType("GLubyte const *") ByteBuffer paramByteBuffer) {
/*  701 */     ARBVertexShader.glVertexAttrib4NubvARB(paramInt, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4NusvARB(int paramInt, long paramLong) {
/*  708 */     ARBVertexShader.nglVertexAttrib4NusvARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NusvARB(@NativeType("GLuint") int paramInt, @NativeType("GLushort const *") ShortBuffer paramShortBuffer) {
/*  718 */     ARBVertexShader.glVertexAttrib4NusvARB(paramInt, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4NuivARB(int paramInt, long paramLong) {
/*  725 */     ARBVertexShader.nglVertexAttrib4NuivARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NuivARB(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  735 */     ARBVertexShader.glVertexAttrib4NuivARB(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribPointerARB(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, long paramLong) {
/*  742 */     ARBVertexShader.nglVertexAttribPointerARB(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramLong);
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
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  758 */     ARBVertexShader.glVertexAttribPointerARB(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramByteBuffer);
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
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") long paramLong) {
/*  774 */     ARBVertexShader.glVertexAttribPointerARB(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramLong);
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
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  790 */     ARBVertexShader.glVertexAttribPointerARB(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramShortBuffer);
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
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  806 */     ARBVertexShader.glVertexAttribPointerARB(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramIntBuffer);
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
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  822 */     ARBVertexShader.glVertexAttribPointerARB(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEnableVertexAttribArrayARB(@NativeType("GLuint") int paramInt) {
/*  833 */     ARBVertexShader.glEnableVertexAttribArrayARB(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDisableVertexAttribArrayARB(@NativeType("GLuint") int paramInt) {
/*  844 */     ARBVertexShader.glDisableVertexAttribArrayARB(paramInt);
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
/*      */   public static void glProgramStringARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  875 */     nglProgramStringARB(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glDeleteProgramsARB(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  905 */     nglDeleteProgramsARB(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glGenProgramsARB(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  924 */     nglGenProgramsARB(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenProgramsARB() {
/*      */     MemoryStack memoryStack;
/*  933 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  935 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  936 */       nglGenProgramsARB(1, MemoryUtil.memAddress(intBuffer));
/*  937 */       return intBuffer.get(0);
/*      */     } finally {
/*  939 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramEnvParameter4dvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  970 */     if (Checks.CHECKS) {
/*  971 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/*  973 */     nglProgramEnvParameter4dvARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glProgramEnvParameter4fvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1003 */     if (Checks.CHECKS) {
/* 1004 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 1006 */     nglProgramEnvParameter4fvARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glProgramLocalParameter4dvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1036 */     if (Checks.CHECKS) {
/* 1037 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/* 1039 */     nglProgramLocalParameter4dvARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glProgramLocalParameter4fvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1069 */     if (Checks.CHECKS) {
/* 1070 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 1072 */     nglProgramLocalParameter4fvARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glGetProgramEnvParameterfvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 1089 */     if (Checks.CHECKS) {
/* 1090 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 1092 */     nglGetProgramEnvParameterfvARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glGetProgramEnvParameterdvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 1108 */     if (Checks.CHECKS) {
/* 1109 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/* 1111 */     nglGetProgramEnvParameterdvARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glGetProgramLocalParameterfvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 1128 */     if (Checks.CHECKS) {
/* 1129 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 1131 */     nglGetProgramLocalParameterfvARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glGetProgramLocalParameterdvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 1147 */     if (Checks.CHECKS) {
/* 1148 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/* 1150 */     nglGetProgramLocalParameterdvARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glGetProgramivARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1167 */     if (Checks.CHECKS) {
/* 1168 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1170 */     nglGetProgramivARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetProgramiARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1182 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1184 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1185 */       nglGetProgramivARB(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1186 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1188 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramStringARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 1208 */     if (Checks.CHECKS && 
/* 1209 */       Checks.DEBUG) {
/* 1210 */       Checks.check(paramByteBuffer, glGetProgramiARB(paramInt1, 34343));
/*      */     }
/*      */     
/* 1213 */     nglGetProgramStringARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribfvARB(int paramInt1, int paramInt2, long paramLong) {
/* 1220 */     ARBVertexShader.nglGetVertexAttribfvARB(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribfvARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 1231 */     ARBVertexShader.glGetVertexAttribfvARB(paramInt1, paramInt2, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribdvARB(int paramInt1, int paramInt2, long paramLong) {
/* 1238 */     ARBVertexShader.nglGetVertexAttribdvARB(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribdvARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 1249 */     ARBVertexShader.glGetVertexAttribdvARB(paramInt1, paramInt2, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribivARB(int paramInt1, int paramInt2, long paramLong) {
/* 1256 */     ARBVertexShader.nglGetVertexAttribivARB(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribivARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1267 */     ARBVertexShader.glGetVertexAttribivARB(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetVertexAttribiARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1278 */     return ARBVertexShader.glGetVertexAttribiARB(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribPointervARB(int paramInt1, int paramInt2, long paramLong) {
/* 1285 */     ARBVertexShader.nglGetVertexAttribPointervARB(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribPointervARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/* 1296 */     ARBVertexShader.glGetVertexAttribPointervARB(paramInt1, paramInt2, paramPointerBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetVertexAttribPointerARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1307 */     return ARBVertexShader.glGetVertexAttribPointerARB(paramInt1, paramInt2);
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
/*      */   public static void glVertexAttrib1svARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 1324 */     ARBVertexShader.glVertexAttrib1svARB(paramInt, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1fvARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1329 */     ARBVertexShader.glVertexAttrib1fvARB(paramInt, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1dvARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1334 */     ARBVertexShader.glVertexAttrib1dvARB(paramInt, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2svARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 1339 */     ARBVertexShader.glVertexAttrib2svARB(paramInt, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2fvARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1344 */     ARBVertexShader.glVertexAttrib2fvARB(paramInt, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2dvARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1349 */     ARBVertexShader.glVertexAttrib2dvARB(paramInt, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3svARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 1354 */     ARBVertexShader.glVertexAttrib3svARB(paramInt, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3fvARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1359 */     ARBVertexShader.glVertexAttrib3fvARB(paramInt, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3dvARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1364 */     ARBVertexShader.glVertexAttrib3dvARB(paramInt, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4fvARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1369 */     ARBVertexShader.glVertexAttrib4fvARB(paramInt, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4svARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 1374 */     ARBVertexShader.glVertexAttrib4svARB(paramInt, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4ivARB(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1379 */     ARBVertexShader.glVertexAttrib4ivARB(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4usvARB(@NativeType("GLuint") int paramInt, @NativeType("GLushort const *") short[] paramArrayOfshort) {
/* 1384 */     ARBVertexShader.glVertexAttrib4usvARB(paramInt, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4uivARB(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1389 */     ARBVertexShader.glVertexAttrib4uivARB(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4dvARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1394 */     ARBVertexShader.glVertexAttrib4dvARB(paramInt, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NsvARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 1399 */     ARBVertexShader.glVertexAttrib4NsvARB(paramInt, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NivARB(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1404 */     ARBVertexShader.glVertexAttrib4NivARB(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NusvARB(@NativeType("GLuint") int paramInt, @NativeType("GLushort const *") short[] paramArrayOfshort) {
/* 1409 */     ARBVertexShader.glVertexAttrib4NusvARB(paramInt, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NuivARB(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1414 */     ARBVertexShader.glVertexAttrib4NuivARB(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 1419 */     ARBVertexShader.glVertexAttribPointerARB(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 1424 */     ARBVertexShader.glVertexAttribPointerARB(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 1429 */     ARBVertexShader.glVertexAttribPointerARB(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteProgramsARB(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1434 */     long l = (GL.getICD()).glDeleteProgramsARB;
/* 1435 */     if (Checks.CHECKS) {
/* 1436 */       Checks.check(l);
/*      */     }
/* 1438 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGenProgramsARB(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 1443 */     long l = (GL.getICD()).glGenProgramsARB;
/* 1444 */     if (Checks.CHECKS) {
/* 1445 */       Checks.check(l);
/*      */     }
/* 1447 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramEnvParameter4dvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1452 */     long l = (GL.getICD()).glProgramEnvParameter4dvARB;
/* 1453 */     if (Checks.CHECKS) {
/* 1454 */       Checks.check(l);
/* 1455 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 1457 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramEnvParameter4fvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1462 */     long l = (GL.getICD()).glProgramEnvParameter4fvARB;
/* 1463 */     if (Checks.CHECKS) {
/* 1464 */       Checks.check(l);
/* 1465 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 1467 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramLocalParameter4dvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1472 */     long l = (GL.getICD()).glProgramLocalParameter4dvARB;
/* 1473 */     if (Checks.CHECKS) {
/* 1474 */       Checks.check(l);
/* 1475 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 1477 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramLocalParameter4fvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1482 */     long l = (GL.getICD()).glProgramLocalParameter4fvARB;
/* 1483 */     if (Checks.CHECKS) {
/* 1484 */       Checks.check(l);
/* 1485 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 1487 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramEnvParameterfvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1492 */     long l = (GL.getICD()).glGetProgramEnvParameterfvARB;
/* 1493 */     if (Checks.CHECKS) {
/* 1494 */       Checks.check(l);
/* 1495 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 1497 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramEnvParameterdvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 1502 */     long l = (GL.getICD()).glGetProgramEnvParameterdvARB;
/* 1503 */     if (Checks.CHECKS) {
/* 1504 */       Checks.check(l);
/* 1505 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 1507 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramLocalParameterfvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1512 */     long l = (GL.getICD()).glGetProgramLocalParameterfvARB;
/* 1513 */     if (Checks.CHECKS) {
/* 1514 */       Checks.check(l);
/* 1515 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 1517 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramLocalParameterdvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 1522 */     long l = (GL.getICD()).glGetProgramLocalParameterdvARB;
/* 1523 */     if (Checks.CHECKS) {
/* 1524 */       Checks.check(l);
/* 1525 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 1527 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramivARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1532 */     long l = (GL.getICD()).glGetProgramivARB;
/* 1533 */     if (Checks.CHECKS) {
/* 1534 */       Checks.check(l);
/* 1535 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1537 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribfvARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1542 */     ARBVertexShader.glGetVertexAttribfvARB(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribdvARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 1547 */     ARBVertexShader.glGetVertexAttribdvARB(paramInt1, paramInt2, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribivARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1552 */     ARBVertexShader.glGetVertexAttribivARB(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */   
/*      */   public static native void nglProgramStringARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glBindProgramARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglDeleteProgramsARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGenProgramsARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glProgramEnvParameter4dARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglProgramEnvParameter4dvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glProgramEnvParameter4fARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void nglProgramEnvParameter4fvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glProgramLocalParameter4dARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglProgramLocalParameter4dvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glProgramLocalParameter4fARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void nglProgramLocalParameter4fvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetProgramEnvParameterfvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetProgramEnvParameterdvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetProgramLocalParameterfvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetProgramLocalParameterdvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetProgramivARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetProgramStringARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsProgramARB(@NativeType("GLuint") int paramInt);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBVertexProgram.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */