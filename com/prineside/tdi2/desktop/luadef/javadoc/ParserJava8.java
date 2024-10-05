/*     */ package com.prineside.tdi2.desktop.luadef.javadoc;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.desktop.luadef.JavadocHandler;
/*     */ import com.prineside.tdi2.desktop.luadef.LuaDefUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ 
/*     */ public class ParserJava8
/*     */   extends ParserVariant {
/*  15 */   private static final TLog a = TLog.forClass(ParserJava8.class);
/*     */ 
/*     */ 
/*     */   
/*     */   public int getScore(Document paramDocument) {
/*  20 */     byte b = 0;
/*  21 */     if (paramDocument.select("body > .contentContainer > .description > .blockList > .blockList > .block").size() != 0) {
/*  22 */       b++;
/*     */     }
/*  24 */     if (paramDocument.select("body > .header > h2.title").size() != 0) {
/*  25 */       b++;
/*     */     }
/*  27 */     if (paramDocument.select("body > .contentContainer > .summary").size() != 0) {
/*  28 */       b++;
/*     */     }
/*  30 */     if (paramDocument.select("a[name=constructor\\.detail]").size() != 0) {
/*  31 */       b++;
/*     */     }
/*  33 */     if (paramDocument.select("a[name=method\\.summary]").size() != 0) {
/*  34 */       b++;
/*     */     }
/*  36 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, String> getClassGenerics(Document paramDocument, Class<?> paramClass) {
/*  41 */     return parseGenerics(paramDocument.select("body > .header > .title").first().text(), paramClass);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getClassGenericsString(Document paramDocument) {
/*  46 */     return parseGenericsString(paramDocument.select("body > .header > .title").first().text());
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<JavadocHandler.FieldJD> getFields(Document paramDocument, Class<?> paramClass) {
/*  51 */     Array array = LuaDefUtils.gatherFieldsCached(paramClass);
/*     */     
/*  53 */     Array<JavadocHandler.FieldJD> array1 = new Array();
/*     */     Element element;
/*  55 */     if ((element = paramDocument.select("a[name=\"field.detail\"]").first()) != null) {
/*  56 */       for (Iterator<Element> iterator = element.parent().select("ul.blockList > li.blockList").iterator(); iterator.hasNext(); ) {
/*  57 */         Element element1; String str2 = sanitizeHtmlString((element1 = iterator.next()).select("h4").first().text());
/*     */         String str1;
/*  59 */         if ((element1 = element1.select(".block").first()) != null && (
/*     */           
/*  61 */           str1 = sanitizeHtmlString(element1.text())).length() != 0) {
/*  62 */           Field field = null;
/*  63 */           for (byte b = 0; b < array.size; b++) {
/*  64 */             if (((Field[])array.items)[b].getName().equals(str2)) {
/*  65 */               field = ((Field[])array.items)[b];
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*  70 */           if (field != null) {
/*     */             JavadocHandler.FieldJD fieldJD;
/*  72 */             (fieldJD = new JavadocHandler.FieldJD()).field = field;
/*  73 */             fieldJD.description = str1;
/*  74 */             array1.add(fieldJD);
/*  75 */             if (verbose) a.i("/+\\ field '" + str2 + "' in " + paramClass, new Object[0]);
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*  81 */     return array1;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getClassDescription(Document paramDocument) {
/*     */     Element element;
/*  87 */     if ((element = paramDocument.select("body > .contentContainer > .description > .blockList > .blockList > .block").first()) == null) {
/*  88 */       return null;
/*     */     }
/*  90 */     return JavadocHandler.formatDocumentation(element.outerHtml(), 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<JavadocHandler.ConstructorJD> getConstructors(Document paramDocument, Class<?> paramClass) {
/*  96 */     Map<String, String> map = getClassGenerics(paramDocument, paramClass);
/*     */     
/*  98 */     Array<JavadocHandler.ConstructorJD> array = new Array();
/*     */     Element element;
/* 100 */     if ((element = paramDocument.select("a[name=\"constructor.detail\"]").first()) != null)
/*     */     {
/* 102 */       for (Iterator<Element> iterator = (element = element.parent()).select("ul.blockList > li.blockList").iterator(); iterator.hasNext(); ) {
/*     */         Iterator<Element> iterator1;
/*     */         
/*     */         Element element1, element2;
/* 106 */         if ((element2 = (element1 = iterator.next()).select("pre").first()) != null) {
/* 107 */           String str = element2.text();
/*     */           try {
/*     */             JavadocHandler.ConstructorJD constructorJD;
/* 110 */             if ((constructorJD = parseConstructorSignature(str, paramClass, map)) != null) {
/*     */               Element element3;
/*     */               
/* 113 */               if ((element3 = element1.select(".block").first()) != null) {
/* 114 */                 constructorJD.description = JavadocHandler.formatDocumentation(element3.outerHtml(), 4);
/*     */               }
/*     */               
/* 117 */               if (constructorJD.params.size != 0)
/*     */               {
/*     */ 
/*     */                 
/* 121 */                 if ((element1 = element1.select("dl").first()) != null)
/*     */                 
/* 123 */                 { boolean bool = false;
/* 124 */                   for (iterator1 = element1.children().iterator(); iterator1.hasNext(); ) {
/* 125 */                     Element element4; if ((element4 = iterator1.next()).tagName().equals("dt")) {
/*     */                       
/* 127 */                       bool = (element4.select(".paramLabel").size() != 0) ? true : false; continue;
/* 128 */                     }  if (element4.tagName().equals("dd") && 
/* 129 */                       bool)
/*     */                     {
/* 131 */                       parseConstructorParamDD(element4, constructorJD);
/*     */                     }
/*     */                   }
/*     */                    }
/*     */                 
/* 136 */                 else if (verbose) { a.i("<dl> not found for " + constructorJD.ctor + " - probably no parameter descriptions, will be skipped", new Object[0]); }
/*     */               
/*     */               }
/*     */               
/* 140 */               array.add(constructorJD);
/*     */             } 
/* 142 */           } catch (Exception exception) {
/* 143 */             a.w("Exception while parsing ctor signature \"" + str + "\" of " + paramClass, new Object[] { exception });
/*     */           }  continue;
/*     */         } 
/* 146 */         a.w("ctor sig not found in \"" + sanitizeHtmlString(iterator1.outerHtml()) + "\" of " + paramClass, new Object[0]);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 151 */     return array;
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<JavadocHandler.MethodJD> getMethods(Document paramDocument, Class<?> paramClass) {
/* 156 */     Map<String, String> map = getClassGenerics(paramDocument, paramClass);
/*     */     
/* 158 */     Array<JavadocHandler.MethodJD> array = new Array();
/*     */     Element element;
/* 160 */     if ((element = paramDocument.select("a[name=\"method.detail\"]").first()) != null)
/*     */     {
/* 162 */       for (Iterator<Element> iterator = (element = element.parent()).select("ul.blockList > li.blockList").iterator(); iterator.hasNext();) {
/*     */         
/* 164 */         if ((methodJD = getMethodOldImpl(element1 = iterator.next(), map, paramClass)) != null) {
/* 165 */           array.add(methodJD);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 170 */     return array;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\desktop\luadef\javadoc\ParserJava8.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */