/*     */ package com.vladsch.flexmark.util.options;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.DelimitedBuilder;
/*     */ import com.vladsch.flexmark.util.misc.Pair;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class OptionsParser<T>
/*     */   implements OptionParser<T>
/*     */ {
/*     */   public static final String OPTION_0_IS_AMBIGUOUS = "Option {0} matches: ";
/*     */   public static final String KEY_OPTION_0_IS_AMBIGUOUS = "options.parser.option.ambiguous";
/*     */   public static final String OPTION_0_DOES_NOT_MATCH = "Option {0} does not match any of: ";
/*     */   public static final String KEY_OPTION_0_DOES_NOT_MATCH = "options.parser.option.unknown";
/*     */   private final String optionName;
/*     */   private final OptionParser<T>[] parseableOptions;
/*     */   private final String optionDelimiter;
/*     */   private final String optionValueDelimiter;
/*     */   
/*     */   public OptionsParser(String paramString, OptionParser<T>[] paramArrayOfOptionParser, char paramChar1, char paramChar2) {
/*  22 */     this.optionName = paramString;
/*  23 */     this.parseableOptions = paramArrayOfOptionParser;
/*  24 */     this.optionDelimiter = Character.toString(paramChar1);
/*  25 */     this.optionValueDelimiter = Character.toString(paramChar2);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getOptionName() {
/*  30 */     return this.optionName;
/*     */   }
/*     */ 
/*     */   
/*     */   public Pair<T, List<ParsedOption<T>>> parseOption(BasedSequence paramBasedSequence, T paramT, MessageProvider paramMessageProvider) {
/*  35 */     BasedSequence[] arrayOfBasedSequence = (BasedSequence[])paramBasedSequence.split(this.optionDelimiter, 0, 6, null);
/*  36 */     paramT = paramT;
/*  37 */     if (paramMessageProvider == null) paramMessageProvider = MessageProvider.DEFAULT; 
/*  38 */     ArrayList arrayList = new ArrayList(arrayOfBasedSequence.length); int i;
/*     */     byte b;
/*  40 */     for (i = (arrayOfBasedSequence = arrayOfBasedSequence).length, b = 0; b < i; ) { BasedSequence basedSequence = arrayOfBasedSequence[b];
/*  41 */       OptionParser<T> optionParser = null;
/*  42 */       DelimitedBuilder delimitedBuilder = null;
/*     */       
/*     */       BasedSequence[] arrayOfBasedSequence1;
/*  45 */       if ((arrayOfBasedSequence1 = (BasedSequence[])basedSequence.split(this.optionValueDelimiter, 2, 4, null)).length != 0) {
/*  46 */         BasedSequence basedSequence2 = arrayOfBasedSequence1[0];
/*  47 */         BasedSequence basedSequence1 = (arrayOfBasedSequence1.length > 1) ? arrayOfBasedSequence1[1] : basedSequence2.subSequence(basedSequence2.length(), basedSequence2.length()); OptionParser<T>[] arrayOfOptionParser; int j;
/*     */         byte b1;
/*  49 */         for (j = (arrayOfOptionParser = this.parseableOptions).length, b1 = 0; b1 < j; b1++) {
/*  50 */           OptionParser<T> optionParser1; if ((optionParser1 = arrayOfOptionParser[b1]).getOptionName().equals(basedSequence2.toString())) {
/*  51 */             optionParser = optionParser1;
/*  52 */             delimitedBuilder = null;
/*     */             break;
/*     */           } 
/*  55 */           if (optionParser1.getOptionName().startsWith(basedSequence2.toString())) {
/*  56 */             if (optionParser == null) {
/*  57 */               optionParser = optionParser1;
/*     */             } else {
/*  59 */               if (delimitedBuilder == null) {
/*     */                 
/*  61 */                 (delimitedBuilder = new DelimitedBuilder(", ")).append(paramMessageProvider.message("options.parser.option.ambiguous", "Option {0} matches: ", new Object[] { basedSequence2 }));
/*  62 */                 delimitedBuilder.append(optionParser.getOptionName()).mark();
/*     */               } 
/*  64 */               delimitedBuilder.append(optionParser1.getOptionName()).mark();
/*     */             } 
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/*  70 */         if (optionParser != null) {
/*  71 */           if (delimitedBuilder == null) {
/*     */             Pair<T, List<ParsedOption<T>>> pair;
/*  73 */             paramT = (T)(pair = optionParser.parseOption(basedSequence1, paramT, paramMessageProvider)).getFirst();
/*  74 */             arrayList.add(new ParsedOption(basedSequence, this, ParsedOptionStatus.VALID, null, (List<ParsedOption<?>>)pair.getSecond()));
/*     */           } else {
/*  76 */             arrayList.add(new ParsedOption(basedSequence, this, ParsedOptionStatus.ERROR, new ParserMessage(basedSequence2, ParsedOptionStatus.ERROR, delimitedBuilder.toString())));
/*     */           } 
/*     */         } else {
/*     */           
/*  80 */           (delimitedBuilder = new DelimitedBuilder(", ")).append(paramMessageProvider.message("options.parser.option.unknown", "Option {0} does not match any of: ", new Object[] { basedSequence2 }));
/*  81 */           appendOptionNames(delimitedBuilder);
/*  82 */           arrayList.add(new ParsedOption(basedSequence, this, ParsedOptionStatus.ERROR, new ParserMessage(basedSequence2, ParsedOptionStatus.ERROR, delimitedBuilder.toString())));
/*     */         } 
/*     */       }  b++; }
/*  85 */      return new Pair(paramT, arrayList); } public void appendOptionNames(DelimitedBuilder paramDelimitedBuilder) {
/*     */     OptionParser<T>[] arrayOfOptionParser;
/*     */     int i;
/*     */     byte b;
/*  89 */     for (i = (arrayOfOptionParser = this.parseableOptions).length, b = 0; b < i; ) { OptionParser<T> optionParser = arrayOfOptionParser[b];
/*  90 */       paramDelimitedBuilder.append(optionParser.getOptionName()).mark();
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   public String getOptionText(T paramT1, T paramT2) {
/*  96 */     DelimitedBuilder delimitedBuilder = new DelimitedBuilder(String.valueOf(this.optionDelimiter)); OptionParser<T>[] arrayOfOptionParser; int i; byte b;
/*  97 */     for (i = (arrayOfOptionParser = this.parseableOptions).length, b = 0; b < i; b++) {
/*     */       String str; OptionParser<T> optionParser;
/*  99 */       if (!(str = (optionParser = arrayOfOptionParser[b]).getOptionText(paramT1, paramT2).trim()).isEmpty()) delimitedBuilder.append(str).mark(); 
/*     */     } 
/* 101 */     return delimitedBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\options\OptionsParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */