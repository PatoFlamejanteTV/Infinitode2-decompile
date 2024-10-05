/*     */ package org.jsoup.nodes;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Pattern;
/*     */ import org.jsoup.SerializationException;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.internal.Normalizer;
/*     */ import org.jsoup.internal.StringUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Attribute
/*     */   implements Cloneable, Map.Entry<String, String>
/*     */ {
/*  19 */   private static final String[] booleanAttributes = new String[] { "allowfullscreen", "async", "autofocus", "checked", "compact", "declare", "default", "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", "open", "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch" };
/*     */ 
/*     */ 
/*     */   
/*     */   private String key;
/*     */ 
/*     */ 
/*     */   
/*     */   private String val;
/*     */ 
/*     */ 
/*     */   
/*     */   Attributes parent;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attribute(String paramString1, String paramString2) {
/*  37 */     this(paramString1, paramString2, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attribute(String paramString1, String paramString2, Attributes paramAttributes) {
/*  47 */     Validate.notNull(paramString1);
/*     */     
/*  49 */     Validate.notEmpty(paramString1 = paramString1.trim());
/*  50 */     this.key = paramString1;
/*  51 */     this.val = paramString2;
/*  52 */     this.parent = paramAttributes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getKey() {
/*  61 */     return this.key;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKey(String paramString) {
/*  69 */     Validate.notNull(paramString);
/*     */     
/*  71 */     Validate.notEmpty(paramString = paramString.trim());
/*     */ 
/*     */ 
/*     */     
/*  75 */     String str = this.parent.keys[i];
/*  76 */     this.parent.keys[i] = paramString;
/*     */     
/*     */     int i;
/*     */     Map<String, Range.AttributeRange> map;
/*  80 */     if (this.parent != null && (i = this.parent.indexOfKey(this.key)) != -1 && (map = this.parent.getRanges()) != null) {
/*  81 */       Range.AttributeRange attributeRange = map.remove(str);
/*  82 */       map.put(paramString, attributeRange);
/*     */     } 
/*     */ 
/*     */     
/*  86 */     this.key = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValue() {
/*  95 */     return Attributes.checkNotNull(this.val);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasDeclaredValue() {
/* 103 */     return (this.val != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String setValue(String paramString) {
/* 112 */     String str = this.val; int i;
/* 113 */     if (this.parent != null && (
/*     */       
/* 115 */       i = this.parent.indexOfKey(this.key)) != -1) {
/* 116 */       str = this.parent.get(this.key);
/* 117 */       this.parent.vals[i] = paramString;
/*     */     } 
/*     */     
/* 120 */     this.val = paramString;
/* 121 */     return Attributes.checkNotNull(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String html() {
/* 129 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/*     */     
/*     */     try {
/* 132 */       html(stringBuilder, (new Document("")).outputSettings());
/* 133 */     } catch (IOException iOException) {
/* 134 */       throw new SerializationException(iOException);
/*     */     } 
/* 136 */     return StringUtil.releaseBuilder((StringBuilder)iOException);
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
/*     */   public Range.AttributeRange sourceRange() {
/* 152 */     if (this.parent == null) return Range.AttributeRange.UntrackedAttr; 
/* 153 */     return this.parent.sourceRange(this.key);
/*     */   }
/*     */   
/*     */   protected void html(Appendable paramAppendable, Document.OutputSettings paramOutputSettings) {
/* 157 */     html(this.key, this.val, paramAppendable, paramOutputSettings);
/*     */   }
/*     */ 
/*     */   
/*     */   protected static void html(String paramString1, String paramString2, Appendable paramAppendable, Document.OutputSettings paramOutputSettings) {
/* 162 */     if ((paramString1 = getValidKey(paramString1, paramOutputSettings.syntax())) == null)
/* 163 */       return;  htmlNoValidate(paramString1, paramString2, paramAppendable, paramOutputSettings);
/*     */   }
/*     */ 
/*     */   
/*     */   static void htmlNoValidate(String paramString1, String paramString2, Appendable paramAppendable, Document.OutputSettings paramOutputSettings) {
/* 168 */     paramAppendable.append(paramString1);
/* 169 */     if (!shouldCollapseAttribute(paramString1, paramString2, paramOutputSettings)) {
/* 170 */       paramAppendable.append("=\"");
/* 171 */       Entities.escape(paramAppendable, Attributes.checkNotNull(paramString2), paramOutputSettings, true, false, false, false);
/* 172 */       paramAppendable.append('"');
/*     */     } 
/*     */   }
/*     */   
/* 176 */   private static final Pattern xmlKeyValid = Pattern.compile("[a-zA-Z_:][-a-zA-Z0-9_:.]*");
/* 177 */   private static final Pattern xmlKeyReplace = Pattern.compile("[^-a-zA-Z0-9_:.]");
/* 178 */   private static final Pattern htmlKeyValid = Pattern.compile("[^\\x00-\\x1f\\x7f-\\x9f \"'/=]+");
/* 179 */   private static final Pattern htmlKeyReplace = Pattern.compile("[\\x00-\\x1f\\x7f-\\x9f \"'/=]");
/*     */ 
/*     */   
/*     */   public static String getValidKey(String paramString, Document.OutputSettings.Syntax paramSyntax) {
/* 183 */     if (paramSyntax == Document.OutputSettings.Syntax.xml && !xmlKeyValid.matcher(paramString).matches()) {
/* 184 */       paramString = xmlKeyReplace.matcher(paramString).replaceAll("");
/* 185 */       return xmlKeyValid.matcher(paramString).matches() ? paramString : null;
/*     */     } 
/* 187 */     if (paramSyntax == Document.OutputSettings.Syntax.html && !htmlKeyValid.matcher(paramString).matches()) {
/* 188 */       paramString = htmlKeyReplace.matcher(paramString).replaceAll("");
/* 189 */       return htmlKeyValid.matcher(paramString).matches() ? paramString : null;
/*     */     } 
/* 191 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 200 */     return html();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Attribute createFromEncoded(String paramString1, String paramString2) {
/* 210 */     paramString2 = Entities.unescape(paramString2, true);
/* 211 */     return new Attribute(paramString1, paramString2, null);
/*     */   }
/*     */   
/*     */   protected boolean isDataAttribute() {
/* 215 */     return isDataAttribute(this.key);
/*     */   }
/*     */   
/*     */   protected static boolean isDataAttribute(String paramString) {
/* 219 */     return (paramString.startsWith("data-") && paramString.length() > 5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean shouldCollapseAttribute(Document.OutputSettings paramOutputSettings) {
/* 229 */     return shouldCollapseAttribute(this.key, this.val, paramOutputSettings);
/*     */   }
/*     */ 
/*     */   
/*     */   protected static boolean shouldCollapseAttribute(String paramString1, String paramString2, Document.OutputSettings paramOutputSettings) {
/* 234 */     if (paramOutputSettings
/* 235 */       .syntax() == Document.OutputSettings.Syntax.html && (paramString2 == null || ((paramString2
/* 236 */       .isEmpty() || paramString2.equalsIgnoreCase(paramString1)) && isBooleanAttribute(paramString1)))) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isBooleanAttribute(String paramString) {
/* 243 */     return (Arrays.binarySearch((Object[])booleanAttributes, Normalizer.lowerCase(paramString)) >= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 248 */     if (this == paramObject) return true; 
/* 249 */     if (paramObject == null || getClass() != paramObject.getClass()) return false; 
/* 250 */     paramObject = paramObject;
/* 251 */     if ((this.key != null) ? !this.key.equals(((Attribute)paramObject).key) : (((Attribute)paramObject).key != null)) return false; 
/* 252 */     return (this.val != null) ? this.val.equals(((Attribute)paramObject).val) : ((((Attribute)paramObject).val == null));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 257 */     int i = (this.key != null) ? this.key.hashCode() : 0;
/*     */     
/* 259 */     return i = i * 31 + ((this.val != null) ? this.val.hashCode() : 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public Attribute clone() {
/*     */     try {
/* 265 */       return (Attribute)super.clone();
/* 266 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 267 */       throw new RuntimeException(cloneNotSupportedException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\nodes\Attribute.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */