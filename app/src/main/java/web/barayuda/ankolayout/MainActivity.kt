package web.barayuda.ankolayout

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

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

                val name = editText {
                    hint = "What's your name?"
                }

                button("Say Hello") {
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    onClick { toast("Hello, ${name.text}!") }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }

                button("Show Alert"){
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        alert("Happy Coding!", "Hello, ${name.text}") {
                            yesButton { toast("Oh") }
                            noButton { toast("Noo") }
                        }.show()
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                button("Show Selector") {
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE

                    onClick {
                        val hero = listOf("Alucard", "Miya", "Lesley", "Chou")
                        selector("Hello, ${name.text}! Apa hero favorite di Mobile Legends?", hero) {
                            _, i -> toast("Jadi hero favoritmu ${hero[i]}?")
                        }
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                button("Show Snackbar") {
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        snackbar(name, "Hello, ${name.text}!")
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                button("Show ProgressBar") {
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        indeterminateProgressDialog("Hello, ${name.text}! Mohon tunggu...").show()
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                button("Go to Second Activity") {
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        startActivity<SecondActivity>("name" to "${name.text}")
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }
            }
        }
    }
}
