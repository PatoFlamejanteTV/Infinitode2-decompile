/*    */ package net.bytebuddy.utility.privilege;
/*    */ 
/*    */ import java.lang.reflect.AccessibleObject;
/*    */ import java.security.PrivilegedAction;
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.utility.nullability.MaybeNull;
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
/*    */ @Enhance
/*    */ public class SetAccessibleAction<T extends AccessibleObject>
/*    */   implements PrivilegedAction<T>
/*    */ {
/*    */   private final T accessibleObject;
/*    */   
/*    */   public SetAccessibleAction(T paramT) {
/* 42 */     this.accessibleObject = paramT;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public T run() {
/* 49 */     this.accessibleObject.setAccessible(true);
/* 50 */     return this.accessibleObject;
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.accessibleObject.equals(((SetAccessibleAction)paramObject).accessibleObject))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return getClass().hashCode() * 31 + this.accessibleObject.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\privilege\SetAccessibleAction.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */