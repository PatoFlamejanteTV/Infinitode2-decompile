/*    */ package net.bytebuddy.utility;
/*    */ 
/*    */ import java.lang.reflect.Field;
/*    */ import java.util.Comparator;
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
/*    */ public enum FieldComparator
/*    */   implements Comparator<Field>
/*    */ {
/* 29 */   INSTANCE;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final int compare(Field paramField1, Field paramField2) {
/* 35 */     if (paramField1 == paramField2) {
/* 36 */       return 0;
/*    */     }
/*    */     int i;
/* 39 */     if ((i = paramField1.getName().compareTo(paramField2.getName())) == 0) {
/* 40 */       return paramField1.getType().getName().compareTo(paramField2.getType().getName());
/*    */     }
/* 42 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\FieldComparator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */