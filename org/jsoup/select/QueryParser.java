/*     */ package org.jsoup.select;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.regex.Pattern;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.internal.Normalizer;
/*     */ import org.jsoup.internal.StringUtil;
/*     */ import org.jsoup.parser.TokenQueue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QueryParser
/*     */ {
/*  19 */   private static final char[] Combinators = new char[] { ',', '>', '+', '~', ' ' };
/*  20 */   private static final String[] AttributeEvals = new String[] { "=", "!=", "^=", "$=", "*=", "~=" };
/*     */   
/*     */   private final TokenQueue tq;
/*     */   private final String query;
/*  24 */   private final List<Evaluator> evals = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private QueryParser(String paramString) {
/*  31 */     Validate.notEmpty(paramString);
/*  32 */     paramString = paramString.trim();
/*  33 */     this.query = paramString;
/*  34 */     this.tq = new TokenQueue(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Evaluator parse(String paramString) {
/*     */     try {
/*     */       QueryParser queryParser;
/*  46 */       return (queryParser = new QueryParser(paramString)).parse();
/*  47 */     } catch (IllegalArgumentException illegalArgumentException) {
/*  48 */       throw new Selector.SelectorParseException(illegalArgumentException.getMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Evaluator parse() {
/*  57 */     this.tq.consumeWhitespace();
/*     */     
/*  59 */     if (this.tq.matchesAny(Combinators)) {
/*  60 */       this.evals.add(new StructuralEvaluator.Root());
/*  61 */       combinator(this.tq.consume());
/*     */     } else {
/*  63 */       this.evals.add(consumeEvaluator());
/*     */     } 
/*     */     
/*  66 */     while (!this.tq.isEmpty()) {
/*     */       
/*  68 */       boolean bool = this.tq.consumeWhitespace();
/*     */       
/*  70 */       if (this.tq.matchesAny(Combinators)) {
/*  71 */         combinator(this.tq.consume()); continue;
/*  72 */       }  if (bool) {
/*  73 */         combinator(' '); continue;
/*     */       } 
/*  75 */       this.evals.add(consumeEvaluator());
/*     */     } 
/*     */ 
/*     */     
/*  79 */     if (this.evals.size() == 1) {
/*  80 */       return this.evals.get(0);
/*     */     }
/*  82 */     return new CombiningEvaluator.And(this.evals); } private void combinator(char paramChar) {
/*     */     StructuralEvaluator.ImmediateParentRun immediateParentRun;
/*     */     CombiningEvaluator.Or or;
/*     */     Evaluator evaluator1, evaluator2;
/*  86 */     this.tq.consumeWhitespace();
/*     */ 
/*     */     
/*     */     String str;
/*     */     
/*  91 */     Evaluator evaluator3 = parse(str = consumeSubQuery());
/*  92 */     boolean bool = false;
/*     */     
/*  94 */     if (this.evals.size() == 1) {
/*     */ 
/*     */       
/*  97 */       if (evaluator1 = evaluator2 = this.evals.get(0) instanceof CombiningEvaluator.Or && paramChar != ',') {
/*  98 */         evaluator2 = ((CombiningEvaluator.Or)evaluator2).rightMostEvaluator();
/*  99 */         assert evaluator2 != null;
/* 100 */         bool = true;
/*     */       } 
/*     */     } else {
/*     */       
/* 104 */       evaluator1 = evaluator2 = new CombiningEvaluator.And(this.evals);
/*     */     } 
/* 106 */     this.evals.clear();
/*     */ 
/*     */     
/* 109 */     switch (paramChar) {
/*     */ 
/*     */       
/*     */       case '>':
/* 113 */         (immediateParentRun = (evaluator2 instanceof StructuralEvaluator.ImmediateParentRun) ? (StructuralEvaluator.ImmediateParentRun)evaluator2 : new StructuralEvaluator.ImmediateParentRun(evaluator2)).add(evaluator3);
/* 114 */         evaluator2 = immediateParentRun;
/*     */         break;
/*     */       case ' ':
/* 117 */         evaluator2 = new CombiningEvaluator.And(new Evaluator[] { new StructuralEvaluator.Parent(evaluator2), evaluator3 });
/*     */         break;
/*     */       case '+':
/* 120 */         evaluator2 = new CombiningEvaluator.And(new Evaluator[] { new StructuralEvaluator.ImmediatePreviousSibling(evaluator2), evaluator3 });
/*     */         break;
/*     */       case '~':
/* 123 */         evaluator2 = new CombiningEvaluator.And(new Evaluator[] { new StructuralEvaluator.PreviousSibling(evaluator2), evaluator3 });
/*     */         break;
/*     */       
/*     */       case ',':
/* 127 */         if (evaluator2 instanceof CombiningEvaluator.Or) {
/* 128 */           or = (CombiningEvaluator.Or)evaluator2;
/*     */         } else {
/*     */           
/* 131 */           (or = new CombiningEvaluator.Or()).add(evaluator2);
/*     */         } 
/* 133 */         or.add(evaluator3);
/* 134 */         evaluator2 = or;
/*     */         break;
/*     */       default:
/* 137 */         throw new Selector.SelectorParseException("Unknown combinator '%s'", new Object[] { Character.valueOf(or) });
/*     */     } 
/*     */     
/* 140 */     if (bool)
/* 141 */     { ((CombiningEvaluator.Or)evaluator1).replaceRightMostEvaluator(evaluator2); }
/* 142 */     else { evaluator1 = evaluator2; }
/* 143 */      this.evals.add(evaluator1);
/*     */   }
/*     */   
/*     */   private String consumeSubQuery() {
/* 147 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/* 148 */     boolean bool = false;
/* 149 */     while (!this.tq.isEmpty()) {
/* 150 */       if (this.tq.matchesAny(Combinators)) {
/* 151 */         if (!bool) {
/*     */           
/* 153 */           stringBuilder.append(this.tq.consume()); continue;
/*     */         }  break;
/*     */       } 
/* 156 */       bool = true;
/* 157 */       if (this.tq.matches("(")) {
/* 158 */         stringBuilder.append("(").append(this.tq.chompBalanced('(', ')')).append(")"); continue;
/* 159 */       }  if (this.tq.matches("[")) {
/* 160 */         stringBuilder.append("[").append(this.tq.chompBalanced('[', ']')).append("]"); continue;
/*     */       } 
/* 162 */       stringBuilder.append(this.tq.consume());
/*     */     } 
/* 164 */     return StringUtil.releaseBuilder(stringBuilder);
/*     */   }
/*     */   
/*     */   private Evaluator consumeEvaluator() {
/* 168 */     if (this.tq.matchChomp("#"))
/* 169 */       return byId(); 
/* 170 */     if (this.tq.matchChomp("."))
/* 171 */       return byClass(); 
/* 172 */     if (this.tq.matchesWord() || this.tq.matches("*|"))
/* 173 */       return byTag(); 
/* 174 */     if (this.tq.matches("["))
/* 175 */       return byAttribute(); 
/* 176 */     if (this.tq.matchChomp("*"))
/* 177 */       return new Evaluator.AllElements(); 
/* 178 */     if (this.tq.matchChomp(":")) {
/* 179 */       return parsePseudoSelector();
/*     */     }
/* 181 */     throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", new Object[] { this.query, this.tq.remainder() });
/*     */   }
/*     */ 
/*     */   
/*     */   private Evaluator parsePseudoSelector() {
/* 186 */     switch (null = this.tq.consumeCssIdentifier()) {
/*     */       case "lt":
/* 188 */         return new Evaluator.IndexLessThan(consumeIndex());
/*     */       case "gt":
/* 190 */         return new Evaluator.IndexGreaterThan(consumeIndex());
/*     */       case "eq":
/* 192 */         return new Evaluator.IndexEquals(consumeIndex());
/*     */       case "has":
/* 194 */         return has();
/*     */       case "is":
/* 196 */         return is();
/*     */       case "contains":
/* 198 */         return contains(false);
/*     */       case "containsOwn":
/* 200 */         return contains(true);
/*     */       case "containsWholeText":
/* 202 */         return containsWholeText(false);
/*     */       case "containsWholeOwnText":
/* 204 */         return containsWholeText(true);
/*     */       case "containsData":
/* 206 */         return containsData();
/*     */       case "matches":
/* 208 */         return matches(false);
/*     */       case "matchesOwn":
/* 210 */         return matches(true);
/*     */       case "matchesWholeText":
/* 212 */         return matchesWholeText(false);
/*     */       case "matchesWholeOwnText":
/* 214 */         return matchesWholeText(true);
/*     */       case "not":
/* 216 */         return not();
/*     */       case "nth-child":
/* 218 */         return cssNthChild(false, false);
/*     */       case "nth-last-child":
/* 220 */         return cssNthChild(true, false);
/*     */       case "nth-of-type":
/* 222 */         return cssNthChild(false, true);
/*     */       case "nth-last-of-type":
/* 224 */         return cssNthChild(true, true);
/*     */       case "first-child":
/* 226 */         return new Evaluator.IsFirstChild();
/*     */       case "last-child":
/* 228 */         return new Evaluator.IsLastChild();
/*     */       case "first-of-type":
/* 230 */         return new Evaluator.IsFirstOfType();
/*     */       case "last-of-type":
/* 232 */         return new Evaluator.IsLastOfType();
/*     */       case "only-child":
/* 234 */         return new Evaluator.IsOnlyChild();
/*     */       case "only-of-type":
/* 236 */         return new Evaluator.IsOnlyOfType();
/*     */       case "empty":
/* 238 */         return new Evaluator.IsEmpty();
/*     */       case "root":
/* 240 */         return new Evaluator.IsRoot();
/*     */       case "matchText":
/* 242 */         return new Evaluator.MatchText();
/*     */     } 
/* 244 */     throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", new Object[] { this.query, this.tq.remainder() });
/*     */   }
/*     */ 
/*     */   
/*     */   private Evaluator byId() {
/*     */     String str;
/* 250 */     Validate.notEmpty(str = this.tq.consumeCssIdentifier());
/* 251 */     return new Evaluator.Id(str);
/*     */   }
/*     */   
/*     */   private Evaluator byClass() {
/*     */     String str;
/* 256 */     Validate.notEmpty(str = this.tq.consumeCssIdentifier());
/* 257 */     return new Evaluator.Class(str.trim());
/*     */   }
/*     */ 
/*     */   
/*     */   private Evaluator byTag() {
/*     */     CombiningEvaluator.Or or;
/*     */     Evaluator.Tag tag;
/*     */     String str;
/* 265 */     Validate.notEmpty(str = Normalizer.normalize(this.tq.consumeElementSelector()));
/*     */ 
/*     */ 
/*     */     
/* 269 */     if (str.startsWith("*|")) {
/* 270 */       String str1 = str.substring(2);
/*     */ 
/*     */       
/* 273 */       or = new CombiningEvaluator.Or(new Evaluator[] { new Evaluator.Tag(str1), new Evaluator.TagEndsWith(str.replace("*|", ":")) });
/*     */     } else {
/*     */       String str1;
/*     */       
/* 277 */       if (or.contains("|")) {
/* 278 */         str1 = or.replace("|", ":");
/*     */       }
/* 280 */       tag = new Evaluator.Tag(str1);
/*     */     } 
/* 282 */     return tag;
/*     */   } private Evaluator byAttribute() {
/*     */     Evaluator.Attribute attribute;
/*     */     Evaluator.AttributeWithValueMatching attributeWithValueMatching;
/*     */     TokenQueue tokenQueue;
/*     */     String str;
/* 288 */     Validate.notEmpty(str = (tokenQueue = new TokenQueue(this.tq.chompBalanced('[', ']'))).consumeToAny(AttributeEvals));
/* 289 */     tokenQueue.consumeWhitespace();
/*     */ 
/*     */     
/* 292 */     if (tokenQueue.isEmpty())
/* 293 */     { if (str.startsWith("^")) {
/* 294 */         Evaluator.AttributeStarting attributeStarting = new Evaluator.AttributeStarting(str.substring(1));
/* 295 */       } else if (str.equals("*")) {
/* 296 */         Evaluator.AttributeStarting attributeStarting = new Evaluator.AttributeStarting("");
/*     */       } else {
/* 298 */         attribute = new Evaluator.Attribute(str);
/*     */       }  }
/* 300 */     else { Evaluator.AttributeWithValue attributeWithValue; if (attribute.matchChomp("="))
/* 301 */       { attributeWithValue = new Evaluator.AttributeWithValue(str, attribute.remainder()); }
/* 302 */       else { Evaluator.AttributeWithValueNot attributeWithValueNot; if (attributeWithValue.matchChomp("!="))
/* 303 */         { attributeWithValueNot = new Evaluator.AttributeWithValueNot(str, attributeWithValue.remainder()); }
/* 304 */         else { Evaluator.AttributeWithValueStarting attributeWithValueStarting; if (attributeWithValueNot.matchChomp("^="))
/* 305 */           { attributeWithValueStarting = new Evaluator.AttributeWithValueStarting(str, attributeWithValueNot.remainder()); }
/* 306 */           else { Evaluator.AttributeWithValueEnding attributeWithValueEnding; if (attributeWithValueStarting.matchChomp("$="))
/* 307 */             { attributeWithValueEnding = new Evaluator.AttributeWithValueEnding(str, attributeWithValueStarting.remainder()); }
/* 308 */             else { Evaluator.AttributeWithValueContaining attributeWithValueContaining; if (attributeWithValueEnding.matchChomp("*="))
/* 309 */               { attributeWithValueContaining = new Evaluator.AttributeWithValueContaining(str, attributeWithValueEnding.remainder()); }
/* 310 */               else if (attributeWithValueContaining.matchChomp("~="))
/* 311 */               { attributeWithValueMatching = new Evaluator.AttributeWithValueMatching(str, Pattern.compile(attributeWithValueContaining.remainder())); }
/*     */               else
/* 313 */               { throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", new Object[] { this.query, attributeWithValueMatching.remainder() }); }  }  }  }  }
/*     */        }
/* 315 */      return attributeWithValueMatching;
/*     */   }
/*     */ 
/*     */   
/* 319 */   private static final Pattern NTH_AB = Pattern.compile("(([+-])?(\\d+)?)n(\\s*([+-])?\\s*\\d+)?", 2);
/* 320 */   private static final Pattern NTH_B = Pattern.compile("([+-])?(\\d+)");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Evaluator cssNthChild(boolean paramBoolean1, boolean paramBoolean2) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial consumeParens : ()Ljava/lang/String;
/*     */     //   4: invokestatic normalize : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   7: astore_3
/*     */     //   8: getstatic org/jsoup/select/QueryParser.NTH_AB : Ljava/util/regex/Pattern;
/*     */     //   11: aload_3
/*     */     //   12: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   15: astore #4
/*     */     //   17: getstatic org/jsoup/select/QueryParser.NTH_B : Ljava/util/regex/Pattern;
/*     */     //   20: aload_3
/*     */     //   21: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   24: astore #5
/*     */     //   26: ldc 'odd'
/*     */     //   28: aload_3
/*     */     //   29: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   32: ifeq -> 43
/*     */     //   35: iconst_2
/*     */     //   36: istore_3
/*     */     //   37: iconst_1
/*     */     //   38: istore #4
/*     */     //   40: goto -> 180
/*     */     //   43: ldc 'even'
/*     */     //   45: aload_3
/*     */     //   46: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   49: ifeq -> 60
/*     */     //   52: iconst_2
/*     */     //   53: istore_3
/*     */     //   54: iconst_0
/*     */     //   55: istore #4
/*     */     //   57: goto -> 180
/*     */     //   60: aload #4
/*     */     //   62: invokevirtual matches : ()Z
/*     */     //   65: ifeq -> 132
/*     */     //   68: aload #4
/*     */     //   70: iconst_3
/*     */     //   71: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   74: ifnull -> 96
/*     */     //   77: aload #4
/*     */     //   79: iconst_1
/*     */     //   80: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   83: ldc '^\+'
/*     */     //   85: ldc ''
/*     */     //   87: invokevirtual replaceFirst : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   90: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   93: goto -> 97
/*     */     //   96: iconst_1
/*     */     //   97: istore_3
/*     */     //   98: aload #4
/*     */     //   100: iconst_4
/*     */     //   101: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   104: ifnull -> 126
/*     */     //   107: aload #4
/*     */     //   109: iconst_4
/*     */     //   110: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   113: ldc '^\+'
/*     */     //   115: ldc ''
/*     */     //   117: invokevirtual replaceFirst : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   120: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   123: goto -> 127
/*     */     //   126: iconst_0
/*     */     //   127: istore #4
/*     */     //   129: goto -> 180
/*     */     //   132: aload #5
/*     */     //   134: invokevirtual matches : ()Z
/*     */     //   137: ifeq -> 162
/*     */     //   140: iconst_0
/*     */     //   141: istore_3
/*     */     //   142: aload #5
/*     */     //   144: invokevirtual group : ()Ljava/lang/String;
/*     */     //   147: ldc '^\+'
/*     */     //   149: ldc ''
/*     */     //   151: invokevirtual replaceFirst : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   154: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   157: istore #4
/*     */     //   159: goto -> 180
/*     */     //   162: new org/jsoup/select/Selector$SelectorParseException
/*     */     //   165: dup
/*     */     //   166: ldc 'Could not parse nth-index '%s': unexpected format'
/*     */     //   168: iconst_1
/*     */     //   169: anewarray java/lang/Object
/*     */     //   172: dup
/*     */     //   173: iconst_0
/*     */     //   174: aload_3
/*     */     //   175: aastore
/*     */     //   176: invokespecial <init> : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   179: athrow
/*     */     //   180: iload_2
/*     */     //   181: ifeq -> 216
/*     */     //   184: iload_1
/*     */     //   185: ifeq -> 202
/*     */     //   188: new org/jsoup/select/Evaluator$IsNthLastOfType
/*     */     //   191: dup
/*     */     //   192: iload_3
/*     */     //   193: iload #4
/*     */     //   195: invokespecial <init> : (II)V
/*     */     //   198: astore_1
/*     */     //   199: goto -> 245
/*     */     //   202: new org/jsoup/select/Evaluator$IsNthOfType
/*     */     //   205: dup
/*     */     //   206: iload_3
/*     */     //   207: iload #4
/*     */     //   209: invokespecial <init> : (II)V
/*     */     //   212: astore_1
/*     */     //   213: goto -> 245
/*     */     //   216: iload_1
/*     */     //   217: ifeq -> 234
/*     */     //   220: new org/jsoup/select/Evaluator$IsNthLastChild
/*     */     //   223: dup
/*     */     //   224: iload_3
/*     */     //   225: iload #4
/*     */     //   227: invokespecial <init> : (II)V
/*     */     //   230: astore_1
/*     */     //   231: goto -> 245
/*     */     //   234: new org/jsoup/select/Evaluator$IsNthChild
/*     */     //   237: dup
/*     */     //   238: iload_3
/*     */     //   239: iload #4
/*     */     //   241: invokespecial <init> : (II)V
/*     */     //   244: astore_1
/*     */     //   245: aload_1
/*     */     //   246: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #323	-> 0
/*     */     //   #324	-> 8
/*     */     //   #325	-> 17
/*     */     //   #327	-> 26
/*     */     //   #328	-> 35
/*     */     //   #329	-> 37
/*     */     //   #330	-> 43
/*     */     //   #331	-> 52
/*     */     //   #332	-> 54
/*     */     //   #333	-> 60
/*     */     //   #334	-> 68
/*     */     //   #335	-> 98
/*     */     //   #336	-> 132
/*     */     //   #337	-> 140
/*     */     //   #338	-> 142
/*     */     //   #340	-> 162
/*     */     //   #344	-> 180
/*     */     //   #345	-> 184
/*     */     //   #346	-> 188
/*     */     //   #348	-> 202
/*     */     //   #350	-> 216
/*     */     //   #351	-> 220
/*     */     //   #353	-> 234
/*     */     //   #355	-> 245
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String consumeParens() {
/* 359 */     return this.tq.chompBalanced('(', ')');
/*     */   }
/*     */   
/*     */   private int consumeIndex() {
/*     */     String str;
/* 364 */     Validate.isTrue(StringUtil.isNumeric(str = consumeParens().trim()), "Index must be numeric");
/* 365 */     return Integer.parseInt(str);
/*     */   }
/*     */ 
/*     */   
/*     */   private Evaluator has() {
/*     */     String str;
/* 371 */     Validate.notEmpty(str = consumeParens(), ":has(selector) sub-select must not be empty");
/* 372 */     return new StructuralEvaluator.Has(parse(str));
/*     */   }
/*     */ 
/*     */   
/*     */   private Evaluator is() {
/*     */     String str;
/* 378 */     Validate.notEmpty(str = consumeParens(), ":is(selector) sub-select must not be empty");
/* 379 */     return new StructuralEvaluator.Is(parse(str));
/*     */   }
/*     */ 
/*     */   
/*     */   private Evaluator contains(boolean paramBoolean) {
/* 384 */     String str1 = paramBoolean ? ":containsOwn" : ":contains";
/*     */     String str2;
/* 386 */     Validate.notEmpty(str2 = TokenQueue.unescape(consumeParens()), str1 + "(text) query must not be empty");
/* 387 */     if (paramBoolean)
/* 388 */       return new Evaluator.ContainsOwnText(str2); 
/* 389 */     return new Evaluator.ContainsText(str2);
/*     */   }
/*     */   
/*     */   private Evaluator containsWholeText(boolean paramBoolean) {
/* 393 */     String str1 = paramBoolean ? ":containsWholeOwnText" : ":containsWholeText";
/*     */     String str2;
/* 395 */     Validate.notEmpty(str2 = TokenQueue.unescape(consumeParens()), str1 + "(text) query must not be empty");
/* 396 */     if (paramBoolean)
/* 397 */       return new Evaluator.ContainsWholeOwnText(str2); 
/* 398 */     return new Evaluator.ContainsWholeText(str2);
/*     */   }
/*     */ 
/*     */   
/*     */   private Evaluator containsData() {
/*     */     String str;
/* 404 */     Validate.notEmpty(str = TokenQueue.unescape(consumeParens()), ":containsData(text) query must not be empty");
/* 405 */     return new Evaluator.ContainsData(str);
/*     */   }
/*     */ 
/*     */   
/*     */   private Evaluator matches(boolean paramBoolean) {
/* 410 */     String str1 = paramBoolean ? ":matchesOwn" : ":matches";
/*     */     String str2;
/* 412 */     Validate.notEmpty(str2 = consumeParens(), str1 + "(regex) query must not be empty");
/*     */     
/* 414 */     if (paramBoolean)
/* 415 */       return new Evaluator.MatchesOwn(Pattern.compile(str2)); 
/* 416 */     return new Evaluator.Matches(Pattern.compile(str2));
/*     */   }
/*     */ 
/*     */   
/*     */   private Evaluator matchesWholeText(boolean paramBoolean) {
/* 421 */     String str1 = paramBoolean ? ":matchesWholeOwnText" : ":matchesWholeText";
/*     */     String str2;
/* 423 */     Validate.notEmpty(str2 = consumeParens(), str1 + "(regex) query must not be empty");
/*     */     
/* 425 */     if (paramBoolean)
/* 426 */       return new Evaluator.MatchesWholeOwnText(Pattern.compile(str2)); 
/* 427 */     return new Evaluator.MatchesWholeText(Pattern.compile(str2));
/*     */   }
/*     */ 
/*     */   
/*     */   private Evaluator not() {
/*     */     String str;
/* 433 */     Validate.notEmpty(str = consumeParens(), ":not(selector) subselect must not be empty");
/*     */     
/* 435 */     return new StructuralEvaluator.Not(parse(str));
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 440 */     return this.query;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\select\QueryParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */