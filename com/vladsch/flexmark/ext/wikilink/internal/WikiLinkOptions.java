/*    */ package com.vladsch.flexmark.ext.wikilink.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.wikilink.WikiLinkExtension;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ 
/*    */ public class WikiLinkOptions {
/*    */   public final boolean allowInlines;
/*    */   public final boolean allowAnchors;
/*    */   public final boolean disableRendering;
/*    */   public final boolean imageLinks;
/*    */   public final boolean linkFirstSyntax;
/*    */   public final boolean allowAnchorEscape;
/*    */   public final boolean allowPipeEscape;
/*    */   public final String imageFileExtension;
/*    */   public final String imagePrefix;
/*    */   public final String imagePrefixAbsolute;
/*    */   public final String linkFileExtension;
/*    */   public final String linkPrefix;
/*    */   public final String linkPrefixAbsolute;
/*    */   public final String linkReplaceChars;
/*    */   public final String linkEscapeChars;
/*    */   
/*    */   public WikiLinkOptions(DataHolder paramDataHolder) {
/* 24 */     this.allowInlines = ((Boolean)WikiLinkExtension.ALLOW_INLINES.get(paramDataHolder)).booleanValue();
/* 25 */     this.allowAnchors = ((Boolean)WikiLinkExtension.ALLOW_ANCHORS.get(paramDataHolder)).booleanValue();
/* 26 */     this.disableRendering = ((Boolean)WikiLinkExtension.DISABLE_RENDERING.get(paramDataHolder)).booleanValue();
/* 27 */     this.imageLinks = ((Boolean)WikiLinkExtension.IMAGE_LINKS.get(paramDataHolder)).booleanValue();
/* 28 */     this.linkFirstSyntax = ((Boolean)WikiLinkExtension.LINK_FIRST_SYNTAX.get(paramDataHolder)).booleanValue();
/* 29 */     this.allowAnchorEscape = ((Boolean)WikiLinkExtension.ALLOW_ANCHOR_ESCAPE.get(paramDataHolder)).booleanValue();
/* 30 */     this.allowPipeEscape = ((Boolean)WikiLinkExtension.ALLOW_PIPE_ESCAPE.get(paramDataHolder)).booleanValue();
/* 31 */     this.imageFileExtension = (String)WikiLinkExtension.IMAGE_FILE_EXTENSION.get(paramDataHolder);
/* 32 */     this.imagePrefix = (String)WikiLinkExtension.IMAGE_PREFIX.get(paramDataHolder);
/* 33 */     this.imagePrefixAbsolute = (String)WikiLinkExtension.IMAGE_PREFIX_ABSOLUTE.get(paramDataHolder);
/* 34 */     this.linkFileExtension = (String)WikiLinkExtension.LINK_FILE_EXTENSION.get(paramDataHolder);
/* 35 */     this.linkPrefix = (String)WikiLinkExtension.LINK_PREFIX.get(paramDataHolder);
/* 36 */     this.linkPrefixAbsolute = (String)WikiLinkExtension.LINK_PREFIX_ABSOLUTE.get(paramDataHolder);
/* 37 */     this.linkEscapeChars = (String)WikiLinkExtension.LINK_ESCAPE_CHARS.get(paramDataHolder);
/* 38 */     this.linkReplaceChars = (String)WikiLinkExtension.LINK_REPLACE_CHARS.get(paramDataHolder);
/*    */   }
/*    */   
/*    */   public Object getLinkPrefix(boolean paramBoolean) {
/* 42 */     return paramBoolean ? this.linkPrefixAbsolute : this.linkPrefix;
/*    */   }
/*    */   
/*    */   public Object getImagePrefix(boolean paramBoolean) {
/* 46 */     return paramBoolean ? this.imagePrefixAbsolute : this.imagePrefix;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\wikilink\internal\WikiLinkOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */