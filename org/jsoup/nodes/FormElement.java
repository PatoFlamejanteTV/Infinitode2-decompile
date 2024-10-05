/*     */ package org.jsoup.nodes;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.jsoup.Connection;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.helper.HttpConnection;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.parser.Tag;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormElement
/*     */   extends Element
/*     */ {
/*  18 */   private final Elements elements = new Elements();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormElement(Tag paramTag, String paramString, Attributes paramAttributes) {
/*  28 */     super(paramTag, paramString, paramAttributes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements elements() {
/*  36 */     return this.elements;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormElement addElement(Element paramElement) {
/*  45 */     this.elements.add(paramElement);
/*  46 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void removeChild(Node paramNode) {
/*  51 */     super.removeChild(paramNode);
/*  52 */     this.elements.remove(paramNode);
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
/*     */   public Connection submit() {
/*     */     String str;
/*  67 */     Validate.notEmpty(str = hasAttr("action") ? absUrl("action") : baseUri(), "Could not determine a form action URL for submit. Ensure you set a base URI when parsing.");
/*     */     
/*  69 */     Connection.Method method = attr("method").equalsIgnoreCase("POST") ? Connection.Method.POST : Connection.Method.GET;
/*     */     
/*     */     Document document;
/*     */     Connection connection;
/*  73 */     return (connection = ((document = ownerDocument()) != null) ? document.connection().newRequest() : Jsoup.newSession()).url(str)
/*  74 */       .data(formData())
/*  75 */       .method(method);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Connection.KeyVal> formData() {
/*  84 */     ArrayList<HttpConnection.KeyVal> arrayList = new ArrayList();
/*     */ 
/*     */     
/*  87 */     for (Iterator<Element> iterator = this.elements.iterator(); iterator.hasNext();) {
/*  88 */       if ((element = iterator.next()).tag().isFormSubmittable() && 
/*  89 */         !element.hasAttr("disabled") && (
/*     */         
/*  91 */         str1 = element.attr("name")).length() != 0 && 
/*     */ 
/*     */         
/*  94 */         !(str2 = element.attr("type")).equalsIgnoreCase("button") && !str2.equalsIgnoreCase("image")) {
/*     */         Element element1;
/*  96 */         if (element.nameIs("select")) {
/*  97 */           Elements elements = element.select("option[selected]");
/*  98 */           boolean bool = false;
/*  99 */           for (Element element2 : elements) {
/* 100 */             arrayList.add(HttpConnection.KeyVal.create(str1, element2.val()));
/* 101 */             bool = true;
/*     */           } 
/* 103 */           if (!bool && (
/*     */             
/* 105 */             element1 = element.selectFirst("option")) != null)
/* 106 */             arrayList.add(HttpConnection.KeyVal.create(str1, element1.val()));  continue;
/*     */         } 
/* 108 */         if ("checkbox".equalsIgnoreCase((String)element1) || "radio".equalsIgnoreCase((String)element1)) {
/*     */           
/* 110 */           if (element.hasAttr("checked")) {
/* 111 */             String str = (element.val().length() > 0) ? element.val() : "on";
/* 112 */             arrayList.add(HttpConnection.KeyVal.create(str1, str));
/*     */           }  continue;
/*     */         } 
/* 115 */         arrayList.add(HttpConnection.KeyVal.create(str1, element.val()));
/*     */       } 
/*     */     } 
/* 118 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public FormElement clone() {
/* 123 */     return (FormElement)super.clone();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\nodes\FormElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */