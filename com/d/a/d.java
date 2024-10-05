/*     */ package com.d.a;
/*     */ 
/*     */ import com.a.a.c.k.b.aa;
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.f.c;
/*     */ import com.d.d.o;
/*     */ import com.d.e.v;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.Text;
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
/*     */ public final class d
/*     */ {
/*     */   private List<b> a;
/*     */   private Map<Text, b> b;
/*     */   private Map<Element, b> c;
/*     */   
/*     */   public static class b
/*     */   {
/*     */     private final StringBuilder b;
/*     */     private final TreeMap<Integer, aa> c;
/*  47 */     private Map<Text, Integer> d = new HashMap<>();
/*     */ 
/*     */     
/*     */     protected final c a;
/*     */     
/*  52 */     private byte e = 0;
/*     */     
/*     */     private b(c param1c) {
/*  55 */       this(param1c, true);
/*     */     }
/*     */     
/*     */     private b(c param1c, boolean param1Boolean) {
/*  59 */       this.b = param1Boolean ? new StringBuilder() : null;
/*  60 */       this.c = param1Boolean ? new TreeMap<>() : null;
/*  61 */       this.a = param1c;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void a(String param1String, Text param1Text) {
/*  68 */       int i = this.b.length();
/*  69 */       this.b.append(param1String);
/*  70 */       this.d.put(param1Text, Integer.valueOf(i));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void a(b param1b) {
/*  77 */       byte b1 = 0;
/*  78 */       String str = this.b.toString();
/*     */       
/*  80 */       if (this.a == c.aK) {
/*  81 */         b1 = 1;
/*  82 */       } else if (this.a == c.e) {
/*  83 */         b1 = param1b.a(str);
/*     */       } 
/*     */       
/*  86 */       this.e = (b1 == 3) ? 0 : b1;
/*  87 */       param1b.a(str, this.e);
/*  88 */       b(param1b);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int a(Text param1Text) {
/*  95 */       if (this.d.isEmpty()) {
/*  96 */         return -1;
/*     */       }
/*     */       
/*     */       Integer integer;
/* 100 */       return ((integer = this.d.get(param1Text)) == null) ? -1 : integer.intValue();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void b(b param1b) {
/* 107 */       int i = param1b.a();
/*     */       
/* 109 */       for (byte b1 = 0; b1 < i; b1++) {
/* 110 */         aa aa = param1b.a(b1);
/* 111 */         this.c.put(Integer.valueOf(aa.a()), aa);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public aa a(int param1Int) {
/*     */       Map.Entry<Integer, aa> entry;
/* 121 */       if ((entry = this.c.ceilingEntry(Integer.valueOf(param1Int))) != null) {
/* 122 */         return entry.getValue();
/*     */       }
/* 124 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public aa b(int param1Int) {
/*     */       Map.Entry<Integer, aa> entry;
/* 133 */       if ((entry = this.c.floorEntry(Integer.valueOf(param1Int))) != null) {
/* 134 */         return entry.getValue();
/*     */       }
/* 136 */       return null;
/*     */     }
/*     */     
/*     */     public byte a() {
/* 140 */       return this.e;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class a
/*     */     extends b
/*     */   {
/*     */     private a(c param1c) {
/* 153 */       super(param1c, false, (byte)0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final void a(String param1String, Text param1Text) {}
/*     */ 
/*     */     
/*     */     public final byte a() {
/* 162 */       return (this.a == c.aK) ? 1 : 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public final aa a(int param1Int) {
/* 167 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public final aa b(int param1Int) {
/* 172 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final void a(b param1b) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final b a(Text paramText) {
/* 189 */     return this.b.isEmpty() ? this.a.get(0) : this.b.get(paramText);
/*     */   }
/*     */   
/*     */   public final b a(Element paramElement) {
/* 193 */     return this.c.isEmpty() ? this.a.get(0) : this.c.get(paramElement);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(v paramv, Document paramDocument) {
/* 200 */     boolean bool = paramv.g().b();
/*     */     c c1;
/* 202 */     c c = (c1 = paramv.y().a(paramDocument.getDocumentElement())).az();
/* 203 */     b b = bool ? new b(c, (byte)0) : new a(c, (byte)0);
/*     */     
/* 205 */     if (bool) {
/* 206 */       this.a = new ArrayList<>();
/* 207 */       this.b = new HashMap<>();
/* 208 */       this.c = new HashMap<>();
/*     */       
/* 210 */       a(paramv, paramDocument, b); return;
/*     */     } 
/* 212 */     this.a = Collections.singletonList(b);
/* 213 */     this.b = Collections.emptyMap();
/* 214 */     this.c = Collections.emptyMap();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(v paramv) {
/* 222 */     for (Iterator<b> iterator = this.a.iterator(); iterator.hasNext();)
/*     */     {
/* 224 */       (b = iterator.next()).a(paramv.h().a());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(v paramv, Node paramNode, b paramb) {
/* 232 */     o o = paramv.v();
/*     */ 
/*     */     
/* 235 */     if ((paramNode = paramNode.getFirstChild()) == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     do {
/* 240 */       if (paramNode.getNodeType() == 3 || paramNode
/* 241 */         .getNodeType() == 4) {
/* 242 */         String str = ((Text)paramNode).getData();
/* 243 */         paramb.a(str, (Text)paramNode);
/* 244 */         this.b.put((Text)paramNode, paramb);
/*     */       } else {
/* 246 */         Element element; if (paramNode.getNodeType() == 1 && 
/*     */ 
/*     */           
/* 249 */           !(element = (Element)paramNode).getNodeName().equals("head") && 
/* 250 */           !o.a(element)) {
/*     */           c c;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 256 */           if ((c = paramv.y().a(element)).aB() || element.hasAttribute("dir") || element.getNodeName().equals("bdi"))
/*     */           
/* 258 */           { b b1 = new b(c.az(), (byte)0);
/* 259 */             this.a.add(b1);
/* 260 */             this.c.put(element, b1);
/* 261 */             a(paramv, element, b1); }
/*     */           
/*     */           else
/*     */           
/* 265 */           { this.c.put(element, paramb);
/* 266 */             a(paramv, element, paramb); } 
/*     */         } 
/*     */       } 
/* 269 */     } while ((paramNode = paramNode.getNextSibling()) != null);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */