package LLD.LoadBalancingAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 02/08/24, Friday
 **/
public class IPHash {

    private final List<String> servers;

    public IPHash(List<String> servers) {
        this.servers = servers;
    }

    public String getNextServer(String clientIp) {
        int hash = clientIp.hashCode();
        int serverIndex = Math.abs(hash) % servers.size();
        return servers.get(serverIndex);
    }

    public static void main(String[] args) {
        List<String> servers = new ArrayList<>(Arrays.asList("Server1", "Server2", "Server3"));
        IPHash ipHash = new IPHash(servers);

        List<String> clientIps = new ArrayList<>(Arrays.asList("192.168.0.1", "192.168.0.2", "192.168.0.3"));
        for (String ip : clientIps) {
            System.out.println(ip + " is mapped to " + ipHash.getNextServer(ip));
        }
    }
}
