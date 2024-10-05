/*     */ package nonapi.io.github.classgraph.fileslice;
/*     */ 
/*     */ import io.github.classgraph.Resource;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import nonapi.io.github.classgraph.fastzipfilereader.NestedJarHandler;
/*     */ import nonapi.io.github.classgraph.fileslice.reader.RandomAccessReader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Slice
/*     */   implements Closeable
/*     */ {
/*     */   protected final NestedJarHandler nestedJarHandler;
/*     */   protected final Slice parentSlice;
/*     */   public final long sliceStartPos;
/*     */   public long sliceLength;
/*     */   public final boolean isDeflatedZipEntry;
/*     */   public final long inflatedLengthHint;
/*     */   private int hashCode;
/*     */   
/*     */   protected Slice(Slice paramSlice, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, NestedJarHandler paramNestedJarHandler) {
/*  90 */     this.parentSlice = paramSlice;
/*  91 */     long l = (paramSlice == null) ? 0L : paramSlice.sliceStartPos;
/*  92 */     this.sliceStartPos = l + paramLong1;
/*  93 */     this.sliceLength = paramLong2;
/*  94 */     this.isDeflatedZipEntry = paramBoolean;
/*  95 */     this.inflatedLengthHint = paramLong3;
/*  96 */     this.nestedJarHandler = paramNestedJarHandler;
/*     */     
/*  98 */     if (this.sliceStartPos < 0L) {
/*  99 */       throw new IllegalArgumentException("Invalid startPos");
/*     */     }
/* 101 */     if (paramLong2 < 0L) {
/* 102 */       throw new IllegalArgumentException("Invalid length");
/*     */     }
/* 104 */     if (paramSlice != null && (this.sliceStartPos < l || this.sliceStartPos + paramLong2 > l + paramSlice.sliceLength))
/*     */     {
/* 106 */       throw new IllegalArgumentException("Child slice is not completely contained within parent slice");
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
/*     */   
/*     */   protected Slice(long paramLong1, boolean paramBoolean, long paramLong2, NestedJarHandler paramNestedJarHandler) {
/* 125 */     this(null, 0L, paramLong1, paramBoolean, paramLong2, paramNestedJarHandler);
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
/*     */   public abstract Slice slice(long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream open() {
/* 154 */     return open(null);
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
/*     */   public InputStream open(final Resource resourceToClose) {
/* 167 */     InputStream inputStream = new InputStream() {
/* 168 */         RandomAccessReader randomAccessReader = Slice.this.randomAccessReader();
/*     */         private long currOff;
/*     */         private long markOff;
/* 171 */         private final byte[] byteBuf = new byte[1];
/* 172 */         private final AtomicBoolean closed = new AtomicBoolean();
/*     */ 
/*     */         
/*     */         public int read() {
/* 176 */           if (this.closed.get()) {
/* 177 */             throw new IOException("Already closed");
/*     */           }
/* 179 */           return read(this.byteBuf, 0, 1);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 186 */           if (this.closed.get())
/* 187 */             throw new IOException("Already closed"); 
/* 188 */           if (param1Int2 == 0) {
/* 189 */             return 0;
/*     */           }
/*     */           
/* 192 */           if ((param1Int2 = Math.min(param1Int2, available())) <= 0) {
/* 193 */             return -1;
/*     */           }
/*     */           int i;
/* 196 */           if ((i = this.randomAccessReader.read(this.currOff, param1ArrayOfbyte, param1Int1, param1Int2)) > 0) {
/* 197 */             this.currOff += i;
/*     */           }
/* 199 */           return i;
/*     */         }
/*     */ 
/*     */         
/*     */         public long skip(long param1Long) {
/* 204 */           if (this.closed.get()) {
/* 205 */             throw new IOException("Already closed");
/*     */           }
/*     */           
/* 208 */           long l1, l2 = (l1 = Math.min(this.currOff + param1Long, Slice.this.sliceLength)) - this.currOff;
/* 209 */           this.currOff = l1;
/* 210 */           return l2;
/*     */         }
/*     */ 
/*     */         
/*     */         public int available() {
/* 215 */           return (int)Math.min(Math.max(Slice.this.sliceLength - this.currOff, 0L), 2147483639L);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public synchronized void mark(int param1Int) {
/* 221 */           this.markOff = this.currOff;
/*     */         }
/*     */ 
/*     */         
/*     */         public synchronized void reset() {
/* 226 */           this.currOff = this.markOff;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean markSupported() {
/* 231 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void close() {
/* 236 */           if (resourceToClose != null) {
/*     */             try {
/* 238 */               resourceToClose.close();
/* 239 */             } catch (Exception exception) {}
/*     */           }
/*     */ 
/*     */           
/* 243 */           this.closed.getAndSet(true);
/*     */         }
/*     */       };
/* 246 */     return this.isDeflatedZipEntry ? this.nestedJarHandler.openInflaterInputStream(inputStream) : inputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract RandomAccessReader randomAccessReader();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract byte[] load();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String loadAsString() {
/* 273 */     return new String(load(), StandardCharsets.UTF_8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteBuffer read() {
/* 284 */     return ByteBuffer.wrap(load());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {}
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 293 */     if (this.hashCode == 0) {
/* 294 */       this.hashCode = ((this.parentSlice == null) ? 1 : this.parentSlice.hashCode()) ^ (int)this.sliceStartPos * 7 ^ (int)this.sliceLength * 15;
/*     */       
/* 296 */       if (this.hashCode == 0) {
/* 297 */         this.hashCode = 1;
/*     */       }
/*     */     } 
/* 300 */     return this.hashCode;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 305 */     if (paramObject == this)
/* 306 */       return true; 
/* 307 */     if (!(paramObject instanceof Slice)) {
/* 308 */       return false;
/*     */     }
/* 310 */     paramObject = paramObject;
/* 311 */     return (this.parentSlice == ((Slice)paramObject).parentSlice && this.sliceStartPos == ((Slice)paramObject).sliceStartPos && this.sliceLength == ((Slice)paramObject).sliceLength);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\fileslice\Slice.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */