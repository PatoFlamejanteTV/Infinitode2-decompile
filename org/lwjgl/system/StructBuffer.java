/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Objects;
/*     */ import java.util.Spliterator;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.stream.Stream;
/*     */ import java.util.stream.StreamSupport;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class StructBuffer<T extends Struct<T>, SELF extends StructBuffer<T, SELF>>
/*     */   extends CustomBuffer<SELF>
/*     */   implements Iterable<T>
/*     */ {
/*     */   protected StructBuffer(ByteBuffer paramByteBuffer, int paramInt) {
/*  20 */     super(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */   
/*     */   protected StructBuffer(long paramLong, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  24 */     super(paramLong, paramByteBuffer, paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public int sizeof() {
/*  29 */     return getElementFactory().sizeof();
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
/*     */   public T get() {
/*     */     T t;
/*  44 */     return (t = getElementFactory()).create(this.address + Integer.toUnsignedLong(nextGetIndex()) * t.sizeof(), this.container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SELF get(T paramT) {
/*  55 */     int i = getElementFactory().sizeof();
/*  56 */     MemoryUtil.memCopy(this.address + Integer.toUnsignedLong(nextGetIndex()) * i, paramT.address(), i);
/*  57 */     return self();
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
/*     */   public SELF put(T paramT) {
/*  73 */     int i = getElementFactory().sizeof();
/*  74 */     MemoryUtil.memCopy(paramT.address(), this.address + Integer.toUnsignedLong(nextPutIndex()) * i, i);
/*  75 */     return self();
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
/*     */   public T get(int paramInt) {
/*     */     T t;
/*  92 */     return (t = getElementFactory()).create(this.address + Integer.toUnsignedLong(check(paramInt, this.limit)) * t.sizeof(), this.container);
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
/*     */   public SELF get(int paramInt, T paramT) {
/* 105 */     int i = getElementFactory().sizeof();
/* 106 */     MemoryUtil.memCopy(this.address + Checks.check(paramInt, this.limit) * i, paramT.address(), i);
/* 107 */     return self();
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
/*     */   public SELF put(int paramInt, T paramT) {
/* 124 */     int i = getElementFactory().sizeof();
/* 125 */     MemoryUtil.memCopy(paramT.address(), this.address + Checks.check(paramInt, this.limit) * i, i);
/* 126 */     return self();
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
/*     */   public SELF apply(Consumer<T> paramConsumer) {
/* 139 */     paramConsumer.accept(get());
/* 140 */     return self();
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
/*     */   public SELF apply(int paramInt, Consumer<T> paramConsumer) {
/* 155 */     paramConsumer.accept(get(paramInt));
/* 156 */     return self();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<T> iterator() {
/* 163 */     return new StructIterator<>(this.address, this.container, getElementFactory(), this.position, this.limit);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class StructIterator<T extends Struct<T>>
/*     */     implements Iterator<T>
/*     */   {
/*     */     private long address;
/*     */     
/*     */     private ByteBuffer container;
/*     */     
/*     */     private T factory;
/*     */     
/*     */     private int index;
/*     */     
/*     */     private int fence;
/*     */     
/*     */     StructIterator(long param1Long, ByteBuffer param1ByteBuffer, T param1T, int param1Int1, int param1Int2) {
/* 181 */       this.address = param1Long;
/* 182 */       this.container = param1ByteBuffer;
/* 183 */       this.factory = param1T;
/* 184 */       this.index = param1Int1;
/* 185 */       this.fence = param1Int2;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 189 */       return (this.index < this.fence);
/*     */     }
/*     */     
/*     */     public T next() {
/* 193 */       if (Checks.CHECKS && this.fence <= this.index) {
/* 194 */         throw new NoSuchElementException();
/*     */       }
/* 196 */       return this.factory.create(this.address + Integer.toUnsignedLong(this.index++) * this.factory.sizeof(), this.container);
/*     */     }
/*     */     
/*     */     public void forEachRemaining(Consumer<? super T> param1Consumer) {
/* 200 */       Objects.requireNonNull(param1Consumer);
/* 201 */       int i = this.index;
/*     */       try {
/* 203 */         for (int j = this.factory.sizeof(); i < this.fence; i++)
/* 204 */           param1Consumer.accept(this.factory.create(this.address + Integer.toUnsignedLong(i) * j, this.container)); 
/*     */         return;
/*     */       } finally {
/* 207 */         this.index = i;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void forEach(Consumer<? super T> paramConsumer) {
/* 214 */     Objects.requireNonNull(paramConsumer);
/* 215 */     T t = getElementFactory();
/* 216 */     int i = this.position, j = this.limit; t.sizeof(); for (; i < j; i++) {
/* 217 */       paramConsumer.accept(t.create(this.address + Integer.toUnsignedLong(i) * sizeof(), this.container));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Spliterator<T> spliterator() {
/* 223 */     return new StructSpliterator<>(this.address, this.container, getElementFactory(), this.position, this.limit);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class StructSpliterator<T extends Struct<T>>
/*     */     implements Spliterator<T>
/*     */   {
/*     */     private long address;
/*     */     
/*     */     private ByteBuffer container;
/*     */     private T factory;
/*     */     private int index;
/*     */     private int fence;
/*     */     
/*     */     StructSpliterator(long param1Long, ByteBuffer param1ByteBuffer, T param1T, int param1Int1, int param1Int2) {
/* 238 */       this.address = param1Long;
/* 239 */       this.container = param1ByteBuffer;
/* 240 */       this.factory = param1T;
/* 241 */       this.index = param1Int1;
/* 242 */       this.fence = param1Int2;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean tryAdvance(Consumer<? super T> param1Consumer) {
/* 247 */       Objects.requireNonNull(param1Consumer);
/*     */       
/* 249 */       if (this.index < this.fence) {
/* 250 */         param1Consumer.accept(this.factory.create(this.address + Integer.toUnsignedLong(this.index++) * this.factory.sizeof(), this.container));
/* 251 */         return true;
/*     */       } 
/*     */       
/* 254 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Spliterator<T> trySplit() {
/* 261 */       int i, j = (i = this.index) + this.fence >>> 1;
/*     */       
/* 263 */       return (i < j) ? new StructSpliterator(this.address, this.container, this.factory, i, this.index = j) : null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long estimateSize() {
/* 270 */       return (this.fence - this.index);
/*     */     }
/*     */ 
/*     */     
/*     */     public int characteristics() {
/* 275 */       return 17744;
/*     */     }
/*     */ 
/*     */     
/*     */     public void forEachRemaining(Consumer<? super T> param1Consumer) {
/* 280 */       Objects.requireNonNull(param1Consumer);
/* 281 */       int i = this.index;
/*     */       try {
/* 283 */         for (int j = this.factory.sizeof(); i < this.fence; i++)
/* 284 */           param1Consumer.accept(this.factory.create(this.address + Integer.toUnsignedLong(i) * j, this.container)); 
/*     */         return;
/*     */       } finally {
/* 287 */         this.index = i;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public Comparator<? super T> getComparator() {
/* 293 */       throw new IllegalStateException();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Stream<T> stream() {
/* 299 */     return StreamSupport.stream(spliterator(), false);
/*     */   }
/*     */ 
/*     */   
/*     */   public Stream<T> parallelStream() {
/* 304 */     return StreamSupport.stream(spliterator(), true);
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract T getElementFactory();
/*     */ 
/*     */   
/*     */   private static int check(int paramInt1, int paramInt2) {
/* 312 */     if (Checks.CHECKS && (paramInt1 < 0 || paramInt2 <= paramInt1)) {
/* 313 */       throw new IndexOutOfBoundsException();
/*     */     }
/* 315 */     return paramInt1;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\StructBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */