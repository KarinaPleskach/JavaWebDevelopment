package by.training.info_threads.task15;

public class Client extends Thread {
    private boolean reading = false;
    private ChannelPool<AudioChannel> pool;
    public Client(ChannelPool<AudioChannel> pool) {
        this.pool = pool;
    }
    @Override
    public void run() {
        AudioChannel channel = null;
        try {
            channel = pool.getResource(600);
            reading = true;
            System.out.println("Channel Client #" + this.getId()
                    + " took channel #" + channel.getChannelId());
            channel.using();
        } catch (RuntimeException e) {
            System.out.println("Client #" + this.getId() + " lost ->"
                    + e.getMessage());
        } finally {
            if (channel != null) {
                reading = false;
                System.out.println("Channel Client #" + this.getId() + " : "
                        + channel.getChannelId() + " channel released");
                pool.returnResource(channel);
            }
        }
    }
    public boolean isReading() {
        return reading;
    }
}
