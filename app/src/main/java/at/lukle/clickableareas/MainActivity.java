package at.lukle.clickableareas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import at.lukle.clickableareasimage.ClickableArea;
import at.lukle.clickableareasimage.ClickableAreasImage;
import at.lukle.clickableareasimage.OnClickableAreaClickedListener;
import uk.co.senab.photoview.PhotoViewAttacher;

public class MainActivity extends AppCompatActivity implements OnClickableAreaClickedListener {

    private final String TAG = getClass().getSimpleName();
    PhotoViewAttacher attacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.breaking_bad_people);

        attacher = new PhotoViewAttacher(image);
        ClickableAreasImage clickableAreasImage = new ClickableAreasImage(attacher, this);

        List<ClickableArea> clickableAreas = getClickableAreas();
        clickableAreasImage.setClickableAreas(clickableAreas);
    }

    @NonNull
    private List<ClickableArea> getClickableAreas() {

        int cellWidth = 320;
        int cellHeight = 439;
        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(65,367,191,273,new Person("Gustavo","Fring")));
        clickableAreas.add(new ClickableArea(257,483,151,251,new Person("Saul","Goodman")));
        clickableAreas.add(new ClickableArea(351,277,107,167,new Person("Mike","Ehrmantraut")));
        clickableAreas.add(new ClickableArea(459,371,95,145,new Person("Jesse","Pinkman")));
        clickableAreas.add(new ClickableArea(557,241,225,574,new Person("Walter","\"Heisenberg\" White")));
        clickableAreas.add(new ClickableArea(889,553,133,235,new Person("Hank","Schrader")));
        clickableAreas.add(new ClickableArea(987,429,105,129,new Person("Marie","Schrader")));
        clickableAreas.add(new ClickableArea(1075,299,173,379,new Person("Skylar","White")));
        clickableAreas.add(new ClickableArea(1260,441,257,325,new Person("Walter JR","\"Flynn\" White")));

        return clickableAreas;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClickableAreaTouched(Object item) {
        String text = "";
        if(item instanceof String){
            text = (String) item;
        } else if (item instanceof Person){
            text = ((Person) item).getFirstName() + " " + ((Person) item).getLastName();
        }
        Toast.makeText(this,text, Toast.LENGTH_SHORT).show();
    }
}
