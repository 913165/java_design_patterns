package org.designpattern.structural.facade;

class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is on.");
    }

    public void off() {
        System.out.println("DVD Player is off.");
    }

    public void play() {
        System.out.println("DVD Player is playing.");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is on.");
    }

    public void off() {
        System.out.println("Projector is off.");
    }

    public void setInput(DVDPlayer dvdPlayer) {
        System.out.println("Projector is focusing.");
    }
}

class Speaker {
   public void on() {
       System.out.println("Speaker is on.");
   }

    public void off() {
         System.out.println("Speaker is off.");
    }

    public void setVolume(int volume) {
        System.out.println("Speaker volume is set to " + volume);
    }
}

class Light {
    public void on() {
        System.out.println("Light is on.");
    }

    public void off() {
        System.out.println("Light is off.");
    }

    public void dim() {
        System.out.println("Light is dimmed.");
    }
}

class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private Speaker speaker;
    private Light light;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Projector projector, Speaker speaker, Light light) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.speaker = speaker;
        this.light = light;
    }

    public void watchMovie() {
        dvdPlayer.on();
        projector.on();
        projector.setInput(dvdPlayer);
        speaker.on();
        speaker.setVolume(10);
        light.dim();
    }

    public void endMovie() {
        dvdPlayer.off();
        projector.off();
        speaker.off();
        light.off();
    }
}
public class FacadePatternDemo {
    public static void main(String[] args) {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        Speaker speaker = new Speaker();
        Light light = new Light();

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(dvdPlayer, projector, speaker, light);
        homeTheaterFacade.watchMovie();
        homeTheaterFacade.endMovie();
    }
}
