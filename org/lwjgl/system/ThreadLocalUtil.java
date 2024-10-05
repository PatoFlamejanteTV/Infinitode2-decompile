/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.jni.JNINativeInterface;
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
/*     */ public final class ThreadLocalUtil
/*     */ {
/*  91 */   private static final long JNI_NATIVE_INTERFACE = MemoryUtil.memGetAddress(getThreadJNIEnv());
/*     */ 
/*     */   
/*     */   private static final int JNI_NATIVE_INTERFACE_FUNCTION_COUNT;
/*     */ 
/*     */   
/*  97 */   private static final long FUNCTION_MISSING_ABORT = getFunctionMissingAbort();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 104 */   private static long FUNCTION_MISSING_ABORT_TABLE = 0L;
/*     */ 
/*     */   
/* 107 */   private static final int CAPABILITIES_OFFSET = 3 * Pointer.POINTER_SIZE;
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*     */     int i;
/* 113 */     switch (i = JNINativeInterface.GetVersion()) {
/*     */       case 65537:
/* 115 */         b = 12;
/*     */         break;
/*     */       default:
/* 118 */         b = 4;
/*     */         break;
/*     */     } 
/*     */     
/* 122 */     switch (i) {
/*     */       case 65537:
/* 124 */         i = 208;
/*     */         break;
/*     */       case 65538:
/* 127 */         i = 225;
/*     */         break;
/*     */       case 65540:
/* 130 */         i = 228;
/*     */         break;
/*     */       case 65542:
/*     */       case 65544:
/* 134 */         i = 229;
/*     */         break;
/*     */       case 589824:
/*     */       case 655360:
/* 138 */         i = 230;
/*     */         break;
/*     */       case 1245184:
/*     */       case 1310720:
/* 142 */         i = 231;
/*     */         break;
/*     */       case 1376256:
/* 145 */         i = 232;
/*     */         break;
/*     */       default:
/* 148 */         i = 232;
/* 149 */         APIUtil.DEBUG_STREAM
/* 150 */           .println("[LWJGL] [ThreadLocalUtil] Unsupported JNI version detected, this may result in a crash. Please inform LWJGL developers."); break;
/*     */     } 
/* 152 */     JNI_NATIVE_INTERFACE_FUNCTION_COUNT = b + ((Integer)Configuration.JNI_NATIVE_INTERFACE_FUNCTION_COUNT.get(Integer.valueOf(i))).intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*     */     byte b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long setupEnvData() {
/* 164 */     return nsetupEnvData(JNI_NATIVE_INTERFACE_FUNCTION_COUNT);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setCapabilities(long paramLong) {
/* 170 */     long l1, l2 = MemoryUtil.memGetAddress(l1 = getThreadJNIEnv());
/*     */     
/* 172 */     if (paramLong == 0L) {
/* 173 */       if (l2 != JNI_NATIVE_INTERFACE) {
/* 174 */         MemoryUtil.memPutAddress(l2 + CAPABILITIES_OFFSET, FUNCTION_MISSING_ABORT_TABLE); return;
/*     */       } 
/*     */     } else {
/* 177 */       if (l2 == JNI_NATIVE_INTERFACE) {
/* 178 */         setupEnvData();
/* 179 */         l2 = MemoryUtil.memGetAddress(l1);
/*     */       } 
/* 181 */       MemoryUtil.memPutAddress(l2 + CAPABILITIES_OFFSET, paramLong);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setFunctionMissingAddresses(int paramInt) {
/* 189 */     long l1 = MemoryUtil.memGetAddress(JNI_NATIVE_INTERFACE);
/*     */ 
/*     */ 
/*     */     
/* 193 */     long l2, l3 = MemoryUtil.memGetAddress(l2 = JNI_NATIVE_INTERFACE + CAPABILITIES_OFFSET);
/* 194 */     if (paramInt == 0) {
/* 195 */       if (l3 != l1) {
/* 196 */         FUNCTION_MISSING_ABORT_TABLE = 0L;
/* 197 */         MemoryUtil.getAllocator().free(l3);
/* 198 */         MemoryUtil.memPutAddress(l2, 0L); return;
/*     */       } 
/*     */     } else {
/* 201 */       if (l3 != l1) {
/* 202 */         throw new IllegalStateException("setFunctionMissingAddresses has been called already");
/*     */       }
/* 204 */       if (l3 != 0L) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 209 */       FUNCTION_MISSING_ABORT_TABLE = MemoryUtil.getAllocator().malloc(Integer.toUnsignedLong(paramInt) * Pointer.POINTER_SIZE);
/* 210 */       for (byte b = 0; b < paramInt; b++) {
/* 211 */         MemoryUtil.memPutAddress(FUNCTION_MISSING_ABORT_TABLE + Integer.toUnsignedLong(b) * Pointer.POINTER_SIZE, FUNCTION_MISSING_ABORT);
/*     */       }
/*     */       
/* 214 */       MemoryUtil.memPutAddress(l2, FUNCTION_MISSING_ABORT_TABLE);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static PointerBuffer setupAddressBuffer(PointerBuffer paramPointerBuffer) {
/* 219 */     for (int i = paramPointerBuffer.position(); i < paramPointerBuffer.limit(); i++) {
/* 220 */       if (paramPointerBuffer.get(i) == 0L) {
/* 221 */         paramPointerBuffer.put(i, FUNCTION_MISSING_ABORT);
/*     */       }
/*     */     } 
/* 224 */     return paramPointerBuffer;
/*     */   }
/*     */   
/*     */   public static boolean areCapabilitiesDifferent(PointerBuffer paramPointerBuffer1, PointerBuffer paramPointerBuffer2) {
/* 228 */     for (byte b = 0; b < paramPointerBuffer1.remaining(); b++) {
/* 229 */       if (paramPointerBuffer1.get(b) != paramPointerBuffer2.get(b) && paramPointerBuffer2.get(b) != 0L) {
/* 230 */         return true;
/*     */       }
/*     */     } 
/* 233 */     return false;
/*     */   }
/*     */   
/*     */   private static native long getThreadJNIEnv();
/*     */   
/*     */   private static native long getFunctionMissingAbort();
/*     */   
/*     */   private static native long nsetupEnvData(int paramInt);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\ThreadLocalUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */