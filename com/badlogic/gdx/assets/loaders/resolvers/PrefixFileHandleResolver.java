/*    */ package com.badlogic.gdx.assets.loaders.resolvers;
/*    */ 
/*    */ import com.badlogic.gdx.assets.loaders.FileHandleResolver;
/*    */ import com.badlogic.gdx.files.FileHandle;
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
/*    */ public class PrefixFileHandleResolver
/*    */   implements FileHandleResolver
/*    */ {
/*    */   private String prefix;
/*    */   private FileHandleResolver baseResolver;
/*    */   
/*    */   public PrefixFileHandleResolver(FileHandleResolver paramFileHandleResolver, String paramString) {
/* 30 */     this.baseResolver = paramFileHandleResolver;
/* 31 */     this.prefix = paramString;
/*    */   }
/*    */   
/*    */   public void setBaseResolver(FileHandleResolver paramFileHandleResolver) {
/* 35 */     this.baseResolver = paramFileHandleResolver;
/*    */   }
/*    */   
/*    */   public FileHandleResolver getBaseResolver() {
/* 39 */     return this.baseResolver;
/*    */   }
/*    */   
/*    */   public void setPrefix(String paramString) {
/* 43 */     this.prefix = paramString;
/*    */   }
/*    */   
/*    */   public String getPrefix() {
/* 47 */     return this.prefix;
/*    */   }
/*    */ 
/*    */   
/*    */   public FileHandle resolve(String paramString) {
/* 52 */     return this.baseResolver.resolve(this.prefix + paramString);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\loaders\resolvers\PrefixFileHandleResolver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */