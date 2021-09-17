package cn.ysliu.study.netty.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileChannelTransferFrom {

  public static void main(String[] args) throws IOException {

    // 创建相关流
    FileInputStream inputStream = new FileInputStream("/home/ysliu/upload/1.jpg");
    FileOutputStream outputStream = new FileOutputStream("/home/ysliu/upload/2.jpg");

    // 获取各个流对应的 FileChannel
    FileChannel inputChannel = inputStream.getChannel();
    FileChannel outputChannel = outputStream.getChannel();

    // 使用 transferForm 完成拷贝
    outputChannel.transferFrom(inputChannel, 0, inputChannel.size());

    // 关闭相关通道和流
    inputChannel.close();
    outputChannel.close();
    inputStream.close();
    outputStream.close();

  }

}
