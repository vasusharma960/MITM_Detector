import java.io.*;

public class Command {
    private void exearp(String path){
        String command = "arp -a";

        try {
            Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            File file = new File(path);
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            String line;
            while ((line = reader.readLine()) != null) {
                pw.println(line);
            }

            reader.close();
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void firstExecute(){
        exearp("C:\\Users\\Vasu Sharma\\Desktop\\New folder (2)\\output1.txt");
    }

    public void secondExecute(){
        exearp("C:\\Users\\Vasu Sharma\\Desktop\\New folder (2)\\output2.txt");
    }
    public void disconnect()throws IOException{
        Process pro = Runtime.getRuntime().exec("netsh wlan disconnect");
    }
}