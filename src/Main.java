import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Compare obj = new Compare();
        obj.initialize();
        boolean status = true;

        while(status){
            if(obj.comparison()){
                System.out.println("Network Secure");
                Thread.sleep(15000);
            }else{
                System.out.println("Network Not Secure");
                new Command().disconnect();
                System.out.println("Successfully Disconnected From The Network");
                status = false;
            }
        }






//        Command ob = new Command();
//        ob.getARP();
//        ob.firstExecute();
//        ob.secondExecute();
//
//        Compare obj = new Compare();
//        boolean status = true;

//        while(flag){
//            if(obj.)
//        }

//        while(status){
//            if(obj.compare()){
//                System.out.println("Network Secure");
//                Thread.sleep(10000);
//                ob.secondExecute();
//            }
//            else{
//                status = false;
//                System.out.println("Network Not Secure");
//                ob.disconnect();
//                System.out.println("Successfully Disconnected From The Network");
//            }
//        }
    }
}