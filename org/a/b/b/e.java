/*    */ package org.a.b.b;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.a.b.d.b;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class e
/*    */   extends b
/*    */ {
/* 32 */   private final Map<Integer, String> a = new HashMap<Integer, String>(250);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final String a(int paramInt) {
/*    */     String str;
/* 51 */     if ((str = this.a.get(Integer.valueOf(paramInt))) == null)
/*    */     {
/* 53 */       return ".notdef";
/*    */     }
/* 55 */     return str;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void a(int paramInt, String paramString) {
/* 65 */     this.a.put(Integer.valueOf(paramInt), paramString);
/* 66 */     b(paramInt, paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final void a(int paramInt1, int paramInt2) {
/* 74 */     String str = n.a(paramInt2);
/* 75 */     this.a.put(Integer.valueOf(paramInt1), str);
/* 76 */     b(paramInt1, str);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */