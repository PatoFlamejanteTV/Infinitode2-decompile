/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EXTRasterMultisample
/*    */ {
/*    */   public static final int GL_RASTER_MULTISAMPLE_EXT = 37671;
/*    */   public static final int GL_RASTER_SAMPLES_EXT = 37672;
/*    */   public static final int GL_MAX_RASTER_SAMPLES_EXT = 37673;
/*    */   public static final int GL_RASTER_FIXED_SAMPLE_LOCATIONS_EXT = 37674;
/*    */   public static final int GL_MULTISAMPLE_RASTERIZATION_ALLOWED_EXT = 37675;
/*    */   public static final int GL_EFFECTIVE_RASTER_SAMPLES_EXT = 37676;
/*    */   
/*    */   static {
/* 26 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glRasterSamplesEXT(@NativeType("GLuint") int paramInt, @NativeType("GLboolean") boolean paramBoolean);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected EXTRasterMultisample() {
/* 40 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTRasterMultisample.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */