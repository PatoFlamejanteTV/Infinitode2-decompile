/*     */ package org.a.c.h.e.a;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.h.a.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class c
/*     */   implements c
/*     */ {
/*     */   public static c a(j paramj) {
/*  42 */     if (j.dt.equals(paramj))
/*     */     {
/*  44 */       return h.c;
/*     */     }
/*  46 */     if (j.ec.equals(paramj))
/*     */     {
/*  48 */       return k.c;
/*     */     }
/*  50 */     if (j.cd.equals(paramj))
/*     */     {
/*  52 */       return g.d;
/*     */     }
/*  54 */     if (j.cc.equals(paramj))
/*     */     {
/*  56 */       return e.c;
/*     */     }
/*     */ 
/*     */     
/*  60 */     return null;
/*     */   }
/*     */ 
/*     */   
/*  64 */   protected final Map<Integer, String> a = new HashMap<Integer, String>(250);
/*  65 */   protected final Map<String, Integer> b = new HashMap<String, Integer>(250);
/*     */ 
/*     */ 
/*     */   
/*     */   private Set<String> c;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Map<Integer, String> d() {
/*  75 */     return Collections.unmodifiableMap(this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Map<String, Integer> e() {
/*  86 */     return Collections.unmodifiableMap(this.b);
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
/*     */   protected final void a(int paramInt, String paramString) {
/*  99 */     this.a.put(Integer.valueOf(paramInt), paramString);
/* 100 */     if (!this.b.containsKey(paramString))
/*     */     {
/* 102 */       this.b.put(paramString, Integer.valueOf(paramInt));
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
/*     */   protected final void b(int paramInt, String paramString) {
/*     */     String str;
/* 118 */     if ((str = this.a.get(Integer.valueOf(paramInt))) != null) {
/*     */       Integer integer;
/*     */       
/* 121 */       if ((integer = this.b.get(str)) != null && integer.intValue() == paramInt)
/*     */       {
/* 123 */         this.b.remove(str);
/*     */       }
/*     */     } 
/* 126 */     this.b.put(paramString, Integer.valueOf(paramInt));
/* 127 */     this.a.put(Integer.valueOf(paramInt), paramString);
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
/*     */   public final boolean a(String paramString) {
/* 139 */     if (this.c == null)
/*     */     {
/* 141 */       synchronized (this) {
/*     */ 
/*     */         
/* 144 */         HashSet<String> hashSet = new HashSet(this.a.values());
/*     */         
/* 146 */         this.c = hashSet;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 151 */     return this.c.contains(paramString);
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
/*     */   public final String a(int paramInt) {
/*     */     String str;
/* 173 */     if ((str = this.a.get(Integer.valueOf(paramInt))) != null)
/*     */     {
/* 175 */       return str;
/*     */     }
/* 177 */     return ".notdef";
/*     */   }
/*     */   
/*     */   public abstract String a();
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */