package main.loadbalancer.impl;

import main.loadbalancer.LoadBalancer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WeightedRoundRobinLoadBalancer extends RoundRobinLoadBalancer {
    public WeightedRoundRobinLoadBalancer(Map<String,Integer> ipToWeightMap ) {
        super(ipToWeightMap.keySet().stream()
                .map(ip->{
                    List<String> tempIpList = new ArrayList();
                    for (int i = 0; i <ipToWeightMap.get(ip) ; i++) {
                        tempIpList.add(ip);
                    }
                    return tempIpList;
                }).flatMap(Collection::stream)
                .collect(Collectors.toList())
                );
    }

    @Override
    protected String getIp() {
        return null;
    }
}
