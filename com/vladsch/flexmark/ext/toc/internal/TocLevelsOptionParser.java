/*     */ package com.vladsch.flexmark.ext.toc.internal;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.DelimitedBuilder;
/*     */ import com.vladsch.flexmark.util.misc.Pair;
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ import com.vladsch.flexmark.util.options.MessageProvider;
/*     */ import com.vladsch.flexmark.util.options.OptionParser;
/*     */ import com.vladsch.flexmark.util.options.ParsedOption;
/*     */ import com.vladsch.flexmark.util.options.ParsedOptionStatus;
/*     */ import com.vladsch.flexmark.util.options.ParserMessage;
/*     */ import com.vladsch.flexmark.util.options.ParserParams;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.function.Function;
/*     */ 
/*     */ public class TocLevelsOptionParser
/*     */   implements OptionParser<TocOptions> {
/*     */   public static final String OPTION_0_VALUE_1_NOT_IN_RANGE = "{0} option value {1} is not an integer in the range [1, 6]";
/*     */   public static final String KEY_OPTION_0_VALUE_1_NOT_IN_RANGE = "options.parser.toc-levels-option.not-in-range";
/*     */   public static final String OPTION_0_VALUE_1_NOT_INTEGER = "{0} option value {1} is not an integer";
/*     */   public static final String KEY_OPTION_0_VALUE_1_NOT_INTEGER = "options.parser.toc-levels-option.not-integer";
/*     */   public static final String OPTION_0_VALUE_1_TRUNCATED_TO_RANGE_2 = "{0} option value {1} truncated to range [{2}]";
/*     */   
/*     */   static {
/*  28 */     (TOC_LEVELS_MAP = new HashMap<>()).put(Integer.valueOf(4), "2");
/*  29 */     TOC_LEVELS_MAP.put(Integer.valueOf(12), "3");
/*  30 */     TOC_LEVELS_MAP.put(Integer.valueOf(28), "4");
/*  31 */     TOC_LEVELS_MAP.put(Integer.valueOf(60), "5");
/*  32 */     TOC_LEVELS_MAP.put(Integer.valueOf(124), "6");
/*  33 */     TOC_LEVELS_MAP.put(Integer.valueOf(2), "1");
/*     */     
/*  35 */     TOC_LEVELS_MAP.put(Integer.valueOf(8), "3-3");
/*  36 */     TOC_LEVELS_MAP.put(Integer.valueOf(16), "4-4");
/*  37 */     TOC_LEVELS_MAP.put(Integer.valueOf(32), "5-5");
/*  38 */     TOC_LEVELS_MAP.put(Integer.valueOf(64), "6-6");
/*     */   }
/*     */   public static final String KEY_OPTION_0_VALUE_1_TRUNCATED_TO_RANGE_2 = "options.parser.toc-levels-option.truncated-to-range"; public static final String OPTION_0_VALUE_1_TRUNCATED_TO_EMPTY_RANGE = "{0} option value {1} truncated to empty range []"; public static final String KEY_OPTION_0_VALUE_1_TRUNCATED_TO_EMPTY_RANGE = "options.parser.toc-levels-option.truncated-to-empty"; private final String myOptionName; private static final Map<Integer, String> TOC_LEVELS_MAP;
/*     */   public TocLevelsOptionParser(String paramString) {
/*  42 */     this.myOptionName = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getOptionName() {
/*  47 */     return this.myOptionName;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Pair<TocOptions, List<ParsedOption<TocOptions>>> parseOption(BasedSequence paramBasedSequence, TocOptions paramTocOptions, MessageProvider paramMessageProvider) {
/*  53 */     paramTocOptions = paramTocOptions;
/*  54 */     BasedSequence[] arrayOfBasedSequence = (BasedSequence[])paramBasedSequence.split(",");
/*  55 */     ParserParams parserParams = new ParserParams();
/*     */     
/*  57 */     if (paramMessageProvider == null) paramMessageProvider = MessageProvider.DEFAULT;
/*     */     
/*  59 */     int i = 0;
/*     */ 
/*     */     
/*  62 */     MessageProvider messageProvider = paramMessageProvider;
/*  63 */     Function<BasedSequence, Integer> function = paramBasedSequence -> {
/*     */         try {
/*     */           return paramBasedSequence.isEmpty() ? null : Integer.valueOf(Integer.parseInt(paramBasedSequence.toString()));
/*  66 */         } catch (Exception exception) {
/*     */           paramParserParams.add(new ParserMessage(paramBasedSequence, ParsedOptionStatus.ERROR, paramMessageProvider.message("options.parser.toc-levels-option.not-integer", "{0} option value {1} is not an integer", new Object[] { this.myOptionName, paramBasedSequence }))); paramParserParams.skip = true;
/*     */           return null;
/*     */         } 
/*     */       };
/*     */     int j;
/*     */     byte b;
/*  73 */     for (j = (arrayOfBasedSequence = arrayOfBasedSequence).length, b = 0; b < j; b++) {
/*  74 */       Integer integer1, integer2; BasedSequence basedSequence, arrayOfBasedSequence1[] = (BasedSequence[])(basedSequence = arrayOfBasedSequence[b]).split("-", 2, 10);
/*     */ 
/*     */ 
/*     */       
/*  78 */       parserParams.skip = false;
/*     */       
/*  80 */       if (arrayOfBasedSequence1.length >= 2) {
/*  81 */         integer2 = function.apply(arrayOfBasedSequence1[0]);
/*  82 */         integer1 = (arrayOfBasedSequence1.length >= 3) ? function.apply(arrayOfBasedSequence1[2]) : null;
/*  83 */         if (integer2 == null) integer2 = Integer.valueOf(1); 
/*  84 */         if (integer1 == null) integer1 = Integer.valueOf(6);
/*     */       
/*     */       } else {
/*     */         Integer integer;
/*  88 */         if ((integer = function.apply(integer1[0])) != null && integer.intValue() <= 2) {
/*     */           
/*  90 */           integer1 = integer2 = integer;
/*     */         } else {
/*  92 */           integer2 = (integer == null) ? null : Integer.valueOf(2);
/*  93 */           integer1 = integer;
/*     */         } 
/*     */       } 
/*     */       
/*  97 */       if (!parserParams.skip) {
/*  98 */         if (integer2 == null) {
/*  99 */           parserParams.add(new ParserMessage(basedSequence, ParsedOptionStatus.IGNORED, messageProvider.message("options.parser.toc-levels-option.truncated-to-empty", "{0} option value {1} truncated to empty range []", new Object[] { this.myOptionName, basedSequence })));
/*     */         } else {
/* 101 */           if (integer1.intValue() < integer2.intValue()) {
/* 102 */             int k = integer2.intValue();
/* 103 */             integer2 = integer1;
/* 104 */             integer1 = Integer.valueOf(k);
/*     */           } 
/*     */           
/* 107 */           if (integer1.intValue() <= 0 || integer2.intValue() > 6) {
/* 108 */             if (integer2.intValue() == integer1.intValue()) {
/* 109 */               parserParams.add(new ParserMessage(basedSequence, ParsedOptionStatus.IGNORED, paramMessageProvider.message("options.parser.toc-levels-option.not-in-range", "{0} option value {1} is not an integer in the range [1, 6]", new Object[] { this.myOptionName, basedSequence })));
/*     */             } else {
/* 111 */               parserParams.add(new ParserMessage(basedSequence, ParsedOptionStatus.WARNING, messageProvider.message("options.parser.toc-levels-option.truncated-to-empty", "{0} option value {1} truncated to empty range []", new Object[] { this.myOptionName, basedSequence })));
/*     */             } 
/*     */           } else {
/* 114 */             int m = integer2.intValue();
/* 115 */             int n = integer1.intValue();
/* 116 */             integer2 = Integer.valueOf(Utils.minLimit(integer2.intValue(), new int[] { 1 }));
/* 117 */             integer1 = Integer.valueOf(Utils.maxLimit(integer1.intValue(), new int[] { 6 }));
/* 118 */             if (m != integer2.intValue() || n != integer1.intValue()) {
/* 119 */               parserParams.add(new ParserMessage(basedSequence, ParsedOptionStatus.WEAK_WARNING, messageProvider.message("options.parser.toc-levels-option.truncated-to-range", "{0} option value {1} truncated to range [{2}]", new Object[] { this.myOptionName, basedSequence, integer2 + ", " + integer1 })));
/*     */             }
/* 121 */             for (int k = integer2.intValue(); k <= integer1.intValue(); ) { i |= 1 << k; k++; }
/*     */           
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 128 */     if (i != 0) paramTocOptions = paramTocOptions.withLevels(i);
/*     */     
/* 130 */     return new Pair(paramTocOptions, Collections.singletonList(new ParsedOption(paramBasedSequence, this, parserParams.status, parserParams.messages)));
/*     */   }
/*     */ 
/*     */   
/*     */   public String getOptionText(TocOptions paramTocOptions1, TocOptions paramTocOptions2) {
/* 135 */     if (paramTocOptions2 == null || paramTocOptions1.levels != paramTocOptions2.levels) {
/*     */       DelimitedBuilder delimitedBuilder;
/* 137 */       (delimitedBuilder = new DelimitedBuilder()).append("levels=");
/*     */       
/*     */       String str;
/*     */       
/* 141 */       if ((str = TOC_LEVELS_MAP.get(Integer.valueOf(paramTocOptions1.levels))) != null) {
/* 142 */         delimitedBuilder.append(str).mark();
/*     */       } else {
/* 144 */         delimitedBuilder.push(",");
/*     */         
/* 146 */         byte b1 = 0;
/* 147 */         byte b2 = 0;
/* 148 */         for (byte b3 = 1; b3 <= 6; b3++) {
/* 149 */           if (paramTocOptions1.isLevelIncluded(b3)) {
/* 150 */             if (!b1) {
/* 151 */               b1 = b3;
/*     */             
/*     */             }
/* 154 */             else if (b2 + 1 != b3) {
/* 155 */               if (b1 != b2)
/* 156 */               { if (b1 + 1 == b2) { delimitedBuilder.append(b1).mark().append(b2).mark(); }
/* 157 */                 else { delimitedBuilder.append(b1).append('-').append(b2).mark(); }
/*     */                  }
/* 159 */               else { delimitedBuilder.append(b1).mark(); }
/*     */               
/* 161 */               b1 = b3;
/*     */             } 
/*     */             
/* 164 */             b2 = b3;
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 170 */         if (b1 != 0) {
/* 171 */           if (b1 != b2)
/* 172 */           { if (b1 == 2) { delimitedBuilder.append(b2).mark(); }
/* 173 */             else if (b1 + 1 == b2) { delimitedBuilder.append(b1).mark().append(b2).mark(); }
/* 174 */             else { delimitedBuilder.append(b1).append('-').append(b2).mark(); }
/*     */              }
/* 176 */           else { delimitedBuilder.append(b1).mark(); }
/*     */         
/*     */         }
/*     */         
/* 180 */         delimitedBuilder.pop().mark();
/*     */       } 
/* 182 */       return delimitedBuilder.toString();
/*     */     } 
/* 184 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\internal\TocLevelsOptionParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */