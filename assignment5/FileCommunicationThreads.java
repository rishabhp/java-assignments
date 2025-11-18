import java.io.*;

class FileHandler {
    private String inputFile = "input.txt";
    private String outputFile = "output.txt";
    private String dataToWrite = null;

    public synchronized void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            dataToWrite = content.toString();
            notify();
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    public synchronized void writeToFile() {
        try {
            while (dataToWrite == null) {
                wait();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                writer.write(dataToWrite);
            }
            System.out.println("Data written to output file: " + dataToWrite);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

class ReadThread extends Thread {
    private FileHandler fileHandler;

    public ReadThread(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    @Override
    public void run() {
        fileHandler.readFromFile();
    }
}

class WriteThread extends Thread {
    private FileHandler fileHandler;

    public WriteThread(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    @Override
    public void run() {
        fileHandler.writeToFile();
    }
}

public class FileCommunicationThreads {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        
        ReadThread readThread = new ReadThread(fileHandler);
        WriteThread writeThread = new WriteThread(fileHandler);
        
        readThread.start();

        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        writeThread.start();
        
        try {
            readThread.join();
            writeThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        
        System.out.println("File processing complete.");
    }
}
