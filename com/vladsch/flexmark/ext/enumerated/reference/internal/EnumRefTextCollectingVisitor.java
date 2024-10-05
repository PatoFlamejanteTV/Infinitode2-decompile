/*     */ package com.vladsch.flexmark.ext.enumerated.reference.internal;
/*     */ import com.vladsch.flexmark.ast.HardLineBreak;
/*     */ import com.vladsch.flexmark.ast.HtmlEntity;
/*     */ import com.vladsch.flexmark.ast.Text;
/*     */ import com.vladsch.flexmark.ast.TextBase;
/*     */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceLink;
/*     */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceRendering;
/*     */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceText;
/*     */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*     */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
/*     */ 
/*     */ public class EnumRefTextCollectingVisitor {
/*     */   private SequenceBuilder out;
/*     */   
/*     */   public EnumRefTextCollectingVisitor() {
/*  18 */     this(-1);
/*     */   }
/*     */   private final NodeVisitor visitor; private Runnable ordinalRunnable;
/*     */   public EnumRefTextCollectingVisitor(int paramInt) {
/*  22 */     this.ordinalRunnable = (paramInt < 0) ? null : (() -> this.out.add(String.valueOf(paramInt)));
/*     */     
/*  24 */     this.visitor = new NodeVisitor(new VisitHandler[] { new VisitHandler(Text.class, this::visit), new VisitHandler(TextBase.class, this::visit), new VisitHandler(HtmlEntity.class, this::visit), new VisitHandler(SoftLineBreak.class, this::visit), new VisitHandler(HardLineBreak.class, this::visit), new VisitHandler(EnumeratedReferenceText.class, this::visit), new VisitHandler(EnumeratedReferenceLink.class, this::visit) });
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
/*     */   public String getText() {
/*  36 */     return this.out.toString();
/*     */   }
/*     */   
/*     */   public void collect(BasedSequence paramBasedSequence, EnumeratedReferenceRendering[] paramArrayOfEnumeratedReferenceRendering, String paramString) {
/*  40 */     this.out = SequenceBuilder.emptyBuilder(paramBasedSequence);
/*  41 */     EnumeratedReferences.renderReferenceOrdinals(paramArrayOfEnumeratedReferenceRendering, new OrdinalRenderer(this));
/*     */   }
/*     */   
/*     */   private static class OrdinalRenderer implements EnumeratedOrdinalRenderer {
/*     */     final EnumRefTextCollectingVisitor renderer;
/*     */     
/*     */     public OrdinalRenderer(EnumRefTextCollectingVisitor param1EnumRefTextCollectingVisitor) {
/*  48 */       this.renderer = param1EnumRefTextCollectingVisitor;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void startRendering(EnumeratedReferenceRendering[] param1ArrayOfEnumeratedReferenceRendering) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void setEnumOrdinalRunnable(Runnable param1Runnable) {
/*  58 */       this.renderer.ordinalRunnable = param1Runnable;
/*     */     }
/*     */ 
/*     */     
/*     */     public Runnable getEnumOrdinalRunnable() {
/*  63 */       return this.renderer.ordinalRunnable;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(int param1Int, EnumeratedReferenceBlock param1EnumeratedReferenceBlock, String param1String, boolean param1Boolean) {
/*  68 */       Runnable runnable = this.renderer.ordinalRunnable;
/*     */       
/*  70 */       if (param1EnumeratedReferenceBlock != null) {
/*  71 */         this.renderer.ordinalRunnable = (() -> {
/*     */             if (param1Runnable != null)
/*     */               param1Runnable.run();  this.renderer.out.add(String.valueOf(param1Int));
/*     */             if (param1Boolean)
/*     */               this.renderer.out.add("."); 
/*     */           });
/*  77 */         this.renderer.visitor.visitChildren((Node)param1EnumeratedReferenceBlock); return;
/*     */       } 
/*  79 */       this.renderer.out.add(param1String + " ");
/*  80 */       if (runnable != null) runnable.run(); 
/*  81 */       this.renderer.out.add(String.valueOf(param1Int));
/*  82 */       if (param1Boolean) this.renderer.out.add(".");
/*     */     
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void endRendering() {}
/*     */   }
/*     */ 
/*     */   
/*     */   public String collectAndGetText(BasedSequence paramBasedSequence, EnumeratedReferenceRendering[] paramArrayOfEnumeratedReferenceRendering, String paramString) {
/*  93 */     collect(paramBasedSequence, paramArrayOfEnumeratedReferenceRendering, paramString);
/*  94 */     return this.out.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private void visit(EnumeratedReferenceText paramEnumeratedReferenceText) {
/*     */     String str;
/* 100 */     if ((str = paramEnumeratedReferenceText.getText().toString()).isEmpty())
/*     */     {
/* 102 */       if (this.ordinalRunnable != null) this.ordinalRunnable.run();
/*     */     
/*     */     }
/*     */   }
/*     */   
/*     */   private void visit(EnumeratedReferenceLink paramEnumeratedReferenceLink) {
/*     */     String str;
/* 109 */     if ((str = paramEnumeratedReferenceLink.getText().toString()).isEmpty())
/*     */     {
/* 111 */       if (this.ordinalRunnable != null) this.ordinalRunnable.run(); 
/*     */     }
/*     */   }
/*     */   
/*     */   private void visit(SoftLineBreak paramSoftLineBreak) {
/* 116 */     this.out.add((CharSequence)paramSoftLineBreak.getChars());
/*     */   }
/*     */   
/*     */   private void visit(HardLineBreak paramHardLineBreak) {
/* 120 */     BasedSequence basedSequence = paramHardLineBreak.getChars();
/* 121 */     this.out.add((CharSequence)basedSequence.subSequence(basedSequence.length() - 1, basedSequence.length()));
/*     */   }
/*     */   
/*     */   private void visit(HtmlEntity paramHtmlEntity) {
/* 125 */     this.out.add(paramHtmlEntity.getChars().unescape());
/*     */   }
/*     */   
/*     */   private void visit(Text paramText) {
/* 129 */     if (!paramText.isOrDescendantOfType(new Class[] { DoNotCollectText.class })) {
/* 130 */       this.out.add((CharSequence)paramText.getChars());
/*     */     }
/*     */   }
/*     */   
/*     */   private void visit(TextBase paramTextBase) {
/* 135 */     this.out.add((CharSequence)paramTextBase.getChars());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\enumerated\reference\internal\EnumRefTextCollectingVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */