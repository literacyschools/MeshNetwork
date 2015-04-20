package com.literacyschools.meshnetwork;

import android.net.wifi.p2p.WifiP2pManager;

/**
 * Created by Elic on 15-04-16.
 */
public class WifiP2p {

    private WifiP2pManager wifiP2pManager;

    public WifiP2p() {

    }

    // Registers the application with the Wi-Fi framework. This must be called before calling any other Wi-Fi P2P method.
    public void initialize() {
        wifiP2pManager.initialize();
    }

    // Starts a peer-to-peer connection with a device with the specified configuration.
    public void connect() {
        wifiP2pManager.connect();
    }

    // Cancels any ongoing peer-to-peer group negotiation.
    public void cancelConnect() {
        wifiP2pManager,cancelConnect();
    }

    // Requests a device's connection information.
    public void requestConnectInfo() {
        wifiP2pManager.requestConnectionInfo();
    }

    // Creates a peer-to-peer group with the current device as the group owner.
    public void createGroup() {
        wifiP2pManager.createGroup();
    }

    // Removes the current peer-to-peer group.
    public void removeGroup() {
        wifiP2pManager.removeGroup();
    }

    // Requests peer-to-peer group information.
    public void requestGroupinfo() {
        wifiP2pManager.requestGroupInfo();
    }

    // Initiates peer discovery
    public void discoverPeers(){
        wifiP2pManager.discoverPeers();
    }

    // Requests the current list of discovered peers.
    public void requestPeers() {
        wifiP2pManager.requestPeers();
    }
}
