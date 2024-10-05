/*     */ package com.d.e;
/*     */ 
/*     */ import com.d.c.a.a;
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.f.c;
/*     */ import com.d.i.q;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.regex.Pattern;
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
/*     */ public final class ag
/*     */ {
/*     */   static {
/*  40 */     Pattern.compile("\\s+\\n\\s+");
/*  41 */     Pattern.compile("\\n");
/*  42 */   } private static Pattern a = Pattern.compile("\\t");
/*  43 */   private static Pattern b = Pattern.compile("(?: )+");
/*  44 */   private static Pattern c = Pattern.compile("[\\s&&[^\\n]]\\n");
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
/*     */   public static void a(List<ac> paramList) {
/*  56 */     boolean bool = false;
/*  57 */     boolean bool1 = true;
/*     */     
/*  59 */     for (Iterator<ac> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*  60 */       q q; ac ac; if ((ac = iterator.next()).a().o()) {
/*     */         
/*  62 */         bool = a(q = (q)ac, bool);
/*  63 */         if (!q.e()) {
/*  64 */           bool1 = false;
/*     */         }
/*     */         
/*  67 */         bool = bool; continue;
/*     */       } 
/*  69 */       if (!a((ac)q)) {
/*  70 */         bool1 = false;
/*  71 */         bool = false;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  76 */     if (bool1) {
/*  77 */       b(paramList);
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean a(ac paramac) {
/*     */     c c;
/*  83 */     if ((c = paramac.a()).C() || c.A() || c.B() || c.P()) return true;  return false;
/*     */   }
/*     */   
/*     */   private static void b(List<ac> paramList) {
/*  87 */     boolean bool = true; Iterator<ac> iterator;
/*  88 */     for (iterator = paramList.iterator(); iterator.hasNext();) {
/*  89 */       if ((ac = iterator.next()).a().o()) {
/*     */         q q;
/*  91 */         if ((q = (q)ac).h() != null) {
/*  92 */           bool = false;
/*     */         }
/*     */         
/*  95 */         q.p();
/*     */       } 
/*     */     } 
/*     */     
/*  99 */     if (bool) {
/* 100 */       for (iterator = paramList.iterator(); iterator.hasNext();) {
/*     */         
/* 102 */         if ((ac = iterator.next()).a().o()) {
/* 103 */           iterator.remove();
/*     */         }
/*     */       } 
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
/*     */   private static boolean a(q paramq, boolean paramBoolean) {
/* 123 */     c c = paramq.a().e(a.au);
/*     */     
/* 125 */     String str = paramq.c();
/*     */ 
/*     */ 
/*     */     
/* 129 */     boolean bool = ((str = a(paramq, c, str, paramBoolean)).endsWith(" ") && (c == c.aq || c == c.ar || c == c.aB)) ? true : false;
/*     */ 
/*     */     
/* 132 */     paramq.a(str);
/* 133 */     if (str.trim().equals("")) {
/* 134 */       if (c == c.aq || c == c.ar) {
/* 135 */         paramq.a(true);
/* 136 */       } else if (c == c.aB) {
/* 137 */         paramq.a(false);
/* 138 */       } else if (str.indexOf("\n") < 0) {
/* 139 */         paramq.a(true);
/*     */       } 
/*     */     }
/* 142 */     return str.equals("") ? paramBoolean : bool;
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
/*     */   private static String a(String paramString, boolean paramBoolean) {
/* 156 */     char[] arrayOfChar = paramString.toCharArray();
/* 157 */     StringBuilder stringBuilder = new StringBuilder(arrayOfChar.length);
/* 158 */     paramBoolean = paramBoolean;
/*     */     
/* 160 */     for (byte b = 0; b < arrayOfChar.length; b++) {
/* 161 */       char c = arrayOfChar[b];
/*     */       
/* 163 */       if (paramBoolean) {
/* 164 */         if (c != '\n' && c != '\t' && c != ' ')
/*     */         {
/*     */           
/* 167 */           stringBuilder.append(c);
/* 168 */           paramBoolean = false;
/*     */         }
/*     */       
/* 171 */       } else if (c == '\n' || c == '\t' || c == ' ') {
/*     */ 
/*     */         
/* 174 */         stringBuilder.append(' ');
/* 175 */         paramBoolean = true;
/*     */       } else {
/* 177 */         stringBuilder.append(c);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 182 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private static String a(q paramq, c paramc, String paramString, boolean paramBoolean) {
/* 186 */     if (paramc == c.aq || paramc == c.ar)
/* 187 */       return a(paramString, paramBoolean); 
/* 188 */     if (paramc == c.aB) {
/* 189 */       paramString = c.matcher(paramString).replaceAll("\n");
/*     */     }
/*     */     
/* 192 */     if (paramc == c.aB || paramc == c.aD) {
/*     */       char[] arrayOfChar;
/*     */       int i;
/* 195 */       Arrays.fill(arrayOfChar = new char[i = (int)paramq.a().b(a.al)], ' ');
/* 196 */       paramString = a.matcher(paramString).replaceAll(new String(arrayOfChar));
/* 197 */     } else if (paramc == c.aC) {
/* 198 */       paramString = a.matcher(paramString).replaceAll(" ");
/* 199 */       paramString = b.matcher(paramString).replaceAll(" ");
/*     */     } 
/*     */     
/* 202 */     return paramString;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\e\ag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */