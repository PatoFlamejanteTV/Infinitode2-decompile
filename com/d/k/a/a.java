/*     */ package com.d.k.a;
/*     */ 
/*     */ import com.d.c.b.c;
/*     */ import com.d.i.a.r;
/*     */ import com.d.k.a;
/*     */ import com.d.l.b;
/*     */ import com.d.m.b;
/*     */ import com.d.m.l;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.w3c.dom.CharacterData;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
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
/*     */ public class a
/*     */   extends a
/*     */ {
/*     */   private static b a;
/*     */   private static boolean b = false;
/*  57 */   private final Map c = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/*  65 */     return "http://www.w3.org/1999/xhtml";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a(Element paramElement) {
/*  75 */     return paramElement.getAttribute("class");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String b(Element paramElement) {
/*     */     String str;
/*  86 */     return ((str = paramElement.getAttribute("id").trim()).length() == 0) ? null : str;
/*     */   }
/*     */   
/*     */   protected final String a(String paramString) {
/*  90 */     if (b(paramString)) {
/*  91 */       return paramString + "px";
/*     */     }
/*  93 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   protected static boolean b(String paramString) {
/*  98 */     for (byte b1 = 0; b1 < paramString.length(); b1++) {
/*     */       char c;
/* 100 */       if ((c = paramString.charAt(b1)) < '0' || c > '9') {
/* 101 */         return false;
/*     */       }
/*     */     } 
/* 104 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected static String b(Element paramElement, String paramString) {
/*     */     String str;
/* 110 */     return ((str = (str = paramElement.getAttribute(paramString)).trim()).length() == 0) ? null : str;
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
/*     */   public final String f(Element paramElement) {
/* 153 */     String str = null;
/* 154 */     if (paramElement.getNodeName().equalsIgnoreCase("a") && paramElement.hasAttribute("href")) {
/* 155 */       str = paramElement.getAttribute("href");
/*     */     }
/* 157 */     return str;
/*     */   }
/*     */   public final String g(Element paramElement) {
/* 160 */     if (paramElement != null && paramElement.getNodeName().equalsIgnoreCase("a") && paramElement
/* 161 */       .hasAttribute("name")) {
/* 162 */       return paramElement.getAttribute("name");
/*     */     }
/* 164 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String c(Element paramElement) {
/* 173 */     StringBuilder stringBuilder = new StringBuilder();
/* 174 */     if (paramElement.getNodeName().equals("td") || paramElement.getNodeName().equals("th")) {
/*     */       String str;
/*     */       
/* 177 */       if ((str = b(paramElement, "colspan")) != null) {
/* 178 */         stringBuilder.append("-fs-table-cell-colspan: ");
/* 179 */         stringBuilder.append(str);
/* 180 */         stringBuilder.append(";");
/*     */       } 
/*     */       
/* 183 */       if ((str = b(paramElement, "rowspan")) != null) {
/* 184 */         stringBuilder.append("-fs-table-cell-rowspan: ");
/* 185 */         stringBuilder.append(str);
/* 186 */         stringBuilder.append(";");
/*     */       } 
/* 188 */     } else if (paramElement.getNodeName().equals("img")) {
/*     */       String str;
/*     */       
/* 191 */       if ((str = b(paramElement, "width")) != null) {
/* 192 */         stringBuilder.append("width: ");
/* 193 */         stringBuilder.append(a(str));
/* 194 */         stringBuilder.append(";");
/*     */       } 
/*     */       
/* 197 */       if ((str = b(paramElement, "height")) != null) {
/* 198 */         stringBuilder.append("height: ");
/* 199 */         stringBuilder.append(a(str));
/* 200 */         stringBuilder.append(";");
/*     */       } 
/* 202 */     } else if (paramElement.getNodeName().equals("colgroup") || paramElement.getNodeName().equals("col")) {
/*     */       String str;
/*     */       
/* 205 */       if ((str = b(paramElement, "span")) != null) {
/* 206 */         stringBuilder.append("-fs-table-cell-colspan: ");
/* 207 */         stringBuilder.append(str);
/* 208 */         stringBuilder.append(";");
/*     */       } 
/*     */       
/* 211 */       if ((str = b(paramElement, "width")) != null) {
/* 212 */         stringBuilder.append("width: ");
/* 213 */         stringBuilder.append(a(str));
/* 214 */         stringBuilder.append(";");
/*     */       } 
/*     */     } 
/* 217 */     stringBuilder.append(paramElement.getAttribute("style"));
/* 218 */     return stringBuilder.toString();
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
/*     */   private static Element c(Element paramElement, String paramString) {
/* 243 */     NodeList nodeList = paramElement.getChildNodes();
/* 244 */     for (byte b1 = 0; b1 < nodeList.getLength(); b1++) {
/*     */       Node node;
/* 246 */       if ((node = nodeList.item(b1)).getNodeType() == 1 && node.getNodeName().equals(paramString)) {
/* 247 */         return (Element)node;
/*     */       }
/*     */     } 
/*     */     
/* 251 */     return null;
/*     */   }
/*     */   private static b h(Element paramElement) {
/* 254 */     String str2 = paramElement.getAttribute("media");
/* 255 */     if ("".equals(str2)) {
/* 256 */       str2 = "all";
/*     */     }
/*     */     b b1;
/* 259 */     (b1 = new b()).c(str2);
/* 260 */     paramElement.getAttribute("type");
/* 261 */     paramElement.getAttribute("title");
/* 262 */     b1.a(2);
/*     */     
/* 264 */     StringBuilder stringBuilder = new StringBuilder();
/* 265 */     Node node = paramElement.getFirstChild();
/* 266 */     while (node != null) {
/* 267 */       if (node instanceof CharacterData) {
/* 268 */         stringBuilder.append(((CharacterData)node).getData());
/*     */       }
/* 270 */       node = node.getNextSibling();
/*     */     } 
/*     */     
/*     */     String str1;
/* 274 */     if ((str1 = stringBuilder.toString().trim()).length() > 0) {
/* 275 */       b1.e(str1);
/*     */       
/* 277 */       return b1;
/*     */     } 
/* 279 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private static b i(Element paramElement) {
/*     */     String str;
/* 285 */     if ((str = paramElement.getAttribute("rel").toLowerCase()).indexOf("alternate") != -1) {
/* 286 */       return null;
/*     */     }
/* 288 */     if (str.indexOf("stylesheet") == -1) {
/* 289 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 293 */     if (!(str = paramElement.getAttribute("type")).equals("") && !str.equals("text/css")) {
/* 294 */       return null;
/*     */     }
/*     */     
/* 297 */     b b1 = new b();
/*     */     
/* 299 */     str.equals("");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 304 */     b1.a(2);
/*     */     
/* 306 */     b1.b(paramElement.getAttribute("href"));
/* 307 */     str = paramElement.getAttribute("media");
/* 308 */     if ("".equals(str)) {
/* 309 */       str = "all";
/*     */     }
/* 311 */     b1.c(str);
/*     */     
/* 313 */     paramElement.getAttribute("title");
/*     */ 
/*     */     
/* 316 */     return b1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final b[] a(Document paramDocument) {
/*     */     ArrayList<?> arrayList;
/* 328 */     (arrayList = new ArrayList()).addAll(Arrays.asList((Object[])super.a(paramDocument)));
/*     */ 
/*     */     
/*     */     Element element;
/*     */     
/* 333 */     if ((element = c(element = paramDocument.getDocumentElement(), "head")) != null) {
/* 334 */       Node node = element.getFirstChild();
/* 335 */       while (node != null) {
/* 336 */         if (node.getNodeType() == 1) {
/* 337 */           Element element1 = (Element)node;
/* 338 */           b b1 = null;
/*     */           String str;
/* 340 */           if ((str = element1.getLocalName()) == null)
/*     */           {
/* 342 */             str = element1.getTagName();
/*     */           }
/* 344 */           if (str.equals("link")) {
/* 345 */             b1 = i(element1);
/* 346 */           } else if (str.equals("style")) {
/* 347 */             b1 = h(element1);
/*     */           } 
/* 349 */           if (b1 != null) {
/* 350 */             arrayList.add(b1);
/*     */           }
/*     */         } 
/* 353 */         node = node.getNextSibling();
/*     */       } 
/*     */     } 
/*     */     
/* 357 */     return arrayList.<b>toArray(new b[arrayList.size()]);
/*     */   }
/*     */   
/*     */   public final b a(c paramc) {
/* 361 */     synchronized (a.class) {
/* 362 */       if (a != null) {
/* 363 */         return a;
/*     */       }
/*     */       
/* 366 */       if (b) {
/* 367 */         return null;
/*     */       }
/*     */       
/*     */       b b1;
/* 371 */       (b1 = new b()).b(a());
/* 372 */       b1.a(0);
/* 373 */       b1.c("all");
/*     */ 
/*     */       
/* 376 */       InputStream inputStream = null;
/*     */       try {
/* 378 */         inputStream = b();
/*     */         
/* 380 */         if (b) {
/* 381 */           paramc = null; return (b)paramc;
/*     */         } 
/*     */         
/* 384 */         r r = paramc.a(new InputStreamReader(inputStream), b1);
/* 385 */         b1.a(r);
/*     */         
/* 387 */         inputStream.close();
/* 388 */         inputStream = null;
/* 389 */       } catch (Exception exception) {
/* 390 */         b = true;
/* 391 */         l.a("Could not parse default stylesheet", exception);
/*     */       } finally {
/* 393 */         if (inputStream != null) {
/*     */           try {
/* 395 */             inputStream.close();
/* 396 */           } catch (IOException iOException) {}
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 404 */       return a = b1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private InputStream b() {
/* 410 */     String str = b.a("xr.css.user-agent-default-css") + "XhtmlNamespaceHandler.css";
/*     */     InputStream inputStream;
/* 412 */     if ((inputStream = getClass().getResourceAsStream(str)) == null) {
/* 413 */       l.c("Can't load default CSS from " + str + ".This file must be on your CLASSPATH. Please check before continuing.");
/*     */       
/* 415 */       b = true;
/*     */     } 
/*     */     
/* 418 */     return inputStream;
/*     */   }
/*     */   
/*     */   private Map b(Document paramDocument) {
/* 422 */     if (this.c != null) {
/* 423 */       return this.c;
/*     */     }
/*     */     
/* 426 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*     */     Element element;
/*     */     
/* 430 */     if ((element = c(element = paramDocument.getDocumentElement(), "head")) != null) {
/* 431 */       Node node = element.getFirstChild();
/* 432 */       while (node != null) {
/* 433 */         if (node.getNodeType() == 1) {
/*     */           Element element1;
/*     */           String str;
/* 436 */           if ((str = (element1 = (Element)node).getLocalName()) == null)
/*     */           {
/* 438 */             str = element1.getTagName();
/*     */           }
/* 440 */           if (str.equals("meta")) {
/* 441 */             str = element1.getAttribute("http-equiv");
/* 442 */             String str1 = element1.getAttribute("content");
/*     */             
/* 444 */             if (!str.equals("") && !str1.equals("")) {
/* 445 */               hashMap.put(str, str1);
/*     */             }
/*     */           } 
/*     */         } 
/* 449 */         node = node.getNextSibling();
/*     */       } 
/*     */     } 
/*     */     
/* 453 */     return hashMap;
/*     */   }
/*     */   
/*     */   public final String e(Element paramElement) {
/*     */     String str;
/* 458 */     if ((str = paramElement.getAttribute("lang")).equals("") && (
/*     */       
/* 460 */       str = (String)b(paramElement.getOwnerDocument()).get("Content-Language")) == null) {
/* 461 */       str = "";
/*     */     }
/*     */     
/* 464 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\k\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */