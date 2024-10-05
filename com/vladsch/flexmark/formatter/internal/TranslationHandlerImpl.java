/*     */ package com.vladsch.flexmark.formatter.internal;
/*     */ import com.vladsch.flexmark.ast.AnchorRefTarget;
/*     */ import com.vladsch.flexmark.formatter.FormatterOptions;
/*     */ import com.vladsch.flexmark.formatter.MarkdownWriter;
/*     */ import com.vladsch.flexmark.formatter.MergeContext;
/*     */ import com.vladsch.flexmark.formatter.NodeFormatterContext;
/*     */ import com.vladsch.flexmark.formatter.RenderPurpose;
/*     */ import com.vladsch.flexmark.formatter.TranslatingSpanRender;
/*     */ import com.vladsch.flexmark.formatter.TranslationHandler;
/*     */ import com.vladsch.flexmark.formatter.TranslationPlaceholderGenerator;
/*     */ import com.vladsch.flexmark.html.renderer.HtmlIdGenerator;
/*     */ import com.vladsch.flexmark.html.renderer.HtmlIdGeneratorFactory;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*     */ import com.vladsch.flexmark.util.data.MutableDataSet;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.IRichSequence;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class TranslationHandlerImpl implements TranslationHandler {
/*     */   final FormatterOptions myFormatterOptions;
/*     */   final HashMap<String, String> myNonTranslatingTexts;
/*     */   final HashMap<String, String> myAnchorTexts;
/*     */   final HashMap<String, String> myTranslatingTexts;
/*     */   final HashMap<String, String> myTranslatedTexts;
/*     */   final ArrayList<String> myTranslatingPlaceholders;
/*     */   final ArrayList<String> myTranslatingSpans;
/*     */   final ArrayList<String> myNonTranslatingSpans;
/*     */   final ArrayList<String> myTranslatedSpans;
/*     */   final HtmlIdGeneratorFactory myIdGeneratorFactory;
/*     */   final Pattern myPlaceHolderMarkerPattern;
/*     */   final MutableDataSet myTranslationStore;
/*     */   final HashMap<String, Integer> myOriginalRefTargets;
/*     */   final HashMap<Integer, String> myTranslatedRefTargets;
/*     */   final HashMap<String, String> myOriginalAnchors;
/*     */   final HashMap<String, String> myTranslatedAnchors;
/*  46 */   private int myPlaceholderId = 0;
/*  47 */   private int myAnchorId = 0;
/*  48 */   private int myTranslatingSpanId = 0;
/*  49 */   private int myNonTranslatingSpanId = 0;
/*     */   private RenderPurpose myRenderPurpose;
/*     */   private MarkdownWriter myWriter;
/*     */   private HtmlIdGenerator myIdGenerator;
/*     */   private TranslationPlaceholderGenerator myPlaceholderGenerator;
/*  54 */   private Function<String, CharSequence> myNonTranslatingPostProcessor = null;
/*  55 */   private MergeContext myMergeContext = null;
/*     */   
/*     */   public TranslationHandlerImpl(DataHolder paramDataHolder, HtmlIdGeneratorFactory paramHtmlIdGeneratorFactory) {
/*  58 */     this.myFormatterOptions = new FormatterOptions(paramDataHolder);
/*  59 */     this.myIdGeneratorFactory = paramHtmlIdGeneratorFactory;
/*  60 */     this.myNonTranslatingTexts = new HashMap<>();
/*  61 */     this.myAnchorTexts = new HashMap<>();
/*  62 */     this.myTranslatingTexts = new HashMap<>();
/*  63 */     this.myTranslatedTexts = new HashMap<>();
/*  64 */     this.myOriginalAnchors = new HashMap<>();
/*  65 */     this.myTranslatedAnchors = new HashMap<>();
/*  66 */     this.myTranslatedRefTargets = new HashMap<>();
/*  67 */     this.myOriginalRefTargets = new HashMap<>();
/*  68 */     this.myTranslatingSpans = new ArrayList<>();
/*  69 */     this.myTranslatedSpans = new ArrayList<>();
/*  70 */     this.myTranslatingPlaceholders = new ArrayList<>();
/*  71 */     this.myNonTranslatingSpans = new ArrayList<>();
/*  72 */     this.myPlaceHolderMarkerPattern = Pattern.compile(this.myFormatterOptions.translationExcludePattern);
/*  73 */     this.myTranslationStore = new MutableDataSet();
/*     */   }
/*     */ 
/*     */   
/*     */   public MergeContext getMergeContext() {
/*  78 */     return this.myMergeContext;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMergeContext(MergeContext paramMergeContext) {
/*  83 */     this.myMergeContext = paramMergeContext;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MutableDataSet getTranslationStore() {
/*  89 */     return this.myTranslationStore;
/*     */   }
/*     */ 
/*     */   
/*     */   public HtmlIdGenerator getIdGenerator() {
/*  94 */     return this.myIdGenerator;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void beginRendering(Document paramDocument, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 100 */     this.myWriter = paramMarkdownWriter;
/* 101 */     this.myIdGenerator = this.myIdGeneratorFactory.create();
/* 102 */     this.myIdGenerator.generateIds(paramDocument);
/*     */   }
/*     */   
/*     */   static boolean isNotBlank(CharSequence paramCharSequence) {
/* 106 */     int i = paramCharSequence.length();
/* 107 */     for (byte b = 0; b < i; b++) {
/* 108 */       if (!Character.isWhitespace(paramCharSequence.charAt(b))) return true; 
/*     */     } 
/* 110 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getTranslatingTexts() {
/* 116 */     this.myTranslatingPlaceholders.clear();
/* 117 */     this.myTranslatingPlaceholders.ensureCapacity(this.myTranslatedSpans.size() + this.myTranslatedTexts.size());
/* 118 */     ArrayList<String> arrayList = new ArrayList(this.myTranslatedSpans.size() + this.myTranslatedTexts.size());
/* 119 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*     */     Iterator<Map.Entry> iterator;
/* 122 */     for (iterator = this.myTranslatingTexts.entrySet().iterator(); iterator.hasNext();) {
/* 123 */       if (isNotBlank((entry = iterator.next()).getValue()) && !this.myPlaceHolderMarkerPattern.matcher(entry.getValue()).matches())
/*     */       {
/* 125 */         if (!hashMap.containsKey(entry.getValue())) {
/*     */           
/* 127 */           hashMap.put(entry.getValue(), Integer.valueOf(arrayList.size()));
/* 128 */           arrayList.add(entry.getValue());
/* 129 */           this.myTranslatingPlaceholders.add((String)entry.getKey());
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 134 */     for (iterator = (Iterator)this.myTranslatingSpans.iterator(); iterator.hasNext();) {
/* 135 */       if (isNotBlank(charSequence = (CharSequence)iterator.next()) && !this.myPlaceHolderMarkerPattern.matcher(charSequence).matches()) {
/* 136 */         arrayList.add(charSequence.toString());
/*     */       }
/*     */     } 
/*     */     
/* 140 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTranslatedTexts(List<? extends CharSequence> paramList) {
/* 145 */     this.myTranslatedTexts.clear();
/* 146 */     this.myTranslatedTexts.putAll(this.myTranslatingTexts);
/* 147 */     this.myTranslatedSpans.clear();
/* 148 */     this.myTranslatedSpans.ensureCapacity(this.myTranslatingSpans.size());
/*     */ 
/*     */     
/* 151 */     byte b = 0;
/* 152 */     paramList.size();
/* 153 */     int i = this.myTranslatingPlaceholders.size();
/* 154 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     Iterator<Map.Entry> iterator;
/* 156 */     for (iterator = this.myTranslatingTexts.entrySet().iterator(); iterator.hasNext();) {
/* 157 */       if (isNotBlank((entry = iterator.next()).getValue()) && !this.myPlaceHolderMarkerPattern.matcher(entry.getValue()).matches()) {
/*     */         Integer integer;
/* 159 */         if ((integer = (Integer)hashMap.get(entry.getValue())) == null) {
/* 160 */           if (b < i) {
/*     */             
/* 162 */             hashMap.put(entry.getValue(), Integer.valueOf(b));
/* 163 */             this.myTranslatedTexts.put((String)entry.getKey(), ((CharSequence)paramList.get(b)).toString());
/* 164 */             b++; continue;
/*     */           }  break;
/* 166 */         }  this.myTranslatedTexts.put((String)entry.getKey(), ((CharSequence)paramList.get(integer.intValue())).toString());
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 173 */     for (iterator = (Iterator)this.myTranslatingSpans.iterator(); iterator.hasNext(); ) {
/* 174 */       CharSequence charSequence; if (isNotBlank(charSequence = (CharSequence)iterator.next()) && !this.myPlaceHolderMarkerPattern.matcher(charSequence).matches()) {
/* 175 */         this.myTranslatedSpans.add(((CharSequence)paramList.get(b)).toString());
/* 176 */         b++;
/*     */         continue;
/*     */       } 
/* 179 */       this.myTranslatedSpans.add(charSequence.toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRenderPurpose(RenderPurpose paramRenderPurpose) {
/* 186 */     this.myAnchorId = 0;
/* 187 */     this.myTranslatingSpanId = 0;
/* 188 */     this.myPlaceholderId = 0;
/* 189 */     this.myRenderPurpose = paramRenderPurpose;
/* 190 */     this.myNonTranslatingSpanId = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderPurpose getRenderPurpose() {
/* 196 */     return this.myRenderPurpose;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTransformingText() {
/* 201 */     return (this.myRenderPurpose != RenderPurpose.FORMAT);
/*     */   }
/*     */   
/*     */   public CharSequence transformAnchorRef(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*     */     String str1;
/*     */     String str2;
/* 207 */     switch (this.myRenderPurpose) {
/*     */       case TRANSLATION_SPANS:
/* 209 */         paramCharSequence1 = String.format(this.myFormatterOptions.translationIdFormat, new Object[] { Integer.valueOf(++this.myAnchorId) });
/* 210 */         this.myAnchorTexts.put(paramCharSequence1, paramCharSequence2.toString());
/* 211 */         return paramCharSequence1;
/*     */       
/*     */       case TRANSLATED_SPANS:
/* 214 */         return String.format(this.myFormatterOptions.translationIdFormat, new Object[] { Integer.valueOf(++this.myAnchorId) });
/*     */       
/*     */       case TRANSLATED:
/* 217 */         str2 = String.format(this.myFormatterOptions.translationIdFormat, new Object[] { Integer.valueOf(++this.myAnchorId) });
/*     */ 
/*     */         
/* 220 */         if ((paramCharSequence1 = this.myNonTranslatingTexts.get(paramCharSequence1.toString())) != null && paramCharSequence1.length() == 0) {
/*     */ 
/*     */           
/* 223 */           if ((paramCharSequence1 = this.myAnchorTexts.get(str2)) != null) {
/*     */             Integer integer;
/*     */             
/* 226 */             if ((integer = this.myOriginalRefTargets.get(paramCharSequence1)) != null)
/*     */             {
/*     */               
/* 229 */               if ((str1 = this.myTranslatedRefTargets.get(integer)) != null) {
/* 230 */                 return str1;
/*     */               }
/*     */             }
/* 233 */             return paramCharSequence1;
/*     */           } 
/*     */           break;
/*     */         } 
/* 237 */         if ((paramCharSequence1 = this.myAnchorTexts.get(str2)) != null) {
/* 238 */           return paramCharSequence1;
/*     */         }
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 244 */     return str1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void customPlaceholderFormat(TranslationPlaceholderGenerator paramTranslationPlaceholderGenerator, TranslatingSpanRender paramTranslatingSpanRender) {
/* 250 */     if (this.myRenderPurpose != RenderPurpose.TRANSLATED_SPANS) {
/* 251 */       TranslationPlaceholderGenerator translationPlaceholderGenerator = this.myPlaceholderGenerator;
/* 252 */       this.myPlaceholderGenerator = paramTranslationPlaceholderGenerator;
/* 253 */       paramTranslatingSpanRender.render((NodeFormatterContext)this.myWriter.getContext(), this.myWriter);
/* 254 */       this.myPlaceholderGenerator = translationPlaceholderGenerator;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void translatingSpan(TranslatingSpanRender paramTranslatingSpanRender) {
/* 260 */     translatingRefTargetSpan(null, paramTranslatingSpanRender);
/*     */   }
/*     */ 
/*     */   
/*     */   private String renderInSubContext(TranslatingSpanRender paramTranslatingSpanRender, boolean paramBoolean) {
/* 265 */     MarkdownWriter markdownWriter1 = this.myWriter;
/*     */     NodeFormatterContext nodeFormatterContext;
/* 267 */     MarkdownWriter markdownWriter2 = (nodeFormatterContext = (NodeFormatterContext)((NodeFormatterContext)this.myWriter.getContext()).getSubContext()).getMarkdown();
/* 268 */     this.myWriter = markdownWriter2;
/*     */     
/* 270 */     paramTranslatingSpanRender.render(nodeFormatterContext, markdownWriter2);
/*     */ 
/*     */     
/* 273 */     String str = markdownWriter2.toString(2, -1);
/*     */     
/* 275 */     this.myWriter = markdownWriter1;
/* 276 */     if (paramBoolean) {
/* 277 */       this.myWriter.append(str);
/*     */     }
/* 279 */     return str;
/*     */   }
/*     */   
/*     */   public void translatingRefTargetSpan(Node paramNode, TranslatingSpanRender paramTranslatingSpanRender) {
/*     */     String str1, str2;
/* 284 */     switch (this.myRenderPurpose) {
/*     */       case TRANSLATION_SPANS:
/* 286 */         str2 = renderInSubContext(paramTranslatingSpanRender, true);
/* 287 */         if (paramNode != null && (
/* 288 */           !(paramNode instanceof AnchorRefTarget) || !((AnchorRefTarget)paramNode).isExplicitAnchorRefId())) {
/* 289 */           str1 = this.myIdGenerator.getId(paramNode);
/* 290 */           this.myOriginalRefTargets.put(str1, Integer.valueOf(this.myTranslatingSpans.size()));
/*     */         } 
/*     */ 
/*     */         
/* 294 */         this.myTranslatingSpans.add(str2);
/*     */         return;
/*     */ 
/*     */ 
/*     */       
/*     */       case TRANSLATED_SPANS:
/* 300 */         renderInSubContext(paramTranslatingSpanRender, false);
/*     */         
/* 302 */         str2 = this.myTranslatedSpans.get(this.myTranslatingSpanId);
/*     */         
/* 304 */         if (str1 != null && (
/* 305 */           !(str1 instanceof AnchorRefTarget) || !((AnchorRefTarget)str1).isExplicitAnchorRefId())) {
/*     */           
/* 307 */           str1 = this.myIdGenerator.getId(str2);
/* 308 */           this.myTranslatedRefTargets.put(Integer.valueOf(this.myTranslatingSpanId), str1);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 314 */         this.myTranslatingSpanId++;
/*     */         
/* 316 */         this.myWriter.append(str2);
/*     */         return;
/*     */ 
/*     */       
/*     */       case TRANSLATED:
/* 321 */         if (str1 != null && (
/* 322 */           !(str1 instanceof AnchorRefTarget) || !((AnchorRefTarget)str1).isExplicitAnchorRefId())) {
/*     */           
/* 324 */           str2 = this.myIdGenerator.getId((Node)str1);
/* 325 */           this.myTranslatedRefTargets.put(Integer.valueOf(this.myTranslatingSpanId), str2);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 331 */         this.myTranslatingSpanId++;
/* 332 */         renderInSubContext(paramTranslatingSpanRender, true);
/*     */         return;
/*     */     } 
/*     */ 
/*     */     
/* 337 */     paramTranslatingSpanRender.render((NodeFormatterContext)this.myWriter.getContext(), this.myWriter);
/*     */   }
/*     */   
/*     */   public void nonTranslatingSpan(TranslatingSpanRender paramTranslatingSpanRender) {
/*     */     String str;
/* 342 */     switch (this.myRenderPurpose) {
/*     */       case TRANSLATION_SPANS:
/* 344 */         str = renderInSubContext(paramTranslatingSpanRender, false);
/*     */         
/* 346 */         this.myNonTranslatingSpans.add(str);
/* 347 */         this.myNonTranslatingSpanId++;
/*     */         
/* 349 */         str = getPlaceholderId(this.myFormatterOptions.translationIdFormat, this.myNonTranslatingSpanId, null, null, null);
/* 350 */         this.myWriter.append(str);
/*     */         return;
/*     */ 
/*     */ 
/*     */       
/*     */       case TRANSLATED_SPANS:
/* 356 */         renderInSubContext((TranslatingSpanRender)str, false);
/*     */         
/* 358 */         str = this.myNonTranslatingSpans.get(this.myNonTranslatingSpanId);
/* 359 */         this.myNonTranslatingSpanId++;
/* 360 */         this.myWriter.append(str);
/*     */         return;
/*     */ 
/*     */ 
/*     */       
/*     */       case TRANSLATED:
/* 366 */         renderInSubContext((TranslatingSpanRender)str, true);
/* 367 */         this.myNonTranslatingSpanId++;
/*     */         return;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 373 */     str.render((NodeFormatterContext)this.myWriter.getContext(), this.myWriter);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPlaceholderId(String paramString, int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3) {
/* 378 */     paramString = (this.myPlaceholderGenerator != null) ? this.myPlaceholderGenerator.getPlaceholder(paramInt) : String.format(paramString, new Object[] { Integer.valueOf(paramInt) });
/* 379 */     if (paramCharSequence1 == null && paramCharSequence2 == null && paramCharSequence3 == null) return paramString;
/*     */     
/* 381 */     return addPrefixSuffix(paramString, paramCharSequence1, paramCharSequence2, paramCharSequence3);
/*     */   }
/*     */   
/*     */   public static String addPrefixSuffix(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, CharSequence paramCharSequence4) {
/* 385 */     if (paramCharSequence2 == null && paramCharSequence3 == null && paramCharSequence4 == null) return paramCharSequence1.toString();
/*     */     
/* 387 */     StringBuilder stringBuilder = new StringBuilder();
/* 388 */     if (paramCharSequence2 != null) stringBuilder.append(paramCharSequence2); 
/* 389 */     stringBuilder.append(paramCharSequence1);
/* 390 */     if (paramCharSequence3 != null) stringBuilder.append(paramCharSequence3); 
/* 391 */     if (paramCharSequence4 != null) stringBuilder.append(paramCharSequence4); 
/* 392 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void postProcessNonTranslating(Function<String, CharSequence> paramFunction, Runnable paramRunnable) {
/* 397 */     Function<String, CharSequence> function = this.myNonTranslatingPostProcessor;
/*     */     try {
/* 399 */       this.myNonTranslatingPostProcessor = paramFunction;
/* 400 */       paramRunnable.run(); return;
/*     */     } finally {
/* 402 */       this.myNonTranslatingPostProcessor = function;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T postProcessNonTranslating(Function<String, CharSequence> paramFunction, Supplier<T> paramSupplier) {
/* 409 */     Function<String, CharSequence> function = this.myNonTranslatingPostProcessor;
/*     */     try {
/* 411 */       this.myNonTranslatingPostProcessor = paramFunction;
/* 412 */       paramFunction = (Function<String, CharSequence>)paramSupplier.get(); return (T)paramFunction;
/*     */     } finally {
/* 414 */       this.myNonTranslatingPostProcessor = function;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPostProcessingNonTranslating() {
/* 420 */     return (this.myNonTranslatingPostProcessor != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence transformNonTranslating(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, CharSequence paramCharSequence4) {
/*     */     IRichSequence iRichSequence;
/*     */     String str;
/* 428 */     if (paramCharSequence4 != null) {
/* 429 */       paramCharSequence4 = paramCharSequence4;
/*     */     } else {
/*     */       BasedSequence basedSequence;
/* 432 */       iRichSequence = (basedSequence = BasedSequence.of(paramCharSequence2)).trimmedEOL();
/*     */     } 
/*     */     
/* 435 */     switch (this.myRenderPurpose) {
/*     */       
/*     */       case TRANSLATION_SPANS:
/* 438 */         paramCharSequence1 = str = getPlaceholderId(this.myFormatterOptions.translationIdFormat, ++this.myPlaceholderId, paramCharSequence1, paramCharSequence3, (CharSequence)iRichSequence);
/*     */         
/* 440 */         if (this.myNonTranslatingPostProcessor != null) {
/* 441 */           paramCharSequence1 = ((CharSequence)this.myNonTranslatingPostProcessor.apply(str)).toString();
/*     */         }
/*     */         
/* 444 */         this.myNonTranslatingTexts.put(paramCharSequence1, paramCharSequence2.toString());
/* 445 */         return paramCharSequence1;
/*     */       
/*     */       case TRANSLATED_SPANS:
/* 448 */         paramCharSequence1 = getPlaceholderId(this.myFormatterOptions.translationIdFormat, ++this.myPlaceholderId, paramCharSequence1, paramCharSequence3, str);
/* 449 */         if (this.myNonTranslatingPostProcessor != null) {
/* 450 */           return this.myNonTranslatingPostProcessor.apply(paramCharSequence1);
/*     */         }
/* 452 */         return paramCharSequence1;
/*     */ 
/*     */       
/*     */       case TRANSLATED:
/* 456 */         if (paramCharSequence2.length() > 0) {
/*     */           
/* 458 */           if ((paramCharSequence1 = this.myNonTranslatingTexts.get(paramCharSequence2.toString())) == null) {
/* 459 */             paramCharSequence1 = "";
/*     */           }
/*     */           
/* 462 */           if (this.myNonTranslatingPostProcessor != null) {
/* 463 */             return this.myNonTranslatingPostProcessor.apply(paramCharSequence1);
/*     */           }
/* 465 */           return paramCharSequence1;
/*     */         } 
/* 467 */         return paramCharSequence2;
/*     */     } 
/*     */ 
/*     */     
/* 471 */     return paramCharSequence2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence transformTranslating(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, CharSequence paramCharSequence4) {
/*     */     CharSequence charSequence;
/* 478 */     switch (this.myRenderPurpose) {
/*     */       case TRANSLATION_SPANS:
/* 480 */         paramCharSequence1 = getPlaceholderId(this.myFormatterOptions.translationIdFormat, ++this.myPlaceholderId, paramCharSequence1, paramCharSequence3, paramCharSequence4);
/* 481 */         this.myTranslatingTexts.put(paramCharSequence1, paramCharSequence2.toString());
/* 482 */         return paramCharSequence1;
/*     */       
/*     */       case TRANSLATED_SPANS:
/* 485 */         return getPlaceholderId(this.myFormatterOptions.translationIdFormat, ++this.myPlaceholderId, paramCharSequence1, paramCharSequence3, paramCharSequence4);
/*     */       
/*     */       case TRANSLATED:
/* 488 */         charSequence = (paramCharSequence1 == null && paramCharSequence3 == null && paramCharSequence4 == null) ? paramCharSequence2 : addPrefixSuffix(paramCharSequence2, paramCharSequence1, paramCharSequence3, paramCharSequence4);
/*     */         
/* 490 */         if ((charSequence = this.myTranslatedTexts.get(charSequence.toString())) != null && (paramCharSequence1 != null || paramCharSequence3 != null || paramCharSequence4 != null)) {
/* 491 */           return addPrefixSuffix(charSequence, paramCharSequence1, paramCharSequence3, paramCharSequence4);
/*     */         }
/* 493 */         if (charSequence != null) {
/* 494 */           return charSequence;
/*     */         }
/*     */         break;
/*     */     } 
/*     */     
/* 499 */     return paramCharSequence2;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\internal\TranslationHandlerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */