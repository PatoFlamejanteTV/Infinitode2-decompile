/*     */ package org.a.d.b;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ public final class m
/*     */ {
/*  46 */   private final List<b> a = new ArrayList<b>();
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
/*     */   public final void a(b paramb) {
/*  82 */     if (c(paramb))
/*     */     {
/*  84 */       b(paramb);
/*     */     }
/*  86 */     this.a.add(paramb);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<b> a() {
/*  96 */     return this.a;
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
/*     */   private List<b> b(String paramString) {
/*     */     List<b> list;
/* 109 */     if ((list = a()) != null) {
/*     */       
/* 111 */       ArrayList<b> arrayList = new ArrayList();
/* 112 */       for (Iterator<b> iterator = list.iterator(); iterator.hasNext();) {
/*     */         
/* 114 */         if ((b = iterator.next()).e().equals(paramString))
/*     */         {
/* 116 */           arrayList.add(b);
/*     */         }
/*     */       } 
/* 119 */       if (arrayList.isEmpty())
/*     */       {
/* 121 */         return null;
/*     */       }
/*     */ 
/*     */       
/* 125 */       return arrayList;
/*     */     } 
/*     */     
/* 128 */     return null;
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
/*     */   private static boolean a(b paramb1, b paramb2) {
/* 143 */     if (paramb1.getClass().equals(paramb2.getClass())) {
/*     */       
/* 145 */       String str1 = paramb1.e();
/* 146 */       String str2 = paramb2.e();
/* 147 */       if (str1 == null)
/*     */       {
/* 149 */         return (str2 == null);
/*     */       }
/*     */ 
/*     */       
/* 153 */       if (str1.equals(str2))
/*     */       {
/* 155 */         return paramb1.equals(paramb2);
/*     */       }
/*     */     } 
/*     */     
/* 159 */     return false;
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
/*     */   private boolean c(b paramb) {
/* 171 */     Iterator<b> iterator = a().iterator();
/*     */     
/* 173 */     while (iterator.hasNext()) {
/*     */       b b1;
/*     */       
/* 176 */       if (a(b1 = iterator.next(), paramb))
/*     */       {
/* 178 */         return true;
/*     */       }
/*     */     } 
/* 181 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(b paramb) {
/* 192 */     if (c(paramb))
/*     */     {
/* 194 */       this.a.remove(paramb);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(String paramString) {
/* 205 */     if (this.a.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/*     */     List<b> list;
/* 210 */     if ((list = b(paramString)) == null) {
/*     */       return;
/*     */     }
/*     */     
/* 214 */     for (b b : list)
/*     */     {
/* 216 */       this.a.remove(b);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\d\b\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */