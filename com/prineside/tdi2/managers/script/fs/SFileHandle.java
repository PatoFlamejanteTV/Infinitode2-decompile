/*     */ package com.prineside.tdi2.managers.script.fs;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.FilenameFilter;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Reader;
/*     */ import java.io.Writer;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS(serializer = SFileHandle.Serializer.class)
/*     */ public final class SFileHandle
/*     */ {
/*  47 */   private static final String[] a = new String[] { "cache/script-temp-files/", "cache/script-data/", "i18n/", "levels/", "models/", "particles/", "res/", "resourcepacks/", "scripts/", "shaders/" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   private static final String[] b = new String[] { "res/luaj/" };
/*     */   
/*     */   private final FileHandle c;
/*     */ 
/*     */   
/*     */   public static class Serializer
/*     */     extends com.esotericsoftware.kryo.Serializer<SFileHandle>
/*     */   {
/*     */     public void write(Kryo param1Kryo, Output param1Output, SFileHandle param1SFileHandle) {
/*  70 */       param1Output.writeString(SFileHandle.a(param1SFileHandle).path());
/*     */     }
/*     */ 
/*     */     
/*     */     public SFileHandle read(Kryo param1Kryo, Input param1Input, Class<? extends SFileHandle> param1Class) {
/*  75 */       String str = param1Input.readString();
/*  76 */       return new SFileHandle(str);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void assertAccessible(String paramString) {
/*  85 */     if (paramString.contains("..")) {
/*  86 */       throw new IllegalArgumentException("Paths can not contain '..'");
/*     */     }
/*  88 */     if (paramString.matches("[^a-zA-Z0-9_\\-./]")) {
/*  89 */       throw new IllegalArgumentException("Invalid characters found in the path, allowed characters: [a-zA-Z0-9_\\-./]");
/*     */     }
/*     */     File file;
/*  92 */     String str = (file = Gdx.files.local(paramString).file()).getAbsolutePath();
/*     */     
/*  94 */     boolean bool = false; String[] arrayOfString; int i; byte b;
/*  95 */     for (i = (arrayOfString = a).length, b = 0; b < i; ) { String str1 = arrayOfString[b];
/*  96 */       File file1 = Gdx.files.local(str1).file();
/*  97 */       if (str.startsWith(file1.getAbsolutePath())) {
/*  98 */         bool = true; break;
/*     */       } 
/*     */       b++; }
/*     */     
/* 102 */     if (!bool) {
/* 103 */       throw new IllegalArgumentException("Path is outside of the accessible dirs: " + Arrays.toString(a));
/*     */     }
/*     */     
/* 106 */     for (i = (arrayOfString = b).length, b = 0; b < i; ) { String str1 = arrayOfString[b];
/* 107 */       File file1 = Gdx.files.local(str1).file();
/* 108 */       if (str.startsWith(file1.getAbsolutePath())) {
/* 109 */         throw new IllegalArgumentException("Directory " + str1 + " is not accessible");
/*     */       }
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isAccessible(String paramString) {
/*     */     try {
/* 119 */       if (paramString.contains("..")) {
/* 120 */         return false;
/*     */       }
/* 122 */       if (paramString.matches("[^a-zA-Z0-9_\\-./]")) {
/* 123 */         return false;
/*     */       }
/*     */       File file;
/* 126 */       String str = (file = Gdx.files.local(paramString).file()).getAbsolutePath();
/*     */       
/* 128 */       boolean bool = false; String[] arrayOfString; int i; byte b;
/* 129 */       for (i = (arrayOfString = a).length, b = 0; b < i; ) { String str1 = arrayOfString[b];
/*     */         
/*     */         File file1;
/* 132 */         String str2 = (str2 = (file1 = Gdx.files.local(str1).file()).getAbsolutePath()).substring(0, str2.length() - str1.length());
/* 133 */         if (str.startsWith(str2)) {
/* 134 */           bool = true; break;
/*     */         } 
/*     */         b++; }
/*     */       
/* 138 */       if (!bool) {
/* 139 */         return false;
/*     */       }
/*     */       
/* 142 */       for (i = (arrayOfString = b).length, b = 0; b < i; ) { String str1 = arrayOfString[b];
/*     */         
/*     */         File file1;
/* 145 */         String str2 = (str2 = (file1 = Gdx.files.local(str1).file()).getAbsolutePath()).substring(0, str2.length() - str1.length());
/* 146 */         if (str.startsWith(str2)) {
/* 147 */           return false;
/*     */         }
/*     */         b++; }
/*     */       
/* 151 */       return true;
/* 152 */     } catch (Exception exception) {
/* 153 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SFileHandle(String paramString) {
/* 163 */     assertAccessible(paramString);
/* 164 */     this.c = Gdx.files.local(paramString);
/*     */   }
/*     */   
/*     */   private SFileHandle(FileHandle paramFileHandle) {
/* 168 */     assertAccessible(paramFileHandle.path());
/* 169 */     this.c = paramFileHandle;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String path() {
/* 175 */     return this.c.path();
/*     */   }
/*     */ 
/*     */   
/*     */   public final String name() {
/* 180 */     return this.c.name();
/*     */   }
/*     */ 
/*     */   
/*     */   public final String extension() {
/* 185 */     return this.c.extension();
/*     */   }
/*     */ 
/*     */   
/*     */   public final String nameWithoutExtension() {
/* 190 */     return this.c.nameWithoutExtension();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String pathWithoutExtension() {
/* 197 */     return this.c.pathWithoutExtension();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final InputStream read() {
/* 203 */     return this.c.read();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BufferedInputStream read(int paramInt) {
/* 209 */     return this.c.read(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Reader reader() {
/* 215 */     return this.c.reader();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Reader reader(String paramString) {
/* 221 */     return this.c.reader(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BufferedReader reader(int paramInt) {
/* 227 */     return this.c.reader(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BufferedReader reader(int paramInt, String paramString) {
/* 233 */     return reader(paramInt, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String readString() {
/* 239 */     return this.c.readString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String readString(String paramString) {
/* 246 */     return this.c.readString(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final byte[] readBytes() {
/* 252 */     return this.c.readBytes();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int readBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 261 */     return this.c.readBytes(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ByteBuffer map() {
/* 268 */     return this.c.map();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ByteBuffer map(FileChannel.MapMode paramMapMode) {
/* 275 */     return this.c.map(paramMapMode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final OutputStream write(boolean paramBoolean) {
/* 283 */     return this.c.write(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final OutputStream write(boolean paramBoolean, int paramInt) {
/* 292 */     return this.c.write(paramBoolean, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(InputStream paramInputStream, boolean paramBoolean) {
/* 301 */     this.c.write(paramInputStream, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Writer writer(boolean paramBoolean) {
/* 309 */     return this.c.writer(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Writer writer(boolean paramBoolean, String paramString) {
/* 318 */     return this.c.writer(paramBoolean, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void writeString(String paramString, boolean paramBoolean) {
/* 326 */     this.c.writeString(paramString, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void writeString(String paramString1, boolean paramBoolean, String paramString2) {
/* 335 */     this.c.writeString(paramString1, paramBoolean, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void writeBytes(byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 343 */     this.c.writeBytes(paramArrayOfbyte, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void writeBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
/* 351 */     this.c.writeBytes(paramArrayOfbyte, paramInt1, paramInt2, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final SFileHandle[] list() {
/* 359 */     FileHandle[] arrayOfFileHandle = this.c.list();
/* 360 */     Array array = new Array(true, 1, SFileHandle.class); int i; byte b;
/* 361 */     for (i = (arrayOfFileHandle = arrayOfFileHandle).length, b = 0; b < i; b++) {
/* 362 */       FileHandle fileHandle; if (isAccessible((fileHandle = arrayOfFileHandle[b]).path())) {
/* 363 */         array.add(new SFileHandle(fileHandle.path()));
/*     */       }
/*     */     } 
/* 366 */     return (SFileHandle[])array.toArray();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final SFileHandle[] list(FileFilter paramFileFilter) {
/* 375 */     FileHandle[] arrayOfFileHandle = this.c.list(paramFileFilter);
/* 376 */     Array array = new Array(true, 1, SFileHandle.class); int i; byte b;
/* 377 */     for (i = (arrayOfFileHandle = arrayOfFileHandle).length, b = 0; b < i; b++) {
/* 378 */       FileHandle fileHandle; if (isAccessible((fileHandle = arrayOfFileHandle[b]).path())) {
/* 379 */         array.add(new SFileHandle(fileHandle.path()));
/*     */       }
/*     */     } 
/* 382 */     return (SFileHandle[])array.toArray();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final SFileHandle[] list(FilenameFilter paramFilenameFilter) {
/* 391 */     FileHandle[] arrayOfFileHandle = this.c.list(paramFilenameFilter);
/* 392 */     Array array = new Array(true, 1, SFileHandle.class); int i; byte b;
/* 393 */     for (i = (arrayOfFileHandle = arrayOfFileHandle).length, b = 0; b < i; b++) {
/* 394 */       FileHandle fileHandle; if (isAccessible((fileHandle = arrayOfFileHandle[b]).path())) {
/* 395 */         array.add(new SFileHandle(fileHandle.path()));
/*     */       }
/*     */     } 
/* 398 */     return (SFileHandle[])array.toArray();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final SFileHandle[] list(String paramString) {
/* 406 */     FileHandle[] arrayOfFileHandle = this.c.list(paramString);
/* 407 */     Array array = new Array(true, 1, SFileHandle.class); int i; byte b;
/* 408 */     for (i = (arrayOfFileHandle = arrayOfFileHandle).length, b = 0; b < i; b++) {
/* 409 */       FileHandle fileHandle; if (isAccessible((fileHandle = arrayOfFileHandle[b]).path())) {
/* 410 */         array.add(new SFileHandle(fileHandle.path()));
/*     */       }
/*     */     } 
/* 413 */     return (SFileHandle[])array.toArray();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isDirectory() {
/* 420 */     return this.c.isDirectory();
/*     */   }
/*     */ 
/*     */   
/*     */   public final SFileHandle child(String paramString) {
/* 425 */     return new SFileHandle(this.c.child(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final SFileHandle sibling(String paramString) {
/* 431 */     return new SFileHandle(this.c.sibling(paramString));
/*     */   }
/*     */   
/*     */   public final SFileHandle parent() {
/* 435 */     return new SFileHandle(this.c.parent());
/*     */   }
/*     */ 
/*     */   
/*     */   public final void mkdirs() {
/* 440 */     this.c.mkdirs();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean exists() {
/* 446 */     return this.c.exists();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean delete() {
/* 452 */     return this.c.delete();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean deleteDirectory() {
/* 458 */     return this.c.deleteDirectory();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void emptyDirectory() {
/* 464 */     this.c.emptyDirectory();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void emptyDirectory(boolean paramBoolean) {
/* 470 */     this.c.emptyDirectory(paramBoolean);
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
/*     */   public final void copyTo(SFileHandle paramSFileHandle) {
/* 482 */     this.c.copyTo(paramSFileHandle.c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void moveTo(SFileHandle paramSFileHandle) {
/* 489 */     this.c.moveTo(paramSFileHandle.c);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final long length() {
/* 495 */     return this.c.length();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long lastModified() {
/* 502 */     return this.c.lastModified();
/*     */   }
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 506 */     if (!(paramObject instanceof SFileHandle)) return false; 
/* 507 */     paramObject = paramObject;
/* 508 */     return path().equals(paramObject.path());
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/*     */     int i;
/* 514 */     return i = 67 + path().hashCode();
/*     */   }
/*     */   
/*     */   public final String toString() {
/* 518 */     return this.c.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\script\fs\SFileHandle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */