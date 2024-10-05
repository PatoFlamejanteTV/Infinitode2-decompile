/*     */ package com.d.h;
/*     */ 
/*     */ import com.a.a.c.f.w;
/*     */ import com.d.c.f.d;
/*     */ import com.d.d.c;
/*     */ import com.d.d.n;
/*     */ import com.d.d.o;
/*     */ import com.d.d.p;
/*     */ import com.d.d.s;
/*     */ import com.d.e.v;
/*     */ import com.d.i.c;
/*     */ import com.d.i.f;
/*     */ import com.d.j.g;
/*     */ import org.w3c.dom.Element;
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
/*     */ public final class r
/*     */   implements o
/*     */ {
/*     */   private final p a;
/*     */   private final p b;
/*     */   private final w.a c;
/*     */   private final m d;
/*     */   
/*     */   public r(m paramm, p paramp1, w.a parama, p paramp2) {
/*  36 */     this.d = paramm;
/*  37 */     this.a = paramp1;
/*  38 */     this.c = parama;
/*  39 */     this.b = paramp2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final n a(v paramv, c paramc, s params, int paramInt1, int paramInt2) {
/*     */     Element element;
/*  46 */     if ((element = paramc.ai()) == null) {
/*  47 */       return null;
/*     */     }
/*     */     
/*     */     String str;
/*     */     
/*  52 */     if ((str = element.getNodeName()).equals("math") && this.b != null)
/*  53 */       return new s(element, this.b, paramInt1, paramInt2, (f)paramc, (d)paramv, paramv.y()); 
/*  54 */     if (str.equals("svg") && this.a != null)
/*  55 */       return new s(element, this.a, paramInt1, paramInt2, (f)paramc, (d)paramv, paramv.y()); 
/*  56 */     if (str.equals("img")) {
/*     */       
/*  58 */       if ((str = element.getAttribute("src")) != null && str.length() > 0) {
/*     */         g g;
/*     */         byte[] arrayOfByte;
/*  61 */         if (str.endsWith(".svg") && this.a != null) {
/*     */ 
/*     */           
/*  64 */           if ((g = params.c(str)) != null) {
/*  65 */             return new s(g.d().getDocumentElement(), this.a, paramInt1, paramInt2, (f)paramc, (d)paramv, paramv.y());
/*     */           }
/*     */           
/*  68 */           return null;
/*  69 */         }  if (str.endsWith(".pdf")) {
/*     */ 
/*     */           
/*  72 */           if ((arrayOfByte = g.d(str)) != null) {
/*  73 */             return n.a(this.d.j(), arrayOfByte, element, (f)paramc, (d)paramv, paramv.y());
/*     */           }
/*     */           
/*  76 */           return null;
/*     */         } 
/*     */         
/*     */         c c1;
/*  80 */         if ((c1 = arrayOfByte.b(str).d()) != null) {
/*  81 */           return new j(element, c1, paramv.y(), paramc.a().al());
/*     */         }
/*     */       } 
/*  84 */     } else if (!str.equals("input")) {
/*     */       e e;
/*  86 */       if (str.equals("bookmark")) {
/*     */         
/*  88 */         e = new e();
/*  89 */         if (element.hasAttribute("name")) {
/*  90 */           String str1 = element.getAttribute("name");
/*  91 */           paramv.a(str1, (f)paramc);
/*  92 */           e.a(str1);
/*     */         } 
/*  94 */         return e;
/*  95 */       }  w.a a1; if (e.equals("object") && this.c != null && (
/*     */         
/*  97 */         a1 = this.c.x()) != null) {
/*  98 */         return new l(element, a1, paramInt1, paramInt2, paramv
/*  99 */             .y());
/*     */       }
/*     */     } 
/* 102 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean a(Element paramElement) {
/* 107 */     if (paramElement == null) {
/* 108 */       return false;
/*     */     }
/*     */     
/*     */     String str;
/* 112 */     if ((str = paramElement.getNodeName()).equals("img"))
/* 113 */       return true; 
/* 114 */     if (str.equals("math") && this.b != null)
/* 115 */       return true; 
/* 116 */     if (str.equals("svg") && this.a != null)
/* 117 */       return true; 
/* 118 */     if (str.equals("bookmark"))
/* 119 */       return true; 
/* 120 */     if (str.equals("object") && this.c != null) {
/* 121 */       return this.c.y();
/*     */     }
/*     */     
/* 124 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\h\r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */