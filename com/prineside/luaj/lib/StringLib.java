/*      */ package com.prineside.luaj.lib;
/*      */ 
/*      */ import com.esotericsoftware.kryo.Kryo;
/*      */ import com.esotericsoftware.kryo.KryoSerializable;
/*      */ import com.esotericsoftware.kryo.io.Input;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.prineside.luaj.Buffer;
/*      */ import com.prineside.luaj.LuaClosure;
/*      */ import com.prineside.luaj.LuaFunction;
/*      */ import com.prineside.luaj.LuaString;
/*      */ import com.prineside.luaj.LuaTable;
/*      */ import com.prineside.luaj.LuaValue;
/*      */ import com.prineside.luaj.Varargs;
/*      */ import com.prineside.luaj.compiler.DumpState;
/*      */ import com.prineside.luaj.lib.jse.JavaClass;
/*      */ import com.prineside.tdi2.managers.script.ReadOnlyLuaTable;
/*      */ import com.prineside.tdi2.utils.NAGS;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.util.Map;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @REGS
/*      */ public class StringLib
/*      */   extends TwoArgFunction
/*      */ {
/*      */   public LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/*   92 */     LuaTable luaTable = new LuaTable();
/*      */     
/*      */     JavaClass javaClass;
/*      */     
/*      */     Map<?, ?> map;
/*   97 */     for (Map.Entry<?, ?> entry : (map = (javaClass = JavaClass.forClass(String.class)).getInstanceMethods()).entrySet())
/*      */     {
/*   99 */       luaTable.set((LuaValue)entry.getKey(), (LuaValue)new _stringMethodWrapper((LuaValue)entry.getValue(), (byte)0));
/*      */     }
/*  101 */     luaTable.set("byte", (LuaValue)new _byte());
/*  102 */     luaTable.set("char", (LuaValue)new _char());
/*  103 */     luaTable.set("dump", (LuaValue)new dump());
/*  104 */     luaTable.set("find", (LuaValue)new find());
/*  105 */     luaTable.set("format", (LuaValue)new format(this, (byte)0));
/*  106 */     luaTable.set("gmatch", (LuaValue)new gmatch());
/*  107 */     luaTable.set("gsub", (LuaValue)new gsub());
/*  108 */     luaTable.set("len", (LuaValue)new len());
/*  109 */     luaTable.set("lower", (LuaValue)new lower());
/*  110 */     luaTable.set("match", (LuaValue)new match());
/*  111 */     luaTable.set("rep", (LuaValue)new rep());
/*  112 */     luaTable.set("reverse", (LuaValue)new reverse());
/*  113 */     luaTable.set("sub", (LuaValue)new sub());
/*  114 */     luaTable.set("upper", (LuaValue)new upper());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  125 */     paramLuaValue2.set("string", (LuaValue)luaTable);
/*  126 */     if (!paramLuaValue2.get("package").isnil()) paramLuaValue2.get("package").get("loaded").set("string", (LuaValue)luaTable); 
/*  127 */     if (LuaString.s_metatable == null) {
/*  128 */       LuaString.s_metatable = (LuaValue)new ReadOnlyLuaTable((LuaValue)LuaValue.tableOf(new LuaValue[] { (LuaValue)INDEX, (LuaValue)luaTable }));
/*      */     }
/*  130 */     return (LuaValue)luaTable;
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class _stringMethodWrapper extends VarArgFunction {
/*      */     @NAGS
/*      */     private LuaValue a;
/*      */     
/*      */     public final void write(Kryo param1Kryo, Output param1Output) {
/*  139 */       super.write(param1Kryo, param1Output);
/*  140 */       param1Kryo.writeClassAndObject(param1Output, this.a);
/*      */     }
/*      */ 
/*      */     
/*      */     public final void read(Kryo param1Kryo, Input param1Input) {
/*  145 */       super.read(param1Kryo, param1Input);
/*  146 */       this.a = (LuaValue)param1Kryo.readClassAndObject(param1Input);
/*      */     }
/*      */     
/*      */     private _stringMethodWrapper() {}
/*      */     
/*      */     private _stringMethodWrapper(LuaValue param1LuaValue) {
/*  152 */       this.a = param1LuaValue;
/*      */     }
/*      */     
/*      */     public final Varargs invoke(Varargs param1Varargs) {
/*  156 */       return this.a.invoke(LuaValue.varargsOf((LuaValue)LuaValue.userdataOf(param1Varargs.tojstring(1)), param1Varargs.subargs(2)));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public static final class _byte
/*      */     extends VarArgFunction
/*      */   {
/*      */     public final Varargs invoke(Varargs param1Varargs) {
/*      */       LuaString luaString;
/*  174 */       int j = (luaString = param1Varargs.checkstring(1)).m_length;
/*  175 */       int k = StringLib.a(param1Varargs.optint(2, 1), j);
/*  176 */       int i = StringLib.a(param1Varargs.optint(3, k), j);
/*      */       
/*  178 */       if (k <= 0) k = 1; 
/*  179 */       if (i > j) i = j; 
/*  180 */       if (k > i) return (Varargs)NONE; 
/*  181 */       j = i - k + 1;
/*  182 */       if (k + j <= i)
/*  183 */         error("string slice too long"); 
/*  184 */       LuaValue[] arrayOfLuaValue = new LuaValue[j];
/*  185 */       for (i = 0; i < j; i++)
/*  186 */         arrayOfLuaValue[i] = (LuaValue)valueOf(luaString.luaByte(k + i - 1)); 
/*  187 */       return varargsOf(arrayOfLuaValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public static final class _char
/*      */     extends VarArgFunction
/*      */   {
/*      */     public final Varargs invoke(Varargs param1Varargs) {
/*      */       int i;
/*  205 */       byte[] arrayOfByte = new byte[i = param1Varargs.narg()];
/*  206 */       for (byte b1 = 0, b2 = 1; b1 < i; b1++, b2++) {
/*      */         int j;
/*  208 */         if ((j = param1Varargs.checkint(b2)) < 0 || j >= 256) argerror(b2, "invalid value for string.char [0; 255]: " + j); 
/*  209 */         arrayOfByte[b1] = (byte)j;
/*      */       } 
/*  211 */       return (Varargs)LuaString.valueUsing(arrayOfByte);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public static final class dump
/*      */     extends VarArgFunction
/*      */   {
/*      */     public final Varargs invoke(Varargs param1Varargs) {
/*  228 */       LuaFunction luaFunction = param1Varargs.checkfunction(1);
/*  229 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*      */       try {
/*  231 */         DumpState.dump(((LuaClosure)luaFunction).p, byteArrayOutputStream, param1Varargs.optboolean(2, true));
/*  232 */         return (Varargs)LuaString.valueUsing(byteArrayOutputStream.toByteArray());
/*  233 */       } catch (IOException iOException) {
/*  234 */         return (Varargs)error((param1Varargs = null).getMessage());
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public static final class find
/*      */     extends VarArgFunction
/*      */   {
/*      */     public final Varargs invoke(Varargs param1Varargs) {
/*  258 */       return StringLib.a(param1Varargs, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public static final class format
/*      */     extends VarArgFunction
/*      */     implements KryoSerializable
/*      */   {
/*      */     private StringLib a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void write(Kryo param1Kryo, Output param1Output) {
/*  291 */       param1Kryo.writeObject(param1Output, this.a);
/*      */     }
/*      */ 
/*      */     
/*      */     public final void read(Kryo param1Kryo, Input param1Input) {
/*  296 */       this.a = (StringLib)param1Kryo.readObject(param1Input, StringLib.class);
/*      */     }
/*      */ 
/*      */     
/*      */     private format() {}
/*      */ 
/*      */     
/*      */     private format(StringLib param1StringLib) {
/*  304 */       this.a = param1StringLib;
/*      */     }
/*      */     
/*      */     public final Varargs invoke(Varargs param1Varargs) {
/*      */       LuaString luaString;
/*  309 */       int i = (luaString = param1Varargs.checkstring(1)).length();
/*  310 */       Buffer buffer = new Buffer(i);
/*  311 */       byte b = 1;
/*      */ 
/*      */       
/*  314 */       for (int j = 0; j < i;) {
/*  315 */         switch (k = luaString.luaByte(j++)) {
/*      */           case 10:
/*  317 */             buffer.append("\n");
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case 37:
/*  323 */             if (j < i) {
/*  324 */               LuaString luaString1; if (luaString.luaByte(j) == 37) {
/*  325 */                 j++;
/*  326 */                 buffer.append((byte)37); break;
/*      */               } 
/*  328 */               b++;
/*  329 */               StringLib.FormatDesc formatDesc = new StringLib.FormatDesc(param1Varargs, luaString, j, this.a);
/*  330 */               j += formatDesc.length;
/*  331 */               switch (formatDesc.conversion) {
/*      */                 case 99:
/*  333 */                   formatDesc.format(buffer, (byte)param1Varargs.checkint(b));
/*      */                   break;
/*      */                 case 100:
/*      */                 case 105:
/*  337 */                   formatDesc.format(buffer, param1Varargs.checklong(b));
/*      */                   break;
/*      */                 case 88:
/*      */                 case 111:
/*      */                 case 117:
/*      */                 case 120:
/*  343 */                   formatDesc.format(buffer, param1Varargs.checklong(b));
/*      */                   break;
/*      */                 case 69:
/*      */                 case 71:
/*      */                 case 101:
/*      */                 case 102:
/*      */                 case 103:
/*  350 */                   formatDesc.format(buffer, param1Varargs.checkdouble(b));
/*      */                   break;
/*      */                 case 113:
/*  353 */                   StringLib.a(buffer, param1Varargs.checkstring(b));
/*      */                   break;
/*      */                 case 115:
/*  356 */                   luaString1 = param1Varargs.checkstring(b);
/*  357 */                   if (formatDesc.a == -1 && luaString1.length() >= 100) {
/*  358 */                     buffer.append(luaString1); break;
/*      */                   } 
/*  360 */                   formatDesc.format(buffer, luaString1);
/*      */                   break;
/*      */               } 
/*      */               
/*  364 */               error("invalid option '%" + (char)formatDesc.conversion + "' to 'format'");
/*      */             } 
/*      */             break;
/*      */         } 
/*      */ 
/*      */ 
/*      */       
/*      */       } 
/*  372 */       return (Varargs)buffer.tostring();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   static void a(Buffer paramBuffer, LuaString paramLuaString) {
/*  378 */     paramBuffer.append((byte)34); byte b; int i;
/*  379 */     for (b = 0, i = paramLuaString.length(); b < i; b++) {
/*  380 */       int j; switch (j = paramLuaString.luaByte(b)) { case 10: case 34:
/*      */         case 92:
/*  382 */           paramBuffer.append((byte)92);
/*  383 */           paramBuffer.append((byte)j);
/*      */           break;
/*      */         default:
/*  386 */           if (j <= 31 || j == 127) {
/*  387 */             paramBuffer.append((byte)92);
/*  388 */             if (b + 1 == i || paramLuaString.luaByte(b + 1) < 48 || paramLuaString.luaByte(b + 1) > 57) {
/*  389 */               paramBuffer.append(Integer.toString(j)); break;
/*      */             } 
/*  391 */             paramBuffer.append((byte)48);
/*  392 */             paramBuffer.append((byte)(48 + j / 10));
/*  393 */             paramBuffer.append((byte)(48 + j % 10));
/*      */             break;
/*      */           } 
/*  396 */           paramBuffer.append((byte)j);
/*      */           break; }
/*      */ 
/*      */     
/*      */     } 
/*  401 */     paramBuffer.append((byte)34);
/*      */   }
/*      */ 
/*      */   
/*      */   static class FormatDesc
/*      */   {
/*      */     private boolean b;
/*      */     
/*      */     private boolean c;
/*      */     
/*      */     private boolean d;
/*      */     
/*      */     private boolean e;
/*      */     
/*      */     private int f;
/*      */     
/*      */     int a;
/*      */     
/*      */     public final int conversion;
/*      */     
/*      */     public final int length;
/*      */     public final String src;
/*      */     private StringLib g;
/*      */     
/*      */     public FormatDesc(Varargs param1Varargs, LuaString param1LuaString, int param1Int, StringLib param1StringLib) {
/*  426 */       this.g = param1StringLib;
/*      */       
/*  428 */       int i = param1Int, j = param1LuaString.length();
/*  429 */       byte b = 0;
/*      */       
/*  431 */       boolean bool = true;
/*  432 */       while (bool) {
/*  433 */         switch (b = (i < j) ? param1LuaString.luaByte(i++) : 0) { case true:
/*  434 */             this.b = true; continue;
/*  435 */           case true: this.d = true; continue;
/*  436 */           case true: this.e = true; continue;
/*      */           case true: continue;
/*  438 */           case true: this.c = true; continue; }
/*  439 */          bool = false;
/*      */       } 
/*      */       
/*  442 */       if (i - param1Int > 5) {
/*  443 */         LuaValue.error("invalid format (repeated flags)");
/*      */       }
/*  445 */       this.f = -1;
/*  446 */       if (Character.isDigit((char)b)) {
/*  447 */         this.f = b - 48;
/*      */         
/*  449 */         if (Character.isDigit((char)(b = (i < j) ? param1LuaString.luaByte(i++) : 0))) {
/*  450 */           this.f = this.f * 10 + b - 48;
/*  451 */           b = (i < j) ? param1LuaString.luaByte(i++) : 0;
/*      */         } 
/*      */       } 
/*      */       
/*  455 */       this.a = -1;
/*  456 */       if (b == 46)
/*      */       {
/*  458 */         if (Character.isDigit((char)(b = (i < j) ? param1LuaString.luaByte(i++) : 0))) {
/*  459 */           this.a = b - 48;
/*      */           
/*  461 */           if (Character.isDigit((char)(b = (i < j) ? param1LuaString.luaByte(i++) : 0))) {
/*  462 */             this.a = this.a * 10 + b - 48;
/*  463 */             b = (i < j) ? param1LuaString.luaByte(i++) : 0;
/*      */           } 
/*      */         } 
/*      */       }
/*      */       
/*  468 */       if (Character.isDigit((char)b)) {
/*  469 */         LuaValue.error("invalid format (width or precision too long)");
/*      */       }
/*  471 */       this.c &= !this.b ? 1 : 0;
/*  472 */       this.conversion = b;
/*  473 */       this.length = i - param1Int;
/*  474 */       this.src = param1LuaString.substring(param1Int - 1, i).tojstring();
/*      */     }
/*      */     
/*      */     public void format(Buffer param1Buffer, byte param1Byte) {
/*  478 */       param1Buffer.append(param1Byte);
/*      */     }
/*      */ 
/*      */     
/*      */     public void format(Buffer param1Buffer, long param1Long) {
/*      */       String str;
/*  484 */       if (param1Long == 0L && this.a == 0) {
/*  485 */         str = "";
/*      */       } else {
/*      */         byte b;
/*  488 */         switch (this.conversion) {
/*      */           case 88:
/*      */           case 120:
/*  491 */             b = 16;
/*      */             break;
/*      */           case 111:
/*  494 */             b = 8;
/*      */             break;
/*      */           default:
/*  497 */             b = 10;
/*      */             break;
/*      */         } 
/*  500 */         str = Long.toString(param1Long, b);
/*  501 */         if (this.conversion == 88) {
/*  502 */           str = str.toUpperCase();
/*      */         }
/*      */       } 
/*      */       
/*  506 */       int i = str.length(), j = i;
/*      */ 
/*      */       
/*  509 */       if (param1Long < 0L) {
/*  510 */         j--;
/*  511 */       } else if (this.d || this.e) {
/*  512 */         i++;
/*      */       } 
/*      */       
/*  515 */       if (this.a > j) {
/*  516 */         j = this.a - j;
/*  517 */       } else if (this.a == -1 && this.c && this.f > i) {
/*  518 */         j = this.f - i;
/*      */       } else {
/*  520 */         j = 0;
/*      */       } 
/*  522 */       i += j;
/*  523 */       i = (this.f > i) ? (this.f - i) : 0;
/*      */       
/*  525 */       if (!this.b) {
/*  526 */         pad(param1Buffer, ' ', i);
/*      */       }
/*  528 */       if (param1Long < 0L) {
/*  529 */         if (j > 0) {
/*  530 */           param1Buffer.append((byte)45);
/*  531 */           str = str.substring(1);
/*      */         } 
/*  533 */       } else if (this.d) {
/*  534 */         param1Buffer.append((byte)43);
/*  535 */       } else if (this.e) {
/*  536 */         param1Buffer.append((byte)32);
/*      */       } 
/*      */       
/*  539 */       if (j > 0) {
/*  540 */         pad(param1Buffer, '0', j);
/*      */       }
/*  542 */       param1Buffer.append(str);
/*      */       
/*  544 */       if (this.b)
/*  545 */         pad(param1Buffer, ' ', i); 
/*      */     }
/*      */     
/*      */     public void format(Buffer param1Buffer, double param1Double) {
/*  549 */       param1Buffer.append(this.g.a(this.src, param1Double));
/*      */     }
/*      */     
/*      */     public void format(Buffer param1Buffer, LuaString param1LuaString) {
/*      */       int i;
/*  554 */       if ((i = param1LuaString.indexOf((byte)0, 0)) != -1)
/*  555 */         param1LuaString = param1LuaString.substring(0, i); 
/*  556 */       param1Buffer.append(param1LuaString);
/*      */     }
/*      */     
/*      */     public final void pad(Buffer param1Buffer, char param1Char, int param1Int) {
/*  560 */       byte b = (byte)param1Char;
/*  561 */       while (param1Int-- > 0)
/*  562 */         param1Buffer.append(b); 
/*      */     }
/*      */   }
/*      */   
/*      */   protected String a(String paramString, double paramDouble) {
/*  567 */     return String.valueOf(paramDouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public static final class gmatch
/*      */     extends VarArgFunction
/*      */   {
/*      */     public final Varargs invoke(Varargs param1Varargs) {
/*  597 */       LuaString luaString1 = param1Varargs.checkstring(1);
/*  598 */       LuaString luaString2 = param1Varargs.checkstring(2);
/*  599 */       return (Varargs)new StringLib.GMatchAux(param1Varargs, luaString1, luaString2);
/*      */     } }
/*      */   
/*      */   static class GMatchAux extends VarArgFunction {
/*      */     private final int a;
/*      */     private final StringLib.MatchState b;
/*      */     private int e;
/*      */     private int f;
/*      */     
/*      */     public GMatchAux(Varargs param1Varargs, LuaString param1LuaString1, LuaString param1LuaString2) {
/*  609 */       this.a = param1LuaString1.length();
/*  610 */       this.b = new StringLib.MatchState(param1Varargs, param1LuaString1, param1LuaString2);
/*  611 */       this.e = 0;
/*  612 */       this.f = -1;
/*      */     }
/*      */     public Varargs invoke(Varargs param1Varargs) {
/*  615 */       for (; this.e <= this.a; this.e++) {
/*  616 */         this.b.a();
/*      */         int i;
/*  618 */         if ((i = this.b.a(this.e, 0)) >= 0 && i != this.f) {
/*  619 */           int j = this.e;
/*  620 */           this.f = this.e = i;
/*  621 */           return this.b.a(true, j, i);
/*      */         } 
/*      */       } 
/*  624 */       return (Varargs)NIL;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public static final class gsub
/*      */     extends VarArgFunction
/*      */   {
/*      */     public final Varargs invoke(Varargs param1Varargs) {
/*      */       LuaString luaString1;
/*  678 */       int i = (luaString1 = param1Varargs.checkstring(1)).length();
/*  679 */       LuaString luaString2 = param1Varargs.checkstring(2);
/*  680 */       int k = -1;
/*  681 */       LuaValue luaValue = param1Varargs.arg(3);
/*  682 */       int m = param1Varargs.optint(4, i + 1);
/*  683 */       boolean bool = (luaString2.length() > 0 && luaString2.charAt(0) == 94) ? true : false;
/*      */       
/*  685 */       Buffer buffer = new Buffer(i);
/*  686 */       StringLib.MatchState matchState = new StringLib.MatchState(param1Varargs, luaString1, luaString2);
/*      */       
/*  688 */       int j = 0;
/*  689 */       byte b = 0;
/*  690 */       while (b < m) {
/*  691 */         matchState.a();
/*      */         int n;
/*  693 */         if ((n = matchState.a(j, bool ? 1 : 0)) != -1 && n != k)
/*  694 */         { b++;
/*  695 */           matchState.add_value(buffer, j, n, luaValue);
/*  696 */           j = k = n; }
/*      */         
/*  698 */         else if (j < i)
/*  699 */         { buffer.append((byte)luaString1.luaByte(j++)); }
/*      */         else { break; }
/*  701 */          if (!bool);
/*      */       } 
/*  703 */       buffer.append(luaString1.substring(j, i));
/*  704 */       return varargsOf((LuaValue)buffer.tostring(), (Varargs)valueOf(b));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public static final class len
/*      */     extends OneArgFunction
/*      */   {
/*      */     public final LuaValue call(LuaValue param1LuaValue) {
/*  717 */       return param1LuaValue.checkstring().len();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public static final class lower
/*      */     extends OneArgFunction
/*      */   {
/*      */     public final LuaValue call(LuaValue param1LuaValue) {
/*  731 */       return (LuaValue)valueOf(param1LuaValue.checkjstring().toLowerCase());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public static final class match
/*      */     extends VarArgFunction
/*      */   {
/*      */     public final Varargs invoke(Varargs param1Varargs) {
/*  747 */       return StringLib.a(param1Varargs, false);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public static final class rep
/*      */     extends VarArgFunction
/*      */   {
/*      */     public final Varargs invoke(Varargs param1Varargs) {
/*  759 */       LuaString luaString = param1Varargs.checkstring(1);
/*  760 */       int i = param1Varargs.checkint(2);
/*  761 */       byte[] arrayOfByte = new byte[luaString.length() * i];
/*  762 */       int j = luaString.length(); int k;
/*  763 */       for (k = 0; k < arrayOfByte.length; k += j) {
/*  764 */         luaString.copyInto(0, arrayOfByte, k, j);
/*      */       }
/*  766 */       return (Varargs)LuaString.valueUsing(arrayOfByte);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public static final class reverse
/*      */     extends OneArgFunction
/*      */   {
/*      */     public final LuaValue call(LuaValue param1LuaValue) {
/*      */       LuaString luaString;
/*      */       int i;
/*  780 */       byte[] arrayOfByte = new byte[i = (luaString = param1LuaValue.checkstring()).length()]; byte b; int j;
/*  781 */       for (b = 0, j = i - 1; b < i; b++, j--)
/*  782 */         arrayOfByte[j] = (byte)luaString.luaByte(b); 
/*  783 */       return (LuaValue)LuaString.valueUsing(arrayOfByte);
/*      */     }
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class trim extends OneArgFunction {
/*      */     public final LuaValue call(LuaValue param1LuaValue) {
/*  790 */       return (LuaValue)LuaString.valueOf(param1LuaValue.checkjstring().trim());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public static final class sub
/*      */     extends VarArgFunction
/*      */   {
/*      */     public final Varargs invoke(Varargs param1Varargs) {
/*      */       LuaString luaString;
/*  809 */       int j = (luaString = param1Varargs.checkstring(1)).length();
/*      */       
/*  811 */       int k = StringLib.a(param1Varargs.checkint(2), j);
/*  812 */       int i = StringLib.a(param1Varargs.optint(3, -1), j);
/*      */       
/*  814 */       if (k <= 0)
/*  815 */         k = 1; 
/*  816 */       if (i > j) {
/*  817 */         i = j;
/*      */       }
/*  819 */       if (k <= i) {
/*  820 */         return (Varargs)luaString.substring(k - 1, i);
/*      */       }
/*  822 */       return (Varargs)EMPTYSTRING;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public static final class upper
/*      */     extends OneArgFunction
/*      */   {
/*      */     public final LuaValue call(LuaValue param1LuaValue) {
/*  837 */       return (LuaValue)valueOf(param1LuaValue.checkjstring().toUpperCase());
/*      */     }
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class split
/*      */     extends VarArgFunction {
/*      */     public final Varargs invoke(Varargs param1Varargs) {
/*  845 */       LuaString luaString1 = param1Varargs.checkstring(1);
/*  846 */       LuaString luaString2 = param1Varargs.checkstring(2);
/*  847 */       if (param1Varargs.narg() == 2) {
/*  848 */         return (Varargs)LuaValue.cObject(luaString1.checkjstring().split(luaString2.checkjstring()));
/*      */       }
/*  850 */       return (Varargs)LuaValue.cObject(luaString1.checkjstring().split(luaString2.checkjstring(), param1Varargs.checkint(3)));
/*      */     }
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class contains
/*      */     extends VarArgFunction
/*      */   {
/*      */     public final Varargs invoke(Varargs param1Varargs) {
/*  859 */       return (Varargs)(param1Varargs.checkjstring(1).contains(param1Varargs.checkjstring(2)) ? LuaValue.TRUE : LuaValue.FALSE);
/*      */     }
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class replace
/*      */     extends VarArgFunction {
/*      */     public final Varargs invoke(Varargs param1Varargs) {
/*  867 */       return (Varargs)LuaString.valueOf(param1Varargs
/*  868 */           .checkjstring(1)
/*  869 */           .replace(param1Varargs.checkjstring(2), param1Varargs.checkjstring(3)));
/*      */     }
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class replaceAll
/*      */     extends VarArgFunction
/*      */   {
/*      */     public final Varargs invoke(Varargs param1Varargs) {
/*  878 */       return (Varargs)LuaString.valueOf(param1Varargs
/*  879 */           .checkjstring(1)
/*  880 */           .replaceAll(param1Varargs.checkjstring(2), param1Varargs.checkjstring(3)));
/*      */     }
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class endsWith
/*      */     extends VarArgFunction
/*      */   {
/*      */     public final Varargs invoke(Varargs param1Varargs) {
/*  889 */       return (Varargs)(param1Varargs.checkjstring(1).endsWith(param1Varargs.checkjstring(2)) ? LuaValue.TRUE : LuaValue.FALSE);
/*      */     }
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class startsWith
/*      */     extends VarArgFunction {
/*      */     public final Varargs invoke(Varargs param1Varargs) {
/*  897 */       return (Varargs)(param1Varargs.checkjstring(1).startsWith(param1Varargs.checkjstring(2)) ? LuaValue.TRUE : LuaValue.FALSE);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static Varargs a(Varargs paramVarargs, boolean paramBoolean) {
/*      */     int i;
/*  905 */     LuaString luaString1 = paramVarargs.checkstring(1);
/*  906 */     LuaString luaString2 = paramVarargs.checkstring(2);
/*      */     
/*      */     int j;
/*  909 */     if ((j = paramVarargs.optint(3, 1)) > 0) {
/*  910 */       j = Math.min(j - 1, luaString1.length());
/*  911 */     } else if (j < 0) {
/*  912 */       j = Math.max(0, luaString1.length() + j);
/*      */     } 
/*      */     
/*      */     boolean bool;
/*      */     
/*  917 */     if (bool = (paramBoolean && (paramVarargs.arg(4).toboolean() || luaString2.indexOfAny(b) == -1)) ? true : false) {
/*      */       
/*  919 */       if ((i = luaString1.indexOf(luaString2, j)) != -1) {
/*  920 */         return varargsOf((LuaValue)valueOf(i + 1), (Varargs)valueOf(i + luaString2.length()));
/*      */       }
/*      */     } else {
/*  923 */       MatchState matchState = new MatchState(i, luaString1, luaString2);
/*      */       
/*  925 */       bool = false;
/*  926 */       boolean bool1 = false;
/*  927 */       if (luaString2.length() > 0 && luaString2.luaByte(0) == 94) {
/*  928 */         bool = true;
/*  929 */         bool1 = true;
/*      */       } 
/*      */       
/*  932 */       int k = j;
/*      */       
/*      */       do {
/*  935 */         matchState.a();
/*  936 */         if ((j = matchState.a(k, bool1)) != -1) {
/*  937 */           if (paramBoolean) {
/*  938 */             return LuaValue.varargsOf((LuaValue)valueOf(k + 1), (LuaValue)valueOf(j), matchState.a(false, k, j));
/*      */           }
/*  940 */           return matchState.a(true, k, j);
/*      */         }
/*      */       
/*  943 */       } while (k++ < luaString1.length() && !bool);
/*      */     } 
/*  945 */     return (Varargs)NIL;
/*      */   }
/*      */   
/*      */   static int a(int paramInt1, int paramInt2) {
/*  949 */     return (paramInt1 >= 0) ? paramInt1 : (paramInt2 + paramInt1 + 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  955 */   private static final LuaString b = valueOf("^$*+?.([%-");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  975 */   static final byte[] a = new byte[256];
/*      */   static {
/*  977 */     for (byte b = 0; b < ''; b++) {
/*  978 */       char c = (char)b;
/*  979 */       a[b] = 
/*      */ 
/*      */         
/*  982 */         (byte)((Character.isDigit(c) ? true : false) | (Character.isLowerCase(c) ? true : false) | (Character.isUpperCase(c) ? 4 : 0) | ((c < ' ' || c == '') ? 64 : 0));
/*  983 */       if ((c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') || (c >= '0' && c <= '9')) {
/*  984 */         a[b] = (byte)(a[b] | Byte.MIN_VALUE);
/*      */       }
/*  986 */       if ((c >= '!' && c <= '/') || (c >= ':' && c <= '@') || (c >= '[' && c <= '`') || (c >= '{' && c <= '~')) {
/*  987 */         a[b] = (byte)(a[b] | 0x10);
/*      */       }
/*  989 */       if ((a[b] & 0x6) != 0) {
/*  990 */         a[b] = (byte)(a[b] | 0x1);
/*      */       }
/*      */     } 
/*      */     
/*  994 */     a[32] = 32;
/*  995 */     a[13] = (byte)(a[13] | 0x20);
/*  996 */     a[10] = (byte)(a[10] | 0x20);
/*  997 */     a[9] = (byte)(a[9] | 0x20);
/*  998 */     a[11] = (byte)(a[11] | 0x20);
/*  999 */     a[12] = (byte)(a[12] | 0x20);
/*      */   }
/*      */   
/*      */   static class MatchState
/*      */   {
/*      */     private int a;
/*      */     private LuaString b;
/*      */     private LuaString c;
/*      */     private int d;
/*      */     private int[] e;
/*      */     private int[] f;
/*      */     
/*      */     MatchState(Varargs param1Varargs, LuaString param1LuaString1, LuaString param1LuaString2) {
/* 1012 */       this.b = param1LuaString1;
/* 1013 */       this.c = param1LuaString2;
/*      */       
/* 1015 */       this.d = 0;
/* 1016 */       this.e = new int[32];
/* 1017 */       this.f = new int[32];
/* 1018 */       this.a = 200;
/*      */     }
/*      */     
/*      */     final void a() {
/* 1022 */       this.d = 0;
/* 1023 */       this.a = 200;
/*      */     }
/*      */     
/*      */     private void a(Buffer param1Buffer, LuaString param1LuaString, int param1Int1, int param1Int2) {
/* 1027 */       int i = param1LuaString.length();
/* 1028 */       for (byte b = 0; b < i; b++) {
/*      */         byte b1;
/* 1030 */         if ((b1 = (byte)param1LuaString.luaByte(b)) != 37) {
/* 1031 */           param1Buffer.append(b1);
/*      */         } else {
/* 1033 */           b++;
/*      */           
/* 1035 */           if (!Character.isDigit((char)(b1 = (byte)((b < i) ? param1LuaString.luaByte(b) : 0)))) {
/* 1036 */             if (b1 != 37) LuaValue.error("invalid use of '%' in replacement string: after '%' must be '0'-'9' or '%', but found " + (
/*      */ 
/*      */                   
/* 1039 */                   (b < i) ? (
/* 1040 */                   "symbol '" + (char)b1 + "' with code " + b1 + " at pos " + (b + 1)) : 
/* 1041 */                   "end of string")); 
/* 1042 */             param1Buffer.append(b1);
/* 1043 */           } else if (b1 == 48) {
/* 1044 */             param1Buffer.append(this.b.substring(param1Int1, param1Int2));
/*      */           } else {
/* 1046 */             param1Buffer.append(a(b1 - 49, param1Int1, param1Int2).strvalue());
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */     public void add_value(Buffer param1Buffer, int param1Int1, int param1Int2, LuaValue param1LuaValue) {
/*      */       LuaString luaString;
/* 1053 */       switch (param1LuaValue.type()) {
/*      */         case 3:
/*      */         case 4:
/* 1056 */           a(param1Buffer, param1LuaValue.strvalue(), param1Int1, param1Int2);
/*      */           return;
/*      */         
/*      */         case 6:
/* 1060 */           param1LuaValue = param1LuaValue.invoke(a(true, param1Int1, param1Int2)).arg1();
/*      */           break;
/*      */ 
/*      */         
/*      */         case 5:
/* 1065 */           param1LuaValue = param1LuaValue.get(a(0, param1Int1, param1Int2));
/*      */           break;
/*      */         
/*      */         default:
/* 1069 */           LuaValue.error("bad argument: string/function/table expected");
/*      */           return;
/*      */       } 
/*      */       
/* 1073 */       if (!param1LuaValue.toboolean()) {
/* 1074 */         luaString = this.b.substring(param1Int1, param1Int2);
/* 1075 */       } else if (!luaString.isstring()) {
/* 1076 */         LuaValue.error("invalid replacement value (a " + luaString.typename() + ")");
/*      */       } 
/* 1078 */       param1Buffer.append(luaString.strvalue());
/*      */     }
/*      */ 
/*      */     
/*      */     final Varargs a(boolean param1Boolean, int param1Int1, int param1Int2) {
/* 1083 */       switch (param1Boolean = (this.d == 0 && param1Boolean) ? true : this.d) { case false:
/* 1084 */           return (Varargs)LuaValue.NONE;
/* 1085 */         case true: return (Varargs)a(0, param1Int1, param1Int2); }
/*      */       
/* 1087 */       LuaValue[] arrayOfLuaValue = new LuaValue[param1Boolean];
/* 1088 */       for (byte b = 0; b < param1Boolean; b++)
/* 1089 */         arrayOfLuaValue[b] = a(b, param1Int1, param1Int2); 
/* 1090 */       return LuaValue.varargsOf(arrayOfLuaValue);
/*      */     }
/*      */     
/*      */     private LuaValue a(int param1Int1, int param1Int2, int param1Int3) {
/* 1094 */       if (param1Int1 >= this.d) {
/* 1095 */         if (param1Int1 == 0) {
/* 1096 */           return (LuaValue)this.b.substring(param1Int2, param1Int3);
/*      */         }
/* 1098 */         return LuaValue.error("invalid capture index %" + (param1Int1 + 1));
/*      */       } 
/*      */ 
/*      */       
/* 1102 */       if ((param1Int2 = this.f[param1Int1]) == -1) {
/* 1103 */         return LuaValue.error("unfinished capture");
/*      */       }
/* 1105 */       if (param1Int2 == -2) {
/* 1106 */         return (LuaValue)LuaValue.valueOf(this.e[param1Int1] + 1);
/*      */       }
/* 1108 */       param1Int1 = this.e[param1Int1];
/* 1109 */       return (LuaValue)this.b.substring(param1Int1, param1Int1 + param1Int2);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private int a(int param1Int) {
/* 1115 */       param1Int -= 49;
/* 1116 */       if (param1Int < 0 || param1Int >= this.d || this.f[param1Int] == -1) {
/* 1117 */         LuaValue.error("invalid capture index %" + (param1Int + 1));
/*      */       }
/* 1119 */       return param1Int;
/*      */     }
/*      */     
/*      */     private int b() {
/* 1123 */       int i = this.d;
/* 1124 */       for (; --i >= 0; i--) {
/* 1125 */         if (this.f[i] == -1)
/* 1126 */           return i; 
/* 1127 */       }  LuaValue.error("invalid pattern capture");
/* 1128 */       return 0;
/*      */     }
/*      */     
/*      */     private int b(int param1Int) {
/* 1132 */       switch (this.c.luaByte(param1Int++)) {
/*      */         case 37:
/* 1134 */           if (param1Int == this.c.length()) {
/* 1135 */             LuaValue.error("malformed pattern (ends with '%')");
/*      */           }
/* 1137 */           return param1Int + 1;
/*      */         
/*      */         case 91:
/* 1140 */           if (param1Int != this.c.length() && this.c.luaByte(param1Int) == 94) param1Int++; 
/*      */           while (true) {
/* 1142 */             if (param1Int == this.c.length()) {
/* 1143 */               LuaValue.error("malformed pattern (missing ']')");
/*      */             }
/* 1145 */             if (this.c.luaByte(param1Int++) == 37 && param1Int < this.c.length())
/* 1146 */               param1Int++; 
/* 1147 */             if (param1Int != this.c.length() && this.c.luaByte(param1Int) == 93)
/* 1148 */               return param1Int + 1; 
/*      */           } 
/* 1150 */       }  return param1Int;
/*      */     }
/*      */ 
/*      */     
/*      */     private static boolean b(int param1Int1, int param1Int2) {
/* 1155 */       char c = Character.toLowerCase((char)param1Int2);
/* 1156 */       byte b = StringLib.a[param1Int1];
/*      */ 
/*      */       
/* 1159 */       switch (c) { case 'a':
/* 1160 */           param1Int1 = ((b & 0x1) != 0) ? 1 : 0; break;
/* 1161 */         case 'd': param1Int1 = ((b & 0x8) != 0) ? 1 : 0; break;
/* 1162 */         case 'l': param1Int1 = ((b & 0x2) != 0) ? 1 : 0; break;
/* 1163 */         case 'u': param1Int1 = ((b & 0x4) != 0) ? 1 : 0; break;
/* 1164 */         case 'c': param1Int1 = ((b & 0x40) != 0) ? 1 : 0; break;
/* 1165 */         case 'p': param1Int1 = ((b & 0x10) != 0) ? 1 : 0; break;
/* 1166 */         case 's': param1Int1 = ((b & 0x20) != 0) ? 1 : 0; break;
/* 1167 */         case 'g': param1Int1 = ((b & 0x19) != 0) ? 1 : 0; break;
/* 1168 */         case 'w': param1Int1 = ((b & 0x9) != 0) ? 1 : 0; break;
/* 1169 */         case 'x': param1Int1 = ((b & Byte.MIN_VALUE) != 0) ? 1 : 0; break;
/* 1170 */         case 'z': param1Int1 = (param1Int1 == 0) ? 1 : 0; break;
/* 1171 */         default: return (param1Int2 == param1Int1); }
/*      */       
/* 1173 */       return (c == param1Int2) ? param1Int1 : ((param1Int1 == 0));
/*      */     }
/*      */     
/*      */     private boolean b(int param1Int1, int param1Int2, int param1Int3) {
/* 1177 */       boolean bool = true;
/* 1178 */       if (this.c.luaByte(param1Int2 + 1) == 94) {
/* 1179 */         bool = false;
/* 1180 */         param1Int2++;
/*      */       } 
/* 1182 */       while (++param1Int2 < param1Int3) {
/* 1183 */         if (this.c.luaByte(param1Int2) == 37) {
/* 1184 */           param1Int2++;
/* 1185 */           if (b(param1Int1, this.c.luaByte(param1Int2)))
/* 1186 */             return bool;  continue;
/*      */         } 
/* 1188 */         if (this.c.luaByte(param1Int2 + 1) == 45 && param1Int2 + 2 < param1Int3) {
/* 1189 */           param1Int2 += 2;
/* 1190 */           if (this.c.luaByte(param1Int2 - 2) <= param1Int1 && param1Int1 <= this.c.luaByte(param1Int2))
/* 1191 */             return bool;  continue;
/*      */         } 
/* 1193 */         if (this.c.luaByte(param1Int2) == param1Int1) return bool; 
/*      */       } 
/* 1195 */       return !bool;
/*      */     }
/*      */     
/*      */     private boolean c(int param1Int1, int param1Int2, int param1Int3) {
/* 1199 */       switch (this.c.luaByte(param1Int2)) { case 46:
/* 1200 */           return true;
/* 1201 */         case 37: return b(param1Int1, this.c.luaByte(param1Int2 + 1));
/* 1202 */         case 91: return b(param1Int1, param1Int2, param1Int3 - 1); }
/* 1203 */        return (this.c.luaByte(param1Int2) == param1Int1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final int a(int param1Int1, int param1Int2) {
/*      */       // Byte code:
/*      */       //   0: aload_0
/*      */       //   1: dup
/*      */       //   2: getfield a : I
/*      */       //   5: dup_x1
/*      */       //   6: iconst_1
/*      */       //   7: isub
/*      */       //   8: putfield a : I
/*      */       //   11: ifne -> 20
/*      */       //   14: ldc 'pattern too complex'
/*      */       //   16: invokestatic error : (Ljava/lang/String;)Lcom/prineside/luaj/LuaValue;
/*      */       //   19: pop
/*      */       //   20: iload_2
/*      */       //   21: aload_0
/*      */       //   22: getfield c : Lcom/prineside/luaj/LuaString;
/*      */       //   25: invokevirtual length : ()I
/*      */       //   28: if_icmpne -> 45
/*      */       //   31: iload_1
/*      */       //   32: istore_3
/*      */       //   33: aload_0
/*      */       //   34: dup
/*      */       //   35: getfield a : I
/*      */       //   38: iconst_1
/*      */       //   39: iadd
/*      */       //   40: putfield a : I
/*      */       //   43: iload_3
/*      */       //   44: ireturn
/*      */       //   45: aload_0
/*      */       //   46: getfield c : Lcom/prineside/luaj/LuaString;
/*      */       //   49: iload_2
/*      */       //   50: invokevirtual luaByte : (I)I
/*      */       //   53: tableswitch default -> 507, 36 -> 465, 37 -> 183, 38 -> 507, 39 -> 507, 40 -> 92, 41 -> 162
/*      */       //   92: iinc #2, 1
/*      */       //   95: iload_2
/*      */       //   96: aload_0
/*      */       //   97: getfield c : Lcom/prineside/luaj/LuaString;
/*      */       //   100: invokevirtual length : ()I
/*      */       //   103: if_icmpge -> 142
/*      */       //   106: aload_0
/*      */       //   107: getfield c : Lcom/prineside/luaj/LuaString;
/*      */       //   110: iload_2
/*      */       //   111: invokevirtual luaByte : (I)I
/*      */       //   114: bipush #41
/*      */       //   116: if_icmpne -> 142
/*      */       //   119: aload_0
/*      */       //   120: iload_1
/*      */       //   121: iload_2
/*      */       //   122: iconst_1
/*      */       //   123: iadd
/*      */       //   124: bipush #-2
/*      */       //   126: invokevirtual f : (III)I
/*      */       //   129: istore_3
/*      */       //   130: aload_0
/*      */       //   131: dup
/*      */       //   132: getfield a : I
/*      */       //   135: iconst_1
/*      */       //   136: iadd
/*      */       //   137: putfield a : I
/*      */       //   140: iload_3
/*      */       //   141: ireturn
/*      */       //   142: aload_0
/*      */       //   143: iload_1
/*      */       //   144: iload_2
/*      */       //   145: iconst_m1
/*      */       //   146: invokevirtual f : (III)I
/*      */       //   149: istore_3
/*      */       //   150: aload_0
/*      */       //   151: dup
/*      */       //   152: getfield a : I
/*      */       //   155: iconst_1
/*      */       //   156: iadd
/*      */       //   157: putfield a : I
/*      */       //   160: iload_3
/*      */       //   161: ireturn
/*      */       //   162: aload_0
/*      */       //   163: iload_1
/*      */       //   164: iload_2
/*      */       //   165: iconst_1
/*      */       //   166: iadd
/*      */       //   167: invokevirtual c : (II)I
/*      */       //   170: istore_3
/*      */       //   171: aload_0
/*      */       //   172: dup
/*      */       //   173: getfield a : I
/*      */       //   176: iconst_1
/*      */       //   177: iadd
/*      */       //   178: putfield a : I
/*      */       //   181: iload_3
/*      */       //   182: ireturn
/*      */       //   183: iload_2
/*      */       //   184: iconst_1
/*      */       //   185: iadd
/*      */       //   186: aload_0
/*      */       //   187: getfield c : Lcom/prineside/luaj/LuaString;
/*      */       //   190: invokevirtual length : ()I
/*      */       //   193: if_icmpne -> 202
/*      */       //   196: ldc 'malformed pattern (ends with '%')'
/*      */       //   198: invokestatic error : (Ljava/lang/String;)Lcom/prineside/luaj/LuaValue;
/*      */       //   201: pop
/*      */       //   202: aload_0
/*      */       //   203: getfield c : Lcom/prineside/luaj/LuaString;
/*      */       //   206: iload_2
/*      */       //   207: iconst_1
/*      */       //   208: iadd
/*      */       //   209: invokevirtual luaByte : (I)I
/*      */       //   212: lookupswitch default -> 399, 98 -> 240, 102 -> 272
/*      */       //   240: aload_0
/*      */       //   241: iload_1
/*      */       //   242: iload_2
/*      */       //   243: iconst_2
/*      */       //   244: iadd
/*      */       //   245: invokevirtual e : (II)I
/*      */       //   248: dup
/*      */       //   249: istore_1
/*      */       //   250: iconst_m1
/*      */       //   251: if_icmpne -> 266
/*      */       //   254: aload_0
/*      */       //   255: dup
/*      */       //   256: getfield a : I
/*      */       //   259: iconst_1
/*      */       //   260: iadd
/*      */       //   261: putfield a : I
/*      */       //   264: iconst_m1
/*      */       //   265: ireturn
/*      */       //   266: iinc #2, 4
/*      */       //   269: goto -> 20
/*      */       //   272: iinc #2, 2
/*      */       //   275: iload_2
/*      */       //   276: aload_0
/*      */       //   277: getfield c : Lcom/prineside/luaj/LuaString;
/*      */       //   280: invokevirtual length : ()I
/*      */       //   283: if_icmpeq -> 299
/*      */       //   286: aload_0
/*      */       //   287: getfield c : Lcom/prineside/luaj/LuaString;
/*      */       //   290: iload_2
/*      */       //   291: invokevirtual luaByte : (I)I
/*      */       //   294: bipush #91
/*      */       //   296: if_icmpeq -> 305
/*      */       //   299: ldc 'missing '[' after '%f' in pattern'
/*      */       //   301: invokestatic error : (Ljava/lang/String;)Lcom/prineside/luaj/LuaValue;
/*      */       //   304: pop
/*      */       //   305: aload_0
/*      */       //   306: iload_2
/*      */       //   307: invokevirtual b : (I)I
/*      */       //   310: istore_3
/*      */       //   311: iload_1
/*      */       //   312: ifne -> 319
/*      */       //   315: iconst_0
/*      */       //   316: goto -> 329
/*      */       //   319: aload_0
/*      */       //   320: getfield b : Lcom/prineside/luaj/LuaString;
/*      */       //   323: iload_1
/*      */       //   324: iconst_1
/*      */       //   325: isub
/*      */       //   326: invokevirtual luaByte : (I)I
/*      */       //   329: istore #4
/*      */       //   331: iload_1
/*      */       //   332: aload_0
/*      */       //   333: getfield b : Lcom/prineside/luaj/LuaString;
/*      */       //   336: invokevirtual length : ()I
/*      */       //   339: if_icmpne -> 346
/*      */       //   342: iconst_0
/*      */       //   343: goto -> 354
/*      */       //   346: aload_0
/*      */       //   347: getfield b : Lcom/prineside/luaj/LuaString;
/*      */       //   350: iload_1
/*      */       //   351: invokevirtual luaByte : (I)I
/*      */       //   354: istore #5
/*      */       //   356: aload_0
/*      */       //   357: iload #4
/*      */       //   359: iload_2
/*      */       //   360: iload_3
/*      */       //   361: iconst_1
/*      */       //   362: isub
/*      */       //   363: invokevirtual b : (III)Z
/*      */       //   366: ifne -> 382
/*      */       //   369: aload_0
/*      */       //   370: iload #5
/*      */       //   372: iload_2
/*      */       //   373: iload_3
/*      */       //   374: iconst_1
/*      */       //   375: isub
/*      */       //   376: invokevirtual b : (III)Z
/*      */       //   379: ifne -> 394
/*      */       //   382: aload_0
/*      */       //   383: dup
/*      */       //   384: getfield a : I
/*      */       //   387: iconst_1
/*      */       //   388: iadd
/*      */       //   389: putfield a : I
/*      */       //   392: iconst_m1
/*      */       //   393: ireturn
/*      */       //   394: iload_3
/*      */       //   395: istore_2
/*      */       //   396: goto -> 20
/*      */       //   399: aload_0
/*      */       //   400: getfield c : Lcom/prineside/luaj/LuaString;
/*      */       //   403: iload_2
/*      */       //   404: iconst_1
/*      */       //   405: iadd
/*      */       //   406: invokevirtual luaByte : (I)I
/*      */       //   409: dup
/*      */       //   410: istore_3
/*      */       //   411: i2c
/*      */       //   412: invokestatic isDigit : (C)Z
/*      */       //   415: ifeq -> 465
/*      */       //   418: aload_0
/*      */       //   419: iload_1
/*      */       //   420: iload_3
/*      */       //   421: invokevirtual d : (II)I
/*      */       //   424: dup
/*      */       //   425: istore_1
/*      */       //   426: iconst_m1
/*      */       //   427: if_icmpne -> 442
/*      */       //   430: aload_0
/*      */       //   431: dup
/*      */       //   432: getfield a : I
/*      */       //   435: iconst_1
/*      */       //   436: iadd
/*      */       //   437: putfield a : I
/*      */       //   440: iconst_m1
/*      */       //   441: ireturn
/*      */       //   442: aload_0
/*      */       //   443: iload_1
/*      */       //   444: iload_2
/*      */       //   445: iconst_2
/*      */       //   446: iadd
/*      */       //   447: invokevirtual a : (II)I
/*      */       //   450: istore #4
/*      */       //   452: aload_0
/*      */       //   453: dup
/*      */       //   454: getfield a : I
/*      */       //   457: iconst_1
/*      */       //   458: iadd
/*      */       //   459: putfield a : I
/*      */       //   462: iload #4
/*      */       //   464: ireturn
/*      */       //   465: iload_2
/*      */       //   466: iconst_1
/*      */       //   467: iadd
/*      */       //   468: aload_0
/*      */       //   469: getfield c : Lcom/prineside/luaj/LuaString;
/*      */       //   472: invokevirtual length : ()I
/*      */       //   475: if_icmpne -> 507
/*      */       //   478: iload_1
/*      */       //   479: aload_0
/*      */       //   480: getfield b : Lcom/prineside/luaj/LuaString;
/*      */       //   483: invokevirtual length : ()I
/*      */       //   486: if_icmpne -> 493
/*      */       //   489: iload_1
/*      */       //   490: goto -> 494
/*      */       //   493: iconst_m1
/*      */       //   494: istore_3
/*      */       //   495: aload_0
/*      */       //   496: dup
/*      */       //   497: getfield a : I
/*      */       //   500: iconst_1
/*      */       //   501: iadd
/*      */       //   502: putfield a : I
/*      */       //   505: iload_3
/*      */       //   506: ireturn
/*      */       //   507: aload_0
/*      */       //   508: iload_2
/*      */       //   509: invokevirtual b : (I)I
/*      */       //   512: istore_3
/*      */       //   513: iload_1
/*      */       //   514: aload_0
/*      */       //   515: getfield b : Lcom/prineside/luaj/LuaString;
/*      */       //   518: invokevirtual length : ()I
/*      */       //   521: if_icmpge -> 545
/*      */       //   524: aload_0
/*      */       //   525: dup
/*      */       //   526: getfield b : Lcom/prineside/luaj/LuaString;
/*      */       //   529: iload_1
/*      */       //   530: invokevirtual luaByte : (I)I
/*      */       //   533: iload_2
/*      */       //   534: iload_3
/*      */       //   535: invokevirtual c : (III)Z
/*      */       //   538: ifeq -> 545
/*      */       //   541: iconst_1
/*      */       //   542: goto -> 546
/*      */       //   545: iconst_0
/*      */       //   546: istore #4
/*      */       //   548: iload_3
/*      */       //   549: aload_0
/*      */       //   550: getfield c : Lcom/prineside/luaj/LuaString;
/*      */       //   553: invokevirtual length : ()I
/*      */       //   556: if_icmpge -> 570
/*      */       //   559: aload_0
/*      */       //   560: getfield c : Lcom/prineside/luaj/LuaString;
/*      */       //   563: iload_3
/*      */       //   564: invokevirtual luaByte : (I)I
/*      */       //   567: goto -> 571
/*      */       //   570: iconst_0
/*      */       //   571: dup
/*      */       //   572: istore #5
/*      */       //   574: lookupswitch default -> 729, 42 -> 658, 43 -> 678, 45 -> 709, 63 -> 616
/*      */       //   616: iload #4
/*      */       //   618: ifeq -> 651
/*      */       //   621: aload_0
/*      */       //   622: iload_1
/*      */       //   623: iconst_1
/*      */       //   624: iadd
/*      */       //   625: iload_3
/*      */       //   626: iconst_1
/*      */       //   627: iadd
/*      */       //   628: invokevirtual a : (II)I
/*      */       //   631: dup
/*      */       //   632: istore_2
/*      */       //   633: iconst_m1
/*      */       //   634: if_icmpeq -> 651
/*      */       //   637: iload_2
/*      */       //   638: istore_1
/*      */       //   639: aload_0
/*      */       //   640: dup
/*      */       //   641: getfield a : I
/*      */       //   644: iconst_1
/*      */       //   645: iadd
/*      */       //   646: putfield a : I
/*      */       //   649: iload_1
/*      */       //   650: ireturn
/*      */       //   651: iload_3
/*      */       //   652: iconst_1
/*      */       //   653: iadd
/*      */       //   654: istore_2
/*      */       //   655: goto -> 20
/*      */       //   658: aload_0
/*      */       //   659: iload_1
/*      */       //   660: iload_2
/*      */       //   661: iload_3
/*      */       //   662: invokevirtual d : (III)I
/*      */       //   665: istore_1
/*      */       //   666: aload_0
/*      */       //   667: dup
/*      */       //   668: getfield a : I
/*      */       //   671: iconst_1
/*      */       //   672: iadd
/*      */       //   673: putfield a : I
/*      */       //   676: iload_1
/*      */       //   677: ireturn
/*      */       //   678: iload #4
/*      */       //   680: ifeq -> 695
/*      */       //   683: aload_0
/*      */       //   684: iload_1
/*      */       //   685: iconst_1
/*      */       //   686: iadd
/*      */       //   687: iload_2
/*      */       //   688: iload_3
/*      */       //   689: invokevirtual d : (III)I
/*      */       //   692: goto -> 696
/*      */       //   695: iconst_m1
/*      */       //   696: istore_1
/*      */       //   697: aload_0
/*      */       //   698: dup
/*      */       //   699: getfield a : I
/*      */       //   702: iconst_1
/*      */       //   703: iadd
/*      */       //   704: putfield a : I
/*      */       //   707: iload_1
/*      */       //   708: ireturn
/*      */       //   709: aload_0
/*      */       //   710: iload_1
/*      */       //   711: iload_2
/*      */       //   712: iload_3
/*      */       //   713: invokevirtual e : (III)I
/*      */       //   716: istore_1
/*      */       //   717: aload_0
/*      */       //   718: dup
/*      */       //   719: getfield a : I
/*      */       //   722: iconst_1
/*      */       //   723: iadd
/*      */       //   724: putfield a : I
/*      */       //   727: iload_1
/*      */       //   728: ireturn
/*      */       //   729: iload #4
/*      */       //   731: ifne -> 746
/*      */       //   734: aload_0
/*      */       //   735: dup
/*      */       //   736: getfield a : I
/*      */       //   739: iconst_1
/*      */       //   740: iadd
/*      */       //   741: putfield a : I
/*      */       //   744: iconst_m1
/*      */       //   745: ireturn
/*      */       //   746: iinc #1, 1
/*      */       //   749: iload_3
/*      */       //   750: istore_2
/*      */       //   751: goto -> 20
/*      */       //   754: astore_1
/*      */       //   755: aload_0
/*      */       //   756: dup
/*      */       //   757: getfield a : I
/*      */       //   760: iconst_1
/*      */       //   761: iadd
/*      */       //   762: putfield a : I
/*      */       //   765: aload_1
/*      */       //   766: athrow
/*      */       // Line number table:
/*      */       //   Java source line number -> byte code offset
/*      */       //   #1212	-> 0
/*      */       //   #1218	-> 20
/*      */       //   #1219	-> 31
/*      */       //   #1291	-> 33
/*      */       //   #1219	-> 43
/*      */       //   #1220	-> 45
/*      */       //   #1222	-> 92
/*      */       //   #1223	-> 119
/*      */       //   #1291	-> 130
/*      */       //   #1223	-> 140
/*      */       //   #1225	-> 142
/*      */       //   #1291	-> 150
/*      */       //   #1225	-> 160
/*      */       //   #1227	-> 162
/*      */       //   #1291	-> 171
/*      */       //   #1227	-> 181
/*      */       //   #1229	-> 183
/*      */       //   #1230	-> 196
/*      */       //   #1231	-> 202
/*      */       //   #1233	-> 240
/*      */       //   #1234	-> 249
/*      */       //   #1291	-> 254
/*      */       //   #1234	-> 264
/*      */       //   #1235	-> 266
/*      */       //   #1236	-> 269
/*      */       //   #1238	-> 272
/*      */       //   #1239	-> 275
/*      */       //   #1240	-> 299
/*      */       //   #1242	-> 305
/*      */       //   #1243	-> 311
/*      */       //   #1244	-> 331
/*      */       //   #1245	-> 356
/*      */       //   #1246	-> 376
/*      */       //   #1291	-> 382
/*      */       //   #1247	-> 392
/*      */       //   #1248	-> 394
/*      */       //   #1249	-> 396
/*      */       //   #1252	-> 399
/*      */       //   #1253	-> 410
/*      */       //   #1254	-> 418
/*      */       //   #1255	-> 425
/*      */       //   #1291	-> 430
/*      */       //   #1256	-> 440
/*      */       //   #1257	-> 442
/*      */       //   #1291	-> 452
/*      */       //   #1257	-> 462
/*      */       //   #1262	-> 465
/*      */       //   #1263	-> 478
/*      */       //   #1291	-> 495
/*      */       //   #1263	-> 505
/*      */       //   #1265	-> 507
/*      */       //   #1266	-> 513
/*      */       //   #1267	-> 548
/*      */       //   #1269	-> 572
/*      */       //   #1272	-> 616
/*      */       //   #1273	-> 637
/*      */       //   #1291	-> 639
/*      */       //   #1273	-> 649
/*      */       //   #1274	-> 651
/*      */       //   #1275	-> 655
/*      */       //   #1277	-> 658
/*      */       //   #1291	-> 666
/*      */       //   #1277	-> 676
/*      */       //   #1279	-> 678
/*      */       //   #1291	-> 697
/*      */       //   #1279	-> 707
/*      */       //   #1281	-> 709
/*      */       //   #1291	-> 717
/*      */       //   #1281	-> 727
/*      */       //   #1283	-> 729
/*      */       //   #1291	-> 734
/*      */       //   #1284	-> 744
/*      */       //   #1285	-> 746
/*      */       //   #1286	-> 749
/*      */       //   #1287	-> 751
/*      */       //   #1291	-> 754
/*      */       //   #1292	-> 765
/*      */       // Exception table:
/*      */       //   from	to	target	type
/*      */       //   20	33	754	finally
/*      */       //   45	130	754	finally
/*      */       //   142	150	754	finally
/*      */       //   162	171	754	finally
/*      */       //   183	254	754	finally
/*      */       //   266	382	754	finally
/*      */       //   394	430	754	finally
/*      */       //   442	452	754	finally
/*      */       //   465	495	754	finally
/*      */       //   507	639	754	finally
/*      */       //   651	666	754	finally
/*      */       //   678	697	754	finally
/*      */       //   709	717	754	finally
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int d(int param1Int1, int param1Int2, int param1Int3) {
/* 1296 */       byte b = 0;
/* 1297 */       while (param1Int1 + b < this.b.length() && 
/* 1298 */         c(this.b.luaByte(param1Int1 + b), param1Int2, param1Int3))
/* 1299 */         b++; 
/* 1300 */       while (b >= 0) {
/*      */         
/* 1302 */         if ((param1Int2 = a(param1Int1 + b, param1Int3 + 1)) != -1)
/* 1303 */           return param1Int2; 
/* 1304 */         b--;
/*      */       } 
/* 1306 */       return -1;
/*      */     }
/*      */     
/*      */     private int e(int param1Int1, int param1Int2, int param1Int3) {
/*      */       while (true) {
/*      */         int i;
/* 1312 */         if ((i = a(param1Int1, param1Int3 + 1)) != -1)
/* 1313 */           return i; 
/* 1314 */         if (param1Int1 < this.b.length() && c(this.b.luaByte(param1Int1), param1Int2, param1Int3))
/* 1315 */         { param1Int1++; continue; }  break;
/* 1316 */       }  return -1;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private int f(int param1Int1, int param1Int2, int param1Int3) {
/*      */       int i;
/* 1323 */       if ((i = this.d) >= 32) {
/* 1324 */         LuaValue.error("too many captures");
/*      */       }
/* 1326 */       this.e[i] = param1Int1;
/* 1327 */       this.f[i] = param1Int3;
/* 1328 */       this.d = i + 1;
/* 1329 */       if ((param1Int1 = a(param1Int1, param1Int2)) == -1)
/* 1330 */         this.d--; 
/* 1331 */       return param1Int1;
/*      */     }
/*      */     
/*      */     private int c(int param1Int1, int param1Int2) {
/* 1335 */       int i = b();
/*      */       
/* 1337 */       this.f[i] = param1Int1 - this.e[i];
/* 1338 */       if ((param1Int1 = a(param1Int1, param1Int2)) == -1)
/* 1339 */         this.f[i] = -1; 
/* 1340 */       return param1Int1;
/*      */     }
/*      */     
/*      */     private int d(int param1Int1, int param1Int2) {
/* 1344 */       param1Int2 = a(param1Int2);
/* 1345 */       int i = this.f[param1Int2];
/* 1346 */       if (this.b.length() - param1Int1 >= i && 
/* 1347 */         LuaString.equals(this.b, this.e[param1Int2], this.b, param1Int1, i)) {
/* 1348 */         return param1Int1 + i;
/*      */       }
/* 1350 */       return -1;
/*      */     }
/*      */     
/*      */     private int e(int param1Int1, int param1Int2) {
/* 1354 */       int i = this.c.length();
/* 1355 */       if (param1Int2 == i || param1Int2 + 1 == i) {
/* 1356 */         LuaValue.error("malformed pattern (missing arguments to '%b')");
/*      */       }
/* 1358 */       i = this.b.length();
/* 1359 */       if (param1Int1 >= i)
/* 1360 */         return -1; 
/* 1361 */       int j = this.c.luaByte(param1Int2);
/* 1362 */       if (this.b.luaByte(param1Int1) != j)
/* 1363 */         return -1; 
/* 1364 */       param1Int2 = this.c.luaByte(param1Int2 + 1);
/* 1365 */       byte b = 1;
/* 1366 */       while (++param1Int1 < i) {
/* 1367 */         if (this.b.luaByte(param1Int1) == param1Int2) {
/* 1368 */           if (--b == 0) return param1Int1 + 1;  continue;
/*      */         } 
/* 1370 */         if (this.b.luaByte(param1Int1) == j) b++; 
/*      */       } 
/* 1372 */       return -1;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\StringLib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */