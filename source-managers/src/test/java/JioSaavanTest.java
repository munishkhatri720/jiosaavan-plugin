
import com.github.appujet.jiosaavan.source.JioSaavnAudioSourceManager;
import com.sedmelluq.discord.lavaplayer.track.AudioReference;


public class JioSaavanTest {
    public static void main(String[] args) {
        final var id1 = "https://www.jiosaavn.com/song/meri-umraan/AT4eZQJ8V1Q";
        final var mngr = new JioSaavnAudioSourceManager("Api url here");
        final var res1 = mngr.loadItem(null, new AudioReference(id1, ""));
        System.out.println(res1);
    }
}
