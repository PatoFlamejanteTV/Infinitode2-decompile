/*      */ package org.lwjgl.system.linux.liburing;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.Library;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ import org.lwjgl.system.Pointer;
/*      */ import org.lwjgl.system.linux.CMsghdr;
/*      */ import org.lwjgl.system.linux.EpollEvent;
/*      */ import org.lwjgl.system.linux.IOVec;
/*      */ import org.lwjgl.system.linux.KernelTimespec;
/*      */ import org.lwjgl.system.linux.Msghdr;
/*      */ import org.lwjgl.system.linux.OpenHow;
/*      */ import org.lwjgl.system.linux.Sockaddr;
/*      */ import org.lwjgl.system.linux.Statx;
/*      */ 
/*      */ public class LibURing {
/*      */   static {
/*   25 */     Library.initialize();
/*      */   }
/*      */ 
/*      */   
/*      */   protected LibURing() {
/*   30 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final long LIBURING_UDATA_TIMEOUT = -1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("struct io_uring_probe *")
/*      */   public static IOURingProbe io_uring_get_probe_ring(@NativeType("struct io_uring *") IOURing paramIOURing) {
/*      */     long l;
/*   47 */     return IOURingProbe.createSafe(l = nio_uring_get_probe_ring(paramIOURing.address()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("struct io_uring_probe *")
/*      */   public static IOURingProbe io_uring_get_probe() {
/*      */     long l;
/*   66 */     return IOURingProbe.createSafe(l = nio_uring_get_probe());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_free_probe(@NativeType("struct io_uring_probe *") IOURingProbe paramIOURingProbe) {
/*   76 */     nio_uring_free_probe(paramIOURingProbe.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_opcode_supported(@NativeType("struct io_uring_probe const *") IOURingProbe paramIOURingProbe, int paramInt) {
/*   90 */     return nio_uring_opcode_supported(paramIOURingProbe.address(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_queue_init_params(@NativeType("unsigned") int paramInt, @NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("struct io_uring_params *") IOURingParams paramIOURingParams) {
/*   98 */     return nio_uring_queue_init_params(paramInt, paramIOURing.address(), paramIOURingParams.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_queue_init(@NativeType("unsigned") int paramInt1, @NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("unsigned") int paramInt2) {
/*  117 */     return nio_uring_queue_init(paramInt1, paramIOURing.address(), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_queue_mmap(int paramInt, @NativeType("struct io_uring_params *") IOURingParams paramIOURingParams, @NativeType("struct io_uring *") IOURing paramIOURing) {
/*  134 */     return nio_uring_queue_mmap(paramInt, paramIOURingParams.address(), paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_ring_dontfork(@NativeType("struct io_uring *") IOURing paramIOURing) {
/*  148 */     return nio_uring_ring_dontfork(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_queue_exit(@NativeType("struct io_uring *") IOURing paramIOURing) {
/*  162 */     nio_uring_queue_exit(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned")
/*      */   public static int io_uring_peek_batch_cqe(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("struct io_uring_cqe **") PointerBuffer paramPointerBuffer) {
/*  177 */     return nio_uring_peek_batch_cqe(paramIOURing.address(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramPointerBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_wait_cqes(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("struct io_uring_cqe **") PointerBuffer paramPointerBuffer, @NativeType("struct __kernel_timespec *") KernelTimespec paramKernelTimespec, @NativeType("sigset_t *") long paramLong) {
/*  197 */     return nio_uring_wait_cqes(paramIOURing.address(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramPointerBuffer.remaining(), MemoryUtil.memAddressSafe((Pointer)paramKernelTimespec), paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_wait_cqe_timeout(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("struct io_uring_cqe **") PointerBuffer paramPointerBuffer, @NativeType("struct __kernel_timespec *") KernelTimespec paramKernelTimespec) {
/*  215 */     if (Checks.CHECKS) {
/*  216 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/*  218 */     return nio_uring_wait_cqe_timeout(paramIOURing.address(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddressSafe((Pointer)paramKernelTimespec));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_submit(@NativeType("struct io_uring *") IOURing paramIOURing) {
/*  234 */     return nio_uring_submit(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_submit_and_wait(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("unsigned") int paramInt) {
/*  251 */     return nio_uring_submit_and_wait(paramIOURing.address(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_submit_and_wait_timeout(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("struct io_uring_cqe **") PointerBuffer paramPointerBuffer, @NativeType("struct __kernel_timespec *") KernelTimespec paramKernelTimespec, @NativeType("sigset_t *") long paramLong) {
/*  271 */     return nio_uring_submit_and_wait_timeout(paramIOURing.address(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramPointerBuffer.remaining(), MemoryUtil.memAddressSafe((Pointer)paramKernelTimespec), paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_buffers(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("struct iovec const *") IOVec.Buffer paramBuffer) {
/*  291 */     return nio_uring_register_buffers(paramIOURing.address(), paramBuffer.address(), paramBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_buffers_tags(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("struct iovec const *") IOVec.Buffer paramBuffer, @NativeType("__u64 const *") LongBuffer paramLongBuffer) {
/*  299 */     if (Checks.CHECKS) {
/*  300 */       Checks.check(paramLongBuffer, paramBuffer.remaining());
/*      */     }
/*  302 */     return nio_uring_register_buffers_tags(paramIOURing.address(), paramBuffer.address(), MemoryUtil.memAddress(paramLongBuffer), paramBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_buffers_sparse(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("unsigned") int paramInt) {
/*  322 */     return nio_uring_register_buffers_sparse(paramIOURing.address(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_buffers_update_tag(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("unsigned") int paramInt, @NativeType("struct iovec const *") IOVec.Buffer paramBuffer, @NativeType("__u64 const *") LongBuffer paramLongBuffer) {
/*  330 */     if (Checks.CHECKS) {
/*  331 */       Checks.check(paramLongBuffer, paramBuffer.remaining());
/*      */     }
/*  333 */     return nio_uring_register_buffers_update_tag(paramIOURing.address(), paramInt, paramBuffer.address(), MemoryUtil.memAddress(paramLongBuffer), paramBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_unregister_buffers(@NativeType("struct io_uring *") IOURing paramIOURing) {
/*  347 */     return nio_uring_unregister_buffers(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_files(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("int const *") IntBuffer paramIntBuffer) {
/*  363 */     return nio_uring_register_files(paramIOURing.address(), MemoryUtil.memAddress(paramIntBuffer), paramIntBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_files_tags(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("int const *") IntBuffer paramIntBuffer, @NativeType("__u64 const *") LongBuffer paramLongBuffer) {
/*  371 */     if (Checks.CHECKS) {
/*  372 */       Checks.check(paramLongBuffer, paramIntBuffer.remaining());
/*      */     }
/*  374 */     return nio_uring_register_files_tags(paramIOURing.address(), MemoryUtil.memAddress(paramIntBuffer), MemoryUtil.memAddress(paramLongBuffer), paramIntBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_files_sparse(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("unsigned") int paramInt) {
/*  390 */     return nio_uring_register_files_sparse(paramIOURing.address(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_files_update_tag(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("unsigned") int paramInt, @NativeType("int const *") IntBuffer paramIntBuffer, @NativeType("__u64 const *") LongBuffer paramLongBuffer) {
/*  398 */     if (Checks.CHECKS) {
/*  399 */       Checks.check(paramLongBuffer, paramIntBuffer.remaining());
/*      */     }
/*  401 */     return nio_uring_register_files_update_tag(paramIOURing.address(), paramInt, MemoryUtil.memAddress(paramIntBuffer), MemoryUtil.memAddress(paramLongBuffer), paramIntBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_unregister_files(@NativeType("struct io_uring *") IOURing paramIOURing) {
/*  409 */     return nio_uring_unregister_files(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_files_update(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("unsigned") int paramInt, @NativeType("int const *") IntBuffer paramIntBuffer) {
/*  417 */     return nio_uring_register_files_update(paramIOURing.address(), paramInt, MemoryUtil.memAddress(paramIntBuffer), paramIntBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_eventfd(@NativeType("struct io_uring *") IOURing paramIOURing, int paramInt) {
/*  425 */     return nio_uring_register_eventfd(paramIOURing.address(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_eventfd_async(@NativeType("struct io_uring *") IOURing paramIOURing, int paramInt) {
/*  433 */     return nio_uring_register_eventfd_async(paramIOURing.address(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_unregister_eventfd(@NativeType("struct io_uring *") IOURing paramIOURing) {
/*  441 */     return nio_uring_unregister_eventfd(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_probe(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("struct io_uring_probe *") IOURingProbe paramIOURingProbe, @NativeType("unsigned") int paramInt) {
/*  449 */     return nio_uring_register_probe(paramIOURing.address(), paramIOURingProbe.address(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_personality(@NativeType("struct io_uring *") IOURing paramIOURing) {
/*  457 */     return nio_uring_register_personality(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_unregister_personality(@NativeType("struct io_uring *") IOURing paramIOURing, int paramInt) {
/*  465 */     return nio_uring_unregister_personality(paramIOURing.address(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_restrictions(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("struct io_uring_restriction *") IOURingRestriction.Buffer paramBuffer) {
/*  473 */     return nio_uring_register_restrictions(paramIOURing.address(), paramBuffer.address(), paramBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_enable_rings(@NativeType("struct io_uring *") IOURing paramIOURing) {
/*  481 */     return nio_uring_enable_rings(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int __io_uring_sqring_wait(@NativeType("struct io_uring *") IOURing paramIOURing) {
/*  489 */     return n__io_uring_sqring_wait(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_iowq_aff(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("size_t") long paramLong1, @NativeType("cpu_set_t const *") long paramLong2) {
/*  497 */     if (Checks.CHECKS) {
/*  498 */       Checks.check(paramLong2);
/*      */     }
/*  500 */     return nio_uring_register_iowq_aff(paramIOURing.address(), paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_unregister_iowq_aff(@NativeType("struct io_uring *") IOURing paramIOURing) {
/*  508 */     return nio_uring_unregister_iowq_aff(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_iowq_max_workers(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("unsigned int *") IntBuffer paramIntBuffer) {
/*  516 */     if (Checks.CHECKS) {
/*  517 */       Checks.check(paramIntBuffer, 2);
/*      */     }
/*  519 */     return nio_uring_register_iowq_max_workers(paramIOURing.address(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_ring_fd(@NativeType("struct io_uring *") IOURing paramIOURing) {
/*  550 */     return nio_uring_register_ring_fd(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_unregister_ring_fd(@NativeType("struct io_uring *") IOURing paramIOURing) {
/*  567 */     return nio_uring_unregister_ring_fd(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_close_ring_fd(@NativeType("struct io_uring *") IOURing paramIOURing) {
/*  575 */     return nio_uring_close_ring_fd(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_buf_ring(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("struct io_uring_buf_reg *") IOURingBufReg paramIOURingBufReg, @NativeType("unsigned int") int paramInt) {
/*  647 */     return nio_uring_register_buf_ring(paramIOURing.address(), paramIOURingBufReg.address(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_unregister_buf_ring(@NativeType("struct io_uring *") IOURing paramIOURing, int paramInt) {
/*  661 */     return nio_uring_unregister_buf_ring(paramIOURing.address(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_sync_cancel(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("struct io_uring_sync_cancel_reg *") IOURingSyncCancelReg paramIOURingSyncCancelReg) {
/*  669 */     return nio_uring_register_sync_cancel(paramIOURing.address(), paramIOURingSyncCancelReg.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_file_alloc_range(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("unsigned") int paramInt1, @NativeType("unsigned") int paramInt2) {
/*  677 */     return nio_uring_register_file_alloc_range(paramIOURing.address(), paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_get_events(@NativeType("struct io_uring *") IOURing paramIOURing) {
/*  694 */     return nio_uring_get_events(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_submit_and_get_events(@NativeType("struct io_uring *") IOURing paramIOURing) {
/*  712 */     return nio_uring_submit_and_get_events(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_enter(@NativeType("unsigned int") int paramInt1, @NativeType("unsigned int") int paramInt2, @NativeType("unsigned int") int paramInt3, @NativeType("unsigned int") int paramInt4, @NativeType("sigset_t *") long paramLong) {
/*  722 */     if (Checks.CHECKS) {
/*  723 */       Checks.check(paramLong);
/*      */     }
/*  725 */     return nio_uring_enter(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_enter2(@NativeType("unsigned int") int paramInt1, @NativeType("unsigned int") int paramInt2, @NativeType("unsigned int") int paramInt3, @NativeType("unsigned int") int paramInt4, @NativeType("sigset_t *") long paramLong1, @NativeType("size_t") long paramLong2) {
/*  735 */     if (Checks.CHECKS) {
/*  736 */       Checks.check(paramLong1);
/*      */     }
/*  738 */     return nio_uring_enter2(paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_setup(@NativeType("unsigned int") int paramInt, @NativeType("struct io_uring_params *") IOURingParams paramIOURingParams) {
/*  748 */     return nio_uring_setup(paramInt, paramIOURingParams.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("struct io_uring_buf_ring *")
/*      */   public static IOURingBufRing io_uring_setup_buf_ring(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("unsigned int") int paramInt1, int paramInt2, @NativeType("unsigned int") int paramInt3, @NativeType("int *") IntBuffer paramIntBuffer) {
/*  763 */     if (Checks.CHECKS) {
/*  764 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*      */     long l;
/*  767 */     return IOURingBufRing.createSafe(l = nio_uring_setup_buf_ring(paramIOURing.address(), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_free_buf_ring(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("struct io_uring_buf_ring *") IOURingBufRing paramIOURingBufRing, @NativeType("unsigned int") int paramInt1, int paramInt2) {
/*  775 */     return nio_uring_free_buf_ring(paramIOURing.address(), paramIOURingBufRing.address(), paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_cqe_seen(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("struct io_uring_cqe *") IOURingCQE paramIOURingCQE) {
/*  792 */     nio_uring_cqe_seen(paramIOURing.address(), paramIOURingCQE.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_sqe_set_data(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("void *") long paramLong) {
/*  807 */     if (Checks.CHECKS) {
/*  808 */       Checks.check(paramLong);
/*      */     }
/*  810 */     nio_uring_sqe_set_data(paramIOURingSQE.address(), paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static long io_uring_cqe_get_data(@NativeType("struct io_uring_cqe const *") IOURingCQE paramIOURingCQE) {
/*  826 */     return nio_uring_cqe_get_data(paramIOURingCQE.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_sqe_set_data64(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("__u64") long paramLong) {
/*  840 */     nio_uring_sqe_set_data64(paramIOURingSQE.address(), paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("__u64")
/*      */   public static long io_uring_cqe_get_data64(@NativeType("struct io_uring_cqe const *") IOURingCQE paramIOURingCQE) {
/*  851 */     return nio_uring_cqe_get_data64(paramIOURingCQE.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_sqe_set_flags(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("unsigned int") int paramInt) {
/*  865 */     nio_uring_sqe_set_flags(paramIOURingSQE.address(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_splice(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("int64_t") long paramLong1, int paramInt2, @NativeType("int64_t") long paramLong2, @NativeType("unsigned int") int paramInt3, @NativeType("unsigned int") int paramInt4) {
/*  889 */     nio_uring_prep_splice(paramIOURingSQE.address(), paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_tee(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, int paramInt2, @NativeType("unsigned int") int paramInt3, @NativeType("unsigned int") int paramInt4) {
/*  897 */     nio_uring_prep_tee(paramIOURingSQE.address(), paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_readv(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("struct iovec const *") IOVec.Buffer paramBuffer, int paramInt2) {
/*  919 */     nio_uring_prep_readv(paramIOURingSQE.address(), paramInt1, paramBuffer.address(), paramBuffer.remaining(), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_readv2(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("struct iovec const *") IOVec.Buffer paramBuffer, int paramInt2, int paramInt3) {
/*  951 */     nio_uring_prep_readv2(paramIOURingSQE.address(), paramInt1, paramBuffer.address(), paramBuffer.remaining(), paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_read_fixed(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("void *") ByteBuffer paramByteBuffer, int paramInt2, int paramInt3) {
/*  972 */     nio_uring_prep_read_fixed(paramIOURingSQE.address(), paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_writev(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("struct iovec const *") IOVec.Buffer paramBuffer, int paramInt2) {
/*  994 */     nio_uring_prep_writev(paramIOURingSQE.address(), paramInt1, paramBuffer.address(), paramBuffer.remaining(), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_writev2(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("struct iovec const *") IOVec.Buffer paramBuffer, int paramInt2, int paramInt3) {
/* 1026 */     nio_uring_prep_writev2(paramIOURingSQE.address(), paramInt1, paramBuffer.address(), paramBuffer.remaining(), paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_write_fixed(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, int paramInt2, int paramInt3) {
/* 1047 */     nio_uring_prep_write_fixed(paramIOURingSQE.address(), paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_recvmsg(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("struct msghdr *") Msghdr paramMsghdr, @NativeType("unsigned int") int paramInt2) {
/* 1055 */     nio_uring_prep_recvmsg(paramIOURingSQE.address(), paramInt1, paramMsghdr.address(), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_recvmsg_multishot(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("struct msghdr *") Msghdr paramMsghdr, @NativeType("unsigned") int paramInt2) {
/* 1063 */     nio_uring_prep_recvmsg_multishot(paramIOURingSQE.address(), paramInt1, paramMsghdr.address(), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_sendmsg(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("struct msghdr const *") Msghdr paramMsghdr, @NativeType("unsigned int") int paramInt2) {
/* 1071 */     if (Checks.CHECKS) {
/* 1072 */       Msghdr.validate(paramMsghdr.address());
/*      */     }
/* 1074 */     nio_uring_prep_sendmsg(paramIOURingSQE.address(), paramInt1, paramMsghdr.address(), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_poll_add(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("unsigned int") int paramInt2) {
/* 1082 */     nio_uring_prep_poll_add(paramIOURingSQE.address(), paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_poll_multishot(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("unsigned int") int paramInt2) {
/* 1090 */     nio_uring_prep_poll_multishot(paramIOURingSQE.address(), paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_poll_remove(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("__u64") long paramLong) {
/* 1098 */     nio_uring_prep_poll_remove(paramIOURingSQE.address(), paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_poll_update(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("__u64") long paramLong1, @NativeType("__u64") long paramLong2, @NativeType("unsigned int") int paramInt1, @NativeType("unsigned int") int paramInt2) {
/* 1106 */     nio_uring_prep_poll_update(paramIOURingSQE.address(), paramLong1, paramLong2, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_fsync(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("unsigned int") int paramInt2) {
/* 1114 */     nio_uring_prep_fsync(paramIOURingSQE.address(), paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_nop(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE) {
/* 1122 */     nio_uring_prep_nop(paramIOURingSQE.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_timeout(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("struct __kernel_timespec *") KernelTimespec paramKernelTimespec, @NativeType("unsigned int") int paramInt1, @NativeType("unsigned int") int paramInt2) {
/* 1130 */     nio_uring_prep_timeout(paramIOURingSQE.address(), paramKernelTimespec.address(), paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_timeout_remove(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("__u64") long paramLong, @NativeType("unsigned int") int paramInt) {
/* 1138 */     nio_uring_prep_timeout_remove(paramIOURingSQE.address(), paramLong, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_timeout_update(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("struct __kernel_timespec *") KernelTimespec paramKernelTimespec, @NativeType("__u64") long paramLong, @NativeType("unsigned int") int paramInt) {
/* 1146 */     nio_uring_prep_timeout_update(paramIOURingSQE.address(), paramKernelTimespec.address(), paramLong, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_accept(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("struct sockaddr *") Sockaddr paramSockaddr, @NativeType("socklen_t *") IntBuffer paramIntBuffer, int paramInt2) {
/* 1154 */     if (Checks.CHECKS) {
/* 1155 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1157 */     nio_uring_prep_accept(paramIOURingSQE.address(), paramInt1, paramSockaddr.address(), MemoryUtil.memAddress(paramIntBuffer), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_accept_direct(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("struct sockaddr *") Sockaddr paramSockaddr, @NativeType("socklen_t *") IntBuffer paramIntBuffer, int paramInt2, @NativeType("unsigned int") int paramInt3) {
/* 1165 */     if (Checks.CHECKS) {
/* 1166 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1168 */     nio_uring_prep_accept_direct(paramIOURingSQE.address(), paramInt1, paramSockaddr.address(), MemoryUtil.memAddress(paramIntBuffer), paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_multishot_accept(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("struct sockaddr *") Sockaddr paramSockaddr, @NativeType("socklen_t *") IntBuffer paramIntBuffer, int paramInt2) {
/* 1176 */     if (Checks.CHECKS) {
/* 1177 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1179 */     nio_uring_prep_multishot_accept(paramIOURingSQE.address(), paramInt1, paramSockaddr.address(), MemoryUtil.memAddress(paramIntBuffer), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_multishot_accept_direct(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("struct sockaddr *") Sockaddr paramSockaddr, @NativeType("socklen_t *") IntBuffer paramIntBuffer, int paramInt2) {
/* 1187 */     if (Checks.CHECKS) {
/* 1188 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1190 */     nio_uring_prep_multishot_accept_direct(paramIOURingSQE.address(), paramInt1, paramSockaddr.address(), MemoryUtil.memAddress(paramIntBuffer), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_cancel64(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("__u64") long paramLong, int paramInt) {
/* 1198 */     nio_uring_prep_cancel64(paramIOURingSQE.address(), paramLong, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_cancel(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("void *") long paramLong, int paramInt) {
/* 1206 */     if (Checks.CHECKS) {
/* 1207 */       Checks.check(paramLong);
/*      */     }
/* 1209 */     nio_uring_prep_cancel(paramIOURingSQE.address(), paramLong, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_cancel_fd(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("unsigned int") int paramInt2) {
/* 1217 */     nio_uring_prep_cancel_fd(paramIOURingSQE.address(), paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_link_timeout(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("struct __kernel_timespec *") KernelTimespec paramKernelTimespec, @NativeType("unsigned int") int paramInt) {
/* 1225 */     nio_uring_prep_link_timeout(paramIOURingSQE.address(), paramKernelTimespec.address(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_connect(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("struct sockaddr const *") Sockaddr paramSockaddr, @NativeType("socklen_t") int paramInt2) {
/* 1233 */     nio_uring_prep_connect(paramIOURingSQE.address(), paramInt1, paramSockaddr.address(), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_files_update(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("int *") IntBuffer paramIntBuffer, int paramInt) {
/* 1241 */     nio_uring_prep_files_update(paramIOURingSQE.address(), MemoryUtil.memAddress(paramIntBuffer), paramIntBuffer.remaining(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_fallocate(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, int paramInt2, @NativeType("off_t") long paramLong1, @NativeType("off_t") long paramLong2) {
/* 1249 */     nio_uring_prep_fallocate(paramIOURingSQE.address(), paramInt1, paramInt2, paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_openat(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("char const *") ByteBuffer paramByteBuffer, int paramInt2, int paramInt3) {
/* 1257 */     if (Checks.CHECKS) {
/* 1258 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1260 */     nio_uring_prep_openat(paramIOURingSQE.address(), paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3);
/*      */   }
/*      */   public static void io_uring_prep_openat(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("char const *") CharSequence paramCharSequence, int paramInt2, int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 1264 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1266 */       memoryStack.nUTF8(paramCharSequence, true);
/* 1267 */       long l = memoryStack.getPointerAddress();
/* 1268 */       nio_uring_prep_openat(paramIOURingSQE.address(), paramInt1, l, paramInt2, paramInt3); return;
/*      */     } finally {
/* 1270 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_openat_direct(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("char const *") ByteBuffer paramByteBuffer, int paramInt2, int paramInt3, @NativeType("unsigned int") int paramInt4) {
/* 1279 */     if (Checks.CHECKS) {
/* 1280 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1282 */     nio_uring_prep_openat_direct(paramIOURingSQE.address(), paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */   public static void io_uring_prep_openat_direct(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("char const *") CharSequence paramCharSequence, int paramInt2, int paramInt3, @NativeType("unsigned int") int paramInt4) {
/*      */     MemoryStack memoryStack;
/* 1286 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1288 */       memoryStack.nUTF8(paramCharSequence, true);
/* 1289 */       long l = memoryStack.getPointerAddress();
/* 1290 */       nio_uring_prep_openat_direct(paramIOURingSQE.address(), paramInt1, l, paramInt2, paramInt3, paramInt4); return;
/*      */     } finally {
/* 1292 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_close(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt) {
/* 1301 */     nio_uring_prep_close(paramIOURingSQE.address(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_close_direct(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("unsigned int") int paramInt) {
/* 1309 */     nio_uring_prep_close_direct(paramIOURingSQE.address(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_read(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("void *") ByteBuffer paramByteBuffer, int paramInt2) {
/* 1331 */     nio_uring_prep_read(paramIOURingSQE.address(), paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_write(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, int paramInt2) {
/* 1353 */     nio_uring_prep_write(paramIOURingSQE.address(), paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_statx(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("char const *") ByteBuffer paramByteBuffer, int paramInt2, @NativeType("unsigned int") int paramInt3, @NativeType("struct statx *") Statx paramStatx) {
/* 1361 */     if (Checks.CHECKS) {
/* 1362 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1364 */     nio_uring_prep_statx(paramIOURingSQE.address(), paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3, paramStatx.address());
/*      */   }
/*      */   public static void io_uring_prep_statx(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("char const *") CharSequence paramCharSequence, int paramInt2, @NativeType("unsigned int") int paramInt3, @NativeType("struct statx *") Statx paramStatx) {
/*      */     MemoryStack memoryStack;
/* 1368 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1370 */       memoryStack.nUTF8(paramCharSequence, true);
/* 1371 */       long l = memoryStack.getPointerAddress();
/* 1372 */       nio_uring_prep_statx(paramIOURingSQE.address(), paramInt1, l, paramInt2, paramInt3, paramStatx.address()); return;
/*      */     } finally {
/* 1374 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_fadvise(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, int paramInt2, @NativeType("off_t") long paramLong, int paramInt3) {
/* 1383 */     nio_uring_prep_fadvise(paramIOURingSQE.address(), paramInt1, paramInt2, paramLong, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_madvise(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("void *") ByteBuffer paramByteBuffer, int paramInt) {
/* 1391 */     nio_uring_prep_madvise(paramIOURingSQE.address(), MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_send(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, int paramInt2) {
/* 1399 */     nio_uring_prep_send(paramIOURingSQE.address(), paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_send_set_addr(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("struct sockaddr const *") Sockaddr paramSockaddr, @NativeType("__u16") short paramShort) {
/* 1407 */     nio_uring_prep_send_set_addr(paramIOURingSQE.address(), paramSockaddr.address(), paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_sendto(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, int paramInt2, @NativeType("struct sockaddr const *") Sockaddr paramSockaddr, @NativeType("socklen_t") int paramInt3) {
/* 1415 */     nio_uring_prep_sendto(paramIOURingSQE.address(), paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramInt2, paramSockaddr.address(), paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_send_zc(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, int paramInt2, @NativeType("unsigned") int paramInt3) {
/* 1423 */     nio_uring_prep_send_zc(paramIOURingSQE.address(), paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_send_zc_fixed(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, int paramInt2, @NativeType("unsigned") int paramInt3, @NativeType("unsigned") int paramInt4) {
/* 1431 */     nio_uring_prep_send_zc_fixed(paramIOURingSQE.address(), paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_sendmsg_zc(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("struct msghdr const *") Msghdr paramMsghdr, @NativeType("unsigned") int paramInt2) {
/* 1439 */     if (Checks.CHECKS) {
/* 1440 */       Msghdr.validate(paramMsghdr.address());
/*      */     }
/* 1442 */     nio_uring_prep_sendmsg_zc(paramIOURingSQE.address(), paramInt1, paramMsghdr.address(), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_recv(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("void *") ByteBuffer paramByteBuffer, int paramInt2) {
/* 1450 */     nio_uring_prep_recv(paramIOURingSQE.address(), paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_recv_multishot(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("void *") ByteBuffer paramByteBuffer, int paramInt2) {
/* 1458 */     nio_uring_prep_recv_multishot(paramIOURingSQE.address(), paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("struct io_uring_recvmsg_out *")
/*      */   public static IOURingRecvmsgOut io_uring_recvmsg_validate(@NativeType("void *") ByteBuffer paramByteBuffer, @NativeType("struct msghdr *") Msghdr paramMsghdr) {
/*      */     long l;
/* 1469 */     return IOURingRecvmsgOut.createSafe(l = nio_uring_recvmsg_validate(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramMsghdr.address()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static long io_uring_recvmsg_name(@NativeType("struct io_uring_recvmsg_out *") IOURingRecvmsgOut paramIOURingRecvmsgOut) {
/* 1478 */     return nio_uring_recvmsg_name(paramIOURingRecvmsgOut.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("struct cmsghdr *")
/*      */   public static CMsghdr io_uring_recvmsg_cmsg_firsthdr(@NativeType("struct io_uring_recvmsg_out *") IOURingRecvmsgOut paramIOURingRecvmsgOut, @NativeType("struct msghdr *") Msghdr paramMsghdr) {
/*      */     long l;
/* 1489 */     return CMsghdr.createSafe(l = nio_uring_recvmsg_cmsg_firsthdr(paramIOURingRecvmsgOut.address(), paramMsghdr.address()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("struct cmsghdr *")
/*      */   public static CMsghdr io_uring_recvmsg_cmsg_nexthdr(@NativeType("struct io_uring_recvmsg_out *") IOURingRecvmsgOut paramIOURingRecvmsgOut, @NativeType("struct msghdr *") Msghdr paramMsghdr, @NativeType("struct cmsghdr *") CMsghdr paramCMsghdr) {
/*      */     long l;
/* 1500 */     return CMsghdr.createSafe(l = nio_uring_recvmsg_cmsg_nexthdr(paramIOURingRecvmsgOut.address(), paramMsghdr.address(), paramCMsghdr.address()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static long io_uring_recvmsg_payload(@NativeType("struct io_uring_recvmsg_out *") IOURingRecvmsgOut paramIOURingRecvmsgOut, @NativeType("struct msghdr *") Msghdr paramMsghdr) {
/* 1509 */     return nio_uring_recvmsg_payload(paramIOURingRecvmsgOut.address(), paramMsghdr.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned int")
/*      */   public static int io_uring_recvmsg_payload_length(@NativeType("struct io_uring_recvmsg_out *") IOURingRecvmsgOut paramIOURingRecvmsgOut, int paramInt, @NativeType("struct msghdr *") Msghdr paramMsghdr) {
/* 1518 */     return nio_uring_recvmsg_payload_length(paramIOURingRecvmsgOut.address(), paramInt, paramMsghdr.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_openat2(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt, @NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("struct open_how *") OpenHow paramOpenHow) {
/* 1526 */     if (Checks.CHECKS) {
/* 1527 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1529 */     nio_uring_prep_openat2(paramIOURingSQE.address(), paramInt, MemoryUtil.memAddress(paramByteBuffer), paramOpenHow.address());
/*      */   }
/*      */   public static void io_uring_prep_openat2(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt, @NativeType("char const *") CharSequence paramCharSequence, @NativeType("struct open_how *") OpenHow paramOpenHow) {
/*      */     MemoryStack memoryStack;
/* 1533 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1535 */       memoryStack.nUTF8(paramCharSequence, true);
/* 1536 */       long l = memoryStack.getPointerAddress();
/* 1537 */       nio_uring_prep_openat2(paramIOURingSQE.address(), paramInt, l, paramOpenHow.address()); return;
/*      */     } finally {
/* 1539 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_openat2_direct(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("struct open_how *") OpenHow paramOpenHow, @NativeType("unsigned int") int paramInt2) {
/* 1550 */     if (Checks.CHECKS) {
/* 1551 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1553 */     nio_uring_prep_openat2_direct(paramIOURingSQE.address(), paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramOpenHow.address(), paramInt2);
/*      */   }
/*      */   
/*      */   public static void io_uring_prep_openat2_direct(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("char const *") CharSequence paramCharSequence, @NativeType("struct open_how *") OpenHow paramOpenHow, @NativeType("unsigned int") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1558 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1560 */       memoryStack.nUTF8(paramCharSequence, true);
/* 1561 */       long l = memoryStack.getPointerAddress();
/* 1562 */       nio_uring_prep_openat2_direct(paramIOURingSQE.address(), paramInt1, l, paramOpenHow.address(), paramInt2); return;
/*      */     } finally {
/* 1564 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_epoll_ctl(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, int paramInt2, int paramInt3, @NativeType("struct epoll_event *") EpollEvent paramEpollEvent) {
/* 1573 */     nio_uring_prep_epoll_ctl(paramIOURingSQE.address(), paramInt1, paramInt2, paramInt3, paramEpollEvent.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_provide_buffers(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("void *") ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3) {
/* 1581 */     nio_uring_prep_provide_buffers(paramIOURingSQE.address(), MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_remove_buffers(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, int paramInt2) {
/* 1589 */     nio_uring_prep_remove_buffers(paramIOURingSQE.address(), paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_shutdown(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, int paramInt2) {
/* 1597 */     nio_uring_prep_shutdown(paramIOURingSQE.address(), paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_unlinkat(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("char const *") ByteBuffer paramByteBuffer, int paramInt2) {
/* 1605 */     if (Checks.CHECKS) {
/* 1606 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1608 */     nio_uring_prep_unlinkat(paramIOURingSQE.address(), paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2);
/*      */   }
/*      */   public static void io_uring_prep_unlinkat(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("char const *") CharSequence paramCharSequence, int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1612 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1614 */       memoryStack.nUTF8(paramCharSequence, true);
/* 1615 */       long l = memoryStack.getPointerAddress();
/* 1616 */       nio_uring_prep_unlinkat(paramIOURingSQE.address(), paramInt1, l, paramInt2); return;
/*      */     } finally {
/* 1618 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_unlink(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("char const *") ByteBuffer paramByteBuffer, int paramInt) {
/* 1627 */     if (Checks.CHECKS) {
/* 1628 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1630 */     nio_uring_prep_unlink(paramIOURingSQE.address(), MemoryUtil.memAddress(paramByteBuffer), paramInt);
/*      */   }
/*      */   public static void io_uring_prep_unlink(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("char const *") CharSequence paramCharSequence, int paramInt) {
/*      */     MemoryStack memoryStack;
/* 1634 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1636 */       memoryStack.nUTF8(paramCharSequence, true);
/* 1637 */       long l = memoryStack.getPointerAddress();
/* 1638 */       nio_uring_prep_unlink(paramIOURingSQE.address(), l, paramInt); return;
/*      */     } finally {
/* 1640 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_renameat(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("char const *") ByteBuffer paramByteBuffer1, int paramInt2, @NativeType("char const *") ByteBuffer paramByteBuffer2, @NativeType("unsigned int") int paramInt3) {
/* 1649 */     if (Checks.CHECKS) {
/* 1650 */       Checks.checkNT1(paramByteBuffer1);
/* 1651 */       Checks.checkNT1(paramByteBuffer2);
/*      */     } 
/* 1653 */     nio_uring_prep_renameat(paramIOURingSQE.address(), paramInt1, MemoryUtil.memAddress(paramByteBuffer1), paramInt2, MemoryUtil.memAddress(paramByteBuffer2), paramInt3);
/*      */   }
/*      */   public static void io_uring_prep_renameat(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("char const *") CharSequence paramCharSequence1, int paramInt2, @NativeType("char const *") CharSequence paramCharSequence2, @NativeType("unsigned int") int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 1657 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1659 */       memoryStack.nUTF8(paramCharSequence1, true);
/* 1660 */       long l1 = memoryStack.getPointerAddress();
/* 1661 */       memoryStack.nUTF8(paramCharSequence2, true);
/* 1662 */       long l2 = memoryStack.getPointerAddress();
/* 1663 */       nio_uring_prep_renameat(paramIOURingSQE.address(), paramInt1, l1, paramInt2, l2, paramInt3); return;
/*      */     } finally {
/* 1665 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_rename(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("char const *") ByteBuffer paramByteBuffer1, @NativeType("char const *") ByteBuffer paramByteBuffer2) {
/* 1674 */     if (Checks.CHECKS) {
/* 1675 */       Checks.checkNT1(paramByteBuffer1);
/* 1676 */       Checks.checkNT1(paramByteBuffer2);
/*      */     } 
/* 1678 */     nio_uring_prep_rename(paramIOURingSQE.address(), MemoryUtil.memAddress(paramByteBuffer1), MemoryUtil.memAddress(paramByteBuffer2));
/*      */   }
/*      */   public static void io_uring_prep_rename(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("char const *") CharSequence paramCharSequence1, @NativeType("char const *") CharSequence paramCharSequence2) {
/*      */     MemoryStack memoryStack;
/* 1682 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1684 */       memoryStack.nUTF8(paramCharSequence1, true);
/* 1685 */       long l1 = memoryStack.getPointerAddress();
/* 1686 */       memoryStack.nUTF8(paramCharSequence2, true);
/* 1687 */       long l2 = memoryStack.getPointerAddress();
/* 1688 */       nio_uring_prep_rename(paramIOURingSQE.address(), l1, l2); return;
/*      */     } finally {
/* 1690 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_sync_file_range(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("unsigned int") int paramInt2, int paramInt3, int paramInt4) {
/* 1699 */     nio_uring_prep_sync_file_range(paramIOURingSQE.address(), paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_mkdirat(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("char const *") ByteBuffer paramByteBuffer, int paramInt2) {
/* 1707 */     if (Checks.CHECKS) {
/* 1708 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1710 */     nio_uring_prep_mkdirat(paramIOURingSQE.address(), paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2);
/*      */   }
/*      */   public static void io_uring_prep_mkdirat(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("char const *") CharSequence paramCharSequence, int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1714 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1716 */       memoryStack.nUTF8(paramCharSequence, true);
/* 1717 */       long l = memoryStack.getPointerAddress();
/* 1718 */       nio_uring_prep_mkdirat(paramIOURingSQE.address(), paramInt1, l, paramInt2); return;
/*      */     } finally {
/* 1720 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_mkdir(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("char const *") ByteBuffer paramByteBuffer, int paramInt) {
/* 1729 */     if (Checks.CHECKS) {
/* 1730 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1732 */     nio_uring_prep_mkdir(paramIOURingSQE.address(), MemoryUtil.memAddress(paramByteBuffer), paramInt);
/*      */   }
/*      */   public static void io_uring_prep_mkdir(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("char const *") CharSequence paramCharSequence, int paramInt) {
/*      */     MemoryStack memoryStack;
/* 1736 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1738 */       memoryStack.nUTF8(paramCharSequence, true);
/* 1739 */       long l = memoryStack.getPointerAddress();
/* 1740 */       nio_uring_prep_mkdir(paramIOURingSQE.address(), l, paramInt); return;
/*      */     } finally {
/* 1742 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_symlinkat(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("char const *") ByteBuffer paramByteBuffer1, int paramInt, @NativeType("char const *") ByteBuffer paramByteBuffer2) {
/* 1751 */     if (Checks.CHECKS) {
/* 1752 */       Checks.checkNT1(paramByteBuffer1);
/* 1753 */       Checks.checkNT1(paramByteBuffer2);
/*      */     } 
/* 1755 */     nio_uring_prep_symlinkat(paramIOURingSQE.address(), MemoryUtil.memAddress(paramByteBuffer1), paramInt, MemoryUtil.memAddress(paramByteBuffer2));
/*      */   }
/*      */   public static void io_uring_prep_symlinkat(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("char const *") CharSequence paramCharSequence1, int paramInt, @NativeType("char const *") CharSequence paramCharSequence2) {
/*      */     MemoryStack memoryStack;
/* 1759 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1761 */       memoryStack.nUTF8(paramCharSequence1, true);
/* 1762 */       long l1 = memoryStack.getPointerAddress();
/* 1763 */       memoryStack.nUTF8(paramCharSequence2, true);
/* 1764 */       long l2 = memoryStack.getPointerAddress();
/* 1765 */       nio_uring_prep_symlinkat(paramIOURingSQE.address(), l1, paramInt, l2); return;
/*      */     } finally {
/* 1767 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_symlink(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("char const *") ByteBuffer paramByteBuffer1, @NativeType("char const *") ByteBuffer paramByteBuffer2) {
/* 1776 */     if (Checks.CHECKS) {
/* 1777 */       Checks.checkNT1(paramByteBuffer1);
/* 1778 */       Checks.checkNT1(paramByteBuffer2);
/*      */     } 
/* 1780 */     nio_uring_prep_symlink(paramIOURingSQE.address(), MemoryUtil.memAddress(paramByteBuffer1), MemoryUtil.memAddress(paramByteBuffer2));
/*      */   }
/*      */   public static void io_uring_prep_symlink(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("char const *") CharSequence paramCharSequence1, @NativeType("char const *") CharSequence paramCharSequence2) {
/*      */     MemoryStack memoryStack;
/* 1784 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1786 */       memoryStack.nUTF8(paramCharSequence1, true);
/* 1787 */       long l1 = memoryStack.getPointerAddress();
/* 1788 */       memoryStack.nUTF8(paramCharSequence2, true);
/* 1789 */       long l2 = memoryStack.getPointerAddress();
/* 1790 */       nio_uring_prep_symlink(paramIOURingSQE.address(), l1, l2); return;
/*      */     } finally {
/* 1792 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_linkat(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("char const *") ByteBuffer paramByteBuffer1, int paramInt2, @NativeType("char const *") ByteBuffer paramByteBuffer2, int paramInt3) {
/* 1801 */     if (Checks.CHECKS) {
/* 1802 */       Checks.checkNT1(paramByteBuffer1);
/* 1803 */       Checks.checkNT1(paramByteBuffer2);
/*      */     } 
/* 1805 */     nio_uring_prep_linkat(paramIOURingSQE.address(), paramInt1, MemoryUtil.memAddress(paramByteBuffer1), paramInt2, MemoryUtil.memAddress(paramByteBuffer2), paramInt3);
/*      */   }
/*      */   public static void io_uring_prep_linkat(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("char const *") CharSequence paramCharSequence1, int paramInt2, @NativeType("char const *") CharSequence paramCharSequence2, int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 1809 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1811 */       memoryStack.nUTF8(paramCharSequence1, true);
/* 1812 */       long l1 = memoryStack.getPointerAddress();
/* 1813 */       memoryStack.nUTF8(paramCharSequence2, true);
/* 1814 */       long l2 = memoryStack.getPointerAddress();
/* 1815 */       nio_uring_prep_linkat(paramIOURingSQE.address(), paramInt1, l1, paramInt2, l2, paramInt3); return;
/*      */     } finally {
/* 1817 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_link(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("char const *") ByteBuffer paramByteBuffer1, @NativeType("char const *") ByteBuffer paramByteBuffer2, int paramInt) {
/* 1826 */     if (Checks.CHECKS) {
/* 1827 */       Checks.checkNT1(paramByteBuffer1);
/* 1828 */       Checks.checkNT1(paramByteBuffer2);
/*      */     } 
/* 1830 */     nio_uring_prep_link(paramIOURingSQE.address(), MemoryUtil.memAddress(paramByteBuffer1), MemoryUtil.memAddress(paramByteBuffer2), paramInt);
/*      */   }
/*      */   public static void io_uring_prep_link(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("char const *") CharSequence paramCharSequence1, @NativeType("char const *") CharSequence paramCharSequence2, int paramInt) {
/*      */     MemoryStack memoryStack;
/* 1834 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1836 */       memoryStack.nUTF8(paramCharSequence1, true);
/* 1837 */       long l1 = memoryStack.getPointerAddress();
/* 1838 */       memoryStack.nUTF8(paramCharSequence2, true);
/* 1839 */       long l2 = memoryStack.getPointerAddress();
/* 1840 */       nio_uring_prep_link(paramIOURingSQE.address(), l1, l2, paramInt); return;
/*      */     } finally {
/* 1842 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_msg_ring_cqe_flags(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("unsigned int") int paramInt2, @NativeType("__u64") long paramLong, @NativeType("unsigned int") int paramInt3, @NativeType("unsigned int") int paramInt4) {
/* 1851 */     nio_uring_prep_msg_ring_cqe_flags(paramIOURingSQE.address(), paramInt1, paramInt2, paramLong, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_msg_ring(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("unsigned int") int paramInt2, @NativeType("__u64") long paramLong, @NativeType("unsigned int") int paramInt3) {
/* 1859 */     nio_uring_prep_msg_ring(paramIOURingSQE.address(), paramInt1, paramInt2, paramLong, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_msg_ring_fd(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, int paramInt2, int paramInt3, @NativeType("__u64") long paramLong, @NativeType("unsigned int") int paramInt4) {
/* 1867 */     nio_uring_prep_msg_ring_fd(paramIOURingSQE.address(), paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_msg_ring_fd_alloc(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, int paramInt2, @NativeType("__u64") long paramLong, @NativeType("unsigned int") int paramInt3) {
/* 1875 */     nio_uring_prep_msg_ring_fd_alloc(paramIOURingSQE.address(), paramInt1, paramInt2, paramLong, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_getxattr(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("char const *") ByteBuffer paramByteBuffer1, @NativeType("char *") ByteBuffer paramByteBuffer2, @NativeType("char const *") ByteBuffer paramByteBuffer3) {
/* 1883 */     if (Checks.CHECKS) {
/* 1884 */       Checks.checkNT1(paramByteBuffer1);
/* 1885 */       Checks.checkNT1(paramByteBuffer3);
/*      */     } 
/* 1887 */     nio_uring_prep_getxattr(paramIOURingSQE.address(), MemoryUtil.memAddress(paramByteBuffer1), MemoryUtil.memAddress(paramByteBuffer2), MemoryUtil.memAddress(paramByteBuffer3), paramByteBuffer2.remaining());
/*      */   }
/*      */   public static void io_uring_prep_getxattr(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("char const *") CharSequence paramCharSequence1, @NativeType("char *") ByteBuffer paramByteBuffer, @NativeType("char const *") CharSequence paramCharSequence2) {
/*      */     MemoryStack memoryStack;
/* 1891 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1893 */       memoryStack.nUTF8(paramCharSequence1, true);
/* 1894 */       long l1 = memoryStack.getPointerAddress();
/* 1895 */       memoryStack.nUTF8(paramCharSequence2, true);
/* 1896 */       long l2 = memoryStack.getPointerAddress();
/* 1897 */       nio_uring_prep_getxattr(paramIOURingSQE.address(), l1, MemoryUtil.memAddress(paramByteBuffer), l2, paramByteBuffer.remaining()); return;
/*      */     } finally {
/* 1899 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_setxattr(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("char const *") ByteBuffer paramByteBuffer1, @NativeType("char const *") ByteBuffer paramByteBuffer2, @NativeType("char const *") ByteBuffer paramByteBuffer3, int paramInt) {
/* 1908 */     if (Checks.CHECKS) {
/* 1909 */       Checks.checkNT1(paramByteBuffer1);
/* 1910 */       Checks.checkNT1(paramByteBuffer3);
/*      */     } 
/* 1912 */     nio_uring_prep_setxattr(paramIOURingSQE.address(), MemoryUtil.memAddress(paramByteBuffer1), MemoryUtil.memAddress(paramByteBuffer2), MemoryUtil.memAddress(paramByteBuffer3), paramInt, paramByteBuffer2.remaining());
/*      */   }
/*      */   public static void io_uring_prep_setxattr(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, @NativeType("char const *") CharSequence paramCharSequence1, @NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("char const *") CharSequence paramCharSequence2, int paramInt) {
/*      */     MemoryStack memoryStack;
/* 1916 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1918 */       memoryStack.nUTF8(paramCharSequence1, true);
/* 1919 */       long l1 = memoryStack.getPointerAddress();
/* 1920 */       memoryStack.nUTF8(paramCharSequence2, true);
/* 1921 */       long l2 = memoryStack.getPointerAddress();
/* 1922 */       nio_uring_prep_setxattr(paramIOURingSQE.address(), l1, MemoryUtil.memAddress(paramByteBuffer), l2, paramInt, paramByteBuffer.remaining()); return;
/*      */     } finally {
/* 1924 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_fgetxattr(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt, @NativeType("char const *") ByteBuffer paramByteBuffer1, @NativeType("char *") ByteBuffer paramByteBuffer2) {
/* 1933 */     if (Checks.CHECKS) {
/* 1934 */       Checks.checkNT1(paramByteBuffer1);
/*      */     }
/* 1936 */     nio_uring_prep_fgetxattr(paramIOURingSQE.address(), paramInt, MemoryUtil.memAddress(paramByteBuffer1), MemoryUtil.memAddress(paramByteBuffer2), paramByteBuffer2.remaining());
/*      */   }
/*      */   public static void io_uring_prep_fgetxattr(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt, @NativeType("char const *") CharSequence paramCharSequence, @NativeType("char *") ByteBuffer paramByteBuffer) {
/*      */     MemoryStack memoryStack;
/* 1940 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1942 */       memoryStack.nUTF8(paramCharSequence, true);
/* 1943 */       long l = memoryStack.getPointerAddress();
/* 1944 */       nio_uring_prep_fgetxattr(paramIOURingSQE.address(), paramInt, l, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining()); return;
/*      */     } finally {
/* 1946 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_fsetxattr(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("char const *") ByteBuffer paramByteBuffer1, @NativeType("char const *") ByteBuffer paramByteBuffer2, int paramInt2) {
/* 1955 */     if (Checks.CHECKS) {
/* 1956 */       Checks.checkNT1(paramByteBuffer1);
/*      */     }
/* 1958 */     nio_uring_prep_fsetxattr(paramIOURingSQE.address(), paramInt1, MemoryUtil.memAddress(paramByteBuffer1), MemoryUtil.memAddress(paramByteBuffer2), paramInt2, paramByteBuffer2.remaining());
/*      */   }
/*      */   public static void io_uring_prep_fsetxattr(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, @NativeType("char const *") CharSequence paramCharSequence, @NativeType("char const *") ByteBuffer paramByteBuffer, int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1962 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1964 */       memoryStack.nUTF8(paramCharSequence, true);
/* 1965 */       long l = memoryStack.getPointerAddress();
/* 1966 */       nio_uring_prep_fsetxattr(paramIOURingSQE.address(), paramInt1, l, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramByteBuffer.remaining()); return;
/*      */     } finally {
/* 1968 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_socket(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, int paramInt2, int paramInt3, @NativeType("unsigned int") int paramInt4) {
/* 1977 */     nio_uring_prep_socket(paramIOURingSQE.address(), paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_socket_direct(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, int paramInt2, int paramInt3, @NativeType("unsigned int") int paramInt4, @NativeType("unsigned int") int paramInt5) {
/* 1985 */     nio_uring_prep_socket_direct(paramIOURingSQE.address(), paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_socket_direct_alloc(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE, int paramInt1, int paramInt2, int paramInt3, @NativeType("unsigned int") int paramInt4) {
/* 1993 */     nio_uring_prep_socket_direct_alloc(paramIOURingSQE.address(), paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned int")
/*      */   public static int io_uring_sq_ready(@NativeType("struct io_uring const *") IOURing paramIOURing) {
/* 2004 */     if (Checks.CHECKS) {
/* 2005 */       IOURing.validate(paramIOURing.address());
/*      */     }
/* 2007 */     return nio_uring_sq_ready(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned int")
/*      */   public static int io_uring_sq_space_left(@NativeType("struct io_uring const *") IOURing paramIOURing) {
/* 2018 */     if (Checks.CHECKS) {
/* 2019 */       IOURing.validate(paramIOURing.address());
/*      */     }
/* 2021 */     return nio_uring_sq_space_left(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_sqring_wait(@NativeType("struct io_uring *") IOURing paramIOURing) {
/* 2038 */     return nio_uring_sqring_wait(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned int")
/*      */   public static int io_uring_cq_ready(@NativeType("struct io_uring const *") IOURing paramIOURing) {
/* 2049 */     if (Checks.CHECKS) {
/* 2050 */       IOURing.validate(paramIOURing.address());
/*      */     }
/* 2052 */     return nio_uring_cq_ready(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("bool")
/*      */   public static boolean io_uring_cq_has_overflow(@NativeType("struct io_uring const *") IOURing paramIOURing) {
/* 2063 */     if (Checks.CHECKS) {
/* 2064 */       IOURing.validate(paramIOURing.address());
/*      */     }
/* 2066 */     return nio_uring_cq_has_overflow(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("bool")
/*      */   public static boolean io_uring_cq_eventfd_enabled(@NativeType("struct io_uring const *") IOURing paramIOURing) {
/* 2077 */     if (Checks.CHECKS) {
/* 2078 */       IOURing.validate(paramIOURing.address());
/*      */     }
/* 2080 */     return nio_uring_cq_eventfd_enabled(paramIOURing.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_cq_eventfd_toggle(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("bool") boolean paramBoolean) {
/* 2090 */     return nio_uring_cq_eventfd_toggle(paramIOURing.address(), paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_wait_cqe_nr(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("struct io_uring_cqe **") PointerBuffer paramPointerBuffer) {
/* 2107 */     return nio_uring_wait_cqe_nr(paramIOURing.address(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramPointerBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_peek_cqe(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("struct io_uring_cqe **") PointerBuffer paramPointerBuffer) {
/* 2121 */     if (Checks.CHECKS) {
/* 2122 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/* 2124 */     return nio_uring_peek_cqe(paramIOURing.address(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_wait_cqe(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("struct io_uring_cqe **") PointerBuffer paramPointerBuffer) {
/* 2141 */     if (Checks.CHECKS) {
/* 2142 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/* 2144 */     return nio_uring_wait_cqe(paramIOURing.address(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_buf_ring_advance(@NativeType("struct io_uring_buf_ring *") IOURingBufRing paramIOURingBufRing, int paramInt) {
/* 2152 */     nio_uring_buf_ring_advance(paramIOURingBufRing.address(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_buf_ring_cq_advance(@NativeType("struct io_uring *") IOURing paramIOURing, @NativeType("struct io_uring_buf_ring *") IOURingBufRing paramIOURingBufRing, int paramInt) {
/* 2160 */     nio_uring_buf_ring_cq_advance(paramIOURing.address(), paramIOURingBufRing.address(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("struct io_uring_sqe *")
/*      */   public static IOURingSQE io_uring_get_sqe(@NativeType("struct io_uring *") IOURing paramIOURing) {
/*      */     long l;
/* 2179 */     return IOURingSQE.createSafe(l = nio_uring_get_sqe(paramIOURing.address()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_mlock_size_params(@NativeType("unsigned") int paramInt, @NativeType("struct io_uring_params *") IOURingParams paramIOURingParams) {
/* 2204 */     return nio_uring_mlock_size_params(paramInt, paramIOURingParams.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_buf_ring_mask(@NativeType("__u32") int paramInt) {
/* 2222 */     return paramInt - 1;
/*      */   }
/*      */   
/*      */   public static void io_uring_buf_ring_init(@NativeType("struct io_uring_buf_ring *") IOURingBufRing paramIOURingBufRing) {
/* 2226 */     paramIOURingBufRing.tail((short)0);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_buf_ring_add(@NativeType("struct io_uring_buf_ring *") IOURingBufRing paramIOURingBufRing, @NativeType("void *") ByteBuffer paramByteBuffer, @NativeType("unsigned short") short paramShort, int paramInt1, int paramInt2) {
/*      */     IOURingBuf iOURingBuf;
/* 2232 */     (iOURingBuf = paramIOURingBufRing.bufs(paramIOURingBufRing.tail() + paramInt2 & paramInt1)).addr(MemoryUtil.memAddress(paramByteBuffer));
/* 2233 */     iOURingBuf.len(paramByteBuffer.remaining());
/* 2234 */     iOURingBuf.bid(paramShort);
/*      */   }
/*      */   
/*      */   public static native long nio_uring_get_probe_ring(long paramLong);
/*      */   
/*      */   public static native long nio_uring_get_probe();
/*      */   
/*      */   public static native void nio_uring_free_probe(long paramLong);
/*      */   
/*      */   public static native int nio_uring_opcode_supported(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nio_uring_queue_init_params(int paramInt, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_queue_init(int paramInt1, long paramLong, int paramInt2);
/*      */   
/*      */   public static native int nio_uring_queue_mmap(int paramInt, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_ring_dontfork(long paramLong);
/*      */   
/*      */   public static native void nio_uring_queue_exit(long paramLong);
/*      */   
/*      */   public static native int nio_uring_peek_batch_cqe(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nio_uring_wait_cqes(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int nio_uring_wait_cqe_timeout(long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int nio_uring_submit(long paramLong);
/*      */   
/*      */   public static native int nio_uring_submit_and_wait(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nio_uring_submit_and_wait_timeout(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int nio_uring_register_buffers(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nio_uring_register_buffers_tags(long paramLong1, long paramLong2, long paramLong3, int paramInt);
/*      */   
/*      */   public static native int nio_uring_register_buffers_sparse(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nio_uring_register_buffers_update_tag(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native int nio_uring_unregister_buffers(long paramLong);
/*      */   
/*      */   public static native int nio_uring_register_files(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nio_uring_register_files_tags(long paramLong1, long paramLong2, long paramLong3, int paramInt);
/*      */   
/*      */   public static native int nio_uring_register_files_sparse(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nio_uring_register_files_update_tag(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native int nio_uring_unregister_files(long paramLong);
/*      */   
/*      */   public static native int nio_uring_register_files_update(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native int nio_uring_register_eventfd(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nio_uring_register_eventfd_async(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nio_uring_unregister_eventfd(long paramLong);
/*      */   
/*      */   public static native int nio_uring_register_probe(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nio_uring_register_personality(long paramLong);
/*      */   
/*      */   public static native int nio_uring_unregister_personality(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nio_uring_register_restrictions(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nio_uring_enable_rings(long paramLong);
/*      */   
/*      */   public static native int n__io_uring_sqring_wait(long paramLong);
/*      */   
/*      */   public static native int nio_uring_register_iowq_aff(long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int nio_uring_unregister_iowq_aff(long paramLong);
/*      */   
/*      */   public static native int nio_uring_register_iowq_max_workers(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_register_ring_fd(long paramLong);
/*      */   
/*      */   public static native int nio_uring_unregister_ring_fd(long paramLong);
/*      */   
/*      */   public static native int nio_uring_close_ring_fd(long paramLong);
/*      */   
/*      */   public static native int nio_uring_register_buf_ring(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nio_uring_unregister_buf_ring(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nio_uring_register_sync_cancel(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_register_file_alloc_range(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native int nio_uring_get_events(long paramLong);
/*      */   
/*      */   public static native int nio_uring_submit_and_get_events(long paramLong);
/*      */   
/*      */   public static native int nio_uring_enter(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native int nio_uring_enter2(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_setup(int paramInt, long paramLong);
/*      */   
/*      */   public static native int io_uring_register(@NativeType("unsigned int") int paramInt1, @NativeType("unsigned int") int paramInt2, @NativeType("void *") long paramLong, @NativeType("unsigned int") int paramInt3);
/*      */   
/*      */   public static native long nio_uring_setup_buf_ring(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_free_buf_ring(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_cqe_seen(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nio_uring_sqe_set_data(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native long nio_uring_cqe_get_data(long paramLong);
/*      */   
/*      */   public static native void nio_uring_sqe_set_data64(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native long nio_uring_cqe_get_data64(long paramLong);
/*      */   
/*      */   public static native void nio_uring_sqe_set_flags(long paramLong, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_splice(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_tee(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_readv(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_readv2(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_read_fixed(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_writev(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_writev2(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_write_fixed(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_recvmsg(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_recvmsg_multishot(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_sendmsg(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_poll_add(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_poll_multishot(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_poll_remove(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nio_uring_prep_poll_update(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_fsync(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_nop(long paramLong);
/*      */   
/*      */   public static native void nio_uring_prep_timeout(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_timeout_remove(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_timeout_update(long paramLong1, long paramLong2, long paramLong3, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_accept(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_accept_direct(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_multishot_accept(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_multishot_accept_direct(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_cancel64(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_cancel(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_cancel_fd(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_link_timeout(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_connect(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_files_update(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_fallocate(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void nio_uring_prep_openat(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_openat_direct(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_close(long paramLong, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_close_direct(long paramLong, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_read(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_write(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_statx(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, long paramLong3);
/*      */   
/*      */   public static native void nio_uring_prep_fadvise(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_madvise(long paramLong1, long paramLong2, long paramLong3, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_send(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_send_set_addr(long paramLong1, long paramLong2, short paramShort);
/*      */   
/*      */   public static native void nio_uring_prep_sendto(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_send_zc(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_send_zc_fixed(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_sendmsg_zc(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_recv(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_recv_multishot(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native long nio_uring_recvmsg_validate(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native long nio_uring_recvmsg_name(long paramLong);
/*      */   
/*      */   public static native long nio_uring_recvmsg_cmsg_firsthdr(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native long nio_uring_recvmsg_cmsg_nexthdr(long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native long nio_uring_recvmsg_payload(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_recvmsg_payload_length(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native void nio_uring_prep_openat2(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void nio_uring_prep_openat2_direct(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_epoll_ctl(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
/*      */   
/*      */   public static native void nio_uring_prep_provide_buffers(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_remove_buffers(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_shutdown(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_unlinkat(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_unlink(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_renameat(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_rename(long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void nio_uring_prep_sync_file_range(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_mkdirat(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_mkdir(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_symlinkat(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*      */   
/*      */   public static native void nio_uring_prep_symlink(long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void nio_uring_prep_linkat(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_link(long paramLong1, long paramLong2, long paramLong3, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_msg_ring_cqe_flags(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_msg_ring(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_msg_ring_fd(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_msg_ring_fd_alloc(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_getxattr(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_setxattr(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_fgetxattr(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_fsetxattr(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_socket(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_socket_direct(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*      */   
/*      */   public static native void nio_uring_prep_socket_direct_alloc(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native int nio_uring_sq_ready(long paramLong);
/*      */   
/*      */   public static native int nio_uring_sq_space_left(long paramLong);
/*      */   
/*      */   public static native int nio_uring_sqring_wait(long paramLong);
/*      */   
/*      */   public static native int nio_uring_cq_ready(long paramLong);
/*      */   
/*      */   public static native boolean nio_uring_cq_has_overflow(long paramLong);
/*      */   
/*      */   public static native boolean nio_uring_cq_eventfd_enabled(long paramLong);
/*      */   
/*      */   public static native int nio_uring_cq_eventfd_toggle(long paramLong, boolean paramBoolean);
/*      */   
/*      */   public static native int nio_uring_wait_cqe_nr(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nio_uring_peek_cqe(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_wait_cqe(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nio_uring_buf_ring_advance(long paramLong, int paramInt);
/*      */   
/*      */   public static native void nio_uring_buf_ring_cq_advance(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native long nio_uring_get_sqe(long paramLong);
/*      */   
/*      */   public static native int io_uring_mlock_size(@NativeType("unsigned") int paramInt1, @NativeType("unsigned") int paramInt2);
/*      */   
/*      */   public static native int nio_uring_mlock_size_params(int paramInt, long paramLong);
/*      */   
/*      */   public static native int io_uring_major_version();
/*      */   
/*      */   public static native int io_uring_minor_version();
/*      */   
/*      */   @NativeType("bool")
/*      */   public static native boolean io_uring_check_version(int paramInt1, int paramInt2);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\LibURing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */