/*     */ package com.vladsch.flexmark.ext.wikilink.internal;
/*     */ 
/*     */ import com.vladsch.flexmark.ext.wikilink.WikiLinkExtension;
/*     */ import com.vladsch.flexmark.html.LinkResolver;
/*     */ import com.vladsch.flexmark.html.LinkResolverFactory;
/*     */ import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
/*     */ import com.vladsch.flexmark.html.renderer.LinkStatus;
/*     */ import com.vladsch.flexmark.html.renderer.LinkType;
/*     */ import com.vladsch.flexmark.html.renderer.ResolvedLink;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WikiLinkLinkResolver
/*     */   implements LinkResolver
/*     */ {
/*     */   private final WikiLinkOptions options;
/*     */   
/*     */   public WikiLinkLinkResolver(LinkResolverBasicContext paramLinkResolverBasicContext) {
/*  22 */     this.options = new WikiLinkOptions(paramLinkResolverBasicContext.getOptions());
/*     */   }
/*     */ 
/*     */   
/*     */   public ResolvedLink resolveLink(Node paramNode, LinkResolverBasicContext paramLinkResolverBasicContext, ResolvedLink paramResolvedLink) {
/*     */     String str;
/*  28 */     if (paramResolvedLink.getLinkType() == WikiLinkExtension.WIKI_LINK) {
/*  29 */       StringBuilder stringBuilder = new StringBuilder();
/*  30 */       boolean bool = paramNode instanceof com.vladsch.flexmark.ext.wikilink.WikiImage;
/*     */       
/*     */       int i;
/*  33 */       byte b = ((i = (str = paramResolvedLink.getUrl()).length()) > 0 && str.charAt(0) == '/') ? 1 : 0;
/*  34 */       stringBuilder.append(bool ? this.options.getImagePrefix(b) : this.options.getLinkPrefix(b));
/*     */       
/*  36 */       boolean bool1 = false;
/*  37 */       boolean bool2 = false;
/*     */       
/*  39 */       String str1 = this.options.linkEscapeChars;
/*  40 */       String str2 = this.options.linkReplaceChars;
/*  41 */       for (b = b ? 1 : 0; b < i; b++) {
/*     */         char c;
/*     */         
/*  44 */         if ((c = str.charAt(b)) == '#' && !bool1 && this.options.allowAnchors && (!bool2 || !this.options.allowAnchorEscape)) {
/*  45 */           stringBuilder.append(bool ? this.options.imageFileExtension : this.options.linkFileExtension);
/*  46 */           stringBuilder.append(c);
/*  47 */           bool1 = true;
/*  48 */           bool2 = false;
/*     */ 
/*     */         
/*     */         }
/*  52 */         else if (c == '\\') {
/*  53 */           if (bool2)
/*     */           {
/*  55 */             stringBuilder.append("%5C");
/*     */           }
/*  57 */           bool2 = !bool2 ? true : false;
/*     */         } else {
/*  59 */           bool2 = false;
/*  60 */           if (c == '#' && !bool1) {
/*     */             
/*  62 */             stringBuilder.append("%23");
/*     */           } else {
/*     */             int j;
/*     */             
/*  66 */             if ((j = str1.indexOf(c)) < 0) {
/*  67 */               stringBuilder.append(c);
/*     */             } else {
/*  69 */               stringBuilder.append(str2.charAt(j));
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*  75 */       if (bool2)
/*     */       {
/*  77 */         stringBuilder.append("%5C");
/*     */       }
/*     */       
/*  80 */       if (!bool1) {
/*  81 */         stringBuilder.append(bool ? this.options.imageFileExtension : this.options.linkFileExtension);
/*     */       }
/*     */       
/*  84 */       if (bool) {
/*  85 */         return new ResolvedLink(LinkType.IMAGE, stringBuilder.toString(), null, LinkStatus.UNCHECKED);
/*     */       }
/*  87 */       return new ResolvedLink(LinkType.LINK, stringBuilder.toString(), null, LinkStatus.UNCHECKED);
/*     */     } 
/*     */ 
/*     */     
/*  91 */     return (ResolvedLink)str;
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements LinkResolverFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/*  98 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/* 104 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/* 109 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public LinkResolver apply(LinkResolverBasicContext param1LinkResolverBasicContext) {
/* 115 */       return new WikiLinkLinkResolver(param1LinkResolverBasicContext);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\wikilink\internal\WikiLinkLinkResolver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */