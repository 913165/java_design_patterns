package org.designpattern.structural.proxy;

import java.util.Map;

public class RemoteServiceProxy implements RemoteService {
    private RealRemoteService realRemoteService;
    private String query;
    private Map<String,String> cache = new java.util.HashMap<>();


    @Override
    public String getDataFromServer(String query) {
        if(cache.containsKey(query)) {
            System.out.println("Returning cached data");
            return cache.get(query);
        }
        if (realRemoteService == null) {
            realRemoteService = new RealRemoteService();
        }

        String result = realRemoteService.getDataFromServer(query);
        cache.put(query, result);
        System.out.println("Returning data from server");
        return result;
    }
}
