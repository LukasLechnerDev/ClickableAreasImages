package at.lukle.clickableareas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.flugblatt);

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

        clickableAreas.add(new ClickableArea(0,0,cellWidth,cellHeight,"Knacker"));
        clickableAreas.add(new ClickableArea(cellWidth,0,cellWidth,cellHeight,"Knacker"));
        clickableAreas.add(new ClickableArea(cellWidth*2,0,cellWidth,cellHeight,"Rostbratwürstel"));

        clickableAreas.add(new ClickableArea(0,cellHeight,cellWidth,cellHeight,"Farmerschinken"));
        clickableAreas.add(new ClickableArea(cellWidth,cellHeight,cellWidth,cellHeight,"Schwarzwälder"));
        clickableAreas.add(new ClickableArea(cellWidth*2,cellHeight,cellWidth,cellHeight,"Putenbrust"));

        clickableAreas.add(new ClickableArea(0,cellHeight*2,cellWidth,cellHeight,"Putenschinken"));
        clickableAreas.add(new ClickableArea(cellWidth, cellHeight * 2, cellWidth, cellHeight, "Schärdinger Österkron"));

        Person heisenberg = new Person("Walter","White");
        clickableAreas.add(new ClickableArea(cellWidth*2,cellHeight*2,cellWidth,cellHeight,heisenberg));

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
