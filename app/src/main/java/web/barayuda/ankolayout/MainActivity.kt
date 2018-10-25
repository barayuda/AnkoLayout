package web.barayuda.ankolayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                imageView(R.drawable.img_ml).
                        lparams(width = matchParent) {
                            padding = dip(30)
                            margin = dip(15)
                        }

                val name = editText() {
                    hint = "What's your name?"
                }

                button("Say Hello")
            }
        }
    }
}
