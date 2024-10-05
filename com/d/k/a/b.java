/*     */ package com.d.k.a;
/*     */ 
/*     */ import com.d.m.l;
/*     */ import java.util.logging.Level;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class b
/*     */   extends a
/*     */ {
/*     */   public final String d(Element paramElement) {
/*  63 */     switch (paramElement.getNodeName()) {
/*     */       case "table":
/*  65 */         return n(paramElement);
/*     */       case "td":
/*     */       case "th":
/*  68 */         return m(paramElement);
/*     */       case "tr":
/*  70 */         return o(paramElement);
/*     */       case "img":
/*  72 */         return l(paramElement);
/*     */       case "p":
/*     */       case "div":
/*  75 */         return k(paramElement);
/*     */       case "textarea":
/*  77 */         return j(paramElement);
/*     */       case "input":
/*  79 */         return i(paramElement);
/*     */       case "svg":
/*  81 */         return h(paramElement);
/*     */     } 
/*     */     
/*  84 */     return "";
/*     */   }
/*     */   private String h(Element paramElement) {
/*     */     StringBuilder stringBuilder;
/*  88 */     String str2 = paramElement.getAttribute("width");
/*  89 */     String str3 = paramElement.getAttribute("height");
/*     */     
/*  91 */     if (!str2.isEmpty() || !str3.isEmpty()) {
/*  92 */       stringBuilder = new StringBuilder();
/*     */       
/*  94 */       if (!str2.isEmpty()) {
/*  95 */         stringBuilder.append("width: ");
/*  96 */         stringBuilder.append(str2);
/*  97 */         if (b(str2)) {
/*  98 */           stringBuilder.append("px");
/*     */         }
/* 100 */         stringBuilder.append(';');
/*     */       } 
/*     */       
/* 103 */       if (!str3.isEmpty()) {
/* 104 */         stringBuilder.append("height: ");
/* 105 */         stringBuilder.append(str3);
/* 106 */         if (b(str3)) {
/* 107 */           stringBuilder.append("px");
/*     */         }
/* 109 */         stringBuilder.append(';');
/*     */       } 
/*     */       
/* 112 */       return stringBuilder.toString();
/*     */     } 
/*     */ 
/*     */     
/*     */     String str1, arrayOfString[];
/*     */     
/* 118 */     if ((arrayOfString = (str1 = stringBuilder.getAttribute("viewBox")).split("\\s+")).length != 4) {
/* 119 */       return "";
/*     */     }
/*     */     try {
/* 122 */       int j = Integer.parseInt(arrayOfString[2]);
/* 123 */       int i = Integer.parseInt(arrayOfString[3]);
/*     */       
/*     */       StringBuilder stringBuilder1;
/*     */       
/* 127 */       (stringBuilder1 = new StringBuilder()).append("width: ");
/* 128 */       stringBuilder1.append(j);
/* 129 */       stringBuilder1.append("px;");
/*     */       
/* 131 */       stringBuilder1.append("height: ");
/* 132 */       stringBuilder1.append(i);
/* 133 */       stringBuilder1.append("px;");
/* 134 */     } catch (NumberFormatException numberFormatException) {
/* 135 */       l.d(Level.WARNING, "Invalid integer passed in viewBox attribute for SVG: " + str1);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 140 */     return "";
/*     */   }
/*     */   
/*     */   private String i(Element paramElement) {
/* 144 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 146 */     if (paramElement.hasAttribute("width") && b(paramElement.getAttribute("width"))) {
/* 147 */       stringBuilder.append("width: ");
/* 148 */       stringBuilder.append(paramElement.getAttribute("width"));
/* 149 */       stringBuilder.append("px;");
/* 150 */     } else if (paramElement.hasAttribute("size") && b(paramElement.getAttribute("size"))) {
/* 151 */       stringBuilder.append("width: ");
/* 152 */       stringBuilder.append(paramElement.getAttribute("size"));
/* 153 */       stringBuilder.append("em;");
/*     */     } 
/*     */     
/* 156 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String j(Element paramElement) {
/* 160 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 162 */     if (paramElement.hasAttribute("cols") && b(paramElement.getAttribute("cols"))) {
/* 163 */       stringBuilder.append("width: ");
/* 164 */       stringBuilder.append(paramElement.getAttribute("cols"));
/* 165 */       stringBuilder.append("em;");
/*     */     } 
/*     */     
/* 168 */     if (paramElement.hasAttribute("rows") && b(paramElement.getAttribute("rows"))) {
/* 169 */       stringBuilder.append("height: ");
/* 170 */       stringBuilder.append(paramElement.getAttribute("rows"));
/* 171 */       stringBuilder.append("em;");
/*     */     } 
/*     */     
/* 174 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String k(Element paramElement) {
/* 178 */     StringBuilder stringBuilder = new StringBuilder();
/* 179 */     b(paramElement, stringBuilder);
/* 180 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String l(Element paramElement) {
/* 184 */     StringBuilder stringBuilder = new StringBuilder();
/* 185 */     a(paramElement, stringBuilder);
/* 186 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String m(Element paramElement) {
/* 190 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*     */     Element element;
/*     */     
/* 194 */     if ((element = p(paramElement)) != null) {
/*     */       String str1;
/* 196 */       if ((str1 = b(element, "cellpadding")) != null) {
/* 197 */         stringBuilder.append("padding: ");
/* 198 */         stringBuilder.append(a(str1));
/* 199 */         stringBuilder.append(";");
/*     */       } 
/*     */       
/* 202 */       if ((str1 = b(element, "border")) != null && !str1.equals("0")) {
/* 203 */         stringBuilder.append("border: 1px outset black;");
/*     */       }
/*     */     } 
/*     */     String str;
/* 207 */     if ((str = b(paramElement, "width")) != null) {
/* 208 */       stringBuilder.append("width: ");
/* 209 */       stringBuilder.append(a(str));
/* 210 */       stringBuilder.append(";");
/*     */     } 
/*     */     
/* 213 */     if ((str = b(paramElement, "height")) != null) {
/* 214 */       stringBuilder.append("height: ");
/* 215 */       stringBuilder.append(a(str));
/* 216 */       stringBuilder.append(";");
/*     */     } 
/* 218 */     c(paramElement, stringBuilder);
/*     */     
/* 220 */     if ((str = b(paramElement, "bgcolor")) != null) {
/* 221 */       str = str.toLowerCase();
/* 222 */       stringBuilder.append("background-color: ");
/* 223 */       if (c(str)) {
/* 224 */         stringBuilder.append('#');
/* 225 */         stringBuilder.append(str);
/*     */       } else {
/* 227 */         stringBuilder.append(str);
/*     */       } 
/* 229 */       stringBuilder.append(';');
/*     */     } 
/*     */     
/* 232 */     if ((str = b(paramElement, "background")) != null) {
/* 233 */       stringBuilder.append("background-image: url(");
/* 234 */       stringBuilder.append(str);
/* 235 */       stringBuilder.append(");");
/*     */     } 
/* 237 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String n(Element paramElement) {
/* 241 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*     */     String str;
/* 244 */     if ((str = b(paramElement, "width")) != null) {
/* 245 */       stringBuilder.append("width: ");
/* 246 */       stringBuilder.append(a(str));
/* 247 */       stringBuilder.append(";");
/*     */     } 
/*     */     
/* 250 */     if ((str = b(paramElement, "border")) != null) {
/* 251 */       stringBuilder.append("border: ");
/* 252 */       stringBuilder.append(a(str));
/* 253 */       stringBuilder.append(" inset black;");
/*     */     } 
/*     */     
/* 256 */     if ((str = b(paramElement, "cellspacing")) != null) {
/* 257 */       stringBuilder.append("border-collapse: separate; border-spacing: ");
/* 258 */       stringBuilder.append(a(str));
/* 259 */       stringBuilder.append(";");
/*     */     } 
/*     */     
/* 262 */     if ((str = b(paramElement, "bgcolor")) != null) {
/* 263 */       str = str.toLowerCase();
/* 264 */       stringBuilder.append("background-color: ");
/* 265 */       if (c(str)) {
/* 266 */         stringBuilder.append('#');
/* 267 */         stringBuilder.append(str);
/*     */       } else {
/* 269 */         stringBuilder.append(str);
/*     */       } 
/* 271 */       stringBuilder.append(';');
/*     */     } 
/*     */     
/* 274 */     if ((str = b(paramElement, "background")) != null) {
/* 275 */       stringBuilder.append("background-image: url(");
/* 276 */       stringBuilder.append(str);
/* 277 */       stringBuilder.append(");");
/*     */     } 
/* 279 */     a(paramElement, stringBuilder);
/* 280 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String o(Element paramElement) {
/* 284 */     StringBuilder stringBuilder = new StringBuilder();
/* 285 */     c(paramElement, stringBuilder);
/* 286 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(Element paramElement, StringBuilder paramStringBuilder) {
/*     */     String str;
/* 292 */     if ((str = b(paramElement, "align")) != null) {
/*     */       
/* 294 */       if ((str = str.toLowerCase().trim()).equals("left")) {
/* 295 */         paramStringBuilder.append("float: left;"); return;
/* 296 */       }  if (str.equals("right")) {
/* 297 */         paramStringBuilder.append("float: right;"); return;
/* 298 */       }  if (str.equals("center")) {
/* 299 */         paramStringBuilder.append("margin-left: auto; margin-right: auto;");
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(Element paramElement, StringBuilder paramStringBuilder) {
/*     */     String str;
/* 307 */     if ((str = b(paramElement, "align")) != null && ((
/*     */       
/* 309 */       str = str.toLowerCase().trim()).equals("left") || str.equals("right") || str
/* 310 */       .equals("center") || str.equals("justify"))) {
/* 311 */       paramStringBuilder.append("text-align: ");
/* 312 */       paramStringBuilder.append(str);
/* 313 */       paramStringBuilder.append(";");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(Element paramElement, StringBuilder paramStringBuilder) {
/*     */     String str;
/* 321 */     if ((str = b(paramElement, "align")) != null) {
/* 322 */       paramStringBuilder.append("text-align: ");
/* 323 */       paramStringBuilder.append(str.toLowerCase());
/* 324 */       paramStringBuilder.append(";");
/*     */     } 
/*     */     
/* 327 */     if ((str = b(paramElement, "valign")) != null) {
/* 328 */       paramStringBuilder.append("vertical-align: ");
/* 329 */       paramStringBuilder.append(str.toLowerCase());
/* 330 */       paramStringBuilder.append(";");
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean c(String paramString) {
/* 335 */     if (paramString.length() != 6) {
/* 336 */       return false;
/*     */     }
/* 338 */     for (byte b1 = 0; b1 < paramString.length(); b1++) {
/*     */       char c;
/*     */       
/* 341 */       if ((c = (((c = paramString.charAt(b1)) >= '0' && c <= '9') || (c >= 'a' && c <= 'f')) ? '\001' : Character.MIN_VALUE) == '\000') {
/* 342 */         return false;
/*     */       }
/*     */     } 
/* 345 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static Element p(Element paramElement) {
/*     */     Node node;
/* 351 */     if ((node = paramElement.getParentNode()).getNodeType() == 1 && (
/*     */       
/* 353 */       node = node).getNodeName().equals("tr") && (
/*     */       
/* 355 */       node = node.getParentNode()).getNodeType() == 1) {
/*     */       String str;
/*     */       
/* 358 */       if ((str = (node = node).getNodeName()).equals("table")) {
/* 359 */         return (Element)node;
/*     */       }
/*     */       
/* 362 */       if ((str.equals("tbody") || str.equals("tfoot") || str.equals("thead")) && (
/*     */         
/* 364 */         node = node.getParentNode()).getNodeType() == 1 && (
/*     */         
/* 366 */         node = node).getNodeName().equals("table")) {
/* 367 */         return (Element)node;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 375 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\k\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */