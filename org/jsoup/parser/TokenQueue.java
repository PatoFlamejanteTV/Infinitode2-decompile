/*     */ package org.jsoup.parser;
/*     */ 
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.internal.StringUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TokenQueue
/*     */ {
/*     */   private String queue;
/*  13 */   private int pos = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final char ESC = '\\';
/*     */ 
/*     */ 
/*     */   
/*     */   public TokenQueue(String paramString) {
/*  22 */     Validate.notNull(paramString);
/*  23 */     this.queue = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  31 */     return (remainingLength() == 0);
/*     */   }
/*     */   
/*     */   private int remainingLength() {
/*  35 */     return this.queue.length() - this.pos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addFirst(String paramString) {
/*  44 */     this.queue = paramString + this.queue.substring(this.pos);
/*  45 */     this.pos = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(String paramString) {
/*  54 */     return this.queue.regionMatches(true, this.pos, paramString, 0, paramString.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matchesAny(String... paramVarArgs) {
/*     */     int i;
/*     */     byte b;
/*  63 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { String str = paramVarArgs[b];
/*  64 */       if (matches(str))
/*  65 */         return true;  b++; }
/*     */     
/*  67 */     return false;
/*     */   }
/*     */   
/*     */   public boolean matchesAny(char... paramVarArgs) {
/*  71 */     if (isEmpty())
/*  72 */       return false;  int i;
/*     */     byte b;
/*  74 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { char c = paramVarArgs[b];
/*  75 */       if (this.queue.charAt(this.pos) == c)
/*  76 */         return true;  b++; }
/*     */     
/*  78 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matchChomp(String paramString) {
/*  88 */     if (matches(paramString)) {
/*  89 */       this.pos += paramString.length();
/*  90 */       return true;
/*     */     } 
/*  92 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matchesWhitespace() {
/* 101 */     return (!isEmpty() && StringUtil.isWhitespace(this.queue.charAt(this.pos)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matchesWord() {
/* 109 */     return (!isEmpty() && Character.isLetterOrDigit(this.queue.charAt(this.pos)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void advance() {
/* 116 */     if (!isEmpty()) this.pos++;
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char consume() {
/* 124 */     return this.queue.charAt(this.pos++);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void consume(String paramString) {
/* 135 */     if (!matches(paramString))
/* 136 */       throw new IllegalStateException("Queue did not match expected sequence"); 
/*     */     int i;
/* 138 */     if ((i = paramString.length()) > remainingLength()) {
/* 139 */       throw new IllegalStateException("Queue not long enough to consume sequence");
/*     */     }
/* 141 */     this.pos += i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String consumeTo(String paramString) {
/*     */     int i;
/* 151 */     if ((i = this.queue.indexOf(paramString, this.pos)) != -1) {
/* 152 */       String str = this.queue.substring(this.pos, i);
/* 153 */       this.pos += str.length();
/* 154 */       return str;
/*     */     } 
/* 156 */     return remainder();
/*     */   }
/*     */ 
/*     */   
/*     */   public String consumeToIgnoreCase(String paramString) {
/* 161 */     int i = this.pos;
/*     */     String str;
/* 163 */     boolean bool = (str = paramString.substring(0, 1)).toLowerCase().equals(str.toUpperCase());
/* 164 */     while (!isEmpty() && 
/* 165 */       !matches(paramString)) {
/*     */ 
/*     */       
/* 168 */       if (bool) {
/*     */         int j;
/* 170 */         if ((j = this.queue.indexOf(str, this.pos) - this.pos) == 0) {
/* 171 */           this.pos++; continue;
/* 172 */         }  if (j < 0) {
/* 173 */           this.pos = this.queue.length(); continue;
/*     */         } 
/* 175 */         this.pos += j;
/*     */         continue;
/*     */       } 
/* 178 */       this.pos++;
/*     */     } 
/*     */     
/* 181 */     return this.queue.substring(i, this.pos);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String consumeToAny(String... paramVarArgs) {
/* 192 */     int i = this.pos;
/* 193 */     while (!isEmpty() && !matchesAny(paramVarArgs)) {
/* 194 */       this.pos++;
/*     */     }
/*     */     
/* 197 */     return this.queue.substring(i, this.pos);
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
/*     */   public String chompTo(String paramString) {
/* 209 */     String str = consumeTo(paramString);
/* 210 */     matchChomp(paramString);
/* 211 */     return str;
/*     */   }
/*     */   
/*     */   public String chompToIgnoreCase(String paramString) {
/* 215 */     String str = consumeToIgnoreCase(paramString);
/* 216 */     matchChomp(paramString);
/* 217 */     return str;
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
/*     */   public String chompBalanced(char paramChar1, char paramChar2) {
/*     */     // Byte code:
/*     */     //   0: iconst_m1
/*     */     //   1: istore_3
/*     */     //   2: iconst_m1
/*     */     //   3: istore #4
/*     */     //   5: iconst_0
/*     */     //   6: istore #5
/*     */     //   8: iconst_0
/*     */     //   9: istore #6
/*     */     //   11: iconst_0
/*     */     //   12: istore #7
/*     */     //   14: iconst_0
/*     */     //   15: istore #8
/*     */     //   17: iconst_0
/*     */     //   18: istore #9
/*     */     //   20: aload_0
/*     */     //   21: invokevirtual isEmpty : ()Z
/*     */     //   24: ifne -> 207
/*     */     //   27: aload_0
/*     */     //   28: invokevirtual consume : ()C
/*     */     //   31: istore #10
/*     */     //   33: iload #6
/*     */     //   35: bipush #92
/*     */     //   37: if_icmpeq -> 159
/*     */     //   40: iload #10
/*     */     //   42: bipush #39
/*     */     //   44: if_icmpne -> 73
/*     */     //   47: iload #10
/*     */     //   49: iload_1
/*     */     //   50: if_icmpeq -> 73
/*     */     //   53: iload #8
/*     */     //   55: ifne -> 73
/*     */     //   58: iload #7
/*     */     //   60: ifne -> 67
/*     */     //   63: iconst_1
/*     */     //   64: goto -> 68
/*     */     //   67: iconst_0
/*     */     //   68: istore #7
/*     */     //   70: goto -> 103
/*     */     //   73: iload #10
/*     */     //   75: bipush #34
/*     */     //   77: if_icmpne -> 103
/*     */     //   80: iload #10
/*     */     //   82: iload_1
/*     */     //   83: if_icmpeq -> 103
/*     */     //   86: iload #7
/*     */     //   88: ifne -> 103
/*     */     //   91: iload #8
/*     */     //   93: ifne -> 100
/*     */     //   96: iconst_1
/*     */     //   97: goto -> 101
/*     */     //   100: iconst_0
/*     */     //   101: istore #8
/*     */     //   103: iload #7
/*     */     //   105: ifne -> 118
/*     */     //   108: iload #8
/*     */     //   110: ifne -> 118
/*     */     //   113: iload #9
/*     */     //   115: ifeq -> 125
/*     */     //   118: iload #10
/*     */     //   120: istore #6
/*     */     //   122: goto -> 202
/*     */     //   125: iload #10
/*     */     //   127: iload_1
/*     */     //   128: if_icmpne -> 147
/*     */     //   131: iinc #5, 1
/*     */     //   134: iload_3
/*     */     //   135: iconst_m1
/*     */     //   136: if_icmpne -> 182
/*     */     //   139: aload_0
/*     */     //   140: getfield pos : I
/*     */     //   143: istore_3
/*     */     //   144: goto -> 182
/*     */     //   147: iload #10
/*     */     //   149: iload_2
/*     */     //   150: if_icmpne -> 182
/*     */     //   153: iinc #5, -1
/*     */     //   156: goto -> 182
/*     */     //   159: iload #10
/*     */     //   161: bipush #81
/*     */     //   163: if_icmpne -> 172
/*     */     //   166: iconst_1
/*     */     //   167: istore #9
/*     */     //   169: goto -> 182
/*     */     //   172: iload #10
/*     */     //   174: bipush #69
/*     */     //   176: if_icmpne -> 182
/*     */     //   179: iconst_0
/*     */     //   180: istore #9
/*     */     //   182: iload #5
/*     */     //   184: ifle -> 198
/*     */     //   187: iload #6
/*     */     //   189: ifeq -> 198
/*     */     //   192: aload_0
/*     */     //   193: getfield pos : I
/*     */     //   196: istore #4
/*     */     //   198: iload #10
/*     */     //   200: istore #6
/*     */     //   202: iload #5
/*     */     //   204: ifgt -> 20
/*     */     //   207: iload #4
/*     */     //   209: iflt -> 225
/*     */     //   212: aload_0
/*     */     //   213: getfield queue : Ljava/lang/String;
/*     */     //   216: iload_3
/*     */     //   217: iload #4
/*     */     //   219: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   222: goto -> 227
/*     */     //   225: ldc ''
/*     */     //   227: astore #10
/*     */     //   229: iload #5
/*     */     //   231: ifle -> 259
/*     */     //   234: new java/lang/StringBuilder
/*     */     //   237: dup
/*     */     //   238: ldc 'Did not find balanced marker at ''
/*     */     //   240: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   243: aload #10
/*     */     //   245: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   248: ldc '''
/*     */     //   250: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   253: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   256: invokestatic fail : (Ljava/lang/String;)V
/*     */     //   259: aload #10
/*     */     //   261: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #230	-> 0
/*     */     //   #231	-> 2
/*     */     //   #232	-> 5
/*     */     //   #233	-> 8
/*     */     //   #234	-> 11
/*     */     //   #235	-> 14
/*     */     //   #236	-> 17
/*     */     //   #239	-> 20
/*     */     //   #240	-> 27
/*     */     //   #241	-> 33
/*     */     //   #242	-> 40
/*     */     //   #243	-> 58
/*     */     //   #244	-> 73
/*     */     //   #245	-> 91
/*     */     //   #246	-> 103
/*     */     //   #247	-> 118
/*     */     //   #248	-> 122
/*     */     //   #251	-> 125
/*     */     //   #252	-> 131
/*     */     //   #253	-> 134
/*     */     //   #254	-> 139
/*     */     //   #256	-> 147
/*     */     //   #257	-> 153
/*     */     //   #258	-> 159
/*     */     //   #259	-> 166
/*     */     //   #260	-> 172
/*     */     //   #261	-> 179
/*     */     //   #264	-> 182
/*     */     //   #265	-> 192
/*     */     //   #266	-> 198
/*     */     //   #267	-> 202
/*     */     //   #268	-> 207
/*     */     //   #269	-> 229
/*     */     //   #270	-> 234
/*     */     //   #272	-> 259
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
/*     */   public static String unescape(String paramString) {
/* 281 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/* 282 */     char c = Character.MIN_VALUE; char[] arrayOfChar; int i; byte b;
/* 283 */     for (i = (arrayOfChar = paramString.toCharArray()).length, b = 0; b < i; b++) {
/* 284 */       char c1; if ((c1 = arrayOfChar[b]) == '\\') {
/* 285 */         if (c == '\\') {
/* 286 */           stringBuilder.append(c1);
/* 287 */           c1 = Character.MIN_VALUE;
/*     */         } 
/*     */       } else {
/*     */         
/* 291 */         stringBuilder.append(c1);
/* 292 */       }  c = c1;
/*     */     } 
/* 294 */     return StringUtil.releaseBuilder(stringBuilder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String escapeCssIdentifier(String paramString) {
/* 302 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/* 303 */     TokenQueue tokenQueue = new TokenQueue(paramString);
/* 304 */     while (!tokenQueue.isEmpty()) {
/* 305 */       if (tokenQueue.matchesCssIdentifier(ElementSelectorChars)) {
/* 306 */         stringBuilder.append(tokenQueue.consume()); continue;
/*     */       } 
/* 308 */       stringBuilder.append('\\').append(tokenQueue.consume());
/*     */     } 
/*     */     
/* 311 */     return StringUtil.releaseBuilder(stringBuilder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean consumeWhitespace() {
/* 319 */     boolean bool = false;
/* 320 */     while (matchesWhitespace()) {
/* 321 */       this.pos++;
/* 322 */       bool = true;
/*     */     } 
/* 324 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String consumeWord() {
/* 332 */     int i = this.pos;
/* 333 */     while (matchesWord())
/* 334 */       this.pos++; 
/* 335 */     return this.queue.substring(i, this.pos);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String consumeElementSelector() {
/* 345 */     return consumeEscapedCssIdentifier(ElementSelectorChars);
/*     */   }
/* 347 */   private static final String[] ElementSelectorChars = new String[] { "*|", "|", "_", "-" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String consumeCssIdentifier() {
/* 355 */     return consumeEscapedCssIdentifier(CssIdentifierChars);
/*     */   }
/* 357 */   private static final String[] CssIdentifierChars = new String[] { "-", "_" };
/*     */ 
/*     */   
/*     */   private String consumeEscapedCssIdentifier(String... paramVarArgs) {
/* 361 */     int i = this.pos;
/* 362 */     boolean bool = false;
/* 363 */     while (!isEmpty()) {
/* 364 */       if (this.queue.charAt(this.pos) == '\\' && remainingLength() > 1) {
/* 365 */         bool = true;
/* 366 */         this.pos += 2; continue;
/* 367 */       }  if (matchesCssIdentifier(paramVarArgs)) {
/* 368 */         this.pos++;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 374 */     String str = this.queue.substring(i, this.pos);
/* 375 */     return bool ? unescape(str) : str;
/*     */   }
/*     */   
/*     */   private boolean matchesCssIdentifier(String... paramVarArgs) {
/* 379 */     return (matchesWord() || matchesAny(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String remainder() {
/* 387 */     String str = this.queue.substring(this.pos);
/* 388 */     this.pos = this.queue.length();
/* 389 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 394 */     return this.queue.substring(this.pos);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\parser\TokenQueue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */