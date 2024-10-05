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
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ public final class ParserInfinitode
/*     */   extends ParserVariant {
/*  16 */   private static final TLog a = TLog.forClass(ParserInfinitode.class);
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getScore(Document paramDocument) {
/*  21 */     byte b = 0;
/*  22 */     if (paramDocument.select("#class-description .block").size() != 0) {
/*  23 */       b++;
/*     */     }
/*  25 */     if (paramDocument.select("body.class-declaration-page > .flex-box").size() != 0) {
/*  26 */       b++;
/*     */     }
/*  28 */     if (paramDocument.select("#method-summary").size() != 0) {
/*  29 */       b++;
/*     */     }
/*  31 */     if (paramDocument.select("#constructor-summary").size() != 0) {
/*  32 */       b++;
/*     */     }
/*  34 */     if (paramDocument.select("#method-detail").size() != 0) {
/*  35 */       b++;
/*     */     }
/*  37 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Array<JavadocHandler.FieldJD> getFields(Document paramDocument, Class<?> paramClass) {
/*  42 */     Array array = LuaDefUtils.gatherFieldsCached(paramClass);
/*     */     
/*  44 */     Array<JavadocHandler.FieldJD> array1 = new Array();
/*     */     Element element;
/*  46 */     if ((element = paramDocument.select("#field-detail").first()) != null)
/*  47 */       for (Iterator<Element> iterator = element.select("ul.member-list > li").iterator(); iterator.hasNext(); ) {
/*  48 */         Element element1; String str1 = sanitizeHtmlString((element1 = iterator.next()).select("h3").first().text());
/*  49 */         Element element2 = element1.select(".member-signature").first();
/*     */         
/*  51 */         String str3 = null; String str2;
/*  52 */         if (element2 != null && (
/*     */           
/*  54 */           str2 = sanitizeHtmlString(element2.text())).contains("<") && str2.contains(">")) {
/*  55 */           int i = str2.indexOf('<');
/*  56 */           int j = str2.lastIndexOf('>');
/*  57 */           str3 = str2.substring(i, j + 1);
/*     */         } 
/*     */ 
/*     */         
/*  61 */         str2 = null;
/*     */         Element element3;
/*  63 */         if ((element3 = element1.select(".block").first()) != null && (
/*     */           
/*  65 */           str2 = sanitizeHtmlString(element3.text())).length() == 0) {
/*  66 */           str2 = null;
/*     */         }
/*     */ 
/*     */         
/*  70 */         Field field = null;
/*  71 */         for (byte b = 0; b < array.size; b++) {
/*  72 */           if (((Field[])array.items)[b].getName().equals(str1)) {
/*  73 */             field = ((Field[])array.items)[b];
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*  78 */         if (field != null) {
/*     */           JavadocHandler.FieldJD fieldJD;
/*  80 */           (fieldJD = new JavadocHandler.FieldJD()).field = field;
/*  81 */           fieldJD.description = str2;
/*  82 */           fieldJD.generics = str3;
/*  83 */           array1.add(fieldJD);
/*  84 */           if (verbose) a.i("/+\\ field '" + str1 + "' in " + paramClass, new Object[0]);
/*     */         
/*     */         } 
/*     */       }  
/*  88 */     return array1;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Map<String, String> getClassGenerics(Document paramDocument, Class<?> paramClass) {
/*  93 */     return parseGenerics(paramDocument.select("h1").first().text(), paramClass);
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getClassGenericsString(Document paramDocument) {
/*  98 */     return parseGenericsString(paramDocument.select("h1").first().text());
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getClassDescription(Document paramDocument) {
/*     */     Element element;
/* 104 */     if ((element = paramDocument.select("#class-description .block").first()) == null) {
/* 105 */       return null;
/*     */     }
/* 107 */     return JavadocHandler.formatDocumentation(element.outerHtml(), 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Array<JavadocHandler.ConstructorJD> getConstructors(Document paramDocument, Class<?> paramClass) {
/* 113 */     Map<String, String> map = getClassGenerics(paramDocument, paramClass);
/* 114 */     Array<JavadocHandler.ConstructorJD> array = new Array();
/*     */     
/*     */     Element element;
/* 117 */     if ((element = paramDocument.select("#constructor-detail").first()) != null) {
/* 118 */       for (Iterator<Element> iterator = element.select(".member-list > li").iterator(); iterator.hasNext(); ) {
/*     */         Iterator<Element> iterator1;
/*     */         
/*     */         Element element1, element2;
/*     */         
/* 123 */         if ((element2 = (element1 = iterator.next()).select("section > .member-signature").first()) != null) {
/* 124 */           String str = element2.text();
/*     */           
/*     */           try {
/*     */             JavadocHandler.ConstructorJD constructorJD;
/* 128 */             if ((constructorJD = parseConstructorSignature(str, paramClass, map)) != null) {
/*     */               Element element3;
/*     */               
/* 131 */               if ((element3 = element1.select("section > .block").first()) != null) {
/* 132 */                 constructorJD.description = JavadocHandler.formatDocumentation(element3.outerHtml(), 4);
/*     */               }
/*     */               
/* 135 */               if (constructorJD.params.size != 0)
/*     */               {
/*     */ 
/*     */                 
/* 139 */                 if ((element1 = element1.select("section > dl.notes").first()) != null)
/*     */                 
/* 141 */                 { boolean bool = false;
/* 142 */                   for (iterator1 = element1.children().iterator(); iterator1.hasNext(); ) {
/* 143 */                     Element element4; if ((element4 = iterator1.next()).tagName().equals("dt")) {
/*     */                       
/* 145 */                       bool = element4.text().equals("Parameters:"); continue;
/* 146 */                     }  if (element4.tagName().equals("dd") && 
/* 147 */                       bool)
/*     */                     {
/* 149 */                       parseConstructorParamDD(element4, constructorJD);
/*     */                     }
/*     */                   }
/*     */                    }
/*     */                 
/* 154 */                 else if (verbose) { a.i("<dl> not found for " + constructorJD.ctor + " - probably no parameter descriptions, will be skipped", new Object[0]); }
/*     */               
/*     */               }
/*     */               
/* 158 */               array.add(constructorJD);
/*     */             } 
/* 160 */           } catch (Exception exception) {
/* 161 */             a.w("Exception while parsing ctor signature \"" + str + "\" of " + paramClass, new Object[] { exception });
/*     */           }  continue;
/*     */         } 
/* 164 */         a.w("ctor sig (section > .member-signature) not found in \"" + sanitizeHtmlString(iterator1.outerHtml()) + "\" of " + paramClass, new Object[0]);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 169 */     return array;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Array<JavadocHandler.MethodJD> getMethods(Document paramDocument, Class<?> paramClass) {
/* 174 */     Map<String, String> map = getClassGenerics(paramDocument, paramClass);
/*     */     
/* 176 */     Array<JavadocHandler.MethodJD> array = new Array();
/*     */     Element element;
/* 178 */     if ((element = paramDocument.select("#method-detail").first()) != null) {
/* 179 */       for (Iterator<Element> iterator = element.select("ul.member-list > li > section.detail").iterator(); iterator.hasNext(); ) {
/*     */         Iterator<Element> iterator1;
/*     */         Element element1, element2;
/* 182 */         if ((element2 = (element1 = iterator.next()).select(".member-signature").first()) != null) {
/* 183 */           String str1 = element2.text();
/* 184 */           String str2 = sanitizeHtmlString(element1.select("h3").first().text());
/*     */           try {
/*     */             JavadocHandler.MethodJD methodJD;
/* 187 */             if ((methodJD = parseMethodSignature(str2, str1, paramClass, map)) != null) {
/*     */               Elements elements;
/*     */               
/* 190 */               for (Iterator<Element> iterator2 = (elements = element1.select(".block")).iterator(); iterator2.hasNext();) {
/*     */                 
/* 192 */                 if (!(str = sanitizeHtmlString((element4 = iterator2.next()).text())).contains("Description copied from")) {
/* 193 */                   methodJD.description = JavadocHandler.formatDocumentation(element4.outerHtml(), 4);
/*     */                   
/*     */                   break;
/*     */                 } 
/*     */               } 
/*     */               
/*     */               Element element3;
/*     */               
/* 201 */               if ((element3 = element1.select("dl.notes").first()) != null)
/*     */               
/* 203 */               { boolean bool1 = false;
/* 204 */                 boolean bool2 = false;
/* 205 */                 for (iterator1 = element3.children().iterator(); iterator1.hasNext(); ) {
/* 206 */                   String str; if ((element3 = iterator1.next()).tagName().equals("dt")) {
/*     */ 
/*     */                     
/* 209 */                     bool1 = (str = sanitizeHtmlString(element3.text())).equals("Parameters:");
/* 210 */                     bool2 = str.equals("Returns:");
/*     */                     
/* 212 */                     if (str.equals("Specified by:")) {
/* 213 */                       methodJD.specifiedByInterface = true;
/*     */                     }
/* 215 */                     if (str.equals("Overrides:"))
/* 216 */                       methodJD.overridesSuperMethod = true;  continue;
/*     */                   } 
/* 218 */                   if (str.tagName().equals("dd")) {
/* 219 */                     if (bool1) {
/*     */                       
/* 221 */                       parseMethodParamDD((Element)str, methodJD); continue;
/* 222 */                     }  if (bool2)
/*     */                     {
/* 224 */                       if (methodJD.returnDescription == null) {
/* 225 */                         methodJD.returnDescription = sanitizeHtmlString(str.text()); continue;
/*     */                       } 
/* 227 */                       a.w("multiple \"Returns:\" <dd> elements in " + methodJD.method, new Object[0]);
/*     */                     }
/*     */                   
/*     */                   }
/*     */                 
/*     */                 }  }
/* 233 */               else if (verbose) { a.i("<dl> not found for " + methodJD.method + " - probably no parameter descriptions, will be skipped", new Object[0]); }
/*     */ 
/*     */               
/* 236 */               array.add(methodJD);
/*     */             } 
/* 238 */           } catch (Exception exception) {
/* 239 */             a.w("Exception while parsing method signature \"" + str1 + "\" of " + paramClass, new Object[] { exception });
/*     */           }  continue;
/*     */         } 
/* 242 */         a.w("method sig (.member-signature) not found in \"" + sanitizeHtmlString(iterator1.outerHtml()) + "\" of " + paramClass, new Object[0]);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 247 */     return array;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\desktop\luadef\javadoc\ParserInfinitode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */