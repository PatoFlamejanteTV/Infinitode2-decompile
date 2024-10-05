/*     */ package nonapi.io.github.classgraph.fastzipfilereader;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.nio.file.Path;
/*     */ import java.util.Objects;
/*     */ import nonapi.io.github.classgraph.fileslice.Slice;
/*     */ import nonapi.io.github.classgraph.scanspec.AcceptReject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ZipFileSlice
/*     */ {
/*     */   private final ZipFileSlice parentZipFileSlice;
/*     */   protected final PhysicalZipFile physicalZipFile;
/*     */   private final String pathWithinParentZipFileSlice;
/*     */   public Slice slice;
/*     */   
/*     */   ZipFileSlice(PhysicalZipFile paramPhysicalZipFile) {
/*  57 */     this.parentZipFileSlice = null;
/*  58 */     this.physicalZipFile = paramPhysicalZipFile;
/*  59 */     this.slice = paramPhysicalZipFile.slice;
/*  60 */     this.pathWithinParentZipFileSlice = paramPhysicalZipFile.getPathStr();
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
/*     */   ZipFileSlice(PhysicalZipFile paramPhysicalZipFile, FastZipEntry paramFastZipEntry) {
/*  73 */     this.parentZipFileSlice = paramFastZipEntry.parentLogicalZipFile;
/*  74 */     this.physicalZipFile = paramPhysicalZipFile;
/*  75 */     this.slice = paramPhysicalZipFile.slice;
/*  76 */     this.pathWithinParentZipFileSlice = paramFastZipEntry.entryName;
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
/*     */   ZipFileSlice(FastZipEntry paramFastZipEntry) {
/*  90 */     this.parentZipFileSlice = paramFastZipEntry.parentLogicalZipFile;
/*  91 */     this.physicalZipFile = paramFastZipEntry.parentLogicalZipFile.physicalZipFile;
/*  92 */     this.slice = paramFastZipEntry.getSlice();
/*  93 */     this.pathWithinParentZipFileSlice = paramFastZipEntry.entryName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ZipFileSlice(ZipFileSlice paramZipFileSlice) {
/* 103 */     this.parentZipFileSlice = paramZipFileSlice.parentZipFileSlice;
/* 104 */     this.physicalZipFile = paramZipFileSlice.physicalZipFile;
/* 105 */     this.slice = paramZipFileSlice.slice;
/* 106 */     this.pathWithinParentZipFileSlice = paramZipFileSlice.pathWithinParentZipFileSlice;
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
/*     */   public boolean isAcceptedAndNotRejected(AcceptReject.AcceptRejectLeafname paramAcceptRejectLeafname) {
/* 119 */     if (paramAcceptRejectLeafname.isAcceptedAndNotRejected(this.pathWithinParentZipFileSlice) && (this.parentZipFileSlice == null || this.parentZipFileSlice
/* 120 */       .isAcceptedAndNotRejected(paramAcceptRejectLeafname))) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ZipFileSlice getParentZipFileSlice() {
/* 130 */     return this.parentZipFileSlice;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPathWithinParentZipFileSlice() {
/* 140 */     return this.pathWithinParentZipFileSlice;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void appendPath(StringBuilder paramStringBuilder) {
/* 150 */     if (this.parentZipFileSlice != null) {
/* 151 */       this.parentZipFileSlice.appendPath(paramStringBuilder);
/* 152 */       if (paramStringBuilder.length() > 0) {
/* 153 */         paramStringBuilder.append("!/");
/*     */       }
/*     */     } 
/* 156 */     paramStringBuilder.append(this.pathWithinParentZipFileSlice);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPath() {
/* 165 */     StringBuilder stringBuilder = new StringBuilder();
/* 166 */     appendPath(stringBuilder);
/* 167 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getPhysicalFile() {
/*     */     Path path;
/* 178 */     if ((path = this.physicalZipFile.getPath()) != null) {
/*     */       try {
/* 180 */         return path.toFile();
/* 181 */       } catch (UnsupportedOperationException unsupportedOperationException) {
/*     */         
/* 183 */         return null;
/*     */       } 
/*     */     }
/* 186 */     return this.physicalZipFile.getFile();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 195 */     if (paramObject == this)
/* 196 */       return true; 
/* 197 */     if (!(paramObject instanceof ZipFileSlice)) {
/* 198 */       return false;
/*     */     }
/* 200 */     paramObject = paramObject;
/* 201 */     if (Objects.equals(this.physicalZipFile, ((ZipFileSlice)paramObject).physicalZipFile) && Objects.equals(this.slice, ((ZipFileSlice)paramObject).slice) && 
/* 202 */       Objects.equals(this.pathWithinParentZipFileSlice, ((ZipFileSlice)paramObject).pathWithinParentZipFileSlice)) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 211 */     return Objects.hash(new Object[] { this.physicalZipFile, this.slice, this.pathWithinParentZipFileSlice });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 219 */     String str1 = getPath();
/*     */     String str2;
/* 221 */     if ((str2 = (String)((this.physicalZipFile.getPath() == null) ? null : this.physicalZipFile.getPath().toString())) == null) {
/* 222 */       str2 = (this.physicalZipFile.getFile() == null) ? null : this.physicalZipFile.getFile().toString();
/*     */     }
/* 224 */     return "[" + ((str2 != null && !str2.equals(str1)) ? (str1 + " -> " + str2) : str1) + " ; byte range: " + this.slice.sliceStartPos + ".." + (this.slice.sliceStartPos + this.slice.sliceLength) + " / " + this.physicalZipFile
/*     */       
/* 226 */       .length() + "]";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\fastzipfilereader\ZipFileSlice.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */