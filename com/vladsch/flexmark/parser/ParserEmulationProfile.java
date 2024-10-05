/*     */ package com.vladsch.flexmark.parser;
/*     */ import com.vladsch.flexmark.html.HtmlRenderer;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.DataKey;
/*     */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*     */ import com.vladsch.flexmark.util.data.MutableDataSet;
/*     */ 
/*     */ public enum ParserEmulationProfile implements MutableDataSetter {
/*   9 */   COMMONMARK(null),
/*  10 */   COMMONMARK_0_26(COMMONMARK),
/*  11 */   COMMONMARK_0_27(COMMONMARK),
/*  12 */   COMMONMARK_0_28(COMMONMARK),
/*  13 */   COMMONMARK_0_29(COMMONMARK),
/*  14 */   FIXED_INDENT(null),
/*  15 */   KRAMDOWN(null),
/*  16 */   MARKDOWN(null),
/*  17 */   GITHUB_DOC(MARKDOWN),
/*  18 */   GITHUB(COMMONMARK),
/*  19 */   MULTI_MARKDOWN(FIXED_INDENT),
/*  20 */   PEGDOWN(FIXED_INDENT),
/*  21 */   PEGDOWN_STRICT(FIXED_INDENT);
/*     */   
/*     */   public final ParserEmulationProfile family;
/*     */   public static final DataKey<Integer> PEGDOWN_EXTENSIONS;
/*     */   
/*     */   ParserEmulationProfile(ParserEmulationProfile paramParserEmulationProfile) {
/*  27 */     this.family = (paramParserEmulationProfile == null) ? this : paramParserEmulationProfile;
/*     */   }
/*     */   
/*     */   public final MutableDataHolder getProfileOptions() {
/*  31 */     MutableDataSet mutableDataSet = new MutableDataSet();
/*  32 */     setIn((MutableDataHolder)mutableDataSet);
/*  33 */     return (MutableDataHolder)mutableDataSet;
/*     */   }
/*     */   
/*     */   public final MutableListOptions getOptions() {
/*  37 */     return getOptions(null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  43 */     PEGDOWN_EXTENSIONS = new DataKey("PEGDOWN_EXTENSIONS", Integer.valueOf(65535));
/*     */   }
/*     */   public final MutableListOptions getOptions(DataHolder paramDataHolder) {
/*  46 */     if (this.family == FIXED_INDENT) {
/*  47 */       if (this == MULTI_MARKDOWN) {
/*  48 */         return (new MutableListOptions()).setParserEmulationFamily(this)
/*  49 */           .setAutoLoose(true)
/*  50 */           .setAutoLooseOneLevelLists(true)
/*  51 */           .setDelimiterMismatchToNewList(false)
/*  52 */           .setCodeIndent(8)
/*  53 */           .setEndOnDoubleBlank(false)
/*  54 */           .setItemIndent(4)
/*  55 */           .setItemInterrupt((new ListOptions.MutableItemInterrupt())
/*  56 */             .setBulletItemInterruptsParagraph(false)
/*  57 */             .setOrderedItemInterruptsParagraph(false)
/*  58 */             .setOrderedNonOneItemInterruptsParagraph(false)
/*     */             
/*  60 */             .setEmptyBulletItemInterruptsParagraph(false)
/*  61 */             .setEmptyOrderedItemInterruptsParagraph(false)
/*  62 */             .setEmptyOrderedNonOneItemInterruptsParagraph(false)
/*     */             
/*  64 */             .setBulletItemInterruptsItemParagraph(true)
/*  65 */             .setOrderedItemInterruptsItemParagraph(true)
/*  66 */             .setOrderedNonOneItemInterruptsItemParagraph(true)
/*     */             
/*  68 */             .setEmptyBulletItemInterruptsItemParagraph(true)
/*  69 */             .setEmptyOrderedItemInterruptsItemParagraph(true)
/*  70 */             .setEmptyOrderedNonOneItemInterruptsItemParagraph(true)
/*     */             
/*  72 */             .setEmptyBulletSubItemInterruptsItemParagraph(true)
/*  73 */             .setEmptyOrderedSubItemInterruptsItemParagraph(true)
/*  74 */             .setEmptyOrderedNonOneSubItemInterruptsItemParagraph(true))
/*     */           
/*  76 */           .setItemMarkerSpace(false)
/*  77 */           .setItemTypeMismatchToNewList(false)
/*  78 */           .setItemTypeMismatchToSubList(false)
/*  79 */           .setLooseWhenBlankLineFollowsItemParagraph(true)
/*  80 */           .setLooseWhenHasTrailingBlankLine(false)
/*  81 */           .setLooseWhenHasNonListChildren(true)
/*  82 */           .setNewItemCodeIndent(2147483647)
/*  83 */           .setOrderedItemDotOnly(true)
/*  84 */           .setOrderedListManualStart(false);
/*     */       }
/*     */ 
/*     */       
/*  88 */       if (this == PEGDOWN || this == PEGDOWN_STRICT) {
/*  89 */         return (new MutableListOptions()).setParserEmulationFamily(this)
/*  90 */           .setAutoLoose(false)
/*  91 */           .setAutoLooseOneLevelLists(false)
/*  92 */           .setLooseWhenBlankLineFollowsItemParagraph(false)
/*  93 */           .setLooseWhenHasLooseSubItem(false)
/*  94 */           .setLooseWhenHasTrailingBlankLine(false)
/*  95 */           .setLooseWhenPrevHasTrailingBlankLine(true)
/*  96 */           .setOrderedListManualStart(false)
/*  97 */           .setDelimiterMismatchToNewList(false)
/*  98 */           .setItemTypeMismatchToNewList(true)
/*  99 */           .setItemTypeMismatchToSubList(false)
/* 100 */           .setEndOnDoubleBlank(false)
/* 101 */           .setOrderedItemDotOnly(true)
/* 102 */           .setItemMarkerSpace(true)
/* 103 */           .setItemIndent(4)
/* 104 */           .setCodeIndent(8)
/* 105 */           .setNewItemCodeIndent(2147483647)
/* 106 */           .setItemInterrupt((new ListOptions.MutableItemInterrupt())
/* 107 */             .setBulletItemInterruptsParagraph(false)
/* 108 */             .setOrderedItemInterruptsParagraph(false)
/* 109 */             .setOrderedNonOneItemInterruptsParagraph(false)
/*     */             
/* 111 */             .setEmptyBulletItemInterruptsParagraph(false)
/* 112 */             .setEmptyOrderedItemInterruptsParagraph(false)
/* 113 */             .setEmptyOrderedNonOneItemInterruptsParagraph(false)
/*     */             
/* 115 */             .setBulletItemInterruptsItemParagraph(true)
/* 116 */             .setOrderedItemInterruptsItemParagraph(true)
/* 117 */             .setOrderedNonOneItemInterruptsItemParagraph(true)
/*     */             
/* 119 */             .setEmptyBulletItemInterruptsItemParagraph(true)
/* 120 */             .setEmptyOrderedItemInterruptsItemParagraph(true)
/* 121 */             .setEmptyOrderedNonOneItemInterruptsItemParagraph(true)
/*     */             
/* 123 */             .setEmptyBulletSubItemInterruptsItemParagraph(true)
/* 124 */             .setEmptyOrderedSubItemInterruptsItemParagraph(true)
/* 125 */             .setEmptyOrderedNonOneSubItemInterruptsItemParagraph(true));
/*     */       }
/*     */ 
/*     */       
/* 129 */       return (new MutableListOptions()).setParserEmulationFamily(this)
/* 130 */         .setAutoLoose(false)
/* 131 */         .setAutoLooseOneLevelLists(false)
/* 132 */         .setLooseWhenBlankLineFollowsItemParagraph(false)
/* 133 */         .setLooseWhenHasLooseSubItem(false)
/* 134 */         .setLooseWhenHasTrailingBlankLine(true)
/* 135 */         .setLooseWhenPrevHasTrailingBlankLine(false)
/* 136 */         .setLooseWhenLastItemPrevHasTrailingBlankLine(true)
/* 137 */         .setOrderedListManualStart(false)
/* 138 */         .setDelimiterMismatchToNewList(false)
/* 139 */         .setItemTypeMismatchToNewList(false)
/* 140 */         .setItemTypeMismatchToSubList(false)
/* 141 */         .setEndOnDoubleBlank(false)
/* 142 */         .setOrderedItemDotOnly(true)
/* 143 */         .setItemMarkerSpace(true)
/* 144 */         .setItemIndent(4)
/* 145 */         .setCodeIndent(8)
/* 146 */         .setNewItemCodeIndent(2147483647)
/* 147 */         .setItemInterrupt((new ListOptions.MutableItemInterrupt())
/* 148 */           .setBulletItemInterruptsParagraph(false)
/* 149 */           .setOrderedItemInterruptsParagraph(false)
/* 150 */           .setOrderedNonOneItemInterruptsParagraph(false)
/*     */           
/* 152 */           .setEmptyBulletItemInterruptsParagraph(false)
/* 153 */           .setEmptyOrderedItemInterruptsParagraph(false)
/* 154 */           .setEmptyOrderedNonOneItemInterruptsParagraph(false)
/*     */           
/* 156 */           .setBulletItemInterruptsItemParagraph(true)
/* 157 */           .setOrderedItemInterruptsItemParagraph(true)
/* 158 */           .setOrderedNonOneItemInterruptsItemParagraph(true)
/*     */           
/* 160 */           .setEmptyBulletItemInterruptsItemParagraph(true)
/* 161 */           .setEmptyOrderedItemInterruptsItemParagraph(true)
/* 162 */           .setEmptyOrderedNonOneItemInterruptsItemParagraph(true)
/*     */           
/* 164 */           .setEmptyBulletSubItemInterruptsItemParagraph(true)
/* 165 */           .setEmptyOrderedSubItemInterruptsItemParagraph(true)
/* 166 */           .setEmptyOrderedNonOneSubItemInterruptsItemParagraph(true));
/*     */     } 
/*     */ 
/*     */     
/* 170 */     if (this.family == KRAMDOWN) {
/* 171 */       return (new MutableListOptions())
/* 172 */         .setParserEmulationFamily(this)
/* 173 */         .setAutoLoose(false)
/* 174 */         .setLooseWhenBlankLineFollowsItemParagraph(true)
/* 175 */         .setLooseWhenHasLooseSubItem(false)
/* 176 */         .setLooseWhenHasTrailingBlankLine(false)
/* 177 */         .setLooseWhenPrevHasTrailingBlankLine(false)
/* 178 */         .setOrderedListManualStart(false)
/* 179 */         .setDelimiterMismatchToNewList(false)
/* 180 */         .setItemTypeMismatchToNewList(true)
/* 181 */         .setItemTypeMismatchToSubList(true)
/* 182 */         .setOrderedItemDotOnly(true)
/* 183 */         .setItemMarkerSpace(true)
/* 184 */         .setEndOnDoubleBlank(false)
/* 185 */         .setItemIndent(4)
/* 186 */         .setCodeIndent(8)
/* 187 */         .setNewItemCodeIndent(2147483647)
/* 188 */         .setItemInterrupt((new ListOptions.MutableItemInterrupt())
/* 189 */           .setBulletItemInterruptsParagraph(false)
/* 190 */           .setOrderedItemInterruptsParagraph(false)
/* 191 */           .setOrderedNonOneItemInterruptsParagraph(false)
/*     */           
/* 193 */           .setEmptyBulletItemInterruptsParagraph(false)
/* 194 */           .setEmptyOrderedItemInterruptsParagraph(false)
/* 195 */           .setEmptyOrderedNonOneItemInterruptsParagraph(false)
/*     */           
/* 197 */           .setBulletItemInterruptsItemParagraph(true)
/* 198 */           .setOrderedItemInterruptsItemParagraph(true)
/* 199 */           .setOrderedNonOneItemInterruptsItemParagraph(true)
/*     */           
/* 201 */           .setEmptyBulletItemInterruptsItemParagraph(true)
/* 202 */           .setEmptyOrderedItemInterruptsItemParagraph(true)
/* 203 */           .setEmptyOrderedNonOneItemInterruptsItemParagraph(true)
/*     */           
/* 205 */           .setEmptyBulletSubItemInterruptsItemParagraph(false)
/* 206 */           .setEmptyOrderedSubItemInterruptsItemParagraph(false)
/* 207 */           .setEmptyOrderedNonOneSubItemInterruptsItemParagraph(false));
/*     */     }
/*     */     
/* 210 */     if (this.family == MARKDOWN) {
/* 211 */       if (this == GITHUB_DOC) {
/* 212 */         return (new MutableListOptions())
/* 213 */           .setParserEmulationFamily(this)
/* 214 */           .setAutoLoose(false)
/* 215 */           .setLooseWhenBlankLineFollowsItemParagraph(true)
/* 216 */           .setLooseWhenHasLooseSubItem(true)
/* 217 */           .setLooseWhenHasTrailingBlankLine(true)
/* 218 */           .setLooseWhenPrevHasTrailingBlankLine(true)
/* 219 */           .setLooseWhenContainsBlankLine(false)
/* 220 */           .setLooseWhenHasNonListChildren(true)
/* 221 */           .setOrderedListManualStart(false)
/* 222 */           .setDelimiterMismatchToNewList(false)
/* 223 */           .setItemTypeMismatchToNewList(false)
/* 224 */           .setItemTypeMismatchToSubList(false)
/* 225 */           .setEndOnDoubleBlank(false)
/* 226 */           .setOrderedItemDotOnly(true)
/* 227 */           .setItemMarkerSpace(true)
/* 228 */           .setItemIndent(4)
/* 229 */           .setCodeIndent(8)
/* 230 */           .setNewItemCodeIndent(2147483647)
/* 231 */           .setItemInterrupt((new ListOptions.MutableItemInterrupt())
/* 232 */             .setBulletItemInterruptsParagraph(true)
/* 233 */             .setOrderedItemInterruptsParagraph(false)
/* 234 */             .setOrderedNonOneItemInterruptsParagraph(false)
/*     */             
/* 236 */             .setEmptyBulletItemInterruptsParagraph(true)
/* 237 */             .setEmptyOrderedItemInterruptsParagraph(false)
/* 238 */             .setEmptyOrderedNonOneItemInterruptsParagraph(false)
/*     */             
/* 240 */             .setBulletItemInterruptsItemParagraph(true)
/* 241 */             .setOrderedItemInterruptsItemParagraph(true)
/* 242 */             .setOrderedNonOneItemInterruptsItemParagraph(true)
/*     */             
/* 244 */             .setEmptyBulletItemInterruptsItemParagraph(true)
/* 245 */             .setEmptyOrderedItemInterruptsItemParagraph(true)
/* 246 */             .setEmptyOrderedNonOneItemInterruptsItemParagraph(true)
/*     */             
/* 248 */             .setEmptyBulletSubItemInterruptsItemParagraph(true)
/* 249 */             .setEmptyOrderedSubItemInterruptsItemParagraph(true)
/* 250 */             .setEmptyOrderedNonOneSubItemInterruptsItemParagraph(true));
/*     */       }
/*     */       
/* 253 */       return (new MutableListOptions())
/* 254 */         .setParserEmulationFamily(this)
/* 255 */         .setAutoLoose(false)
/* 256 */         .setLooseWhenBlankLineFollowsItemParagraph(true)
/* 257 */         .setLooseWhenHasLooseSubItem(true)
/* 258 */         .setLooseWhenHasTrailingBlankLine(true)
/* 259 */         .setLooseWhenPrevHasTrailingBlankLine(true)
/* 260 */         .setLooseWhenContainsBlankLine(true)
/* 261 */         .setOrderedListManualStart(false)
/* 262 */         .setDelimiterMismatchToNewList(false)
/* 263 */         .setItemTypeMismatchToNewList(false)
/* 264 */         .setItemTypeMismatchToSubList(false)
/* 265 */         .setEndOnDoubleBlank(false)
/* 266 */         .setOrderedItemDotOnly(true)
/* 267 */         .setItemMarkerSpace(true)
/* 268 */         .setItemIndent(4)
/* 269 */         .setCodeIndent(8)
/* 270 */         .setNewItemCodeIndent(2147483647)
/* 271 */         .setItemInterrupt((new ListOptions.MutableItemInterrupt())
/* 272 */           .setBulletItemInterruptsParagraph(false)
/* 273 */           .setOrderedItemInterruptsParagraph(false)
/* 274 */           .setOrderedNonOneItemInterruptsParagraph(false)
/*     */           
/* 276 */           .setEmptyBulletItemInterruptsParagraph(false)
/* 277 */           .setEmptyOrderedItemInterruptsParagraph(false)
/* 278 */           .setEmptyOrderedNonOneItemInterruptsParagraph(false)
/*     */           
/* 280 */           .setBulletItemInterruptsItemParagraph(true)
/* 281 */           .setOrderedItemInterruptsItemParagraph(true)
/* 282 */           .setOrderedNonOneItemInterruptsItemParagraph(true)
/*     */           
/* 284 */           .setEmptyBulletItemInterruptsItemParagraph(false)
/* 285 */           .setEmptyOrderedItemInterruptsItemParagraph(false)
/* 286 */           .setEmptyOrderedNonOneItemInterruptsItemParagraph(false)
/*     */           
/* 288 */           .setEmptyBulletSubItemInterruptsItemParagraph(true)
/* 289 */           .setEmptyOrderedSubItemInterruptsItemParagraph(true)
/* 290 */           .setEmptyOrderedNonOneSubItemInterruptsItemParagraph(true));
/*     */     } 
/*     */ 
/*     */     
/* 294 */     if (this.family == COMMONMARK && 
/* 295 */       this == COMMONMARK_0_26) {
/* 296 */       return (new MutableListOptions((DataHolder)null)).setEndOnDoubleBlank(true);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 305 */     return new MutableListOptions((DataHolder)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final MutableDataHolder setIn(MutableDataHolder paramMutableDataHolder) {
/* 311 */     if (this == FIXED_INDENT) {
/* 312 */       getOptions((DataHolder)paramMutableDataHolder).setIn(paramMutableDataHolder)
/* 313 */         .set(Parser.STRONG_WRAPS_EMPHASIS, Boolean.TRUE)
/* 314 */         .set(Parser.LINKS_ALLOW_MATCHED_PARENTHESES, Boolean.FALSE);
/*     */     }
/* 316 */     else if (this == KRAMDOWN) {
/* 317 */       getOptions((DataHolder)paramMutableDataHolder).setIn(paramMutableDataHolder);
/* 318 */       paramMutableDataHolder
/* 319 */         .set(Parser.HEADING_NO_LEAD_SPACE, Boolean.TRUE)
/* 320 */         .set(Parser.BLOCK_QUOTE_INTERRUPTS_PARAGRAPH, Boolean.FALSE)
/* 321 */         .set(HtmlRenderer.RENDER_HEADER_ID, Boolean.TRUE)
/* 322 */         .set(HtmlRenderer.SOFT_BREAK, " ")
/*     */ 
/*     */         
/* 325 */         .set(Parser.HTML_BLOCK_DEEP_PARSER, Boolean.TRUE)
/* 326 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_NON_BLOCK, Boolean.TRUE)
/* 327 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_FIRST_OPEN_TAG_ON_ONE_LINE, Boolean.FALSE)
/* 328 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS, Boolean.FALSE)
/* 329 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_MARKDOWN_INTERRUPTS_CLOSED, Boolean.TRUE)
/* 330 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS_PARTIAL_TAG, Boolean.FALSE)
/* 331 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_INDENTED_CODE_INTERRUPTS, Boolean.TRUE)
/* 332 */         .set(Parser.STRONG_WRAPS_EMPHASIS, Boolean.TRUE)
/* 333 */         .set(Parser.LINKS_ALLOW_MATCHED_PARENTHESES, Boolean.FALSE);
/*     */     }
/* 335 */     else if (this == MARKDOWN) {
/* 336 */       getOptions((DataHolder)paramMutableDataHolder).setIn(paramMutableDataHolder);
/* 337 */       paramMutableDataHolder
/* 338 */         .set(Parser.HEADING_NO_LEAD_SPACE, Boolean.TRUE)
/* 339 */         .set(Parser.BLOCK_QUOTE_IGNORE_BLANK_LINE, Boolean.TRUE)
/* 340 */         .set(HtmlRenderer.SOFT_BREAK, " ")
/*     */ 
/*     */         
/* 343 */         .set(Parser.HTML_BLOCK_DEEP_PARSER, Boolean.TRUE)
/* 344 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_NON_BLOCK, Boolean.TRUE)
/* 345 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_FIRST_OPEN_TAG_ON_ONE_LINE, Boolean.FALSE)
/* 346 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS, Boolean.FALSE)
/* 347 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_MARKDOWN_INTERRUPTS_CLOSED, Boolean.TRUE)
/* 348 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS_PARTIAL_TAG, Boolean.FALSE)
/* 349 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_INDENTED_CODE_INTERRUPTS, Boolean.TRUE)
/* 350 */         .set(Parser.STRONG_WRAPS_EMPHASIS, Boolean.TRUE)
/* 351 */         .set(Parser.LINKS_ALLOW_MATCHED_PARENTHESES, Boolean.FALSE);
/*     */     }
/* 353 */     else if (this == GITHUB_DOC) {
/* 354 */       getOptions((DataHolder)paramMutableDataHolder).setIn(paramMutableDataHolder);
/* 355 */       paramMutableDataHolder
/* 356 */         .set(Parser.BLOCK_QUOTE_IGNORE_BLANK_LINE, Boolean.TRUE)
/* 357 */         .set(Parser.BLOCK_QUOTE_INTERRUPTS_PARAGRAPH, Boolean.TRUE)
/* 358 */         .set(Parser.BLOCK_QUOTE_INTERRUPTS_ITEM_PARAGRAPH, Boolean.FALSE)
/* 359 */         .set(Parser.HEADING_NO_LEAD_SPACE, Boolean.TRUE)
/*     */ 
/*     */         
/* 362 */         .set(Parser.HTML_BLOCK_DEEP_PARSER, Boolean.TRUE)
/* 363 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_NON_BLOCK, Boolean.TRUE)
/* 364 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_FIRST_OPEN_TAG_ON_ONE_LINE, Boolean.FALSE)
/* 365 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS, Boolean.TRUE)
/* 366 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_MARKDOWN_INTERRUPTS_CLOSED, Boolean.TRUE)
/* 367 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS_PARTIAL_TAG, Boolean.FALSE)
/* 368 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_INDENTED_CODE_INTERRUPTS, Boolean.FALSE)
/* 369 */         .set(Parser.STRONG_WRAPS_EMPHASIS, Boolean.TRUE)
/* 370 */         .set(Parser.LINKS_ALLOW_MATCHED_PARENTHESES, Boolean.FALSE)
/*     */ 
/*     */         
/* 373 */         .set(HtmlRenderer.HEADER_ID_GENERATOR_TO_DASH_CHARS, " -")
/* 374 */         .set(HtmlRenderer.HEADER_ID_GENERATOR_NON_DASH_CHARS, "_")
/* 375 */         .set(HtmlRenderer.HEADER_ID_GENERATOR_NON_ASCII_TO_LOWERCASE, Boolean.FALSE);
/*     */     }
/* 377 */     else if (this == GITHUB) {
/* 378 */       getOptions((DataHolder)paramMutableDataHolder).setIn(paramMutableDataHolder);
/* 379 */       paramMutableDataHolder
/*     */         
/* 381 */         .set(HtmlRenderer.HEADER_ID_GENERATOR_TO_DASH_CHARS, " -")
/* 382 */         .set(HtmlRenderer.HEADER_ID_GENERATOR_NON_DASH_CHARS, "_")
/* 383 */         .set(HtmlRenderer.HEADER_ID_GENERATOR_NON_ASCII_TO_LOWERCASE, Boolean.FALSE)
/*     */ 
/*     */         
/* 386 */         .set(HtmlRenderer.HEADER_ID_REF_TEXT_TRIM_TRAILING_SPACES, Boolean.FALSE)
/*     */         
/* 388 */         .set(HtmlRenderer.HEADER_ID_ADD_EMOJI_SHORTCUT, Boolean.TRUE);
/*     */     }
/* 390 */     else if (this == MULTI_MARKDOWN) {
/* 391 */       getOptions((DataHolder)paramMutableDataHolder).setIn(paramMutableDataHolder);
/* 392 */       paramMutableDataHolder
/* 393 */         .set(Parser.BLOCK_QUOTE_IGNORE_BLANK_LINE, Boolean.TRUE)
/* 394 */         .set(Parser.BLOCK_QUOTE_WITH_LEAD_SPACES_INTERRUPTS_ITEM_PARAGRAPH, Boolean.FALSE)
/* 395 */         .set(HtmlRenderer.RENDER_HEADER_ID, Boolean.TRUE)
/* 396 */         .set(HtmlRenderer.HEADER_ID_GENERATOR_RESOLVE_DUPES, Boolean.FALSE)
/* 397 */         .set(HtmlRenderer.HEADER_ID_GENERATOR_TO_DASH_CHARS, "")
/* 398 */         .set(HtmlRenderer.HEADER_ID_GENERATOR_NO_DUPED_DASHES, Boolean.TRUE)
/* 399 */         .set(HtmlRenderer.SOFT_BREAK, " ")
/*     */ 
/*     */         
/* 402 */         .set(Parser.HTML_BLOCK_DEEP_PARSER, Boolean.TRUE)
/* 403 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_NON_BLOCK, Boolean.TRUE)
/* 404 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_FIRST_OPEN_TAG_ON_ONE_LINE, Boolean.FALSE)
/* 405 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS, Boolean.FALSE)
/* 406 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_MARKDOWN_INTERRUPTS_CLOSED, Boolean.TRUE)
/* 407 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS_PARTIAL_TAG, Boolean.FALSE)
/* 408 */         .set(Parser.HTML_BLOCK_DEEP_PARSE_INDENTED_CODE_INTERRUPTS, Boolean.TRUE)
/* 409 */         .set(Parser.STRONG_WRAPS_EMPHASIS, Boolean.TRUE)
/* 410 */         .set(Parser.LINKS_ALLOW_MATCHED_PARENTHESES, Boolean.FALSE);
/*     */     }
/* 412 */     else if (this == PEGDOWN || this == PEGDOWN_STRICT) {
/* 413 */       int i = ((Integer)PEGDOWN_EXTENSIONS.get((DataHolder)paramMutableDataHolder)).intValue();
/*     */       
/* 415 */       getOptions((DataHolder)paramMutableDataHolder).setIn(paramMutableDataHolder);
/* 416 */       paramMutableDataHolder
/* 417 */         .set(Parser.BLOCK_QUOTE_EXTEND_TO_BLANK_LINE, Boolean.TRUE)
/* 418 */         .set(Parser.BLOCK_QUOTE_IGNORE_BLANK_LINE, Boolean.TRUE)
/* 419 */         .set(Parser.BLOCK_QUOTE_ALLOW_LEADING_SPACE, Boolean.FALSE)
/* 420 */         .set(Parser.INDENTED_CODE_NO_TRAILING_BLANK_LINES, Boolean.TRUE)
/* 421 */         .set(Parser.HEADING_SETEXT_MARKER_LENGTH, Integer.valueOf(3))
/* 422 */         .set(Parser.HEADING_NO_LEAD_SPACE, Boolean.TRUE)
/* 423 */         .set(Parser.REFERENCES_KEEP, KeepType.LAST)
/* 424 */         .set(Parser.PARSE_INNER_HTML_COMMENTS, Boolean.TRUE)
/* 425 */         .set(Parser.SPACE_IN_LINK_ELEMENTS, Boolean.TRUE)
/*     */         
/* 427 */         .set(HtmlRenderer.OBFUSCATE_EMAIL, Boolean.TRUE)
/* 428 */         .set(HtmlRenderer.GENERATE_HEADER_ID, Boolean.TRUE)
/*     */         
/* 430 */         .set(HtmlRenderer.HEADER_ID_GENERATOR_NO_DUPED_DASHES, Boolean.TRUE)
/* 431 */         .set(HtmlRenderer.HEADER_ID_GENERATOR_RESOLVE_DUPES, Boolean.FALSE)
/* 432 */         .set(HtmlRenderer.SOFT_BREAK, " ")
/* 433 */         .set(Parser.STRONG_WRAPS_EMPHASIS, Boolean.TRUE)
/* 434 */         .set(Parser.LINKS_ALLOW_MATCHED_PARENTHESES, Boolean.FALSE);
/*     */ 
/*     */       
/* 437 */       if (haveAny(i, 1024)) {
/* 438 */         paramMutableDataHolder.set(HtmlRenderer.RENDER_HEADER_ID, Boolean.FALSE);
/*     */       }
/*     */       
/* 441 */       if (this == PEGDOWN_STRICT) {
/*     */         
/* 443 */         paramMutableDataHolder
/* 444 */           .set(Parser.HTML_BLOCK_DEEP_PARSER, Boolean.TRUE)
/* 445 */           .set(Parser.HTML_BLOCK_DEEP_PARSE_NON_BLOCK, Boolean.TRUE)
/* 446 */           .set(Parser.HTML_BLOCK_DEEP_PARSE_FIRST_OPEN_TAG_ON_ONE_LINE, Boolean.FALSE)
/* 447 */           .set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS, Boolean.FALSE)
/* 448 */           .set(Parser.HTML_BLOCK_DEEP_PARSE_MARKDOWN_INTERRUPTS_CLOSED, Boolean.TRUE)
/* 449 */           .set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS_PARTIAL_TAG, Boolean.FALSE)
/* 450 */           .set(Parser.HTML_BLOCK_DEEP_PARSE_INDENTED_CODE_INTERRUPTS, Boolean.FALSE);
/*     */       } else {
/*     */         
/* 453 */         paramMutableDataHolder
/* 454 */           .set(Parser.HTML_BLOCK_DEEP_PARSER, Boolean.TRUE)
/* 455 */           .set(Parser.HTML_BLOCK_DEEP_PARSE_NON_BLOCK, Boolean.TRUE)
/* 456 */           .set(Parser.HTML_BLOCK_DEEP_PARSE_FIRST_OPEN_TAG_ON_ONE_LINE, Boolean.FALSE)
/* 457 */           .set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS, Boolean.TRUE)
/* 458 */           .set(Parser.HTML_BLOCK_DEEP_PARSE_MARKDOWN_INTERRUPTS_CLOSED, Boolean.TRUE)
/* 459 */           .set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS_PARTIAL_TAG, Boolean.FALSE)
/* 460 */           .set(Parser.HTML_BLOCK_DEEP_PARSE_INDENTED_CODE_INTERRUPTS, Boolean.FALSE);
/*     */       }
/*     */     
/* 463 */     } else if (this == COMMONMARK_0_26 || this == COMMONMARK_0_27) {
/*     */       
/* 465 */       paramMutableDataHolder.set(Parser.STRONG_WRAPS_EMPHASIS, Boolean.TRUE);
/* 466 */       paramMutableDataHolder.set(Parser.LINKS_ALLOW_MATCHED_PARENTHESES, Boolean.FALSE);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 472 */     return paramMutableDataHolder;
/*     */   }
/*     */   
/*     */   public static boolean haveAny(int paramInt1, int paramInt2) {
/* 476 */     return ((paramInt1 & paramInt2) != 0);
/*     */   }
/*     */   
/*     */   public static boolean haveAll(int paramInt1, int paramInt2) {
/* 480 */     return ((paramInt1 & paramInt2) == paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\ParserEmulationProfile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */