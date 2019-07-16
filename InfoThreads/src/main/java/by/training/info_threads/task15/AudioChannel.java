package by.training.info_threads.task15;

public class AudioChannel {
    private int channelId;
    public AudioChannel(int id) {
        channelId = id;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public void using() {
        try {
            //использование канала
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
