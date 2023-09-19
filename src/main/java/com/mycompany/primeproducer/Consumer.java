package com.mycompany.primeproducer;

import java.io.FileWriter;
import java.io.IOException;

public class Consumer extends Thread {
    buffer buffer;
    FileWriter writer;

    public Consumer(buffer buffer, String file) {
        this.buffer = buffer;
        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run() {


        while (true) {

            if (buffer.isFinished() && buffer.getTotalPrimes() == buffer.getOutInFile())
                break;
            int item = buffer.get();

            try {
                writer.write(item + ", ");

            } catch (IOException e) {
                e.printStackTrace();
            }


            buffer.increaseInFile();

        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
