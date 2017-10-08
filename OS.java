package simulation;

import java.util.ArrayList;

class OS {
	public CPU cpu;
	public IOdevice io;
	public boolean isCPUAvailable;
	public ProcessTable process_Table;
	public ArrayList<Process> New_Queue;
	public ArrayList<Process> Ready_Queue;
	public ArrayList<Process> Wait_Queue;
	public ArrayList<Process> Terminated_Queue;

	// Read the txt input file, for each line, create a process and record its
	// arrival
	// time
	// Put each process in New_Q queue initially then put them in Ready_Q
	// Always check whether the CPU is idle or not; if yes, use your scheduler
	// algorithm to select a process from the Ready_Queue for CPU execution\
	// According to the return value of CPU execute(), put the process into the
	// corresponding queue.
	// Record the time of every operation for computing your latency and
	// response
	public void FCFS(Process process) {
		int timeslice = 999999999;
		boolean done = false;
		int processNumber = 0;
		CPU cpu = new CPU(timeslice);

		while (!done) {
			String state = "New";
			switch (state) {
			case "New":// Process being created
				while (New_Queue.get(0) != null) {
					Ready_Queue.add(New_Queue.get(0));// Moves all processes
														// from New_Queue to
														// Ready_Queue
					New_Queue.remove(0);
				}

				System.out.println("Creating process...");
				state = "Ready";

			case "Ready":// Process is ready to be executed
				System.out.println("Process ready to execute...");
				state = "Running";

			case "Running":// Process is now being executed
				System.out.println("Executing process...");
				CPU.BubbleSort(Ready_Queue.get(0));
				if (wait_for_IO == true) {
					state = "Waiting";
				} else {
					state = "Terminated";
				}

			case "Waiting":// Process is waiting on I/O
				System.out.println("Waiting on I/O");
				while (wait_for_IO == true) {
				}
				state = "Running";

			case "Terminated":// Process has finished executing
				Terminated_Queue.add(Ready_Queue.get(0));
				System.out.println("Finished executing");
				break;
			}
			processNumber++;
		}
	}

	public void RoundRobin(Process process) {

	}

}