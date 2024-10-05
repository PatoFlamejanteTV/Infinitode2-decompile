/*     */ package com.vladsch.flexmark.ext.toc.internal;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.Pair;
/*     */ import com.vladsch.flexmark.util.options.BooleanOptionParser;
/*     */ import com.vladsch.flexmark.util.options.MessageProvider;
/*     */ import com.vladsch.flexmark.util.options.OptionParser;
/*     */ import com.vladsch.flexmark.util.options.ParsedOption;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.List;
/*     */ 
/*     */ public enum TocOptionTypes
/*     */   implements OptionParser<TocOptions> {
/*  13 */   LEVELS(new TocLevelsOptionParser("levels")),
/*  14 */   BULLETS((OptionParser<TocOptions>)new BooleanOptionParser<TocOptions>("bullet")
/*     */     {
/*     */       protected final boolean isOptionSet(TocOptions param1TocOptions) {
/*  17 */         return !param1TocOptions.isNumbered;
/*     */       }
/*     */ 
/*     */       
/*     */       public final TocOptions setOptions(TocOptions param1TocOptions) {
/*  22 */         return param1TocOptions.withIsNumbered(false);
/*     */       }
/*     */     }),
/*  25 */   NUMERIC((OptionParser<TocOptions>)new BooleanOptionParser<TocOptions>("numbered")
/*     */     {
/*     */       protected final boolean isOptionSet(TocOptions param1TocOptions) {
/*  28 */         return param1TocOptions.isNumbered;
/*     */       }
/*     */ 
/*     */       
/*     */       public final TocOptions setOptions(TocOptions param1TocOptions) {
/*  33 */         return param1TocOptions.withIsNumbered(true);
/*     */       }
/*     */     }),
/*  36 */   TEXT((OptionParser<TocOptions>)new BooleanOptionParser<TocOptions>("text")
/*     */     {
/*     */       protected final boolean isOptionSet(TocOptions param1TocOptions) {
/*  39 */         return param1TocOptions.isTextOnly;
/*     */       }
/*     */ 
/*     */       
/*     */       public final TocOptions setOptions(TocOptions param1TocOptions) {
/*  44 */         return param1TocOptions.withIsTextOnly(true);
/*     */       }
/*     */     }),
/*  47 */   FORMATTED((OptionParser<TocOptions>)new BooleanOptionParser<TocOptions>("formatted")
/*     */     {
/*     */       protected final boolean isOptionSet(TocOptions param1TocOptions) {
/*  50 */         return !param1TocOptions.isTextOnly;
/*     */       }
/*     */ 
/*     */       
/*     */       public final TocOptions setOptions(TocOptions param1TocOptions) {
/*  55 */         return param1TocOptions.withIsTextOnly(false);
/*     */       }
/*     */     }),
/*  58 */   HIERARCHY((OptionParser<TocOptions>)new BooleanOptionParser<TocOptions>("hierarchy")
/*     */     {
/*     */       protected final boolean isOptionSet(TocOptions param1TocOptions) {
/*  61 */         return (param1TocOptions.listType == TocOptions.ListType.HIERARCHY);
/*     */       }
/*     */ 
/*     */       
/*     */       public final TocOptions setOptions(TocOptions param1TocOptions) {
/*  66 */         return param1TocOptions.withListType(TocOptions.ListType.HIERARCHY);
/*     */       }
/*     */     }),
/*  69 */   FLAT((OptionParser<TocOptions>)new BooleanOptionParser<TocOptions>("flat")
/*     */     {
/*     */       protected final boolean isOptionSet(TocOptions param1TocOptions) {
/*  72 */         return (param1TocOptions.listType == TocOptions.ListType.FLAT);
/*     */       }
/*     */ 
/*     */       
/*     */       public final TocOptions setOptions(TocOptions param1TocOptions) {
/*  77 */         return param1TocOptions.withListType(TocOptions.ListType.FLAT);
/*     */       }
/*     */     }),
/*  80 */   FLAT_REVERSED((OptionParser<TocOptions>)new BooleanOptionParser<TocOptions>("reversed")
/*     */     {
/*     */       protected final boolean isOptionSet(TocOptions param1TocOptions) {
/*  83 */         return (param1TocOptions.listType == TocOptions.ListType.FLAT_REVERSED);
/*     */       }
/*     */ 
/*     */       
/*     */       public final TocOptions setOptions(TocOptions param1TocOptions) {
/*  88 */         return param1TocOptions.withListType(TocOptions.ListType.FLAT_REVERSED);
/*     */       }
/*     */     }),
/*  91 */   SORTED((OptionParser<TocOptions>)new BooleanOptionParser<TocOptions>("increasing")
/*     */     {
/*     */       protected final boolean isOptionSet(TocOptions param1TocOptions) {
/*  94 */         return (param1TocOptions.listType == TocOptions.ListType.SORTED);
/*     */       }
/*     */ 
/*     */       
/*     */       public final TocOptions setOptions(TocOptions param1TocOptions) {
/*  99 */         return param1TocOptions.withListType(TocOptions.ListType.SORTED);
/*     */       }
/*     */     }),
/* 102 */   SORTED_REVERSED((OptionParser<TocOptions>)new BooleanOptionParser<TocOptions>("decreasing")
/*     */     {
/*     */       protected final boolean isOptionSet(TocOptions param1TocOptions) {
/* 105 */         return (param1TocOptions.listType == TocOptions.ListType.SORTED_REVERSED);
/*     */       }
/*     */ 
/*     */       
/*     */       public final TocOptions setOptions(TocOptions param1TocOptions) {
/* 110 */         return param1TocOptions.withListType(TocOptions.ListType.SORTED_REVERSED);
/*     */       }
/*     */     });
/*     */   
/*     */   public final OptionParser<TocOptions> parser;
/*     */   public static final OptionParser<TocOptions>[] OPTIONS;
/*     */   
/*     */   public final String getOptionName() {
/* 118 */     return this.parser.getOptionName();
/*     */   }
/*     */   public final Pair<TocOptions, List<ParsedOption<TocOptions>>> parseOption(BasedSequence paramBasedSequence, TocOptions paramTocOptions, MessageProvider paramMessageProvider) {
/* 121 */     return this.parser.parseOption(paramBasedSequence, paramTocOptions, paramMessageProvider);
/*     */   }
/*     */   public final String getOptionText(TocOptions paramTocOptions1, TocOptions paramTocOptions2) {
/* 124 */     return this.parser.getOptionText(paramTocOptions1, paramTocOptions2);
/*     */   } TocOptionTypes(OptionParser<TocOptions> paramOptionParser) {
/* 126 */     this.parser = paramOptionParser;
/*     */   } static {
/* 128 */     OPTIONS = (OptionParser<TocOptions>[])values();
/*     */   }
/*     */   
/*     */   static class Constants {
/*     */     static final String OPTION_BULLET = "bullet";
/*     */     static final String OPTION_NUMBERED = "numbered";
/*     */     static final String OPTION_TEXT = "text";
/*     */     static final String OPTION_FORMATTED = "formatted";
/*     */     static final String OPTION_HIERARCHY = "hierarchy";
/*     */     static final String OPTION_FLAT = "flat";
/*     */     static final String OPTION_FLAT_REVERSED = "reversed";
/*     */     static final String OPTION_SORTED = "increasing";
/*     */     static final String OPTION_SORTED_REVERSED = "decreasing";
/*     */     static final String OPTION_LEVELS = "levels";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\internal\TocOptionTypes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */