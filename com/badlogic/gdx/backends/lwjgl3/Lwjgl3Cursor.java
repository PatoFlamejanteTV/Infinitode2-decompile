/*     */ package com.badlogic.gdx.backends.lwjgl3;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Cursor;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.lwjgl.glfw.GLFW;
/*     */ import org.lwjgl.glfw.GLFWImage;
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
/*     */ public class Lwjgl3Cursor
/*     */   implements Cursor
/*     */ {
/*  32 */   static final Array<Lwjgl3Cursor> cursors = new Array();
/*  33 */   static final Map<Cursor.SystemCursor, Long> systemCursors = new HashMap<>();
/*     */   
/*  35 */   private static int inputModeBeforeNoneCursor = -1;
/*     */   
/*     */   final Lwjgl3Window window;
/*     */   Pixmap pixmapCopy;
/*     */   GLFWImage glfwImage;
/*     */   final long glfwCursor;
/*     */   
/*     */   Lwjgl3Cursor(Lwjgl3Window paramLwjgl3Window, Pixmap paramPixmap, int paramInt1, int paramInt2) {
/*  43 */     this.window = paramLwjgl3Window;
/*  44 */     if (paramPixmap.getFormat() != Pixmap.Format.RGBA8888) {
/*  45 */       throw new GdxRuntimeException("Cursor image pixmap is not in RGBA8888 format.");
/*     */     }
/*     */     
/*  48 */     if ((paramPixmap.getWidth() & paramPixmap.getWidth() - 1) != 0) {
/*  49 */       throw new GdxRuntimeException("Cursor image pixmap width of " + paramPixmap
/*  50 */           .getWidth() + " is not a power-of-two greater than zero.");
/*     */     }
/*     */     
/*  53 */     if ((paramPixmap.getHeight() & paramPixmap.getHeight() - 1) != 0) {
/*  54 */       throw new GdxRuntimeException("Cursor image pixmap height of " + paramPixmap
/*  55 */           .getHeight() + " is not a power-of-two greater than zero.");
/*     */     }
/*     */     
/*  58 */     if (paramInt1 < 0 || paramInt1 >= paramPixmap.getWidth()) {
/*  59 */       throw new GdxRuntimeException("xHotspot coordinate of " + paramInt1 + " is not within image width bounds: [0, " + paramPixmap
/*  60 */           .getWidth() + ").");
/*     */     }
/*     */     
/*  63 */     if (paramInt2 < 0 || paramInt2 >= paramPixmap.getHeight()) {
/*  64 */       throw new GdxRuntimeException("yHotspot coordinate of " + paramInt2 + " is not within image height bounds: [0, " + paramPixmap
/*  65 */           .getHeight() + ").");
/*     */     }
/*     */     
/*  68 */     this.pixmapCopy = new Pixmap(paramPixmap.getWidth(), paramPixmap.getHeight(), Pixmap.Format.RGBA8888);
/*  69 */     this.pixmapCopy.setBlending(Pixmap.Blending.None);
/*  70 */     this.pixmapCopy.drawPixmap(paramPixmap, 0, 0);
/*     */     
/*  72 */     this.glfwImage = GLFWImage.malloc();
/*  73 */     this.glfwImage.width(this.pixmapCopy.getWidth());
/*  74 */     this.glfwImage.height(this.pixmapCopy.getHeight());
/*  75 */     this.glfwImage.pixels(this.pixmapCopy.getPixels());
/*  76 */     this.glfwCursor = GLFW.glfwCreateCursor(this.glfwImage, paramInt1, paramInt2);
/*  77 */     cursors.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/*  82 */     if (this.pixmapCopy == null) {
/*  83 */       throw new GdxRuntimeException("Cursor already disposed");
/*     */     }
/*  85 */     cursors.removeValue(this, true);
/*  86 */     this.pixmapCopy.dispose();
/*  87 */     this.pixmapCopy = null;
/*  88 */     this.glfwImage.free();
/*  89 */     GLFW.glfwDestroyCursor(this.glfwCursor);
/*     */   }
/*     */   
/*     */   static void dispose(Lwjgl3Window paramLwjgl3Window) {
/*  93 */     for (int i = cursors.size - 1; i >= 0; i--) {
/*     */       Lwjgl3Cursor lwjgl3Cursor;
/*  95 */       if ((lwjgl3Cursor = (Lwjgl3Cursor)cursors.get(i)).window.equals(paramLwjgl3Window)) {
/*  96 */         ((Lwjgl3Cursor)cursors.removeIndex(i)).dispose();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void disposeSystemCursors() {
/*     */     // Byte code:
/*     */     //   0: getstatic com/badlogic/gdx/backends/lwjgl3/Lwjgl3Cursor.systemCursors : Ljava/util/Map;
/*     */     //   3: invokeinterface values : ()Ljava/util/Collection;
/*     */     //   8: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   13: astore_0
/*     */     //   14: aload_0
/*     */     //   15: invokeinterface hasNext : ()Z
/*     */     //   20: ifeq -> 43
/*     */     //   23: aload_0
/*     */     //   24: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   29: checkcast java/lang/Long
/*     */     //   32: invokevirtual longValue : ()J
/*     */     //   35: dup2
/*     */     //   36: lstore_1
/*     */     //   37: invokestatic glfwDestroyCursor : (J)V
/*     */     //   40: goto -> 14
/*     */     //   43: getstatic com/badlogic/gdx/backends/lwjgl3/Lwjgl3Cursor.systemCursors : Ljava/util/Map;
/*     */     //   46: invokeinterface clear : ()V
/*     */     //   51: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #102	-> 0
/*     */     //   #103	-> 36
/*     */     //   #104	-> 40
/*     */     //   #105	-> 43
/*     */     //   #106	-> 51
/*     */   }
/*     */ 
/*     */   
/*     */   static void setSystemCursor(long paramLong, Cursor.SystemCursor paramSystemCursor) {
/* 109 */     if (paramSystemCursor == Cursor.SystemCursor.None) {
/* 110 */       if (inputModeBeforeNoneCursor == -1) inputModeBeforeNoneCursor = GLFW.glfwGetInputMode(paramLong, 208897); 
/* 111 */       GLFW.glfwSetInputMode(paramLong, 208897, 212994); return;
/*     */     } 
/* 113 */     if (inputModeBeforeNoneCursor != -1) {
/* 114 */       GLFW.glfwSetInputMode(paramLong, 208897, inputModeBeforeNoneCursor);
/* 115 */       inputModeBeforeNoneCursor = -1;
/*     */     } 
/*     */     Long long_;
/* 118 */     if ((long_ = systemCursors.get(paramSystemCursor)) == null) {
/*     */       long l;
/* 120 */       if (paramSystemCursor == Cursor.SystemCursor.Arrow) {
/* 121 */         l = GLFW.glfwCreateStandardCursor(221185);
/* 122 */       } else if (paramSystemCursor == Cursor.SystemCursor.Crosshair) {
/* 123 */         l = GLFW.glfwCreateStandardCursor(221187);
/* 124 */       } else if (paramSystemCursor == Cursor.SystemCursor.Hand) {
/* 125 */         l = GLFW.glfwCreateStandardCursor(221188);
/* 126 */       } else if (paramSystemCursor == Cursor.SystemCursor.HorizontalResize) {
/* 127 */         l = GLFW.glfwCreateStandardCursor(221189);
/* 128 */       } else if (paramSystemCursor == Cursor.SystemCursor.VerticalResize) {
/* 129 */         l = GLFW.glfwCreateStandardCursor(221190);
/* 130 */       } else if (paramSystemCursor == Cursor.SystemCursor.Ibeam) {
/* 131 */         l = GLFW.glfwCreateStandardCursor(221186);
/* 132 */       } else if (paramSystemCursor == Cursor.SystemCursor.NWSEResize) {
/* 133 */         l = GLFW.glfwCreateStandardCursor(221191);
/* 134 */       } else if (paramSystemCursor == Cursor.SystemCursor.NESWResize) {
/* 135 */         l = GLFW.glfwCreateStandardCursor(221192);
/* 136 */       } else if (paramSystemCursor == Cursor.SystemCursor.AllResize) {
/* 137 */         l = GLFW.glfwCreateStandardCursor(221193);
/* 138 */       } else if (paramSystemCursor == Cursor.SystemCursor.NotAllowed) {
/* 139 */         l = GLFW.glfwCreateStandardCursor(221194);
/*     */       } else {
/* 141 */         throw new GdxRuntimeException("Unknown system cursor " + paramSystemCursor);
/*     */       } 
/*     */       
/* 144 */       if (l == 0L) {
/*     */         return;
/*     */       }
/* 147 */       long_ = Long.valueOf(l);
/* 148 */       systemCursors.put(paramSystemCursor, long_);
/*     */     } 
/* 150 */     GLFW.glfwSetCursor(paramLong, long_.longValue());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Lwjgl3Cursor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */