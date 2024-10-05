/*     */ package com.vladsch.flexmark.ext.abbreviation.internal;
/*     */ import com.vladsch.flexmark.ast.Text;
/*     */ import com.vladsch.flexmark.ast.TextBase;
/*     */ import com.vladsch.flexmark.ext.abbreviation.Abbreviation;
/*     */ import com.vladsch.flexmark.ext.abbreviation.AbbreviationBlock;
/*     */ import com.vladsch.flexmark.ext.abbreviation.AbbreviationExtension;
/*     */ import com.vladsch.flexmark.ext.autolink.internal.AutolinkNodePostProcessor;
/*     */ import com.vladsch.flexmark.parser.PostProcessor;
/*     */ import com.vladsch.flexmark.parser.block.NodePostProcessor;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.NodeTracker;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.ReplacedTextMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class AbbreviationNodePostProcessor extends NodePostProcessor {
/*  23 */   private Pattern abbreviations = null;
/*  24 */   private HashMap<String, BasedSequence> abbreviationMap = null;
/*     */   
/*     */   private AbbreviationNodePostProcessor(Document paramDocument) {
/*  27 */     computeAbbreviations(paramDocument);
/*     */   }
/*     */ 
/*     */   
/*     */   private void computeAbbreviations(Document paramDocument) {
/*     */     AbbreviationRepository abbreviationRepository;
/*  33 */     if (!(abbreviationRepository = (AbbreviationRepository)AbbreviationExtension.ABBREVIATIONS.get((DataHolder)paramDocument)).isEmpty()) {
/*  34 */       this.abbreviationMap = new HashMap<>();
/*  35 */       StringBuilder stringBuilder = new StringBuilder();
/*     */       
/*     */       ArrayList<?> arrayList;
/*     */       
/*  39 */       (arrayList = new ArrayList(abbreviationRepository.keySet())).sort(Comparator.reverseOrder());
/*     */       
/*  41 */       for (Iterator<?> iterator = arrayList.iterator(); iterator.hasNext();) {
/*     */         
/*  43 */         if (!(str = (String)iterator.next()).isEmpty() && (
/*     */           
/*  45 */           abbreviationBlock = (AbbreviationBlock)abbreviationRepository.get(str)) != null && 
/*     */           
/*  47 */           !(basedSequence = abbreviationBlock.getAbbreviation()).isEmpty()) {
/*  48 */           this.abbreviationMap.put(str, basedSequence);
/*     */           
/*  50 */           if (stringBuilder.length() > 0) stringBuilder.append("|");
/*     */           
/*  52 */           if (Character.isLetterOrDigit(str.charAt(0))) stringBuilder.append("\\b"); 
/*  53 */           stringBuilder.append("\\Q").append(str).append("\\E");
/*  54 */           if (Character.isLetterOrDigit(str.charAt(str.length() - 1))) stringBuilder.append("\\b");
/*     */         
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  60 */       if (stringBuilder.length() > 0) this.abbreviations = Pattern.compile(stringBuilder.toString());
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public void process(NodeTracker paramNodeTracker, Node paramNode) {
/*  66 */     if (this.abbreviations == null)
/*     */       return; 
/*  68 */     BasedSequence basedSequence1 = paramNode.getChars();
/*  69 */     ReplacedTextMapper replacedTextMapper = new ReplacedTextMapper(basedSequence1);
/*  70 */     BasedSequence basedSequence2 = Escaping.unescape(basedSequence1, replacedTextMapper);
/*     */     
/*  72 */     Matcher matcher = this.abbreviations.matcher((CharSequence)basedSequence2);
/*  73 */     int i = 0;
/*     */     boolean bool;
/*  75 */     TextBase textBase = (bool = !(paramNode.getParent() instanceof TextBase) ? true : false) ? null : (TextBase)paramNode.getParent();
/*     */     
/*  77 */     while (matcher.find()) {
/*     */       BasedSequence basedSequence;
/*     */       
/*  80 */       if ((basedSequence = this.abbreviationMap.get(matcher.group(0))) != null) {
/*     */         
/*  82 */         int j = replacedTextMapper.originalOffset(matcher.start(0));
/*  83 */         int k = replacedTextMapper.originalOffset(matcher.end(0));
/*     */         
/*  85 */         if (bool) {
/*  86 */           bool = false;
/*  87 */           textBase = new TextBase(basedSequence1);
/*  88 */           paramNode.insertBefore((Node)textBase);
/*  89 */           paramNodeTracker.nodeAdded((Node)textBase);
/*     */         } 
/*     */         
/*  92 */         if (j != i) {
/*  93 */           BasedSequence basedSequence4 = basedSequence1.subSequence(i, j);
/*  94 */           Text text = new Text(basedSequence4);
/*  95 */           textBase.appendChild((Node)text);
/*  96 */           paramNodeTracker.nodeAdded((Node)text);
/*     */         } 
/*     */         
/*  99 */         BasedSequence basedSequence3 = basedSequence1.subSequence(j, k);
/* 100 */         Abbreviation abbreviation = new Abbreviation(basedSequence3, basedSequence);
/* 101 */         textBase.appendChild((Node)abbreviation);
/* 102 */         paramNodeTracker.nodeAdded((Node)abbreviation);
/*     */         
/* 104 */         i = k;
/*     */       } 
/*     */     } 
/*     */     
/* 108 */     if (i > 0) {
/* 109 */       if (i != basedSequence1.length()) {
/* 110 */         BasedSequence basedSequence = basedSequence1.subSequence(i, basedSequence1.length());
/* 111 */         Text text = new Text(basedSequence);
/* 112 */         textBase.appendChild((Node)text);
/* 113 */         paramNodeTracker.nodeAdded((Node)text);
/*     */       } 
/*     */       
/* 116 */       paramNode.unlink();
/* 117 */       paramNodeTracker.nodeRemoved(paramNode);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     extends NodePostProcessorFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/*     */       HashSet<Class<AutolinkNodePostProcessor.Factory>> hashSet;
/* 126 */       (hashSet = new HashSet<>()).add(AutolinkNodePostProcessor.Factory.class);
/* 127 */       return hashSet;
/*     */     }
/*     */     
/*     */     public Factory() {
/* 131 */       super(false);
/* 132 */       addNodeWithExclusions(Text.class, new Class[] { DoNotDecorate.class, DoNotLinkDecorate.class });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public NodePostProcessor apply(Document param1Document) {
/* 138 */       return new AbbreviationNodePostProcessor(param1Document);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\abbreviation\internal\AbbreviationNodePostProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */