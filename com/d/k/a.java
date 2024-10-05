/*     */ package com.d.k;
/*     */ 
/*     */ import com.d.c.b.c;
/*     */ import com.d.d.l;
/*     */ import com.d.l.b;
/*     */ import java.util.ArrayList;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.w3c.dom.Attr;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NamedNodeMap;
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
/*     */ 
/*     */ public class a
/*     */   implements l
/*     */ {
/*     */   public String a() {
/*  51 */     return "http://www.w3.org/XML/1998/namespace";
/*     */   }
/*     */   
/*     */   public final String a(Element paramElement, String paramString) {
/*  55 */     return paramElement.hasAttribute(paramString) ? paramElement.getAttribute(paramString) : null;
/*     */   } public final String a(Element paramElement, String paramString1, String paramString2) {
/*     */     NamedNodeMap namedNodeMap;
/*     */     int i;
/*  59 */     if (paramString1 == "")
/*  60 */       return a(paramElement, paramString2); 
/*  61 */     if (paramString1 == null) {
/*  62 */       if (paramElement.getLocalName() == null) {
/*  63 */         return a(paramElement, paramString2);
/*     */       }
/*     */       
/*  66 */       i = (namedNodeMap = paramElement.getAttributes()).getLength();
/*  67 */       for (byte b = 0; b < i; b++) {
/*  68 */         Attr attr = (Attr)namedNodeMap.item(b);
/*  69 */         if (paramString2.equals(attr.getLocalName())) {
/*  70 */           return attr.getValue();
/*     */         }
/*     */       } 
/*     */       
/*  74 */       return null;
/*     */     } 
/*     */     
/*  77 */     return namedNodeMap.hasAttributeNS(i, paramString2) ? namedNodeMap.getAttributeNS(i, paramString2) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String a(Element paramElement) {
/*  82 */     return null;
/*     */   }
/*     */   
/*     */   public String b(Element paramElement) {
/*  86 */     return null;
/*     */   }
/*     */   
/*     */   public String e(Element paramElement) {
/*  90 */     return paramElement.getAttribute("lang");
/*     */   }
/*     */   
/*     */   public String c(Element paramElement) {
/*  94 */     return null;
/*     */   }
/*     */   
/*     */   public String d(Element paramElement) {
/*  98 */     return null;
/*     */   }
/*     */   
/*     */   public String f(Element paramElement) {
/* 102 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String g(Element paramElement) {
/* 110 */     return null;
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
/* 125 */   private Pattern a = Pattern.compile("type\\s?=\\s?");
/* 126 */   private Pattern b = Pattern.compile("href\\s?=\\s?");
/* 127 */   private Pattern c = Pattern.compile("title\\s?=\\s?");
/* 128 */   private Pattern d = Pattern.compile("alternate\\s?=\\s?");
/* 129 */   private Pattern e = Pattern.compile("media\\s?=\\s?");
/*     */   
/*     */   public b[] a(Document paramDocument) {
/* 132 */     ArrayList<b> arrayList = new ArrayList();
/*     */ 
/*     */     
/* 135 */     NodeList nodeList = paramDocument.getChildNodes(); byte b; int i;
/* 136 */     for (b = 0, i = nodeList.getLength(); b < i; b++) {
/*     */       Node node;
/* 138 */       if ((node = nodeList.item(b)).getNodeType() == 7 && (
/*     */         
/* 140 */         node = node).getTarget().equals("xml-stylesheet")) {
/*     */         b b1;
/*     */         
/* 143 */         (b1 = new b()).a(2);
/* 144 */         String str1 = node.getData();
/*     */ 
/*     */         
/* 147 */         int j = matcher.end();
/*     */         Matcher matcher;
/*     */         String str2;
/* 150 */         if (!(matcher = this.d.matcher(str1)).matches() || !(str2 = str1.substring(j + 1, str1.indexOf(str1.charAt(j), j + 1))).equals("yes")) {
/*     */ 
/*     */ 
/*     */           
/* 154 */           int k = matcher1.end();
/*     */           String str;
/*     */           Matcher matcher1;
/* 157 */           if (!(matcher1 = this.a.matcher(str1)).find() || (str = str1.substring(k + 1, str1.indexOf(str1.charAt(k), k + 1))).equals("text/css"))
/*     */           { Matcher matcher2;
/*     */ 
/*     */             
/* 161 */             if ((matcher2 = this.b.matcher(str1)).find()) {
/* 162 */               int m = matcher2.end();
/* 163 */               String str3 = str1.substring(m + 1, str1.indexOf(str1.charAt(m), m + 1));
/* 164 */               b1.b(str3);
/*     */             } 
/*     */             
/* 167 */             if ((matcher2 = this.c.matcher(str1)).find()) {
/* 168 */               int m = matcher2.end();
/* 169 */               str1.substring(m + 1, str1.indexOf(str1.charAt(m), m + 1));
/*     */             } 
/*     */ 
/*     */             
/* 173 */             if ((matcher2 = this.e.matcher(str1)).find()) {
/* 174 */               int m = matcher2.end();
/* 175 */               String str3 = str1.substring(m + 1, str1.indexOf(str1.charAt(m), m + 1));
/* 176 */               b1.c(str3);
/*     */             } else {
/* 178 */               b1.d("screen");
/*     */             } 
/* 180 */             arrayList.add(b1); } 
/*     */         } 
/*     */       } 
/* 183 */     }  return arrayList.<b>toArray(new b[arrayList.size()]);
/*     */   }
/*     */   
/*     */   public b a(c paramc) {
/* 187 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\k\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */