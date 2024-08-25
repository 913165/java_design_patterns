package org.designpattern.structural.proxy;

public class RealRemoteService implements RemoteService {
    @Override
    public String getDataFromServer(String query) {
        // simulate complex operation or actual remote call
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       return "Data for query: " + query;
    }
}
