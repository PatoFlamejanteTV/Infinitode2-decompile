/*     */ package com.prineside.luaj.lib;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.luaj.LuaNumber;
/*     */ import com.prineside.luaj.LuaTable;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.Varargs;
/*     */ import com.prineside.tdi2.utils.NAGS;
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
/*     */ public class MathLib
/*     */   extends TwoArgFunction
/*     */ {
/*  90 */   public static MathLib MATHLIB = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MathLib() {
/*  96 */     MATHLIB = this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/*     */     LuaTable luaTable;
/* 107 */     (luaTable = new LuaTable(0, 30)).set("abs", (LuaValue)new abs());
/* 108 */     luaTable.set("ceil", (LuaValue)new ceil());
/* 109 */     luaTable.set("cos", (LuaValue)new cos());
/* 110 */     luaTable.set("deg", (LuaValue)new deg());
/* 111 */     luaTable.set("exp", (LuaValue)new exp(this));
/* 112 */     luaTable.set("floor", (LuaValue)new floor());
/* 113 */     luaTable.set("fmod", (LuaValue)new fmod());
/* 114 */     luaTable.set("frexp", (LuaValue)new frexp());
/* 115 */     luaTable.set("huge", (LuaValue)LuaNumber.POSINF);
/* 116 */     luaTable.set("ldexp", (LuaValue)new ldexp());
/* 117 */     luaTable.set("max", (LuaValue)new max());
/* 118 */     luaTable.set("min", (LuaValue)new min());
/* 119 */     luaTable.set("modf", (LuaValue)new modf());
/* 120 */     luaTable.set("pi", Math.PI);
/* 121 */     luaTable.set("pow", (LuaValue)new pow());
/*     */     random random;
/* 123 */     luaTable.set("random", (LuaValue)(random = new random()));
/* 124 */     luaTable.set("randomseed", (LuaValue)new randomseed(random));
/* 125 */     luaTable.set("rad", (LuaValue)new rad());
/* 126 */     luaTable.set("sin", (LuaValue)new sin());
/* 127 */     luaTable.set("sqrt", (LuaValue)new sqrt());
/* 128 */     luaTable.set("tan", (LuaValue)new tan());
/* 129 */     paramLuaValue2.set("math", (LuaValue)luaTable);
/* 130 */     if (!paramLuaValue2.get("package").isnil()) paramLuaValue2.get("package").get("loaded").set("math", (LuaValue)luaTable); 
/* 131 */     return (LuaValue)luaTable;
/*     */   }
/*     */   
/*     */   protected static abstract class UnaryOp extends OneArgFunction {
/*     */     public LuaValue call(LuaValue param1LuaValue) {
/* 136 */       return (LuaValue)valueOf(a(param1LuaValue.checkdouble()));
/*     */     }
/*     */     
/*     */     protected abstract double a(double param1Double);
/*     */   }
/*     */   
/*     */   protected static abstract class BinaryOp extends TwoArgFunction { public LuaValue call(LuaValue param1LuaValue1, LuaValue param1LuaValue2) {
/* 143 */       return (LuaValue)valueOf(a(param1LuaValue1.checkdouble(), param1LuaValue2.checkdouble()));
/*     */     }
/*     */     protected abstract double a(double param1Double1, double param1Double2); }
/*     */   
/*     */   @REGS
/*     */   public static final class abs extends UnaryOp { protected final double a(double param1Double) {
/* 149 */       return StrictMath.abs(param1Double);
/*     */     } } @REGS
/*     */   public static final class ceil extends UnaryOp { protected final double a(double param1Double) {
/* 152 */       return StrictMath.ceil(param1Double);
/*     */     } } @REGS
/*     */   public static final class cos extends UnaryOp { protected final double a(double param1Double) {
/* 155 */       return MathUtils.cos((float)param1Double);
/*     */     } } @REGS
/*     */   public static final class deg extends UnaryOp { protected final double a(double param1Double) {
/* 158 */       return StrictMath.toDegrees(param1Double);
/*     */     } } @REGS
/*     */   public static final class floor extends UnaryOp { protected final double a(double param1Double) {
/* 161 */       return StrictMath.floor(param1Double);
/*     */     } } @REGS
/*     */   public static final class rad extends UnaryOp { protected final double a(double param1Double) {
/* 164 */       return StrictMath.toRadians(param1Double);
/*     */     } } @REGS
/*     */   public static final class sin extends UnaryOp { protected final double a(double param1Double) {
/* 167 */       return MathUtils.sin((float)param1Double);
/*     */     } } @REGS
/*     */   public static final class sqrt extends UnaryOp { protected final double a(double param1Double) {
/* 170 */       return StrictMath.sqrt(param1Double);
/*     */     } } @REGS
/*     */   public static final class tan extends UnaryOp { protected final double a(double param1Double) {
/* 173 */       return StrictMath.tan(param1Double);
/*     */     } }
/*     */   
/*     */   @REGS
/*     */   public static final class exp extends UnaryOp implements KryoSerializable {
/*     */     private MathLib a;
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 181 */       param1Kryo.writeClassAndObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 186 */       this.a = (MathLib)param1Kryo.readClassAndObject(param1Input);
/*     */     }
/*     */     private exp() {}
/*     */     
/*     */     exp(MathLib param1MathLib) {
/* 191 */       this.a = param1MathLib;
/*     */     }
/*     */     protected final double a(double param1Double) {
/* 194 */       return this.a.dpow_lib(Math.E, param1Double);
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class fmod extends TwoArgFunction {
/*     */     public final LuaValue call(LuaValue param1LuaValue1, LuaValue param1LuaValue2) {
/* 201 */       if (param1LuaValue1.islong() && param1LuaValue2.islong()) {
/* 202 */         return (LuaValue)valueOf((param1LuaValue1.tolong() % param1LuaValue2.tolong()));
/*     */       }
/* 204 */       return (LuaValue)valueOf(param1LuaValue1.checkdouble() % param1LuaValue2.checkdouble());
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class ldexp
/*     */     extends BinaryOp {
/*     */     protected final double a(double param1Double1, double param1Double2) {
/* 212 */       return param1Double1 * Double.longBitsToDouble((long)param1Double2 + 1023L << 52L);
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class pow extends BinaryOp {
/*     */     protected final double a(double param1Double1, double param1Double2) {
/* 219 */       return MathLib.a(param1Double1, param1Double2);
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class frexp extends VarArgFunction {
/*     */     public Varargs invoke(Varargs param1Varargs) {
/*     */       double d1;
/* 227 */       if ((d1 = param1Varargs.checkdouble(1)) == 0.0D) return varargsOf((LuaValue)ZERO, (Varargs)ZERO); 
/*     */       long l;
/* 229 */       double d2 = (((l = Double.doubleToLongBits(d1)) & 0xFFFFFFFFFFFFFL) + 4503599627370496L) * ((l >= 0L) ? 1.1102230246251565E-16D : -1.1102230246251565E-16D);
/* 230 */       double d3 = (((int)(l >> 52L) & 0x7FF) - 1022);
/* 231 */       return varargsOf((LuaValue)valueOf(d2), (Varargs)valueOf(d3));
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class max extends VarArgFunction {
/*     */     public Varargs invoke(Varargs param1Varargs) {
/* 238 */       LuaValue luaValue = param1Varargs.checkvalue(1); byte b; int i;
/* 239 */       for (b = 2, i = param1Varargs.narg(); b <= i; b++) {
/* 240 */         LuaValue luaValue1 = param1Varargs.checkvalue(b);
/* 241 */         if (luaValue.lt_b(luaValue1)) luaValue = luaValue1; 
/*     */       } 
/* 243 */       return (Varargs)luaValue;
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class min extends VarArgFunction {
/*     */     public Varargs invoke(Varargs param1Varargs) {
/* 250 */       LuaValue luaValue = param1Varargs.checkvalue(1); byte b; int i;
/* 251 */       for (b = 2, i = param1Varargs.narg(); b <= i; b++) {
/*     */         LuaValue luaValue1;
/* 253 */         if ((luaValue1 = param1Varargs.checkvalue(b)).lt_b(luaValue)) luaValue = luaValue1; 
/*     */       } 
/* 255 */       return (Varargs)luaValue;
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class modf
/*     */     extends VarArgFunction {
/*     */     public Varargs invoke(Varargs param1Varargs) {
/*     */       LuaValue luaValue;
/* 264 */       if ((luaValue = param1Varargs.arg1()).islong()) return varargsOf(luaValue, (Varargs)valueOf(0.0D));
/*     */ 
/*     */       
/* 267 */       double d1, d2 = ((d1 = luaValue.checkdouble()) > 0.0D) ? Math.floor(d1) : Math.ceil(d1);
/*     */       
/* 269 */       double d3 = (d1 == d2) ? 0.0D : (d1 - d2);
/* 270 */       return varargsOf((LuaValue)valueOf(d2), (Varargs)valueOf(d3));
/*     */     } }
/*     */   @REGS
/*     */   public static class random extends LibFunction implements KryoSerializable { @NAGS
/*     */     RandomXS128 a;
/*     */     public random() {
/* 276 */       this.a = new RandomXS128();
/*     */     }
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 280 */       param1Kryo.writeObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 285 */       this.a = (RandomXS128)param1Kryo.readObject(param1Input, RandomXS128.class);
/*     */     }
/*     */     
/*     */     public LuaValue call() {
/* 289 */       return (LuaValue)valueOf(this.a.nextDouble());
/*     */     }
/*     */     public LuaValue call(LuaValue param1LuaValue) {
/*     */       int i;
/* 293 */       if ((i = param1LuaValue.checkint()) <= 0) argerror(1, "interval is empty"); 
/* 294 */       return (LuaValue)valueOf(1 + this.a.nextInt(i));
/*     */     }
/*     */     public LuaValue call(LuaValue param1LuaValue1, LuaValue param1LuaValue2) {
/* 297 */       int i = param1LuaValue1.checkint();
/*     */       int j;
/* 299 */       if ((j = param1LuaValue2.checkint()) < i) argerror(2, "interval is empty"); 
/* 300 */       return (LuaValue)valueOf(i + this.a.nextInt(j + 1 - i));
/*     */     } }
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public static class randomseed
/*     */     extends OneArgFunction implements KryoSerializable {
/*     */     private MathLib.random a;
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 310 */       param1Kryo.writeObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 315 */       this.a = (MathLib.random)param1Kryo.readObject(param1Input, MathLib.random.class);
/*     */     }
/*     */     randomseed() {}
/*     */     
/*     */     randomseed(MathLib.random param1random) {
/* 320 */       this.a = param1random;
/*     */     }
/*     */     
/*     */     public LuaValue call(LuaValue param1LuaValue) {
/* 324 */       long l = param1LuaValue.checklong();
/* 325 */       this.a.a = new RandomXS128(l);
/* 326 */       return NONE;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static LuaValue dpow(double paramDouble1, double paramDouble2) {
/* 332 */     return (LuaValue)LuaNumber.valueOf(
/* 333 */         (MATHLIB != null) ? 
/* 334 */         MATHLIB.dpow_lib(paramDouble1, paramDouble2) : 
/* 335 */         a(paramDouble1, paramDouble2));
/*     */   }
/*     */   public static double dpow_d(double paramDouble1, double paramDouble2) {
/* 338 */     if (MATHLIB != null)
/* 339 */       return MATHLIB.dpow_lib(paramDouble1, paramDouble2); 
/* 340 */     return a(paramDouble1, paramDouble2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double dpow_lib(double paramDouble1, double paramDouble2) {
/* 347 */     return a(paramDouble1, paramDouble2);
/*     */   }
/*     */   
/*     */   protected static double a(double paramDouble1, double paramDouble2) {
/*     */     // Byte code:
/*     */     //   0: dload_2
/*     */     //   1: dconst_0
/*     */     //   2: dcmpg
/*     */     //   3: ifge -> 15
/*     */     //   6: dconst_1
/*     */     //   7: dload_0
/*     */     //   8: dload_2
/*     */     //   9: dneg
/*     */     //   10: invokestatic a : (DD)D
/*     */     //   13: ddiv
/*     */     //   14: dreturn
/*     */     //   15: dconst_1
/*     */     //   16: dstore #4
/*     */     //   18: dload_2
/*     */     //   19: d2i
/*     */     //   20: istore #6
/*     */     //   22: dload_0
/*     */     //   23: dstore #7
/*     */     //   25: iload #6
/*     */     //   27: ifle -> 59
/*     */     //   30: iload #6
/*     */     //   32: iconst_1
/*     */     //   33: iand
/*     */     //   34: ifeq -> 44
/*     */     //   37: dload #4
/*     */     //   39: dload #7
/*     */     //   41: dmul
/*     */     //   42: dstore #4
/*     */     //   44: iload #6
/*     */     //   46: iconst_1
/*     */     //   47: ishr
/*     */     //   48: istore #6
/*     */     //   50: dload #7
/*     */     //   52: dup2
/*     */     //   53: dmul
/*     */     //   54: dstore #7
/*     */     //   56: goto -> 25
/*     */     //   59: dload_2
/*     */     //   60: iload #6
/*     */     //   62: i2d
/*     */     //   63: dsub
/*     */     //   64: dup2
/*     */     //   65: dstore_2
/*     */     //   66: dconst_0
/*     */     //   67: dcmpl
/*     */     //   68: ifle -> 115
/*     */     //   71: dload_2
/*     */     //   72: ldc2_w 65536.0
/*     */     //   75: dmul
/*     */     //   76: d2i
/*     */     //   77: istore #7
/*     */     //   79: iload #7
/*     */     //   81: ldc 65535
/*     */     //   83: iand
/*     */     //   84: ifeq -> 115
/*     */     //   87: dload_0
/*     */     //   88: invokestatic sqrt : (D)D
/*     */     //   91: dstore_0
/*     */     //   92: iload #7
/*     */     //   94: ldc 32768
/*     */     //   96: iand
/*     */     //   97: ifeq -> 106
/*     */     //   100: dload #4
/*     */     //   102: dload_0
/*     */     //   103: dmul
/*     */     //   104: dstore #4
/*     */     //   106: iload #7
/*     */     //   108: iconst_1
/*     */     //   109: ishl
/*     */     //   110: istore #7
/*     */     //   112: goto -> 79
/*     */     //   115: dload #4
/*     */     //   117: dreturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #354	-> 0
/*     */     //   #355	-> 6
/*     */     //   #356	-> 15
/*     */     //   #357	-> 18
/*     */     //   #358	-> 22
/*     */     //   #359	-> 30
/*     */     //   #360	-> 37
/*     */     //   #358	-> 44
/*     */     //   #361	-> 59
/*     */     //   #362	-> 71
/*     */     //   #363	-> 79
/*     */     //   #364	-> 87
/*     */     //   #365	-> 92
/*     */     //   #366	-> 100
/*     */     //   #363	-> 106
/*     */     //   #369	-> 115
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\MathLib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */