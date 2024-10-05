/*     */ package org.a.b.f;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class al
/*     */ {
/*     */   private boolean a = false;
/*     */   private boolean b = false;
/*     */   
/*     */   public al() {
/*  38 */     this(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public al(boolean paramBoolean) {
/*  48 */     this(paramBoolean, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public al(boolean paramBoolean1, boolean paramBoolean2) {
/*  59 */     this.a = paramBoolean1;
/*  60 */     this.b = paramBoolean2;
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
/*     */   public ap b(File paramFile) {
/*  84 */     ah ah = new ah(paramFile, "r");
/*     */     
/*     */     try {
/*  87 */       return b(ah);
/*     */     }
/*  89 */     catch (IOException iOException) {
/*     */ 
/*     */       
/*  92 */       ah.close();
/*  93 */       throw iOException;
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
/*     */   public ap b(InputStream paramInputStream) {
/* 106 */     return b(new x(paramInputStream));
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
/*     */   public final ap c(InputStream paramInputStream) {
/* 118 */     this.a = true;
/* 119 */     return b(new x(paramInputStream));
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
/*     */   ap b(ak paramak) {
/*     */     ap ap;
/* 132 */     (ap = a(paramak)).a(paramak.h());
/* 133 */     int i = paramak.c();
/* 134 */     paramak.c();
/* 135 */     paramak.c();
/* 136 */     paramak.c();
/* 137 */     for (byte b = 0; b < i; b++) {
/*     */       an an;
/*     */ 
/*     */ 
/*     */       
/* 142 */       if ((an = a(ap, paramak)) != null)
/*     */       {
/* 144 */         ap.a(an);
/*     */       }
/*     */     } 
/*     */     
/* 148 */     if (!this.b)
/*     */     {
/* 150 */       a(ap);
/*     */     }
/*     */     
/* 153 */     return ap;
/*     */   }
/*     */ 
/*     */   
/*     */   ap a(ak paramak) {
/* 158 */     return new ap(paramak);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(ap paramap) {
/* 169 */     for (Iterator<an> iterator = paramap.h().iterator(); iterator.hasNext();) {
/*     */       
/* 171 */       if (!(an = iterator.next()).F())
/*     */       {
/* 173 */         paramap.c(an);
/*     */       }
/*     */     } 
/*     */     
/* 177 */     boolean bool = (a() && paramap.a.containsKey("CFF ")) ? true : false;
/*     */     
/*     */     q q;
/* 180 */     if ((q = paramap.n()) == null)
/*     */     {
/* 182 */       throw new IOException("head is mandatory");
/*     */     }
/*     */     
/*     */     r r;
/* 186 */     if ((r = paramap.o()) == null)
/*     */     {
/* 188 */       throw new IOException("hhead is mandatory");
/*     */     }
/*     */     
/*     */     w w;
/* 192 */     if ((w = paramap.m()) == null)
/*     */     {
/* 194 */       throw new IOException("maxp is mandatory");
/*     */     }
/*     */     
/*     */     ag ag;
/* 198 */     if ((ag = paramap.k()) == null && !this.a)
/*     */     {
/*     */       
/* 201 */       throw new IOException("post is mandatory");
/*     */     }
/*     */     
/* 204 */     if (!bool) {
/*     */       t t;
/*     */       
/* 207 */       if ((t = paramap.q()) == null)
/*     */       {
/* 209 */         throw new IOException("loca is mandatory");
/*     */       }
/*     */       
/* 212 */       if (paramap.e() == null)
/*     */       {
/* 214 */         throw new IOException("glyf is mandatory");
/*     */       }
/*     */     } 
/*     */     
/* 218 */     if (paramap.j() == null && !this.a)
/*     */     {
/* 220 */       throw new IOException("name is mandatory");
/*     */     }
/*     */     
/* 223 */     if (paramap.p() == null)
/*     */     {
/* 225 */       throw new IOException("hmtx is mandatory");
/*     */     }
/*     */     
/* 228 */     if (!this.a && paramap.r() == null)
/*     */     {
/* 230 */       throw new IOException("cmap is mandatory");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a() {
/* 236 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private an a(ap paramap, ak paramak) {
/*     */     an an;
/*     */     String str;
/* 243 */     if ((str = paramak.a(4)).equals("cmap")) {
/*     */       
/* 245 */       an = new f(paramap);
/*     */     } else {
/* 247 */       p p; if (str.equals("glyf")) {
/*     */         
/* 249 */         p = new p((ap)an);
/*     */       } else {
/* 251 */         q q; if (str.equals("head"))
/*     */         
/* 253 */         { q = new q((ap)p); }
/*     */         else
/* 255 */         { r r; if (str.equals("hhea"))
/*     */           
/* 257 */           { r = new r((ap)q); }
/*     */           else
/* 259 */           { s s; if (str.equals("hmtx"))
/*     */             
/* 261 */             { s = new s((ap)r); }
/*     */             else
/* 263 */             { t t; if (str.equals("loca"))
/*     */               
/* 265 */               { t = new t((ap)s); }
/*     */               else
/* 267 */               { w w; if (str.equals("maxp"))
/*     */                 
/* 269 */                 { w = new w((ap)t); }
/*     */                 else
/* 271 */                 { z z; if (str.equals("name"))
/*     */                   
/* 273 */                   { z = new z((ap)w); }
/*     */                   else
/* 275 */                   { aa aa; if (str.equals("OS/2"))
/*     */                     
/* 277 */                     { aa = new aa((ap)z); }
/*     */                     else
/* 279 */                     { ag ag; if (str.equals("post"))
/*     */                       
/* 281 */                       { ag = new ag((ap)aa); }
/*     */                       else
/* 283 */                       { g g; if (str.equals("DSIG"))
/*     */                         
/* 285 */                         { g = new g((ap)ag); }
/*     */                         else
/* 287 */                         { v v; if (str.equals("kern"))
/*     */                           
/* 289 */                           { v = new v((ap)g); }
/*     */                           else
/* 291 */                           { aq aq; if (str.equals("vhea"))
/*     */                             
/* 293 */                             { aq = new aq((ap)v); }
/*     */                             else
/* 295 */                             { ar ar; if (str.equals("vmtx"))
/*     */                               
/* 297 */                               { ar = new ar((ap)aq); }
/*     */                               else
/* 299 */                               { as as; if (str.equals("VORG"))
/*     */                                 
/* 301 */                                 { as = new as((ap)ar); }
/*     */                                 else
/* 303 */                                 { n n; if (str.equals("GSUB"))
/*     */                                   
/* 305 */                                   { n = new n((ap)as); }
/*     */                                   
/*     */                                   else
/*     */                                   
/* 309 */                                   { an = a((ap)n, str); }  }  }  }  }  }  }  }  }  }  }  }  }  } 
/*     */       } 
/* 311 */     }  an.a(str);
/* 312 */     paramak.k();
/* 313 */     an.b(paramak.k());
/* 314 */     an.a(paramak.k());
/*     */ 
/*     */     
/* 317 */     if (an.C() == 0L && !str.equals("glyf"))
/*     */     {
/* 319 */       return null;
/*     */     }
/*     */     
/* 322 */     return an;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected an a(ap paramap, String paramString) {
/* 328 */     return new an(paramap);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */