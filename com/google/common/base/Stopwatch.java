/*     */ package com.google.common.base;
/*     */ 
/*     */ import java.util.concurrent.TimeUnit;
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
/*     */ @ElementTypesAreNonnullByDefault
/*     */ public final class Stopwatch
/*     */ {
/*     */   private final Ticker ticker;
/*     */   private boolean isRunning;
/*     */   private long elapsedNanos;
/*     */   private long startTick;
/*     */   
/*     */   public static Stopwatch createUnstarted() {
/* 103 */     return new Stopwatch();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Stopwatch createUnstarted(Ticker paramTicker) {
/* 112 */     return new Stopwatch(paramTicker);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Stopwatch createStarted() {
/* 121 */     return (new Stopwatch()).start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Stopwatch createStarted(Ticker paramTicker) {
/* 130 */     return (new Stopwatch(paramTicker)).start();
/*     */   }
/*     */   
/*     */   Stopwatch() {
/* 134 */     this.ticker = Ticker.systemTicker();
/*     */   }
/*     */   
/*     */   Stopwatch(Ticker paramTicker) {
/* 138 */     this.ticker = Preconditions.<Ticker>checkNotNull(paramTicker, "ticker");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isRunning() {
/* 146 */     return this.isRunning;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Stopwatch start() {
/* 157 */     Preconditions.checkState(!this.isRunning, "This stopwatch is already running.");
/* 158 */     this.isRunning = true;
/* 159 */     this.startTick = this.ticker.read();
/* 160 */     return this;
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
/*     */   public final Stopwatch stop() {
/* 172 */     long l = this.ticker.read();
/* 173 */     Preconditions.checkState(this.isRunning, "This stopwatch is already stopped.");
/* 174 */     this.isRunning = false;
/* 175 */     this.elapsedNanos += l - this.startTick;
/* 176 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Stopwatch reset() {
/* 186 */     this.elapsedNanos = 0L;
/* 187 */     this.isRunning = false;
/* 188 */     return this;
/*     */   }
/*     */   
/*     */   private long elapsedNanos() {
/* 192 */     return this.isRunning ? (this.ticker.read() - this.startTick + this.elapsedNanos) : this.elapsedNanos;
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
/*     */   public final long elapsed(TimeUnit paramTimeUnit) {
/* 205 */     return paramTimeUnit.convert(elapsedNanos(), TimeUnit.NANOSECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/*     */     long l;
/* 213 */     TimeUnit timeUnit = chooseUnit(l = elapsedNanos());
/*     */     
/*     */     double d;
/*     */     
/* 217 */     String str1 = Platform.formatCompact4Digits(d = l / TimeUnit.NANOSECONDS.convert(1L, timeUnit)), str2 = abbreviate(timeUnit); return (new StringBuilder(1 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(" ").append(str2).toString();
/*     */   }
/*     */   
/*     */   private static TimeUnit chooseUnit(long paramLong) {
/* 221 */     if (TimeUnit.DAYS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
/* 222 */       return TimeUnit.DAYS;
/*     */     }
/* 224 */     if (TimeUnit.HOURS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
/* 225 */       return TimeUnit.HOURS;
/*     */     }
/* 227 */     if (TimeUnit.MINUTES.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
/* 228 */       return TimeUnit.MINUTES;
/*     */     }
/* 230 */     if (TimeUnit.SECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
/* 231 */       return TimeUnit.SECONDS;
/*     */     }
/* 233 */     if (TimeUnit.MILLISECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
/* 234 */       return TimeUnit.MILLISECONDS;
/*     */     }
/* 236 */     if (TimeUnit.MICROSECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
/* 237 */       return TimeUnit.MICROSECONDS;
/*     */     }
/* 239 */     return TimeUnit.NANOSECONDS;
/*     */   }
/*     */   
/*     */   private static String abbreviate(TimeUnit paramTimeUnit) {
/* 243 */     switch (paramTimeUnit) {
/*     */       case NANOSECONDS:
/* 245 */         return "ns";
/*     */       case MICROSECONDS:
/* 247 */         return "μs";
/*     */       case MILLISECONDS:
/* 249 */         return "ms";
/*     */       case SECONDS:
/* 251 */         return "s";
/*     */       case MINUTES:
/* 253 */         return "min";
/*     */       case HOURS:
/* 255 */         return "h";
/*     */       case DAYS:
/* 257 */         return "d";
/*     */     } 
/* 259 */     throw new AssertionError();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Stopwatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */