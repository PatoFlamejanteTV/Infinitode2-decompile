/*    */ package com.badlogic.gdx.ai;
/*    */ 
/*    */ import com.badlogic.gdx.Files;
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.assets.loaders.FileHandleResolver;
/*    */ import com.badlogic.gdx.assets.loaders.resolvers.AbsoluteFileHandleResolver;
/*    */ import com.badlogic.gdx.assets.loaders.resolvers.ClasspathFileHandleResolver;
/*    */ import com.badlogic.gdx.assets.loaders.resolvers.ExternalFileHandleResolver;
/*    */ import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
/*    */ import com.badlogic.gdx.assets.loaders.resolvers.LocalFileHandleResolver;
/*    */ import com.badlogic.gdx.files.FileHandle;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GdxFileSystem
/*    */   implements FileSystem
/*    */ {
/*    */   public FileHandleResolver newResolver(Files.FileType paramFileType) {
/* 39 */     switch (paramFileType) {
/*    */       case Absolute:
/* 41 */         return (FileHandleResolver)new AbsoluteFileHandleResolver();
/*    */       case Classpath:
/* 43 */         return (FileHandleResolver)new ClasspathFileHandleResolver();
/*    */       case External:
/* 45 */         return (FileHandleResolver)new ExternalFileHandleResolver();
/*    */       case Internal:
/* 47 */         return (FileHandleResolver)new InternalFileHandleResolver();
/*    */       case Local:
/* 49 */         return (FileHandleResolver)new LocalFileHandleResolver();
/*    */     } 
/* 51 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public FileHandle newFileHandle(String paramString) {
/* 56 */     return Gdx.files.absolute(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public FileHandle newFileHandle(File paramFile) {
/* 61 */     return Gdx.files.absolute(paramFile.getAbsolutePath());
/*    */   }
/*    */ 
/*    */   
/*    */   public FileHandle newFileHandle(String paramString, Files.FileType paramFileType) {
/* 66 */     return Gdx.files.getFileHandle(paramString, paramFileType);
/*    */   }
/*    */ 
/*    */   
/*    */   public FileHandle newFileHandle(File paramFile, Files.FileType paramFileType) {
/* 71 */     return Gdx.files.getFileHandle(paramFile.getPath(), paramFileType);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\GdxFileSystem.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */