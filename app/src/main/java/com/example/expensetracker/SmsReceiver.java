package com.example.expensetracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {

    private static final String TAG = "SmsReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "========== SmsReceiver.onReceive() ==========");
        Log.d(TAG, "Action: " + intent.getAction());

        if (!Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())) {
            Log.d(TAG, "Not SMS_RECEIVED");
            return;
        }

        Log.d(TAG, "SMS_RECEIVED detected");

        Bundle bundle = intent.getExtras();

        if (bundle == null) {
            Log.d(TAG, "Bundle is NULL");
            return;
        }

        Log.d(TAG, "Bundle received");

        SmsMessage[] messages =
                Telephony.Sms.Intents.getMessagesFromIntent(intent);

        if (messages == null || messages.length == 0) {
            Log.d(TAG, "No SMS messages found");
            return;
        }

        StringBuilder messageBody = new StringBuilder();

        String sender = messages[0].getDisplayOriginatingAddress();

        for (SmsMessage message : messages) {
            if (message != null) {
                messageBody.append(message.getMessageBody());
            }
        }

        Log.d(TAG, "Sender: " + sender);
        Log.d(TAG, "SMS BODY: " + messageBody);
        Log.d(TAG, "========== SMS PROCESSING COMPLETE ==========");
    }
}