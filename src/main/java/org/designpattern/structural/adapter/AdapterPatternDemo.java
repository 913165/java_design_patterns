package org.designpattern.structural.adapter;

interface MediaPlayer {
    String play(String audioType, String fileName);
}

interface AdvancedMediaPlayer {
    String playMp4(String fileName);
}

// concrete class implementing the AdvancedMediaPlayer interface

class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public String playMp4(String fileName) {
        return "Playing mp4 file. Name: " + fileName;
    }
}

// adapter class implementing the MediaPlayer interface
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public String  play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp4")) {
            return advancedMusicPlayer.playMp4(fileName);
        }
        return "Invalid media. " + audioType + " format not supported";
    }
}

class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public String play(String audioType, String fileName) {
        String output = "";
        // playing mp3 by default
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
            output = "Playing mp3 file. Name: " + fileName;
        }
        else if (audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
            output = "Playing mp4 file. Name: " + fileName;
        }else {
            System.out.println("Invalid media. " + audioType + " format not supported");
            output = "Invalid media. " + audioType + " format not supported";
        }
        return output;
    }
}


public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
