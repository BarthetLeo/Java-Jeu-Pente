import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.*;

public class Sounds {

    private Clip clip = null;
    private FloatControl gainControl;

    /**
     * Création du son
     * 
     * @param path
     */
    Sounds(String path) {
        try {
            InputStream audioSrc = Sounds.class.getResourceAsStream(path);
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream ais = AudioSystem.getAudioInputStream(bufferedIn);
            AudioFormat baseFormat = ais.getFormat();
            AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
                    baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
            clip = AudioSystem.getClip();
            AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);

            clip.open(dais);

            gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

        } catch (UnsupportedAudioFileException | LineUnavailableException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("Sound: Input/Output Error: " + e);
        }
    }

    /**
     * Lance la musique si clip existe et clip n'a pas déja commencer
     */
    public void play() {
        if (clip == null) {
            return;
        }

        stop();
        clip.setFramePosition(0);

        while (!clip.isRunning()) {
            clip.start();
        }
    }

    /**
     * Si clip en cours alors stop la musique
     */
    public void stop() {
        if (clip.isRunning()) {
            clip.stop();
        }
    }

    /**
     * Ferme le clip
     */
    public void close() {
        stop();
        clip.drain();
        clip.close();
    }

    /**
     * Boucle pour jouer la musique
     */
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        play();
    }

    /**
     * Modifie le volume
     * 
     * @param value
     */
    public void setVolume(float value) {
        gainControl.setValue(value);
    }

    /**
     * Regarde si le clip est en cours
     * 
     * @return boolean
     */
    public boolean isRunning() {
        return clip.isRunning();
    }
}
