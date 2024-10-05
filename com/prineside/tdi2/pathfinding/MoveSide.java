/*     */ package com.prineside.tdi2.pathfinding;
/*     */ 
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.utils.BitVector;
/*     */ import com.prineside.tdi2.utils.IntPair;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class MoveSide
/*     */ {
/*     */   public static final byte LEFT_TOP = 0;
/*     */   public static final byte LEFT_RIGHT = 1;
/*     */   public static final byte LEFT_BOTTOM = 2;
/*     */   public static final byte LEFT_CENTER = 3;
/*     */   public static final byte TOP_LEFT = 4;
/*     */   public static final byte TOP_RIGHT = 5;
/*     */   public static final byte TOP_BOTTOM = 6;
/*     */   public static final byte TOP_CENTER = 7;
/*     */   public static final byte RIGHT_LEFT = 8;
/*     */   public static final byte RIGHT_TOP = 9;
/*     */   public static final byte RIGHT_BOTTOM = 10;
/*     */   public static final byte RIGHT_CENTER = 11;
/*     */   public static final byte BOTTOM_LEFT = 12;
/*     */   public static final byte BOTTOM_TOP = 13;
/*     */   public static final byte BOTTOM_RIGHT = 14;
/*     */   public static final byte BOTTOM_CENTER = 15;
/*     */   public static final byte CENTER_LEFT = 16;
/*     */   public static final byte CENTER_TOP = 17;
/*     */   public static final byte CENTER_RIGHT = 18;
/*     */   public static final byte CENTER_BOTTOM = 19;
/*     */   public static final int VALUES_COUNT = 20;
/*  33 */   public static final byte[] REVERSE = new byte[] { 4, 8, 12, 16, 0, 9, 13, 17, 1, 5, 14, 18, 2, 6, 10, 19, 3, 7, 11, 15 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  56 */   private static final BitVector a = new BitVector(400);
/*  57 */   private static final IntPair[] b = new IntPair[20];
/*     */   
/*     */   static {
/*  60 */     for (byte b = 0; b < 20; b = (byte)(b + 1)) {
/*  61 */       for (byte b1 = 0; b1 < 20; b1 = (byte)(b1 + 1)) {
/*  62 */         a.unsafeSetValue(b * 20 + b1, ((
/*  63 */             getName(b).endsWith("TOP") && getName(b1).startsWith("BOTTOM")) || (
/*  64 */             getName(b).endsWith("BOTTOM") && getName(b1).startsWith("TOP")) || (
/*  65 */             getName(b).endsWith("LEFT") && getName(b1).startsWith("RIGHT")) || (
/*  66 */             getName(b).endsWith("RIGHT") && getName(b1).startsWith("LEFT"))));
/*     */       }
/*     */ 
/*     */       
/*  70 */       if (getName(b).endsWith("TOP")) {
/*  71 */         b[b] = new IntPair(0, 1);
/*  72 */       } else if (getName(b).endsWith("RIGHT")) {
/*  73 */         b[b] = new IntPair(1, 0);
/*  74 */       } else if (getName(b).endsWith("LEFT")) {
/*  75 */         b[b] = new IntPair(-1, 0);
/*  76 */       } else if (getName(b).endsWith("BOTTOM")) {
/*  77 */         b[b] = new IntPair(0, -1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean areConnected(byte paramByte1, byte paramByte2) {
/*  83 */     return a.unsafeGet(paramByte1 * 20 + paramByte2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IntPair getNextNodeShift(byte paramByte) {
/*  90 */     return b[paramByte];
/*     */   }
/*     */   
/*     */   public static boolean isStraightLine(byte paramByte) {
/*  94 */     return (paramByte == 1 || paramByte == 8 || paramByte == 6 || paramByte == 13);
/*     */   }
/*     */   
/*     */   public static String getName(byte paramByte) {
/*  98 */     switch (paramByte) { case 0:
/*  99 */         return "LEFT_TOP";
/* 100 */       case 1: return "LEFT_RIGHT";
/* 101 */       case 2: return "LEFT_BOTTOM";
/* 102 */       case 3: return "LEFT_CENTER";
/* 103 */       case 4: return "TOP_LEFT";
/* 104 */       case 5: return "TOP_RIGHT";
/* 105 */       case 6: return "TOP_BOTTOM";
/* 106 */       case 7: return "TOP_CENTER";
/* 107 */       case 8: return "RIGHT_LEFT";
/* 108 */       case 9: return "RIGHT_TOP";
/* 109 */       case 10: return "RIGHT_BOTTOM";
/* 110 */       case 11: return "RIGHT_CENTER";
/* 111 */       case 12: return "BOTTOM_LEFT";
/* 112 */       case 13: return "BOTTOM_TOP";
/* 113 */       case 14: return "BOTTOM_RIGHT";
/* 114 */       case 15: return "BOTTOM_CENTER";
/* 115 */       case 16: return "CENTER_LEFT";
/* 116 */       case 17: return "CENTER_TOP";
/* 117 */       case 18: return "CENTER_RIGHT";
/* 118 */       case 19: return "CENTER_BOTTOM"; }
/* 119 */      return "UNKNOWN";
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte valueOf(String paramString) {
/* 124 */     switch (paramString) { case "LEFT_TOP":
/* 125 */         return 0;
/* 126 */       case "LEFT_RIGHT": return 1;
/* 127 */       case "LEFT_BOTTOM": return 2;
/* 128 */       case "LEFT_CENTER": return 3;
/* 129 */       case "TOP_LEFT": return 4;
/* 130 */       case "TOP_RIGHT": return 5;
/* 131 */       case "TOP_BOTTOM": return 6;
/* 132 */       case "TOP_CENTER": return 7;
/* 133 */       case "RIGHT_LEFT": return 8;
/* 134 */       case "RIGHT_TOP": return 9;
/* 135 */       case "RIGHT_BOTTOM": return 10;
/* 136 */       case "RIGHT_CENTER": return 11;
/* 137 */       case "BOTTOM_LEFT": return 12;
/* 138 */       case "BOTTOM_TOP": return 13;
/* 139 */       case "BOTTOM_RIGHT": return 14;
/* 140 */       case "BOTTOM_CENTER": return 15;
/* 141 */       case "CENTER_LEFT": return 16;
/* 142 */       case "CENTER_TOP": return 17;
/* 143 */       case "CENTER_RIGHT": return 18;
/* 144 */       case "CENTER_BOTTOM": return 19; }
/* 145 */      return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte calculateMoveSides(PathNode paramPathNode1, PathNode paramPathNode2, PathNode paramPathNode3) {
/* 153 */     byte b1 = -1;
/* 154 */     byte b2 = -1;
/*     */     
/* 156 */     if (paramPathNode2 != null) {
/*     */       
/* 158 */       if (paramPathNode2.getY() == paramPathNode1.getY() && paramPathNode2.getX() + 1 == paramPathNode1.getX()) {
/* 159 */         b1 = 0;
/* 160 */       } else if (paramPathNode2.getY() == paramPathNode1.getY() && paramPathNode2.getX() - 1 == paramPathNode1.getX()) {
/* 161 */         b1 = 1;
/* 162 */       } else if (paramPathNode2.getX() == paramPathNode1.getX() && paramPathNode2.getY() + 1 == paramPathNode1.getY()) {
/* 163 */         b1 = 3;
/* 164 */       } else if (paramPathNode2.getX() == paramPathNode1.getX() && paramPathNode2.getY() - 1 == paramPathNode1.getY()) {
/* 165 */         b1 = 2;
/*     */       } 
/*     */     } else {
/* 168 */       b1 = 4;
/*     */     } 
/*     */     
/* 171 */     if (paramPathNode3 != null) {
/*     */       
/* 173 */       if (paramPathNode3.getY() == paramPathNode1.getY() && paramPathNode3.getX() + 1 == paramPathNode1.getX()) {
/* 174 */         b2 = 0;
/* 175 */       } else if (paramPathNode3.getY() == paramPathNode1.getY() && paramPathNode3.getX() - 1 == paramPathNode1.getX()) {
/* 176 */         b2 = 1;
/* 177 */       } else if (paramPathNode3.getX() == paramPathNode1.getX() && paramPathNode3.getY() + 1 == paramPathNode1.getY()) {
/* 178 */         b2 = 3;
/* 179 */       } else if (paramPathNode3.getX() == paramPathNode1.getX() && paramPathNode3.getY() - 1 == paramPathNode1.getY()) {
/* 180 */         b2 = 2;
/*     */       } 
/*     */     } else {
/* 183 */       b2 = 4;
/*     */     } 
/*     */ 
/*     */     
/* 187 */     if (b1 == -1) {
/*     */       int[] arrayOfInt;
/*     */       
/* 190 */       if ((arrayOfInt = paramPathNode2.getTeleports()) != null) {
/* 191 */         byte b; for (b = 0; b < 4; b = (byte)(b + 1)) {
/*     */           int i;
/* 193 */           if ((i = arrayOfInt[b]) != -1) {
/*     */             int[] arrayOfInt1;
/*     */             
/* 196 */             if ((arrayOfInt1 = paramPathNode1.getTeleports()) != null) {
/* 197 */               byte b3; for (b3 = 0; b3 < 4; b3 = (byte)(b3 + 1)) {
/* 198 */                 if (i == arrayOfInt1[b3]) {
/*     */                   
/* 200 */                   b1 = b3;
/*     */                   break;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 209 */     if (b2 == -1) {
/*     */       int[] arrayOfInt;
/*     */       
/* 212 */       if ((arrayOfInt = paramPathNode3.getTeleports()) != null) {
/* 213 */         byte b; for (b = 0; b < 4; b = (byte)(b + 1)) {
/*     */           int i;
/* 215 */           if ((i = arrayOfInt[b]) != -1) {
/*     */             int[] arrayOfInt1;
/*     */             
/* 218 */             if ((arrayOfInt1 = paramPathNode1.getTeleports()) != null) {
/* 219 */               byte b3; for (b3 = 0; b3 < 4; b3 = (byte)(b3 + 1)) {
/* 220 */                 if (i == arrayOfInt1[b3]) {
/*     */                   
/* 222 */                   b2 = b3;
/*     */                   
/*     */                   break;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 232 */     if (b1 == -1 || b2 == -1) {
/* 233 */       throw new IllegalStateException("Can't find move direction - " + ((b1 == -1) ? "no from, " : "") + " " + ((b2 == -1) ? "no to, " : "") + " (prev: " + paramPathNode2 + ") (curr: " + paramPathNode1 + ") (next: " + paramPathNode3 + ")");
/*     */     }
/*     */ 
/*     */     
/* 237 */     if (b1 == b2)
/*     */     {
/* 239 */       b1 = 4;
/*     */     }
/*     */     
/* 242 */     return MoveDirection.getMoveSideByDirections(b1, b2);
/*     */   }
/*     */   
/*     */   public static void assertValid(byte paramByte) {
/* 246 */     Preconditions.checkArgument((paramByte >= 0 && paramByte < 20), "move side must be a value in range 0..%s, %s given", 20, paramByte);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\pathfinding\MoveSide.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */