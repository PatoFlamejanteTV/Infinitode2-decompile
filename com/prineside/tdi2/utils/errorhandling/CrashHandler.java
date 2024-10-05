/*     */ package com.prineside.tdi2.utils.errorhandling;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.net.HttpParametersUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.ActionResolver;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.HeadlessReplayValidationGame;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.screens.GameScreen;
/*     */ import com.prineside.tdi2.utils.FileIntegrityChecker;
/*     */ import com.prineside.tdi2.utils.logging.Logger;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Properties;
/*     */ import java.util.Set;
/*     */ import java.util.WeakHashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CrashHandler
/*     */ {
/*  39 */   private static final TLog a = TLog.forClass(CrashHandler.class);
/*     */ 
/*     */ 
/*     */   
/*  43 */   private static long b = 0L;
/*     */   
/*  45 */   private static final Set<Thread> c = Collections.newSetFromMap(new WeakHashMap<>());
/*     */ 
/*     */ 
/*     */   
/*     */   private static ActionResolver d;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setActionResolver(ActionResolver paramActionResolver) {
/*  55 */     Preconditions.checkNotNull(paramActionResolver);
/*  56 */     d = paramActionResolver;
/*  57 */     handleThreadExceptions(Thread.currentThread());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isThreadExceptionsHandled(Thread paramThread) {
/*  66 */     return c.contains(paramThread);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void handleThreadExceptions(Thread paramThread) {
/*  74 */     a(paramThread, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void handleThreadExceptionsForgiving(Thread paramThread) {
/*  82 */     a(paramThread, false);
/*     */   }
/*     */   
/*     */   private static void a(Thread paramThread, boolean paramBoolean) {
/*  86 */     if (isThreadExceptionsHandled(paramThread))
/*     */       return; 
/*  88 */     if (d == null) {
/*  89 */       throw new IllegalStateException("actionResolver not set yet");
/*     */     }
/*  91 */     d.handleThreadExceptions(paramThread);
/*  92 */     c.add(paramThread);
/*     */     
/*  94 */     Thread.UncaughtExceptionHandler uncaughtExceptionHandler = paramThread.getUncaughtExceptionHandler();
/*  95 */     paramThread.setUncaughtExceptionHandler((paramThread, paramThrowable) -> {
/*     */           a(paramThread, paramThrowable);
/*     */           if (paramUncaughtExceptionHandler != null) {
/*     */             paramUncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable);
/*     */           }
/*     */           if (paramBoolean) {
/*     */             Game.exit();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private static void a(Thread paramThread, Throwable paramThrowable) {
/*     */     try {
/* 108 */       Json json = new Json(JsonWriter.OutputType.json);
/* 109 */       StringWriter stringWriter1 = new StringWriter();
/* 110 */       json.setWriter(stringWriter1);
/*     */       
/* 112 */       json.writeObjectStart();
/* 113 */       json.writeValue("type", paramThrowable.getClass().getName());
/* 114 */       json.writeValue("thread", paramThread.getName());
/* 115 */       json.writeValue("message", paramThrowable.getMessage());
/*     */       
/* 117 */       StringWriter stringWriter2 = new StringWriter();
/* 118 */       PrintWriter printWriter = new PrintWriter(stringWriter2);
/* 119 */       paramThrowable.printStackTrace(printWriter);
/*     */       
/* 121 */       json.writeValue("stacktrace", stringWriter2.toString());
/* 122 */       json.writeObjectEnd();
/*     */       
/* 124 */       Gdx.files.local("cache/crash-report.json").writeString(stringWriter1.toString(), false, "UTF-8");
/* 125 */       a.i("Crash report saved", new Object[0]);
/* 126 */     } catch (Exception exception) {
/* 127 */       a.e("Failed to write crash report", new Object[] { exception });
/*     */     } 
/*     */     
/* 130 */     a.e("Uncaught exception in thread " + paramThread.getName() + " (" + paramThrowable.getMessage() + ")", new Object[] { paramThrowable });
/*     */     
/*     */     try {
/*     */       FileHandle fileHandle;
/*     */       
/* 135 */       OutputStream outputStream = (fileHandle = Gdx.files.local("exceptions.log")).write(true);
/*     */       PrintWriter printWriter;
/* 137 */       (printWriter = new PrintWriter(outputStream)).append((new Date()).toString()).append("\n");
/* 138 */       printWriter.append("Exception in thread ").append(paramThread.getName()).append(":\n");
/* 139 */       paramThrowable.printStackTrace(printWriter);
/* 140 */       if (Game.i instanceof HeadlessReplayValidationGame) {
/* 141 */         HeadlessReplayValidationGame headlessReplayValidationGame = (HeadlessReplayValidationGame)Game.i;
/* 142 */         printWriter.append("\nReplay: ").append(headlessReplayValidationGame.currentReplay);
/*     */       } 
/* 144 */       printWriter.append("\n\n");
/* 145 */       printWriter.close();
/* 146 */     } catch (Exception exception) {}
/*     */     
/* 148 */     if (!Config.isHeadless())
/*     */     {
/* 150 */       report("UE in " + paramThread.getName() + ": " + paramThrowable.getMessage(), paramThrowable);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void report(String paramString) {
/* 155 */     report(paramString, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void report(String paramString, Throwable paramThrowable) {
/* 165 */     if (Game.getRealTickCount() - b < 500000L) {
/* 166 */       a.i("Cancelled report - too frequent", new Object[0]);
/*     */       
/*     */       return;
/*     */     } 
/* 170 */     if (Game.i.actionResolver.isAppModified()) {
/* 171 */       a.i("Cancelled report - app is modified", new Object[0]);
/*     */       
/*     */       return;
/*     */     } 
/* 175 */     if (Config.isModdingMode()) {
/* 176 */       a.i("Cancelled report - modding mode", new Object[0]);
/*     */       
/*     */       return;
/*     */     } 
/* 180 */     if (Config.isHeadless()) {
/* 181 */       a.i("Cancelled report - headless mode", new Object[0]);
/*     */       
/*     */       return;
/*     */     } 
/* 185 */     if (Game.isLoaded() && 
/* 186 */       !Game.i.settingsManager.isBugReportsEnabled()) {
/* 187 */       a.i("Cancelled report - disabled", new Object[0]);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 192 */     b = Game.getRealTickCount();
/*     */     
/* 194 */     Json json = new Json(JsonWriter.OutputType.json);
/* 195 */     StringWriter stringWriter = new StringWriter();
/* 196 */     json.setWriter(stringWriter);
/* 197 */     json.writeObjectStart();
/* 198 */     json.writeValue("current", Thread.currentThread().getName());
/* 199 */     json.writeArrayStart("threads");
/*     */     try {
/*     */       Set<Thread> set;
/* 202 */       for (Iterator<Thread> iterator = (set = Thread.getAllStackTraces().keySet()).iterator(); iterator.hasNext();) {
/* 203 */         if (isThreadExceptionsHandled(thread = iterator.next()))
/*     */         
/*     */         { 
/* 206 */           json.writeObjectStart();
/* 207 */           json.writeValue("name", thread.getName());
/* 208 */           json.writeValue("state", thread.getState().name());
/* 209 */           json.writeArrayStart("trace");
/* 210 */           byte b1 = 0; StackTraceElement[] arrayOfStackTraceElement; int i; byte b2;
/* 211 */           for (i = (arrayOfStackTraceElement = thread.getStackTrace()).length, b2 = 0; b2 < i; ) { StackTraceElement stackTraceElement = arrayOfStackTraceElement[b2];
/* 212 */             json.writeValue(stackTraceElement.toString());
/* 213 */             b1++;
/* 214 */             if (b1 != 5)
/*     */               b2++;  }
/* 216 */            json.writeArrayEnd();
/* 217 */           json.writeObjectEnd(); } 
/*     */       } 
/* 219 */     } catch (Exception exception) {}
/* 220 */     json.writeObjectEnd();
/* 221 */     json.writeObjectEnd();
/*     */     
/*     */     try {
/*     */       Net.HttpRequest httpRequest;
/* 225 */       (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.LOGGER_REPORT_URL);
/* 226 */       HashMap<Object, Object> hashMap = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 247 */       String str1 = "?";
/* 248 */       String str2 = "unknown";
/* 249 */       StringBuilder stringBuilder = new StringBuilder();
/* 250 */       if (Game.i.isInMainThread()) {
/*     */         try {
/*     */           try {
/* 253 */             Array array = FileIntegrityChecker.runTheTest();
/* 254 */             stringBuilder.append("File integrity: ");
/* 255 */             if (array.size == 0) {
/* 256 */               str2 = "valid";
/* 257 */               stringBuilder.append("valid");
/*     */             } else {
/* 259 */               str2 = "invalid";
/* 260 */               stringBuilder.append("invalid");
/* 261 */               for (byte b1 = 0; b1 < array.size; b1++) {
/* 262 */                 stringBuilder.append("- ").append((String)array.get(b1)).append("\n");
/*     */               }
/*     */             } 
/* 265 */             stringBuilder.append("\n");
/* 266 */           } catch (Exception exception) {}
/*     */           try {
/* 268 */             stringBuilder.append("Screen: ").append(Game.i.screenManager.getCurrentScreen().getClass().getSimpleName()).append("\n");
/* 269 */             str1 = Game.i.screenManager.getCurrentScreen().getClass().getSimpleName();
/* 270 */           } catch (Exception exception) {}
/*     */           try {
/* 272 */             if (Game.i.screenManager.getCurrentScreen() instanceof GameScreen) {
/* 273 */               GameScreen gameScreen = (GameScreen)Game.i.screenManager.getCurrentScreen();
/* 274 */               stringBuilder.append("Game mode: ").append(gameScreen.S.gameState.gameMode.name()).append("\n");
/* 275 */               stringBuilder.append("Difficulty mode: ").append(gameScreen.S.gameState.difficultyMode.name()).append("\n");
/* 276 */               stringBuilder.append("Replay ID: ").append(gameScreen.S.gameState.replayId).append("\n");
/* 277 */               stringBuilder.append("Basic level name: ").append(gameScreen.S.gameState.basicLevelName).append("\n");
/*     */             } 
/* 279 */           } catch (Throwable throwable) {}
/*     */           try {
/* 281 */             stringBuilder.append("Resolution: ").append(Gdx.graphics.getWidth()).append(":").append(Gdx.graphics.getHeight()).append("\n");
/* 282 */           } catch (Throwable throwable) {}
/*     */           try {
/* 284 */             stringBuilder.append("GL version: ").append(Gdx.gl.glGetString(7938)).append("\n");
/* 285 */           } catch (Throwable throwable) {}
/*     */           try {
/* 287 */             stringBuilder.append("GL vendor: ").append(Gdx.gl.glGetString(7936)).append("\n");
/* 288 */           } catch (Throwable throwable) {}
/*     */           try {
/* 290 */             stringBuilder.append("GL renderer: ").append(Gdx.gl.glGetString(7937)).append("\n");
/* 291 */           } catch (Throwable throwable) {}
/*     */           try {
/* 293 */             stringBuilder.append("Sync check: ").append(Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_SYNC_VALIDATION)).append("\n");
/* 294 */           } catch (Throwable throwable) {}
/*     */         }
/* 296 */         catch (Throwable throwable) {}
/*     */       } else {
/*     */         
/* 299 */         stringBuilder.append("Not on main thread");
/*     */       } 
/*     */       
/* 302 */       hashMap.put("log", Logger.getLastLogLines(100) + "\n\n" + stringBuilder);
/* 303 */       hashMap.put("currentScreen", str1);
/* 304 */       hashMap.put("fileIntegrity", str2);
/* 305 */       hashMap.put("reason", paramString);
/* 306 */       hashMap.put("os", (Gdx.app == null) ? "unknown" : Gdx.app.getType().name());
/* 307 */       if (Game.isLoaded()) {
/* 308 */         hashMap.put("playerid", Game.i.authManager.getPlayerIdCached());
/*     */       } else {
/* 310 */         hashMap.put("playerid", "G-0000-0000-000000");
/*     */       } 
/* 312 */       if (Game.isLoaded()) {
/* 313 */         ObjectMap objectMap = Game.i.actionResolver.getDeviceInfo();
/* 314 */         Json json1 = new Json(JsonWriter.OutputType.json);
/* 315 */         StringWriter stringWriter1 = new StringWriter();
/* 316 */         json1.setWriter(stringWriter1);
/* 317 */         json1.writeObjectStart();
/* 318 */         if (Game.i.localeManager != null) {
/*     */           try {
/* 320 */             json1.writeValue("g.locale", Charset.defaultCharset() + "," + Game.i.localeManager.getLocale() + "," + Game.i.localeManager.i18n.getLocale());
/* 321 */           } catch (Exception exception) {}
/*     */         }
/*     */         ObjectMap.Entries<ObjectMap.Entry> entries;
/* 324 */         for (entries = objectMap.iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/* 325 */           json1.writeValue((String)entry.key, entry.value); }
/*     */ 
/*     */         
/* 328 */         json1.writeObjectStart("s.properties");
/*     */         try {
/*     */           Properties properties;
/* 331 */           Enumeration<?> enumeration = (properties = System.getProperties()).propertyNames();
/* 332 */           while (enumeration.hasMoreElements()) {
/* 333 */             str2 = (String)enumeration.nextElement();
/*     */             Object object;
/* 335 */             if ((object = properties.get(str2)) != null)
/*     */             {
/* 337 */               json1.writeValue(str2.toString(), ((String)object).trim()); } 
/*     */           } 
/* 339 */         } catch (Exception exception) {
/* 340 */           (entries = null).printStackTrace();
/*     */         } 
/* 342 */         json1.writeObjectEnd();
/*     */         
/* 344 */         json1.writeObjectStart("s.runtime");
/*     */         try {
/* 346 */           Runtime runtime = Runtime.getRuntime();
/* 347 */           json1.writeValue("proc_av", Integer.valueOf(runtime.availableProcessors()));
/* 348 */           json1.writeValue("mem_free", Long.valueOf(runtime.freeMemory()));
/* 349 */           json1.writeValue("mem_max", Long.valueOf(runtime.maxMemory()));
/* 350 */           json1.writeValue("mem_total", Long.valueOf(runtime.totalMemory()));
/* 351 */         } catch (Exception exception) {
/* 352 */           (entries = null).printStackTrace();
/*     */         } 
/* 354 */         json1.writeObjectEnd();
/*     */         
/* 356 */         json1.writeObjectStart("s.graphics");
/*     */         try {
/* 358 */           json1.writeValue("type", Gdx.graphics.getGLVersion().getType().toString());
/* 359 */           json1.writeValue("version", Gdx.graphics.getGLVersion().getMajorVersion() + "." + Gdx.graphics.getGLVersion().getMinorVersion() + "." + Gdx.graphics.getGLVersion().getReleaseVersion());
/* 360 */           json1.writeValue("renderer", Gdx.graphics.getGLVersion().getRendererString());
/* 361 */           json1.writeValue("vendor", Gdx.graphics.getGLVersion().getVendorString());
/* 362 */           json1.writeValue("bb_size", Gdx.graphics.getBackBufferWidth() + "x" + Gdx.graphics.getBackBufferHeight());
/* 363 */           json1.writeValue("density", Float.valueOf(Gdx.graphics.getDensity()));
/* 364 */           json1.writeValue("max_txt_size", Integer.valueOf(Config.getMaxTextureSize()));
/* 365 */         } catch (Exception exception) {
/* 366 */           (entries = null).printStackTrace();
/*     */         } 
/* 368 */         json1.writeObjectEnd();
/*     */         
/* 370 */         json1.writeObjectEnd();
/*     */         
/* 372 */         hashMap.put("device", stringWriter1.toString());
/*     */       } 
/* 374 */       hashMap.put("threads", stringWriter.toString());
/*     */       
/* 376 */       if (paramThrowable != null) {
/* 377 */         StringWriter stringWriter1 = new StringWriter();
/* 378 */         PrintWriter printWriter = new PrintWriter(stringWriter1);
/* 379 */         paramThrowable.printStackTrace(printWriter);
/* 380 */         hashMap.put("stacktrace", stringWriter1.toString());
/*     */         
/* 382 */         hashMap.put("exception", String.valueOf(paramThrowable.getMessage()));
/*     */       } 
/*     */       
/* 385 */       httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*     */       
/* 387 */       boolean[] arrayOfBoolean = new boolean[1];
/* 388 */       Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(arrayOfBoolean) {
/*     */             public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/*     */               try {
/* 391 */                 String str = param1HttpResponse.getResultAsString();
/* 392 */                 System.out.println("Logger.report: " + str);
/* 393 */               } catch (Exception exception) {
/* 394 */                 System.out.println("Logger.report: Exception: " + exception.getMessage());
/* 395 */                 exception.printStackTrace();
/*     */               } 
/* 397 */               this.a[0] = true;
/*     */             }
/*     */             
/*     */             public void failed(Throwable param1Throwable) {
/* 401 */               System.out.println("Logger.report: Error sending report: " + ((param1Throwable == null) ? "null" : param1Throwable.getMessage()));
/* 402 */               this.a[0] = true;
/*     */             }
/*     */             
/*     */             public void cancelled() {
/* 406 */               System.out.println("Logger.report: cancelled");
/* 407 */               this.a[0] = true;
/*     */             }
/*     */           });
/*     */       
/* 411 */       a.i("Sent report", new Object[0]);
/*     */       
/* 413 */       for (byte b = 0; b < 40 && 
/* 414 */         !arrayOfBoolean[0]; b++) {
/* 415 */         Thread.sleep(50L);
/*     */       }
/*     */ 
/*     */       
/*     */       return;
/* 420 */     } catch (Exception exception) {
/*     */       
/* 422 */       a.e("Failed to report", new Object[] { exception });
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\errorhandling\CrashHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */