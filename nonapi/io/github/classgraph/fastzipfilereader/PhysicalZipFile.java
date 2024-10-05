/*     */ package nonapi.io.github.classgraph.fastzipfilereader;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.InputStream;
/*     */ import java.nio.file.Path;
/*     */ import java.util.Objects;
/*     */ import nonapi.io.github.classgraph.fileslice.ArraySlice;
/*     */ import nonapi.io.github.classgraph.fileslice.FileSlice;
/*     */ import nonapi.io.github.classgraph.fileslice.PathSlice;
/*     */ import nonapi.io.github.classgraph.fileslice.Slice;
/*     */ import nonapi.io.github.classgraph.utils.FastPathResolver;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PhysicalZipFile
/*     */ {
/*     */   private Path path;
/*     */   private File file;
/*     */   private final String pathStr;
/*     */   Slice slice;
/*     */   NestedJarHandler nestedJarHandler;
/*     */   private int hashCode;
/*     */   
/*     */   PhysicalZipFile(File paramFile, NestedJarHandler paramNestedJarHandler, LogNode paramLogNode) {
/*  80 */     this.nestedJarHandler = paramNestedJarHandler;
/*  81 */     this.file = paramFile;
/*  82 */     this.pathStr = FastPathResolver.resolve(FileUtils.currDirPath(), paramFile.getPath());
/*  83 */     this.slice = (Slice)new FileSlice(paramFile, paramNestedJarHandler, paramLogNode);
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
/*     */   PhysicalZipFile(Path paramPath, NestedJarHandler paramNestedJarHandler, LogNode paramLogNode) {
/* 100 */     this.nestedJarHandler = paramNestedJarHandler;
/* 101 */     this.path = paramPath;
/* 102 */     this.pathStr = FastPathResolver.resolve(FileUtils.currDirPath(), paramPath.toString());
/* 103 */     this.slice = (Slice)new PathSlice(paramPath, paramNestedJarHandler);
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
/*     */   PhysicalZipFile(byte[] paramArrayOfbyte, File paramFile, String paramString, NestedJarHandler paramNestedJarHandler) {
/* 122 */     this.nestedJarHandler = paramNestedJarHandler;
/* 123 */     this.file = paramFile;
/* 124 */     this.pathStr = paramString;
/* 125 */     this.slice = (Slice)new ArraySlice(paramArrayOfbyte, false, 0L, paramNestedJarHandler);
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
/*     */   PhysicalZipFile(InputStream paramInputStream, long paramLong, String paramString, NestedJarHandler paramNestedJarHandler, LogNode paramLogNode) {
/* 149 */     this.nestedJarHandler = paramNestedJarHandler;
/* 150 */     this.pathStr = paramString;
/*     */ 
/*     */     
/* 153 */     this.slice = paramNestedJarHandler.readAllBytesWithSpilloverToDisk(paramInputStream, paramString, paramLong, paramLogNode);
/*     */     
/* 155 */     this.file = (this.slice instanceof FileSlice) ? ((FileSlice)this.slice).file : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Path getPath() {
/* 165 */     return this.path;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getFile() {
/* 175 */     return this.file;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPathStr() {
/* 186 */     return this.pathStr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long length() {
/* 196 */     return this.slice.sliceLength;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 204 */     if (this.hashCode == 0) {
/* 205 */       this.hashCode = (this.file == null) ? 0 : this.file.hashCode();
/* 206 */       if (this.hashCode == 0) {
/* 207 */         this.hashCode = 1;
/*     */       }
/*     */     } 
/* 210 */     return this.hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 218 */     if (paramObject == this)
/* 219 */       return true; 
/* 220 */     if (!(paramObject instanceof PhysicalZipFile)) {
/* 221 */       return false;
/*     */     }
/* 223 */     paramObject = paramObject;
/* 224 */     return Objects.equals(this.file, ((PhysicalZipFile)paramObject).file);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 232 */     return this.pathStr;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\fastzipfilereader\PhysicalZipFile.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */