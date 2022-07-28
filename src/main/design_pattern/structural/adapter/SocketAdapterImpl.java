package main.design_pattern.structural.adapter;

public class SocketAdapterImpl extends Socket implements SocketAdapter  {
    @Override
    public Volt get120Volt() {
        return getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt v= getVolt();
        return convertVolt(v,10);
    }

    @Override
    public Volt get3Volt() {
        Volt v= getVolt();
        return convertVolt(v,40);
    }
    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts()/i);
    }
}
