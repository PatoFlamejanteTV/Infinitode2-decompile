/*    */ package org.a.d.b;
/*    */ 
/*    */ import org.a.d.b;
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
/*    */ public class am
/*    */   extends c
/*    */ {
/*    */   private String a;
/*    */   
/*    */   public am(b paramb, String paramString1, String paramString2, String paramString3, Object paramObject) {
/* 53 */     super(paramb, paramString1, paramString2, paramString3, paramObject);
/*    */   }
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
/*    */   public final void a(Object paramObject) {
/* 66 */     if (!(paramObject instanceof String))
/*    */     {
/* 68 */       throw new IllegalArgumentException("Value given is not allowed for the Text type : '" + paramObject + "'");
/*    */     }
/*    */ 
/*    */     
/* 72 */     this.a = (String)paramObject;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final String a() {
/* 80 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\d\b\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */