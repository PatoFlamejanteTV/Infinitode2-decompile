/*     */ package org.lwjgl.glfw;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Struct;
/*     */ import org.lwjgl.system.StructBuffer;
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
/*     */ @NativeType("struct GLFWvidmode")
/*     */ public class GLFWVidMode
/*     */   extends Struct<GLFWVidMode>
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int WIDTH;
/*     */   public static final int HEIGHT;
/*     */   public static final int REDBITS;
/*     */   public static final int GREENBITS;
/*     */   public static final int BLUEBITS;
/*     */   public static final int REFRESHRATE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  59 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(4), __member(4), __member(4), __member(4) })).getSize();
/*  60 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  62 */     WIDTH = layout.offsetof(0);
/*  63 */     HEIGHT = layout.offsetof(1);
/*  64 */     REDBITS = layout.offsetof(2);
/*  65 */     GREENBITS = layout.offsetof(3);
/*  66 */     BLUEBITS = layout.offsetof(4);
/*  67 */     REFRESHRATE = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected GLFWVidMode(long paramLong, ByteBuffer paramByteBuffer) {
/*  71 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWVidMode create(long paramLong, ByteBuffer paramByteBuffer) {
/*  76 */     return new GLFWVidMode(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWVidMode(ByteBuffer paramByteBuffer) {
/*  86 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  90 */     return SIZEOF;
/*     */   }
/*     */   public int width() {
/*  93 */     return nwidth(address());
/*     */   } public int height() {
/*  95 */     return nheight(address());
/*     */   } public int redBits() {
/*  97 */     return nredBits(address());
/*     */   } public int greenBits() {
/*  99 */     return ngreenBits(address());
/*     */   } public int blueBits() {
/* 101 */     return nblueBits(address());
/*     */   } public int refreshRate() {
/* 103 */     return nrefreshRate(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWVidMode create(long paramLong) {
/* 109 */     return new GLFWVidMode(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWVidMode createSafe(long paramLong) {
/* 115 */     return (paramLong == 0L) ? null : new GLFWVidMode(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 125 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 131 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwidth(long paramLong) {
/* 137 */     return UNSAFE.getInt(null, paramLong + WIDTH);
/*     */   } public static int nheight(long paramLong) {
/* 139 */     return UNSAFE.getInt(null, paramLong + HEIGHT);
/*     */   } public static int nredBits(long paramLong) {
/* 141 */     return UNSAFE.getInt(null, paramLong + REDBITS);
/*     */   } public static int ngreenBits(long paramLong) {
/* 143 */     return UNSAFE.getInt(null, paramLong + GREENBITS);
/*     */   } public static int nblueBits(long paramLong) {
/* 145 */     return UNSAFE.getInt(null, paramLong + BLUEBITS);
/*     */   } public static int nrefreshRate(long paramLong) {
/* 147 */     return UNSAFE.getInt(null, paramLong + REFRESHRATE);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<GLFWVidMode, Buffer>
/*     */   {
/* 154 */     private static final GLFWVidMode ELEMENT_FACTORY = GLFWVidMode.create(-1L);
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
/*     */     public Buffer(ByteBuffer param1ByteBuffer) {
/* 166 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / GLFWVidMode.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 170 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 174 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 179 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected GLFWVidMode getElementFactory() {
/* 184 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int width() {
/* 188 */       return GLFWVidMode.nwidth(address());
/*     */     } public int height() {
/* 190 */       return GLFWVidMode.nheight(address());
/*     */     } public int redBits() {
/* 192 */       return GLFWVidMode.nredBits(address());
/*     */     } public int greenBits() {
/* 194 */       return GLFWVidMode.ngreenBits(address());
/*     */     } public int blueBits() {
/* 196 */       return GLFWVidMode.nblueBits(address());
/*     */     } public int refreshRate() {
/* 198 */       return GLFWVidMode.nrefreshRate(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWVidMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */