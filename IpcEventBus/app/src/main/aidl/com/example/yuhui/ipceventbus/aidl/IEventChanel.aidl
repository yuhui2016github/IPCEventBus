package com.example.yuhui.ipceventbus.aidl;
import com.example.yuhui.ipceventbus.aidl.MessageEvent;
interface IEventChanel {
   void postEvent(in MessageEvent messageEvent);
   void otherMethod(int a, int b);
}
