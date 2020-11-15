/*
Copyright &copy;2020 by MillionStrengthKnowledge.com, All rights reserved.

The publication of the ebook and source code are protected by copyright, 
and permission must be obtained from the MillionStrengthKnowledge.com 
prior to any prohibited reproduction, storage in a retrieval system, 
or transmission in any form or by any means, electronic, mechanical, 
photocopying, recording, or likewise.
 */
package com.millionstrengthknowledge.interceptorprj.interceptor;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.bytebuddy.asm.Advice.OnMethodEnter;

public class LogInterceptor {
    public static Logger logger=
      Logger.getLogger(LogInterceptor.class.getName());

    @OnMethodEnter
    public static void start() {       
        logger.log(Level.INFO, "Method start");
    }
}
