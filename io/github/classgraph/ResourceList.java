/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.AbstractMap;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Map;
/*     */ import nonapi.io.github.classgraph.utils.CollectionUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ResourceList
/*     */   extends PotentiallyUnmodifiableList<Resource>
/*     */   implements AutoCloseable
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*     */   static final ResourceList EMPTY_LIST;
/*     */   
/*     */   static {
/*  55 */     (EMPTY_LIST = new ResourceList()).makeUnmodifiable();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ResourceList emptyList() {
/*  64 */     return EMPTY_LIST;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResourceList() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResourceList(int paramInt) {
/*  81 */     super(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResourceList(Collection<Resource> paramCollection) {
/*  91 */     super(paramCollection);
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
/*     */   public ResourceList get(String paramString) {
/* 107 */     boolean bool = false;
/* 108 */     for (Iterator<Resource> iterator1 = iterator(); iterator1.hasNext();) {
/* 109 */       if ((resource = iterator1.next()).getPath().equals(paramString)) {
/* 110 */         bool = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 114 */     if (!bool) {
/* 115 */       return EMPTY_LIST;
/*     */     }
/* 117 */     ResourceList resourceList = new ResourceList(2);
/* 118 */     for (Iterator<Resource> iterator2 = iterator(); iterator2.hasNext();) {
/* 119 */       if ((resource = iterator2.next()).getPath().equals(paramString)) {
/* 120 */         resourceList.add(resource);
/*     */       }
/*     */     } 
/* 123 */     return resourceList;
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
/*     */   public List<String> getPaths() {
/* 136 */     ArrayList<String> arrayList = new ArrayList(size());
/* 137 */     for (Resource resource : this) {
/* 138 */       arrayList.add(resource.getPath());
/*     */     }
/* 140 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getPathsRelativeToClasspathElement() {
/* 150 */     ArrayList<String> arrayList = new ArrayList(size());
/* 151 */     for (Resource resource : this) {
/* 152 */       arrayList.add(resource.getPath());
/*     */     }
/* 154 */     return arrayList;
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
/*     */   public List<URL> getURLs() {
/* 166 */     ArrayList<URL> arrayList = new ArrayList(size());
/* 167 */     for (Resource resource : this) {
/* 168 */       arrayList.add(resource.getURL());
/*     */     }
/* 170 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<URI> getURIs() {
/* 179 */     ArrayList<URI> arrayList = new ArrayList(size());
/* 180 */     for (Resource resource : this) {
/* 181 */       arrayList.add(resource.getURI());
/*     */     }
/* 183 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 189 */   private static final ResourceFilter CLASSFILE_FILTER = new ResourceFilter()
/*     */     {
/*     */       public final boolean accept(Resource param1Resource) {
/*     */         String str;
/* 193 */         if (!(str = param1Resource.getPath()).endsWith(".class") || str.length() < 7) {
/* 194 */           return false;
/*     */         }
/*     */         
/*     */         char c;
/* 198 */         if ((c = str.charAt(str.length() - 7)) != '/' && c != '.') return true;  return false;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResourceList classFilesOnly() {
/* 208 */     return filter(CLASSFILE_FILTER);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResourceList nonClassFilesOnly() {
/* 218 */     return filter(new ResourceFilter()
/*     */         {
/*     */           public boolean accept(Resource param1Resource) {
/* 221 */             return !ResourceList.CLASSFILE_FILTER.accept(param1Resource);
/*     */           }
/*     */         });
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
/*     */   public Map<String, ResourceList> asMap() {
/* 236 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 237 */     for (Iterator<Resource> iterator = iterator(); iterator.hasNext(); ) {
/* 238 */       Resource resource; String str = (resource = iterator.next()).getPath();
/*     */       ResourceList resourceList;
/* 240 */       if ((resourceList = (ResourceList)hashMap.get(str)) == null) {
/* 241 */         resourceList = new ResourceList(1);
/* 242 */         hashMap.put(str, resourceList);
/*     */       } 
/* 244 */       resourceList.add(resource);
/*     */     } 
/* 246 */     return (Map)hashMap;
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
/*     */   public List<Map.Entry<String, ResourceList>> findDuplicatePaths() {
/* 258 */     ArrayList<Map.Entry<String, ResourceList>> arrayList = new ArrayList();
/* 259 */     for (Iterator<Map.Entry> iterator = asMap().entrySet().iterator(); iterator.hasNext();) {
/*     */       
/* 261 */       if (((ResourceList)(entry = iterator.next()).getValue()).size() > 1) {
/* 262 */         arrayList.add(new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue()));
/*     */       }
/*     */     } 
/* 265 */     CollectionUtils.sortIfNotEmpty(arrayList, new Comparator<Map.Entry<String, ResourceList>>()
/*     */         {
/*     */           public int compare(Map.Entry<String, ResourceList> param1Entry1, Map.Entry<String, ResourceList> param1Entry2)
/*     */           {
/* 269 */             return ((String)param1Entry1.getKey()).compareTo(param1Entry2.getKey());
/*     */           }
/*     */         });
/* 272 */     return arrayList;
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
/*     */   public ResourceList filter(ResourceFilter paramResourceFilter) {
/* 302 */     ResourceList resourceList = new ResourceList();
/* 303 */     for (Resource resource : this) {
/* 304 */       if (paramResourceFilter.accept(resource)) {
/* 305 */         resourceList.add(resource);
/*     */       }
/*     */     } 
/* 308 */     return resourceList;
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
/*     */   @Deprecated
/*     */   public void forEachByteArray(ByteArrayConsumer paramByteArrayConsumer, boolean paramBoolean) {
/* 365 */     for (Resource resource : this) { 
/* 366 */       try { Resource resource1 = resource; Throwable throwable = null; 
/* 367 */         try { paramByteArrayConsumer.accept(resource1, resource1.load()); } catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/* 368 */         finally { if (resource1 != null) if (throwable != null) { try { resource1.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }   }  } catch (IOException iOException)
/* 369 */       { if (!paramBoolean) {
/* 370 */           throw new IllegalArgumentException("Could not load resource " + resource, iOException);
/*     */         } }
/*     */        }
/*     */   
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
/*     */   @Deprecated
/*     */   public void forEachByteArray(ByteArrayConsumer paramByteArrayConsumer) {
/* 389 */     forEachByteArray(paramByteArrayConsumer, false);
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
/*     */   public void forEachByteArrayIgnoringIOException(ByteArrayConsumer paramByteArrayConsumer) {
/* 402 */     for (Resource resource : this) { 
/* 403 */       try { resource = resource; Throwable throwable = null; 
/* 404 */         try { paramByteArrayConsumer.accept(resource, resource.load()); } catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/* 405 */         finally { if (resource != null) if (throwable != null) { try { resource.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }   }  } catch (IOException iOException) {} }
/*     */   
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
/*     */   public void forEachByteArrayThrowingIOException(ByteArrayConsumerThrowsIOException paramByteArrayConsumerThrowsIOException) {
/* 423 */     for (Iterator<Resource> iterator = iterator(); iterator.hasNext();) {
/* 424 */       try (Resource null = resource = iterator.next()) {
/* 425 */         paramByteArrayConsumerThrowsIOException.accept(resource, resource.load());
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void forEachInputStream(InputStreamConsumer paramInputStreamConsumer, boolean paramBoolean) {
/* 485 */     for (Resource resource : this) { 
/* 486 */       try { Resource resource1 = resource; Throwable throwable = null; 
/* 487 */         try { paramInputStreamConsumer.accept(resource1, resource1.open()); } catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/* 488 */         finally { if (resource1 != null) if (throwable != null) { try { resource1.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }   }  } catch (IOException iOException)
/* 489 */       { if (!paramBoolean) {
/* 490 */           throw new IllegalArgumentException("Could not load resource " + resource, iOException);
/*     */         } }
/*     */        }
/*     */   
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
/*     */   @Deprecated
/*     */   public void forEachInputStream(InputStreamConsumer paramInputStreamConsumer) {
/* 509 */     forEachInputStream(paramInputStreamConsumer, false);
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
/*     */   public void forEachInputStreamIgnoringIOException(InputStreamConsumer paramInputStreamConsumer) {
/* 522 */     for (Resource resource : this) { 
/* 523 */       try { resource = resource; Throwable throwable = null; 
/* 524 */         try { paramInputStreamConsumer.accept(resource, resource.open()); } catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/* 525 */         finally { if (resource != null) if (throwable != null) { try { resource.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }   }  } catch (IOException iOException) {} }
/*     */   
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
/*     */   public void forEachInputStreamThrowingIOException(InputStreamConsumerThrowsIOException paramInputStreamConsumerThrowsIOException) {
/* 544 */     for (Iterator<Resource> iterator = iterator(); iterator.hasNext();) {
/* 545 */       try (Resource null = resource = iterator.next()) {
/* 546 */         paramInputStreamConsumerThrowsIOException.accept(resource, resource.open());
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void forEachByteBuffer(ByteBufferConsumer paramByteBufferConsumer, boolean paramBoolean) {
/* 604 */     for (Resource resource : this) { 
/* 605 */       try { Resource resource1 = resource; Throwable throwable = null; 
/* 606 */         try { paramByteBufferConsumer.accept(resource1, resource1.read()); } catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/* 607 */         finally { if (resource1 != null) if (throwable != null) { try { resource1.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }   }  } catch (IOException iOException)
/* 608 */       { if (!paramBoolean) {
/* 609 */           throw new IllegalArgumentException("Could not load resource " + resource, iOException);
/*     */         } }
/*     */        }
/*     */   
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
/*     */   @Deprecated
/*     */   public void forEachByteBuffer(ByteBufferConsumer paramByteBufferConsumer) {
/* 628 */     forEachByteBuffer(paramByteBufferConsumer, false);
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
/*     */   public void forEachByteBufferIgnoringIOException(ByteBufferConsumer paramByteBufferConsumer) {
/* 641 */     for (Resource resource : this) { 
/* 642 */       try { resource = resource; Throwable throwable = null; 
/* 643 */         try { paramByteBufferConsumer.accept(resource, resource.read()); } catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/* 644 */         finally { if (resource != null) if (throwable != null) { try { resource.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }   }  } catch (IOException iOException) {} }
/*     */   
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
/*     */   public void forEachByteBufferThrowingIOException(ByteBufferConsumerThrowsIOException paramByteBufferConsumerThrowsIOException) {
/* 662 */     for (Iterator<Resource> iterator = iterator(); iterator.hasNext();) {
/* 663 */       try (Resource null = resource = iterator.next()) {
/* 664 */         paramByteBufferConsumerThrowsIOException.accept(resource, resource.read());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 674 */     for (Iterator<Resource> iterator = iterator(); iterator.hasNext();)
/* 675 */       (resource = iterator.next()).close(); 
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface ResourceFilter {
/*     */     boolean accept(Resource param1Resource);
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface ByteArrayConsumer {
/*     */     void accept(Resource param1Resource, byte[] param1ArrayOfbyte);
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface ByteArrayConsumerThrowsIOException {
/*     */     void accept(Resource param1Resource, byte[] param1ArrayOfbyte);
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface InputStreamConsumer {
/*     */     void accept(Resource param1Resource, InputStream param1InputStream);
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface InputStreamConsumerThrowsIOException {
/*     */     void accept(Resource param1Resource, InputStream param1InputStream);
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface ByteBufferConsumer {
/*     */     void accept(Resource param1Resource, ByteBuffer param1ByteBuffer);
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface ByteBufferConsumerThrowsIOException {
/*     */     void accept(Resource param1Resource, ByteBuffer param1ByteBuffer);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ResourceList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */