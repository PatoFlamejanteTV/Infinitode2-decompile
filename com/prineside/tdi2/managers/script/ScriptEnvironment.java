/*     */ package com.prineside.tdi2.managers.script;
/*     */ 
/*     */ import com.badlogic.gdx.Files;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.luaj.Globals;
/*     */ import com.prineside.luaj.LoadState;
/*     */ import com.prineside.luaj.LuaError;
/*     */ import com.prineside.luaj.LuaString;
/*     */ import com.prineside.luaj.LuaTable;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.Varargs;
/*     */ import com.prineside.luaj.compiler.LuaC;
/*     */ import com.prineside.luaj.lib.Bit32Lib;
/*     */ import com.prineside.luaj.lib.DebugLib;
/*     */ import com.prineside.luaj.lib.PackageLib;
/*     */ import com.prineside.luaj.lib.StringLib;
/*     */ import com.prineside.luaj.lib.TableLib;
/*     */ import com.prineside.luaj.lib.jse.JavaClass;
/*     */ import com.prineside.luaj.lib.jse.JavaInstance;
/*     */ import com.prineside.luaj.lib.jse.JseBaseLib;
/*     */ import com.prineside.luaj.lib.jse.JseMathLib;
/*     */ import com.prineside.luaj.lib.jse.JseOsLib;
/*     */ import com.prineside.luaj.lib.jse.LuajavaLib;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.managers.script.autocompletion.LuaScriptParser;
/*     */ import com.prineside.tdi2.utils.ObjectPair;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ 
/*     */ @REGS
/*     */ public class ScriptEnvironment
/*     */   implements KryoSerializable
/*     */ {
/*  46 */   private static final TLog a = TLog.forClass(ScriptEnvironment.class);
/*     */   
/*     */   private Globals b;
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  52 */     paramKryo.writeObject(paramOutput, this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  57 */     this.b = (Globals)paramKryo.readObject(paramInput, Globals.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a() {
/*  63 */     if (this.b == null) {
/*  64 */       throw new IllegalStateException("Script environment not initialized yet");
/*     */     }
/*     */   }
/*     */   
/*     */   public void initialize() {
/*  69 */     if (this.b == null) {
/*     */       
/*  71 */       this.b = new Globals();
/*  72 */       this.b.load((LuaValue)new JseBaseLib());
/*  73 */       this.b.load((LuaValue)new PackageLib());
/*  74 */       this.b.load((LuaValue)new JseOsLib());
/*  75 */       this.b.load((LuaValue)new Bit32Lib());
/*  76 */       this.b.load((LuaValue)new TableLib());
/*  77 */       this.b.load((LuaValue)new StringLib());
/*     */       
/*  79 */       this.b.load((LuaValue)new JseMathLib());
/*     */ 
/*     */       
/*  82 */       this.b.load((LuaValue)new LuajavaLib());
/*     */       
/*  84 */       this.b.load((LuaValue)new DebugLib());
/*  85 */       LoadState.install(this.b);
/*     */       
/*  87 */       LuaC luaC = new LuaC();
/*  88 */       this.b.compiler = (Globals.Compiler)luaC;
/*  89 */       this.b.loader = (Globals.Loader)luaC;
/*     */       
/*  91 */       Game.i.scriptManager.fillGlobalsWithClassDefinitions(this.b);
/*     */ 
/*     */       
/*  94 */       loadScriptsInDir("scripts");
/*     */     } 
/*     */   }
/*     */   @Null
/*     */   private Object a(LuaValue paramLuaValue, Array<String> paramArray) {
/*  99 */     if (paramArray.size == 0) {
/* 100 */       return paramLuaValue;
/*     */     }
/*     */     
/* 103 */     String str = (String)paramArray.peek();
/*     */ 
/*     */ 
/*     */     
/* 107 */     if ((paramLuaValue = paramLuaValue.get(str)) != null && !paramLuaValue.isnil()) {
/*     */       
/* 109 */       (paramArray = new Array(paramArray)).pop();
/* 110 */       return a(paramLuaValue, paramArray);
/*     */     } 
/* 112 */     return null;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public Suggestion getAutocompletion(String paramString, int paramInt) {
/*     */     try {
/*     */       String[] arrayOfString;
/* 119 */       if ((arrayOfString = (new LuaScriptParser(paramString)).getACStringAt(paramInt)) == null || arrayOfString.length == 0) {
/* 120 */         return null;
/*     */       }
/*     */       
/*     */       Array<String> array;
/* 124 */       (array = new Array((Object[])arrayOfString)).pop();
/* 125 */       array.reverse();
/*     */       Object object;
/* 127 */       if ((object = a((LuaValue)this.b, array)) == null) {
/* 128 */         return null;
/*     */       }
/*     */       
/*     */       Suggestion suggestion;
/*     */       
/* 133 */       (suggestion = new Suggestion()).start = 0;
/* 134 */       String str = arrayOfString[arrayOfString.length - 1];
/* 135 */       for (paramInt -= str.length(); paramInt >= 0; paramInt--) {
/*     */         char c;
/* 137 */         if ((c = paramString.charAt(paramInt)) == ' ' || c == ':' || c == '.' || c == '(' || c == '=') {
/* 138 */           suggestion.start = paramInt + 1;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */       
/* 144 */       if (object instanceof LuaTable) {
/* 145 */         LuaValue luaValue = LuaValue.NIL;
/* 146 */         LuaTable luaTable = (LuaTable)object;
/*     */         
/*     */         Varargs varargs;
/* 149 */         while (!(luaValue = (varargs = luaTable.next(luaValue)).arg1()).isnil()) {
/* 150 */           object = varargs.arg(2);
/* 151 */           if (luaValue.isstring()) {
/* 152 */             String str1 = luaValue.tojstring();
/*     */             
/* 154 */             if (str.length() == 0 || str1.startsWith(str)) {
/* 155 */               suggestion.variants.add(new ObjectPair(str1, object.typename()));
/*     */             }
/*     */           }
/*     */         
/*     */         } 
/* 160 */       } else if (object instanceof JavaClass) {
/*     */         JavaClass javaClass;
/* 162 */         for (ObjectMap.Entries<ObjectMap.Entry> entries = (javaClass = (JavaClass)object).getClassFields().iterator(); entries.hasNext();) {
/* 163 */           if (((LuaString)(entry = entries.next()).key).tojstring().startsWith(str)) {
/* 164 */             suggestion.variants.add(new ObjectPair(((LuaString)entry.key).tojstring(), ((Field)entry.value).getType().getSimpleName()));
/*     */           }
/*     */         } 
/* 167 */         for (Iterator<Map.Entry> iterator = javaClass.getClassMethods().entrySet().iterator(); iterator.hasNext();) {
/* 168 */           if (((LuaString)(entry = iterator.next()).getKey()).tojstring().startsWith(str)) {
/* 169 */             suggestion.variants.add(new ObjectPair(((LuaString)entry.getKey()).tojstring(), "method"));
/*     */           }
/*     */         } 
/*     */       } else {
/*     */         JavaInstance javaInstance;
/*     */         JavaClass javaClass;
/* 175 */         for (ObjectMap.Entries<ObjectMap.Entry> entries = (javaClass = (javaInstance = (JavaInstance)object).getJavaClass()).getInstanceFields().iterator(); entries.hasNext();) {
/* 176 */           if (((LuaString)((ObjectMap.Entry)(object = entries.next())).key).tojstring().startsWith(str)) {
/* 177 */             suggestion.variants.add(new ObjectPair(((LuaString)((ObjectMap.Entry)object).key).tojstring(), ((Field)((ObjectMap.Entry)object).value).getType().getSimpleName()));
/*     */           }
/*     */         } 
/* 180 */         for (Iterator<Map.Entry> iterator = javaClass.getInstanceMethods().entrySet().iterator(); iterator.hasNext();) {
/* 181 */           if (((LuaString)(object = iterator.next()).getKey()).tojstring().startsWith(str)) {
/* 182 */             suggestion.variants.add(new ObjectPair(((LuaString)object.getKey()).tojstring(), "method"));
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 187 */       suggestion.variants.sort((paramObjectPair1, paramObjectPair2) -> ((String)paramObjectPair1.first).compareTo((String)paramObjectPair2.first));
/*     */       
/* 189 */       return suggestion;
/* 190 */     } catch (Exception exception) {
/* 191 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadScriptsInDir(String paramString) {
/* 197 */     Array array = new Array(true, 1, FileHandle.class);
/*     */     
/* 199 */     if (Gdx.files.local(paramString).exists()) {
/*     */       FileHandle[] arrayOfFileHandle1; int j; byte b;
/* 201 */       for (j = (arrayOfFileHandle1 = arrayOfFileHandle1 = Gdx.files.local(paramString).list()).length, b = 0; b < j; b++) {
/* 202 */         FileHandle fileHandle; if (!(fileHandle = arrayOfFileHandle1[b]).isDirectory()) {
/* 203 */           array.add(fileHandle);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     FileHandle[] arrayOfFileHandle;
/*     */     int i;
/*     */     byte b2;
/* 210 */     for (i = (arrayOfFileHandle = arrayOfFileHandle = Gdx.files.internal(paramString).list()).length, b2 = 0; b2 < i; b2++) {
/* 211 */       FileHandle fileHandle; if (!(fileHandle = arrayOfFileHandle[b2]).isDirectory()) {
/* 212 */         boolean bool = false;
/* 213 */         for (byte b = 0; b < array.size; b++) {
/* 214 */           if (((FileHandle[])array.items)[b].path().equals(fileHandle.path())) {
/* 215 */             bool = true;
/*     */             break;
/*     */           } 
/*     */         } 
/* 219 */         if (!bool) array.add(fileHandle);
/*     */       
/*     */       } 
/*     */     } 
/*     */     
/* 224 */     for (byte b1 = 0; b1 < array.size; b1++) {
/* 225 */       for (i = b1 + 1; i < array.size; i++) {
/* 226 */         if (((FileHandle[])array.items)[b1].name().compareTo(((FileHandle[])array.items)[i].name()) > 0) {
/* 227 */           array.swap(b1, i);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 232 */     for (Array.ArrayIterator<FileHandle> arrayIterator = array.iterator(); arrayIterator.hasNext();) {
/* 233 */       if (!(fileHandle = arrayIterator.next()).name().startsWith("_"))
/*     */         try {
/* 235 */           loadScript(fileHandle);
/*     */         }
/* 237 */         catch (Exception exception) {
/* 238 */           a.e("Failed to load script: " + fileHandle.name(), new Object[] { exception });
/*     */         }  
/*     */     } 
/*     */   }
/*     */   
/*     */   public Globals getGlobals() {
/* 244 */     a();
/*     */     
/* 246 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaExecutionResult loadScript(FileHandle paramFileHandle) {
/* 253 */     String str = (paramFileHandle.type() == Files.FileType.Classpath) ? ("[CP] " + paramFileHandle.path()) : paramFileHandle.path();
/* 254 */     return executeLua(paramFileHandle.readString("UTF-8"), str);
/*     */   }
/*     */   
/*     */   public LuaExecutionResult executeLua(String paramString1, String paramString2) {
/* 258 */     a();
/*     */     
/* 260 */     LuaExecutionResult luaExecutionResult = new LuaExecutionResult();
/*     */     try {
/* 262 */       LuaValue luaValue = this.b.load(paramString1, paramString2);
/* 263 */       luaExecutionResult.returnValue = luaValue.call();
/* 264 */     } catch (LuaError luaError) {
/* 265 */       handleLuaError((LuaError)(paramString2 = null));
/* 266 */       luaExecutionResult.caughtError = (Throwable)paramString2;
/* 267 */     } catch (Exception exception) {
/* 268 */       a.e("executeLua() failed for string:\n" + paramString1, new Object[] { exception });
/*     */       
/* 270 */       luaExecutionResult.caughtError = exception;
/*     */     } 
/*     */     
/* 273 */     return luaExecutionResult;
/*     */   }
/*     */   
/*     */   public static void handleLuaError(LuaError paramLuaError) {
/*     */     String str;
/* 278 */     if ((str = paramLuaError.getFileline()) != null) {
/* 279 */       if (str.startsWith("ScriptTile[")) {
/*     */         
/* 281 */         a.e("error in script tile: %s", new Object[] { str });
/*     */ 
/*     */         
/*     */         try {
/* 285 */           if (Game.i.screenManager.getCurrentScreen() instanceof com.prineside.tdi2.screens.GameScreen) {
/* 286 */             Game.i.screenManager.getCurrentScreen();
/*     */           }
/*     */         }
/* 289 */         catch (Exception exception) {}
/* 290 */       } else if (str.startsWith("@")) {
/*     */         
/* 292 */         a.e("error in file: %s", new Object[] { str });
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 312 */     if (Game.i.settingsManager != null && Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_PRINT_FULL_LUA_STACKTRACES) == 0.0D) {
/* 313 */       a.e("Lua error at %s: %s", new Object[] { paramLuaError.getFileline(), paramLuaError.getMessage() }); return;
/*     */     } 
/* 315 */     a.e("Lua error at %s", new Object[] { paramLuaError.getFileline(), paramLuaError });
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 320 */     this.b = null;
/*     */   }
/*     */   
/*     */   public static class LuaExecutionResult {
/*     */     public LuaValue returnValue;
/*     */     public Throwable caughtError;
/*     */   }
/*     */   
/*     */   public static final class Suggestion {
/*     */     public int start;
/* 330 */     public Array<ObjectPair<String, String>> variants = new Array();
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 334 */       return "@" + this.start + ":" + this.variants.toString("|");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\script\ScriptEnvironment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */