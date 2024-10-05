/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ 
/*    */ public class SteamScreenshots
/*    */   extends SteamInterface
/*    */ {
/*    */   public SteamScreenshots(SteamScreenshotsCallback paramSteamScreenshotsCallback) {
/*  9 */     super(SteamScreenshotsNative.createCallback(new SteamScreenshotsCallbackAdapter(paramSteamScreenshotsCallback)));
/*    */   }
/*    */   
/*    */   public SteamScreenshotHandle writeScreenshot(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
/* 13 */     return new SteamScreenshotHandle(SteamScreenshotsNative.writeScreenshot(paramByteBuffer, paramByteBuffer.remaining(), paramInt1, paramInt2));
/*    */   }
/*    */   
/*    */   public SteamScreenshotHandle addScreenshotToLibrary(String paramString1, String paramString2, int paramInt1, int paramInt2) {
/* 17 */     return new SteamScreenshotHandle(SteamScreenshotsNative.addScreenshotToLibrary(paramString1, paramString2, paramInt1, paramInt2));
/*    */   }
/*    */   
/*    */   public void triggerScreenshot() {
/* 21 */     SteamScreenshotsNative.triggerScreenshot();
/*    */   }
/*    */   
/*    */   public void hookScreenshots(boolean paramBoolean) {
/* 25 */     SteamScreenshotsNative.hookScreenshots(paramBoolean);
/*    */   }
/*    */   
/*    */   public boolean setLocation(SteamScreenshotHandle paramSteamScreenshotHandle, String paramString) {
/* 29 */     return SteamScreenshotsNative.setLocation(paramSteamScreenshotHandle.handle, paramString);
/*    */   }
/*    */   
/*    */   public boolean tagUser(SteamScreenshotHandle paramSteamScreenshotHandle, SteamID paramSteamID) {
/* 33 */     return SteamScreenshotsNative.tagUser(paramSteamScreenshotHandle.handle, paramSteamID.handle);
/*    */   }
/*    */   
/*    */   public boolean tagPublishedFile(SteamScreenshotHandle paramSteamScreenshotHandle, SteamPublishedFileID paramSteamPublishedFileID) {
/* 37 */     return SteamScreenshotsNative.tagPublishedFile(paramSteamScreenshotHandle.handle, paramSteamPublishedFileID.handle);
/*    */   }
/*    */   
/*    */   public boolean isScreenshotsHooked() {
/* 41 */     return SteamScreenshotsNative.isScreenshotsHooked();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamScreenshots.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */