/*     */ package com.vladsch.flexmark.formatter.internal;
/*     */ 
/*     */ import com.vladsch.flexmark.formatter.Formatter;
/*     */ import com.vladsch.flexmark.html.LinkResolver;
/*     */ import com.vladsch.flexmark.html.LinkResolverFactory;
/*     */ import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
/*     */ import com.vladsch.flexmark.html.renderer.LinkStatus;
/*     */ import com.vladsch.flexmark.html.renderer.ResolvedLink;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MergeLinkResolver
/*     */   implements LinkResolver
/*     */ {
/*     */   private final String docRelativeURL;
/*     */   private final String docRootURL;
/*     */   private final String[] relativeParts;
/*     */   
/*     */   public MergeLinkResolver(LinkResolverBasicContext paramLinkResolverBasicContext) {
/*  26 */     String str2 = (String)Formatter.DOC_RELATIVE_URL.get(paramLinkResolverBasicContext.getOptions());
/*  27 */     String str1 = (String)Formatter.DOC_ROOT_URL.get(paramLinkResolverBasicContext.getOptions());
/*  28 */     this.docRelativeURL = str2;
/*  29 */     this.docRootURL = str1;
/*     */     
/*  31 */     str2 = Utils.removePrefix(str2, '/');
/*     */     
/*  33 */     this.relativeParts = str2.split("/");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ResolvedLink resolveLink(Node paramNode, LinkResolverBasicContext paramLinkResolverBasicContext, ResolvedLink paramResolvedLink) {
/*  39 */     if (paramNode instanceof com.vladsch.flexmark.ast.Image || paramNode instanceof com.vladsch.flexmark.ast.Link || paramNode instanceof com.vladsch.flexmark.ast.Reference) {
/*  40 */       String str = paramResolvedLink.getUrl();
/*     */       
/*  42 */       if (this.docRelativeURL.isEmpty() && this.docRootURL.isEmpty())
/*     */       {
/*  44 */         return paramResolvedLink.withStatus(LinkStatus.VALID)
/*  45 */           .withUrl(str);
/*     */       }
/*     */       
/*  48 */       if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("ftp://") || str.startsWith("sftp://"))
/*     */       {
/*  50 */         return paramResolvedLink.withStatus(LinkStatus.VALID)
/*  51 */           .withUrl(str); } 
/*  52 */       if (str.startsWith("file:/"))
/*     */       {
/*  54 */         return paramResolvedLink.withStatus(LinkStatus.VALID)
/*  55 */           .withUrl(str); } 
/*  56 */       if (str.startsWith("/")) {
/*  57 */         if (this.docRootURL != null && !this.docRootURL.isEmpty()) {
/*     */           
/*  59 */           str = (!this.docRootURL.startsWith("/") ? "/" : "") + this.docRootURL + str;
/*  60 */           return paramResolvedLink.withStatus(LinkStatus.VALID)
/*  61 */             .withUrl(str);
/*     */         } 
/*  63 */       } else if (!str.matches("^(?:[a-z]+:|#|\\?)")) {
/*     */         
/*  65 */         String str1 = str;
/*  66 */         String str2 = "";
/*     */         int j;
/*  68 */         if ((j = str.indexOf('#')) == 0) {
/*  69 */           return paramResolvedLink.withStatus(LinkStatus.VALID);
/*     */         }
/*  71 */         if (j > 0) {
/*     */           
/*  73 */           str2 = str.substring(j);
/*  74 */           str1 = str.substring(0, j);
/*  75 */         } else if (str.contains("?")) {
/*     */           
/*  77 */           j = str.indexOf("?");
/*  78 */           str2 = str.substring(j);
/*  79 */           str1 = str.substring(0, j);
/*     */         } 
/*     */         
/*  82 */         String[] arrayOfString = str1.split("/");
/*  83 */         int i = this.relativeParts.length;
/*  84 */         j = arrayOfString.length;
/*  85 */         StringBuilder stringBuilder1 = new StringBuilder();
/*  86 */         String str3 = "";
/*     */         
/*  88 */         for (byte b1 = 0; b1 < j; b1++) {
/*     */           String str5;
/*  90 */           if (!(str5 = arrayOfString[b1]).equals("."))
/*     */           {
/*  92 */             if (str5.equals("..")) {
/*     */               
/*  94 */               if (i == 0) return paramResolvedLink; 
/*  95 */               i--;
/*     */             } else {
/*  97 */               stringBuilder1.append(str3);
/*  98 */               stringBuilder1.append(str5);
/*  99 */               str3 = "/";
/*     */             } 
/*     */           }
/*     */         } 
/*     */         
/* 104 */         str3 = this.docRelativeURL.startsWith("/") ? "/" : "";
/* 105 */         StringBuilder stringBuilder2 = new StringBuilder();
/* 106 */         j = i;
/* 107 */         for (byte b2 = 0; b2 < j; b2++) {
/* 108 */           stringBuilder2.append(str3);
/* 109 */           stringBuilder2.append(this.relativeParts[b2]);
/* 110 */           str3 = "/";
/*     */         } 
/*     */         
/* 113 */         stringBuilder2.append('/').append(stringBuilder1).append(str2);
/* 114 */         String str4 = stringBuilder2.toString();
/* 115 */         return paramResolvedLink.withStatus(LinkStatus.VALID)
/* 116 */           .withUrl(str4);
/*     */       } 
/*     */     } 
/*     */     
/* 120 */     return paramResolvedLink;
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements LinkResolverFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/* 127 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/* 133 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/* 138 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public LinkResolver apply(LinkResolverBasicContext param1LinkResolverBasicContext) {
/* 144 */       return new MergeLinkResolver(param1LinkResolverBasicContext);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\internal\MergeLinkResolver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */