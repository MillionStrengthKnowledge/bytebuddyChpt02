package com.millionstrengthknowledge.interceptorprj.program;

import com.millionstrengthknowledge.interceptorprj.interceptor.LogInterceptor;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataProducer
{
  public void create()
  {
    LogInterceptor.logger.log(Level.INFO, "Method start");System.out.println("create data");
  }
}
