package org.designpattern.structural.proxy;

public class Client {
    public static void main(String[] args) {
        RemoteServiceProxy proxy = new RemoteServiceProxy();
        System.out.println(proxy.getDataFromServer("query1"));
        System.out.println(proxy.getDataFromServer("query2"));
        System.out.println(proxy.getDataFromServer("query1"));
        System.out.println(proxy.getDataFromServer("query2"));
    }
}
