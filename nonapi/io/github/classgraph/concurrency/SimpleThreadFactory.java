/*    */ package nonapi.io.github.classgraph.concurrency;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.concurrent.ThreadFactory;
/*    */ import java.util.concurrent.atomic.AtomicInteger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SimpleThreadFactory
/*    */   implements ThreadFactory
/*    */ {
/*    */   private final String threadNamePrefix;
/* 44 */   private static final AtomicInteger threadIdx = new AtomicInteger();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final boolean daemon;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   SimpleThreadFactory(String paramString, boolean paramBoolean) {
/* 58 */     this.threadNamePrefix = paramString;
/* 59 */     this.daemon = paramBoolean;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Thread newThread(Runnable paramRunnable) {
/* 72 */     ThreadGroup threadGroup = null;
/*    */     try {
/*    */       Object object;
/*    */       Method method;
/* 76 */       if ((object = (method = System.class.getDeclaredMethod("getSecurityManager", new Class[0])).invoke(null, new Object[0])) != null) {
/*    */         Method method1;
/* 78 */         threadGroup = (ThreadGroup)(method1 = object.getClass().getDeclaredMethod("getThreadGroup", new Class[0])).invoke(object, new Object[0]);
/*    */       } 
/* 80 */     } catch (Throwable throwable) {}
/*    */ 
/*    */ 
/*    */     
/*    */     Thread thread;
/*    */ 
/*    */     
/* 87 */     (thread = new Thread((threadGroup != null) ? threadGroup : new ThreadGroup("ClassGraph-thread-group"), paramRunnable, this.threadNamePrefix + threadIdx.getAndIncrement())).setDaemon(this.daemon);
/* 88 */     return thread;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\concurrency\SimpleThreadFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */