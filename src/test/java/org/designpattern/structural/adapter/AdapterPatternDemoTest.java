package org.designpattern.structural.adapter;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdapterPatternDemoTest {
    private AudioPlayer audioPlayer;
    @BeforeEach
    void setUp() {
        audioPlayer = new AudioPlayer();
    }

    @Test
    void testPlayMp3() {
       String expected = "Playing mp3 file. Name: bensound-cute.mp3";
       assertEquals(expected, audioPlayer.play("mp3", "bensound-cute.mp3"));
    }

    @Test
    void testPlayMp4() {
       String expected = "Playing mp4 file. Name: bensound-cute.mp4";
       assertEquals(expected, audioPlayer.play("mp4", "bensound-cute.mp4"));
    }

    // test invalid media type
    @Test
    void testPlayInvalidMedia() {
       String expected = "Invalid media. avi format not supported";
       assertEquals(expected, audioPlayer.play("avi", "bensound-cute.avi"));
    }
}