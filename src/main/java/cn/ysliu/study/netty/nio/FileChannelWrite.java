package cn.ysliu.study.netty.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class FileChannelWrite {

  public static void main(String[] args) throws IOException {
    String message = "hello nio fileChannel";

    // 创建一个文件输出流
    FileOutputStream fileOutputStream = new FileOutputStream("/home/ysliu/Projects/upload/file.txt");
    //通过 fileOutputStream 获取对应的 FileChannel
    //这个 fileChannel 真实类型是 FileChannelImpl
    FileChannel fileChannel = fileOutputStream.getChannel();
    //创建一个缓冲区 ByteBuffer并使用字节数组初始化缓冲区。
    ByteBuffer buffer = ByteBuffer.wrap(message.getBytes(StandardCharsets.UTF_8));
    //将 byteBuffer 数据写入到 fileChannel
    fileChannel.write(buffer);
    fileOutputStream.close();
  }

}
