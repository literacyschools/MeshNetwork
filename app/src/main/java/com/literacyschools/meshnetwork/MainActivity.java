package com.literacyschools.meshnetwork;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.literacyschools.meshnetwork.utils.Logger;

public class MainActivity extends ActionBarActivity {

    private WifiP2pManager wifiP2pManager;
    private WifiP2pManager.Channel channel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.setTextField((TextView) findViewById(R.id.txtLog));

        wifiP2pManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);

        channel = wifiP2pManager.initialize(this, getMainLooper(), new WifiP2pManager.ChannelListener() {
            @Override
            public void onChannelDisconnected() {
                Logger.log("Channel Disconnected");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnDiscover_onClick(View view) {
        Logger.log("Start discovery");
        findViewById(R.id.btnDiscover).setEnabled(false);
        findViewById(R.id.btnStopDiscovery).setEnabled(true);
        wifiP2pManager.discoverPeers(channel, new WifiP2pManager.ActionListener() {
            @Override
            public void onSuccess() {

                findViewById(R.id.btnDiscover).setEnabled(true);
                findViewById(R.id.btnStopDiscovery).setEnabled(false);
                wifiP2pManager.requestPeers(channel, new WifiP2pManager.PeerListListener() {
                    @Override
                    public void onPeersAvailable(WifiP2pDeviceList peers) {
                        String devicesName = "";
                        Logger.log("Discovered peers nb:" + peers.getDeviceList().size());
                for(WifiP2pDevice device:peers.getDeviceList()) {
                    devicesName += "name:" + device.deviceName + " address:" + device.deviceAddress + " owner:" + device.isGroupOwner();
                }
                Logger.log(devicesName);
            }
        });
    }

    @Override
    public void onFailure(int reason) {
        Logger.log("Failed while Discovered peers reason: " + reason);
                findViewById(R.id.btnDiscover).setEnabled(true);
                findViewById(R.id.btnStopDiscovery).setEnabled(false);
            }
        });
    }
}