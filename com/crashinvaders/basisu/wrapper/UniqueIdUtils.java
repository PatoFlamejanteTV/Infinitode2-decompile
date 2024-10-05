/*    */ package com.crashinvaders.basisu.wrapper;
/*    */ 
/*    */ public class UniqueIdUtils {
/*    */   static <T extends UniqueIdValue> T findOrThrow(T[] paramArrayOfT, int paramInt) {
/*  5 */     for (byte b = 0; b < paramArrayOfT.length; b++) {
/*  6 */       if (paramArrayOfT[b].getId() == paramInt) {
/*  7 */         return paramArrayOfT[b];
/*    */       }
/*    */     } 
/* 10 */     throw new IllegalArgumentException("Cannot find an enum value with ID: " + paramInt);
/*    */   }
/*    */   
/*    */   public static interface UniqueIdValue {
/*    */     int getId();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\wrapper\UniqueIdUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */