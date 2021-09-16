package cn.ysliu.study.netty.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class NIOFileChannelRead {

  public static void main(String[] args) throws IOException {

    // 创建一个文件输出流
    File file = new File("/home/ysliu/Projects/upload/file.txt");
    FileInputStream fileInputStream = new FileInputStream(file);
    //通过 fileInputStream 获取对应的 FileChannel -> 实际类型 FileChannelImpl
    FileChannel channel = fileInputStream.getChannel();
    //创建容量为文件大小的缓冲区
    ByteBuffer buffer = ByteBuffer.allocate((int) file.length());
    //将通道的数据读入到 Buffer
    channel.read(buffer);
    //将 byteBuffer 的字节数据转成 String
    System.out.println(new String(buffer.array()));
    fileInputStream.close();
  }

}
