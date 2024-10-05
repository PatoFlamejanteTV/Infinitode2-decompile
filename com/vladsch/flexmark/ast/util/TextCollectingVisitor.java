/*     */ package com.vladsch.flexmark.ast.util;
/*     */ import com.vladsch.flexmark.ast.HardLineBreak;
/*     */ import com.vladsch.flexmark.ast.HtmlEntity;
/*     */ import com.vladsch.flexmark.ast.Paragraph;
/*     */ import com.vladsch.flexmark.ast.SoftLineBreak;
/*     */ import com.vladsch.flexmark.ast.Text;
/*     */ import com.vladsch.flexmark.ast.TextBase;
/*     */ import com.vladsch.flexmark.util.ast.DoNotCollectText;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*     */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*     */ import com.vladsch.flexmark.util.ast.Visitor;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.function.BiConsumer;
/*     */ 
/*     */ @Deprecated
/*     */ public class TextCollectingVisitor {
/*     */   SequenceBuilder out;
/*     */   
/*     */   protected static Class<?>[] concatArrays(Class<?>[]... paramVarArgs) {
/*  24 */     int i = 0; Class<?>[][] arrayOfClass1; int j; byte b2;
/*  25 */     for (j = (arrayOfClass1 = paramVarArgs).length, b2 = 0; b2 < j; ) { Class<?>[] arrayOfClass3 = arrayOfClass1[b2];
/*  26 */       i += arrayOfClass3.length;
/*     */       b2++; }
/*     */     
/*  29 */     Class[] arrayOfClass = new Class[i];
/*     */     
/*  31 */     j = 0; byte b1; Class<?>[][] arrayOfClass2; int k;
/*  32 */     for (k = (arrayOfClass2 = paramVarArgs).length, b1 = 0; b1 < k; b1++) {
/*  33 */       Class<?>[] arrayOfClass3; System.arraycopy(arrayOfClass3 = arrayOfClass2[b1], 0, arrayOfClass, j, arrayOfClass3.length);
/*  34 */       j += arrayOfClass3.length;
/*     */     } 
/*     */     
/*  37 */     return arrayOfClass;
/*     */   }
/*     */   private final NodeVisitor myVisitor; final HashSet<Class<?>> myLineBreakNodes;
/*     */   public TextCollectingVisitor(Class<?>... paramVarArgs) {
/*  41 */     this.myLineBreakNodes = (paramVarArgs.length == 0) ? null : new HashSet<>(Arrays.asList(paramVarArgs));
/*     */     
/*  43 */     this.myVisitor = new NodeVisitor(new VisitHandler[] { new VisitHandler(Text.class, this::visit), new VisitHandler(TextBase.class, this::visit), new VisitHandler(HtmlEntity.class, this::visit), new VisitHandler(SoftLineBreak.class, this::visit), new VisitHandler(Paragraph.class, this::visit), new VisitHandler(HardLineBreak.class, this::visit) })
/*     */       {
/*     */         public void processNode(Node param1Node, boolean param1Boolean, BiConsumer<Node, Visitor<Node>> param1BiConsumer)
/*     */         {
/*     */           Visitor<Node> visitor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  55 */           if ((visitor = (Visitor)getAction(param1Node)) != null) {
/*  56 */             param1BiConsumer.accept(param1Node, visitor); return;
/*     */           } 
/*  58 */           processChildren(param1Node, param1BiConsumer);
/*  59 */           if (TextCollectingVisitor.this.myLineBreakNodes != null && TextCollectingVisitor.this.myLineBreakNodes.contains(param1Node.getClass()) && !param1Node.isOrDescendantOfType(new Class[] { DoNotCollectText.class })) {
/*  60 */             TextCollectingVisitor.this.out.add("\n");
/*     */           }
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public String getText() {
/*  68 */     return this.out.toString();
/*     */   }
/*     */   
/*     */   public void collect(Node paramNode) {
/*  72 */     this.out = SequenceBuilder.emptyBuilder(paramNode.getChars());
/*  73 */     this.myVisitor.visit(paramNode);
/*     */   }
/*     */   
/*     */   public String collectAndGetText(Node paramNode) {
/*  77 */     collect(paramNode);
/*  78 */     return this.out.toString();
/*     */   }
/*     */   
/*     */   public BasedSequence collectAndGetSequence(Node paramNode) {
/*  82 */     collect(paramNode);
/*  83 */     return this.out.toSequence();
/*     */   }
/*     */   
/*     */   private void visit(Paragraph paramParagraph) {
/*  87 */     if (!paramParagraph.isOrDescendantOfType(new Class[] { DoNotCollectText.class })) {
/*  88 */       if (!this.out.isEmpty()) {
/*  89 */         this.out.add("\n\n");
/*     */       }
/*  91 */       this.myVisitor.visitChildren((Node)paramParagraph);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void visit(SoftLineBreak paramSoftLineBreak) {
/*  96 */     this.out.add((CharSequence)paramSoftLineBreak.getChars());
/*     */   }
/*     */   
/*     */   private void visit(HardLineBreak paramHardLineBreak) {
/* 100 */     BasedSequence basedSequence = paramHardLineBreak.getChars();
/* 101 */     this.out.add((CharSequence)basedSequence.subSequence(basedSequence.length() - 1, basedSequence.length()));
/*     */   }
/*     */   
/*     */   private void visit(HtmlEntity paramHtmlEntity) {
/* 105 */     this.out.add(paramHtmlEntity.getChars().unescape());
/*     */   }
/*     */   
/*     */   private void visit(Text paramText) {
/* 109 */     if (!paramText.isOrDescendantOfType(new Class[] { DoNotCollectText.class })) {
/* 110 */       this.out.add((CharSequence)paramText.getChars());
/*     */     }
/*     */   }
/*     */   
/*     */   private void visit(TextBase paramTextBase) {
/* 115 */     this.out.add((CharSequence)paramTextBase.getChars());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\as\\util\TextCollectingVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */