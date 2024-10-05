/*     */ package net.bytebuddy.build;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.utility.nullability.MaybeNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface BuildLogger
/*     */ {
/*     */   boolean isDebugEnabled();
/*     */   
/*     */   void debug(String paramString);
/*     */   
/*     */   void debug(String paramString, Throwable paramThrowable);
/*     */   
/*     */   boolean isInfoEnabled();
/*     */   
/*     */   void info(String paramString);
/*     */   
/*     */   void info(String paramString, Throwable paramThrowable);
/*     */   
/*     */   boolean isWarnEnabled();
/*     */   
/*     */   void warn(String paramString);
/*     */   
/*     */   void warn(String paramString, Throwable paramThrowable);
/*     */   
/*     */   boolean isErrorEnabled();
/*     */   
/*     */   void error(String paramString);
/*     */   
/*     */   void error(String paramString, Throwable paramThrowable);
/*     */   
/*     */   public enum NoOp
/*     */     implements BuildLogger
/*     */   {
/* 125 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isDebugEnabled() {
/* 131 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void debug(String param1String) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void debug(String param1String, Throwable param1Throwable) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isInfoEnabled() {
/* 152 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void info(String param1String) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void info(String param1String, Throwable param1Throwable) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isWarnEnabled() {
/* 173 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void warn(String param1String) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void warn(String param1String, Throwable param1Throwable) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isErrorEnabled() {
/* 194 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void error(String param1String) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void error(String param1String, Throwable param1Throwable) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class Adapter
/*     */     implements BuildLogger
/*     */   {
/*     */     public boolean isDebugEnabled() {
/* 221 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void debug(String param1String) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void debug(String param1String, Throwable param1Throwable) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isInfoEnabled() {
/* 242 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void info(String param1String) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void info(String param1String, Throwable param1Throwable) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isWarnEnabled() {
/* 263 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void warn(String param1String) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void warn(String param1String, Throwable param1Throwable) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isErrorEnabled() {
/* 284 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void error(String param1String) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void error(String param1String, Throwable param1Throwable) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class StreamWriting
/*     */     implements BuildLogger
/*     */   {
/*     */     private final PrintStream printStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StreamWriting(PrintStream param1PrintStream) {
/* 319 */       this.printStream = param1PrintStream;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static BuildLogger toSystemOut() {
/* 328 */       return new StreamWriting(System.out);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static BuildLogger toSystemError() {
/* 337 */       return new StreamWriting(System.err);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isDebugEnabled() {
/* 344 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void debug(String param1String) {
/* 351 */       this.printStream.print(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void debug(String param1String, Throwable param1Throwable) {
/* 358 */       synchronized (this.printStream) {
/* 359 */         this.printStream.print(param1String);
/* 360 */         param1Throwable.printStackTrace(this.printStream);
/*     */         return;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isInfoEnabled() {
/* 368 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void info(String param1String) {
/* 375 */       this.printStream.print(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void info(String param1String, Throwable param1Throwable) {
/* 382 */       synchronized (this.printStream) {
/* 383 */         this.printStream.print(param1String);
/* 384 */         param1Throwable.printStackTrace(this.printStream);
/*     */         return;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isWarnEnabled() {
/* 392 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void warn(String param1String) {
/* 399 */       this.printStream.print(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void warn(String param1String, Throwable param1Throwable) {
/* 406 */       synchronized (this.printStream) {
/* 407 */         this.printStream.print(param1String);
/* 408 */         param1Throwable.printStackTrace(this.printStream);
/*     */         return;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isErrorEnabled() {
/* 416 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void error(String param1String) {
/* 423 */       this.printStream.print(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void error(String param1String, Throwable param1Throwable) {
/* 430 */       synchronized (this.printStream) {
/* 431 */         this.printStream.print(param1String);
/* 432 */         param1Throwable.printStackTrace(this.printStream);
/*     */         return;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.printStream.equals(((StreamWriting)param1Object).printStream))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.printStream.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Compound
/*     */     implements BuildLogger
/*     */   {
/*     */     public Compound(BuildLogger... param1VarArgs) {
/* 454 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 463 */     private final List<BuildLogger> buildLoggers = new ArrayList<BuildLogger>(); public Compound(List<? extends BuildLogger> param1List) {
/* 464 */       for (Iterator<? extends BuildLogger> iterator = param1List.iterator(); iterator.hasNext(); ) {
/* 465 */         BuildLogger buildLogger; if (buildLogger = iterator.next() instanceof Compound) {
/* 466 */           this.buildLoggers.addAll(((Compound)buildLogger).buildLoggers); continue;
/* 467 */         }  if (!(buildLogger instanceof BuildLogger.NoOp)) {
/* 468 */           this.buildLoggers.add(buildLogger);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isDebugEnabled() {
/* 477 */       for (Iterator<BuildLogger> iterator = this.buildLoggers.iterator(); iterator.hasNext();) {
/* 478 */         if ((buildLogger = iterator.next()).isDebugEnabled()) {
/* 479 */           return true;
/*     */         }
/*     */       } 
/* 482 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void debug(String param1String) {
/* 489 */       for (Iterator<BuildLogger> iterator = this.buildLoggers.iterator(); iterator.hasNext();) {
/* 490 */         if ((buildLogger = iterator.next()).isDebugEnabled()) {
/* 491 */           buildLogger.debug(param1String);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void debug(String param1String, Throwable param1Throwable) {
/* 500 */       for (Iterator<BuildLogger> iterator = this.buildLoggers.iterator(); iterator.hasNext();) {
/* 501 */         if ((buildLogger = iterator.next()).isDebugEnabled()) {
/* 502 */           buildLogger.debug(param1String, param1Throwable);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isInfoEnabled() {
/* 511 */       for (Iterator<BuildLogger> iterator = this.buildLoggers.iterator(); iterator.hasNext();) {
/* 512 */         if ((buildLogger = iterator.next()).isInfoEnabled()) {
/* 513 */           return true;
/*     */         }
/*     */       } 
/* 516 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void info(String param1String) {
/* 523 */       for (Iterator<BuildLogger> iterator = this.buildLoggers.iterator(); iterator.hasNext();) {
/* 524 */         if ((buildLogger = iterator.next()).isInfoEnabled()) {
/* 525 */           buildLogger.info(param1String);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void info(String param1String, Throwable param1Throwable) {
/* 534 */       for (Iterator<BuildLogger> iterator = this.buildLoggers.iterator(); iterator.hasNext();) {
/* 535 */         if ((buildLogger = iterator.next()).isInfoEnabled()) {
/* 536 */           buildLogger.info(param1String, param1Throwable);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isWarnEnabled() {
/* 545 */       for (Iterator<BuildLogger> iterator = this.buildLoggers.iterator(); iterator.hasNext();) {
/* 546 */         if ((buildLogger = iterator.next()).isWarnEnabled()) {
/* 547 */           return true;
/*     */         }
/*     */       } 
/* 550 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void warn(String param1String) {
/* 557 */       for (Iterator<BuildLogger> iterator = this.buildLoggers.iterator(); iterator.hasNext();) {
/* 558 */         if ((buildLogger = iterator.next()).isWarnEnabled()) {
/* 559 */           buildLogger.warn(param1String);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void warn(String param1String, Throwable param1Throwable) {
/* 568 */       for (Iterator<BuildLogger> iterator = this.buildLoggers.iterator(); iterator.hasNext();) {
/* 569 */         if ((buildLogger = iterator.next()).isWarnEnabled()) {
/* 570 */           buildLogger.warn(param1String, param1Throwable);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isErrorEnabled() {
/* 579 */       for (Iterator<BuildLogger> iterator = this.buildLoggers.iterator(); iterator.hasNext();) {
/* 580 */         if ((buildLogger = iterator.next()).isErrorEnabled()) {
/* 581 */           return true;
/*     */         }
/*     */       } 
/* 584 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void error(String param1String) {
/* 591 */       for (Iterator<BuildLogger> iterator = this.buildLoggers.iterator(); iterator.hasNext();) {
/* 592 */         if ((buildLogger = iterator.next()).isErrorEnabled()) {
/* 593 */           buildLogger.error(param1String);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void error(String param1String, Throwable param1Throwable) {
/* 602 */       for (Iterator<BuildLogger> iterator = this.buildLoggers.iterator(); iterator.hasNext();) {
/* 603 */         if ((buildLogger = iterator.next()).isErrorEnabled())
/* 604 */           buildLogger.error(param1String, param1Throwable); 
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.buildLoggers.equals(((Compound)param1Object).buildLoggers))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.buildLoggers.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\build\BuildLogger.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */