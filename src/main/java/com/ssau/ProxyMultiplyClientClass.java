package com.ssau;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

public class ProxyMultiplyClientClass {
  private static final int  SOCKET = 5000;
  private static final String HOST_NAME= "localhost";
  private double[] args;

  public ProxyMultiplyClientClass(){
  }

  public static double ConnectToServer(double firstArg,double secondArg) throws IOException {
    Socket socket = new Socket(HOST_NAME,SOCKET);
    double[] arrDouble = new double[]{firstArg,secondArg};
    byte[] bytes = new byte[arrDouble.length * 8];
    ByteBuffer buf = ByteBuffer.wrap(bytes);
    for (double l : arrDouble) {
      buf.putDouble(l);
    }
    OutputStream outStream = socket.getOutputStream();
    outStream.write(bytes);

    byte[] inputBytes = new byte[]{};
    InputStream inputStream =socket.getInputStream();
    inputStream.read(inputBytes);


    return
  }
}