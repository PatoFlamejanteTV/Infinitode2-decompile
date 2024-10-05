/*     */ package nonapi.io.github.classgraph.fileslice;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.util.Arrays;
/*     */ import nonapi.io.github.classgraph.fastzipfilereader.NestedJarHandler;
/*     */ import nonapi.io.github.classgraph.fileslice.reader.RandomAccessArrayReader;
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
/*     */ public class ArraySlice
/*     */   extends Slice
/*     */ {
/*     */   public byte[] arr;
/*     */   
/*     */   private ArraySlice(ArraySlice paramArraySlice, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, NestedJarHandler paramNestedJarHandler) {
/*  64 */     super(paramArraySlice, paramLong1, paramLong2, paramBoolean, paramLong3, paramNestedJarHandler);
/*  65 */     this.arr = paramArraySlice.arr;
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
/*     */   public ArraySlice(byte[] paramArrayOfbyte, boolean paramBoolean, long paramLong, NestedJarHandler paramNestedJarHandler) {
/*  83 */     super(paramArrayOfbyte.length, paramBoolean, paramLong, paramNestedJarHandler);
/*  84 */     this.arr = paramArrayOfbyte;
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
/* 104 */     if (this.isDeflatedZipEntry) {
/* 105 */       throw new IllegalArgumentException("Cannot slice a deflated zip entry");
/*     */     }
/* 107 */     return new ArraySlice(this, paramLong1, paramLong2, paramBoolean, paramLong3, this.nestedJarHandler);
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
/* 119 */     if (this.isDeflatedZipEntry) {
/*     */       
/* 121 */       InputStream inputStream = open(); Throwable throwable2 = null; 
/* 122 */       try { return NestedJarHandler.readAllBytesAsArray(inputStream, this.inflatedLengthHint); } catch (Throwable throwable4) { Throwable throwable3 = null; throw throwable3; }
/* 123 */       finally { if (throwable1 != null) if (throwable2 != null) { try { throwable1.close(); } catch (Throwable throwable) { throwable2.addSuppressed(throwable); }  } else { throwable.close(); }   } 
/* 124 */     }  if (this.sliceStartPos == 0L && this.sliceLength == this.arr.length)
/*     */     {
/* 126 */       return this.arr;
/*     */     }
/*     */     
/* 129 */     return Arrays.copyOfRange(this.arr, (int)this.sliceStartPos, (int)(this.sliceStartPos + this.sliceLength));
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
/* 140 */     return (RandomAccessReader)new RandomAccessArrayReader(this.arr, (int)this.sliceStartPos, (int)this.sliceLength);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 145 */     return super.equals(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 150 */     return super.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\fileslice\ArraySlice.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */