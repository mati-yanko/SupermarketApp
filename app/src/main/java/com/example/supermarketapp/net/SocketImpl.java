package com.example.supermarketapp.net;

import com.example.supermarketapp.ISocketActions;
import com.example.supermarketapp.ISocketEvents;

import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import tech.gusavila92.websocketclient.WebSocketClient;

public class SocketImpl extends Socket implements ISocketActions {

    private ArrayList<ISocketEvents> mSubscribers = new ArrayList<>();
    private WebSocketClient mSocket;
    private Thread mThread;
    private boolean mActive;

    public SocketImpl() {

        mThread = new Thread() {
            @Override
            public void run() {
                try {
                    while(true) {
                        sleep(1000);
                        if (mActive) {
                            if (mSocket == null) {
                                try {
                                    try {
                                        mSocket = new WebSocketClient(new URI("ws://superdo-groceries.herokuapp.com:80/receive")) {
                                            @Override
                                            public void onOpen() {

                                            }

                                            @Override
                                            public void onTextReceived(String message) {

                                            }

                                            @Override
                                            public void onBinaryReceived(byte[] data) {

                                            }

                                            @Override
                                            public void onPingReceived(byte[] data) {

                                            }

                                            @Override
                                            public void onPongReceived(byte[] data) {

                                            }

                                            @Override
                                            public void onException(Exception e) {

                                            }

                                            @Override
                                            public void onCloseReceived() {

                                            }
                                        };
                                    } catch (URISyntaxException e) {
                                        e.printStackTrace();
                                    }

                                    mSocket.setConnectTimeout(10000);
                                    mSocket.setReadTimeout(60000);
                                    mSocket.enableAutomaticReconnection(5000);
                                    mSocket.connect();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            if (mSocket != null) {
                                try {
                                    mSocket.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        mThread.start();
    }

    @Override
    public void on() {
        mActive = true;

    }

    @Override
    public void off() {
        mActive = false;

    }

    public void register(ISocketEvents subscriber) {
        mSubscribers.add(subscriber);
    }
}
