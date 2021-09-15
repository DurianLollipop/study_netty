package cn.ysliu.study.netty.nio;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.stream.IntStream;

public class BasicBuffer {

  public static void main(String[] args) {
    // 设置缓冲区大小为5的int缓冲取
    IntBuffer intBuffer = IntBuffer.allocate(5);
    IntStream.range(0, intBuffer.capacity())
        .boxed()
        .forEach(index -> intBuffer.put(index * 2));
    // 翻转缓冲区，读写切换
    intBuffer.flip();
    while (intBuffer.hasRemaining()){
      System.out.println(intBuffer.get());
    }
  }

}
