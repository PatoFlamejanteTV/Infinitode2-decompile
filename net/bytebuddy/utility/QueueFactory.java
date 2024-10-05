/*    */ package net.bytebuddy.utility;
/*    */ 
/*    */ import java.security.AccessController;
/*    */ import java.security.PrivilegedAction;
/*    */ import java.util.Collection;
/*    */ import java.util.LinkedList;
/*    */ import java.util.Queue;
/*    */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.utility.dispatcher.JavaDispatcher;
/*    */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Defaults;
/*    */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.IsConstructor;
/*    */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied;
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
/*    */ @Enhance
/*    */ public class QueueFactory
/*    */ {
/* 38 */   private static final QueueFactory INSTANCE = new QueueFactory(); static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*    */      }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 49 */   private final Dispatcher dispatcher = doPrivileged(JavaDispatcher.of(Dispatcher.class));
/*    */ 
/*    */ 
/*    */   
/*    */   private static final boolean ACCESS_CONTROLLER;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> Queue<T> make() {
/*    */     Queue<?> queue;
/* 60 */     return ((queue = INSTANCE.dispatcher.arrayDeque()) == null) ? new LinkedList<T>() : queue;
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
/*    */   public static <T> Queue<T> make(Collection<? extends T> paramCollection) {
/*    */     Queue<T> queue;
/* 74 */     return ((queue = INSTANCE.dispatcher.<T>arrayDeque(paramCollection)) == null) ? new LinkedList<T>(paramCollection) : queue;
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
/*    */   @Enhance
/*    */   private static <T> T doPrivileged(PrivilegedAction<T> paramPrivilegedAction) {
/* 88 */     return ACCESS_CONTROLLER ? AccessController.doPrivileged(paramPrivilegedAction) : paramPrivilegedAction.run();
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.dispatcher.equals(((QueueFactory)paramObject).dispatcher))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return getClass().hashCode() * 31 + this.dispatcher.hashCode();
/*    */   }
/*    */   
/*    */   @Defaults
/*    */   @Proxied("java.util.ArrayDeque")
/*    */   protected static interface Dispatcher {
/*    */     @MaybeNull
/*    */     @IsConstructor
/*    */     @Proxied("arrayDeque")
/*    */     <T> Queue<T> arrayDeque();
/*    */     
/*    */     @MaybeNull
/*    */     @IsConstructor
/*    */     @Proxied("arrayDeque")
/*    */     <T> Queue<T> arrayDeque(Collection<? extends T> param1Collection);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\QueueFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */