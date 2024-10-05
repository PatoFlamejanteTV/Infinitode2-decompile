/*     */ package org.lwjgl.glfw;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Platform;
/*     */ import org.lwjgl.system.Pointer;
/*     */ import org.lwjgl.system.SharedLibrary;
/*     */ import org.lwjgl.vulkan.VK;
/*     */ import org.lwjgl.vulkan.VkAllocationCallbacks;
/*     */ import org.lwjgl.vulkan.VkInstance;
/*     */ import org.lwjgl.vulkan.VkPhysicalDevice;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GLFWVulkan
/*     */ {
/*     */   public static final class Functions
/*     */   {
/*  34 */     public static final long InitVulkanLoader = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwInitVulkanLoader");
/*  35 */     public static final long VulkanSupported = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwVulkanSupported");
/*  36 */     public static final long GetRequiredInstanceExtensions = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetRequiredInstanceExtensions");
/*  37 */     public static final long GetInstanceProcAddress = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetInstanceProcAddress");
/*  38 */     public static final long GetPhysicalDevicePresentationSupport = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetPhysicalDevicePresentationSupport");
/*  39 */     public static final long CreateWindowSurface = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwCreateWindowSurface");
/*     */   }
/*     */ 
/*     */   
/*     */   static {
/*  44 */     if (Platform.get() == Platform.MACOSX) {
/*  45 */       setPath(VK.getFunctionProvider());
/*     */     }
/*     */   }
/*     */   
/*     */   protected GLFWVulkan() {
/*  50 */     throw new UnsupportedOperationException();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glfwInitVulkanLoader(@NativeType("PFN_vkGetInstanceProcAddr") long paramLong) {
/*  81 */     long l = Functions.InitVulkanLoader;
/*  82 */     JNI.invokePV(paramLong, l);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean glfwVulkanSupported() {
/*     */     long l;
/* 105 */     return (JNI.invokeI(l = Functions.VulkanSupported) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglfwGetRequiredInstanceExtensions(long paramLong) {
/* 116 */     long l = Functions.GetRequiredInstanceExtensions;
/* 117 */     return JNI.invokePP(paramLong, l);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("char const **")
/*     */   public static PointerBuffer glfwGetRequiredInstanceExtensions() {
/*     */     MemoryStack memoryStack;
/* 147 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 148 */     null = memoryStack.callocInt(1);
/*     */     try {
/*     */       long l;
/* 151 */       return MemoryUtil.memPointerBufferSafe(l = nglfwGetRequiredInstanceExtensions(MemoryUtil.memAddress(null)), null.get(0));
/*     */     } finally {
/* 153 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglfwGetInstanceProcAddress(long paramLong1, long paramLong2) {
/* 161 */     long l = Functions.GetInstanceProcAddress;
/* 162 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLFWvkproc")
/*     */   public static long glfwGetInstanceProcAddress(VkInstance paramVkInstance, @NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 196 */     if (Checks.CHECKS) {
/* 197 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/* 199 */     return nglfwGetInstanceProcAddress(MemoryUtil.memAddressSafe((Pointer)paramVkInstance), MemoryUtil.memAddress(paramByteBuffer));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLFWvkproc")
/*     */   public static long glfwGetInstanceProcAddress(VkInstance paramVkInstance, @NativeType("char const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 233 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 235 */       memoryStack.nASCII(paramCharSequence, true);
/* 236 */       long l = memoryStack.getPointerAddress();
/* 237 */       return nglfwGetInstanceProcAddress(MemoryUtil.memAddressSafe((Pointer)paramVkInstance), l);
/*     */     } finally {
/* 239 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean glfwGetPhysicalDevicePresentationSupport(VkInstance paramVkInstance, VkPhysicalDevice paramVkPhysicalDevice, @NativeType("uint32_t") int paramInt) {
/* 269 */     long l = Functions.GetPhysicalDevicePresentationSupport;
/* 270 */     return (JNI.invokePPI(paramVkInstance.address(), paramVkPhysicalDevice.address(), paramInt, l) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglfwCreateWindowSurface(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/* 277 */     long l = Functions.CreateWindowSurface;
/* 278 */     if (Checks.CHECKS) {
/* 279 */       Checks.check(paramLong2);
/*     */     }
/* 281 */     return JNI.invokePPPPI(paramLong1, paramLong2, paramLong3, paramLong4, l);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("VkResult")
/*     */   public static int glfwCreateWindowSurface(VkInstance paramVkInstance, @NativeType("GLFWwindow *") long paramLong, @NativeType("VkAllocationCallbacks const *") VkAllocationCallbacks paramVkAllocationCallbacks, @NativeType("VkSurfaceKHR *") LongBuffer paramLongBuffer) {
/* 329 */     if (Checks.CHECKS) {
/* 330 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 332 */     return nglfwCreateWindowSurface(paramVkInstance.address(), paramLong, MemoryUtil.memAddressSafe((Pointer)paramVkAllocationCallbacks), MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("VkResult")
/*     */   public static int glfwCreateWindowSurface(VkInstance paramVkInstance, @NativeType("GLFWwindow *") long paramLong, @NativeType("VkAllocationCallbacks const *") VkAllocationCallbacks paramVkAllocationCallbacks, @NativeType("VkSurfaceKHR *") long[] paramArrayOflong) {
/* 338 */     long l = Functions.CreateWindowSurface;
/* 339 */     if (Checks.CHECKS) {
/* 340 */       Checks.check(paramLong);
/* 341 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 343 */     return JNI.invokePPPPI(paramVkInstance.address(), paramLong, MemoryUtil.memAddressSafe((Pointer)paramVkAllocationCallbacks), paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setPath(FunctionProvider paramFunctionProvider) {
/* 354 */     if (!(paramFunctionProvider instanceof SharedLibrary)) {
/* 355 */       APIUtil.apiLog("GLFW Vulkan path override not set: function provider is not a shared library.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     String str;
/* 360 */     if ((str = ((SharedLibrary)paramFunctionProvider).getPath()) == null) {
/* 361 */       APIUtil.apiLog("GLFW Vulkan path override not set: Could not resolve the shared library path.");
/*     */       
/*     */       return;
/*     */     } 
/* 365 */     setPath(str);
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
/*     */   
/*     */   public static void setPath(String paramString) {
/*     */     long l1;
/* 380 */     if ((l1 = GLFW.getLibrary().getFunctionAddress("_glfw_vulkan_library")) == 0L) {
/* 381 */       APIUtil.apiLog("GLFW Vulkan path override not set: Could not resolve override symbol.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     long l2;
/* 386 */     if ((l2 = MemoryUtil.memGetAddress(l1)) != 0L) {
/* 387 */       MemoryUtil.nmemFree(l2);
/*     */     }
/* 389 */     MemoryUtil.memPutAddress(l1, (paramString == null) ? 0L : MemoryUtil.memAddress(MemoryUtil.memUTF8(paramString)));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWVulkan.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */