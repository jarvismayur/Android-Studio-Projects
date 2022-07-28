package com.example.broadcastreceiver;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BluetoothReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if(action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)){
            final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
            switch (state){
                case BluetoothAdapter.STATE_OFF:
                    Toast.makeText(context, "BlueTooth State OFF", Toast.LENGTH_LONG).show();
                    break;
                case BluetoothAdapter.STATE_TURNING_OFF:
                    Toast.makeText(context, "BlueTooth is Turning Off", Toast.LENGTH_LONG).show();
                    break;
                case BluetoothAdapter.STATE_ON:
                    Toast.makeText(context, "Bluetooth is On " , Toast.LENGTH_LONG);
                    break;
                case BluetoothAdapter.STATE_TURNING_ON:
                    Toast.makeText(context, "Bluetooth is Turning On ", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}
