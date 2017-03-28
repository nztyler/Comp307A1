package main;

import algorithm.Reader;

public class Main {

	// So I don't screw up later in the code writing the name of the file by hand
	public static final String TEST = "iris-test.txt";
	public static final String TRAINING = "iris-training.txt";
	public static final String DATA = "iris.data";
	public static final String NAMES = "iris.names";
	
	private int k = 1;
	
	public static void main(String[] args) {
		
		String file = TEST;
		
		Reader readFile = new Reader(file);
		System.out.println(readFile.toString());
		
		if (args.length == 2) {
			// do the thing
		}
		
		
		
	}
}
