import java.io.*;

class Command {
    protected final String sysMAC;
    protected final String sysIP;
    protected final String defaultGateway;
    private boolean valid = true;

    Command(){
        String ip = "", mac = "", gateway = "";
        try{
            Process p = Runtime.getRuntime().exec("ipconfig /all");
            BufferedReader br = new BufferedReader((new InputStreamReader(p.getInputStream())));
            String l;
            int c = 0;

            while((l = br.readLine()) != null){
                if(l.trim().equals("Wireless LAN adapter Wi-Fi:")){
                    l = br.readLine();

                    while((l = br.readLine()) != null && !l.trim().isEmpty()){
                        if(l.contains("Media disconnected")){
                            this.valid = false;
                            break;
                        }
                            if (l.contains("Physical Address")) {
                                mac = l;
                                c++;
                            } else if (l.contains("IPv4 Address")) {
                                ip = l;
                                c++;
                            } else if (l.contains("Default Gateway")) {
                                gateway = l;
                                c++;
                            }

                            if (c == 3) break;
                    }
                    break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i = mac.length() - 1; i >= 0; i--){
                if(sb.length() <= 17){
                    sb.append(mac.charAt(i));
                }else{
                    break;
                }
            }

            mac = sb.reverse().toString();

            sb.setLength(0);

            for(int i = ip.trim().length() - 1; i >= 0; i--){
                if(ip.charAt(i) == ' ') {
                    break;
                }
                else{
                    sb.append(ip.charAt(i));
                }
            }

            ip = sb.reverse().toString();

            sb.setLength(0);
            int dotCount = 0;

            for(int i = 0; i < ip.length(); i++){
                char ch = ip.charAt(i);

                if(Character.isDigit(ch)){
                    sb.append(ch);
                }else if(ch == '.' && dotCount < 3){
                    sb.append(ch);
                    dotCount++;
                }else if(!Character.isDigit(ch) && dotCount >= 3){
                    break;
                }
            }

            ip = sb.toString();

            sb.setLength(0);

            gateway = gateway.trim();
            for(int i = gateway.trim().length() - 1; i >= 0; i--){
                if(gateway.charAt(i) == ' '){
                    break;
                }else{
                    sb.append(gateway.charAt(i));
                }
            }

            gateway = sb.reverse().toString();

        }catch(Exception e){
            e.printStackTrace();
        }

        sysMAC = mac.trim();
        sysIP = ip.trim();
        defaultGateway = gateway.trim();
    }

    public boolean checkValidity(){
        return this.valid;
    }

    private String executeARP(){
        String command = "arp -a";
        String arpDetails = "";
        boolean flag = true;

        try {
            Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null && flag) {
                if(line.contains(sysIP)){
                    while((line = reader.readLine()) != null){
                        if(line.contains(defaultGateway)){
                            arpDetails = line.trim();
                            flag = false;
                            break;
                        }
                    }
                }
            }

            reader.close();



        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(arpDetails);
        return arpDetails;

    }

    public String getARP(){
        return executeARP();
    }

    public void disconnect()throws IOException{
        Process pro = Runtime.getRuntime().exec("netsh wlan disconnect");
    }
}