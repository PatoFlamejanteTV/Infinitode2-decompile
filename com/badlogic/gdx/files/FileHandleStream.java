/*    */ package com.badlogic.gdx.files;
/*    */ 
/*    */ import com.badlogic.gdx.Files;
/*    */ import java.io.File;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class FileHandleStream
/*    */   extends FileHandle
/*    */ {
/*    */   public FileHandleStream(String paramString) {
/* 31 */     super(new File(paramString), Files.FileType.Absolute);
/*    */   }
/*    */   
/*    */   public boolean isDirectory() {
/* 35 */     return false;
/*    */   }
/*    */   
/*    */   public long length() {
/* 39 */     return 0L;
/*    */   }
/*    */   
/*    */   public boolean exists() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public FileHandle child(String paramString) {
/* 47 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public FileHandle sibling(String paramString) {
/* 51 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public FileHandle parent() {
/* 55 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public InputStream read() {
/* 59 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public OutputStream write(boolean paramBoolean) {
/* 63 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public FileHandle[] list() {
/* 67 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public void mkdirs() {
/* 71 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public boolean delete() {
/* 75 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public boolean deleteDirectory() {
/* 79 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public void copyTo(FileHandle paramFileHandle) {
/* 83 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public void moveTo(FileHandle paramFileHandle) {
/* 87 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public void emptyDirectory() {
/* 91 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public void emptyDirectory(boolean paramBoolean) {
/* 95 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\files\FileHandleStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */