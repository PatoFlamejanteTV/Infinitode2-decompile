/*     */ package com.badlogic.gdx.ai;
/*     */ 
/*     */ import com.badlogic.gdx.Files;
/*     */ import com.badlogic.gdx.assets.loaders.FileHandleResolver;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.io.File;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StandaloneFileSystem
/*     */   implements FileSystem
/*     */ {
/*     */   public FileHandleResolver newResolver(final Files.FileType fileType) {
/*  34 */     return new FileHandleResolver()
/*     */       {
/*     */         public FileHandle resolve(String param1String)
/*     */         {
/*  38 */           return new StandaloneFileSystem.DesktopFileHandle(param1String, fileType);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public FileHandle newFileHandle(String paramString) {
/*  45 */     return new DesktopFileHandle(paramString, Files.FileType.Absolute);
/*     */   }
/*     */ 
/*     */   
/*     */   public FileHandle newFileHandle(File paramFile) {
/*  50 */     return new DesktopFileHandle(paramFile, Files.FileType.Absolute);
/*     */   }
/*     */ 
/*     */   
/*     */   public FileHandle newFileHandle(String paramString, Files.FileType paramFileType) {
/*  55 */     return new DesktopFileHandle(paramString, paramFileType);
/*     */   }
/*     */ 
/*     */   
/*     */   public FileHandle newFileHandle(File paramFile, Files.FileType paramFileType) {
/*  60 */     return new DesktopFileHandle(paramFile, paramFileType);
/*     */   }
/*     */   
/*     */   public static class DesktopFileHandle
/*     */     extends FileHandle {
/*  65 */     public static final String externalPath = System.getProperty("user.home") + File.separator;
/*  66 */     public static final String localPath = (new File("")).getAbsolutePath() + File.separator;
/*     */     
/*     */     public DesktopFileHandle(String param1String, Files.FileType param1FileType) {
/*  69 */       super(param1String, param1FileType);
/*     */     }
/*     */     
/*     */     public DesktopFileHandle(File param1File, Files.FileType param1FileType) {
/*  73 */       super(param1File, param1FileType);
/*     */     }
/*     */     
/*     */     public FileHandle child(String param1String) {
/*  77 */       if (this.file.getPath().length() == 0) return new DesktopFileHandle(new File(param1String), this.type); 
/*  78 */       return new DesktopFileHandle(new File(this.file, param1String), this.type);
/*     */     }
/*     */     
/*     */     public FileHandle sibling(String param1String) {
/*  82 */       if (this.file.getPath().length() == 0) throw new GdxRuntimeException("Cannot get the sibling of the root."); 
/*  83 */       return new DesktopFileHandle(new File(this.file.getParent(), param1String), this.type);
/*     */     }
/*     */     
/*     */     public FileHandle parent() {
/*     */       File file;
/*  88 */       if ((file = this.file.getParentFile()) == null)
/*  89 */         if (this.type == Files.FileType.Absolute) {
/*  90 */           file = new File("/");
/*     */         } else {
/*  92 */           file = new File("");
/*     */         }  
/*  94 */       return new DesktopFileHandle(file, this.type);
/*     */     }
/*     */     
/*     */     public File file() {
/*  98 */       if (this.type == Files.FileType.External) return new File(externalPath, this.file.getPath()); 
/*  99 */       if (this.type == Files.FileType.Local) return new File(localPath, this.file.getPath()); 
/* 100 */       return this.file;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\StandaloneFileSystem.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */