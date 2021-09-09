package at.likle.clickableareasimage

import android.content.res.Resources
import android.graphics.drawable.BitmapDrawable
import android.util.DisplayMetrics
import android.widget.ImageView
import at.lukle.clickableareasimage.AbstractArea
import at.lukle.clickableareasimage.ClickableAreasImage
import at.lukle.clickableareasimage.OnClickableAreaClickedListener
import io.mockk.*
import io.mockk.MockKAnnotations.init
import io.mockk.impl.annotations.MockK
import org.junit.Test
import uk.co.senab.photoview.PhotoViewAttacher
import kotlin.collections.ArrayList

class ClickableAreasImageTest {

    @MockK
    lateinit var resources: Resources
    @MockK
    lateinit var displayMetrics: DisplayMetrics


    init {
        init(this)
    }

    @Test
    fun testTwoAreasInOneClick(){
        //before
        mockkStatic("android.content.res.Resources")
        every { Resources.getSystem() } returns resources
        every { resources.displayMetrics } returns displayMetrics
        displayMetrics.density = 100f

        val drawableMock = mockkClass(BitmapDrawable::class)
        every { drawableMock.bitmap.width } returns 100
        every { drawableMock.bitmap.height } returns 100

        val imageViewMock = mockkClass(ImageView::class)
        every { imageViewMock.drawable } returns drawableMock

        val attacher = mockkClass(PhotoViewAttacher::class)
        every { attacher.onPhotoTapListener = any() } returns Unit
        every { attacher.imageView } returns imageViewMock

        val listener = spyk(OnClickableAreaClickedListener<Int>{})
        val areas = ClickableAreasImage(attacher, listener)

        val mockedArea1 = MockedArea(1, true)
        val mockedArea2 = MockedArea(2, false)
        val mockedArea3 = MockedArea(3, true)

        areas.clickableAreas = ArrayList<AbstractArea<*>>().apply {
            add(mockedArea1)
            add(mockedArea2)
            add(mockedArea3)
        }

        //action
        areas.onPhotoTap(imageViewMock, 1f, 1f)

        //verify
        verify(exactly = 1) {  listener.onClickableAreaTouched(1)}
        verify(exactly = 1) { listener.onClickableAreaTouched(3) }
        verify(exactly = 0) { listener.onClickableAreaTouched(2) }

    }


    class MockedArea(number: Int, private val isInside: Boolean) : AbstractArea<Int>(number) {
        override fun isInside(positionX: Int, positionY: Int) = isInside
    }
}