/*     */ package com.prineside.luaj.lib;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.luaj.Buffer;
/*     */ import com.prineside.luaj.Globals;
/*     */ import com.prineside.luaj.LuaTable;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.Varargs;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.IOException;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public class OsLib
/*     */   extends TwoArgFunction
/*     */ {
/*  87 */   private static final TLog a = TLog.forClass(OsLib.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String TMP_PREFIX = ".luaj";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String TMP_SUFFIX = "tmp";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 104 */   private static final String[] b = new String[] { "clock", "date", "difftime", "execute", "exit", "getenv", "remove", "rename", "setlocale", "time", "tmpname" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final long e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 119 */   private static long f = e = System.currentTimeMillis();
/*     */   
/*     */   private Globals g;
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/* 125 */     super.write(paramKryo, paramOutput);
/* 126 */     paramKryo.writeClassAndObject(paramOutput, this.g);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/* 131 */     super.read(paramKryo, paramInput);
/* 132 */     this.g = (Globals)paramKryo.readClassAndObject(paramInput);
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
/*     */   public LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 148 */     this.g = paramLuaValue2.checkglobals();
/* 149 */     LuaTable luaTable = new LuaTable();
/* 150 */     for (byte b = 0; b < b.length; b++)
/* 151 */       luaTable.set(b[b], (LuaValue)new OsLibFunc(this, b, b[b])); 
/* 152 */     paramLuaValue2.set("os", (LuaValue)luaTable);
/* 153 */     if (!paramLuaValue2.get("package").isnil()) paramLuaValue2.get("package").get("loaded").set("os", (LuaValue)luaTable); 
/* 154 */     return (LuaValue)luaTable;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class OsLibFunc
/*     */     extends VarArgFunction {
/*     */     private OsLib a;
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 163 */       super.write(param1Kryo, param1Output);
/* 164 */       param1Kryo.writeClassAndObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 169 */       super.read(param1Kryo, param1Input);
/* 170 */       this.a = (OsLib)param1Kryo.readClassAndObject(param1Input);
/*     */     }
/*     */     
/*     */     private OsLibFunc() {}
/*     */     
/*     */     public OsLibFunc(OsLib param1OsLib, int param1Int, String param1String) {
/* 176 */       this.c = param1Int;
/* 177 */       this.d = param1String;
/* 178 */       this.a = param1OsLib; } public Varargs invoke(Varargs param1Varargs) { try {
/*     */         Calendar calendar; String str2; LuaTable luaTable;
/*     */         String str1;
/*     */         double d;
/* 182 */         switch (this.c) {
/*     */           case 0:
/* 184 */             return (Varargs)valueOf(OsLib.d());
/*     */           case 1:
/* 186 */             str2 = param1Varargs.optjstring(1, "%c");
/* 187 */             d = param1Varargs.isnumber(2) ? param1Varargs.todouble(2) : OsLib.a((LuaTable)null);
/* 188 */             if (str2.equals("*t")) {
/*     */               
/* 190 */               (calendar = Calendar.getInstance()).setTime(new Date((long)(d * 1000.0D)));
/*     */               
/* 192 */               (luaTable = LuaValue.tableOf()).set("year", (LuaValue)LuaValue.valueOf(calendar.get(1)));
/* 193 */               luaTable.set("month", (LuaValue)LuaValue.valueOf(calendar.get(2) + 1));
/* 194 */               luaTable.set("day", (LuaValue)LuaValue.valueOf(calendar.get(5)));
/* 195 */               luaTable.set("hour", (LuaValue)LuaValue.valueOf(calendar.get(11)));
/* 196 */               luaTable.set("min", (LuaValue)LuaValue.valueOf(calendar.get(12)));
/* 197 */               luaTable.set("sec", (LuaValue)LuaValue.valueOf(calendar.get(13)));
/* 198 */               luaTable.set("wday", (LuaValue)LuaValue.valueOf(calendar.get(7)));
/* 199 */               luaTable.set("yday", (LuaValue)LuaValue.valueOf(calendar.get(6)));
/* 200 */               luaTable.set("isdst", (LuaValue)LuaValue.valueOf(OsLib.a(this.a, calendar)));
/* 201 */               return (Varargs)luaTable;
/*     */             } 
/* 203 */             return (Varargs)valueOf(this.a.date((String)luaTable, (d == -1.0D) ? OsLib.a((LuaTable)null) : d));
/*     */           
/*     */           case 2:
/* 206 */             return (Varargs)valueOf(OsLib.a(calendar.checkdouble(1), calendar.checkdouble(2)));
/*     */           case 3:
/* 208 */             calendar.optjstring(1, null); return OsLib.e();
/*     */           case 4:
/* 210 */             OsLib.a(calendar.optint(1, 0));
/* 211 */             return (Varargs)NONE;
/*     */           
/*     */           case 5:
/* 214 */             return (Varargs)(((str1 = this.a.c(calendar.checkjstring(1))) != null) ? valueOf(str1) : NIL);
/*     */           
/*     */           case 6:
/* 217 */             calendar.checkjstring(1); this.a.f();
/* 218 */             return (Varargs)LuaValue.TRUE;
/*     */           case 7:
/* 220 */             calendar.checkjstring(1); calendar.checkjstring(2); this.a.g();
/* 221 */             return (Varargs)LuaValue.TRUE;
/*     */           case 8:
/* 223 */             calendar.optjstring(1, null); calendar.optjstring(2, "all");
/* 224 */             return (Varargs)valueOf(str1 = OsLib.h());
/*     */           
/*     */           case 9:
/* 227 */             return (Varargs)valueOf(OsLib.a(calendar.opttable(1, null)));
/*     */           case 10:
/* 229 */             return (Varargs)valueOf(this.a.i());
/*     */         } 
/* 231 */         return (Varargs)NONE;
/* 232 */       } catch (IOException iOException) {
/* 233 */         return varargsOf(NIL, (Varargs)valueOf(iOException.getMessage()));
/*     */       }  }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static double d() {
/* 244 */     return (System.currentTimeMillis() - e) / 1000.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static double a(double paramDouble1, double paramDouble2) {
/* 255 */     return paramDouble1 - paramDouble2;
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
/*     */   public String date(String paramString, double paramDouble) {
/*     */     Calendar calendar;
/* 278 */     (calendar = Calendar.getInstance()).setTime(new Date((long)(paramDouble * 1000.0D)));
/* 279 */     if (paramString.startsWith("!")) {
/* 280 */       paramDouble -= b(calendar);
/* 281 */       calendar.setTime(new Date((long)(paramDouble * 1000.0D)));
/* 282 */       paramString = paramString.substring(1);
/*     */     } 
/*     */     byte[] arrayOfByte;
/* 285 */     int i = (arrayOfByte = paramString.getBytes()).length;
/* 286 */     Buffer buffer = new Buffer(i);
/*     */     
/* 288 */     for (byte b = 0; b < i;) {
/* 289 */       switch (b1 = arrayOfByte[b++]) {
/*     */         case 10:
/* 291 */           buffer.append("\n");
/*     */           break;
/*     */ 
/*     */ 
/*     */         
/*     */         case 37:
/* 297 */           if (b < i) {
/* 298 */             Calendar calendar1; switch (b1 = arrayOfByte[b++]) {
/*     */               default:
/* 300 */                 LuaValue.argerror(1, "invalid conversion specifier '%" + b1 + "'");
/*     */                 break;
/*     */               case 37:
/* 303 */                 buffer.append((byte)37);
/*     */                 break;
/*     */               case 97:
/* 306 */                 buffer.append(h[calendar.get(7) - 1]);
/*     */                 break;
/*     */               case 65:
/* 309 */                 buffer.append(i[calendar.get(7) - 1]);
/*     */                 break;
/*     */               case 98:
/* 312 */                 buffer.append(j[calendar.get(2)]);
/*     */                 break;
/*     */               case 66:
/* 315 */                 buffer.append(k[calendar.get(2)]);
/*     */                 break;
/*     */               case 99:
/* 318 */                 buffer.append(date("%a %b %d %H:%M:%S %Y", paramDouble));
/*     */                 break;
/*     */               case 100:
/* 321 */                 buffer.append(String.valueOf(100 + calendar.get(5)).substring(1));
/*     */                 break;
/*     */               case 72:
/* 324 */                 buffer.append(String.valueOf(100 + calendar.get(11)).substring(1));
/*     */                 break;
/*     */               case 73:
/* 327 */                 buffer.append(String.valueOf(100 + calendar.get(11) % 12).substring(1));
/*     */                 break;
/*     */               case 106:
/* 330 */                 calendar1 = a(calendar);
/* 331 */                 k = (int)((calendar.getTime().getTime() - calendar1.getTime().getTime()) / 86400000L);
/* 332 */                 buffer.append(String.valueOf(k + 1001).substring(1));
/*     */                 break;
/*     */               
/*     */               case 109:
/* 336 */                 buffer.append(String.valueOf(101 + calendar.get(2)).substring(1));
/*     */                 break;
/*     */               case 77:
/* 339 */                 buffer.append(String.valueOf(100 + calendar.get(12)).substring(1));
/*     */                 break;
/*     */               case 112:
/* 342 */                 buffer.append((calendar.get(11) < 12) ? "AM" : "PM");
/*     */                 break;
/*     */               case 83:
/* 345 */                 buffer.append(String.valueOf(100 + calendar.get(13)).substring(1));
/*     */                 break;
/*     */               case 85:
/* 348 */                 buffer.append(String.valueOf(a(calendar, 0)));
/*     */                 break;
/*     */               case 119:
/* 351 */                 buffer.append(String.valueOf((calendar.get(7) + 6) % 7));
/*     */                 break;
/*     */               case 87:
/* 354 */                 buffer.append(String.valueOf(a(calendar, 1)));
/*     */                 break;
/*     */               case 120:
/* 357 */                 buffer.append(date("%m/%d/%y", paramDouble));
/*     */                 break;
/*     */               case 88:
/* 360 */                 buffer.append(date("%H:%M:%S", paramDouble));
/*     */                 break;
/*     */               case 121:
/* 363 */                 buffer.append(String.valueOf(calendar.get(1)).substring(2));
/*     */                 break;
/*     */               case 89:
/* 366 */                 buffer.append(String.valueOf(calendar.get(1))); break;
/*     */               case 122:
/*     */                 break;
/*     */             } 
/* 370 */             int j, k = Math.abs(j = b(calendar) / 60);
/* 371 */             String str2 = String.valueOf(100 + k / 60).substring(1);
/* 372 */             String str1 = String.valueOf(100 + k % 60).substring(1);
/* 373 */             buffer.append(((j >= 0) ? "+" : "-") + str2 + str1);
/*     */           } 
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/* 379 */     return buffer.tojstring();
/*     */   }
/*     */   
/* 382 */   private static final String[] h = new String[] { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
/* 383 */   private static final String[] i = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
/* 384 */   private static final String[] j = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
/* 385 */   private static final String[] k = new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
/*     */   
/*     */   private static Calendar a(Calendar paramCalendar) {
/*     */     Calendar calendar;
/* 389 */     (calendar = Calendar.getInstance()).setTime(paramCalendar.getTime());
/* 390 */     calendar.set(2, 0);
/* 391 */     calendar.set(5, 1);
/* 392 */     calendar.set(11, 0);
/* 393 */     calendar.set(12, 0);
/* 394 */     calendar.set(13, 0);
/* 395 */     calendar.set(14, 0);
/* 396 */     return calendar;
/*     */   }
/*     */   
/*     */   private int a(Calendar paramCalendar, int paramInt) {
/*     */     Calendar calendar;
/* 401 */     (calendar = a(paramCalendar)).set(5, 1 + (paramInt + 8 - calendar.get(7)) % 7);
/* 402 */     if (calendar.after(paramCalendar)) {
/* 403 */       calendar.set(1, calendar.get(1) - 1);
/* 404 */       calendar.set(5, 1 + (paramInt + 8 - calendar.get(7)) % 7);
/*     */     } 
/* 406 */     long l = paramCalendar.getTime().getTime() - calendar.getTime().getTime();
/* 407 */     return 1 + (int)(l / 604800000L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int b(Calendar paramCalendar) {
/* 414 */     int i = (paramCalendar.get(11) * 3600 + paramCalendar.get(12) * 60 + paramCalendar.get(13)) * 1000;
/* 415 */     return paramCalendar.getTimeZone().getOffset(1, paramCalendar
/*     */         
/* 417 */         .get(1), paramCalendar
/* 418 */         .get(2), paramCalendar
/* 419 */         .get(5), paramCalendar
/* 420 */         .get(7), i) / 1000;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean c(Calendar paramCalendar) {
/* 425 */     return (b(paramCalendar) != paramCalendar.getTimeZone().getRawOffset() / 1000);
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
/*     */   protected static Varargs e() {
/* 437 */     a.e("os.execute is not allowed", new Object[0]);
/* 438 */     return LuaValue.varargsOf(NIL, (LuaValue)valueOf("exit"), (Varargs)ONE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void a(int paramInt) {
/* 446 */     a.i("os.exit(" + paramInt + ") called by the script", new Object[0]);
/* 447 */     Game.exit();
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
/*     */   protected String c(String paramString) {
/* 468 */     return System.getProperty(paramString);
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
/*     */   protected void f() {
/* 480 */     throw new IOException("not implemented");
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
/*     */   protected void g() {
/* 492 */     throw new IOException("not implemented");
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
/*     */   protected static String h() {
/* 514 */     a.e("os.setlocale is not available - use LocaleManager if you really need to change the game's locale", new Object[0]);
/* 515 */     return "C";
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
/*     */   protected static double a(LuaTable paramLuaTable) {
/*     */     Date date;
/* 529 */     if (paramLuaTable == null) {
/* 530 */       date = new Date();
/*     */     } else {
/*     */       Calendar calendar;
/* 533 */       (calendar = Calendar.getInstance()).set(1, date.get("year").checkint());
/* 534 */       calendar.set(2, date.get("month").checkint() - 1);
/* 535 */       calendar.set(5, date.get("day").checkint());
/* 536 */       calendar.set(11, date.get("hour").optint(12));
/* 537 */       calendar.set(12, date.get("min").optint(0));
/* 538 */       calendar.set(13, date.get("sec").optint(0));
/* 539 */       calendar.set(14, 0);
/* 540 */       date = calendar.getTime();
/*     */     } 
/* 542 */     return date.getTime() / 1000.0D;
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
/*     */   protected String i() {
/* 559 */     synchronized (OsLib.class) {
/* 560 */       return ".luaj" + f++ + "tmp";
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\OsLib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */