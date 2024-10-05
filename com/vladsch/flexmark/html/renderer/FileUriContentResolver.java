/*    */ package com.vladsch.flexmark.html.renderer;
/*    */ 
/*    */ import com.vladsch.flexmark.html.UriContentResolver;
/*    */ import com.vladsch.flexmark.html.UriContentResolverFactory;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.dependency.LastDependent;
/*    */ import com.vladsch.flexmark.util.misc.FileUtil;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.Collections;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FileUriContentResolver
/*    */   implements UriContentResolver
/*    */ {
/*    */   public FileUriContentResolver(LinkResolverBasicContext paramLinkResolverBasicContext) {}
/*    */   
/*    */   public ResolvedContent resolveContent(Node paramNode, LinkResolverBasicContext paramLinkResolverBasicContext, ResolvedContent paramResolvedContent) {
/*    */     ResolvedLink resolvedLink;
/* 25 */     if ((resolvedLink = paramResolvedContent.getResolvedLink()).getStatus() == LinkStatus.VALID) {
/*    */       String str;
/*    */       
/* 28 */       if ((str = resolvedLink.getUrl()).startsWith("file:/")) {
/*    */         
/* 30 */         str = str.startsWith("file://") ? str.substring(7) : ((File.separatorChar == '\\') ? str.substring(6) : str.substring(5));
/*    */         File file;
/* 32 */         if ((file = new File(str)).isFile() && file.exists()) {
/*    */           
/*    */           try {
/* 35 */             return paramResolvedContent.withContent(FileUtil.getFileContentBytesWithExceptions(file)).withStatus(LinkStatus.VALID);
/* 36 */           } catch (IOException iOException) {
/* 37 */             (file = null).printStackTrace();
/*    */           } 
/*    */         }
/*    */       } 
/*    */     } 
/* 42 */     return paramResolvedContent;
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     implements UriContentResolverFactory
/*    */   {
/*    */     public Set<Class<?>> getAfterDependents() {
/* 50 */       return Collections.singleton(LastDependent.class);
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Set<Class<?>> getBeforeDependents() {
/* 56 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean affectsGlobalScope() {
/* 61 */       return false;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public UriContentResolver apply(LinkResolverBasicContext param1LinkResolverBasicContext) {
/* 67 */       return new FileUriContentResolver(param1LinkResolverBasicContext);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\renderer\FileUriContentResolver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */