/*     */ package nonapi.io.github.classgraph.fileslice;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.file.OpenOption;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.StandardOpenOption;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import nonapi.io.github.classgraph.fastzipfilereader.NestedJarHandler;
/*     */ import nonapi.io.github.classgraph.fileslice.reader.RandomAccessFileChannelReader;
/*     */ import nonapi.io.github.classgraph.fileslice.reader.RandomAccessReader;
/*     */ import nonapi.io.github.classgraph.utils.FileUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PathSlice
/*     */   extends Slice
/*     */ {
/*     */   public final Path path;
/*     */   private final long fileLength;
/*     */   private FileChannel fileChannel;
/*     */   private final boolean isTopLevelFileSlice;
/*  61 */   private final AtomicBoolean isClosed = new AtomicBoolean();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PathSlice(PathSlice paramPathSlice, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, NestedJarHandler paramNestedJarHandler) {
/*  84 */     super(paramPathSlice, paramLong1, paramLong2, paramBoolean, paramLong3, paramNestedJarHandler);
/*     */     
/*  86 */     this.path = paramPathSlice.path;
/*  87 */     this.fileChannel = paramPathSlice.fileChannel;
/*  88 */     this.fileLength = paramPathSlice.fileLength;
/*  89 */     this.isTopLevelFileSlice = false;
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
/*     */   
/*     */   public PathSlice(Path paramPath, boolean paramBoolean, long paramLong, NestedJarHandler paramNestedJarHandler) {
/* 115 */     this(paramPath, paramBoolean, paramLong, paramNestedJarHandler, true);
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
/*     */   public PathSlice(Path paramPath, boolean paramBoolean1, long paramLong, NestedJarHandler paramNestedJarHandler, boolean paramBoolean2) {
/* 138 */     super(0L, paramBoolean1, paramLong, paramNestedJarHandler);
/*     */     
/* 140 */     if (paramBoolean2)
/*     */     {
/* 142 */       FileUtils.checkCanReadAndIsFile(paramPath);
/*     */     }
/*     */     
/* 145 */     this.path = paramPath;
/* 146 */     this.fileChannel = FileChannel.open(paramPath, new OpenOption[] { StandardOpenOption.READ });
/* 147 */     this.fileLength = this.fileChannel.size();
/* 148 */     this.isTopLevelFileSlice = true;
/*     */ 
/*     */ 
/*     */     
/* 152 */     this.sliceLength = this.fileLength;
/*     */ 
/*     */     
/* 155 */     paramNestedJarHandler.markSliceAsOpen(this);
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
/*     */   public PathSlice(Path paramPath, NestedJarHandler paramNestedJarHandler) {
/* 169 */     this(paramPath, false, 0L, paramNestedJarHandler);
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
/*     */   public Slice slice(long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3) {
/* 190 */     if (this.isDeflatedZipEntry) {
/* 191 */       throw new IllegalArgumentException("Cannot slice a deflated zip entry");
/*     */     }
/* 193 */     return new PathSlice(this, paramLong1, paramLong2, paramBoolean, paramLong3, this.nestedJarHandler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RandomAccessReader randomAccessReader() {
/* 204 */     return (RandomAccessReader)new RandomAccessFileChannelReader(this.fileChannel, this.sliceStartPos, this.sliceLength);
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
/*     */   public byte[] load() {
/* 216 */     if (this.isDeflatedZipEntry) {
/*     */       
/* 218 */       if (this.inflatedLengthHint > 2147483639L) {
/* 219 */         throw new IOException("Uncompressed size is larger than 2GB");
/*     */       }
/* 221 */       InputStream inputStream = open(); Throwable throwable2 = null; 
/* 222 */       try { return NestedJarHandler.readAllBytesAsArray(inputStream, this.inflatedLengthHint); } catch (Throwable throwable4) { Throwable throwable3 = null; throw throwable3; }
/* 223 */       finally { if (throwable1 != null) if (throwable2 != null) { try { throwable1.close(); } catch (Throwable throwable) { throwable2.addSuppressed(throwable); }  } else { throwable.close(); }
/*     */             }
/*     */     
/* 226 */     }  if (this.sliceLength > 2147483639L) {
/* 227 */       throw new IOException("File is larger than 2GB");
/*     */     }
/* 229 */     RandomAccessReader randomAccessReader = randomAccessReader();
/* 230 */     byte[] arrayOfByte = new byte[(int)this.sliceLength];
/* 231 */     if (randomAccessReader.read(0L, arrayOfByte, 0, arrayOfByte.length) < arrayOfByte.length)
/*     */     {
/* 233 */       throw new IOException("File is truncated");
/*     */     }
/* 235 */     return arrayOfByte;
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
/*     */   public ByteBuffer read() {
/* 250 */     if (this.isDeflatedZipEntry) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 255 */       if (this.inflatedLengthHint > 2147483639L) {
/* 256 */         throw new IOException("Uncompressed size is larger than 2GB");
/*     */       }
/* 258 */       return ByteBuffer.wrap(load());
/*     */     } 
/*     */     
/* 261 */     if (this.sliceLength > 2147483639L) {
/* 262 */       throw new IOException("File is larger than 2GB");
/*     */     }
/* 264 */     return ByteBuffer.wrap(load());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 269 */     return super.equals(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 274 */     return super.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 280 */     if (!this.isClosed.getAndSet(true)) {
/* 281 */       if (this.isTopLevelFileSlice && this.fileChannel != null) {
/*     */ 
/*     */         
/*     */         try {
/*     */           
/* 286 */           this.fileChannel.close();
/* 287 */         } catch (IOException iOException) {}
/*     */ 
/*     */         
/* 290 */         this.fileChannel = null;
/*     */       } 
/* 292 */       this.fileChannel = null;
/* 293 */       this.nestedJarHandler.markSliceAsClosed(this);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\fileslice\PathSlice.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */