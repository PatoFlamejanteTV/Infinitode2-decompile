/*      */ package com.prineside.luaj;
/*      */ 
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.esotericsoftware.kryo.Kryo;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.google.common.base.Preconditions;
/*      */ import com.prineside.luaj.lib.jse.CoerceJavaToLua;
/*      */ import com.prineside.luaj.lib.jse.JavaInstance;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.managers.NetworkManager;
/*      */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*      */ 
/*      */ 
/*      */ @REGS(arrayLevels = 1, classOnly = true)
/*      */ public abstract class LuaValue
/*      */   extends Varargs
/*      */ {
/*   21 */   private static final TLog a = TLog.forClass(LuaValue.class); public static final int TINT = -2; public static final int TNONE = -1; public static final int TNIL = 0; public static final int TBOOLEAN = 1; public static final int TLIGHTUSERDATA = 2; public static final int TNUMBER = 3; public static final int TSTRING = 4; public static final int TTABLE = 5;
/*      */   public static final int TFUNCTION = 6;
/*   23 */   public static final NillableSerializer NILLABLE_SERIALIZER = new NillableSerializer(); public static final int TUSERDATA = 7; public static final int TTHREAD = 8; public static final int TVALUE = 9;
/*      */   
/*   25 */   public static class NillableSerializer { private static final Array<LuaValue> a = new Array(LuaValue.class);
/*      */     public void writeClassAndObject(Kryo param1Kryo, Output param1Output, LuaValue param1LuaValue) {
/*      */       String str;
/*   28 */       if (param1LuaValue instanceof LuaUserdata && !(param1LuaValue instanceof com.prineside.luaj.lib.jse.JavaClass)) {
/*      */         LuaUserdata luaUserdata;
/*      */         
/*   31 */         if ((luaUserdata = (LuaUserdata)param1LuaValue).m_instance instanceof Class) {
/*   32 */           throw new IllegalStateException(param1LuaValue + " contains a class instance but is not a JavaClass, instead: " + param1LuaValue.getClass());
/*      */         }
/*   34 */         Class<?> clazz = luaUserdata.m_instance.getClass();
/*      */ 
/*      */         
/*   37 */         if (!((NetworkManager.KryoForState)param1Kryo).hasRegistration(clazz)) {
/*      */           
/*   39 */           if (Game.i.settingsManager.isInDebugDetailedMode()) {
/*   40 */             str = param1LuaValue.toString();
/*   41 */             LuaValue.c().i("skipping serialization of " + ((str.length() < 64) ? str : str.substring(0, 63)).replace("\n", " ") + " - " + clazz + " not registered", new Object[0]);
/*      */           } 
/*   43 */           param1Kryo.writeClassAndObject(param1Output, LuaValue.NIL);
/*      */         } else {
/*   45 */           param1Kryo.writeClassAndObject(param1Output, str); return;
/*      */         } 
/*      */       } else {
/*   48 */         param1Kryo.writeClassAndObject(param1Output, str);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void writeClassAndObject(Kryo param1Kryo, Output param1Output, LuaValue[] param1ArrayOfLuaValue) {
/*   54 */       if (param1ArrayOfLuaValue == null) {
/*   55 */         param1Kryo.writeClassAndObject(param1Output, null);
/*      */         return;
/*      */       } 
/*   58 */       a.clear();
/*   59 */       a.setSize(param1ArrayOfLuaValue.length);
/*      */       byte b;
/*   61 */       for (b = 0; b < param1ArrayOfLuaValue.length; b++) {
/*   62 */         if (!(param1ArrayOfLuaValue[b] instanceof com.prineside.luaj.lib.jse.JavaClass))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*   68 */           if (param1ArrayOfLuaValue[b] instanceof JavaInstance) {
/*      */             JavaInstance javaInstance;
/*      */ 
/*      */ 
/*      */             
/*   73 */             if ((javaInstance = (JavaInstance)param1ArrayOfLuaValue[b]).m_instance instanceof Class) {
/*   74 */               throw new IllegalStateException(param1ArrayOfLuaValue[b] + " contains a class instance but is not a JavaClass, instead: " + param1ArrayOfLuaValue[b].getClass());
/*      */             }
/*   76 */             Class<?> clazz = javaInstance.m_instance.getClass();
/*      */ 
/*      */             
/*   79 */             if (!((NetworkManager.KryoForState)param1Kryo).hasRegistration(clazz)) {
/*      */ 
/*      */ 
/*      */               
/*   83 */               a.set(b, param1ArrayOfLuaValue[b]);
/*   84 */               param1ArrayOfLuaValue[b] = LuaValue.NIL;
/*      */             } 
/*   86 */           } else if (param1ArrayOfLuaValue[b] != null) {
/*      */             
/*   88 */             if (!((NetworkManager.KryoForState)param1Kryo).hasRegistration(param1ArrayOfLuaValue[b].getClass())) {
/*      */               
/*   90 */               a.set(b, param1ArrayOfLuaValue[b]);
/*   91 */               param1ArrayOfLuaValue[b] = LuaValue.NIL;
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } 
/*      */       
/*   97 */       param1Kryo.writeClassAndObject(param1Output, param1ArrayOfLuaValue);
/*      */ 
/*      */       
/*  100 */       for (b = 0; b < a.size; b++) {
/*      */         LuaValue luaValue;
/*  102 */         if ((luaValue = ((LuaValue[])a.items)[b]) != null) {
/*  103 */           param1ArrayOfLuaValue[b] = luaValue;
/*      */         }
/*      */       } 
/*  106 */       a.clear();
/*      */     } }
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
/*  151 */   public static final String[] TYPE_NAMES = new String[] { "nil", "boolean", "lightuserdata", "number", "string", "table", "function", "userdata", "thread", "value" };
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
/*  165 */   public static final LuaValue NIL = LuaNil.a;
/*      */ 
/*      */   
/*  168 */   public static final LuaBoolean TRUE = LuaBoolean.a;
/*      */ 
/*      */   
/*  171 */   public static final LuaBoolean FALSE = LuaBoolean.b;
/*      */ 
/*      */   
/*  174 */   public static final LuaValue NONE = None.b;
/*      */ 
/*      */   
/*  177 */   public static final LuaNumber ZERO = LuaNumber.valueOf(0);
/*      */ 
/*      */   
/*  180 */   public static final LuaNumber ONE = LuaNumber.valueOf(1);
/*      */ 
/*      */   
/*  183 */   public static final LuaNumber MINUSONE = LuaNumber.valueOf(-1);
/*      */   
/*      */   public static final LuaValue[] NOVALS;
/*      */   
/*      */   static {
/*  188 */     SyncChecker.addSyncShareableObject(NOVALS = new LuaValue[0]);
/*      */   }
/*      */ 
/*      */   
/*  192 */   public static LuaString ENV = valueOf("_ENV");
/*      */ 
/*      */   
/*  195 */   public static final LuaString INDEX = valueOf("__index");
/*      */ 
/*      */   
/*  198 */   public static final LuaString NEWINDEX = valueOf("__newindex");
/*      */ 
/*      */   
/*  201 */   public static final LuaString CALL = valueOf("__call");
/*      */ 
/*      */   
/*  204 */   public static final LuaString MODE = valueOf("__mode");
/*      */ 
/*      */   
/*  207 */   public static final LuaString METATABLE = valueOf("__metatable");
/*      */ 
/*      */   
/*  210 */   public static final LuaString ADD = valueOf("__add");
/*      */ 
/*      */   
/*  213 */   public static final LuaString SUB = valueOf("__sub");
/*      */ 
/*      */   
/*  216 */   public static final LuaString DIV = valueOf("__div");
/*      */ 
/*      */   
/*  219 */   public static final LuaString MUL = valueOf("__mul");
/*      */ 
/*      */   
/*  222 */   public static final LuaString POW = valueOf("__pow");
/*      */ 
/*      */   
/*  225 */   public static final LuaString MOD = valueOf("__mod");
/*      */ 
/*      */   
/*  228 */   public static final LuaString UNM = valueOf("__unm");
/*      */ 
/*      */   
/*  231 */   public static final LuaString LEN = valueOf("__len");
/*      */ 
/*      */   
/*  234 */   public static final LuaString EQ = valueOf("__eq");
/*      */ 
/*      */   
/*  237 */   public static final LuaString LT = valueOf("__lt");
/*      */ 
/*      */   
/*  240 */   public static final LuaString LE = valueOf("__le");
/*      */ 
/*      */   
/*  243 */   public static final LuaString TOSTRING = valueOf("__tostring");
/*      */ 
/*      */   
/*  246 */   public static final LuaString CONCAT = valueOf("__concat");
/*      */ 
/*      */   
/*  249 */   public static final LuaString EMPTYSTRING = valueOf("");
/*      */ 
/*      */   
/*  252 */   public static final LuaString IPAIRS = valueOf("__ipairs");
/*      */ 
/*      */   
/*  255 */   public static final LuaString PAIRS = valueOf("__pairs");
/*      */ 
/*      */ 
/*      */   
/*      */   private static int b;
/*      */ 
/*      */ 
/*      */   
/*  263 */   public static final LuaValue[] NILS = new LuaValue[b = 250];
/*      */   static {
/*  265 */     for (byte b = 0; b < b; b++) {
/*  266 */       NILS[b] = NIL;
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
/*      */   public boolean isboolean() {
/*  303 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isclosure() {
/*  313 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isfunction() {
/*  322 */     return false;
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
/*      */   public boolean isint() {
/*  338 */     return false;
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
/*      */   public boolean isinttype() {
/*  350 */     return false;
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
/*      */   public boolean islong() {
/*  364 */     return false;
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
/*      */   public boolean isnil() {
/*  376 */     return false;
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
/*      */   public boolean isnumber() {
/*  388 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isstring() {
/*  399 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean istable() {
/*  407 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isuserdata() {
/*  417 */     return false;
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
/*      */   public boolean isuserdata(Class paramClass) {
/*  430 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean toboolean() {
/*  439 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte tobyte() {
/*  449 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char tochar() {
/*  459 */     return Character.MIN_VALUE;
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
/*      */   public double todouble() {
/*  474 */     return 0.0D;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float tofloat() {
/*  484 */     return 0.0F;
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
/*      */   public int toint() {
/*  499 */     return 0;
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
/*      */   public long tolong() {
/*  512 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short toshort() {
/*  522 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String tojstring() {
/*  532 */     return typename() + ": " + Integer.toHexString(hashCode());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object touserdata() {
/*  541 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> T touserdata(Class<T> paramClass) {
/*  551 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*  562 */     return tojstring();
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
/*      */   public LuaValue tonumber() {
/*  584 */     return NIL;
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
/*      */   public LuaValue tostring() {
/*  602 */     return NIL;
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
/*      */   public boolean optboolean(boolean paramBoolean) {
/*  614 */     a("boolean"); return false;
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
/*      */   public LuaClosure optclosure(LuaClosure paramLuaClosure) {
/*  628 */     a("closure"); return null;
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
/*      */   public double optdouble(double paramDouble) {
/*  643 */     a("number"); return 0.0D;
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
/*      */   public LuaFunction optfunction(LuaFunction paramLuaFunction) {
/*  659 */     a("function"); return null;
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
/*      */   public int optint(int paramInt) {
/*  675 */     a("int"); return 0;
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
/*      */   public long optlong(long paramLong) {
/*  691 */     a("long"); return 0L;
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
/*      */   public LuaNumber optnumber(LuaNumber paramLuaNumber) {
/*  708 */     a("number"); return null;
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
/*      */   public String optjstring(String paramString) {
/*  722 */     a("String"); return null;
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
/*      */   public LuaString optstring(LuaString paramLuaString) {
/*  736 */     a("string"); return null;
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
/*      */   public LuaTable opttable(LuaTable paramLuaTable) {
/*  748 */     a("table"); return null;
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
/*      */   public Object optuserdata(Object paramObject) {
/*  761 */     a("object"); return null;
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
/*      */   public Object optuserdata(Class paramClass, Object paramObject) {
/*  776 */     a(paramClass.getName()); return null;
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
/*      */   public LuaValue optvalue(LuaValue paramLuaValue) {
/*  788 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean checkboolean() {
/*  798 */     a("boolean"); return false;
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
/*      */   public LuaClosure checkclosure() {
/*  811 */     a("closure"); return null;
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
/*      */   public double checkdouble() {
/*  825 */     a("number"); return 0.0D;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaFunction checkfunction() {
/*  836 */     a("function"); return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Globals checkglobals() {
/*  845 */     a("globals"); return null;
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
/*      */   public int checkint() {
/*  859 */     a("int"); return 0;
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
/*      */   public long checklong() {
/*  873 */     a("long"); return 0L;
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
/*      */   public LuaNumber checknumber() {
/*  886 */     a("number"); return null;
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
/*      */   public LuaNumber checknumber(String paramString) {
/*  900 */     throw new LuaError(paramString);
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
/*      */   public String checkjstring() {
/*  914 */     a("string"); return null;
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
/*      */   public LuaString checkstring() {
/*  930 */     a("string"); return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaTable checktable() {
/*  939 */     a("table"); return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object checkuserdata() {
/*  949 */     a("userdata"); return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object checkuserdata(Class paramClass) {
/*  959 */     a("userdata"); return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaValue checknotnil() {
/*  966 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isvalidkey() {
/*  973 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LuaValue error(String paramString) {
/*  980 */     throw new LuaError(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void assert_(boolean paramBoolean, String paramString) {
/*  990 */     if (!paramBoolean) throw new LuaError(paramString);
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected final LuaValue a(String paramString) {
/*  997 */     throw new LuaError("bad argument: " + paramString + " expected, got " + typename());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LuaValue argerror(int paramInt, String paramString) {
/* 1005 */     throw new LuaError("bad argument #" + paramInt + ": " + paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final LuaValue b(String paramString) {
/* 1012 */     throw new LuaError(paramString + " expected, got " + typename());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private LuaValue c(String paramString) {
/* 1018 */     throw new LuaError("'" + paramString + "' not implemented for " + typename());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static LuaValue a(String paramString1, String paramString2) {
/* 1025 */     throw new LuaError("illegal operation '" + paramString1 + "' for " + paramString2);
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
/*      */   protected final LuaValue b() {
/* 1039 */     throw new LuaError("attempt to perform arithmetic on " + typename());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private LuaValue d(String paramString) {
/* 1047 */     throw new LuaError("attempt to perform arithmetic '" + paramString + "' on " + typename());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private LuaValue e(String paramString) {
/* 1055 */     throw new LuaError("attempt to compare " + typename() + " with " + paramString);
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
/*      */   public LuaValue get(LuaValue paramLuaValue) {
/* 1075 */     return c(this, paramLuaValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaValue get(int paramInt) {
/* 1085 */     return get(LuaNumber.valueOf(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaValue get(String paramString) {
/* 1095 */     return get(valueOf(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void set(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 1104 */     a(this, paramLuaValue1, paramLuaValue2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void set(int paramInt, LuaValue paramLuaValue) {
/* 1112 */     set(LuaNumber.valueOf(paramInt), paramLuaValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void set(int paramInt, String paramString) {
/* 1120 */     set(paramInt, valueOf(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void set(String paramString, LuaValue paramLuaValue) {
/* 1128 */     set(valueOf(paramString), paramLuaValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void set(String paramString, double paramDouble) {
/* 1136 */     set(valueOf(paramString), valueOf(paramDouble));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void set(String paramString, int paramInt) {
/* 1144 */     set(valueOf(paramString), valueOf(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void set(String paramString1, String paramString2) {
/* 1152 */     set(valueOf(paramString1), valueOf(paramString2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaValue rawget(LuaValue paramLuaValue) {
/* 1159 */     return c("rawget");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaValue rawget(int paramInt) {
/* 1166 */     return rawget(valueOf(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaValue rawget(String paramString) {
/* 1173 */     return rawget(valueOf(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rawset(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 1180 */     c("rawset");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rawset(int paramInt, LuaValue paramLuaValue) {
/* 1187 */     rawset(valueOf(paramInt), paramLuaValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rawset(int paramInt, String paramString) {
/* 1194 */     rawset(paramInt, valueOf(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rawset(String paramString, LuaValue paramLuaValue) {
/* 1201 */     rawset(valueOf(paramString), paramLuaValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rawset(String paramString, double paramDouble) {
/* 1208 */     rawset(valueOf(paramString), valueOf(paramDouble));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rawset(String paramString, int paramInt) {
/* 1215 */     rawset(valueOf(paramString), valueOf(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rawset(String paramString1, String paramString2) {
/* 1222 */     rawset(valueOf(paramString1), valueOf(paramString2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rawsetlist(int paramInt, Varargs paramVarargs) {
/*      */     byte b;
/*      */     int i;
/* 1231 */     for (b = 0, i = paramVarargs.narg(); b < i; ) { rawset(paramInt + b, paramVarargs.arg(b + 1)); b++; }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void presize(int paramInt) {
/* 1239 */     b("table");
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
/*      */   public Varargs next(LuaValue paramLuaValue) {
/* 1266 */     return b("table");
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
/*      */   public Varargs inext(LuaValue paramLuaValue) {
/* 1294 */     return b("table");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaValue load(LuaValue paramLuaValue) {
/* 1303 */     return paramLuaValue.call(EMPTYSTRING, this);
/*      */   }
/*      */   
/* 1306 */   public LuaValue arg(int paramInt) { return (paramInt == 1) ? this : NIL; }
/* 1307 */   public int narg() { return 1; } public LuaValue arg1() {
/* 1308 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaValue getmetatable() {
/* 1318 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaValue setmetatable(LuaValue paramLuaValue) {
/* 1328 */     return a("table");
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
/*      */   public LuaValue call() {
/* 1353 */     return a().call(this);
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
/*      */   public LuaValue call(LuaValue paramLuaValue) {
/* 1379 */     return a().call(this, paramLuaValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaValue call(String paramString) {
/* 1386 */     return call(valueOf(paramString));
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
/*      */   public LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 1413 */     return a().call(this, paramLuaValue1, paramLuaValue2);
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
/*      */   public LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2, LuaValue paramLuaValue3) {
/* 1440 */     return a().invoke(new LuaValue[] { this, paramLuaValue1, paramLuaValue2, paramLuaValue3 }).arg1();
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
/*      */   public LuaValue method(String paramString) {
/* 1466 */     return get(paramString).call(this);
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
/*      */   public LuaValue method(LuaValue paramLuaValue) {
/* 1492 */     return get(paramLuaValue).call(this);
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
/*      */   public LuaValue method(String paramString, LuaValue paramLuaValue) {
/* 1519 */     return get(paramString).call(this, paramLuaValue);
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
/*      */   public LuaValue method(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 1546 */     return get(paramLuaValue1).call(this, paramLuaValue2);
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
/*      */   public LuaValue method(String paramString, LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 1573 */     return get(paramString).call(this, paramLuaValue1, paramLuaValue2);
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
/*      */   public LuaValue method(LuaValue paramLuaValue1, LuaValue paramLuaValue2, LuaValue paramLuaValue3) {
/* 1600 */     return get(paramLuaValue1).call(this, paramLuaValue2, paramLuaValue3);
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
/*      */   public Varargs invoke() {
/* 1621 */     return invoke(NONE);
/*      */   }
/*      */ 
/*      */   
/*      */   public Varargs invoke(Varargs paramVarargs) {
/* 1626 */     return a().invoke(this, paramVarargs);
/*      */   } public Varargs invoke(LuaValue[] paramArrayOfLuaValue) {
/* 1628 */     return invoke(varargsOf(paramArrayOfLuaValue));
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
/*      */   public Varargs invoke(LuaValue paramLuaValue, Varargs paramVarargs) {
/* 1651 */     return invoke(varargsOf(paramLuaValue, paramVarargs));
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
/*      */   public Varargs invoke(LuaValue paramLuaValue1, LuaValue paramLuaValue2, Varargs paramVarargs) {
/* 1676 */     return invoke(varargsOf(paramLuaValue1, paramLuaValue2, paramVarargs));
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
/*      */   public Varargs invokemethod(String paramString) {
/* 1702 */     return get(paramString).invoke(this);
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
/*      */   public Varargs invokemethod(LuaValue paramLuaValue) {
/* 1727 */     return get(paramLuaValue).invoke(this);
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
/*      */   public Varargs invokemethod(String paramString, Varargs paramVarargs) {
/* 1755 */     return get(paramString).invoke(varargsOf(this, paramVarargs));
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
/*      */   public Varargs invokemethod(LuaValue paramLuaValue, Varargs paramVarargs) {
/* 1783 */     return get(paramLuaValue).invoke(varargsOf(this, paramVarargs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected LuaValue a() {
/* 1792 */     return a(CALL, "attempt to call ");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaValue not() {
/* 1798 */     return FALSE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaValue neg() {
/* 1806 */     return a(UNM, "attempt to perform arithmetic on ").call(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaValue len() {
/* 1813 */     return a(LEN, "attempt to get length of ").call(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int length() {
/* 1820 */     return len().toint();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int rawlen() {
/* 1826 */     b("table or string"); return 0;
/*      */   }
/*      */   public boolean equals(Object paramObject) {
/* 1829 */     return (this == paramObject);
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
/*      */   public LuaValue eq(LuaValue paramLuaValue) {
/* 1843 */     return eq_b(paramLuaValue) ? TRUE : FALSE;
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
/*      */   public boolean eq_b(LuaValue paramLuaValue) {
/* 1858 */     return (this == paramLuaValue);
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
/*      */   public LuaValue neq(LuaValue paramLuaValue) {
/* 1871 */     return eq_b(paramLuaValue) ? FALSE : TRUE;
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
/*      */   public boolean neq_b(LuaValue paramLuaValue) {
/* 1884 */     return !eq_b(paramLuaValue);
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
/*      */   public boolean raweq(LuaValue paramLuaValue) {
/* 1897 */     return (this == paramLuaValue);
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
/*      */   public boolean raweq(LuaUserdata paramLuaUserdata) {
/* 1909 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean raweq(LuaString paramLuaString) {
/* 1918 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean raweq(double paramDouble) {
/* 1927 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean raweq(int paramInt) {
/* 1936 */     return false;
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
/*      */   public static boolean eqmtcall(LuaValue paramLuaValue1, LuaValue paramLuaValue2, LuaValue paramLuaValue3, LuaValue paramLuaValue4) {
/* 1952 */     if (!(paramLuaValue2 = paramLuaValue2.rawget(EQ)).isnil() && paramLuaValue2 == paramLuaValue4.rawget(EQ) && paramLuaValue2.call(paramLuaValue1, paramLuaValue3).toboolean()) return true;  return false;
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
/*      */   public LuaValue add(LuaValue paramLuaValue) {
/* 1968 */     return b(ADD, paramLuaValue);
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
/*      */   public LuaValue add(double paramDouble) {
/* 1987 */     return a(ADD, paramDouble);
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
/*      */   public LuaValue add(int paramInt) {
/* 2000 */     return add(paramInt);
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
/*      */   public LuaValue sub(LuaValue paramLuaValue) {
/* 2016 */     return b(SUB, paramLuaValue);
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
/*      */   public LuaValue sub(double paramDouble) {
/* 2029 */     return d("sub");
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
/*      */   public LuaValue sub(int paramInt) {
/* 2042 */     return d("sub");
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
/*      */   public LuaValue subFrom(double paramDouble) {
/* 2057 */     return a(SUB, paramDouble);
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
/*      */   public LuaValue subFrom(int paramInt) {
/* 2074 */     return subFrom(paramInt);
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
/*      */   public LuaValue mul(LuaValue paramLuaValue) {
/* 2090 */     return b(MUL, paramLuaValue);
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
/*      */   public LuaValue mul(double paramDouble) {
/* 2104 */     return a(MUL, paramDouble);
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
/*      */   public LuaValue mul(int paramInt) {
/* 2116 */     return mul(paramInt);
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
/*      */   public LuaValue pow(LuaValue paramLuaValue) {
/* 2131 */     return b(POW, paramLuaValue);
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
/*      */   public LuaValue pow(double paramDouble) {
/* 2144 */     return d("pow");
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
/*      */   public LuaValue pow(int paramInt) {
/* 2157 */     return d("pow");
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
/*      */   public LuaValue powWith(double paramDouble) {
/* 2172 */     return a(POW, paramDouble);
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
/*      */   public LuaValue powWith(int paramInt) {
/* 2187 */     return powWith(paramInt);
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
/*      */   public LuaValue div(LuaValue paramLuaValue) {
/* 2203 */     return b(DIV, paramLuaValue);
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
/*      */   public LuaValue div(double paramDouble) {
/* 2218 */     return d("div");
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
/*      */   public LuaValue div(int paramInt) {
/* 2233 */     return d("div");
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
/*      */   public LuaValue divInto(double paramDouble) {
/* 2248 */     return a(DIV, paramDouble);
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
/*      */   public LuaValue mod(LuaValue paramLuaValue) {
/* 2264 */     return b(MOD, paramLuaValue);
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
/*      */   public LuaValue mod(double paramDouble) {
/* 2279 */     return d("mod");
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
/*      */   public LuaValue mod(int paramInt) {
/* 2294 */     return d("mod");
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
/*      */   public LuaValue modFrom(double paramDouble) {
/* 2309 */     return a(MOD, paramDouble);
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
/*      */   protected final LuaValue b(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/*      */     LuaValue luaValue;
/* 2333 */     if ((luaValue = metatag(paramLuaValue1)).isnil() && (
/*      */       
/* 2335 */       luaValue = paramLuaValue2.metatag(paramLuaValue1)).isnil()) {
/* 2336 */       error("attempt to perform arithmetic " + paramLuaValue1 + " on " + typename() + " and " + paramLuaValue2.typename());
/*      */     }
/* 2338 */     return luaValue.call(this, paramLuaValue2);
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
/*      */   private LuaValue a(LuaValue paramLuaValue, double paramDouble) {
/*      */     LuaValue luaValue;
/* 2363 */     if ((luaValue = metatag(paramLuaValue)).isnil())
/* 2364 */       error("attempt to perform arithmetic " + paramLuaValue + " on number and " + typename()); 
/* 2365 */     return luaValue.call(valueOf(paramDouble), this);
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
/*      */   public LuaValue lt(LuaValue paramLuaValue) {
/* 2383 */     return comparemt(LT, paramLuaValue);
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
/*      */   public LuaValue lt(double paramDouble) {
/* 2399 */     return e("number");
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
/*      */   public LuaValue lt(int paramInt) {
/* 2415 */     return e("number");
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
/*      */   public boolean lt_b(LuaValue paramLuaValue) {
/* 2432 */     return comparemt(LT, paramLuaValue).toboolean();
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
/*      */   public boolean lt_b(int paramInt) {
/* 2449 */     e("number"); return false;
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
/*      */   public boolean lt_b(double paramDouble) {
/* 2466 */     e("number"); return false;
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
/*      */   public LuaValue lteq(LuaValue paramLuaValue) {
/* 2483 */     return comparemt(LE, paramLuaValue);
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
/*      */   public LuaValue lteq(double paramDouble) {
/* 2499 */     return e("number");
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
/*      */   public LuaValue lteq(int paramInt) {
/* 2515 */     return e("number");
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
/*      */   public boolean lteq_b(LuaValue paramLuaValue) {
/* 2532 */     return comparemt(LE, paramLuaValue).toboolean();
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
/*      */   public boolean lteq_b(int paramInt) {
/* 2549 */     e("number"); return false;
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
/*      */   public boolean lteq_b(double paramDouble) {
/* 2566 */     e("number"); return false;
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
/*      */   public LuaValue gt(LuaValue paramLuaValue) {
/* 2583 */     return paramLuaValue.comparemt(LE, this);
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
/*      */   public LuaValue gt(double paramDouble) {
/* 2599 */     return e("number");
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
/*      */   public LuaValue gt(int paramInt) {
/* 2615 */     return e("number");
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
/*      */   public boolean gt_b(LuaValue paramLuaValue) {
/* 2632 */     return paramLuaValue.comparemt(LE, this).toboolean();
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
/*      */   public boolean gt_b(int paramInt) {
/* 2649 */     e("number"); return false;
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
/*      */   public boolean gt_b(double paramDouble) {
/* 2666 */     e("number"); return false;
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
/*      */   public LuaValue gteq(LuaValue paramLuaValue) {
/* 2683 */     return paramLuaValue.comparemt(LT, this);
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
/*      */   public LuaValue gteq(double paramDouble) {
/* 2699 */     return e("number");
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
/*      */   public LuaValue gteq(int paramInt) {
/* 2715 */     return valueOf((todouble() >= paramInt));
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
/*      */   public boolean gteq_b(LuaValue paramLuaValue) {
/* 2732 */     return paramLuaValue.comparemt(LT, this).toboolean();
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
/*      */   public boolean gteq_b(int paramInt) {
/* 2749 */     e("number"); return false;
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
/*      */   public boolean gteq_b(double paramDouble) {
/* 2766 */     e("number"); return false;
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
/*      */   public LuaValue comparemt(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/*      */     LuaValue luaValue;
/* 2785 */     if (!(luaValue = metatag(paramLuaValue1)).isnil() || !(luaValue = paramLuaValue2.metatag(paramLuaValue1)).isnil())
/* 2786 */       return luaValue.call(this, paramLuaValue2); 
/* 2787 */     if (LE.raweq(paramLuaValue1) && (!(luaValue = metatag(LT)).isnil() || !(luaValue = paramLuaValue2.metatag(LT)).isnil()))
/* 2788 */       return luaValue.call(paramLuaValue2, this).not(); 
/* 2789 */     return error("attempt to compare " + paramLuaValue1 + " on " + typename() + " and " + paramLuaValue2.typename());
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
/*      */   public int strcmp(LuaValue paramLuaValue) {
/* 2803 */     error("attempt to compare " + typename()); return 0;
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
/*      */   public int strcmp(LuaString paramLuaString) {
/* 2816 */     error("attempt to compare " + typename()); return 0;
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
/*      */   public LuaValue concat(LuaValue paramLuaValue) {
/* 2829 */     return concatmt(paramLuaValue);
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
/*      */   public LuaValue concatTo(LuaValue paramLuaValue) {
/* 2845 */     return paramLuaValue.concatmt(this);
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
/*      */   public LuaValue concatTo(LuaNumber paramLuaNumber) {
/* 2861 */     return paramLuaNumber.concatmt(this);
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
/*      */   public LuaValue concatTo(LuaString paramLuaString) {
/* 2877 */     return paramLuaString.concatmt(this);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Buffer buffer() {
/* 2883 */     return new Buffer(this);
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
/*      */   public Buffer concat(Buffer paramBuffer) {
/* 2896 */     return paramBuffer.concatTo(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaValue concatmt(LuaValue paramLuaValue) {
/*      */     LuaValue luaValue;
/* 2908 */     if ((luaValue = metatag(CONCAT)).isnil() && (luaValue = paramLuaValue.metatag(CONCAT)).isnil())
/* 2909 */       error("attempt to concatenate " + typename() + " and " + paramLuaValue.typename()); 
/* 2910 */     return luaValue.call(this, paramLuaValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaValue and(LuaValue paramLuaValue) {
/* 2919 */     return toboolean() ? paramLuaValue : this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaValue or(LuaValue paramLuaValue) {
/* 2927 */     return toboolean() ? this : paramLuaValue;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean testfor_b(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 2937 */     return paramLuaValue2.gt_b(0) ? lteq_b(paramLuaValue1) : gteq_b(paramLuaValue1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaString strvalue() {
/* 2945 */     b("string or number"); return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaValue strongvalue() {
/* 2951 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LuaBoolean valueOf(boolean paramBoolean) {
/* 2958 */     return paramBoolean ? TRUE : FALSE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LuaNumber valueOf(int paramInt) {
/* 2965 */     return LuaNumber.valueOf(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LuaNumber valueOf(double paramDouble) {
/* 2974 */     return LuaNumber.valueOf(paramDouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LuaString valueOf(String paramString) {
/* 2981 */     return LuaString.valueOf(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LuaString valueOf(byte[] paramArrayOfbyte) {
/* 2988 */     return LuaString.valueOf(paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LuaString valueOf(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 2998 */     return LuaString.valueOf(paramArrayOfbyte, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static LuaTable tableOf() {
/* 3004 */     return new LuaTable();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LuaTable tableOf(Varargs paramVarargs, int paramInt) {
/* 3011 */     return new LuaTable(paramVarargs, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LuaTable tableOf(int paramInt1, int paramInt2) {
/* 3018 */     return new LuaTable(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static LuaTable listOf(LuaValue[] paramArrayOfLuaValue) {
/* 3024 */     return new LuaTable(null, paramArrayOfLuaValue, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LuaTable listOf(LuaValue[] paramArrayOfLuaValue, Varargs paramVarargs) {
/* 3032 */     return new LuaTable(null, paramArrayOfLuaValue, paramVarargs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LuaTable tableOf(LuaValue[] paramArrayOfLuaValue) {
/* 3039 */     return new LuaTable(paramArrayOfLuaValue, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LuaTable tableOf(LuaValue[] paramArrayOfLuaValue1, LuaValue[] paramArrayOfLuaValue2) {
/* 3050 */     return new LuaTable(paramArrayOfLuaValue1, paramArrayOfLuaValue2, null);
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
/*      */   public static LuaTable tableOf(LuaValue[] paramArrayOfLuaValue1, LuaValue[] paramArrayOfLuaValue2, Varargs paramVarargs) {
/* 3063 */     return new LuaTable(paramArrayOfLuaValue1, paramArrayOfLuaValue2, paramVarargs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LuaUserdata userdataOf(Object paramObject) {
/* 3070 */     return new LuaUserdata(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LuaUserdata userdataOf(Object paramObject, LuaValue paramLuaValue) {
/* 3078 */     return new LuaUserdata(paramObject, paramLuaValue);
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
/*      */   protected static LuaValue c(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 3093 */     byte b = 0; while (true) {
/*      */       LuaValue luaValue;
/* 3095 */       if (paramLuaValue1.istable()) {
/*      */         LuaValue luaValue1;
/* 3097 */         if (!(luaValue1 = paramLuaValue1.rawget(paramLuaValue2)).isnil() || (luaValue = paramLuaValue1.metatag(INDEX)).isnil())
/* 3098 */           return luaValue1; 
/* 3099 */       } else if ((luaValue = paramLuaValue1.metatag(INDEX)).isnil()) {
/* 3100 */         paramLuaValue1.f(paramLuaValue2.tojstring());
/* 3101 */       }  if (luaValue.isfunction())
/* 3102 */         return luaValue.call(paramLuaValue1, paramLuaValue2); 
/* 3103 */       paramLuaValue1 = luaValue;
/*      */       
/* 3105 */       if (++b >= 100) {
/* 3106 */         error("loop in gettable");
/* 3107 */         return NIL;
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
/*      */   protected static boolean a(LuaValue paramLuaValue1, LuaValue paramLuaValue2, LuaValue paramLuaValue3) {
/* 3120 */     byte b = 0; while (true) {
/*      */       LuaValue luaValue;
/* 3122 */       if (paramLuaValue1.istable()) {
/* 3123 */         if (!paramLuaValue1.rawget(paramLuaValue2).isnil() || (luaValue = paramLuaValue1.metatag(NEWINDEX)).isnil()) {
/* 3124 */           paramLuaValue1.rawset(paramLuaValue2, paramLuaValue3);
/* 3125 */           return true;
/*      */         } 
/* 3127 */       } else if ((luaValue = paramLuaValue1.metatag(NEWINDEX)).isnil()) {
/* 3128 */         throw new LuaError("table expected for set index ('" + paramLuaValue2 + "') value, got " + paramLuaValue1.typename());
/* 3129 */       }  if (luaValue.isfunction()) {
/* 3130 */         luaValue.call(paramLuaValue1, paramLuaValue2, paramLuaValue3);
/* 3131 */         return true;
/*      */       } 
/* 3133 */       paramLuaValue1 = luaValue;
/*      */       
/* 3135 */       if (++b >= 100) {
/* 3136 */         error("loop in settable");
/* 3137 */         return false;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuaValue metatag(LuaValue paramLuaValue) {
/*      */     LuaValue luaValue;
/* 3148 */     if ((luaValue = getmetatable()) == null)
/* 3149 */       return NIL; 
/* 3150 */     return luaValue.rawget(paramLuaValue);
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
/*      */   private LuaValue a(LuaValue paramLuaValue, String paramString) {
/* 3163 */     if ((paramLuaValue = metatag(paramLuaValue)).isnil())
/* 3164 */       throw new LuaError(paramString + "a " + typename() + " value on " + getClass().getSimpleName() + " " + tojstring()); 
/* 3165 */     return paramLuaValue;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected static Metatable b(LuaValue paramLuaValue) {
/* 3171 */     if (paramLuaValue != null && paramLuaValue.istable()) {
/*      */       LuaValue luaValue;
/* 3173 */       if ((luaValue = paramLuaValue.rawget(MODE)).isstring()) {
/*      */         String str;
/* 3175 */         boolean bool2 = ((str = luaValue.tojstring()).indexOf('k') >= 0) ? true : false;
/* 3176 */         boolean bool1 = (str.indexOf('v') >= 0) ? true : false;
/* 3177 */         if (bool2 || bool1) {
/* 3178 */           return new WeakTable(bool2, bool1, paramLuaValue);
/*      */         }
/*      */       } 
/* 3181 */       return (LuaTable)paramLuaValue;
/* 3182 */     }  if (paramLuaValue != null) {
/* 3183 */       return new NonTableMetatable(paramLuaValue);
/*      */     }
/* 3185 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void f(String paramString) {
/* 3193 */     error("attempt to index ? (a " + typename() + " value) with key '" + paramString + "'");
/*      */   }
/*      */   
/*      */   public static LuaNumber cFloat(float paramFloat) {
/* 3197 */     return LuaNumber.valueOf(paramFloat);
/*      */   }
/*      */   
/*      */   public static LuaNumber cDouble(double paramDouble) {
/* 3201 */     return LuaNumber.valueOf(paramDouble);
/*      */   }
/*      */   
/*      */   public static LuaNumber cInt(int paramInt) {
/* 3205 */     return LuaNumber.valueOf(paramInt);
/*      */   }
/*      */   
/*      */   public static LuaNumber cNcInt(int paramInt) {
/* 3209 */     return LuaNumber.valueOf(paramInt);
/*      */   }
/*      */   
/*      */   public static LuaNumber cNcFloat(float paramFloat) {
/* 3213 */     return LuaNumber.valueOf(paramFloat);
/*      */   }
/*      */   
/*      */   public static LuaNumber cNcDouble(double paramDouble) {
/* 3217 */     return LuaNumber.valueOf(paramDouble);
/*      */   }
/*      */   
/*      */   public static LuaBoolean cBool(boolean paramBoolean) {
/* 3221 */     return paramBoolean ? TRUE : FALSE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LuaValue cRegObject(Object paramObject) {
/* 3232 */     return (paramObject == null) ? NIL : CoerceJavaToLua.instanceCoercion.coerce(paramObject);
/*      */   }
/*      */   
/*      */   public static boolean isRegObject(Class<?> paramClass) {
/* 3236 */     Preconditions.checkNotNull(paramClass);
/*      */     
/* 3238 */     if (paramClass == String.class) return false; 
/* 3239 */     if (paramClass == Object.class) return false; 
/* 3240 */     if (paramClass == Class.class) return false; 
/* 3241 */     if (paramClass.isAssignableFrom(LuaValue.class)) return false;
/*      */     
/* 3243 */     return true;
/*      */   }
/*      */   
/*      */   public static LuaValue cObject(Object paramObject) {
/* 3247 */     return CoerceJavaToLua.coerce(paramObject);
/*      */   }
/*      */   
/*      */   public static Varargs varargsOf(LuaValue paramLuaValue1, LuaValue paramLuaValue2, Varargs paramVarargs) {
/* 3251 */     switch (paramVarargs.narg()) { case 0:
/* 3252 */         return new Varargs.PairVarargs(paramLuaValue1, paramLuaValue2); }
/* 3253 */      return new Varargs.ArrayPartVarargs(new LuaValue[] { paramLuaValue1, paramLuaValue2 }, 0, 2, paramVarargs);
/*      */   }
/*      */   
/*      */   public static Varargs varargsOf(LuaValue paramLuaValue, Varargs paramVarargs) {
/* 3257 */     switch (paramVarargs.narg()) { case 0:
/* 3258 */         return paramLuaValue; }
/* 3259 */      return new Varargs.PairVarargs(paramLuaValue, paramVarargs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static Varargs varargsOf(LuaValue[] paramArrayOfLuaValue, int paramInt1, int paramInt2, Varargs paramVarargs) {
/* 3264 */     switch (paramInt2) { case 0:
/* 3265 */         return paramVarargs;
/* 3266 */       case 1: if (paramVarargs.narg() > 0)
/* 3267 */           return new Varargs.PairVarargs(paramArrayOfLuaValue[paramInt1], paramVarargs); 
/* 3268 */         return paramArrayOfLuaValue[paramInt1];
/* 3269 */       case 2: if (paramVarargs.narg() > 0)
/* 3270 */           return new Varargs.ArrayPartVarargs(paramArrayOfLuaValue, paramInt1, paramInt2, paramVarargs); 
/* 3271 */         return new Varargs.PairVarargs(paramArrayOfLuaValue[paramInt1], paramArrayOfLuaValue[paramInt1 + 1]); }
/* 3272 */      return new Varargs.ArrayPartVarargs(paramArrayOfLuaValue, paramInt1, paramInt2, paramVarargs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static Varargs varargsOf(LuaValue[] paramArrayOfLuaValue, int paramInt1, int paramInt2) {
/* 3277 */     switch (paramInt2) { case 0:
/* 3278 */         return NONE;
/* 3279 */       case 1: return paramArrayOfLuaValue[paramInt1];
/* 3280 */       case 2: return new Varargs.PairVarargs(paramArrayOfLuaValue[paramInt1], paramArrayOfLuaValue[paramInt1 + 1]); }
/* 3281 */      return new Varargs.ArrayPartVarargs(paramArrayOfLuaValue, paramInt1, paramInt2, NONE);
/*      */   }
/*      */ 
/*      */   
/*      */   public static Varargs varargsOf(LuaValue[] paramArrayOfLuaValue, Varargs paramVarargs) {
/* 3286 */     switch (paramArrayOfLuaValue.length) { case 0:
/* 3287 */         return paramVarargs;
/* 3288 */       case 1: if (paramVarargs.narg() > 0)
/* 3289 */           return new Varargs.PairVarargs(paramArrayOfLuaValue[0], paramVarargs); 
/* 3290 */         return paramArrayOfLuaValue[0];
/* 3291 */       case 2: if (paramVarargs.narg() > 0)
/* 3292 */           return new Varargs.ArrayVarargs(paramArrayOfLuaValue, paramVarargs); 
/* 3293 */         return new Varargs.PairVarargs(paramArrayOfLuaValue[0], paramArrayOfLuaValue[1]); }
/* 3294 */      return new Varargs.ArrayVarargs(paramArrayOfLuaValue, paramVarargs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static Varargs varargsOf(LuaValue[] paramArrayOfLuaValue) {
/* 3299 */     switch (paramArrayOfLuaValue.length) { case 0:
/* 3300 */         return NONE;
/* 3301 */       case 1: return paramArrayOfLuaValue[0];
/* 3302 */       case 2: return new Varargs.PairVarargs(paramArrayOfLuaValue[0], paramArrayOfLuaValue[1]); }
/* 3303 */      return new Varargs.ArrayVarargs(paramArrayOfLuaValue, NONE);
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
/*      */   public static Varargs tailcallOf(LuaValue paramLuaValue, Varargs paramVarargs) {
/* 3324 */     return new TailcallVarargs(paramLuaValue, paramVarargs);
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
/*      */   public Varargs onInvoke(Varargs paramVarargs) {
/* 3342 */     return invoke(paramVarargs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void initupvalue1(LuaValue paramLuaValue) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS(serializer = None.Serializer.class)
/*      */   public static final class None
/*      */     extends LuaNil
/*      */   {
/* 3361 */     static None b = new None();
/*      */     
/*      */     public static class Serializer extends SingletonSerializer<None> {
/*      */       public Serializer() {
/* 3365 */         setImmutable(true);
/*      */       }
/*      */ 
/*      */       
/*      */       public LuaValue.None read() {
/* 3370 */         return LuaValue.None.b;
/*      */       }
/*      */     }
/*      */     
/* 3374 */     public final LuaValue arg(int param1Int) { return NIL; }
/* 3375 */     public final int narg() { return 0; }
/* 3376 */     public final LuaValue arg1() { return NIL; }
/* 3377 */     public final String tojstring() { return "none"; }
/* 3378 */     public final Varargs subargs(int param1Int) { return (param1Int > 0) ? this : argerror(1, "start must be > 0"); } final void a(LuaValue[] param1ArrayOfLuaValue, int param1Int1, int param1Int2) {
/* 3379 */       while (param1Int2 > 0) { param1ArrayOfLuaValue[param1Int1++] = NIL; param1Int2--; }
/*      */     
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Varargs subargs(int paramInt) {
/* 3388 */     if (paramInt == 1)
/* 3389 */       return this; 
/* 3390 */     if (paramInt > 1)
/* 3391 */       return NONE; 
/* 3392 */     return argerror(1, "start must be > 0");
/*      */   }
/*      */   
/*      */   public abstract int type();
/*      */   
/*      */   public abstract String typename();
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\LuaValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */