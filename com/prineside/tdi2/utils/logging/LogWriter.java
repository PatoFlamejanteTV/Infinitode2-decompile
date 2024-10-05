/*     */ package com.prineside.tdi2.utils.logging;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public final class LogWriter
/*     */   implements Runnable {
/*  17 */   private static final TLog a = TLog.forClass(LogWriter.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  23 */   public static long LOG_ROTATE_AFTER_CHARACTERS = -1L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  33 */   public static final Pattern LOG_FILE_ENTRY_REGEX = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}\\.\\d{3})\\s([DEIW])\\s([a-zA-Z0-9_\\-./]+)\\s");
/*     */   
/*  35 */   public static final SimpleDateFormat LOG_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
/*  36 */   private static final SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
/*     */   
/*     */   public static final int LOG_FILE_WRITER_STATUS_NOT_STARTED = 0;
/*     */   
/*     */   public static final int LOG_FILE_WRITER_STATUS_STARTING = 1;
/*     */   
/*     */   public static final int LOG_FILE_WRITER_STATUS_STOPPED = 2;
/*     */   
/*     */   public static final int LOG_FILE_WRITER_STATUS_SLEEP_NO_FILE = 3;
/*     */   
/*     */   public static final int LOG_FILE_WRITER_STATUS_SLEEP_NO_ENTRIES = 4;
/*     */   public static final int LOG_FILE_WRITER_STATUS_WRITING = 5;
/*  48 */   private static final AtomicInteger c = new AtomicInteger(0);
/*     */   public static int getWriterStatus() {
/*  50 */     return c.get();
/*     */   }
/*     */   
/*     */   private static long d;
/*     */   private static long e;
/*     */   
/*     */   private static void a(Writer paramWriter, Logger.LogEntry paramLogEntry) {
/*  57 */     char c = LogLevel.getShortName(paramLogEntry.logLevel);
/*  58 */     CharSequence charSequence = StringFormatter.stripTerminalColors(paramLogEntry.message);
/*  59 */     String str = b.format(new Date(paramLogEntry.timestampMs));
/*  60 */     paramWriter.append(str).append(' ').append(c).append(' ').append(paramLogEntry.tag).append(' ').append(charSequence).append("\n");
/*  61 */     int i = str.length() + 3 + paramLogEntry.tag.length() + 1 + charSequence.length() + 1;
/*  62 */     e += i;
/*     */   }
/*     */   
/*     */   private static void a() {
/*  66 */     if (Logger.b == null)
/*     */       return; 
/*     */     Logger.LogEntry logEntry;
/*  69 */     while ((logEntry = Logger.d.poll()) != null)
/*     */     {
/*     */       
/*  72 */       a(Logger.b, logEntry);
/*     */     }
/*     */     
/*  75 */     Logger.b.flush();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void run() {
/*  81 */     c.set(1);
/*  82 */     FileHandle fileHandle = null;
/*     */     try {
/*     */       while (true) {
/*  85 */         if (Logger.c.get()) {
/*     */           
/*  87 */           System.out.println("Logger is disposed - closing the writer and stopping the log writer thread");
/*     */           try {
/*  89 */             a();
/*  90 */           } catch (Exception exception) {
/*  91 */             System.out.println("failed to write all entries on dispose: " + exception.getMessage());
/*     */           } 
/*     */           
/*  94 */           Logger.a();
/*  95 */           Logger.setLogFile(null);
/*     */           
/*     */           return;
/*     */         } 
/*  99 */         if (Logger.a != fileHandle) {
/*     */           
/*     */           try {
/* 102 */             a();
/* 103 */           } catch (Exception exception) {
/* 104 */             System.out.println("/!\\ failed to write all entries on log file change: " + exception.getMessage());
/*     */           } 
/* 106 */           Logger.a();
/* 107 */           fileHandle = Logger.a;
/*     */         } 
/*     */         
/* 110 */         if (Logger.b == null && Logger.a != null) {
/* 111 */           Logger.b = new BufferedWriter(Logger.a.writer(false, "UTF-8"));
/*     */         }
/*     */         Writer writer;
/* 114 */         if ((writer = Logger.b) != null) {
/*     */           try {
/* 116 */             if (Logger.d.peek() == null) {
/* 117 */               c.set(4);
/* 118 */               Thread.sleep(31L);
/*     */             } else {
/* 120 */               c.set(5);
/* 121 */               a();
/*     */               
/* 123 */               if (LOG_ROTATE_AFTER_CHARACTERS > 0L && e > LOG_ROTATE_AFTER_CHARACTERS) {
/* 124 */                 Logger.b();
/* 125 */                 e = 0L;
/*     */               } 
/*     */             } 
/* 128 */           } catch (IOException iOException) {
/* 129 */             Logger.setLogFile(null);
/* 130 */             writer = null;
/* 131 */             a.e("failed to write log: " + iOException.getMessage(), new Object[0]);
/*     */           } 
/*     */ 
/*     */           
/* 135 */           if (writer != null) {
/*     */             long l;
/* 137 */             if ((l = Game.getTimestampMillis()) - d > 3000L) {
/*     */               try {
/* 139 */                 writer.flush();
/* 140 */               } catch (Exception exception) {}
/* 141 */               d = l;
/*     */             } 
/* 143 */             if (Logger.e.size != 0) {
/*     */               try {
/* 145 */                 writer.flush();
/* 146 */               } catch (Exception exception) {}
/* 147 */               d = l;
/*     */               
/* 149 */               synchronized (Logger.e) {
/* 150 */                 for (byte b = 0; b < Logger.e.size; b++) {
/* 151 */                   Runnable runnable = ((Runnable[])Logger.e.items)[b];
/*     */                   try {
/* 153 */                     runnable.run();
/* 154 */                   } catch (Throwable throwable) {}
/*     */                 } 
/* 156 */                 Logger.e.clear();
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           continue;
/*     */         } 
/* 162 */         c.set(3);
/* 163 */         Thread.sleep(101L); int i;
/* 164 */         if (Logger.a == null && (
/*     */           
/* 166 */           i = Logger.d.size()) > 500) {
/* 167 */           int j = i - 50;
/* 168 */           System.out.println("Still no log file, purging " + j + " queued lines");
/* 169 */           for (byte b = 0; b < j; b++) {
/* 170 */             Logger.d.poll();
/*     */           }
/*     */         }
/*     */       
/*     */       }
/*     */     
/* 176 */     } catch (InterruptedException interruptedException) {
/* 177 */       System.out.println("Log file writer interrupted");
/* 178 */       c.set(2);
/*     */       try {
/* 180 */         a();
/* 181 */       } catch (Exception exception) {
/* 182 */         System.out.println("failed to write all entries on thread interrupt: " + exception.getMessage());
/*     */       } 
/*     */       
/* 185 */       Logger.a();
/* 186 */       Logger.setLogFile(null);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\logging\LogWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */