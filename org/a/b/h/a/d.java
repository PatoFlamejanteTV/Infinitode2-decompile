/*    */ package org.a.b.h.a;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public abstract class d
/*    */   implements a
/*    */ {
/*    */   public final List<File> a() {
/* 38 */     ArrayList<File> arrayList = new ArrayList();
/*    */     String[] arrayOfString;
/*    */     int i;
/*    */     byte b;
/* 42 */     for (i = (arrayOfString = arrayOfString = b()).length, b = 0; b < i; ) { String str = arrayOfString[b];
/*    */       
/* 44 */       File file = new File(str);
/*    */       
/*    */       try {
/* 47 */         if (file.exists() && file.canRead())
/*    */         {
/* 49 */           arrayList.add(file);
/*    */         }
/*    */       }
/* 52 */       catch (SecurityException securityException) {}
/*    */ 
/*    */       
/*    */       b++; }
/*    */ 
/*    */     
/* 58 */     return arrayList;
/*    */   }
/*    */   
/*    */   protected abstract String[] b();
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\h\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */