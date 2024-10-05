/*    */ package com.prineside.tdi2.pathfinding;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class SideShift
/*    */ {
/*    */   public static final int SIDE_SHIFTS_COUNT = 11;
/*    */   public static final int MIDDLE_SIDE_SHIFT = 5;
/*    */   public static final float SIDE_SHIFT_DISTANCE = 0.0625F;
/*    */   public static final int[][] SIDE_SHIFT_BY_COUNT;
/*    */   
/*    */   static {
/* 14 */     (new int[1])[0] = 5; (SIDE_SHIFT_BY_COUNT = new int[12][])[1] = new int[1];
/* 15 */     (new int[2])[0] = 3; (new int[2])[1] = 7; SIDE_SHIFT_BY_COUNT[2] = new int[2];
/* 16 */     (new int[3])[0] = 2; (new int[3])[1] = 5; (new int[3])[2] = 8; SIDE_SHIFT_BY_COUNT[3] = new int[3];
/* 17 */     (new int[4])[0] = 2; (new int[4])[1] = 4; (new int[4])[2] = 6; (new int[4])[3] = 8; SIDE_SHIFT_BY_COUNT[4] = new int[4];
/* 18 */     (new int[5])[0] = 1; (new int[5])[1] = 3; (new int[5])[2] = 5; (new int[5])[3] = 7; (new int[5])[4] = 9; SIDE_SHIFT_BY_COUNT[5] = new int[5];
/* 19 */     (new int[6])[0] = 0; (new int[6])[1] = 2; (new int[6])[2] = 4; (new int[6])[3] = 6; (new int[6])[4] = 8; (new int[6])[5] = 10; SIDE_SHIFT_BY_COUNT[6] = new int[6];
/* 20 */     (new int[7])[0] = 0; (new int[7])[1] = 2; (new int[7])[2] = 4; (new int[7])[3] = 5; (new int[7])[4] = 6; (new int[7])[5] = 8; (new int[7])[6] = 10; SIDE_SHIFT_BY_COUNT[7] = new int[7];
/* 21 */     (new int[8])[0] = 0; (new int[8])[1] = 2; (new int[8])[2] = 3; (new int[8])[3] = 4; (new int[8])[4] = 6; (new int[8])[5] = 7; (new int[8])[6] = 8; (new int[8])[7] = 10; SIDE_SHIFT_BY_COUNT[8] = new int[8];
/* 22 */     (new int[9])[0] = 0; (new int[9])[1] = 1; (new int[9])[2] = 2; (new int[9])[3] = 4; (new int[9])[4] = 5; (new int[9])[5] = 6; (new int[9])[6] = 8; (new int[9])[7] = 9; (new int[9])[8] = 10; SIDE_SHIFT_BY_COUNT[9] = new int[9];
/* 23 */     (new int[10])[0] = 0; (new int[10])[1] = 1; (new int[10])[2] = 2; (new int[10])[3] = 3; (new int[10])[4] = 4; (new int[10])[5] = 6; (new int[10])[6] = 7; (new int[10])[7] = 8; (new int[10])[8] = 9; (new int[10])[9] = 10; SIDE_SHIFT_BY_COUNT[10] = new int[10];
/* 24 */     (new int[11])[0] = 0; (new int[11])[1] = 1; (new int[11])[2] = 2; (new int[11])[3] = 3; (new int[11])[4] = 4; (new int[11])[5] = 5; (new int[11])[6] = 6; (new int[11])[7] = 7; (new int[11])[8] = 8; (new int[11])[9] = 9; (new int[11])[10] = 10; SIDE_SHIFT_BY_COUNT[11] = new int[11];
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\pathfinding\SideShift.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */