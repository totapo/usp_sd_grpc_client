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
import protobufgencode.Aluno;
import protobufgencode.ArgumentsRequest;
import protobufgencode.CollectionRequest;
import protobufgencode.CollectionResponse;
import protobufgencode.ComplexRequest;
import protobufgencode.ComplexResponse;
import protobufgencode.EPGrpc;
import protobufgencode.EightLongArrayRequest;
import protobufgencode.EightLongRequest;
import protobufgencode.LongRequest;
import protobufgencode.LongResponse;
import protobufgencode.Resultado;
import protobufgencode.StringRequest;
import protobufgencode.StringResponse;
import protobufgencode.Turma;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
        .usePlaintext()
        .build();
    blockingStub = EPGrpc.newBlockingStub(channel);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  /** Say hello to server. */
  
  public long testVoid(){
	  long start, finish;
	  try {
	      //logger.info("Will try to run tests ");
	      Empty req = Empty.newBuilder().build();
	      //marcar tempo
	      start = System.nanoTime();
	      blockingStub.testVoid(req);
	      finish = System.nanoTime();
	      //marcar tempo
	      //logger.info("Done");
	      return finish-start;
	    } catch (RuntimeException e) {
	      //logger.log(Level.WARNING, "RPC failed", e);
	      return -1;
	    }
  }
  
  public long testLong(long val){
	  long start, finish;
	  try {
	      //logger.info("Will try to run tests ");
	      LongRequest req = LongRequest.newBuilder().setNumero(val).build();
	      //marcar tempo
	      start = System.nanoTime();
	      LongResponse r = blockingStub.testLong(req);
	      finish = System.nanoTime();
	      //marcar tempo
	      //logger.info("Done");
	      return finish-start;
	    } catch (RuntimeException e) {
	      //logger.log(Level.WARNING, "RPC failed", e);
	      return -1;
	    }
  }
  
  
  public long testEightLong(long v1, long v2, long v3, long v4, long v5, long v6, long v7, long v8){
	  long start, finish;
	  try {
	      //logger.info("Will try to run tests ");
	      EightLongRequest req = EightLongRequest.newBuilder()
	    		  .setParam1(v1)
	    		  .setParam2(v2)
	    		  .setParam3(v3)
	    		  .setParam4(v4)
	    		  .setParam5(v5)
	    		  .setParam6(v6)
	    		  .setParam7(v7)
	    		  .setParam8(v8)
	    		  .build();
	      //marcar tempo
	      start = System.nanoTime();
	      LongResponse r = blockingStub.testEightLong(req);
	      finish = System.nanoTime();
	      //marcar tempo
	      //logger.info("Done");
	      return finish-start;
	    } catch (RuntimeException e) {
	      //logger.log(Level.WARNING, "RPC failed", e);
	      return -1;
	    }
	}
  
  public long testEightLongArray(List<Long> ar) {
	  long start, finish;
	  try {
	      //logger.info("Will try to run tests ");
	      EightLongArrayRequest req = EightLongArrayRequest.newBuilder()
	    		  .addAllArray(ar)
	    		  .build();
	      //marcar tempo
	      start = System.nanoTime();
	      LongResponse r = blockingStub.testEightLongArray(req);
	      finish = System.nanoTime();
	      //marcar tempo
	      //logger.info("Done");
	      return finish-start;
	    } catch (RuntimeException e) {
	      //logger.log(Level.WARNING, "RPC failed", e);
	      return -1;
	    }
  }
  
  public long testStringLenght(String s) {
	  long start, finish;
	  try {
	      //logger.info("Will try to run tests ");
	      StringRequest req = StringRequest.newBuilder()
	    		  .setReq(s)
	    		  .build();
	      //marcar tempo
	      start = System.nanoTime();
	      StringResponse r = blockingStub.testStringLength(req);
	      finish = System.nanoTime();
	      //marcar tempo
	      //logger.info("Done");
	      return finish-start;
	    } catch (RuntimeException e) {
	      //logger.log(Level.WARNING, "RPC failed", e);
	      return -1;
	    }
  }
  
  public long testComplexType(Turma t) {
	  long start, finish;
	  try {
	      //logger.info("Will try to run tests ");
	      ComplexRequest req = ComplexRequest.newBuilder()
	    		  .setTurma(t)
	    		  .build();
	      //marcar tempo
	      start = System.nanoTime();
	      ComplexResponse r = blockingStub.testComplexType(req);
	      finish = System.nanoTime();
	      //marcar tempo
	      //logger.info("Done");
	      return finish-start;
	    } catch (RuntimeException e) {
	      //logger.log(Level.WARNING, "RPC failed", e);
	      return -1;
	    }
  }
  
  public long testCollection(Collection<Aluno> p){
	  long start, finish;
	  try {
	      //logger.info("Will try to run tests ");
	      CollectionRequest req = CollectionRequest.newBuilder()
	    		  .addAllAlunos(p)
	    		  .build();
	      //marcar tempo
	      start = System.nanoTime();
	      CollectionResponse r = blockingStub.testRemoteCollection(req);
	      finish = System.nanoTime();
	      //marcar tempo
	      //logger.info("Done");
	      return finish-start;
	  } catch (RuntimeException e) {
	      //logger.log(Level.WARNING, "RPC failed", e);
	      return -1;
	  }
  }
  
  public long testArgumentsRequest(Aluno a) {
	  long start, finish;
	  try {
	      //logger.info("Will try to run tests ");
	      ArgumentsRequest req = ArgumentsRequest.newBuilder()
	    		  .setNum(1).setNum2(Long.MAX_VALUE).setNum3(0.5f).setNum4(Double.MIN_VALUE).setBoolean(true).setStr("str")
	    		  .setNum7(1).setNum8(Long.MAX_VALUE).setNum9(0.5f).setNum10(Double.MIN_VALUE).setBoolean2(true).setStr2("str")
	    		  .setNum13(1).setNum14(Long.MAX_VALUE).setNum15(0.5f).setNum16(Double.MIN_VALUE).setBoolean3(true).setStr3("str")
	    		  .setNum19(1).setNum20(Long.MAX_VALUE).setNum21(0.5f).setNum22(Double.MIN_VALUE).setBoolean4(true).setStr4("str")
	    		  .setNum25(1).setNum26(Long.MAX_VALUE).setNum27(0.5f).setNum28(Double.MIN_VALUE).setBoolean5(true).setStr5("str")
	    		  .setNum31(1).setNum32(Long.MAX_VALUE).setNum33(0.5f).setNum34(Double.MIN_VALUE).setBoolean6(true).setStr6("str")
	    		  .setAluno(a)
	    		  .build();
	      //marcar tempo
	      start = System.nanoTime();
	      Empty r = blockingStub.testManyArguments(req);
	      finish = System.nanoTime();
	      //marcar tempo
	      //logger.info("Done");
	      return finish-start;
	  } catch (RuntimeException e) {
	      //logger.log(Level.WARNING, "RPC failed", e);
	      return -1;
	  }
  }
  
  public long testException() {
	  long start, finish;
	  try {
	      //logger.info("Will try to run tests ");
	      Empty req = Empty.newBuilder().build();
	      //marcar tempo
	      start = System.nanoTime();
	      blockingStub.testException(req);
	      finish = System.nanoTime();
	      //marcar tempo
	      //logger.info("Done");
	      return finish-start;
	    } catch (RuntimeException e) {
	      //logger.log(Level.WARNING, "RPC failed", e);
	      return -1;
	    }
  }

  
}