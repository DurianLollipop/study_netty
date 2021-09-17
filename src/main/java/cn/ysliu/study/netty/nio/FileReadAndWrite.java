package cn.ysliu.study.netty.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileReadAndWrite {

  public static void main(String[] args) throws IOException {
    FileInputStream inputStream = new FileInputStream("/home/ysliu/Projects/upload/file.txt");
    FileChannel inputChannel = inputStream.getChannel();
    FileOutputStream outputStream = new FileOutputStream("/home/ysliu/Projects/upload/copyfile.txt");
    FileChannel outputChannel = outputStream.getChannel();

    ByteBuffer buffer = ByteBuffer.allocate(512);

    // 循环读取
    while (true) {
      // 清空 buffer
      buffer.clear();
      int read = inputChannel.read(buffer);
      // -1表示读完
      if (read == -1) {
        break;
      }
      //将 buffer 中的数据写入到 outputChannel--copyfile.txt
      buffer.flip();
      outputChannel.write(buffer);
    }

    // 关闭相关的流
    inputStream.close();
    outputChannel.close();
  }

}
