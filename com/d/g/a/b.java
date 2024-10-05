/*     */ package com.d.g.a;
/*     */ 
/*     */ import com.a.a.c.f.w;
/*     */ import com.d.d.e;
/*     */ import com.d.d.g;
/*     */ import com.d.d.h;
/*     */ import com.d.d.i;
/*     */ import com.d.d.p;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.w3c.dom.Document;
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
/*     */ public abstract class b<TFinalClass extends b, TBaseRendererBuilderState extends b.a>
/*     */ {
/*     */   protected final TBaseRendererBuilderState a;
/*     */   
/*     */   public static abstract class a
/*     */   {
/*  32 */     public final List<w.a> a = new ArrayList<>();
/*  33 */     public Map<String, e> b = new HashMap<>();
/*     */     
/*     */     public i c;
/*     */     
/*     */     public String d;
/*     */     
/*     */     public String e;
/*     */     public Document f;
/*     */     public p g;
/*     */     public p h;
/*     */     public String i;
/*     */     public g j;
/*     */     public g k;
/*     */     public h l;
/*     */     public h m;
/*     */     public h n;
/*     */     public com.d.a.c o;
/*     */     public com.d.a.a p;
/*     */     public boolean q = false;
/*     */     public Float r;
/*     */     public Float s;
/*     */     public String t;
/*     */     public File u;
/*     */     public boolean v = false;
/*     */     public w.a w;
/*  58 */     public String x = "com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl";
/*  59 */     public String y = "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl";
/*     */     
/*     */     public boolean z = false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected b(TBaseRendererBuilderState paramTBaseRendererBuilderState) {
/*  66 */     this.a = paramTBaseRendererBuilderState;
/*  67 */     a((e)new com.d.l.c.b(), new String[] { "http", "https" });
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
/*     */   public final TFinalClass a(d paramd) {
/* 126 */     ((a)this.a).q = (paramd == d.a);
/* 127 */     return (TFinalClass)this;
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
/*     */   
/*     */   private TFinalClass a(e parame, String... paramVarArgs) {
/*     */     byte b1;
/* 194 */     for (paramVarArgs = paramVarArgs, b1 = 0; b1 < 2; ) { String str = paramVarArgs[b1];
/* 195 */       ((a)this.a).b.put(str, parame); b1++; }
/*     */     
/* 197 */     return (TFinalClass)this;
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
/*     */   public final TFinalClass a(com.d.a.c paramc) {
/* 219 */     ((a)this.a).o = paramc;
/* 220 */     return (TFinalClass)this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final TFinalClass a(com.d.a.a parama) {
/* 230 */     ((a)this.a).p = parama;
/* 231 */     return (TFinalClass)this;
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
/*     */   public final TFinalClass a(Document paramDocument, String paramString) {
/* 255 */     ((a)this.a).f = paramDocument;
/* 256 */     ((a)this.a).e = paramString;
/* 257 */     return (TFinalClass)this;
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
/*     */   
/*     */   public enum d
/*     */   {
/* 438 */     a, b;
/*     */   }
/*     */   
/*     */   public enum c {
/* 442 */     b, a;
/*     */   }
/*     */   
/*     */   public enum b {
/* 446 */     a, b, c;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\g\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */