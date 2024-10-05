/*    */ package com.badlogic.gdx.backends.lwjgl3;
/*    */ 
/*    */ import com.badlogic.gdx.Files;
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*    */ import java.io.File;
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
/*    */ public final class Lwjgl3FileHandle
/*    */   extends FileHandle
/*    */ {
/*    */   public Lwjgl3FileHandle(String paramString, Files.FileType paramFileType) {
/* 29 */     super(paramString, paramFileType);
/*    */   }
/*    */   
/*    */   public Lwjgl3FileHandle(File paramFile, Files.FileType paramFileType) {
/* 33 */     super(paramFile, paramFileType);
/*    */   }
/*    */   
/*    */   public final FileHandle child(String paramString) {
/* 37 */     if (this.file.getPath().length() == 0) return new Lwjgl3FileHandle(new File(paramString), this.type); 
/* 38 */     return new Lwjgl3FileHandle(new File(this.file, paramString), this.type);
/*    */   }
/*    */   
/*    */   public final FileHandle sibling(String paramString) {
/* 42 */     if (this.file.getPath().length() == 0) throw new GdxRuntimeException("Cannot get the sibling of the root."); 
/* 43 */     return new Lwjgl3FileHandle(new File(this.file.getParent(), paramString), this.type);
/*    */   }
/*    */   
/*    */   public final FileHandle parent() {
/*    */     File file;
/* 48 */     if ((file = this.file.getParentFile()) == null)
/* 49 */       if (this.type == Files.FileType.Absolute) {
/* 50 */         file = new File("/");
/*    */       } else {
/* 52 */         file = new File("");
/*    */       }  
/* 54 */     return new Lwjgl3FileHandle(file, this.type);
/*    */   }
/*    */   
/*    */   public final File file() {
/* 58 */     if (this.type == Files.FileType.External) return new File(Lwjgl3Files.externalPath, this.file.getPath()); 
/* 59 */     if (this.type == Files.FileType.Local) return new File(Lwjgl3Files.localPath, this.file.getPath()); 
/* 60 */     return this.file;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Lwjgl3FileHandle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */