package org.example.project;

import java.util.Arrays;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.MemoryAccess;


public class TryMemorySegment {

  public static byte[] byteArr = new byte[128];
  public static MemorySegment seg = MemorySegment.ofArray(byteArr);

  public static void fill() {
    Arrays.fill(byteArr, (byte)1);
    for (int i = 0; i < byteArr.length; i++) {
      if (MemoryAccess.getByteAtOffset(seg, i) == (byte)1) { continue; }
      throw new IllegalStateException("Mismatch");
    }
  }
}
