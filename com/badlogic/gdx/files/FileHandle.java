/*     */ package com.badlogic.gdx.files;
/*     */ 
/*     */ import com.badlogic.gdx.Files;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.StreamUtils;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FilenameFilter;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.io.Reader;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.io.Writer;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.MappedByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileHandle
/*     */ {
/*     */   protected File file;
/*     */   protected Files.FileType type;
/*     */   
/*     */   protected FileHandle() {}
/*     */   
/*     */   public FileHandle(String paramString) {
/*  67 */     this.file = new File(paramString);
/*  68 */     this.type = Files.FileType.Absolute;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileHandle(File paramFile) {
/*  75 */     this.file = paramFile;
/*  76 */     this.type = Files.FileType.Absolute;
/*     */   }
/*     */   
/*     */   protected FileHandle(String paramString, Files.FileType paramFileType) {
/*  80 */     this.type = paramFileType;
/*  81 */     this.file = new File(paramString);
/*     */   }
/*     */   
/*     */   protected FileHandle(File paramFile, Files.FileType paramFileType) {
/*  85 */     this.file = paramFile;
/*  86 */     this.type = paramFileType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String path() {
/*  92 */     return this.file.getPath().replace('\\', '/');
/*     */   }
/*     */ 
/*     */   
/*     */   public String name() {
/*  97 */     return this.file.getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public String extension() {
/*     */     String str;
/*     */     int i;
/* 104 */     if ((i = (str = this.file.getName()).lastIndexOf('.')) == -1) return ""; 
/* 105 */     return str.substring(i + 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public String nameWithoutExtension() {
/*     */     String str;
/*     */     int i;
/* 112 */     if ((i = (str = this.file.getName()).lastIndexOf('.')) == -1) return str; 
/* 113 */     return str.substring(0, i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String pathWithoutExtension() {
/*     */     String str;
/*     */     int i;
/* 121 */     if ((i = (str = this.file.getPath().replace('\\', '/')).lastIndexOf('.')) == -1) return str; 
/* 122 */     return str.substring(0, i);
/*     */   }
/*     */   
/*     */   public Files.FileType type() {
/* 126 */     return this.type;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public File file() {
/* 132 */     if (this.type == Files.FileType.External) return new File(Gdx.files.getExternalStoragePath(), this.file.getPath()); 
/* 133 */     return this.file;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream read() {
/* 139 */     if (this.type == Files.FileType.Classpath || (this.type == Files.FileType.Internal && !file().exists()) || (this.type == Files.FileType.Local && 
/* 140 */       !file().exists())) {
/*     */       InputStream inputStream;
/* 142 */       if ((inputStream = FileHandle.class.getResourceAsStream("/" + this.file.getPath().replace('\\', '/'))) == null) throw new GdxRuntimeException("File not found: " + this.file + " (" + this.type + ")"); 
/* 143 */       return inputStream;
/*     */     } 
/*     */     try {
/* 146 */       return new FileInputStream(file());
/* 147 */     } catch (Exception exception) {
/* 148 */       if (file().isDirectory())
/* 149 */         throw new GdxRuntimeException("Cannot open a stream to a directory: " + this.file + " (" + this.type + ")", exception); 
/* 150 */       throw new GdxRuntimeException("Error reading file: " + this.file + " (" + this.type + ")", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BufferedInputStream read(int paramInt) {
/* 157 */     return new BufferedInputStream(read(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Reader reader() {
/* 163 */     return new InputStreamReader(read());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Reader reader(String paramString) {
/* 169 */     InputStream inputStream = read();
/*     */     try {
/* 171 */       return new InputStreamReader(inputStream, paramString);
/* 172 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 173 */       StreamUtils.closeQuietly(inputStream);
/* 174 */       throw new GdxRuntimeException("Error reading file: " + this, unsupportedEncodingException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BufferedReader reader(int paramInt) {
/* 181 */     return new BufferedReader(new InputStreamReader(read()), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BufferedReader reader(int paramInt, String paramString) {
/*     */     try {
/* 188 */       return new BufferedReader(new InputStreamReader(read(), paramString), paramInt);
/* 189 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 190 */       throw new GdxRuntimeException("Error reading file: " + this, unsupportedEncodingException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String readString() {
/* 197 */     return readString(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String readString(String paramString) {
/* 204 */     StringBuilder stringBuilder = new StringBuilder(estimateLength());
/* 205 */     InputStreamReader inputStreamReader = null;
/*     */     try {
/* 207 */       if (paramString == null) {
/* 208 */         inputStreamReader = new InputStreamReader(read());
/*     */       } else {
/* 210 */         inputStreamReader = new InputStreamReader(read(), paramString);
/* 211 */       }  char[] arrayOfChar = new char[256];
/*     */       
/*     */       int i;
/* 214 */       while ((i = inputStreamReader.read(arrayOfChar)) != -1) {
/* 215 */         stringBuilder.append(arrayOfChar, 0, i);
/*     */       }
/* 217 */     } catch (IOException iOException) {
/* 218 */       throw new GdxRuntimeException("Error reading layout file: " + this, iOException);
/*     */     } finally {
/* 220 */       StreamUtils.closeQuietly(inputStreamReader);
/*     */     } 
/* 222 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] readBytes() {
/* 228 */     InputStream inputStream = read();
/*     */     try {
/* 230 */       return StreamUtils.copyStreamToByteArray(inputStream, estimateLength());
/* 231 */     } catch (IOException iOException) {
/* 232 */       throw new GdxRuntimeException("Error reading file: " + this, iOException);
/*     */     } finally {
/* 234 */       StreamUtils.closeQuietly(inputStream);
/*     */     } 
/*     */   }
/*     */   
/*     */   private int estimateLength() {
/*     */     int i;
/* 240 */     return ((i = (int)length()) != 0) ? i : 512;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int readBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 249 */     InputStream inputStream = read();
/* 250 */     int i = 0;
/*     */     
/*     */     try {
/*     */       int j;
/* 254 */       while ((j = inputStream.read(paramArrayOfbyte, paramInt1 + i, paramInt2 - i)) > 0) {
/* 255 */         i += j;
/*     */       }
/* 257 */     } catch (IOException iOException) {
/* 258 */       throw new GdxRuntimeException("Error reading file: " + this, iOException);
/*     */     } finally {
/* 260 */       StreamUtils.closeQuietly(inputStream);
/*     */     } 
/* 262 */     return i - paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteBuffer map() {
/* 269 */     return map(FileChannel.MapMode.READ_ONLY);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteBuffer map(FileChannel.MapMode paramMapMode) {
/* 276 */     if (this.type == Files.FileType.Classpath) throw new GdxRuntimeException("Cannot map a classpath file: " + this); 
/* 277 */     RandomAccessFile randomAccessFile = null;
/*     */     try {
/* 279 */       File file = file();
/*     */       
/*     */       MappedByteBuffer mappedByteBuffer;
/*     */       FileChannel fileChannel;
/* 283 */       (mappedByteBuffer = (fileChannel = (randomAccessFile = new RandomAccessFile(file, (paramMapMode == FileChannel.MapMode.READ_ONLY) ? "r" : "rw")).getChannel()).map(paramMapMode, 0L, file.length())).order(ByteOrder.nativeOrder());
/* 284 */       mappedByteBuffer = mappedByteBuffer; return mappedByteBuffer;
/* 285 */     } catch (Exception exception) {
/* 286 */       throw new GdxRuntimeException("Error memory mapping file: " + this + " (" + this.type + ")", exception);
/*     */     } finally {
/* 288 */       StreamUtils.closeQuietly(randomAccessFile);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OutputStream write(boolean paramBoolean) {
/* 297 */     if (this.type == Files.FileType.Classpath) throw new GdxRuntimeException("Cannot write to a classpath file: " + this.file); 
/* 298 */     if (this.type == Files.FileType.Internal) throw new GdxRuntimeException("Cannot write to an internal file: " + this.file); 
/* 299 */     parent().mkdirs();
/*     */     try {
/* 301 */       return new FileOutputStream(file(), paramBoolean);
/* 302 */     } catch (Exception exception) {
/* 303 */       if (file().isDirectory())
/* 304 */         throw new GdxRuntimeException("Cannot open a stream to a directory: " + this.file + " (" + this.type + ")", exception); 
/* 305 */       throw new GdxRuntimeException("Error writing file: " + this.file + " (" + this.type + ")", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OutputStream write(boolean paramBoolean, int paramInt) {
/* 315 */     return new BufferedOutputStream(write(paramBoolean), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(InputStream paramInputStream, boolean paramBoolean) {
/* 324 */     OutputStream outputStream = null;
/*     */     try {
/* 326 */       outputStream = write(paramBoolean);
/* 327 */       StreamUtils.copyStream(paramInputStream, outputStream); return;
/* 328 */     } catch (Exception exception) {
/* 329 */       throw new GdxRuntimeException("Error stream writing to file: " + this.file + " (" + this.type + ")", exception);
/*     */     } finally {
/* 331 */       StreamUtils.closeQuietly(paramInputStream);
/* 332 */       StreamUtils.closeQuietly(outputStream);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Writer writer(boolean paramBoolean) {
/* 342 */     return writer(paramBoolean, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Writer writer(boolean paramBoolean, String paramString) {
/* 351 */     if (this.type == Files.FileType.Classpath) throw new GdxRuntimeException("Cannot write to a classpath file: " + this.file); 
/* 352 */     if (this.type == Files.FileType.Internal) throw new GdxRuntimeException("Cannot write to an internal file: " + this.file); 
/* 353 */     parent().mkdirs();
/*     */     try {
/* 355 */       FileOutputStream fileOutputStream = new FileOutputStream(file(), paramBoolean);
/* 356 */       if (paramString == null) {
/* 357 */         return new OutputStreamWriter(fileOutputStream);
/*     */       }
/* 359 */       return new OutputStreamWriter(fileOutputStream, paramString);
/* 360 */     } catch (IOException iOException) {
/* 361 */       if (file().isDirectory())
/* 362 */         throw new GdxRuntimeException("Cannot open a stream to a directory: " + this.file + " (" + this.type + ")", iOException); 
/* 363 */       throw new GdxRuntimeException("Error writing file: " + this.file + " (" + this.type + ")", iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeString(String paramString, boolean paramBoolean) {
/* 372 */     writeString(paramString, paramBoolean, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeString(String paramString1, boolean paramBoolean, String paramString2) {
/* 381 */     Writer writer = null;
/*     */     
/*     */     try {
/* 384 */       (writer = writer(paramBoolean, paramString2)).write(paramString1); return;
/* 385 */     } catch (Exception exception) {
/* 386 */       throw new GdxRuntimeException("Error writing file: " + this.file + " (" + this.type + ")", exception);
/*     */     } finally {
/* 388 */       StreamUtils.closeQuietly(writer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeBytes(byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 397 */     OutputStream outputStream = write(paramBoolean);
/*     */     try {
/* 399 */       outputStream.write(paramArrayOfbyte); return;
/* 400 */     } catch (IOException iOException) {
/* 401 */       throw new GdxRuntimeException("Error writing file: " + this.file + " (" + this.type + ")", iOException);
/*     */     } finally {
/* 403 */       StreamUtils.closeQuietly(outputStream);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
/* 412 */     OutputStream outputStream = write(paramBoolean);
/*     */     try {
/* 414 */       outputStream.write(paramArrayOfbyte, paramInt1, paramInt2); return;
/* 415 */     } catch (IOException iOException) {
/* 416 */       throw new GdxRuntimeException("Error writing file: " + this.file + " (" + this.type + ")", iOException);
/*     */     } finally {
/* 418 */       StreamUtils.closeQuietly(outputStream);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileHandle[] list() {
/* 427 */     if (this.type == Files.FileType.Classpath) throw new GdxRuntimeException("Cannot list a classpath directory: " + this.file); 
/*     */     String[] arrayOfString;
/* 429 */     if ((arrayOfString = file().list()) == null) return new FileHandle[0]; 
/* 430 */     FileHandle[] arrayOfFileHandle = new FileHandle[arrayOfString.length]; byte b; int i;
/* 431 */     for (b = 0, i = arrayOfString.length; b < i; b++)
/* 432 */       arrayOfFileHandle[b] = child(arrayOfString[b]); 
/* 433 */     return arrayOfFileHandle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileHandle[] list(FileFilter paramFileFilter) {
/* 442 */     if (this.type == Files.FileType.Classpath) throw new GdxRuntimeException("Cannot list a classpath directory: " + this.file); 
/*     */     String[] arrayOfString;
/*     */     File file;
/* 445 */     if ((arrayOfString = (file = file()).list()) == null) return new FileHandle[0]; 
/* 446 */     FileHandle[] arrayOfFileHandle = new FileHandle[arrayOfString.length];
/* 447 */     byte b1 = 0; byte b2; int i;
/* 448 */     for (b2 = 0, i = arrayOfString.length; b2 < i; b2++) {
/* 449 */       String str = arrayOfString[b2];
/* 450 */       FileHandle fileHandle = child(str);
/* 451 */       if (paramFileFilter.accept(fileHandle.file())) {
/* 452 */         arrayOfFileHandle[b1] = fileHandle;
/* 453 */         b1++;
/*     */       } 
/* 455 */     }  if (b1 < arrayOfString.length) {
/* 456 */       FileHandle[] arrayOfFileHandle1 = new FileHandle[b1];
/* 457 */       System.arraycopy(arrayOfFileHandle, 0, arrayOfFileHandle1, 0, b1);
/* 458 */       arrayOfFileHandle = arrayOfFileHandle1;
/*     */     } 
/* 460 */     return arrayOfFileHandle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileHandle[] list(FilenameFilter paramFilenameFilter) {
/* 469 */     if (this.type == Files.FileType.Classpath) throw new GdxRuntimeException("Cannot list a classpath directory: " + this.file); 
/*     */     File file;
/*     */     String[] arrayOfString;
/* 472 */     if ((arrayOfString = (file = file()).list()) == null) return new FileHandle[0]; 
/* 473 */     FileHandle[] arrayOfFileHandle = new FileHandle[arrayOfString.length];
/* 474 */     byte b1 = 0; byte b2; int i;
/* 475 */     for (b2 = 0, i = arrayOfString.length; b2 < i; b2++) {
/* 476 */       String str = arrayOfString[b2];
/* 477 */       if (paramFilenameFilter.accept(file, str)) {
/* 478 */         arrayOfFileHandle[b1] = child(str);
/* 479 */         b1++;
/*     */       } 
/* 481 */     }  if (b1 < arrayOfString.length) {
/* 482 */       FileHandle[] arrayOfFileHandle1 = new FileHandle[b1];
/* 483 */       System.arraycopy(arrayOfFileHandle, 0, arrayOfFileHandle1, 0, b1);
/* 484 */       arrayOfFileHandle = arrayOfFileHandle1;
/*     */     } 
/* 486 */     return arrayOfFileHandle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileHandle[] list(String paramString) {
/* 494 */     if (this.type == Files.FileType.Classpath) throw new GdxRuntimeException("Cannot list a classpath directory: " + this.file); 
/*     */     String[] arrayOfString;
/* 496 */     if ((arrayOfString = file().list()) == null) return new FileHandle[0]; 
/* 497 */     FileHandle[] arrayOfFileHandle = new FileHandle[arrayOfString.length];
/* 498 */     byte b1 = 0; byte b2; int i;
/* 499 */     for (b2 = 0, i = arrayOfString.length; b2 < i; b2++) {
/*     */       String str;
/* 501 */       if ((str = arrayOfString[b2]).endsWith(paramString)) {
/* 502 */         arrayOfFileHandle[b1] = child(str);
/* 503 */         b1++;
/*     */       } 
/* 505 */     }  if (b1 < arrayOfString.length) {
/* 506 */       FileHandle[] arrayOfFileHandle1 = new FileHandle[b1];
/* 507 */       System.arraycopy(arrayOfFileHandle, 0, arrayOfFileHandle1, 0, b1);
/* 508 */       arrayOfFileHandle = arrayOfFileHandle1;
/*     */     } 
/* 510 */     return arrayOfFileHandle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDirectory() {
/* 517 */     if (this.type == Files.FileType.Classpath) return false; 
/* 518 */     return file().isDirectory();
/*     */   }
/*     */ 
/*     */   
/*     */   public FileHandle child(String paramString) {
/* 523 */     if (this.file.getPath().length() == 0) return new FileHandle(new File(paramString), this.type); 
/* 524 */     return new FileHandle(new File(this.file, paramString), this.type);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FileHandle sibling(String paramString) {
/* 530 */     if (this.file.getPath().length() == 0) throw new GdxRuntimeException("Cannot get the sibling of the root."); 
/* 531 */     return new FileHandle(new File(this.file.getParent(), paramString), this.type);
/*     */   }
/*     */   
/*     */   public FileHandle parent() {
/*     */     File file;
/* 536 */     if ((file = this.file.getParentFile()) == null)
/* 537 */       if (this.type == Files.FileType.Absolute) {
/* 538 */         file = new File("/");
/*     */       } else {
/* 540 */         file = new File("");
/*     */       }  
/* 542 */     return new FileHandle(file, this.type);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mkdirs() {
/* 547 */     if (this.type == Files.FileType.Classpath) throw new GdxRuntimeException("Cannot mkdirs with a classpath file: " + this.file); 
/* 548 */     if (this.type == Files.FileType.Internal) throw new GdxRuntimeException("Cannot mkdirs with an internal file: " + this.file); 
/* 549 */     file().mkdirs();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean exists() {
/* 555 */     switch (this.type) {
/*     */       case Internal:
/* 557 */         if (file().exists()) return true;
/*     */       
/*     */       case Classpath:
/* 560 */         return (FileHandle.class.getResource("/" + this.file.getPath().replace('\\', '/')) != null);
/*     */     } 
/* 562 */     return file().exists();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean delete() {
/* 568 */     if (this.type == Files.FileType.Classpath) throw new GdxRuntimeException("Cannot delete a classpath file: " + this.file); 
/* 569 */     if (this.type == Files.FileType.Internal) throw new GdxRuntimeException("Cannot delete an internal file: " + this.file); 
/* 570 */     return file().delete();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean deleteDirectory() {
/* 576 */     if (this.type == Files.FileType.Classpath) throw new GdxRuntimeException("Cannot delete a classpath file: " + this.file); 
/* 577 */     if (this.type == Files.FileType.Internal) throw new GdxRuntimeException("Cannot delete an internal file: " + this.file); 
/* 578 */     return deleteDirectory(file());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void emptyDirectory() {
/* 584 */     emptyDirectory(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void emptyDirectory(boolean paramBoolean) {
/* 590 */     if (this.type == Files.FileType.Classpath) throw new GdxRuntimeException("Cannot delete a classpath file: " + this.file); 
/* 591 */     if (this.type == Files.FileType.Internal) throw new GdxRuntimeException("Cannot delete an internal file: " + this.file); 
/* 592 */     emptyDirectory(file(), paramBoolean);
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
/*     */   public void copyTo(FileHandle paramFileHandle) {
/* 604 */     if (!isDirectory()) {
/* 605 */       if (paramFileHandle.isDirectory()) paramFileHandle = paramFileHandle.child(name()); 
/* 606 */       copyFile(this, paramFileHandle);
/*     */       return;
/*     */     } 
/* 609 */     if (paramFileHandle.exists()) {
/* 610 */       if (!paramFileHandle.isDirectory()) throw new GdxRuntimeException("Destination exists but is not a directory: " + paramFileHandle); 
/*     */     } else {
/* 612 */       paramFileHandle.mkdirs();
/* 613 */       if (!paramFileHandle.isDirectory()) throw new GdxRuntimeException("Destination directory cannot be created: " + paramFileHandle); 
/*     */     } 
/* 615 */     copyDirectory(this, paramFileHandle.child(name()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void moveTo(FileHandle paramFileHandle) {
/* 622 */     switch (this.type) {
/*     */       case Classpath:
/* 624 */         throw new GdxRuntimeException("Cannot move a classpath file: " + this.file);
/*     */       case Internal:
/* 626 */         throw new GdxRuntimeException("Cannot move an internal file: " + this.file);
/*     */       
/*     */       case Absolute:
/*     */       case External:
/* 630 */         if (file().renameTo(paramFileHandle.file()))
/*     */           return;  break;
/* 632 */     }  copyTo(paramFileHandle);
/* 633 */     delete();
/* 634 */     if (exists() && isDirectory()) deleteDirectory();
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public long length() {
/* 640 */     if (this.type == Files.FileType.Classpath || (this.type == Files.FileType.Internal && !this.file.exists())) {
/* 641 */       InputStream inputStream = read();
/*     */       
/* 643 */       try { return inputStream.available(); }
/* 644 */       catch (Exception exception) {  }
/*     */       finally
/* 646 */       { StreamUtils.closeQuietly(inputStream); }
/*     */       
/* 648 */       return 0L;
/*     */     } 
/* 650 */     return file().length();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long lastModified() {
/* 657 */     return file().lastModified();
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 661 */     if (!(paramObject instanceof FileHandle)) return false; 
/* 662 */     paramObject = paramObject;
/* 663 */     return (this.type == ((FileHandle)paramObject).type && path().equals(paramObject.path()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     int i;
/* 670 */     return i = (i = 37 + this.type.hashCode()) * 67 + path().hashCode();
/*     */   }
/*     */   
/*     */   public String toString() {
/* 674 */     return this.file.getPath().replace('\\', '/');
/*     */   }
/*     */   
/*     */   public static FileHandle tempFile(String paramString) {
/*     */     try {
/* 679 */       return new FileHandle(File.createTempFile(paramString, null));
/* 680 */     } catch (IOException iOException) {
/* 681 */       throw new GdxRuntimeException("Unable to create temp file.", iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static FileHandle tempDirectory(String paramString) {
/*     */     try {
/*     */       File file;
/* 688 */       if (!(file = File.createTempFile(paramString, null)).delete()) throw new IOException("Unable to delete temp file: " + file); 
/* 689 */       if (!file.mkdir()) throw new IOException("Unable to create temp directory: " + file); 
/* 690 */       return new FileHandle(file);
/* 691 */     } catch (IOException iOException) {
/* 692 */       throw new GdxRuntimeException("Unable to create temp file.", iOException);
/*     */     } 
/*     */   }
/*     */   private static void emptyDirectory(File paramFile, boolean paramBoolean) {
/*     */     File[] arrayOfFile;
/* 697 */     if (paramFile.exists() && (
/*     */       
/* 699 */       arrayOfFile = paramFile.listFiles()) != null) {
/* 700 */       byte b; int i; for (b = 0, i = arrayOfFile.length; b < i; b++) {
/* 701 */         if (!arrayOfFile[b].isDirectory()) {
/* 702 */           arrayOfFile[b].delete();
/* 703 */         } else if (paramBoolean) {
/* 704 */           emptyDirectory(arrayOfFile[b], true);
/*     */         } else {
/* 706 */           deleteDirectory(arrayOfFile[b]);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean deleteDirectory(File paramFile) {
/* 713 */     emptyDirectory(paramFile, false);
/* 714 */     return paramFile.delete();
/*     */   }
/*     */   
/*     */   private static void copyFile(FileHandle paramFileHandle1, FileHandle paramFileHandle2) {
/*     */     try {
/* 719 */       paramFileHandle2.write(paramFileHandle1.read(), false); return;
/* 720 */     } catch (Exception exception) {
/* 721 */       throw new GdxRuntimeException("Error copying source file: " + paramFileHandle1.file + " (" + paramFileHandle1.type + ")\nTo destination: " + paramFileHandle2.file + " (" + paramFileHandle2.type + ")", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void copyDirectory(FileHandle paramFileHandle1, FileHandle paramFileHandle2) {
/* 727 */     paramFileHandle2.mkdirs();
/* 728 */     FileHandle[] arrayOfFileHandle = paramFileHandle1.list(); byte b; int i;
/* 729 */     for (b = 0, i = arrayOfFileHandle.length; b < i; b++) {
/* 730 */       FileHandle fileHandle1 = arrayOfFileHandle[b];
/* 731 */       FileHandle fileHandle2 = paramFileHandle2.child(fileHandle1.name());
/* 732 */       if (fileHandle1.isDirectory()) {
/* 733 */         copyDirectory(fileHandle1, fileHandle2);
/*     */       } else {
/* 735 */         copyFile(fileHandle1, fileHandle2);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\files\FileHandle.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */