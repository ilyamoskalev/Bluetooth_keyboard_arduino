package ilya.bkb;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;



public class Keyboard extends Activity {

    BluetoothAdapter bluetooth;
    BluetoothDevice device;
    BluetoothSocket clientSocket;
    OutputStream outStream;
    Button esc;
    Button f1;
    Button f2;
    Button f3;
    Button f4;
    Button f5;
    Button f6;
    Button f7;
    Button f8;
    Button f9;
    Button f10;
    Button f11;
    Button f12;
    Button ins;
    Button del;
    Button btn11;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button btn12;
    Button btn13;
    Button btn14;
    Button btn15;
    Button btn16;
    Button btn17;
    Button btn18;
    Button btn19;
    Button btn20;
    Button btn21;
    Button btn22;
    Button btn23;
    Button btn24;
    Button bs;
    Button tab;
    Button q;
    Button w;
    Button ke;
    Button r;
    Button t;
    Button y;
    Button u;
    Button i;
    Button o;
    Button p;
    Button caps;
    Button a;
    Button s;
    Button d;
    Button f;
    Button g;
    Button h;
    Button j;
    Button k;
    Button l;
    Button enter;
    Button lshift;
    Button z;
    Button x;
    Button c;
    Button v;
    Button b;
    Button n;
    Button km;
    Button rshift;
    Button lctrl;
    Button gui;
    Button lalt;
    Button space;
    Button ralt;
    Button rctrl;
    LinearLayout ll;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keyboard);
        ll = (LinearLayout) findViewById(R.id.lin);
        ll.setBackgroundColor(Color.rgb(0, 255, 0));
        esc = (Button) findViewById(R.id.esc);
        f1 = (Button) findViewById(R.id.f1);
        f2 = (Button) findViewById(R.id.f2);
        f3 = (Button) findViewById(R.id.f3);
        f4 = (Button) findViewById(R.id.f4);
        f5 = (Button) findViewById(R.id.f5);
        f6 = (Button) findViewById(R.id.f6);
        f7 = (Button) findViewById(R.id.f7);
        f8 = (Button) findViewById(R.id.f8);
        f9 = (Button) findViewById(R.id.f9);
        f10 = (Button) findViewById(R.id.f10);
        f11 = (Button) findViewById(R.id.f11);
        f12 = (Button) findViewById(R.id.f12);
        ins = (Button) findViewById(R.id.ins);
        del = (Button) findViewById(R.id.del);
        btn11 = (Button) findViewById(R.id.btn11);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn10);
        btn12 = (Button) findViewById(R.id.btn12);
        btn13 = (Button) findViewById(R.id.btn13);
        btn14 = (Button) findViewById(R.id.btn14);
        btn15 = (Button) findViewById(R.id.btn15);
        btn16 = (Button) findViewById(R.id.btn16);
        btn17 = (Button) findViewById(R.id.btn17);
        btn18 = (Button) findViewById(R.id.btn18);
        btn19 = (Button) findViewById(R.id.btn19);
        btn20 = (Button) findViewById(R.id.btn20);
        btn21 = (Button) findViewById(R.id.btn21);
        btn22 = (Button) findViewById(R.id.btn22);
        btn23 = (Button) findViewById(R.id.btn23);
        btn24 = (Button) findViewById(R.id.btn24);
        bs = (Button) findViewById(R.id.bs);
        tab = (Button) findViewById(R.id.tab);
        q = (Button) findViewById(R.id.q);
        w = (Button) findViewById(R.id.w);
        ke = (Button) findViewById(R.id.e);
        r = (Button) findViewById(R.id.r);
        t = (Button) findViewById(R.id.t);
        y = (Button) findViewById(R.id.y);
        u = (Button) findViewById(R.id.u);
        i = (Button) findViewById(R.id.i);
        o = (Button) findViewById(R.id.o);
        p = (Button) findViewById(R.id.p);
        caps = (Button) findViewById(R.id.caps);
        a = (Button) findViewById(R.id.a);
        s = (Button) findViewById(R.id.s);
        d = (Button) findViewById(R.id.d);
        f = (Button) findViewById(R.id.f);
        g = (Button) findViewById(R.id.g);
        h = (Button) findViewById(R.id.h);
        j = (Button) findViewById(R.id.j);
        k = (Button) findViewById(R.id.k);
        l = (Button) findViewById(R.id.l);
        enter = (Button) findViewById(R.id.enter);
        lshift = (Button) findViewById(R.id.lshift);
        z = (Button) findViewById(R.id.z);
        x = (Button) findViewById(R.id.x);
        c = (Button) findViewById(R.id.c);
        v = (Button) findViewById(R.id.v);
        b = (Button) findViewById(R.id.b);
        n = (Button) findViewById(R.id.n);
        km = (Button) findViewById(R.id.m);
        rshift = (Button) findViewById(R.id.rshift);
        lctrl = (Button) findViewById(R.id.lctrl);
        gui = (Button) findViewById(R.id.gui);
        lalt = (Button) findViewById(R.id.lalt);
        space = (Button) findViewById(R.id.space);
        ralt = (Button) findViewById(R.id.ralt);
        rctrl = (Button) findViewById(R.id.rctrl);
        bluetooth = BluetoothAdapter.getDefaultAdapter();
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
        try {
            outStream = clientSocket.getOutputStream();
        }
        catch (IOException e) {
            
            Log.d("BLUETOOTH", e.getMessage());
        }
    }



    public void onClick(View v) {
        int value = 0;
        switch (v.getId()) {
            case R.id.esc:
                value = 0xB1;
                break;
            case R.id.f1:
                value = 0xC1;
                break;
            case R.id.f2:
                value = 0xC2;
                break;
            case R.id.f3:
                value = 0xC3;
                break;
            case R.id.f4:
                value = 0xC4;
                break;
            case R.id.f5:
                value = 0xC5;
                break;
            case R.id.f6:
                value = 0xC6;
                break;
            case R.id.f7:
                value = 0xC7;
                break;
            case R.id.f8:
                value = 0xC8;
                break;
            case R.id.f9:
                value = 0xC9;
                break;
            case R.id.f10:
                value = 0xCA;
                break;
            case R.id.f11:
                value = 0xCB;
                break;
            case R.id.f12:
                value = 0xCD;
                break;
            case R.id.ins:
                value = 0xD1;
                break;
            case R.id.del:
                value = 0xD4;
                break;
            case R.id.btn1:
                value = 0x31;
                break;
            case R.id.btn2:
                value = 0x32;
                break;
            case R.id.btn3:
                value = 0x33;
                break;
            case R.id.btn4:
                value = 0x34;
                break;
            case R.id.btn5:
                value = 0x35;
                break;
            case R.id.btn6:
                value = 0x36;
                break;
            case R.id.btn7:
                value = 0x37;
                break;
            case R.id.btn8:
                value = 0x38;
                break;
            case R.id.btn9:
                value = 0x39;
                break;
            case R.id.btn10:
                value = 0x30;
                break;
            case R.id.btn11:
                value = 0x7E;
                break;
            case R.id.btn12:
                value = 0x2D;
                break;
            case R.id.btn13:
                value = 0x2B;
                break;
            case R.id.btn14:
                value = 0x5B;
                break;
            case R.id.btn15:
                value = 0x5D;
                break;
            case R.id.btn16:
                value = 0x5C;
                break;
            case R.id.btn17:
                value = 0x3A;
                break;
            case R.id.btn18:
                value = 0x22;
                break;
            case R.id.btn19:
                value = 0x3C;
                break;
            case R.id.btn20:
                value = 0x3E;
                break;
            case R.id.btn21:
                value = 0xDA;
                break;
            case R.id.btn22:
                value = 0xD8;
                break;
            case R.id.btn23:
                value = 0xD9;
                break;
            case R.id.btn24:
                value = 0xD7;
                break;
            case R.id.btn25:
                value = 0x2F;
                break;
            case R.id.bs:
                value = 0xB2;
                break;
            case R.id.tab:
                value = 0xB3;
                break;
            case R.id.q:
                value = 0x71;
                break;
            case R.id.w:
                value = 0x77;
                break;
            case R.id.e:
                value = 0x65;
                break;
            case R.id.r:
                value = 0x72;
                break;
            case R.id.t:
                value = 0x74;
                break;
            case R.id.y:
                value = 0x79;
                break;
            case R.id.u:
                value = 0x75;
                break;
            case R.id.i:
                value = 0x69;
                break;
            case R.id.o:
                value = 0x6F;
                break;
            case R.id.p:
                value = 0x70;
                break;
            case R.id.caps:
                value = 0xC1;
                break;
            case R.id.a:
                value = 0x61;
                break;
            case R.id.s:
                value = 0x73;
                break;
            case R.id.d:
                value = 0x64;
                break;
            case R.id.f:
                value = 0x66;
                break;
            case R.id.g:
                value = 0x67;
                break;
            case R.id.h:
                value = 0x68;
                break;
            case R.id.j:
                value = 0x6A;
                break;
            case R.id.k:
                value = 0x6B;
                break;
            case R.id.l:
                value = 0x6C;
                break;
            case R.id.enter:
                value = 0xB0;
                break;
            case R.id.lshift:
                value = 0x81;
                break;
            case R.id.z:
                value = 0x7A;
                break;
            case R.id.x:
                value = 0x78;
                break;
            case R.id.c:
                value = 0x63;
                break;
            case R.id.v:
                value = 0x76;
                break;
            case R.id.b:
                value = 0x62;
                break;
            case R.id.n:
                value = 0x6E;
            case R.id.m:
                value = 0x6D;
                break;
            case R.id.rshift:
                value = 0x85;
                break;
            case R.id.lctrl:
                value = 0x80;
                break;
            case R.id.gui:
                value =	0x83;
                break;
            case R.id.ralt:
                value = 0x82;
                break;
            case R.id.space:
                value = 0x20;
                break;
            case R.id.lalt:
                value = 0x82;
                break;
            case R.id.rctrl:
                value = 0x84;
                break;
        }


                try {
                    outStream.write(value);
                }
                catch (IOException e) {
                    Log.d("BLUETOOTH", e.getMessage());
                }

        }
    }

