/*     */ package nonapi.io.github.classgraph.fastzipfilereader;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Calendar;
/*     */ import java.util.TimeZone;
/*     */ import nonapi.io.github.classgraph.fileslice.Slice;
/*     */ import nonapi.io.github.classgraph.fileslice.reader.RandomAccessReader;
/*     */ import nonapi.io.github.classgraph.utils.VersionFinder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FastZipEntry
/*     */   implements Comparable<FastZipEntry>
/*     */ {
/*     */   final LogicalZipFile parentLogicalZipFile;
/*     */   private final long locHeaderPos;
/*     */   public final String entryName;
/*     */   final boolean isDeflated;
/*     */   public final long compressedSize;
/*     */   public final long uncompressedSize;
/*     */   private long lastModifiedTimeMillis;
/*     */   private final int lastModifiedTimeMSDOS;
/*     */   private final int lastModifiedDateMSDOS;
/*     */   public final int fileAttributes;
/*     */   private Slice slice;
/*     */   final int version;
/*     */   public final String entryNameUnversioned;
/*     */   
/*     */   FastZipEntry(LogicalZipFile paramLogicalZipFile, long paramLong1, String paramString, boolean paramBoolean1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2) {
/* 115 */     this.parentLogicalZipFile = paramLogicalZipFile;
/* 116 */     this.locHeaderPos = paramLong1;
/* 117 */     this.entryName = paramString;
/* 118 */     this.isDeflated = paramBoolean1;
/* 119 */     this.compressedSize = paramLong2;
/* 120 */     this.uncompressedSize = (!paramBoolean1 && paramLong3 < 0L) ? paramLong2 : paramLong3;
/* 121 */     this.lastModifiedTimeMillis = paramLong4;
/* 122 */     this.lastModifiedTimeMSDOS = paramInt1;
/* 123 */     this.lastModifiedDateMSDOS = paramInt2;
/* 124 */     this.fileAttributes = paramInt3;
/*     */ 
/*     */     
/* 127 */     int i = 8;
/* 128 */     String str = paramString;
/* 129 */     if (paramString.startsWith("META-INF/versions/") && paramString
/* 130 */       .length() > 18 + 1) {
/*     */       int j;
/*     */       
/* 133 */       if ((j = paramString.indexOf('/', 18)) > 0) {
/*     */         
/* 135 */         String str1 = paramString.substring(18, j);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 140 */         int k = 0;
/* 141 */         if (str1.length() < 6 && !str1.isEmpty()) {
/* 142 */           for (byte b = 0; b < str1.length(); b++) {
/*     */             char c;
/* 144 */             if ((c = str1.charAt(b)) < '0' || c > '9') {
/* 145 */               k = 0;
/*     */               break;
/*     */             } 
/* 148 */             if (!k) {
/* 149 */               k = c - 48;
/*     */             } else {
/* 151 */               k = k * 10 + c - 48;
/*     */             } 
/*     */           } 
/*     */         }
/* 155 */         if (k != 0) {
/* 156 */           i = k;
/*     */         }
/*     */         
/* 159 */         if (i < 9 || i > VersionFinder.JAVA_MAJOR_VERSION) {
/* 160 */           i = 8;
/*     */         }
/* 162 */         if (!paramBoolean2 && i > 8)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 168 */           if ((str = paramString.substring(j + 1)).startsWith("META-INF/")) {
/* 169 */             i = 8;
/* 170 */             str = paramString;
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 175 */     this.version = i;
/* 176 */     this.entryNameUnversioned = str;
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
/*     */   public Slice getSlice() {
/* 190 */     if (this.slice == null) {
/*     */       RandomAccessReader randomAccessReader;
/*     */ 
/*     */       
/* 194 */       if ((randomAccessReader = this.parentLogicalZipFile.slice.randomAccessReader()).readInt(this.locHeaderPos) != 67324752) {
/* 195 */         throw new IOException("Zip entry has bad LOC header: " + this.entryName);
/*     */       }
/*     */       
/*     */       long l;
/* 199 */       if ((l = this.locHeaderPos + 30L + randomAccessReader.readShort(this.locHeaderPos + 26L) + randomAccessReader.readShort(this.locHeaderPos + 28L)) > this.parentLogicalZipFile.slice.sliceLength) {
/* 200 */         throw new IOException("Unexpected EOF when trying to read zip entry data: " + this.entryName);
/*     */       }
/*     */ 
/*     */       
/* 204 */       this.slice = this.parentLogicalZipFile.slice.slice(l, this.compressedSize, this.isDeflated, this.uncompressedSize);
/*     */     } 
/* 206 */     return this.slice;
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
/*     */   public String getPath() {
/* 218 */     return this.parentLogicalZipFile.getPath() + "!/" + this.entryName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLastModifiedTimeMillis() {
/* 228 */     if (this.lastModifiedTimeMillis == 0L && (this.lastModifiedDateMSDOS != 0 || this.lastModifiedTimeMSDOS != 0)) {
/*     */       
/* 230 */       int i = (this.lastModifiedTimeMSDOS & 0x1F) << 1;
/* 231 */       int j = this.lastModifiedTimeMSDOS >> 5 & 0x3F;
/* 232 */       int k = this.lastModifiedTimeMSDOS >> 11;
/* 233 */       int m = this.lastModifiedDateMSDOS & 0x1F;
/* 234 */       int n = (this.lastModifiedDateMSDOS >> 5 & 0x7) - 1;
/* 235 */       int i1 = (this.lastModifiedDateMSDOS >> 9) + 1980;
/*     */       
/*     */       Calendar calendar;
/* 238 */       (calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))).set(i1, n, m, k, j, i);
/*     */       
/* 240 */       calendar.set(14, 0);
/*     */ 
/*     */       
/* 243 */       this.lastModifiedTimeMillis = calendar.getTimeInMillis();
/*     */     } 
/*     */ 
/*     */     
/* 247 */     return this.lastModifiedTimeMillis;
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
/*     */   public int compareTo(FastZipEntry paramFastZipEntry) {
/*     */     int i;
/* 261 */     if ((i = paramFastZipEntry.version - this.version) != 0) {
/* 262 */       return i;
/*     */     }
/*     */     
/* 265 */     if ((i = this.entryNameUnversioned.compareTo(paramFastZipEntry.entryNameUnversioned)) != 0) {
/* 266 */       return i;
/*     */     }
/*     */     
/* 269 */     if ((i = this.entryName.compareTo(paramFastZipEntry.entryName)) != 0) {
/* 270 */       return i;
/*     */     }
/*     */     
/*     */     long l;
/*     */     
/* 275 */     return ((l = this.locHeaderPos - paramFastZipEntry.locHeaderPos) < 0L) ? -1 : ((l > 0L) ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 283 */     return this.parentLogicalZipFile.hashCode() ^ this.version ^ this.entryName.hashCode() ^ (int)this.locHeaderPos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 291 */     if (this == paramObject)
/* 292 */       return true; 
/* 293 */     if (!(paramObject instanceof FastZipEntry)) {
/* 294 */       return false;
/*     */     }
/* 296 */     paramObject = paramObject;
/* 297 */     return (this.parentLogicalZipFile.equals(((FastZipEntry)paramObject).parentLogicalZipFile) && compareTo((FastZipEntry)paramObject) == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 305 */     return "jar:file:" + getPath();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\fastzipfilereader\FastZipEntry.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */