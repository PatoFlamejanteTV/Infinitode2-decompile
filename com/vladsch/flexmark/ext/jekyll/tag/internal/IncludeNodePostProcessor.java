/*     */ package com.vladsch.flexmark.ext.jekyll.tag.internal;
/*     */ import com.vladsch.flexmark.ext.jekyll.tag.JekyllTag;
/*     */ import com.vladsch.flexmark.ext.jekyll.tag.JekyllTagExtension;
/*     */ import com.vladsch.flexmark.html.LinkResolver;
/*     */ import com.vladsch.flexmark.html.LinkResolverFactory;
/*     */ import com.vladsch.flexmark.html.UriContentResolver;
/*     */ import com.vladsch.flexmark.html.UriContentResolverFactory;
/*     */ import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
/*     */ import com.vladsch.flexmark.html.renderer.LinkStatus;
/*     */ import com.vladsch.flexmark.html.renderer.ResolvedContent;
/*     */ import com.vladsch.flexmark.html.renderer.ResolvedLink;
/*     */ import com.vladsch.flexmark.parser.Parser;
/*     */ import com.vladsch.flexmark.parser.PostProcessor;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.NodeTracker;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.dependency.DependencyResolver;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class IncludeNodePostProcessor extends NodePostProcessor {
/*  26 */   final HashMap<JekyllTag, String> includedDocuments = new HashMap<>();
/*  27 */   final HashMap<String, ResolvedLink> resolvedLinks = new HashMap<>();
/*     */   final Parser parser;
/*     */   final List<LinkResolver> linkResolvers;
/*     */   final List<UriContentResolver> contentResolvers;
/*     */   final boolean isIncluding = false;
/*     */   final Document document;
/*     */   final LinkResolverBasicContext context;
/*     */   private final boolean embedIncludedContent;
/*     */   private final Map<String, String> includedHtml;
/*     */   
/*     */   public IncludeNodePostProcessor(final Document document) {
/*  38 */     this.document = document;
/*  39 */     this.parser = Parser.builder((DataHolder)document).build();
/*  40 */     this.context = new LinkResolverBasicContext()
/*     */       {
/*     */         public DataHolder getOptions() {
/*  43 */           return (DataHolder)document;
/*     */         }
/*     */ 
/*     */         
/*     */         public Document getDocument() {
/*  48 */           return document;
/*     */         }
/*     */       };
/*  51 */     List<?> list = DependencyResolver.resolveFlatDependencies((List)JekyllTagExtension.LINK_RESOLVER_FACTORIES.get((DataHolder)document), null, null);
/*  52 */     this.linkResolvers = new ArrayList<>(list.size());
/*  53 */     for (LinkResolverFactory linkResolverFactory : list) {
/*  54 */       this.linkResolvers.add(linkResolverFactory.apply(this.context));
/*     */     }
/*     */ 
/*     */     
/*  58 */     if ((list = (List)JekyllTagExtension.CONTENT_RESOLVER_FACTORIES.get((DataHolder)document)).isEmpty()) {
/*  59 */       list = Collections.singletonList(new FileUriContentResolver.Factory());
/*     */     }
/*  61 */     List list1 = DependencyResolver.resolveFlatDependencies(list, null, null);
/*  62 */     this.contentResolvers = new ArrayList<>(list1.size());
/*  63 */     for (UriContentResolverFactory uriContentResolverFactory : list1) {
/*  64 */       this.contentResolvers.add(uriContentResolverFactory.apply(this.context));
/*     */     }
/*     */     
/*  67 */     this.embedIncludedContent = ((Boolean)JekyllTagExtension.EMBED_INCLUDED_CONTENT.get((DataHolder)document)).booleanValue();
/*  68 */     this.includedHtml = (Map<String, String>)JekyllTagExtension.INCLUDED_HTML.get((DataHolder)document);
/*     */   }
/*     */ 
/*     */   
/*     */   public void process(NodeTracker paramNodeTracker, Node paramNode) {
/*  73 */     if (paramNode instanceof JekyllTag && !this.includedDocuments.containsKey(paramNode)) {
/*  74 */       JekyllTag jekyllTag = (JekyllTag)paramNode;
/*     */       
/*  76 */       if (this.embedIncludedContent && jekyllTag.getTag().equals("include")) {
/*     */         BasedSequence basedSequence;
/*     */ 
/*     */         
/*  80 */         String str1 = (basedSequence = jekyllTag.getParameters()).unescape();
/*  81 */         String str2 = null;
/*     */         
/*  83 */         if (this.includedHtml != null && this.includedHtml.containsKey(str1)) {
/*  84 */           str2 = this.includedHtml.get(str1);
/*     */         } else {
/*     */           ResolvedLink resolvedLink;
/*     */           
/*  88 */           if ((resolvedLink = this.resolvedLinks.get(str1)) == null) {
/*  89 */             resolvedLink = new ResolvedLink(LinkType.LINK, str1); LinkResolver linkResolver;
/*  90 */             for (Iterator<LinkResolver> iterator = this.linkResolvers.iterator(); iterator.hasNext() && (
/*     */               
/*  92 */               resolvedLink = (linkResolver = iterator.next()).resolveLink(paramNode, this.context, resolvedLink)).getStatus() == LinkStatus.UNKNOWN;);
/*     */ 
/*     */             
/*  95 */             this.resolvedLinks.put(str1, resolvedLink);
/*     */           } 
/*     */           
/*  98 */           if (resolvedLink.getStatus() == LinkStatus.VALID) {
/*  99 */             ResolvedContent resolvedContent = new ResolvedContent(resolvedLink, LinkStatus.UNKNOWN, null); UriContentResolver uriContentResolver; Iterator<UriContentResolver> iterator;
/* 100 */             for (iterator = this.contentResolvers.iterator(); iterator.hasNext() && (
/*     */               
/* 102 */               resolvedContent = (uriContentResolver = iterator.next()).resolveContent(paramNode, this.context, resolvedContent)).getStatus() == LinkStatus.UNKNOWN;);
/*     */ 
/*     */             
/* 105 */             if (resolvedContent.getStatus() == LinkStatus.VALID) {
/*     */               try {
/* 107 */                 str2 = new String(resolvedContent.getContent(), "UTF-8");
/* 108 */               } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 109 */                 (iterator = null).printStackTrace();
/*     */               } 
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 115 */         if (str2 != null && !str2.isEmpty()) {
/* 116 */           this.includedDocuments.put(jekyllTag, str2);
/*     */           
/* 118 */           Document document = this.parser.parse(str2);
/* 119 */           this.parser.transferReferences(this.document, document, null);
/*     */           
/* 121 */           if (document.contains((DataKeyBase)Parser.REFERENCES))
/*     */           {
/* 123 */             this.document.set(HtmlRenderer.RECHECK_UNDEFINED_REFERENCES, Boolean.TRUE);
/*     */           }
/*     */ 
/*     */           
/* 127 */           Node node = document.getFirstChild();
/*     */ 
/*     */           
/* 130 */           if (!(jekyllTag.getParent() instanceof com.vladsch.flexmark.ext.jekyll.tag.JekyllTagBlock) && 
/* 131 */             node instanceof com.vladsch.flexmark.ast.Paragraph && node.getNext() == null) {
/* 132 */             node = node.getFirstChild();
/*     */           }
/*     */ 
/*     */           
/* 136 */           while (node != null) {
/* 137 */             Node node1 = node.getNext();
/* 138 */             paramNode.appendChild(node);
/* 139 */             paramNodeTracker.nodeAddedWithDescendants(node);
/*     */             
/* 141 */             node = node1;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class Factory extends NodePostProcessorFactory {
/*     */     public Factory() {
/* 150 */       super(false);
/* 151 */       addNodes(new Class[] { JekyllTag.class });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/* 157 */       return Collections.singleton(FirstDependent.class);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public NodePostProcessor apply(Document param1Document) {
/* 163 */       return new IncludeNodePostProcessor(param1Document);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\jekyll\tag\internal\IncludeNodePostProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */