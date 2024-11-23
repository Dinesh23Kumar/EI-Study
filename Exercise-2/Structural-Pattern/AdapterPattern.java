// Target Interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Adaptee Class
class AdvancedMediaPlayer {
    void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }

    void playVlc(String fileName) {
        System.out.println("Playing vlc file: " + fileName);
    }
}

// Adapter Class
class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedPlayer;

    // Constructor to initialize the correct player based on audio type
    public MediaAdapter(String audioType) {
        advancedPlayer = new AdvancedMediaPlayer();
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedPlayer.playMp4(fileName);
        } else if (audioType.equalsIgnoreCase("vlc")) {
            advancedPlayer.playVlc(fileName);
        }
    }
}

// Client Class
class AudioPlayer implements MediaPlayer {
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        } else if (audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("vlc")) {
            MediaAdapter adapter = new MediaAdapter(audioType); // Correcting the logic for the adapter
            adapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media type (" + audioType + ") for file: " + fileName);
        }
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.play("mp3", "song.mp3");  // Supported type
        player.play("mp4", "video.mp4"); // Supported type
        player.play("vlc", "movie.vlc"); // Supported type
        player.play("avi", "clip.avi");  // Unsupported type
    }
}
