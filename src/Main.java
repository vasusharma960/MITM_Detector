import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        if(!new Command().checkValidity()){
            System.out.println("Not Connected");
            return;
        }

        System.out.println("Connected");
        Compare obj = new Compare();
        obj.initialize();
        boolean status = true;

        while(status){
            if(obj.comparison()){
                System.out.println("Network Secure");
                Thread.sleep(10000);
            }else{
                System.out.println("Network Not Secure");
                new Command().disconnect();
                System.out.println("Successfully Disconnected From The Network");
                status = false;
            }
        }
    }
}