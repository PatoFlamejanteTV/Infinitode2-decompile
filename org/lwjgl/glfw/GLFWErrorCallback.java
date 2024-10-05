/*     */ package org.lwjgl.glfw;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.Map;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Callback;
/*     */ import org.lwjgl.system.MemoryUtil;
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
/*     */ public abstract class GLFWErrorCallback
/*     */   extends Callback
/*     */   implements GLFWErrorCallbackI
/*     */ {
/*     */   public static GLFWErrorCallback create(long paramLong) {
/*     */     GLFWErrorCallbackI gLFWErrorCallbackI;
/*  41 */     return (gLFWErrorCallbackI = (GLFWErrorCallbackI)Callback.get(paramLong) instanceof GLFWErrorCallback) ? (GLFWErrorCallback)gLFWErrorCallbackI : new Container(paramLong, gLFWErrorCallbackI);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWErrorCallback createSafe(long paramLong) {
/*  49 */     return (paramLong == 0L) ? null : create(paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWErrorCallback create(GLFWErrorCallbackI paramGLFWErrorCallbackI) {
/*  54 */     return (paramGLFWErrorCallbackI instanceof GLFWErrorCallback) ? (GLFWErrorCallback)paramGLFWErrorCallbackI : new Container(paramGLFWErrorCallbackI
/*     */         
/*  56 */         .address(), paramGLFWErrorCallbackI);
/*     */   }
/*     */   
/*     */   protected GLFWErrorCallback() {
/*  60 */     super(CIF);
/*     */   }
/*     */   
/*     */   GLFWErrorCallback(long paramLong) {
/*  64 */     super(paramLong);
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
/*     */   public static String getDescription(long paramLong) {
/*  77 */     return MemoryUtil.memUTF8(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWErrorCallback createPrint() {
/*  86 */     return createPrint(APIUtil.DEBUG_STREAM);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWErrorCallback createPrint(final PrintStream stream) {
/*  97 */     return new GLFWErrorCallback()
/*     */       {
/*     */         private Map<Integer, String> ERROR_CODES;
/*     */         
/*     */         public final void invoke(int param1Int, long param1Long) {
/* 102 */           String str = getDescription(param1Long);
/*     */           
/*     */           StringBuilder stringBuilder;
/* 105 */           (stringBuilder = new StringBuilder(512))
/* 106 */             .append("[LWJGL] ")
/* 107 */             .append(this.ERROR_CODES.get(Integer.valueOf(param1Int)))
/* 108 */             .append(" error\n\tDescription : ")
/*     */             
/* 110 */             .append(str)
/* 111 */             .append("\n\tStacktrace  :\n");
/*     */ 
/*     */           
/* 114 */           StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
/* 115 */           for (byte b = 4; b < arrayOfStackTraceElement.length; b++) {
/* 116 */             stringBuilder.append("\t\t");
/* 117 */             stringBuilder.append(arrayOfStackTraceElement[b]);
/* 118 */             stringBuilder.append("\n");
/*     */           } 
/*     */           
/* 121 */           stream.print(stringBuilder);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWErrorCallback createThrow() {
/* 132 */     return new GLFWErrorCallback()
/*     */       {
/*     */         public final void invoke(int param1Int, long param1Long) {
/* 135 */           throw new IllegalStateException(String.format("GLFW error [0x%X]: %s", new Object[] { Integer.valueOf(param1Int), getDescription(param1Long) }));
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public GLFWErrorCallback set() {
/* 142 */     GLFW.glfwSetErrorCallback(this);
/* 143 */     return this;
/*     */   }
/*     */   
/*     */   private static final class Container
/*     */     extends GLFWErrorCallback {
/*     */     private final GLFWErrorCallbackI delegate;
/*     */     
/*     */     Container(long param1Long, GLFWErrorCallbackI param1GLFWErrorCallbackI) {
/* 151 */       super(param1Long);
/* 152 */       this.delegate = param1GLFWErrorCallbackI;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void invoke(int param1Int, long param1Long) {
/* 157 */       this.delegate.invoke(param1Int, param1Long);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWErrorCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */