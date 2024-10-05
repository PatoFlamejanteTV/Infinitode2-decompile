/*     */ package com.prineside.tdi2.managers;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.luaj.Globals;
/*     */ import com.prineside.luaj.LuaString;
/*     */ import com.prineside.luaj.LuaTable;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.lib.jse.CoerceJavaToLua;
/*     */ import com.prineside.luaj.lib.jse.JavaClass;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.managers.script.ClassTreeLuaTable;
/*     */ import com.prineside.tdi2.managers.script.GlobalCLuaTable;
/*     */ import com.prineside.tdi2.managers.script.MathEnvironment;
/*     */ import com.prineside.tdi2.managers.script.ScriptEnvironment;
/*     */ import com.prineside.tdi2.managers.script.Whitelist;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Scanner;
/*     */ 
/*     */ @REGS(serializer = ScriptManager.Serializer.class)
/*     */ public class ScriptManager
/*     */   extends Manager.ManagerAdapter
/*     */ {
/*  35 */   private static final TLog a = TLog.forClass(ScriptManager.class); public static final String WHITELIST_FILE_PATH = "res/luaj/whitelist.txt"; public static final String CLASS_ALIASES_FILE_PATH = "res/luaj/lua-class-aliases.txt"; public ScriptEnvironment global;
/*     */   public MathEnvironment math;
/*     */   private Whitelist b;
/*     */   private volatile LuaTable c;
/*     */   private GlobalCLuaTable d;
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<ScriptManager> { public ScriptManager read() {
/*  42 */       return Game.i.scriptManager;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ScriptManager() {
/*  55 */     Threads.i().runAsync(this::a);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setup() {
/*  60 */     this.global = new ScriptEnvironment();
/*  61 */     this.global.initialize();
/*  62 */     this.global.loadScriptsInDir("scripts/global");
/*  63 */     a.i("global environment init", new Object[0]);
/*     */     
/*  65 */     this.math = new MathEnvironment();
/*     */   }
/*     */   
/*     */   public static Array<String> getPackagesToScanFromConfig() {
/*  69 */     Scanner scanner = new Scanner(new File("res/luaj/packages-to-scan.txt"));
/*  70 */     Array<String> array = new Array(true, 1, String.class);
/*  71 */     while (scanner.hasNextLine()) {
/*     */       String str;
/*  73 */       if ((str = scanner.nextLine().trim()).length() != 0) {
/*  74 */         array.add(str);
/*     */       }
/*     */     } 
/*  77 */     scanner.close();
/*  78 */     return array;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void restoreClassTreePath(String paramString, ClassTreeLuaTable paramClassTreeLuaTable) {
/*     */     try {
/*  85 */       String[] arrayOfString = paramString.split("\\.");
/*  86 */       LuaTable luaTable = getLuaPackageDefinitions(); int i; byte b;
/*  87 */       for (i = (arrayOfString = arrayOfString).length, b = 0; b < i; ) { String str = arrayOfString[b];
/*  88 */         luaTable = (LuaTable)luaTable.get(str); b++; }
/*     */       
/*  90 */       paramClassTreeLuaTable.loadFrom((LuaValue)luaTable); return;
/*  91 */     } catch (Exception exception) {
/*  92 */       a.e("failed to restore package table " + paramString, new Object[] { exception });
/*     */       return;
/*     */     } 
/*     */   }
/*     */   private synchronized void a() {
/*  97 */     if (this.c == null) {
/*  98 */       a.i("generating luaPackageDefinitions", new Object[0]);
/*     */       
/* 100 */       HashMap<Object, Object> hashMap1 = new HashMap<>(); 
/* 101 */       try { BufferedReader bufferedReader = new BufferedReader(AssetManager.localOrInternalFile("res/luaj/forced-class-aliases.txt").reader("UTF-8")); 
/* 102 */         try { byte b = 1;
/*     */           
/*     */           String str;
/* 105 */           while ((str = bufferedReader.readLine()) != null) {
/*     */ 
/*     */ 
/*     */             
/* 109 */             if ((str = str.trim()).length() != 0)
/* 110 */               if (str.charAt(0) != '#')
/*     */               { String[] arrayOfString;
/* 112 */                 if ((arrayOfString = str.split("=")).length != 2) {
/* 113 */                   throw new IllegalArgumentException("Invalid definition at line " + b + " in res/luaj/forced-class-aliases.txt");
/*     */                 }
/*     */                 try {
/* 116 */                   Class<?> clazz = Class.forName(arrayOfString[1].trim());
/* 117 */                   hashMap1.put(arrayOfString[0].trim(), clazz);
/* 118 */                 } catch (Exception exception) {
/* 119 */                   a.w("Class " + arrayOfString[1].trim() + " defined at line " + b + " of forced-class-aliases.txt not found and won't be aliased in _G.C", new Object[0]);
/*     */                 }  }
/*     */               else { continue; }
/* 122 */                 b++;
/*     */           } 
/* 124 */           bufferedReader.close(); } catch (Throwable throwable) { try { bufferedReader.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }  } catch (Exception exception)
/* 125 */       { a.e("Failed to read res/luaj/forced-class-aliases.txt", new Object[] { exception }); }
/*     */ 
/*     */       
/* 128 */       HashMap<Object, Object> hashMap2 = new HashMap<>();
/* 129 */       LuaTable luaTable1 = new LuaTable(); 
/* 130 */       try { BufferedReader bufferedReader = new BufferedReader(AssetManager.localOrInternalFile("res/luaj/class-list.txt").reader("UTF-8"));
/*     */         
/*     */         try { String str;
/* 133 */           while ((str = bufferedReader.readLine()) != null) {
/*     */ 
/*     */ 
/*     */             
/* 137 */             if ((str = str.trim()).length() != 0 && str.charAt(0) != '#') {
/*     */               try {
/*     */                 Class<?> clazz;
/* 140 */                 String[] arrayOfString = (clazz = Class.forName(str)).getName().split("\\.");
/* 141 */                 StringBuilder stringBuilder = new StringBuilder();
/* 142 */                 LuaTable luaTable4 = luaTable1;
/* 143 */                 for (byte b = 0; b < arrayOfString.length - 1; b++) {
/* 144 */                   LuaTable luaTable; if (stringBuilder.length != 0) {
/* 145 */                     stringBuilder.append(".");
/*     */                   }
/* 147 */                   String str3 = arrayOfString[b];
/* 148 */                   stringBuilder.append(str3);
/*     */                   
/*     */                   LuaValue luaValue;
/*     */                   
/* 152 */                   if ((luaValue = luaTable4.get((LuaValue)LuaString.valueOf(str3))).isnil()) {
/* 153 */                     luaTable = new LuaTable();
/* 154 */                     luaTable4.set((LuaValue)LuaString.valueOf(str3), (LuaValue)luaTable);
/* 155 */                     luaTable.set((LuaValue)LuaString.valueOf("_noSerialization"), (LuaValue)LuaValue.TRUE);
/* 156 */                     luaTable.set((LuaValue)LuaString.valueOf("_noSyncCheck"), (LuaValue)LuaValue.TRUE);
/* 157 */                     luaTable.set((LuaValue)LuaString.valueOf("_classTreePath"), (LuaValue)LuaString.valueOf(stringBuilder.toString()));
/*     */                   } else {
/* 159 */                     luaTable = luaValue.checktable();
/*     */                   } 
/* 161 */                   luaTable4 = luaTable;
/*     */                 } 
/*     */                 
/* 164 */                 String str1 = arrayOfString[arrayOfString.length - 1].replaceAll("\\$", "_");
/*     */                 
/*     */                 LuaTable luaTable5;
/* 167 */                 (luaTable5 = new LuaTable()).set((LuaValue)LuaString.valueOf("class"), CoerceJavaToLua.coerce(clazz));
/* 168 */                 luaTable4.set((LuaValue)LuaValue.valueOf(str1), (LuaValue)luaTable5);
/*     */                 
/* 170 */                 String str2 = clazz.getSimpleName();
/*     */                 Array array;
/* 172 */                 if ((array = (Array)hashMap2.get(str2)) == null) {
/*     */                   
/* 174 */                   (array = new Array(true, 1, Class.class)).add(clazz);
/* 175 */                   hashMap2.put(str2, array); continue;
/*     */                 } 
/* 177 */                 array.add(clazz);
/*     */               }
/* 179 */               catch (Exception exception) {}
/*     */             }
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 186 */           bufferedReader.close(); } catch (Throwable throwable) { try { bufferedReader.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }  } catch (Exception exception)
/* 187 */       { a.e("Failed to read res/luaj/class-list.txt", new Object[] { exception }); }
/*     */ 
/*     */       
/*     */       LuaTable luaTable2;
/*     */       
/* 192 */       (luaTable2 = luaTable1.get("java").checktable()).set("int", CoerceJavaToLua.coerce(int.class));
/* 193 */       luaTable2.set("byte", CoerceJavaToLua.coerce(byte.class));
/* 194 */       luaTable2.set("short", CoerceJavaToLua.coerce(short.class));
/* 195 */       luaTable2.set("long", CoerceJavaToLua.coerce(long.class));
/* 196 */       luaTable2.set("float", CoerceJavaToLua.coerce(float.class));
/* 197 */       luaTable2.set("double", CoerceJavaToLua.coerce(double.class));
/* 198 */       luaTable2.set("boolean", CoerceJavaToLua.coerce(boolean.class));
/* 199 */       luaTable2.set("char", CoerceJavaToLua.coerce(char.class));
/*     */ 
/*     */       
/* 202 */       LuaTable luaTable3 = new LuaTable();
/* 203 */       for (null = hashMap2.entrySet().iterator(); null.hasNext();) {
/* 204 */         if (((Array)(entry = null.next()).getValue()).size == 1)
/*     */         {
/* 206 */           luaTable3.set((String)entry.getKey(), (LuaValue)JavaClass.forClass((Class)((Array)entry.getValue()).first()));
/*     */         }
/*     */       } 
/* 209 */       for (Map.Entry<Object, Object> entry : hashMap1.entrySet()) {
/* 210 */         luaTable3.set((String)entry.getKey(), (LuaValue)JavaClass.forClass((Class)entry.getValue()));
/*     */       }
/* 212 */       this.d = new GlobalCLuaTable((LuaValue)luaTable3);
/* 213 */       SyncChecker.addSyncShareableObject(this.d);
/* 214 */       this.c = luaTable1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public LuaTable getLuaPackageDefinitions() {
/* 219 */     a();
/* 220 */     return this.c;
/*     */   }
/*     */   
/*     */   public GlobalCLuaTable getGlobalCTable() {
/* 224 */     a();
/* 225 */     return this.d;
/*     */   }
/*     */   public void fillGlobalsWithClassDefinitions(Globals paramGlobals) {
/*     */     LuaTable luaTable;
/*     */     LuaValue[] arrayOfLuaValue;
/*     */     int i;
/*     */     byte b;
/* 232 */     for (i = (arrayOfLuaValue = (luaTable = getLuaPackageDefinitions()).keys()).length, b = 0; b < i; ) { LuaValue luaValue = arrayOfLuaValue[b];
/* 233 */       paramGlobals.set(luaValue, (LuaValue)new ClassTreeLuaTable(luaTable.get(luaValue)));
/*     */       b++; }
/*     */     
/* 236 */     paramGlobals.set((LuaValue)LuaString.valueOf("C"), (LuaValue)getGlobalCTable());
/*     */   }
/*     */   
/*     */   public Whitelist getWhitelist() {
/* 240 */     if (this.b == null) {
/* 241 */       a.i("loading LuaJ whitelist from file...", new Object[0]);
/* 242 */       long l = Game.getRealTickCount();
/*     */       try {
/* 244 */         this.b = Whitelist.fromFile(AssetManager.localOrInternalFile("res/luaj/whitelist.txt"));
/* 245 */       } catch (IOException iOException) {
/* 246 */         throw new IllegalArgumentException("Failed to read from LuaJ whitelist", iOException);
/*     */       } 
/* 248 */       a.i("whitelist loaded in " + ((float)(Game.getRealTickCount() - iOException) / 1000.0F) + "ms", new Object[0]);
/*     */     } 
/* 250 */     return this.b;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\ScriptManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */