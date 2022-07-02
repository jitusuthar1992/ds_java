package main.loadbalancer;

import java.util.Collections;
import java.util.List;

public abstract class LoadBalancer {

    protected final List<String> ipList ;
    public LoadBalancer(List<String> ipList) {
        this.ipList = Collections.unmodifiableList(ipList);
    }
    protected abstract String getIp();

    protected String getIp(String clientIp){
        return null;
    }
}
