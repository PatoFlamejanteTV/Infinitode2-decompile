/*     */ package com.vladsch.flexmark.ext.wikilink;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.LinkRefDerived;
/*     */ import com.vladsch.flexmark.util.ast.DoNotDecorate;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*     */ import com.vladsch.flexmark.util.ast.TextContainer;
/*     */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.Escaping;
/*     */ import com.vladsch.flexmark.util.sequence.ReplacedTextMapper;
/*     */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*     */ 
/*     */ public class WikiNode
/*     */   extends Node
/*     */   implements LinkRefDerived, DoNotDecorate, TextContainer {
/*     */   public static final char SEPARATOR_CHAR = '|';
/*  18 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/*  19 */   protected BasedSequence link = BasedSequence.NULL;
/*  20 */   protected BasedSequence pageRef = BasedSequence.NULL;
/*  21 */   protected BasedSequence anchorMarker = BasedSequence.NULL;
/*  22 */   protected BasedSequence anchorRef = BasedSequence.NULL;
/*  23 */   protected BasedSequence textSeparatorMarker = BasedSequence.NULL;
/*  24 */   protected BasedSequence text = BasedSequence.NULL;
/*  25 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*     */   
/*     */   protected final boolean linkIsFirst;
/*     */ 
/*     */   
/*     */   public BasedSequence[] getSegments() {
/*  31 */     if (this.linkIsFirst) {
/*  32 */       return new BasedSequence[] { this.openingMarker, this.link, this.pageRef, this.anchorMarker, this.anchorRef, this.textSeparatorMarker, this.text, this.closingMarker };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  43 */     return new BasedSequence[] { this.openingMarker, this.text, this.textSeparatorMarker, this.link, this.pageRef, this.anchorMarker, this.anchorRef, this.closingMarker };
/*     */   }
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
/*     */   public void getAstExtra(StringBuilder paramStringBuilder) {
/*  58 */     if (this.linkIsFirst) {
/*  59 */       segmentSpanChars(paramStringBuilder, this.openingMarker, "linkOpen");
/*  60 */       segmentSpanChars(paramStringBuilder, this.text, "text");
/*  61 */       segmentSpanChars(paramStringBuilder, this.textSeparatorMarker, "textSep");
/*  62 */       segmentSpanChars(paramStringBuilder, this.link, "link");
/*  63 */       if (this.pageRef.isNotNull()) segmentSpanChars(paramStringBuilder, this.pageRef, "pageRef"); 
/*  64 */       if (this.anchorMarker.isNotNull()) segmentSpanChars(paramStringBuilder, this.anchorMarker, "anchorMarker"); 
/*  65 */       if (this.anchorRef.isNotNull()) segmentSpanChars(paramStringBuilder, this.anchorRef, "anchorRef"); 
/*  66 */       segmentSpanChars(paramStringBuilder, this.closingMarker, "linkClose"); return;
/*     */     } 
/*  68 */     segmentSpanChars(paramStringBuilder, this.openingMarker, "linkOpen");
/*  69 */     segmentSpanChars(paramStringBuilder, this.link, "link");
/*  70 */     if (this.pageRef.isNotNull()) segmentSpanChars(paramStringBuilder, this.pageRef, "pageRef"); 
/*  71 */     if (this.anchorMarker.isNotNull()) segmentSpanChars(paramStringBuilder, this.anchorMarker, "anchorMarker"); 
/*  72 */     if (this.anchorRef.isNotNull()) segmentSpanChars(paramStringBuilder, this.anchorRef, "anchorRef"); 
/*  73 */     segmentSpanChars(paramStringBuilder, this.textSeparatorMarker, "textSep");
/*  74 */     segmentSpanChars(paramStringBuilder, this.text, "text");
/*  75 */     segmentSpanChars(paramStringBuilder, this.closingMarker, "linkClose");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLinkIsFirst() {
/*  80 */     return this.linkIsFirst;
/*     */   }
/*     */   
/*     */   public WikiNode(boolean paramBoolean) {
/*  84 */     this.linkIsFirst = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTentative() {
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public WikiNode(BasedSequence paramBasedSequence, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
/*  96 */     super(paramBasedSequence);
/*  97 */     this.linkIsFirst = paramBoolean1;
/*  98 */     setLinkChars(paramBasedSequence, paramBoolean2, paramBoolean3, paramBoolean4);
/*     */   }
/*     */   
/*     */   public BasedSequence getOpeningMarker() {
/* 102 */     return this.openingMarker;
/*     */   }
/*     */   
/*     */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/* 106 */     this.openingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getPageRef() {
/* 110 */     return this.pageRef;
/*     */   }
/*     */   
/*     */   public void setPageRef(BasedSequence paramBasedSequence) {
/* 114 */     this.pageRef = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getTextSeparatorMarker() {
/* 118 */     return this.textSeparatorMarker;
/*     */   }
/*     */   
/*     */   public void setTextSeparatorMarker(BasedSequence paramBasedSequence) {
/* 122 */     this.textSeparatorMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getText() {
/* 126 */     return this.text;
/*     */   }
/*     */   
/*     */   public void setText(BasedSequence paramBasedSequence) {
/* 130 */     this.text = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getClosingMarker() {
/* 134 */     return this.closingMarker;
/*     */   }
/*     */   
/*     */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 138 */     this.closingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getAnchorMarker() {
/* 142 */     return this.anchorMarker;
/*     */   }
/*     */   
/*     */   public void setAnchorMarker(BasedSequence paramBasedSequence) {
/* 146 */     this.anchorMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getAnchorRef() {
/* 150 */     return this.anchorRef;
/*     */   }
/*     */   
/*     */   public void setAnchorRef(BasedSequence paramBasedSequence) {
/* 154 */     this.anchorRef = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getLink() {
/* 158 */     return this.link;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLink(BasedSequence paramBasedSequence, boolean paramBoolean1, boolean paramBoolean2) {
/* 163 */     this.link = paramBasedSequence;
/*     */     
/* 165 */     if (!paramBoolean1) {
/* 166 */       this.pageRef = paramBasedSequence; return;
/*     */     } 
/* 168 */     int i = -1;
/*     */     do {
/*     */     
/* 171 */     } while ((i = paramBasedSequence.indexOf('#', i + 1)) != -1 && paramBoolean2 && i > 0 && paramBasedSequence.charAt(i - 1) == '\\' && (paramBasedSequence.subSequence(0, i).countTrailing(CharPredicate.BACKSLASH) & 0x1) == 1);
/*     */     
/* 173 */     if (i < 0) {
/* 174 */       this.pageRef = paramBasedSequence; return;
/*     */     } 
/* 176 */     this.pageRef = paramBasedSequence.subSequence(0, i);
/* 177 */     this.anchorMarker = paramBasedSequence.subSequence(i, i + 1);
/* 178 */     this.anchorRef = (BasedSequence)paramBasedSequence.subSequence(i + 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLinkChars(BasedSequence paramBasedSequence, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*     */     BasedSequence basedSequence;
/* 184 */     int j, i = paramBasedSequence.length();
/* 185 */     byte b = (this instanceof WikiImage) ? 3 : 2;
/* 186 */     this.openingMarker = paramBasedSequence.subSequence(0, b);
/* 187 */     this.closingMarker = paramBasedSequence.subSequence(i - 2, i);
/*     */ 
/*     */     
/* 190 */     if (this.linkIsFirst) {
/* 191 */       j = paramBasedSequence.length() - 2;
/*     */       do {
/*     */       
/* 194 */       } while ((j = paramBasedSequence.lastIndexOf('|', j - 1)) != -1 && paramBoolean2 && j > 0 && paramBasedSequence.charAt(j - 1) == '\\' && (paramBasedSequence.subSequence(0, j).countTrailing(CharPredicate.BACKSLASH) & 0x1) == 1);
/*     */     } else {
/* 196 */       j = -1;
/*     */       do {
/*     */       
/* 199 */       } while ((j = paramBasedSequence.indexOf('|', j + 1)) != -1 && paramBoolean2 && j > 0 && paramBasedSequence.charAt(j - 1) == '\\' && (paramBasedSequence.subSequence(0, j).countTrailing(CharPredicate.BACKSLASH) & 0x1) == 1);
/*     */     } 
/*     */ 
/*     */     
/* 203 */     if (j < 0) {
/* 204 */       basedSequence = paramBasedSequence.subSequence(b, i - 2);
/*     */     } else {
/* 206 */       this.textSeparatorMarker = paramBasedSequence.subSequence(j, j + 1);
/* 207 */       if (this.linkIsFirst) {
/* 208 */         basedSequence = paramBasedSequence.subSequence(b, j);
/* 209 */         this.text = paramBasedSequence.subSequence(j + 1, i - 2);
/*     */       } else {
/* 211 */         this.text = paramBasedSequence.subSequence(b, j);
/* 212 */         basedSequence = paramBasedSequence.subSequence(j + 1, i - 2);
/*     */       } 
/*     */     } 
/*     */     
/* 216 */     setLink(basedSequence, paramBoolean1, paramBoolean3);
/*     */     
/* 218 */     if (this.text.isNull() && paramBoolean1 && !this.anchorMarker.isNull())
/*     */     {
/* 220 */       this.text = this.pageRef;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> paramISequenceBuilder, int paramInt, NodeVisitor paramNodeVisitor) {
/*     */     BasedSequence basedSequence;
/* 230 */     switch (paramInt = paramInt & F_LINK_TEXT_TYPE) {
/*     */       case 1:
/* 232 */         basedSequence = getPageRef();
/*     */         break;
/*     */       case 2:
/* 235 */         basedSequence = getAnchorRef();
/*     */         break;
/*     */       case 3:
/* 238 */         basedSequence = getLink();
/*     */         break;
/*     */       
/*     */       case 4:
/* 242 */         basedSequence = BasedSequence.NULL;
/*     */         break;
/*     */ 
/*     */       
/*     */       default:
/* 247 */         return true;
/*     */     } 
/*     */     
/* 250 */     if (paramInt == 4) {
/* 251 */       paramISequenceBuilder.append((CharSequence)getChars());
/*     */     } else {
/* 253 */       ReplacedTextMapper replacedTextMapper = new ReplacedTextMapper(basedSequence);
/* 254 */       BasedSequence basedSequence1 = Escaping.unescape(basedSequence, replacedTextMapper);
/* 255 */       paramISequenceBuilder.append((CharSequence)basedSequence1);
/*     */     } 
/*     */     
/* 258 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\wikilink\WikiNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */