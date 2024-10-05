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
/*     */ public final class ParserGdx
/*     */   extends ParserVariant {
/*  15 */   private static final TLog a = TLog.forClass(ParserGdx.class);
/*     */ 
/*     */   
/*     */   public final int getScore(Document paramDocument) {
/*  19 */     byte b = 0;
/*     */ 
/*     */     
/*  22 */     if (paramDocument
/*  23 */       .select("body > main > .header > .subTitle > .packageLabelInType").size() != 0 && paramDocument
/*  24 */       .select("body > main > .header > h2.title").size() != 0)
/*     */     {
/*  26 */       b++;
/*     */     }
/*     */     
/*  29 */     if (paramDocument.select("body > main > .contentContainer > .summary").size() != 0) {
/*  30 */       b++;
/*     */     }
/*     */     
/*  33 */     if (paramDocument.select("a#method\\.detail").size() != 0) {
/*  34 */       b++;
/*     */     }
/*     */     
/*  37 */     if (paramDocument.select("a#constructor\\.detail").size() != 0) {
/*  38 */       b++;
/*     */     }
/*     */ 
/*     */     
/*  42 */     if (paramDocument.select("body > main > .contentContainer > .description > .blockList > .blockList > .block").size() != 0) {
/*  43 */       b++;
/*     */     }
/*  45 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Array<JavadocHandler.FieldJD> getFields(Document paramDocument, Class<?> paramClass) {
/*  50 */     Array array = LuaDefUtils.gatherFieldsCached(paramClass);
/*     */     
/*  52 */     Array<JavadocHandler.FieldJD> array1 = new Array();
/*     */     Element element;
/*  54 */     if ((element = paramDocument.select("#field\\.summary").first()) != null)
/*  55 */       for (Iterator<Element> iterator = element.parent().select("table > tbody > tr").iterator(); iterator.hasNext();) {
/*  56 */         if ((element1 = iterator.next()).hasAttr("class")) {
/*     */           
/*  58 */           String str2 = sanitizeHtmlString(element1.select(".colSecond").text());
/*     */           String str1;
/*  60 */           if ((str1 = sanitizeHtmlString(element1.select("td.colLast").first().text())).length() != 0) {
/*  61 */             Field field = null;
/*  62 */             for (byte b = 0; b < array.size; b++) {
/*  63 */               if (((Field[])array.items)[b].getName().equals(str2)) {
/*  64 */                 field = ((Field[])array.items)[b];
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*  69 */             if (field != null) {
/*     */               JavadocHandler.FieldJD fieldJD;
/*  71 */               (fieldJD = new JavadocHandler.FieldJD()).field = field;
/*  72 */               fieldJD.description = str1;
/*  73 */               array1.add(fieldJD);
/*  74 */               if (verbose) a.i("/+\\ field '" + str2 + "' in " + paramClass, new Object[0]);
/*     */             
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }  
/*  80 */     return array1;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getClassDescription(Document paramDocument) {
/*     */     Element element;
/*  86 */     if ((element = paramDocument.select("body > main > .contentContainer > .description > .blockList > .blockList > .block").first()) == null) {
/*  87 */       return null;
/*     */     }
/*  89 */     return JavadocHandler.formatDocumentation(element.outerHtml(), 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Map<String, String> getClassGenerics(Document paramDocument, Class<?> paramClass) {
/*  95 */     return parseGenerics(paramDocument.select("body > main > .header > .title").first().text(), paramClass);
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getClassGenericsString(Document paramDocument) {
/* 100 */     return parseGenericsString(paramDocument.select("body > main > .header > .title").first().text());
/*     */   }
/*     */ 
/*     */   
/*     */   public final Array<JavadocHandler.ConstructorJD> getConstructors(Document paramDocument, Class<?> paramClass) {
/* 105 */     Map<String, String> map = getClassGenerics(paramDocument, paramClass);
/*     */     
/* 107 */     Array<JavadocHandler.ConstructorJD> array = new Array();
/*     */     Element element;
/* 109 */     if ((element = paramDocument.select("#constructor\\.detail").first()) != null)
/*     */     {
/* 111 */       for (Iterator<Element> iterator = (element = element.parent()).select("ul > li").iterator(); iterator.hasNext(); ) {
/*     */         Iterator<Element> iterator1;
/*     */         
/*     */         Element element1, element2;
/* 115 */         if ((element2 = (element1 = iterator.next()).select("pre").first()) != null) {
/* 116 */           String str = element2.text();
/*     */           try {
/*     */             JavadocHandler.ConstructorJD constructorJD;
/* 119 */             if ((constructorJD = parseConstructorSignature(str, paramClass, map)) != null) {
/*     */               Element element3;
/*     */               
/* 122 */               if ((element3 = element1.select(".block").first()) != null) {
/* 123 */                 constructorJD.description = JavadocHandler.formatDocumentation(element3.outerHtml(), 4);
/*     */               }
/*     */               
/* 126 */               if (constructorJD.params.size != 0)
/*     */               {
/*     */ 
/*     */                 
/* 130 */                 if ((element1 = element1.select("dl").first()) != null)
/*     */                 
/* 132 */                 { boolean bool = false;
/* 133 */                   for (iterator1 = element1.children().iterator(); iterator1.hasNext(); ) {
/* 134 */                     Element element4; if ((element4 = iterator1.next()).tagName().equals("dt")) {
/*     */                       
/* 136 */                       bool = (element4.select(".paramLabel").size() != 0) ? true : false; continue;
/* 137 */                     }  if (element4.tagName().equals("dd") && 
/* 138 */                       bool)
/*     */                     {
/* 140 */                       parseConstructorParamDD(element4, constructorJD);
/*     */                     }
/*     */                   }
/*     */                    }
/*     */                 
/* 145 */                 else if (verbose) { a.i("<dl> not found for " + constructorJD.ctor + " - probably no parameter descriptions, will be skipped", new Object[0]); }
/*     */               
/*     */               }
/*     */               
/* 149 */               array.add(constructorJD);
/*     */             } 
/* 151 */           } catch (Exception exception) {
/* 152 */             a.w("Exception while parsing ctor signature \"" + str + "\" of " + paramClass, new Object[] { exception });
/*     */           }  continue;
/*     */         } 
/* 155 */         a.w("ctor sig (pre) not found in \"" + sanitizeHtmlString(iterator1.outerHtml()) + "\" of " + paramClass, new Object[0]);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 160 */     return array;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Array<JavadocHandler.MethodJD> getMethods(Document paramDocument, Class<?> paramClass) {
/* 165 */     Map<String, String> map = getClassGenerics(paramDocument, paramClass);
/*     */     
/* 167 */     Array<JavadocHandler.MethodJD> array = new Array();
/*     */     Element element;
/* 169 */     if ((element = paramDocument.select("#method\\.detail").first()) != null)
/*     */     {
/* 171 */       for (Iterator<Element> iterator = (element = element.parent()).select("ul.blockList > li.blockList").iterator(); iterator.hasNext();) {
/*     */         
/* 173 */         if ((methodJD = getMethodOldImpl(element1 = iterator.next(), map, paramClass)) != null) {
/* 174 */           array.add(methodJD);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 179 */     return array;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\desktop\luadef\javadoc\ParserGdx.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */