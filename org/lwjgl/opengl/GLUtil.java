/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Callback;
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
/*     */ public final class GLUtil
/*     */ {
/*     */   public static Callback setupDebugMessageCallback() {
/*  30 */     return setupDebugMessageCallback(APIUtil.DEBUG_STREAM);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Callback setupDebugMessageCallback(PrintStream paramPrintStream) {
/*     */     GLDebugMessageCallback gLDebugMessageCallback;
/*     */     GLDebugMessageARBCallback gLDebugMessageARBCallback;
/*     */     GLCapabilities gLCapabilities;
/*  43 */     if ((gLCapabilities = GL.getCapabilities()).OpenGL43) {
/*  44 */       APIUtil.apiLog("[GL] Using OpenGL 4.3 for error logging.");
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
/*  57 */       GL43C.glDebugMessageCallback(gLDebugMessageCallback = GLDebugMessageCallback.create((paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong1, paramLong2) -> { StringBuilder stringBuilder; (stringBuilder = new StringBuilder(300)).append("[LWJGL] OpenGL debug message\n"); printDetail(stringBuilder, "ID", "0x" + Integer.toHexString(paramInt3).toUpperCase()); printDetail(stringBuilder, "Source", getDebugSource(paramInt1)); printDetail(stringBuilder, "Type", getDebugType(paramInt2)); printDetail(stringBuilder, "Severity", getDebugSeverity(paramInt4)); printDetail(stringBuilder, "Message", GLDebugMessageCallback.getMessage(paramInt5, paramLong1)); paramPrintStream.print(stringBuilder); }), 0L);
/*  58 */       if ((GL43C.glGetInteger(33310) & 0x2) == 0) {
/*  59 */         APIUtil.apiLog("[GL] Warning: A non-debug context may not produce any debug output.");
/*  60 */         GL43C.glEnable(37600);
/*     */       } 
/*  62 */       return gLDebugMessageCallback;
/*     */     } 
/*     */     
/*  65 */     if (gLCapabilities.GL_KHR_debug) {
/*  66 */       APIUtil.apiLog("[GL] Using KHR_debug for error logging.");
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
/*  79 */       KHRDebug.glDebugMessageCallback(gLDebugMessageCallback = GLDebugMessageCallback.create((paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong1, paramLong2) -> { StringBuilder stringBuilder; (stringBuilder = new StringBuilder(300)).append("[LWJGL] OpenGL debug message\n"); printDetail(stringBuilder, "ID", "0x" + Integer.toHexString(paramInt3).toUpperCase()); printDetail(stringBuilder, "Source", getDebugSource(paramInt1)); printDetail(stringBuilder, "Type", getDebugType(paramInt2)); printDetail(stringBuilder, "Severity", getDebugSeverity(paramInt4)); printDetail(stringBuilder, "Message", GLDebugMessageCallback.getMessage(paramInt5, paramLong1)); paramPrintStream.print(stringBuilder); }), 0L);
/*  80 */       if (gLCapabilities.OpenGL30 && (GL43C.glGetInteger(33310) & 0x2) == 0) {
/*  81 */         APIUtil.apiLog("[GL] Warning: A non-debug context may not produce any debug output.");
/*  82 */         GL43C.glEnable(37600);
/*     */       } 
/*  84 */       return gLDebugMessageCallback;
/*     */     } 
/*     */     
/*  87 */     if (gLCapabilities.GL_ARB_debug_output) {
/*  88 */       APIUtil.apiLog("[GL] Using ARB_debug_output for error logging.");
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
/* 101 */       ARBDebugOutput.glDebugMessageCallbackARB(gLDebugMessageARBCallback = GLDebugMessageARBCallback.create((paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong1, paramLong2) -> { StringBuilder stringBuilder; (stringBuilder = new StringBuilder(300)).append("[LWJGL] ARB_debug_output message\n"); printDetail(stringBuilder, "ID", "0x" + Integer.toHexString(paramInt3).toUpperCase()); printDetail(stringBuilder, "Source", getSourceARB(paramInt1)); printDetail(stringBuilder, "Type", getTypeARB(paramInt2)); printDetail(stringBuilder, "Severity", getSeverityARB(paramInt4)); printDetail(stringBuilder, "Message", GLDebugMessageARBCallback.getMessage(paramInt5, paramLong1)); paramPrintStream.print(stringBuilder); }), 0L);
/* 102 */       return gLDebugMessageARBCallback;
/*     */     } 
/*     */     
/* 105 */     if (gLCapabilities.GL_AMD_debug_output) {
/* 106 */       APIUtil.apiLog("[GL] Using AMD_debug_output for error logging.");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       GLDebugMessageAMDCallback gLDebugMessageAMDCallback;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 118 */       AMDDebugOutput.glDebugMessageCallbackAMD(gLDebugMessageAMDCallback = GLDebugMessageAMDCallback.create((paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2) -> { StringBuilder stringBuilder; (stringBuilder = new StringBuilder(300)).append("[LWJGL] AMD_debug_output message\n"); printDetail(stringBuilder, "ID", "0x" + Integer.toHexString(paramInt1).toUpperCase()); printDetail(stringBuilder, "Category", getCategoryAMD(paramInt2)); printDetail(stringBuilder, "Severity", getSeverityAMD(paramInt3)); printDetail(stringBuilder, "Message", GLDebugMessageAMDCallback.getMessage(paramInt4, paramLong1)); paramPrintStream.print(stringBuilder); }), 0L);
/* 119 */       return gLDebugMessageAMDCallback;
/*     */     } 
/*     */     
/* 122 */     APIUtil.apiLog("[GL] No debug output implementation is available.");
/* 123 */     return null;
/*     */   }
/*     */   
/*     */   private static void printDetail(StringBuilder paramStringBuilder, String paramString1, String paramString2) {
/* 127 */     paramStringBuilder
/* 128 */       .append("\t")
/* 129 */       .append(paramString1)
/* 130 */       .append(": ")
/* 131 */       .append(paramString2)
/* 132 */       .append("\n");
/*     */   }
/*     */   
/*     */   private static String getDebugSource(int paramInt) {
/* 136 */     switch (paramInt) {
/*     */       case 33350:
/* 138 */         return "API";
/*     */       case 33351:
/* 140 */         return "WINDOW SYSTEM";
/*     */       case 33352:
/* 142 */         return "SHADER COMPILER";
/*     */       case 33353:
/* 144 */         return "THIRD PARTY";
/*     */       case 33354:
/* 146 */         return "APPLICATION";
/*     */       case 33355:
/* 148 */         return "OTHER";
/*     */     } 
/* 150 */     return APIUtil.apiUnknownToken(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getDebugType(int paramInt) {
/* 155 */     switch (paramInt) {
/*     */       case 33356:
/* 157 */         return "ERROR";
/*     */       case 33357:
/* 159 */         return "DEPRECATED BEHAVIOR";
/*     */       case 33358:
/* 161 */         return "UNDEFINED BEHAVIOR";
/*     */       case 33359:
/* 163 */         return "PORTABILITY";
/*     */       case 33360:
/* 165 */         return "PERFORMANCE";
/*     */       case 33361:
/* 167 */         return "OTHER";
/*     */       case 33384:
/* 169 */         return "MARKER";
/*     */     } 
/* 171 */     return APIUtil.apiUnknownToken(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getDebugSeverity(int paramInt) {
/* 176 */     switch (paramInt) {
/*     */       case 37190:
/* 178 */         return "HIGH";
/*     */       case 37191:
/* 180 */         return "MEDIUM";
/*     */       case 37192:
/* 182 */         return "LOW";
/*     */       case 33387:
/* 184 */         return "NOTIFICATION";
/*     */     } 
/* 186 */     return APIUtil.apiUnknownToken(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getSourceARB(int paramInt) {
/* 191 */     switch (paramInt) {
/*     */       case 33350:
/* 193 */         return "API";
/*     */       case 33351:
/* 195 */         return "WINDOW SYSTEM";
/*     */       case 33352:
/* 197 */         return "SHADER COMPILER";
/*     */       case 33353:
/* 199 */         return "THIRD PARTY";
/*     */       case 33354:
/* 201 */         return "APPLICATION";
/*     */       case 33355:
/* 203 */         return "OTHER";
/*     */     } 
/* 205 */     return APIUtil.apiUnknownToken(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getTypeARB(int paramInt) {
/* 210 */     switch (paramInt) {
/*     */       case 33356:
/* 212 */         return "ERROR";
/*     */       case 33357:
/* 214 */         return "DEPRECATED BEHAVIOR";
/*     */       case 33358:
/* 216 */         return "UNDEFINED BEHAVIOR";
/*     */       case 33359:
/* 218 */         return "PORTABILITY";
/*     */       case 33360:
/* 220 */         return "PERFORMANCE";
/*     */       case 33361:
/* 222 */         return "OTHER";
/*     */     } 
/* 224 */     return APIUtil.apiUnknownToken(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getSeverityARB(int paramInt) {
/* 229 */     switch (paramInt) {
/*     */       case 37190:
/* 231 */         return "HIGH";
/*     */       case 37191:
/* 233 */         return "MEDIUM";
/*     */       case 37192:
/* 235 */         return "LOW";
/*     */     } 
/* 237 */     return APIUtil.apiUnknownToken(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getCategoryAMD(int paramInt) {
/* 242 */     switch (paramInt) {
/*     */       case 37193:
/* 244 */         return "API ERROR";
/*     */       case 37194:
/* 246 */         return "WINDOW SYSTEM";
/*     */       case 37195:
/* 248 */         return "DEPRECATION";
/*     */       case 37196:
/* 250 */         return "UNDEFINED BEHAVIOR";
/*     */       case 37197:
/* 252 */         return "PERFORMANCE";
/*     */       case 37198:
/* 254 */         return "SHADER COMPILER";
/*     */       case 37199:
/* 256 */         return "APPLICATION";
/*     */       case 37200:
/* 258 */         return "OTHER";
/*     */     } 
/* 260 */     return APIUtil.apiUnknownToken(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getSeverityAMD(int paramInt) {
/* 265 */     switch (paramInt) {
/*     */       case 37190:
/* 267 */         return "HIGH";
/*     */       case 37191:
/* 269 */         return "MEDIUM";
/*     */       case 37192:
/* 271 */         return "LOW";
/*     */     } 
/* 273 */     return APIUtil.apiUnknownToken(paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */