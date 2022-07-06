package main.systemdesign.loadbalancer.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WeightedRandomLoadBalancer extends RandomLoadBalancer{
    public WeightedRandomLoadBalancer(Map<String,Integer> ipToWeightMap) {
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
}
