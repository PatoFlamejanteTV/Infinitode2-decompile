/*     */ package nonapi.io.github.classgraph.types;
/*     */ 
/*     */ import nonapi.io.github.classgraph.json.JSONUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Parser
/*     */ {
/*     */   private final String string;
/*     */   private int position;
/*  44 */   private final StringBuilder token = new StringBuilder();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object state;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int SHOW_BEFORE = 80;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int SHOW_AFTER = 80;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Parser(String paramString) {
/*  64 */     if (paramString == null) {
/*  65 */       throw new ParseException(null, "Cannot parse null string");
/*     */     }
/*  67 */     this.string = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPositionInfo() {
/*  76 */     int i = Math.max(0, this.position - 80);
/*  77 */     int j = Math.min(this.string.length(), this.position + 80);
/*  78 */     return "before: \"" + JSONUtils.escapeJSONString(this.string.substring(i, this.position)) + "\"; after: \"" + 
/*  79 */       JSONUtils.escapeJSONString(this.string.substring(this.position, j)) + "\"; position: " + this.position + "; token: \"" + this.token + "\"";
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
/*     */   public Object setState(Object paramObject) {
/*  91 */     Object object = this.state;
/*  92 */     this.state = paramObject;
/*  93 */     return object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getState() {
/* 102 */     return this.state;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char getc() {
/* 113 */     if (this.position >= this.string.length()) {
/* 114 */       throw new ParseException(this, "Ran out of input while parsing");
/*     */     }
/* 116 */     return this.string.charAt(this.position++);
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
/*     */   public void expect(char paramChar) {
/*     */     char c;
/* 129 */     if ((c = getc()) != paramChar) {
/* 130 */       throw new ParseException(this, "Expected '" + paramChar + "'; got '" + (char)c + "'");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char peek() {
/* 140 */     return (this.position == this.string.length()) ? Character.MIN_VALUE : this.string.charAt(this.position);
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
/*     */   public void peekExpect(char paramChar) {
/* 153 */     if (this.position == this.string.length()) {
/* 154 */       throw new ParseException(this, "Expected '" + paramChar + "'; reached end of string");
/*     */     }
/*     */     char c;
/* 157 */     if ((c = this.string.charAt(this.position)) != paramChar) {
/* 158 */       throw new ParseException(this, "Expected '" + paramChar + "'; got '" + c + "'");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean peekMatches(String paramString) {
/* 170 */     return this.string.regionMatches(this.position, paramString, 0, paramString.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void next() {
/* 177 */     this.position++;
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
/*     */   public void advance(int paramInt) {
/* 189 */     if (this.position + paramInt >= this.string.length()) {
/* 190 */       throw new IllegalArgumentException("Invalid skip distance");
/*     */     }
/* 192 */     this.position += paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasMore() {
/* 201 */     return (this.position < this.string.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPosition() {
/* 210 */     return this.position;
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
/*     */   public void setPosition(int paramInt) {
/* 222 */     if (paramInt < 0 || paramInt >= this.string.length()) {
/* 223 */       throw new IllegalArgumentException("Invalid position");
/*     */     }
/* 225 */     this.position = paramInt;
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
/*     */   public CharSequence getSubsequence(int paramInt1, int paramInt2) {
/* 238 */     return this.string.subSequence(paramInt1, paramInt2);
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
/*     */   public String getSubstring(int paramInt1, int paramInt2) {
/* 251 */     return this.string.substring(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendToToken(String paramString) {
/* 261 */     this.token.append(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendToToken(char paramChar) {
/* 271 */     this.token.append(paramChar);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void skipWhitespace() {
/*     */     char c;
/* 278 */     while (this.position < this.string.length() && ((
/*     */       
/* 280 */       c = this.string.charAt(this.position)) == ' ' || c == '\n' || c == '\r' || c == '\t')) {
/* 281 */       this.position++;
/*     */     }
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
/*     */   public String currToken() {
/* 294 */     String str = this.token.toString();
/* 295 */     this.token.setLength(0);
/* 296 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 304 */     return getPositionInfo();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\types\Parser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */