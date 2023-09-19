package com.mycompany.primeproducer;


/*
    Project Team:-
                Group: S6
    1. 20206094 - Youssef Abdelrahman Youssef
    2. 20206068 - Mohamed Alaa Mohamed
    3. 20206130 - Omar Waleed Zenhom
    4. 20206147 - Ayman hatem abdelbaki



 */

public class Producer extends Thread {
    buffer buffer;
    int n;


    public Producer(buffer buffer, int n) {
        this.buffer = buffer;
        this.n = n;
    }

    private synchronized boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n) + 1; i++) {
            if (n == 2)
                continue;
            if (n % i == 0) {
                return false;
            }
        }
        buffer.increase();
        prime.jLabel8.setText(Integer.toString(n));
        prime.jLabel9.setText(Integer.toString(buffer.getTotalPrimes()));

        return true;
    }

    public void run() {
        for (int i = 2; i <= n; i++) {

            buffer.endTime = System.currentTimeMillis();

            long dif = buffer.endTime - buffer.startTime;
            prime.jLabel10.setText(Long.toString(dif)+" ms");


            if (isPrime(i)) {
                buffer.put(i);
            }
        }

        buffer.setFinished(true);
    }


}
