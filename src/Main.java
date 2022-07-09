public class Main {
    public static void main(String[] args) throws Exception {
        Command ob = new Command();
        ob.firstExecute();
        ob.secondExecute();

        Compare obj = new Compare();
        boolean status = true;

        while(status){
            if(obj.compare()){
                System.out.println("Network Secure");
                Thread.sleep(10000);
                ob.secondExecute();
            }
            else{
                status = false;
                System.out.println("Network Not Secure");
                ob.disconnect();
                System.out.println("Successfully Disconnected From The Network");
            }
        }
    }
}