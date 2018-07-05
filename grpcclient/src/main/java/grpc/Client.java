package grpc;

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
import protobufgencode.StringRequest;
import protobufgencode.StringResponse;
import protobufgencode.Turma;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.protobuf.Empty;

public class Client {

	private final ManagedChannel channel;
	private final EPGrpc.EPBlockingStub blockingStub;

	public Client(String host, int port) {
		channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		blockingStub = EPGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}


	public long testVoid() {
		long start, finish;
		try {
			// logger.info("Will try to run tests ");
			Empty req = Empty.newBuilder().build();
			// marcar tempo
			start = System.nanoTime();
			blockingStub.testVoid(req);
			finish = System.nanoTime();
			// marcar tempo
			// logger.info("Done");
			return finish - start;
		} catch (RuntimeException e) {
			// logger.log(Level.WARNING, "RPC failed", e);
			return -1;
		}
	}

	public long testLong(long val) {
		long start, finish;
		try {
			// logger.info("Will try to run tests ");
			LongRequest req = LongRequest.newBuilder().setNumero(val).build();
			// marcar tempo
			start = System.nanoTime();
			LongResponse r = blockingStub.testLong(req);
			finish = System.nanoTime();
			// marcar tempo
			// logger.info("Done");
			return finish - start;
		} catch (RuntimeException e) {
			// logger.log(Level.WARNING, "RPC failed", e);
			return -1;
		}
	}

	public long testEightLong(long v1, long v2, long v3, long v4, long v5, long v6, long v7, long v8) {
		long start, finish;
		try {
			// logger.info("Will try to run tests ");
			EightLongRequest req = EightLongRequest.newBuilder().setParam1(v1).setParam2(v2).setParam3(v3).setParam4(v4)
					.setParam5(v5).setParam6(v6).setParam7(v7).setParam8(v8).build();
			// marcar tempo
			start = System.nanoTime();
			LongResponse r = blockingStub.testEightLong(req);
			finish = System.nanoTime();
			// marcar tempo
			// logger.info("Done");
			return finish - start;
		} catch (RuntimeException e) {
			// logger.log(Level.WARNING, "RPC failed", e);
			return -1;
		}
	}

	public long testEightLongArray(List<Long> ar) {
		long start, finish;
		try {
			// logger.info("Will try to run tests ");
			EightLongArrayRequest req = EightLongArrayRequest.newBuilder().addAllArray(ar).build();
			// marcar tempo
			start = System.nanoTime();
			LongResponse r = blockingStub.testEightLongArray(req);
			finish = System.nanoTime();
			// marcar tempo
			// logger.info("Done");
			return finish - start;
		} catch (RuntimeException e) {
			// logger.log(Level.WARNING, "RPC failed", e);
			return -1;
		}
	}

	public long testStringLenght(String s) {
		long start, finish;
		try {
			// logger.info("Will try to run tests ");
			StringRequest req = StringRequest.newBuilder().setReq(s).build();
			// marcar tempo
			start = System.nanoTime();
			StringResponse r = blockingStub.testStringLength(req);
			finish = System.nanoTime();
			// marcar tempo
			// logger.info("Done");
			return finish - start;
		} catch (RuntimeException e) {
			// logger.log(Level.WARNING, "RPC failed", e);
			return -1;
		}
	}

	public long testComplexType(Turma t) {
		long start, finish;
		try {
			// logger.info("Will try to run tests ");
			ComplexRequest req = ComplexRequest.newBuilder().setTurma(t).build();
			// marcar tempo
			start = System.nanoTime();
			ComplexResponse r = blockingStub.testComplexType(req);
			finish = System.nanoTime();
			// marcar tempo
			// logger.info("Done");
			return finish - start;
		} catch (RuntimeException e) {
			// logger.log(Level.WARNING, "RPC failed", e);
			return -1;
		}
	}

	public long testCollection(Collection<Aluno> p) {
		long start, finish;
		try {
			// logger.info("Will try to run tests ");
			CollectionRequest req = CollectionRequest.newBuilder().addAllAlunos(p).build();
			// marcar tempo
			start = System.nanoTime();
			CollectionResponse r = blockingStub.testRemoteCollection(req);
			finish = System.nanoTime();
			// marcar tempo
			// logger.info("Done");
			return finish - start;
		} catch (RuntimeException e) {
			// logger.log(Level.WARNING, "RPC failed", e);
			return -1;
		}
	}

	public long testArgumentsRequest(Aluno a) {
		long start, finish;
		try {
			// logger.info("Will try to run tests ");
			ArgumentsRequest req = ArgumentsRequest.newBuilder().setNum(1).setNum2(Long.MAX_VALUE).setNum3(0.5f)
					.setNum4(Double.MIN_VALUE).setBoolean(true).setStr("str").setNum7(1).setNum8(Long.MAX_VALUE)
					.setNum9(0.5f).setNum10(Double.MIN_VALUE).setBoolean2(true).setStr2("str").setNum13(1)
					.setNum14(Long.MAX_VALUE).setNum15(0.5f).setNum16(Double.MIN_VALUE).setBoolean3(true).setStr3("str")
					.setNum19(1).setNum20(Long.MAX_VALUE).setNum21(0.5f).setNum22(Double.MIN_VALUE).setBoolean4(true)
					.setStr4("str").setNum25(1).setNum26(Long.MAX_VALUE).setNum27(0.5f).setNum28(Double.MIN_VALUE)
					.setBoolean5(true).setStr5("str").setNum31(1).setNum32(Long.MAX_VALUE).setNum33(0.5f)
					.setNum34(Double.MIN_VALUE).setBoolean6(true).setStr6("str").setAluno(a).build();
			// marcar tempo
			start = System.nanoTime();
			Empty r = blockingStub.testManyArguments(req);
			finish = System.nanoTime();
			// marcar tempo
			// logger.info("Done");
			return finish - start;
		} catch (RuntimeException e) {
			// logger.log(Level.WARNING, "RPC failed", e);
			return -1;
		}
	}

	public long testException() {
		long start, finish;
		// logger.info("Will try to run tests ");
		Empty req = Empty.newBuilder().build();
		// marcar tempo
		start = System.nanoTime();
		try {
			blockingStub.testException(req);
			finish = System.nanoTime();
			// marcar tempo
			// logger.info("Done");
		} catch (RuntimeException e) {
			finish = System.nanoTime();
		}
		return finish - start;
	}

}