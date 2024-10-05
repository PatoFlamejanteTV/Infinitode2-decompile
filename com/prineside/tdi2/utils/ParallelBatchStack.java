/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Mesh;
/*     */ import com.badlogic.gdx.graphics.VertexAttribute;
/*     */ import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*     */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Comparator;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ParallelBatchStack
/*     */ {
/*  22 */   private static final TLog a = TLog.forClass(ParallelBatchStack.class);
/*     */   
/*     */   private Mesh b;
/*     */   
/*     */   private final int c;
/*     */   private final ShaderProgram d;
/*     */   private final ExecutorService e;
/*  29 */   private Array<Future<?>> f = new Array(true, 1, Future.class);
/*  30 */   public Array<Entry> batchesOrdered = new Array(true, 1, Entry.class);
/*     */   
/*     */   public ParallelBatchStack(int paramInt1, ShaderProgram paramShaderProgram, int paramInt2) {
/*  33 */     this.c = paramInt1;
/*  34 */     this.d = paramShaderProgram;
/*     */     
/*  36 */     Mesh.VertexDataType vertexDataType = (Gdx.gl30 != null) ? Mesh.VertexDataType.VertexBufferObjectWithVAO : SpriteBatch.defaultVertexDataType;
/*  37 */     this.b = new Mesh(vertexDataType, false, paramInt1 << 2, paramInt1 * 6, new VertexAttribute[] { new VertexAttribute(1, 2, "a_position"), new VertexAttribute(4, 4, "a_color"), new VertexAttribute(16, 2, "a_texCoord0") });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  42 */     short[] arrayOfShort = new short[paramInt1 = paramInt1 * 6];
/*  43 */     short s = 0;
/*  44 */     for (byte b = 0; b < paramInt1; b += 6, s = (short)(s + 4)) {
/*  45 */       arrayOfShort[b] = s;
/*  46 */       arrayOfShort[b + 1] = (short)(s + 1);
/*  47 */       arrayOfShort[b + 2] = (short)(s + 2);
/*  48 */       arrayOfShort[b + 3] = (short)(s + 2);
/*  49 */       arrayOfShort[b + 4] = (short)(s + 3);
/*  50 */       arrayOfShort[b + 5] = s;
/*     */     } 
/*  52 */     this.b.setIndices(arrayOfShort);
/*     */     
/*  54 */     this.e = Executors.newFixedThreadPool(paramInt2, new ThreadFactory(this) {
/*  55 */           private int a = 0;
/*     */ 
/*     */           
/*     */           public Thread newThread(Runnable param1Runnable) {
/*  59 */             (param1Runnable = new Thread(param1Runnable, "ParallelBatchStack_" + this.a++)).setDaemon(true);
/*     */             
/*  61 */             return (Thread)param1Runnable;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void registerBatch(int paramInt, ObjectConsumer<ParallelBatch> paramObjectConsumer) {
/*  67 */     registerBatchWithFlushCallback(paramInt, paramObjectConsumer, null);
/*     */   }
/*     */   
/*     */   public void registerBatchWithFlushCallback(int paramInt, ObjectConsumer<ParallelBatch> paramObjectConsumer, Runnable paramRunnable) {
/*     */     Entry entry;
/*  72 */     (entry = new Entry()).priority = paramInt;
/*  73 */     entry.batch = new ParallelBatch(this.c, this.d);
/*  74 */     entry.job = paramObjectConsumer;
/*  75 */     entry.postFlushRunnable = paramRunnable;
/*  76 */     entry.threadRunnable = (() -> {
/*     */         paramEntry.batch.reset(); paramEntry.job.accept(paramEntry.batch);
/*     */         if (paramEntry.batch.drawing)
/*     */           paramEntry.batch.end(); 
/*     */       });
/*  81 */     this.batchesOrdered.add(entry);
/*     */     
/*  83 */     Threads.sortGdxArray(this.batchesOrdered, new Comparator<Entry>(this)
/*     */         {
/*     */           public int compare(ParallelBatchStack.Entry param1Entry1, ParallelBatchStack.Entry param1Entry2) {
/*  86 */             return Integer.compare(param1Entry1.priority, param1Entry2.priority);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void execute() {
/*     */     Entry entry;
/*  92 */     this.f.clear();
/*  93 */     for (byte b1 = 0; b1 < this.batchesOrdered.size; b1++) {
/*  94 */       Future<?> future = this.e.submit((((Entry[])this.batchesOrdered.items)[b1]).threadRunnable);
/*  95 */       this.f.add(future);
/*     */     } 
/*     */     
/*  98 */     Exception exception = null; byte b2;
/*  99 */     for (b2 = 0; b2 < this.f.size; b2++) {
/*     */       try {
/* 101 */         ((Future[])this.f.items)[b2].get();
/* 102 */       } catch (Exception exception1) {
/* 103 */         exception = exception = null;
/*     */         break;
/*     */       } 
/*     */     } 
/* 107 */     if (exception == null) {
/*     */       
/* 109 */       for (b2 = 0; b2 < this.batchesOrdered.size; b2++) {
/*     */         
/* 111 */         (entry = ((Entry[])this.batchesOrdered.items)[b2]).batch.render(this.b);
/* 112 */         entry.batch.reset();
/* 113 */         if (entry.postFlushRunnable != null)
/* 114 */           entry.postFlushRunnable.run(); 
/*     */       } 
/*     */       return;
/*     */     } 
/* 118 */     a.i("timeout / exception", new Object[] { entry });
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 123 */     this.b.dispose();
/* 124 */     this.b = null;
/*     */     try {
/* 126 */       if (!this.e.awaitTermination(800L, TimeUnit.MILLISECONDS))
/* 127 */         this.e.shutdownNow(); 
/*     */       return;
/* 129 */     } catch (InterruptedException interruptedException) {
/* 130 */       this.e.shutdownNow();
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final class Entry {
/*     */     public ParallelBatch batch;
/*     */     public ObjectConsumer<ParallelBatch> job;
/*     */     public int priority;
/*     */     public Runnable threadRunnable;
/*     */     public Runnable postFlushRunnable;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\ParallelBatchStack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */