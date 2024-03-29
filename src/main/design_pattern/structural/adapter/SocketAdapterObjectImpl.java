package main.design_pattern.structural.adapter;

public class SocketAdapterObjectImpl implements SocketAdapter {

    private Socket socket = new Socket();

    public Volt get120Volt() {
        return socket.getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt v= socket.getVolt();
        return convertVolt(v,10);
    }

    @Override
    public Volt get3Volt() {
        Volt v= socket.getVolt();
        return convertVolt(v,40);
    }
    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts()/i);
    }
}
