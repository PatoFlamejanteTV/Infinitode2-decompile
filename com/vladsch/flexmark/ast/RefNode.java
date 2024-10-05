/*     */ package com.vladsch.flexmark.ast;
/*     */ import com.vladsch.flexmark.ast.util.ReferenceRepository;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.NodeRepository;
/*     */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*     */ import com.vladsch.flexmark.util.ast.ReferenceNode;
/*     */ import com.vladsch.flexmark.util.misc.BitFieldSet;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.Escaping;
/*     */ import com.vladsch.flexmark.util.sequence.ReplacedTextMapper;
/*     */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*     */ 
/*     */ public abstract class RefNode extends Node implements LinkRefDerived, DoNotLinkDecorate, ReferencingNode<ReferenceRepository, Reference>, TextContainer {
/*  14 */   protected BasedSequence textOpeningMarker = BasedSequence.NULL;
/*  15 */   protected BasedSequence text = BasedSequence.NULL;
/*  16 */   protected BasedSequence textClosingMarker = BasedSequence.NULL;
/*  17 */   protected BasedSequence referenceOpeningMarker = BasedSequence.NULL;
/*  18 */   protected BasedSequence reference = BasedSequence.NULL;
/*  19 */   protected BasedSequence referenceClosingMarker = BasedSequence.NULL;
/*     */   
/*     */   protected boolean isDefined = false;
/*     */ 
/*     */   
/*     */   public BasedSequence[] getSegments() {
/*  25 */     if (isReferenceTextCombined()) {
/*  26 */       return new BasedSequence[] { this.referenceOpeningMarker, this.reference, this.referenceClosingMarker, this.textOpeningMarker, this.text, this.textClosingMarker };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  35 */     return new BasedSequence[] { this.textOpeningMarker, this.text, this.textClosingMarker, this.referenceOpeningMarker, this.reference, this.referenceClosingMarker };
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
/*     */   public void getAstExtra(StringBuilder paramStringBuilder) {
/*  48 */     if (isReferenceTextCombined()) {
/*  49 */       delimitedSegmentSpanChars(paramStringBuilder, this.referenceOpeningMarker, this.reference, this.referenceClosingMarker, "reference");
/*  50 */       delimitedSegmentSpanChars(paramStringBuilder, this.textOpeningMarker, this.text, this.textClosingMarker, "text"); return;
/*     */     } 
/*  52 */     delimitedSegmentSpanChars(paramStringBuilder, this.textOpeningMarker, this.text, this.textClosingMarker, "text");
/*  53 */     delimitedSegmentSpanChars(paramStringBuilder, this.referenceOpeningMarker, this.reference, this.referenceClosingMarker, "reference");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RefNode(BasedSequence paramBasedSequence) {
/*  61 */     super(paramBasedSequence);
/*     */   }
/*     */   
/*     */   public RefNode(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5, BasedSequence paramBasedSequence6) {
/*  65 */     super(paramBasedSequence1.baseSubSequence(paramBasedSequence1.getStartOffset(), paramBasedSequence6.getEndOffset()));
/*  66 */     this.textOpeningMarker = paramBasedSequence1;
/*  67 */     this.text = paramBasedSequence2;
/*  68 */     this.textClosingMarker = paramBasedSequence3;
/*  69 */     this.referenceOpeningMarker = paramBasedSequence4;
/*  70 */     this.reference = paramBasedSequence5;
/*  71 */     this.referenceClosingMarker = paramBasedSequence6;
/*     */   }
/*     */   
/*     */   public RefNode(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5, BasedSequence paramBasedSequence6, BasedSequence paramBasedSequence7) {
/*  75 */     super(paramBasedSequence1);
/*  76 */     this.textOpeningMarker = paramBasedSequence2;
/*  77 */     this.text = paramBasedSequence3;
/*  78 */     this.textClosingMarker = paramBasedSequence4;
/*  79 */     this.referenceOpeningMarker = paramBasedSequence5;
/*  80 */     this.reference = paramBasedSequence6;
/*  81 */     this.referenceClosingMarker = paramBasedSequence7;
/*     */   }
/*     */   
/*     */   public RefNode(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/*  85 */     super(paramBasedSequence1.baseSubSequence(paramBasedSequence1.getStartOffset(), paramBasedSequence3.getEndOffset()));
/*  86 */     this.textOpeningMarker = paramBasedSequence1;
/*  87 */     this.text = paramBasedSequence2;
/*  88 */     this.textClosingMarker = paramBasedSequence3;
/*     */   }
/*     */   
/*     */   public RefNode(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4) {
/*  92 */     super(paramBasedSequence1);
/*  93 */     this.textOpeningMarker = paramBasedSequence2;
/*  94 */     this.text = paramBasedSequence3;
/*  95 */     this.textClosingMarker = paramBasedSequence4;
/*     */   }
/*     */   
/*     */   public RefNode(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5) {
/*  99 */     super(paramBasedSequence1.baseSubSequence(paramBasedSequence1.getStartOffset(), paramBasedSequence5.getEndOffset()));
/* 100 */     this.textOpeningMarker = paramBasedSequence1;
/* 101 */     this.text = paramBasedSequence2;
/* 102 */     this.textClosingMarker = paramBasedSequence3;
/* 103 */     this.referenceOpeningMarker = paramBasedSequence4;
/* 104 */     this.referenceClosingMarker = paramBasedSequence5;
/*     */   }
/*     */   
/*     */   public void setReferenceChars(BasedSequence paramBasedSequence) {
/* 108 */     int i = paramBasedSequence.length();
/* 109 */     boolean bool = (paramBasedSequence.charAt(0) == '!') ? true : true;
/* 110 */     this.referenceOpeningMarker = paramBasedSequence.subSequence(0, bool);
/* 111 */     this.reference = (BasedSequence)paramBasedSequence.subSequence(bool, i - 1).trim();
/* 112 */     this.referenceClosingMarker = paramBasedSequence.subSequence(i - 1, i);
/*     */   }
/*     */   
/*     */   public void setTextChars(BasedSequence paramBasedSequence) {
/* 116 */     int i = paramBasedSequence.length();
/* 117 */     this.textOpeningMarker = paramBasedSequence.subSequence(0, 1);
/* 118 */     this.text = (BasedSequence)paramBasedSequence.subSequence(1, i - 1).trim();
/* 119 */     this.textClosingMarker = paramBasedSequence.subSequence(i - 1, i);
/*     */   }
/*     */   
/*     */   public boolean isReferenceTextCombined() {
/* 123 */     return (this.text == BasedSequence.NULL);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDefined() {
/* 128 */     return this.isDefined;
/*     */   }
/*     */   
/*     */   public void setDefined(boolean paramBoolean) {
/* 132 */     this.isDefined = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTentative() {
/* 137 */     return !this.isDefined;
/*     */   }
/*     */   
/*     */   public boolean isDummyReference() {
/* 141 */     return (this.textOpeningMarker != BasedSequence.NULL && this.text == BasedSequence.NULL && this.textClosingMarker != BasedSequence.NULL);
/*     */   }
/*     */   
/*     */   public BasedSequence getText() {
/* 145 */     return this.text;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence getReference() {
/* 151 */     return this.reference;
/*     */   }
/*     */ 
/*     */   
/*     */   public Reference getReferenceNode(Document paramDocument) {
/* 156 */     return getReferenceNode((ReferenceRepository)Parser.REFERENCES.get((DataHolder)paramDocument));
/*     */   }
/*     */ 
/*     */   
/*     */   public Reference getReferenceNode(ReferenceRepository paramReferenceRepository) {
/* 161 */     if (paramReferenceRepository == null) return null; 
/* 162 */     String str = paramReferenceRepository.normalizeKey((CharSequence)this.reference);
/* 163 */     return (Reference)paramReferenceRepository.get(str);
/*     */   }
/*     */   
/*     */   public BasedSequence getTextOpeningMarker() {
/* 167 */     return this.textOpeningMarker;
/*     */   }
/*     */   
/*     */   public void setTextOpeningMarker(BasedSequence paramBasedSequence) {
/* 171 */     this.textOpeningMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public void setText(BasedSequence paramBasedSequence) {
/* 175 */     this.text = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getTextClosingMarker() {
/* 179 */     return this.textClosingMarker;
/*     */   }
/*     */   
/*     */   public void setTextClosingMarker(BasedSequence paramBasedSequence) {
/* 183 */     this.textClosingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getReferenceOpeningMarker() {
/* 187 */     return this.referenceOpeningMarker;
/*     */   }
/*     */   
/*     */   public void setReferenceOpeningMarker(BasedSequence paramBasedSequence) {
/* 191 */     this.referenceOpeningMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public void setReference(BasedSequence paramBasedSequence) {
/* 195 */     this.reference = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getDummyReference() {
/* 199 */     if (isDummyReference()) {
/* 200 */       return getChars().baseSubSequence(this.textOpeningMarker.getStartOffset(), this.textClosingMarker.getEndOffset());
/*     */     }
/* 202 */     return BasedSequence.NULL;
/*     */   }
/*     */   
/*     */   public BasedSequence getReferenceClosingMarker() {
/* 206 */     return this.referenceClosingMarker;
/*     */   }
/*     */   
/*     */   public void setReferenceClosingMarker(BasedSequence paramBasedSequence) {
/* 210 */     this.referenceClosingMarker = paramBasedSequence;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> paramISequenceBuilder, int paramInt, NodeVisitor paramNodeVisitor) {
/*     */     int i;
/* 219 */     if ((i = paramInt & F_LINK_TEXT_TYPE) == 0) {
/*     */       
/* 221 */       if (BitFieldSet.any(paramInt, F_FOR_HEADING_ID) && this instanceof ImageRef) return false;
/*     */       
/* 223 */       if (BitFieldSet.any(paramInt, F_FOR_HEADING_ID) && BitFieldSet.any(paramInt, (F_NO_TRIM_REF_TEXT_START | F_NO_TRIM_REF_TEXT_END))) {
/* 224 */         BasedSequence[] arrayOfBasedSequence = getSegments();
/* 225 */         if (BitFieldSet.any(paramInt, F_NO_TRIM_REF_TEXT_START)) paramISequenceBuilder.append((CharSequence)getChars().baseSubSequence(arrayOfBasedSequence[0].getEndOffset(), arrayOfBasedSequence[1].getStartOffset())); 
/* 226 */         paramNodeVisitor.visitChildren(this);
/* 227 */         if (BitFieldSet.any(paramInt, F_NO_TRIM_REF_TEXT_END)) paramISequenceBuilder.append((CharSequence)getChars().baseSubSequence(arrayOfBasedSequence[1].getEndOffset(), arrayOfBasedSequence[2].getStartOffset())); 
/* 228 */         return false;
/*     */       } 
/* 230 */       return true;
/*     */     } 
/*     */     
/* 233 */     Reference reference = getReferenceNode(getDocument());
/* 234 */     if (i == 4) {
/* 235 */       paramISequenceBuilder.append((CharSequence)getChars());
/*     */     } else {
/* 237 */       if (reference == null) {
/* 238 */         return true;
/*     */       }
/*     */ 
/*     */       
/* 242 */       switch (i) {
/*     */         case 1:
/* 244 */           basedSequence = reference.getPageRef();
/*     */           break;
/*     */         
/*     */         case 2:
/* 248 */           basedSequence = reference.getAnchorRef();
/*     */           break;
/*     */         
/*     */         case 3:
/* 252 */           basedSequence = reference.getUrl();
/*     */           break;
/*     */         
/*     */         default:
/* 256 */           return true;
/*     */       } 
/*     */       
/* 259 */       ReplacedTextMapper replacedTextMapper = new ReplacedTextMapper(basedSequence);
/*     */       
/* 261 */       BasedSequence basedSequence = Escaping.percentDecodeUrl(basedSequence = Escaping.unescape(basedSequence, replacedTextMapper), replacedTextMapper);
/* 262 */       paramISequenceBuilder.append((CharSequence)basedSequence);
/*     */     } 
/*     */ 
/*     */     
/* 266 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String toStringAttributes() {
/* 273 */     return "text=" + this.text + ", reference=" + this.reference;
/*     */   }
/*     */   
/*     */   public RefNode() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\RefNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */