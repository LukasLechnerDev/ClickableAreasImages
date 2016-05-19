# ClickableAreasImages
An android library that lets you define rectangular clickable areas in your images.

Description
===========

ClickableAreasImages is an android library that lets you define rectangular clickable areas in your images and associate different objects to it. The images are zoomable and orientation changes are also handled.

![demo image](https://raw.githubusercontent.com/Lukle/ClickableAreasImages/master/images/demo_image.png "Demo Image")

Sample Application
==================

I created a sample application.

[![get it on Google Play](https://raw.githubusercontent.com/Lukle/ClickableAreasImages/master/images/google-play-badge.png)](https://play.google.com/store/apps/details?id=at.lukle.clickableareas.app)


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
            image.setImageResource(R.drawable.simpsons);

            // Create your image
            ClickableAreasImage clickableAreasImage = new ClickableAreasImage(new PhotoViewAttacher(image), this);

            // Initialize your clickable area list
            List<ClickableArea> clickableAreas = new ArrayList<>();

            // Define your clickable areas
            // parameter values (pixels): (x coordinate, y coordinate, width, height) and assign an object to it
            clickableAreas.add(new ClickableArea(500, 200, 125, 200, new Character("Homer", "Simpson")));
        	clickableAreas.add(new ClickableArea(600, 440, 130, 160, new Character("Bart", "Simpson")));

            // Set your clickable areas to the image
            clickableAreasImage.setClickableAreas(clickableAreas);
        }

        // Listen for touches on your images:
        @Override
        public void onClickableAreaTouched(Object item) {
            if (item instanceof Character) {
                String text = ((Character) item).getFirstName() + " " + ((Character) item).getLastName();
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
            }
        }
    ...
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

Thanks to
=========

[PhotoView](https://github.com/chrisbanes/PhotoView), which serves as foundation for this library.

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
