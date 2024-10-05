/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class SteamAPI
/*    */ {
/*    */   private static boolean isRunning = false;
/*    */   private static boolean isNativeAPILoaded = false;
/*    */   
/*    */   public static void loadLibraries() {
/* 11 */     loadLibraries(null);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void loadLibraries(String paramString) {
/* 16 */     if (isNativeAPILoaded) {
/*    */       return;
/*    */     }
/*    */     
/* 20 */     if (paramString == null && SteamSharedLibraryLoader.DEBUG) {
/* 21 */       String str = SteamSharedLibraryLoader.getSdkRedistributableBinPath();
/* 22 */       SteamSharedLibraryLoader.loadLibrary("steam_api", str);
/*    */     } else {
/* 24 */       SteamSharedLibraryLoader.loadLibrary("steam_api", paramString);
/*    */     } 
/*    */     
/* 27 */     SteamSharedLibraryLoader.loadLibrary("steamworks4j", paramString);
/*    */     
/* 29 */     isNativeAPILoaded = true;
/*    */   }
/*    */   
/*    */   public static void skipLoadLibraries() {
/* 33 */     isNativeAPILoaded = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean restartAppIfNecessary(int paramInt) {
/* 38 */     if (!isNativeAPILoaded) {
/* 39 */       throw new SteamException("Native libraries not loaded.\nEnsure to call SteamAPI.loadLibraries() first!");
/*    */     }
/*    */     
/* 42 */     return nativeRestartAppIfNecessary(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean init() {
/* 47 */     if (!isNativeAPILoaded) {
/* 48 */       throw new SteamException("Native libraries not loaded.\nEnsure to call SteamAPI.loadLibraries() first!");
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 53 */     return isRunning = nativeInit();
/*    */   }
/*    */   
/*    */   public static void shutdown() {
/* 57 */     isRunning = false;
/* 58 */     nativeShutdown();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isSteamRunning() {
/* 70 */     return isSteamRunning(false);
/*    */   }
/*    */   
/*    */   public static boolean isSteamRunning(boolean paramBoolean) {
/* 74 */     return (isRunning && (!paramBoolean || isSteamRunningNative()));
/*    */   }
/*    */   
/*    */   public static void printDebugInfo(PrintStream paramPrintStream) {
/* 78 */     paramPrintStream.println("  Steam API initialized: " + isRunning);
/* 79 */     paramPrintStream.println("  Steam client active: " + isSteamRunning());
/*    */   }
/*    */   
/*    */   static boolean isIsNativeAPILoaded() {
/* 83 */     return isNativeAPILoaded;
/*    */   }
/*    */   
/*    */   private static native boolean nativeRestartAppIfNecessary(int paramInt);
/*    */   
/*    */   public static native void releaseCurrentThreadMemory();
/*    */   
/*    */   private static native boolean nativeInit();
/*    */   
/*    */   private static native void nativeShutdown();
/*    */   
/*    */   public static native void runCallbacks();
/*    */   
/*    */   private static native boolean isSteamRunningNative();
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamAPI.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */