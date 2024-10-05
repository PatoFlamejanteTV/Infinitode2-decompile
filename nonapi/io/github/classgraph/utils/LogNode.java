/*     */ package nonapi.io.github.classgraph.utils;
/*     */ 
/*     */ import io.github.classgraph.ClassGraph;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentSkipListMap;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import java.util.logging.Logger;
/*     */ import nonapi.io.github.classgraph.classpath.SystemJarFinder;
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
/*     */ public final class LogNode
/*     */ {
/*     */   static {
/*  55 */     System.getProperties().setProperty("log4j2.formatMsgNoLookups", "true");
/*     */   }
/*     */ 
/*     */   
/*  59 */   private static final Logger log = Logger.getLogger(ClassGraph.class.getName());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  64 */   private final long timeStampNano = System.nanoTime();
/*     */ 
/*     */   
/*  67 */   private final long timeStampMillis = System.currentTimeMillis();
/*     */ 
/*     */   
/*     */   private final String msg;
/*     */ 
/*     */   
/*     */   private String stackTrace;
/*     */ 
/*     */   
/*     */   private long elapsedTimeNanos;
/*     */ 
/*     */   
/*     */   private LogNode parent;
/*     */ 
/*     */   
/*  82 */   private final Map<String, LogNode> children = new ConcurrentSkipListMap<>();
/*     */ 
/*     */   
/*     */   private final String sortKeyPrefix;
/*     */ 
/*     */   
/*  88 */   private static AtomicInteger sortKeyUniqueSuffix = new AtomicInteger(0);
/*     */ 
/*     */   
/*  91 */   private static final SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZ", Locale.US);
/*     */ 
/*     */ 
/*     */   
/*  95 */   private static final DecimalFormat nanoFormatter = new DecimalFormat("0.000000");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean logInRealtime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void logInRealtime(boolean paramBoolean) {
/* 109 */     logInRealtime = paramBoolean;
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
/*     */   private LogNode(String paramString1, String paramString2, long paramLong, Throwable paramThrowable) {
/* 127 */     this.sortKeyPrefix = paramString1;
/* 128 */     this.msg = paramString2;
/* 129 */     this.elapsedTimeNanos = paramLong;
/* 130 */     if (paramThrowable != null) {
/* 131 */       StringWriter stringWriter = new StringWriter();
/* 132 */       paramThrowable.printStackTrace(new PrintWriter(stringWriter));
/* 133 */       this.stackTrace = stringWriter.toString();
/*     */     } else {
/* 135 */       this.stackTrace = null;
/*     */     } 
/* 137 */     if (logInRealtime) {
/* 138 */       log.info(toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public LogNode() {
/* 144 */     this("", "", -1L, null);
/* 145 */     log("ClassGraph version " + VersionFinder.getVersion());
/* 146 */     logJavaInfo();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void logJavaInfo() {
/* 153 */     log("Operating system: " + VersionFinder.getProperty("os.name") + " " + 
/* 154 */         VersionFinder.getProperty("os.version") + " " + VersionFinder.getProperty("os.arch"));
/* 155 */     log("Java version: " + VersionFinder.getProperty("java.version") + " / " + 
/* 156 */         VersionFinder.getProperty("java.runtime.version") + " (" + 
/* 157 */         VersionFinder.getProperty("java.vendor") + ")");
/* 158 */     log("Java home: " + VersionFinder.getProperty("java.home"));
/*     */     String str;
/* 160 */     if ((str = SystemJarFinder.getJreRtJarPath()) != null) {
/* 161 */       log("JRE rt.jar:").log(str);
/*     */     }
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
/*     */   private void appendLine(String paramString1, int paramInt, String paramString2, StringBuilder paramStringBuilder) {
/* 179 */     paramStringBuilder.append(paramString1);
/* 180 */     paramStringBuilder.append('\t');
/* 181 */     paramStringBuilder.append(ClassGraph.class.getSimpleName());
/* 182 */     paramStringBuilder.append('\t');
/* 183 */     int i = 2 * (paramInt - 1);
/* 184 */     for (paramInt = 0; paramInt < i; paramInt++) {
/* 185 */       paramStringBuilder.append('-');
/*     */     }
/* 187 */     if (i > 0) {
/* 188 */       paramStringBuilder.append(' ');
/*     */     }
/* 190 */     paramStringBuilder.append(paramString2);
/* 191 */     paramStringBuilder.append('\n');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void toString(int paramInt, StringBuilder paramStringBuilder) {
/*     */     String str;
/*     */     Calendar calendar;
/* 204 */     (calendar = Calendar.getInstance()).setTimeInMillis(this.timeStampMillis);
/*     */     
/* 206 */     synchronized (dateTimeFormatter) {
/* 207 */       str = dateTimeFormatter.format(calendar.getTime());
/*     */     } 
/*     */     
/* 210 */     if (this.msg != null && !this.msg.isEmpty()) {
/* 211 */       appendLine(str, paramInt, (this.elapsedTimeNanos > 0L) ? (this.msg + " (took " + nanoFormatter
/*     */           
/* 213 */           .format(this.elapsedTimeNanos * 1.0E-9D) + " sec)") : this.msg, paramStringBuilder);
/*     */     }
/*     */ 
/*     */     
/* 217 */     if (this.stackTrace != null && !this.stackTrace.isEmpty()) {
/*     */       String[] arrayOfString1; byte b; String[] arrayOfString2; int i;
/* 219 */       for (i = (arrayOfString2 = arrayOfString1 = this.stackTrace.split("\n")).length, b = 0; b < i; ) { String str1 = arrayOfString2[b];
/* 220 */         appendLine(str, paramInt, str1, paramStringBuilder);
/*     */         b++; }
/*     */     
/*     */     } 
/* 224 */     for (Iterator<Map.Entry> iterator = this.children.entrySet().iterator(); iterator.hasNext();)
/*     */     {
/* 226 */       (logNode = (entry = iterator.next()).getValue()).toString(paramInt + 1, paramStringBuilder);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 238 */     synchronized (dateTimeFormatter) {
/* 239 */       StringBuilder stringBuilder = new StringBuilder();
/* 240 */       toString(0, stringBuilder);
/* 241 */       return stringBuilder.toString();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void addElapsedTime() {
/* 250 */     this.elapsedTimeNanos = System.nanoTime() - this.timeStampNano;
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
/*     */   private LogNode addChild(String paramString1, String paramString2, long paramLong, Throwable paramThrowable) {
/* 269 */     paramString1 = this.sortKeyPrefix + "\t" + ((paramString1 == null) ? "" : paramString1) + "\t" + String.format("%09d", new Object[] { Integer.valueOf(sortKeyUniqueSuffix.getAndIncrement()) });
/*     */     LogNode logNode;
/* 271 */     (logNode = new LogNode(paramString1, paramString2, paramLong, paramThrowable)).parent = this;
/*     */ 
/*     */     
/* 274 */     this.children.put(paramString1, logNode);
/* 275 */     return logNode;
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
/*     */   private LogNode addChild(String paramString1, String paramString2, long paramLong) {
/* 290 */     return addChild(paramString1, paramString2, paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private LogNode addChild(Throwable paramThrowable) {
/* 301 */     return addChild("", "", -1L, paramThrowable);
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
/*     */   public final LogNode log(String paramString1, String paramString2, long paramLong, Throwable paramThrowable) {
/* 318 */     return addChild(paramString1, paramString2, paramLong).addChild(paramThrowable);
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
/*     */   public final LogNode log(String paramString1, String paramString2, long paramLong) {
/* 333 */     return addChild(paramString1, paramString2, paramLong);
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
/*     */   public final LogNode log(String paramString1, String paramString2, Throwable paramThrowable) {
/* 348 */     return addChild(paramString1, paramString2, -1L).addChild(paramThrowable);
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
/*     */   public final LogNode log(String paramString1, String paramString2) {
/* 361 */     return addChild(paramString1, paramString2, -1L);
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
/*     */   public final LogNode log(String paramString, long paramLong, Throwable paramThrowable) {
/* 376 */     return addChild("", paramString, paramLong).addChild(paramThrowable);
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
/*     */   public final LogNode log(String paramString, long paramLong) {
/* 389 */     return addChild("", paramString, paramLong);
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
/*     */   public final LogNode log(String paramString, Throwable paramThrowable) {
/* 402 */     return addChild("", paramString, -1L).addChild(paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final LogNode log(String paramString) {
/* 413 */     return addChild("", paramString, -1L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final LogNode log(Collection<String> paramCollection) {
/*     */     LogNode logNode;
/* 424 */     str = null;
/* 425 */     for (String str : paramCollection) {
/* 426 */       logNode = log(str);
/*     */     }
/* 428 */     return logNode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final LogNode log(Throwable paramThrowable) {
/* 439 */     return log("Exception thrown").addChild(paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void flush() {
/* 448 */     if (this.parent != null) {
/* 449 */       throw new IllegalArgumentException("Only flush the toplevel LogNode");
/*     */     }
/* 451 */     if (!this.children.isEmpty()) {
/* 452 */       String str = toString();
/* 453 */       this.children.clear();
/* 454 */       log.info(str);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgrap\\utils\LogNode.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */