package ilya.bkb;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;





public class MainActivity extends Activity {


    private static final int REQUEST_ENABLE_BT = 1;
   

    EditText edt1;
    Button btn1;
    Button btn2;
    Button btn3;
    TextView txt1;
    BluetoothAdapter bluetooth;
    BluetoothDevice device;
    BluetoothSocket clientSocket;
    OutputStream outStream;
    LinearLayout ll;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bluetooth = BluetoothAdapter.getDefaultAdapter();
        edt1 = (EditText) findViewById(R.id.edt1);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        txt1 = (TextView) findViewById(R.id.txt1) ;
        ll = (LinearLayout) findViewById((R.id.linlayout));
        ll.setBackgroundColor(Color.rgb(135 , 206, 250));
        btn1.setEnabled(false);
        if (bluetooth.isEnabled()) {
            
        }
        else
        {
            
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
    }

    public void clickBtn1(View v) {

        
        try {
            outStream = clientSocket.getOutputStream();
            String out = edt1.getText().toString();
            byte[] output = out.getBytes();
            outStream.write(output);
            if(txt1.getText() != "") {
                txt1.setText(txt1.getText() + "\n" + out);
            }
            else {
                txt1.setText(out);
            }
            edt1.setText("");

        } catch (IOException e) {
            
            Log.d("BLUETOOTH", e.getMessage());
        }
    }


    public void clickBtn2(View v) {
        try{
            
            device = bluetooth.getRemoteDevice("98:D3:31:FD:1C:DA");

            
            Method m = device.getClass().getMethod(
                    "createRfcommSocket", new Class[] {int.class});

            clientSocket = (BluetoothSocket) m.invoke(device, 1);
            clientSocket.connect();

            
        } catch (IOException e) {
            Log.d("BLUETOOTH", e.getMessage());
        } catch (SecurityException e) {
            Log.d("BLUETOOTH", e.getMessage());
        } catch (NoSuchMethodException e) {
            Log.d("BLUETOOTH", e.getMessage());
        } catch (IllegalArgumentException e) {
            Log.d("BLUETOOTH", e.getMessage());
        } catch (IllegalAccessException e) {
            Log.d("BLUETOOTH", e.getMessage());
        } catch (InvocationTargetException e) {
            Log.d("BLUETOOTH", e.getMessage());
        }

       


        Toast.makeText(getApplicationContext(), "CONNECTED", Toast.LENGTH_LONG).show();
        btn2.setEnabled(false);
        btn1.setEnabled(true);

    }

    public void clickBtn3(View v) {

        txt1.setText("");
    }

    public void clickBtn4(View view) throws IOException {
        Intent intent = new Intent(MainActivity.this, Keyboard.class);
        startActivity(intent);
    }

}
