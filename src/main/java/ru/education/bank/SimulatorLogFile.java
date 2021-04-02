package ru.education.bank;

import java.io.*;
import java.util.Date;

public class SimulatorLogFile {

    final File logFile;

    public SimulatorLogFile() {
        logFile = new File("logFile");
    }

    public SimulatorLogFile(File logFile) {
        this.logFile = logFile;
    }

    public void logFile(String login,String text) {
        try {
            Date date = new Date();
            String time =String.valueOf(date);

                Writer file = new BufferedWriter(new FileWriter(logFile, true));
                PrintWriter pw = new PrintWriter(file);
                pw.println(time + ":"+"User "+login+" " +text);
                pw.close();
            } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
