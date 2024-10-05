/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ public enum SteamUniverse {
/*  4 */   Invalid(0),
/*  5 */   Public(1),
/*  6 */   Beta(2),
/*  7 */   Internal(3),
/*  8 */   Dev(4); private final int value; private static final SteamUniverse[] values;
/*    */   
/*    */   static {
/* 11 */     values = values();
/*    */   }
/*    */   
/* 14 */   SteamUniverse(int paramInt1) { this.value = paramInt1; } static SteamUniverse byValue(int paramInt) {
/*    */     SteamUniverse[] arrayOfSteamUniverse;
/*    */     int i;
/*    */     byte b;
/* 18 */     for (i = (arrayOfSteamUniverse = values).length, b = 0; b < i; b++) {
/* 19 */       SteamUniverse steamUniverse; if ((steamUniverse = arrayOfSteamUniverse[b]).value == paramInt) {
/* 20 */         return steamUniverse;
/*    */       }
/*    */     } 
/* 23 */     return Invalid;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamUniverse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */