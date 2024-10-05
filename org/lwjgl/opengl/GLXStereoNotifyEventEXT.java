/*     */ package org.lwjgl.opengl;
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
/*     */ 
/*     */ 
/*     */ public class GLXStereoNotifyEventEXT
/*     */   extends Struct<GLXStereoNotifyEventEXT>
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int EXTENSION;
/*     */   public static final int EVTYPE;
/*     */   public static final int WINDOW;
/*     */   public static final int STEREO_TREE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  62 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(4), __member(4), __member(POINTER_SIZE), __member(4) })).getSize();
/*  63 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  65 */     TYPE = layout.offsetof(0);
/*  66 */     SERIAL = layout.offsetof(1);
/*  67 */     SEND_EVENT = layout.offsetof(2);
/*  68 */     DISPLAY = layout.offsetof(3);
/*  69 */     EXTENSION = layout.offsetof(4);
/*  70 */     EVTYPE = layout.offsetof(5);
/*  71 */     WINDOW = layout.offsetof(6);
/*  72 */     STEREO_TREE = layout.offsetof(7);
/*     */   }
/*     */   
/*     */   protected GLXStereoNotifyEventEXT(long paramLong, ByteBuffer paramByteBuffer) {
/*  76 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLXStereoNotifyEventEXT create(long paramLong, ByteBuffer paramByteBuffer) {
/*  81 */     return new GLXStereoNotifyEventEXT(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLXStereoNotifyEventEXT(ByteBuffer paramByteBuffer) {
/*  91 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  95 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/*  98 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 101 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 104 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 107 */     return ndisplay(address());
/*     */   } public int extension() {
/* 109 */     return nextension(address());
/*     */   } public int evtype() {
/* 111 */     return nevtype(address());
/*     */   } @NativeType("GLXDrawable")
/*     */   public long window() {
/* 114 */     return nwindow(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean stereo_tree() {
/* 117 */     return (nstereo_tree(address()) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLXStereoNotifyEventEXT create(long paramLong) {
/* 123 */     return new GLXStereoNotifyEventEXT(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLXStereoNotifyEventEXT createSafe(long paramLong) {
/* 129 */     return (paramLong == 0L) ? null : new GLXStereoNotifyEventEXT(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 139 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 145 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 151 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 153 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 155 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 157 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static int nextension(long paramLong) {
/* 159 */     return UNSAFE.getInt(null, paramLong + EXTENSION);
/*     */   } public static int nevtype(long paramLong) {
/* 161 */     return UNSAFE.getInt(null, paramLong + EVTYPE);
/*     */   } public static long nwindow(long paramLong) {
/* 163 */     return MemoryUtil.memGetAddress(paramLong + WINDOW);
/*     */   } public static int nstereo_tree(long paramLong) {
/* 165 */     return UNSAFE.getInt(null, paramLong + STEREO_TREE);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<GLXStereoNotifyEventEXT, Buffer>
/*     */   {
/* 172 */     private static final GLXStereoNotifyEventEXT ELEMENT_FACTORY = GLXStereoNotifyEventEXT.create(-1L);
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
/* 184 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / GLXStereoNotifyEventEXT.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 188 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 192 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 197 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected GLXStereoNotifyEventEXT getElementFactory() {
/* 202 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 206 */       return GLXStereoNotifyEventEXT.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 209 */       return GLXStereoNotifyEventEXT.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 212 */       return (GLXStereoNotifyEventEXT.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 215 */       return GLXStereoNotifyEventEXT.ndisplay(address());
/*     */     } public int extension() {
/* 217 */       return GLXStereoNotifyEventEXT.nextension(address());
/*     */     } public int evtype() {
/* 219 */       return GLXStereoNotifyEventEXT.nevtype(address());
/*     */     } @NativeType("GLXDrawable")
/*     */     public long window() {
/* 222 */       return GLXStereoNotifyEventEXT.nwindow(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean stereo_tree() {
/* 225 */       return (GLXStereoNotifyEventEXT.nstereo_tree(address()) != 0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLXStereoNotifyEventEXT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */