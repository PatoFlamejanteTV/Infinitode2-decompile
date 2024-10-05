/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.util.Set;
/*     */ import java.util.function.IntFunction;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.FunctionProviderLocal;
/*     */ import org.lwjgl.system.ThreadLocalUtil;
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
/*     */ public final class ALCCapabilities
/*     */ {
/*     */   public final long alcOpenDevice;
/*     */   public final long alcCloseDevice;
/*     */   public final long alcCreateContext;
/*     */   public final long alcMakeContextCurrent;
/*     */   public final long alcProcessContext;
/*     */   public final long alcSuspendContext;
/*     */   public final long alcDestroyContext;
/*     */   public final long alcGetCurrentContext;
/*     */   public final long alcGetContextsDevice;
/*     */   public final long alcIsExtensionPresent;
/*     */   public final long alcGetProcAddress;
/*     */   public final long alcGetEnumValue;
/*     */   public final long alcGetError;
/*     */   public final long alcGetString;
/*     */   public final long alcGetIntegerv;
/*     */   public final long alcCaptureOpenDevice;
/*     */   public final long alcCaptureCloseDevice;
/*     */   public final long alcCaptureStart;
/*     */   public final long alcCaptureStop;
/*     */   public final long alcCaptureSamples;
/*     */   public final long alcSetThreadContext;
/*     */   public final long alcGetThreadContext;
/*     */   public final long alcGetInteger64vSOFT;
/*     */   public final long alcGetStringiSOFT;
/*     */   public final long alcResetDeviceSOFT;
/*     */   public final long alcLoopbackOpenDeviceSOFT;
/*     */   public final long alcIsRenderFormatSupportedSOFT;
/*     */   public final long alcRenderSamplesSOFT;
/*     */   public final long alcDevicePauseSOFT;
/*     */   public final long alcDeviceResumeSOFT;
/*     */   public final long alcReopenDeviceSOFT;
/*     */   public final boolean OpenALC10;
/*     */   public final boolean OpenALC11;
/*     */   public final boolean OpenALC_SOFT_loopback_bformat;
/*     */   public final boolean ALC_ENUMERATE_ALL_EXT;
/*     */   public final boolean ALC_ENUMERATION_EXT;
/*     */   public final boolean ALC_EXT_CAPTURE;
/*     */   public final boolean ALC_EXT_DEDICATED;
/*     */   public final boolean ALC_EXT_DEFAULT_FILTER_ORDER;
/*     */   public final boolean ALC_EXT_disconnect;
/*     */   public final boolean ALC_EXT_EFX;
/*     */   public final boolean ALC_EXT_thread_local_context;
/*     */   public final boolean ALC_LOKI_audio_channel;
/*     */   public final boolean ALC_SOFT_device_clock;
/*     */   public final boolean ALC_SOFT_HRTF;
/*     */   public final boolean ALC_SOFT_loopback;
/*     */   public final boolean ALC_SOFT_output_limiter;
/*     */   public final boolean ALC_SOFT_output_mode;
/*     */   public final boolean ALC_SOFT_pause_device;
/*     */   public final boolean ALC_SOFT_reopen_device;
/*     */   final long device;
/*     */   final PointerBuffer addresses;
/*     */   
/*     */   ALCCapabilities(FunctionProviderLocal paramFunctionProviderLocal, long paramLong, Set<String> paramSet, IntFunction<PointerBuffer> paramIntFunction) {
/* 123 */     this.device = paramLong;
/*     */     
/* 125 */     PointerBuffer pointerBuffer = paramIntFunction.apply(31);
/*     */     
/* 127 */     this.OpenALC10 = check_ALC10(paramFunctionProviderLocal, paramLong, pointerBuffer, paramSet);
/* 128 */     this.OpenALC11 = check_ALC11(paramFunctionProviderLocal, paramLong, pointerBuffer, paramSet);
/* 129 */     this.OpenALC_SOFT_loopback_bformat = paramSet.contains("OpenALC_SOFT_loopback_bformat");
/* 130 */     this.ALC_ENUMERATE_ALL_EXT = paramSet.contains("ALC_ENUMERATE_ALL_EXT");
/* 131 */     this.ALC_ENUMERATION_EXT = paramSet.contains("ALC_ENUMERATION_EXT");
/* 132 */     this.ALC_EXT_CAPTURE = check_EXT_CAPTURE(paramFunctionProviderLocal, paramLong, pointerBuffer, paramSet);
/* 133 */     this.ALC_EXT_DEDICATED = paramSet.contains("ALC_EXT_DEDICATED");
/* 134 */     this.ALC_EXT_DEFAULT_FILTER_ORDER = paramSet.contains("ALC_EXT_DEFAULT_FILTER_ORDER");
/* 135 */     this.ALC_EXT_disconnect = paramSet.contains("ALC_EXT_disconnect");
/* 136 */     this.ALC_EXT_EFX = paramSet.contains("ALC_EXT_EFX");
/* 137 */     this.ALC_EXT_thread_local_context = check_EXT_thread_local_context(paramFunctionProviderLocal, paramLong, pointerBuffer, paramSet);
/* 138 */     this.ALC_LOKI_audio_channel = paramSet.contains("ALC_LOKI_audio_channel");
/* 139 */     this.ALC_SOFT_device_clock = check_SOFT_device_clock(paramFunctionProviderLocal, paramLong, pointerBuffer, paramSet);
/* 140 */     this.ALC_SOFT_HRTF = check_SOFT_HRTF(paramFunctionProviderLocal, paramLong, pointerBuffer, paramSet);
/* 141 */     this.ALC_SOFT_loopback = check_SOFT_loopback(paramFunctionProviderLocal, paramLong, pointerBuffer, paramSet);
/* 142 */     this.ALC_SOFT_output_limiter = paramSet.contains("ALC_SOFT_output_limiter");
/* 143 */     this.ALC_SOFT_output_mode = paramSet.contains("ALC_SOFT_output_mode");
/* 144 */     this.ALC_SOFT_pause_device = check_SOFT_pause_device(paramFunctionProviderLocal, paramLong, pointerBuffer, paramSet);
/* 145 */     this.ALC_SOFT_reopen_device = check_SOFT_reopen_device(paramFunctionProviderLocal, paramLong, pointerBuffer, paramSet);
/*     */     
/* 147 */     this.alcOpenDevice = pointerBuffer.get(0);
/* 148 */     this.alcCloseDevice = pointerBuffer.get(1);
/* 149 */     this.alcCreateContext = pointerBuffer.get(2);
/* 150 */     this.alcMakeContextCurrent = pointerBuffer.get(3);
/* 151 */     this.alcProcessContext = pointerBuffer.get(4);
/* 152 */     this.alcSuspendContext = pointerBuffer.get(5);
/* 153 */     this.alcDestroyContext = pointerBuffer.get(6);
/* 154 */     this.alcGetCurrentContext = pointerBuffer.get(7);
/* 155 */     this.alcGetContextsDevice = pointerBuffer.get(8);
/* 156 */     this.alcIsExtensionPresent = pointerBuffer.get(9);
/* 157 */     this.alcGetProcAddress = pointerBuffer.get(10);
/* 158 */     this.alcGetEnumValue = pointerBuffer.get(11);
/* 159 */     this.alcGetError = pointerBuffer.get(12);
/* 160 */     this.alcGetString = pointerBuffer.get(13);
/* 161 */     this.alcGetIntegerv = pointerBuffer.get(14);
/* 162 */     this.alcCaptureOpenDevice = pointerBuffer.get(15);
/* 163 */     this.alcCaptureCloseDevice = pointerBuffer.get(16);
/* 164 */     this.alcCaptureStart = pointerBuffer.get(17);
/* 165 */     this.alcCaptureStop = pointerBuffer.get(18);
/* 166 */     this.alcCaptureSamples = pointerBuffer.get(19);
/* 167 */     this.alcSetThreadContext = pointerBuffer.get(20);
/* 168 */     this.alcGetThreadContext = pointerBuffer.get(21);
/* 169 */     this.alcGetInteger64vSOFT = pointerBuffer.get(22);
/* 170 */     this.alcGetStringiSOFT = pointerBuffer.get(23);
/* 171 */     this.alcResetDeviceSOFT = pointerBuffer.get(24);
/* 172 */     this.alcLoopbackOpenDeviceSOFT = pointerBuffer.get(25);
/* 173 */     this.alcIsRenderFormatSupportedSOFT = pointerBuffer.get(26);
/* 174 */     this.alcRenderSamplesSOFT = pointerBuffer.get(27);
/* 175 */     this.alcDevicePauseSOFT = pointerBuffer.get(28);
/* 176 */     this.alcDeviceResumeSOFT = pointerBuffer.get(29);
/* 177 */     this.alcReopenDeviceSOFT = pointerBuffer.get(30);
/*     */     
/* 179 */     this.addresses = ThreadLocalUtil.setupAddressBuffer(pointerBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public final PointerBuffer getAddressBuffer() {
/* 184 */     return this.addresses;
/*     */   }
/*     */   
/*     */   private static boolean check_ALC10(FunctionProviderLocal paramFunctionProviderLocal, long paramLong, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 188 */     if (!paramSet.contains("OpenALC10")) {
/* 189 */       return false;
/*     */     }
/*     */     
/* 192 */     if (Checks.checkFunctions(paramFunctionProviderLocal, paramLong, paramPointerBuffer, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 }, new String[] { "alcOpenDevice", "alcCloseDevice", "alcCreateContext", "alcMakeContextCurrent", "alcProcessContext", "alcSuspendContext", "alcDestroyContext", "alcGetCurrentContext", "alcGetContextsDevice", "alcIsExtensionPresent", "alcGetProcAddress", "alcGetEnumValue", "alcGetError", "alcGetString", "alcGetIntegerv"
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 198 */         }) || Checks.reportMissing("ALC", "OpenALC10")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_ALC11(FunctionProviderLocal paramFunctionProviderLocal, long paramLong, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 202 */     if (!paramSet.contains("OpenALC11")) {
/* 203 */       return false;
/*     */     }
/*     */     
/* 206 */     if (Checks.checkFunctions(paramFunctionProviderLocal, paramLong, paramPointerBuffer, new int[] { 15, 16, 17, 18, 19 }, new String[] { "alcCaptureOpenDevice", "alcCaptureCloseDevice", "alcCaptureStart", "alcCaptureStop", "alcCaptureSamples"
/*     */ 
/*     */ 
/*     */         
/* 210 */         }) || Checks.reportMissing("ALC", "OpenALC11")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_EXT_CAPTURE(FunctionProviderLocal paramFunctionProviderLocal, long paramLong, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 214 */     if (!paramSet.contains("ALC_EXT_CAPTURE")) {
/* 215 */       return false;
/*     */     }
/*     */     
/* 218 */     if (Checks.checkFunctions(paramFunctionProviderLocal, paramLong, paramPointerBuffer, new int[] { 15, 16, 17, 18, 19 }, new String[] { "alcCaptureOpenDevice", "alcCaptureCloseDevice", "alcCaptureStart", "alcCaptureStop", "alcCaptureSamples"
/*     */ 
/*     */ 
/*     */         
/* 222 */         }) || Checks.reportMissing("ALC", "ALC_EXT_CAPTURE")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_EXT_thread_local_context(FunctionProviderLocal paramFunctionProviderLocal, long paramLong, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 226 */     if (!paramSet.contains("ALC_EXT_thread_local_context")) {
/* 227 */       return false;
/*     */     }
/*     */     
/* 230 */     if (Checks.checkFunctions(paramFunctionProviderLocal, paramLong, paramPointerBuffer, new int[] { 20, 21 }, new String[] { "alcSetThreadContext", "alcGetThreadContext"
/*     */ 
/*     */ 
/*     */         
/* 234 */         }) || Checks.reportMissing("ALC", "ALC_EXT_thread_local_context")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_SOFT_device_clock(FunctionProviderLocal paramFunctionProviderLocal, long paramLong, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 238 */     if (!paramSet.contains("ALC_SOFT_device_clock")) {
/* 239 */       return false;
/*     */     }
/*     */     
/* 242 */     if (Checks.checkFunctions(paramFunctionProviderLocal, paramLong, paramPointerBuffer, new int[] { 22 }, new String[] { "alcGetInteger64vSOFT"
/*     */ 
/*     */ 
/*     */         
/* 246 */         }) || Checks.reportMissing("ALC", "ALC_SOFT_device_clock")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_SOFT_HRTF(FunctionProviderLocal paramFunctionProviderLocal, long paramLong, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 250 */     if (!paramSet.contains("ALC_SOFT_HRTF")) {
/* 251 */       return false;
/*     */     }
/*     */     
/* 254 */     if (Checks.checkFunctions(paramFunctionProviderLocal, paramLong, paramPointerBuffer, new int[] { 23, 24 }, new String[] { "alcGetStringiSOFT", "alcResetDeviceSOFT"
/*     */ 
/*     */ 
/*     */         
/* 258 */         }) || Checks.reportMissing("ALC", "ALC_SOFT_HRTF")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_SOFT_loopback(FunctionProviderLocal paramFunctionProviderLocal, long paramLong, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 262 */     if (!paramSet.contains("ALC_SOFT_loopback")) {
/* 263 */       return false;
/*     */     }
/*     */     
/* 266 */     if (Checks.checkFunctions(paramFunctionProviderLocal, paramLong, paramPointerBuffer, new int[] { 25, 26, 27 }, new String[] { "alcLoopbackOpenDeviceSOFT", "alcIsRenderFormatSupportedSOFT", "alcRenderSamplesSOFT"
/*     */ 
/*     */ 
/*     */         
/* 270 */         }) || Checks.reportMissing("ALC", "ALC_SOFT_loopback")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_SOFT_pause_device(FunctionProviderLocal paramFunctionProviderLocal, long paramLong, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 274 */     if (!paramSet.contains("ALC_SOFT_pause_device")) {
/* 275 */       return false;
/*     */     }
/*     */     
/* 278 */     if (Checks.checkFunctions(paramFunctionProviderLocal, paramLong, paramPointerBuffer, new int[] { 28, 29 }, new String[] { "alcDevicePauseSOFT", "alcDeviceResumeSOFT"
/*     */ 
/*     */ 
/*     */         
/* 282 */         }) || Checks.reportMissing("ALC", "ALC_SOFT_pause_device")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_SOFT_reopen_device(FunctionProviderLocal paramFunctionProviderLocal, long paramLong, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 286 */     if (!paramSet.contains("ALC_SOFT_reopen_device")) {
/* 287 */       return false;
/*     */     }
/*     */     
/* 290 */     if (Checks.checkFunctions(paramFunctionProviderLocal, paramLong, paramPointerBuffer, new int[] { 30 }, new String[] { "alcReopenDeviceSOFT"
/*     */ 
/*     */ 
/*     */         
/* 294 */         }) || Checks.reportMissing("ALC", "ALC_SOFT_reopen_device")) return true; 
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\ALCCapabilities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */