/*     */ package com.prineside.luaj;
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
/*     */ public class Lua
/*     */ {
/*     */   public static final String _VERSION = "Lua 5.2";
/*     */   public static final String _LUAJ_VERSION = "Luaj 3.0.2 custom";
/*     */   public static final int LUA_MULTRET = -1;
/*     */   public static final int MAX_CALL_STACK = 500;
/*     */   public static final int iABC = 0;
/*     */   public static final int iABx = 1;
/*     */   public static final int iAsBx = 2;
/*     */   public static final int iAx = 3;
/*     */   public static final int SIZE_C = 9;
/*     */   public static final int SIZE_B = 9;
/*     */   public static final int SIZE_Bx = 18;
/*     */   public static final int SIZE_A = 8;
/*     */   public static final int SIZE_Ax = 26;
/*     */   public static final int SIZE_OP = 6;
/*     */   public static final int POS_OP = 0;
/*     */   public static final int POS_A = 6;
/*     */   public static final int POS_C = 14;
/*     */   public static final int POS_B = 23;
/*     */   public static final int POS_Bx = 14;
/*     */   public static final int POS_Ax = 6;
/*     */   public static final int MAX_OP = 63;
/*     */   public static final int MAXARG_A = 255;
/*     */   public static final int MAXARG_B = 511;
/*     */   public static final int MAXARG_C = 511;
/*     */   public static final int MAXARG_Bx = 262143;
/*     */   public static final int MAXARG_sBx = 131071;
/*     */   public static final int MAXARG_Ax = 67108863;
/*     */   public static final int MASK_OP = 63;
/*     */   public static final int MASK_A = 16320;
/*     */   public static final int MASK_B = -8388608;
/*     */   public static final int MASK_C = 8372224;
/*     */   public static final int MASK_Bx = -16384;
/*     */   public static final int MASK_Ax = -64;
/*     */   public static final int MASK_NOT_OP = -64;
/*     */   public static final int MASK_NOT_A = -16321;
/*     */   public static final int MASK_NOT_B = 8388607;
/*     */   public static final int MASK_NOT_C = -8372225;
/*     */   public static final int MASK_NOT_Bx = 16383;
/*     */   public static final int BITRK = 256;
/*     */   public static final int MAXINDEXRK = 255;
/*     */   public static final int NO_REG = 255;
/*     */   public static final int OP_MOVE = 0;
/*     */   public static final int OP_LOADK = 1;
/*     */   public static final int OP_LOADKX = 2;
/*     */   public static final int OP_LOADBOOL = 3;
/*     */   public static final int OP_LOADNIL = 4;
/*     */   public static final int OP_GETUPVAL = 5;
/*     */   public static final int OP_GETTABUP = 6;
/*     */   public static final int OP_GETTABLE = 7;
/*     */   public static final int OP_SETTABUP = 8;
/*     */   public static final int OP_SETUPVAL = 9;
/*     */   public static final int OP_SETTABLE = 10;
/*     */   public static final int OP_NEWTABLE = 11;
/*     */   public static final int OP_SELF = 12;
/*     */   public static final int OP_ADD = 13;
/*     */   public static final int OP_SUB = 14;
/*     */   public static final int OP_MUL = 15;
/*     */   public static final int OP_DIV = 16;
/*     */   public static final int OP_MOD = 17;
/*     */   public static final int OP_POW = 18;
/*     */   public static final int OP_UNM = 19;
/*     */   public static final int OP_NOT = 20;
/*     */   public static final int OP_LEN = 21;
/*     */   public static final int OP_CONCAT = 22;
/*     */   public static final int OP_JMP = 23;
/*     */   public static final int OP_EQ = 24;
/*     */   public static final int OP_LT = 25;
/*     */   public static final int OP_LE = 26;
/*     */   public static final int OP_TEST = 27;
/*     */   public static final int OP_TESTSET = 28;
/*     */   public static final int OP_CALL = 29;
/*     */   public static final int OP_TAILCALL = 30;
/*     */   public static final int OP_RETURN = 31;
/*     */   public static final int OP_FORLOOP = 32;
/*     */   public static final int OP_FORPREP = 33;
/*     */   public static final int OP_TFORCALL = 34;
/*     */   public static final int OP_TFORLOOP = 35;
/*     */   public static final int OP_SETLIST = 36;
/*     */   public static final int OP_CLOSURE = 37;
/*     */   public static final int OP_VARARG = 38;
/*     */   public static final int OP_EXTRAARG = 39;
/*     */   public static final int NUM_OPCODES = 40;
/*     */   public static final int OP_GT = 63;
/*     */   public static final int OP_GE = 62;
/*     */   public static final int OP_NEQ = 61;
/*     */   public static final int OP_AND = 60;
/*     */   public static final int OP_OR = 59;
/*     */   
/*     */   public static int GET_OPCODE(int paramInt) {
/* 110 */     return paramInt & 0x3F;
/*     */   }
/*     */   
/*     */   public static int GETARG_A(int paramInt) {
/* 114 */     return paramInt >> 6 & 0xFF;
/*     */   }
/*     */   
/*     */   public static int GETARG_Ax(int paramInt) {
/* 118 */     return paramInt >> 6 & 0x3FFFFFF;
/*     */   }
/*     */   
/*     */   public static int GETARG_B(int paramInt) {
/* 122 */     return paramInt >> 23 & 0x1FF;
/*     */   }
/*     */   
/*     */   public static int GETARG_C(int paramInt) {
/* 126 */     return paramInt >> 14 & 0x1FF;
/*     */   }
/*     */   
/*     */   public static int GETARG_Bx(int paramInt) {
/* 130 */     return paramInt >> 14 & 0x3FFFF;
/*     */   }
/*     */   
/*     */   public static int GETARG_sBx(int paramInt) {
/* 134 */     return (paramInt >> 14 & 0x3FFFF) - 131071;
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
/*     */   public static boolean ISK(int paramInt) {
/* 147 */     return (0 != (paramInt & 0x100));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int INDEXK(int paramInt) {
/* 152 */     return paramInt & 0xFFFFFEFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int RKASK(int paramInt) {
/* 159 */     return paramInt | 0x100;
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
/* 248 */   public static final String[] OPCODE_NAMES = new String[] { "MOVE", "LOADK", "LOADKX", "LOADBOOL", "LOADNIL", "GETUPVAL", "GETTABUP", "GETTABLE", "SETTABUP", "SETUPVAL", "SETTABLE", "NEWTABLE", "SELF", "ADD", "SUB", "MUL", "DIV", "MOD", "POW", "UNM", "NOT", "LEN", "CONCAT", "JMP", "EQ", "LT", "LE", "TEST", "TESTSET", "CALL", "TAILCALL", "RETURN", "FORLOOP", "FORPREP", "TFORCALL", "TFORLOOP", "SETLIST", "CLOSURE", "VARARG", "EXTRAARG" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int OpArgN = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int OpArgU = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int OpArgR = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int OpArgK = 3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 290 */   public static final int[] luaP_opmodes = new int[] { 96, 113, 65, 84, 80, 80, 92, 108, 60, 16, 60, 84, 108, 124, 124, 124, 124, 124, 124, 96, 96, 96, 104, 34, 188, 188, 188, 132, 228, 84, 84, 16, 98, 98, 4, 226, 20, 81, 80, 23 };
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
/*     */   public static final int LFIELDS_PER_FLUSH = 50;
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
/*     */   public static int getOpMode(int paramInt) {
/* 335 */     return luaP_opmodes[paramInt] & 0x3;
/*     */   }
/*     */   public static int getBMode(int paramInt) {
/* 338 */     return luaP_opmodes[paramInt] >> 4 & 0x3;
/*     */   }
/*     */   public static int getCMode(int paramInt) {
/* 341 */     return luaP_opmodes[paramInt] >> 2 & 0x3;
/*     */   }
/*     */   public static boolean testAMode(int paramInt) {
/* 344 */     return (0 != (luaP_opmodes[paramInt] & 0x40));
/*     */   }
/*     */   public static boolean testTMode(int paramInt) {
/* 347 */     return (0 != (luaP_opmodes[paramInt] & 0x80));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String chunkid(String paramString) {
/* 356 */     if (paramString.startsWith("="))
/* 357 */       return paramString.substring(1); 
/* 358 */     String str = "";
/* 359 */     if (paramString.startsWith("@")) {
/* 360 */       paramString = paramString.substring(1);
/*     */     } else {
/* 362 */       paramString = "[string \"" + paramString;
/* 363 */       str = "\"]";
/*     */     } 
/*     */     int i;
/* 366 */     if ((i = paramString.length() + str.length()) > 80)
/* 367 */       paramString = paramString.substring(0, 80 - str.length() - 3) + "..."; 
/* 368 */     return paramString + str;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\Lua.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */