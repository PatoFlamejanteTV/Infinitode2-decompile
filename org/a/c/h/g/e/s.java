/*     */ package org.a.c.h.g.e;
/*     */ 
/*     */ import java.text.AttributedCharacterIterator;
/*     */ import java.text.AttributedString;
/*     */ import java.text.BreakIterator;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.a.c.h.e.u;
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
/*     */ final class s
/*     */ {
/*     */   private final List<b> a;
/*     */   
/*     */   s(String paramString) {
/*  54 */     List<String> list = Arrays.asList(paramString.replaceAll("\t", " ").split("\\r\\n|\\n|\\r|\\u2028|\\u2029"));
/*  55 */     this.a = new ArrayList<b>();
/*  56 */     for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
/*     */       String str;
/*     */       
/*  59 */       if ((str = iterator.next()).length() == 0)
/*     */       {
/*  61 */         str = " ";
/*     */       }
/*  63 */       this.a.add(new b(str));
/*     */     } 
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
/*     */   final List<b> a() {
/*  91 */     return this.a;
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
/*     */   static class c
/*     */     extends AttributedCharacterIterator.Attribute
/*     */   {
/* 111 */     public static final AttributedCharacterIterator.Attribute a = new c("width");
/*     */ 
/*     */     
/*     */     private c(String param1String) {
/* 115 */       super(param1String);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class b
/*     */   {
/*     */     private final String a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     b(String param1String) {
/* 135 */       this.a = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     final String a() {
/* 145 */       return this.a;
/*     */     }
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
/*     */     final List<s.a> a(u param1u, float param1Float1, float param1Float2) {
/*     */       BreakIterator breakIterator;
/* 160 */       (breakIterator = BreakIterator.getLineInstance()).setText(this.a);
/*     */       
/* 162 */       float f1 = param1Float1 / 1000.0F;
/*     */       
/* 164 */       int i = breakIterator.first();
/* 165 */       int j = breakIterator.next();
/* 166 */       float f2 = 0.0F;
/*     */       
/* 168 */       ArrayList<s.a> arrayList = new ArrayList();
/* 169 */       s.a a = new s.a();
/*     */       
/* 171 */       while (j != -1) {
/*     */         
/* 173 */         String str = this.a.substring(i, j);
/* 174 */         float f = param1u.b(str) * f1;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 179 */         if ((f2 = f2 + f) >= param1Float2 && Character.isWhitespace(str.charAt(str.length() - 1))) {
/*     */           
/* 181 */           float f3 = param1u.b(str.substring(str.length() - 1)) * f1;
/* 182 */           f2 -= f3;
/*     */         } 
/*     */         
/* 185 */         if (f2 >= param1Float2) {
/*     */           
/* 187 */           a.a(a.a(param1u, param1Float1));
/* 188 */           arrayList.add(a);
/* 189 */           a = new s.a();
/* 190 */           f2 = param1u.b(str) * f1;
/*     */         } 
/*     */         
/*     */         AttributedString attributedString;
/* 194 */         (attributedString = new AttributedString(str)).addAttribute(s.c.a, Float.valueOf(f));
/*     */         s.d d;
/* 196 */         (d = new s.d(str)).a(attributedString);
/* 197 */         a.a(d);
/* 198 */         int k = j;
/* 199 */         j = breakIterator.next();
/*     */       } 
/* 201 */       a.a(a.a(param1u, param1Float1));
/* 202 */       arrayList.add(a);
/* 203 */       return arrayList;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class a
/*     */   {
/* 212 */     private final List<s.d> a = new ArrayList<s.d>();
/*     */     
/*     */     private float b;
/*     */     
/*     */     final float a() {
/* 217 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     final void a(float param1Float) {
/* 222 */       this.b = param1Float;
/*     */     }
/*     */ 
/*     */     
/*     */     final float a(u param1u, float param1Float) {
/* 227 */       param1Float /= 1000.0F;
/* 228 */       float f = 0.0F;
/* 229 */       for (s.d d : this.a) {
/*     */         
/* 231 */         f += ((Float)d
/* 232 */           .b().getIterator().getAttribute(s.c.a)).floatValue();
/* 233 */         String str = d.a();
/* 234 */         if (this.a.indexOf(d) == this.a.size() - 1 && Character.isWhitespace(str.charAt(str.length() - 1))) {
/*     */           
/* 236 */           float f1 = param1u.b(str.substring(str.length() - 1)) * param1Float;
/* 237 */           f -= f1;
/*     */         } 
/*     */       } 
/* 240 */       return f;
/*     */     }
/*     */ 
/*     */     
/*     */     final List<s.d> b() {
/* 245 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     final float b(float param1Float) {
/* 250 */       return (param1Float - this.b) / (this.a.size() - 1);
/*     */     }
/*     */ 
/*     */     
/*     */     final void a(s.d param1d) {
/* 255 */       this.a.add(param1d);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class d
/*     */   {
/*     */     private AttributedString a;
/*     */ 
/*     */     
/*     */     private final String b;
/*     */ 
/*     */ 
/*     */     
/*     */     d(String param1String) {
/* 272 */       this.b = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     final String a() {
/* 277 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     final AttributedString b() {
/* 282 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     final void a(AttributedString param1AttributedString) {
/* 287 */       this.a = param1AttributedString;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\g\e\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */