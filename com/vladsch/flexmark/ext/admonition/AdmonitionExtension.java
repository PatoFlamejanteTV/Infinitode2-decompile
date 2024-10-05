/*     */ package com.vladsch.flexmark.ext.admonition;
/*     */ 
/*     */ import com.vladsch.flexmark.ext.admonition.internal.AdmonitionBlockParser;
/*     */ import com.vladsch.flexmark.ext.admonition.internal.AdmonitionNodeFormatter;
/*     */ import com.vladsch.flexmark.ext.admonition.internal.AdmonitionNodeRenderer;
/*     */ import com.vladsch.flexmark.formatter.Formatter;
/*     */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*     */ import com.vladsch.flexmark.html.HtmlRenderer;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*     */ import com.vladsch.flexmark.parser.Parser;
/*     */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*     */ import com.vladsch.flexmark.util.data.DataKey;
/*     */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Reader;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AdmonitionExtension
/*     */   implements Formatter.FormatterExtension, HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension
/*     */ {
/*  27 */   public static final DataKey<Integer> CONTENT_INDENT = new DataKey("ADMONITION.CONTENT_INDENT", Integer.valueOf(4));
/*  28 */   public static final DataKey<Boolean> ALLOW_LEADING_SPACE = new DataKey("ADMONITION.ALLOW_LEADING_SPACE", Boolean.TRUE);
/*  29 */   public static final DataKey<Boolean> INTERRUPTS_PARAGRAPH = new DataKey("ADMONITION.INTERRUPTS_PARAGRAPH", Boolean.TRUE);
/*  30 */   public static final DataKey<Boolean> INTERRUPTS_ITEM_PARAGRAPH = new DataKey("ADMONITION.INTERRUPTS_ITEM_PARAGRAPH", Boolean.TRUE);
/*  31 */   public static final DataKey<Boolean> WITH_SPACES_INTERRUPTS_ITEM_PARAGRAPH = new DataKey("ADMONITION.WITH_SPACES_INTERRUPTS_ITEM_PARAGRAPH", Boolean.TRUE);
/*  32 */   public static final DataKey<Boolean> ALLOW_LAZY_CONTINUATION = new DataKey("ADMONITION.ALLOW_LAZY_CONTINUATION", Boolean.TRUE);
/*  33 */   public static final DataKey<String> UNRESOLVED_QUALIFIER = new DataKey("ADMONITION.UNRESOLVED_QUALIFIER", "note");
/*  34 */   public static final DataKey<Map<String, String>> QUALIFIER_TYPE_MAP = new DataKey("ADMONITION.QUALIFIER_TYPE_MAP", AdmonitionExtension::getQualifierTypeMap);
/*  35 */   public static final DataKey<Map<String, String>> QUALIFIER_TITLE_MAP = new DataKey("ADMONITION.QUALIFIER_TITLE_MAP", AdmonitionExtension::getQualifierTitleMap);
/*  36 */   public static final DataKey<Map<String, String>> TYPE_SVG_MAP = new DataKey("ADMONITION.TYPE_SVG_MAP", AdmonitionExtension::getQualifierSvgValueMap);
/*     */ 
/*     */   
/*     */   public static Map<String, String> getQualifierTypeMap() {
/*     */     HashMap<Object, Object> hashMap;
/*  41 */     (hashMap = new HashMap<>()).put("abstract", "abstract");
/*  42 */     hashMap.put("summary", "abstract");
/*  43 */     hashMap.put("tldr", "abstract");
/*     */     
/*  45 */     hashMap.put("bug", "bug");
/*     */     
/*  47 */     hashMap.put("danger", "danger");
/*  48 */     hashMap.put("error", "danger");
/*     */     
/*  50 */     hashMap.put("example", "example");
/*  51 */     hashMap.put("snippet", "example");
/*     */     
/*  53 */     hashMap.put("fail", "fail");
/*  54 */     hashMap.put("failure", "fail");
/*  55 */     hashMap.put("missing", "fail");
/*     */     
/*  57 */     hashMap.put("faq", "faq");
/*  58 */     hashMap.put("question", "faq");
/*  59 */     hashMap.put("help", "faq");
/*     */     
/*  61 */     hashMap.put("info", "info");
/*  62 */     hashMap.put("todo", "info");
/*     */     
/*  64 */     hashMap.put("note", "note");
/*  65 */     hashMap.put("seealso", "note");
/*     */     
/*  67 */     hashMap.put("quote", "quote");
/*  68 */     hashMap.put("cite", "quote");
/*     */     
/*  70 */     hashMap.put("success", "success");
/*  71 */     hashMap.put("check", "success");
/*  72 */     hashMap.put("done", "success");
/*     */     
/*  74 */     hashMap.put("tip", "tip");
/*  75 */     hashMap.put("hint", "tip");
/*  76 */     hashMap.put("important", "tip");
/*     */     
/*  78 */     hashMap.put("warning", "warning");
/*  79 */     hashMap.put("caution", "warning");
/*  80 */     hashMap.put("attention", "warning");
/*     */     
/*  82 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   public static Map<String, String> getQualifierTitleMap() {
/*     */     HashMap<Object, Object> hashMap;
/*  87 */     (hashMap = new HashMap<>()).put("abstract", "Abstract");
/*  88 */     hashMap.put("summary", "Summary");
/*  89 */     hashMap.put("tldr", "TLDR");
/*     */     
/*  91 */     hashMap.put("bug", "Bug");
/*     */     
/*  93 */     hashMap.put("danger", "Danger");
/*  94 */     hashMap.put("error", "Error");
/*     */     
/*  96 */     hashMap.put("example", "Example");
/*  97 */     hashMap.put("snippet", "Snippet");
/*     */     
/*  99 */     hashMap.put("fail", "Fail");
/* 100 */     hashMap.put("failure", "Failure");
/* 101 */     hashMap.put("missing", "Missing");
/*     */     
/* 103 */     hashMap.put("faq", "Faq");
/* 104 */     hashMap.put("question", "Question");
/* 105 */     hashMap.put("help", "Help");
/*     */     
/* 107 */     hashMap.put("info", "Info");
/* 108 */     hashMap.put("todo", "To Do");
/*     */     
/* 110 */     hashMap.put("note", "Note");
/* 111 */     hashMap.put("seealso", "See Also");
/*     */     
/* 113 */     hashMap.put("quote", "Quote");
/* 114 */     hashMap.put("cite", "Cite");
/*     */     
/* 116 */     hashMap.put("success", "Success");
/* 117 */     hashMap.put("check", "Check");
/* 118 */     hashMap.put("done", "Done");
/*     */     
/* 120 */     hashMap.put("tip", "Tip");
/* 121 */     hashMap.put("hint", "Hint");
/* 122 */     hashMap.put("important", "Important");
/*     */     
/* 124 */     hashMap.put("warning", "Warning");
/* 125 */     hashMap.put("caution", "Caution");
/* 126 */     hashMap.put("attention", "Attention");
/*     */     
/* 128 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   public static Map<String, String> getQualifierSvgValueMap() {
/*     */     HashMap<Object, Object> hashMap;
/* 133 */     (hashMap = new HashMap<>()).put("abstract", getInputStreamContent(AdmonitionExtension.class.getResourceAsStream("/images/adm-abstract.svg")));
/* 134 */     hashMap.put("bug", getInputStreamContent(AdmonitionExtension.class.getResourceAsStream("/images/adm-bug.svg")));
/* 135 */     hashMap.put("danger", getInputStreamContent(AdmonitionExtension.class.getResourceAsStream("/images/adm-danger.svg")));
/* 136 */     hashMap.put("example", getInputStreamContent(AdmonitionExtension.class.getResourceAsStream("/images/adm-example.svg")));
/* 137 */     hashMap.put("fail", getInputStreamContent(AdmonitionExtension.class.getResourceAsStream("/images/adm-fail.svg")));
/* 138 */     hashMap.put("faq", getInputStreamContent(AdmonitionExtension.class.getResourceAsStream("/images/adm-faq.svg")));
/* 139 */     hashMap.put("info", getInputStreamContent(AdmonitionExtension.class.getResourceAsStream("/images/adm-info.svg")));
/* 140 */     hashMap.put("note", getInputStreamContent(AdmonitionExtension.class.getResourceAsStream("/images/adm-note.svg")));
/* 141 */     hashMap.put("quote", getInputStreamContent(AdmonitionExtension.class.getResourceAsStream("/images/adm-quote.svg")));
/* 142 */     hashMap.put("success", getInputStreamContent(AdmonitionExtension.class.getResourceAsStream("/images/adm-success.svg")));
/* 143 */     hashMap.put("tip", getInputStreamContent(AdmonitionExtension.class.getResourceAsStream("/images/adm-tip.svg")));
/* 144 */     hashMap.put("warning", getInputStreamContent(AdmonitionExtension.class.getResourceAsStream("/images/adm-warning.svg")));
/* 145 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   public static String getInputStreamContent(InputStream paramInputStream) {
/*     */     try {
/* 150 */       InputStreamReader inputStreamReader = new InputStreamReader(paramInputStream);
/* 151 */       StringWriter stringWriter = new StringWriter();
/* 152 */       copy(inputStreamReader, stringWriter);
/* 153 */       stringWriter.close();
/* 154 */       return stringWriter.toString();
/* 155 */     } catch (Exception exception) {
/* 156 */       (paramInputStream = null).printStackTrace();
/* 157 */       return "";
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String getDefaultCSS() {
/* 162 */     return getInputStreamContent(AdmonitionExtension.class.getResourceAsStream("/admonition.css"));
/*     */   }
/*     */   
/*     */   public static String getDefaultScript() {
/* 166 */     return getInputStreamContent(AdmonitionExtension.class.getResourceAsStream("/admonition.js"));
/*     */   }
/*     */   
/*     */   public static void copy(Reader paramReader, Writer paramWriter) {
/* 170 */     char[] arrayOfChar = new char[4096];
/*     */     int i;
/* 172 */     while (-1 != (i = paramReader.read(arrayOfChar))) {
/* 173 */       paramWriter.write(arrayOfChar, 0, i);
/*     */     }
/* 175 */     paramWriter.flush();
/* 176 */     paramReader.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AdmonitionExtension create() {
/* 183 */     return new AdmonitionExtension();
/*     */   }
/*     */ 
/*     */   
/*     */   public void extend(Formatter.Builder paramBuilder) {
/* 188 */     paramBuilder.nodeFormatterFactory((NodeFormatterFactory)new AdmonitionNodeFormatter.Factory());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rendererOptions(MutableDataHolder paramMutableDataHolder) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void parserOptions(MutableDataHolder paramMutableDataHolder) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void extend(Parser.Builder paramBuilder) {
/* 203 */     paramBuilder.customBlockParserFactory((CustomBlockParserFactory)new AdmonitionBlockParser.Factory());
/*     */   }
/*     */ 
/*     */   
/*     */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 208 */     if (paramBuilder.isRendererType("HTML")) {
/* 209 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new AdmonitionNodeRenderer.Factory()); return;
/* 210 */     }  paramBuilder.isRendererType("JIRA");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\admonition\AdmonitionExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */