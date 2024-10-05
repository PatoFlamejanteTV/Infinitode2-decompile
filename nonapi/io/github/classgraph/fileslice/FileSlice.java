/*     */ package nonapi.io.github.classgraph.fileslice;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import nonapi.io.github.classgraph.fastzipfilereader.NestedJarHandler;
/*     */ import nonapi.io.github.classgraph.fileslice.reader.RandomAccessByteBufferReader;
/*     */ import nonapi.io.github.classgraph.fileslice.reader.RandomAccessFileChannelReader;
/*     */ import nonapi.io.github.classgraph.fileslice.reader.RandomAccessReader;
/*     */ import nonapi.io.github.classgraph.utils.FileUtils;
/*     */ import nonapi.io.github.classgraph.utils.LogNode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileSlice
/*     */   extends Slice
/*     */ {
/*     */   public final File file;
/*     */   public RandomAccessFile raf;
/*     */   private final long fileLength;
/*     */   private FileChannel fileChannel;
/*     */   private ByteBuffer backingByteBuffer;
/*     */   private final boolean isTopLevelFileSlice;
/*  71 */   private final AtomicBoolean isClosed = new AtomicBoolean();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FileSlice(FileSlice paramFileSlice, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, NestedJarHandler paramNestedJarHandler) {
/*  93 */     super(paramFileSlice, paramLong1, paramLong2, paramBoolean, paramLong3, paramNestedJarHandler);
/*  94 */     this.file = paramFileSlice.file;
/*  95 */     this.raf = paramFileSlice.raf;
/*  96 */     this.fileChannel = paramFileSlice.fileChannel;
/*  97 */     this.fileLength = paramFileSlice.fileLength;
/*  98 */     this.isTopLevelFileSlice = false;
/*     */     
/* 100 */     if (paramFileSlice.backingByteBuffer != null) {
/*     */       
/* 102 */       this.backingByteBuffer = paramFileSlice.backingByteBuffer.duplicate();
/* 103 */       this.backingByteBuffer.position((int)this.sliceStartPos);
/* 104 */       this.backingByteBuffer.limit((int)(this.sliceStartPos + this.sliceLength));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileSlice(File paramFile, boolean paramBoolean, long paramLong, NestedJarHandler paramNestedJarHandler, LogNode paramLogNode) {
/* 130 */     super(paramFile.length(), paramBoolean, paramLong, paramNestedJarHandler);
/*     */     
/* 132 */     FileUtils.checkCanReadAndIsFile(paramFile);
/* 133 */     this.file = paramFile;
/* 134 */     this.raf = new RandomAccessFile(paramFile, "r");
/* 135 */     this.fileChannel = this.raf.getChannel();
/* 136 */     this.fileLength = paramFile.length();
/* 137 */     this.isTopLevelFileSlice = true;
/*     */     
/* 139 */     if (paramNestedJarHandler.scanSpec.enableMemoryMapping) {
/*     */       
/*     */       try {
/*     */         
/* 143 */         this.backingByteBuffer = this.fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, this.fileLength);
/* 144 */       } catch (IOException|OutOfMemoryError iOException) {
/*     */         
/* 146 */         System.gc();
/* 147 */         paramNestedJarHandler.runFinalizationMethod();
/*     */         try {
/* 149 */           this.backingByteBuffer = this.fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, this.fileLength);
/* 150 */         } catch (IOException|OutOfMemoryError iOException1) {
/* 151 */           if (paramLogNode != null) {
/* 152 */             paramLogNode.log("File " + paramFile + " cannot be memory mapped: " + iOException1 + " (using RandomAccessFile API instead)");
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 161 */     paramNestedJarHandler.markSliceAsOpen(this);
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
/*     */   public FileSlice(File paramFile, NestedJarHandler paramNestedJarHandler, LogNode paramLogNode) {
/* 178 */     this(paramFile, false, 0L, paramNestedJarHandler, paramLogNode);
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
/*     */   
/*     */   public Slice slice(long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3) {
/* 198 */     if (this.isDeflatedZipEntry) {
/* 199 */       throw new IllegalArgumentException("Cannot slice a deflated zip entry");
/*     */     }
/* 201 */     return new FileSlice(this, paramLong1, paramLong2, paramBoolean, paramLong3, this.nestedJarHandler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RandomAccessReader randomAccessReader() {
/* 211 */     if (this.backingByteBuffer == null)
/*     */     {
/* 213 */       return (RandomAccessReader)new RandomAccessFileChannelReader(this.fileChannel, this.sliceStartPos, this.sliceLength);
/*     */     }
/*     */     
/* 216 */     return (RandomAccessReader)new RandomAccessByteBufferReader(this.backingByteBuffer, this.sliceStartPos, this.sliceLength);
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
/*     */   public byte[] load() {
/* 229 */     if (this.isDeflatedZipEntry) {
/*     */       
/* 231 */       if (this.inflatedLengthHint > 2147483639L) {
/* 232 */         throw new IOException("Uncompressed size is larger than 2GB");
/*     */       }
/* 234 */       InputStream inputStream = open(); Throwable throwable2 = null; 
/* 235 */       try { return NestedJarHandler.readAllBytesAsArray(inputStream, this.inflatedLengthHint); } catch (Throwable throwable4) { Throwable throwable3 = null; throw throwable3; }
/* 236 */       finally { if (throwable1 != null) if (throwable2 != null) { try { throwable1.close(); } catch (Throwable throwable) { throwable2.addSuppressed(throwable); }  } else { throwable.close(); }
/*     */             }
/*     */     
/* 239 */     }  if (this.sliceLength > 2147483639L) {
/* 240 */       throw new IOException("File is larger than 2GB");
/*     */     }
/* 242 */     RandomAccessReader randomAccessReader = randomAccessReader();
/* 243 */     byte[] arrayOfByte = new byte[(int)this.sliceLength];
/* 244 */     if (randomAccessReader.read(0L, arrayOfByte, 0, arrayOfByte.length) < arrayOfByte.length)
/*     */     {
/* 246 */       throw new IOException("File is truncated");
/*     */     }
/* 248 */     return arrayOfByte;
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
/*     */   public ByteBuffer read() {
/* 262 */     if (this.isDeflatedZipEntry) {
/*     */ 
/*     */       
/* 265 */       if (this.inflatedLengthHint > 2147483639L) {
/* 266 */         throw new IOException("Uncompressed size is larger than 2GB");
/*     */       }
/* 268 */       return ByteBuffer.wrap(load());
/* 269 */     }  if (this.backingByteBuffer == null) {
/*     */       
/* 271 */       if (this.sliceLength > 2147483639L) {
/* 272 */         throw new IOException("File is larger than 2GB");
/*     */       }
/* 274 */       return ByteBuffer.wrap(load());
/*     */     } 
/*     */     
/* 277 */     return this.backingByteBuffer.duplicate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 283 */     return super.equals(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 288 */     return super.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 294 */     if (!this.isClosed.getAndSet(true)) {
/* 295 */       if (this.isTopLevelFileSlice && this.backingByteBuffer != null)
/*     */       {
/*     */         
/* 298 */         this.nestedJarHandler.closeDirectByteBuffer(this.backingByteBuffer);
/*     */       }
/* 300 */       this.backingByteBuffer = null;
/* 301 */       this.fileChannel = null;
/*     */       
/*     */       try {
/* 304 */         this.raf.close();
/* 305 */       } catch (IOException iOException) {}
/*     */ 
/*     */       
/* 308 */       this.raf = null;
/* 309 */       this.nestedJarHandler.markSliceAsClosed(this);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\fileslice\FileSlice.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */