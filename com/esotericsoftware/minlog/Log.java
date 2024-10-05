/*     */ package com.esotericsoftware.minlog;
/*     */ 
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
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
/*     */ public class Log
/*     */ {
/*     */   public static final int LEVEL_NONE = 6;
/*     */   public static final int LEVEL_ERROR = 5;
/*     */   public static final int LEVEL_WARN = 4;
/*     */   public static final int LEVEL_INFO = 3;
/*     */   public static final int LEVEL_DEBUG = 2;
/*     */   public static final int LEVEL_TRACE = 1;
/*     */   private static int level;
/*  28 */   public static boolean ERROR = ((level = 3) <= 5);
/*     */   
/*  30 */   public static boolean WARN = (level <= 4);
/*     */   
/*  32 */   public static boolean INFO = (level <= 3);
/*     */   
/*  34 */   public static boolean DEBUG = (level <= 2);
/*     */   
/*  36 */   public static boolean TRACE = (level <= 1);
/*     */ 
/*     */ 
/*     */   
/*     */   public static void set(int paramInt) {
/*  41 */     level = paramInt;
/*  42 */     ERROR = (paramInt <= 5);
/*  43 */     WARN = (paramInt <= 4);
/*  44 */     INFO = (paramInt <= 3);
/*  45 */     DEBUG = (paramInt <= 2);
/*  46 */     TRACE = (paramInt <= 1);
/*     */   }
/*     */   
/*     */   public static void NONE() {
/*  50 */     set(6);
/*     */   }
/*     */   
/*     */   public static void ERROR() {
/*  54 */     set(5);
/*     */   }
/*     */   
/*     */   public static void WARN() {
/*  58 */     set(4);
/*     */   }
/*     */   
/*     */   public static void INFO() {
/*  62 */     set(3);
/*     */   }
/*     */   
/*     */   public static void DEBUG() {
/*  66 */     set(2);
/*     */   }
/*     */   
/*     */   public static void TRACE() {
/*  70 */     set(1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setLogger(Logger paramLogger) {
/*  75 */     logger = paramLogger;
/*     */   }
/*     */   
/*  78 */   private static Logger logger = new Logger();
/*     */   
/*     */   public static void error(String paramString, Throwable paramThrowable) {
/*  81 */     if (ERROR) logger.log(5, null, paramString, paramThrowable); 
/*     */   }
/*     */   
/*     */   public static void error(String paramString1, String paramString2, Throwable paramThrowable) {
/*  85 */     if (ERROR) logger.log(5, paramString1, paramString2, paramThrowable); 
/*     */   }
/*     */   
/*     */   public static void error(String paramString) {
/*  89 */     if (ERROR) logger.log(5, null, paramString, null); 
/*     */   }
/*     */   
/*     */   public static void error(String paramString1, String paramString2) {
/*  93 */     if (ERROR) logger.log(5, paramString1, paramString2, null); 
/*     */   }
/*     */   
/*     */   public static void warn(String paramString, Throwable paramThrowable) {
/*  97 */     if (WARN) logger.log(4, null, paramString, paramThrowable); 
/*     */   }
/*     */   
/*     */   public static void warn(String paramString1, String paramString2, Throwable paramThrowable) {
/* 101 */     if (WARN) logger.log(4, paramString1, paramString2, paramThrowable); 
/*     */   }
/*     */   
/*     */   public static void warn(String paramString) {
/* 105 */     if (WARN) logger.log(4, null, paramString, null); 
/*     */   }
/*     */   
/*     */   public static void warn(String paramString1, String paramString2) {
/* 109 */     if (WARN) logger.log(4, paramString1, paramString2, null); 
/*     */   }
/*     */   
/*     */   public static void info(String paramString, Throwable paramThrowable) {
/* 113 */     if (INFO) logger.log(3, null, paramString, paramThrowable); 
/*     */   }
/*     */   
/*     */   public static void info(String paramString1, String paramString2, Throwable paramThrowable) {
/* 117 */     if (INFO) logger.log(3, paramString1, paramString2, paramThrowable); 
/*     */   }
/*     */   
/*     */   public static void info(String paramString) {
/* 121 */     if (INFO) logger.log(3, null, paramString, null); 
/*     */   }
/*     */   
/*     */   public static void info(String paramString1, String paramString2) {
/* 125 */     if (INFO) logger.log(3, paramString1, paramString2, null); 
/*     */   }
/*     */   
/*     */   public static void debug(String paramString, Throwable paramThrowable) {
/* 129 */     if (DEBUG) logger.log(2, null, paramString, paramThrowable); 
/*     */   }
/*     */   
/*     */   public static void debug(String paramString1, String paramString2, Throwable paramThrowable) {
/* 133 */     if (DEBUG) logger.log(2, paramString1, paramString2, paramThrowable); 
/*     */   }
/*     */   
/*     */   public static void debug(String paramString) {
/* 137 */     if (DEBUG) logger.log(2, null, paramString, null); 
/*     */   }
/*     */   
/*     */   public static void debug(String paramString1, String paramString2) {
/* 141 */     if (DEBUG) logger.log(2, paramString1, paramString2, null); 
/*     */   }
/*     */   
/*     */   public static void trace(String paramString, Throwable paramThrowable) {
/* 145 */     if (TRACE) logger.log(1, null, paramString, paramThrowable); 
/*     */   }
/*     */   
/*     */   public static void trace(String paramString1, String paramString2, Throwable paramThrowable) {
/* 149 */     if (TRACE) logger.log(1, paramString1, paramString2, paramThrowable); 
/*     */   }
/*     */   
/*     */   public static void trace(String paramString) {
/* 153 */     if (TRACE) logger.log(1, null, paramString, null); 
/*     */   }
/*     */   
/*     */   public static void trace(String paramString1, String paramString2) {
/* 157 */     if (TRACE) logger.log(1, paramString1, paramString2, null);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Logger
/*     */   {
/* 166 */     private final long firstLogTime = System.currentTimeMillis();
/*     */     
/*     */     public void log(int param1Int, String param1String1, String param1String2, Throwable param1Throwable) {
/* 169 */       StringBuilder stringBuilder = new StringBuilder(256);
/*     */ 
/*     */       
/* 172 */       long l1, l2 = (l1 = System.currentTimeMillis() - this.firstLogTime) / 60000L;
/* 173 */       long l3 = l1 / 1000L % 60L;
/* 174 */       if (l2 <= 9L) stringBuilder.append('0'); 
/* 175 */       stringBuilder.append(l2);
/* 176 */       stringBuilder.append(':');
/* 177 */       if (l3 <= 9L) stringBuilder.append('0'); 
/* 178 */       stringBuilder.append(l3);
/*     */       
/* 180 */       switch (param1Int) {
/*     */         case 5:
/* 182 */           stringBuilder.append(" ERROR: ");
/*     */           break;
/*     */         case 4:
/* 185 */           stringBuilder.append("  WARN: ");
/*     */           break;
/*     */         case 3:
/* 188 */           stringBuilder.append("  INFO: ");
/*     */           break;
/*     */         case 2:
/* 191 */           stringBuilder.append(" DEBUG: ");
/*     */           break;
/*     */         case 1:
/* 194 */           stringBuilder.append(" TRACE: ");
/*     */           break;
/*     */       } 
/*     */       
/* 198 */       if (param1String1 != null) {
/* 199 */         stringBuilder.append('[');
/* 200 */         stringBuilder.append(param1String1);
/* 201 */         stringBuilder.append("] ");
/*     */       } 
/*     */       
/* 204 */       stringBuilder.append(param1String2);
/*     */       
/* 206 */       if (param1Throwable != null) {
/* 207 */         StringWriter stringWriter = new StringWriter(256);
/* 208 */         param1Throwable.printStackTrace(new PrintWriter(stringWriter));
/* 209 */         stringBuilder.append('\n');
/* 210 */         stringBuilder.append(stringWriter.toString().trim());
/*     */       } 
/*     */       
/* 213 */       print(stringBuilder.toString());
/*     */     }
/*     */ 
/*     */     
/*     */     protected void print(String param1String) {
/* 218 */       System.out.println(param1String);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\minlog\Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */