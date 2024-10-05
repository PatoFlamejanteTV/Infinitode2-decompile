/*    */ package com.prineside.tdi2.desktop;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ import io.github.classgraph.ClassGraph;
/*    */ import io.github.classgraph.ClassInfo;
/*    */ import io.github.classgraph.ClassInfoList;
/*    */ import io.github.classgraph.ScanResult;
/*    */ import java.io.PrintStream;
/*    */ import java.lang.reflect.Modifier;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Paths;
/*    */ import java.util.Comparator;
/*    */ 
/*    */ public class KryoRegistryGenerator {
/*    */   private static final Comparator<Class<?>> a;
/*    */   
/*    */   static {
/* 19 */     a = ((paramClass1, paramClass2) -> paramClass1.getName().compareTo(paramClass2.getName()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/* 26 */     ScanResult scanResult = (new ClassGraph()).enableClassInfo().enableAnnotationInfo().acceptPackages(new String[] { "com" }).scan();
/*    */     try {
/* 28 */       ClassInfoList classInfoList = scanResult.getClassesWithAnnotation(REGS.class);
/* 29 */       Array array = new Array(Class.class);
/* 30 */       for (ClassInfo classInfo : classInfoList) {
/* 31 */         array.add(classInfo.loadClass());
/*    */       }
/* 33 */       array.sort(a);
/*    */       
/* 35 */       StringBuilder stringBuilder = new StringBuilder();
/* 36 */       for (byte b = 0; b < array.size; b++) {
/*    */         Class<?> clazz;
/* 38 */         if (!Modifier.isPublic((clazz = ((Class[])array.items)[b]).getModifiers())) {
/* 39 */           System.err.println(clazz + " is not public, can't add to kryo-registry (Proguard will change its name)");
/*    */         }
/* 41 */         stringBuilder.append(clazz.getName()).append("\n");
/*    */       } 
/*    */       
/* 44 */       String str = "res/kryo-registry.txt"; 
/* 45 */       try { PrintStream printStream = new PrintStream(Files.newOutputStream(Paths.get(str, new String[0]), new java.nio.file.OpenOption[0]), false, "UTF-8"); 
/* 46 */         try { printStream.print(stringBuilder);
/* 47 */           printStream.flush();
/* 48 */           printStream.close(); } catch (Throwable throwable) { try { printStream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }  } catch (Exception exception)
/* 49 */       { throw new IllegalStateException("Failed to write file " + str, exception); }
/*    */       
/* 51 */       System.out.println("generated kryo-registry.txt");
/* 52 */       if (scanResult != null) { scanResult.close();
/*    */         return; }
/*    */     
/*    */     } catch (Throwable throwable) {
/*    */       if (scanResult != null)
/*    */         try {
/*    */           scanResult.close();
/*    */         } catch (Throwable throwable1) {
/*    */           throwable.addSuppressed(throwable1);
/*    */         }  
/*    */       throw throwable;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\desktop\KryoRegistryGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */