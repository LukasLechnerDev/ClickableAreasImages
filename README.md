# ClickableAreasImages
An android library that lets you define clickable areas in your images.

Description
===========

ClickableAreaImages is an android library that lets you define clickable areas in your images and associate different objects to it. The images are zoomable and orientation changes are also handled.

![demo image](https://raw.githubusercontent.com/Lukle/ClickableAreasImages/master/images/demo_image.png "Demo Image")

Sample Application
==================
soon ...

Thanks to
=========

[PhotoView](https://github.com/chrisbanes/PhotoView), which serves as foundation for this library.

Sample Usage
========

```java
    public class MainActivity extends AppCompatActivity implements OnClickableAreaClickedListener {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Add image
            ImageView image = (ImageView) findViewById(R.id.imageView);
            image.setImageResource(R.drawable.breaking_bad_people);

            // Create your image
            ClickableAreasImage clickableAreasImage = new ClickableAreasImage(new PhotoViewAttacher(image), this);

            // Define your clickable area (pixel values: x coordinate, y coordinate, width, height) and assign an object to it
            List<ClickableArea> clickableAreas = new ArrayList<>();
            clickableAreas.add(new ClickableArea(230, 185, 47, 72, new Person("Jesse", "Pinkman")));
            clickableAreas.add(new ClickableArea(275, 120, 112, 285, new Person("Walter", "\"Heisenberg\" White")));
            clickableAreasImage.setClickableAreas(clickableAreas);
        }

        // Listen for touches on your images:
        @Override
        public void onClickableAreaTouched(Object item) {
            if (item instanceof Person) {
                String text = ((Person) item).getFirstName() + " " + ((Person) item).getLastName();
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
            }
        }
```

Download
========

Add it in your root build.gradle:

```gradle
    allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}

    dependencies {
	        compile 'com.github.Lukle:ClickableAreasImages:v0.1'
	}
```

License
=======

    Copyright 2016, Lukas Lechner

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
