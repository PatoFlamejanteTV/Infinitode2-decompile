/*     */ package nonapi.io.github.classgraph.json;
/*     */ 
/*     */ import java.util.AbstractMap;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import nonapi.io.github.classgraph.types.ParseException;
/*     */ import nonapi.io.github.classgraph.types.Parser;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class JSONParser
/*     */   extends Parser
/*     */ {
/*     */   private JSONParser(String paramString) {
/*  56 */     super(paramString);
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
/*     */   private int getAndParseHexChar() {
/*     */     char c;
/*  70 */     if ((c = getc()) >= '0' && c <= '9')
/*  71 */       return c - 48; 
/*  72 */     if (c >= 'a' && c <= 'f')
/*  73 */       return c - 97 + 10; 
/*  74 */     if (c >= 'A' && c <= 'F') {
/*  75 */       return c - 65 + 10;
/*     */     }
/*  77 */     throw new ParseException(this, "Invalid character in Unicode escape sequence: " + c);
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
/*     */   private CharSequence parseString() {
/*  99 */     skipWhitespace();
/* 100 */     if (peek() != '"') {
/* 101 */       return null;
/*     */     }
/* 103 */     next();
/* 104 */     int i = getPosition();
/*     */ 
/*     */     
/* 107 */     int j = 0;
/* 108 */     while (hasMore()) {
/*     */       char c;
/* 110 */       if ((c = getc()) == '\\') {
/* 111 */         switch (getc()) {
/*     */           case '"':
/*     */           case '\'':
/*     */           case '/':
/*     */           case '\\':
/*     */           case 'b':
/*     */           case 'f':
/*     */           case 'n':
/*     */           case 'r':
/*     */           case 't':
/* 121 */             j = 1;
/*     */             continue;
/*     */           case 'u':
/* 124 */             j = 1;
/* 125 */             advance(4);
/*     */             continue;
/*     */         } 
/* 128 */         throw new ParseException(this, "Invalid escape sequence: \\" + c);
/*     */       } 
/* 130 */       if (c != '"');
/*     */     } 
/*     */ 
/*     */     
/* 134 */     int k = getPosition() - 1;
/* 135 */     if (!j) {
/* 136 */       return getSubsequence(i, k);
/*     */     }
/*     */ 
/*     */     
/* 140 */     setPosition(i);
/* 141 */     StringBuilder stringBuilder = new StringBuilder();
/* 142 */     while (hasMore()) {
/*     */       
/* 144 */       if ((j = getc()) == '\\') {
/*     */         
/* 146 */         switch (k = getc()) {
/*     */           case 98:
/* 148 */             stringBuilder.append('\b');
/*     */             continue;
/*     */           case 102:
/* 151 */             stringBuilder.append('\f');
/*     */             continue;
/*     */           case 110:
/* 154 */             stringBuilder.append('\n');
/*     */             continue;
/*     */           case 114:
/* 157 */             stringBuilder.append('\r');
/*     */             continue;
/*     */           case 116:
/* 160 */             stringBuilder.append('\t');
/*     */             continue;
/*     */           case 34:
/*     */           case 39:
/*     */           case 47:
/*     */           case 92:
/* 166 */             stringBuilder.append(k);
/*     */             continue;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case 117:
/* 173 */             j = (j = (j = (j = getAndParseHexChar() << 12) | getAndParseHexChar() << 8) | getAndParseHexChar() << 4) | getAndParseHexChar();
/* 174 */             stringBuilder.append((char)j);
/*     */             continue;
/*     */         } 
/* 177 */         throw new ParseException(this, "Invalid escape sequence: \\" + j);
/*     */       } 
/* 179 */       if (j != 34)
/*     */       {
/*     */         
/* 182 */         stringBuilder.append(j);
/*     */       }
/*     */     } 
/* 185 */     skipWhitespace();
/* 186 */     return stringBuilder.toString();
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
/*     */   private Number parseNumber() {
/* 213 */     int i = getPosition();
/* 214 */     if (peekMatches("Infinity")) {
/* 215 */       advance(8);
/* 216 */       return Double.valueOf(Double.POSITIVE_INFINITY);
/* 217 */     }  if (peekMatches("-Infinity")) {
/* 218 */       advance(9);
/* 219 */       return Double.valueOf(Double.NEGATIVE_INFINITY);
/* 220 */     }  if (peekMatches("NaN")) {
/* 221 */       advance(3);
/* 222 */       return Double.valueOf(Double.NaN);
/*     */     } 
/* 224 */     if (peek() == '-') {
/* 225 */       next();
/*     */     }
/* 227 */     int j = getPosition(); char c;
/* 228 */     for (; hasMore() && (
/*     */       
/* 230 */       c = peek()) >= '0' && c <= '9'; next());
/*     */ 
/*     */     
/*     */     int k;
/*     */ 
/*     */     
/* 236 */     if ((j = (k = getPosition()) - j) == 0) {
/* 237 */       throw new ParseException(this, "Expected a number");
/*     */     }
/*     */     boolean bool1;
/* 240 */     if (bool1 = (peek() == '.') ? true : false) {
/* 241 */       next(); char c1;
/* 242 */       for (; hasMore() && (
/*     */         
/* 244 */         c1 = peek()) >= '0' && c1 <= '9'; next());
/*     */ 
/*     */ 
/*     */       
/* 248 */       if (getPosition() - k + 1 == 0) {
/* 249 */         throw new ParseException(this, "Expected digits after decimal point");
/*     */       }
/*     */     } 
/*     */     boolean bool2;
/* 253 */     if (bool2 = (peek() == 'e' || peek() == 'E') ? true : false) {
/* 254 */       next();
/*     */       
/* 256 */       if ((k = peek()) == 45 || k == 43) {
/* 257 */         next();
/*     */       }
/* 259 */       k = getPosition(); char c1;
/* 260 */       for (; hasMore() && (
/*     */         
/* 262 */         c1 = peek()) >= '0' && c1 <= '9'; next());
/*     */ 
/*     */ 
/*     */       
/* 266 */       if (getPosition() - k == 0) {
/* 267 */         throw new ParseException(this, "Expected an exponent");
/*     */       }
/*     */     } 
/* 270 */     k = getPosition();
/* 271 */     String str = getSubstring(i, k);
/* 272 */     if (bool1 || bool2)
/* 273 */       return Double.valueOf(str); 
/* 274 */     if (j < 10)
/* 275 */       return Integer.valueOf(str); 
/* 276 */     if (j == 10) {
/*     */       long l;
/*     */       
/* 279 */       if ((l = Long.parseLong(str)) >= -2147483648L && l <= 2147483647L) {
/* 280 */         return Integer.valueOf((int)l);
/*     */       }
/* 282 */       return Long.valueOf(l);
/*     */     } 
/*     */     
/* 285 */     return Long.valueOf(str);
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
/*     */   private JSONArray parseJSONArray() {
/* 305 */     expect('[');
/* 306 */     skipWhitespace();
/* 307 */     if (peek() == ']') {
/*     */       
/* 309 */       next();
/* 310 */       return new JSONArray(Collections.emptyList());
/*     */     } 
/*     */     
/* 313 */     ArrayList<Object> arrayList = new ArrayList();
/* 314 */     boolean bool = true;
/* 315 */     while (peek() != ']') {
/* 316 */       if (bool) {
/* 317 */         bool = false;
/*     */       } else {
/* 319 */         expect(',');
/*     */       } 
/* 321 */       arrayList.add(parseJSON());
/*     */     } 
/* 323 */     expect(']');
/* 324 */     return new JSONArray(arrayList);
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
/*     */   private JSONObject parseJSONObject() {
/* 344 */     expect('{');
/* 345 */     skipWhitespace();
/* 346 */     if (peek() == '}') {
/*     */       
/* 348 */       next();
/* 349 */       return new JSONObject(Collections.emptyList());
/*     */     } 
/*     */     
/* 352 */     ArrayList<Map.Entry<String, Object>> arrayList = new ArrayList();
/* 353 */     JSONObject jSONObject = new JSONObject(arrayList);
/* 354 */     boolean bool = true;
/* 355 */     while (peek() != '}') {
/* 356 */       if (bool) {
/* 357 */         bool = false;
/*     */       } else {
/* 359 */         expect(',');
/*     */       } 
/*     */       CharSequence charSequence;
/* 362 */       if ((charSequence = parseString()) == null) {
/* 363 */         throw new ParseException(this, "Object keys must be strings");
/*     */       }
/* 365 */       if (peek() != ':') {
/* 366 */         return null;
/*     */       }
/* 368 */       expect(':');
/* 369 */       Object object = parseJSON();
/*     */ 
/*     */       
/* 372 */       if (charSequence.equals("__ID")) {
/* 373 */         if (object == null) {
/* 374 */           throw new ParseException(this, "Got null value for \"__ID\" key");
/*     */         }
/* 376 */         jSONObject.objectId = (CharSequence)object; continue;
/*     */       } 
/* 378 */       arrayList.add(new AbstractMap.SimpleEntry<>(charSequence.toString(), object));
/*     */     } 
/*     */     
/* 381 */     expect('}');
/* 382 */     return jSONObject;
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
/*     */   private Object parseJSON() {
/*     */     JSONObject jSONObject;
/*     */     JSONArray jSONArray;
/* 405 */     skipWhitespace();
/*     */     char c;
/* 407 */     if ((c = peek()) == '{') {
/*     */       
/* 409 */       jSONObject = parseJSONObject();
/* 410 */       skipWhitespace();
/* 411 */       return jSONObject;
/*     */     } 
/* 413 */     if (jSONObject == 91) {
/*     */       
/* 415 */       jSONArray = parseJSONArray();
/* 416 */       skipWhitespace();
/* 417 */       return jSONArray;
/*     */     } 
/* 419 */     if (jSONArray == 34) {
/*     */       
/* 421 */       CharSequence charSequence = parseString();
/* 422 */       skipWhitespace();
/* 423 */       if (charSequence == null) {
/* 424 */         throw new ParseException(this, "Invalid string");
/*     */       }
/* 426 */       return charSequence;
/*     */     } 
/* 428 */     if (peekMatches("true")) {
/*     */       
/* 430 */       advance(4);
/* 431 */       skipWhitespace();
/* 432 */       return Boolean.TRUE;
/*     */     } 
/* 434 */     if (peekMatches("false")) {
/*     */       
/* 436 */       advance(5);
/* 437 */       skipWhitespace();
/* 438 */       return Boolean.FALSE;
/*     */     } 
/* 440 */     if (peekMatches("null")) {
/*     */       
/* 442 */       advance(4);
/* 443 */       skipWhitespace();
/* 444 */       return null;
/*     */     } 
/*     */ 
/*     */     
/* 448 */     Number number = parseNumber();
/* 449 */     skipWhitespace();
/* 450 */     return number;
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
/*     */   static Object parseJSON(String paramString) {
/* 464 */     return (new JSONParser(paramString)).parseJSON();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\json\JSONParser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */