# CPU_Schedulers_Simulator
# Prime Number Generator with Multithreading

## Description

This project involves generating prime numbers within a given range (0 to N) using a multithreaded application. The system simulates a real-life scenario of buffering, where a user specifies N, and the goal is to efficiently produce and write prime numbers to a file. 

Here's how the process works:

1. The producer thread schedules prime numbers and places them into a queue.
2. The consumer thread takes numbers from the queue and writes them to a file.
3. Multiple threads work simultaneously to reduce the elapsed time for generating and writing prime numbers.

### Implementation Details

- The consumer thread holds a lock when it starts and releases it when the ready queue is empty. It also notifies all other threads when it releases the lock.

This multithreaded approach helps improve the efficiency of the prime number generation process and demonstrates the benefits of concurrent programming.
