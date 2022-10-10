import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Compare{
    private String initARPDetails;
    private String gatewayIP;

    private void setInitARPDetails(String initDetails){
        this.initARPDetails = initDetails;
    }

    private void setGatewayDetails(String gatewayIP){
        this.gatewayIP = gatewayIP;
    }

    public void initialize(){
        Command ob = new Command();
        setGatewayDetails(ob.defaultGateway);
        setInitARPDetails(ob.getARP());
    }
    private boolean compar()throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader("C:\\Users\\Vasu Sharma\\Desktop\\New folder (2)\\output1.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("C:\\Users\\Vasu Sharma\\Desktop\\New folder (2)\\output2.txt"));

        String line1 = reader1.readLine();
        String line2 = reader2.readLine();

        for(int i = 1; i <= 3;i++ ){
            line1 = reader1.readLine();
            line2 = reader2.readLine();
        }

        if (line1.equalsIgnoreCase(line2)){
            reader1.close();
            reader2.close();
            return true;
        }

        return false;
    }

    public boolean compare()throws IOException{
        return compar();
    }

    public boolean comparison(){
        return comp();
    }

    private boolean comp(){
        String getARPDetails = new Command().getARP();

        if(!getARPDetails.contains(gatewayIP)){
            System.out.println("There might be a change in network. Please restart the application and reconnect with the network.");
            initialize();
        }

        return getARPDetails.equalsIgnoreCase(initARPDetails);
    }
}