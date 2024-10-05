/*     */ package nonapi.io.github.classgraph.recycler;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Queue;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentLinkedQueue;
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
/*     */ public abstract class Recycler<T, E extends Exception>
/*     */   implements AutoCloseable
/*     */ {
/*  49 */   private final Set<T> usedInstances = Collections.newSetFromMap(new ConcurrentHashMap<>());
/*     */ 
/*     */   
/*  52 */   private final Queue<T> unusedInstances = new ConcurrentLinkedQueue<>();
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
/*     */   public abstract T newInstance() throws E;
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
/*     */   public T acquire() throws E {
/*     */     T t2, t1, t3;
/*  77 */     if ((t3 = this.unusedInstances.poll()) == null) {
/*     */ 
/*     */       
/*  80 */       if ((t3 = newInstance()) == null) {
/*  81 */         throw (E)new NullPointerException("Failed to allocate a new recyclable instance");
/*     */       }
/*  83 */       t2 = t3;
/*     */     } else {
/*     */       
/*  86 */       t1 = t2;
/*     */     } 
/*  88 */     this.usedInstances.add(t1);
/*  89 */     return t1;
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
/*     */   public RecycleOnClose<T, E> acquireRecycleOnClose() throws E {
/* 101 */     return new RecycleOnClose<>(this, acquire());
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
/*     */   public final void recycle(T paramT) {
/* 114 */     if (paramT != null) {
/* 115 */       if (!this.usedInstances.remove(paramT)) {
/* 116 */         throw new IllegalArgumentException("Tried to recycle an instance that was not in use");
/*     */       }
/* 118 */       if (paramT instanceof Resettable) {
/* 119 */         ((Resettable)paramT).reset();
/*     */       }
/* 121 */       if (!this.unusedInstances.add(paramT)) {
/* 122 */         throw new IllegalArgumentException("Tried to recycle an instance twice");
/*     */       }
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
/*     */   public void close() {
/*     */     T t;
/* 138 */     while ((t = this.unusedInstances.poll()) != null) {
/* 139 */       if (t instanceof AutoCloseable) {
/*     */         try {
/* 141 */           ((AutoCloseable)t).close();
/* 142 */         } catch (Exception exception) {}
/*     */       }
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
/*     */   public void forceClose() {
/* 156 */     for (Object object : new ArrayList(this.usedInstances)) {
/* 157 */       if (this.usedInstances.remove(object)) {
/* 158 */         this.unusedInstances.add((T)object);
/*     */       }
/*     */     } 
/* 161 */     close();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\recycler\Recycler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */