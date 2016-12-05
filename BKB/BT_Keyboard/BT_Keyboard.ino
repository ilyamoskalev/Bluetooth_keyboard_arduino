#include <Keyboard.h>

int val; 

void setup()   {                
  Serial.begin(9600);
  Serial1.begin(9600);
  Keyboard.begin();
}

void loop() {
  if( Serial1.available() )      
  {
    val = Serial1.read(); 
    if (val == 0xD4 || val == 0xB3  || val == 0xB0   || val == 0x81  || val ==0x85   || val == 0x80   || val == 0x82  || val == 0x82  || val == 0x84 || val ==  0x83 || val == 0xB2){      
    Keyboard.press(val);
    }
    else
    {
      Keyboard.press(val);
      Keyboard.releaseAll(); 
    }  
    Keyboard.end();
    Keyboard.begin();      
  }
}     


