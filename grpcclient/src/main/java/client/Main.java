package client;

import grpc.Client;

public class Main {
	/**
	   * Greet server. If provided, the first element of {@code args} is the name to use in the
	   * greeting.
	   */
	  public static void main(String[] args) throws Exception {
	    Client client = new Client("localhost", 50051);
	    try {
	      client.runTests();
	    } finally {
	      client.shutdown();
	    }
	  }
}
