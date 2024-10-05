/*     */ package com.badlogic.gdx.assets.loaders.resolvers;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.assets.loaders.FileHandleResolver;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ResolutionFileResolver
/*     */   implements FileHandleResolver
/*     */ {
/*     */   protected final FileHandleResolver baseResolver;
/*     */   protected final Resolution[] descriptors;
/*     */   
/*     */   public static class Resolution
/*     */   {
/*     */     public final int portraitWidth;
/*     */     public final int portraitHeight;
/*     */     public final String folder;
/*     */     
/*     */     public Resolution(int param1Int1, int param1Int2, String param1String) {
/*  67 */       this.portraitWidth = param1Int1;
/*  68 */       this.portraitHeight = param1Int2;
/*  69 */       this.folder = param1String;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResolutionFileResolver(FileHandleResolver paramFileHandleResolver, Resolution... paramVarArgs) {
/*  80 */     if (paramVarArgs.length == 0) throw new IllegalArgumentException("At least one Resolution needs to be supplied."); 
/*  81 */     this.baseResolver = paramFileHandleResolver;
/*  82 */     this.descriptors = paramVarArgs;
/*     */   }
/*     */ 
/*     */   
/*     */   public FileHandle resolve(String paramString) {
/*  87 */     Resolution resolution = choose(this.descriptors);
/*  88 */     FileHandle fileHandle2 = new FileHandle(paramString);
/*     */     FileHandle fileHandle1;
/*  90 */     if (!(fileHandle1 = this.baseResolver.resolve(resolve(fileHandle2, resolution.folder))).exists()) fileHandle1 = this.baseResolver.resolve(paramString); 
/*  91 */     return fileHandle1;
/*     */   }
/*     */   
/*     */   protected String resolve(FileHandle paramFileHandle, String paramString) {
/*  95 */     String str = "";
/*     */     FileHandle fileHandle;
/*  97 */     if ((fileHandle = paramFileHandle.parent()) != null && !fileHandle.name().equals("")) {
/*  98 */       str = fileHandle + "/";
/*     */     }
/* 100 */     return str + paramString + "/" + paramFileHandle.name();
/*     */   }
/*     */   
/*     */   public static Resolution choose(Resolution... paramVarArgs) {
/* 104 */     int i = Gdx.graphics.getBackBufferWidth(), j = Gdx.graphics.getBackBufferHeight();
/*     */ 
/*     */     
/* 107 */     Resolution resolution = paramVarArgs[0];
/* 108 */     if (i < j) {
/* 109 */       byte b; int k; for (b = 0, k = paramVarArgs.length; b < k; b++) {
/* 110 */         Resolution resolution1 = paramVarArgs[b];
/* 111 */         if (i >= resolution1.portraitWidth && resolution1.portraitWidth >= resolution.portraitWidth && j >= resolution1.portraitHeight && resolution1.portraitHeight >= resolution.portraitHeight)
/* 112 */           resolution = paramVarArgs[b]; 
/*     */       } 
/*     */     } else {
/* 115 */       byte b; int k; for (b = 0, k = paramVarArgs.length; b < k; b++) {
/* 116 */         Resolution resolution1 = paramVarArgs[b];
/* 117 */         if (i >= resolution1.portraitHeight && resolution1.portraitHeight >= resolution.portraitHeight && j >= resolution1.portraitWidth && resolution1.portraitWidth >= resolution.portraitWidth)
/* 118 */           resolution = paramVarArgs[b]; 
/*     */       } 
/*     */     } 
/* 121 */     return resolution;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\loaders\resolvers\ResolutionFileResolver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */