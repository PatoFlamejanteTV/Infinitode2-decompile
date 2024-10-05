/*    */ package com.vladsch.flexmark.ext.enumerated.reference.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.Paragraph;
/*    */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceBlock;
/*    */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceExtension;
/*    */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceRepository;
/*    */ import com.vladsch.flexmark.parser.block.ParagraphPreProcessor;
/*    */ import com.vladsch.flexmark.parser.block.ParagraphPreProcessorFactory;
/*    */ import com.vladsch.flexmark.parser.block.ParserState;
/*    */ import com.vladsch.flexmark.parser.core.ReferencePreProcessorFactory;
/*    */ import com.vladsch.flexmark.util.ast.Block;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EnumeratedReferenceParagraphPreProcessor
/*    */   implements ParagraphPreProcessor
/*    */ {
/* 27 */   static String ENUM_REF_ID = "(?:[^0-9].*)?";
/* 28 */   static Pattern ENUM_REF_DEF_PARAGRAPH_PATTERN = Pattern.compile("\\s{0,3}(\\[[\\@]\\s*(" + ENUM_REF_ID + ")\\s*\\]:)\\s+(.*\n)");
/*    */   
/*    */   private final EnumeratedReferenceOptions options;
/*    */   private final EnumeratedReferenceRepository enumeratedReferences;
/*    */   
/*    */   EnumeratedReferenceParagraphPreProcessor(DataHolder paramDataHolder) {
/* 34 */     this.options = new EnumeratedReferenceOptions(paramDataHolder);
/* 35 */     this.enumeratedReferences = (EnumeratedReferenceRepository)EnumeratedReferenceExtension.ENUMERATED_REFERENCES.get(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public int preProcessBlock(Paragraph paramParagraph, ParserState paramParserState) {
/* 40 */     BasedSequence basedSequence = paramParagraph.getChars();
/* 41 */     Matcher matcher = ENUM_REF_DEF_PARAGRAPH_PATTERN.matcher((CharSequence)basedSequence);
/* 42 */     int i = 0;
/* 43 */     while (matcher.find() && 
/* 44 */       matcher.start() == i) {
/*    */       
/* 46 */       i = matcher.end();
/*    */       
/* 48 */       int j = matcher.start(1);
/* 49 */       int k = matcher.end(1);
/* 50 */       BasedSequence basedSequence3 = basedSequence.subSequence(j, j + 2);
/* 51 */       BasedSequence basedSequence1 = (BasedSequence)basedSequence.subSequence(j + 2, k - 2).trim();
/* 52 */       BasedSequence basedSequence2 = basedSequence.subSequence(k - 2, k);
/*    */       
/*    */       EnumeratedReferenceBlock enumeratedReferenceBlock;
/* 55 */       (enumeratedReferenceBlock = new EnumeratedReferenceBlock()).setOpeningMarker(basedSequence3);
/* 56 */       enumeratedReferenceBlock.setText(basedSequence1);
/* 57 */       enumeratedReferenceBlock.setClosingMarker(basedSequence2);
/*    */       
/* 59 */       basedSequence1 = basedSequence.subSequence(matcher.start(3), matcher.end(3));
/* 60 */       enumeratedReferenceBlock.setEnumeratedReference(basedSequence1);
/* 61 */       Paragraph paragraph = new Paragraph(basedSequence1);
/* 62 */       enumeratedReferenceBlock.appendChild((Node)paragraph);
/* 63 */       enumeratedReferenceBlock.setCharsFromContent();
/*    */       
/* 65 */       paramParagraph.insertBefore((Node)enumeratedReferenceBlock);
/* 66 */       paramParserState.blockAdded((Block)enumeratedReferenceBlock);
/*    */       
/* 68 */       this.enumeratedReferences.put(enumeratedReferenceBlock.getText().toString(), enumeratedReferenceBlock);
/*    */     } 
/* 70 */     return i;
/*    */   }
/*    */   
/*    */   public static ParagraphPreProcessorFactory Factory() {
/* 74 */     return new ParagraphPreProcessorFactory()
/*    */       {
/*    */         public final boolean affectsGlobalScope() {
/* 77 */           return true;
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         public final Set<Class<?>> getAfterDependents() {
/* 83 */           return null;
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         public final Set<Class<?>> getBeforeDependents() {
/*    */           HashSet<Class<ReferencePreProcessorFactory>> hashSet;
/* 90 */           (hashSet = new HashSet<>()).add(ReferencePreProcessorFactory.class);
/* 91 */           return hashSet;
/*    */         }
/*    */ 
/*    */         
/*    */         public final ParagraphPreProcessor apply(ParserState param1ParserState) {
/* 96 */           return new EnumeratedReferenceParagraphPreProcessor((DataHolder)param1ParserState.getProperties());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\enumerated\reference\internal\EnumeratedReferenceParagraphPreProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */