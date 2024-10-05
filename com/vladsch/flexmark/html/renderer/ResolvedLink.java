/*     */ package com.vladsch.flexmark.html.renderer;
/*     */ 
/*     */ import com.vladsch.flexmark.util.html.Attributes;
/*     */ import com.vladsch.flexmark.util.html.MutableAttributes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ResolvedLink
/*     */ {
/*     */   private final LinkType myLinkType;
/*     */   private final String myUrl;
/*     */   private final LinkStatus myStatus;
/*     */   private MutableAttributes myAttributes;
/*     */   
/*     */   public ResolvedLink(LinkType paramLinkType, CharSequence paramCharSequence) {
/*  17 */     this(paramLinkType, paramCharSequence, null, LinkStatus.UNKNOWN);
/*     */   }
/*     */   
/*     */   public ResolvedLink(LinkType paramLinkType, CharSequence paramCharSequence, Attributes paramAttributes) {
/*  21 */     this(paramLinkType, paramCharSequence, paramAttributes, LinkStatus.UNKNOWN);
/*     */   }
/*     */ 
/*     */   
/*     */   public Attributes getAttributes() {
/*  26 */     return (this.myAttributes == null) ? null : this.myAttributes.toImmutable();
/*     */   }
/*     */   
/*     */   public Attributes getNonNullAttributes() {
/*  30 */     if (this.myAttributes == null) {
/*  31 */       this.myAttributes = new MutableAttributes();
/*     */     }
/*  33 */     return this.myAttributes.toImmutable();
/*     */   }
/*     */   
/*     */   public MutableAttributes getMutableAttributes() {
/*  37 */     if (this.myAttributes == null) {
/*  38 */       this.myAttributes = new MutableAttributes();
/*     */     }
/*  40 */     return this.myAttributes;
/*     */   }
/*     */   
/*     */   public ResolvedLink(LinkType paramLinkType, CharSequence paramCharSequence, Attributes paramAttributes, LinkStatus paramLinkStatus) {
/*  44 */     this.myLinkType = paramLinkType;
/*  45 */     this.myUrl = String.valueOf(paramCharSequence);
/*  46 */     this.myStatus = paramLinkStatus;
/*  47 */     if (paramAttributes != null) {
/*  48 */       getMutableAttributes().addValues(paramAttributes);
/*     */     }
/*     */   }
/*     */   
/*     */   public ResolvedLink withLinkType(LinkType paramLinkType) {
/*  53 */     return (paramLinkType == this.myLinkType) ? this : new ResolvedLink(paramLinkType, this.myUrl, (Attributes)this.myAttributes, this.myStatus); } public ResolvedLink withStatus(LinkStatus paramLinkStatus) {
/*  54 */     return (paramLinkStatus == this.myStatus) ? this : new ResolvedLink(this.myLinkType, this.myUrl, (Attributes)this.myAttributes, paramLinkStatus);
/*     */   }
/*     */ 
/*     */   
/*     */   public LinkType getLinkType() {
/*  59 */     return this.myLinkType;
/*     */   }
/*     */ 
/*     */   
/*     */   public LinkStatus getStatus() {
/*  64 */     return this.myStatus;
/*     */   }
/*     */   
/*     */   public ResolvedLink withUrl(CharSequence paramCharSequence) {
/*  68 */     paramCharSequence = String.valueOf(paramCharSequence);
/*  69 */     return this.myUrl.equals(paramCharSequence) ? this : new ResolvedLink(this.myLinkType, paramCharSequence, (Attributes)this.myAttributes, this.myStatus);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUrl() {
/*  74 */     return this.myUrl;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPageRef() {
/*     */     int i;
/*  80 */     if ((i = this.myUrl.indexOf('#')) < 0) {
/*  81 */       return this.myUrl;
/*     */     }
/*  83 */     return this.myUrl.substring(0, i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAnchorRef() {
/*     */     int i;
/*  90 */     if ((i = this.myUrl.indexOf('#')) < 0) {
/*  91 */       return null;
/*     */     }
/*  93 */     return this.myUrl.substring(i + 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public ResolvedLink withTitle(CharSequence paramCharSequence) {
/*  98 */     String str = (this.myAttributes == null) ? null : this.myAttributes.getValue("title");
/*  99 */     if (paramCharSequence == str || (str != null && paramCharSequence != null && str.contentEquals(paramCharSequence))) return this;
/*     */     
/* 101 */     MutableAttributes mutableAttributes = new MutableAttributes((Attributes)this.myAttributes);
/* 102 */     if (paramCharSequence == null) {
/* 103 */       mutableAttributes.remove("title");
/* 104 */       if (mutableAttributes.isEmpty()) mutableAttributes = null; 
/*     */     } else {
/* 106 */       mutableAttributes.replaceValue("title", paramCharSequence);
/*     */     } 
/* 108 */     return new ResolvedLink(this.myLinkType, this.myUrl, (Attributes)mutableAttributes, this.myStatus);
/*     */   }
/*     */   
/*     */   public String getTitle() {
/* 112 */     return (this.myAttributes == null) ? null : this.myAttributes.getValue("title");
/*     */   }
/*     */   
/*     */   public ResolvedLink withTarget(CharSequence paramCharSequence) {
/* 116 */     String str = (this.myAttributes == null) ? null : this.myAttributes.getValue("target");
/* 117 */     if (paramCharSequence == str || (str != null && paramCharSequence != null && str.contentEquals(paramCharSequence))) return this;
/*     */     
/* 119 */     MutableAttributes mutableAttributes = new MutableAttributes((Attributes)this.myAttributes);
/* 120 */     if (paramCharSequence == null) {
/* 121 */       mutableAttributes.remove("target");
/* 122 */       if (mutableAttributes.isEmpty()) mutableAttributes = null; 
/*     */     } else {
/* 124 */       mutableAttributes.replaceValue("target", paramCharSequence);
/*     */     } 
/* 126 */     return new ResolvedLink(this.myLinkType, this.myUrl, (Attributes)mutableAttributes, this.myStatus);
/*     */   }
/*     */   
/*     */   public String getTarget() {
/* 130 */     return (this.myAttributes == null) ? null : this.myAttributes.getValue("target");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 135 */     if (this == paramObject) return true; 
/* 136 */     if (!(paramObject instanceof ResolvedLink)) return false;
/*     */     
/* 138 */     paramObject = paramObject;
/*     */     
/* 140 */     if (!this.myLinkType.equals(((ResolvedLink)paramObject).myLinkType)) return false; 
/* 141 */     if (!this.myUrl.equals(((ResolvedLink)paramObject).myUrl)) return false; 
/* 142 */     return this.myStatus.equals(((ResolvedLink)paramObject).myStatus);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 147 */     int i = this.myLinkType.hashCode();
/* 148 */     i = i * 31 + this.myUrl.hashCode();
/*     */     
/* 150 */     return i = i * 31 + this.myStatus.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\renderer\ResolvedLink.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */