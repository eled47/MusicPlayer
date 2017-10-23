package musicmain;
import sun.audio.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Edward on 10/11/2017.
 */
public class MusicPlayer implements ActionListener {

    AudioStream as;
    AudioStream as1;
    JButton play = new JButton("Play");
    JButton stop = new JButton("Stop");
    JButton pause = new JButton("Pause");
    JButton play1 = new JButton("Play1");
    JButton stop1 = new JButton("Stop1");


    public static void main(String[] args){
        new MusicPlayer().createGui();
    }

    public void createGui(){

        JFrame frame = new JFrame("Music Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,3,5,5));
        frame.add(play);
        frame.add(stop);
        frame.add(pause);
        frame.add(play1);
        frame.add(stop1);
        frame.pack();
        frame.setVisible(true);

        play.addActionListener(this);
        stop.addActionListener(this);
        pause.addActionListener(this);
        play1.addActionListener(this);
        stop1.addActionListener(this);

        try{
            as = new AudioStream(this.getClass().getResourceAsStream("Mono.wav"));
            as1 = new AudioStream(this.getClass().getResourceAsStream("Sh.wav"));
        }
        catch(IOException e){

        }
    }


    public void actionPerformed(ActionEvent arg0){
        if(arg0.getSource() == play){
            AudioPlayer.player.start(as);
        }
        else if(arg0.getSource() == play1){
            AudioPlayer.player.start(as1);
        }
        else if(arg0.getSource() == stop){
            AudioPlayer.player.stop(as);
            try{
                as = new AudioStream(this.getClass().getResourceAsStream("Mono.wav"));
            }
            catch(IOException e){

            }
        }
        else if(arg0.getSource() == stop1){
            AudioPlayer.player.stop(as1);
            try{
                as1 = new AudioStream(this.getClass().getResourceAsStream("Sh.wav"));
            }
            catch(IOException e){

            }

        }
        else{
            AudioPlayer.player.stop(as);
            AudioPlayer.player.stop(as1);
        }
    }
}
