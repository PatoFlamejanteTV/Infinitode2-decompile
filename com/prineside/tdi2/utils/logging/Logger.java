/*     */ package com.prineside.tdi2.utils.logging;
/*     */ 
/*     */ import com.badlogic.gdx.ApplicationLogger;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.base.Strings;
/*     */ import com.prineside.tdi2.ActionResolver;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.events.global.GameDispose;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.FileUtils;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import java.util.concurrent.ConcurrentLinkedQueue;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Logger
/*     */ {
/*  31 */   private static final TLog f = TLog.forClass(Logger.class);
/*     */ 
/*     */   
/*     */   public static final String DEFAULT_LOG_FILE_NAME = "log.txt";
/*     */   
/*     */   public static final int MAX_TAG_SIZE = 20;
/*     */   
/*     */   static volatile FileHandle a;
/*     */   
/*     */   static volatile Writer b;
/*     */   
/*  42 */   private static PlatformLogger g = new SystemOutPlatformLogger(false, false);
/*  43 */   private static final Array<LogListener> h = new Array(true, 1, LogListener.class);
/*     */ 
/*     */   
/*  46 */   static final AtomicBoolean c = new AtomicBoolean();
/*  47 */   static final ConcurrentLinkedQueue<LogEntry> d = new ConcurrentLinkedQueue<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   static final Array<Runnable> e = new Array(true, 1, Runnable.class);
/*     */ 
/*     */ 
/*     */   
/*     */   public static TLog forClass(Class<?> paramClass) {
/*  58 */     return TLog.forClass(paramClass);
/*     */   }
/*     */   
/*     */   public static TLog forTag(String paramString) {
/*  62 */     return TLog.forTag(paramString);
/*     */   }
/*     */   
/*     */   public static void init(ActionResolver paramActionResolver) {
/*  66 */     Preconditions.checkNotNull(paramActionResolver, "actionResolver can not be null");
/*     */     
/*  68 */     h.clear();
/*  69 */     c.set(false);
/*  70 */     Game.EVENTS.getListeners(GameDispose.class).add(paramGameDispose -> c());
/*     */     
/*  72 */     setLogFile(paramActionResolver.getLogFile());
/*  73 */     b();
/*     */ 
/*     */     
/*  76 */     if ((g = paramActionResolver.createPlatformLogger()) == null) {
/*  77 */       throw new IllegalArgumentException("actionResolver.createPlatformLogger returned null");
/*     */     }
/*  79 */     if (Gdx.app == null) {
/*  80 */       f.w("Gdx.app not set, skipping AppLogger swap", new Object[0]);
/*     */     }
/*  82 */     else if (Gdx.app.getApplicationLogger() instanceof ProxyAppLogger) {
/*  83 */       f.w("app logger already set to ProxyAppLogger, skipping", new Object[0]);
/*     */     } else {
/*  85 */       Gdx.app.setApplicationLogger(new ProxyAppLogger((byte)0));
/*     */     } 
/*     */ 
/*     */     
/*     */     Thread thread;
/*     */     
/*  91 */     (thread = new Thread(new LogWriter(), "Log file writer")).setDaemon(true);
/*  92 */     thread.start();
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  97 */       (thread = new Thread(Logger::c, "Logger dispose thread")).setDaemon(false);
/*  98 */       Runtime.getRuntime().addShutdownHook(thread);
/*  99 */       a((byte)0, "Logger", "added shutdown hook for dispose", new Object[0]); return;
/* 100 */     } catch (Throwable throwable) {
/* 101 */       a((byte)2, "Logger", "failed to set up a shutdown hook", new Object[] { throwable });
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void forceLogFileFlushAndRun(Runnable paramRunnable) {
/* 110 */     synchronized (e) {
/* 111 */       e.add(paramRunnable);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   public static void addLogListener(LogListener paramLogListener) {
/* 116 */     synchronized (h) {
/* 117 */       if (!h.contains(paramLogListener, true))
/* 118 */         h.add(paramLogListener); 
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void removeLogListener(LogListener paramLogListener) {
/* 124 */     synchronized (h) {
/* 125 */       h.removeValue(paramLogListener, true);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setLogFile(@Null FileHandle paramFileHandle) {
/* 134 */     System.out.println("Setting log file: " + paramFileHandle);
/* 135 */     a = paramFileHandle;
/*     */   }
/*     */   
/*     */   static void a() {
/* 139 */     if (b != null) {
/*     */       try {
/* 141 */         Writer writer = b;
/* 142 */         b = null;
/* 143 */         writer.close(); return;
/* 144 */       } catch (Throwable throwable) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public static PlatformLogger getPlatformLogger() {
/* 149 */     return g;
/*     */   }
/*     */   
/*     */   public static void setPlatformLogger(PlatformLogger paramPlatformLogger) {
/* 153 */     Preconditions.checkNotNull(paramPlatformLogger, "platformLogger can not be null. Use dummy object here if you don't need logging");
/* 154 */     g = paramPlatformLogger;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void a(byte paramByte, String paramString1, String paramString2, Object... paramVarArgs) {
/* 164 */     StringBuilder stringBuilder = (new StringBuilder(paramString2)).append("\n");
/* 165 */     StringWriter stringWriter = new StringWriter();
/* 166 */     ((Throwable)paramVarArgs[paramVarArgs.length - 1]).printStackTrace(new PrintWriter(stringWriter));
/* 167 */     stringBuilder.append(stringWriter.getBuffer());
/* 168 */     paramString2 = stringBuilder.toString();
/*     */     Object[] arrayOfObject;
/* 170 */     if (paramVarArgs.length != 0 && paramVarArgs[paramVarArgs.length - 1] instanceof Throwable && (arrayOfObject = new Object[paramVarArgs.length - 1]).length != 0) {
/* 171 */       System.arraycopy(paramVarArgs, 0, arrayOfObject, 0, arrayOfObject.length);
/* 172 */       paramVarArgs = arrayOfObject;
/*     */     } 
/*     */     
/* 175 */     String str = Strings.lenientFormat(paramString2, paramVarArgs);
/*     */     
/* 177 */     switch (paramByte) { case 0:
/* 178 */         g.debug(paramString1, str); break;
/* 179 */       case 1: g.info(paramString1, str); break;
/* 180 */       case 2: g.warn(paramString1, str); break;
/* 181 */       case 3: g.error(paramString1, str);
/*     */         break; }
/*     */     
/* 184 */     LogEntry logEntry = new LogEntry(paramByte, Game.getTimestampMillis(), paramString1, str);
/*     */     int i;
/* 186 */     if ((i = LogWriter.getWriterStatus()) != 2 && i != 0) {
/* 187 */       d.add(logEntry);
/*     */     }
/*     */     
/* 190 */     if (h.size != 0) {
/* 191 */       synchronized (h) {
/* 192 */         for (i = 0; i < h.size; i++) {
/*     */           try {
/* 194 */             ((LogListener)h.get(i)).onNewLogEntry(logEntry);
/* 195 */           } catch (Exception exception) {
/* 196 */             f.e("Failed to call listener " + h.get(i) + ", it will be removed and other listeners won't be notified", new Object[] { exception });
/* 197 */             h.removeIndex(i);
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 205 */     if (paramByte >= 3) {
/*     */       try {
/* 207 */         if (Game.isLoaded() && Game.i.isInMainThread() && Game.i.settingsManager.isInDebugMode())
/* 208 */           Notifications.i().add(paramString1 + ":" + paramString2 + "\n" + str, (Drawable)new TextureRegionDrawable((TextureRegion)Game.i.assetManager.getTextureRegions("enemy-type-boss-metaphor-creep").first()), MaterialColor.RED.P900, StaticSoundType.ENEMY_REACHED); 
/*     */         return;
/* 210 */       } catch (Exception exception) {}
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getLastLogLines(int paramInt) {
/* 219 */     if (a == null) {
/* 220 */       return "(no logFile set)";
/*     */     }
/*     */     try {
/* 223 */       return FileUtils.tail(a.file(), paramInt).toString("\n");
/* 224 */     } catch (Exception exception) {
/* 225 */       return "(failed to read log: " + exception.getMessage() + ")";
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void b() {
/* 236 */     if (a == null) {
/* 237 */       System.out.println("rotateLogs skipped - no log file");
/*     */       
/*     */       return;
/*     */     } 
/* 241 */     System.out.println("Rotating logs");
/*     */     try {
/* 243 */       a();
/*     */       
/* 245 */       String str = a.name();
/*     */ 
/*     */       
/* 248 */       if (a.sibling(str + ".1").exists()) {
/* 249 */         FileUtils.fileToZip(a.sibling(str + ".1").file(), a.sibling(str + ".1.zip").file(), str);
/*     */       }
/*     */ 
/*     */       
/* 253 */       for (byte b = 4; b > 0; b--) {
/* 254 */         String str1 = str + "." + b + ".zip";
/* 255 */         String str2 = str + "." + (b + 1) + ".zip";
/* 256 */         if (a.sibling(str1).exists()) {
/* 257 */           a.sibling(str1).file().renameTo(a.sibling(str2).file());
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 262 */       if (a.exists())
/* 263 */         a.file().renameTo(a.sibling(str + ".1").file()); 
/*     */       return;
/* 265 */     } catch (Exception exception2) {
/* 266 */       Exception exception1; (exception1 = null).printStackTrace(System.out);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void c() {
/* 274 */     System.out.println("Logger dispose called");
/* 275 */     c.set(true);
/*     */   }
/*     */   
/*     */   private static final class ProxyAppLogger implements ApplicationLogger { private ProxyAppLogger() {}
/*     */     
/*     */     public final void log(String param1String1, String param1String2) {
/* 281 */       Logger.a((byte)1, param1String1, param1String2, new Object[0]);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void log(String param1String1, String param1String2, Throwable param1Throwable) {
/* 286 */       Logger.a((byte)1, param1String1, param1String2, new Object[] { param1Throwable });
/*     */     }
/*     */ 
/*     */     
/*     */     public final void error(String param1String1, String param1String2) {
/* 291 */       Logger.a((byte)3, param1String1, param1String2, new Object[0]);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void error(String param1String1, String param1String2, Throwable param1Throwable) {
/* 296 */       Logger.a((byte)3, param1String1, param1String2, new Object[] { param1Throwable });
/*     */     }
/*     */ 
/*     */     
/*     */     public final void debug(String param1String1, String param1String2) {
/* 301 */       Logger.a((byte)0, param1String1, param1String2, new Object[0]);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void debug(String param1String1, String param1String2, Throwable param1Throwable) {
/* 306 */       Logger.a((byte)0, param1String1, param1String2, new Object[] { param1Throwable });
/*     */     } }
/*     */ 
/*     */   
/*     */   public static final class LogEntry {
/*     */     public final long timestampMs;
/*     */     public final byte logLevel;
/*     */     public final String tag;
/*     */     public final String message;
/*     */     
/*     */     public LogEntry(byte param1Byte, long param1Long, String param1String1, String param1String2) {
/* 317 */       this.timestampMs = param1Long;
/* 318 */       this.logLevel = param1Byte;
/* 319 */       this.tag = param1String1;
/* 320 */       this.message = param1String2;
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface LogListener {
/*     */     void onNewLogEntry(Logger.LogEntry param1LogEntry);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\logging\Logger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */