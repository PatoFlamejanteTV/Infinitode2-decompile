/*    */ package com.prineside.tdi2.pathfinding;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class MoveDirection
/*    */ {
/*    */   public static final byte LEFT = 0;
/*    */   public static final byte RIGHT = 1;
/*    */   public static final byte TOP = 2;
/*    */   public static final byte BOTTOM = 3;
/*    */   public static final byte CENTER = 4;
/*    */   public static final int VALUES_COUNT = 5;
/* 19 */   public static final byte[] MOVE_SIDE_BY_DIRECTIONS = new byte[25];
/*    */   static {
/* 21 */     for (byte b = 0; b < 5; b = (byte)(b + 1)) {
/* 22 */       for (byte b1 = 0; b1 < 5; b1 = (byte)(b1 + 1)) {
/* 23 */         if (b != b1)
/* 24 */           MOVE_SIDE_BY_DIRECTIONS[b * 5 + b1] = MoveSide.valueOf(getName(b) + "_" + getName(b1)); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static String getName(byte paramByte) {
/* 30 */     switch (paramByte) { case 4:
/* 31 */         return "CENTER";
/* 32 */       case 0: return "LEFT";
/* 33 */       case 1: return "RIGHT";
/* 34 */       case 2: return "TOP";
/* 35 */       case 3: return "BOTTOM"; }
/* 36 */      return "UNKNOWN";
/*    */   }
/*    */ 
/*    */   
/*    */   public static byte valueOf(String paramString) {
/* 41 */     switch (paramString) { case "CENTER":
/* 42 */         return 4;
/* 43 */       case "LEFT": return 0;
/* 44 */       case "RIGHT": return 1;
/* 45 */       case "TOP": return 2;
/* 46 */       case "BOTTOM": return 3; }
/* 47 */      return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public static byte getMoveSideByDirections(byte paramByte1, byte paramByte2) {
/* 52 */     return MOVE_SIDE_BY_DIRECTIONS[paramByte1 * 5 + paramByte2];
/*    */   }
/*    */   
/*    */   public static void assertValid(byte paramByte) {
/* 56 */     Preconditions.checkArgument((paramByte >= 0 && paramByte < 5), "direction must be a value in range 0..%s, %s given", 5, paramByte);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\pathfinding\MoveDirection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */