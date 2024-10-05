/*     */ package com.prineside.luaj.lib;
/*     */ 
/*     */ import com.prineside.luaj.LuaTable;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.Varargs;
/*     */ import com.prineside.tdi2.utils.REGS;
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
/*     */ public class Bit32Lib
/*     */   extends TwoArgFunction
/*     */ {
/*     */   public LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/*  64 */     LuaTable luaTable = new LuaTable();
/*  65 */     a((LuaValue)luaTable, Bit32LibV.class, new String[] { "band", "bnot", "bor", "btest", "bxor", "extract", "replace" });
/*     */ 
/*     */     
/*  68 */     a((LuaValue)luaTable, Bit32Lib2.class, new String[] { "arshift", "lrotate", "lshift", "rrotate", "rshift" });
/*     */ 
/*     */     
/*  71 */     paramLuaValue2.set("bit32", (LuaValue)luaTable);
/*  72 */     if (!paramLuaValue2.get("package").isnil()) paramLuaValue2.get("package").get("loaded").set("bit32", (LuaValue)luaTable); 
/*  73 */     return (LuaValue)luaTable;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class Bit32LibV extends VarArgFunction {
/*     */     public final Varargs invoke(Varargs param1Varargs) {
/*  79 */       switch (this.c) { case 0:
/*  80 */           return Bit32Lib.a(param1Varargs);
/*  81 */         case 1: return Bit32Lib.b(param1Varargs);
/*  82 */         case 2: return Bit32Lib.c(param1Varargs);
/*  83 */         case 3: return Bit32Lib.d(param1Varargs);
/*  84 */         case 4: return Bit32Lib.e(param1Varargs);
/*     */         case 5:
/*  86 */           return (Varargs)Bit32Lib.a(param1Varargs.checkint(1), param1Varargs.checkint(2), param1Varargs.optint(3, 1));
/*     */         case 6:
/*  88 */           return (Varargs)Bit32Lib.a(param1Varargs.checkint(1), param1Varargs.checkint(2), param1Varargs
/*  89 */               .checkint(3), param1Varargs.optint(4, 1)); }
/*     */       
/*  91 */       return (Varargs)NIL;
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class Bit32Lib2
/*     */     extends TwoArgFunction {
/*     */     public final LuaValue call(LuaValue param1LuaValue1, LuaValue param1LuaValue2) {
/*  99 */       switch (this.c) { case 0:
/* 100 */           return Bit32Lib.a(param1LuaValue1.checkint(), param1LuaValue2.checkint());
/* 101 */         case 1: return Bit32Lib.d(param1LuaValue1.checkint(), param1LuaValue2.checkint());
/* 102 */         case 2: return Bit32Lib.c(param1LuaValue1.checkint(), param1LuaValue2.checkint());
/* 103 */         case 3: return Bit32Lib.e(param1LuaValue1.checkint(), param1LuaValue2.checkint());
/* 104 */         case 4: return Bit32Lib.b(param1LuaValue1.checkint(), param1LuaValue2.checkint()); }
/*     */       
/* 106 */       return NIL;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static LuaValue a(int paramInt1, int paramInt2) {
/* 112 */     if (paramInt2 >= 0) {
/* 113 */       return a(paramInt1 >> paramInt2);
/*     */     }
/* 115 */     return a(paramInt1 << -paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   static LuaValue b(int paramInt1, int paramInt2) {
/* 120 */     if (paramInt2 >= 32 || paramInt2 <= -32)
/* 121 */       return (LuaValue)ZERO; 
/* 122 */     if (paramInt2 >= 0) {
/* 123 */       return a(paramInt1 >>> paramInt2);
/*     */     }
/* 125 */     return a(paramInt1 << -paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   static LuaValue c(int paramInt1, int paramInt2) {
/* 130 */     if (paramInt2 >= 32 || paramInt2 <= -32)
/* 131 */       return (LuaValue)ZERO; 
/* 132 */     if (paramInt2 >= 0) {
/* 133 */       return a(paramInt1 << paramInt2);
/*     */     }
/* 135 */     return a(paramInt1 >>> -paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   static Varargs a(Varargs paramVarargs) {
/* 140 */     int i = -1;
/* 141 */     for (byte b = 1; b <= paramVarargs.narg(); b++) {
/* 142 */       i &= paramVarargs.checkint(b);
/*     */     }
/* 144 */     return (Varargs)a(i);
/*     */   }
/*     */   
/*     */   static Varargs b(Varargs paramVarargs) {
/* 148 */     return (Varargs)a(paramVarargs.checkint(1) ^ 0xFFFFFFFF);
/*     */   }
/*     */   
/*     */   static Varargs c(Varargs paramVarargs) {
/* 152 */     int i = 0;
/* 153 */     for (byte b = 1; b <= paramVarargs.narg(); b++) {
/* 154 */       i |= paramVarargs.checkint(b);
/*     */     }
/* 156 */     return (Varargs)a(i);
/*     */   }
/*     */   
/*     */   static Varargs d(Varargs paramVarargs) {
/* 160 */     int i = -1;
/* 161 */     for (byte b = 1; b <= paramVarargs.narg(); b++) {
/* 162 */       i &= paramVarargs.checkint(b);
/*     */     }
/* 164 */     return (Varargs)valueOf((i != 0));
/*     */   }
/*     */   
/*     */   static Varargs e(Varargs paramVarargs) {
/* 168 */     int i = 0;
/* 169 */     for (byte b = 1; b <= paramVarargs.narg(); b++) {
/* 170 */       i ^= paramVarargs.checkint(b);
/*     */     }
/* 172 */     return (Varargs)a(i);
/*     */   }
/*     */   
/*     */   static LuaValue d(int paramInt1, int paramInt2) {
/* 176 */     if (paramInt2 < 0) {
/* 177 */       return e(paramInt1, -paramInt2);
/*     */     }
/* 179 */     paramInt2 &= 0x1F;
/* 180 */     return a(paramInt1 << paramInt2 | paramInt1 >>> 32 - paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   static LuaValue e(int paramInt1, int paramInt2) {
/* 185 */     if (paramInt2 < 0) {
/* 186 */       return d(paramInt1, -paramInt2);
/*     */     }
/* 188 */     paramInt2 &= 0x1F;
/* 189 */     return a(paramInt1 >>> paramInt2 | paramInt1 << 32 - paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   static LuaValue a(int paramInt1, int paramInt2, int paramInt3) {
/* 194 */     if (paramInt2 < 0) {
/* 195 */       argerror(2, "field cannot be negative");
/*     */     }
/* 197 */     if (paramInt3 < 0) {
/* 198 */       argerror(3, "width must be postive");
/*     */     }
/* 200 */     if (paramInt2 + paramInt3 > 32) {
/* 201 */       error("trying to access non-existent bits");
/*     */     }
/* 203 */     return a(paramInt1 >>> paramInt2 & -1 >>> 32 - paramInt3);
/*     */   }
/*     */   
/*     */   static LuaValue a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 207 */     if (paramInt3 < 0) {
/* 208 */       argerror(3, "field cannot be negative");
/*     */     }
/* 210 */     if (paramInt4 < 0) {
/* 211 */       argerror(4, "width must be postive");
/*     */     }
/* 213 */     if (paramInt3 + paramInt4 > 32) {
/* 214 */       error("trying to access non-existent bits");
/*     */     }
/* 216 */     paramInt4 = -1 >>> 32 - paramInt4 << paramInt3;
/*     */     
/* 218 */     return a(paramInt1 = paramInt1 & (paramInt4 ^ 0xFFFFFFFF) | paramInt2 << paramInt3 & paramInt4);
/*     */   }
/*     */   
/*     */   private static LuaValue a(int paramInt) {
/* 222 */     return (LuaValue)((paramInt < 0) ? valueOf((paramInt & 0xFFFFFFFFL)) : valueOf(paramInt));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\Bit32Lib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */