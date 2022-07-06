package main.systemdesign.loadbalancer.impl;

import main.systemdesign.loadbalancer.LoadBalancer;

import java.util.List;

public class IpHashLoadBalancer extends LoadBalancer {


    public IpHashLoadBalancer(List<String> ipList) {
        super(ipList);
    }

    @Override
    protected String getIp() {
        return null;
    }

    protected String getIp(String clientIp){

        if(null == clientIp){
            clientIp="127.0.0.1";
        }
        int index = clientIp.hashCode() % ipList.size();
        return ipList.get(index);
    }
}
