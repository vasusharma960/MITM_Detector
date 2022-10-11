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