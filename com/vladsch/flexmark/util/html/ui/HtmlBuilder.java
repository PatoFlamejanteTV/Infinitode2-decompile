/*     */ package com.vladsch.flexmark.util.html.ui;
/*     */ 
/*     */ import com.vladsch.flexmark.util.html.Attribute;
/*     */ import com.vladsch.flexmark.util.html.AttributeImpl;
/*     */ import com.vladsch.flexmark.util.html.Attributes;
/*     */ import com.vladsch.flexmark.util.html.HtmlAppendable;
/*     */ import com.vladsch.flexmark.util.html.HtmlAppendableBase;
/*     */ import com.vladsch.flexmark.util.sequence.LineAppendable;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import javax.swing.plaf.FontUIResource;
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
/*     */ public class HtmlBuilder
/*     */   extends HtmlAppendableBase<HtmlBuilder>
/*     */ {
/*     */   public HtmlBuilder() {
/*  35 */     super(0, LineAppendable.F_PASS_THROUGH);
/*     */   }
/*     */   
/*     */   public HtmlBuilder(int paramInt1, int paramInt2) {
/*  39 */     super(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public HtmlBuilder closeAllTags() {
/*  44 */     while (!getOpenTags().isEmpty()) {
/*  45 */       CharSequence charSequence = getOpenTags().peek();
/*  46 */       closeTag(charSequence);
/*     */     } 
/*  48 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toFinalizedString() {
/*  53 */     closeAllTags();
/*  54 */     return toString(0, 0);
/*     */   }
/*     */   public HtmlBuilder attr(Object... paramVarArgs) {
/*     */     int i;
/*     */     byte b;
/*  59 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/*  60 */       Object object; if (object = paramVarArgs[b] instanceof Attribute) {
/*  61 */         super.attr(new Attribute[] { (Attribute)object });
/*  62 */         withAttr();
/*     */       } else {
/*     */         HtmlStyler htmlStyler;
/*     */ 
/*     */         
/*  67 */         if ((htmlStyler = getHtmlStyler(object)) == null) throw new IllegalStateException("Don't know how to style " + object.getClass().getName().substring(getClass().getPackage().getName().length() + 1));
/*     */ 
/*     */ 
/*     */         
/*  71 */         if ((object = htmlStyler.getStyle(htmlStyler.getStyleable(object))) != null && !object.isEmpty()) {
/*  72 */           object = AttributeImpl.of("style", (CharSequence)object);
/*  73 */           super.attr(new Attribute[] { (Attribute)object });
/*  74 */           withAttr();
/*     */         } 
/*     */       } 
/*     */     } 
/*  78 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HtmlBuilder attr(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*  84 */     withAttr();
/*  85 */     return (HtmlBuilder)super.attr(paramCharSequence1, paramCharSequence2);
/*     */   }
/*     */   
/*     */   public HtmlBuilder style(CharSequence paramCharSequence) {
/*  89 */     withAttr();
/*  90 */     return (HtmlBuilder)super.attr("style", paramCharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HtmlBuilder attr(Attribute... paramVarArgs) {
/*  96 */     withAttr();
/*  97 */     return (HtmlBuilder)super.attr(paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HtmlBuilder attr(Attributes paramAttributes) {
/* 103 */     withAttr();
/* 104 */     return (HtmlBuilder)super.attr(paramAttributes);
/*     */   }
/*     */   
/*     */   public HtmlBuilder span() {
/* 108 */     return (HtmlBuilder)tag("span", false);
/*     */   }
/*     */   
/*     */   public HtmlBuilder span(CharSequence paramCharSequence) {
/* 112 */     tag("span", false);
/* 113 */     text(paramCharSequence);
/* 114 */     return closeSpan();
/*     */   }
/*     */   
/*     */   public HtmlBuilder span(boolean paramBoolean, Runnable paramRunnable) {
/* 118 */     return (HtmlBuilder)tag("span", false, paramBoolean, paramRunnable);
/*     */   }
/*     */   
/*     */   public HtmlBuilder span(Runnable paramRunnable) {
/* 122 */     return span(false, paramRunnable);
/*     */   }
/*     */   
/*     */   public HtmlBuilder spanLine(Runnable paramRunnable) {
/* 126 */     return span(true, paramRunnable);
/*     */   }
/*     */   
/*     */   public HtmlBuilder closeSpan() {
/* 130 */     return (HtmlBuilder)closeTag("span");
/*     */   }
/*     */ 
/*     */   
/* 134 */   public static final HashMap<Class, HtmlStyler> stylerMap = new HashMap<>();
/*     */   static {
/* 136 */     ColorStyler colorStyler = new ColorStyler();
/* 137 */     stylerMap.put(BackgroundColor.class, colorStyler);
/* 138 */     stylerMap.put(Color.class, colorStyler);
/*     */     
/* 140 */     stylerMap.put(Color.class, colorStyler);
/*     */     
/* 142 */     FontStyler fontStyler = new FontStyler();
/* 143 */     stylerMap.put(Font.class, fontStyler);
/* 144 */     stylerMap.put(FontUIResource.class, fontStyler);
/*     */     
/* 146 */     stylerMap.put(FontStyle.class, new FontStyleStyler());
/*     */   }
/*     */   public static void addColorStylerClass(Class paramClass) {
/* 149 */     HtmlStyler htmlStyler = stylerMap.get(Color.class);
/* 150 */     stylerMap.put(paramClass, htmlStyler);
/*     */   }
/*     */   
/*     */   public static HtmlStyler getHtmlStyler(Object paramObject) {
/*     */     HtmlStyler htmlStyler;
/* 155 */     if ((htmlStyler = stylerMap.get(paramObject.getClass())) != null) return htmlStyler;
/*     */ 
/*     */     
/* 158 */     for (Iterator<Class<?>> iterator = stylerMap.keySet().iterator(); iterator.hasNext();) {
/*     */       
/* 160 */       if ((clazz = iterator.next()).isAssignableFrom(paramObject.getClass())) {
/* 161 */         htmlStyler = stylerMap.get(clazz);
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 166 */     if (htmlStyler != null) {
/* 167 */       stylerMap.put(paramObject.getClass(), htmlStyler);
/*     */     }
/* 169 */     return htmlStyler;
/*     */   }
/*     */   
/*     */   public static Attribute getAttribute(Object paramObject) {
/*     */     HtmlStyler htmlStyler;
/* 174 */     if ((htmlStyler = getHtmlStyler(paramObject)) != null)
/*     */     {
/*     */       
/* 177 */       if ((paramObject = htmlStyler.getStyle(htmlStyler.getStyleable(paramObject))) != null && !paramObject.isEmpty()) {
/* 178 */         return (Attribute)AttributeImpl.of("style", (CharSequence)paramObject);
/*     */       }
/*     */     }
/* 181 */     return null;
/*     */   }
/*     */   
/*     */   public HtmlBuilder append(Object paramObject) {
/* 185 */     return (HtmlBuilder)super.append(String.valueOf(paramObject));
/*     */   } public HtmlBuilder append(String paramString) {
/* 187 */     return (HtmlBuilder)super.append(paramString);
/*     */   } public HtmlBuilder append(StringBuffer paramStringBuffer) {
/* 189 */     return (HtmlBuilder)super.append(paramStringBuffer.toString());
/*     */   }
/*     */   public HtmlBuilder append(CharSequence paramCharSequence) {
/* 192 */     return (HtmlBuilder)super.append(paramCharSequence);
/*     */   }
/*     */   public HtmlBuilder append(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 195 */     return (HtmlBuilder)super.append(paramCharSequence, paramInt1, paramInt2);
/*     */   } public HtmlBuilder append(char[] paramArrayOfchar) {
/* 197 */     return (HtmlBuilder)super.append(String.valueOf(paramArrayOfchar));
/*     */   } public HtmlBuilder append(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 199 */     return (HtmlBuilder)super.append(String.valueOf(paramArrayOfchar, paramInt1, paramInt2));
/*     */   } public HtmlBuilder append(boolean paramBoolean) {
/* 201 */     return (HtmlBuilder)super.append(paramBoolean ? "true" : "false");
/*     */   }
/*     */   public HtmlBuilder append(char paramChar) {
/* 204 */     return (HtmlBuilder)super.append(paramChar);
/*     */   } public HtmlBuilder append(int paramInt) {
/* 206 */     return (HtmlBuilder)super.append(String.valueOf(paramInt));
/*     */   } public HtmlBuilder append(long paramLong) {
/* 208 */     return (HtmlBuilder)super.append(String.valueOf(paramLong));
/*     */   } public HtmlBuilder append(float paramFloat) {
/* 210 */     return (HtmlBuilder)super.append(String.valueOf(paramFloat));
/*     */   } public HtmlBuilder append(double paramDouble) {
/* 212 */     return (HtmlBuilder)super.append(String.valueOf(paramDouble));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\htm\\ui\HtmlBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */