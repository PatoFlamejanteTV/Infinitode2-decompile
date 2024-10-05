/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ public abstract class SteamNativeIntHandle
/*    */ {
/*    */   int handle;
/*    */   
/*    */   SteamNativeIntHandle(int paramInt) {
/*  8 */     this.handle = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T extends SteamNativeIntHandle> int getNativeHandle(T paramT) {
/* 15 */     return ((SteamNativeIntHandle)paramT).handle;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 20 */     return Integer.valueOf(this.handle).hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 25 */     if (paramObject instanceof SteamNativeIntHandle) {
/* 26 */       return (this.handle == ((SteamNativeIntHandle)paramObject).handle);
/*    */     }
/* 28 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 33 */     return Integer.toHexString(this.handle);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamNativeIntHandle.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */