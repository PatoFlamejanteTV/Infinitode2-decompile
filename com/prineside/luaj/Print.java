/*     */ package com.prineside.luaj;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Print
/*     */   extends Lua
/*     */ {
/*  36 */   public static PrintStream ps = System.out;
/*     */ 
/*     */   
/*  39 */   public static final String[] OPNAMES = new String[] { "MOVE", "LOADK", "LOADKX", "LOADBOOL", "LOADNIL", "GETUPVAL", "GETTABUP", "GETTABLE", "SETTABUP", "SETUPVAL", "SETTABLE", "NEWTABLE", "SELF", "ADD", "SUB", "MUL", "DIV", "MOD", "POW", "UNM", "NOT", "LEN", "CONCAT", "JMP", "EQ", "LT", "LE", "TEST", "TESTSET", "CALL", "TAILCALL", "RETURN", "FORLOOP", "FORPREP", "TFORCALL", "TFORLOOP", "SETLIST", "CLOSURE", "VARARG", "EXTRAARG", null };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(PrintStream paramPrintStream, LuaString paramLuaString) {
/*  86 */     paramPrintStream.print('"'); byte b; int i;
/*  87 */     for (b = 0, i = paramLuaString.m_length; b < i; b++) {
/*     */       byte b1;
/*  89 */       if ((b1 = paramLuaString.m_bytes[paramLuaString.m_offset + b]) >= 32 && b1 <= 126 && b1 != 34 && b1 != 92) {
/*  90 */         paramPrintStream.print((char)b1);
/*     */       } else {
/*  92 */         switch (b1) {
/*     */           case 34:
/*  94 */             paramPrintStream.print("\\\"");
/*     */             break;
/*     */           case 92:
/*  97 */             paramPrintStream.print("\\\\");
/*     */             break;
/*     */           case 7:
/* 100 */             paramPrintStream.print("\\a");
/*     */             break;
/*     */           case 8:
/* 103 */             paramPrintStream.print("\\b");
/*     */             break;
/*     */           case 12:
/* 106 */             paramPrintStream.print("\\f");
/*     */             break;
/*     */           case 9:
/* 109 */             paramPrintStream.print("\\t");
/*     */             break;
/*     */           case 13:
/* 112 */             paramPrintStream.print("\\r");
/*     */             break;
/*     */           case 10:
/* 115 */             paramPrintStream.print("\\n");
/*     */             break;
/*     */           case 11:
/* 118 */             paramPrintStream.print("\\v");
/*     */             break;
/*     */           default:
/* 121 */             paramPrintStream.print('\\');
/* 122 */             paramPrintStream.print(Integer.toString(0x4E7 & b1).substring(1));
/*     */             break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 127 */     paramPrintStream.print('"');
/*     */   }
/*     */   
/*     */   private static void a(PrintStream paramPrintStream, LuaValue paramLuaValue) {
/* 131 */     if (paramLuaValue == null) {
/* 132 */       paramPrintStream.print("null");
/*     */       return;
/*     */     } 
/* 135 */     switch (paramLuaValue.type()) { case 4:
/* 136 */         a(paramPrintStream, (LuaString)paramLuaValue); return; }
/* 137 */      paramPrintStream.print(paramLuaValue.tojstring());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(PrintStream paramPrintStream, FPrototype paramFPrototype, int paramInt) {
/* 143 */     a(paramPrintStream, (paramInt < paramFPrototype.k.length) ? paramFPrototype.k[paramInt] : LuaValue.valueOf("UNKNOWN_CONST_" + paramInt));
/*     */   }
/*     */   
/*     */   private static void a(PrintStream paramPrintStream, Upvaldesc paramUpvaldesc) {
/* 147 */     paramPrintStream.print(paramUpvaldesc.idx + " ");
/* 148 */     a(paramPrintStream, paramUpvaldesc.name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void printCode(FPrototype paramFPrototype) {
/* 157 */     int arrayOfInt[], j = (arrayOfInt = paramFPrototype.code).length;
/* 158 */     for (int i = 0; i < j; i++) {
/* 159 */       i = printOpCode(paramFPrototype, i);
/* 160 */       ps.println();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int printOpCode(FPrototype paramFPrototype, int paramInt) {
/* 171 */     return printOpCode(ps, paramFPrototype, paramInt);
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
/*     */   public static int printOpCode(PrintStream paramPrintStream, FPrototype paramFPrototype, int paramInt) {
/* 184 */     int arrayOfInt[], i, j = GET_OPCODE(i = (arrayOfInt = paramFPrototype.code)[paramInt]);
/* 185 */     int k = GETARG_A(i);
/* 186 */     int m = GETARG_B(i);
/* 187 */     int n = GETARG_C(i);
/* 188 */     int i1 = GETARG_Bx(i);
/* 189 */     i = GETARG_sBx(i);
/* 190 */     int i2 = a(paramFPrototype, paramInt);
/* 191 */     paramPrintStream.print("  " + (paramInt + 1) + "  ");
/* 192 */     if (i2 > 0) {
/* 193 */       paramPrintStream.print("[" + i2 + "]  ");
/*     */     } else {
/* 195 */       paramPrintStream.print("[-]  ");
/* 196 */     }  if (j >= OPNAMES.length - 1) {
/* 197 */       paramPrintStream.print("UNKNOWN_OP_" + j + "  ");
/*     */     } else {
/* 199 */       paramPrintStream.print(OPNAMES[j] + "  ");
/* 200 */       switch (getOpMode(j)) {
/*     */         case 0:
/* 202 */           paramPrintStream.print(k);
/* 203 */           if (getBMode(j) != 0)
/* 204 */             paramPrintStream.print(" " + (ISK(m) ? (-1 - INDEXK(m)) : m)); 
/* 205 */           if (getCMode(j) != 0)
/* 206 */             paramPrintStream.print(" " + (ISK(n) ? (-1 - INDEXK(n)) : n)); 
/*     */           break;
/*     */         case 1:
/* 209 */           if (getBMode(j) == 3) {
/* 210 */             paramPrintStream.print(k + " " + (-1 - i1)); break;
/*     */           } 
/* 212 */           paramPrintStream.print(k + " " + i1);
/*     */           break;
/*     */         
/*     */         case 2:
/* 216 */           if (j == 23) {
/* 217 */             paramPrintStream.print(i); break;
/*     */           } 
/* 219 */           paramPrintStream.print(k + " " + i);
/*     */           break;
/*     */       } 
/* 222 */       switch (j) {
/*     */         case 1:
/* 224 */           paramPrintStream.print("  ; ");
/* 225 */           a(paramPrintStream, paramFPrototype, i1);
/*     */           break;
/*     */         case 5:
/*     */         case 9:
/* 229 */           paramPrintStream.print("  ; ");
/* 230 */           if (m < paramFPrototype.upvalues.length) {
/* 231 */             a(paramPrintStream, paramFPrototype.upvalues[m]); break;
/*     */           } 
/* 233 */           paramPrintStream.print("UNKNOWN_UPVALUE_" + m);
/*     */           break;
/*     */         
/*     */         case 6:
/* 237 */           paramPrintStream.print("  ; ");
/* 238 */           if (m < paramFPrototype.upvalues.length) {
/* 239 */             a(paramPrintStream, paramFPrototype.upvalues[m]);
/*     */           } else {
/* 241 */             paramPrintStream.print("UNKNOWN_UPVALUE_" + m);
/*     */           } 
/* 243 */           paramPrintStream.print(" ");
/* 244 */           if (ISK(n)) {
/* 245 */             a(paramPrintStream, paramFPrototype, INDEXK(n)); break;
/*     */           } 
/* 247 */           paramPrintStream.print("-");
/*     */           break;
/*     */         case 8:
/* 250 */           paramPrintStream.print("  ; ");
/* 251 */           if (k < paramFPrototype.upvalues.length) {
/* 252 */             a(paramPrintStream, paramFPrototype.upvalues[k]);
/*     */           } else {
/* 254 */             paramPrintStream.print("UNKNOWN_UPVALUE_" + k);
/*     */           } 
/* 256 */           paramPrintStream.print(" ");
/* 257 */           if (ISK(m)) {
/* 258 */             a(paramPrintStream, paramFPrototype, INDEXK(m));
/*     */           } else {
/* 260 */             paramPrintStream.print("-");
/* 261 */           }  paramPrintStream.print(" ");
/* 262 */           if (ISK(n)) {
/* 263 */             a(paramPrintStream, paramFPrototype, INDEXK(n)); break;
/*     */           } 
/* 265 */           paramPrintStream.print("-");
/*     */           break;
/*     */         case 7:
/*     */         case 12:
/* 269 */           if (ISK(n)) {
/* 270 */             paramPrintStream.print("  ; ");
/* 271 */             a(paramPrintStream, paramFPrototype, INDEXK(n));
/*     */           } 
/*     */           break;
/*     */         case 10:
/*     */         case 13:
/*     */         case 14:
/*     */         case 15:
/*     */         case 16:
/*     */         case 18:
/*     */         case 24:
/*     */         case 25:
/*     */         case 26:
/* 283 */           if (ISK(m) || ISK(n)) {
/* 284 */             paramPrintStream.print("  ; ");
/* 285 */             if (ISK(m)) {
/* 286 */               a(paramPrintStream, paramFPrototype, INDEXK(m));
/*     */             } else {
/* 288 */               paramPrintStream.print("-");
/* 289 */             }  paramPrintStream.print(" ");
/* 290 */             if (ISK(n)) {
/* 291 */               a(paramPrintStream, paramFPrototype, INDEXK(n)); break;
/*     */             } 
/* 293 */             paramPrintStream.print("-");
/*     */           } 
/*     */           break;
/*     */         case 23:
/*     */         case 32:
/*     */         case 33:
/* 299 */           paramPrintStream.print("  ; to " + (i + paramInt + 2));
/*     */           break;
/*     */         case 37:
/* 302 */           if (i1 < paramFPrototype.p.length) {
/* 303 */             paramPrintStream.print("  ; " + paramFPrototype.p[i1].getClass().getName()); break;
/*     */           } 
/* 305 */           paramPrintStream.print("  ; UNKNOWN_PROTYPE_" + i1);
/*     */           break;
/*     */         
/*     */         case 36:
/* 309 */           if (n == 0) {
/* 310 */             paramPrintStream.print("  ; " + arrayOfInt[++paramInt] + " (stored in the next OP)"); break;
/*     */           } 
/* 312 */           paramPrintStream.print("  ; " + n);
/*     */           break;
/*     */         case 38:
/* 315 */           paramPrintStream.print("  ; is_vararg=" + paramFPrototype.is_vararg);
/*     */           break;
/*     */       } 
/*     */ 
/*     */     
/*     */     } 
/* 321 */     return paramInt;
/*     */   }
/*     */   
/*     */   private static int a(FPrototype paramFPrototype, int paramInt) {
/* 325 */     return (paramInt > 0 && paramFPrototype.lineinfo != null && paramInt < paramFPrototype.lineinfo.length) ? paramFPrototype.lineinfo[paramInt] : -1;
/*     */   }
/*     */   
/*     */   private static void a(FPrototype paramFPrototype) {
/*     */     String str1;
/* 330 */     if ((str1 = String.valueOf(paramFPrototype.source)).startsWith("@") || str1.startsWith("=")) {
/* 331 */       str1 = str1.substring(1);
/* 332 */     } else if ("\033Lua".equals(str1)) {
/* 333 */       str1 = "(bstring)";
/*     */     } else {
/* 335 */       str1 = "(string)";
/* 336 */     }  String str2 = (paramFPrototype.linedefined == 0) ? "main" : "function";
/* 337 */     ps.print("\n%" + str2 + " <" + str1 + ":" + paramFPrototype.linedefined + "," + paramFPrototype.lastlinedefined + "> (" + paramFPrototype.code.length + " instructions, " + (paramFPrototype.code.length << 2) + " bytes at " + 
/*     */         
/* 339 */         a() + ")\n");
/* 340 */     ps.print(paramFPrototype.numparams + " param, " + paramFPrototype.maxstacksize + " slot, " + paramFPrototype.upvalues.length + " upvalue, ");
/*     */     
/* 342 */     ps.print(paramFPrototype.locvars.length + " local, " + paramFPrototype.k.length + " constant, " + paramFPrototype.p.length + " function\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private static void b(FPrototype paramFPrototype) {
/* 347 */     int i = paramFPrototype.k.length;
/* 348 */     ps.print("constants (" + i + ") for " + a() + ":\n");
/* 349 */     for (byte b = 0; b < i; b++) {
/* 350 */       ps.print("  " + (b + 1) + "  ");
/* 351 */       a(ps, paramFPrototype.k[b]);
/* 352 */       ps.print("\n");
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void c(FPrototype paramFPrototype) {
/* 357 */     int i = paramFPrototype.locvars.length;
/* 358 */     ps.print("locals (" + i + ") for " + a() + ":\n");
/* 359 */     for (byte b = 0; b < i; b++) {
/* 360 */       ps.println("  " + b + "  " + (paramFPrototype.locvars[b]).varname + " " + ((paramFPrototype.locvars[b]).startpc + 1) + " " + ((paramFPrototype.locvars[b]).endpc + 1));
/*     */     }
/*     */   }
/*     */   
/*     */   private static void d(FPrototype paramFPrototype) {
/* 365 */     int i = paramFPrototype.upvalues.length;
/* 366 */     ps.print("upvalues (" + i + ") for " + a() + ":\n");
/* 367 */     for (byte b = 0; b < i; b++) {
/* 368 */       ps.print("  " + b + "  " + paramFPrototype.upvalues[b] + "\n");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void print(FPrototype paramFPrototype) {
/* 377 */     printFunction(paramFPrototype, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void printFunction(FPrototype paramFPrototype, boolean paramBoolean) {
/* 386 */     int i = paramFPrototype.p.length;
/* 387 */     a(paramFPrototype);
/* 388 */     printCode(paramFPrototype);
/* 389 */     if (paramBoolean) {
/* 390 */       b(paramFPrototype);
/* 391 */       c(paramFPrototype);
/* 392 */       d(paramFPrototype);
/*     */     } 
/* 394 */     for (byte b = 0; b < i; b++) {
/* 395 */       printFunction(paramFPrototype.p[b], paramBoolean);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void a(String paramString, int paramInt) {
/* 400 */     if ((paramInt = paramString.length()) > 50) {
/* 401 */       ps.print(paramString.substring(0, 50)); return;
/*     */     } 
/* 403 */     ps.print(paramString);
/* 404 */     for (int i = 50 - paramInt; --i >= 0;) {
/* 405 */       ps.print(' ');
/*     */     }
/*     */   }
/*     */   
/*     */   private static String a() {
/* 410 */     return "Proto";
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
/*     */   public static void printState(LuaClosure paramLuaClosure, int paramInt1, LuaValue[] paramArrayOfLuaValue, int paramInt2, Varargs paramVarargs) {
/* 427 */     PrintStream printStream = ps;
/* 428 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 429 */     ps = new PrintStream(byteArrayOutputStream);
/* 430 */     printOpCode(paramLuaClosure.p, paramInt1);
/* 431 */     ps.flush();
/* 432 */     ps.close();
/* 433 */     ps = printStream;
/* 434 */     a(byteArrayOutputStream.toString(), 50);
/* 435 */     printStack(paramArrayOfLuaValue, paramInt2, paramVarargs);
/* 436 */     ps.println();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void printStack(LuaValue[] paramArrayOfLuaValue, int paramInt, Varargs paramVarargs) {
/* 441 */     ps.print('[');
/* 442 */     for (byte b = 0; b < paramArrayOfLuaValue.length; b++) {
/*     */       LuaValue luaValue;
/* 444 */       if ((luaValue = paramArrayOfLuaValue[b]) == null)
/* 445 */       { ps.print("null"); }
/* 446 */       else { String str; Object object; switch (luaValue.type()) {
/*     */           case 4:
/* 448 */             luaValue = luaValue.checkstring();
/* 449 */             ps.print((luaValue.length() < 48) ? 
/* 450 */                 luaValue.tojstring() : (
/* 451 */                 luaValue.substring(0, 32).tojstring() + "...+" + (luaValue.length() - 32) + "b"));
/*     */             break;
/*     */           case 6:
/* 454 */             ps.print(luaValue.tojstring());
/*     */             break;
/*     */           
/*     */           case 7:
/* 458 */             if ((object = luaValue.touserdata()) != null) {
/*     */               
/* 460 */               str = (str = object.getClass().getName()).substring(str.lastIndexOf('.') + 1);
/* 461 */               ps.print(str + ": " + Integer.toHexString(object.hashCode())); break;
/*     */             } 
/* 463 */             ps.print(str.toString());
/*     */             break;
/*     */           
/*     */           default:
/* 467 */             ps.print(str.tojstring()); break;
/*     */         }  }
/* 469 */        if (b + 1 == paramInt)
/* 470 */         ps.print(']'); 
/* 471 */       ps.print(" | ");
/*     */     } 
/* 473 */     ps.print(paramVarargs);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\Print.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */