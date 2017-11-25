package seaskyways.gdgcounterappkotlin

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import org.jetbrains.anko.*

/** Created by seaskyways on 11/25/17. */
class AnkoActivity : AppCompatActivity() {
    
    lateinit var inputCount: EditText
    lateinit var inputMessage: EditText
    lateinit var btnSave: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val messages = mutableMapOf<Int, String>()
        
        verticalLayout {
            textView {
                backgroundColor = Color.RED
                text = "Hello GDG"
            }.lparams(width = matchParent, height = dip(64)) {
                verticalMargin = dip(16)
            }
            
            linearLayout {
                inputCount = editText {
                    inputType = InputType.TYPE_CLASS_NUMBER
                }.lparams(width = dip(32))
                
                inputMessage = editText {
                    inputType = InputType.TYPE_CLASS_TEXT
                }
                
                btnSave = button("Save") {
                    setOnClickListener {
                        val count = inputCount.text.toString().toIntOrNull()
                        val message = inputMessage.text.toString().trim()
                        
                        if (count == null) {
                            showToast("Please enter a valid count")
                            return@setOnClickListener
                        }
                        
                        if (message.isBlank()) {
                            showToast("Please enter a valid Message")
                            return@setOnClickListener
                        }
                        
                        messages[count] = message
                    }
                }
            }
            
            val count = textView("0")
            
            button("Count up") {
                setOnClickListener {
                    val currentCount = count.text.toString().toInt().inc()
                    count.text = currentCount.toString()
                    
                    if (messages.containsKey(currentCount)) {
                        toast(messages[currentCount].toString())
                    }
                }
            }
        }
        
    }
}