/*     */ package com.vladsch.flexmark.html;
/*     */ 
/*     */ import com.vladsch.flexmark.html.renderer.AttributablePart;
/*     */ import com.vladsch.flexmark.html.renderer.LinkStatus;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*     */ import com.vladsch.flexmark.html.renderer.ResolvedLink;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.html.Attributes;
/*     */ import com.vladsch.flexmark.util.html.HtmlAppendable;
/*     */ import com.vladsch.flexmark.util.html.HtmlAppendableBase;
/*     */ import com.vladsch.flexmark.util.html.MutableAttributes;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.LineAppendable;
/*     */ import com.vladsch.flexmark.util.sequence.TagRange;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class HtmlWriter extends HtmlAppendableBase<HtmlWriter> {
/*     */   private NodeRendererContext context;
/*     */   private AttributablePart useAttributes;
/*     */   
/*     */   public HtmlWriter(int paramInt1, int paramInt2) {
/*  22 */     super(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public HtmlWriter(HtmlWriter paramHtmlWriter, boolean paramBoolean) {
/*  26 */     super((LineAppendable)paramHtmlWriter, paramBoolean);
/*  27 */     this.context = paramHtmlWriter.context;
/*     */   }
/*     */   
/*     */   public HtmlWriter(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
/*  31 */     this((Appendable)null, paramInt1, paramInt2, paramBoolean1, paramBoolean2);
/*     */   }
/*     */   
/*     */   public HtmlWriter(Appendable paramAppendable, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
/*  35 */     super(paramAppendable, paramInt1, paramInt2);
/*  36 */     setSuppressOpenTagLine(paramBoolean1);
/*  37 */     setSuppressCloseTagLine(paramBoolean2);
/*     */   }
/*     */   
/*     */   void setContext(NodeRendererContext paramNodeRendererContext) {
/*  41 */     this.context = paramNodeRendererContext;
/*     */   }
/*     */   
/*     */   public NodeRendererContext getContext() {
/*  45 */     assert this.context != null;
/*  46 */     return this.context;
/*     */   }
/*     */   
/*     */   public HtmlWriter srcPos() {
/*  50 */     return (this.context == null) ? this : srcPos(this.context.getCurrentNode().getChars());
/*     */   }
/*     */   
/*     */   public HtmlWriter srcPosWithEOL() {
/*  54 */     return (this.context == null) ? this : srcPosWithEOL(this.context.getCurrentNode().getChars());
/*     */   }
/*     */   
/*     */   public HtmlWriter srcPosWithTrailingEOL() {
/*  58 */     return (this.context == null) ? this : srcPosWithTrailingEOL(this.context.getCurrentNode().getChars());
/*     */   }
/*     */   
/*     */   public HtmlWriter srcPos(BasedSequence paramBasedSequence) {
/*  62 */     if (paramBasedSequence.isNotNull()) {
/*  63 */       paramBasedSequence = (BasedSequence)paramBasedSequence.trimEOL();
/*  64 */       return srcPos(paramBasedSequence.getStartOffset(), paramBasedSequence.getEndOffset());
/*     */     } 
/*  66 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HtmlWriter srcPosWithEOL(BasedSequence paramBasedSequence) {
/*  71 */     if (paramBasedSequence.isNotNull()) {
/*  72 */       return srcPos(paramBasedSequence.getStartOffset(), paramBasedSequence.getEndOffset());
/*     */     }
/*  74 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HtmlWriter srcPosWithTrailingEOL(BasedSequence paramBasedSequence) {
/*  79 */     if (paramBasedSequence.isNotNull()) {
/*  80 */       int i = paramBasedSequence.getEndOffset();
/*  81 */       BasedSequence basedSequence = paramBasedSequence.getBaseSequence();
/*     */       char c;
/*  83 */       while (i < basedSequence.length() && ((
/*     */         
/*  85 */         c = basedSequence.charAt(i)) == ' ' || c == '\t')) {
/*  86 */         i++;
/*     */       }
/*     */       
/*  89 */       if (i < basedSequence.length() && basedSequence.charAt(i) == '\r') {
/*  90 */         i++;
/*     */       }
/*     */       
/*  93 */       if (i < basedSequence.length() && basedSequence.charAt(i) == '\n') {
/*  94 */         i++;
/*     */       }
/*  96 */       return srcPos(paramBasedSequence.getStartOffset(), i);
/*     */     } 
/*  98 */     return this;
/*     */   }
/*     */   
/*     */   public HtmlWriter srcPos(int paramInt1, int paramInt2) {
/* 102 */     if (paramInt1 <= paramInt2 && this.context != null && !(this.context.getHtmlOptions()).sourcePositionAttribute.isEmpty()) {
/* 103 */       attr((this.context.getHtmlOptions()).sourcePositionAttribute, paramInt1 + "-" + paramInt2);
/*     */     }
/* 105 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HtmlWriter withAttr() {
/* 110 */     return withAttr(AttributablePart.NODE);
/*     */   }
/*     */   
/*     */   public HtmlWriter withAttr(AttributablePart paramAttributablePart) {
/* 114 */     super.withAttr();
/* 115 */     this.useAttributes = paramAttributablePart;
/* 116 */     return this;
/*     */   }
/*     */   
/*     */   public HtmlWriter withAttr(LinkStatus paramLinkStatus) {
/* 120 */     attr("Link Status", paramLinkStatus.getName());
/* 121 */     return withAttr(AttributablePart.LINK);
/*     */   }
/*     */   
/*     */   public HtmlWriter withAttr(ResolvedLink paramResolvedLink) {
/* 125 */     return withAttr(paramResolvedLink.getStatus());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HtmlWriter tag(CharSequence paramCharSequence, boolean paramBoolean) {
/* 131 */     if (this.useAttributes != null) {
/*     */       String str;
/*     */       
/*     */       Attributes attributes;
/* 135 */       if (this.context != null) {
/* 136 */         MutableAttributes mutableAttributes = this.context.extendRenderingNodeAttributes(this.useAttributes, getAttributes());
/* 137 */         String str1 = (this.context.getHtmlOptions()).sourcePositionAttribute;
/* 138 */         str = mutableAttributes.getValue(str1);
/*     */       } else {
/* 140 */         str = "";
/* 141 */         attributes = new Attributes();
/*     */       } 
/*     */       
/* 144 */       if (!str.isEmpty()) {
/*     */         
/* 146 */         int i = str.indexOf('-');
/* 147 */         int j = -1;
/* 148 */         int k = -1;
/*     */         
/* 150 */         if (i != -1) {
/*     */           try {
/* 152 */             j = Integer.parseInt(str.substring(0, i));
/* 153 */           } catch (Throwable throwable) {}
/*     */ 
/*     */           
/*     */           try {
/* 157 */             k = Integer.parseInt(str.substring(i + 1));
/* 158 */           } catch (Throwable throwable) {}
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 163 */         if (j >= 0 && j < k) {
/*     */           ArrayList<TagRange> arrayList;
/* 165 */           (arrayList = (ArrayList<TagRange>)HtmlRenderer.TAG_RANGES.get((DataHolder)this.context.getDocument())).add(new TagRange(paramCharSequence, j, k));
/*     */         } 
/*     */       } 
/*     */       
/* 169 */       setAttributes(attributes);
/* 170 */       this.useAttributes = null;
/*     */     } 
/*     */     
/* 173 */     super.tag(paramCharSequence, paramBoolean);
/* 174 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\HtmlWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */