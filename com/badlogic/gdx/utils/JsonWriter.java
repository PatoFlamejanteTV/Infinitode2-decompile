/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import java.io.Writer;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class JsonWriter
/*     */   extends Writer
/*     */ {
/*     */   final Writer writer;
/*  29 */   private final Array<JsonObject> stack = new Array<>();
/*     */   private JsonObject current;
/*     */   private boolean named;
/*  32 */   private OutputType outputType = OutputType.json;
/*     */   private boolean quoteLongValues = false;
/*     */   
/*     */   public JsonWriter(Writer paramWriter) {
/*  36 */     this.writer = paramWriter;
/*     */   }
/*     */   
/*     */   public Writer getWriter() {
/*  40 */     return this.writer;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOutputType(OutputType paramOutputType) {
/*  45 */     this.outputType = paramOutputType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQuoteLongValues(boolean paramBoolean) {
/*  51 */     this.quoteLongValues = paramBoolean;
/*     */   }
/*     */   
/*     */   public JsonWriter name(String paramString) {
/*  55 */     if (this.current == null || this.current.array) throw new IllegalStateException("Current item must be an object."); 
/*  56 */     if (!this.current.needsComma) {
/*  57 */       this.current.needsComma = true;
/*     */     } else {
/*  59 */       this.writer.write(44);
/*  60 */     }  this.writer.write(this.outputType.quoteName(paramString));
/*  61 */     this.writer.write(58);
/*  62 */     this.named = true;
/*  63 */     return this;
/*     */   }
/*     */   
/*     */   public JsonWriter object() {
/*  67 */     requireCommaOrName();
/*  68 */     this.stack.add(this.current = new JsonObject(false));
/*  69 */     return this;
/*     */   }
/*     */   
/*     */   public JsonWriter array() {
/*  73 */     requireCommaOrName();
/*  74 */     this.stack.add(this.current = new JsonObject(true));
/*  75 */     return this;
/*     */   }
/*     */   
/*     */   public JsonWriter value(@Null Object paramObject) {
/*  79 */     if (this.quoteLongValues && (paramObject instanceof Long || paramObject instanceof Double || paramObject instanceof java.math.BigDecimal || paramObject instanceof java.math.BigInteger)) {
/*     */       
/*  81 */       paramObject = paramObject.toString();
/*  82 */     } else if (paramObject instanceof Number) {
/*     */       Number number;
/*  84 */       long l = (number = (Number)paramObject).longValue();
/*  85 */       if (number.doubleValue() == l) paramObject = Long.valueOf(l); 
/*     */     } 
/*  87 */     requireCommaOrName();
/*  88 */     this.writer.write(this.outputType.quoteValue(paramObject));
/*  89 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public JsonWriter json(String paramString) {
/*  94 */     requireCommaOrName();
/*  95 */     this.writer.write(paramString);
/*  96 */     return this;
/*     */   }
/*     */   
/*     */   private void requireCommaOrName() {
/* 100 */     if (this.current == null)
/* 101 */       return;  if (this.current.array) {
/* 102 */       if (!this.current.needsComma) {
/* 103 */         this.current.needsComma = true; return;
/*     */       } 
/* 105 */       this.writer.write(44); return;
/*     */     } 
/* 107 */     if (!this.named) throw new IllegalStateException("Name must be set."); 
/* 108 */     this.named = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public JsonWriter object(String paramString) {
/* 113 */     return name(paramString).object();
/*     */   }
/*     */   
/*     */   public JsonWriter array(String paramString) {
/* 117 */     return name(paramString).array();
/*     */   }
/*     */   
/*     */   public JsonWriter set(String paramString, Object paramObject) {
/* 121 */     return name(paramString).value(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public JsonWriter json(String paramString1, String paramString2) {
/* 126 */     return name(paramString1).json(paramString2);
/*     */   }
/*     */   
/*     */   public JsonWriter pop() {
/* 130 */     if (this.named) throw new IllegalStateException("Expected an object, array, or value since a name was set."); 
/* 131 */     ((JsonObject)this.stack.pop()).close();
/* 132 */     this.current = (this.stack.size == 0) ? null : this.stack.peek();
/* 133 */     return this;
/*     */   }
/*     */   
/*     */   public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 137 */     this.writer.write(paramArrayOfchar, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void flush() {
/* 141 */     this.writer.flush();
/*     */   }
/*     */   
/*     */   public void close() {
/* 145 */     while (this.stack.size > 0)
/* 146 */       pop(); 
/* 147 */     this.writer.close();
/*     */   }
/*     */   
/*     */   private class JsonObject {
/*     */     final boolean array;
/*     */     boolean needsComma;
/*     */     
/*     */     JsonObject(boolean param1Boolean) {
/* 155 */       this.array = param1Boolean;
/* 156 */       JsonWriter.this.writer.write(param1Boolean ? 91 : 123);
/*     */     }
/*     */     
/*     */     void close() {
/* 160 */       JsonWriter.this.writer.write(this.array ? 93 : 125);
/*     */     }
/*     */   }
/*     */   
/*     */   public enum OutputType
/*     */   {
/* 166 */     json,
/*     */     
/* 168 */     javascript,
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
/* 180 */     minimal;
/*     */     
/* 182 */     private static Pattern javascriptPattern = Pattern.compile("^[a-zA-Z_$][a-zA-Z_$0-9]*$");
/* 183 */     private static Pattern minimalNamePattern = Pattern.compile("^[^\":,}/ ][^:]*$");
/* 184 */     private static Pattern minimalValuePattern = Pattern.compile("^[^\":,{\\[\\]/ ][^}\\],]*$");
/*     */     
/*     */     public final String quoteValue(@Null Object param1Object) {
/* 187 */       if (param1Object == null) return "null"; 
/* 188 */       String str = param1Object.toString();
/* 189 */       if (param1Object instanceof Number || param1Object instanceof Boolean) return str;
/*     */       
/* 191 */       (param1Object = new StringBuilder(str)).replace('\\', "\\\\").replace('\r', "\\r").replace('\n', "\\n").replace('\t', "\\t"); int i;
/* 192 */       if (this == minimal && !str.equals("true") && !str.equals("false") && !str.equals("null") && 
/* 193 */         !str.contains("//") && !str.contains("/*") && (
/*     */         
/* 195 */         i = param1Object.length()) > 0 && param1Object.charAt(i - 1) != ' ' && minimalValuePattern.matcher((CharSequence)param1Object).matches()) {
/* 196 */         return param1Object.toString();
/*     */       }
/* 198 */       return "\"" + param1Object.replace('"', "\\\"").toString() + '"';
/*     */     }
/*     */     
/*     */     static {
/*     */     
/*     */     }
/*     */     
/*     */     public final String quoteName(String param1String) {
/*     */       // Byte code:
/*     */       //   0: new com/badlogic/gdx/utils/StringBuilder
/*     */       //   3: dup
/*     */       //   4: aload_1
/*     */       //   5: invokespecial <init> : (Ljava/lang/String;)V
/*     */       //   8: dup
/*     */       //   9: astore_2
/*     */       //   10: bipush #92
/*     */       //   12: ldc '\\'
/*     */       //   14: invokevirtual replace : (CLjava/lang/String;)Lcom/badlogic/gdx/utils/StringBuilder;
/*     */       //   17: bipush #13
/*     */       //   19: ldc '\r'
/*     */       //   21: invokevirtual replace : (CLjava/lang/String;)Lcom/badlogic/gdx/utils/StringBuilder;
/*     */       //   24: bipush #10
/*     */       //   26: ldc '\n'
/*     */       //   28: invokevirtual replace : (CLjava/lang/String;)Lcom/badlogic/gdx/utils/StringBuilder;
/*     */       //   31: bipush #9
/*     */       //   33: ldc '\t'
/*     */       //   35: invokevirtual replace : (CLjava/lang/String;)Lcom/badlogic/gdx/utils/StringBuilder;
/*     */       //   38: pop
/*     */       //   39: getstatic com/badlogic/gdx/utils/JsonWriter$1.$SwitchMap$com$badlogic$gdx$utils$JsonWriter$OutputType : [I
/*     */       //   42: aload_0
/*     */       //   43: invokevirtual ordinal : ()I
/*     */       //   46: iaload
/*     */       //   47: lookupswitch default -> 126, 1 -> 72, 2 -> 108
/*     */       //   72: aload_1
/*     */       //   73: ldc '//'
/*     */       //   75: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*     */       //   78: ifne -> 108
/*     */       //   81: aload_1
/*     */       //   82: ldc '/*'
/*     */       //   84: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*     */       //   87: ifne -> 108
/*     */       //   90: getstatic com/badlogic/gdx/utils/JsonWriter$OutputType.minimalNamePattern : Ljava/util/regex/Pattern;
/*     */       //   93: aload_2
/*     */       //   94: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */       //   97: invokevirtual matches : ()Z
/*     */       //   100: ifeq -> 108
/*     */       //   103: aload_2
/*     */       //   104: invokevirtual toString : ()Ljava/lang/String;
/*     */       //   107: areturn
/*     */       //   108: getstatic com/badlogic/gdx/utils/JsonWriter$OutputType.javascriptPattern : Ljava/util/regex/Pattern;
/*     */       //   111: aload_2
/*     */       //   112: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */       //   115: invokevirtual matches : ()Z
/*     */       //   118: ifeq -> 126
/*     */       //   121: aload_2
/*     */       //   122: invokevirtual toString : ()Ljava/lang/String;
/*     */       //   125: areturn
/*     */       //   126: new java/lang/StringBuilder
/*     */       //   129: dup
/*     */       //   130: ldc '"'
/*     */       //   132: invokespecial <init> : (Ljava/lang/String;)V
/*     */       //   135: aload_2
/*     */       //   136: bipush #34
/*     */       //   138: ldc '\"'
/*     */       //   140: invokevirtual replace : (CLjava/lang/String;)Lcom/badlogic/gdx/utils/StringBuilder;
/*     */       //   143: invokevirtual toString : ()Ljava/lang/String;
/*     */       //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   149: bipush #34
/*     */       //   151: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */       //   154: invokevirtual toString : ()Ljava/lang/String;
/*     */       //   157: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #202	-> 0
/*     */       //   #203	-> 9
/*     */       //   #204	-> 39
/*     */       //   #206	-> 72
/*     */       //   #207	-> 103
/*     */       //   #209	-> 108
/*     */       //   #211	-> 126
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\JsonWriter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */