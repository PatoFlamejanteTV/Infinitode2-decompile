/*     */ package com.vladsch.flexmark.parser.internal;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class HtmlDeepParser {
/*     */   public enum HtmlMatch {
/*   9 */     NONE(null, null, false),
/*  10 */     SCRIPT("<(script)(?:\\s|>|$)", "</script>", true),
/*  11 */     STYLE("<(style)(?:\\s|>|$)", "</style>", true),
/*  12 */     OPEN_TAG("<([A-Za-z][A-Za-z0-9-]*)", "<|/>|\\s/>|>", true),
/*  13 */     CLOSE_TAG("</([A-Za-z][A-Za-z0-9-]*)>", null, true),
/*  14 */     NON_TAG("<(![A-Z])", ">", false),
/*  15 */     TEMPLATE("<([?])", "\\?>", false),
/*  16 */     COMMENT("<(!--)", "-->", false),
/*  17 */     CDATA("<!\\[(CDATA)\\[", "\\]\\]>", false);
/*     */     
/*     */     public final Pattern open;
/*     */     
/*     */     public final Pattern close;
/*     */     public final boolean caseInsentive;
/*     */     
/*     */     HtmlMatch(String param1String1, String param1String2, boolean param1Boolean) {
/*  25 */       this.open = (param1String1 == null) ? null : Pattern.compile(param1String1, param1Boolean ? 2 : 0);
/*  26 */       this.close = (param1String2 == null) ? null : Pattern.compile(param1String2, param1Boolean ? 2 : 0);
/*  27 */       this.caseInsentive = param1Boolean;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  37 */   public static final Set<String> BLOCK_TAGS = new HashSet<>();
/*  38 */   public static final Set<String> VOID_TAGS = new HashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Map<String, Set<String>> OPTIONAL_TAGS;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Pattern START_PATTERN;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  54 */     String[] arrayOfString = "address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|meta|nav|noframes|ol|optgroup|option|p|param|pre|section|source|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul".split("\\|");
/*  55 */     BLOCK_TAGS.addAll(Arrays.asList(arrayOfString));
/*     */     
/*  57 */     arrayOfString = "area|base|br|col|embed|hr|img|input|keygen|link|menuitem|meta|param|source|track|wbr".split("\\|");
/*  58 */     VOID_TAGS.addAll(Arrays.asList(arrayOfString));
/*     */ 
/*     */     
/*  61 */     (OPTIONAL_TAGS = new HashMap<>()).put("li", new HashSet<>(Arrays.asList(new String[] { "li" })));
/*  62 */     OPTIONAL_TAGS.put("dt", new HashSet<>(Arrays.asList(new String[] { "dt", "dd" })));
/*  63 */     OPTIONAL_TAGS.put("dd", new HashSet<>(Arrays.asList(new String[] { "dd", "dt" })));
/*  64 */     OPTIONAL_TAGS.put("p", new HashSet<>(Arrays.asList(new String[] { "address", "article", "aside", "blockquote", "details", "div", "dl", "fieldset", "figcaption", "figure", "footer", "form", "h1", "h2", "h3", "h4", "h5", "h6", "header", "hr", "main", "menu", "nav", "ol", "p", "pre", "section", "table", "ul" })));
/*  65 */     OPTIONAL_TAGS.put("rt", new HashSet<>(Arrays.asList(new String[] { "rt", "rp" })));
/*  66 */     OPTIONAL_TAGS.put("rp", new HashSet<>(Arrays.asList(new String[] { "rt", "rp" })));
/*  67 */     OPTIONAL_TAGS.put("optgroup", new HashSet<>(Arrays.asList(new String[] { "optgroup" })));
/*  68 */     OPTIONAL_TAGS.put("option", new HashSet<>(Arrays.asList(new String[] { "option", "optgroup" })));
/*  69 */     OPTIONAL_TAGS.put("colgroup", new HashSet<>(Arrays.asList(new String[] { "colgroup" })));
/*  70 */     OPTIONAL_TAGS.put("thead", new HashSet<>(Arrays.asList(new String[] { "tbody", "tfoot" })));
/*  71 */     OPTIONAL_TAGS.put("tbody", new HashSet<>(Arrays.asList(new String[] { "tbody", "tfoot" })));
/*  72 */     OPTIONAL_TAGS.put("tfoot", new HashSet<>(Arrays.asList(new String[] { "tbody" })));
/*  73 */     OPTIONAL_TAGS.put("tr", new HashSet<>(Arrays.asList(new String[] { "tr" })));
/*  74 */     OPTIONAL_TAGS.put("td", new HashSet<>(Arrays.asList(new String[] { "td", "th" })));
/*  75 */     OPTIONAL_TAGS.put("th", new HashSet<>(Arrays.asList(new String[] { "td", "th" })));
/*     */   }
/*     */   
/*  78 */   private static final HtmlMatch[] PATTERN_MAP = new HtmlMatch[(HtmlMatch.values()).length]; private final ArrayList<String> myOpenTags; private Pattern myClosingPattern; private HtmlMatch myHtmlMatch; static {
/*  79 */     StringBuilder stringBuilder = new StringBuilder();
/*  80 */     byte b1 = 0; HtmlMatch[] arrayOfHtmlMatch; int i; byte b2;
/*  81 */     for (i = (arrayOfHtmlMatch = HtmlMatch.values()).length, b2 = 0; b2 < i; b2++) {
/*  82 */       HtmlMatch htmlMatch; if ((htmlMatch = arrayOfHtmlMatch[b2]) != HtmlMatch.NONE) {
/*  83 */         if (stringBuilder.length() != 0) stringBuilder.append("|"); 
/*  84 */         if (htmlMatch.caseInsentive) {
/*  85 */           stringBuilder.append("(?i:");
/*  86 */           stringBuilder.append(htmlMatch.open.pattern());
/*  87 */           stringBuilder.append(")");
/*     */         } else {
/*  89 */           stringBuilder.append(htmlMatch.open.pattern());
/*     */         } 
/*  91 */         PATTERN_MAP[b1] = htmlMatch;
/*     */       } 
/*  93 */       b1++;
/*     */     } 
/*     */     
/*  96 */     START_PATTERN = Pattern.compile(stringBuilder.toString());
/*     */   }
/*     */ 
/*     */   
/*     */   private int myHtmlCount;
/*     */   
/*     */   private final HashSet<String> myBlockTags;
/*     */   
/*     */   private boolean myFirstBlockTag;
/*     */   
/*     */   public HtmlDeepParser() {
/* 107 */     this(Collections.emptyList());
/*     */   }
/*     */   
/*     */   public HtmlDeepParser(List<String> paramList) {
/* 111 */     this.myOpenTags = new ArrayList<>();
/* 112 */     this.myClosingPattern = null;
/* 113 */     this.myHtmlMatch = null;
/* 114 */     this.myHtmlCount = 0;
/* 115 */     this.myFirstBlockTag = false;
/*     */     
/* 117 */     this.myBlockTags = new HashSet<>(BLOCK_TAGS);
/* 118 */     this.myBlockTags.addAll(paramList);
/*     */   }
/*     */   
/*     */   public ArrayList<String> getOpenTags() {
/* 122 */     return this.myOpenTags;
/*     */   }
/*     */   
/*     */   public Pattern getClosingPattern() {
/* 126 */     return this.myClosingPattern;
/*     */   }
/*     */   
/*     */   public HtmlMatch getHtmlMatch() {
/* 130 */     return this.myHtmlMatch;
/*     */   }
/*     */   
/*     */   public int getHtmlCount() {
/* 134 */     return this.myHtmlCount;
/*     */   }
/*     */   
/*     */   public boolean isFirstBlockTag() {
/* 138 */     return this.myFirstBlockTag;
/*     */   }
/*     */   
/*     */   public boolean isHtmlClosed() {
/* 142 */     return (this.myClosingPattern == null && this.myOpenTags.isEmpty());
/*     */   }
/*     */   
/*     */   public boolean isBlankLineInterruptible() {
/* 146 */     return ((this.myOpenTags.isEmpty() && this.myClosingPattern == null) || (this.myHtmlMatch == HtmlMatch.OPEN_TAG && this.myClosingPattern != null && this.myOpenTags.size() == 1));
/*     */   }
/*     */   
/*     */   public boolean haveOpenRawTag() {
/* 150 */     return (this.myClosingPattern != null && this.myHtmlMatch != HtmlMatch.OPEN_TAG);
/*     */   }
/*     */   
/*     */   public boolean haveOpenBlockTag() {
/* 154 */     if (!this.myOpenTags.isEmpty()) {
/* 155 */       for (String str : this.myOpenTags) {
/* 156 */         if (this.myBlockTags.contains(str)) {
/* 157 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/* 161 */     return false;
/*     */   }
/*     */   
/*     */   public boolean hadHtml() {
/* 165 */     return (this.myHtmlCount > 0 || !isHtmlClosed());
/*     */   }
/*     */ 
/*     */   
/*     */   private void openTag(String paramString) {
/* 170 */     if (!this.myOpenTags.isEmpty()) {
/* 171 */       String str = this.myOpenTags.get(this.myOpenTags.size() - 1);
/*     */       
/* 173 */       if (OPTIONAL_TAGS.containsKey(str) && (
/* 174 */         (Set)OPTIONAL_TAGS.get(str)).contains(paramString)) {
/* 175 */         this.myOpenTags.set(this.myOpenTags.size() - 1, paramString);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 180 */     this.myOpenTags.add(paramString);
/* 181 */     this.myFirstBlockTag = this.myBlockTags.contains(paramString);
/*     */   }
/*     */   
/*     */   public void parseHtmlChunk(CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield myHtmlCount : I
/*     */     //   4: ifne -> 24
/*     */     //   7: aload_0
/*     */     //   8: getfield myHtmlMatch : Lcom/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch;
/*     */     //   11: ifnull -> 24
/*     */     //   14: aload_0
/*     */     //   15: dup
/*     */     //   16: getfield myHtmlCount : I
/*     */     //   19: iconst_1
/*     */     //   20: iadd
/*     */     //   21: putfield myHtmlCount : I
/*     */     //   24: aconst_null
/*     */     //   25: astore #5
/*     */     //   27: iload #4
/*     */     //   29: istore #4
/*     */     //   31: aload_1
/*     */     //   32: invokeinterface length : ()I
/*     */     //   37: ifeq -> 696
/*     */     //   40: aload_0
/*     */     //   41: getfield myClosingPattern : Ljava/util/regex/Pattern;
/*     */     //   44: ifnull -> 260
/*     */     //   47: aload_0
/*     */     //   48: getfield myClosingPattern : Ljava/util/regex/Pattern;
/*     */     //   51: aload_1
/*     */     //   52: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   55: dup
/*     */     //   56: astore #6
/*     */     //   58: invokevirtual find : ()Z
/*     */     //   61: ifeq -> 696
/*     */     //   64: aload_0
/*     */     //   65: getfield myHtmlMatch : Lcom/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch;
/*     */     //   68: getstatic com/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch.OPEN_TAG : Lcom/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch;
/*     */     //   71: if_acmpne -> 231
/*     */     //   74: aload #6
/*     */     //   76: invokevirtual group : ()Ljava/lang/String;
/*     */     //   79: ldc '<'
/*     */     //   81: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   84: ifeq -> 128
/*     */     //   87: aload #5
/*     */     //   89: ifnonnull -> 112
/*     */     //   92: aload_0
/*     */     //   93: getfield myOpenTags : Ljava/util/ArrayList;
/*     */     //   96: aload_0
/*     */     //   97: getfield myOpenTags : Ljava/util/ArrayList;
/*     */     //   100: invokevirtual size : ()I
/*     */     //   103: iconst_1
/*     */     //   104: isub
/*     */     //   105: invokevirtual remove : (I)Ljava/lang/Object;
/*     */     //   108: pop
/*     */     //   109: goto -> 249
/*     */     //   112: iload #4
/*     */     //   114: ifeq -> 249
/*     */     //   117: aconst_null
/*     */     //   118: astore #5
/*     */     //   120: aload_0
/*     */     //   121: aconst_null
/*     */     //   122: putfield myClosingPattern : Ljava/util/regex/Pattern;
/*     */     //   125: goto -> 696
/*     */     //   128: iconst_0
/*     */     //   129: istore #4
/*     */     //   131: aload #6
/*     */     //   133: invokevirtual group : ()Ljava/lang/String;
/*     */     //   136: ldc '/>'
/*     */     //   138: invokevirtual endsWith : (Ljava/lang/String;)Z
/*     */     //   141: ifeq -> 176
/*     */     //   144: aload #5
/*     */     //   146: ifnonnull -> 166
/*     */     //   149: aload_0
/*     */     //   150: getfield myOpenTags : Ljava/util/ArrayList;
/*     */     //   153: aload_0
/*     */     //   154: getfield myOpenTags : Ljava/util/ArrayList;
/*     */     //   157: invokevirtual size : ()I
/*     */     //   160: iconst_1
/*     */     //   161: isub
/*     */     //   162: invokevirtual remove : (I)Ljava/lang/Object;
/*     */     //   165: pop
/*     */     //   166: aload_0
/*     */     //   167: getfield myHtmlCount : I
/*     */     //   170: ifne -> 210
/*     */     //   173: goto -> 200
/*     */     //   176: aload #5
/*     */     //   178: ifnull -> 210
/*     */     //   181: getstatic com/vladsch/flexmark/parser/internal/HtmlDeepParser.VOID_TAGS : Ljava/util/Set;
/*     */     //   184: aload #5
/*     */     //   186: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */     //   191: ifne -> 200
/*     */     //   194: aload_0
/*     */     //   195: aload #5
/*     */     //   197: invokespecial openTag : (Ljava/lang/String;)V
/*     */     //   200: aload_0
/*     */     //   201: dup
/*     */     //   202: getfield myHtmlCount : I
/*     */     //   205: iconst_1
/*     */     //   206: iadd
/*     */     //   207: putfield myHtmlCount : I
/*     */     //   210: aload_1
/*     */     //   211: aload #6
/*     */     //   213: invokevirtual end : ()I
/*     */     //   216: aload_1
/*     */     //   217: invokeinterface length : ()I
/*     */     //   222: invokeinterface subSequence : (II)Ljava/lang/CharSequence;
/*     */     //   227: astore_1
/*     */     //   228: goto -> 249
/*     */     //   231: aload_1
/*     */     //   232: aload #6
/*     */     //   234: invokevirtual end : ()I
/*     */     //   237: aload_1
/*     */     //   238: invokeinterface length : ()I
/*     */     //   243: invokeinterface subSequence : (II)Ljava/lang/CharSequence;
/*     */     //   248: astore_1
/*     */     //   249: aconst_null
/*     */     //   250: astore #5
/*     */     //   252: aload_0
/*     */     //   253: aconst_null
/*     */     //   254: putfield myClosingPattern : Ljava/util/regex/Pattern;
/*     */     //   257: goto -> 31
/*     */     //   260: getstatic com/vladsch/flexmark/parser/internal/HtmlDeepParser.START_PATTERN : Ljava/util/regex/Pattern;
/*     */     //   263: aload_1
/*     */     //   264: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   267: dup
/*     */     //   268: astore #6
/*     */     //   270: invokevirtual find : ()Z
/*     */     //   273: ifeq -> 696
/*     */     //   276: aload_1
/*     */     //   277: aload #6
/*     */     //   279: invokevirtual end : ()I
/*     */     //   282: aload_1
/*     */     //   283: invokeinterface length : ()I
/*     */     //   288: invokeinterface subSequence : (II)Ljava/lang/CharSequence;
/*     */     //   293: astore #7
/*     */     //   295: getstatic com/vladsch/flexmark/parser/internal/HtmlDeepParser.PATTERN_MAP : [Lcom/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch;
/*     */     //   298: arraylength
/*     */     //   299: istore #8
/*     */     //   301: aload_0
/*     */     //   302: aconst_null
/*     */     //   303: putfield myClosingPattern : Ljava/util/regex/Pattern;
/*     */     //   306: iconst_1
/*     */     //   307: istore #9
/*     */     //   309: iload #9
/*     */     //   311: iload #8
/*     */     //   313: if_icmpge -> 690
/*     */     //   316: aload #6
/*     */     //   318: iload #9
/*     */     //   320: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   323: ifnull -> 684
/*     */     //   326: aload #6
/*     */     //   328: iload #9
/*     */     //   330: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   333: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   336: astore #8
/*     */     //   338: getstatic com/vladsch/flexmark/parser/internal/HtmlDeepParser.PATTERN_MAP : [Lcom/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch;
/*     */     //   341: iload #9
/*     */     //   343: aaload
/*     */     //   344: astore #9
/*     */     //   346: aload_0
/*     */     //   347: getfield myBlockTags : Ljava/util/HashSet;
/*     */     //   350: aload #8
/*     */     //   352: invokevirtual contains : (Ljava/lang/Object;)Z
/*     */     //   355: istore #10
/*     */     //   357: iload_2
/*     */     //   358: ifne -> 365
/*     */     //   361: iload_3
/*     */     //   362: ifne -> 401
/*     */     //   365: aload #6
/*     */     //   367: invokevirtual start : ()I
/*     */     //   370: ifle -> 401
/*     */     //   373: aload_1
/*     */     //   374: iconst_0
/*     */     //   375: aload #6
/*     */     //   377: invokevirtual start : ()I
/*     */     //   380: invokeinterface subSequence : (II)Ljava/lang/CharSequence;
/*     */     //   385: invokeinterface toString : ()Ljava/lang/String;
/*     */     //   390: dup
/*     */     //   391: astore_1
/*     */     //   392: invokevirtual trim : ()Ljava/lang/String;
/*     */     //   395: invokevirtual isEmpty : ()Z
/*     */     //   398: ifeq -> 690
/*     */     //   401: aload #9
/*     */     //   403: getstatic com/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch.OPEN_TAG : Lcom/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch;
/*     */     //   406: if_acmpeq -> 448
/*     */     //   409: aload #9
/*     */     //   411: getstatic com/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch.CLOSE_TAG : Lcom/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch;
/*     */     //   414: if_acmpeq -> 448
/*     */     //   417: aload_0
/*     */     //   418: aload #9
/*     */     //   420: getfield close : Ljava/util/regex/Pattern;
/*     */     //   423: putfield myClosingPattern : Ljava/util/regex/Pattern;
/*     */     //   426: aload_0
/*     */     //   427: aload #9
/*     */     //   429: putfield myHtmlMatch : Lcom/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch;
/*     */     //   432: aload_0
/*     */     //   433: dup
/*     */     //   434: getfield myHtmlCount : I
/*     */     //   437: iconst_1
/*     */     //   438: iadd
/*     */     //   439: putfield myHtmlCount : I
/*     */     //   442: iconst_0
/*     */     //   443: istore #4
/*     */     //   445: goto -> 690
/*     */     //   448: iload_2
/*     */     //   449: ifne -> 456
/*     */     //   452: iload_3
/*     */     //   453: ifne -> 461
/*     */     //   456: iload #10
/*     */     //   458: ifeq -> 690
/*     */     //   461: iconst_0
/*     */     //   462: istore_2
/*     */     //   463: aload #9
/*     */     //   465: getstatic com/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch.OPEN_TAG : Lcom/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch;
/*     */     //   468: if_acmpne -> 515
/*     */     //   471: getstatic com/vladsch/flexmark/parser/internal/HtmlDeepParser.VOID_TAGS : Ljava/util/Set;
/*     */     //   474: aload #8
/*     */     //   476: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */     //   481: ifeq -> 515
/*     */     //   484: iload #4
/*     */     //   486: ifeq -> 496
/*     */     //   489: aload #8
/*     */     //   491: astore #5
/*     */     //   493: goto -> 690
/*     */     //   496: aload_0
/*     */     //   497: aload #9
/*     */     //   499: putfield myHtmlMatch : Lcom/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch;
/*     */     //   502: aload_0
/*     */     //   503: dup
/*     */     //   504: getfield myHtmlCount : I
/*     */     //   507: iconst_1
/*     */     //   508: iadd
/*     */     //   509: putfield myHtmlCount : I
/*     */     //   512: goto -> 690
/*     */     //   515: aload #9
/*     */     //   517: getstatic com/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch.OPEN_TAG : Lcom/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch;
/*     */     //   520: if_acmpne -> 576
/*     */     //   523: aload_0
/*     */     //   524: aload #9
/*     */     //   526: putfield myHtmlMatch : Lcom/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch;
/*     */     //   529: aload_0
/*     */     //   530: aload #9
/*     */     //   532: getfield close : Ljava/util/regex/Pattern;
/*     */     //   535: putfield myClosingPattern : Ljava/util/regex/Pattern;
/*     */     //   538: iload #4
/*     */     //   540: ifeq -> 550
/*     */     //   543: aload #8
/*     */     //   545: astore #5
/*     */     //   547: goto -> 690
/*     */     //   550: aload_0
/*     */     //   551: aload #8
/*     */     //   553: invokespecial openTag : (Ljava/lang/String;)V
/*     */     //   556: aload_0
/*     */     //   557: getfield myHtmlCount : I
/*     */     //   560: ifeq -> 690
/*     */     //   563: aload_0
/*     */     //   564: dup
/*     */     //   565: getfield myHtmlCount : I
/*     */     //   568: iconst_1
/*     */     //   569: iadd
/*     */     //   570: putfield myHtmlCount : I
/*     */     //   573: goto -> 690
/*     */     //   576: aload_0
/*     */     //   577: getfield myOpenTags : Ljava/util/ArrayList;
/*     */     //   580: invokevirtual size : ()I
/*     */     //   583: istore_1
/*     */     //   584: aload_0
/*     */     //   585: aload #9
/*     */     //   587: putfield myHtmlMatch : Lcom/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch;
/*     */     //   590: aload_0
/*     */     //   591: dup
/*     */     //   592: getfield myHtmlCount : I
/*     */     //   595: iconst_1
/*     */     //   596: iadd
/*     */     //   597: putfield myHtmlCount : I
/*     */     //   600: iload_1
/*     */     //   601: istore #6
/*     */     //   603: iload #6
/*     */     //   605: iinc #6, -1
/*     */     //   608: ifle -> 681
/*     */     //   611: aload_0
/*     */     //   612: getfield myOpenTags : Ljava/util/ArrayList;
/*     */     //   615: iload #6
/*     */     //   617: invokevirtual get : (I)Ljava/lang/Object;
/*     */     //   620: checkcast java/lang/String
/*     */     //   623: dup
/*     */     //   624: astore #9
/*     */     //   626: aload #8
/*     */     //   628: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   631: ifeq -> 661
/*     */     //   634: iload_1
/*     */     //   635: istore_1
/*     */     //   636: iload_1
/*     */     //   637: iinc #1, -1
/*     */     //   640: iload #6
/*     */     //   642: if_icmple -> 658
/*     */     //   645: aload_0
/*     */     //   646: getfield myOpenTags : Ljava/util/ArrayList;
/*     */     //   649: iload #6
/*     */     //   651: invokevirtual remove : (I)Ljava/lang/Object;
/*     */     //   654: pop
/*     */     //   655: goto -> 636
/*     */     //   658: goto -> 690
/*     */     //   661: iload #10
/*     */     //   663: ifne -> 678
/*     */     //   666: aload_0
/*     */     //   667: getfield myBlockTags : Ljava/util/HashSet;
/*     */     //   670: aload #9
/*     */     //   672: invokevirtual contains : (Ljava/lang/Object;)Z
/*     */     //   675: ifne -> 681
/*     */     //   678: goto -> 603
/*     */     //   681: goto -> 690
/*     */     //   684: iinc #9, 1
/*     */     //   687: goto -> 309
/*     */     //   690: aload #7
/*     */     //   692: astore_1
/*     */     //   693: goto -> 31
/*     */     //   696: aload #5
/*     */     //   698: ifnull -> 716
/*     */     //   701: aload_0
/*     */     //   702: getfield myHtmlMatch : Lcom/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch;
/*     */     //   705: getstatic com/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch.OPEN_TAG : Lcom/vladsch/flexmark/parser/internal/HtmlDeepParser$HtmlMatch;
/*     */     //   708: if_acmpne -> 716
/*     */     //   711: aload_0
/*     */     //   712: aconst_null
/*     */     //   713: putfield myClosingPattern : Ljava/util/regex/Pattern;
/*     */     //   716: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #185	-> 0
/*     */     //   #186	-> 14
/*     */     //   #189	-> 24
/*     */     //   #190	-> 27
/*     */     //   #192	-> 31
/*     */     //   #193	-> 40
/*     */     //   #195	-> 47
/*     */     //   #196	-> 56
/*     */     //   #198	-> 64
/*     */     //   #199	-> 74
/*     */     //   #201	-> 87
/*     */     //   #202	-> 92
/*     */     //   #204	-> 112
/*     */     //   #206	-> 117
/*     */     //   #207	-> 120
/*     */     //   #208	-> 125
/*     */     //   #212	-> 128
/*     */     //   #213	-> 131
/*     */     //   #215	-> 144
/*     */     //   #216	-> 149
/*     */     //   #218	-> 166
/*     */     //   #220	-> 176
/*     */     //   #222	-> 181
/*     */     //   #223	-> 194
/*     */     //   #225	-> 200
/*     */     //   #228	-> 210
/*     */     //   #231	-> 231
/*     */     //   #234	-> 249
/*     */     //   #235	-> 252
/*     */     //   #236	-> 257
/*     */     //   #238	-> 260
/*     */     //   #239	-> 268
/*     */     //   #241	-> 276
/*     */     //   #242	-> 295
/*     */     //   #243	-> 301
/*     */     //   #245	-> 306
/*     */     //   #246	-> 316
/*     */     //   #248	-> 326
/*     */     //   #249	-> 338
/*     */     //   #250	-> 346
/*     */     //   #252	-> 357
/*     */     //   #254	-> 373
/*     */     //   #255	-> 391
/*     */     //   #259	-> 401
/*     */     //   #261	-> 417
/*     */     //   #262	-> 426
/*     */     //   #263	-> 432
/*     */     //   #264	-> 442
/*     */     //   #265	-> 445
/*     */     //   #268	-> 448
/*     */     //   #274	-> 461
/*     */     //   #277	-> 463
/*     */     //   #279	-> 484
/*     */     //   #280	-> 489
/*     */     //   #282	-> 496
/*     */     //   #283	-> 502
/*     */     //   #285	-> 512
/*     */     //   #288	-> 515
/*     */     //   #290	-> 523
/*     */     //   #291	-> 529
/*     */     //   #292	-> 538
/*     */     //   #293	-> 543
/*     */     //   #295	-> 550
/*     */     //   #296	-> 556
/*     */     //   #300	-> 576
/*     */     //   #301	-> 584
/*     */     //   #302	-> 590
/*     */     //   #303	-> 600
/*     */     //   #304	-> 611
/*     */     //   #305	-> 624
/*     */     //   #307	-> 634
/*     */     //   #308	-> 645
/*     */     //   #310	-> 658
/*     */     //   #313	-> 661
/*     */     //   #315	-> 666
/*     */     //   #317	-> 678
/*     */     //   #320	-> 681
/*     */     //   #245	-> 684
/*     */     //   #323	-> 690
/*     */     //   #324	-> 693
/*     */     //   #327	-> 696
/*     */     //   #329	-> 711
/*     */     //   #331	-> 716
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\internal\HtmlDeepParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */