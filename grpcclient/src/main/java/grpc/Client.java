package grpc;
/*
 * Copyright 2015, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import protobufgencode.EPGrpc;
import protobufgencode.LongRequest;
import protobufgencode.LongResponse;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.protobuf.Empty;

/**
 * A simple client that requests a greeting from the {@link HelloWorldServer}.
 */
public class Client {
  private static final Logger logger = Logger.getLogger(Client.class.getName());

  private final ManagedChannel channel;
  private final EPGrpc.EPBlockingStub blockingStub;

  /** Construct client connecting to HelloWorld server at {@code host:port}. */
  public Client(String host, int port) {
    channel = ManagedChannelBuilder.forAddress(host, port)
        .usePlaintext(true)
        .build();
    blockingStub = EPGrpc.newBlockingStub(channel);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  /** Say hello to server. */
  
  public void testVoid(){
	  try {
	      logger.info("Will try to run tests ");
	      Empty req = Empty.newBuilder().build();
	      //marcar tempo
	      blockingStub.testVoid(req);
	      //marcar tempo
	      logger.info("Done");
	    } catch (RuntimeException e) {
	      logger.log(Level.WARNING, "RPC failed", e);
	      return;
	    }
  }
  
  public long testLong(long val){
	  try {
	      logger.info("Will try to run tests ");
	      LongRequest req = LongRequest.newBuilder().setNumero(val).build();
	      //marcar tempo
	      LongResponse r = blockingStub.testLong(req);
	      //marcar tempo
	      logger.info("Done");
	      long resp = r.getResposta();
	      return resp;
	    } catch (RuntimeException e) {
	      logger.log(Level.WARNING, "RPC failed", e);
	      return Long.MAX_VALUE;
	    }
  }
  
  public long testEightLong(long v1, long v2, long v3, long v4){
	  return 0;
  }
  
  public void runTests() {
    try {
      logger.info("Will try to run tests ");
      
      Empty req = Empty.newBuilder().build();
      //marcar tempo
      blockingStub.testVoid(req);
      //marcar tempo
      
      
      
      //HelloRequest request = HelloRequest.newBuilder().setName(name).build();
      //HelloResponse response = blockingStub.sayHello(request);
      logger.info("Done");
    } catch (RuntimeException e) {
      logger.log(Level.WARNING, "RPC failed", e);
      return;
    }
  }

  
}