package com.example.supermarketapp;

public class Controller implements ISocketActions, ISocketEvents {

    private SocketImpl mSocketImpl = new SocketImpl();

    public Controller() {
        registerSocketEvents();
    }

    @Override
    public void on() {
        mSocketImpl.on();
    }

    @Override
    public void off() {
        mSocketImpl.off();
    }

    private void registerSocketEvents() {
        mSocketImpl.register(this);
    }

    @Override
    public String onDataArrived() {

        // parse
        return null;
    }
}
